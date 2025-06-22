package god.com.aa.aa001t1.service.impl;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import god.com.aa.aa001t1.service.ComAa001t1VO;

/**
 * ComAa001t1 Mapper
 */
@Mapper
public interface ComAa001t1Mapper {

	/**
	 * ComAa001t1 등록
	 * 
	 * @param comAa001t1VO
	 * @return
	 */
	int insertComAa001t1(ComAa001t1VO comAa001t1VO);

}
