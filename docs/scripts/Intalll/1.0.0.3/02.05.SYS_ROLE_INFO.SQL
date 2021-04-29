/***************************************************************/
/*  Designed for Oracle 10g                                    */
/*  COPYRIGHT  GNT (2012)   WRITER MRF                         */
/***************************************************************/


insert into SYS_ROLE_INFO(jsid,xmbm,role_bm,role_name,new_user_id,new_date,zxbz)values('QXGLADMIN','QXGL','QXGLADMIN','系统管理员','admin',sysdate,'0');
insert into sys_role_info(jsid,xmbm,role_bm,role_name,new_user_id,new_date,zxbz)values('LGYADMIN','LGY','LGYADMIN','旅馆业系统管理员','admin',sysdate,'0');
insert into sys_role_info(jsid,xmbm,role_bm,role_name,role_desc,new_user_id,new_date,zxbz)values('4028809d35e5c7410135e5d97ab80014', 'QXGL', 'FJGLY', '分局管理员', '', 'admin', sysdate, '0');
commit;
