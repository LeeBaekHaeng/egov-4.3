package god.api.juso.web;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import god.api.cmm.web.EgovApiAbstractController;
import god.api.juso.service.JusoRequestVo;
import god.api.juso.service.JusoResponseVo;
import lombok.extern.slf4j.Slf4j;

/**
 * 도로명주소 검색 API
 * 
 * @author 이백행
 * @since 2025.07.22
 * @version 1.0
 * @see
 *
 *      <pre>
 *  == 개정이력(Modification Information) ==
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2025.07.22  이백행          최초 생성
 *
 *      </pre>
 */
@RestController
@Slf4j
public class JusoRestController extends EgovApiAbstractController {

	// https://business.juso.go.kr/addrlink/openApi/searchApi.do

	// http://localhost:9300/addrlink/addrLinkApi.do?currentPage=1&countPerPage=10&keyword=지족북로
	// http://localhost:9300/addrlink/addrLinkApi.do?currentPage=1&countPerPage=2&keyword=지족북로

	@GetMapping("/addrlink/addrLinkApi.do")
	public ResponseEntity<JusoResponseVo> getAddrApi(JusoRequestVo jusoRequestVo) {
//		return getAddrApiA(jusoRequestVo);
		return getAddrApiB(jusoRequestVo);
	}

	ResponseEntity<JusoResponseVo> getAddrApiA(JusoRequestVo jusoRequestVo) {
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

		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("confmKey", jusoRequestVo.getConfmKey());
		uriVariables.put("currentPage", jusoRequestVo.getCurrentPage());
		uriVariables.put("countPerPage", jusoRequestVo.getCountPerPage());
		uriVariables.put("keyword", jusoRequestVo.getKeyword());
		uriVariables.put("resultType", jusoRequestVo.getResultType());

		String responseString = restTemplate.getForObject(
				"https://business.juso.go.kr/addrlink/addrLinkApi.do?confmKey={confmKey}&currentPage={currentPage}&countPerPage={countPerPage}&keyword={keyword}&resultType={resultType}",
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

//	ResponseEntity<JusoResponseVo> responseEntity = restTemplate.postForEntity(
//			"https://business.juso.go.kr/addrlink/addrLinkApi.do", JusoRequestVo, JusoResponseVo.class);

//	String currentPage = req.getParameter("currentPage");
//	String countPerPage = req.getParameter("countPerPage");
//	String resultType = req.getParameter("resultType");
//	String confmKey = req.getParameter("confmKey");
//	String keyword = req.getParameter("keyword");
//	String apiUrl = "https://business.juso.go.kr/addrlink/addrLinkApi.do?currentPage=" + currentPage
//			+ "&countPerPage=" + countPerPage + "&keyword=" + URLEncoder.encode(keyword, "UTF-8") + "&confmKey="
//			+ confmKey + "&resultType=" + resultType;
//	URL url = new URL(apiUrl);
//	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
//	StringBuffer sb = new StringBuffer();
//	String tempStr = null;
//	while (true) {
//		tempStr = br.readLine();
//		if (tempStr == null) {
//			break;
//		}
//		sb.append(tempStr);
//	}
//	br.close();
//	response.setCharacterEncoding("UTF-8");
//	response.setContentType("application/json");
//	response.getWriter().write(sb.toString());

		return ResponseEntity.ok(jusoResponseVo);
	}

	/**
	 * mock 가짜 객체
	 * 
	 * @param jusoRequestVo
	 * @return
	 */
	ResponseEntity<JusoResponseVo> getAddrApiB(JusoRequestVo jusoRequestVo) {
		String responseString;
		try {
			responseString = FileUtils.readFileToString(
					new ClassPathResource("/god/api/juso/web/getAddrApi.json").getFile(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}

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

//	ResponseEntity<JusoResponseVo> responseEntity = restTemplate.postForEntity(
//			"https://business.juso.go.kr/addrlink/addrLinkApi.do", JusoRequestVo, JusoResponseVo.class);

//	String currentPage = req.getParameter("currentPage");
//	String countPerPage = req.getParameter("countPerPage");
//	String resultType = req.getParameter("resultType");
//	String confmKey = req.getParameter("confmKey");
//	String keyword = req.getParameter("keyword");
//	String apiUrl = "https://business.juso.go.kr/addrlink/addrLinkApi.do?currentPage=" + currentPage
//			+ "&countPerPage=" + countPerPage + "&keyword=" + URLEncoder.encode(keyword, "UTF-8") + "&confmKey="
//			+ confmKey + "&resultType=" + resultType;
//	URL url = new URL(apiUrl);
//	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
//	StringBuffer sb = new StringBuffer();
//	String tempStr = null;
//	while (true) {
//		tempStr = br.readLine();
//		if (tempStr == null) {
//			break;
//		}
//		sb.append(tempStr);
//	}
//	br.close();
//	response.setCharacterEncoding("UTF-8");
//	response.setContentType("application/json");
//	response.getWriter().write(sb.toString());

		return ResponseEntity.ok(jusoResponseVo);
	}

}
