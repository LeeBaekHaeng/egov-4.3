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

	/**
	 * IP정보
	 * 
	 * @컬럼 `IP_INFO` varchar(23) NOT NULL COMMENT 'IP정보',
	 */
	private String ipInfo;

	/**
	 * 중복허용여부
	 * 
	 * @컬럼 `DPLCT_PERM_AT` char(1) NOT NULL COMMENT '중복허용여부',
	 */
	private String dplctPermAt;

	/**
	 * 제한여부
	 * 
	 * @컬럼 `LMTT_AT` char(1) NOT NULL COMMENT '제한여부',
	 */
	private String lmttAt;

	/**
	 * 최초등록자ID
	 * 
	 * @컬럼 `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '최초등록자ID',
	 */
	private String frstRegisterId;

	/**
	 * 최초등록시점
	 * 
	 * @컬럼 `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
	 */
	private String frstRegistPnttm;

	/**
	 * 최종수정자ID
	 * 
	 * @컬럼 `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
	 */
	private String lastUpdusrId;

	/**
	 * 최종수정시점
	 * 
	 * @컬럼 `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
	 */
	private String lastUpdtPnttm;

}
