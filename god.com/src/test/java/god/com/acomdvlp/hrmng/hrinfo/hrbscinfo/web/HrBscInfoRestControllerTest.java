package god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import egovframework.com.test.EgovAbstractTestJUnit5;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class HrBscInfoRestControllerTest extends EgovAbstractTestJUnit5 {

	@Test
	void testA10insertHrBscInfo() {
//		String ipInfo = "127.0.0.1";
//		String ipInfo = null;
		String ipInfo = "123456789012345678901234";
		String dplctAt = "Y";
		String lmttAt = "Y";

		Assertions.assertDoesNotThrow(() ->

		mockMvc.perform(post("/api/acomdvlp/hrmng/hrinfo/hrbscinfo/insertHrBscInfo.do")

				.param("ipInfo", ipInfo)

				.param("dplctAt", dplctAt)

				.param("lmttAt", lmttAt)

		)

				.andExpect(status().isOk())

//				.andExpect(jsonPath("$.ipInfo").value(ipInfo))

				.andDo(print())

		);
	}

}
