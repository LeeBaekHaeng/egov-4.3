package god.data;

import org.junit.jupiter.api.Test;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import egovframework.com.cmm.service.Globals;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class Data15081808Test {

	@Test
	void test() {
//		RestTemplate restTemplate = new RestTemplate();

		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		int connectTimeout = 3000;
		requestFactory.setConnectTimeout(connectTimeout);
		requestFactory.setReadTimeout(connectTimeout);
		RestTemplate restTemplate = new RestTemplate(requestFactory);

		if (log.isDebugEnabled()) {
			log.debug("DATA_NTS_BUSINESSMAN_URL={}", Globals.DATA_NTS_BUSINESSMAN_URL);
		}

//		String responseBody = restTemplate.getForObject(Globals.DATA_NTS_BUSINESSMAN_URL + "/validate", String.class);

		String responseBody;
		try {
			responseBody = restTemplate.getForObject(Globals.DATA_NTS_BUSINESSMAN_URL + "/validate", String.class);
		} catch (HttpClientErrorException e) {
			if (log.isErrorEnabled()) {
				log.error("HttpClientErrorException ");
			}

			responseBody = e.getResponseBodyAsString();
		}

		if (log.isDebugEnabled()) {
			log.debug("responseBody={}", responseBody);
		}
	}

}
