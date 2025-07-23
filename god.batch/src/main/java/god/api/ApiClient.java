package god.api;

import java.util.HashMap;
import java.util.Map;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import god.api.juso.service.JusoRequestVo;
import god.api.juso.service.JusoResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 내부연계 외부연계 API 클라이언트
 * 
 * @author 공통컴포넌트 개발팀 이백행
 * @since 2025.07.23
 * @version 1.0
 * @see
 *
 *      <pre>
 *  == 개정이력(Modification Information) ==
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2025.07.23  이백행          최초 생성
 *
 *      </pre>
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class ApiClient {

	private final SqlSessionTemplate sqlSession;

	private final SqlSessionTemplate batchSqlSession;

	/**
	 * RestTemplate 팩토리 연결/읽기 타임아웃 milliseconds (3초)
	 * 
	 * @return
	 */
	protected RestTemplate createRestTemplate() {
		return createRestTemplate(3_000); // milliseconds (3초)
	}

	/**
	 * RestTemplate 팩토리 연결/읽기 타임아웃 milliseconds (timeout초)
	 * 
	 * @param timeout
	 * @return
	 * 
	 *         <pre>{@code
	 * RestTemplate restTemplate = createRestTemplate(30_000); // milliseconds (30초)
	 * }</pre>
	 */
	protected RestTemplate createRestTemplate(int timeout) {
//		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//		factory.setConnectTimeout(timeout); // 연결 타임아웃
//		factory.setReadTimeout(timeout); // 읽기 타임아웃

		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(timeout); // 연결 타임아웃
		factory.setReadTimeout(timeout); // 응답 읽기 타임아웃

		RestTemplate restTemplate = new RestTemplate(factory);

		return restTemplate;
	}

	/**
	 * ObjectMapper 팩토리
	 * 
	 * @return
	 */
	protected ObjectMapper createObjectMapper() {
		final ObjectMapper mapper = new ObjectMapper();

		// JSON 역직렬화 시 알 수 없는 필드를 무시하도록 설정합니다.
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		return mapper;
	}

	/**
	 * 도로명주소 검색 API
	 * 
	 * @param jusoRequestVo
	 * @return
	 * 
	 *         <pre>{@code 
	 * 
	 * private final ApiClient apiClient;
	 * 
	 * JusoRequestVo jusoRequestVo = new JusoRequestVo();
	 * jusoRequestVo.setCurrentPage(1);
	 * jusoRequestVo.setCountPerPage(10);
	 * jusoRequestVo.setKeyword("지족북로");
	 * 
	 * JusoResponseVo jusoResponseVo = apiClient.getAddrApi(jusoRequestVo);
	 * 
	 * if (log.isDebugEnabled()) {
	 *         log.debug("jusoResponseVo={}", jusoResponseVo);
	 *         }
	 * 
	 * }</pre>
	 */
	public JusoResponseVo getAddrApi(JusoRequestVo jusoRequestVo) {
		if (log.isDebugEnabled()) {
			log.debug("sqlSession={}", sqlSession);
			log.debug("getExecutorType={}", sqlSession.getExecutorType());
			log.debug("batchSqlSession={}", batchSqlSession);
			log.debug("batchSqlSession={}", batchSqlSession.getExecutorType());

			log.debug("jusoRequestVo={}", jusoRequestVo);
//			log.debug("getConfmKey={}", jusoRequestVo.getConfmKey());
			log.debug("getCurrentPage={}", jusoRequestVo.getCurrentPage());
			log.debug("getCountPerPage={}", jusoRequestVo.getCountPerPage());
			log.debug("getKeyword={}", jusoRequestVo.getKeyword());
		}

		RestTemplate restTemplate = createRestTemplate();
//		RestTemplate restTemplate = createRestTemplate(30_000);

		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("confmKey", jusoRequestVo.getConfmKey());
		uriVariables.put("currentPage", jusoRequestVo.getCurrentPage());
		uriVariables.put("countPerPage", jusoRequestVo.getCountPerPage());
		uriVariables.put("keyword", jusoRequestVo.getKeyword());
		uriVariables.put("resultType", jusoRequestVo.getResultType());

		String responseString = restTemplate.getForObject(
				"http://localhost:9300/addrlink/addrLinkApi.do?confmKey={confmKey}&currentPage={currentPage}&countPerPage={countPerPage}&keyword={keyword}&resultType={resultType}",
				String.class, uriVariables);

		if (log.isDebugEnabled()) {
			log.debug("responseString={}", responseString);
		}

		JusoResponseVo jusoResponseVo;
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

		return jusoResponseVo;
	}

}
