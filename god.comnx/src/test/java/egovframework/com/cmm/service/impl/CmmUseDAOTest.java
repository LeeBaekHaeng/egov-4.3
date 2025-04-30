package egovframework.com.cmm.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.test.EgovAbstractTestJUnit5;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class CmmUseDAOTest extends EgovAbstractTestJUnit5 {

	@Autowired
	private CmmUseDAO cmmUseDAO;

	@Test
	void testA10selectCmmCodeDetail() {
		// given
		ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setCodeId("COM001");

		log.debug("comDefaultCodeVO={}", comDefaultCodeVO);

		// when
		List<CmmnDetailCode> resultListCmmCodeDetail = cmmUseDAO.selectCmmCodeDetail(comDefaultCodeVO);

		log.debug("resultListCmmCodeDetail={}", resultListCmmCodeDetail);

		for (CmmnDetailCode resultCmmCodeDetail : resultListCmmCodeDetail) {
			log.debug("resultCmmCodeDetail={}", resultCmmCodeDetail);
			log.debug("getCodeId={}", resultCmmCodeDetail.getCodeId());
			log.debug("getCode={}", resultCmmCodeDetail.getCode());
			log.debug("getCodeNm={}", resultCmmCodeDetail.getCodeNm());
			log.debug("getCodeDc={}", resultCmmCodeDetail.getCodeDc());
		}

		// then
		assertEquals(comDefaultCodeVO.getCodeId(), resultListCmmCodeDetail.get(0).getCodeId());
	}

	@Test
	void testB10selectOgrnztIdDetail() {
		// given
		ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setTableNm("COMTNORGNZTINFO");
		comDefaultCodeVO.setHaveDetailCondition("Y");
		comDefaultCodeVO.setDetailCondition("ORGNZT_0000000000000");

		log.debug("comDefaultCodeVO={}", comDefaultCodeVO);

		// when
		List<CmmnDetailCode> resultListOgrnztIdDetail = cmmUseDAO.selectOgrnztIdDetail(comDefaultCodeVO);

		log.debug("resultListOgrnztIdDetail={}", resultListOgrnztIdDetail);

		for (CmmnDetailCode resultOgrnztIdDetail : resultListOgrnztIdDetail) {
			log.debug("resultOgrnztIdDetail={}", resultOgrnztIdDetail);
			log.debug("getCodeId={}", resultOgrnztIdDetail.getCodeId());
			log.debug("getCode={}", resultOgrnztIdDetail.getCode());
			log.debug("getCodeNm={}", resultOgrnztIdDetail.getCodeNm());
			log.debug("getCodeDc={}", resultOgrnztIdDetail.getCodeDc());
		}

		// then
		assertEquals(comDefaultCodeVO.getTableNm(), resultListOgrnztIdDetail.get(0).getCodeId());
	}

	@Test
	void testC10selectGroupIdDetail() {
		// given
		ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setTableNm("COMTNAUTHORGROUPINFO");
		comDefaultCodeVO.setHaveDetailCondition("Y");
		comDefaultCodeVO.setDetailCondition("GROUP_00000000000000");

		log.debug("comDefaultCodeVO={}", comDefaultCodeVO);

		// when
		List<CmmnDetailCode> resultListGroupIdDetail = cmmUseDAO.selectGroupIdDetail(comDefaultCodeVO);

		log.debug("resultListGroupIdDetail={}", resultListGroupIdDetail);

		for (CmmnDetailCode resultGroupIdDetail : resultListGroupIdDetail) {
			log.debug("resultGroupIdDetail={}", resultGroupIdDetail);
			log.debug("getCodeId={}", resultGroupIdDetail.getCodeId());
			log.debug("getCode={}", resultGroupIdDetail.getCode());
			log.debug("getCodeNm={}", resultGroupIdDetail.getCodeNm());
			log.debug("getCodeDc={}", resultGroupIdDetail.getCodeDc());
		}

		// then
		assertEquals(comDefaultCodeVO.getTableNm(), resultListGroupIdDetail.get(0).getCodeId());
	}

}
