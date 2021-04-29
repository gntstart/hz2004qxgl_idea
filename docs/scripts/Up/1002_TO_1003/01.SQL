declare
  i   PLS_INTEGER;
begin
  select count(*) into i
  from TBL_SYS_VERSION
  where 
    MODULENAME = 'QXGL'
    and VERSION='1.0.0.2';
  if i = 0 then   
    RAISE_APPLICATION_ERROR(-20001,'QXGL 当前版本不是 1.0.0.2');
  end if;
end;
/

delete from TBL_SYS_VERSION where   MODULENAME = 'QXGL';

insert into TBL_SYS_VERSION (MODULENAME,VERSION,INSTALLFLAG) 
values('QXGL','1.0.0.3','U');

COMMIT;

