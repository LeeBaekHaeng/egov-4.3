package egovframework.example.bat.job;

import java.net.MalformedURLException;

import org.egovframe.rte.bat.core.item.database.EgovMyBatisPagingItemReader;
import org.egovframe.rte.bat.core.item.file.transform.EgovFieldExtractor;
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
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import egovframework.example.bat.domain.trade.CustomerCredit;
import egovframework.example.bat.domain.trade.CustomerCreditIncreaseProcessor;

@Configuration
public class MybatisToDelimitedJobConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(MybatisToDelimitedJobConfig.class);
	
	@Autowired
    private JobBuilderFactory jobBuilderFactory;
	@Autowired
    private StepBuilderFactory stepBuilderFactory;
	
    @Bean
    public Job mybatisToDelimitedJob() {
        return jobBuilderFactory.get("mybatisToDelimitedJob")
                .start(mybatisToDelimitedStep())
                .build();
    }

    @Bean
    public Step mybatisToDelimitedStep() {
        return stepBuilderFactory.get("mybatisToDelimitedStep")
                .<CustomerCredit,CustomerCredit>chunk(2)
                .reader(myBatisPagingItemReader(null))
                .processor(itemProcessor())
                .writer(delimitedItemWriter(null,null))
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
    public FlatFileItemWriter<CustomerCredit> delimitedItemWriter(@Qualifier("delimitedToDelimitedJob.delimitedLineAggregator") DelimitedLineAggregator<CustomerCredit> lineAggregator
    		, @Value("#{jobParameters[outputFile]}") String outputFile) {
    	
    	Resource resource = null;
		try {
			resource = new UrlResource(outputFile);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
    	return new FlatFileItemWriterBuilder<CustomerCredit>()
    			.name("delimitedItemWriter")
    			.resource(resource)
    			.lineAggregator(lineAggregator)
    			.saveState(false)
    			.build();
    }
    
    @Bean(name="delimitedToDelimitedJob.fieldExtractor")
    public EgovFieldExtractor<CustomerCredit> fieldExtractor() {
    	EgovFieldExtractor<CustomerCredit> fieldExtractor = new EgovFieldExtractor<>();
    	fieldExtractor.setNames(new String[] {"name","credit"});
    	return fieldExtractor;
    }
    
    @Bean(name="delimitedToDelimitedJob.delimitedLineAggregator")
    public DelimitedLineAggregator<CustomerCredit> lineAggregator(@Qualifier("delimitedToDelimitedJob.fieldExtractor") EgovFieldExtractor<CustomerCredit> fieldExtractor) {
    	DelimitedLineAggregator<CustomerCredit> lineAggregator = new DelimitedLineAggregator<>();
    	lineAggregator.setDelimiter(",");
    	lineAggregator.setFieldExtractor(fieldExtractor);
    	return lineAggregator;
    }
}
