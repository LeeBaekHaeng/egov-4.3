--SELECT /* select */
--       A.OWNER
--     , A.*
--  FROM ALL_TABLES A
-- WHERE 1 = 1
--   AND A.OWNER = 'COM'
--;

--테이블

SELECT /* select */
       'INSERT /* Mapper.insert */ INTO ' || A.TABLE_NAME || ' ( /* ' || A.COMMENTS || ' */' AS SQL_INSERT
     , '  FROM ' || A.TABLE_NAME || ' A /* ' || A.COMMENTS || ' */' AS SQL_SELECT
     , 'UPDATE /* Mapper.update */ ' || A.TABLE_NAME || ' /* ' || A.COMMENTS || ' */' AS SQL_UPDATE
     , 'DELETE FROM /* Mapper.delete */ ' || A.TABLE_NAME || ' /* ' || A.COMMENTS || ' */' AS SQL_DELETE
     , A.*
  FROM ALL_TAB_COMMENTS A
 WHERE 1 = 1
   AND A.OWNER = 'COM'
   AND A.TABLE_NAME = 'COMTCADMINISTCODE'
;

--SELECT /* select */
--       A.OWNER
--     , A.*
--  FROM ALL_COL_COMMENTS A
-- WHERE 1 = 1
--   AND A.OWNER = 'COM'
--;

--    /** 이름 */
--    private String name;
--    /** Upper Case 명 */
--    private String ucName;
--    /** Lower Case 명 */
--    private String lcName;
--    /** Camel Case 명 */
--    private String ccName;
--    /** Pascal Case 명 */
--    private String pcName;

--컬럼

WITH A AS (
SELECT /* select */
       A.OWNER
     , A.TABLE_NAME
     , A.COLUMN_NAME
     , TO_CAMEL_CASE(A.COLUMN_NAME) AS COLUMN_CCNAME
     , (SELECT AA.COMMENTS FROM ALL_COL_COMMENTS AA WHERE AA.OWNER = A.OWNER AND AA.TABLE_NAME = A.TABLE_NAME AND AA.COLUMN_NAME = A.COLUMN_NAME) AS COLUMN_COMMENTS
     , A.DATA_TYPE
     , A.DATA_LENGTH
     , A.DATA_PRECISION
     , A.DATA_SCALE
     , A.NULLABLE
     , A.COLUMN_ID
     , A.DATA_DEFAULT
--
--     , A.*
  FROM ALL_TAB_COLUMNS A
 WHERE 1 = 1
   AND A.OWNER = 'COM'
   AND A.TABLE_NAME = 'COMTCADMINISTCODE'
)
SELECT
       '     , ' || COLUMN_NAME || ' /* ' || COLUMN_COMMENTS || ' */' AS SQL_INSERT_INTO
     , '     , #{' || COLUMN_CCNAME || '} /* ' || COLUMN_COMMENTS || ' */' AS SQL_INSERT_VALUES
--
     , '     , A.' || COLUMN_NAME || ' /* ' || COLUMN_COMMENTS || ' */' AS SQL_SELECT
     , '   AND A.' || COLUMN_NAME || ' = #{' || COLUMN_CCNAME || '} /* ' || COLUMN_COMMENTS || ' */' AS SQL_SELECT_WHERE
--
     , '     , ' || COLUMN_NAME || ' = #{' || COLUMN_CCNAME || '} /* ' || COLUMN_COMMENTS || ' */' AS SQL_UPDATE_SET
     , '   AND ' || COLUMN_NAME || ' = #{' || COLUMN_CCNAME || '} /* ' || COLUMN_COMMENTS || ' */' AS SQL_UPDATE_WHERE
--
     , '   AND ' || COLUMN_NAME || ' = #{' || COLUMN_CCNAME || '} /* ' || COLUMN_COMMENTS || ' */' AS SQL_DELETE_WHERE
--
     , A.*
  FROM A
;

