package egovframework.com.cmm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class GlobalsTest {

	@Test
	void test() {
		// given
		System.setProperty("env", Globals.ENV_DEV);

		// when
		if (Globals.ENV_DEV.equals(Globals.ENV)) {
			if (log.isDebugEnabled()) {
				log.debug("개발");
			}
		} else if (Globals.ENV_TEST.equals(Globals.ENV)) {
			if (log.isDebugEnabled()) {
				log.debug("검증");
			}
		} else if (Globals.ENV_PROD.equals(Globals.ENV)) {
			if (log.isDebugEnabled()) {
				log.debug("운영");
			}
		} else {
			if (log.isDebugEnabled()) {
				log.debug("로컬");
			}
		}

		// then
		assertEquals(Globals.ENV_DEV, Globals.ENV);
	}

}
