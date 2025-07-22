package god.api.a.a.web;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import god.api.a.a.service.AaRequestVo;
import god.api.a.a.service.AaResponseVo;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AaRestController {

	// http://localhost:9300/api/a/a?a=a에이&b=b비
	// http://localhost:9300/api/a/a?a=a%EC%97%90%EC%9D%B4&b=b%EB%B9%84

	@GetMapping("/api/a/a")
	public AaResponseVo a(AaRequestVo aaRequestVo) {
		if (log.isDebugEnabled()) {
			log.debug("aaRequestVo={}", aaRequestVo);
			log.debug("getA={}", aaRequestVo.getA());
			log.debug("getB={}", aaRequestVo.getB());
		}

		AaResponseVo aaResponseVo = new AaResponseVo();

		aaResponseVo.setResult("결과");

		aaResponseVo.setResults(Arrays.asList("결과1", "결과2", aaRequestVo.getA(), aaRequestVo.getB()));

		if (log.isDebugEnabled()) {
			log.debug("aaResultVo={}", aaResponseVo);
			log.debug("getA={}", aaResponseVo.getResult());
			log.debug("getResults={}", aaResponseVo.getResults());
			log.debug("size={}", aaResponseVo.getResults().size());
		}

		return aaResponseVo;
	}

}
