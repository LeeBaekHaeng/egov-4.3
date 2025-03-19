package egovframework.com.uat.uap.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.test.EgovAbstractTestJUnit5;
import egovframework.com.uat.uap.service.LoginPolicy;
import egovframework.com.uat.uap.service.LoginPolicyVO;
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
		loginPolicy.setEmplyrId("TEST1"); // 업무사용자ID
//		loginPolicy.setEmplyrId("USER"); // 업무사용자ID
//		loginPolicy.setEmplyrId("ENTERPRISE"); // 업무사용자ID
//		loginPolicy.setEmplyrId("webmaster"); // 업무사용자ID

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

	private LoginPolicy testData() {
		// given
		LoginPolicy loginPolicy = new LoginPolicy(); // 로그인정책
		// NOT NULL
		loginPolicy.setEmplyrId("TEST1"); // 업무사용자ID
//		loginPolicy.setEmplyrId("USER"); // 업무사용자ID
//		loginPolicy.setEmplyrId("ENTERPRISE"); // 업무사용자ID
//		loginPolicy.setEmplyrId("webmaster"); // 업무사용자ID

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

		return loginPolicy;
	}

	/**
	 * 조회(단건) select공통표준단어
	 */
	@Test
	void testB10selectLoginPolicy() {
		LoginPolicy testData = testData();

		// given
		LoginPolicyVO loginPolicyVO = new LoginPolicyVO(); // 로그인정책
		loginPolicyVO.setEmplyrId(testData.getEmplyrId()); // 업무사용자ID

		log.debug("loginPolicyVO={}", loginPolicyVO);

		// when
		LoginPolicyVO result = loginPolicyDAO.selectLoginPolicy(loginPolicyVO);

		log.debug("result={}", result);
		log.debug("emplyrId={}", result.getEmplyrId());
		log.debug("emplyrNm={}", result.getEmplyrNm());
		log.debug("emplyrSe={}", result.getEmplyrSe());
		log.debug("ipInfo={}", result.getIpInfo());
		log.debug("dplctPermAt={}", result.getDplctPermAt());
		log.debug("lmttAt={}", result.getLmttAt());
		log.debug("userId={}", result.getUserId());
		log.debug("regDate={}", result.getRegDate());
		log.debug("regYn={}", result.getRegYn());

		// then
		assertEquals(loginPolicyVO.getEmplyrId(), result.getEmplyrId());
		assertEquals(testData.getIpInfo(), result.getIpInfo());
		assertEquals(testData.getDplctPermAt(), result.getDplctPermAt());
		assertEquals(testData.getLmttAt(), result.getLmttAt());
		assertEquals(testData.getUserId(), result.getUserId());

		log.debug("emplyrId={}, {}", loginPolicyVO.getEmplyrId(), result.getEmplyrId());
		log.debug("ipInfo={}, {}", testData.getIpInfo(), result.getIpInfo());
		log.debug("dplctPermAt={}, {}", testData.getDplctPermAt(), result.getDplctPermAt());
		log.debug("lmttAt={}, {}", testData.getLmttAt(), result.getLmttAt());
		log.debug("userId={}, {}", testData.getUserId(), result.getUserId());
	}

	/**
	 * 조회(멀티건) select공통표준단어List
	 */
	@Test
	void testC10selectLoginPolicyList() {
		LoginPolicy testData = testData();

		// given
		LoginPolicyVO loginPolicyVO = new LoginPolicyVO(); // 로그인정책

//		loginPolicyVO.setRecordCountPerPage(10);
		loginPolicyVO.setRecordCountPerPage(propertiesService.getInt("pageUnit"));

		loginPolicyVO.setFirstIndex(0);

		loginPolicyVO.setSearchCondition("1");
		loginPolicyVO.setSearchKeyword("테스트1");

		log.debug("loginPolicyVO={}", loginPolicyVO);

		// when
		List<LoginPolicyVO> resultList = loginPolicyDAO.selectLoginPolicyList(loginPolicyVO);
		int size = resultList.size();
		boolean isEmpty = resultList.isEmpty();

		log.debug("resultList={}", resultList);
		log.debug("size={}", size);
		log.debug("isEmpty={}", isEmpty);

		for (LoginPolicyVO result : resultList) {
			log.debug("result={}", result);
			log.debug("emplyrId={}", result.getEmplyrId());
			log.debug("emplyrNm={}", result.getEmplyrNm());
			log.debug("emplyrSe={}", result.getEmplyrSe());
			log.debug("ipInfo={}", result.getIpInfo());
			log.debug("dplctPermAt={}", result.getDplctPermAt());
			log.debug("lmttAt={}", result.getLmttAt());
			log.debug("userId={}", result.getUserId());
			log.debug("regDate={}", result.getRegDate());
			log.debug("regYn={}", result.getRegYn());
		}

		int totCnt = loginPolicyDAO.selectLoginPolicyListTotCnt(loginPolicyVO);

		log.debug("totCnt={}", totCnt);

		// then
		LoginPolicyVO result = resultList.get(0);
		assertEquals(loginPolicyVO.getSearchKeyword(), result.getEmplyrNm());
		assertEquals(testData.getIpInfo(), result.getIpInfo());
		assertEquals(testData.getDplctPermAt(), result.getDplctPermAt());
		assertEquals(testData.getLmttAt(), result.getLmttAt());
		assertEquals(testData.getUserId(), result.getUserId());

		log.debug("emplyrId={}, {}", testData.getEmplyrId(), result.getEmplyrId());
		log.debug("emplyrNm={}, {}", loginPolicyVO.getSearchKeyword(), result.getEmplyrNm());
		log.debug("ipInfo={}, {}", testData.getIpInfo(), result.getIpInfo());
		log.debug("dplctPermAt={}, {}", testData.getDplctPermAt(), result.getDplctPermAt());
		log.debug("lmttAt={}, {}", testData.getLmttAt(), result.getLmttAt());
		log.debug("userId={}, {}", testData.getUserId(), result.getUserId());

		assertEquals(1, totCnt);

		log.debug("totCnt={}, {}", 1, totCnt);
	}

}
