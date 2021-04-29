/***************************************************************/
/*  Designed for Oracle 10g                                    */
/*  COPYRIGHT  GNT (2012)   WRITER MRF                         */
/***************************************************************/


alter table SYS_CODE
  add constraint UNIQUE_SYS_CODE_C unique (CODE, CODETYPE, VISIONTYPE, XMBM, DS)
  using index 
  tablespace QXGL_IDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 3M
    minextents 1
    maxextents unlimited
  );


alter table SYS_CODETYPE
  add constraint UNIQUE_SYS_CODETYPE_C unique (CODETYPE, VISIONTYPE, XMBM)
  using index 
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


alter table SYS_CODETYPE
  add constraint FK_SYS_CODETYPE_CODE_SEFLF foreign key (PID)
  references SYS_CODETYPE (ID_CODETYPE) on delete cascade
  disable;

alter table SYS_FUNCTION_INFO
  add constraint F_UK unique (XMBM, FUNCTION_BM)
  using index 
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


alter table SYS_FUNCTION_INFO_ROLE
  add constraint QXGX_UK unique (XMBM, FUNCTION_BM, ROLE_BM)
  using index 
  tablespace QXGL_IDX
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 320K
    minextents 1
    maxextents unlimited
  );

alter table SYS_ORGANIZE_INFO
  add constraint ORG_UK1 unique (ORGANIZE_BM)
  using index 
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


alter table SYS_ORGANIZE_INFO
  add constraint ORG_UK2 unique (CCM)
  using index 
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


alter table SYS_ROLE_INFO
  add constraint JS_UK unique (XMBM, ROLE_BM)
  using index 
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

alter table SYS_USER_INFO
  add constraint LOGIN_NAME_UK unique (LOGIN_NAME)
  using index 
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


/***************************************************************/
/*  End of this file                                           */
/***************************************************************/
