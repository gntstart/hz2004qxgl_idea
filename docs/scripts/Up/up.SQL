
define XZQH_4X  = 3402
define SYSTEM_CONNECTION = system/oracle@ora
define QXGL_CONNECTION   = QXGL/QXGL@ora
define DATAFILE_PATH     = f:\test_data\
--------------------------------------------------------
set serverout on
spool Up.log
WHENEVER SQLERROR exit rollback

--@1000_TO_1001.SQL
--@1001_TO_1002.SQL
@1002_TO_1003.SQL
spool off

