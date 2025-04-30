package god.com.cmm.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import egovframework.com.test.EgovAbstractTestJUnit5;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ComCmmControllerTest extends EgovAbstractTestJUnit5 {

	@Test
	void testA10selectCmmCodeDetails() {
		// given
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("codeIds", "COM001");
		params.add("codeIds", "COM002");

		String first = params.getFirst("codeIds");

		Assertions.assertDoesNotThrow(() ->

		// when
		mockMvc.perform(

				get("/cmm/selectCmmCodeDetails.do")

						.params(params)

		)

				// then

				.andExpect(status().isOk())

				.andExpect(jsonPath("$.cmmCodeDetails." + first + "[0].codeId").value(first))

				.andDo(print())

		);
	}

}
