package egovframework.com.cmm.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.test.EgovAbstractTestJUnit4;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EgovCmmUseServiceImplJUnit4Test extends EgovAbstractTestJUnit4 {

	@Autowired
	private EgovCmmUseService egovCmmUseService;

	@Test
	public void testA10selectCmmCodeDetail() {
		// given
		ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setCodeId("COM001");

		log.debug("comDefaultCodeVO={}", comDefaultCodeVO);

		// when
		List<CmmnDetailCode> resultListCmmCodeDetail = egovCmmUseService.selectCmmCodeDetail(comDefaultCodeVO);

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
	public void testB10selectCmmCodeDetails() {
		// given
		List<ComDefaultCodeVO> comDefaultCodeVOs = new ArrayList<>();
		ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setCodeId("COM001");
		comDefaultCodeVOs.add(comDefaultCodeVO);

		comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setCodeId("COM002");
		comDefaultCodeVOs.add(comDefaultCodeVO);

		log.debug("comDefaultCodeVOs={}", comDefaultCodeVOs);

		// when
		Map<String, List<CmmnDetailCode>> resultCmmCodeDetails = egovCmmUseService
				.selectCmmCodeDetails(comDefaultCodeVOs);

		resultCmmCodeDetails.forEach((key, resultListCmmnDetailCode) -> {
			log.debug("key={}", key);
			log.debug("value, resultListCmmnDetailCode={}", resultListCmmnDetailCode);

			log.debug("resultListCmmnDetailCode={}", resultListCmmnDetailCode);

			for (CmmnDetailCode resultCmmnDetailCode : resultListCmmnDetailCode) {
				log.debug("resultCmmnDetailCode={}", resultCmmnDetailCode);
				log.debug("getCodeId={}", resultCmmnDetailCode.getCodeId());
				log.debug("getCode={}", resultCmmnDetailCode.getCode());
				log.debug("getCodeNm={}", resultCmmnDetailCode.getCodeNm());
				log.debug("getCodeDc={}", resultCmmnDetailCode.getCodeDc());
			}
		});

		// then
		assertEquals(comDefaultCodeVOs.get(0).getCodeId(),
				resultCmmCodeDetails.get(comDefaultCodeVOs.get(0).getCodeId()).get(0).getCodeId());
	}

	@Test
	public void testC10selectOgrnztIdDetail() {
		// given
		ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setTableNm("COMTNORGNZTINFO");
		comDefaultCodeVO.setHaveDetailCondition("Y");
		comDefaultCodeVO.setDetailCondition("ORGNZT_0000000000000");

		log.debug("comDefaultCodeVO={}", comDefaultCodeVO);

		// when
		List<CmmnDetailCode> resultListOgrnztIdDetail = egovCmmUseService.selectOgrnztIdDetail(comDefaultCodeVO);

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
	public void testD10selectGroupIdDetail() {
		// given
		ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setTableNm("COMTNAUTHORGROUPINFO");
		comDefaultCodeVO.setHaveDetailCondition("Y");
		comDefaultCodeVO.setDetailCondition("GROUP_00000000000000");

		log.debug("comDefaultCodeVO={}", comDefaultCodeVO);

		// when
		List<CmmnDetailCode> resultListGroupIdDetail = egovCmmUseService.selectGroupIdDetail(comDefaultCodeVO);

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