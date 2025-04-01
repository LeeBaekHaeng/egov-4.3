package god.com.acomdvlp.hrmng.hrinfo.hrbscinfo.service;

import java.util.List;

import org.springframework.validation.ObjectError;

import egovframework.com.cmm.ComDefaultVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HrBscInfoDefaultVO extends ComDefaultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7753159002428439723L;

	private int result;

//	@JsonIgnore
	private List<ObjectError> allErrors;

}
