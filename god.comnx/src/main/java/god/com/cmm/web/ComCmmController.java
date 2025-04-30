package god.com.cmm.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import god.com.cmm.web.service.SelectCmmCodeDetailsRequestVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ComCmmController {

	private final EgovCmmUseService egovCmmUseService;

	// http://localhost:8080/comnx/cmm/selectCmmCodeDetails.do?codeIds=COM001&codeIds=COM002

	@GetMapping("/cmm/selectCmmCodeDetails.do")
	public String selectCmmCodeDetails(SelectCmmCodeDetailsRequestVO selectCmmCodeDetailsRequestVO, Model model) {
		if (log.isDebugEnabled()) {
			log.debug("cmmSelectCmmCodeDetailsVO={}", selectCmmCodeDetailsRequestVO);
		}

		List<ComDefaultCodeVO> comDefaultCodeVOs = new ArrayList<>();
		if (selectCmmCodeDetailsRequestVO.getCodeIds() != null) {
			for (String codeId : selectCmmCodeDetailsRequestVO.getCodeIds()) {
				ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
				comDefaultCodeVO.setCodeId(codeId);
				comDefaultCodeVOs.add(comDefaultCodeVO);
			}
		}

		model.addAttribute("cmmCodeDetails", egovCmmUseService.selectCmmCodeDetails(comDefaultCodeVOs));

		return "jsonView";
	}

}
