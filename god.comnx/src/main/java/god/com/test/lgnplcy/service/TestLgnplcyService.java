package god.com.test.lgnplcy.service;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;

public interface TestLgnplcyService {

	/**
	 * 로그인정책 조회(단건)
	 * 
	 * @param testLgnplcyVO
	 * @return
	 */
	TestLgnplcyVO selectTestLgnplcy(TestLgnplcyVO testLgnplcyVO) throws BaseRuntimeException, Exception;

}
