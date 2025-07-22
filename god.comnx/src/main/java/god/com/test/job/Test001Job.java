package god.com.test.job;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Test001Job implements Job {

	@Autowired
	private EgovCmmUseService egovCmmUseService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		if (log.isDebugEnabled()) {
			log.debug("context={}", context);
		}

		ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setCodeId("COM001");

		List<CmmnDetailCode> results = egovCmmUseService.selectCmmCodeDetail(comDefaultCodeVO);

		if (log.isDebugEnabled()) {
			log.debug("results={}", results);
			log.debug("size={}", results.size());
		}

		for (CmmnDetailCode result : results) {
			if (log.isDebugEnabled()) {
				log.debug("result={}", result);
				log.debug("getCodeId={}", result.getCodeId());
				log.debug("getCode={}", result.getCode());
				log.debug("getCodeNm={}", result.getCodeNm());
				log.debug("getCodeDc={}", result.getCodeDc());
			}
		}
	}

}
