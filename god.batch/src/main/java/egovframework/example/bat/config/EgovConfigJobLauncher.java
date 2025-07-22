package egovframework.example.bat.config;

import javax.sql.DataSource;

import org.egovframe.rte.bat.core.launch.support.EgovBatchRunner;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

@Configuration
public class EgovConfigJobLauncher {
	
	@Bean
	public EgovBatchRunner batchRunner(JobOperator jobOperator, JobExplorer jobExplorer, JobRepository jobRepository) {
		EgovBatchRunner runner = new EgovBatchRunner(jobOperator, jobExplorer, jobRepository);
	    return runner;
	}
	
	@Bean
	public SimpleJobLauncher jobLauncher(JobRepository jobRepository) {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository);
		return jobLauncher;
	}
	
	@Bean
	public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
		JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
		jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);
		return jobRegistryBeanPostProcessor;
	}

	@Bean
	public JobRepositoryFactoryBean jobRepository(DataSource dataSource, TransactionManager transactionManager, LobHandler lobHandler) {
		JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
		jobRepositoryFactoryBean.setDataSource(dataSource);
		jobRepositoryFactoryBean.setTransactionManager((PlatformTransactionManager) transactionManager);
		jobRepositoryFactoryBean.setLobHandler(lobHandler);
		return jobRepositoryFactoryBean;
	}
	
	@Bean
	public SimpleJobOperator jobOperator(JobLauncher jobLauncher, JobExplorer jobExplorer, JobRepository jobRepository, JobRegistry jobRegistry) {
		SimpleJobOperator jobOperator = new SimpleJobOperator();
		jobOperator.setJobLauncher(jobLauncher);
		jobOperator.setJobExplorer(jobExplorer);
		jobOperator.setJobRepository(jobRepository);
		jobOperator.setJobRegistry(jobRegistry);
		return jobOperator;
	}

	@Bean
	public JobExplorerFactoryBean jobExplorer(DataSource datasource) {
		JobExplorerFactoryBean jobExplorer = new JobExplorerFactoryBean();
		jobExplorer.setDataSource(datasource);
		return jobExplorer;
	}

	@Bean
	public MapJobRegistry jobRegistry() {
		MapJobRegistry jobRegistry = new MapJobRegistry();
		return jobRegistry;
	}
	
}
