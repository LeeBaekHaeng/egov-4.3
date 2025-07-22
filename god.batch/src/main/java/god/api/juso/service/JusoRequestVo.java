package god.api.juso.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JusoRequestVo {

	/**
	 * confmKey String Y - 신청시 발급받은 승인키
	 */
	private String confmKey;

	/**
	 * currentPage Integer Y 1 현재 페이지 번호
	 */
	private int currentPage = 1;

	/**
	 * countPerPage Integer Y 10 페이지당 출력할 결과 Row 수
	 */
	private int countPerPage = 10;

	/**
	 * keyword String Y - 주소 검색어
	 */
	private String keyword;

	/**
	 * resultType String N xml 검색결과형식 설정(xml, json)
	 */
	private String resultType;

	/**
	 * hstryYn String N N
	 * <p>
	 * * 2020년12월8일 추가된 항목
	 * <p>
	 * 변동된 주소정보 포함 여부.
	 */
	private String hstryYn;

	/**
	 * firstSort String N none
	 * <p>
	 * * 2020년12월8일 추가된 항목
	 * <p>
	 * 정확도순 정렬(none), 우선정렬(road: 도로명 포함, location: 지번 포함)
	 * <p>
	 * ※ keyword(검색어)가 우선정렬 항목에 포함된 결과 우선 표출
	 */
	private String firstSort;

	/**
	 * addInfoYn String N N
	 * <p>
	 * * 2020년12월8일 추가된 항목 출력결과에 추가된 항목(hstryYn, relJibun, hemdNm) 제공여부
	 * <p>
	 * ※ 해당 옵션으로 추가제공되는 항목의 경우, 추후 특정항목이 제거되거나 추가될 수 있으니 적용 시 고려해주시기 바랍니다.
	 */
	private String addInfoYn;

}
