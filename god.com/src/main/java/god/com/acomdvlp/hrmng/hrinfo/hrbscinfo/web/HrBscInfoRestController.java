package god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.web;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springmodules.validation.commons.DefaultBeanValidator;

import god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.HrBscInfoService;
import god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.HrBscInfoUpdt2VO;
import god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.HrBscInfoUpdt3VO;
import god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.HrBscInfoUpdtVO;
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

	@PostMapping("/api/acomdvlp/hrmng/hrinfo/hrbscinfo/update3HrBscInfo.do")
	public HrBscInfoVO update3HrBscInfo(HrBscInfoUpdt3VO hrBscInfoUpdt3VO, BindingResult bindingResult) {
		if (log.isDebugEnabled()) {
			log.debug("hrBscInfoUpdt3VO={}", hrBscInfoUpdt3VO);
		}

		beanValidator.validate(hrBscInfoUpdt3VO, bindingResult);

		if (bindingResult.hasErrors()) {
			hrBscInfoUpdt3VO.setAllErrors(bindingResult.getAllErrors());
			return hrBscInfoUpdt3VO;
		}

		hrBscInfoUpdt3VO.setEmplyrId(hrBscInfoService.getNextStringId());

		int result = hrBscInfoService.insertHrBscInfo(hrBscInfoUpdt3VO);

		hrBscInfoUpdt3VO.setResult(result);

		return hrBscInfoUpdt3VO;
	}

	@PostMapping("/api/acomdvlp/hrmng/hrinfo/hrbscinfo/updateHrBscInfo.do")
	public HrBscInfoVO update(HrBscInfoUpdtVO hrBscInfoUpdtVO, BindingResult bindingResult) {
		if (log.isDebugEnabled()) {
			log.debug("hrBscInfoUpdtVO={}", hrBscInfoUpdtVO);
		}

		beanValidator.validate(hrBscInfoUpdtVO, bindingResult);

		if (bindingResult.hasErrors()) {
			hrBscInfoUpdtVO.setAllErrors(bindingResult.getAllErrors());
			return hrBscInfoUpdtVO;
		}

		hrBscInfoUpdtVO.setEmplyrId(hrBscInfoService.getNextStringId());

		int result = hrBscInfoService.insertHrBscInfo(hrBscInfoUpdtVO);

		hrBscInfoUpdtVO.setResult(result);

		return hrBscInfoUpdtVO;
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
