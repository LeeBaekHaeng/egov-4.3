import org.egovframe.rte.fdl.cryptography.EgovPasswordEncoder;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EgovEnvCryptoAlgorithmCreateTest {

	@Test
	public void test() {
		// 계정암호화키 키
		String algorithmKey = "(사용자정의 값)";

		// 계정암호화 알고리즘(MD5, SHA-1, SHA-256)
		String algorithm = "SHA-256";

		// 계정암호화키 블럭사이즈
		int algorithmBlockSize = 1024;

		EgovPasswordEncoder egovPasswordEncoder = new EgovPasswordEncoder();
		egovPasswordEncoder.setAlgorithm(algorithm);

		log.info("------------------------------------------------------");
		log.info("알고리즘(algorithm) : " + algorithm);
		log.info("알고리즘 키(algorithmKey) : " + algorithmKey);
		log.info("알고리즘 키 Hash(algorithmKeyHash) : " + egovPasswordEncoder.encryptPassword(algorithmKey));
		log.info("알고리즘 블럭사이즈(algorithmBlockSize)  :" + algorithmBlockSize);
	}

}
