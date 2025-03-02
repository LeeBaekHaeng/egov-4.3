import org.egovframe.rte.fdl.cryptography.EgovEnvCryptoService;
import org.egovframe.rte.fdl.cryptography.impl.EgovEnvCryptoServiceImpl;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EgovEnvCryptoUserTest {

	@Test
	public void test() {
		String[] arrCryptoString = { "com", // 데이터베이스 접속 계정 설정
				"com01", // 데이터베이스 접속 패드워드 설정
				"jdbc:log4jdbc:mysql://127.0.0.1:3306/com", // 데이터베이스 접속 주소 설정
				"net.sf.log4jdbc.DriverSpy" // 데이터베이스 드라이버
		};

		log.info("------------------------------------------------------");
		EgovEnvCryptoService cryptoService;
		try (AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:/context-crypto-test.xml" });) {
			cryptoService = context.getBean(EgovEnvCryptoServiceImpl.class);
		}

		log.info("------------------------------------------------------");

		String label = "";
		try {
			for (int i = 0; i < arrCryptoString.length; i++) {
				if (i == 0)
					label = "사용자 아이디";
				if (i == 1)
					label = "사용자 비밀번호";
				if (i == 2)
					label = "접속 주소";
				if (i == 3)
					label = "데이터 베이스 드라이버";
				log.info(label + " 원본(orignal):" + arrCryptoString[i]);
				log.info(label + " 인코딩(encrypted):" + cryptoService.encrypt(arrCryptoString[i]));
				log.info("------------------------------------------------------");
			}
		} catch (IllegalArgumentException e) {
			log.error("[" + e.getClass() + "] IllegalArgumentException : " + e.getMessage());
		}

//		((ClassPathXmlApplicationContext) context).close();
//		((AbstractApplicationContext) context).close();
	}

}
