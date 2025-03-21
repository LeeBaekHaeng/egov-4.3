# 개발표준가이드

## 소스 포매터(Code Formatter)

기 배포된 표준화된 소스 포매터(Code Formatter)를 Eclipse에 임포트하여 활용(ctrl+shift+F)하도록 한다.

## 공통표준단어

- 공공데이터 공통표준7차 제·개정(2024.11월)
  - 공통표준용어, 공통표준단어, 공통표준도메인

## 시스템 코드

```
코드	코드 설명
MGT	관리환경
DEV	개발환경
COM	공통컴포넌트

MNGR	관리자 페이지
USER	사용자 페이지

PUB	대국민	인터넷	인터넷 영역	대민지원서비스	인터넷DB
BIZ	공무원	업무망	업무망 영역	업무지원서비스	업무망DB
```

## jsp 명명규칙

```
Postfix명	설명		적용 예						비고
List		목록		EgovChangeRequestList
Regist		등록		EgovChangeRequestRegist
Detail		상세		EgovChangeRequestDetail
Updt		수정		EgovChangeRequestUpdt
Popup		팝업		EgovChangeRequestPopup
Search		조회		EgovChangeRequestSearch
```

## 각 컨트롤의 변수명에 대한 명명규칙

```
컨트롤		Prefix명		적용 예						비고
버튼		btn		회원등록버튼 --> btnRegiUsr
이미지		img		검색버튼 --> imgSearch
Text		txt		사용자이름 Input --> txtName
TextArea	txa		내용 Textarea --> txaContent
Select		sel		Select에서 옵션선택 --> selOption1
ListBox		lst		List에서 메뉴선택 --> lstMenu01
Radio		rdo		Radio에서 타입선택 --> rdoTypeA
CheckBox	chk		체크박스로 옵션선택 --> chkOption1
```

## JSP 파일 주석

```jsp
<%--
  Class Name : EgovLogin.jsp
  Description : 사용자 로그인을 담당
  Modification Information

      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2008-01-01    홍길동          최초 생성
     2008-02-01    길동이          그룹웨어 결재 연동기능 추가

    author   : 각팀명(예. 공통서비스 개발팀) 홍길동
    since    : 2009-02-01
--%>
```

## java script 명명규칙

function 명은 fn_egov_[동사]_[명사]를 사용한다. (ex. fn_egov_check_valid(), 동사 및 명사는 용어사전을 기준으로 한다.)

## java script file 주석

```js
/********************************************************
   파일명 : EgovCommon.js
   설  명 : 전자정부 공통 JavaScript
   수정일       수정자        Version        Function 명
  -------    --------    ----------   --------------
  2009-01-01   홍길동         1.0            최초 생성
  2009-02-01   길동이         2.0            fn_check_period
*********************************************************/
```

## java script function 주석

```js
/************************************************************************/
   함수명 : fn_egov_check_period
   설   명 : 행정달력으로 받은 날짜값이 정상적인 허용범위에 속한
             값인지를 검사 검색시작일과  끝나는 일자의 크기 비교
   인   자 : sdt( 시작일 control명)     edt( 시작일 control명)
   사용법 :  checkPeriodBeforeSearch(input1, input2)
            텍스트 입력값은 반드시 10자리(2004-05-01)로 구성되어야 한다.
            상황에 따라 구분자(sep)는 '-'(2004-05-01) or '.'(2004.05.01)
   작성일 : 2009-02-01
   작성자 : 각팀명(예. 공통서비스 개발팀) 홍길동
  수정일       수정자             수정내용
 ------      ------     -------------------
    2009-02-01    길동이        윤년 처리 추가
/************************************************************************/
```

## 자바 클래스 명명규칙 java package

- service클래스, vo, model 클래스를 가지고 있는 패키지
- 서비스 구현 클래스와 DAO 클래스를 가지고 있는 패키지

```
egovframework.com.cmm.service.impl
```

controller 클래스를 가지고 있는 패키지

```
egovframework.com.cmm.web
```

## 자바 클래스 명명규칙 java class

postfix는 framework에서 정의하는 class 요소에 대한 구분으로 해당 java class의 성격을 나타낸다.

```
Controller RestController
```

```
Service
```

```
ServiceImpl
```

```
DAO Mapper
```

```
VO DefaultVO
```

```
Test
```


## 자바 클래스 명명규칙 java method

```
구 분	유형	동사(prefix)	비고
business 처리 관련
	내용검증		validate
	조건확인		check
	검색			search
	연계			contact
	action		action
	파일관리-읽기		read
	파일관리-쓰기		write

data 처리관련(Controller, Business, DAO 공통)
	등록			insert
	조회(단건)		select
	조회(멀티건)		select	postfix로 List를 사용
	수정			update
	삭제			delete
	등록/수정		merge
	등록/수정/삭제		multi	작업을 동시에 수행하는 경우

Value Object(model)
	값읽기		get
	값설정		set
```
## 자바 클래스 명명규칙 *.do 명명규칙

○ Controller의 매핑정보를 관리하는 *.do의 명명규칙은 다음과 같다.
- “/서브시스템/.../동사명+용어사전.do”(단, 동사명은 add, select, get, remove 등의 의미있는 단어 사용)
- 예. /cop/bbs/adm/addBBSMaster.do

## 자바 클래스 주석

- 배포되는 Code Template을 Eclipse에서 활용(alt+shift+J)하도록 한다.

```
/**
 * 사용자 계정을 처리하는 비즈니스 구현 클래스
 * <p><b>NOTE:</b> Exception 종류를 EgovBizException, RuntimeException 에서만 동작한다.
 * fail.common.msg 메세지키가 Message Resource 에 정의 되어 있어야 한다.
 * @author 공통컴포넌트 개발팀 홍길동
 * @since 2009-06-01
 * @version 1.0
 * @see
 *
 * <pre>
 *  == 개정이력(Modification Information) ==
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009-03-20  홍길동          최초 생성
 *
 * </pre>
 */
```

## VO 변수 주석

```
	/**
	 * 업무사용자ID
	 * 
	 * @컬럼 `EMPLYR_ID` varchar(20) NOT NULL DEFAULT '' COMMENT '업무사용자ID',
	 */
	private String emplyrId;
```

## 예외처리

throws 지양하고 catch 지향
- throws 사용을 피하고, catch를 활용

EgovBizException/FdlException/BaseRuntimeException 사용 가능

```java
throws EgovBizException
} catch (EgovBizException e) {

throws FdlException
} catch (FdlException e) {

throws org.egovframe.rte.fdl.cmmn.exception.BaseException
} catch (org.egovframe.rte.fdl.cmmn.exception.BaseException e) {

throws BaseRuntimeException
} catch (BaseRuntimeException e) {
```


Exception/RuntimeException 사용 불가

```java
throws Exception
} catch (Exception e) {
```

## 인증 및 권한관리

```java
		// 로그인 사용자 정보 획득 방법
		// 인증된 사용자객체를 VO형식으로 가져온다.
		LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		if (loginVO != null) {
			log.debug("loginVO={}", loginVO);
			log.debug("getUniqId={}", loginVO.getUniqId());
		}

		// 인증된 사용자의 권한정보를 획득하는 방법
		// 인증된 사용자의 권한 정보를 가져온다.
		List<String> authorities = EgovUserDetailsHelper.getAuthorities();
		for (String authoritie : authorities) {
			log.debug("authoritie={}", authoritie);
		}

		// 인증여부 확인방법
		// 인증된 사용자 여부를 체크한다.
		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
		log.debug("isAuthenticated={}", isAuthenticated);
```
