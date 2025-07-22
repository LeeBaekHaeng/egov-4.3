package god.com.acomdvlp.job;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class AcomdvlpEgovConfigScheduling {

	@Bean
	public JobFactory jobFactory(ApplicationContext applicationContext) {
		AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

	// Scheduler 설정
	@Bean
	public SchedulerFactoryBean schedulerFactoryAcomdvlp(JobFactory jobFactory, Trigger cronTriggerAcomdvlp001,
			Trigger cronTriggerAcomdvlp002) {
		SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
		schedulerFactory.setJobFactory(jobFactory); // ✅ 반드시 설정!
		schedulerFactory.setTriggers(cronTriggerAcomdvlp001, cronTriggerAcomdvlp002);
		return schedulerFactory;
	}

	// CronTrigger 설정
	@Bean
	public CronTriggerFactoryBean cronTriggerAcomdvlp001(JobDetail jobDetailAcomdvlp001) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();

		trigger.setJobDetail(jobDetailAcomdvlp001);

//		trigger.setCronExpression("0 0 2 * * ?"); // 매일 02:00:00에 동작

		trigger.setCronExpression("0/10 * * * * ?"); // 매 10초마다 실행

//		trigger.setCronExpression("0 0/1 * * * ?"); // 매 1분마다 실행

		return trigger;
	}

	@Bean
	public JobDetailFactoryBean jobDetailAcomdvlp001() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
//		factoryBean.setName("acomdvlp001JobDetail");
//		factoryBean.setGroup("acomdvlp001JobGroup");
		factoryBean.setJobClass(Acomdvlp001Job.class); // ✅ 실행할 Job 클래스 지정
//		factoryBean.setDurability(true); // 트리거 없어도 유지
		return factoryBean;
	}

	// CronTrigger 설정
	@Bean
	public CronTriggerFactoryBean cronTriggerAcomdvlp002(JobDetail jobDetailAcomdvlp002) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();

		trigger.setJobDetail(jobDetailAcomdvlp002);

//		trigger.setCronExpression("0 0 2 * * ?"); // 매일 02:00:00에 동작

		trigger.setCronExpression("0/20 * * * * ?"); // 매 20초마다 실행

//		trigger.setCronExpression("0 0/1 * * * ?"); // 매 1분마다 실행

		return trigger;
	}

	@Bean
	public JobDetailFactoryBean jobDetailAcomdvlp002() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
//		factoryBean.setName("acomdvlp001JobDetail");
//		factoryBean.setGroup("acomdvlp001JobGroup");
		factoryBean.setJobClass(Acomdvlp002Job.class); // ✅ 실행할 Job 클래스 지정
//		factoryBean.setDurability(true); // 트리거 없어도 유지
		return factoryBean;
	}

}
