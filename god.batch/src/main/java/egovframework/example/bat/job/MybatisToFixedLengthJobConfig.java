package egovframework.example.bat.job;

import java.net.MalformedURLException;

import org.egovframe.rte.bat.core.item.database.EgovMyBatisPagingItemReader;
import org.egovframe.rte.bat.core.item.file.transform.EgovFieldExtractor;
import org.egovframe.rte.bat.core.item.file.transform.EgovFixedLengthLineAggregator;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import egovframework.example.bat.domain.trade.CustomerCredit;
import egovframework.example.bat.domain.trade.CustomerCreditIncreaseProcessor;

@Configuration
public class MybatisToFixedLengthJobConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(MybatisToFixedLengthJobConfig.class);
	
	@Autowired
    private JobBuilderFactory jobBuilderFactory;
	@Autowired
    private StepBuilderFactory stepBuilderFactory;
	
    @Bean
    public Job mybatisToFixedLengthJob() {
        return jobBuilderFactory.get("mybatisToFixedLengthJob")
                .start(mybatisToFixedLengthStep())
                .build();
    }

    @Bean
    public Step mybatisToFixedLengthStep() {
        return stepBuilderFactory.get("mybatisToFixedLengthStep")
                .<CustomerCredit,CustomerCredit>chunk(2)
                .reader(myBatisPagingItemReader(null))
                .processor(itemProcessor())
                .writer(fixedLengthItemWriter(null))
                .build();
    }
    
    @Bean
    @StepScope
    public EgovMyBatisPagingItemReader<CustomerCredit> myBatisPagingItemReader(SqlSessionFactoryBean sqlSessionFactoryBean) {
    	
    	EgovMyBatisPagingItemReader<CustomerCredit> myBatisPagingItemReader = new EgovMyBatisPagingItemReader<>();
    	try {
			myBatisPagingItemReader.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	myBatisPagingItemReader.setQueryId("Customer.getAllCustomerCredits");
    	myBatisPagingItemReader.setPageSize(10);
    	
        return myBatisPagingItemReader;
    }
    
    @Bean
    public CustomerCreditIncreaseProcessor itemProcessor() {
        return new CustomerCreditIncreaseProcessor();
    }

    @Bean
    @StepScope
    @Value("#{jobParameters[outputFile]}")
    public FlatFileItemWriter<CustomerCredit> fixedLengthItemWriter(String outputFile) {
    	
    	LOGGER.debug("===>>> outputFile = "+outputFile);
    	
    	Resource resource = null;
		try {
			resource = new UrlResource(outputFile);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
    	return new FlatFileItemWriterBuilder<CustomerCredit>()
    			.name("fixedLengthItemWriter")
    			.resource(resource)
    			.lineAggregator(lineAggregator())
    			.saveState(false)
    			.build();
    }
    
    @Bean
    public EgovFieldExtractor<CustomerCredit> fieldExtractor() {
    	EgovFieldExtractor<CustomerCredit> fieldExtractor = new EgovFieldExtractor<>();
    	fieldExtractor.setNames(new String[] {"name","credit"});
    	return fieldExtractor;
    }
    
    @Bean
    public EgovFixedLengthLineAggregator<CustomerCredit> lineAggregator() {
    	EgovFixedLengthLineAggregator<CustomerCredit> lineAggregator = new EgovFixedLengthLineAggregator<>();
    	lineAggregator.setFieldRanges(new int[] {9,9});
    	lineAggregator.setFieldExtractor(fieldExtractor());
    	return lineAggregator;
    }
}
