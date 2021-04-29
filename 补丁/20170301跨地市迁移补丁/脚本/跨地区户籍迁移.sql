-- Add/modify columns 
alter table HJYW_QCZXXXB add KDQQY_DQBM VARCHAR2(20);
alter table HJYW_QCZXXXB add KDQQY_YHM VARCHAR2(40);
-- Add comments to the columns 
comment on column HJYW_QCZXXXB.KDQQY_DQBM
  is '跨地区迁移地区';
comment on column HJYW_QCZXXXB.KDQQY_YHM
  is '跨地区迁移用户名';
-- Create/Recreate indexes 
create index I_QCZX_KDQQY_DQ on HJYW_QCZXXXB (kdqqy_dqbm);
create index I_QCZX_KDQQY_YHM on HJYW_QCZXXXB (kdqqy_yhm);

-- Add/modify columns 
alter table HJYW_QCZXXXB add KDQQY_YHID NUMBER(19);
-- Add comments to the columns 
comment on column HJYW_QCZXXXB.KDQQY_YHID
  is '跨地区迁移用户ID';
-- Create/Recreate indexes 
create index I_QCZX_KDQQY_UID on HJYW_QCZXXXB (kdqqy_yhid);

-- Add/modify columns 
alter table HJYW_QCZXXXB add KDQQY_CGBZ varchar2(20);
-- Add comments to the columns 
comment on column HJYW_QCZXXXB.KDQQY_CGBZ
  is '跨地区迁移成功标志：0 迁出，1 迁出且迁入';
-- Create/Recreate indexes 
create index I_QCZX_KDQQY_CGBZ on HJYW_QCZXXXB (kdqqy_cgbz);

-- Add/modify columns 
alter table HJSP_HJSPSQB add KDQQY_QCHJYWID VARCHAR2(20);
alter table HJSP_HJSPSQB add KDQQY_QCDQBM VARCHAR2(20);
-- Add comments to the columns 
comment on column HJSP_HJSPSQB.KDQQY_QCHJYWID
  is '跨地区迁移-迁出户籍业务ID';
comment on column HJSP_HJSPSQB.KDQQY_QCDQBM
  is '跨地区迁移-迁出地区';
-- Create/Recreate indexes 
create index PK_HJSP_KDQQR on HJSP_HJSPSQB (kdqqy_qchjywid);
