package god.com.test.lgnplcy.service.impl;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import god.com.test.lgnplcy.service.TestLgnplcyVO;

@Mapper
public interface TestLgnplcyMapper {

	/**
	 * 로그인정책 조회(단건)
	 * 
	 * @param testLgnplcyVO
	 * @return
	 */
	TestLgnplcyVO selectTestLgnplcy(TestLgnplcyVO testLgnplcyVO);

}
