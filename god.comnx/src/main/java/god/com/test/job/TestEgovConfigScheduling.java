package god.com.test.job;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import god.com.acomdvlp.job.AutowiringSpringBeanJobFactory;

@Configuration
public class TestEgovConfigScheduling {

	@Bean
	public JobFactory jobFactory(ApplicationContext applicationContext) {
		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

	// Scheduler 설정
	@Bean
	public SchedulerFactoryBean schedulerFactoryTest(JobFactory jobFactory, Trigger cronTriggerTest001,
			Trigger cronTriggerTest002) {
		SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
		schedulerFactory.setJobFactory(jobFactory); // ✅ 반드시 설정!
		schedulerFactory.setTriggers(cronTriggerTest001, cronTriggerTest002);
		return schedulerFactory;
	}

	// CronTrigger 설정
	@Bean
	public CronTriggerFactoryBean cronTriggerTest001(JobDetail jobDetailTest001) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();

		trigger.setJobDetail(jobDetailTest001);

//		trigger.setCronExpression("0 0 2 * * ?"); // 매일 02:00:00에 동작

		trigger.setCronExpression("0/15 * * * * ?"); // 매 10초마다 실행

//		trigger.setCronExpression("0 0/1 * * * ?"); // 매 1분마다 실행

		return trigger;
	}

	@Bean
	public JobDetailFactoryBean jobDetailTest001() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
//		factoryBean.setName("test001JobDetail");
//		factoryBean.setGroup("test001JobGroup");
		factoryBean.setJobClass(Test001Job.class); // ✅ 실행할 Job 클래스 지정
//		factoryBean.setDurability(true); // 트리거 없어도 유지
		return factoryBean;
	}

	// CronTrigger 설정
	@Bean
	public CronTriggerFactoryBean cronTriggerTest002(JobDetail jobDetailTest002) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();

		trigger.setJobDetail(jobDetailTest002);

//		trigger.setCronExpression("0 0 2 * * ?"); // 매일 02:00:00에 동작

		trigger.setCronExpression("0/25 * * * * ?"); // 매 20초마다 실행

//		trigger.setCronExpression("0 0/1 * * * ?"); // 매 1분마다 실행

		return trigger;
	}

	@Bean
	public JobDetailFactoryBean jobDetailTest002() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
//		factoryBean.setName("acomdvlp001JobDetail");
//		factoryBean.setGroup("acomdvlp001JobGroup");
		factoryBean.setJobClass(Test002Job.class); // ✅ 실행할 Job 클래스 지정
//		factoryBean.setDurability(true); // 트리거 없어도 유지
		return factoryBean;
	}

}
