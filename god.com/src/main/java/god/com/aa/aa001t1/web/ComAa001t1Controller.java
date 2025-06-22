package god.com.aa.aa001t1.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.cmm.web.EgovComAbstractController;
import egovframework.com.utl.sim.service.EgovClntInfo;
import god.com.aa.aa001t1.service.ComAa001t1Service;
import god.com.aa.aa001t1.service.ComAa001t1VO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ComAa001t1 Controller
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class ComAa001t1Controller extends EgovComAbstractController {

	private final ComAa001t1Service comAa001t1Service;

	@GetMapping("/com/aa/aa001/insertComAa001t1.do")
	public String insertComAa001t1(ComAa001t1VO comAa001t1VO, Model model, HttpServletRequest request) {
		if (log.isDebugEnabled()) {
			log.debug("comAa001t1VO={}", comAa001t1VO);
		}

		// 인증된 사용자객체를 VO형식으로 가져온다.
		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		if (log.isDebugEnabled()) {
			log.debug("loginVO={}", loginVO);
		}
		if (loginVO != null) {
			if (log.isDebugEnabled()) {
				log.debug("getUniqId={}", loginVO.getUniqId());
				log.debug("getIp={}", loginVO.getIp());
			}

			comAa001t1VO.setFrstRegisterId(loginVO.getUniqId());
			comAa001t1VO.setLastUpdusrId(loginVO.getUniqId());
		}
		model.addAttribute("loginVO", loginVO);
		LocalDateTime frstRegistPnttm = LocalDateTime.now();
		String frstRegistPnttm2 = frstRegistPnttm.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
		comAa001t1VO.setFrstRegistPnttm(frstRegistPnttm);
		comAa001t1VO.setFrstRegistPnttm2(frstRegistPnttm2);
		comAa001t1VO.setLastUpdtPnttm(frstRegistPnttm);
		comAa001t1VO.setLastUpdtPnttm2(frstRegistPnttm2);

		// 인증된 사용자의 권한 정보를 가져온다.
		List<String> loginAuthorities = EgovUserDetailsHelper.getAuthorities();
		if (log.isDebugEnabled()) {
			log.debug("loginAuthorities={}", loginAuthorities);
		}
		if (loginAuthorities != null) {
			if (loginAuthorities.contains("ROLE_ANONYMOUS")) {
				if (log.isDebugEnabled()) {
					log.debug("ROLE_ANONYMOUS, 모든 사용자={}", loginAuthorities);
				}
			}

			if (loginAuthorities.contains("ROLE_USER")) {
				if (log.isDebugEnabled()) {
					log.debug("ROLE_USER, 일반 사용자={}", loginAuthorities);
				}
			}

			if (loginAuthorities.contains("ROLE_ADMIN")) {
				if (log.isDebugEnabled()) {
					log.debug("ROLE_ADMIN, 관리자={}", loginAuthorities);
				}
			}
		}
		model.addAttribute("loginAuthorities", loginAuthorities);

		comAa001t1VO.setEmplyrId("t" + frstRegistPnttm2);
		comAa001t1VO.setIpInfo(EgovClntInfo.getClntIP(request));
		comAa001t1VO.setDplctPermAt(ComAa001t1VO.DPLCT_PERM_AT_Y);
		comAa001t1VO.setLmttAt("Y");

		int result = comAa001t1Service.insertComAa001t1(comAa001t1VO);

		if (log.isDebugEnabled()) {
			log.debug("result={}", result);
		}

		model.addAttribute("result", result);

		comAa001t1VO.setEmplyrId("t_" + frstRegistPnttm2);
		comAa001t1Service.insertComAa001t1(comAa001t1VO, model);

		return "jsonView";
	}

}
