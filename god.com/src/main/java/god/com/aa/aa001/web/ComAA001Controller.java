package god.com.aa.aa001.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import god.com.aa.aa001.service.ComAA001VO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ComAA001 Controller
 * <p>
 * <table border="1">
 * <thead>
 * <tr>
 * <th rowspan="2">단위업무명 or 서브시스템</th>
 * <th colspan="4">분석단계</th>
 * <th colspan="4">설계단계</th>
 * <th colspan="2">구현단계</th>
 * <th colspan="4">테스트</th>
 * <th colspan="2">RFP (제안요청서)</th>
 * <th rowspan="2">담당자</th>
 * </tr>
 * <tr>
 * <th>RFP ID</th>
 * <th>요구사항 명칭</th>
 * <th>요구사항 ID</th>
 * <th>요구사항명</th>
 * <th>프로세스ID</th>
 * <th>프로세스명</th>
 * <th>화면ID</th>
 * <th>화면명</th>
 * <th>프로그램ID</th>
 * <th>프로그램명</th>
 * <th>단위테스트ID</th>
 * <th>단위테스트명</th>
 * <th>통합테스트ID</th>
 * <th>통합테스트명</th>
 * <th>인수테스트ID</th>
 * <th>인수테스트명</th>
 * </tr>
 * </thead> <tbody>
 * <tr>
 * <td>단위업무명 or 서브시스템1</td>
 * <td>RFP ID1</td>
 * <td>요구사항 명칭1</td>
 * <td>요구사항 ID1</td>
 * <td>요구사항명1</td>
 * <td>프로세스ID1</td>
 * <td>프로세스명1</td>
 * <td>화면ID1</td>
 * <td>화면명1</td>
 * <td>프로그램ID1</td>
 * <td>프로그램명1</td>
 * <td>단위테스트ID1</td>
 * <td>단위테스트명1</td>
 * <td>통합테스트ID1</td>
 * <td>통합테스트명1</td>
 * <td>인수테스트ID1</td>
 * <td>인수테스트명1</td>
 * <td>담당자1</td>
 * </tr>
 * </tbody>
 * </table>
 */
@Controller
@RequiredArgsConstructor
@Slf4j
public class ComAA001Controller {

	/**
	 * ComAA001 등록 화면
	 * 
	 * @param comAA001VO
	 * @param model
	 * @return
	 */
	@GetMapping("/com/aa/aa001/insertComAA001View.do")
	public String insertComAA001View(ComAA001VO comAA001VO, Model model) {
		if (log.isDebugEnabled()) {
			log.debug("comAA001VO={}", comAA001VO);
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
		}
		model.addAttribute("loginVO", loginVO);

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

		return "jsonView";
	}

	/**
	 * ComAA001 등록
	 * 
	 * @param comAA001VO
	 * @param model
	 * @return
	 */
	@PostMapping("/com/aa/aa001/insertComAA001.do")
	public String insertComAA001(ComAA001VO comAA001VO, Model model) {
		return "jsonView";
	}

	@GetMapping("/com/aa/aa001/selectComAA001Login.do")
	public String selectComAA001Login(ComAA001VO comAA001VO, Model model, HttpSession session) {
		selectComAA001LoginAuthenticatedUser(comAA001VO, model, session);
		selectComAA001LoginAuthorities(comAA001VO, model, session);
		return "jsonView";
	}

	private void selectComAA001LoginAuthenticatedUser(ComAA001VO comAA001VO, Model model, HttpSession session) {
		LoginVO loginVO = new LoginVO();
		loginVO.setId("TEST1");
		loginVO.setPassword("raHLBnHFcunwNzcDcfad4PhD11hHgXSUr7fc1Jk9uoQ=");
		loginVO.setUserSe("USR");
		loginVO.setEmail("egovframe@nia.or.kr");
		loginVO.setIhidNum("");
		loginVO.setName("더미사용자");
		loginVO.setOrgnztId("ORGNZT_0000000000000");
		loginVO.setUniqId("USRCNFRM_00000000000");

		if (log.isDebugEnabled()) {
			log.debug("loginVO={}", loginVO);
			log.debug("getId={}", loginVO.getId());
			log.debug("getName={}", loginVO.getName());
			log.debug("getUserSe={}", loginVO.getUserSe());
			log.debug("getUniqId={}", loginVO.getUniqId());
		}

		model.addAttribute("loginVO", loginVO);

		session.setAttribute("loginVO", loginVO);
	}

	private void selectComAA001LoginAuthorities(ComAA001VO comAA001VO, Model model, HttpSession session) {
		List<String> listAuth = new ArrayList<String>();
		listAuth.add("IS_AUTHENTICATED_ANONYMOUSLY");
		listAuth.add("IS_AUTHENTICATED_FULLY");
		listAuth.add("IS_AUTHENTICATED_REMEMBERED");
		listAuth.add("ROLE_ADMIN");
		listAuth.add("ROLE_ANONYMOUS");
		listAuth.add("ROLE_RESTRICTED");
		listAuth.add("ROLE_USER");

		if (log.isDebugEnabled()) {
			log.debug("listAuth={}", listAuth);
		}

		model.addAttribute("loginAuthorities", listAuth);

		session.setAttribute("loginAuthorities", listAuth);
	}

	@GetMapping("/com/aa/aa001/selectComAA001User.do")
	public String selectComAA001User(ComAA001VO comAA001VO, Model model, HttpSession session) {
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
		}
		model.addAttribute("loginVO", loginVO);

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

		return "jsonView";
	}

	@GetMapping("/com/aa/aa001/selectComAA001Logout.do")
	public String selectComAA001Logout(ComAA001VO comAA001VO, Model model, HttpSession session) {
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
		}
		model.addAttribute("loginVO", loginVO);

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

		session.removeAttribute("loginVO");
		session.removeAttribute("loginAuthorities");

		// 인증된 사용자객체를 VO형식으로 가져온다.
		LoginVO loginVO2 = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		if (log.isDebugEnabled()) {
			log.debug("loginVO2={}", loginVO2);
		}
		if (loginVO2 != null) {
			if (log.isDebugEnabled()) {
				log.debug("getUniqId={}", loginVO2.getUniqId());
				log.debug("getIp={}", loginVO2.getIp());
			}
		}
		model.addAttribute("loginVO2", loginVO2);

		// 인증된 사용자의 권한 정보를 가져온다.
		List<String> loginAuthorities2 = EgovUserDetailsHelper.getAuthorities();
		if (log.isDebugEnabled()) {
			log.debug("loginAuthorities2={}", loginAuthorities2);
		}
		if (loginAuthorities2 != null) {
			if (loginAuthorities2.contains("ROLE_ANONYMOUS")) {
				if (log.isDebugEnabled()) {
					log.debug("ROLE_ANONYMOUS, 모든 사용자={}", loginAuthorities2);
				}
			}

			if (loginAuthorities2.contains("ROLE_USER")) {
				if (log.isDebugEnabled()) {
					log.debug("ROLE_USER, 일반 사용자={}", loginAuthorities2);
				}
			}

			if (loginAuthorities2.contains("ROLE_ADMIN")) {
				if (log.isDebugEnabled()) {
					log.debug("ROLE_ADMIN, 관리자={}", loginAuthorities2);
				}
			}
		}
		model.addAttribute("loginAuthorities2", loginAuthorities2);

		return "jsonView";
	}

}
