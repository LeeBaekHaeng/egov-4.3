package god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.test.EgovAbstractTestJUnit5;
import god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.HrBscInfoVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Commit
class HrBscInfoMapperTest extends EgovAbstractTestJUnit5 {

	@Autowired
	private HrBscInfoMapper hrBscInfoMapper;

	/**
	 * 조회(단건) select[공통표준단어]
	 */
	@Test
//	@Commit
	void testA10insertHrBscInfo() {
//		LoginPolicy testData = testData();

		// given
		HrBscInfoVO hrBscInfoVO = new HrBscInfoVO(); // 로그인정책
		hrBscInfoVO.setEmplyrId("TEST1"); // 업무사용자ID

		if (log.isDebugEnabled()) {
			log.debug("hrBscInfoVO={}", hrBscInfoVO);
		}

		// when
		int result = hrBscInfoMapper.insertHrBscInfo();

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		// then
		assertEquals(1, result);

		if (log.isDebugEnabled()) {
			log.debug("=예상, 실제");
			log.debug("result={}, {}", 1, result);
		}
	}

}
