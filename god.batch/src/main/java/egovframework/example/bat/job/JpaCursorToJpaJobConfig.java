package egovframework.example.bat.job;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import egovframework.example.bat.domain.jpa.Customer;
import egovframework.example.bat.domain.jpa.CustomerIncreaseProcessor;

@Configuration
public class JpaCursorToJpaJobConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(JpaCursorToJpaJobConfig.class);
	
	@Autowired
    private JobBuilderFactory jobBuilderFactory;
	@Autowired
    private StepBuilderFactory stepBuilderFactory;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
    @Bean
    public Job jpaCursorToJpaJob() {
        return jobBuilderFactory.get("jpaCursorToJpaJob")
                .start(jpaCursorToJpaStep())
                .build();
    }

    @Bean
    public Step jpaCursorToJpaStep() {
        return stepBuilderFactory.get("jpaCursorToJpaStep")
                .<Customer,Customer>chunk(2)
                .reader(jpaCursorItemReader())
                .processor(jpaItemProcessor())
                .writer(jpaBatchItemWriter())
                //.writer(customItemWriter())
                .build();
    }
    
    
    @Bean
    @StepScope
    public JpaCursorItemReader<Customer> jpaCursorItemReader() {
    	
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("name", "%");
        
        return new JpaCursorItemReaderBuilder<Customer>()
        		.name("jpaCursorItemReader")
        		.queryString("select c from Customer c where id < 1000 and name like :name")
                .entityManagerFactory(entityManagerFactory)
                .parameterValues(parameters)
//                .maxItemCount(10)
//                .currentItemCount(2)
                .build();
    }

    @Bean
    public CustomerIncreaseProcessor jpaItemProcessor() {
        return new CustomerIncreaseProcessor();
    }

    @Bean
    @StepScope
    public JpaItemWriter<Customer> jpaBatchItemWriter() {
    	
        return new JpaItemWriterBuilder<Customer>()
                .entityManagerFactory(entityManagerFactory)
                .usePersist(true)
                .build();

    }
    
    @Bean
    public ItemWriter<Customer> customItemWriter() {
        return items -> {
            for (Customer item : items) {
                LOGGER.debug("===>>> "+item.getName());
            }
        };
    }
    
}
