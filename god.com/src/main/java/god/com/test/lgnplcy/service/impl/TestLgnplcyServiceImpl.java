package god.com.test.lgnplcy.service.impl;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import god.com.test.lgnplcy.service.TestLgnplcyService;
import god.com.test.lgnplcy.service.TestLgnplcyVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestLgnplcyServiceImpl extends EgovAbstractServiceImpl implements TestLgnplcyService {

	private final TestLgnplcyMapper testLgnplcyMapper;

	@Override
	public TestLgnplcyVO selectTestLgnplcy(TestLgnplcyVO testLgnplcyVO) {
		log.debug("testLgnplcyVO={}", testLgnplcyVO);
		return testLgnplcyMapper.selectTestLgnplcy(testLgnplcyVO);
	}

}
