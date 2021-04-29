/***************************************************************/
/*  Designed for Oracle 10g                                     */
/*  COPYRIGHT  GNT (2012)   WRITER MRF                         */
/***************************************************************/

/*==============================================================*/
/* Index: F_INDEX1                                              */
/*==============================================================*/

-- Create/Recreate indexes 
create index F_INDEX1 on SYS_FUNCTION_INFO (NEW_USER_UID)
  tablespace QXGL_IDX
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
/* Index: QXGX_INDEX1                                           */
/*==============================================================*/
-- Create/Recreate indexes 
create index QXGX_INDEX1 on SYS_FUNCTION_INFO_ROLE (NEW_USER_ID)
  tablespace QXGL_IDX
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
/* Index: DW_YH_INDEX1                                          */
/*==============================================================*/
-- Create/Recreate indexes 
create index DW_YH_INDEX1 on SYS_ORGANIZE_INFO_ADMIN (ORGANIZE_BM)
  tablespace QXGL_IDX
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
/* Index: DW_YH_INDEX2                                          */
/*==============================================================*/
create index DW_YH_INDEX2 on SYS_ORGANIZE_INFO_ADMIN (LOGIN_NAME)
  tablespace QXGL_IDX
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
/* Index: DW_YHGX_INDEX1                                        */
/*==============================================================*/
-- Create/Recreate indexes 
create index DW_YHGX_INDEX1 on SYS_ORGANIZE_INFO_USER (LOGIN_NAME)
  tablespace QXGL_IDX
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
/* Index: DW_YHGX_INDEX2                                        */
/*==============================================================*/
create index DW_YHGX_INDEX2 on SYS_ORGANIZE_INFO_USER (ORGANIZE_BM)
  tablespace QXGL_IDX
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
/* Index: DW_YHGX_INDEX3                                        */
/*==============================================================*/
create index DW_YHGX_INDEX3 on SYS_ORGANIZE_INFO_USER (GXLX)
  tablespace QXGL_IDX
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
/* Index: JS_INDEX1                                             */
/*==============================================================*/
-- Create/Recreate indexes 
create index JS_INDEX1 on SYS_ROLE_INFO (XMBM)
  tablespace QXGL_IDX
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
/* Index: JS_INDEX2                                             */
/*==============================================================*/
create index JS_INDEX2 on SYS_ROLE_INFO (ROLE_BM)
  tablespace QXGL_IDX
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
/* Index: JS_INDEX3                                             */
/*==============================================================*/
create index JS_INDEX3 on SYS_ROLE_INFO (NEW_USER_ID)
  tablespace QXGL_IDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
