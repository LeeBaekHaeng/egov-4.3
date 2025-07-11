package egovframework.com.cmm.service;

import lombok.extern.slf4j.Slf4j;

/**
 * Class Name : Globals.java Description : 시스템 구동 시 프로퍼티를 통해 사용될 전역변수를 정의한다.
 * Modification Information
 *
 * 수정일 수정자 수정내용 ------- -------- --------------------------- 2009.01.19 박지욱 최초
 * 생성
 *
 * @author 공통 서비스 개발팀 박지욱
 * @since 2009. 01. 19
 * @version 1.0
 * @see
 *
 */
@Slf4j
public class Globals {

	public static final String ENV;
	public static final String ENV_DEV = "dev";
	public static final String ENV_TEST = "test";
	public static final String ENV_PROD = "prod";

	static {
		ENV = System.getProperty("env");

		if (log.isDebugEnabled()) {
			log.debug("env={}", ENV);
		}

		if (Globals.ENV_DEV.equals(ENV)) {
			if (log.isDebugEnabled()) {
				log.debug("개발");
			}
		} else if (Globals.ENV_TEST.equals(ENV)) {
			if (log.isDebugEnabled()) {
				log.debug("검증");
			}
		} else if (Globals.ENV_PROD.equals(ENV)) {
			if (log.isDebugEnabled()) {
				log.debug("운영");
			}
		} else {
			if (log.isDebugEnabled()) {
				log.debug("로컬");
			}
		}
	}

	// OS 유형
	public static final String OS_TYPE = EgovProperties.getProperty("Globals.OsType");
	// DB 유형
	public static final String DB_TYPE = EgovProperties.getProperty("Globals.DbType");
	// 메인 페이지
	public static final String MAIN_PAGE = EgovProperties.getProperty("Globals.MainPage");
	// ShellFile 경로
	public static final String SHELL_FILE_PATH = EgovProperties.getPathProperty("Globals.ShellFilePath");
	// 퍼로퍼티 파일 위치
	public static final String CONF_PATH = EgovProperties.getPathProperty("Globals.ConfPath");
	// Server정보 프로퍼티 위치
	public static final String SERVER_CONF_PATH = EgovProperties.getPathProperty("Globals.ServerConfPath");
	// Client정보 프로퍼티 위치
	public static final String CLIENT_CONF_PATH = EgovProperties.getPathProperty("Globals.ClientConfPath");
	// 파일포맷 정보 프로퍼티 위치
	public static final String FILE_FORMAT_PATH = EgovProperties.getPathProperty("Globals.FileFormatPath");

	// 파일 업로드 원 파일명
	public static final String ORIGIN_FILE_NM = "originalFileName";
	// 파일 확장자
	public static final String FILE_EXT = "fileExtension";
	// 파일크기
	public static final String FILE_SIZE = "fileSize";
	// 업로드된 파일명
	public static final String UPLOAD_FILE_NM = "uploadFileName";
	// 파일경로
	public static final String FILE_PATH = "filePath";

	// 메일발송요청 XML파일경로
	public static final String MAIL_REQUEST_PATH = EgovProperties.getPathProperty("Globals.MailRequestPath");
	// 메일발송응답 XML파일경로
	public static final String MAIL_RESPONSE_PATH = EgovProperties.getPathProperty("Globals.MailRResponsePath");

	// G4C 연결용 IP (localhost)
	public static final String LOCAL_IP = EgovProperties.getProperty("Globals.LocalIp");

	// SMS 정보 프로퍼티 위치
	public static final String SMSDB_CONF_PATH = EgovProperties.getPathProperty("Globals.SmsDbConfPath");

	// 파일 업로드 가능 확장자들
	public static final String FILE_UP_EXTS = EgovProperties.getProperty("Globals.fileUpload.Extensions");
	// 파일 업로드 최대 용량
	public static final String FILE_UP_MAX_SIZE = EgovProperties.getProperty("Globals.fileUpload.maxSize");

	/**
	 * 국세청_사업자등록정보 진위확인 및 상태조회 서비스 웹 주소
	 */
	public static final String DATA_NTS_BUSINESSMAN_URL = EgovProperties
			.getProperty("Globals.data.nts-businessman.Url");

}
