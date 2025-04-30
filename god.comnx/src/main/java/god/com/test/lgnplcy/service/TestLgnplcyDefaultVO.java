package god.com.test.lgnplcy.service;

import egovframework.com.cmm.ComDefaultVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestLgnplcyDefaultVO extends ComDefaultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7832532638336339014L;

	/**
	 * 업무사용자ID 암호화
	 * 
	 * @컬럼 `EMPLYR_ID` varchar(20) NOT NULL DEFAULT '' COMMENT '업무사용자ID',
	 */
	private String emplyrIdencpt;

}
