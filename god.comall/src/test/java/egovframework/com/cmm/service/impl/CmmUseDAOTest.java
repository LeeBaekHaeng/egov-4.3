package egovframework.com.cmm.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.test.EgovAbstractJUnit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CmmUseDAOTest extends EgovAbstractJUnit {

	@Autowired
	private CmmUseDAO cmmUseDAO;

	@Test
	public void test() {
		// given
		ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setCodeId("COM001");

		// when
		List<CmmnDetailCode> results = cmmUseDAO.selectCmmCodeDetail(comDefaultCodeVO);

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