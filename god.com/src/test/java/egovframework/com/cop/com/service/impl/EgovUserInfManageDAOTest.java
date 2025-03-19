package egovframework.com.cop.com.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import egovframework.com.cop.com.service.UserInfVO;
import egovframework.com.test.EgovAbstractTestJUnit5;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EgovUserInfManageDAOTest extends EgovAbstractTestJUnit5 {

	@Autowired
	private EgovUserInfManageDAO egovUserInfManageDAO;

//	@Resource(name = "propertiesService")
//	private EgovPropertyService propertiesService;

//	@Autowired
//	@Qualifier("propertiesService")
//	private EgovPropertyService egovPropertyService;

	@Autowired
	private EgovPropertyService propertiesService;

	@Test
	void testA10selectUserList() {
		// given
		UserInfVO userInfVO = new UserInfVO();

//		userInfVO.setRecordCountPerPage(10);
//		userInfVO.setRecordCountPerPage(egovPropertyService.getInt("pageUnit"));
		userInfVO.setRecordCountPerPage(propertiesService.getInt("pageUnit"));

		userInfVO.setFirstIndex(0);

		log.debug("comDefaultCodeVO={}", userInfVO);

		// when
		List<UserInfVO> resultList = egovUserInfManageDAO.selectUserList(userInfVO);
		int size = resultList.size();
		boolean isEmpty = resultList.isEmpty();

		log.debug("resultList={}", resultList);
		log.debug("size={}", size);
		log.debug("isEmpty={}", isEmpty);

		for (UserInfVO result : resultList) {
			log.debug("result={}", result);
			log.debug("uniqId={}", result.getUniqId());
			log.debug("userId={}", result.getUserId());
			log.debug("userNm={}", result.getUserNm());
			log.debug("userZip={}", result.getUserZip());
			log.debug("userAdres={}", result.getUserAdres());
			log.debug("userEmail={}", result.getUserEmail());
		}

		// then
		assertTrue(size > 0);
		assertEquals(false, isEmpty);
	}

	@Test
	void testA10selectUserList2() {
		// given
		UserInfVO userInfVO = new UserInfVO();
//		userInfVO.setRecordCountPerPage(10);
		userInfVO.setRecordCountPerPage(propertiesService.getInt("pageUnit"));
		userInfVO.setFirstIndex(0);

//		userInfVO.setSearchCnd(null);
//		userInfVO.setSearchCnd("-1");
		userInfVO.setSearchCnd("0");
//		userInfVO.setSearchCnd("1");

		userInfVO.setSearchWrd("test 이백행 " + LocalDateTime.now());

		log.debug("comDefaultCodeVO={}", userInfVO);

		// when
		List<UserInfVO> resultList = egovUserInfManageDAO.selectUserList(userInfVO);
		int size = resultList.size();
		boolean isEmpty = resultList.isEmpty();

		log.debug("resultList={}", resultList);
		log.debug("size={}", size);
		log.debug("isEmpty={}", isEmpty);

		for (UserInfVO result : resultList) {
			log.debug("result={}", result);
			log.debug("uniqId={}", result.getUniqId());
			log.debug("userId={}", result.getUserId());
			log.debug("userNm={}", result.getUserNm());
			log.debug("userZip={}", result.getUserZip());
			log.debug("userAdres={}", result.getUserAdres());
			log.debug("userEmail={}", result.getUserEmail());
		}

		// then
		assertEquals(0, size);
		assertEquals(true, isEmpty);
	}

}
