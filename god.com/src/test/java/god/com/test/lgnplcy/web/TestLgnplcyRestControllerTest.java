package god.com.test.lgnplcy.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import egovframework.com.test.EgovAbstractTestJUnit5;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class TestLgnplcyRestControllerTest extends EgovAbstractTestJUnit5 {

//	@Autowired
//	private TestLgnplcyService testLgnplcyService;

//	@Autowired
//	private EgovPropertyService propertiesService;

//	/**
//	 * 등록 insert[공통표준단어]
//	 */
//	@Test
////	@Commit
//	void testA10insertLoginPolicy() {
//		// given
//		LoginPolicy loginPolicy = new LoginPolicy(); // 로그인정책
//		// NOT NULL
//		loginPolicy.setEmplyrId("TEST1"); // 업무사용자ID
////		loginPolicy.setEmplyrId("USER"); // 업무사용자ID
////		loginPolicy.setEmplyrId("ENTERPRISE"); // 업무사용자ID
////		loginPolicy.setEmplyrId("webmaster"); // 업무사용자ID
//
//		loginPolicy.setIpInfo("127.0.0.1"); // IP정보
//		loginPolicy.setDplctPermAt("Y"); // 중복허용여부
//		loginPolicy.setLmttAt("Y"); // 제한여부
//		// NULL
//		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
//		if (loginVO != null) {
//			// MBER_ID/ENTRPRS_MBER_ID/EMPLYR_ID
//			// 회원ID/기업회원ID/업무사용자ID
//			// 최초등록자ID, 최종수정자ID
////			loginPolicy.setUserId(loginVO.getId());
//
//			// ESNTL_ID, 고유ID, 최초등록자ID, 최종수정자ID
//			loginPolicy.setUserId(loginVO.getUniqId());
//		}
//
//		log.debug("loginPolicy={}", loginPolicy);
//
//		// when
//		int result = loginPolicyDAO.insertLoginPolicy(loginPolicy);
//
//		log.debug("result={}", result);
//
//		// then
//		assertEquals(1, result);
//	}

//	private LoginPolicy testData() {
//		// given
//		LoginPolicy loginPolicy = new LoginPolicy(); // 로그인정책
//		// NOT NULL
//		loginPolicy.setEmplyrId("TEST1"); // 업무사용자ID
////		loginPolicy.setEmplyrId("USER"); // 업무사용자ID
////		loginPolicy.setEmplyrId("ENTERPRISE"); // 업무사용자ID
////		loginPolicy.setEmplyrId("webmaster"); // 업무사용자ID
//
//		loginPolicy.setIpInfo("127.0.0.1"); // IP정보
//		loginPolicy.setDplctPermAt("Y"); // 중복허용여부
//		loginPolicy.setLmttAt("Y"); // 제한여부
//		// NULL
//		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
//		if (loginVO != null) {
//			// MBER_ID/ENTRPRS_MBER_ID/EMPLYR_ID
//			// 회원ID/기업회원ID/업무사용자ID
//			// 최초등록자ID, 최종수정자ID
////			loginPolicy.setUserId(loginVO.getId());
//
//			// ESNTL_ID, 고유ID, 최초등록자ID, 최종수정자ID
//			loginPolicy.setUserId(loginVO.getUniqId());
//		}
//
//		log.debug("loginPolicy={}", loginPolicy);
//
//		// when
//		int result = loginPolicyDAO.insertLoginPolicy(loginPolicy);
//
//		log.debug("result={}", result);
//
//		// then
//		assertEquals(1, result);
//
//		return loginPolicy;
//	}

	/**
	 * 조회(단건) select[공통표준단어]
	 */
	@Test
	void testB10selectTestLgnplcy() {
		String emplyrId = "TEST1";

		Assertions.assertDoesNotThrow(() ->

		mockMvc.perform(post("/api/test/lgnplcy/selectTestLgnplcy.do").param("emplyrId", emplyrId))

				.andExpect(status().isOk())

//				.andExpect(jsonPath("$.emplyrId").value(emplyrId))

				.andDo(print())

		);

////		LoginPolicy testData = testData();
//
//		// given
//		TestLgnplcyVO testLgnplcyVO = new TestLgnplcyVO(); // 로그인정책
//		testLgnplcyVO.setEmplyrId("TEST1"); // 업무사용자ID
//
//		log.debug("testLgnplcyVO={}", testLgnplcyVO);
//
//		// when
//		TestLgnplcyVO result = testLgnplcyService.selectTestLgnplcy(testLgnplcyVO);
//
//		log.debug("result={}", result);
//		log.debug("emplyrId={}", result.getEmplyrId());
////		log.debug("emplyrNm={}", result.getEmplyrNm());
////		log.debug("emplyrSe={}", result.getEmplyrSe());
////		log.debug("ipInfo={}", result.getIpInfo());
////		log.debug("dplctPermAt={}", result.getDplctPermAt());
////		log.debug("lmttAt={}", result.getLmttAt());
////		log.debug("userId={}", result.getUserId());
////		log.debug("regDate={}", result.getRegDate());
////		log.debug("regYn={}", result.getRegYn());
////
////		// then
//		assertEquals(testLgnplcyVO.getEmplyrId(), result.getEmplyrId());
////		assertEquals(testData.getIpInfo(), result.getIpInfo());
////		assertEquals(testData.getDplctPermAt(), result.getDplctPermAt());
////		assertEquals(testData.getLmttAt(), result.getLmttAt());
////		assertEquals(testData.getUserId(), result.getUserId());
//
//		log.debug("=예상, 실제");
//		log.debug("emplyrId={}, {}", testLgnplcyVO.getEmplyrId(), result.getEmplyrId());
////		log.debug("ipInfo={}, {}", testData.getIpInfo(), result.getIpInfo());
////		log.debug("dplctPermAt={}, {}", testData.getDplctPermAt(), result.getDplctPermAt());
////		log.debug("lmttAt={}, {}", testData.getLmttAt(), result.getLmttAt());
////		log.debug("userId={}, {}", testData.getUserId(), result.getUserId());
	}

//	/**
//	 * 조회(멀티건) select[공통표준단어]List
//	 */
//	@Test
//	void testC10selectLoginPolicyList() {
//		LoginPolicy testData = testData();
//
//		// given
//		LoginPolicyVO loginPolicyVO = new LoginPolicyVO(); // 로그인정책
//
////		loginPolicyVO.setRecordCountPerPage(10);
//		loginPolicyVO.setRecordCountPerPage(propertiesService.getInt("pageUnit"));
//
//		loginPolicyVO.setFirstIndex(0);
//
//		loginPolicyVO.setSearchCondition("1");
//		loginPolicyVO.setSearchKeyword("테스트1");
//
//		log.debug("loginPolicyVO={}", loginPolicyVO);
//
//		// when
//		List<LoginPolicyVO> resultList = loginPolicyDAO.selectLoginPolicyList(loginPolicyVO);
//		int size = resultList.size();
//		boolean isEmpty = resultList.isEmpty();
//
//		log.debug("resultList={}", resultList);
//		log.debug("size={}", size);
//		log.debug("isEmpty={}", isEmpty);
//
//		for (LoginPolicyVO result : resultList) {
//			log.debug("result={}", result);
//			log.debug("emplyrId={}", result.getEmplyrId());
//			log.debug("emplyrNm={}", result.getEmplyrNm());
//			log.debug("emplyrSe={}", result.getEmplyrSe());
//			log.debug("ipInfo={}", result.getIpInfo());
//			log.debug("dplctPermAt={}", result.getDplctPermAt());
//			log.debug("lmttAt={}", result.getLmttAt());
//			log.debug("userId={}", result.getUserId());
//			log.debug("regDate={}", result.getRegDate());
//			log.debug("regYn={}", result.getRegYn());
//		}
//
//		int totCnt = loginPolicyDAO.selectLoginPolicyListTotCnt(loginPolicyVO);
//
//		log.debug("totCnt={}", totCnt);
//
//		// then
//		LoginPolicyVO result = resultList.get(0);
//		assertEquals(loginPolicyVO.getSearchKeyword(), result.getEmplyrNm());
//		assertEquals(testData.getIpInfo(), result.getIpInfo());
//		assertEquals(testData.getDplctPermAt(), result.getDplctPermAt());
//		assertEquals(testData.getLmttAt(), result.getLmttAt());
//		assertEquals(testData.getUserId(), result.getUserId());
//
//		log.debug("emplyrId={}, {}", testData.getEmplyrId(), result.getEmplyrId());
//		log.debug("emplyrNm={}, {}", loginPolicyVO.getSearchKeyword(), result.getEmplyrNm());
//		log.debug("ipInfo={}, {}", testData.getIpInfo(), result.getIpInfo());
//		log.debug("dplctPermAt={}, {}", testData.getDplctPermAt(), result.getDplctPermAt());
//		log.debug("lmttAt={}, {}", testData.getLmttAt(), result.getLmttAt());
//		log.debug("userId={}, {}", testData.getUserId(), result.getUserId());
//
//		assertEquals(1, totCnt);
//
//		log.debug("totCnt={}, {}", 1, totCnt);
//	}
//
//	/**
//	 * 수정 update[공통표준단어]
//	 */
//	@Test
//	void testD10updateLoginPolicy() {
//		LoginPolicy testData = testData();
//
//		// given
//		LoginPolicy loginPolicy = new LoginPolicy();
//		// NOT NULL
//		loginPolicy.setEmplyrId(testData.getEmplyrId());
//		loginPolicy.setIpInfo("127.0.0.2");
//		loginPolicy.setDplctPermAt("N");
//		loginPolicy.setLmttAt("N");
//		// NULL
//		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
//		if (loginVO != null) {
//			// MBER_ID/ENTRPRS_MBER_ID/EMPLYR_ID
//			// 회원ID/기업회원ID/업무사용자ID
//			// 최초등록자ID, 최종수정자ID
////			loginPolicy.setUserId(loginVO.getId());
//
//			// ESNTL_ID, 고유ID, 최초등록자ID, 최종수정자ID
//			loginPolicy.setUserId(loginVO.getUniqId());
//		}
//
//		log.debug("loginPolicy={}", loginPolicy);
//
//		// when
//		int result = loginPolicyDAO.updateLoginPolicy(loginPolicy);
//
//		log.debug("result={}", result);
//
//		// then
//		assertEquals(1, result);
//
//		log.debug("result={}, {}", 1, result);
//	}
//
//	/**
//	 * 삭제 delete[공통표준단어]
//	 */
//	@Test
//	void testE10deleteLoginPolicy() {
//		LoginPolicy testData = testData();
//
//		// given
//		LoginPolicy loginPolicy = new LoginPolicy();
//		// NOT NULL
//		loginPolicy.setEmplyrId(testData.getEmplyrId());
//
//		log.debug("loginPolicy={}", loginPolicy);
//
//		// when
//		int result = loginPolicyDAO.deleteLoginPolicy(loginPolicy);
//
//		log.debug("result={}", result);
//
//		// then
//		assertEquals(1, result);
//
//		log.debug("result={}, {}", 1, result);
//	}
//
//	/**
//	 * 등록/수정 merge[공통표준단어]
//	 */
//	@Test
//	void testF10mergeLoginPolicy() {
//		// TODO 이백행 2025-03-19 로그인정책 등록/수정 DAO 단위 테스트
//	}
//
//	/**
//	 * 등록/수정/삭제 multi[공통표준단어]
//	 */
//	@Test
//	void testG10multiLoginPolicy() {
//		// TODO 이백행 2025-03-19 로그인정책 등록/수정/삭제 DAO 단위 테스트
//	}

}
