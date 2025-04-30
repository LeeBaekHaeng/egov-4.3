package god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.egovframe.rte.fdl.cmmn.exception.BaseRuntimeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.cmm.web.EgovFileMngController;
import egovframework.com.test.EgovAbstractTestJUnit5;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class HrBscInfoRestControllerTest extends EgovAbstractTestJUnit5 {

	@Test
	void testA10insertHrBscInfo() {
		String ipInfo = "127.0.0.1";
//		String ipInfo = null;
//		String ipInfo = "123456789012345678901234";
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

				.andExpect(jsonPath("$.result").value(1))

				.andDo(print())

		);
	}

	@Test
	void testD10update3HrBscInfo() {
		String ipInfo = "127.0.0.1";
//		String ipInfo = null;
//		String ipInfo = "123456789012345678901234";
		String dplctAt = "Y";
		String lmttAt = "Y";

		Assertions.assertDoesNotThrow(() ->

		mockMvc.perform(post("/api/acomdvlp/hrmng/hrinfo/hrbscinfo/update3HrBscInfo.do")

				.param("ipInfo", ipInfo)

				.param("dplctAt", dplctAt)

				.param("lmttAt", lmttAt)

		)

				.andExpect(status().isOk())

//				.andExpect(jsonPath("$.ipInfo").value(ipInfo))

				.andExpect(jsonPath("$.result").value(1))

				.andDo(print())

		);
	}

	@Test
	void testD10updateHrBscInfo() {
		String ipInfo = "127.0.0.1";
//		String ipInfo = null;
//		String ipInfo = "123456789012345678901234";

		String dplctAt = "Y";
//		String dplctAt = null;
//		String dplctAt = "";

		String lmttAt = "Y";

		Assertions.assertDoesNotThrow(() ->

		mockMvc.perform(post("/api/acomdvlp/hrmng/hrinfo/hrbscinfo/updateHrBscInfo.do")

				.param("ipInfo", ipInfo)

				.param("dplctAt", dplctAt)

				.param("lmttAt", lmttAt)

		)

				.andExpect(status().isOk())

//				.andExpect(jsonPath("$.ipInfo").value(ipInfo))
//
				.andExpect(jsonPath("$.result").value(1))

				.andDo(print())

		);
	}

	@Test
	void testD10update2HrBscInfo() {
		String emplyrIdEncpt = EgovFileMngController.encrypt("AAAA_000000000002015");
		String emplyrIdDecrypt = EgovFileMngController.decrypt(emplyrIdEncpt);
		if (log.isDebugEnabled()) {
			log.debug("emplyrIdEncpt 업무사용자ID 암호화={}", emplyrIdEncpt);
			log.debug("emplyrIdDecrypt 업무사용자ID 복호화={}", emplyrIdDecrypt);
		}

//		String ipInfo = "127.0.0.1";
		String ipInfo = null;
//		String ipInfo = "123456789012345678901234";

//		String dplctAt = "Y";
		String dplctAt = null;

		String lmttAt = "Y";

		MvcResult mvcResult = Assertions.assertDoesNotThrow(() ->

		mockMvc.perform(post("/api/acomdvlp/hrmng/hrinfo/hrbscinfo/update2HrBscInfo.do")

				.param("ipInfo", ipInfo)

				.param("dplctAt", dplctAt)

				.param("lmttAt", lmttAt)

		)

				.andExpect(status().isOk())

				.andExpect(jsonPath("$.ipInfo").value(ipInfo))

				.andExpect(jsonPath("$.dplctAt").value(dplctAt))

				.andExpect(jsonPath("$.lmttAt").value(lmttAt))

				.andDo(print())

				.andReturn()

//		;

		);

		try {
			String content = mvcResult.getResponse().getContentAsString();

			final ObjectMapper mapper = new ObjectMapper();
//			HrBscInfoUpdt2VO hrBscInfoUpdt2VO = mapper.readValue(content, HrBscInfoUpdt2VO.class);
//			if (hrBscInfoUpdt2VO.getAllErrors() != null) {
//				for (ObjectError objectError : hrBscInfoUpdt2VO.getAllErrors()) {
//					if (log.isDebugEnabled()) {
//						log.debug("objectError={}", objectError);
//						log.debug("getCode={}", objectError.getCode());
//						log.debug("getCodes={}", objectError.getCodes().toString());
//						log.debug("getArguments={}", objectError.getArguments());
//						log.debug("getDefaultMessage={}", objectError.getDefaultMessage());
//					}
//				}
//			}

			JsonNode root = mapper.readTree(content);
			JsonNode allErrors = root.get("allErrors");
			for (JsonNode allError : allErrors) {
				if (log.isDebugEnabled()) {
					log.debug("allError={}", allError);
					log.debug("getCode={}", allError.get("code"));
					log.debug("getCodes={}", allError.get("codes"));
					log.debug("getArguments={}", allError.get("arguments"));
					log.debug("getDefaultMessage={}", allError.get("defaultMessage"));
				}
			}
		} catch (UnsupportedEncodingException | JsonProcessingException e) {
			throw new BaseRuntimeException(
					"UnsupportedEncodingException | JsonProcessingException getContentAsString readTree", e);
		}

	}

}
