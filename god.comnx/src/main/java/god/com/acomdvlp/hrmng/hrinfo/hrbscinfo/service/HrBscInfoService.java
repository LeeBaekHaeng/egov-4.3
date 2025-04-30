package god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service;

public interface HrBscInfoService {

	/**
	 * 인사 기본정보 등록
	 * 
	 * @param hrBscInfoVO
	 * @return
	 */
	int insertHrBscInfo(HrBscInfoVO hrBscInfoVO);

	String getNextStringId();

}
