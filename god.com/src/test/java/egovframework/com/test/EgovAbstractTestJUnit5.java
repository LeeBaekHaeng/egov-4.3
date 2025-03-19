package egovframework.com.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.MethodName.class)

@ContextConfiguration(locations = {

		"classpath*:egovframework/spring/com/**/context-*.xml",

		"classpath*:god/spring/com/**/context-*.xml",

		"file:src/main/webapp/WEB-INF/config/egovframework/springmvc/egov-com-*.xml",

})

@WebAppConfiguration

//@ActiveProfiles({ "altibase", "dummy" })
//@ActiveProfiles({ "cubrid", "dummy" })
//@ActiveProfiles({ "maria", "dummy" })
@ActiveProfiles({ "mysql", "dummy" })
//@ActiveProfiles({ "oracle", "dummy" })
//@ActiveProfiles({ "postgres", "dummy" })
//@ActiveProfiles({ "tibero", "dummy" })

@Transactional
public class EgovAbstractTestJUnit5 {

	private static final StopWatch STOP_WATCH = new StopWatch();
	private final StopWatch stopWatch = new StopWatch();

	private static String[] beanDefinitionNames;

	@Autowired
	private ApplicationContext context;

	@BeforeAll
	static void setUpBeforeClass() {
		log.info("setUpBeforeClass, @BeforeAll");

		STOP_WATCH.start();
	}

	@AfterAll
	static void tearDownAfterClass() {
		log.info("tearDownAfterClass, @AfterAll");

		STOP_WATCH.stop();

		log.info("getTotalTimeMillis={}", STOP_WATCH.getTotalTimeMillis());
		log.info("getTotalTimeSeconds={}", STOP_WATCH.getTotalTimeSeconds());
	}

	@BeforeEach
	void setUp() {
		log.info("setUp, @BeforeEach");

		stopWatch.start();

		beanDefinitionNames = context.getBeanDefinitionNames();
		log.info("beanDefinitionNames.length={}", beanDefinitionNames.length);
		for (String beanDefinitionName : beanDefinitionNames) {
			log.info("beanDefinitionName={}", beanDefinitionName);
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		log.info("tearDown, @AfterEach");

		stopWatch.stop();

		log.info("getTotalTimeMillis2={}", stopWatch.getTotalTimeMillis());
		log.info("getTotalTimeSeconds2={}", stopWatch.getTotalTimeSeconds());
	}

}