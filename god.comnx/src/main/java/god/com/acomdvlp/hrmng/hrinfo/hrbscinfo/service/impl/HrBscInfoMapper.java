package god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.impl;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service.HrBscInfoVO;

@Mapper
public interface HrBscInfoMapper {

	int insertHrBscInfo(HrBscInfoVO hrBscInfoVO);

	String selectHrBscInfoId();

}
