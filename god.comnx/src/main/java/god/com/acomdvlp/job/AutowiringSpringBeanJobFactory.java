package god.com.acomdvlp.job;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

public class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {

	private transient AutowireCapableBeanFactory beanFactory;

	@Override
	public void setApplicationContext(ApplicationContext context) {
		this.beanFactory = context.getAutowireCapableBeanFactory();
	}

	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws BaseRuntimeException, Exception {
		Object job = super.createJobInstance(bundle);
		beanFactory.autowireBean(job); // ⭐ 서비스 주입 핵심!
		return job;
	}

}
