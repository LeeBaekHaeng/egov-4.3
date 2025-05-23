# egov-4.3
전자정부 표준프레임워크 4.3

목차
- [전자정부 표준프레임워크 4.3 개발환경 새 폴더](#전자정부-표준프레임워크-43-개발환경-새-폴더)
- [전자정부 표준프레임워크 4.3 개발환경 다운로드](#전자정부-표준프레임워크-43-개발환경-다운로드)
- [전자정부 표준프레임워크 4.3 개발환경 반디집으로 압축 풀기(B)...](#전자정부-표준프레임워크-43-개발환경-반디집으로-압축-풀기b)
- [아파치 메이븐 localRepository 설정](#아파치-메이븐-localrepository-설정)
- [이클립스 바로 가기](#이클립스-바로-가기)
- [이클립스 아파치 메이븐 설정](#이클립스-아파치-메이븐-설정)
- [이클립스 아파치 메이븐 설정](#이클립스-아파치-메이븐-설정-1)
- [공통컴포넌트 4.3.0 all-in-one 프로젝트 생성](#공통컴포넌트-430-all-in-one-프로젝트-생성)
- [dependency:go-offline](#dependencygo-offline)
- [MariaDB Server 11.4.5 다운로드](#mariadb-server-1145-다운로드)
- [MariaDB Server 11.4.5 설치](#mariadb-server-1145-설치)
- [MariaDB Server 11.4.5 설정](#mariadb-server-1145-설정)
- [MariaDB Server 11.4.5 실행](#mariadb-server-1145-실행)
- [DBeaver 다운로드](#dbeaver-다운로드)
- [DBeaver 설치](#dbeaver-설치)
- [DBeaver 설정](#dbeaver-설정)
- [공통컴포넌트 com 사용자 생성](#공통컴포넌트-com-사용자-생성)
- [공통컴포넌트 com 테이블 생성](#공통컴포넌트-com-테이블-생성)
- [apache-tomcat-9.0.102 설치](#apache-tomcat-90102-설치)
- [git](#git)
- [context-crypto.xml 파일에서 algorithmKey및 - algorithmKeyHash 기본값 변경](#context-cryptoxml-파일에서-algorithmkey및-algorithmkeyhash-기본값-변경)
- [단위 테스트](#단위-테스트)
- [Tibero 7, Tibero 6](#tibero-7-tibero-6)
- [SVN 설치 가이드(리눅스용)](#svn-설치-가이드리눅스용)

## 전자정부 표준프레임워크 4.3 개발환경 새 폴더

```
EGOVFRAMEDEV-4.3.0-64BIT
```

```
EGOVFRAMEDEV-4.3.0-64BIT_DOWNLOADS
```

## 전자정부 표준프레임워크 4.3 개발환경 다운로드

C:\EGOVFRAMEDEV-4.3.0-64BIT_DOWNLOADS
- eGovCI-4.3.0_64bit.zip
- eGovFrameDev-4.3.0-64bit.zip

## 전자정부 표준프레임워크 4.3 개발환경 반디집으로 압축 풀기(B)...

```
C:\EGOVFRAMEDEV-4.3.0-64BIT
```

- C:\EGOVFRAMEDEV-4.3.0-64BIT\eGovCI-4.3.0_64bit
- C:\EGOVFRAMEDEV-4.3.0-64BIT\eGovFrameDev-4.3.0-64bit

## 아파치 메이븐 localRepository 설정

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\eGovCI-4.3.0_64bit\bin\apache-maven-3.9.9\apache-maven-3.9.9\conf
```

settings.xml

```xml
  <localRepository>/EGOVFRAMEDEV-4.3.0-64BIT/.m2/repository</localRepository>
```

D:\Users\bhlee\Documents\egov-4.3 에 아파치 메이븐 새 폴더
```
mkdir EGOVFRAMEDEV-4.3.0-64BIT\eGovCI-4.3.0_64bit\bin\apache-maven-3.9.9\apache-maven-3.9.9\conf
```

## 이클립스 바로 가기

C:\EGOVFRAMEDEV-4.3.0-64BIT

이클립스 실행

```
eclipse.exe - 바로 가기 (EGOVFRAMEDEV-4.3.0-64BIT)
```

워크스페이스 선택

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\eGovFrameDev-4.3.0-64bit\workspace-egov
```

## 이클립스 아파치 메이븐 설정

Window > Preferences > Maven > User Settings

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\eGovCI-4.3.0_64bit\bin\apache-maven-3.9.9\apache-maven-3.9.9\conf\settings.xml
```

## 이클립스 아파치 메이븐 설정

- Window > Preferences > Validation
- Suspend all vaildators 체크

## 공통컴포넌트 4.3.0 all-in-one 프로젝트 생성

```
god.comall
```

## dependency:go-offline

```
dependency:go-offline
```

https://maven.apache.org/plugins/maven-dependency-plugin/go-offline-mojo.html

```
clean package
```

```
god.comall_go-offline_configuration
god.comall_configuration (go-offline)
```

```
god.comall_clean package_configuration
god.comall_configuration (clean package)
```

## MariaDB Server 11.4.5 다운로드

```
C:\EGOVFRAMEDEV-4.3.0-64BIT_DOWNLOADS
```

- mariadb-11.4.5-winx64.msi
- mariadb-11.4.5-winx64.zip

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\mariadb-11.4.5-winx64
```

## MariaDB Server 11.4.5 설치

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\mariadb-11.4.5-winx64\bin
```

mariadb-install-db.exe 실행

## MariaDB Server 11.4.5 설정

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\mariadb-11.4.5-winx64\data
```

my.ini

```ini
port=3306
#port=13306
innodb_buffer_pool_size=4064M
character-set-server=utf8mb4
```

```ini
[mysqld]
datadir=C:/EGOVFRAMEDEV-4.3.0-64BIT/mariadb-11.4.5-winx64/data

port=3306
#port=13306
innodb_buffer_pool_size=4064M
character-set-server=utf8mb4

[client]
plugin-dir=C:\EGOVFRAMEDEV-4.3.0-64BIT\mariadb-11.4.5-winx64/lib/plugin

```

## MariaDB Server 11.4.5 실행

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\mariadb-11.4.5-winx64\bin
```

mysqld.exe 실행

```
mysqld.exe - 바로 가기 (EGOVFRAMEDEV-4.3.0-64BIT)
```

## DBeaver 다운로드

https://dbeaver.io/download/

- dbeaver-ce-25.0.0-x86_64-setup.exe
- dbeaver-ce-25.0.0-win32.win32.x86_64.zip

## DBeaver 설치

dbeaver-ce-25.0.0-win32.win32.x86_64.zip

```
dbeaver.exe - 바로 가기 (EGOVFRAMEDEV-4.3.0-64BIT)
```

## DBeaver 설정

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\dbeaver-ce-25.0.0-win32.win32.x86_64\dbeaver
```

dbeaver.ini

```ini
-data
../DBeaverData
```

```ini
-data
../DBeaverData

-startup
plugins/org.jkiss.dbeaver.launcher_1.0.24.202503021833.jar
--launcher.library
plugins/org.eclipse.equinox.launcher.win32.win32.x86_64_1.2.1100.v20240722-2106
-vmargs
-XX:+IgnoreUnrecognizedVMOptions
-Dosgi.requiredJavaVersion=17
-Dfile.encoding=UTF-8
--add-modules=ALL-SYSTEM
--add-opens=java.base/java.io=ALL-UNNAMED
--add-opens=java.base/java.lang=ALL-UNNAMED
--add-opens=java.base/java.lang.reflect=ALL-UNNAMED
--add-opens=java.base/java.net=ALL-UNNAMED
--add-opens=java.base/java.nio=ALL-UNNAMED
--add-opens=java.base/java.nio.charset=ALL-UNNAMED
--add-opens=java.base/java.text=ALL-UNNAMED
--add-opens=java.base/java.time=ALL-UNNAMED
--add-opens=java.base/java.util=ALL-UNNAMED
--add-opens=java.base/java.util.concurrent=ALL-UNNAMED
--add-opens=java.base/java.util.concurrent.atomic=ALL-UNNAMED
--add-opens=java.base/jdk.internal.vm=ALL-UNNAMED
--add-opens=java.base/jdk.internal.misc=ALL-UNNAMED
--add-opens=java.base/sun.nio.ch=ALL-UNNAMED
--add-opens=java.base/sun.nio.fs=ALL-UNNAMED
--add-opens=java.base/sun.security.ssl=ALL-UNNAMED
--add-opens=java.base/sun.security.action=ALL-UNNAMED
--add-opens=java.base/sun.security.util=ALL-UNNAMED
--add-opens=java.security.jgss/sun.security.jgss=ALL-UNNAMED
--add-opens=java.security.jgss/sun.security.krb5=ALL-UNNAMED
--add-opens=java.desktop/java.awt=ALL-UNNAMED
--add-opens=java.desktop/java.awt.peer=ALL-UNNAMED
--add-opens=java.sql/java.sql=ALL-UNNAMED
-Xms64m
-Xmx1024m
-Ddbeaver.distribution.type=zip

```

## 공통컴포넌트 com 사용자 생성

com 데이터베이스 생성

```sql
CREATE USER 'com'@'%' IDENTIFIED BY 'com01';
GRANT DELETE ON com.* TO 'com'@'%';
GRANT INSERT ON com.* TO 'com'@'%';
GRANT SELECT ON com.* TO 'com'@'%';
GRANT UPDATE ON com.* TO 'com'@'%';
```

## 공통컴포넌트 com 테이블 생성

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\eGovFrameDev-4.3.0-64bit\workspace-egov\god.comall\script\ddl\mysql\com_DDL_mysql.sql
```

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\eGovFrameDev-4.3.0-64bit\workspace-egov\god.comall\script\comment\mysql\egov_mysql_comment.sql
```

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\eGovFrameDev-4.3.0-64bit\workspace-egov\god.comall\script\dml\mysql\com_DML_mysql.sql
```

## apache-tomcat-9.0.102 설치

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\apache-tomcat-9.0.102
```

http://localhost:8080/egovframework-all-in-one

## git

```
C:\Users\bhlee\git
```

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\eGovFrameDev-4.3.0-64bit\workspace-egov\git
```

## context-crypto.xml 파일에서 algorithmKey및 algorithmKeyHash 기본값 변경

context-crypto.xml 파일에서 algorithmKey및 algorithmKeyHash 기본값을 반드시 다른 것으로 변경하시기 바랍니다.

[실행환경 Crypto 설정간소화 관련 위키가이드 참조](https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte4.0:fdl:crypto)

- EgovEnvCryptoAlgorithmCreateTest
- EgovEnvCryptoUserTest

Crypto algorithmKey, algorithmKeyHash 생성

```
EgovEnvCryptoAlgorithmCreateTest
```

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import org.egovframe.rte.fdl.cryptography.EgovPasswordEncoder;
 
public class EgovEnvCryptoAlgorithmCreateTest {
 
	private static final Logger LOGGER = LoggerFactory.getLogger(EgovEnvCryptoAlgorithmCreateTest.class);
 
	//계정암호화키 키
	public String algorithmKey = "(사용자정의 값)";
 
	//계정암호화 알고리즘(MD5, SHA-1, SHA-256)
	public String algorithm = "SHA-256";
 
	//계정암호화키 블럭사이즈
	public int algorithmBlockSize = 1024;
 
	public static void main(String[] args) {
		EgovEnvCryptoAlgorithmCreateTest cryptoTest = new EgovEnvCryptoAlgorithmCreateTest();
 
		EgovPasswordEncoder egovPasswordEncoder = new EgovPasswordEncoder();
		egovPasswordEncoder.setAlgorithm(cryptoTest.algorithm);
 
		LOGGER.info("------------------------------------------------------");
		LOGGER.info("알고리즘(algorithm) : "+cryptoTest.algorithm);
		LOGGER.info("알고리즘 키(algorithmKey) : "+cryptoTest.algorithmKey);
		LOGGER.info("알고리즘 키 Hash(algorithmKeyHash) : "+egovPasswordEncoder.encryptPassword(cryptoTest.algorithmKey));
		LOGGER.info("알고리즘 블럭사이즈(algorithmBlockSize)  :"+cryptoTest.algorithmBlockSize);
 
	}
}
```

환경설정 파일(globals.properties)의 데이터베이스 연결 항목(Url, UserName, Password) 인코딩 값 생성

```
EgovEnvCryptoUserTest
```

```java
// 데이터베이스 연결 항목(Url, UserName, Password) 인코딩 값 생성 JAVA
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import org.egovframe.rte.fdl.cryptography.EgovEnvCryptoService;
import org.egovframe.rte.fdl.cryptography.impl.EgovEnvCryptoServiceImpl;
 
public class EgovEnvCryptoUserTest {
 
	private static final Logger LOGGER = LoggerFactory.getLogger(EgovEnvCryptoUserTest.class);
 
	public static void main(String[] args) {
 
		String[] arrCryptoString = { 
		"userId",         //데이터베이스 접속 계정 설정
		"userPassword",   //데이터베이스 접속 패드워드 설정
		"url",            //데이터베이스 접속 주소 설정
		"databaseDriver"  //데이터베이스 드라이버
              };
 
 
		LOGGER.info("------------------------------------------------------");		
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:/context-crypto-test.xml"});
		EgovEnvCryptoService cryptoService = context.getBean(EgovEnvCryptoServiceImpl.class);
		LOGGER.info("------------------------------------------------------");
 
		String label = "";
		try {
			for(int i=0; i < arrCryptoString.length; i++) {		
				if(i==0)label = "사용자 아이디";
				if(i==1)label = "사용자 비밀번호";
				if(i==2)label = "접속 주소";
				if(i==3)label = "데이터 베이스 드라이버";
				LOGGER.info(label+" 원본(orignal):" + arrCryptoString[i]);
				LOGGER.info(label+" 인코딩(encrypted):" + cryptoService.encrypt(arrCryptoString[i]));
				LOGGER.info("------------------------------------------------------");
			}
		} catch (IllegalArgumentException e) {
			LOGGER.error("["+e.getClass()+"] IllegalArgumentException : " + e.getMessage());
		} catch (Exception e) {
			LOGGER.error("["+e.getClass()+"] Exception : " + e.getMessage());
		}
 
	}
 
}
```

## 단위 테스트

## Tibero 7, Tibero 6

주제별 > 개발 > CLI > CLI, ODBC 드라이버 연결 > 드라이버 연결 가이드
- JDBC 연결
- https://docs.tmaxtibero.com/tibero/topics/development/cli/cli-odbc-driver-connection/driver-connection-guide/jdbc

Tibero Studio (JDK 1.8)  다운로드
- https://technet.tmax.co.kr/ko/front/download/viewDownload.do?cmProductCode=0301&version_seq=PVER-20170425-000001&doc_type_cd=DN

C:\Tibero\tibero6\client\lib\jar
- tibero6-jdbc.jar
- tibero6-jdbc-14.jar
- tibero6-jdbc-18.jar

공통컴포넌트

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\eGovFrameDev-4.3.0-64bit\workspace-egov\git\egov-4.3\god.com\src\main\webapp\WEB-INF\lib\project\tibero5\5.0.0
```

tibero5-5.0.0.jar

티베로 sys 접속

Alias
```
sys
```

IP
```
localhost
```

Port
```
8629
```

User
```
sys
```

Password
```
tibero
```

DB Name
```
tibero
```

DBeaver 티베로 접속

```
C:\EGOVFRAMEDEV-4.3.0-64BIT\dbeaver-ce-25.0.0-win32.win32.x86_64\drivers\Tibero\tibero6
```

- tibero6-jdbc.jar
- tibero6-jdbc-14.jar
- tibero6-jdbc-18.jar

dbeaver 티베로 연결

Settings탭의 Tibero 드라이버 세팅하기

```
Driver Name : Tibero
Class Name : com.tmax.tibero.jdbc.TbDriver
URL Template : jdbc:tibero:thin:@{host}[:{port}]:{database}
example : jdbc:tibero:thin:@127.0.0.1:8629:tibero_sid (7번그림 참고)
Default Port : 8629
출처: https://javaoop.tistory.com/91 [개쿠:티스토리]
```

## SVN 설치 가이드(리눅스용)

서버 개발환경 4.3.0 설치가이드
- https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:dev4.3:svrinstall
- SVN 설치 가이드(리눅스용)
- https://www.egovframe.go.kr/wiki/lib/exe/fetch.php?media=egovframework:dev4.0:svn-installation-guide.pdf

로키 리눅스 (Rocky Linux)
- Rocky-8.10-x86_64-minimal.iso
- Rocky-8.10-x86_64-dvd1.iso
- https://rockylinux.org/ko-KR/download

Apache Subversion 바이너리 패키지
- Apache Subversion Binary Packages
- Centos Linux
- https://subversion.apache.org/packages.html#centos

사용자 추가
su - root
```sh
adduser god
passwd god
cat /etc/passwd
cat /etc/group
```

온라인 설치
```sh
yum install subversion
dnf install subversion
```

오프라인 설치
su - god
```sh
dnf search subversion
dnf info subversion
dnf info subversion-1.10.2
dnf download --resolve --downloaddir=subversion-1.10.2 subversion
dnf remove subversion
dnf remove subversion-libs
dnf remove subversion && dnf autoremove
dnf list --installed
dnf list --installed | grep subversion
```

오프라인 서버에서 설치
```sh
dnf install *.rpm
rpm -Uvh *.rpm
svn
svn help
svn --version
svnadmin
svnadmin help
svnadmin --version
```
