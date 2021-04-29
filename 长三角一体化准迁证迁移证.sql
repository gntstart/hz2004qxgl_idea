-- Create table
create table ZJYW_ZQZXX
(
  ywlsh               VARCHAR2(50) not null,
  zqzbh               VARCHAR2(100) not null,
  sqr_gmsfhm          VARCHAR2(18),
  sqr_xm              VARCHAR2(50) not null,
  sqr_zz_ssxqdm       VARCHAR2(50) not null,
  sqr_zz_qhnxxdz      NVARCHAR2(200) not null,
  sqr_hkdjjg_gajgjgdm VARCHAR2(32),
  sqr_hkdjjg_gajgmc   VARCHAR2(50),
  qcd_ssxqdm          VARCHAR2(50),
  qcd_qhnxxdz         NVARCHAR2(200),
  qcd_hkdjjg_gajgjgdm VARCHAR2(32),
  qcd_hkdjjg_gajgmc   VARCHAR2(50),
  qrd_ssxqdm          VARCHAR2(50) not null,
  qrd_qhnxxdz         NVARCHAR2(200) not null,
  qrd_hkdjjg_gajgjgdm VARCHAR2(32),
  qrd_hkdjjg_gajgmc   VARCHAR2(50),
  qfjg_gajgjgdm       VARCHAR2(32) not null,
  qfjg_gajgmc         VARCHAR2(50) not null,
  cbr_xm              VARCHAR2(50),
  qfrq                VARCHAR2(14),
  bz                  VARCHAR2(500),
  qyldyydm            VARCHAR2(500),
  yxqjzrq             VARCHAR2(50),
  qyfwdm              VARCHAR2(50),
  sldw_gajgjgdm       VARCHAR2(32) not null,
  sldw_gajgmc         VARCHAR2(50) not null,
  slr_xm              VARCHAR2(50),
  slsj                VARCHAR2(14) default TO_CHAR(SYSDATE,'yyyymmddhh24miss'),
  sjgsdwdm            VARCHAR2(32),
  sjgsdwmc            VARCHAR2(50),
  postid              VARCHAR2(32),
  sqr_lxdh            VARCHAR2(11),
  qyldyymc_nb         VARCHAR2(50),
  sldw_lxdh           VARCHAR2(11),
  isstatus            NUMBER default 0,
  sfbj                NUMBER default 0
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
comment on column ZJYW_ZQZXX.ywlsh
  is '主键';
comment on column ZJYW_ZQZXX.zqzbh
  is '准迁证编号';
comment on column ZJYW_ZQZXX.sqr_gmsfhm
  is '申请人_公民身份号码';
comment on column ZJYW_ZQZXX.sqr_xm
  is '申请人_姓名';
comment on column ZJYW_ZQZXX.sqr_zz_ssxqdm
  is '申请人_住址_省市县（区）';
comment on column ZJYW_ZQZXX.sqr_zz_qhnxxdz
  is '申请人_住址_区划内详细地址';
comment on column ZJYW_ZQZXX.sqr_hkdjjg_gajgjgdm
  is '申请人_户口登记机关_公安机关机构代码';
comment on column ZJYW_ZQZXX.sqr_hkdjjg_gajgmc
  is '申请人_户口登记机关_公安机关名称';
comment on column ZJYW_ZQZXX.qcd_ssxqdm
  is '迁出地_省市县（区）';
comment on column ZJYW_ZQZXX.qcd_qhnxxdz
  is '迁出地_区划内详细地址';
comment on column ZJYW_ZQZXX.qcd_hkdjjg_gajgjgdm
  is '迁出地_户口登记机关_公安机关机构代码';
comment on column ZJYW_ZQZXX.qcd_hkdjjg_gajgmc
  is '迁出地_户口登记机关_公安机关名称';
comment on column ZJYW_ZQZXX.qrd_ssxqdm
  is '迁入地_省市县（区）';
comment on column ZJYW_ZQZXX.qrd_qhnxxdz
  is '迁入地_区划内详细地址';
comment on column ZJYW_ZQZXX.qrd_hkdjjg_gajgjgdm
  is '迁入地_户口登记机关_公安机关机构代码';
comment on column ZJYW_ZQZXX.qrd_hkdjjg_gajgmc
  is '迁入地_户口登记机关_公安机关名称';
comment on column ZJYW_ZQZXX.qfjg_gajgjgdm
  is '签发机关_公安机关机构代码';
comment on column ZJYW_ZQZXX.qfjg_gajgmc
  is '签发机关_公安机关名称';
comment on column ZJYW_ZQZXX.cbr_xm
  is '承办人_姓名';
comment on column ZJYW_ZQZXX.qfrq
  is '签发日期';
comment on column ZJYW_ZQZXX.bz
  is '备注';
comment on column ZJYW_ZQZXX.qyldyydm
  is '迁移（流动）原因';
comment on column ZJYW_ZQZXX.yxqjzrq
  is '有效期截止日期';
comment on column ZJYW_ZQZXX.qyfwdm
  is '区域范围';
comment on column ZJYW_ZQZXX.sldw_gajgjgdm
  is '受理单位_公安机关机构代码';
comment on column ZJYW_ZQZXX.sldw_gajgmc
  is '受理单位_公安机关名称';
comment on column ZJYW_ZQZXX.slr_xm
  is '受理人_姓名';
comment on column ZJYW_ZQZXX.slsj
  is '受理时间';
comment on column ZJYW_ZQZXX.sjgsdwdm
  is '数据归属单位代码';
comment on column ZJYW_ZQZXX.sjgsdwmc
  is '数据归属单位名称';
comment on column ZJYW_ZQZXX.postid
  is '返回存储标记业务流水号';
comment on column ZJYW_ZQZXX.sqr_lxdh
  is '申请人联系电话';
comment on column ZJYW_ZQZXX.qyldyymc_nb
  is '迁移流动原因名称（内部）';
comment on column ZJYW_ZQZXX.sldw_lxdh
  is '受理单位_联系电话';
comment on column ZJYW_ZQZXX.isstatus
  is '是否报送 0/未报送 1/已报送';
comment on column ZJYW_ZQZXX.sfbj
  is '是否报送 0/未办结 1/已办结';
-- Create/Recreate primary, unique and foreign key constraints
alter table ZJYW_ZQZXX
  add constraint PK_ZJYW_ZQZXX primary key (YWLSH)
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
create table ZJYW_ZQZQYRXX
(
  id            VARCHAR2(32) not null,
  zqzbh         VARCHAR2(100) not null,
  ysqrgx_jtgxdm VARCHAR2(32) not null,
  gmsfhm        VARCHAR2(18),
  xm            VARCHAR2(50),
  xbdm          VARCHAR2(32),
  csrq          CHAR(8),
  ywlsh         VARCHAR2(32) not null
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
comment on column ZJYW_ZQZQYRXX.zqzbh
  is '准迁证编号';
comment on column ZJYW_ZQZQYRXX.ysqrgx_jtgxdm
  is '与申请人关系_家庭关系';
comment on column ZJYW_ZQZQYRXX.gmsfhm
  is '公民身份号码';
comment on column ZJYW_ZQZQYRXX.xm
  is '姓名';
comment on column ZJYW_ZQZQYRXX.xbdm
  is '性别';
comment on column ZJYW_ZQZQYRXX.csrq
  is '出生日期';
comment on column ZJYW_ZQZQYRXX.ywlsh
  is '浙江准迁证表id';
-- Create/Recreate primary, unique and foreign key constraints
alter table ZJYW_ZQZQYRXX
  add constraint PK_ZJYW_ZQZQYRXX primary key (ID)
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
create table ZJYW_QYZXX
(
  qyzbh         VARCHAR2(32) not null,
  czr_gmsfhm    VARCHAR2(18) not null,
  czr_xm        VARCHAR2(50) not null,
  yzz_ssxqdm    VARCHAR2(50) not null,
  yzz_qhnxxdz   NVARCHAR2(200) not null,
  yzz_cxfldm    VARCHAR2(10) not null,
  qwd_ssxqdm    VARCHAR2(50) not null,
  qwd_qhnxxdz   NVARCHAR2(200) not null,
  qfjg_gajgjgdm VARCHAR2(32),
  qfjg_gajgmc   VARCHAR2(50),
  qfrq          CHAR(8),
  yxqjzrq       VARCHAR2(50),
  cbr_xm        VARCHAR2(50),
  bz            NVARCHAR2(200),
  zqzbh         VARCHAR2(32),
  qyfwdm        VARCHAR2(32),
  sldw_gajgjgdm VARCHAR2(32) not null,
  sldw_gajgmc   VARCHAR2(50) not null,
  slr_xm        VARCHAR2(50) not null,
  slsj          CHAR(14) not null,
  sjgsdwdm      VARCHAR2(32) not null,
  sjgsdwmc      VARCHAR2(50) not null,
  ywlsh         VARCHAR2(32) not null,
  isstatus      NUMBER default 0,
  hkdjpcs       VARCHAR2(50),
  sfbj          VARCHAR2(2) default 0
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
comment on column ZJYW_QYZXX.qyzbh
  is '迁移证编号';
comment on column ZJYW_QYZXX.czr_gmsfhm
  is '持证人_公民身份号码';
comment on column ZJYW_QYZXX.czr_xm
  is '持证人_姓名';
comment on column ZJYW_QYZXX.yzz_ssxqdm
  is '原住址_省市县（区）';
comment on column ZJYW_QYZXX.yzz_qhnxxdz
  is '原住址_区划内详细地址';
comment on column ZJYW_QYZXX.yzz_cxfldm
  is '原住址_城乡分类';
comment on column ZJYW_QYZXX.qwd_ssxqdm
  is '去往地_省市县（区）';
comment on column ZJYW_QYZXX.qwd_qhnxxdz
  is '去往地_区划内详细地址';
comment on column ZJYW_QYZXX.qfjg_gajgjgdm
  is '签发机关_公安机关机构代码';
comment on column ZJYW_QYZXX.qfjg_gajgmc
  is '签发机关_公安机关名称';
comment on column ZJYW_QYZXX.qfrq
  is '签发日期';
comment on column ZJYW_QYZXX.yxqjzrq
  is '有效期截止日期';
comment on column ZJYW_QYZXX.cbr_xm
  is '承办人_姓名';
comment on column ZJYW_QYZXX.bz
  is '备注';
comment on column ZJYW_QYZXX.zqzbh
  is '准迁证编号';
comment on column ZJYW_QYZXX.qyfwdm
  is '区域范围';
comment on column ZJYW_QYZXX.sldw_gajgjgdm
  is '受理单位_公安机关机构代码';
comment on column ZJYW_QYZXX.sldw_gajgmc
  is '受理单位_公安机关名称';
comment on column ZJYW_QYZXX.slr_xm
  is '受理人_姓名';
comment on column ZJYW_QYZXX.slsj
  is '受理时间';
comment on column ZJYW_QYZXX.sjgsdwdm
  is '数据归属单位代码';
comment on column ZJYW_QYZXX.sjgsdwmc
  is '数据归属单位名称';
comment on column ZJYW_QYZXX.ywlsh
  is '返回存储标记';
comment on column ZJYW_QYZXX.isstatus
  is '是否报送 0/未报送 1/已报送';
comment on column ZJYW_QYZXX.hkdjpcs
  is '户口登记派出所';
comment on column ZJYW_QYZXX.sfbj
  is '是否办结 0/未办结 1/已办结';
-- Create/Recreate primary, unique and foreign key constraints
alter table ZJYW_QYZXX
  add constraint PK_ZJYW_QYZXX primary key (YWLSH)
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
create table ZJYW_QYZXXQYRXX
(
  id             VARCHAR2(32) not null,
  qyzbh          VARCHAR2(32) not null,
  yczrgx_jtgxdm  VARCHAR2(32) not null,
  gmsfhm         VARCHAR2(18) not null,
  xm             VARCHAR2(50) not null,
  cym            VARCHAR2(200),
  xbdm           VARCHAR2(32) not null,
  mzdm           VARCHAR2(32) not null,
  csrq           CHAR(8) not null,
  csd_gjhdqdm    VARCHAR2(23),
  csd_ssxqdm     VARCHAR2(32),
  csd_qhnxxdz    NVARCHAR2(200),
  jg_gjhdqdm     VARCHAR2(23),
  jg_ssxqdm      VARCHAR2(23),
  jg_qhnxxdz     NVARCHAR2(200),
  xldm           VARCHAR2(32),
  hyzkdm         VARCHAR2(32),
  zy             VARCHAR2(50),
  qyldyydm       NVARCHAR2(200) not null,
  xp             BLOB,
  ywlsh          VARCHAR2(32),
  qyldyymc_nb    VARCHAR2(50),
  jmsfz_qfjg     VARCHAR2(50),
  jmsfz_yxqxqsrq VARCHAR2(50),
  jmsfz_yxqxjzrq VARCHAR2(50)
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
comment on column ZJYW_QYZXXQYRXX.qyzbh
  is '迁移证编号';
comment on column ZJYW_QYZXXQYRXX.yczrgx_jtgxdm
  is '与持证人关系_家庭关系';
comment on column ZJYW_QYZXXQYRXX.gmsfhm
  is '公民身份号码';
comment on column ZJYW_QYZXXQYRXX.xm
  is '姓名';
comment on column ZJYW_QYZXXQYRXX.cym
  is '曾用名 最多允许5个，使用“，”分隔';
comment on column ZJYW_QYZXXQYRXX.xbdm
  is '性别';
comment on column ZJYW_QYZXXQYRXX.mzdm
  is '民族';
comment on column ZJYW_QYZXXQYRXX.csrq
  is '出生日期';
comment on column ZJYW_QYZXXQYRXX.csd_gjhdqdm
  is '出生地_国家（地区）';
comment on column ZJYW_QYZXXQYRXX.csd_ssxqdm
  is '出生地_省市县（区）';
comment on column ZJYW_QYZXXQYRXX.csd_qhnxxdz
  is '出生地_区划内详细地址';
comment on column ZJYW_QYZXXQYRXX.jg_gjhdqdm
  is '籍贯_国家（地区）';
comment on column ZJYW_QYZXXQYRXX.jg_ssxqdm
  is '籍贯_省市县（区）';
comment on column ZJYW_QYZXXQYRXX.jg_qhnxxdz
  is '籍贯_区划内详细地址';
comment on column ZJYW_QYZXXQYRXX.xldm
  is '文化程度';
comment on column ZJYW_QYZXXQYRXX.hyzkdm
  is '婚姻状况';
comment on column ZJYW_QYZXXQYRXX.zy
  is '职业';
comment on column ZJYW_QYZXXQYRXX.qyldyydm
  is '迁移（流动）原因';
comment on column ZJYW_QYZXXQYRXX.xp
  is '相片';
comment on column ZJYW_QYZXXQYRXX.ywlsh
  is '业务流水号';
comment on column ZJYW_QYZXXQYRXX.qyldyymc_nb
  is '迁移流动原因名称（内部）';
comment on column ZJYW_QYZXXQYRXX.jmsfz_qfjg
  is '居民身份证签发机关';
comment on column ZJYW_QYZXXQYRXX.jmsfz_yxqxqsrq
  is '有效期限起始日期';
comment on column ZJYW_QYZXXQYRXX.jmsfz_yxqxjzrq
  is '有效期限截止日期';
-- Create/Recreate primary, unique and foreign key constraints
alter table ZJYW_QYZXXQYRXX
  add constraint PK_ZJYW_QYZXXQYRXX primary key (ID)
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
create table ZJYW_ZQZQYZRESULT
(
  id    VARCHAR2(50) not null,
  sjblx VARCHAR2(50),
  ywlsh VARCHAR2(50),
  zqzbh VARCHAR2(100),
  qyzbh VARCHAR2(100),
  code  VARCHAR2(50),
  msg   VARCHAR2(4000),
  cjsj  DATE
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
comment on table ZJYW_ZQZQYZRESULT
  is '准迁证迁移证反馈信息';
-- Add comments to the columns
comment on column ZJYW_ZQZQYZRESULT.id
  is '主键';
comment on column ZJYW_ZQZQYZRESULT.sjblx
  is '数据包类型  010122准迁证/010124迁移证';
comment on column ZJYW_ZQZQYZRESULT.ywlsh
  is '业务流水号';
comment on column ZJYW_ZQZQYZRESULT.zqzbh
  is '准迁证编号';
comment on column ZJYW_ZQZQYZRESULT.qyzbh
  is '迁移证编号';
comment on column ZJYW_ZQZQYZRESULT.code
  is '反馈code';
comment on column ZJYW_ZQZQYZRESULT.msg
  is '反馈信息';
comment on column ZJYW_ZQZQYZRESULT.cjsj
  is '创建时间';
-- Create/Recreate primary, unique and foreign key constraints
alter table ZJYW_ZQZQYZRESULT
  add constraint PK_ZJYW_ZQZQYZRESULT primary key (ID)
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

