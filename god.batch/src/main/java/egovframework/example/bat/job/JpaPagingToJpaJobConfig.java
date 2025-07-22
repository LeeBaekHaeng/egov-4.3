package egovframework.example.bat.job;

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
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import egovframework.example.bat.domain.jpa.Customer;
import egovframework.example.bat.domain.jpa.Customer2;
import egovframework.example.bat.domain.jpa.CustomerIncreaseProcessor2;

@Configuration
public class JpaPagingToJpaJobConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(JpaPagingToJpaJobConfig.class);
	
	@Autowired
    private JobBuilderFactory jobBuilderFactory;
	@Autowired
    private StepBuilderFactory stepBuilderFactory;
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
    @Bean
    public Job jpaPagingToJpaJob() {
        return jobBuilderFactory.get("jpaPagingToJpaJob")
                .start(jpaPagingToJpaStep())
                .build();
    }

    @Bean
    public Step jpaPagingToJpaStep() {
        return stepBuilderFactory.get("jpaPagingToJpaStep")
                .<Customer,Customer2>chunk(2)
                .reader(jpaPagingItemReader())
                .processor(jpaItemProcessor2())
                .writer(jpaBatchItemWriter())
                //.writer(customItemWriter())
                .build();
    }
    
    
    @Bean
    @StepScope
    public JpaPagingItemReader<Customer> jpaPagingItemReader() {
    	
        return new JpaPagingItemReaderBuilder<Customer>()
                .name("jpaPagingItemReader")
                .entityManagerFactory(entityManagerFactory)
                .pageSize(2)
                .queryString("select c from Customer c")
                .build();
    }

    @Bean
    public CustomerIncreaseProcessor2 jpaItemProcessor2() {
        return new CustomerIncreaseProcessor2();
    }
    
    @Bean
    @StepScope
    public JpaItemWriter<Customer2> jpaBatchItemWriter() {
    	
        return new JpaItemWriterBuilder<Customer2>()
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
