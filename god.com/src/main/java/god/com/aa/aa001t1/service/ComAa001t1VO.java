package god.com.aa.aa001t1.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComAa001t1VO extends ComAa001t1DefaultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6223082140407137371L;

	/**
	 * 중복허용 여
	 */
	public static final String DPLCT_PERM_AT_Y = "Y";

	/**
	 * 중복허용 부
	 */
	public static final String DPLCT_PERM_AT_N = "N";

	/**
	 * 업무사용자ID
	 */
	private String emplyrId;

	/**
	 * IP정보
	 */
	private String ipInfo;

	/**
	 * 중복허용여부
	 */
	private String dplctPermAt;

	/**
	 * 제한여부
	 */
	private String lmttAt;

}
