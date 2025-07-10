package god.com.test.lgnplcy.service.impl;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.EgovMessageSource;
import god.com.test.lgnplcy.service.TestLgnplcyService;
import god.com.test.lgnplcy.service.TestLgnplcyVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestLgnplcyServiceImpl extends EgovAbstractServiceImpl implements TestLgnplcyService {

	private final TestLgnplcyMapper testLgnplcyMapper;

	private final EgovMessageSource egovMessageSource;

	/**
	 * <pre>
	 * 소프트웨어 개발보안 가이드
	 *   04. 에러 처리
	 *     36. 부적절한 예외 처리
	 *       부적절한 예외 처리(광벙위한 예외객체 사용)
	 *       부적절한 예외 처리(광벙위한 예외객체 선언)
	 * </pre>
	 */
	@Override
	public TestLgnplcyVO selectTestLgnplcy(TestLgnplcyVO testLgnplcyVO) throws BaseRuntimeException, Exception {
		if (log.isDebugEnabled()) {
			log.debug("testLgnplcyVO={}", testLgnplcyVO);
		}

		TestLgnplcyVO result = null;

		try {
			result = testLgnplcyMapper.selectTestLgnplcy(testLgnplcyVO);

			if (result == null) {
				throw new BaseRuntimeException(
						"selectTestLgnplcy result " + egovMessageSource.getMessage("info.nodata.msg"));
			}
		} catch (DataAccessException e) {
			if (log.isErrorEnabled()) {
				log.error("DataAccessException: selectTestLgnplcy", e);
			}
		} catch (BaseRuntimeException e) {
			if (log.isErrorEnabled()) {
				log.error("BaseRuntimeException: selectTestLgnplcy", e);
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Exception: selectTestLgnplcy", e);
			}
		}

		return result;
	}

}
