
define XZQH_4X  = 3402
define SYSTEM_CONNECTION = system/manager@test
define QXGL_CONNECTION   = QXGL/QXGL@test
define DATAFILE_PATH     = D:\test_data\



----------------------------------------------------------
--   以下内容请勿编辑 ！！！
----------------------------------------------------------

spool qxgl_install.log
WHENEVER SQLERROR exit rollback

connect  &SYSTEM_CONNECTION
prompt 01.创建基础数据库对象
@01.01.TABLESPACES.SQL
@01.02.SCHEMA.SQL

prompt 02.创建对象属性
connect  &QXGL_CONNECTION

@01.03.TABLES.SQL
@01.04.CONSTRAINTS.SQL
@01.05.INDEX.SQL



WHENEVER SQLERROR exit rollback
prompt 02.初始化基础数据
@02.01.TBL_SYS_VERSION.SQL
@02.02.SYS_PROJECT_INFO.SQL
@02.03.SYS_PROJECT_FL.SQL
@02.04.SYS_FUNCTION_INFO.SQL
@02.05.SYS_ROLE_INFO.SQL
--exp qxgl/qxgl@ora158 file=d:\qxgl.dmp tables=(sys_codetype,sys_code)
host imp &SYSTEM_CONNECTION fromuser=QXGL touser=QXGL file=.\qxgl.dmp ignore=Y log=QXGL_data.log



prompt ******************************** 
prompt   Installation accomplished .
prompt ******************************** 

spool off
