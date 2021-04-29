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



-- add by zjm 20200615 开具范围  字典
insert into XT_XTCSB (CSID, CSLB, DM, MC, ZWPY, KZBZB, KZBZC, KZBZD, KZBZE, KZBZF, KZBZG, XGBZ, BDLX, BDSJ)
values ('9000000001000005305', '9999', '5028', '开具范围', '名称中文拼音', null, null, null, 'CS_KJFW', '1', '8', '0', 'I', '20180502000002');
insert into XT_XTCSB (CSID, CSLB, DM, MC, ZWPY, KZBZB, KZBZC, KZBZD, KZBZE, KZBZF, KZBZG, XGBZ, BDLX, BDSJ)
values ('9000000001000005306', '5028', '1', '户口登记项目内容变更更正证明', 'HKDJXMNRBGGZZM', null, null, null, null, null, null, '0', 'I', '20180502000002');
insert into XT_XTCSB (CSID, CSLB, DM, MC, ZWPY, KZBZB, KZBZC, KZBZD, KZBZE, KZBZF, KZBZG, XGBZ, BDLX, BDSJ)
values ('9000000001000005307', '5028', '2', '注销户口证明', 'ZXHKZM', null, null, null, null, null, null, '0', 'I', '20180502000002');
insert into XT_XTCSB (CSID, CSLB, DM, MC, ZWPY, KZBZB, KZBZC, KZBZD, KZBZE, KZBZF, KZBZG, XGBZ, BDLX, BDSJ)
values ('9000000001000005308', '5028', '3', '曾经同户人员亲属关系证明', 'CJTHRYQSGXZM', null, null, null, null, null, null, '0', 'I', '20180502000002');
insert into XT_XTCSB (CSID, CSLB, DM, MC, ZWPY, KZBZB, KZBZC, KZBZD, KZBZE, KZBZF, KZBZG, XGBZ, BDLX, BDSJ)
values ('9000000001000005309', '5028', '4', '法律法规规定的其他情形', 'FLFGGDDQTQX', null, null, null, null, null, null, '0', 'I', '20180502000002');

-- add by zjm 20200615 领取方式字典
insert into XT_XTCSB (CSID, CSLB, DM, MC, ZWPY, KZBZB, KZBZC, KZBZD, KZBZE, KZBZF, KZBZG, XGBZ, BDLX, BDSJ)
values ('9000000001000005310', '9999', '5029', '领取方式', '名称中文拼音', null, null, null, 'CS_LQFS', '1', '8', '0', 'I', '20180502000002');
insert into XT_XTCSB (CSID, CSLB, DM, MC, ZWPY, KZBZB, KZBZC, KZBZD, KZBZE, KZBZF, KZBZG, XGBZ, BDLX, BDSJ)
values ('9000000001000005311', '5029', '1', '网上下载', 'WSXZ', null, null, null, null, null, null, '0', 'I', '20180502000002');
insert into XT_XTCSB (CSID, CSLB, DM, MC, ZWPY, KZBZB, KZBZC, KZBZD, KZBZE, KZBZF, KZBZG, XGBZ, BDLX, BDSJ)
values ('9000000001000005312', '5029', '2', '物流快递', 'WLKD', null, null, null, null, null, null, '0', 'I', '20180502000002');
insert into XT_XTCSB (CSID, CSLB, DM, MC, ZWPY, KZBZB, KZBZC, KZBZD, KZBZE, KZBZF, KZBZG, XGBZ, BDLX, BDSJ)
values ('9000000001000005313', '5029', '3', '线下自取', 'XXZQ', null, null, null, null, null, null, '0', 'I', '20180502000002');



-- Create table
create table YWTB_API_LOG
(
  lgbm    VARCHAR2(200),
  logsj   VARCHAR2(500),
  apiname VARCHAR2(200),
  bz      VARCHAR2(4000),
  hs      VARCHAR2(32),
  sfcg    VARCHAR2(2),
  logid   VARCHAR2(32) not null,
  jls     NUMBER,
  ip      VARCHAR2(32)
)
tablespace HZ2004_CZRK
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table
comment on table YWTB_API_LOG
  is 'api';
-- Add comments to the columns
comment on column YWTB_API_LOG.lgbm
  is '派出所编码';
comment on column YWTB_API_LOG.logsj
  is '日志数据';
comment on column YWTB_API_LOG.apiname
  is '访问方法名称';
comment on column YWTB_API_LOG.bz
  is '备注';
comment on column YWTB_API_LOG.hs
  is '提交行数';
comment on column YWTB_API_LOG.sfcg
  is '是否成功';
comment on column YWTB_API_LOG.logid
  is '主键';
comment on column YWTB_API_LOG.jls
  is '记录数';
comment on column YWTB_API_LOG.ip
  is '请求ip';
-- Create/Recreate primary, unique and foreign key constraints
alter table YWTB_API_LOG
  add constraint PK_YWTB_API_LOG_ID primary key (LOGID)
  using index
  tablespace HZ2004_CZRK
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );




-- Create table
create table YWTB_FJCL
(
  id        VARCHAR2(32) not null,
  applyno   VARCHAR2(100),
  filename  VARCHAR2(100),
  needflag  VARCHAR2(5),
  stuffname VARCHAR2(100),
  stuffcode VARCHAR2(100),
  stuffid   VARCHAR2(50),
  stufffile BLOB,
  cjsj      DATE
)
tablespace HZ2004_CZRK
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns
comment on column YWTB_FJCL.id
  is 'id';
