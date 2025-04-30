package god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.impl;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.egovframe.rte.fdl.cmmn.exception.FdlException;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.springframework.stereotype.Service;

import god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.HrBscInfoService;
import god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.HrBscInfoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class HrBscInfoServiceImpl extends EgovAbstractServiceImpl implements HrBscInfoService {

	private final HrBscInfoMapper hrBscInfoMapper;

	private final EgovIdGnrService hrBscInfoIdGnrService;

	@Override
	public int insertHrBscInfo(HrBscInfoVO hrBscInfoVO) {
		if (log.isDebugEnabled()) {
			log.debug("hrBscInfoVO={}", hrBscInfoVO);
		}
		return hrBscInfoMapper.insertHrBscInfo(hrBscInfoVO);
	}

	@Override
	public String getNextStringId() {
		if (log.isDebugEnabled()) {
			log.debug("selectHrBscInfoId");
		}
		try {
			return hrBscInfoIdGnrService.getNextStringId();
		} catch (FdlException e) {
			throw new BaseRuntimeException("FdlException hrBscInfoIdGnrService", e);
		}
	}

}
