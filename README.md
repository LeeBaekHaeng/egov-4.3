# egov-4.3
전자정부 표준프레임워크 4.3

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
