package god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.HrBscInfoService;
import god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.HrBscInfoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HrBscInfoRestController {

	private final HrBscInfoService hrBscInfoService;

	@PostMapping("/api/acomdvlp/hrmng/hrinfo/hrbscinfo/insertHrBscInfo.do")
	public HrBscInfoVO insertHrBscInfo(HrBscInfoVO hrBscInfoVO) {
		if (log.isDebugEnabled()) {
			log.debug("hrBscInfoVO={}", hrBscInfoVO);
		}

		hrBscInfoVO.setEmplyrId(hrBscInfoService.getNextStringId());

		int result = hrBscInfoService.insertHrBscInfo(hrBscInfoVO);

		hrBscInfoVO.setResult(result);

		return hrBscInfoVO;
	}

}
