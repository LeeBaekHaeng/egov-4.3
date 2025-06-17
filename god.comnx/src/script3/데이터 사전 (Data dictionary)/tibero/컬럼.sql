/*

| 뷰 접두사     | 설명                              |
| --------- | ------------------------------- |
| `USER_` 뷰 | 현재 로그인한 사용자가 소유한 객체 정보          |
| `ALL_` 뷰  | 현재 사용자에게 **접근 권한이 있는 모든 객체 정보** |
| `DBA_` 뷰  | DBA 권한 보유 시 접근 가능한 **모든 객체 정보** |

*/

SELECT /* select */
       A.*
  FROM USER_TAB_COLUMNS A
--  FROM ALL_TAB_COLUMNS A
--  FROM DBA_TAB_COLUMNS A
;

SELECT /* select */
       A.OWNER
     , A.TABLE_NAME
     , A.COLUMN_NAME
     , TO_CAMEL_CASE(A.COLUMN_NAME)
     , A.DATA_TYPE
     , A.DATA_LENGTH
     , A.DATA_PRECISION
     , A.DATA_SCALE
     , A.NULLABLE
     , A.COLUMN_ID
     , A.DATA_DEFAULT
--
     , A.*
  FROM ALL_TAB_COLUMNS A
 WHERE 1 = 1
   AND OWNER = 'COM'
   AND TABLE_NAME = 'COMTCADMINISTCODE'
;
