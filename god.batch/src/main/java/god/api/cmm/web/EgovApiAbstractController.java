/**
 *
 */
package god.api.cmm.web;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 내부연계 외부연계
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
public class EgovApiAbstractController {

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
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}

}
