package god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.egovframe.rte.fdl.cmmn.exception.FdlException;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
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

//	@Autowired
	@Resource(name = "hrBscInfoIdGnrService")
	private EgovIdGnrService hrBscInfoIdGnrService;

	/**
	 * 조회(단건) select[공통표준단어]
	 */
	@Test
//	@Commit
	void testA10insertHrBscInfo() {
//		LoginPolicy testData = testData();

		// given
		HrBscInfoVO hrBscInfoVO = new HrBscInfoVO(); // 로그인정책
//		hrBscInfoVO.setEmplyrId("TEST1"); // 업무사용자ID

//		String now = LocalDateTime.now().toString();
		// 현재 시간 (밀리초 포함)
		long millis = System.currentTimeMillis();
		// 밀리초를 LocalDateTime으로 변환
		LocalDateTime ldt = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDateTime();
		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
		// 포맷 적용
		String now = ldt.format(formatter);
		hrBscInfoVO.setEmplyrId("AA_" + now); // 업무사용자ID

		String hrBscInfoId;
		try {
			hrBscInfoId = hrBscInfoIdGnrService.getNextStringId();
		} catch (FdlException e) {
			throw new BaseRuntimeException("FdlException hrBscInfoIdGnrService", e);
		}

		if (log.isDebugEnabled()) {
			log.debug("hrBscInfoId={}", hrBscInfoId);
			log.debug("hrBscInfoVO={}", hrBscInfoVO);
		}

		// when
		int result = hrBscInfoMapper.insertHrBscInfo(hrBscInfoVO);

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
