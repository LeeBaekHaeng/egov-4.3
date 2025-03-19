package egovframework.com.uat.uap.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.test.EgovAbstractTestJUnit5;
import egovframework.com.uat.uap.service.LoginPolicy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class LoginPolicyDAOTest extends EgovAbstractTestJUnit5 {

	@Autowired
	private LoginPolicyDAO loginPolicyDAO;

	@Autowired
	private EgovPropertyService propertiesService;

	/**
	 * 등록 insert공통표준단어
	 */
	@Test
//	@Commit
	void testA10insertLoginPolicy() {
		// given
		LoginPolicy loginPolicy = new LoginPolicy(); // 로그인정책
		// NOT NULL
//		loginPolicy.setEmplyrId("TEST1"); // 업무사용자ID
		loginPolicy.setEmplyrId("USER"); // 업무사용자ID

		loginPolicy.setIpInfo("127.0.0.1"); // IP정보
		loginPolicy.setDplctPermAt("Y"); // 중복허용여부
		loginPolicy.setLmttAt("Y"); // 제한여부
		// NULL
		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		if (loginVO != null) {
			// MBER_ID/ENTRPRS_MBER_ID/EMPLYR_ID
			// 회원ID/기업회원ID/업무사용자ID
			// 최초등록자ID, 최종수정자ID
//			loginPolicy.setUserId(loginVO.getId());

			// ESNTL_ID, 고유ID, 최초등록자ID, 최종수정자ID
			loginPolicy.setUserId(loginVO.getUniqId());
		}

		log.debug("loginPolicy={}", loginPolicy);

		// when
		int result = loginPolicyDAO.insertLoginPolicy(loginPolicy);

		log.debug("result={}", result);

		// then
		assertEquals(1, result);
	}

}
