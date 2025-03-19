package god.com.test.lgnplcy.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestLgnplcyVO extends TestLgnplcyDefaultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3798707774009807332L;

	/**
	 * 업무사용자ID
	 * 
	 * @컬럼 `EMPLYR_ID` varchar(20) NOT NULL DEFAULT '' COMMENT '업무사용자ID',
	 */
	private String emplyrId;

//	  
//	  `IP_INFO` varchar(23) NOT NULL COMMENT 'IP정보',
//	  `DPLCT_PERM_AT` char(1) NOT NULL COMMENT '중복허용여부',
//	  `LMTT_AT` char(1) NOT NULL COMMENT '제한여부',
//	  `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '최초등록자ID',
//	  `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
//	  `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
//	  `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',

}
