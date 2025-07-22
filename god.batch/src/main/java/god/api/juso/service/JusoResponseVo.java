package god.api.juso.service;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JusoResponseVo {

	private Results results;

	@Getter
	@Setter
	public static class Results {

		private Common common;

		private List<Juso> juso;

	}

	@Getter
	@Setter
	public static class Common {

		/**
		 * totalCount String Y 총 검색 데이터수
		 */
		private String totalCount;

		/**
		 * currentPage Integer Y 페이지 번호
		 */
		private int currentPage;

		/**
		 * countPerPage Integer Y 페이지당 출력할 결과 Row 수
		 */
		private int countPerPage;

		/**
		 * errorCode String Y 에러 코드
		 */
		private String errorCode;

		/**
		 * errorMessage String Y 에러 메시지
		 */
		private String errorMessage;

	}

	@Getter
	@Setter
	public static class Juso {

		/**
		 * roadAddr String Y 전체 도로명주소
		 */
		private String roadAddr;

		/**
		 * roadAddrPart1 String Y 도로명주소(참고항목 제외)
		 */
		private String roadAddrPart1;

		/**
		 * roadAddrPart2 String N 도로명주소 참고항목
		 */
		private String roadAddrPart2;

		/**
		 * jibunAddr String Y 지번주소
		 */
		private String jibunAddr;

		/**
		 * engAddr String Y 도로명주소(영문)
		 */
		private String engAddr;

		/**
		 * zipNo String Y 우편번호
		 */
		private String zipNo;

		/**
		 * admCd String Y 행정구역코드
		 */
		private String admCd;

		/**
		 * rnMgtSn String Y 도로명코드
		 */
		private String rnMgtSn;

		/**
		 * bdMgtSn String Y 건물관리번호
		 */
		private String bdMgtSn;

		/**
		 * detBdNmList String N 상세건물명
		 */
		private String detBdNmList;

		/**
		 * bdNm String N 건물명
		 */
		private String bdNm;

		/**
		 * bdKdcd String Y 공동주택여부(1 : 공동주택, 0 : 비공동주택)
		 */
		private String bdKdcd;

		/**
		 * siNm String Y 시도명
		 */
		private String siNm;

		/**
		 * sggNm String Y 시군구명
		 */
		private String sggNm;

		/**
		 * emdNm String Y 읍면동명
		 */
		private String emdNm;

		/**
		 * liNm String N 법정리명
		 */
		private String liNm;

		/**
		 * rn String Y 도로명
		 */
		private String rn;

		/**
		 * udrtYn String Y 지하여부(0 : 지상, 1 : 지하)
		 */
		private String udrtYn;

		/**
		 * buldMnnm Number Y 건물본번
		 */
		private int buldMnnm;

		/**
		 * buldSlno Number Y 건물부번
		 */
		private int buldSlno;

		/**
		 * mtYn String Y 산여부(0 : 대지, 1 : 산)
		 */
		private String mtYn;

		/**
		 * lnbrMnnm Number Y 지번본번(번지)
		 */
		private int lnbrMnnm;

		/**
		 * lnbrSlno Number Y 지번부번(호)
		 */
		private int lnbrSlno;

		/**
		 * emdNo String Y 읍면동일련번호
		 */
		private String emdNo;

		/**
		 * hstryYn String Y
		 * <p>
		 * * 2020년12월8일 추가된 항목
		 * <p>
		 * 변동이력여부(0: 현행 주소정보, 1: 요청변수의 keyword(검색어)가 변동된 주소정보에서 검색된 정보)
		 */
		private String hstryYn;

		/**
		 * relJibun String N
		 * <p>
		 * * 2020년12월8일 추가된 항목
		 * <p>
		 * 관련지번
		 */
		private String relJibun;

		/**
		 * hemdNm String N
		 * <p>
		 * * 2020년12월8일 추가된 항목 관할주민센터
		 * <p>
		 * ※ 참고정보이며, 실제와 다를 수 있습니다.
		 */
		private String hemdNm;

	}

}
