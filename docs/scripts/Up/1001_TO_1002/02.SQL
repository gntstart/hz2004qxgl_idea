---------2012-7-3 16:33:47 [省级旅馆业新增加的菜单] mrf-------------
insert into sys_function_info(funid,function_bm,function_name,xmbm,function_order,new_user_uid,new_date,FUNCTION_URL)
values('LGLTLTJ','LGLTLTJ','旅馆连通率统计','LGY',1,'admin',sysdate,'tj/lgltltj.jsp');
       
insert into sys_function_info(funid,function_bm,function_name,xmbm,function_order,new_user_uid,new_date,FUNCTION_URL)
values('LGRZLTJ','LGRZLTJ','旅馆入住率统计','LGY',1,'admin',sysdate,'tj/lgrzl.jsp');
       
insert into sys_function_info(funid,function_bm,function_name,xmbm,function_order,new_user_uid,new_date,FUNCTION_URL)
values('SCYCLG','SCYCLG','上传异常旅馆','LGY',1,'admin',sysdate,'tj/lgyctj.jsp');
       
insert into sys_function_info(funid,function_bm,function_name,xmbm,function_order,new_user_uid,new_date,FUNCTION_URL)
values('LGGWDQSZ','LGGWDQSZ','高危区域设置','LGY',1,'admin',sysdate,'xtgl/gwsz.jsp');
       
insert into sys_function_info(funid,function_bm,function_name,xmbm,function_order,new_user_uid,new_date,FUNCTION_URL)
values('LGGWDQTJ','LGGWDQTJ','高危区域入住统计','LGY',1,'admin',sysdate,'tj/gwdqtj.jsp');

insert into sys_function_info(funid,function_bm,function_name,xmbm,function_order,new_user_uid,new_date,FUNCTION_URL)
values('LGCQBF','LGCQBF','长期包房统计','LGY',1,'admin',sysdate,'tj/cqbftj.jsp');

insert into sys_function_info (FUNID, FUNCTION_BM, FUNCTION_NAME, FUNCTION_DESC, FUNCTION_URL, FUNCTION_ORDER, NEW_USER_UID, NEW_DATE, PARENT_PROJECT_BM, PARENT_FUNID, XMBM, ZYLX, CJBM, PXH, ZZCD, SFKJ, DSBM, SFYC)
values ('LGZHRYTJ', 'LGZHRYTJ', '旅馆抓获人员统计', '', 'tj/lgzhrytj.jsp', '9', 'admin', to_date('13-06-2012 17:12:04', 'dd-mm-yyyy hh24:mi:ss'), '', '', 'LGY', '', '', '', '', '', '', '');
 
insert into sys_function_info (FUNID, FUNCTION_BM, FUNCTION_NAME, FUNCTION_DESC, FUNCTION_URL, FUNCTION_ORDER, NEW_USER_UID, NEW_DATE, PARENT_PROJECT_BM, PARENT_FUNID, XMBM, ZYLX, CJBM, PXH, ZZCD, SFKJ, DSBM, SFYC)
values ('LGYBKRYGL', 'LGYBKRYGL', '布控人员管理', '', 'bdbk/bdbkry.jsp', '1', 'admin', to_date('28-02-2012 11:33:43', 'dd-mm-yyyy hh24:mi:ss'), '', '', 'LGY', '', '', '', '', '', '', '');
 
insert into sys_function_info (FUNID, FUNCTION_BM, FUNCTION_NAME, FUNCTION_DESC, FUNCTION_URL, FUNCTION_ORDER, NEW_USER_UID, NEW_DATE, PARENT_PROJECT_BM, PARENT_FUNID, XMBM, ZYLX, CJBM, PXH, ZZCD, SFKJ, DSBM, SFYC)
values ('LGYBKJGCX', 'LGYBKJGCX', '布控结果查询', '', 'bdbk/bdbkjg.jsp', '2', 'admin', to_date('28-02-2012 11:33:43', 'dd-mm-yyyy hh24:mi:ss'), '', '', 'LGY', '', '', '', '', '', '', '');

insert into sys_function_info (FUNID, FUNCTION_BM, FUNCTION_NAME, FUNCTION_DESC, FUNCTION_URL, FUNCTION_ORDER, NEW_USER_UID, NEW_DATE, PARENT_PROJECT_BM, PARENT_FUNID, XMBM, ZYLX, CJBM, PXH, ZZCD, SFKJ, DSBM, SFYC)
values ('LKWJSTFTJ', 'LKWJSTFTJ', '未及时退房统计', '', 'tj/lkwjstftj.jsp', '8', 'admin', to_date('13-06-2012 17:12:04', 'dd-mm-yyyy hh24:mi:ss'), '', '', 'LGY', '', '', '', '', '', '', '');

insert into sys_function_info (FUNID, FUNCTION_BM, FUNCTION_NAME, FUNCTION_DESC, FUNCTION_URL, FUNCTION_ORDER, NEW_USER_UID, NEW_DATE, PARENT_PROJECT_BM, PARENT_FUNID, XMBM, ZYLX, CJBM, PXH, ZZCD, SFKJ, DSBM, SFYC)
values ('LGZHRY', 'LGZHRY', '旅馆抓获人员', '', 'lg/lgzhry.jsp', '5', 'admin', to_date('28-02-2012 11:33:43', 'dd-mm-yyyy hh24:mi:ss'), '', '', 'LGY', '', '', '', '', '', '', '');

insert into sys_function_info (FUNID, FUNCTION_BM, FUNCTION_NAME, FUNCTION_DESC, FUNCTION_URL, FUNCTION_ORDER, NEW_USER_UID, NEW_DATE, PARENT_PROJECT_BM, PARENT_FUNID, XMBM, ZYLX, CJBM, PXH, ZZCD, SFKJ, DSBM, SFYC)
values ('XTRZTJ', 'XTRZTJ', '系统日志统计', '', 'xtgl/syslogtj.jsp', '9', 'admin', to_date('13-06-2012 17:12:04', 'dd-mm-yyyy hh24:mi:ss'), '', '', 'LGY', '', '', '', '', '', '', '');

insert into sys_function_info(funid,function_bm,function_name,xmbm,function_order,new_user_uid,new_date,FUNCTION_URL)
values('MJZAJC','MJZAJC','民警治安检查','LGY',1,'admin',sysdate,'lg/mjzajc.jsp');      

insert into sys_function_info(funid,function_bm,function_name,xmbm,function_order,new_user_uid,new_date,FUNCTION_URL)
values('LGJFJC','LGJFJC','旅馆积分检查','LGY',1,'admin',sysdate,'lg/lgjfjc.jsp');

insert into sys_function_info(funid,function_bm,function_name,xmbm,function_order,new_user_uid,new_date,FUNCTION_URL)
values('DSRWZXQK','DSRWZXQK','后台任务执行情况','LGY',1,'admin',sysdate,'xtgl/htrwcx.jsp');
commit;
---------2012-7-3 16:33:47 [省级旅馆业新增加的菜单] mrf-------------

