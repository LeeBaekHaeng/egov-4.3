package god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.web;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springmodules.validation.commons.DefaultBeanValidator;

import god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.HrBscInfoService;
import god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.HrBscInfoUpdt2VO;
import god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.HrBscInfoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HrBscInfoRestController {

	private final HrBscInfoService hrBscInfoService;

	private final DefaultBeanValidator beanValidator;

	@PostMapping("/api/acomdvlp/hrmng/hrinfo/hrbscinfo/insertHrBscInfo.do")
	public HrBscInfoVO insertHrBscInfo(HrBscInfoVO hrBscInfoVO, BindingResult bindingResult) {
		if (log.isDebugEnabled()) {
			log.debug("hrBscInfoVO={}", hrBscInfoVO);
		}

		beanValidator.validate(hrBscInfoVO, bindingResult); // validation 수행

		if (bindingResult.hasErrors()) {
			hrBscInfoVO.setAllErrors(bindingResult.getAllErrors());
			return hrBscInfoVO;
		}

		hrBscInfoVO.setEmplyrId(hrBscInfoService.getNextStringId());

		int result = hrBscInfoService.insertHrBscInfo(hrBscInfoVO);

		hrBscInfoVO.setResult(result);

		return hrBscInfoVO;
	}

	@PostMapping("/api/acomdvlp/hrmng/hrinfo/hrbscinfo/update2HrBscInfo.do")
	public HrBscInfoVO updateHr2BscInfo(HrBscInfoUpdt2VO hrBscInfoUpdt2VO, BindingResult bindingResult) {
		if (log.isDebugEnabled()) {
			log.debug("hrBscInfoUpdt2VO={}", hrBscInfoUpdt2VO);
		}

		beanValidator.validate(hrBscInfoUpdt2VO, bindingResult);

		if (bindingResult.hasErrors()) {
			hrBscInfoUpdt2VO.setAllErrors(bindingResult.getAllErrors());
			return hrBscInfoUpdt2VO;
		}

		return hrBscInfoUpdt2VO;
	}

}
