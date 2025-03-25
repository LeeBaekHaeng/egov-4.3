# 자체개발서버

## Microsoft Windows 10 Pro SVN 설치

cmd 명령 프롬프트

```
systeminfo
```

C:\Users\bhlee>systeminfo

```
호스트 이름:             LAPTOP-V14DM3GL
OS 이름:                 Microsoft Windows 10 Pro
OS 버전:                 10.0.19045 N/A 빌드 19045
OS 제조업체:             Microsoft Corporation
OS 구성:                 독립 실행형 워크스테이션
```

### Cirata Microsoft Windows - Subversion 1.14.4-1 - Server 다운로드

https://subversion.apache.org/packages.html#windows

```
Cirata (32- and 64-bit client and server; supported and certified by Cirata (formerly WANdisco))
```

https://cirata.com/resources/support/subversion-binaries

```
Download Cirata Certified Subversion Binaries
```

Windows Binaries
- Microsoft Windows - Subversion 1.14.4-1 - Server
  - https://opensource.wandisco.com/Windows/1.14/WANdiscoSubversion_1.14.4-1_apache_24.exe

### WANdiscoSubversion_1.14.4-1_apache_24.exe 설치

WANdiscoSubversion_1.14.4-1_apache_24.exe

Destination Folder
```
C:\Program Files (x86)\WANdisco\Subversion
```

Host/Server Name
```
localhost
```

Host Port
80 -> 1080
```
1080
```

Repository Directory
```cmd
mkdir C:\repositories
```

```
C:\repositories
```

Repository Location Prefix
```
/svn
```

### 서비스

서비스 이름:
```
WANdiscoSubversionServer
```

### 구성

```
C:\Program Files (x86)\WANdisco\Subversion\Apache2\conf
```

httpd - 복사본.conf
httpd.conf
```conf
Listen 1080
```

subversion - 복사본.conf
subversion.conf
원본
```conf
<VirtualHost *:1080>
 KeepAlive On
 <Location /svn>
  DAV svn
  SVNParentPath "C:\repositories" 
  #AuthType Basic
  #AuthName "Subversion Repo"
  # If you didn't specify a password file during installation the
  # next line needs to be configured for user authentication.
  #AuthUserFile "C:\Program Files (x86)\WANdisco\Subversion\passwd"
  #AuthzSVNAccessFile /home/scm/svn.authz
 #Require valid-user
  SVNAutoversioning on
 </Location>
 # Enable Subversion logging 
CustomLog logs/subversion.log combined
</VirtualHost>
```

수정
```
<VirtualHost *:1080>
 KeepAlive On
 <Location /svn>
  DAV svn
  SVNParentPath "C:\repositories" 
  AuthType Basic
  AuthName "Subversion Repo"
  # If you didn't specify a password file during installation the
  # next line needs to be configured for user authentication.
  AuthUserFile "C:\Program Files (x86)\WANdisco\Subversion\passwd"
  AuthzSVNAccessFile "C:\Program Files (x86)\WANdisco\Subversion\authz"
  Require valid-user
  SVNAutoversioning on
 </Location>
 # Enable Subversion logging 
CustomLog logs/subversion.log combined
</VirtualHost>
```

WANdiscoSubversionServer 서비스 다시 시작

주소
- http://localhost:1080/
- http://localhost:1080/svn

### 저장소 생성

cmd 명령 프롬프트
```cmd
cd C:\repositories
"C:\Program Files (x86)\WANdisco\Subversion\svnadmin" create a10
"C:\Program Files (x86)\WANdisco\Subversion\svnadmin" create a20
"C:\Program Files (x86)\WANdisco\Subversion\svnadmin" create b10
```

http://localhost:1080/svn/a10

http://localhost:1080/svn/a20

### 사용자 추가

cmd 명령 프롬프트 관리자 권한으로 실행

a10a01
```cmd
"C:\Program Files (x86)\WANdisco\Subversion\Apache2\bin\htpasswd" -c "C:\Program Files (x86)\WANdisco\Subversion\passwd" a10a01
```

a10a02
```cmd
"C:\Program Files (x86)\WANdisco\Subversion\Apache2\bin\htpasswd" -m "C:\Program Files (x86)\WANdisco\Subversion\passwd" a10a02
```

a20a01
```cmd
"C:\Program Files (x86)\WANdisco\Subversion\Apache2\bin\htpasswd" -m "C:\Program Files (x86)\WANdisco\Subversion\passwd" a20a01
```

a20a02
```cmd
"C:\Program Files (x86)\WANdisco\Subversion\Apache2\bin\htpasswd" -m "C:\Program Files (x86)\WANdisco\Subversion\passwd" a20a02
```

b10a01
```cmd
"C:\Program Files (x86)\WANdisco\Subversion\Apache2\bin\htpasswd" -m "C:\Program Files (x86)\WANdisco\Subversion\passwd" b10a01
```

b10a02
```cmd
"C:\Program Files (x86)\WANdisco\Subversion\Apache2\bin\htpasswd" -m "C:\Program Files (x86)\WANdisco\Subversion\passwd" b10a02
```

passwd
```
C:\Program Files (x86)\WANdisco\Subversion
```

authz
```
C:\Program Files (x86)\WANdisco\Subversion
```

```
[groups]
# harry_and_sally = harry,sally
# harry_sally_and_joe = harry,sally,&joe

a10 = a10a01,a20a02
a20 = a20a01,a20a02
b10 = b10a01,b10a02

# [/foo/bar]
# harry = rw
# &joe = r
# * =

# [repository:/baz/fuz]
# @harry_and_sally = rw
# * = r

[a10:/]
@a10 = rw
@a20 = r
@b10 = r

[a20:/]
@a10 = r
@a20 = rw
@b10 = r

[b10:/]
@a10 = r
@a20 = r
@b10 = rw
```

### 테스트

```cmd
mkdir -p "C:\test테스트\a10에이십"
mkdir -p "C:\test테스트\a20에이이십"
mkdir -p "C:\test테스트\b10비십"
```

a10에이십
```
http://localhost:1080/svn/a10
```

a20에이이십
```
http://localhost:1080/svn/a20
```

b10비십
```
http://localhost:1080/svn/b10
```