comment on column YWTB_FJCL.applyno
  is 'YWTB_XX 主键';
comment on column YWTB_FJCL.filename
  is '是否必填';
comment on column YWTB_FJCL.needflag
  is '证件类型';
comment on column YWTB_FJCL.stuffname
  is '证件号码';
comment on column YWTB_FJCL.stuffid
  is '材料id';
comment on column YWTB_FJCL.stufffile
  is 'base64字符串';
comment on column YWTB_FJCL.cjsj
  is '创建时间';
-- Create/Recreate primary, unique and foreign key constraints
alter table YWTB_FJCL
  add constraint PK_YWTB_XX_ID primary key (ID)
  using index
  tablespace HZ2004_CZRK
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );



-- Create table
create table YWTB_XKZ_API
(
  lgbm  VARCHAR2(50) not null,
  gxsj  DATE,
  ipxz  VARCHAR2(200),
  jzsj  DATE,
  kssj  DATE,
  xkz   VARCHAR2(4000) not null,
  bz    VARCHAR2(400),
  lgmc  VARCHAR2(200),
  pl    NUMBER(4),
  xkzid VARCHAR2(32) not null,
  pwd   VARCHAR2(20),
  sbh   VARCHAR2(50),
  qfsj  DATE,
  ip    VARCHAR2(200)
)
tablespace HZ2004_CZRK
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table
comment on table YWTB_XKZ_API
  is 'api商户〃';
-- Add comments to the columns
comment on column YWTB_XKZ_API.lgbm
  is '主键-派出所编码';
comment on column YWTB_XKZ_API.gxsj
  is '更新时间';
comment on column YWTB_XKZ_API.ipxz
  is 'ip限制';
comment on column YWTB_XKZ_API.jzsj
  is '截止时间';
comment on column YWTB_XKZ_API.kssj
  is '开始时间';
comment on column YWTB_XKZ_API.xkz
  is '许可证';
comment on column YWTB_XKZ_API.bz
  is '备注';
comment on column YWTB_XKZ_API.lgmc
  is '派出所名称';
comment on column YWTB_XKZ_API.pl
  is '提交数据批次量小于100条每次';
comment on column YWTB_XKZ_API.xkzid
  is '许可证id';
comment on column YWTB_XKZ_API.pwd
  is '传输密码';
comment on column YWTB_XKZ_API.sbh
  is '设备号';
comment on column YWTB_XKZ_API.qfsj
  is '签发时间';
comment on column YWTB_XKZ_API.ip
  is 'ip地址';
-- Create/Recreate primary, unique and foreign key constraints
alter table YWTB_XKZ_API
  add constraint PK_YWTB_XKZ_API primary key (LGBM)
  using index
  tablespace HZ2004_CZRK
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


-- Create table
create table YWTB_XX
(
  applyno     VARCHAR2(100) not null,
  username    VARCHAR2(50),
  licenseno   VARCHAR2(18),
  mobile      VARCHAR2(11),
  sldwcode    VARCHAR2(100),
  sldwname    VARCHAR2(100),
  content     VARCHAR2(500),
  itemname    VARCHAR2(100),
  begintime   DATE,
  kjfw        VARCHAR2(10),
  lqfs        VARCHAR2(10),
  sjrusername VARCHAR2(50),
  sjraddress  VARCHAR2(500),
  sjrmobile   VARCHAR2(11),
  isstatus    VARCHAR2(10) default 0,
  cjsj        DATE,
  xgsj        DATE,
  bljg        VARCHAR2(10),
  blyj        VARCHAR2(500),
  bl_file     BLOB,
  bl_bmcode   VARCHAR2(10),
  bl_bmname   VARCHAR2(50)
)
tablespace HZ2004_CZRK
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns
comment on column YWTB_XX.applyno
  is '业务编号,作为主键';
comment on column YWTB_XX.username
  is '姓名';
comment on column YWTB_XX.licenseno
  is '身份证号码';
comment on column YWTB_XX.mobile
  is '手机号码';
comment on column YWTB_XX.sldwcode
  is '受理单位编号';
comment on column YWTB_XX.sldwname
  is '受理单位名称';
comment on column YWTB_XX.content
  is '简述需查证内容';
comment on column YWTB_XX.itemname
  is '事项名称';
comment on column YWTB_XX.begintime
  is '申请时间';
comment on column YWTB_XX.kjfw
  is '开具范围   字典见操作文档';
comment on column YWTB_XX.lqfs
  is '领取方式   字典见操作文档';
comment on column YWTB_XX.sjrusername
  is '收件人姓名';
comment on column YWTB_XX.sjraddress
  is '收件人联系地址';
comment on column YWTB_XX.sjrmobile
  is '收件人联系电话';
comment on column YWTB_XX.isstatus
  is '数据状态 0、未推送  1、推送成功  2、推送失败';
comment on column YWTB_XX.cjsj
  is '创建时间';
comment on column YWTB_XX.xgsj
  is '修改时间';
comment on column YWTB_XX.bljg
  is '办理结果  0 通过， 1不通过';
comment on column YWTB_XX.blyj
  is '办理意见';
comment on column YWTB_XX.bl_file
  is '附件材料';
comment on column YWTB_XX.bl_bmcode
  is '办理部门编码';
comment on column YWTB_XX.bl_bmname
  is '办理部门名称';
-- Create/Recreate primary, unique and foreign key constraints
alter table YWTB_XX
  add constraint PK_YWTB_XX_APPLYNO primary key (APPLYNO)
  using index
  tablespace HZ2004_CZRK
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

