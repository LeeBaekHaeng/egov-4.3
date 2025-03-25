package god.com.test2.lgnplcy.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Test2LgnPlcyVO extends Test2LgnPlcyDefaultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5425417210603696971L;

	/**
	 * 업무사용자ID
	 * 
	 * @컬럼 `EMPLYR_ID` varchar(20) NOT NULL DEFAULT '' COMMENT '업무사용자ID',
	 */
	private String emplyrId;

}
