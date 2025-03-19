package egovframework.com.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.OrderWith;
import org.junit.runner.RunWith;
import org.junit.runner.manipulation.Alphanumeric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@OrderWith(Alphanumeric.class)

@ContextConfiguration(locations = { "classpath*:egovframework/spring/com/**/context-*.xml"

		, "file:src/main/webapp/WEB-INF/config/egovframework/springmvc/egov-com-*.xml"

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
public class EgovAbstractTestJUnit4 {

	private static final StopWatch STOP_WATCH = new StopWatch();
	private final StopWatch stopWatch = new StopWatch();

	private static String[] beanDefinitionNames;

	@Autowired
	private ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() {
		log.info("setUpBeforeClass, @BeforeClass");

		STOP_WATCH.start();
	}

	@AfterClass
	public static void tearDownAfterClass() {
		log.info("tearDownAfterClass, @AfterClass");

		STOP_WATCH.stop();

		log.info("getTotalTimeMillis={}", STOP_WATCH.getTotalTimeMillis());
		log.info("getTotalTimeSeconds={}", STOP_WATCH.getTotalTimeSeconds());
	}

	@Before
	public void setUp() {
		log.info("setUp, @Before");

		stopWatch.start();

		beanDefinitionNames = context.getBeanDefinitionNames();
		log.info("beanDefinitionNames.length={}", beanDefinitionNames.length);
		for (String beanDefinitionName : beanDefinitionNames) {
			log.info("beanDefinitionName={}", beanDefinitionName);
		}
	}

	@After
	public void tearDown() {
		log.info("tearDown, @After");

		stopWatch.stop();

		log.info("getTotalTimeMillis2={}", stopWatch.getTotalTimeMillis());
		log.info("getTotalTimeSeconds2={}", stopWatch.getTotalTimeSeconds());
	}

}