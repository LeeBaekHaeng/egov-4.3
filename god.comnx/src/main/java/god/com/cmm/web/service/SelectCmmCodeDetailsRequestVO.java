package god.com.cmm.web.service;

import java.util.List;

import egovframework.com.cmm.ComDefaultVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectCmmCodeDetailsRequestVO extends ComDefaultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6093161780410239664L;

	private List<String> codeIds;

}
