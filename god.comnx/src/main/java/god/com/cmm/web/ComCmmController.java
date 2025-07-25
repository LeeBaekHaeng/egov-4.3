package god.com.cmm.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.nexacro.java.xapi.data.DataSet;
import com.nexacro.java.xapi.data.DataTypes;
import com.nexacro.java.xapi.data.PlatformData;
import com.nexacro.java.xapi.data.VariableList;
import com.nexacro.java.xapi.tx.HttpPlatformRequest;
import com.nexacro.java.xapi.tx.HttpPlatformResponse;
import com.nexacro.java.xapi.tx.PlatformException;
import com.nexacro.java.xapi.tx.PlatformType;
import com.nexacro.uiadapter.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter.spring.core.data.NexacroResult;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.Globals;
import god.com.cmm.web.service.SelectCmmCodeDetailsRequestVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ComCmmController {

	private final EgovCmmUseService egovCmmUseService;

	// http://localhost:8080/comnx/cmm/selectCmmCodeDetails.do?codeIds=COM001&codeIds=COM002

	@GetMapping("/cmm/selectCmmCodeDetails.do")
	public String selectCmmCodeDetails(SelectCmmCodeDetailsRequestVO selectCmmCodeDetailsRequestVO, Model model) {
		if (log.isDebugEnabled()) {
			log.debug("cmmSelectCmmCodeDetailsVO={}", selectCmmCodeDetailsRequestVO);
		}

		List<ComDefaultCodeVO> comDefaultCodeVOs = new ArrayList<>();
		if (selectCmmCodeDetailsRequestVO.getCodeIds() != null) {
			for (String codeId : selectCmmCodeDetailsRequestVO.getCodeIds()) {
				ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
				comDefaultCodeVO.setCodeId(codeId);
				comDefaultCodeVOs.add(comDefaultCodeVO);
			}
		}

		model.addAttribute("cmmCodeDetails", egovCmmUseService.selectCmmCodeDetails(comDefaultCodeVOs));

		selectCmmCodeDetails();
		selectCmmCodeDetails2();

		return "jsonView";
	}

	private void selectCmmCodeDetails() {
		if (Globals.ENV_DEV.equals(Globals.ENV)) {
			if (log.isDebugEnabled()) {
				log.debug("개발");
			}
		} else if (Globals.ENV_TEST.equals(Globals.ENV)) {
			if (log.isDebugEnabled()) {
				log.debug("검증");
			}
		} else if (Globals.ENV_PROD.equals(Globals.ENV)) {
			if (log.isDebugEnabled()) {
				log.debug("운영");
			}
		} else {
			if (log.isDebugEnabled()) {
				log.debug("로컬");
			}
		}
	}

	private void selectCmmCodeDetails2() {
//		RestTemplate restTemplate = new RestTemplate();

		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		int connectTimeout = 3000;
		requestFactory.setConnectTimeout(connectTimeout);
		requestFactory.setReadTimeout(connectTimeout);
		RestTemplate restTemplate = new RestTemplate(requestFactory);

		if (log.isDebugEnabled()) {
			log.debug("DATA_NTS_BUSINESSMAN_URL={}", Globals.DATA_NTS_BUSINESSMAN_URL);
		}

		String responseBody = restTemplate.getForObject(Globals.DATA_NTS_BUSINESSMAN_URL + "/validate", String.class);

//		String responseBody;
//		try {
//			responseBody = restTemplate.getForObject(Globals.DATA_NTS_BUSINESSMAN_URL + "/validate", String.class);
//		} catch (HttpClientErrorException e) {
//			if (log.isErrorEnabled()) {
//				log.error("HttpClientErrorException ");
//			}
//
//			responseBody = e.getResponseBodyAsString();
//		}

		if (log.isDebugEnabled()) {
			log.debug("responseBody={}", responseBody);
		}
	}

	@PostMapping("/cmm/selectCmmCodeDetailsnx.do")
	public void selectCmmCodeDetailsnx(HttpServletRequest request, HttpServletResponse response)
			throws PlatformException {

		// req
		HttpPlatformRequest req = new HttpPlatformRequest(request);
		req.receiveData();

		// reqPlatformData
		PlatformData reqPlatformData = req.getData();

		// 단일 데이터(Variable) 참조
		VariableList reqVariableList = reqPlatformData.getVariableList();
		String argu0 = reqVariableList.getString("argu0");
		String argu1 = reqVariableList.getString("argu1");
		if (log.isDebugEnabled()) {
			log.debug("argu0={}", argu0);
			log.debug("argu1={}", argu1);
		}

		// DataSet의 2차원 데이터 참조
		DataSet input1 = reqPlatformData.getDataSet("input1");

		// Service
		List<ComDefaultCodeVO> comDefaultCodeVOs = new ArrayList<>();
		for (int i = 0; i < input1.getRowCount(); i++) {
			String prefix = input1.getString(i, "prefix");

			if (log.isDebugEnabled()) {
				log.debug("prefix={}", prefix);
			}

			ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
			comDefaultCodeVO.setCodeId(prefix);
			comDefaultCodeVOs.add(comDefaultCodeVO);
		}

		Map<String, List<CmmnDetailCode>> cmmCodeDetails = egovCmmUseService.selectCmmCodeDetails(comDefaultCodeVOs);

		DataSet ds = new DataSet("customers");

		ds.addColumn("prefix", DataTypes.STRING);
		ds.addColumn("form_id", DataTypes.STRING);
		ds.addColumn("form_title", DataTypes.STRING);
		ds.addColumn("comp_id", DataTypes.STRING);
		ds.addColumn("comp_event", DataTypes.STRING);

		int row = 0;

		// resPlatformData
		PlatformData resPlatformData = new PlatformData();

		for (Map.Entry<String, List<CmmnDetailCode>> entry : cmmCodeDetails.entrySet()) {
			String key = entry.getKey();
			List<CmmnDetailCode> value = entry.getValue();

			if (log.isDebugEnabled()) {
				log.debug("key={}", key);
				log.debug("value={}", value);
			}

			for (CmmnDetailCode cmmnDetailCode : value) {
				row = ds.newRow();
				ds.set(row, "prefix", cmmnDetailCode.getCodeId());
				ds.set(row, "form_id", cmmnDetailCode.getCode());
				ds.set(row, "form_title", cmmnDetailCode.getCodeNm());
				ds.set(row, "comp_id", cmmnDetailCode.getCodeDc());
				ds.set(row, "comp_event", "");
			}

			resPlatformData.addDataSet(selectCmmCodeDetailsnx(key, value));
		}

		VariableList resVariableList = resPlatformData.getVariableList();
		resVariableList.add("ErrorCode", 0);
		resVariableList.add("ErrorMsg", "SUCC");

		resPlatformData.addDataSet(ds);

		if (log.isDebugEnabled()) {
			log.debug("saveXml={}", resPlatformData.saveXml());
		}

		// res
		HttpPlatformResponse res = new HttpPlatformResponse(response, PlatformType.CONTENT_TYPE_XML);
		res.setData(resPlatformData);
		res.sendData();
	}

	private DataSet selectCmmCodeDetailsnx(String key, List<CmmnDetailCode> value) {
		DataSet ds = new DataSet(key);

		ds.addColumn("codeId", DataTypes.STRING, 6);
		ds.addColumn("code", DataTypes.STRING, 15);
		ds.addColumn("codeNm", DataTypes.STRING, 60);
		ds.addColumn("codeDc", DataTypes.STRING, 200);

		int row = 0;

		for (CmmnDetailCode cmmnDetailCode : value) {
			row = ds.newRow();
			ds.set(row, "codeId", cmmnDetailCode.getCodeId());
			ds.set(row, "code", cmmnDetailCode.getCode());
			ds.set(row, "codeNm", cmmnDetailCode.getCodeNm());
			ds.set(row, "codeDc", cmmnDetailCode.getCodeDc());
		}

		return ds;
	}

	@PostMapping("/cmm/selectCmmCodeDetailsnx2.do")
	public NexacroResult selectCmmCodeDetailsnx2(
			@ParamDataSet(name = "input1") List<ComDefaultCodeVO> comDefaultCodeVOs,
			@ParamDataSet(name = "input1") ComDefaultCodeVO comDefaultCodeVO) {
		if (log.isDebugEnabled()) {
			log.debug("comDefaultCodeVOs={}", comDefaultCodeVOs);
			log.debug("comDefaultCodeVO={}", comDefaultCodeVO);
		}

		for (ComDefaultCodeVO item : comDefaultCodeVOs) {
			if (log.isDebugEnabled()) {
				log.debug("item={}", item);
				log.debug("getCodeId={}", item.getCodeId());
				log.debug("getCode={}", item.getCode());
				log.debug("getCodeNm={}", item.getCodeNm());
				log.debug("getCodeDc={}", item.getCodeDc());
			}
		}

		List<CmmnDetailCode> cmmCodeDetail = egovCmmUseService.selectCmmCodeDetail(comDefaultCodeVO);

		for (CmmnDetailCode item : cmmCodeDetail) {
			int rowType = item.getRowType();

			if (log.isDebugEnabled()) {
				log.debug("item={}", item);
				log.debug("rowType={}", rowType);
			}

			if (rowType == DataSet.ROW_TYPE_NORMAL) {
				if (log.isDebugEnabled()) {
					log.debug("일반 행 (0)");
				}
			} else if (rowType == DataSet.ROW_TYPE_INSERTED) {
				if (log.isDebugEnabled()) {
					log.debug("추가 된 행 (1)");
				}
			} else if (rowType == DataSet.ROW_TYPE_UPDATED) {
				if (log.isDebugEnabled()) {
					log.debug("값이 변경 된 행 (2)");
				}
			} else if (rowType == DataSet.ROW_TYPE_DELETED) {
				if (log.isDebugEnabled()) {
					log.debug("삭제된 행 (3)");
				}
			}
		}

		NexacroResult nexacroResult = new NexacroResult();

		nexacroResult.addDataSet("output1", cmmCodeDetail);
		nexacroResult.addDataSet("output2", egovCmmUseService.selectOgrnztIdDetail(null));

		return nexacroResult;
	}

}
