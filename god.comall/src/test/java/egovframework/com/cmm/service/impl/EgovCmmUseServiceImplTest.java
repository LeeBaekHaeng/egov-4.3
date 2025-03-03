package egovframework.com.cmm.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.test.EgovAbstractJUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EgovCmmUseServiceImplTest extends EgovAbstractJUnit {

	@Autowired
	private EgovCmmUseService egovCmmUseService;

	@Test
	public void test() {
		// given
		ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setCodeId("COM001");

		// when
		List<CmmnDetailCode> results = egovCmmUseService.selectCmmCodeDetail(comDefaultCodeVO);

		// then
		assertEquals(results.get(0).getCodeId(), comDefaultCodeVO.getCodeId());

		log.debug("results={}", results);

		for (CmmnDetailCode result : results) {
			log.debug("result={}", result);
			log.debug("getCodeId={}", result.getCodeId());
			log.debug("getCode={}", result.getCode());
			log.debug("getCodeNm={}", result.getCodeNm());
			log.debug("getCodeDc={}", result.getCodeDc());
		}
	}

}