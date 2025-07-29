package god.batchgod.api.juso.web;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.junit.Test;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import god.api.cmm.web.EgovApiAbstractController;
import god.api.juso.service.JusoRequestVo;
import god.api.juso.service.JusoResponseVo;
import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * curl -v "http://125.60.46.141/addrlink/addrLinkApi.do?confmKey=devU01TX0FVVEgyMDI1MDcyMjE1MDgwOTExNTk3MDg%3D&currentPage=1&countPerPage=10&keyword=%EC%A7%80%EC%A1%B1%EB%B6%81%EB%A1%9C&resultType=json"
 * </pre>
 */
@Slf4j
public class JusoRestControllerTest extends EgovApiAbstractController {

	@Test
	public void test() {
		if (log.isDebugEnabled()) {
			log.debug("test");
		}

		JusoRequestVo jusoRequestVo = new JusoRequestVo();
		jusoRequestVo.setKeyword("지족북로");

		if (log.isDebugEnabled()) {
			log.debug("jusoRequestVo={}", jusoRequestVo);
//		log.debug("getConfmKey={}", jusoRequestVo.getConfmKey());
			log.debug("getCurrentPage={}", jusoRequestVo.getCurrentPage());
			log.debug("getCountPerPage={}", jusoRequestVo.getCountPerPage());
			log.debug("getKeyword={}", jusoRequestVo.getKeyword());
		}

		if (ObjectUtils.isEmpty(jusoRequestVo.getConfmKey())) {
			// errorCode: E0014, errorMessage: 개발승인키 기간이 만료되어 서비스를 이용하실 수 없습니다.
//	jusoRequestVo.setConfmKey("devU01TX0FVVEgyMDI0MTExMzA5NTk0MDExNTIzMTg=");
			// 개발 ( 사용기간 : 2025-07-22 ~ 2025-10-20 )
			jusoRequestVo.setConfmKey("devU01TX0FVVEgyMDI1MDcyMjE1MDgwOTExNTk3MDg=");
		}

//	if (ObjectUtils.isEmpty(jusoRequestVo.getKeyword())) {
//		jusoRequestVo.setKeyword("지족북로60");
//	}

		if (ObjectUtils.isEmpty(jusoRequestVo.getResultType())) {
			jusoRequestVo.setResultType("json");
		}

		if (log.isDebugEnabled()) {
			log.debug("jusoRequestVo={}", jusoRequestVo);
			log.debug("getConfmKey={}", jusoRequestVo.getConfmKey());
			log.debug("getCurrentPage={}", jusoRequestVo.getCurrentPage());
			log.debug("getCountPerPage={}", jusoRequestVo.getCountPerPage());
			log.debug("getKeyword={}", jusoRequestVo.getKeyword());

			log.debug("getResultType={}", jusoRequestVo.getResultType());
		}

//	RestTemplate restTemplate = new RestTemplate();
//	RestTemplate restTemplate = createRestTemplate();
		RestTemplate restTemplate = createRestTemplate(30_000);

		restTemplate.getInterceptors().add((request, body, execution) -> {
			URI uri = request.getURI();

			if (log.isDebugEnabled()) {
				log.debug("요청 URL: {}", uri.toString()); // URL 확인
			}

			return execution.execute(request, body);
		});

		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("confmKey", jusoRequestVo.getConfmKey());
		uriVariables.put("currentPage", jusoRequestVo.getCurrentPage());
		uriVariables.put("countPerPage", jusoRequestVo.getCountPerPage());
		uriVariables.put("keyword", jusoRequestVo.getKeyword());
		uriVariables.put("resultType", jusoRequestVo.getResultType());

//		String url = "https://business.juso.go.kr";
//		String url = "http://business.juso.go.kr";
		String url = "http://125.60.46.141";

		String responseString = restTemplate.getForObject(url
				+ "/addrlink/addrLinkApi.do?confmKey={confmKey}&currentPage={currentPage}&countPerPage={countPerPage}&keyword={keyword}&resultType={resultType}",
				String.class, uriVariables);

//	String responseString = restTemplate.postForObject("https://business.juso.go.kr/addrlink/addrLinkApi.do",
//			request, String.class);

		if (log.isDebugEnabled()) {
			log.debug("responseString={}", responseString);
		}

		JusoResponseVo jusoResponseVo;
//	final ObjectMapper mapper = new ObjectMapper();
//	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		final ObjectMapper mapper = createObjectMapper();
		try {
			jusoResponseVo = mapper.readValue(responseString, JusoResponseVo.class);
		} catch (JsonMappingException e) {
			throw new BaseRuntimeException(e);
		} catch (JsonProcessingException e) {
			throw new BaseRuntimeException(e);
		}

		if (log.isDebugEnabled()) {
			log.debug("jusoResponseVo={}", jusoResponseVo);
		}
	}

}
