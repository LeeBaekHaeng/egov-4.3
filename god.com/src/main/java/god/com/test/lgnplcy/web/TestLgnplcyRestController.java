package god.com.test.lgnplcy.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import god.com.test.lgnplcy.service.TestLgnplcyService;
import god.com.test.lgnplcy.service.TestLgnplcyVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestLgnplcyRestController {

	private final TestLgnplcyService testLgnplcyService;

	/**
	 * 로그인정책 조회(단건)
	 * 
	 * @param testLgnplcyVO
	 * @return
	 */
	@PostMapping("/api/test/lgnplcy/selectTestLgnplcy.do")
	public TestLgnplcyVO selectTestLgnplcy(TestLgnplcyVO testLgnplcyVO) {
		log.debug("testLgnplcyVO={}", testLgnplcyVO);
		return testLgnplcyService.selectTestLgnplcy(testLgnplcyVO);
	}

}
