/***************************************************************/
/*  Designed for Oracle 10g                                    */
/*  Export file for user HOTEL                                 */
/*  COPYRIGHT  mrf (2012)                                      */
/***************************************************************/


/*==============================================================*/
/* Table: TBL_SYS_VERSION                                       */
/*==============================================================*/
-- Create table
create table TBL_SYS_VERSION
(
  MODULENAME  VARCHAR2(30) not null,
  VERSION     VARCHAR2(20) not null,
  APPVERSION  VARCHAR2(20),
  CLTVERSION  VARCHAR2(20),
  TIMESTAMP   DATE default (sysdate),
  INSTALLFLAG CHAR(1)
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 48K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table TBL_SYS_VERSION
  is '版本信息表';
-- Add comments to the columns 
comment on column TBL_SYS_VERSION.MODULENAME
  is '模块名称';
comment on column TBL_SYS_VERSION.VERSION
  is '版本号';
comment on column TBL_SYS_VERSION.APPVERSION
  is '支持最高中间层版本号';
comment on column TBL_SYS_VERSION.CLTVERSION
  is '支持最高客户端版本号';
comment on column TBL_SYS_VERSION.TIMESTAMP
  is '安装标志';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TBL_SYS_VERSION
  add constraint PK_TBL_SYS_VERSION primary key (MODULENAME)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

/*==============================================================*/
/* Table: SYS_CODE                                              */
/*==============================================================*/
-- Create table
create table SYS_CODE
(
  ID         VARCHAR2(32) not null,
  CODETYPE   VARCHAR2(20) not null,
  CODE       VARCHAR2(20) not null,
  CODENAME   VARCHAR2(500) not null,
  PYT        VARCHAR2(100),
  SORT       NUMBER(3),
  VISIONTYPE VARCHAR2(20),
  DELETEFLAG VARCHAR2(20) not null,
  ISSTANDARD VARCHAR2(20),
  JLCJSJ     DATE,
  PARENTID   VARCHAR2(32),
  ISSELED    VARCHAR2(20),
  PARENTCODE VARCHAR2(20),
  XMBM       VARCHAR2(20) not null,
  DS         VARCHAR2(20) default 'gonganbu' not null,
  SPACENAME  VARCHAR2(50)
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 4M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_CODE
  is '系统代码表';
-- Add comments to the columns 
comment on column SYS_CODE.ID
  is '代码ID';
comment on column SYS_CODE.CODETYPE
  is '代码类别';
comment on column SYS_CODE.CODE
  is '代码编号';
comment on column SYS_CODE.CODENAME
  is '代码名称';
comment on column SYS_CODE.PYT
  is '拼音头';
comment on column SYS_CODE.SORT
  is '同等级的排序';
comment on column SYS_CODE.VISIONTYPE
  is '字典类型';
comment on column SYS_CODE.DELETEFLAG
  is '删除标志';
comment on column SYS_CODE.ISSTANDARD
  is '是否标准代码';
comment on column SYS_CODE.JLCJSJ
  is '创建日期';
comment on column SYS_CODE.PARENTID
  is '父id';
comment on column SYS_CODE.ISSELED
  is '是否可以选择';
comment on column SYS_CODE.PARENTCODE
  is '父code';
comment on column SYS_CODE.XMBM
  is '项目编码，为空或者*表示所有项目，否则表示该字典只适用于指定项目';
comment on column SYS_CODE.DS
  is '地市~~DQKHBM';
comment on column SYS_CODE.SPACENAME
  is '命名空间：空表示系统字典SYS，多个相同字典可用名字空间区分';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_CODE
  add constraint PK_TBL_SYS_CODE primary key (ID)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 2M
    minextents 1
    maxextents unlimited
  );



/*==============================================================*/
/* Table: SYS_CODETYP                                           */
/*==============================================================*/
-- Create table
create table SYS_CODETYPE
(
  ID_CODETYPE   VARCHAR2(32) not null,
  CODETYPE      VARCHAR2(20) not null,
  CODETYPENAME  VARCHAR2(100) not null,
  P_CODETYPE    VARCHAR2(20),
  ISSELED       VARCHAR2(20),
  SORT          NUMBER(3),
  DELETEFLAG    VARCHAR2(20) not null,
  ISINSERT      VARCHAR2(20),
  ISSTANDARD    VARCHAR2(20),
  VISIONTYPE    VARCHAR2(20),
  VB_VISIONTYPE VARCHAR2(20),
  PYT           VARCHAR2(1000),
  XMBM          VARCHAR2(20) not null,
  DS            VARCHAR2(20) default 'gonganbu' not null,
  BZ            VARCHAR2(500),
  PID           VARCHAR2(32),
  SPACENAME     VARCHAR2(50)
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 320K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_CODETYPE
  is '系统代码类别表';
-- Add comments to the columns 
comment on column SYS_CODETYPE.ID_CODETYPE
  is '代码类别ID';
comment on column SYS_CODETYPE.CODETYPE
  is '代码类别';
comment on column SYS_CODETYPE.CODETYPENAME
  is '代码类别名称';
comment on column SYS_CODETYPE.P_CODETYPE
  is '父类型标识';
comment on column SYS_CODETYPE.ISSELED
  is '是否可以选择';
comment on column SYS_CODETYPE.SORT
  is '同等级的排序';
comment on column SYS_CODETYPE.DELETEFLAG
  is '删除标记';
comment on column SYS_CODETYPE.ISINSERT
  is '是否允许新增';
comment on column SYS_CODETYPE.ISSTANDARD
  is '是否标准代码';
comment on column SYS_CODETYPE.VISIONTYPE
  is '字典类型';
comment on column SYS_CODETYPE.VB_VISIONTYPE
  is '代码选择树中用到的字典类型';
comment on column SYS_CODETYPE.PYT
  is '拼音头';
comment on column SYS_CODETYPE.XMBM
  is '项目编码，为空或者*表示所有项目，否则表示该字典只适用于指定项目';
comment on column SYS_CODETYPE.DS
  is '地市~~DQKHBM';
comment on column SYS_CODETYPE.BZ
  is '备注';
comment on column SYS_CODETYPE.PID
  is '父亲ID';
comment on column SYS_CODETYPE.SPACENAME
  is '命名空间：空表示系统字典SYS，多个相同字典可用名字空间区分';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_CODETYPE
  add constraint PK_TBL_SYS_CODETYPE primary key (ID_CODETYPE)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    minextents 1
    maxextents unlimited
  );



/*==============================================================*/
/* Table: SYS_FUNCTION_INFO                                     */
/*==============================================================*/
-- Create table
create table SYS_FUNCTION_INFO
(
  FUNID             VARCHAR2(32) not null,
  FUNCTION_BM       VARCHAR2(255) not null,
  FUNCTION_NAME     VARCHAR2(50) not null,
  FUNCTION_DESC     VARCHAR2(50),
  FUNCTION_URL      VARCHAR2(200),
  FUNCTION_ORDER    NUMBER(4) not null,
  NEW_USER_UID      VARCHAR2(32) not null,
  NEW_DATE          DATE not null,
  PARENT_PROJECT_BM VARCHAR2(20),
  PARENT_FUNID      VARCHAR2(32),
  XMBM              VARCHAR2(20) not null,
  ZYLX              VARCHAR2(20),
  CJBM              VARCHAR2(20),
  PXH               INTEGER,
  ZZCD              VARCHAR2(20),
  SFKJ              VARCHAR2(20),
  DSBM              VARCHAR2(50),
  SFYC              VARCHAR2(20)
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 192K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_FUNCTION_INFO
  is '系统权限编码表';
-- Add comments to the columns 
comment on column SYS_FUNCTION_INFO.FUNID
  is '权限ID，主键';
comment on column SYS_FUNCTION_INFO.FUNCTION_BM
  is '权限编码';
comment on column SYS_FUNCTION_INFO.FUNCTION_NAME
  is '权限名称';
comment on column SYS_FUNCTION_INFO.FUNCTION_DESC
  is '权限注释';
comment on column SYS_FUNCTION_INFO.FUNCTION_URL
  is '权限URL';
comment on column SYS_FUNCTION_INFO.FUNCTION_ORDER
  is '权限显示排序';
comment on column SYS_FUNCTION_INFO.NEW_USER_UID
  is '创建用户ID';
comment on column SYS_FUNCTION_INFO.NEW_DATE
  is '创建时间';
comment on column SYS_FUNCTION_INFO.PARENT_PROJECT_BM
  is '父功能点主键-项目代码';
comment on column SYS_FUNCTION_INFO.PARENT_FUNID
  is '父功能点主键-功能点代码';
comment on column SYS_FUNCTION_INFO.XMBM
  is '权限属于的项目';
comment on column SYS_FUNCTION_INFO.ZYLX
  is '扩展将来的菜单管理：资源类型:menu 菜单，btn_url 按钮/链接 other 其它';
comment on column SYS_FUNCTION_INFO.CJBM
  is '扩展将来的菜单管理：资源应用场景编码：菜单不能为空，默认sys(用来区分系统中的子系统菜单)';
comment on column SYS_FUNCTION_INFO.PXH
  is '扩展将来的菜单管理：排序号: 同一层次资源的排序号，只对菜单资源有效';
comment on column SYS_FUNCTION_INFO.ZZCD
  is '扩展将来的菜单管理：是否最终菜单：0 否，1 是';
comment on column SYS_FUNCTION_INFO.SFKJ
  is '扩展将来的菜单管理：是否快捷菜单:0 否，1 是';
comment on column SYS_FUNCTION_INFO.DSBM
  is '扩展将来的菜单管理：地市编码: DS';
comment on column SYS_FUNCTION_INFO.SFYC
  is '扩展将来的菜单管理：是否隐藏：0 否，1 是，隐藏的菜单必须通过搜索才能使用';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_FUNCTION_INFO
  add constraint F_PK primary key (FUNID)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    minextents 1
    maxextents unlimited
  );



/*==============================================================*/
/* Table: SYS_FUNCTION_INFO_ROLE                                */
/*==============================================================*/

-- Create table
create table SYS_FUNCTION_INFO_ROLE
(
  GXID        VARCHAR2(32) not null,
  FUNCTION_BM VARCHAR2(255) not null,
  ROLE_BM     VARCHAR2(20) not null,
  NEW_USER_ID VARCHAR2(32),
  NEW_DATE    DATE,
  XMBM        VARCHAR2(20)
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 384K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_FUNCTION_INFO_ROLE
  is '权限和角色关系表';
-- Add comments to the columns 
comment on column SYS_FUNCTION_INFO_ROLE.GXID
  is '关系ID';
comment on column SYS_FUNCTION_INFO_ROLE.FUNCTION_BM
  is '权限编码';
comment on column SYS_FUNCTION_INFO_ROLE.ROLE_BM
  is '角色编码';
comment on column SYS_FUNCTION_INFO_ROLE.NEW_USER_ID
  is '创建该关系的用户ID';
comment on column SYS_FUNCTION_INFO_ROLE.NEW_DATE
  is '创建该关系的时间';
comment on column SYS_FUNCTION_INFO_ROLE.XMBM
  is '权限属于的项目';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_FUNCTION_INFO_ROLE
  add constraint QXGX_PK primary key (GXID)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 320K
    minextents 1
    maxextents unlimited
  );


/*==============================================================*/
/* Table: SYS_ORGANIZE_INFO                                     */
/*==============================================================*/
-- Create table
create table SYS_ORGANIZE_INFO
(
  ORGID          VARCHAR2(32) not null,
  CCM            VARCHAR2(1000),
  ORGANIZE_NAME  VARCHAR2(100) not null,
  NEW_USER_ID    VARCHAR2(32),
  NEW_DATE       DATE,
  DWDH           VARCHAR2(60),
  PYT            VARCHAR2(60),
  SSQH           VARCHAR2(20),
  DWJC           VARCHAR2(100),
  DWGZ           BLOB,
  DWLX           VARCHAR2(20),
  GAJJC          VARCHAR2(60),
  JCGAJJC        VARCHAR2(60),
  JZY            BLOB,
  DWJB           VARCHAR2(20),
  YWXTFL         VARCHAR2(20),
  ORGANIZE_ORDER NUMBER(5),
  PCSDM          VARCHAR2(20),
  ORGANIZE_BM    VARCHAR2(20),
  ZXBZ           VARCHAR2(20),
  ORGANIZE_PATH  VARCHAR2(500),
  BZ             VARCHAR2(500),
  ADMINLB        VARCHAR2(500)
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_ORGANIZE_INFO
  is '单位表';
-- Add comments to the columns 
comment on column SYS_ORGANIZE_INFO.ORGID
  is 'UUID，主键';
comment on column SYS_ORGANIZE_INFO.CCM
  is '单位层次码，5级一个层次，根为5个0';
comment on column SYS_ORGANIZE_INFO.ORGANIZE_NAME
  is '单位名称';
comment on column SYS_ORGANIZE_INFO.NEW_USER_ID
  is '创建该单位的用户ID';
comment on column SYS_ORGANIZE_INFO.NEW_DATE
  is '创建时间';
comment on column SYS_ORGANIZE_INFO.DWDH
  is '单位电话';
comment on column SYS_ORGANIZE_INFO.PYT
  is '拼音头';
comment on column SYS_ORGANIZE_INFO.SSQH
  is '所属区划~~XZQH';
comment on column SYS_ORGANIZE_INFO.DWJC
  is '单位简称';
comment on column SYS_ORGANIZE_INFO.DWGZ
  is '单位公章';
comment on column SYS_ORGANIZE_INFO.DWLX
  is '单位类型~~';
comment on column SYS_ORGANIZE_INFO.GAJJC
  is '公安局简称';
comment on column SYS_ORGANIZE_INFO.JCGAJJC
  is '基层公安局简称';
comment on column SYS_ORGANIZE_INFO.JZY
  is '局长印';
comment on column SYS_ORGANIZE_INFO.DWJB
  is '单位级别';
comment on column SYS_ORGANIZE_INFO.YWXTFL
  is '业务系统分类';
comment on column SYS_ORGANIZE_INFO.ORGANIZE_ORDER
  is '单位排序号：同级单位排序用';
comment on column SYS_ORGANIZE_INFO.PCSDM
  is '派出所代码（兼容旅馆业，在旅馆业里面设置）';
comment on column SYS_ORGANIZE_INFO.ORGANIZE_BM
  is '单位代码';
comment on column SYS_ORGANIZE_INFO.ZXBZ
  is '注销标志：0 正常，1 注销';
comment on column SYS_ORGANIZE_INFO.ORGANIZE_PATH
  is '主单位完整路径（斜杠/分隔）';
comment on column SYS_ORGANIZE_INFO.BZ
  is '备注';
comment on column SYS_ORGANIZE_INFO.ADMINLB
  is '逗号分隔的单位管理员loginName列表';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ORGANIZE_INFO
  add constraint ORG_PK primary key (ORGID)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );


/*==============================================================*/
/* Table: SYS_ORGANIZE_INFO_ADMIN                               */
/*==============================================================*/

-- Create table
create table SYS_ORGANIZE_INFO_ADMIN
(
  ORGANIZE_BM VARCHAR2(20) not null,
  LOGIN_NAME  VARCHAR2(50) not null,
  YSID        VARCHAR2(32) not null
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_ORGANIZE_INFO_ADMIN
  is '单位管理员表';
-- Add comments to the columns 
comment on column SYS_ORGANIZE_INFO_ADMIN.ORGANIZE_BM
  is '单位编码';
comment on column SYS_ORGANIZE_INFO_ADMIN.LOGIN_NAME
  is '该单位的单位管理员名称';
comment on column SYS_ORGANIZE_INFO_ADMIN.YSID
  is '映射ID';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ORGANIZE_INFO_ADMIN
  add constraint DW_YH_YS_PK primary key (YSID)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );


/*==============================================================*/
/* Table: SYS_ORGANIZE_INFO_USER                                */
/*==============================================================*/
-- Create table
create table SYS_ORGANIZE_INFO_USER
(
  START_TIME   DATE,
  END_TIME     DATE,
  LOGIN_NAME   VARCHAR2(50) not null,
  ORGANIZE_BM  VARCHAR2(20) not null,
  GXID         VARCHAR2(32) not null,
  GXLX         VARCHAR2(20) not null,
  ZXBZ         VARCHAR2(20),
  CJSJ         DATE,
  XGSJ         DATE,
  NEW_USER_ID  VARCHAR2(32),
  EDIT_USER_ID VARCHAR2(32)
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_ORGANIZE_INFO_USER
  is '用户-单位关系表';
-- Add comments to the columns 
comment on column SYS_ORGANIZE_INFO_USER.START_TIME
  is '有效开始时间';
comment on column SYS_ORGANIZE_INFO_USER.END_TIME
  is '有效结束时间';
comment on column SYS_ORGANIZE_INFO_USER.LOGIN_NAME
  is '用户登陆名';
comment on column SYS_ORGANIZE_INFO_USER.ORGANIZE_BM
  is '单位编码';
comment on column SYS_ORGANIZE_INFO_USER.GXID
  is '主键，关系ID';
comment on column SYS_ORGANIZE_INFO_USER.GXLX
  is '关系类型：1 主单位 0 兼职';
comment on column SYS_ORGANIZE_INFO_USER.ZXBZ
  is '关系注销标志：0 有效，1 关系已注销';
comment on column SYS_ORGANIZE_INFO_USER.CJSJ
  is '创建时间';
comment on column SYS_ORGANIZE_INFO_USER.XGSJ
  is '最后修改时间';
comment on column SYS_ORGANIZE_INFO_USER.NEW_USER_ID
  is '创建该的用户ID';
comment on column SYS_ORGANIZE_INFO_USER.EDIT_USER_ID
  is '修改的用户ID';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ORGANIZE_INFO_USER
  add constraint DW_YH_PK primary key (GXID)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );



/*==============================================================*/
/* Table: SYS_PROJECT_FL                                        */
/*==============================================================*/
-- Create table
create table SYS_PROJECT_FL
(
  FLID   VARCHAR2(32) not null,
  FLNAME VARCHAR2(100),
  XMLB   VARCHAR2(200)
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_PROJECT_FL
  is '项目分类（项目域），一个项目分类包含若干项目';
-- Add comments to the columns 
comment on column SYS_PROJECT_FL.FLID
  is 'KEY';
comment on column SYS_PROJECT_FL.FLNAME
  is '项目分类名称';
comment on column SYS_PROJECT_FL.XMLB
  is '该分类包含的项目编码列表（多个用逗号分隔）';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_PROJECT_FL
  add constraint XMFL_KEY primary key (FLID)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );



/*==============================================================*/
/* Table: SYS_PROJECT_INFO                                      */
/*==============================================================*/
-- Create table
create table SYS_PROJECT_INFO
(
  XMBM VARCHAR2(20) not null,
  XMMC VARCHAR2(50) not null,
  XMSM VARCHAR2(100),
  CJSJ DATE,
  ZXBZ VARCHAR2(20)
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_PROJECT_INFO
  is '项目表';
-- Add comments to the columns 
comment on column SYS_PROJECT_INFO.XMBM
  is '项目编码，唯一';
comment on column SYS_PROJECT_INFO.XMMC
  is '项目名称，唯一';
comment on column SYS_PROJECT_INFO.XMSM
  is '项目说明';
comment on column SYS_PROJECT_INFO.CJSJ
  is '创建时间';
comment on column SYS_PROJECT_INFO.ZXBZ
  is '注销标志：0 有效，1 注销';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_PROJECT_INFO
  add constraint XMBM_PK primary key (XMBM)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );



/*==============================================================*/
/* Table: SYS_PROJECT_INFO_ADMIN                                */
/*==============================================================*/
-- Create table
create table SYS_PROJECT_INFO_ADMIN
(
  XMBM       VARCHAR2(20) not null,
  LOGIN_USER VARCHAR2(50) not null,
  CJSJ       DATE,
  GXID       VARCHAR2(32) not null
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_PROJECT_INFO_ADMIN
  is '项目管理员，只有项目管理员，才能创建本项目相关的权限和授权';
-- Add comments to the columns 
comment on column SYS_PROJECT_INFO_ADMIN.XMBM
  is '项目编码';
comment on column SYS_PROJECT_INFO_ADMIN.LOGIN_USER
  is '项目管理员登录名';
comment on column SYS_PROJECT_INFO_ADMIN.CJSJ
  is '创建时间';
comment on column SYS_PROJECT_INFO_ADMIN.GXID
  is '关系ID，主键';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_PROJECT_INFO_ADMIN
  add constraint XM_GL_PK primary key (GXID)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );



/*==============================================================*/
/* Table: SYS_ROLE_INFO                                         */
/*==============================================================*/
-- Create table
create table SYS_ROLE_INFO
(
  JSID        VARCHAR2(32) not null,
  XMBM        VARCHAR2(20) not null,
  ROLE_BM     VARCHAR2(20) not null,
  ROLE_NAME   VARCHAR2(255),
  ROLE_DESC   VARCHAR2(255),
  NEW_USER_ID VARCHAR2(32),
  NEW_DATE    DATE,
  ZXBZ        VARCHAR2(20)
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_ROLE_INFO
  is '角色表';
-- Add comments to the columns 
comment on column SYS_ROLE_INFO.JSID
  is '主键';
comment on column SYS_ROLE_INFO.XMBM
  is '该角色所在的项目编码';
comment on column SYS_ROLE_INFO.ROLE_BM
  is '角色编码';
comment on column SYS_ROLE_INFO.ROLE_NAME
  is '角色名称';
comment on column SYS_ROLE_INFO.ROLE_DESC
  is '角色说明';
comment on column SYS_ROLE_INFO.NEW_USER_ID
  is '创建该角色的用户ID';
comment on column SYS_ROLE_INFO.NEW_DATE
  is '创建该角色的时间';
comment on column SYS_ROLE_INFO.ZXBZ
  is '注销标志：1 注销，0 正常';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ROLE_INFO
  add constraint JS_KEY primary key (JSID)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );




/*==============================================================*/
/* Table: SYS_USER_INFO                                         */
/*==============================================================*/
-- Create table
create table SYS_USER_INFO
(
  XM                VARCHAR2(50) default 'abc' not null,
  LOGIN_NAME        VARCHAR2(50) not null,
  LOGIN_PASSWORD    VARCHAR2(100),
  ZXBZ              VARCHAR2(20),
  EMAIL             VARCHAR2(1000),
  MOBILE            VARCHAR2(20),
  TELEPHONE_NUMBER  VARCHAR2(30),
  SEX               VARCHAR2(5),
  LAST_LOGIN_TIME   DATE,
  MSN               VARCHAR2(255),
  IDCARD            VARCHAR2(18) not null,
  YWXTFL            VARCHAR2(20),
  PYT               VARCHAR2(60),
  SJFW              VARCHAR2(1000),
  YHQM              BLOB,
  GWLB              VARCHAR2(20),
  USID              VARCHAR2(32) not null,
  JM_LOGIN_NAME     VARCHAR2(100),
  JM_LOGIN_PASSWORD VARCHAR2(100),
  LAST_LOGIN_STATUS VARCHAR2(2),
  LAST_LOGIN_XMBM   VARCHAR2(20),
  RANK_CODE         VARCHAR2(32),
  NFXGMM            VARCHAR2(20),
  ORGANIZE_PATH     VARCHAR2(500),
  ORGANIZE_BM       VARCHAR2(20),
  CJSJ              DATE,
  XGSJ              DATE,
  ZWM               VARCHAR2(200),
  NEW_USER_ID       VARCHAR2(32),
  EDIT_USER_ID      VARCHAR2(32),
  BZ                VARCHAR2(500)
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_USER_INFO
  is '用户表';
-- Add comments to the columns 
comment on column SYS_USER_INFO.XM
  is '用户姓名';
comment on column SYS_USER_INFO.LOGIN_NAME
  is '用户登录名，唯一';
comment on column SYS_USER_INFO.LOGIN_PASSWORD
  is '用户登录密码';
comment on column SYS_USER_INFO.ZXBZ
  is '注销标志：0 正常，1 注销';
comment on column SYS_USER_INFO.EMAIL
  is '邮件地址';
comment on column SYS_USER_INFO.MOBILE
  is '手机号码';
comment on column SYS_USER_INFO.TELEPHONE_NUMBER
  is '电话号码';
comment on column SYS_USER_INFO.SEX
  is '性别，字典：性别';
comment on column SYS_USER_INFO.LAST_LOGIN_TIME
  is '最近尝试登录时间';
comment on column SYS_USER_INFO.MSN
  is 'MSN';
comment on column SYS_USER_INFO.IDCARD
  is '身份证号码';
comment on column SYS_USER_INFO.YWXTFL
  is '业务系统分类';
comment on column SYS_USER_INFO.PYT
  is '拼音头';
comment on column SYS_USER_INFO.SJFW
  is '数据范围（单位CCM字段，也是旅馆业的核实范围字段：单位下的所有管辖派出所代码)';
comment on column SYS_USER_INFO.YHQM
  is '用户签名';
comment on column SYS_USER_INFO.GWLB
  is '岗位类别';
comment on column SYS_USER_INFO.USID
  is '用户ID，唯一';
comment on column SYS_USER_INFO.JM_LOGIN_NAME
  is '加密登录名（兼容旅馆业）';
comment on column SYS_USER_INFO.JM_LOGIN_PASSWORD
  is '加密密码（兼容旅馆业）';
comment on column SYS_USER_INFO.LAST_LOGIN_STATUS
  is '最近用户登录状态：1 成功登录，0 密码错误';
comment on column SYS_USER_INFO.LAST_LOGIN_XMBM
  is '最近尝试登录项目 ';
comment on column SYS_USER_INFO.NFXGMM
  is '能否修改自己的密码：1 能，0 不能（兼容旅馆业）';
comment on column SYS_USER_INFO.ORGANIZE_PATH
  is '主单位完整路径（斜杠/分隔）';
comment on column SYS_USER_INFO.ORGANIZE_BM
  is '单位编码（用户主单位，冗余数据）';
comment on column SYS_USER_INFO.CJSJ
  is '创建时间';
comment on column SYS_USER_INFO.XGSJ
  is '最后修改时间';
comment on column SYS_USER_INFO.ZWM
  is '职务名称';
comment on column SYS_USER_INFO.NEW_USER_ID
  is '创建该的用户ID';
comment on column SYS_USER_INFO.EDIT_USER_ID
  is '修改的用户ID';
comment on column SYS_USER_INFO.BZ
  is '备注';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_USER_INFO
  add constraint UID_PK primary key (USID)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );



/*==============================================================*/
/* Table: SYS_USER_ROLE                                         */
/*==============================================================*/
-- Create table
create table SYS_USER_ROLE
(
  GXID        VARCHAR2(32) not null,
  LOGIN_NAME  VARCHAR2(50) not null,
  ROLE_BM     VARCHAR2(20) not null,
  XMBM        VARCHAR2(20) not null,
  NEW_USER_ID VARCHAR2(32),
  NEW_DATE    DATE
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_USER_ROLE
  is '角色-用户关系表';
-- Add comments to the columns 
comment on column SYS_USER_ROLE.GXID
  is 'KEY';
comment on column SYS_USER_ROLE.LOGIN_NAME
  is '用户登录名，唯一';
comment on column SYS_USER_ROLE.ROLE_BM
  is '角色编码';
comment on column SYS_USER_ROLE.XMBM
  is '该角色所在的项目编码';
comment on column SYS_USER_ROLE.NEW_USER_ID
  is '创建该关系的用户ID';
comment on column SYS_USER_ROLE.NEW_DATE
  is '创建时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_USER_ROLE
  add constraint JSYH_GXID primary key (GXID)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );



/*==============================================================*/
/* Table: SYS_USER_SESSION                                      */
/*==============================================================*/
-- Create table
create table SYS_USER_SESSION
(
  ID       VARCHAR2(32) not null,
  USERCODE VARCHAR2(10) not null,
  CRTTIME  DATE not null
)
tablespace QXGL_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table SYS_USER_SESSION
  is '用户登录标识，每次登陆都修改或者插入记录';
-- Add comments to the columns 
comment on column SYS_USER_SESSION.ID
  is '主键:UUID';
comment on column SYS_USER_SESSION.USERCODE
  is '用户标识';
comment on column SYS_USER_SESSION.CRTTIME
  is '创建时间';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_USER_SESSION
  add constraint USER_SESSION_UID primary key (ID)
  using index 
  tablespace QXGL_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );



/***************************************************************/
/*  End of this file                                           */
/***************************************************************/




