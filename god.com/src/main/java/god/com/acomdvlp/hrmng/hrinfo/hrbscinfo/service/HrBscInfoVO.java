package god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HrBscInfoVO extends HrBscInfoDefaultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3857138176985435912L;

	/**
	 * 업무사용자ID
	 * 
	 * @컬럼 `EMPLYR_ID` varchar(20) NOT NULL DEFAULT '' COMMENT '업무사용자ID',
	 */
	private String emplyrId;

	private String ipInfo;

	private String dplctAt;

	private String lmttAt;

	private String frstId;

//	private String frstPnttm;
	private LocalDateTime frstPnttm;

	private String lastId;

	private String lastPnttm;

}
