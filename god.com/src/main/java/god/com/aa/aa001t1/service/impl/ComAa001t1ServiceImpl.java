package god.com.aa.aa001t1.service.impl;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import god.com.aa.aa001t1.service.ComAa001t1Service;
import god.com.aa.aa001t1.service.ComAa001t1VO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ComAa001t1 ServiceImpl
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ComAa001t1ServiceImpl extends EgovAbstractServiceImpl implements ComAa001t1Service {

	private final ComAa001t1Mapper comAa001t1Mapper;

	@Override
	public int insertComAa001t1(ComAa001t1VO comAa001t1VO) {
		if (log.isDebugEnabled()) {
			log.debug("comAa001t1VO={}", comAa001t1VO);
		}

		int result = 0;
		try {
			result = comAa001t1Mapper.insertComAa001t1(comAa001t1VO);
		} catch (DataAccessException e) {
			if (log.isErrorEnabled()) {
				log.error("DataAccessException comAa001t1Mapper.insertComAa001t1");
			}
//		} catch (BaseRuntimeException e) {
//			if (log.isErrorEnabled()) {
//				log.error("BaseRuntimeException comAa001t1Mapper.insertComAa001t1");
//			}
//		} catch (Exception e) {
//			if (log.isErrorEnabled()) {
//				log.error("Exception comAa001t1Mapper.insertComAa001t1");
//			}
		}

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		return result;
	}

	@Override
	public void insertComAa001t1(ComAa001t1VO comAa001t1VO, Model model) {
		if (log.isDebugEnabled()) {
			log.debug("comAa001t1VO={}", comAa001t1VO);
		}

		int result = comAa001t1Mapper.insertComAa001t1(comAa001t1VO);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		model.addAttribute("result2", result);
	}

}