--INSERT /* Mapper.insert */ INTO COMTCADMINISTCODE (
INSERT /* Mapper.insert */ INTO COMTCADMINISTCODE ( /* 행정코드 */
--       ADMINIST_ZONE_SE
--     , ADMINIST_ZONE_CODE, USE_AT, ADMINIST_ZONE_NM, UPPER_ADMINIST_ZONE_CODE, CREAT_DE, ABL_DE, FRST_REGIST_PNTTM, FRST_REGISTER_ID, LAST_UPDT_PNTTM, LAST_UPDUSR_ID
--
       ADMINIST_ZONE_SE /* 행정구역구분 */
     , ADMINIST_ZONE_CODE /* 행정구역코드 */
     , USE_AT /* 사용여부 */
--     , ADMINIST_ZONE_NM /* 행정구역명 */
--     , UPPER_ADMINIST_ZONE_CODE /* 상위행정구역코드 */
--     , CREAT_DE /* 생성일 */
--     , ABL_DE /* 폐지일 */
     , FRST_REGIST_PNTTM /* 최초등록시점 */
--     , FRST_REGISTER_ID /* 최초등록자ID */
--     , LAST_UPDT_PNTTM /* 최종수정시점 */
--     , LAST_UPDUSR_ID /* 최종수정자ID */
       ) VALUES(
--       ''
--     , '', '', '', '', '', '', '', '', '', ''
--
       'A' /* 행정구역구분 */
     , 'TEST_00001' /* 행정구역코드 */
     , 'Y' /* 사용여부 */
--     , '' /* 행정구역명 */
--     , '' /* 상위행정구역코드 */
--     , '' /* 생성일 */
--     , '' /* 폐지일 */
     , SYSDATE /* 최초등록시점 */
--     , '' /* 최초등록자ID */
--     , '' /* 최종수정시점 */
--     , '' /* 최종수정자ID */
       )
;

SELECT /* Mapper.select */
--ADMINIST_ZONE_SE, ADMINIST_ZONE_CODE, USE_AT, ADMINIST_ZONE_NM, UPPER_ADMINIST_ZONE_CODE, CREAT_DE, ABL_DE, FRST_REGIST_PNTTM, FRST_REGISTER_ID, LAST_UPDT_PNTTM, LAST_UPDUSR_ID
       A.ADMINIST_ZONE_SE /* 행정구역구분 */
     , A.ADMINIST_ZONE_CODE /* 행정구역코드 */
     , A.USE_AT /* 사용여부 */
     , A.ADMINIST_ZONE_NM /* 행정구역명 */
     , A.UPPER_ADMINIST_ZONE_CODE /* 상위행정구역코드 */
     , A.CREAT_DE /* 생성일 */
     , A.ABL_DE /* 폐지일 */
     , A.FRST_REGIST_PNTTM /* 최초등록시점 */
     , TO_CHAR(A.FRST_REGIST_PNTTM, 'YYYY-MM-DD HH24:MI:SS') AS FRST_REGIST_PNTTM2 /* 최초등록시점 */
     , A.FRST_REGISTER_ID /* 최초등록자ID */
     , A.LAST_UPDT_PNTTM /* 최종수정시점 */
     , TO_CHAR(A.LAST_UPDT_PNTTM, 'YYYY-MM-DD HH24:MI:SS') AS LAST_UPDT_PNTTM2 /* 최종수정시점 */
     , A.LAST_UPDUSR_ID /* 최종수정자ID */
--  FROM COMTCADMINISTCODE A
  FROM COMTCADMINISTCODE A /* 행정코드 */
 WHERE 1 = 1
   AND A.ADMINIST_ZONE_SE = 'A' /* 행정구역구분 */
   AND A.ADMINIST_ZONE_CODE = 'TEST_00001' /* 행정구역코드 */
--   AND A.USE_AT = 'Y' /* 사용여부 */
--   AND A.ADMINIST_ZONE_NM = '' /* 행정구역명 */
--   AND A.UPPER_ADMINIST_ZONE_CODE = '' /* 상위행정구역코드 */
--   AND A.CREAT_DE = '' /* 생성일 */
--   AND A.ABL_DE = '' /* 폐지일 */
--   AND A.FRST_REGIST_PNTTM = '' /* 최초등록시점 */
--   AND A.FRST_REGISTER_ID = '' /* 최초등록자ID */
--   AND A.LAST_UPDT_PNTTM = '' /* 최종수정시점 */
--   AND A.LAST_UPDUSR_ID = '' /* 최종수정자ID */
;

--UPDATE /* Mapper.update */ COMTCADMINISTCODE
UPDATE /* Mapper.update */ COMTCADMINISTCODE /* 행정코드 */
--SET USE_AT='', ADMINIST_ZONE_NM='', UPPER_ADMINIST_ZONE_CODE='', CREAT_DE='', ABL_DE='', FRST_REGIST_PNTTM='', FRST_REGISTER_ID='', LAST_UPDT_PNTTM='', LAST_UPDUSR_ID=''
   SET
       USE_AT = 'N' /* 사용여부 */
     , ADMINIST_ZONE_NM = 'test 이백행 ' || TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') /* 행정구역명 */
     , UPPER_ADMINIST_ZONE_CODE = '' /* 상위행정구역코드 */
     , CREAT_DE = '' /* 생성일 */
     , ABL_DE = '' /* 폐지일 */
--     , FRST_REGIST_PNTTM = '' /* 최초등록시점 */
--     , FRST_REGISTER_ID = '' /* 최초등록자ID */
     , LAST_UPDT_PNTTM = SYSDATE /* 최종수정시점 */
     , LAST_UPDUSR_ID = '' /* 최종수정자ID */
--WHERE ADMINIST_ZONE_SE='' AND ADMINIST_ZONE_CODE=''
 WHERE 1= 1
   AND ADMINIST_ZONE_SE = 'A' /* 행정구역구분 */
   AND ADMINIST_ZONE_CODE = 'TEST_00001' /* 행정구역코드 */
--   AND USE_AT = '' /* 사용여부 */
--   AND ADMINIST_ZONE_NM = '' /* 행정구역명 */
--   AND UPPER_ADMINIST_ZONE_CODE = '' /* 상위행정구역코드 */
--   AND CREAT_DE = '' /* 생성일 */
--   AND ABL_DE = '' /* 폐지일 */
--   AND FRST_REGIST_PNTTM = '' /* 최초등록시점 */
--   AND FRST_REGISTER_ID = '' /* 최초등록자ID */
--   AND LAST_UPDT_PNTTM = '' /* 최종수정시점 */
--   AND LAST_UPDUSR_ID = '' /* 최종수정자ID */
;

--DELETE FROM COMTCADMINISTCODE
DELETE FROM /* Mapper.delete */ COMTCADMINISTCODE /* 행정코드 */
--WHERE ADMINIST_ZONE_SE='' AND ADMINIST_ZONE_CODE=''
 WHERE 1= 1
   AND ADMINIST_ZONE_SE = 'A' /* 행정구역구분 */
   AND ADMINIST_ZONE_CODE = 'TEST_00001' /* 행정구역코드 */
--   AND USE_AT = '' /* 사용여부 */
--   AND ADMINIST_ZONE_NM = '' /* 행정구역명 */
--   AND UPPER_ADMINIST_ZONE_CODE = '' /* 상위행정구역코드 */
--   AND CREAT_DE = '' /* 생성일 */
--   AND ABL_DE = '' /* 폐지일 */
--   AND FRST_REGIST_PNTTM = '' /* 최초등록시점 */
--   AND FRST_REGISTER_ID = '' /* 최초등록자ID */
--   AND LAST_UPDT_PNTTM = '' /* 최종수정시점 */
--   AND LAST_UPDUSR_ID = '' /* 최종수정자ID */
;
