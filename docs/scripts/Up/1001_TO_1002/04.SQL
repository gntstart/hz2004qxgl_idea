----------2012-7-3 16:43:01 [ °º∂¬√π›“µ–ﬁ∏ƒ–Ë“™–¬‘ˆº”µƒ±Ì] mrf-----------
create table HZPYDZB
(
  HZ VARCHAR2(2) not null,
  PY VARCHAR2(8) not null
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
-- Create/Recreate primary, unique and foreign key constraints 
alter table HZPYDZB
  add constraint HZPYDZB_PK primary key (HZ, PY)
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


insert into HZPYDZB (HZ, PY)
values ('àÿ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('àŸ', 'LENG');
insert into HZPYDZB (HZ, PY)
values ('à⁄', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('à‹', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('à›', 'AN');
insert into HZPYDZB (HZ, PY)
values ('àﬁ', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('àﬂ', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('à‡', 'TU');
insert into HZPYDZB (HZ, PY)
values ('à‚', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('àÂ', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('àÂ', 'WO');
insert into HZPYDZB (HZ, PY)
values ('àÁ', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('àË', 'YU');
insert into HZPYDZB (HZ, PY)
values ('àÈ', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('àÍ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('àÎ', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('àÏ', 'AI');
insert into HZPYDZB (HZ, PY)
values ('àÏ', 'E');
insert into HZPYDZB (HZ, PY)
values ('àÌ', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('àÔ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('à', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('àÒ', 'E');
insert into HZPYDZB (HZ, PY)
values ('àÛ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('àÙ', 'CI');
insert into HZPYDZB (HZ, PY)
values ('àÙ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('àı', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('àˆ', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('à˜', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('à¯', 'POU');
insert into HZPYDZB (HZ, PY)
values ('à¯', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('à˘', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('à˙', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('à˚', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('à¸', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('à˝', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('â@', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('â@', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('âA', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('âA', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('âB', 'PING');
insert into HZPYDZB (HZ, PY)
values ('âC', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('âD', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('âF', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('âG', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('âJ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('âK', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('âN', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('âQ', 'MI');
insert into HZPYDZB (HZ, PY)
values ('âR', 'WENG');
insert into HZPYDZB (HZ, PY)
values ('âS', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('âT', 'TU');
insert into HZPYDZB (HZ, PY)
values ('âU', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('âU', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('âW', 'LI');
insert into HZPYDZB (HZ, PY)
values ('âY', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('â[', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('â\', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('âa', 'AI');
insert into HZPYDZB (HZ, PY)
values ('âd', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('âe', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('âi', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('âj', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('âl', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('âm', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ân', 'LU');
insert into HZPYDZB (HZ, PY)
values ('âo', 'LU');
insert into HZPYDZB (HZ, PY)
values ('âp', 'OU');
insert into HZPYDZB (HZ, PY)
values ('âr', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('âs', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ât', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('âv', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('âw', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ây', 'DI');
insert into HZPYDZB (HZ, PY)
values ('ây', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('âz', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('â{', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('â~', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('â~', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('âÄ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('âÅ', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('âÉ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('âÉ', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('âÑ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('âÖ', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('âà', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('ââ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('âä', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('âé', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('âè', 'BA');
insert into HZPYDZB (HZ, PY)
values ('âê', 'PU');
insert into HZPYDZB (HZ, PY)
values ('âí', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('âí', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('âì', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('âï', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('âñ', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('âò', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('âô', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('âö', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('âõ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('âú', 'DENG');
commit;
prompt 100 records committed...
insert into HZPYDZB (HZ, PY)
values ('âü', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('â†', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('â£', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('â•', 'AO');
insert into HZPYDZB (HZ, PY)
values ('â¶', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('âß', 'AO');
insert into HZPYDZB (HZ, PY)
values ('â®', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('â¨', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('â≠', 'YE');
insert into HZPYDZB (HZ, PY)
values ('âÆ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('âÆ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('âØ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('âØ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('â∞', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('â±', 'JU');
insert into HZPYDZB (HZ, PY)
values ('â≤', 'HUAI');
insert into HZPYDZB (HZ, PY)
values ('â≥', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('â∑', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('âº', 'RUAN');
insert into HZPYDZB (HZ, PY)
values ('âΩ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('âæ', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('âæ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('âø', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('â¿', 'LU');
insert into HZPYDZB (HZ, PY)
values ('â≈', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('â∆', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('â»', 'LI');
insert into HZPYDZB (HZ, PY)
values ('â…', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('âÕ', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('âŒ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('â–', 'SAN');
insert into HZPYDZB (HZ, PY)
values ('â—', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('â”', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('â‘', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('â’', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('â÷', 'HU');
insert into HZPYDZB (HZ, PY)
values ('â◊', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('âŸ', 'XU');
insert into HZPYDZB (HZ, PY)
values ('â⁄', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('â‹', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('â›', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('âﬁ', 'SHOU');
insert into HZPYDZB (HZ, PY)
values ('â‡', 'GU');
insert into HZPYDZB (HZ, PY)
values ('â‡', 'YING');
insert into HZPYDZB (HZ, PY)
values ('â·', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('â‚', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('â‚', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('â„', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('â‰', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('âÂ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('âÊ', 'QUN');
insert into HZPYDZB (HZ, PY)
values ('âÁ', 'LING');
insert into HZPYDZB (HZ, PY)
values ('âË', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('âÎ', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('âÏ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('âÌ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('âÌ', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('âÓ', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('âÓ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('âÔ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('â', 'QING');
insert into HZPYDZB (HZ, PY)
values ('âÒ', 'OES');
insert into HZPYDZB (HZ, PY)
values ('âÚ', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('âÙ', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('âı', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('â¯', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('â˘', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('â˙', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('â˙', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('â˚', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('â¸', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('â˝', 'BI');
insert into HZPYDZB (HZ, PY)
values ('â˛', 'HWA');
insert into HZPYDZB (HZ, PY)
values ('ä@', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('äA', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('äB', 'BA');
insert into HZPYDZB (HZ, PY)
values ('äD', 'DI');
insert into HZPYDZB (HZ, PY)
values ('äD', 'TI');
insert into HZPYDZB (HZ, PY)
values ('äE', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('äF', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('äG', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('äH', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('äJ', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('äK', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('äL', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('äM', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('äN', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('äO', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('äR', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('äR', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('äS', 'AO');
insert into HZPYDZB (HZ, PY)
values ('äU', 'PO');
insert into HZPYDZB (HZ, PY)
values ('äW', 'AO');
insert into HZPYDZB (HZ, PY)
values ('äX', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ä^', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('ä_', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('äa', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('äb', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('äc', 'DING');
insert into HZPYDZB (HZ, PY)
values ('äc', 'TING');
commit;
prompt 200 records committed...
insert into HZPYDZB (HZ, PY)
values ('äd', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('äe', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('äf', 'NUAN');
insert into HZPYDZB (HZ, PY)
values ('äg', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('äh', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('äi', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('äk', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('äl', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('äm', 'FU');
insert into HZPYDZB (HZ, PY)
values ('äm', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('än', 'JING');
insert into HZPYDZB (HZ, PY)
values ('äo', 'HA');
insert into HZPYDZB (HZ, PY)
values ('äo', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('äp', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('äq', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('är', 'PA');
insert into HZPYDZB (HZ, PY)
values ('äs', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('äs', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('ät', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('äu', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('äv', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('äx', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('äy', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('äz', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('ä{', 'NA');
insert into HZPYDZB (HZ, PY)
values ('ä{', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('ä|', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('ä}', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('ä~', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('äÄ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('äÄ', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('äÅ', 'DU');
insert into HZPYDZB (HZ, PY)
values ('äÇ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('äÇ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('äÉ', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('äÑ', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('äÖ', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('äÖ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('äá', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('äà', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('äâ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('äâ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ää', 'E');
insert into HZPYDZB (HZ, PY)
values ('äã', 'MO');
insert into HZPYDZB (HZ, PY)
values ('äå', 'BI');
insert into HZPYDZB (HZ, PY)
values ('äç', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('äé', 'E');
insert into HZPYDZB (HZ, PY)
values ('äè', 'HE');
insert into HZPYDZB (HZ, PY)
values ('äê', 'XU');
insert into HZPYDZB (HZ, PY)
values ('äë', 'FA');
insert into HZPYDZB (HZ, PY)
values ('äí', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('äì', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('äî', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('äï', 'FU');
insert into HZPYDZB (HZ, PY)
values ('äñ', 'LING');
insert into HZPYDZB (HZ, PY)
values ('äò', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('äô', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('äö', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('äõ', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('äú', 'CI');
insert into HZPYDZB (HZ, PY)
values ('äù', 'JU');
insert into HZPYDZB (HZ, PY)
values ('äü', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('ä†', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ä°', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('ä¢', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('ä£', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ä£', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ä§', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ä•', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('ä¶', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ä©', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ä™', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ä¨', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('ä≠', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('äÆ', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('äØ', 'HU');
insert into HZPYDZB (HZ, PY)
values ('äØ', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('ä±', 'MING');
insert into HZPYDZB (HZ, PY)
values ('ä≤', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('ä≥', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('ä∂', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('ä∑', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ä∑', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('ä∏', 'TI');
insert into HZPYDZB (HZ, PY)
values ('äπ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('äπ', 'WA');
insert into HZPYDZB (HZ, PY)
values ('ä∫', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('äª', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('äº', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('äΩ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('äæ', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('äø', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ä¬', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ä√', 'MU');
insert into HZPYDZB (HZ, PY)
values ('äƒ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ä≈', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('ä∆', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('ä∆', 'CU');
insert into HZPYDZB (HZ, PY)
values ('ä«', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ä«', 'TING');
commit;
prompt 300 records committed...
insert into HZPYDZB (HZ, PY)
values ('ä…', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('äÀ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('äÀ', 'PO');
insert into HZPYDZB (HZ, PY)
values ('äÃ', 'NEI');
insert into HZPYDZB (HZ, PY)
values ('äÃ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('äÕ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('äŒ', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ä–', 'PING');
insert into HZPYDZB (HZ, PY)
values ('ä—', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('ä“', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('ä”', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ä‘', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('ä’', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ä÷', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ä◊', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('äŸ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ä⁄', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ä€', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ä‹', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('ä›', 'QI');
insert into HZPYDZB (HZ, PY)
values ('äﬂ', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('ä·', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ä‚', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ä‚', 'E');
insert into HZPYDZB (HZ, PY)
values ('ä„', 'E');
insert into HZPYDZB (HZ, PY)
values ('ä‰', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('ä‰', 'LV');
insert into HZPYDZB (HZ, PY)
values ('äÂ', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('äÊ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('äÁ', 'POU');
insert into HZPYDZB (HZ, PY)
values ('äË', 'JU');
insert into HZPYDZB (HZ, PY)
values ('äÈ', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('äÍ', 'LING');
insert into HZPYDZB (HZ, PY)
values ('äÏ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('äÌ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('äÓ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('äÔ', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('äÔ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ä', 'WO');
insert into HZPYDZB (HZ, PY)
values ('äÒ', 'WO');
insert into HZPYDZB (HZ, PY)
values ('äÚ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('äÛ', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('äÙ', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('äı', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('äˆ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ä˜', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('ä¯', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ä˘', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ä˙', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ä˚', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('ä˝', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ä˛', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('ä˛', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ã@', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('ãB', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('ãB', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('ãC', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('ãC', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ãD', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ãF', 'AN');
insert into HZPYDZB (HZ, PY)
values ('ãG', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ãG', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('ãI', 'YA');
insert into HZPYDZB (HZ, PY)
values ('ãJ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ãK', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ãL', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('ãN', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ãO', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ãP', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('ãQ', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ãR', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('ãS', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('ãT', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ãU', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ãV', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ãX', 'DI');
insert into HZPYDZB (HZ, PY)
values ('ãX', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ãY', 'ROU');
insert into HZPYDZB (HZ, PY)
values ('ãZ', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('ã[', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ã\', 'NEN');
insert into HZPYDZB (HZ, PY)
values ('ã]', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('ã_', 'WO');
insert into HZPYDZB (HZ, PY)
values ('ãa', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('ãb', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('ãd', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ãe', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('ãf', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('ãg', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('ãh', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ãi', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('ãj', 'AN');
insert into HZPYDZB (HZ, PY)
values ('ãj', 'E');
insert into HZPYDZB (HZ, PY)
values ('ãk', 'YING');
insert into HZPYDZB (HZ, PY)
values ('ãl', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('ãm', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ãn', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ão', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('ãq', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ãs', 'DUO');
commit;
prompt 400 records committed...
insert into HZPYDZB (HZ, PY)
values ('ãt', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ãu', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('ãv', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('ãw', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ãy', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ãz', 'WA');
insert into HZPYDZB (HZ, PY)
values ('ã{', 'CU');
insert into HZPYDZB (HZ, PY)
values ('ã|', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ã}', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ã~', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('ãÅ', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('ãÅ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ãÇ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ãÉ', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ãÑ', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ãà', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('ãâ', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('ãã', 'WO');
insert into HZPYDZB (HZ, PY)
values ('ãã', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('ãå', 'MA');
insert into HZPYDZB (HZ, PY)
values ('ãç', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('ãç', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ãé', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('ãé', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ãè', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ãê', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('ãë', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ãë', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('ãí', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('ãì', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ãì', 'MING');
insert into HZPYDZB (HZ, PY)
values ('ãñ', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('ãó', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('ãò', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('ãò', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('ãô', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('ãö', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ãû', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('ã†', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('ã†', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('ã¢', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('ã§', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ã¶', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ãß', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('ã®', 'CE');
insert into HZPYDZB (HZ, PY)
values ('ã®', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('ã©', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ã©', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('ã™', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ã´', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ã¨', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ã≠', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ãØ', 'NEN');
insert into HZPYDZB (HZ, PY)
values ('ãØ', 'RUAN');
insert into HZPYDZB (HZ, PY)
values ('ã∞', 'MA');
insert into HZPYDZB (HZ, PY)
values ('ã≤', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ã¥', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ãµ', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ã∂', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('ã∑', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('ãπ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('ã∫', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ãª', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ãº', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ãΩ', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ãø', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('ã¿', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ã¬', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ã√', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ã∆', 'RAO');
insert into HZPYDZB (HZ, PY)
values ('ã…', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ã ', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('ãÃ', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ãÕ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ãŒ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ã–', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ã”', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ã‘', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('ã’', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ã÷', 'QIONG');
insert into HZPYDZB (HZ, PY)
values ('ãÿ', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('ãŸ', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('ã⁄', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ã€', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ã‹', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ã›', 'NIANG');
insert into HZPYDZB (HZ, PY)
values ('ãﬁ', 'NING');
insert into HZPYDZB (HZ, PY)
values ('ãﬂ', 'MA');
insert into HZPYDZB (HZ, PY)
values ('ã‡', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('ã·', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('ãÁ', 'NOU');
insert into HZPYDZB (HZ, PY)
values ('ãÁ', 'RU');
insert into HZPYDZB (HZ, PY)
values ('ãË', 'ER');
insert into HZPYDZB (HZ, PY)
values ('ãÎ', 'YING');
insert into HZPYDZB (HZ, PY)
values ('ãÏ', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ãÓ', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('ãÔ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ã', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ãÚ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ãÛ', 'DU');
commit;
prompt 500 records committed...
insert into HZPYDZB (HZ, PY)
values ('ãÙ', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('ãˆ', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ã˘', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ã˙', 'NIANG');
insert into HZPYDZB (HZ, PY)
values ('ã˙', 'RANG');
insert into HZPYDZB (HZ, PY)
values ('åD', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('åD', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('åF', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('åG', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('åH', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('åI', 'MA');
insert into HZPYDZB (HZ, PY)
values ('åI', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('åJ', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('åL', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('åN', 'NI');
insert into HZPYDZB (HZ, PY)
values ('åN', 'ZHUAN');
insert into HZPYDZB (HZ, PY)
values ('åO', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('åP', 'MIE');
insert into HZPYDZB (HZ, PY)
values ('åQ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('åR', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('åT', 'NI');
insert into HZPYDZB (HZ, PY)
values ('åV', 'LI');
insert into HZPYDZB (HZ, PY)
values ('åW', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('åW', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('åX', 'BO');
insert into HZPYDZB (HZ, PY)
values ('åY', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('åZ', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('å\', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('å]', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('å^', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('å^', 'QIONG');
insert into HZPYDZB (HZ, PY)
values ('å_', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('å_', 'TU');
insert into HZPYDZB (HZ, PY)
values ('å`', 'ROU');
insert into HZPYDZB (HZ, PY)
values ('åc', 'JING');
insert into HZPYDZB (HZ, PY)
values ('åd', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('åe', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('åf', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('åg', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('åi', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('åj', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('åk', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ål', 'QUN');
insert into HZPYDZB (HZ, PY)
values ('åm', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('åo', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('åp', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('år', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ås', 'MI');
insert into HZPYDZB (HZ, PY)
values ('åt', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('åx', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('åy', 'HE');
insert into HZPYDZB (HZ, PY)
values ('åz', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('å{', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('å~', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('åÄ', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('åÅ', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('åÇ', 'NING');
insert into HZPYDZB (HZ, PY)
values ('åÉ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('åÑ', 'NING');
insert into HZPYDZB (HZ, PY)
values ('åÖ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('åá', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('åà', 'KUAN');
insert into HZPYDZB (HZ, PY)
values ('åâ', 'NING');
insert into HZPYDZB (HZ, PY)
values ('åä', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('åã', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('åå', 'HU');
insert into HZPYDZB (HZ, PY)
values ('åé', 'NING');
insert into HZPYDZB (HZ, PY)
values ('åè', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('åê', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('åí', 'KUAN');
insert into HZPYDZB (HZ, PY)
values ('åó', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('åô', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('åö', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('åõ', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('åú', 'LUE');
insert into HZPYDZB (HZ, PY)
values ('åú', 'LV');
insert into HZPYDZB (HZ, PY)
values ('åù', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('åü', 'ZHUAN');
insert into HZPYDZB (HZ, PY)
values ('å†', 'BU');
insert into HZPYDZB (HZ, PY)
values ('å°', 'KE');
insert into HZPYDZB (HZ, PY)
values ('å°', 'KEI');
insert into HZPYDZB (HZ, PY)
values ('å¢', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('å£', 'ZHUAN');
insert into HZPYDZB (HZ, PY)
values ('å•', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('å®', 'JI');
insert into HZPYDZB (HZ, PY)
values ('å®', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('å©', 'ER');
insert into HZPYDZB (HZ, PY)
values ('å©', 'MI');
insert into HZPYDZB (HZ, PY)
values ('å™', 'ER');
insert into HZPYDZB (HZ, PY)
values ('å´', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('å¨', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('å≠', 'MA');
insert into HZPYDZB (HZ, PY)
values ('å≠', 'MO');
insert into HZPYDZB (HZ, PY)
values ('åÆ', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('å±', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('å≤', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('å≥', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('å≥', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('å¥', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('å¥', 'MENG');
commit;
prompt 600 records committed...
insert into HZPYDZB (HZ, PY)
values ('åµ', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('å∂', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('å∑', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('åπ', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('å∫', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('åª', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('åº', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('åΩ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('å¬', 'BI');
insert into HZPYDZB (HZ, PY)
values ('å√', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('åƒ', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('å≈', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('å«', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('å…', 'NI');
insert into HZPYDZB (HZ, PY)
values ('åÀ', 'UU');
insert into HZPYDZB (HZ, PY)
values ('åÕ', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('åŒ', 'PING');
insert into HZPYDZB (HZ, PY)
values ('åœ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('å–', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('å’', 'JU');
insert into HZPYDZB (HZ, PY)
values ('å÷', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('å◊', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('åÿ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('å€', 'JI');
insert into HZPYDZB (HZ, PY)
values ('å€', 'PO');
insert into HZPYDZB (HZ, PY)
values ('å‹', 'WA');
insert into HZPYDZB (HZ, PY)
values ('å›', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('åﬁ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('å‡', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('å·', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('å‚', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('å„', 'REN');
insert into HZPYDZB (HZ, PY)
values ('å‰', 'WU');
insert into HZPYDZB (HZ, PY)
values ('åÂ', 'AN');
insert into HZPYDZB (HZ, PY)
values ('åÂ', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('åÊ', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('åÁ', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('åÈ', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('åÍ', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('åÏ', 'ANG');
insert into HZPYDZB (HZ, PY)
values ('åÌ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('åÓ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('åÔ', 'E');
insert into HZPYDZB (HZ, PY)
values ('åÔ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('å', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('å', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('åÒ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('åÚ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('åÛ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('åÙ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('åˆ', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('å¯', 'JU');
insert into HZPYDZB (HZ, PY)
values ('å˘', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('å˚', 'PO');
insert into HZPYDZB (HZ, PY)
values ('å¸', 'LI');
insert into HZPYDZB (HZ, PY)
values ('å˝', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('å˛', 'QU');
insert into HZPYDZB (HZ, PY)
values ('çA', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('çC', 'AO');
insert into HZPYDZB (HZ, PY)
values ('çD', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('çE', 'QU');
insert into HZPYDZB (HZ, PY)
values ('çF', 'PO');
insert into HZPYDZB (HZ, PY)
values ('çG', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('çH', 'LING');
insert into HZPYDZB (HZ, PY)
values ('çI', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('çJ', 'PING');
insert into HZPYDZB (HZ, PY)
values ('çK', 'CEOM');
insert into HZPYDZB (HZ, PY)
values ('çL', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('çM', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('çO', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('çP', 'HE');
insert into HZPYDZB (HZ, PY)
values ('çQ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('çQ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('çR', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('çT', 'FU');
insert into HZPYDZB (HZ, PY)
values ('çT', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('çU', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('çW', 'EN');
insert into HZPYDZB (HZ, PY)
values ('çY', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('çZ', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('ç[', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ç\', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ç^', 'AN');
insert into HZPYDZB (HZ, PY)
values ('ç_', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ç`', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ça', 'MI');
insert into HZPYDZB (HZ, PY)
values ('çb', 'LI');
insert into HZPYDZB (HZ, PY)
values ('çc', 'JI');
insert into HZPYDZB (HZ, PY)
values ('çd', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('çd', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('çe', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('çg', 'GU');
insert into HZPYDZB (HZ, PY)
values ('çh', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('çj', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('çk', 'E');
insert into HZPYDZB (HZ, PY)
values ('çm', 'BU');
insert into HZPYDZB (HZ, PY)
values ('çn', 'QUN');
insert into HZPYDZB (HZ, PY)
values ('ço', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('çq', 'LI');
insert into HZPYDZB (HZ, PY)
values ('çr', 'YOU');
commit;
prompt 700 records committed...
insert into HZPYDZB (HZ, PY)
values ('çt', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('çv', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('çw', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('çy', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('çz', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('ç{', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('ç}', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ç}', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ç~', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('ç~', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('çÄ', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('çÇ', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('çÉ', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('çÑ', 'TA');
insert into HZPYDZB (HZ, PY)
values ('çÖ', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('çÜ', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('çá', 'JU');
insert into HZPYDZB (HZ, PY)
values ('çà', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('çâ', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('çä', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('çå', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('çç', 'GU');
insert into HZPYDZB (HZ, PY)
values ('çê', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('çë', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('çí', 'LING');
insert into HZPYDZB (HZ, PY)
values ('çì', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('çî', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('çï', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('çó', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('çò', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('çô', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('çö', 'BI');
insert into HZPYDZB (HZ, PY)
values ('çö', 'PI');
insert into HZPYDZB (HZ, PY)
values ('çõ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('çù', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('çü', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('ç¢', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ç£', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ç§', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('ç®', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ç´', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ç´', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ç¨', 'E');
insert into HZPYDZB (HZ, PY)
values ('ç≠', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('çÆ', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('çÆ', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('çØ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ç±', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('ç≤', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ç≥', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ç¥', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('çµ', 'TING');
insert into HZPYDZB (HZ, PY)
values ('çπ', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ç∫', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ç∫', 'KE');
insert into HZPYDZB (HZ, PY)
values ('çª', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('çΩ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ç¿', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('ç¡', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ç√', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ç√', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ç…', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('ç…', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('çÀ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('çÃ', 'AI');
insert into HZPYDZB (HZ, PY)
values ('çÃ', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('çÕ', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('çœ', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('ç–', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('ç—', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('ç‘', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ç◊', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('ç⁄', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ç€', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ç€', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ç‹', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('ç›', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ç‚', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('ç„', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ç‰', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('çÂ', 'AO');
insert into HZPYDZB (HZ, PY)
values ('çÊ', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('çÁ', 'QU');
insert into HZPYDZB (HZ, PY)
values ('çÈ', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('çÓ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ç', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('çÚ', 'CENG');
insert into HZPYDZB (HZ, PY)
values ('çÚ', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('çÛ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('çı', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ç˜', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ç˘', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ç˙', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ç˚', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ç¸', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ç˛', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('é@', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('é@', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('éB', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('éD', 'JUE');
commit;
prompt 800 records committed...
insert into HZPYDZB (HZ, PY)
values ('éE', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('éH', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('éK', 'YI');
insert into HZPYDZB (HZ, PY)
values ('éL', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('éN', 'JI');
insert into HZPYDZB (HZ, PY)
values ('éO', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('éP', 'KE');
insert into HZPYDZB (HZ, PY)
values ('éR', 'DI');
insert into HZPYDZB (HZ, PY)
values ('éS', 'AO');
insert into HZPYDZB (HZ, PY)
values ('éU', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('éV', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('éX', 'LING');
insert into HZPYDZB (HZ, PY)
values ('é]', 'RU');
insert into HZPYDZB (HZ, PY)
values ('é^', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('é`', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('éa', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('éb', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('ée', 'JU');
insert into HZPYDZB (HZ, PY)
values ('éh', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('éj', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ék', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('ém', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('én', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('éq', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('éu', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('éw', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('éw', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('éz', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('é{', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('éÅ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('éÇ', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('éÉ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('éÑ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('éÜ', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('éà', 'PO');
insert into HZPYDZB (HZ, PY)
values ('éâ', 'ZA');
insert into HZPYDZB (HZ, PY)
values ('éä', 'DING');
insert into HZPYDZB (HZ, PY)
values ('éã', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('éå', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('éç', 'PA');
insert into HZPYDZB (HZ, PY)
values ('éê', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('éë', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('éí', 'MO');
insert into HZPYDZB (HZ, PY)
values ('éí', 'WA');
insert into HZPYDZB (HZ, PY)
values ('éì', 'FU');
insert into HZPYDZB (HZ, PY)
values ('éî', 'MO');
insert into HZPYDZB (HZ, PY)
values ('éï', 'YI');
insert into HZPYDZB (HZ, PY)
values ('éñ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('éó', 'PING');
insert into HZPYDZB (HZ, PY)
values ('éò', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('éô', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('éö', 'RU');
insert into HZPYDZB (HZ, PY)
values ('éõ', 'SHUAI');
insert into HZPYDZB (HZ, PY)
values ('éú', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('éù', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('éû', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('éü', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('é¢', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('é£', 'PING');
insert into HZPYDZB (HZ, PY)
values ('é§', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('é¶', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('é®', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('é©', 'JI');
insert into HZPYDZB (HZ, PY)
values ('é©', 'QI');
insert into HZPYDZB (HZ, PY)
values ('é™', 'DU');
insert into HZPYDZB (HZ, PY)
values ('é´', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('é¨', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('éÆ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('éØ', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('é∞', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('é±', 'PING');
insert into HZPYDZB (HZ, PY)
values ('é≤', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('éµ', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('é∑', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('éπ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('éª', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('éª', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('éº', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('éæ', 'CE');
insert into HZPYDZB (HZ, PY)
values ('éø', 'MU');
insert into HZPYDZB (HZ, PY)
values ('é¿', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('é¡', 'JING');
insert into HZPYDZB (HZ, PY)
values ('é¬', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('éƒ', 'HU');
insert into HZPYDZB (HZ, PY)
values ('é≈', 'BI');
insert into HZPYDZB (HZ, PY)
values ('é∆', 'BI');
insert into HZPYDZB (HZ, PY)
values ('é«', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('é»', 'MI');
insert into HZPYDZB (HZ, PY)
values ('é…', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('é ', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('éÃ', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('éÕ', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('éŒ', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('éŒ', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('é–', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('é—', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('é”', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('é’', 'BING');
insert into HZPYDZB (HZ, PY)
values ('é÷', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('é◊', 'JI');
commit;
prompt 900 records committed...
insert into HZPYDZB (HZ, PY)
values ('éÿ', 'TING');
insert into HZPYDZB (HZ, PY)
values ('éŸ', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('é›', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('éﬂ', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('éﬂ', 'TING');
insert into HZPYDZB (HZ, PY)
values ('é‡', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('é„', 'CI');
insert into HZPYDZB (HZ, PY)
values ('é‰', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('éÊ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('éÎ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('éÔ', 'BU');
insert into HZPYDZB (HZ, PY)
values ('é', 'BING');
insert into HZPYDZB (HZ, PY)
values ('éÒ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('éÚ', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('éÛ', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('éÛ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('éı', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('é¯', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('é˚', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('é˝', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('é˛', 'E');
insert into HZPYDZB (HZ, PY)
values ('è@', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('è@', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('èA', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('èC', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('èE', 'BU');
insert into HZPYDZB (HZ, PY)
values ('èG', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('èH', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('èL', 'LU');
insert into HZPYDZB (HZ, PY)
values ('èM', 'YI');
insert into HZPYDZB (HZ, PY)
values ('èP', 'SI');
insert into HZPYDZB (HZ, PY)
values ('èS', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('èU', 'FA');
insert into HZPYDZB (HZ, PY)
values ('èU', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('èV', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('èV', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('èX', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('èY', 'BI');
insert into HZPYDZB (HZ, PY)
values ('èZ', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('è[', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('è[', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('è]', 'LU');
insert into HZPYDZB (HZ, PY)
values ('è]', 'LV');
insert into HZPYDZB (HZ, PY)
values ('è^', 'JI');
insert into HZPYDZB (HZ, PY)
values ('èc', 'LI');
insert into HZPYDZB (HZ, PY)
values ('èe', 'SHUN');
insert into HZPYDZB (HZ, PY)
values ('èf', 'DI');
insert into HZPYDZB (HZ, PY)
values ('èg', 'PO');
insert into HZPYDZB (HZ, PY)
values ('èh', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('èi', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('èk', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('èl', 'JU');
insert into HZPYDZB (HZ, PY)
values ('èm', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('èp', 'ER');
insert into HZPYDZB (HZ, PY)
values ('èq', 'SAN');
insert into HZPYDZB (HZ, PY)
values ('èr', 'ER');
insert into HZPYDZB (HZ, PY)
values ('èv', 'WU');
insert into HZPYDZB (HZ, PY)
values ('èw', 'TI');
insert into HZPYDZB (HZ, PY)
values ('èw', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('èx', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('èy', 'BA');
insert into HZPYDZB (HZ, PY)
values ('èz', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('è{', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('è|', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('è}', 'FU');
insert into HZPYDZB (HZ, PY)
values ('è~', 'DI');
insert into HZPYDZB (HZ, PY)
values ('èÄ', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('èÅ', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('èÉ', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('èÑ', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('èÖ', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('èÜ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('èá', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('èà', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('èâ', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('èä', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('èä', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('èã', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('èç', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('èé', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('èé', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('èè', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('èê', 'GE');
insert into HZPYDZB (HZ, PY)
values ('èí', 'BI');
insert into HZPYDZB (HZ, PY)
values ('èì', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('èî', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('èï', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('èó', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('èó', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('èò', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('èô', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('èõ', 'MI');
insert into HZPYDZB (HZ, PY)
values ('èõ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('èû', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('è†', 'LU');
insert into HZPYDZB (HZ, PY)
values ('è°', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('è¢', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('è£', 'YI');
insert into HZPYDZB (HZ, PY)
values ('è§', 'YI');
insert into HZPYDZB (HZ, PY)
values ('è•', 'YI');
commit;
prompt 1000 records committed...
insert into HZPYDZB (HZ, PY)
values ('è®', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('è©', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('è¨', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('èÆ', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('è∞', 'BO');
insert into HZPYDZB (HZ, PY)
values ('è∞', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('è±', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('è±', 'YI');
insert into HZPYDZB (HZ, PY)
values ('è≤', 'JI');
insert into HZPYDZB (HZ, PY)
values ('è≥', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('è¥', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('èµ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('è∂', 'LING');
insert into HZPYDZB (HZ, PY)
values ('è∑', 'FU');
insert into HZPYDZB (HZ, PY)
values ('è∏', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('èπ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('è∫', 'WA');
insert into HZPYDZB (HZ, PY)
values ('è∫', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('èª', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('èª', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('èº', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('èΩ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('èæ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('èø', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('è¿', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('è¡', 'UU');
insert into HZPYDZB (HZ, PY)
values ('è√', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('èƒ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('èƒ', 'ZONG');
insert into HZPYDZB (HZ, PY)
values ('è≈', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('è∆', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('è»', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('è…', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('è ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('èÀ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('èÕ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('èŒ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('èœ', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('èœ', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('è–', 'XI');
insert into HZPYDZB (HZ, PY)
values ('è“', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('è”', 'TI');
insert into HZPYDZB (HZ, PY)
values ('è‘', 'DE');
insert into HZPYDZB (HZ, PY)
values ('è’', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('è◊', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('è◊', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('èÿ', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('è⁄', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('è‹', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('èﬂ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('è‡', 'LE');
insert into HZPYDZB (HZ, PY)
values ('è‚', 'DING');
insert into HZPYDZB (HZ, PY)
values ('è‚', 'TING');
insert into HZPYDZB (HZ, PY)
values ('è„', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('è‰', 'REN');
insert into HZPYDZB (HZ, PY)
values ('èÂ', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('èÂ', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('èÊ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('èÁ', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('èÁ', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('èË', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('èË', 'XI');
insert into HZPYDZB (HZ, PY)
values ('èÈ', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('èÎ', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('èÎ', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('èÏ', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('èÌ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('èÓ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('èÔ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('è', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('è', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('èÒ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('èÚ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('èÛ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('èÛ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('èÙ', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('èı', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('èˆ', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('è˜', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('è˜', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('è¯', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('è¯', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('è˘', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('è˙', 'XIONG');
insert into HZPYDZB (HZ, PY)
values ('è˚', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('è˝', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('è˝', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('è˛', 'JU');
insert into HZPYDZB (HZ, PY)
values ('êA', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('êB', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('êB', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('êC', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('êD', 'JU');
insert into HZPYDZB (HZ, PY)
values ('êD', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('êE', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('êF', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('êG', 'TIE');
insert into HZPYDZB (HZ, PY)
values ('êG', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('êH', 'GU');
insert into HZPYDZB (HZ, PY)
values ('êH', 'HU');
commit;
prompt 1100 records committed...
insert into HZPYDZB (HZ, PY)
values ('êI', 'CU');
insert into HZPYDZB (HZ, PY)
values ('êJ', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('êK', 'DI');
insert into HZPYDZB (HZ, PY)
values ('êL', 'TU');
insert into HZPYDZB (HZ, PY)
values ('êN', 'FU');
insert into HZPYDZB (HZ, PY)
values ('êO', 'XI');
insert into HZPYDZB (HZ, PY)
values ('êP', 'BI');
insert into HZPYDZB (HZ, PY)
values ('êQ', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('êR', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('êS', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('êT', 'BING');
insert into HZPYDZB (HZ, PY)
values ('êU', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('êW', 'BI');
insert into HZPYDZB (HZ, PY)
values ('êW', 'PI');
insert into HZPYDZB (HZ, PY)
values ('êX', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ê\', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ê^', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ê_', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ê`', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('êa', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('êa', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('êb', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('êc', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('êd', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('êf', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('êf', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('êg', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('êh', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('êi', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('êi', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('êj', 'QI');
insert into HZPYDZB (HZ, PY)
values ('êj', 'XU');
insert into HZPYDZB (HZ, PY)
values ('êk', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('êl', 'SI');
insert into HZPYDZB (HZ, PY)
values ('êm', 'HU');
insert into HZPYDZB (HZ, PY)
values ('êm', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('ên', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('êo', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('êp', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('êq', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ês', 'GUAI');
insert into HZPYDZB (HZ, PY)
values ('êt', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('êu', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('êv', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('êw', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('êw', 'ZHUAN');
insert into HZPYDZB (HZ, PY)
values ('êy', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('êz', 'DE');
insert into HZPYDZB (HZ, PY)
values ('ê{', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ê}', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('ê~', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('êÄ', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('êÅ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('êÅ', 'PI');
insert into HZPYDZB (HZ, PY)
values ('êÇ', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('êÉ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('êÑ', 'TU');
insert into HZPYDZB (HZ, PY)
values ('êÑ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('êÖ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('êÖ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('êÜ', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('êá', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('êà', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('êà', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('êâ', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('êä', 'TI');
insert into HZPYDZB (HZ, PY)
values ('êã', 'BU');
insert into HZPYDZB (HZ, PY)
values ('êç', 'XI');
insert into HZPYDZB (HZ, PY)
values ('êé', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('êé', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('êê', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('êë', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('êì', 'LI');
insert into HZPYDZB (HZ, PY)
values ('êî', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('êî', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('êï', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('êó', 'LI');
insert into HZPYDZB (HZ, PY)
values ('êö', 'WU');
insert into HZPYDZB (HZ, PY)
values ('êõ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('êú', 'DE');
insert into HZPYDZB (HZ, PY)
values ('êü', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ê°', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('ê£', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('ê§', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ê•', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('ê¶', 'XI');
insert into HZPYDZB (HZ, PY)
values ('êß', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('ê®', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('ê©', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ê™', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('ê´', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('ê≠', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('êÆ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('êØ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ê∞', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ê∞', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ê≤', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ê≥', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ê≥', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('ê¥', 'DAN');
commit;
prompt 1200 records committed...
insert into HZPYDZB (HZ, PY)
values ('ê¥', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ê∑', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('ê∑', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('ê∏', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ê∏', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('êπ', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('ê∫', 'WU');
insert into HZPYDZB (HZ, PY)
values ('êª', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('êª', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('êΩ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ê¿', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ê¡', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('ê¬', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ê¬', 'TIE');
insert into HZPYDZB (HZ, PY)
values ('ê√', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('ê∆', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ê«', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ê…', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ê…', 'TI');
insert into HZPYDZB (HZ, PY)
values ('êÀ', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('êÃ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('êÕ', 'GE');
insert into HZPYDZB (HZ, PY)
values ('êŒ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('êœ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ê–', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('ê“', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('ê‘', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ê‘', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ê’', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('ê’', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ê÷', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('ê◊', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ê◊', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('êÿ', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('êŸ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('êŸ', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('ê⁄', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ê‹', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('ê›', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('êﬁ', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('ê‡', 'SAI');
insert into HZPYDZB (HZ, PY)
values ('ê‡', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ê„', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('ê„', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('êÂ', 'SU');
insert into HZPYDZB (HZ, PY)
values ('êÁ', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('êË', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('êÈ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('êÍ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('êÎ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('êÌ', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('êÓ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ê', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('êˆ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ê˜', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('ê¯', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ê˘', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ê¸', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ê˛', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('ëA', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ëB', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('ëC', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('ëC', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('ëD', 'MING');
insert into HZPYDZB (HZ, PY)
values ('ëF', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('ëF', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ëH', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ëJ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ëK', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ëL', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ëM', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ëN', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('ëO', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('ëP', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('ëR', 'AO');
insert into HZPYDZB (HZ, PY)
values ('ëS', 'SHUANG');
insert into HZPYDZB (HZ, PY)
values ('ëT', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('ëW', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ëX', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ëY', 'OU');
insert into HZPYDZB (HZ, PY)
values ('ë[', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ë[', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('ë]', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ë^', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('ë_', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('ë`', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('ëb', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('ëc', 'QING');
insert into HZPYDZB (HZ, PY)
values ('ëe', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ëf', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('ëf', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ëg', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ël', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ëm', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ëo', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('ër', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ës', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ët', 'QU');
insert into HZPYDZB (HZ, PY)
values ('ëu', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('ëx', 'JIAO');
commit;
prompt 1300 records committed...
insert into HZPYDZB (HZ, PY)
values ('ëy', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ëz', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ë}', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ë~', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('ëÇ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ëÉ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ëÑ', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ëÖ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ëÜ', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ëá', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('ëà', 'SU');
insert into HZPYDZB (HZ, PY)
values ('ëâ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ëä', 'CE');
insert into HZPYDZB (HZ, PY)
values ('ëã', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ëå', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ëé', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ëè', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ëí', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ëì', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ëî', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ëï', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ëñ', 'CU');
insert into HZPYDZB (HZ, PY)
values ('ëõ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ëù', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('ëû', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ëü', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ë†', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ë°', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('ë¢', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ë¢', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ë£', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ë§', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ëß', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ë®', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('ë®', 'SAO');
insert into HZPYDZB (HZ, PY)
values ('ë¨', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ëØ', 'HUAI');
insert into HZPYDZB (HZ, PY)
values ('ë∏', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ëπ', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ëπ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ë∫', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ëΩ', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ëæ', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ëø', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('ë¿', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('ë¬', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('ë≈', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ë ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ëœ', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ë—', 'HUAI');
insert into HZPYDZB (HZ, PY)
values ('ë”', 'RANG');
insert into HZPYDZB (HZ, PY)
values ('ë‘', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ë’', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ë◊', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('ë◊', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ëÿ', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('ëŸ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ë⁄', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('ë€', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ë€', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ë›', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ëﬁ', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('ë‡', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('ë·', 'GE');
insert into HZPYDZB (HZ, PY)
values ('ë‚', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ë‚', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ë„', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('ëÂ', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('ëÊ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ëÁ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ëË', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ëÎ', 'GE');
insert into HZPYDZB (HZ, PY)
values ('ëÔ', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ëÒ', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ëÚ', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ëÛ', 'QU');
insert into HZPYDZB (HZ, PY)
values ('ë¯', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ë˘', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('ë˚', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('í@', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('íA', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('íB', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('íC', 'RU');
insert into HZPYDZB (HZ, PY)
values ('íE', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('íF', 'DI');
insert into HZPYDZB (HZ, PY)
values ('íG', 'WU');
insert into HZPYDZB (HZ, PY)
values ('íG', 'YU');
insert into HZPYDZB (HZ, PY)
values ('íH', 'KU');
insert into HZPYDZB (HZ, PY)
values ('íH', 'WU');
insert into HZPYDZB (HZ, PY)
values ('íI', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('íI', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('íJ', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('íK', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('íK', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('íL', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('íL', 'YI');
insert into HZPYDZB (HZ, PY)
values ('íM', 'GU');
insert into HZPYDZB (HZ, PY)
values ('íN', 'WU');
insert into HZPYDZB (HZ, PY)
values ('íP', 'REN');
insert into HZPYDZB (HZ, PY)
values ('íQ', 'CHA');
commit;
prompt 1400 records committed...
insert into HZPYDZB (HZ, PY)
values ('íR', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('íR', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('íS', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('íT', 'YU');
insert into HZPYDZB (HZ, PY)
values ('íU', 'AO');
insert into HZPYDZB (HZ, PY)
values ('íV', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('íW', 'QI');
insert into HZPYDZB (HZ, PY)
values ('íW', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('íX', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('íX', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('íY', 'DEN');
insert into HZPYDZB (HZ, PY)
values ('í[', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('í[', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('í\', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('í]', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('í]', 'JU');
insert into HZPYDZB (HZ, PY)
values ('í^', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('í_', 'GU');
insert into HZPYDZB (HZ, PY)
values ('í_', 'HU');
insert into HZPYDZB (HZ, PY)
values ('í`', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('ía', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('íb', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('íb', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('íc', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('íd', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('íe', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('íf', 'NA');
insert into HZPYDZB (HZ, PY)
values ('íg', 'POU');
insert into HZPYDZB (HZ, PY)
values ('íh', 'FU');
insert into HZPYDZB (HZ, PY)
values ('íh', 'POU');
insert into HZPYDZB (HZ, PY)
values ('íi', 'BA');
insert into HZPYDZB (HZ, PY)
values ('íj', 'AO');
insert into HZPYDZB (HZ, PY)
values ('íj', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('ík', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('íl', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('ím', 'BING');
insert into HZPYDZB (HZ, PY)
values ('ín', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('ín', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ío', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('íp', 'PU');
insert into HZPYDZB (HZ, PY)
values ('íq', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('íq', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ír', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ít', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('íu', 'HE');
insert into HZPYDZB (HZ, PY)
values ('íu', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('ív', 'NI');
insert into HZPYDZB (HZ, PY)
values ('íw', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('íw', 'YE');
insert into HZPYDZB (HZ, PY)
values ('íx', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('íy', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('íy', 'PI');
insert into HZPYDZB (HZ, PY)
values ('í{', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('í|', 'QU');
insert into HZPYDZB (HZ, PY)
values ('í}', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('í~', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('í~', 'YA');
insert into HZPYDZB (HZ, PY)
values ('íÅ', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('íÇ', 'NA');
insert into HZPYDZB (HZ, PY)
values ('íÉ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('íÑ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('íÑ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('íÖ', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('íÜ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('íá', 'JU');
insert into HZPYDZB (HZ, PY)
values ('íâ', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('íã', 'HEN');
insert into HZPYDZB (HZ, PY)
values ('íå', 'NIN');
insert into HZPYDZB (HZ, PY)
values ('íé', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('íè', 'YI');
insert into HZPYDZB (HZ, PY)
values ('íë', 'SE');
insert into HZPYDZB (HZ, PY)
values ('íí', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('íî', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('íî', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('íï', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('íï', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('íó', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('íò', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('íô', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('íö', 'GE');
insert into HZPYDZB (HZ, PY)
values ('íö', 'HE');
insert into HZPYDZB (HZ, PY)
values ('íõ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('íú', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('íù', 'RU');
insert into HZPYDZB (HZ, PY)
values ('íû', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('íü', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('í†', 'LU');
insert into HZPYDZB (HZ, PY)
values ('í°', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('í¢', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('í£', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('í•', 'YA');
insert into HZPYDZB (HZ, PY)
values ('íß', 'YU');
insert into HZPYDZB (HZ, PY)
values ('í®', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('í®', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('í©', 'BO');
insert into HZPYDZB (HZ, PY)
values ('í™', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('í´', 'TI');
insert into HZPYDZB (HZ, PY)
values ('í¨', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('í≠', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('í≠', 'SUO');
commit;
prompt 1500 records committed...
insert into HZPYDZB (HZ, PY)
values ('íÆ', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('í∞', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('í±', 'JU');
insert into HZPYDZB (HZ, PY)
values ('í≤', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('í¥', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('íµ', 'RUA');
insert into HZPYDZB (HZ, PY)
values ('í∂', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('í∑', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('í∏', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('íπ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('íπ', 'KU');
insert into HZPYDZB (HZ, PY)
values ('í∫', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('íª', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('íª', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('íº', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('íº', 'TU');
insert into HZPYDZB (HZ, PY)
values ('íΩ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('íΩ', 'POU');
insert into HZPYDZB (HZ, PY)
values ('íø', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('í¡', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('í¬', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('í√', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('í≈', 'ZHUAI');
insert into HZPYDZB (HZ, PY)
values ('í∆', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('í«', 'LU');
insert into HZPYDZB (HZ, PY)
values ('í»', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('í…', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('í…', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('í ', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('íÀ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('íÃ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('íÕ', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('íŒ', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('íœ', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('í—', 'FU');
insert into HZPYDZB (HZ, PY)
values ('í“', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('í”', 'WO');
insert into HZPYDZB (HZ, PY)
values ('í‘', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('í’', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('í÷', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('í◊', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('íÿ', 'TU');
insert into HZPYDZB (HZ, PY)
values ('íŸ', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('í⁄', 'WO');
insert into HZPYDZB (HZ, PY)
values ('í€', 'SU');
insert into HZPYDZB (HZ, PY)
values ('í‹', 'WO');
insert into HZPYDZB (HZ, PY)
values ('í›', 'QI');
insert into HZPYDZB (HZ, PY)
values ('í‡', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('í‚', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('í„', 'DI');
insert into HZPYDZB (HZ, PY)
values ('íÂ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('íÊ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('íÁ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('íË', 'LING');
insert into HZPYDZB (HZ, PY)
values ('íÍ', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('íÏ', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('íÌ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('íÌ', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('íÓ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('íÔ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('í', 'DING');
insert into HZPYDZB (HZ, PY)
values ('í', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('íÒ', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('íÚ', 'BING');
insert into HZPYDZB (HZ, PY)
values ('íÛ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('íÙ', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('íı', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('í˜', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('í¯', 'MING');
insert into HZPYDZB (HZ, PY)
values ('í˘', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('í˙', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('í¸', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('í˝', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('ì@', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('ì@', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('ìA', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ìB', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ìD', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('ìF', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('ìF', 'PI');
insert into HZPYDZB (HZ, PY)
values ('ìG', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ìH', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('ìH', 'SAI');
insert into HZPYDZB (HZ, PY)
values ('ìI', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ìK', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('ìL', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ìN', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ìO', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ìP', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('ìT', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ìT', 'XU');
insert into HZPYDZB (HZ, PY)
values ('ìU', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ìV', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ìW', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ìX', 'LA');
insert into HZPYDZB (HZ, PY)
values ('ìY', 'LA');
insert into HZPYDZB (HZ, PY)
values ('ìZ', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ì[', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ì\', 'TU');
insert into HZPYDZB (HZ, PY)
values ('ì^', 'GEN');
commit;
prompt 1600 records committed...
insert into HZPYDZB (HZ, PY)
values ('ì_', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('ì_', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('ìa', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ìb', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ìc', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('ìe', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ìh', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('ìh', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ìj', 'GEN');
insert into HZPYDZB (HZ, PY)
values ('ìk', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('ìm', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('ìn', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ìp', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('ìr', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('ìs', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('ìt', 'E');
insert into HZPYDZB (HZ, PY)
values ('ìt', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ìu', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ìx', 'NOU');
insert into HZPYDZB (HZ, PY)
values ('ìy', 'LA');
insert into HZPYDZB (HZ, PY)
values ('ìz', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('ì|', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ì}', 'MIE');
insert into HZPYDZB (HZ, PY)
values ('ì~', 'E');
insert into HZPYDZB (HZ, PY)
values ('ì~', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ìÄ', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('ìÅ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ìÇ', 'DA');
insert into HZPYDZB (HZ, PY)
values ('ìÇ', 'TA');
insert into HZPYDZB (HZ, PY)
values ('ìÉ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ìÑ', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('ìÖ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ìÜ', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('ìá', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ìá', 'KU');
insert into HZPYDZB (HZ, PY)
values ('ìà', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('ìä', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ìã', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('ìå', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ìç', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ìç', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ìé', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ìè', 'E');
insert into HZPYDZB (HZ, PY)
values ('ìê', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('ìë', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('ìí', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('ìì', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ìî', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ìï', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('ìò', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ìô', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('ìö', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ìö', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ìõ', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('ìû', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('ìü', 'TU');
insert into HZPYDZB (HZ, PY)
values ('ìü', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ì†', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('ì°', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('ì°', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('ì¢', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ì£', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ì¶', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ìß', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('ì™', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ì™', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ìÆ', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ìØ', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('ìØ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ì∞', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ì±', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ì≥', 'AO');
insert into HZPYDZB (HZ, PY)
values ('ì≥', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('ì¥', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ìµ', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('ìµ', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ì∂', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('ì∑', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ì∑', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ì∏', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('ì∏', 'OU');
insert into HZPYDZB (HZ, PY)
values ('ìπ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ìπ', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ì∫', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ìº', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('ìº', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ìΩ', 'SEN');
insert into HZPYDZB (HZ, PY)
values ('ìæ', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('ìø', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ìø', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('ì¿', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ì¬', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('ì≈', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('ì∆', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ì…', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('ìŒ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ìœ', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ì–', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ì—', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('ì“', 'TA');
commit;
prompt 1700 records committed...
insert into HZPYDZB (HZ, PY)
values ('ì”', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('ì‘', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ì’', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ì’', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('ì◊', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ìÿ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ì⁄', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ì⁄', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ì€', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ìﬁ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ìﬂ', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('ì·', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ì‚', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('ì„', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ì‰', 'BU');
insert into HZPYDZB (HZ, PY)
values ('ì‰', 'PU');
insert into HZPYDZB (HZ, PY)
values ('ìÊ', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('ìÁ', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ìË', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ìÍ', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('ìÎ', 'WO');
insert into HZPYDZB (HZ, PY)
values ('ìÏ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ìÌ', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('ìÓ', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('ìÔ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ìÒ', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('ìÒ', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('ìÚ', 'BU');
insert into HZPYDZB (HZ, PY)
values ('ìÚ', 'PU');
insert into HZPYDZB (HZ, PY)
values ('ìÛ', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('ì˜', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ì˜', 'QING');
insert into HZPYDZB (HZ, PY)
values ('ì˘', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('ì˙', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ì¸', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ì˝', 'AO');
insert into HZPYDZB (HZ, PY)
values ('ì˛', 'JU');
insert into HZPYDZB (HZ, PY)
values ('îB', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('îC', 'MI');
insert into HZPYDZB (HZ, PY)
values ('îD', 'JI');
insert into HZPYDZB (HZ, PY)
values ('îJ', 'RU');
insert into HZPYDZB (HZ, PY)
values ('îM', 'NI');
insert into HZPYDZB (HZ, PY)
values ('îN', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('îO', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('îR', 'GE');
insert into HZPYDZB (HZ, PY)
values ('îU', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('îU', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('îV', 'MI');
insert into HZPYDZB (HZ, PY)
values ('îV', 'MO');
insert into HZPYDZB (HZ, PY)
values ('îY', 'LA');
insert into HZPYDZB (HZ, PY)
values ('îY', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('î[', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('î^', 'LI');
insert into HZPYDZB (HZ, PY)
values ('î^', 'LUE');
insert into HZPYDZB (HZ, PY)
values ('î`', 'TI');
insert into HZPYDZB (HZ, PY)
values ('î`', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('îb', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('îc', 'CA');
insert into HZPYDZB (HZ, PY)
values ('îd', 'LU');
insert into HZPYDZB (HZ, PY)
values ('îe', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('îf', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('îh', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('îj', 'LA');
insert into HZPYDZB (HZ, PY)
values ('îj', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('îm', 'LU');
insert into HZPYDZB (HZ, PY)
values ('îm', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('în', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('îs', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('îu', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('îv', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('îx', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('îz', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('îz', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('î{', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('î|', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('î}', 'MI');
insert into HZPYDZB (HZ, PY)
values ('î}', 'MO');
insert into HZPYDZB (HZ, PY)
values ('îÄ', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('îÅ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('îÅ', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('îÇ', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('îÉ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('îá', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('îà', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('îâ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('îä', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('îã', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('îå', 'JI');
insert into HZPYDZB (HZ, PY)
values ('îé', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('îê', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('îê', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('îë', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('îí', 'PO');
insert into HZPYDZB (HZ, PY)
values ('îì', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('îî', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('îï', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('îñ', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('ÅB', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('ÅC', 'MYEON');
insert into HZPYDZB (HZ, PY)
values ('ÅE', 'CHOU');
commit;
prompt 1800 records committed...
insert into HZPYDZB (HZ, PY)
values ('ÅF', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ÅG', 'DIU');
insert into HZPYDZB (HZ, PY)
values ('ÅH', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('ÅK', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('ÅQ', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('ÅR', 'HA');
insert into HZPYDZB (HZ, PY)
values ('ÅS', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ÅS', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ÅT', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ÅU', 'I');
insert into HZPYDZB (HZ, PY)
values ('ÅU', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÅV', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÅX', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ÅY', 'HO');
insert into HZPYDZB (HZ, PY)
values ('ÅZ', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('Å[', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Å_', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('Å`', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('Åb', 'HOL');
insert into HZPYDZB (HZ, PY)
values ('Åd', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Åe', 'KEG');
insert into HZPYDZB (HZ, PY)
values ('Åe', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('Åg', 'KEOL');
insert into HZPYDZB (HZ, PY)
values ('Åh', 'TOL');
insert into HZPYDZB (HZ, PY)
values ('Åi', 'MOL');
insert into HZPYDZB (HZ, PY)
values ('Åj', 'OL');
insert into HZPYDZB (HZ, PY)
values ('Åk', 'CAL');
insert into HZPYDZB (HZ, PY)
values ('Åp', 'NA');
insert into HZPYDZB (HZ, PY)
values ('Åq', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('Åq', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('År', 'SOL');
insert into HZPYDZB (HZ, PY)
values ('Åu', 'CEOR');
insert into HZPYDZB (HZ, PY)
values ('Åv', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('Åw', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('Åy', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('Åz', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Å|', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Å}', 'MA');
insert into HZPYDZB (HZ, PY)
values ('Å~', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Å~', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÅÅ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ÅÇ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ÅÑ', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÅÜ', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÅÜ', 'YA');
insert into HZPYDZB (HZ, PY)
values ('Åá', 'DA');
insert into HZPYDZB (HZ, PY)
values ('Åä', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Åç', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Åé', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('Åê', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('Åì', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Åì', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Åî', 'BA');
insert into HZPYDZB (HZ, PY)
values ('Åñ', 'FO');
insert into HZPYDZB (HZ, PY)
values ('Åó', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Åô', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('Åö', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('Åõ', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('Åú', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('Åú', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Å†', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('Å¢', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('Å£', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('Å£', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('Å§', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Å§', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('Å•', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Å¶', 'FO');
insert into HZPYDZB (HZ, PY)
values ('Åß', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('Å©', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Å™', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Å´', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('Å¨', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('ÅØ', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('Å∞', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Å±', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Å≤', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Å≤', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('Å≥', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('Å≥', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Å¥', 'AI');
insert into HZPYDZB (HZ, PY)
values ('Åµ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Åµ', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('Å∂', 'PI');
insert into HZPYDZB (HZ, PY)
values ('Å∑', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('Å∑', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('Å∏', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Åπ', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Å∫', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('Åª', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('Åº', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('Åº', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ÅΩ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('ÅΩ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('Åø', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('Å¿', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('Å¬', 'NU');
insert into HZPYDZB (HZ, PY)
values ('Å√', 'NI');
insert into HZPYDZB (HZ, PY)
values ('Åƒ', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('Å≈', 'XU');
commit;
prompt 1900 records committed...
insert into HZPYDZB (HZ, PY)
values ('Å∆', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('Å«', 'QU');
insert into HZPYDZB (HZ, PY)
values ('Å«', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('Å»', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('Å…', 'PI');
insert into HZPYDZB (HZ, PY)
values ('Å ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÅÀ', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ÅÀ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ÅÃ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÅÕ', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('ÅŒ', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ÅŒ', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Åœ', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('Å–', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Å“', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('Å“', 'QU');
insert into HZPYDZB (HZ, PY)
values ('Å”', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Å‘', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('Å‘', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('Å’', 'CI');
insert into HZPYDZB (HZ, PY)
values ('Å÷', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('Å◊', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Åÿ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Å⁄', 'QU');
insert into HZPYDZB (HZ, PY)
values ('Å€', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Å‹', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Å›', 'HUAI');
insert into HZPYDZB (HZ, PY)
values ('Å›', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Åﬁ', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Åﬁ', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Åﬂ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('Å‡', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Å‚', 'MING');
insert into HZPYDZB (HZ, PY)
values ('Å„', 'BING');
insert into HZPYDZB (HZ, PY)
values ('Å‰', 'HEN');
insert into HZPYDZB (HZ, PY)
values ('Å‰', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('ÅÂ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ÅÊ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ÅÁ', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('ÅÍ', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ÅÎ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ÅÏ', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('ÅÓ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÅÔ', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('ÅÚ', 'XU');
insert into HZPYDZB (HZ, PY)
values ('ÅÛ', 'AN');
insert into HZPYDZB (HZ, PY)
values ('ÅÙ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Åˆ', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('Å˜', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('Å˘', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('Å˚', 'RU');
insert into HZPYDZB (HZ, PY)
values ('Å¸', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('Å˝', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Å˛', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('Ç@', 'TA');
insert into HZPYDZB (HZ, PY)
values ('ÇA', 'NING');
insert into HZPYDZB (HZ, PY)
values ('ÇB', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ÇC', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('ÇD', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ÇD', 'TING');
insert into HZPYDZB (HZ, PY)
values ('ÇE', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ÇG', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('ÇH', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ÇI', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ÇJ', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('ÇJ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ÇK', 'TING');
insert into HZPYDZB (HZ, PY)
values ('ÇL', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ÇM', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('ÇM', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ÇN', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ÇO', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('ÇQ', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('ÇS', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ÇT', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ÇU', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('ÇV', 'KU');
insert into HZPYDZB (HZ, PY)
values ('ÇW', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ÇX', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÇY', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ÇZ', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('Ç[', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('Ç\', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Ç\', 'YING');
insert into HZPYDZB (HZ, PY)
values ('Ç]', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('Ç^', 'SAN');
insert into HZPYDZB (HZ, PY)
values ('Ç_', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('Ç`', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Ça', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Çb', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('Çd', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Çe', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('Çe', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Çf', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Çg', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('Çh', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Çi', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('Çk', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Çl', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Çm', 'CHU');
commit;
prompt 2000 records committed...
insert into HZPYDZB (HZ, PY)
values ('Çn', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Çs', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Çs', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Çt', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('Çu', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Çw', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('Çy', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('Çy', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('Çz', 'LIA');
insert into HZPYDZB (HZ, PY)
values ('Çz', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('Ç{', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÇÄ', 'GE');
insert into HZPYDZB (HZ, PY)
values ('ÇÅ', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ÇÉ', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('ÇÑ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ÇÑ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ÇÖ', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('ÇÖ', 'ZHUI');
insert into HZPYDZB (HZ, PY)
values ('Çá', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('Çá', 'PING');
insert into HZPYDZB (HZ, PY)
values ('Çà', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Çâ', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('Çä', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Çä', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('Çã', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('Çå', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Çå', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('Çç', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('Çé', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Çè', 'ZONG');
insert into HZPYDZB (HZ, PY)
values ('Çê', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('Çë', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('Çí', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Çì', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('Çñ', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('Çó', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Çò', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Çô', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('Çö', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('Çù', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('Çû', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('Çü', 'YING');
insert into HZPYDZB (HZ, PY)
values ('Ç°', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ç°', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('Ç£', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('Ç§', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('Ç•', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Ç¶', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Çß', 'BING');
insert into HZPYDZB (HZ, PY)
values ('Ç®', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Ç©', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('Ç™', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('Ç´', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('Ç´', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ç¨', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Ç≠', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÇÆ', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('ÇØ', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('Ç∞', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('Ç±', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Çµ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('Ç∑', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('Ç∏', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('Ç∏', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('Çª', 'XU');
insert into HZPYDZB (HZ, PY)
values ('ÇΩ', 'CI');
insert into HZPYDZB (HZ, PY)
values ('Çæ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Çø', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Çø', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Ç¿', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Ç¡', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('Ç¬', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Çƒ', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('Ç≈', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('Ç∆', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Ç«', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('Ç»', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('Ç»', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('Ç…', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ÇÕ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ÇŒ', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÇŒ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('Çœ', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('Ç—', 'SU');
insert into HZPYDZB (HZ, PY)
values ('Ç”', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('Ç‘', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('Ç’', 'NU');
insert into HZPYDZB (HZ, PY)
values ('Ç◊', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('Ç◊', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Çÿ', 'MA');
insert into HZPYDZB (HZ, PY)
values ('ÇŸ', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('Ç⁄', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ç€', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('Ç‹', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ç›', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Çﬁ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('Çﬂ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Çﬂ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('Ç‡', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ç‡', 'QUE');
commit;
prompt 2100 records committed...
insert into HZPYDZB (HZ, PY)
values ('ÇÊ', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('ÇÁ', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ÇË', 'TA');
insert into HZPYDZB (HZ, PY)
values ('ÇË', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ÇÈ', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('ÇÏ', 'BING');
insert into HZPYDZB (HZ, PY)
values ('ÇÌ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ÇÌ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('ÇÔ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Ç', 'SAN');
insert into HZPYDZB (HZ, PY)
values ('ÇÒ', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('ÇÚ', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('ÇÛ', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('Çı', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('Çı', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('Ç˜', 'ZHUAN');
insert into HZPYDZB (HZ, PY)
values ('Ç˘', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('Ç˚', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('Ç¸', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('Ç˝', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Ç˛', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('É@', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('ÉA', 'QING');
insert into HZPYDZB (HZ, PY)
values ('ÉD', 'SU');
insert into HZPYDZB (HZ, PY)
values ('ÉD', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('ÉE', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('ÉE', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('ÉG', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ÉH', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ÉI', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ÉJ', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ÉJ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ÉK', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('ÉN', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ÉR', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ÉT', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('ÉU', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('ÉV', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('ÉV', 'ZUN');
insert into HZPYDZB (HZ, PY)
values ('ÉW', 'PU');
insert into HZPYDZB (HZ, PY)
values ('ÉY', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('ÉZ', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('É\', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('É\', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('É]', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('É^', 'E');
insert into HZPYDZB (HZ, PY)
values ('É^', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('É`', 'BO');
insert into HZPYDZB (HZ, PY)
values ('Éa', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Éb', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('Éb', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('Éc', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Éc', 'TIE');
insert into HZPYDZB (HZ, PY)
values ('Éd', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Éd', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('Ée', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ée', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('Éh', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Éj', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Éo', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('Éq', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ér', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Ér', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('És', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('Éw', 'SAI');
insert into HZPYDZB (HZ, PY)
values ('Éx', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Éz', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('É{', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('É|', 'YI');
insert into HZPYDZB (HZ, PY)
values ('É~', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('ÉÅ', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ÉÇ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ÉÖ', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ÉÜ', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('Éà', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('Éâ', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('Éâ', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('Éã', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('Éå', 'NI');
insert into HZPYDZB (HZ, PY)
values ('Éå', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Éê', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Éë', 'NING');
insert into HZPYDZB (HZ, PY)
values ('Éí', 'QIONG');
insert into HZPYDZB (HZ, PY)
values ('Éï', 'LA');
insert into HZPYDZB (HZ, PY)
values ('Éï', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('Éñ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('Éò', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Éö', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Éü', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('É°', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('É¢', 'LI');
insert into HZPYDZB (HZ, PY)
values ('É•', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('É¶', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('Éß', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('É™', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('É´', 'LI');
insert into HZPYDZB (HZ, PY)
values ('É¨', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ÉÆ', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('ÉØ', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('É±', 'LEI');
commit;
prompt 2200 records committed...
insert into HZPYDZB (HZ, PY)
values ('É±', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('É≤', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('Éµ', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('É∂', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('É∑', 'TU');
insert into HZPYDZB (HZ, PY)
values ('É∏', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('Éª', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Éæ', 'SHIKE');
insert into HZPYDZB (HZ, PY)
values ('É¬', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('É√', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('Éƒ', 'BAIKE');
insert into HZPYDZB (HZ, PY)
values ('É≈', 'GONGLI');
insert into HZPYDZB (HZ, PY)
values ('É∆', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('É«', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('É«', 'WU');
insert into HZPYDZB (HZ, PY)
values ('É»', 'NEI');
insert into HZPYDZB (HZ, PY)
values ('É…', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('É ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('É ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ÉŒ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Éœ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('É–', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('É”', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('É‘', 'CE');
insert into HZPYDZB (HZ, PY)
values ('É’', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('É◊', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('Éÿ', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('É⁄', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('É‹', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('É‹', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('É›', 'HEM');
insert into HZPYDZB (HZ, PY)
values ('É›', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('Éﬁ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Éﬂ', 'MI');
insert into HZPYDZB (HZ, PY)
values ('É·', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('É‚', 'JU');
insert into HZPYDZB (HZ, PY)
values ('É„', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('É‰', 'LEM');
insert into HZPYDZB (HZ, PY)
values ('É‰', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('ÉÂ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ÉÁ', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ÉË', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('ÉÈ', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('ÉÎ', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('ÉÌ', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('ÉÓ', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('ÉÔ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('É', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('ÉÚ', 'TU');
insert into HZPYDZB (HZ, PY)
values ('ÉÛ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ÉÙ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Éı', 'QING');
insert into HZPYDZB (HZ, PY)
values ('É˜', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('É¯', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('É˘', 'AI');
insert into HZPYDZB (HZ, PY)
values ('É˙', 'LI');
insert into HZPYDZB (HZ, PY)
values ('É¸', 'MING');
insert into HZPYDZB (HZ, PY)
values ('É˝', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('É˛', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('Ñ@', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ÑB', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ÑC', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ÑE', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('ÑF', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ÑG', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ÑH', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ÑI', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ÑJ', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('ÑK', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('ÑL', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ÑM', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÑN', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('ÑO', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('ÑP', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('ÑQ', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ÑS', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('ÑT', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ÑW', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÑX', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('ÑY', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('ÑZ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ñ[', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('Ñ\', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Ñ]', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ñ^', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ñ_', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Ñ`', 'QU');
insert into HZPYDZB (HZ, PY)
values ('Ña', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('Ñb', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('Ñc', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Ñd', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('Ñe', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('Ñf', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ñg', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ñh', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('Ñi', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Ñj', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('Ñk', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('Ñl', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Ñm', 'DUO');
commit;
prompt 2300 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ñn', 'ER');
insert into HZPYDZB (HZ, PY)
values ('Ño', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ñp', 'CI');
insert into HZPYDZB (HZ, PY)
values ('Ñr', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('Ñs', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('Ñt', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('Ñu', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('Ñv', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('Ñw', 'KE');
insert into HZPYDZB (HZ, PY)
values ('Ñw', 'KEI');
insert into HZPYDZB (HZ, PY)
values ('Ñx', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('Ñx', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('Ñy', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('Ñz', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('Ñ{', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ñ|', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Ñ}', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Ñ~', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ÑÄ', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('ÑÇ', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('ÑÉ', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('ÑÉ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ÑÑ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ÑÑ', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ÑÖ', 'LUE');
insert into HZPYDZB (HZ, PY)
values ('ÑÖ', 'QING');
insert into HZPYDZB (HZ, PY)
values ('Ñä', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('Ñã', 'DU');
insert into HZPYDZB (HZ, PY)
values ('Ñã', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('Ñå', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('Ñå', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Ñè', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('Ñë', 'DA');
insert into HZPYDZB (HZ, PY)
values ('Ñí', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('Ñì', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('Ñî', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('Ñï', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Ñó', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('Ñò', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ñô', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('Ñú', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('Ñù', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('Ñ†', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('Ñ°', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Ñ¢', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Ñ£', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('Ñ§', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('Ñ§', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ñ•', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('Ñ®', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ñ©', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÑØ', 'MI');
insert into HZPYDZB (HZ, PY)
values ('Ñ∞', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ñ≥', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ñ≥', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Ñ¥', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('Ñµ', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('Ñµ', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('Ñ∏', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Ñπ', 'MO');
insert into HZPYDZB (HZ, PY)
values ('Ñª', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('Ñº', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('Ñæ', 'WA');
insert into HZPYDZB (HZ, PY)
values ('Ñø', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('Ñ¡', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('Ñ¬', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ñ√', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('Ñƒ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('Ñƒ', 'KEI');
insert into HZPYDZB (HZ, PY)
values ('Ñ≈', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ñ∆', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('Ñ«', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('Ñ»', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Ñ…', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('ÑÀ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ÑÀ', 'KEI');
insert into HZPYDZB (HZ, PY)
values ('ÑÃ', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ÑÕ', 'QING');
insert into HZPYDZB (HZ, PY)
values ('ÑŒ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Ñœ', 'BU');
insert into HZPYDZB (HZ, PY)
values ('Ñ—', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('Ñ“', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('Ñ’', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('Ñ◊', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('ÑŸ', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('Ñ€', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Ñﬂ', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ñ‡', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('Ñ‡', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ñ‰', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ÑÂ', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ÑÊ', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ÑÁ', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('ÑË', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ÑÈ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ÑÍ', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('ÑÌ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ÑÓ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ÑÔ', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('ÑÚ', 'JUN');
commit;
prompt 2400 records committed...
insert into HZPYDZB (HZ, PY)
values ('ÑÚ', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('ÑÛ', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('Ñı', 'MANGMI');
insert into HZPYDZB (HZ, PY)
values ('Ñˆ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Ñ˜', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('Ñ¯', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('Ñ˚', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Ñ¸', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ñ¸', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('Ñ˝', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Ö@', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('ÖB', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ÖC', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('ÖD', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ÖE', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ÖG', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ÖH', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('ÖI', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ÖJ', 'QU');
insert into HZPYDZB (HZ, PY)
values ('ÖK', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ÖM', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('ÖN', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('ÖO', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ÖQ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ÖR', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ÖU', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ÖV', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ÖW', 'SUAN');
insert into HZPYDZB (HZ, PY)
values ('ÖX', 'DU');
insert into HZPYDZB (HZ, PY)
values ('ÖY', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ÖZ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ö\', 'AN');
insert into HZPYDZB (HZ, PY)
values ('Ö\', 'KE');
insert into HZPYDZB (HZ, PY)
values ('Ö^', 'OU');
insert into HZPYDZB (HZ, PY)
values ('Ö`', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('Öa', 'CU');
insert into HZPYDZB (HZ, PY)
values ('Öd', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Öe', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Öf', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('Ög', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('Öh', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Öh', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Öi', 'LV');
insert into HZPYDZB (HZ, PY)
values ('Öj', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('Öj', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('Öm', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Öm', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('Ön', 'ANG');
insert into HZPYDZB (HZ, PY)
values ('Öo', 'QIONG');
insert into HZPYDZB (HZ, PY)
values ('Öp', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('Öq', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Ös', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Öt', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Öu', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Öv', 'E');
insert into HZPYDZB (HZ, PY)
values ('Öy', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Öz', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('Öz', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('Ö{', 'AN');
insert into HZPYDZB (HZ, PY)
values ('Ö{', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Ö}', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Ö~', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('ÖÄ', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('ÖÄ', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('ÖÅ', 'AES');
insert into HZPYDZB (HZ, PY)
values ('ÖÉ', 'YA');
insert into HZPYDZB (HZ, PY)
values ('ÖÑ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÖÖ', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('ÖÜ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Öá', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('Öà', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Öä', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Öã', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Öé', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('Öè', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Öê', 'AO');
insert into HZPYDZB (HZ, PY)
values ('Öî', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('Öï', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('Öö', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('Öö', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('Öõ', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Öõ', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('Öú', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('Öú', 'ROU');
insert into HZPYDZB (HZ, PY)
values ('Öù', 'QU');
insert into HZPYDZB (HZ, PY)
values ('Öû', 'KEUM');
insert into HZPYDZB (HZ, PY)
values ('Öü', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('Ö†', 'DU');
insert into HZPYDZB (HZ, PY)
values ('Ö°', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Ö¢', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('Ö¢', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('Ö£', 'SAN');
insert into HZPYDZB (HZ, PY)
values ('Ö§', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('Ö§', 'CEN');
insert into HZPYDZB (HZ, PY)
values ('Ö•', 'AI');
insert into HZPYDZB (HZ, PY)
values ('Öß', 'SHOU');
insert into HZPYDZB (HZ, PY)
values ('Ö™', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('Ö¨', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Ö≠', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('ÖØ', 'JI');
commit;
prompt 2500 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ö∞', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Ö±', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('Ö≤', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('Ö≥', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('Ö¥', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('Ö∑', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('Ö∏', 'MIE');
insert into HZPYDZB (HZ, PY)
values ('Ö∫', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('Öª', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Öª', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('Öº', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('Öº', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('Öæ', 'OU');
insert into HZPYDZB (HZ, PY)
values ('Öø', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('Ö¿', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Ö¡', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('Ö√', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Ö√', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Öƒ', 'POU');
insert into HZPYDZB (HZ, PY)
values ('Ö≈', 'E');
insert into HZPYDZB (HZ, PY)
values ('Ö∆', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('Ö«', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Ö»', 'NA');
insert into HZPYDZB (HZ, PY)
values ('Ö…', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('Ö…', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ö ', 'RU');
insert into HZPYDZB (HZ, PY)
values ('ÖÀ', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ÖÕ', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('ÖŒ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('Öœ', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Ö–', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Ö—', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Ö“', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Ö”', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ö’', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Ö÷', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('Ö◊', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('Öÿ', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('ÖŸ', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ÖŸ', 'E');
insert into HZPYDZB (HZ, PY)
values ('Ö⁄', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Ö€', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('Ö‹', 'PEN');
insert into HZPYDZB (HZ, PY)
values ('Ö›', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('Ö›', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Öﬁ', 'M');
insert into HZPYDZB (HZ, PY)
values ('Öﬁ', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('Öﬂ', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('Ö‡', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Ö·', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Ö„', 'TIE');
insert into HZPYDZB (HZ, PY)
values ('Ö‰', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ÖÊ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ÖÁ', 'PING');
insert into HZPYDZB (HZ, PY)
values ('ÖË', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('ÖÈ', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('ÖÈ', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('ÖÍ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ÖÍ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÖÎ', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('ÖÏ', 'TA');
insert into HZPYDZB (HZ, PY)
values ('ÖÏ', 'YA');
insert into HZPYDZB (HZ, PY)
values ('ÖÌ', 'QU');
insert into HZPYDZB (HZ, PY)
values ('ÖÓ', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ÖÓ', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ÖÔ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Ö', 'POU');
insert into HZPYDZB (HZ, PY)
values ('ÖÒ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ÖÒ', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('ÖÛ', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('ÖÙ', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Öı', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('Öı', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('Öˆ', 'DA');
insert into HZPYDZB (HZ, PY)
values ('Ö˜', 'WA');
insert into HZPYDZB (HZ, PY)
values ('Ö¯', 'ZO');
insert into HZPYDZB (HZ, PY)
values ('Ö¯', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('Ö˘', 'BU');
insert into HZPYDZB (HZ, PY)
values ('Ö˙', 'TA');
insert into HZPYDZB (HZ, PY)
values ('Ö˝', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Ö˛', 'ER');
insert into HZPYDZB (HZ, PY)
values ('Ü@', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÜA', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ÜA', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÜB', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('ÜC', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ÜE', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('ÜF', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('ÜG', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('ÜG', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('ÜH', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÜJ', 'WAI');
insert into HZPYDZB (HZ, PY)
values ('ÜK', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ÜL', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('ÜM', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ÜN', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('ÜO', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ÜP', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('ÜS', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('ÜT', 'YUAN');
commit;
prompt 2600 records committed...
insert into HZPYDZB (HZ, PY)
values ('ÜU', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('ÜV', 'DEO');
insert into HZPYDZB (HZ, PY)
values ('ÜV', 'POU');
insert into HZPYDZB (HZ, PY)
values ('ÜY', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Ü[', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('Ü\', 'PO');
insert into HZPYDZB (HZ, PY)
values ('Ü]', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('Ü^', 'BA');
insert into HZPYDZB (HZ, PY)
values ('Ü_', 'MIE');
insert into HZPYDZB (HZ, PY)
values ('Ü`', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('Ü`', 'LV');
insert into HZPYDZB (HZ, PY)
values ('Üa', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('Üb', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Üd', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('Üe', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('Üf', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Üg', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Üh', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('Üh', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('Üi', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Üj', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Ük', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Ül', 'TU');
insert into HZPYDZB (HZ, PY)
values ('Üm', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('Ün', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Üo', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Üp', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('Üs', 'E');
insert into HZPYDZB (HZ, PY)
values ('Üt', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('Üv', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Üw', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('Üy', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('Üy', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('Üz', 'TEO');
insert into HZPYDZB (HZ, PY)
values ('Ü}', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('Ü~', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('ÜÅ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ÜÅ', 'WO');
insert into HZPYDZB (HZ, PY)
values ('ÜÇ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ÜÉ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ÜÑ', 'ER');
insert into HZPYDZB (HZ, PY)
values ('ÜÑ', 'WA');
insert into HZPYDZB (HZ, PY)
values ('ÜÖ', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('ÜÜ', 'AN');
insert into HZPYDZB (HZ, PY)
values ('Üá', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Üá', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('Üà', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('Üà', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('Üâ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Üä', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('Üç', 'AI');
insert into HZPYDZB (HZ, PY)
values ('Üé', 'NOU');
insert into HZPYDZB (HZ, PY)
values ('Üè', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('Üè', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('Üê', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Üë', 'E');
insert into HZPYDZB (HZ, PY)
values ('Üë', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('Üí', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('Üì', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('Üî', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('Üñ', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Üó', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Üò', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Üô', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Üõ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('Üú', 'WA');
insert into HZPYDZB (HZ, PY)
values ('Üù', 'CI');
insert into HZPYDZB (HZ, PY)
values ('Üû', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Üû', 'TU');
insert into HZPYDZB (HZ, PY)
values ('Üü', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('Ü†', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Ü°', 'E');
insert into HZPYDZB (HZ, PY)
values ('Ü¢', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Ü£', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('Ü¶', 'QING');
insert into HZPYDZB (HZ, PY)
values ('Ü®', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('Ü©', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('Ü™', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('Ü´', 'NGAM');
insert into HZPYDZB (HZ, PY)
values ('Ü≠', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ü≠', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('ÜÆ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ü≤', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('Ü≥', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Ü¥', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('Ü∂', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('Ü∑', 'WAI');
insert into HZPYDZB (HZ, PY)
values ('Ü∏', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Üª', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('Üº', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Üæ', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('Üø', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Üø', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('Ü¿', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ü¡', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('Ü¡', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('Ü¬', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Üƒ', 'XU');
insert into HZPYDZB (HZ, PY)
values ('Ü≈', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('Ü∆', 'ZHA');
commit;
prompt 2700 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ü«', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('Ü…', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ÜÀ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ÜÀ', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('ÜÃ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ÜÃ', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('Üœ', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('Ü–', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('Ü“', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Ü÷', 'GIB');
insert into HZPYDZB (HZ, PY)
values ('Ü◊', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('Üÿ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Ü⁄', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('Ü‹', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('Ü›', 'SE');
insert into HZPYDZB (HZ, PY)
values ('Üﬂ', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('Üﬂ', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ÜÂ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ÜÂ', 'WA');
insert into HZPYDZB (HZ, PY)
values ('ÜÁ', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('ÜÁ', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('ÜÍ', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('ÜÎ', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ÜÎ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ÜÏ', 'WA');
insert into HZPYDZB (HZ, PY)
values ('ÜÌ', 'JIALUN');
insert into HZPYDZB (HZ, PY)
values ('ÜÓ', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('ÜÔ', 'CIS');
insert into HZPYDZB (HZ, PY)
values ('ÜÚ', 'NA');
insert into HZPYDZB (HZ, PY)
values ('Üı', 'AO');
insert into HZPYDZB (HZ, PY)
values ('Ü˜', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('Ü¯', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('Ü¯', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Ü˘', 'MO');
insert into HZPYDZB (HZ, PY)
values ('Ü˚', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ü˝', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('Ü˝', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ü˛', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Ü˛', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('áB', 'AI');
insert into HZPYDZB (HZ, PY)
values ('áD', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('áE', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('áF', 'HU');
insert into HZPYDZB (HZ, PY)
values ('áI', 'OU');
insert into HZPYDZB (HZ, PY)
values ('áK', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('áN', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('áN', 'DE');
insert into HZPYDZB (HZ, PY)
values ('áO', 'MA');
insert into HZPYDZB (HZ, PY)
values ('áP', 'HU');
insert into HZPYDZB (HZ, PY)
values ('áQ', 'GA');
insert into HZPYDZB (HZ, PY)
values ('áR', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('áS', 'GE');
insert into HZPYDZB (HZ, PY)
values ('áU', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('áW', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('áX', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('áY', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('áZ', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('á[', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('á_', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('á`', 'FU');
insert into HZPYDZB (HZ, PY)
values ('á`', 'M');
insert into HZPYDZB (HZ, PY)
values ('áa', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('áb', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('áb', 'SHOU');
insert into HZPYDZB (HZ, PY)
values ('ád', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('áf', 'E');
insert into HZPYDZB (HZ, PY)
values ('áf', 'WO');
insert into HZPYDZB (HZ, PY)
values ('áh', 'BO');
insert into HZPYDZB (HZ, PY)
values ('áh', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ák', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ál', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('ám', 'CU');
insert into HZPYDZB (HZ, PY)
values ('ám', 'HE');
insert into HZPYDZB (HZ, PY)
values ('án', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('áo', 'YU');
insert into HZPYDZB (HZ, PY)
values ('áp', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('áp', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('ár', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ás', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('áu', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('áu', 'XU');
insert into HZPYDZB (HZ, PY)
values ('áv', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('áy', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('á~', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('á~', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('áÄ', 'DU');
insert into HZPYDZB (HZ, PY)
values ('áÅ', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('áÅ', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('áÇ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('áÑ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('áÑ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('áà', 'GUAI');
insert into HZPYDZB (HZ, PY)
values ('áâ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('áä', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('áå', 'HEN');
insert into HZPYDZB (HZ, PY)
values ('áì', 'NING');
insert into HZPYDZB (HZ, PY)
values ('áî', 'DI');
insert into HZPYDZB (HZ, PY)
values ('áï', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('áó', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('áó', 'WO');
commit;
prompt 2800 records committed...
insert into HZPYDZB (HZ, PY)
values ('áò', 'HE');
insert into HZPYDZB (HZ, PY)
values ('áò', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('áú', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('áù', 'JI');
insert into HZPYDZB (HZ, PY)
values ('áû', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('á°', 'ME');
insert into HZPYDZB (HZ, PY)
values ('á¢', 'TI');
insert into HZPYDZB (HZ, PY)
values ('á£', 'LU');
insert into HZPYDZB (HZ, PY)
values ('á•', 'BO');
insert into HZPYDZB (HZ, PY)
values ('áß', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('á™', 'ME');
insert into HZPYDZB (HZ, PY)
values ('á™', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('á´', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('á¨', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('á≠', 'LI');
insert into HZPYDZB (HZ, PY)
values ('áÆ', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('á±', 'MO');
insert into HZPYDZB (HZ, PY)
values ('á≥', 'LI');
insert into HZPYDZB (HZ, PY)
values ('á¥', 'LU');
insert into HZPYDZB (HZ, PY)
values ('áµ', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('á∂', 'MO');
insert into HZPYDZB (HZ, PY)
values ('áº', 'ME');
insert into HZPYDZB (HZ, PY)
values ('áæ', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('áø', 'KU');
insert into HZPYDZB (HZ, PY)
values ('áƒ', 'LA');
insert into HZPYDZB (HZ, PY)
values ('á«', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('á»', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('áÀ', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('áÀ', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('áœ', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('á”', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('á÷', 'HEUI');
insert into HZPYDZB (HZ, PY)
values ('áŸ', 'E');
insert into HZPYDZB (HZ, PY)
values ('áŸ', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('á€', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('á‹', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('áﬂ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('á·', 'NIN');
insert into HZPYDZB (HZ, PY)
values ('á‚', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('á„', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('áÂ', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('áÁ', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('áË', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('áÈ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('áÎ', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('áÏ', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('áÌ', 'TU');
insert into HZPYDZB (HZ, PY)
values ('áÔ', 'QUN');
insert into HZPYDZB (HZ, PY)
values ('á', 'RI');
insert into HZPYDZB (HZ, PY)
values ('áÚ', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('áı', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('á˘', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('á˘', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('á¸', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('á¸', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('á˝', 'KU');
insert into HZPYDZB (HZ, PY)
values ('à@', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('àA', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('àC', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('àD', 'TU');
insert into HZPYDZB (HZ, PY)
values ('àG', 'LUE');
insert into HZPYDZB (HZ, PY)
values ('àJ', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('àL', 'YA');
insert into HZPYDZB (HZ, PY)
values ('àM', 'TU');
insert into HZPYDZB (HZ, PY)
values ('àN', 'TING');
insert into HZPYDZB (HZ, PY)
values ('àO', 'PU');
insert into HZPYDZB (HZ, PY)
values ('àP', 'LU');
insert into HZPYDZB (HZ, PY)
values ('àQ', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('àR', 'JU');
insert into HZPYDZB (HZ, PY)
values ('àS', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('àT', 'SU');
insert into HZPYDZB (HZ, PY)
values ('àU', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('àU', 'SU');
insert into HZPYDZB (HZ, PY)
values ('àV', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('àW', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('àX', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('àY', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('àZ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('à[', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('à\', 'MO');
insert into HZPYDZB (HZ, PY)
values ('à]', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('à^', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('à`', 'YI');
insert into HZPYDZB (HZ, PY)
values ('àa', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('àb', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('àb', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('àc', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('àc', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('àd', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('àe', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('àf', 'BI');
insert into HZPYDZB (HZ, PY)
values ('àg', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ài', 'JING');
insert into HZPYDZB (HZ, PY)
values ('àj', 'JI');
insert into HZPYDZB (HZ, PY)
values ('àk', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('àk', 'DI');
insert into HZPYDZB (HZ, PY)
values ('àl', 'JING');
insert into HZPYDZB (HZ, PY)
values ('àm', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('àm', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('ào', 'QU');
commit;
prompt 2900 records committed...
insert into HZPYDZB (HZ, PY)
values ('àp', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('àp', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('àq', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('àr', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('às', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('àt', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('àv', 'LU');
insert into HZPYDZB (HZ, PY)
values ('àw', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('àx', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('àz', 'BA');
insert into HZPYDZB (HZ, PY)
values ('à{', 'LING');
insert into HZPYDZB (HZ, PY)
values ('à|', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('à}', 'FU');
insert into HZPYDZB (HZ, PY)
values ('à~', 'HU');
insert into HZPYDZB (HZ, PY)
values ('àÄ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('àÅ', 'AO');
insert into HZPYDZB (HZ, PY)
values ('àÇ', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('àÇ', 'TAE');
insert into HZPYDZB (HZ, PY)
values ('àÉ', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('àÑ', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('àÖ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('àÜ', 'HE');
insert into HZPYDZB (HZ, PY)
values ('àá', 'LV');
insert into HZPYDZB (HZ, PY)
values ('àà', 'CI');
insert into HZPYDZB (HZ, PY)
values ('àâ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('àã', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('àç', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('àé', 'FU');
insert into HZPYDZB (HZ, PY)
values ('àè', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('àê', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('àë', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('àí', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('àì', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('àî', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('àñ', 'SHOU');
insert into HZPYDZB (HZ, PY)
values ('àó', 'BING');
insert into HZPYDZB (HZ, PY)
values ('àò', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('àô', 'DA');
insert into HZPYDZB (HZ, PY)
values ('àö', 'KA');
insert into HZPYDZB (HZ, PY)
values ('àõ', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('àú', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('àù', 'AN');
insert into HZPYDZB (HZ, PY)
values ('àû', 'XING');
insert into HZPYDZB (HZ, PY)
values ('à†', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('à°', 'POU');
insert into HZPYDZB (HZ, PY)
values ('à¢', 'BA');
insert into HZPYDZB (HZ, PY)
values ('à¢', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('à£', 'YI');
insert into HZPYDZB (HZ, PY)
values ('à•', 'AN');
insert into HZPYDZB (HZ, PY)
values ('à•', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('à¶', 'XU');
insert into HZPYDZB (HZ, PY)
values ('àß', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('à®', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('à©', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('à™', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('à´', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('à´', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('à¨', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('à≠', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('àÆ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('àÆ', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('à∞', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('à±', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('à≤', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('à≥', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('à¥', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('àµ', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('à∂', 'BU');
insert into HZPYDZB (HZ, PY)
values ('à∑', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('àπ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('à∫', 'E');
insert into HZPYDZB (HZ, PY)
values ('àª', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('àº', 'SU');
insert into HZPYDZB (HZ, PY)
values ('àº', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('àΩ', 'QING');
insert into HZPYDZB (HZ, PY)
values ('àΩ', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('àæ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('àø', 'JU');
insert into HZPYDZB (HZ, PY)
values ('à¿', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('à¡', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('à¡', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('à¬', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('à√', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('à≈', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('à∆', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('à«', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('à…', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('à ', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('àÃ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('àÕ', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('àŒ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('àœ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('à–', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('à–', 'NI');
insert into HZPYDZB (HZ, PY)
values ('à—', 'KE');
insert into HZPYDZB (HZ, PY)
values ('à“', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('à”', 'NI');
insert into HZPYDZB (HZ, PY)
values ('à’', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('à÷', 'YU');
insert into HZPYDZB (HZ, PY)
values ('∏p', 'BING');
commit;
prompt 3000 records committed...
insert into HZPYDZB (HZ, PY)
values ('∏q', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('∏s', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('∏t', 'JING');
insert into HZPYDZB (HZ, PY)
values ('∏t', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('∏u', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('∏v', 'YI');
insert into HZPYDZB (HZ, PY)
values ('∏w', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('∏x', 'JING');
insert into HZPYDZB (HZ, PY)
values ('∏y', 'QU');
insert into HZPYDZB (HZ, PY)
values ('∏{', 'LI');
insert into HZPYDZB (HZ, PY)
values ('∏}', 'CENG');
insert into HZPYDZB (HZ, PY)
values ('∏~', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('∏Ä', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('∏Ç', 'JING');
insert into HZPYDZB (HZ, PY)
values ('∏É', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('∏Ö', 'LE');
insert into HZPYDZB (HZ, PY)
values ('∏Ü', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('∏á', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('∏à', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('∏â', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∏â', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('∏ä', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('∏ã', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('∏å', 'SUAN');
insert into HZPYDZB (HZ, PY)
values ('∏ç', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('∏è', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('∏ê', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('∏ë', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('∏í', 'CEN');
insert into HZPYDZB (HZ, PY)
values ('∏ì', 'BI');
insert into HZPYDZB (HZ, PY)
values ('∏ì', 'PI');
insert into HZPYDZB (HZ, PY)
values ('∏ï', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('∏ñ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('∏ò', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('∏ö', 'GU');
insert into HZPYDZB (HZ, PY)
values ('∏õ', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('∏ú', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('∏ù', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('∏ü', 'FA');
insert into HZPYDZB (HZ, PY)
values ('∏†', 'LING');
insert into HZPYDZB (HZ, PY)
values ('∏°', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏¢', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏¢', 'POU');
insert into HZPYDZB (HZ, PY)
values ('∏£', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏§', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏•', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏¶', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏¶', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∏ß', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏®', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏©', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏™', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏´', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏¨', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏¨', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∏≠', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏Æ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏Ø', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏∞', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏±', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏≤', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏≥', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏¥', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏µ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏∂', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏∑', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏∏', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏π', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏∫', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏ª', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏º', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏Ω', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏æ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏ø', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏¿', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏¡', 'GA');
insert into HZPYDZB (HZ, PY)
values ('∏¡', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏¬', 'GA');
insert into HZPYDZB (HZ, PY)
values ('∏√', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('∏ƒ', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('∏≈', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('∏∆', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('∏«', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('∏»', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('∏…', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∏ ', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∏À', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∏Ã', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∏Õ', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∏Œ', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∏œ', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∏–', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∏—', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∏“', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∏”', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∏‘', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('∏’', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('∏÷', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('∏◊', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('∏ÿ', 'GANG');
commit;
prompt 3100 records committed...
insert into HZPYDZB (HZ, PY)
values ('∏Ÿ', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('∏⁄', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('∏€', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('∏‹', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('∏›', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('∏ﬁ', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('∏ﬂ', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('∏‡', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('∏·', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('∏‚', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('∏„', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('∏‰', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('∏‰', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∏Â', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('∏Ê', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('∏Á', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏Ë', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏È', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏Í', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏Î', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏Ï', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏Ì', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏Ó', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏Ô', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏Ò', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏Ú', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏Ú', 'HA');
insert into HZPYDZB (HZ, PY)
values ('∏Û', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏Ù', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏ı', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏ı', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('∏ˆ', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏˜', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∏¯', 'GEI');
insert into HZPYDZB (HZ, PY)
values ('∏¯', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∏˘', 'GEN');
insert into HZPYDZB (HZ, PY)
values ('∏˙', 'GEN');
insert into HZPYDZB (HZ, PY)
values ('∏˚', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('∏¸', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('∏˝', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('∏˛', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('π@', 'NU');
insert into HZPYDZB (HZ, PY)
values ('πA', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('πA', 'FU');
insert into HZPYDZB (HZ, PY)
values ('πB', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('πC', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('πD', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('πE', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('πF', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('πG', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('πG', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('πH', 'QIONG');
insert into HZPYDZB (HZ, PY)
values ('πI', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('πJ', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('πK', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πL', 'QU');
insert into HZPYDZB (HZ, PY)
values ('πM', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('πN', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('πO', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('πP', 'BI');
insert into HZPYDZB (HZ, PY)
values ('πR', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('πS', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('πS', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('πT', 'RU');
insert into HZPYDZB (HZ, PY)
values ('πU', 'JI');
insert into HZPYDZB (HZ, PY)
values ('πW', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('πX', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('πY', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('π[', 'FU');
insert into HZPYDZB (HZ, PY)
values ('π\', 'TU');
insert into HZPYDZB (HZ, PY)
values ('π]', 'LI');
insert into HZPYDZB (HZ, PY)
values ('π^', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('π_', 'JU');
insert into HZPYDZB (HZ, PY)
values ('π`', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('πb', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('πc', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('πc', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('πf', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('πh', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('πi', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('πj', 'TING');
insert into HZPYDZB (HZ, PY)
values ('πl', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('πm', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('πn', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('πp', 'O');
insert into HZPYDZB (HZ, PY)
values ('πq', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('πr', 'POU');
insert into HZPYDZB (HZ, PY)
values ('πr', 'PU');
insert into HZPYDZB (HZ, PY)
values ('πs', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('πt', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('πt', 'BI');
insert into HZPYDZB (HZ, PY)
values ('πu', 'PAI');
insert into HZPYDZB (HZ, PY)
values ('πv', 'BI');
insert into HZPYDZB (HZ, PY)
values ('πw', 'GE');
insert into HZPYDZB (HZ, PY)
values ('πx', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('πy', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('πy', 'GUAI');
insert into HZPYDZB (HZ, PY)
values ('π{', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('π|', 'DAO');
commit;
prompt 3200 records committed...
insert into HZPYDZB (HZ, PY)
values ('π}', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('π}', 'HU');
insert into HZPYDZB (HZ, PY)
values ('π~', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('πÅ', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('πÇ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('πÉ', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('πÑ', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('πÑ', 'QUN');
insert into HZPYDZB (HZ, PY)
values ('πÖ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('πá', 'GU');
insert into HZPYDZB (HZ, PY)
values ('πà', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('πâ', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('πä', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('πç', 'BO');
insert into HZPYDZB (HZ, PY)
values ('πè', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('πî', 'HU');
insert into HZPYDZB (HZ, PY)
values ('πñ', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('πó', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('πò', 'LV');
insert into HZPYDZB (HZ, PY)
values ('πõ', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('πú', 'JI');
insert into HZPYDZB (HZ, PY)
values ('πù', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('πü', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('π°', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('π¢', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('π£', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('π§', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('π•', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('π¶', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('πß', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('π®', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('π©', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('π™', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('π´', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('π¨', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('π≠', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('πÆ', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('πØ', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('π∞', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('π±', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('π≤', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('π¥', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('πµ', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('π∂', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('π∑', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('π∏', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('ππ', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('π∫', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('πª', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('πº', 'GU');
insert into HZPYDZB (HZ, PY)
values ('πΩ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('πæ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('πø', 'GU');
insert into HZPYDZB (HZ, PY)
values ('π¿', 'GU');
insert into HZPYDZB (HZ, PY)
values ('π¡', 'GU');
insert into HZPYDZB (HZ, PY)
values ('π¬', 'GU');
insert into HZPYDZB (HZ, PY)
values ('π√', 'GU');
insert into HZPYDZB (HZ, PY)
values ('πƒ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('π≈', 'GU');
insert into HZPYDZB (HZ, PY)
values ('π∆', 'GU');
insert into HZPYDZB (HZ, PY)
values ('π«', 'GU');
insert into HZPYDZB (HZ, PY)
values ('π»', 'GU');
insert into HZPYDZB (HZ, PY)
values ('π…', 'GU');
insert into HZPYDZB (HZ, PY)
values ('π ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('πÀ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('πÃ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('πÕ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('πŒ', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('πœ', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('π–', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('π—', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('π“', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('π”', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('π‘', 'GUAI');
insert into HZPYDZB (HZ, PY)
values ('π’', 'GUAI');
insert into HZPYDZB (HZ, PY)
values ('π÷', 'GUAI');
insert into HZPYDZB (HZ, PY)
values ('π◊', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('πÿ', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('πŸ', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('π⁄', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('π€', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('π‹', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('π›', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('πﬁ', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('πﬂ', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('π‡', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('π·', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('π‚', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('π„', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('π‰', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('πÂ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πÊ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πÁ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πË', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πÈ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πÍ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πÎ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πÏ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πÌ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πÓ', 'GUI');
commit;
prompt 3300 records committed...
insert into HZPYDZB (HZ, PY)
values ('πÔ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('π', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πÒ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πÚ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πÛ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πÙ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('πı', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('πˆ', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('π˜', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('π¯', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('π˘', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('π˙', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('π˚', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('π˝', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('π˛', 'HA');
insert into HZPYDZB (HZ, PY)
values ('π˛', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫@', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('∫@', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('∫F', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('∫G', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('∫H', 'GU');
insert into HZPYDZB (HZ, PY)
values ('∫K', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫L', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('∫O', 'NA');
insert into HZPYDZB (HZ, PY)
values ('∫O', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('∫P', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('∫Q', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('∫R', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('∫S', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('∫T', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('∫U', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('∫V', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∫W', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('∫X', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('∫]', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('∫_', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('∫b', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('∫d', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('∫d', 'CEN');
insert into HZPYDZB (HZ, PY)
values ('∫e', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('∫j', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('∫n', 'HU');
insert into HZPYDZB (HZ, PY)
values ('∫o', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('∫p', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('∫t', 'JU');
insert into HZPYDZB (HZ, PY)
values ('∫v', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('∫w', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('∫x', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('∫|', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('∫}', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('∫~', 'BO');
insert into HZPYDZB (HZ, PY)
values ('∫Ä', 'MI');
insert into HZPYDZB (HZ, PY)
values ('∫Å', 'SI');
insert into HZPYDZB (HZ, PY)
values ('∫Ç', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('∫á', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('∫à', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('∫å', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('∫ç', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('∫é', 'LU');
insert into HZPYDZB (HZ, PY)
values ('∫ê', 'ZAN');
insert into HZPYDZB (HZ, PY)
values ('∫ì', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∫ï', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∫ñ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('∫ó', 'LU');
insert into HZPYDZB (HZ, PY)
values ('∫ò', 'LU');
insert into HZPYDZB (HZ, PY)
values ('∫ú', 'KE');
insert into HZPYDZB (HZ, PY)
values ('∫°', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('∫¢', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('∫£', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('∫§', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('∫•', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('∫¶', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('∫ß', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('∫®', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫©', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫™', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫´', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫¨', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫≠', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫Æ', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫Ø', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫∞', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫±', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫≤', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫≥', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫¥', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫µ', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫∂', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫∑', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫∏', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫π', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫∫', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∫ª', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('∫º', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('∫Ω', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('∫æ', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∫ø', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∫¿', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∫¡', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∫¬', 'HAO');
commit;
prompt 3400 records committed...
insert into HZPYDZB (HZ, PY)
values ('∫√', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∫ƒ', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∫≈', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∫∆', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∫«', 'A');
insert into HZPYDZB (HZ, PY)
values ('∫»', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫…', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫ ', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫À', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫À', 'HU');
insert into HZPYDZB (HZ, PY)
values ('∫Ã', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫Õ', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫Õ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('∫Œ', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫œ', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫–', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫—', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∫“', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫”', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫‘', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫’', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('∫÷', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫◊', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫ÿ', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∫Ÿ', 'HEI');
insert into HZPYDZB (HZ, PY)
values ('∫⁄', 'HEI');
insert into HZPYDZB (HZ, PY)
values ('∫€', 'HEN');
insert into HZPYDZB (HZ, PY)
values ('∫‹', 'HEN');
insert into HZPYDZB (HZ, PY)
values ('∫›', 'HEN');
insert into HZPYDZB (HZ, PY)
values ('∫ﬁ', 'HEN');
insert into HZPYDZB (HZ, PY)
values ('∫ﬂ', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('∫‡', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('∫·', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('∫‚', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('∫„', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('∫‰', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('∫Â', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('∫Ê', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('∫Á', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('∫Ë', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('∫È', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('∫Í', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('∫Î', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('∫Ï', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('∫Ì', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('∫Ó', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('∫Ô', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('∫', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('∫Ò', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('∫Ú', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('∫Û', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('∫Ù', 'HU');
insert into HZPYDZB (HZ, PY)
values ('∫ı', 'HU');
insert into HZPYDZB (HZ, PY)
values ('∫ˆ', 'HU');
insert into HZPYDZB (HZ, PY)
values ('∫˜', 'HU');
insert into HZPYDZB (HZ, PY)
values ('∫¯', 'HU');
insert into HZPYDZB (HZ, PY)
values ('∫˘', 'HU');
insert into HZPYDZB (HZ, PY)
values ('∫˙', 'HU');
insert into HZPYDZB (HZ, PY)
values ('∫˚', 'HU');
insert into HZPYDZB (HZ, PY)
values ('∫¸', 'HU');
insert into HZPYDZB (HZ, PY)
values ('∫˝', 'HU');
insert into HZPYDZB (HZ, PY)
values ('∫˛', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ª@', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ªA', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ªE', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ªG', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ªH', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ªH', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ªI', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('ªK', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ªL', 'TENG');
insert into HZPYDZB (HZ, PY)
values ('ªO', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ªU', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ªV', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ª\', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('ª_', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ªc', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ªd', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ªe', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ªh', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ªj', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ªo', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ªp', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ªq', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ªr', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ªs', 'NV');
insert into HZPYDZB (HZ, PY)
values ('ªu', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ªv', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('ªx', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('ªz', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ªz', 'PI');
insert into HZPYDZB (HZ, PY)
values ('ª{', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('ª~', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ª~', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('ªÅ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ªÇ', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('ªÇ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ªÑ', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ªÜ', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('ªá', 'HU');
commit;
prompt 3500 records committed...
insert into HZPYDZB (HZ, PY)
values ('ªà', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ªâ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ªä', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ªã', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('ªç', 'SU');
insert into HZPYDZB (HZ, PY)
values ('ªé', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ªè', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('ªê', 'SE');
insert into HZPYDZB (HZ, PY)
values ('ªë', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ªí', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('ªì', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('ªî', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ªï', 'ER');
insert into HZPYDZB (HZ, PY)
values ('ªñ', 'QU');
insert into HZPYDZB (HZ, PY)
values ('ªó', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ªô', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ªö', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ªõ', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('ªú', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ªù', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ªû', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ªü', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('ª°', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ª¢', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ª£', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ª§', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ª•', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ª¶', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ªß', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ª®', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ª©', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ª™', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ª´', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ª¨', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ª≠', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ªÆ', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ªØ', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ª∞', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ª±', 'HUAI');
insert into HZPYDZB (HZ, PY)
values ('ª≤', 'HUAI');
insert into HZPYDZB (HZ, PY)
values ('ª≤', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª≥', 'HUAI');
insert into HZPYDZB (HZ, PY)
values ('ª¥', 'HUAI');
insert into HZPYDZB (HZ, PY)
values ('ªµ', 'HUAI');
insert into HZPYDZB (HZ, PY)
values ('ª∂', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ª∑', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ª∏', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ªπ', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('ªπ', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ª∫', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ªº', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ªæ', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ªø', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ª¿', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ª¡', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ª¬', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ª√', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ªƒ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ª≈', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ª∆', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ª«', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ª»', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ª…', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ª ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ªÀ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ªÃ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ªÕ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ªŒ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ªœ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ª–', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ª“', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª”', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª‘', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª’', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª÷', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª◊', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ªÿ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ªŸ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª⁄', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª€', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª‹', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª›', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ªﬁ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ªﬂ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª‡', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª·', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª‚', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª„', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ª‰', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ªÂ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ªÊ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ªÁ', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ªË', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ªÈ', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ªÍ', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ªÎ', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ªÏ', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ªÌ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ªÓ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ªÔ', 'HUO');
commit;
prompt 3600 records committed...
insert into HZPYDZB (HZ, PY)
values ('ª', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ªÒ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ªÚ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ªÛ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ªÙ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ªı', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ªˆ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ª˜', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ª¯', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ª˘', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ª˙', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ª˚', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ª˚', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ª¸', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ª˝', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºD', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ºE', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('ºH', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ºJ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ºK', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('ºM', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ºO', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ºQ', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ºT', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ºU', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ºX', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('ºY', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('º\', 'BO');
insert into HZPYDZB (HZ, PY)
values ('º_', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºb', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ºc', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ºf', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ºg', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('ºh', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ºj', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ºk', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('ºl', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('ºm', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ºp', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('ºq', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('ºs', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ºs', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('ºt', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ºu', 'OU');
insert into HZPYDZB (HZ, PY)
values ('ºu', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ºv', 'GE');
insert into HZPYDZB (HZ, PY)
values ('ºw', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ºx', 'REN');
insert into HZPYDZB (HZ, PY)
values ('ºy', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('º{', 'NA');
insert into HZPYDZB (HZ, PY)
values ('º}', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('ºÄ', 'FOU');
insert into HZPYDZB (HZ, PY)
values ('ºÇ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ºÉ', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('ºÑ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ºà', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ºâ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºã', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('ºé', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ºë', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ºì', 'BA');
insert into HZPYDZB (HZ, PY)
values ('ºï', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ºò', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ºö', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ºù', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ºû', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ºû', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ºü', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ºü', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('º†', 'QU');
insert into HZPYDZB (HZ, PY)
values ('º°', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º¢', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º£', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º§', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º•', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º¶', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºß', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º®', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º©', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º™', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º´', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º¨', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º≠', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºÆ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºØ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º∞', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º±', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º≤', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º≥', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º¥', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºµ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º∂', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º∑', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º∏', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºπ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º∫', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºª', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºº', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºΩ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºæ', 'JI');
commit;
prompt 3700 records committed...
insert into HZPYDZB (HZ, PY)
values ('ºø', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º¿', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º¡', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º¬', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º√', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºƒ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º≈', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º∆', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º«', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º»', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º»', 'XI');
insert into HZPYDZB (HZ, PY)
values ('º…', 'JI');
insert into HZPYDZB (HZ, PY)
values ('º ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºÀ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºÃ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºÕ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ºŒ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ºœ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('º–', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('º—', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('º“', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('º”', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('º‘', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('º’', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('º÷', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('º◊', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ºÿ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ºŸ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('º⁄', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('º€', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('º‹', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('º›', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ºﬁ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ºﬂ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('º‡', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('º·', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('º‚', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('º„', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('º‰', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºÂ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºÊ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºÁ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºË', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºÈ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºÍ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºÎ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºÏ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºÌ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºÓ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºÔ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('º', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºÒ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºÚ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºÛ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºÙ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºı', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ºˆ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('º˜', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('º¯', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('º˘', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('º˙', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('º˚', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('º˚', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('º¸', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('º˝', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('º˛', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ω@', 'LING');
insert into HZPYDZB (HZ, PY)
values ('ΩA', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('ΩB', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('ΩC', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ΩF', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ΩG', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ΩI', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ΩK', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('ΩM', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('ΩN', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('ΩP', 'QU');
insert into HZPYDZB (HZ, PY)
values ('ΩQ', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ΩR', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ΩT', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('ΩY', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ΩZ', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Ω[', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('Ω\', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('Ω\', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('Ω_', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('Ω`', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Ωa', 'CI');
insert into HZPYDZB (HZ, PY)
values ('Ωb', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('Ωb', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('Ωc', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('Ωd', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ωf', 'KU');
insert into HZPYDZB (HZ, PY)
values ('Ωg', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ωg', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('Ωh', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('Ωj', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('Ωj', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('Ωn', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Ωo', 'XIA');
commit;
prompt 3800 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ωp', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('Ωp', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Ωq', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('Ωr', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('Ωr', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('Ωv', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('Ωw', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('Ωw', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('Ωy', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Ωz', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ΩÅ', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ΩÇ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ΩÉ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ΩÉ', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('ΩÖ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ΩÜ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('Ωá', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('Ωà', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('Ωâ', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('Ωã', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('Ωã', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('Ωå', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('Ωå', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Ωé', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('Ωê', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Ωë', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('Ωï', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Ωñ', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Ωó', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('Ωô', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('Ωõ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Ωù', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Ω°', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ω¢', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ω£', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ω§', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ω•', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ω¶', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ωß', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ω®', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ω©', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ω™', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ω´', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ω¨', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ω≠', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ΩÆ', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ΩØ', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ω∞', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ω±', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ω≤', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ω≥', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ω¥', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ωµ', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ωµ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('Ω∂', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω∑', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω∏', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ωπ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω∫', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ωª', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ωº', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ΩΩ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ωæ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ωø', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω¿', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω¿', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ω¡', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω¬', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω√', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ωƒ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω≈', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω∆', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω«', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω«', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ω»', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω…', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ΩÀ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ΩÃ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ΩÕ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ΩŒ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ωœ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω–', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω—', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ω“', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ω”', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ω‘', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ω’', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ω’', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ω÷', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ω◊', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ωÿ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ΩŸ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ω⁄', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ω€', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Ω‹', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ω›', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ωﬁ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ωﬂ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ω‡', 'JIE');
commit;
prompt 3900 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ω·', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ω‚', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ω‚', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('Ω„', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ω‰', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ΩÂ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ΩÊ', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('ΩÊ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ΩÁ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ΩË', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ΩÈ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ΩÍ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ΩÎ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ΩÏ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ΩÌ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ΩÓ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ΩÔ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ω', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ΩÒ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ΩÚ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ΩÛ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ΩÙ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ωı', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ωˆ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ω˜', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ω¯', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ω˘', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ω˙', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ω˚', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ω¸', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ω˝', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ω˛', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ω˛', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('æ@', 'JI');
insert into HZPYDZB (HZ, PY)
values ('æC', 'ZONG');
insert into HZPYDZB (HZ, PY)
values ('æD', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('æG', 'LV');
insert into HZPYDZB (HZ, PY)
values ('æH', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('æI', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('æJ', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('æK', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('æM', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('æN', 'QI');
insert into HZPYDZB (HZ, PY)
values ('æO', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('æP', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('æS', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('æT', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('æU', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('æV', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('æW', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('æY', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('æZ', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('æ\', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('æ]', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('æ_', 'QI');
insert into HZPYDZB (HZ, PY)
values ('æ_', 'YI');
insert into HZPYDZB (HZ, PY)
values ('æ`', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('æa', 'BI');
insert into HZPYDZB (HZ, PY)
values ('æb', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('æb', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('æc', 'LING');
insert into HZPYDZB (HZ, PY)
values ('æd', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('æe', 'QI');
insert into HZPYDZB (HZ, PY)
values ('æg', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('æi', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('æi', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('æn', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('æo', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ær', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('æt', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('æu', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('æv', 'LV');
insert into HZPYDZB (HZ, PY)
values ('æw', 'XU');
insert into HZPYDZB (HZ, PY)
values ('æ{', 'XU');
insert into HZPYDZB (HZ, PY)
values ('æ~', 'KE');
insert into HZPYDZB (HZ, PY)
values ('æÇ', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('æÉ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('æÖ', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('æÜ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('æá', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('æà', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('æà', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('æâ', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('æã', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('æå', 'SI');
insert into HZPYDZB (HZ, PY)
values ('æé', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('æê', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('æì', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('æî', 'FU');
insert into HZPYDZB (HZ, PY)
values ('æñ', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('æó', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('æò', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('æö', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('æú', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('æù', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('æü', 'TI');
insert into HZPYDZB (HZ, PY)
values ('æ†', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('æ°', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('æ¢', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('æ¢', 'JING');
commit;
prompt 4000 records committed...
insert into HZPYDZB (HZ, PY)
values ('æ£', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ§', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ•', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ¶', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æß', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ®', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ©', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ™', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ´', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ¨', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ≠', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æÆ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æØ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ∞', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ±', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ≤', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ≥', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ¥', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æµ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ∂', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ∑', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ∏', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æπ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æ∫', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æª', 'JING');
insert into HZPYDZB (HZ, PY)
values ('æº', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('æΩ', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('ææ', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æø', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æ¿', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æ¡', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æ¬', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æ√', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æƒ', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æ≈', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æ∆', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æ«', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æ»', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æ…', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æ ', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æÀ', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æÃ', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æÕ', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æŒ', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('æœ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ–', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ”', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ‘', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ’', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ÷', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ◊', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ◊', 'ZUI');
insert into HZPYDZB (HZ, PY)
values ('æÿ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æŸ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ⁄', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ€', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ‹', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ›', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æﬁ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æﬂ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ‡', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ·', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ‚', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ„', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æ‰', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æÂ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æÊ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æÁ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('æË', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('æÈ', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('æÍ', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('æÎ', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('æÏ', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('æÌ', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('æÌ', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('æÓ', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('æÔ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('æ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('æÒ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('æÚ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('æÛ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('æÙ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('æı', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('æı', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('æˆ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('æ˜', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('æ¯', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('æ˘', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('æ˙', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('æ˚', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('æ¸', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('æ˝', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('æ˛', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('øA', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('øA', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('øE', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('øK', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('øM', 'YING');
insert into HZPYDZB (HZ, PY)
values ('øO', 'YI');
insert into HZPYDZB (HZ, PY)
values ('øQ', 'NI');
commit;
prompt 4100 records committed...
insert into HZPYDZB (HZ, PY)
values ('øR', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('øS', 'GU');
insert into HZPYDZB (HZ, PY)
values ('øT', 'HU');
insert into HZPYDZB (HZ, PY)
values ('øU', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('øU', 'CU');
insert into HZPYDZB (HZ, PY)
values ('øW', 'CI');
insert into HZPYDZB (HZ, PY)
values ('øW', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('øZ', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('øZ', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('ø\', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ø^', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('ø_', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('øb', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('øb', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('øc', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('øe', 'HU');
insert into HZPYDZB (HZ, PY)
values ('øf', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('øg', 'TENG');
insert into HZPYDZB (HZ, PY)
values ('øj', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('øk', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('øn', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('ør', 'LI');
insert into HZPYDZB (HZ, PY)
values ('øs', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('øt', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('øt', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('øv', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('øw', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('øx', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('øz', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('ø|', 'LV');
insert into HZPYDZB (HZ, PY)
values ('øÄ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('øÇ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('øÖ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('øÜ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('øä', 'MIU');
insert into HZPYDZB (HZ, PY)
values ('øä', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('øé', 'JI');
insert into HZPYDZB (HZ, PY)
values ('øì', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('øï', 'CENG');
insert into HZPYDZB (HZ, PY)
values ('øï', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('øö', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('øõ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('øû', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('øû', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('ø°', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('ø¢', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('ø£', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('ø§', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('ø•', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('ø¶', 'KA');
insert into HZPYDZB (HZ, PY)
values ('ø¶', 'KE');
insert into HZPYDZB (HZ, PY)
values ('øß', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('øß', 'KA');
insert into HZPYDZB (HZ, PY)
values ('ø®', 'KA');
insert into HZPYDZB (HZ, PY)
values ('ø®', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('ø©', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ø™', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('ø´', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('ø¨', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('ø≠', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('øÆ', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('øØ', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('ø∞', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('ø±', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('ø≤', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('ø≥', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('ø¥', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('øµ', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('ø∂', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('ø∑', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('ø∏', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('øπ', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('ø∫', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('ø∫', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('øª', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('øº', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('øΩ', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('øæ', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('øø', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('ø¿', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ø¡', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ø¬', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ø√', 'KE');
insert into HZPYDZB (HZ, PY)
values ('øƒ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ø≈', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ø∆', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ø«', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ø«', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('ø»', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ø…', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ø ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('øÀ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('øÃ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('øÕ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('øŒ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('øœ', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('ø–', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('ø—', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('ø“', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('ø”', 'KENG');
commit;
prompt 4200 records committed...
insert into HZPYDZB (HZ, PY)
values ('îñ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('îó', 'HE');
insert into HZPYDZB (HZ, PY)
values ('îò', 'CE');
insert into HZPYDZB (HZ, PY)
values ('îô', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('îö', 'GE');
insert into HZPYDZB (HZ, PY)
values ('îù', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('î°', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('î§', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('î¶', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('î®', 'KE');
insert into HZPYDZB (HZ, PY)
values ('î©', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('î™', 'JI');
insert into HZPYDZB (HZ, PY)
values ('î´', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('î±', 'AI');
insert into HZPYDZB (HZ, PY)
values ('îµ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('î∂', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('îª', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('îæ', 'DU');
insert into HZPYDZB (HZ, PY)
values ('î¡', 'LI');
insert into HZPYDZB (HZ, PY)
values ('î∆', 'QI');
insert into HZPYDZB (HZ, PY)
values ('î…', 'UU');
insert into HZPYDZB (HZ, PY)
values ('î ', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('îÃ', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('îŒ', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('î“', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('î’', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('î÷', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('î◊', 'QU');
insert into HZPYDZB (HZ, PY)
values ('î‹', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('î›', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('îﬂ', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('î‚', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('î„', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('î‰', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('îÂ', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('îÊ', 'MYEO');
insert into HZPYDZB (HZ, PY)
values ('îË', 'BI');
insert into HZPYDZB (HZ, PY)
values ('îÈ', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('îÎ', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('îÏ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('îÌ', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('îÓ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('îÔ', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('î', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('îÛ', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('îı', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('î˜', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('î˛', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('ï@', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('ï@', 'YING');
insert into HZPYDZB (HZ, PY)
values ('ïB', 'XU');
insert into HZPYDZB (HZ, PY)
values ('ïC', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ïE', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ïF', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('ïG', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('ïH', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('ïH', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('ïJ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ïK', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('ïL', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('ïM', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ïN', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('ïO', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ïP', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('ïQ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ïQ', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('ïS', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('ïT', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('ïU', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ïW', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('ïX', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('ïZ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ï\', 'BING');
insert into HZPYDZB (HZ, PY)
values ('ï\', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('ï^', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('ï^', 'PO');
insert into HZPYDZB (HZ, PY)
values ('ï_', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ï`', 'LING');
insert into HZPYDZB (HZ, PY)
values ('ïa', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('ïb', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ïd', 'XU');
insert into HZPYDZB (HZ, PY)
values ('ïe', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ïg', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ïg', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('ïh', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ïi', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ïi', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ïj', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('ïk', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('ïl', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ïn', 'ANG');
insert into HZPYDZB (HZ, PY)
values ('ïp', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('ïq', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('ïr', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ïs', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ïu', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ïv', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('ïw', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ïy', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ïz', 'TONG');
commit;
prompt 4300 records committed...
insert into HZPYDZB (HZ, PY)
values ('ï{', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ï|', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('ï~', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ïÄ', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('ïÇ', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('ïÑ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ïÖ', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('ïÜ', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ïá', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ïà', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ïâ', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('ïä', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ïã', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ïê', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ïë', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ïí', 'DU');
insert into HZPYDZB (HZ, PY)
values ('ïî', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ïï', 'AN');
insert into HZPYDZB (HZ, PY)
values ('ïñ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ïó', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ïò', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('ïô', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('ïõ', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ïú', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('ïù', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ïû', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('ï§', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ï¶', 'QING');
insert into HZPYDZB (HZ, PY)
values ('ïß', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('ï©', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ï´', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('ï¨', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ï≠', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('ïØ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ï∞', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('ï±', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('ï±', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('ï≤', 'WENG');
insert into HZPYDZB (HZ, PY)
values ('ï≥', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('ïµ', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('ï∏', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ïπ', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('ïΩ', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ïæ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ï¿', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('ï¡', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ï≈', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ï«', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ï…', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ï ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ïÀ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ïÃ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ïÃ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ïÕ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ï—', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ï”', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('ï’', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ïŸ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ï‹', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ïﬂ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ï·', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ï„', 'RU');
insert into HZPYDZB (HZ, PY)
values ('ï‰', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ïÂ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ïÁ', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('ïË', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ïÈ', 'UU');
insert into HZPYDZB (HZ, PY)
values ('ïÏ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ïÔ', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ï', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('ïˆ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ï˜', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ï¯', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ï˙', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('ï˚', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('ï¸', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ï¸', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ï˛', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('ñB', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('ñD', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('ñD', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('ñE', 'LING');
insert into HZPYDZB (HZ, PY)
values ('ñF', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ñF', 'KU');
insert into HZPYDZB (HZ, PY)
values ('ñG', 'UU');
insert into HZPYDZB (HZ, PY)
values ('ñH', 'NV');
insert into HZPYDZB (HZ, PY)
values ('ñI', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('ñJ', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('ñK', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ñM', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('ñN', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('ñR', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('ñS', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('ñS', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('ñT', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('ñU', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ñV', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('ñW', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('ñW', 'TEUN');
insert into HZPYDZB (HZ, PY)
values ('ñX', 'SHU');
commit;
prompt 4400 records committed...
insert into HZPYDZB (HZ, PY)
values ('ñY', 'TEUL');
insert into HZPYDZB (HZ, PY)
values ('ñZ', 'REN');
insert into HZPYDZB (HZ, PY)
values ('ñ[', 'BA');
insert into HZPYDZB (HZ, PY)
values ('ñ]', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('ñ]', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('ñ^', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ñ_', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ñ_', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('ñ`', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ña', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ñb', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ñb', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ñc', 'CI');
insert into HZPYDZB (HZ, PY)
values ('ñd', 'RU');
insert into HZPYDZB (HZ, PY)
values ('ñe', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('ñf', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ñf', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ñg', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ñi', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ñj', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('ñk', 'ER');
insert into HZPYDZB (HZ, PY)
values ('ñk', 'REN');
insert into HZPYDZB (HZ, PY)
values ('ñl', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ñl', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ñm', 'DI');
insert into HZPYDZB (HZ, PY)
values ('ñm', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ñn', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('ñp', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ñq', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('ñq', 'GE');
insert into HZPYDZB (HZ, PY)
values ('ñr', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('ñs', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ñs', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ñt', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ñu', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ñv', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ñw', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ñx', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('ñy', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ñ}', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('ñ}', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('ñ~', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('ñÄ', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('ñÄ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ñÅ', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ñÉ', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('ñÉ', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('ñÑ', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('ñÖ', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('ñÜ', 'WO');
insert into HZPYDZB (HZ, PY)
values ('ñÜ', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('ñá', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ñà', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ñâ', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('ñä', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ñä', 'PI');
insert into HZPYDZB (HZ, PY)
values ('ñã', 'ANG');
insert into HZPYDZB (HZ, PY)
values ('ñå', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('ñé', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ñè', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('ñê', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ñí', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('ñí', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('ñì', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('ñî', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ñï', 'E');
insert into HZPYDZB (HZ, PY)
values ('ññ', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('ñô', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('ñö', 'DI');
insert into HZPYDZB (HZ, PY)
values ('ñö', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ñõ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ñú', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('ñù', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('ñû', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('ñû', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ñü', 'CI');
insert into HZPYDZB (HZ, PY)
values ('ñ°', 'GUAI');
insert into HZPYDZB (HZ, PY)
values ('ñ¢', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('ñ¢', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ñ£', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ñ•', 'YE');
insert into HZPYDZB (HZ, PY)
values ('ñ®', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ñ©', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ñ™', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ñ´', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ñ´', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ñ¨', 'LA');
insert into HZPYDZB (HZ, PY)
values ('ñ≠', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ñÆ', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('ñÆ', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('ñØ', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ñ∞', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('ñ±', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('ñ≤', 'CI');
insert into HZPYDZB (HZ, PY)
values ('ñ≥', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('ñ¥', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ñµ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ñ∂', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('ñ∑', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('ñ∏', 'SHEN');
commit;
prompt 4500 records committed...
insert into HZPYDZB (HZ, PY)
values ('ñπ', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('ñª', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ñª', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ñº', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('ñº', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('ñΩ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ñæ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ñø', 'BU');
insert into HZPYDZB (HZ, PY)
values ('ñø', 'PU');
insert into HZPYDZB (HZ, PY)
values ('ñ¿', 'AO');
insert into HZPYDZB (HZ, PY)
values ('ñ¡', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ñ¬', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ñ√', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ñƒ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ñƒ', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('ñ≈', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ñ∆', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ñ«', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('ñ»', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('ñ»', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('ñ…', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ñ ', 'GUAI');
insert into HZPYDZB (HZ, PY)
values ('ñÃ', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ñÕ', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ñŒ', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('ñœ', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('ñ–', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ñ“', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('ñ”', 'SAENG');
insert into HZPYDZB (HZ, PY)
values ('ñ’', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('ñ’', 'SHUAN');
insert into HZPYDZB (HZ, PY)
values ('ñ÷', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ñ◊', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ñÿ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ñ⁄', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ñ€', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ñ‹', 'SE');
insert into HZPYDZB (HZ, PY)
values ('ñ›', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('ñﬁ', 'BING');
insert into HZPYDZB (HZ, PY)
values ('ñﬂ', 'REN');
insert into HZPYDZB (HZ, PY)
values ('ñ·', 'REN');
insert into HZPYDZB (HZ, PY)
values ('ñ‚', 'BING');
insert into HZPYDZB (HZ, PY)
values ('ñ„', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('ñ‰', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('ñÂ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ñÊ', 'CI');
insert into HZPYDZB (HZ, PY)
values ('ñÁ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ñÈ', 'ER');
insert into HZPYDZB (HZ, PY)
values ('ñÍ', 'ER');
insert into HZPYDZB (HZ, PY)
values ('ñÎ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ñÏ', 'FA');
insert into HZPYDZB (HZ, PY)
values ('ñÌ', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('ñÔ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ñÒ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ñÚ', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ñÛ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ñÙ', 'RU');
insert into HZPYDZB (HZ, PY)
values ('ñı', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ñˆ', 'KU');
insert into HZPYDZB (HZ, PY)
values ('ñ˙', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ñ˚', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('ñ¸', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('ñ˛', 'UU');
insert into HZPYDZB (HZ, PY)
values ('óA', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('óB', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('óE', 'SA');
insert into HZPYDZB (HZ, PY)
values ('óF', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('óF', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('óH', 'TING');
insert into HZPYDZB (HZ, PY)
values ('óJ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('óK', 'BO');
insert into HZPYDZB (HZ, PY)
values ('óM', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('óN', 'XI');
insert into HZPYDZB (HZ, PY)
values ('óO', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('óQ', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('óR', 'QI');
insert into HZPYDZB (HZ, PY)
values ('óS', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('óT', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('óU', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('óU', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('óV', 'SU');
insert into HZPYDZB (HZ, PY)
values ('óW', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('óY', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('óZ', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('ó\', 'DI');
insert into HZPYDZB (HZ, PY)
values ('ó]', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ó^', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('ó^', 'TU');
insert into HZPYDZB (HZ, PY)
values ('ó`', 'AO');
insert into HZPYDZB (HZ, PY)
values ('óa', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ób', 'DI');
insert into HZPYDZB (HZ, PY)
values ('óc', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ód', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('óe', 'REN');
insert into HZPYDZB (HZ, PY)
values ('óf', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('óh', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ói', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ój', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('ók', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ól', 'TIAO');
commit;
prompt 4600 records committed...
insert into HZPYDZB (HZ, PY)
values ('óo', 'LV');
insert into HZPYDZB (HZ, PY)
values ('óp', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('óp', 'KUAN');
insert into HZPYDZB (HZ, PY)
values ('óq', 'CEN');
insert into HZPYDZB (HZ, PY)
values ('ór', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('ót', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ót', 'SI');
insert into HZPYDZB (HZ, PY)
values ('óu', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('óv', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('óx', 'JU');
insert into HZPYDZB (HZ, PY)
values ('óy', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('óy', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('óz', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('ó{', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ó|', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ó}', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ó~', 'LI');
insert into HZPYDZB (HZ, PY)
values ('óÄ', 'BING');
insert into HZPYDZB (HZ, PY)
values ('óÉ', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('óÑ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('óÖ', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('óÜ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('óá', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('óá', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('óà', 'LI');
insert into HZPYDZB (HZ, PY)
values ('óä', 'BING');
insert into HZPYDZB (HZ, PY)
values ('óã', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('óå', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('óç', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('óè', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('óê', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('óë', 'DE');
insert into HZPYDZB (HZ, PY)
values ('óë', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('óí', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('óì', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('óî', 'POU');
insert into HZPYDZB (HZ, PY)
values ('óï', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('óò', 'LI');
insert into HZPYDZB (HZ, PY)
values ('óò', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('óô', 'YU');
insert into HZPYDZB (HZ, PY)
values ('óõ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('óú', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('óû', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('óü', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('ó†', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('ó°', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ó¢', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ó™', 'REN');
insert into HZPYDZB (HZ, PY)
values ('ó™', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ó≠', 'FU');
insert into HZPYDZB (HZ, PY)
values ('óØ', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('ó±', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('ó≤', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ó≥', 'QING');
insert into HZPYDZB (HZ, PY)
values ('ó¥', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ó¥', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('óµ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ó∂', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ó∑', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('ó∏', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('óπ', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('óπ', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('óª', 'JU');
insert into HZPYDZB (HZ, PY)
values ('óΩ', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('óæ', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('óæ', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('óø', 'E');
insert into HZPYDZB (HZ, PY)
values ('ó¿', 'PAI');
insert into HZPYDZB (HZ, PY)
values ('ó¡', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('ó√', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('ó≈', 'DING');
insert into HZPYDZB (HZ, PY)
values ('ó∆', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ó«', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('ó»', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('ó…', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('óÀ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('óÕ', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('óŒ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('óœ', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('ó–', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ó—', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('ó“', 'MYEONG');
insert into HZPYDZB (HZ, PY)
values ('ó‘', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('ó÷', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ó◊', 'YI');
insert into HZPYDZB (HZ, PY)
values ('óÿ', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('óŸ', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ó⁄', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ó€', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ó‹', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ó›', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('óﬂ', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('óﬂ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ó‰', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('óÊ', 'HE');
insert into HZPYDZB (HZ, PY)
values ('óÁ', 'WO');
insert into HZPYDZB (HZ, PY)
values ('óÈ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('óÍ', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('óÎ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('óÎ', 'KUA');
commit;
prompt 4700 records committed...
insert into HZPYDZB (HZ, PY)
values ('óÌ', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('óÓ', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('óÔ', 'LA');
insert into HZPYDZB (HZ, PY)
values ('óÒ', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('óÛ', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('óÙ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('óı', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('óˆ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ó¯', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ó˘', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ó˘', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ó˙', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ó˚', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('ó¸', 'KU');
insert into HZPYDZB (HZ, PY)
values ('ó˝', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ó˛', 'TING');
insert into HZPYDZB (HZ, PY)
values ('ò@', 'YU');
insert into HZPYDZB (HZ, PY)
values ('òB', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('òE', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('òG', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('òG', 'YE');
insert into HZPYDZB (HZ, PY)
values ('òH', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('òI', 'YE');
insert into HZPYDZB (HZ, PY)
values ('òJ', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('òJ', 'SHUN');
insert into HZPYDZB (HZ, PY)
values ('òK', 'YU');
insert into HZPYDZB (HZ, PY)
values ('òL', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('òM', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('òN', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('òN', 'TI');
insert into HZPYDZB (HZ, PY)
values ('òP', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('òQ', 'ROU');
insert into HZPYDZB (HZ, PY)
values ('òR', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('òS', 'LE');
insert into HZPYDZB (HZ, PY)
values ('òU', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('òV', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('òW', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('òX', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('òZ', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ò\', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ò]', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ò^', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ò_', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ò_', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ò`', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('òa', 'MI');
insert into HZPYDZB (HZ, PY)
values ('òb', 'GU');
insert into HZPYDZB (HZ, PY)
values ('òc', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('òc', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('òd', 'TA');
insert into HZPYDZB (HZ, PY)
values ('òe', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('òg', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('òh', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('òk', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('òl', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('òm', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('òn', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('òo', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('òo', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('òp', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('òq', 'MA');
insert into HZPYDZB (HZ, PY)
values ('òv', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('òw', 'TING');
insert into HZPYDZB (HZ, PY)
values ('òx', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('òy', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ò}', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ò~', 'XI');
insert into HZPYDZB (HZ, PY)
values ('òÄ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('òÅ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('òÇ', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('òÑ', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('òÖ', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('òÜ', 'GE');
insert into HZPYDZB (HZ, PY)
values ('òá', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('òà', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('òä', 'JI');
insert into HZPYDZB (HZ, PY)
values ('òã', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('òã', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('òé', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('òè', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('òì', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('òî', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('òï', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('òñ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('òó', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('òö', 'SANG');
insert into HZPYDZB (HZ, PY)
values ('òõ', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('òù', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('òû', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ò¢', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('ò£', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('ò¶', 'SEN');
insert into HZPYDZB (HZ, PY)
values ('òß', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('ò©', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('ò´', 'HU');
insert into HZPYDZB (HZ, PY)
values ('òÆ', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ò∞', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('ò±', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('ò¥', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('ò¥', 'WAN');
commit;
prompt 4800 records committed...
insert into HZPYDZB (HZ, PY)
values ('òµ', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('òµ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ò∂', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('ò∑', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ò∑', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ò∏', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('òπ', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ò∫', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('òª', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('òª', 'LI');
insert into HZPYDZB (HZ, PY)
values ('òæ', 'SHUANG');
insert into HZPYDZB (HZ, PY)
values ('òø', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('ò¬', 'SU');
insert into HZPYDZB (HZ, PY)
values ('ò√', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('òƒ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ò∆', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ò«', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('ò«', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ò…', 'SU');
insert into HZPYDZB (HZ, PY)
values ('òÀ', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('òÃ', 'DU');
insert into HZPYDZB (HZ, PY)
values ('òÃ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('òÕ', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('òÕ', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('òŒ', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ò–', 'DU');
insert into HZPYDZB (HZ, PY)
values ('ò–', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ò—', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('ò—', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('ò“', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('ò”', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('ò÷', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('òŸ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ò⁄', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('òﬁ', 'ER');
insert into HZPYDZB (HZ, PY)
values ('ò‚', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ò„', 'PU');
insert into HZPYDZB (HZ, PY)
values ('ò‰', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('òÂ', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('òÊ', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('òÁ', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('òË', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('òÌ', 'MO');
insert into HZPYDZB (HZ, PY)
values ('òÔ', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ò', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('òÚ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('òÚ', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('òÙ', 'RUN');
insert into HZPYDZB (HZ, PY)
values ('òı', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('òˆ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ò˘', 'SHUN');
insert into HZPYDZB (HZ, PY)
values ('ò˙', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('ò˙', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('ò¸', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ò¸', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ò˝', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ô@', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ôA', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('ôA', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ôB', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ôC', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ôD', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('ôE', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ôE', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ôF', 'NING');
insert into HZPYDZB (HZ, PY)
values ('ôH', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('ôH', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('ôI', 'CENG');
insert into HZPYDZB (HZ, PY)
values ('ôI', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('ôJ', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ôL', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('ôM', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('ôN', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('ôO', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ôP', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('ôQ', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ôR', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('ôU', 'CA');
insert into HZPYDZB (HZ, PY)
values ('ôX', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('ôY', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ô[', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ô\', 'DA');
insert into HZPYDZB (HZ, PY)
values ('ô]', 'SAO');
insert into HZPYDZB (HZ, PY)
values ('ô^', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ô_', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ô`', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ôb', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ôg', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ôh', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ôk', 'PU');
insert into HZPYDZB (HZ, PY)
values ('ôm', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ôn', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('ôo', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ôp', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ôq', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ôr', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ôs', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ôu', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ôw', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ô{', 'QIANG');
commit;
prompt 4900 records committed...
insert into HZPYDZB (HZ, PY)
values ('ô~', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ôÅ', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('ôÑ', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('ôÜ', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('ôâ', 'BING');
insert into HZPYDZB (HZ, PY)
values ('ôä', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ôä', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ôç', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ôç', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ôé', 'NING');
insert into HZPYDZB (HZ, PY)
values ('ôê', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('ôë', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('ôì', 'RUAN');
insert into HZPYDZB (HZ, PY)
values ('ôó', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ôò', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('ôõ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ôú', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ôû', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('ôü', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ô†', 'GE');
insert into HZPYDZB (HZ, PY)
values ('ô°', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('ô§', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ô¶', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('ôß', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('ôß', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('ô®', 'SA');
insert into HZPYDZB (HZ, PY)
values ('ô©', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ô´', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('ô¨', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ô¨', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ô≠', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('ô≠', 'MIE');
insert into HZPYDZB (HZ, PY)
values ('ôØ', 'OU');
insert into HZPYDZB (HZ, PY)
values ('ô∞', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ô≤', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('ô≥', 'DU');
insert into HZPYDZB (HZ, PY)
values ('ôµ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ôµ', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ôπ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ô∫', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ôæ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ôæ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ô¿', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ô¬', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ô¬', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('ô√', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ô√', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ô«', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ô…', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('ô ', 'LA');
insert into HZPYDZB (HZ, PY)
values ('ô ', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('ôÀ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ô–', 'LING');
insert into HZPYDZB (HZ, PY)
values ('ô—', 'YING');
insert into HZPYDZB (HZ, PY)
values ('ô◊', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('ôÿ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ô⁄', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ô⁄', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ô›', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('ôﬂ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ô·', 'QU');
insert into HZPYDZB (HZ, PY)
values ('ô‚', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('ôÂ', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ôÊ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ôÁ', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('ôË', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('ôÍ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ôÎ', 'EOM');
insert into HZPYDZB (HZ, PY)
values ('ôÏ', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ôÌ', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ôÔ', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('ôÔ', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ôÒ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('ôÚ', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('ôÙ', 'LING');
insert into HZPYDZB (HZ, PY)
values ('ôı', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('ôˆ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ô˜', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ô˘', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('ô˙', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ô¸', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('ô˛', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ö@', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('öB', 'HE');
insert into HZPYDZB (HZ, PY)
values ('öE', 'KUAN');
insert into HZPYDZB (HZ, PY)
values ('öF', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('öF', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('öG', 'E');
insert into HZPYDZB (HZ, PY)
values ('öH', 'CHUA');
insert into HZPYDZB (HZ, PY)
values ('öI', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('öI', 'CHUAI');
insert into HZPYDZB (HZ, PY)
values ('öJ', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('öK', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('öK', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('öM', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('öM', 'KE');
insert into HZPYDZB (HZ, PY)
values ('öN', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('öV', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('öV', 'QUN');
insert into HZPYDZB (HZ, PY)
values ('öW', 'OU');
commit;
prompt 5000 records committed...
insert into HZPYDZB (HZ, PY)
values ('öX', 'HU');
insert into HZPYDZB (HZ, PY)
values ('öZ', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ö\', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('ö^', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ö`', 'UU');
insert into HZPYDZB (HZ, PY)
values ('öd', 'E');
insert into HZPYDZB (HZ, PY)
values ('öf', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('ög', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('öh', 'BU');
insert into HZPYDZB (HZ, PY)
values ('öi', 'BU');
insert into HZPYDZB (HZ, PY)
values ('öj', 'JU');
insert into HZPYDZB (HZ, PY)
values ('öl', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('öl', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('öm', 'SE');
insert into HZPYDZB (HZ, PY)
values ('ön', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('öp', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('öq', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('ör', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('öv', 'LI');
insert into HZPYDZB (HZ, PY)
values ('öy', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('öz', 'MO');
insert into HZPYDZB (HZ, PY)
values ('öz', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('ö{', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ö|', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ö}', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('ö~', 'XU');
insert into HZPYDZB (HZ, PY)
values ('öÇ', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('öÉ', 'SU');
insert into HZPYDZB (HZ, PY)
values ('öÑ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('öÑ', 'QING');
insert into HZPYDZB (HZ, PY)
values ('öÜ', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('öà', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('öâ', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('öä', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('öã', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('öç', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('öé', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('öê', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('öí', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('öî', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('öï', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('öñ', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('öô', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('öõ', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('öú', 'DU');
insert into HZPYDZB (HZ, PY)
values ('öù', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ö†', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('ö¢', 'SA');
insert into HZPYDZB (HZ, PY)
values ('ö£', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ö£', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ö§', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('ö•', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ö®', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('ö®', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('ö™', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('ö™', 'OU');
insert into HZPYDZB (HZ, PY)
values ('öØ', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('ö≤', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('öµ', 'UU');
insert into HZPYDZB (HZ, PY)
values ('ö∂', 'UU');
insert into HZPYDZB (HZ, PY)
values ('ö∏', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('öπ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ö∫', 'SAI');
insert into HZPYDZB (HZ, PY)
values ('öª', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('öª', 'MU');
insert into HZPYDZB (HZ, PY)
values ('öº', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('öæ', 'ER');
insert into HZPYDZB (HZ, PY)
values ('ö¡', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ö¬', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('ö√', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('öƒ', 'UU');
insert into HZPYDZB (HZ, PY)
values ('ö≈', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('ö∆', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ö«', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ö»', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ö ', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('öÀ', 'SAI');
insert into HZPYDZB (HZ, PY)
values ('öÀ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('öÃ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('öÕ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('öŒ', 'DA');
insert into HZPYDZB (HZ, PY)
values ('ö—', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('ö—', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ö“', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ö”', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ö”', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('ö‘', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('öŸ', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ö⁄', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ö‹', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('öﬁ', 'RI');
insert into HZPYDZB (HZ, PY)
values ('öﬂ', 'NEI');
insert into HZPYDZB (HZ, PY)
values ('ö‡', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('öË', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('öÈ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('öÈ', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('öÏ', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('öÌ', 'LE');
insert into HZPYDZB (HZ, PY)
values ('öÔ', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ö', 'QIU');
commit;
prompt 5100 records committed...
insert into HZPYDZB (HZ, PY)
values ('öÒ', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('öÒ', 'PA');
insert into HZPYDZB (HZ, PY)
values ('öÚ', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('öÙ', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('öı', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('öˆ', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('ö˜', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ö˜', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ö¯', 'FA');
insert into HZPYDZB (HZ, PY)
values ('ö¯', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ö˘', 'DA');
insert into HZPYDZB (HZ, PY)
values ('ö˘', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('ö˙', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ö˚', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('ö¸', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('ö˝', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('ö˛', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('õ@', 'WA');
insert into HZPYDZB (HZ, PY)
values ('õ@', 'WU');
insert into HZPYDZB (HZ, PY)
values ('õA', 'WA');
insert into HZPYDZB (HZ, PY)
values ('õA', 'WU');
insert into HZPYDZB (HZ, PY)
values ('õB', 'TU');
insert into HZPYDZB (HZ, PY)
values ('õC', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('õD', 'JI');
insert into HZPYDZB (HZ, PY)
values ('õD', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('õE', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('õF', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('õG', 'JING');
insert into HZPYDZB (HZ, PY)
values ('õH', 'JING');
insert into HZPYDZB (HZ, PY)
values ('õI', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('õI', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('õJ', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('õK', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('õL', 'FU');
insert into HZPYDZB (HZ, PY)
values ('õM', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('õN', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('õO', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('õP', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('õP', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('õQ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('õQ', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('õR', 'HU');
insert into HZPYDZB (HZ, PY)
values ('õR', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('õS', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('õT', 'XU');
insert into HZPYDZB (HZ, PY)
values ('õW', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('õX', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('õZ', 'HU');
insert into HZPYDZB (HZ, PY)
values ('õ[', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('õ\', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('õ\', 'NV');
insert into HZPYDZB (HZ, PY)
values ('õ^', 'FU');
insert into HZPYDZB (HZ, PY)
values ('õ_', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('õa', 'BI');
insert into HZPYDZB (HZ, PY)
values ('õb', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('õc', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('õd', 'ZHUI');
insert into HZPYDZB (HZ, PY)
values ('õd', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('õf', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('õg', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('õh', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('õi', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('õi', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('õk', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('õk', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('õl', 'LI');
insert into HZPYDZB (HZ, PY)
values ('õl', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('õm', 'MI');
insert into HZPYDZB (HZ, PY)
values ('õm', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('õn', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('õn', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('õo', 'FA');
insert into HZPYDZB (HZ, PY)
values ('õp', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('õq', 'SI');
insert into HZPYDZB (HZ, PY)
values ('õr', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('õs', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('õs', 'YING');
insert into HZPYDZB (HZ, PY)
values ('õt', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('õt', 'JU');
insert into HZPYDZB (HZ, PY)
values ('õu', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('õu', 'YI');
insert into HZPYDZB (HZ, PY)
values ('õv', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('õw', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('õw', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('õx', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('õy', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('õz', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('õ{', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('õ|', 'AO');
insert into HZPYDZB (HZ, PY)
values ('õ|', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('õ}', 'GU');
insert into HZPYDZB (HZ, PY)
values ('õ~', 'HU');
insert into HZPYDZB (HZ, PY)
values ('õÄ', 'PING');
insert into HZPYDZB (HZ, PY)
values ('õÅ', 'CI');
insert into HZPYDZB (HZ, PY)
values ('õÅ', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('õÇ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('õÇ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('õÉ', 'SU');
insert into HZPYDZB (HZ, PY)
values ('õÑ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('õÖ', 'SI');
commit;
prompt 5200 records committed...
insert into HZPYDZB (HZ, PY)
values ('õÜ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('õà', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('õâ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('õä', 'FU');
insert into HZPYDZB (HZ, PY)
values ('õã', 'JI');
insert into HZPYDZB (HZ, PY)
values ('õå', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('õç', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('õé', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('õè', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('õè', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('õê', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('õë', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('õí', 'ZAI');
insert into HZPYDZB (HZ, PY)
values ('õì', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('õî', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('õï', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('õñ', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('õñ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('õó', 'SI');
insert into HZPYDZB (HZ, PY)
values ('õô', 'XING');
insert into HZPYDZB (HZ, PY)
values ('õö', 'FU');
insert into HZPYDZB (HZ, PY)
values ('õõ', 'SE');
insert into HZPYDZB (HZ, PY)
values ('õõ', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('õú', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('õû', 'WU');
insert into HZPYDZB (HZ, PY)
values ('õü', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('õ†', 'UU');
insert into HZPYDZB (HZ, PY)
values ('õ°', 'AN');
insert into HZPYDZB (HZ, PY)
values ('õ°', 'E');
insert into HZPYDZB (HZ, PY)
values ('õ¢', 'TI');
insert into HZPYDZB (HZ, PY)
values ('õ£', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('õ§', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('õ•', 'YI');
insert into HZPYDZB (HZ, PY)
values ('õß', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('õ®', 'PO');
insert into HZPYDZB (HZ, PY)
values ('õ™', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('õ™', 'YI');
insert into HZPYDZB (HZ, PY)
values ('õ´', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('õ´', 'SU');
insert into HZPYDZB (HZ, PY)
values ('õ¨', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('õ≠', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('õÆ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('õØ', 'PING');
insert into HZPYDZB (HZ, PY)
values ('õ±', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('õ≤', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('õ≤', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('õ≥', 'MING');
insert into HZPYDZB (HZ, PY)
values ('õ¥', 'HU');
insert into HZPYDZB (HZ, PY)
values ('õ¥', 'WU');
insert into HZPYDZB (HZ, PY)
values ('õµ', 'QU');
insert into HZPYDZB (HZ, PY)
values ('õ∂', 'YI');
insert into HZPYDZB (HZ, PY)
values ('õ∑', 'JING');
insert into HZPYDZB (HZ, PY)
values ('õ∏', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('õ∫', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('õª', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('õº', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('õΩ', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('õæ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('õø', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('õø', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('õ¡', 'DI');
insert into HZPYDZB (HZ, PY)
values ('õ¡', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('õ¬', 'BO');
insert into HZPYDZB (HZ, PY)
values ('õ√', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('õƒ', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('õ≈', 'YA');
insert into HZPYDZB (HZ, PY)
values ('õ≈', 'YI');
insert into HZPYDZB (HZ, PY)
values ('õ∆', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('õ«', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('õ»', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('õ…', 'LI');
insert into HZPYDZB (HZ, PY)
values ('õ ', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('õÀ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('õÃ', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('õÕ', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('õÕ', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('õŒ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('õœ', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('õ–', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('õ—', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('õ“', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('õ”', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('õ‘', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('õ’', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('õ÷', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('õÿ', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('õŸ', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('õ€', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('õ‹', 'JING');
insert into HZPYDZB (HZ, PY)
values ('õ›', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('õ›', 'REN');
insert into HZPYDZB (HZ, PY)
values ('õﬁ', 'TU');
insert into HZPYDZB (HZ, PY)
values ('õ‡', 'TING');
insert into HZPYDZB (HZ, PY)
values ('õ·', 'E');
insert into HZPYDZB (HZ, PY)
values ('õ‚', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('õ„', 'LI');
insert into HZPYDZB (HZ, PY)
values ('õ‰', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('õÂ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('õÊ', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('õÁ', 'SHUI');
commit;
prompt 5300 records committed...
insert into HZPYDZB (HZ, PY)
values ('õË', 'DU');
insert into HZPYDZB (HZ, PY)
values ('õÍ', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('õÎ', 'XING');
insert into HZPYDZB (HZ, PY)
values ('õÏ', 'SHOU');
insert into HZPYDZB (HZ, PY)
values ('õÏ', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('õÌ', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('õÔ', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('õÔ', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('õ', 'WO');
insert into HZPYDZB (HZ, PY)
values ('õÒ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('õÛ', 'WO');
insert into HZPYDZB (HZ, PY)
values ('õÙ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('õı', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('õ˜', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('õ˘', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('õ˙', 'DE');
insert into HZPYDZB (HZ, PY)
values ('õ˚', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('õ¸', 'GU');
insert into HZPYDZB (HZ, PY)
values ('õ¸', 'HU');
insert into HZPYDZB (HZ, PY)
values ('õ˝', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('õ˝', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('õ˛', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('õ˛', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('ú@', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('ú@', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('úB', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('úC', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('úD', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('úE', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('úF', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('úG', 'LU');
insert into HZPYDZB (HZ, PY)
values ('úH', 'JU');
insert into HZPYDZB (HZ, PY)
values ('úI', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('úJ', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('úK', 'PING');
insert into HZPYDZB (HZ, PY)
values ('úL', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('úM', 'YU');
insert into HZPYDZB (HZ, PY)
values ('úN', 'NI');
insert into HZPYDZB (HZ, PY)
values ('úO', 'LU');
insert into HZPYDZB (HZ, PY)
values ('úP', 'MI');
insert into HZPYDZB (HZ, PY)
values ('úR', 'LING');
insert into HZPYDZB (HZ, PY)
values ('úS', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('úU', 'YU');
insert into HZPYDZB (HZ, PY)
values ('úV', 'NA');
insert into HZPYDZB (HZ, PY)
values ('úV', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('úW', 'HU');
insert into HZPYDZB (HZ, PY)
values ('úX', 'HU');
insert into HZPYDZB (HZ, PY)
values ('úY', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('úZ', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('ú[', 'QING');
insert into HZPYDZB (HZ, PY)
values ('ú]', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ú_', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ú_', 'PO');
insert into HZPYDZB (HZ, PY)
values ('ú`', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('úb', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('úc', 'RE');
insert into HZPYDZB (HZ, PY)
values ('úc', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('úd', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('úf', 'KE');
insert into HZPYDZB (HZ, PY)
values ('úh', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('úh', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('új', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ún', 'ROU');
insert into HZPYDZB (HZ, PY)
values ('úq', 'NUAN');
insert into HZPYDZB (HZ, PY)
values ('ús', 'TING');
insert into HZPYDZB (HZ, PY)
values ('út', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('úu', 'WO');
insert into HZPYDZB (HZ, PY)
values ('úv', 'DI');
insert into HZPYDZB (HZ, PY)
values ('úv', 'TI');
insert into HZPYDZB (HZ, PY)
values ('úw', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('úx', 'RU');
insert into HZPYDZB (HZ, PY)
values ('úy', 'CE');
insert into HZPYDZB (HZ, PY)
values ('úz', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ú|', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ú}', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ú~', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('úÄ', 'YING');
insert into HZPYDZB (HZ, PY)
values ('úÇ', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('úÉ', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('úÑ', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('úá', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('úà', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('úâ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('úä', 'E');
insert into HZPYDZB (HZ, PY)
values ('úã', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('úå', 'QI');
insert into HZPYDZB (HZ, PY)
values ('úç', 'QI');
insert into HZPYDZB (HZ, PY)
values ('úè', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('úê', 'COU');
insert into HZPYDZB (HZ, PY)
values ('úí', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('úî', 'BO');
insert into HZPYDZB (HZ, PY)
values ('úî', 'PO');
insert into HZPYDZB (HZ, PY)
values ('úï', 'XU');
insert into HZPYDZB (HZ, PY)
values ('úñ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('úô', 'YI');
insert into HZPYDZB (HZ, PY)
values ('úõ', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('úú', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('úú', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('úù', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('úù', 'ZHENG');
commit;
prompt 5400 records committed...
insert into HZPYDZB (HZ, PY)
values ('úü', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ú†', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ú°', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ú°', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('ú¢', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ú£', 'TU');
insert into HZPYDZB (HZ, PY)
values ('ú§', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('ú•', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('ú¶', 'JU');
insert into HZPYDZB (HZ, PY)
values ('úß', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('ú®', 'NUAN');
insert into HZPYDZB (HZ, PY)
values ('ú®', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('ú©', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ú©', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ú´', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ú¨', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('ú∞', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('ú±', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('ú≥', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ú¥', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('úµ', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ú∑', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('ú∑', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('ú∏', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ú∫', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('úº', 'LA');
insert into HZPYDZB (HZ, PY)
values ('úΩ', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('úæ', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('ú¡', 'YING');
insert into HZPYDZB (HZ, PY)
values ('ú√', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('úƒ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ú≈', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('ú«', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ú«', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('ú…', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ú ', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('ú ', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('úÀ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('úÃ', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('úÕ', 'DA');
insert into HZPYDZB (HZ, PY)
values ('úÕ', 'TA');
insert into HZPYDZB (HZ, PY)
values ('úœ', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('ú”', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('ú‘', 'MA');
insert into HZPYDZB (HZ, PY)
values ('ú’', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('ú’', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ú◊', 'WU');
insert into HZPYDZB (HZ, PY)
values ('úÿ', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('ú‹', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ú›', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('úﬂ', 'SU');
insert into HZPYDZB (HZ, PY)
values ('ú‡', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('ú‚', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ú„', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('ú‰', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('úÂ', 'WENG');
insert into HZPYDZB (HZ, PY)
values ('úÁ', 'MIE');
insert into HZPYDZB (HZ, PY)
values ('úË', 'GE');
insert into HZPYDZB (HZ, PY)
values ('úÈ', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('úÍ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('úÏ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('úÌ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('úÔ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ú', 'GE');
insert into HZPYDZB (HZ, PY)
values ('úÒ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('úÚ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('úÙ', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('úı', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('úı', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('úˆ', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('ú˜', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('ú˘', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ú˚', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ú¸', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ú˛', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ù@', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ùA', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('ùB', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ùC', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('ùD', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ùE', 'AO');
insert into HZPYDZB (HZ, PY)
values ('ùF', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ùG', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ùH', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('ùI', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ùK', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('ùM', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('ùO', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ùP', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ùQ', 'YA');
insert into HZPYDZB (HZ, PY)
values ('ùR', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('ùT', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ùU', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('ùU', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ùV', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('ùW', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ùY', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ù[', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('ù\', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('ù]', 'JIAO');
commit;
prompt 5500 records committed...
insert into HZPYDZB (HZ, PY)
values ('ù^', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ù_', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('ùa', 'OU');
insert into HZPYDZB (HZ, PY)
values ('ùe', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ùf', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ùg', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ùh', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ùi', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ùj', 'WA');
insert into HZPYDZB (HZ, PY)
values ('ùk', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ùl', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ùm', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('ùn', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('ùo', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('ùr', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('ùr', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('ùt', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('ùu', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ùw', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('ùw', 'SHUANG');
insert into HZPYDZB (HZ, PY)
values ('ùx', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('ùy', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('ùz', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ù{', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ù|', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ù}', 'YING');
insert into HZPYDZB (HZ, PY)
values ('ùÅ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ùÉ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ùÑ', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('ùà', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ùà', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ùâ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ùâ', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('ùä', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ùå', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ùç', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ùé', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ùê', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ùë', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ùë', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ùí', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('ùí', 'SU');
insert into HZPYDZB (HZ, PY)
values ('ùì', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('ùî', 'YA');
insert into HZPYDZB (HZ, PY)
values ('ùñ', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('ùó', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('ùò', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('ùô', 'RUN');
insert into HZPYDZB (HZ, PY)
values ('ùö', 'SU');
insert into HZPYDZB (HZ, PY)
values ('ùõ', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ùú', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ùû', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ùû', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ù§', 'TU');
insert into HZPYDZB (HZ, PY)
values ('ù•', 'SA');
insert into HZPYDZB (HZ, PY)
values ('ù•', 'SAN');
insert into HZPYDZB (HZ, PY)
values ('ù¶', 'HEI');
insert into HZPYDZB (HZ, PY)
values ('ùß', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ù®', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ù©', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ù™', 'PU');
insert into HZPYDZB (HZ, PY)
values ('ù´', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ùØ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ù∞', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('ù±', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ù≤', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ù≤', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ù≥', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ù¥', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('ùµ', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ù∂', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ù∑', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('ù∏', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('ù∫', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ùª', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('ùª', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('ùº', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ùΩ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('ùø', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ù¡', 'AO');
insert into HZPYDZB (HZ, PY)
values ('ù¡', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ù¬', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ù√', 'NING');
insert into HZPYDZB (HZ, PY)
values ('ùƒ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ù≈', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ù…', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ù ', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('ùŒ', 'LING');
insert into HZPYDZB (HZ, PY)
values ('ùœ', 'OU');
insert into HZPYDZB (HZ, PY)
values ('ù–', 'CI');
insert into HZPYDZB (HZ, PY)
values ('ù–', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('ù—', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('ù“', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('ù”', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ù‘', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ù◊', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ùÿ', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ùŸ', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('ù€', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ù‹', 'SUI');
commit;
prompt 5600 records committed...
insert into HZPYDZB (HZ, PY)
values ('ùﬁ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ù‡', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('ù‚', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('ù„', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('ù„', 'WO');
insert into HZPYDZB (HZ, PY)
values ('ùÂ', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('ùË', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ùË', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ùÈ', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ùÏ', 'TING');
insert into HZPYDZB (HZ, PY)
values ('ùÌ', 'SE');
insert into HZPYDZB (HZ, PY)
values ('ùÓ', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('ùÔ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ù', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ù', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ùÚ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ùÛ', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ùÙ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ùÙ', 'NING');
insert into HZPYDZB (HZ, PY)
values ('ù˜', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ù˙', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ù˚', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('ù¸', 'WO');
insert into HZPYDZB (HZ, PY)
values ('ù˝', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('ûC', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ûC', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ûD', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ûE', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ûE', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ûF', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('ûH', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ûI', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('ûJ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ûM', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('ûQ', 'ME');
insert into HZPYDZB (HZ, PY)
values ('ûS', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('ûT', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ûT', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ûU', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('ûV', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ûW', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ûY', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('ûZ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('û]', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('û^', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('û^', 'DU');
insert into HZPYDZB (HZ, PY)
values ('û`', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ûc', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ûd', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ûk', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ûl', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('ûo', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ûq', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('ûr', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ûs', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ûv', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ûw', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('û{', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('û|', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('û~', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ûÅ', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('ûÖ', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ûÖ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ûÜ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ûá', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ûâ', 'YING');
insert into HZPYDZB (HZ, PY)
values ('ûä', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ûå', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ûè', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('ûè', 'RANG');
insert into HZPYDZB (HZ, PY)
values ('ûí', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ûì', 'SHUANG');
insert into HZPYDZB (HZ, PY)
values ('ûï', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ûï', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('ûñ', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('ûó', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ûò', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('ûô', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ûö', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ûõ', 'QU');
insert into HZPYDZB (HZ, PY)
values ('û¢', 'LI');
insert into HZPYDZB (HZ, PY)
values ('û¢', 'SA');
insert into HZPYDZB (HZ, PY)
values ('û£', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('ûß', 'MI');
insert into HZPYDZB (HZ, PY)
values ('û©', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('û´', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ûÆ', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('û∞', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('û±', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('û≤', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('û∏', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ûª', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('ûæ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ûø', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('û¿', 'ZHUAN');
insert into HZPYDZB (HZ, PY)
values ('û√', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('û∆', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('û«', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('û»', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('û…', 'WEN');
commit;
prompt 5700 records committed...
insert into HZPYDZB (HZ, PY)
values ('û ', 'PU');
insert into HZPYDZB (HZ, PY)
values ('ûÀ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ûÕ', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('ûŒ', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('ûœ', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('û–', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('û–', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('û—', 'MU');
insert into HZPYDZB (HZ, PY)
values ('û“', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('û”', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('û’', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('û÷', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('û◊', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ûÿ', 'DA');
insert into HZPYDZB (HZ, PY)
values ('û⁄', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('û€', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('û‹', 'KE');
insert into HZPYDZB (HZ, PY)
values ('û›', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('ûﬁ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ûﬂ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('û‚', 'LING');
insert into HZPYDZB (HZ, PY)
values ('û„', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('û‰', 'FOU');
insert into HZPYDZB (HZ, PY)
values ('ûÂ', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('ûÊ', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('ûÁ', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('ûË', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('ûÈ', 'HA');
insert into HZPYDZB (HZ, PY)
values ('ûÈ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ûÍ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ûÎ', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('ûÏ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ûÏ', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ûÓ', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('ûÔ', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('û', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ûı', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ûˆ', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('û˜', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('û˘', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('û˙', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('û˙', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('û˝', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('ü@', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('üA', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('üC', 'AI');
insert into HZPYDZB (HZ, PY)
values ('üC', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('üD', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('üE', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('üF', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('üG', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('üH', 'UU');
insert into HZPYDZB (HZ, PY)
values ('üI', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('üJ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('üK', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('üL', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('üN', 'JING');
insert into HZPYDZB (HZ, PY)
values ('üN', 'TING');
insert into HZPYDZB (HZ, PY)
values ('üP', 'TING');
insert into HZPYDZB (HZ, PY)
values ('üQ', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('üR', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('üS', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('üT', 'XU');
insert into HZPYDZB (HZ, PY)
values ('üU', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('üW', 'HU');
insert into HZPYDZB (HZ, PY)
values ('üZ', 'HE');
insert into HZPYDZB (HZ, PY)
values ('üZ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ü[', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ü\', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('ü\', 'KU');
insert into HZPYDZB (HZ, PY)
values ('ü]', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ü]', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('üa', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('üb', 'DI');
insert into HZPYDZB (HZ, PY)
values ('üc', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('üd', 'JI');
insert into HZPYDZB (HZ, PY)
values ('üe', 'UU');
insert into HZPYDZB (HZ, PY)
values ('üf', 'LV');
insert into HZPYDZB (HZ, PY)
values ('üh', 'JU');
insert into HZPYDZB (HZ, PY)
values ('üj', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('ük', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ül', 'TIU');
insert into HZPYDZB (HZ, PY)
values ('ül', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('ün', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('üo', 'WU');
insert into HZPYDZB (HZ, PY)
values ('üp', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('üq', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('üq', 'JU');
insert into HZPYDZB (HZ, PY)
values ('üs', 'AI');
insert into HZPYDZB (HZ, PY)
values ('üs', 'WO');
insert into HZPYDZB (HZ, PY)
values ('üt', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('üx', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('ü|', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ü}', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ü}', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('üÄ', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('üÉ', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('üÑ', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('üÖ', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('üÜ', 'SHAO');
commit;
prompt 5800 records committed...
insert into HZPYDZB (HZ, PY)
values ('üá', 'UU');
insert into HZPYDZB (HZ, PY)
values ('üà', 'NEM');
insert into HZPYDZB (HZ, PY)
values ('üâ', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('üä', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('üã', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('üå', 'HE');
insert into HZPYDZB (HZ, PY)
values ('üç', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('üé', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('üë', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('üí', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('üî', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('üò', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('üò', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('üô', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('üõ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('üú', 'NUAN');
insert into HZPYDZB (HZ, PY)
values ('üù', 'NUAN');
insert into HZPYDZB (HZ, PY)
values ('üû', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ü†', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('ü°', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('ü¢', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('ü£', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ü•', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('üß', 'ROU');
insert into HZPYDZB (HZ, PY)
values ('ü´', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ü≠', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('üÆ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ü∞', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('ü±', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('ü¥', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('üµ', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('ü∂', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ü∑', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('ü∏', 'EN');
insert into HZPYDZB (HZ, PY)
values ('ü∫', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('üø', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ü¿', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ü¿', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('ü√', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('ü≈', 'QIONG');
insert into HZPYDZB (HZ, PY)
values ('ü∆', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ü«', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ü»', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('üœ', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ü–', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ü—', 'AO');
insert into HZPYDZB (HZ, PY)
values ('ü—', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ü“', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ü‘', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('ü‘', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('ü’', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('ü’', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ü÷', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ü◊', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('üÿ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ü⁄', 'HU');
insert into HZPYDZB (HZ, PY)
values ('üﬁ', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('ü‡', 'OU');
insert into HZPYDZB (HZ, PY)
values ('ü‚', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('ü„', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('ü‰', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('üÂ', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('üÊ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('üÏ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('üÌ', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('üÌ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('üÔ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('üÛ', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('üÙ', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('üı', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('üı', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('ü˜', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ü˜', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ü¯', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('ü¯', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('ü˘', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ü˚', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ü¸', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('ü˝', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('ü˛', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('†A', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('†C', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('†D', 'YI');
insert into HZPYDZB (HZ, PY)
values ('†E', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('†F', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('†G', 'JING');
insert into HZPYDZB (HZ, PY)
values ('†H', 'UU');
insert into HZPYDZB (HZ, PY)
values ('†I', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('†L', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('†N', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('†Q', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('†R', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('†S', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('†T', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('†U', 'LING');
insert into HZPYDZB (HZ, PY)
values ('†Y', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('†\', 'NUNG');
insert into HZPYDZB (HZ, PY)
values ('†]', 'BING');
insert into HZPYDZB (HZ, PY)
values ('†^', 'RU');
insert into HZPYDZB (HZ, PY)
values ('†_', 'HE');
commit;
prompt 5900 records committed...
insert into HZPYDZB (HZ, PY)
values ('†_', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('†d', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('†e', 'HE');
insert into HZPYDZB (HZ, PY)
values ('†f', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('†g', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('†j', 'MO');
insert into HZPYDZB (HZ, PY)
values ('†l', 'LV');
insert into HZPYDZB (HZ, PY)
values ('†m', 'LA');
insert into HZPYDZB (HZ, PY)
values ('†m', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('†n', 'AO');
insert into HZPYDZB (HZ, PY)
values ('†p', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('†p', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('†q', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('†s', 'LI');
insert into HZPYDZB (HZ, PY)
values ('†t', 'LU');
insert into HZPYDZB (HZ, PY)
values ('†v', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('†z', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('†Ä', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('†Å', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('†Ç', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('†Ç', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('†É', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('†Ñ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('†Ü', 'MI');
insert into HZPYDZB (HZ, PY)
values ('†à', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('†â', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('†ä', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('†é', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('†è', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('†ê', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('†ë', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('†í', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('†î', 'YE');
insert into HZPYDZB (HZ, PY)
values ('†ñ', 'ER');
insert into HZPYDZB (HZ, PY)
values ('†ó', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('†ò', 'KE');
insert into HZPYDZB (HZ, PY)
values ('†û', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('†ü', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('††', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('†°', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('†§', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('†§', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('†•', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('†©', 'DU');
insert into HZPYDZB (HZ, PY)
values ('†™', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('†¨', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('†¨', 'LE');
insert into HZPYDZB (HZ, PY)
values ('†≠', 'TA');
insert into HZPYDZB (HZ, PY)
values ('†≠', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('†Ø', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('†∞', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('†±', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('†≤', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('†≥', 'GE');
insert into HZPYDZB (HZ, PY)
values ('†≥', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('†¥', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('†µ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('†∂', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('†∑', 'GE');
insert into HZPYDZB (HZ, PY)
values ('†∏', 'MU');
insert into HZPYDZB (HZ, PY)
values ('†π', 'DI');
insert into HZPYDZB (HZ, PY)
values ('†ª', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('†º', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('†æ', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('†¿', 'LI');
insert into HZPYDZB (HZ, PY)
values ('†¡', 'POU');
insert into HZPYDZB (HZ, PY)
values ('†¬', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('†√', 'TE');
insert into HZPYDZB (HZ, PY)
values ('†ƒ', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('†∆', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('†«', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('†…', 'KE');
insert into HZPYDZB (HZ, PY)
values ('† ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('†À', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('†Œ', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('†œ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('†“', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('†”', 'LI');
insert into HZPYDZB (HZ, PY)
values ('†”', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('†‘', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('†’', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('†Ÿ', 'DU');
insert into HZPYDZB (HZ, PY)
values ('†⁄', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('†›', 'BO');
insert into HZPYDZB (HZ, PY)
values ('†„', 'BA');
insert into HZPYDZB (HZ, PY)
values ('†‰', 'JI');
insert into HZPYDZB (HZ, PY)
values ('†Â', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('†Á', 'GE');
insert into HZPYDZB (HZ, PY)
values ('†Á', 'HE');
insert into HZPYDZB (HZ, PY)
values ('†Ë', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('†Ë', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('†È', 'BO');
insert into HZPYDZB (HZ, PY)
values ('†Í', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('†Î', 'YA');
insert into HZPYDZB (HZ, PY)
values ('†Ì', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('†Ì', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('†Ó', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('†Ô', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('†', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('†Û', 'JU');
commit;
prompt 6000 records committed...
insert into HZPYDZB (HZ, PY)
values ('†Ù', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('†Ù', 'YI');
insert into HZPYDZB (HZ, PY)
values ('†ı', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('†ˆ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('†ˆ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('†˜', 'LING');
insert into HZPYDZB (HZ, PY)
values ('†˘', 'NI');
insert into HZPYDZB (HZ, PY)
values ('†˝', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('†˛', 'BO');
insert into HZPYDZB (HZ, PY)
values ('™@', 'KU');
insert into HZPYDZB (HZ, PY)
values ('™B', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('™B', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('™C', 'HE');
insert into HZPYDZB (HZ, PY)
values ('™D', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('™E', 'JI');
insert into HZPYDZB (HZ, PY)
values ('™E', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('™H', 'TA');
insert into HZPYDZB (HZ, PY)
values ('™I', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('™J', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('™J', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('™K', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('™R', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('™S', 'JING');
insert into HZPYDZB (HZ, PY)
values ('™U', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('™W', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('™W', 'PI');
insert into HZPYDZB (HZ, PY)
values ('™[', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('™\', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('™]', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('™^', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('™b', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('™c', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('™c', 'YA');
insert into HZPYDZB (HZ, PY)
values ('™d', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('™e', 'CEON');
insert into HZPYDZB (HZ, PY)
values ('™g', 'FUI');
insert into HZPYDZB (HZ, PY)
values ('™i', 'WO');
insert into HZPYDZB (HZ, PY)
values ('™k', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('™l', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('™m', 'YA');
insert into HZPYDZB (HZ, PY)
values ('™n', 'GE');
insert into HZPYDZB (HZ, PY)
values ('™n', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('™o', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('™p', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('™t', 'BO');
insert into HZPYDZB (HZ, PY)
values ('™u', 'MING');
insert into HZPYDZB (HZ, PY)
values ('™v', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('™w', 'MA');
insert into HZPYDZB (HZ, PY)
values ('™y', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('™|', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('™~', 'YI');
insert into HZPYDZB (HZ, PY)
values ('™Ä', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('™Ç', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('™É', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('™Ö', 'MU');
insert into HZPYDZB (HZ, PY)
values ('™á', 'AO');
insert into HZPYDZB (HZ, PY)
values ('™à', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('™â', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('™ã', 'BI');
insert into HZPYDZB (HZ, PY)
values ('™å', 'BI');
insert into HZPYDZB (HZ, PY)
values ('™ç', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('™è', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('™ê', 'XU');
insert into HZPYDZB (HZ, PY)
values ('™ë', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('™ñ', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('™ó', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('™ô', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('™õ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('™ü', 'NING');
insert into HZPYDZB (HZ, PY)
values ('´@', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('´A', 'NOU');
insert into HZPYDZB (HZ, PY)
values ('´B', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('´C', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('´D', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('´E', 'JING');
insert into HZPYDZB (HZ, PY)
values ('´G', 'LU');
insert into HZPYDZB (HZ, PY)
values ('´H', 'TA');
insert into HZPYDZB (HZ, PY)
values ('´J', 'MI');
insert into HZPYDZB (HZ, PY)
values ('´L', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('´M', 'E');
insert into HZPYDZB (HZ, PY)
values ('´M', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('´P', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('´Q', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('´R', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('´R', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('´S', 'LU');
insert into HZPYDZB (HZ, PY)
values ('´T', 'SU');
insert into HZPYDZB (HZ, PY)
values ('´U', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('´W', 'LE');
insert into HZPYDZB (HZ, PY)
values ('´X', 'BA');
insert into HZPYDZB (HZ, PY)
values ('´Y', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('´Z', 'DI');
insert into HZPYDZB (HZ, PY)
values ('´[', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('´\', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('´]', 'YU');
insert into HZPYDZB (HZ, PY)
values ('´^', 'QI');
insert into HZPYDZB (HZ, PY)
values ('´_', 'YU');
insert into HZPYDZB (HZ, PY)
values ('´a', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('´b', 'WU');
insert into HZPYDZB (HZ, PY)
values ('´c', 'FU');
commit;
prompt 6100 records committed...
insert into HZPYDZB (HZ, PY)
values ('´d', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('´e', 'YA');
insert into HZPYDZB (HZ, PY)
values ('´f', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('´g', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('´h', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('´i', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('´j', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('´k', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('´l', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('´m', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('´n', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('´o', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('´p', 'YI');
insert into HZPYDZB (HZ, PY)
values ('´q', 'AN');
insert into HZPYDZB (HZ, PY)
values ('´q', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('´r', 'PING');
insert into HZPYDZB (HZ, PY)
values ('´s', 'FU');
insert into HZPYDZB (HZ, PY)
values ('´t', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('´u', 'CI');
insert into HZPYDZB (HZ, PY)
values ('´u', 'COU');
insert into HZPYDZB (HZ, PY)
values ('´v', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('´w', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('´x', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('´y', 'CI');
insert into HZPYDZB (HZ, PY)
values ('´z', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('´{', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('´}', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('´}', 'YI');
insert into HZPYDZB (HZ, PY)
values ('´~', 'JU');
insert into HZPYDZB (HZ, PY)
values ('´~', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('´Ä', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('´Å', 'BI');
insert into HZPYDZB (HZ, PY)
values ('´Ç', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('´É', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('´Ñ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('´Ö', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('´Ü', 'LI');
insert into HZPYDZB (HZ, PY)
values ('´á', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('´à', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('´â', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('´å', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('´ç', 'XU');
insert into HZPYDZB (HZ, PY)
values ('´é', 'SU');
insert into HZPYDZB (HZ, PY)
values ('´è', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('´ê', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('´ê', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('´í', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('´ï', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('´ñ', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('´ó', 'XU');
insert into HZPYDZB (HZ, PY)
values ('´ò', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('´ô', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('´ö', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('´ù', 'E');
insert into HZPYDZB (HZ, PY)
values ('´û', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('´û', 'TING');
insert into HZPYDZB (HZ, PY)
values ('´ü', 'DI');
insert into HZPYDZB (HZ, PY)
values ('´ü', 'TI');
insert into HZPYDZB (HZ, PY)
values ('´†', 'WU');
insert into HZPYDZB (HZ, PY)
values ('¨@', 'WU');
insert into HZPYDZB (HZ, PY)
values ('¨A', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('¨B', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('¨C', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('¨E', 'TING');
insert into HZPYDZB (HZ, PY)
values ('¨G', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('¨H', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('¨I', 'QIONG');
insert into HZPYDZB (HZ, PY)
values ('¨L', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('¨M', 'FU');
insert into HZPYDZB (HZ, PY)
values ('¨O', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¨P', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¨Q', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('¨R', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('¨S', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('¨T', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('¨U', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('¨V', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('¨X', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('¨X', 'SE');
insert into HZPYDZB (HZ, PY)
values ('¨Y', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('¨[', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('¨\', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('¨]', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('¨]', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('¨^', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('¨_', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('¨`', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('¨a', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('¨a', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('¨b', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('¨d', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('¨e', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('¨f', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¨g', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('¨g', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('¨h', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('¨i', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('¨j', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('¨l', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('¨m', 'FA');
commit;
prompt 6200 records committed...
insert into HZPYDZB (HZ, PY)
values ('¨n', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('¨o', 'DU');
insert into HZPYDZB (HZ, PY)
values ('¨p', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('¨q', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('¨t', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('¨v', 'TI');
insert into HZPYDZB (HZ, PY)
values ('¨z', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('¨{', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('¨|', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('¨Å', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('¨Ç', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('¨Ö', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¨á', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('¨à', 'YA');
insert into HZPYDZB (HZ, PY)
values ('¨â', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('¨ä', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('¨å', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('¨ç', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('¨é', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('¨è', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('¨ë', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('¨í', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('¨î', 'MA');
insert into HZPYDZB (HZ, PY)
values ('¨ï', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('¨ñ', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('¨ò', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('¨ô', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('¨õ', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('¨ú', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('¨ù', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('¨û', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('¨ü', 'TU');
insert into HZPYDZB (HZ, PY)
values ('≠@', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('≠B', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('≠D', 'JI');
insert into HZPYDZB (HZ, PY)
values ('≠E', 'JING');
insert into HZPYDZB (HZ, PY)
values ('≠H', 'AO');
insert into HZPYDZB (HZ, PY)
values ('≠I', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('≠J', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('≠K', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('≠L', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('≠O', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('≠Q', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('≠T', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('≠U', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('≠V', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('≠W', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('≠Y', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('≠Z', 'JING');
insert into HZPYDZB (HZ, PY)
values ('≠[', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('≠]', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('≠^', 'JI');
insert into HZPYDZB (HZ, PY)
values ('≠_', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('≠`', 'JING');
insert into HZPYDZB (HZ, PY)
values ('≠a', 'AI');
insert into HZPYDZB (HZ, PY)
values ('≠f', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('≠h', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('≠i', 'SE');
insert into HZPYDZB (HZ, PY)
values ('≠j', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('≠l', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('≠o', 'FU');
insert into HZPYDZB (HZ, PY)
values ('≠o', 'LU');
insert into HZPYDZB (HZ, PY)
values ('≠p', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('≠s', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('≠u', 'JI');
insert into HZPYDZB (HZ, PY)
values ('≠w', 'RUAN');
insert into HZPYDZB (HZ, PY)
values ('≠x', 'WO');
insert into HZPYDZB (HZ, PY)
values ('≠z', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('≠|', 'LI');
insert into HZPYDZB (HZ, PY)
values ('≠Ä', 'LI');
insert into HZPYDZB (HZ, PY)
values ('≠É', 'TI');
insert into HZPYDZB (HZ, PY)
values ('≠Ñ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('≠Ö', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('≠Ü', 'LA');
insert into HZPYDZB (HZ, PY)
values ('≠á', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('≠à', 'LU');
insert into HZPYDZB (HZ, PY)
values ('≠â', 'LI');
insert into HZPYDZB (HZ, PY)
values ('≠ä', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('≠å', 'MI');
insert into HZPYDZB (HZ, PY)
values ('≠è', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('≠ê', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('≠ì', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≠î', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≠ï', 'HU');
insert into HZPYDZB (HZ, PY)
values ('≠ñ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('≠ó', 'SHIWA');
insert into HZPYDZB (HZ, PY)
values ('≠ò', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('≠ö', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('≠õ', 'PEN');
insert into HZPYDZB (HZ, PY)
values ('≠ú', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('≠ù', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('Æ@', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ÆB', 'BAIWA');
insert into HZPYDZB (HZ, PY)
values ('ÆC', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ÆH', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ÆJ', 'PING');
insert into HZPYDZB (HZ, PY)
values ('ÆK', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ÆL', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('ÆN', 'CI');
insert into HZPYDZB (HZ, PY)
values ('ÆR', 'LOU');
commit;
prompt 6300 records committed...
insert into HZPYDZB (HZ, PY)
values ('ÆT', 'OU');
insert into HZPYDZB (HZ, PY)
values ('ÆU', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('ÆV', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Æ\', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('Æ]', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Æ_', 'QING');
insert into HZPYDZB (HZ, PY)
values ('Æa', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Æb', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Æf', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Æh', 'GAD');
insert into HZPYDZB (HZ, PY)
values ('Æi', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Æj', 'PING');
insert into HZPYDZB (HZ, PY)
values ('Æk', 'DING');
insert into HZPYDZB (HZ, PY)
values ('Æl', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('Æl', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('Æm', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('Æm', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('Æn', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Æo', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('Æp', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('Æq', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Ær', 'MU');
insert into HZPYDZB (HZ, PY)
values ('Æs', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('Æt', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Æu', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('Æv', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Æw', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Æw', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Æx', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('Æz', 'TAP');
insert into HZPYDZB (HZ, PY)
values ('Æ{', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Æ|', 'WA');
insert into HZPYDZB (HZ, PY)
values ('Æ}', 'DA');
insert into HZPYDZB (HZ, PY)
values ('Æ}', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Æ~', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('ÆÄ', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ÆÅ', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ÆÇ', 'CE');
insert into HZPYDZB (HZ, PY)
values ('ÆÉ', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ÆÑ', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('ÆÜ', 'DA');
insert into HZPYDZB (HZ, PY)
values ('Æá', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Æà', 'LUE');
insert into HZPYDZB (HZ, PY)
values ('Æâ', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('Æé', 'MU');
insert into HZPYDZB (HZ, PY)
values ('Æè', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('Æê', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Æñ', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Æó', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('Æò', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('Æô', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('Æö', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('Æõ', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('Æû', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Æü', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Æ†', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('ØC', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ØC', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('ØD', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ØE', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ØF', 'DI');
insert into HZPYDZB (HZ, PY)
values ('ØG', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('ØH', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ØI', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('ØJ', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('ØM', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ØP', 'YA');
insert into HZPYDZB (HZ, PY)
values ('ØQ', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('ØR', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ØV', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ØV', 'FA');
insert into HZPYDZB (HZ, PY)
values ('ØW', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ØX', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ØY', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ØZ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('Ø[', 'NI');
insert into HZPYDZB (HZ, PY)
values ('Ø\', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('Ø]', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Ø^', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ø_', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Ø`', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Øb', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Øc', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('Ød', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Øf', 'TU');
insert into HZPYDZB (HZ, PY)
values ('Øg', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('Øl', 'SHOU');
insert into HZPYDZB (HZ, PY)
values ('Øn', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('Øn', 'BING');
insert into HZPYDZB (HZ, PY)
values ('Øp', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('Øq', 'MA');
insert into HZPYDZB (HZ, PY)
values ('Ør', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Øs', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Øt', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('Øt', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('Øu', 'AN');
insert into HZPYDZB (HZ, PY)
values ('Øw', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Øw', 'PI');
insert into HZPYDZB (HZ, PY)
values ('Øy', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('Øz', 'KE');
commit;
prompt 6400 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ø|', 'CU');
insert into HZPYDZB (HZ, PY)
values ('ØÄ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ØÉ', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('ØÉ', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('ØÖ', 'TU');
insert into HZPYDZB (HZ, PY)
values ('ØÜ', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('Øâ', 'KU');
insert into HZPYDZB (HZ, PY)
values ('Øã', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Øë', 'NVE');
insert into HZPYDZB (HZ, PY)
values ('Øí', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('Øï', 'CU');
insert into HZPYDZB (HZ, PY)
values ('Øò', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('Øõ', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('Øú', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('Øú', 'LV');
insert into HZPYDZB (HZ, PY)
values ('Øü', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('Øü', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('∞A', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('∞F', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∞J', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('∞N', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('∞O', 'LI');
insert into HZPYDZB (HZ, PY)
values ('∞R', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('∞S', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('∞T', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('∞U', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∞W', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('∞[', 'LI');
insert into HZPYDZB (HZ, PY)
values ('∞\', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('∞]', 'LA');
insert into HZPYDZB (HZ, PY)
values ('∞]', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('∞^', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∞e', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('∞f', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('∞i', 'UU');
insert into HZPYDZB (HZ, PY)
values ('∞k', 'FA');
insert into HZPYDZB (HZ, PY)
values ('∞l', 'BO');
insert into HZPYDZB (HZ, PY)
values ('∞l', 'FA');
insert into HZPYDZB (HZ, PY)
values ('∞m', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('∞n', 'BI');
insert into HZPYDZB (HZ, PY)
values ('∞n', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∞o', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('∞p', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('∞q', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞q', 'PA');
insert into HZPYDZB (HZ, PY)
values ('∞r', 'CI');
insert into HZPYDZB (HZ, PY)
values ('∞s', 'LING');
insert into HZPYDZB (HZ, PY)
values ('∞t', 'MO');
insert into HZPYDZB (HZ, PY)
values ('∞u', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∞w', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('∞x', 'E');
insert into HZPYDZB (HZ, PY)
values ('∞y', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('∞z', 'BI');
insert into HZPYDZB (HZ, PY)
values ('∞{', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('∞|', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('∞}', 'AI');
insert into HZPYDZB (HZ, PY)
values ('∞Ä', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∞Å', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('∞Ç', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∞É', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('∞Ñ', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('∞å', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('∞ç', 'BO');
insert into HZPYDZB (HZ, PY)
values ('∞è', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∞ë', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∞ñ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('∞ò', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('∞ö', 'CU');
insert into HZPYDZB (HZ, PY)
values ('∞õ', 'UU');
insert into HZPYDZB (HZ, PY)
values ('∞ú', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('∞ü', 'YING');
insert into HZPYDZB (HZ, PY)
values ('∞°', 'A');
insert into HZPYDZB (HZ, PY)
values ('∞°', 'E');
insert into HZPYDZB (HZ, PY)
values ('∞¢', 'A');
insert into HZPYDZB (HZ, PY)
values ('∞¢', 'E');
insert into HZPYDZB (HZ, PY)
values ('∞£', 'AI');
insert into HZPYDZB (HZ, PY)
values ('∞§', 'AI');
insert into HZPYDZB (HZ, PY)
values ('∞•', 'AI');
insert into HZPYDZB (HZ, PY)
values ('∞¶', 'AI');
insert into HZPYDZB (HZ, PY)
values ('∞ß', 'AI');
insert into HZPYDZB (HZ, PY)
values ('∞®', 'AI');
insert into HZPYDZB (HZ, PY)
values ('∞©', 'AI');
insert into HZPYDZB (HZ, PY)
values ('∞™', 'AI');
insert into HZPYDZB (HZ, PY)
values ('∞´', 'AI');
insert into HZPYDZB (HZ, PY)
values ('∞¨', 'AI');
insert into HZPYDZB (HZ, PY)
values ('∞≠', 'AI');
insert into HZPYDZB (HZ, PY)
values ('∞Æ', 'AI');
insert into HZPYDZB (HZ, PY)
values ('∞Ø', 'AI');
insert into HZPYDZB (HZ, PY)
values ('∞∞', 'AN');
insert into HZPYDZB (HZ, PY)
values ('∞±', 'AN');
insert into HZPYDZB (HZ, PY)
values ('∞≤', 'AN');
insert into HZPYDZB (HZ, PY)
values ('∞≥', 'AN');
insert into HZPYDZB (HZ, PY)
values ('∞µ', 'AN');
insert into HZPYDZB (HZ, PY)
values ('∞∂', 'AN');
insert into HZPYDZB (HZ, PY)
values ('∞∑', 'AN');
insert into HZPYDZB (HZ, PY)
values ('∞∑', 'E');
insert into HZPYDZB (HZ, PY)
values ('∞∏', 'AN');
insert into HZPYDZB (HZ, PY)
values ('∞π', 'ANG');
insert into HZPYDZB (HZ, PY)
values ('∞∫', 'ANG');
insert into HZPYDZB (HZ, PY)
values ('∞ª', 'ANG');
commit;
prompt 6500 records committed...
insert into HZPYDZB (HZ, PY)
values ('∞º', 'AO');
insert into HZPYDZB (HZ, PY)
values ('∞º', 'WA');
insert into HZPYDZB (HZ, PY)
values ('∞Ω', 'AO');
insert into HZPYDZB (HZ, PY)
values ('∞æ', 'AO');
insert into HZPYDZB (HZ, PY)
values ('∞ø', 'AO');
insert into HZPYDZB (HZ, PY)
values ('∞¿', 'AO');
insert into HZPYDZB (HZ, PY)
values ('∞¡', 'AO');
insert into HZPYDZB (HZ, PY)
values ('∞¬', 'AO');
insert into HZPYDZB (HZ, PY)
values ('∞√', 'AO');
insert into HZPYDZB (HZ, PY)
values ('∞ƒ', 'AO');
insert into HZPYDZB (HZ, PY)
values ('∞≈', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞≈', 'PA');
insert into HZPYDZB (HZ, PY)
values ('∞∆', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞«', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞»', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞…', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞ ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞À', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞Ã', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞Õ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞Œ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞Œ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('∞œ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞–', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞—', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞“', 'PA');
insert into HZPYDZB (HZ, PY)
values ('∞”', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞‘', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞’', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞÷', 'BA');
insert into HZPYDZB (HZ, PY)
values ('∞◊', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('∞ÿ', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('∞Ÿ', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('∞⁄', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('∞€', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('∞‹', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('∞›', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('∞ﬁ', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('∞ﬂ', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞‡', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞·', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞‚', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞„', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞‰', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞Â', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞Ê', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞Á', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞Ë', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞È', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞Í', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞Î', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞Ï', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞Ì', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∞Ó', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('∞Ô', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('∞', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('∞Ò', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('∞Ú', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('∞Û', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('∞Ù', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('∞ı', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('∞ˆ', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('∞˜', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('∞¯', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('∞˘', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('∞˙', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('∞˚', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('∞¸', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('∞˝', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('∞˛', 'BO');
insert into HZPYDZB (HZ, PY)
values ('±B', 'HE');
insert into HZPYDZB (HZ, PY)
values ('±C', 'BO');
insert into HZPYDZB (HZ, PY)
values ('±D', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('±H', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('±L', 'LI');
insert into HZPYDZB (HZ, PY)
values ('±M', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('±O', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('±Q', 'AN');
insert into HZPYDZB (HZ, PY)
values ('±R', 'LV');
insert into HZPYDZB (HZ, PY)
values ('±T', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('±U', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('±X', 'LI');
insert into HZPYDZB (HZ, PY)
values ('±Y', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('±Z', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('±Z', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('±[', 'QI');
insert into HZPYDZB (HZ, PY)
values ('±]', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('±]', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('±^', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('±_', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('±`', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('±a', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('±b', 'MING');
insert into HZPYDZB (HZ, PY)
values ('±c', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('±d', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('±e', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('±f', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('±g', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('±g', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('±h', 'XIAN');
commit;
prompt 6600 records committed...
insert into HZPYDZB (HZ, PY)
values ('±i', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('±j', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('±j', 'YING');
insert into HZPYDZB (HZ, PY)
values ('±k', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('±l', 'AO');
insert into HZPYDZB (HZ, PY)
values ('±n', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('±o', 'DA');
insert into HZPYDZB (HZ, PY)
values ('±p', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('±q', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('±r', 'JU');
insert into HZPYDZB (HZ, PY)
values ('±r', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('±t', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('±u', 'MIE');
insert into HZPYDZB (HZ, PY)
values ('±u', 'MO');
insert into HZPYDZB (HZ, PY)
values ('±v', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('±w', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('±y', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('±y', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('±z', 'NI');
insert into HZPYDZB (HZ, PY)
values ('±|', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('±}', 'BING');
insert into HZPYDZB (HZ, PY)
values ('±~', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('±Ä', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('±Å', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('±Ç', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('±É', 'DI');
insert into HZPYDZB (HZ, PY)
values ('±Ñ', 'NE');
insert into HZPYDZB (HZ, PY)
values ('±Ö', 'MING');
insert into HZPYDZB (HZ, PY)
values ('±Ü', 'SHUN');
insert into HZPYDZB (HZ, PY)
values ('±á', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('±à', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('±â', 'MI');
insert into HZPYDZB (HZ, PY)
values ('±â', 'MO');
insert into HZPYDZB (HZ, PY)
values ('±ã', 'MO');
insert into HZPYDZB (HZ, PY)
values ('±ç', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('±ç', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('±é', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('±ê', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('±ë', 'ZHUAI');
insert into HZPYDZB (HZ, PY)
values ('±í', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('±ì', 'E');
insert into HZPYDZB (HZ, PY)
values ('±î', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('±ó', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('±ô', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('±õ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('±ú', 'LENG');
insert into HZPYDZB (HZ, PY)
values ('±ü', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('±†', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('±°', 'BO');
insert into HZPYDZB (HZ, PY)
values ('±¢', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('±£', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('±§', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('±§', 'PU');
insert into HZPYDZB (HZ, PY)
values ('±•', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('±¶', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('±ß', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('±®', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('±©', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('±™', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('±´', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('±´', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('±¨', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('±≠', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±Æ', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±Ø', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±∞', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±±', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±≤', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±≥', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±¥', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±µ', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±∂', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±∑', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±∏', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±π', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±∫', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±ª', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±º', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('±Ω', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('±æ', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('±ø', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('±¿', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('±¡', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('±¬', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('±√', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('±ƒ', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('±≈', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('±∆', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±«', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±»', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±…', 'BI');
insert into HZPYDZB (HZ, PY)
values ('± ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±À', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±Ã', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±Õ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±Œ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±œ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±–', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±—', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±“', 'BI');
commit;
prompt 6700 records committed...
insert into HZPYDZB (HZ, PY)
values ('±”', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±‘', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±’', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±÷', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±◊', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±ÿ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±Ÿ', 'PI');
insert into HZPYDZB (HZ, PY)
values ('±⁄', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±€', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('±€', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±‹', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±›', 'BI');
insert into HZPYDZB (HZ, PY)
values ('±ﬁ', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('±ﬂ', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('±‡', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('±·', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('±‚', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('±„', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('±„', 'PIAN');
insert into HZPYDZB (HZ, PY)
values ('±‰', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('±Â', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('±Ê', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('±Á', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('±Ë', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('±È', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('±Í', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('±Î', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('±Ï', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('±Ì', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('±Ó', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('±Ô', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('±', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('±Ò', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('±Ú', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('±Û', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('±Ù', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('±ı', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('±ˆ', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('±˜', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('±¯', 'BING');
insert into HZPYDZB (HZ, PY)
values ('±˘', 'BING');
insert into HZPYDZB (HZ, PY)
values ('±˙', 'BING');
insert into HZPYDZB (HZ, PY)
values ('±˚', 'BING');
insert into HZPYDZB (HZ, PY)
values ('±¸', 'BING');
insert into HZPYDZB (HZ, PY)
values ('±˝', 'BING');
insert into HZPYDZB (HZ, PY)
values ('±˛', 'BING');
insert into HZPYDZB (HZ, PY)
values ('≤@', 'LI');
insert into HZPYDZB (HZ, PY)
values ('≤B', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('≤C', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('≤E', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('≤F', 'LU');
insert into HZPYDZB (HZ, PY)
values ('≤G', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('≤J', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('≤K', 'MA');
insert into HZPYDZB (HZ, PY)
values ('≤L', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('≤Q', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('≤R', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('≤S', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('≤T', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('≤Y', 'WO');
insert into HZPYDZB (HZ, PY)
values ('≤Z', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('≤[', 'MI');
insert into HZPYDZB (HZ, PY)
values ('≤]', 'JI');
insert into HZPYDZB (HZ, PY)
values ('≤]', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('≤^', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('≤_', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('≤`', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('≤b', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('≤g', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('≤h', 'MO');
insert into HZPYDZB (HZ, PY)
values ('≤i', 'SHUN');
insert into HZPYDZB (HZ, PY)
values ('≤j', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('≤k', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('≤k', 'LV');
insert into HZPYDZB (HZ, PY)
values ('≤m', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('≤m', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('≤p', 'SHUN');
insert into HZPYDZB (HZ, PY)
values ('≤r', 'PU');
insert into HZPYDZB (HZ, PY)
values ('≤t', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('≤u', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('≤y', 'MI');
insert into HZPYDZB (HZ, PY)
values ('≤y', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('≤z', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('≤}', 'AI');
insert into HZPYDZB (HZ, PY)
values ('≤É', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('≤Ö', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≤Ö', 'NING');
insert into HZPYDZB (HZ, PY)
values ('≤à', 'WO');
insert into HZPYDZB (HZ, PY)
values ('≤â', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('≤ç', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('≤é', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('≤ë', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('≤í', 'LU');
insert into HZPYDZB (HZ, PY)
values ('≤î', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('≤ï', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('≤ó', 'LI');
insert into HZPYDZB (HZ, PY)
values ('≤ò', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('≤ô', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('≤õ', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('≤ú', 'JUE');
commit;
prompt 6800 records committed...
insert into HZPYDZB (HZ, PY)
values ('≤ù', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('≤û', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('≤ü', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('≤†', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('≤°', 'BING');
insert into HZPYDZB (HZ, PY)
values ('≤¢', 'BING');
insert into HZPYDZB (HZ, PY)
values ('≤£', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤§', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤•', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤¶', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤ß', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤®', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤©', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤™', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤´', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤¨', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤≠', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤Æ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤Ø', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤∞', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤±', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤≤', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤≥', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤¥', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤¥', 'PO');
insert into HZPYDZB (HZ, PY)
values ('≤µ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤∂', 'BU');
insert into HZPYDZB (HZ, PY)
values ('≤∑', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≤∑', 'BU');
insert into HZPYDZB (HZ, PY)
values ('≤∏', 'BU');
insert into HZPYDZB (HZ, PY)
values ('≤∏', 'FU');
insert into HZPYDZB (HZ, PY)
values ('≤π', 'BU');
insert into HZPYDZB (HZ, PY)
values ('≤∫', 'BU');
insert into HZPYDZB (HZ, PY)
values ('≤ª', 'BU');
insert into HZPYDZB (HZ, PY)
values ('≤º', 'BU');
insert into HZPYDZB (HZ, PY)
values ('≤Ω', 'BU');
insert into HZPYDZB (HZ, PY)
values ('≤æ', 'BU');
insert into HZPYDZB (HZ, PY)
values ('≤ø', 'BU');
insert into HZPYDZB (HZ, PY)
values ('≤¿', 'BU');
insert into HZPYDZB (HZ, PY)
values ('≤¡', 'CA');
insert into HZPYDZB (HZ, PY)
values ('≤¬', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('≤√', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('≤ƒ', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('≤≈', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('≤∆', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('≤«', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('≤»', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('≤…', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('≤ ', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('≤À', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('≤Ã', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('≤Õ', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('≤Œ', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('≤Œ', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('≤œ', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('≤–', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('≤—', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('≤“', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('≤”', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('≤‘', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('≤’', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('≤÷', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('≤◊', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('≤ÿ', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('≤ÿ', 'ZANG');
insert into HZPYDZB (HZ, PY)
values ('≤Ÿ', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('≤⁄', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('≤€', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('≤‹', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('≤›', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('≤ﬁ', 'CE');
insert into HZPYDZB (HZ, PY)
values ('≤ﬂ', 'CE');
insert into HZPYDZB (HZ, PY)
values ('≤‡', 'CE');
insert into HZPYDZB (HZ, PY)
values ('≤·', 'CE');
insert into HZPYDZB (HZ, PY)
values ('≤‚', 'CE');
insert into HZPYDZB (HZ, PY)
values ('≤„', 'CENG');
insert into HZPYDZB (HZ, PY)
values ('≤‰', 'CENG');
insert into HZPYDZB (HZ, PY)
values ('≤Â', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('≤Ê', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('≤Á', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('≤Ë', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('≤È', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('≤Í', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('≤Î', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('≤Ï', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('≤Ì', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('≤Ó', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('≤Ó', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('≤Ô', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('≤', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('≤Ò', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('≤Ú', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('≤Û', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('≤Ù', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('≤ı', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('≤ˆ', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('≤˜', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('≤¯', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('≤˘', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('≤˙', 'CHAN');
commit;
prompt 6900 records committed...
insert into HZPYDZB (HZ, PY)
values ('≤˚', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('≤¸', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('≤˝', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('≤˛', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('≥@', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('≥B', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('≥D', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('≥F', 'BA');
insert into HZPYDZB (HZ, PY)
values ('≥G', 'DING');
insert into HZPYDZB (HZ, PY)
values ('≥H', 'QI');
insert into HZPYDZB (HZ, PY)
values ('≥I', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('≥J', 'WU');
insert into HZPYDZB (HZ, PY)
values ('≥K', 'DA');
insert into HZPYDZB (HZ, PY)
values ('≥K', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('≥L', 'KU');
insert into HZPYDZB (HZ, PY)
values ('≥L', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('≥M', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('≥M', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('≥N', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('≥O', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('≥P', 'LI');
insert into HZPYDZB (HZ, PY)
values ('≥Q', 'FU');
insert into HZPYDZB (HZ, PY)
values ('≥R', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('≥R', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('≥T', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('≥V', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('≥W', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('≥Y', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('≥Z', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('≥[', 'WA');
insert into HZPYDZB (HZ, PY)
values ('≥\', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('≥]', 'MO');
insert into HZPYDZB (HZ, PY)
values ('≥^', 'JU');
insert into HZPYDZB (HZ, PY)
values ('≥^', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('≥_', 'YU');
insert into HZPYDZB (HZ, PY)
values ('≥`', 'KE');
insert into HZPYDZB (HZ, PY)
values ('≥a', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('≥c', 'MU');
insert into HZPYDZB (HZ, PY)
values ('≥d', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('≥e', 'NU');
insert into HZPYDZB (HZ, PY)
values ('≥f', 'PING');
insert into HZPYDZB (HZ, PY)
values ('≥g', 'LING');
insert into HZPYDZB (HZ, PY)
values ('≥h', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('≥i', 'LE');
insert into HZPYDZB (HZ, PY)
values ('≥j', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≥j', 'E');
insert into HZPYDZB (HZ, PY)
values ('≥k', 'PO');
insert into HZPYDZB (HZ, PY)
values ('≥m', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('≥n', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('≥o', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('≥p', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('≥q', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('≥q', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('≥s', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('≥t', 'LU');
insert into HZPYDZB (HZ, PY)
values ('≥u', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('≥u', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('≥v', 'AI');
insert into HZPYDZB (HZ, PY)
values ('≥w', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('≥x', 'XING');
insert into HZPYDZB (HZ, PY)
values ('≥x', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('≥y', 'PING');
insert into HZPYDZB (HZ, PY)
values ('≥z', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('≥{', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('≥|', 'QING');
insert into HZPYDZB (HZ, PY)
values ('≥}', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('≥~', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('≥Ä', 'CEOK');
insert into HZPYDZB (HZ, PY)
values ('≥Å', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('≥Ç', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('≥É', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('≥Ñ', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('≥Ö', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('≥â', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('≥ä', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('≥ä', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('≥ã', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('≥ç', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('≥é', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('≥è', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('≥ê', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('≥ë', 'GU');
insert into HZPYDZB (HZ, PY)
values ('≥í', 'CEOK');
insert into HZPYDZB (HZ, PY)
values ('≥ì', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('≥î', 'LU');
insert into HZPYDZB (HZ, PY)
values ('≥ï', 'CEN');
insert into HZPYDZB (HZ, PY)
values ('≥ï', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('≥ñ', 'NUE');
insert into HZPYDZB (HZ, PY)
values ('≥ò', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('≥ô', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('≥õ', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('≥ú', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('≥ù', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥ü', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('≥†', 'QING');
insert into HZPYDZB (HZ, PY)
values ('≥°', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('≥¢', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('≥£', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('≥§', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('≥§', 'ZHANG');
commit;
prompt 7000 records committed...
insert into HZPYDZB (HZ, PY)
values ('≥•', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('≥¶', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('≥ß', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('≥®', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('≥©', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('≥™', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('≥´', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('≥¨', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('≥≠', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('≥Æ', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('≥Ø', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('≥Ø', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('≥∞', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('≥≤', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('≥≥', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('≥¥', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('≥µ', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('≥µ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('≥∂', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('≥∑', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('≥∏', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('≥π', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('≥∫', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('≥ª', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('≥ª', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('≥º', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('≥Ω', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('≥æ', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('≥ø', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('≥¿', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('≥¿', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('≥¡', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('≥¬', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('≥√', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('≥ƒ', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('≥≈', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥∆', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('≥∆', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥«', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥»', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥…', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥ ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥À', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥Ã', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥Œ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥Œ', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('≥œ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥–', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥—', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥“', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥”', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('≥‘', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('≥‘', 'QI');
insert into HZPYDZB (HZ, PY)
values ('≥’', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('≥÷', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('≥◊', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('≥ÿ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('≥Ÿ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('≥⁄', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('≥€', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('≥‹', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('≥›', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('≥ﬁ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('≥ﬂ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('≥‡', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('≥·', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('≥‚', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('≥„', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('≥‰', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('≥Â', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('≥Ê', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('≥Á', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('≥Ë', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('≥È', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('≥Í', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('≥Î', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('≥Ì', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('≥Ó', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('≥Ô', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('≥', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('≥', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('≥Ò', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('≥Ú', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('≥Û', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('≥Ù', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('≥Ù', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('≥ı', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('≥ˆ', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('≥˜', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('≥¯', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('≥˘', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('≥˙', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('≥˚', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('≥¸', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('≥˝', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('≥˛', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('¥@', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('¥A', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('¥B', 'BO');
insert into HZPYDZB (HZ, PY)
values ('¥C', 'MIN');
commit;
prompt 7100 records committed...
insert into HZPYDZB (HZ, PY)
values ('¥D', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('¥E', 'HE');
insert into HZPYDZB (HZ, PY)
values ('¥G', 'LENG');
insert into HZPYDZB (HZ, PY)
values ('¥I', 'WU');
insert into HZPYDZB (HZ, PY)
values ('¥J', 'QI');
insert into HZPYDZB (HZ, PY)
values ('¥L', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('¥L', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('¥O', 'DING');
insert into HZPYDZB (HZ, PY)
values ('¥P', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('¥Q', 'YING');
insert into HZPYDZB (HZ, PY)
values ('¥R', 'KE');
insert into HZPYDZB (HZ, PY)
values ('¥S', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('¥T', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('¥U', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('¥V', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('¥Y', 'DI');
insert into HZPYDZB (HZ, PY)
values ('¥Y', 'TI');
insert into HZPYDZB (HZ, PY)
values ('¥Z', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('¥[', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('¥\', 'QI');
insert into HZPYDZB (HZ, PY)
values ('¥]', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('¥`', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('¥`', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('¥a', 'MA');
insert into HZPYDZB (HZ, PY)
values ('¥c', 'SU');
insert into HZPYDZB (HZ, PY)
values ('¥e', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('¥g', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('¥h', 'GU');
insert into HZPYDZB (HZ, PY)
values ('¥j', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('¥j', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('¥k', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('¥l', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('¥m', 'QI');
insert into HZPYDZB (HZ, PY)
values ('¥n', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¥o', 'AI');
insert into HZPYDZB (HZ, PY)
values ('¥q', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('¥r', 'LA');
insert into HZPYDZB (HZ, PY)
values ('¥t', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('¥u', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('¥x', 'AO');
insert into HZPYDZB (HZ, PY)
values ('¥{', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¥|', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('¥}', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('¥Ö', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('¥á', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('¥à', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('¥â', 'JI');
insert into HZPYDZB (HZ, PY)
values ('¥ä', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('¥ã', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('¥å', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('¥ê', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('¥ë', 'BO');
insert into HZPYDZB (HZ, PY)
values ('¥ë', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('¥ì', 'AO');
insert into HZPYDZB (HZ, PY)
values ('¥ï', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¥ù', 'AO');
insert into HZPYDZB (HZ, PY)
values ('¥û', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('¥û', 'KE');
insert into HZPYDZB (HZ, PY)
values ('¥†', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¥°', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('¥¢', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('¥£', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('¥§', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('¥•', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('¥¶', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('¥ß', 'CHUAI');
insert into HZPYDZB (HZ, PY)
values ('¥®', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('¥©', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('¥™', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('¥´', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('¥¨', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('¥≠', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('¥Æ', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('¥Ø', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('¥∞', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('¥±', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('¥≤', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('¥≥', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('¥¥', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('¥µ', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('¥∂', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('¥∑', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('¥∏', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('¥π', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('¥∫', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('¥ª', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('¥º', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('¥Ω', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('¥æ', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('¥ø', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('¥¿', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('¥¡', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('¥¬', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('¥√', 'CI');
insert into HZPYDZB (HZ, PY)
values ('¥ƒ', 'CI');
insert into HZPYDZB (HZ, PY)
values ('¥≈', 'CI');
insert into HZPYDZB (HZ, PY)
values ('¥∆', 'CI');
insert into HZPYDZB (HZ, PY)
values ('¥«', 'CI');
insert into HZPYDZB (HZ, PY)
values ('¥»', 'CI');
insert into HZPYDZB (HZ, PY)
values ('¥…', 'CI');
commit;
prompt 7200 records committed...
insert into HZPYDZB (HZ, PY)
values ('¥ ', 'CI');
insert into HZPYDZB (HZ, PY)
values ('¥À', 'CI');
insert into HZPYDZB (HZ, PY)
values ('¥Ã', 'CI');
insert into HZPYDZB (HZ, PY)
values ('¥Õ', 'CI');
insert into HZPYDZB (HZ, PY)
values ('¥Œ', 'CI');
insert into HZPYDZB (HZ, PY)
values ('¥œ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('¥–', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('¥—', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('¥“', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('¥”', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('¥‘', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('¥’', 'COU');
insert into HZPYDZB (HZ, PY)
values ('¥÷', 'CU');
insert into HZPYDZB (HZ, PY)
values ('¥◊', 'CU');
insert into HZPYDZB (HZ, PY)
values ('¥ÿ', 'CU');
insert into HZPYDZB (HZ, PY)
values ('¥Ÿ', 'CU');
insert into HZPYDZB (HZ, PY)
values ('¥⁄', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('¥€', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('¥‹', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('¥›', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('¥ﬁ', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('¥ﬂ', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('¥‡', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('¥·', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('¥‚', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('¥„', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('¥‰', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('¥Â', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('¥Ê', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('¥Á', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('¥Ë', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('¥È', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('¥Í', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('¥Î', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('¥Ï', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('¥Ì', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('¥Ó', 'DA');
insert into HZPYDZB (HZ, PY)
values ('¥Ô', 'DA');
insert into HZPYDZB (HZ, PY)
values ('¥', 'DA');
insert into HZPYDZB (HZ, PY)
values ('¥Ò', 'DA');
insert into HZPYDZB (HZ, PY)
values ('¥Ú', 'DA');
insert into HZPYDZB (HZ, PY)
values ('¥Û', 'DA');
insert into HZPYDZB (HZ, PY)
values ('¥Û', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('¥Ù', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('¥ı', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('¥ˆ', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('¥˜', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('¥¯', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('¥˘', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('¥˙', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('¥˚', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('¥¸', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('¥˝', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('¥˛', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('µ@', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('µA', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('µC', 'HU');
insert into HZPYDZB (HZ, PY)
values ('µD', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('µJ', 'E');
insert into HZPYDZB (HZ, PY)
values ('µL', 'KE');
insert into HZPYDZB (HZ, PY)
values ('µO', 'RUAN');
insert into HZPYDZB (HZ, PY)
values ('µR', 'BO');
insert into HZPYDZB (HZ, PY)
values ('µT', 'MA');
insert into HZPYDZB (HZ, PY)
values ('µW', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('µX', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('µZ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('µ[', 'LI');
insert into HZPYDZB (HZ, PY)
values ('µ[', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('µ`', 'LI');
insert into HZPYDZB (HZ, PY)
values ('µa', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('µb', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('µc', 'MO');
insert into HZPYDZB (HZ, PY)
values ('µe', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('µf', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('µi', 'RENG');
insert into HZPYDZB (HZ, PY)
values ('µj', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('µl', 'MA');
insert into HZPYDZB (HZ, PY)
values ('µn', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('µo', 'QI');
insert into HZPYDZB (HZ, PY)
values ('µo', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('µp', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('µp', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('µq', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('µr', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('µr', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('µs', 'UU');
insert into HZPYDZB (HZ, PY)
values ('µt', 'YI');
insert into HZPYDZB (HZ, PY)
values ('µu', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('µv', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('µw', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('µx', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('µy', 'FU');
insert into HZPYDZB (HZ, PY)
values ('µz', 'MI');
insert into HZPYDZB (HZ, PY)
values ('µ{', 'SUAN');
insert into HZPYDZB (HZ, PY)
values ('µ|', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('µ}', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('µ~', 'LV');
insert into HZPYDZB (HZ, PY)
values ('µÄ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('µÅ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('µÇ', 'ZHU');
commit;
prompt 7300 records committed...
insert into HZPYDZB (HZ, PY)
values ('µÉ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('µÖ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('µÜ', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('µá', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('µà', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('µà', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('µâ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('µä', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('µã', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('µå', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('µç', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µé', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('µè', 'GU');
insert into HZPYDZB (HZ, PY)
values ('µê', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('µì', 'LU');
insert into HZPYDZB (HZ, PY)
values ('µî', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('µï', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('µñ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('µó', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('µò', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('µõ', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('µú', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('µù', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('µü', 'WU');
insert into HZPYDZB (HZ, PY)
values ('µ°', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('µ¢', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µ£', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µ§', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µ•', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µ•', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('µ¶', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µß', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µ®', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µ©', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µ™', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µ´', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µ¨', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µ≠', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µÆ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µØ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µØ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('µ∞', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('µ±', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('µ≤', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('µ≥', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('µ¥', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('µµ', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('µ∂', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('µ∑', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('µ∏', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('µπ', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('µ∫', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('µª', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('µº', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('µΩ', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('µæ', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('µø', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('µ¿', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('µ¡', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('µ¬', 'DE');
insert into HZPYDZB (HZ, PY)
values ('µ√', 'DE');
insert into HZPYDZB (HZ, PY)
values ('µƒ', 'DE');
insert into HZPYDZB (HZ, PY)
values ('µƒ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µ≈', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('µ∆', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('µ«', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('µ»', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('µ…', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('µ ', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('µÀ', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('µÃ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µÕ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µŒ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µœ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µ–', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µ—', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µ“', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µ”', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µ‘', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('µ’', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µ÷', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µ◊', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µÿ', 'DE');
insert into HZPYDZB (HZ, PY)
values ('µÿ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µŸ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µ⁄', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µ€', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µ‹', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µ›', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µﬁ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('µﬂ', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µ‡', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µ·', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µ‚', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µ„', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µ‰', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µÂ', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µÊ', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µÁ', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µË', 'DIAN');
commit;
prompt 7400 records committed...
insert into HZPYDZB (HZ, PY)
values ('µÈ', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µÍ', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µÎ', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µÏ', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µÌ', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µÓ', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('µÔ', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('µ', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('µÒ', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('µÚ', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('µÛ', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('µÙ', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('µı', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('µˆ', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('µ˜', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('µ˜', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('µ¯', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('µ˘', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('µ˙', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('µ˚', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('µ¸', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('µ¸', 'YI');
insert into HZPYDZB (HZ, PY)
values ('µ˝', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('µ˛', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('∂A', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('∂D', 'SI');
insert into HZPYDZB (HZ, PY)
values ('∂E', 'DI');
insert into HZPYDZB (HZ, PY)
values ('∂F', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('∂G', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('∂I', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∂J', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('∂K', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('∂M', 'MA');
insert into HZPYDZB (HZ, PY)
values ('∂N', 'TA');
insert into HZPYDZB (HZ, PY)
values ('∂O', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∂Q', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∂S', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∂T', 'SI');
insert into HZPYDZB (HZ, PY)
values ('∂U', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('∂V', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('∂X', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('∂Y', 'LI');
insert into HZPYDZB (HZ, PY)
values ('∂Z', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('∂[', 'MI');
insert into HZPYDZB (HZ, PY)
values ('∂\', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('∂_', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('∂_', 'TI');
insert into HZPYDZB (HZ, PY)
values ('∂d', 'TU');
insert into HZPYDZB (HZ, PY)
values ('∂e', 'REN');
insert into HZPYDZB (HZ, PY)
values ('∂f', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('∂g', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('∂g', 'NA');
insert into HZPYDZB (HZ, PY)
values ('∂h', 'YI');
insert into HZPYDZB (HZ, PY)
values ('∂h', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('∂j', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('∂l', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∂m', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∂m', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('∂o', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('∂p', 'JING');
insert into HZPYDZB (HZ, PY)
values ('∂q', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('∂s', 'KU');
insert into HZPYDZB (HZ, PY)
values ('∂t', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('∂v', 'NI');
insert into HZPYDZB (HZ, PY)
values ('∂w', 'LI');
insert into HZPYDZB (HZ, PY)
values ('∂x', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('∂z', 'BO');
insert into HZPYDZB (HZ, PY)
values ('∂{', 'LING');
insert into HZPYDZB (HZ, PY)
values ('∂|', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('∂}', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('∂~', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('∂Ä', 'JU');
insert into HZPYDZB (HZ, PY)
values ('∂Å', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('∂Ç', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('∂É', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('∂É', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('∂Ñ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('∂Ñ', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('∂Ö', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∂Ö', 'HE');
insert into HZPYDZB (HZ, PY)
values ('∂à', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('∂ä', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂ã', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('∂å', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('∂ç', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∂é', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('∂è', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('∂ê', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('∂ë', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('∂í', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∂ì', 'JING');
insert into HZPYDZB (HZ, PY)
values ('∂î', 'TI');
insert into HZPYDZB (HZ, PY)
values ('∂ï', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('∂ï', 'TU');
insert into HZPYDZB (HZ, PY)
values ('∂ó', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('∂ò', 'LU');
insert into HZPYDZB (HZ, PY)
values ('∂ô', 'GU');
insert into HZPYDZB (HZ, PY)
values ('∂ö', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('∂õ', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('∂ú', 'BANG');
commit;
prompt 7500 records committed...
insert into HZPYDZB (HZ, PY)
values ('∂ù', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∂û', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('∂ü', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('∂†', 'LENG');
insert into HZPYDZB (HZ, PY)
values ('∂°', 'DING');
insert into HZPYDZB (HZ, PY)
values ('∂¢', 'DING');
insert into HZPYDZB (HZ, PY)
values ('∂£', 'DING');
insert into HZPYDZB (HZ, PY)
values ('∂§', 'DING');
insert into HZPYDZB (HZ, PY)
values ('∂•', 'DING');
insert into HZPYDZB (HZ, PY)
values ('∂¶', 'DING');
insert into HZPYDZB (HZ, PY)
values ('∂ß', 'DING');
insert into HZPYDZB (HZ, PY)
values ('∂®', 'DING');
insert into HZPYDZB (HZ, PY)
values ('∂©', 'DING');
insert into HZPYDZB (HZ, PY)
values ('∂™', 'DIU');
insert into HZPYDZB (HZ, PY)
values ('∂´', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('∂¨', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('∂≠', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('∂Æ', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('∂Ø', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('∂∞', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('∂±', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('∂±', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('∂≤', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('∂≤', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('∂≥', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('∂¥', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('∂µ', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('∂∂', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('∂∑', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('∂∏', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('∂π', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('∂∫', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('∂ª', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('∂º', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('∂º', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂Ω', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂æ', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂ø', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂¿', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂¡', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂¬', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂√', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂ƒ', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂≈', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂∆', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂«', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂»', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂»', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('∂…', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂ ', 'DU');
insert into HZPYDZB (HZ, PY)
values ('∂À', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('∂Ã', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('∂Õ', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('∂Œ', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('∂œ', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('∂–', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('∂—', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('∂“', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('∂”', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('∂‘', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('∂’', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('∂÷', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('∂◊', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('∂ÿ', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('∂ÿ', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('∂Ÿ', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('∂⁄', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('∂€', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('∂‹', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('∂›', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('∂ﬁ', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('∂ﬂ', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('∂‡', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('∂·', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('∂‚', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('∂„', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('∂‰', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('∂Â', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('∂Ê', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('∂Á', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('∂Ë', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('∂È', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('∂Í', 'E');
insert into HZPYDZB (HZ, PY)
values ('∂Î', 'E');
insert into HZPYDZB (HZ, PY)
values ('∂Ï', 'E');
insert into HZPYDZB (HZ, PY)
values ('∂Ì', 'E');
insert into HZPYDZB (HZ, PY)
values ('∂Ó', 'E');
insert into HZPYDZB (HZ, PY)
values ('∂Ô', 'E');
insert into HZPYDZB (HZ, PY)
values ('∂', 'E');
insert into HZPYDZB (HZ, PY)
values ('∂Ò', 'E');
insert into HZPYDZB (HZ, PY)
values ('∂Ò', 'WU');
insert into HZPYDZB (HZ, PY)
values ('∂Ú', 'E');
insert into HZPYDZB (HZ, PY)
values ('∂Û', 'E');
insert into HZPYDZB (HZ, PY)
values ('∂Ù', 'E');
insert into HZPYDZB (HZ, PY)
values ('∂ı', 'E');
insert into HZPYDZB (HZ, PY)
values ('∂ˆ', 'E');
insert into HZPYDZB (HZ, PY)
values ('∂˜', 'EN');
insert into HZPYDZB (HZ, PY)
values ('∂¯', 'ER');
insert into HZPYDZB (HZ, PY)
values ('∂˘', 'ER');
insert into HZPYDZB (HZ, PY)
values ('∂˙', 'ER');
commit;
prompt 7600 records committed...
insert into HZPYDZB (HZ, PY)
values ('∂˚', 'ER');
insert into HZPYDZB (HZ, PY)
values ('∂¸', 'ER');
insert into HZPYDZB (HZ, PY)
values ('∂˝', 'ER');
insert into HZPYDZB (HZ, PY)
values ('∂˛', 'ER');
insert into HZPYDZB (HZ, PY)
values ('∑A', 'BING');
insert into HZPYDZB (HZ, PY)
values ('∑A', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('∑B', 'SU');
insert into HZPYDZB (HZ, PY)
values ('∑D', 'LUE');
insert into HZPYDZB (HZ, PY)
values ('∑D', 'SU');
insert into HZPYDZB (HZ, PY)
values ('∑E', 'UU');
insert into HZPYDZB (HZ, PY)
values ('∑I', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∑J', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∑K', 'BI');
insert into HZPYDZB (HZ, PY)
values ('∑K', 'PI');
insert into HZPYDZB (HZ, PY)
values ('∑L', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('∑M', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('∑N', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('∑N', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('∑P', 'XU');
insert into HZPYDZB (HZ, PY)
values ('∑Q', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('∑Q', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('∑T', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('∑X', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('∑X', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('∑Y', 'GU');
insert into HZPYDZB (HZ, PY)
values ('∑[', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('∑\', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('∑^', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('∑_', 'CEN');
insert into HZPYDZB (HZ, PY)
values ('∑a', 'TI');
insert into HZPYDZB (HZ, PY)
values ('∑a', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('∑b', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∑c', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('∑c', 'LU');
insert into HZPYDZB (HZ, PY)
values ('∑d', 'SU');
insert into HZPYDZB (HZ, PY)
values ('∑e', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∑f', 'YING');
insert into HZPYDZB (HZ, PY)
values ('∑g', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('∑j', 'YI');
insert into HZPYDZB (HZ, PY)
values ('∑k', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('∑m', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∑o', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∑p', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('∑q', 'BO');
insert into HZPYDZB (HZ, PY)
values ('∑r', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('∑r', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('∑t', 'LV');
insert into HZPYDZB (HZ, PY)
values ('∑u', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('∑v', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('∑z', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('∑}', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∑Ñ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('∑Ö', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('∑á', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('∑à', 'LI');
insert into HZPYDZB (HZ, PY)
values ('∑â', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('∑ä', 'WA');
insert into HZPYDZB (HZ, PY)
values ('∑ã', 'YU');
insert into HZPYDZB (HZ, PY)
values ('∑å', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('∑ç', 'JING');
insert into HZPYDZB (HZ, PY)
values ('∑è', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('∑í', 'BING');
insert into HZPYDZB (HZ, PY)
values ('∑ì', 'WA');
insert into HZPYDZB (HZ, PY)
values ('∑î', 'KU');
insert into HZPYDZB (HZ, PY)
values ('∑î', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('∑ï', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('∑ï', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('∑ñ', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('∑ò', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('∑ò', 'WA');
insert into HZPYDZB (HZ, PY)
values ('∑ô', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('∑ö', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('∑ú', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('∑ù', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('∑û', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('∑°', 'ER');
insert into HZPYDZB (HZ, PY)
values ('∑¢', 'FA');
insert into HZPYDZB (HZ, PY)
values ('∑£', 'FA');
insert into HZPYDZB (HZ, PY)
values ('∑§', 'FA');
insert into HZPYDZB (HZ, PY)
values ('∑•', 'FA');
insert into HZPYDZB (HZ, PY)
values ('∑¶', 'FA');
insert into HZPYDZB (HZ, PY)
values ('∑ß', 'FA');
insert into HZPYDZB (HZ, PY)
values ('∑®', 'FA');
insert into HZPYDZB (HZ, PY)
values ('∑©', 'FA');
insert into HZPYDZB (HZ, PY)
values ('∑™', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑´', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑¨', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑≠', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑Æ', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑Ø', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑∞', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑±', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑≤', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑≥', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑¥', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑µ', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑∂', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑∑', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑∏', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑π', 'FAN');
commit;
prompt 7700 records committed...
insert into HZPYDZB (HZ, PY)
values ('∑∫', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('∑ª', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('∑º', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('∑Ω', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('∑æ', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('∑ø', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('∑ø', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('∑¿', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('∑¡', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('∑¬', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('∑√', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('∑ƒ', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('∑≈', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('∑∆', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('∑«', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('∑»', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('∑…', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('∑ ', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('∑À', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('∑Ã', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('∑Õ', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('∑Œ', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('∑œ', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('∑–', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('∑—', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('∑“', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑”', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑‘', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑’', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑÷', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑◊', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑ÿ', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑Ÿ', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑⁄', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑€', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑‹', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑›', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑ﬁ', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑ﬂ', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑‡', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∑·', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑‚', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑„', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑‰', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑Â', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑Ê', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑Á', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑Ë', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑È', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑Í', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑Î', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑Ï', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑Ì', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑Ó', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑Ô', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('∑', 'FO');
insert into HZPYDZB (HZ, PY)
values ('∑Ò', 'FOU');
insert into HZPYDZB (HZ, PY)
values ('∑Ò', 'PI');
insert into HZPYDZB (HZ, PY)
values ('∑Ú', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∑Û', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∑Ù', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∑ı', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∑ˆ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∑˜', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∑¯', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∑˘', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∑˙', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∑˚', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∑¸', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∑˝', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∑˛', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏A', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('∏D', 'WA');
insert into HZPYDZB (HZ, PY)
values ('∏H', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('∏J', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('∏L', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('∏M', 'JU');
insert into HZPYDZB (HZ, PY)
values ('∏M', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('∏S', 'KE');
insert into HZPYDZB (HZ, PY)
values ('∏S', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('∏T', 'KUAN');
insert into HZPYDZB (HZ, PY)
values ('∏U', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('∏U', 'KUAN');
insert into HZPYDZB (HZ, PY)
values ('∏X', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('∏Z', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('∏_', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('∏a', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('∏b', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('∏c', 'FU');
insert into HZPYDZB (HZ, PY)
values ('∏d', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('∏e', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('∏f', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('∏g', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∏h', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∏i', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('∏j', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('∏k', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('∏l', 'QU');
insert into HZPYDZB (HZ, PY)
values ('∏m', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('∏n', 'LING');
commit;
prompt 7800 records committed...
insert into HZPYDZB (HZ, PY)
values ('∏o', 'NENG');
insert into HZPYDZB (HZ, PY)
values (' …', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('  ', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' À', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' Ã', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' Õ', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' Œ', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' œ', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' –', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' —', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' “', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ”', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ‘', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ’', 'SHOU');
insert into HZPYDZB (HZ, PY)
values (' ÷', 'SHOU');
insert into HZPYDZB (HZ, PY)
values (' ◊', 'SHOU');
insert into HZPYDZB (HZ, PY)
values (' ÿ', 'SHOU');
insert into HZPYDZB (HZ, PY)
values (' Ÿ', 'SHOU');
insert into HZPYDZB (HZ, PY)
values (' ⁄', 'SHOU');
insert into HZPYDZB (HZ, PY)
values (' €', 'SHOU');
insert into HZPYDZB (HZ, PY)
values (' ‹', 'SHOU');
insert into HZPYDZB (HZ, PY)
values (' ›', 'SHOU');
insert into HZPYDZB (HZ, PY)
values (' ﬁ', 'SHOU');
insert into HZPYDZB (HZ, PY)
values (' ﬂ', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ‡', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ·', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ‚', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' „', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ‰', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' Â', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' Ê', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' Á', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' Ë', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' È', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' Í', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' Î', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' Ï', 'SHOU');
insert into HZPYDZB (HZ, PY)
values (' Ï', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' Ì', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' Ó', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' Ô', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' Ò', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' Ú', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' Û', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' Ù', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ı', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ˆ', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ˜', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ¯', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ˘', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ˙', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ˚', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ¸', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ˝', 'SHU');
insert into HZPYDZB (HZ, PY)
values (' ˛', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ÀA', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('ÀC', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ÀD', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ÀI', 'MIE');
insert into HZPYDZB (HZ, PY)
values ('ÀJ', 'LENG');
insert into HZPYDZB (HZ, PY)
values ('ÀK', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ÀL', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ÀN', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('ÀO', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ÀP', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ÀS', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ÀW', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('ÀW', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ÀY', 'DING');
insert into HZPYDZB (HZ, PY)
values ('À[', 'GU');
insert into HZPYDZB (HZ, PY)
values ('À^', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('À^', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('Àb', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('Àf', 'NING');
insert into HZPYDZB (HZ, PY)
values ('Àh', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('Àh', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Àj', 'CI');
insert into HZPYDZB (HZ, PY)
values ('Àj', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Àl', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('Àm', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Ào', 'NI');
insert into HZPYDZB (HZ, PY)
values ('Àq', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('Àr', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('Àw', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Àx', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('Ày', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Ày', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('Àz', 'MI');
insert into HZPYDZB (HZ, PY)
values ('À{', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ÀÄ', 'UU');
insert into HZPYDZB (HZ, PY)
values ('ÀÉ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('Àà', 'LA');
insert into HZPYDZB (HZ, PY)
values ('Àâ', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('Àä', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Àã', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Àå', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Àé', 'LUE');
insert into HZPYDZB (HZ, PY)
values ('Àë', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Àó', 'WEI');
commit;
prompt 7900 records committed...
insert into HZPYDZB (HZ, PY)
values ('Àò', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Àö', 'OU');
insert into HZPYDZB (HZ, PY)
values ('Àõ', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('Àú', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Àú', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('Àù', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Àû', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Àü', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('À†', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('À°', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('À¢', 'SHUA');
insert into HZPYDZB (HZ, PY)
values ('À£', 'SHUA');
insert into HZPYDZB (HZ, PY)
values ('À§', 'SHUAI');
insert into HZPYDZB (HZ, PY)
values ('À•', 'SHUAI');
insert into HZPYDZB (HZ, PY)
values ('À¶', 'SHUAI');
insert into HZPYDZB (HZ, PY)
values ('Àß', 'SHUAI');
insert into HZPYDZB (HZ, PY)
values ('À®', 'SHUAN');
insert into HZPYDZB (HZ, PY)
values ('À©', 'SHUAN');
insert into HZPYDZB (HZ, PY)
values ('À™', 'SHUANG');
insert into HZPYDZB (HZ, PY)
values ('À´', 'SHUANG');
insert into HZPYDZB (HZ, PY)
values ('À¨', 'SHUANG');
insert into HZPYDZB (HZ, PY)
values ('À≠', 'SHEI');
insert into HZPYDZB (HZ, PY)
values ('À≠', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('ÀÆ', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('ÀØ', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('À∞', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('À±', 'SHUN');
insert into HZPYDZB (HZ, PY)
values ('À≤', 'SHUN');
insert into HZPYDZB (HZ, PY)
values ('À≥', 'SHUN');
insert into HZPYDZB (HZ, PY)
values ('À¥', 'SHUN');
insert into HZPYDZB (HZ, PY)
values ('Àµ', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('Àµ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('À∂', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('À∑', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('À∏', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('Àπ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('À∫', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Àª', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Àº', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ÀΩ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Àæ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Àø', 'SI');
insert into HZPYDZB (HZ, PY)
values ('À¿', 'SI');
insert into HZPYDZB (HZ, PY)
values ('À¡', 'SI');
insert into HZPYDZB (HZ, PY)
values ('À¬', 'SI');
insert into HZPYDZB (HZ, PY)
values ('À√', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Àƒ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('À≈', 'CI');
insert into HZPYDZB (HZ, PY)
values ('À≈', 'SI');
insert into HZPYDZB (HZ, PY)
values ('À∆', 'SI');
insert into HZPYDZB (HZ, PY)
values ('À«', 'SI');
insert into HZPYDZB (HZ, PY)
values ('À»', 'SI');
insert into HZPYDZB (HZ, PY)
values ('À»', 'YI');
insert into HZPYDZB (HZ, PY)
values ('À…', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('À ', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('ÀÀ', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('ÀÃ', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('ÀÕ', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('ÀŒ', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('Àœ', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('À–', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('À—', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('À“', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('À”', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('À‘', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('À’', 'SU');
insert into HZPYDZB (HZ, PY)
values ('À÷', 'SU');
insert into HZPYDZB (HZ, PY)
values ('À◊', 'SU');
insert into HZPYDZB (HZ, PY)
values ('Àÿ', 'SU');
insert into HZPYDZB (HZ, PY)
values ('ÀŸ', 'SU');
insert into HZPYDZB (HZ, PY)
values ('À⁄', 'SU');
insert into HZPYDZB (HZ, PY)
values ('À€', 'SU');
insert into HZPYDZB (HZ, PY)
values ('À‹', 'SU');
insert into HZPYDZB (HZ, PY)
values ('À›', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('Àﬁ', 'SU');
insert into HZPYDZB (HZ, PY)
values ('Àﬁ', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('Àﬂ', 'SU');
insert into HZPYDZB (HZ, PY)
values ('À‡', 'SU');
insert into HZPYDZB (HZ, PY)
values ('À·', 'SUAN');
insert into HZPYDZB (HZ, PY)
values ('À‚', 'SUAN');
insert into HZPYDZB (HZ, PY)
values ('À„', 'SUAN');
insert into HZPYDZB (HZ, PY)
values ('À‰', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ÀÂ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ÀÊ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ÀÁ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ÀË', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ÀÈ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ÀÍ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ÀÎ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ÀÏ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ÀÌ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ÀÓ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ÀÔ', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('À', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('ÀÒ', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('ÀÚ', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('ÀÛ', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('ÀÙ', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('Àı', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('Àˆ', 'SUO');
commit;
prompt 8000 records committed...
insert into HZPYDZB (HZ, PY)
values ('À˜', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('À¯', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('À˘', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('À˙', 'TA');
insert into HZPYDZB (HZ, PY)
values ('À˚', 'TA');
insert into HZPYDZB (HZ, PY)
values ('À¸', 'TA');
insert into HZPYDZB (HZ, PY)
values ('À˝', 'TA');
insert into HZPYDZB (HZ, PY)
values ('À˛', 'TA');
insert into HZPYDZB (HZ, PY)
values ('Ã@', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ÃA', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ÃD', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('ÃF', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÃI', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÃJ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ÃK', 'SU');
insert into HZPYDZB (HZ, PY)
values ('ÃL', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('ÃN', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('ÃO', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('ÃR', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÃX', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('ÃY', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ÃY', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ÃZ', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('Ã^', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Ã`', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('Ãd', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('Ãj', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('Ãk', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Ãk', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('Ãl', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Ãm', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('Ãn', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ão', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('Ãp', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('Ãq', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('Ãr', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('Ãs', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('Ãs', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Ãt', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('Ãv', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Ãw', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Ãz', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ã{', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('Ã|', 'HUAI');
insert into HZPYDZB (HZ, PY)
values ('Ã~', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÃÄ', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ÃÅ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ÃÖ', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('Ãâ', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('Ãã', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('Ãé', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('Ãé', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Ãè', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Ãì', 'XU');
insert into HZPYDZB (HZ, PY)
values ('Ãî', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Ãï', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Ãñ', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('Ãó', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('Ãó', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ãò', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Ãô', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Ãù', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Ãû', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('Ã°', 'TA');
insert into HZPYDZB (HZ, PY)
values ('Ã¢', 'TA');
insert into HZPYDZB (HZ, PY)
values ('Ã£', 'TA');
insert into HZPYDZB (HZ, PY)
values ('Ã§', 'TA');
insert into HZPYDZB (HZ, PY)
values ('Ã•', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('Ã¶', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('Ãß', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('Ã®', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('Ã©', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('Ã™', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('Ã´', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('Ã¨', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('Ã≠', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('ÃÆ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ÃØ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ã∞', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ã±', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ã≤', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ã≥', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ã¥', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ãµ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ã∂', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ã∑', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ã∏', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ãπ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ã∫', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ãª', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ãº', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ÃΩ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ãæ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ãø', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ã¿', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ã¡', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ã¬', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ã√', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ãƒ', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ã≈', 'TANG');
commit;
prompt 8100 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ã∆', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ã«', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ã»', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ã…', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ã ', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ÃÀ', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ÃÃ', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ÃÕ', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('ÃŒ', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('ÃŒ', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ãœ', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ã–', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ã—', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ã“', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ã”', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ã‘', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ã’', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ã÷', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ã◊', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ãÿ', 'TE');
insert into HZPYDZB (HZ, PY)
values ('ÃŸ', 'TENG');
insert into HZPYDZB (HZ, PY)
values ('Ã⁄', 'TENG');
insert into HZPYDZB (HZ, PY)
values ('Ã€', 'TENG');
insert into HZPYDZB (HZ, PY)
values ('Ã‹', 'TENG');
insert into HZPYDZB (HZ, PY)
values ('Ã›', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Ãﬁ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Ãﬂ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Ã‡', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Ã·', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Ã‚', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Ã„', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Ã‰', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ÃÂ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ÃÊ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ÃÁ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ÃË', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ÃÈ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ÃÍ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ÃÎ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ÃÏ', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ÃÌ', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ÃÓ', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ÃÔ', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('Ã', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ÃÒ', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ÃÚ', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ÃÛ', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ÃÙ', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('Ãı', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('Ãˆ', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('Ã˜', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('Ã¯', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('Ã˘', 'TIE');
insert into HZPYDZB (HZ, PY)
values ('Ã˙', 'TIE');
insert into HZPYDZB (HZ, PY)
values ('Ã˚', 'TIE');
insert into HZPYDZB (HZ, PY)
values ('Ã¸', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Ã˝', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Ã˛', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Ã˛', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Õ@', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('Õ@', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('ÕB', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ÕB', 'DING');
insert into HZPYDZB (HZ, PY)
values ('ÕC', 'UU');
insert into HZPYDZB (HZ, PY)
values ('ÕD', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ÕE', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ÕF', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('ÕH', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ÕH', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ÕK', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('ÕL', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÕM', 'BA');
insert into HZPYDZB (HZ, PY)
values ('ÕN', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ÕO', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('ÕP', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('ÕS', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('ÕU', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('ÕV', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÕW', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕX', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ÕY', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ÕZ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('ÕZ', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('Õ\', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('Õ^', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Õ_', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('Õ`', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('Õa', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('Õb', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Õd', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Õe', 'NI');
insert into HZPYDZB (HZ, PY)
values ('Õh', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Õh', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Õi', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Õj', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Õk', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Õm', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('Õm', 'QU');
insert into HZPYDZB (HZ, PY)
values ('Õo', 'BO');
insert into HZPYDZB (HZ, PY)
values ('Õo', 'PI');
commit;
prompt 8200 records committed...
insert into HZPYDZB (HZ, PY)
values ('Õq', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('Õr', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('Õs', 'BING');
insert into HZPYDZB (HZ, PY)
values ('Õu', 'TIE');
insert into HZPYDZB (HZ, PY)
values ('Õv', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Õx', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Õx', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('Õy', 'CI');
insert into HZPYDZB (HZ, PY)
values ('Õz', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Õ{', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('Õ{', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('Õ|', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Õ}', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('ÕÅ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ÕÑ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ÕÑ', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('ÕÖ', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('Õá', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Õà', 'MO');
insert into HZPYDZB (HZ, PY)
values ('Õâ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('Õä', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('Õå', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('Õé', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Õë', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('Õí', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('Õî', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Õñ', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Õó', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Õó', 'PU');
insert into HZPYDZB (HZ, PY)
values ('Õô', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('Õô', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('Õö', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Õù', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Õü', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('Õ°', 'DING');
insert into HZPYDZB (HZ, PY)
values ('Õ°', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Õ¢', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Õ£', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Õ§', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Õ•', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Õ¶', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Õß', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Õ®', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Õ©', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Õ™', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('Õ™', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Õ´', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Õ¨', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Õ≠', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('ÕÆ', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('ÕØ', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Õ∞', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Õ±', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Õ≤', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Õ≥', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Õ¥', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Õµ', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('Õ∂', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('Õ∑', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('Õ∏', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('Õπ', 'TU');
insert into HZPYDZB (HZ, PY)
values ('Õ∫', 'TU');
insert into HZPYDZB (HZ, PY)
values ('Õª', 'TU');
insert into HZPYDZB (HZ, PY)
values ('Õº', 'TU');
insert into HZPYDZB (HZ, PY)
values ('ÕΩ', 'TU');
insert into HZPYDZB (HZ, PY)
values ('Õæ', 'TU');
insert into HZPYDZB (HZ, PY)
values ('Õø', 'TU');
insert into HZPYDZB (HZ, PY)
values ('Õ¿', 'TU');
insert into HZPYDZB (HZ, PY)
values ('Õ¡', 'TU');
insert into HZPYDZB (HZ, PY)
values ('Õ¬', 'TU');
insert into HZPYDZB (HZ, PY)
values ('Õ√', 'TU');
insert into HZPYDZB (HZ, PY)
values ('Õƒ', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('Õ≈', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('Õ∆', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('Õ«', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('Õ»', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('Õ…', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('Õ ', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('ÕÀ', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('ÕÃ', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('ÕÕ', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('ÕŒ', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('Õœ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Õ–', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Õ—', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Õ“', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Õ”', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('Õ”', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Õ‘', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Õ’', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Õ÷', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Õ◊', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Õÿ', 'TA');
insert into HZPYDZB (HZ, PY)
values ('Õÿ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ÕŸ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Õ⁄', 'WA');
insert into HZPYDZB (HZ, PY)
values ('Õ€', 'WA');
insert into HZPYDZB (HZ, PY)
values ('Õ‹', 'WA');
insert into HZPYDZB (HZ, PY)
values ('Õ›', 'WA');
insert into HZPYDZB (HZ, PY)
values ('Õﬁ', 'WA');
commit;
prompt 8300 records committed...
insert into HZPYDZB (HZ, PY)
values ('Õﬂ', 'WA');
insert into HZPYDZB (HZ, PY)
values ('Õ‡', 'WA');
insert into HZPYDZB (HZ, PY)
values ('Õ·', 'WAI');
insert into HZPYDZB (HZ, PY)
values ('Õ‚', 'WAI');
insert into HZPYDZB (HZ, PY)
values ('Õ„', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Õ‰', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕÂ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕÊ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕÁ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕË', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕÈ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕÍ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕÎ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕÏ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕÌ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕÓ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕÔ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Õ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕÒ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕÚ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕÛ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÕÙ', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Õı', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Õˆ', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Õ˜', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Õ¯', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Õ˘', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Õ˙', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Õ˚', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Õ¸', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Õ˝', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Õ˛', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ@', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('ŒA', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ŒD', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('ŒE', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ŒG', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ŒH', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ŒI', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('ŒJ', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('ŒK', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ŒM', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('ŒN', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ŒO', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ŒP', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('ŒP', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('ŒT', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ŒV', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ŒW', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('ŒZ', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('Œ\', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('Œ]', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('Œ^', 'MI');
insert into HZPYDZB (HZ, PY)
values ('Œ_', 'UU');
insert into HZPYDZB (HZ, PY)
values ('Œ`', 'LA');
insert into HZPYDZB (HZ, PY)
values ('Œa', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Œa', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Œb', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Œc', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('Œe', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('Œf', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Œg', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Œg', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('Œj', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('Œk', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œl', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Œn', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('Œo', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œr', 'HA');
insert into HZPYDZB (HZ, PY)
values ('Œr', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Œu', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('Œu', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('Œv', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Œw', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Œy', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Œy', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Œ{', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('Œ|', 'LA');
insert into HZPYDZB (HZ, PY)
values ('Œ}', 'DU');
insert into HZPYDZB (HZ, PY)
values ('ŒÄ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ŒÅ', 'WO');
insert into HZPYDZB (HZ, PY)
values ('ŒÇ', 'AO');
insert into HZPYDZB (HZ, PY)
values ('ŒÖ', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ŒÜ', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('Œà', 'CI');
insert into HZPYDZB (HZ, PY)
values ('Œä', 'WENG');
insert into HZPYDZB (HZ, PY)
values ('Œã', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('Œå', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('Œå', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('Œç', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('Œé', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Œê', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('Œì', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Œì', 'PI');
insert into HZPYDZB (HZ, PY)
values ('Œî', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('Œñ', 'DU');
insert into HZPYDZB (HZ, PY)
values ('Œó', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('Œó', 'NENG');
insert into HZPYDZB (HZ, PY)
values ('Œò', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Œô', 'HU');
commit;
prompt 8400 records committed...
insert into HZPYDZB (HZ, PY)
values ('Œö', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('Œö', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Œõ', 'MA');
insert into HZPYDZB (HZ, PY)
values ('Œù', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Œû', 'YING');
insert into HZPYDZB (HZ, PY)
values ('Œ°', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ¢', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ£', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ§', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ•', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ¶', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œß', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ®', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ©', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ™', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ´', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ¨', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ≠', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ŒÆ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ŒØ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ∞', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ±', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ≤', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ≥', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ¥', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œµ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ∂', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ∑', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ∏', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œπ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ∫', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œª', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œº', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ŒΩ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œæ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œæ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Œø', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ¿', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Œ¡', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Œ¬', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Œ√', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Œƒ', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Œ≈', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Œ∆', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Œ«', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Œ»', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Œ…', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Œ ', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('ŒÀ', 'WENG');
insert into HZPYDZB (HZ, PY)
values ('ŒÃ', 'WENG');
insert into HZPYDZB (HZ, PY)
values ('ŒÕ', 'WENG');
insert into HZPYDZB (HZ, PY)
values ('ŒŒ', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Œœ', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Œ–', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Œ—', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Œ“', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Œ”', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Œ‘', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Œ’', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Œ÷', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Œ◊', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Œÿ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒŸ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Œ⁄', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Œ€', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Œ‹', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Œ›', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Œﬁ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Œﬂ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Œ‡', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Œ·', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Œ‚', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Œ„', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Œ‰', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒÂ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒÊ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒÁ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒË', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒÈ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒÍ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒÎ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒÏ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒÌ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒÓ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒÔ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Œ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒÒ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒÚ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒÛ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ŒÙ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Œı', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Œˆ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Œ˜', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Œ¯', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Œ˘', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Œ˙', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Œ˚', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Œ¸', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Œ˝', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Œ˛', 'XI');
commit;
prompt 8500 records committed...
insert into HZPYDZB (HZ, PY)
values ('œ@', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('œA', 'SO');
insert into HZPYDZB (HZ, PY)
values ('œF', 'LU');
insert into HZPYDZB (HZ, PY)
values ('œG', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('œH', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('œH', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('œN', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('œQ', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('œT', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('œV', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('œW', 'MA');
insert into HZPYDZB (HZ, PY)
values ('œY', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('œZ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('œ[', 'LI');
insert into HZPYDZB (HZ, PY)
values ('œ_', 'MO');
insert into HZPYDZB (HZ, PY)
values ('œh', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('œi', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('œl', 'JI');
insert into HZPYDZB (HZ, PY)
values ('œn', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('œn', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('œo', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('œo', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('œp', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('œq', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('œs', 'TI');
insert into HZPYDZB (HZ, PY)
values ('œu', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('œw', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('œx', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('œx', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('œ{', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('œ~', 'LI');
insert into HZPYDZB (HZ, PY)
values ('œÄ', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('œÄ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('œÇ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('œá', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('œë', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('œñ', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('œô', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('œõ', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('œú', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('œù', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('œü', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('œ†', 'LI');
insert into HZPYDZB (HZ, PY)
values ('œ°', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ¢', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ£', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ§', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ•', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ¶', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œß', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ®', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ©', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ™', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ´', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ¨', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ≠', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œÆ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œØ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ∞', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ±', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ≤', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('œ≤', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ≥', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ≥', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ¥', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ¥', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œµ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ∂', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ∑', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œ∏', 'XI');
insert into HZPYDZB (HZ, PY)
values ('œπ', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('œ∫', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('œª', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('œº', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('œΩ', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('œæ', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('œø', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('œ¿', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('œ¡', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('œ¬', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('œ√', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('œƒ', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('œ≈', 'HE');
insert into HZPYDZB (HZ, PY)
values ('œ≈', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('œ∆', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ«', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ»', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ…', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œÀ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('œÀ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œÃ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œÕ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œŒ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œœ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ–', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ—', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ“', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ”', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ‘', 'XIAN');
commit;
prompt 8600 records committed...
insert into HZPYDZB (HZ, PY)
values ('œ’', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ÷', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ◊', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œÿ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œŸ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ⁄', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ€', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ‹', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ›', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œﬁ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œﬂ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('œ‡', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œ·', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œ‚', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œ„', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œ‰', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œÂ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œÊ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œÁ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œË', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œÈ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œÍ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œÎ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œÏ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œÌ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œÓ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œÔ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œÒ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œÚ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œÛ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('œÙ', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('œı', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('œˆ', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('œ˜', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('œ˜', 'XUE');
insert into HZPYDZB (HZ, PY)
values ('œ¯', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('œ˘', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('œ˙', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('œ˚', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('œ¸', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('œ˝', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('œ˛', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('–A', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('–B', 'LU');
insert into HZPYDZB (HZ, PY)
values ('–C', 'DU');
insert into HZPYDZB (HZ, PY)
values ('–F', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('–L', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('–Q', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('–T', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('–U', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('–Z', 'NV');
insert into HZPYDZB (HZ, PY)
values ('–[', 'FOU');
insert into HZPYDZB (HZ, PY)
values ('–[', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('–]', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('–^', 'ER');
insert into HZPYDZB (HZ, PY)
values ('–_', 'KA');
insert into HZPYDZB (HZ, PY)
values ('–`', 'MIE');
insert into HZPYDZB (HZ, PY)
values ('–b', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('–e', 'LING');
insert into HZPYDZB (HZ, PY)
values ('–g', 'SHAI');
insert into HZPYDZB (HZ, PY)
values ('–g', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('–h', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('–i', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('–j', 'YU');
insert into HZPYDZB (HZ, PY)
values ('–k', 'HU');
insert into HZPYDZB (HZ, PY)
values ('–n', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('–q', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('–r', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('–u', 'FU');
insert into HZPYDZB (HZ, PY)
values ('–v', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('–v', 'PEN');
insert into HZPYDZB (HZ, PY)
values ('–w', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('–x', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('–y', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('–{', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('–|', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('–}', 'QI');
insert into HZPYDZB (HZ, PY)
values ('–Å', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('–Ç', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('–Ñ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('–Ñ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('–Ö', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('–Ü', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('–á', 'LING');
insert into HZPYDZB (HZ, PY)
values ('–à', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('–ä', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('–ã', 'BI');
insert into HZPYDZB (HZ, PY)
values ('–å', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('–ç', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('–ç', 'JU');
insert into HZPYDZB (HZ, PY)
values ('–é', 'KE');
insert into HZPYDZB (HZ, PY)
values ('–ê', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('–ë', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('–í', 'PA');
insert into HZPYDZB (HZ, PY)
values ('–ì', 'BO');
insert into HZPYDZB (HZ, PY)
values ('–ì', 'FU');
insert into HZPYDZB (HZ, PY)
values ('–ï', 'FU');
insert into HZPYDZB (HZ, PY)
values ('–ñ', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('–ó', 'ZHI');
commit;
prompt 8700 records committed...
insert into HZPYDZB (HZ, PY)
values ('–ô', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('–õ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('–ú', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('–ú', 'NA');
insert into HZPYDZB (HZ, PY)
values ('–ü', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('–ü', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('–†', 'QU');
insert into HZPYDZB (HZ, PY)
values ('–°', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('–¢', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('–£', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('–£', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('–§', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('–•', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('–¶', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('–ß', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('–®', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–©', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–™', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–´', 'HE');
insert into HZPYDZB (HZ, PY)
values ('–´', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–¨', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–≠', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–Æ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('–Æ', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–Ø', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–∞', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–±', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–≤', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–≥', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–¥', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–µ', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–∂', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–∑', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–∏', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–π', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–∫', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–ª', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–º', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('–Ω', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('–æ', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('–ø', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('–ø', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('–¿', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('–¡', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('–¬', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('–√', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('–ƒ', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('–≈', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('–∆', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('–«', 'XING');
insert into HZPYDZB (HZ, PY)
values ('–»', 'XING');
insert into HZPYDZB (HZ, PY)
values ('–…', 'XING');
insert into HZPYDZB (HZ, PY)
values ('– ', 'XING');
insert into HZPYDZB (HZ, PY)
values ('–À', 'XING');
insert into HZPYDZB (HZ, PY)
values ('–Ã', 'XING');
insert into HZPYDZB (HZ, PY)
values ('–Õ', 'XING');
insert into HZPYDZB (HZ, PY)
values ('–Œ', 'XING');
insert into HZPYDZB (HZ, PY)
values ('–œ', 'XING');
insert into HZPYDZB (HZ, PY)
values ('––', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('––', 'XING');
insert into HZPYDZB (HZ, PY)
values ('–—', 'XING');
insert into HZPYDZB (HZ, PY)
values ('–“', 'XING');
insert into HZPYDZB (HZ, PY)
values ('–”', 'XING');
insert into HZPYDZB (HZ, PY)
values ('–‘', 'XING');
insert into HZPYDZB (HZ, PY)
values ('–’', 'XING');
insert into HZPYDZB (HZ, PY)
values ('–÷', 'XIONG');
insert into HZPYDZB (HZ, PY)
values ('–◊', 'XIONG');
insert into HZPYDZB (HZ, PY)
values ('–ÿ', 'XIONG');
insert into HZPYDZB (HZ, PY)
values ('–Ÿ', 'XIONG');
insert into HZPYDZB (HZ, PY)
values ('–⁄', 'XIONG');
insert into HZPYDZB (HZ, PY)
values ('–€', 'XIONG');
insert into HZPYDZB (HZ, PY)
values ('–‹', 'XIONG');
insert into HZPYDZB (HZ, PY)
values ('–›', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('–ﬁ', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('–ﬂ', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('–‡', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('–·', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('–‚', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('–„', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('–‰', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('–Â', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('–Ê', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–Á', 'QU');
insert into HZPYDZB (HZ, PY)
values ('–Á', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–Ë', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–È', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–Í', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–Î', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–Ï', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–Ì', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–Ó', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–Ô', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–Ò', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–Ú', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–Û', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('–Û', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–Ù', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–ı', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–ˆ', 'XU');
commit;
prompt 8800 records committed...
insert into HZPYDZB (HZ, PY)
values ('–˜', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–¯', 'XU');
insert into HZPYDZB (HZ, PY)
values ('–˘', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('–˙', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('–˚', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('–¸', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('–˝', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('–˛', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('—A', 'MI');
insert into HZPYDZB (HZ, PY)
values ('—A', 'NI');
insert into HZPYDZB (HZ, PY)
values ('—B', 'BO');
insert into HZPYDZB (HZ, PY)
values ('—C', 'UU');
insert into HZPYDZB (HZ, PY)
values ('—D', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('—D', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('—E', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('—F', 'KU');
insert into HZPYDZB (HZ, PY)
values ('—G', 'REN');
insert into HZPYDZB (HZ, PY)
values ('—H', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('—I', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('—J', 'BO');
insert into HZPYDZB (HZ, PY)
values ('—J', 'MO');
insert into HZPYDZB (HZ, PY)
values ('—K', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('—L', 'ER');
insert into HZPYDZB (HZ, PY)
values ('—M', 'RU');
insert into HZPYDZB (HZ, PY)
values ('—N', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('—O', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('—Q', 'KA');
insert into HZPYDZB (HZ, PY)
values ('—S', 'SED');
insert into HZPYDZB (HZ, PY)
values ('—T', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('—U', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('—V', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('—W', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('—X', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('—Y', 'LI');
insert into HZPYDZB (HZ, PY)
values ('—Z', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('—]', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('—^', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('—_', 'JI');
insert into HZPYDZB (HZ, PY)
values ('—a', 'BU');
insert into HZPYDZB (HZ, PY)
values ('—b', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('—c', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('—e', 'LI');
insert into HZPYDZB (HZ, PY)
values ('—f', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('—g', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('—g', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('—h', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('—i', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('—l', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('—n', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('—o', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('—p', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('—q', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('—r', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('—s', 'AN');
insert into HZPYDZB (HZ, PY)
values ('—t', 'DU');
insert into HZPYDZB (HZ, PY)
values ('—v', 'QI');
insert into HZPYDZB (HZ, PY)
values ('—w', 'JI');
insert into HZPYDZB (HZ, PY)
values ('—w', 'QI');
insert into HZPYDZB (HZ, PY)
values ('—y', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('—z', 'QI');
insert into HZPYDZB (HZ, PY)
values ('—{', 'TI');
insert into HZPYDZB (HZ, PY)
values ('—|', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('—|', 'TI');
insert into HZPYDZB (HZ, PY)
values ('—}', 'FU');
insert into HZPYDZB (HZ, PY)
values ('—~', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('—~', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('—Å', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('—Ç', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('—É', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('—É', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('—á', 'FU');
insert into HZPYDZB (HZ, PY)
values ('—à', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('—ã', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('—ç', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('—é', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('—è', 'TA');
insert into HZPYDZB (HZ, PY)
values ('—ê', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('—ë', 'HUAI');
insert into HZPYDZB (HZ, PY)
values ('—í', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('—î', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('—ï', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('—ñ', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('—ñ', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('—ó', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('—ô', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('—ú', 'HUAI');
insert into HZPYDZB (HZ, PY)
values ('—ù', 'KU');
insert into HZPYDZB (HZ, PY)
values ('—û', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('—ü', 'LI');
insert into HZPYDZB (HZ, PY)
values ('—°', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('—£', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('—§', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('—§', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—•', 'XUE');
insert into HZPYDZB (HZ, PY)
values ('—¶', 'XUE');
insert into HZPYDZB (HZ, PY)
values ('—ß', 'XUE');
insert into HZPYDZB (HZ, PY)
values ('—®', 'XUE');
insert into HZPYDZB (HZ, PY)
values ('—©', 'XUE');
insert into HZPYDZB (HZ, PY)
values ('—™', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('—™', 'XUE');
commit;
prompt 8900 records committed...
insert into HZPYDZB (HZ, PY)
values ('—´', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—¨', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—≠', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—Æ', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—Ø', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—∞', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—±', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—≤', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—≥', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—¥', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—µ', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—∂', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—∑', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—∏', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('—π', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—∫', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—ª', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—º', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—Ω', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—æ', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—ø', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—¿', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—¡', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—¬', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—√', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—ƒ', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—≈', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—∆', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—«', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—»', 'YA');
insert into HZPYDZB (HZ, PY)
values ('—…', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('— ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—À', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—Ã', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—Õ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—Œ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—œ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—–', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('——', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—“', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—”', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—‘', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—’', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—÷', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—◊', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—ÿ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—Ÿ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—⁄', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—€', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—‹', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—›', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—ﬁ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—ﬂ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—‡', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—·', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—‚', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—„', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—‰', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—Â', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—Ê', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—Á', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—Ë', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—È', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('—Í', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—Î', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—Ï', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—Ì', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—Ó', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—Ô', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—Ò', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—Ú', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—Û', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—Ù', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—ı', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—ˆ', 'ANG');
insert into HZPYDZB (HZ, PY)
values ('—ˆ', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—˜', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—¯', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—˘', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—˙', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('—˚', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('—¸', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('—˝', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('—˛', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('“@', 'LV');
insert into HZPYDZB (HZ, PY)
values ('“A', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('“E', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('“F', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('“G', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('“H', 'JI');
insert into HZPYDZB (HZ, PY)
values ('“L', 'FU');
insert into HZPYDZB (HZ, PY)
values ('“L', 'PU');
insert into HZPYDZB (HZ, PY)
values ('“N', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('“P', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('“P', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('“Q', 'JI');
insert into HZPYDZB (HZ, PY)
values ('“T', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('“U', 'BO');
insert into HZPYDZB (HZ, PY)
values ('“[', 'LAN');
commit;
prompt 9000 records committed...
insert into HZPYDZB (HZ, PY)
values ('“_', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('“`', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('“a', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('“b', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('“b', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('“c', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('“c', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('“e', 'DU');
insert into HZPYDZB (HZ, PY)
values ('“e', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('“f', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('“h', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('“i', 'PU');
insert into HZPYDZB (HZ, PY)
values ('“l', 'DU');
insert into HZPYDZB (HZ, PY)
values ('“m', 'WA');
insert into HZPYDZB (HZ, PY)
values ('“o', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('“q', 'BO');
insert into HZPYDZB (HZ, PY)
values ('“r', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('“w', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('“y', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('“{', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('“Ä', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('“Ñ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('“Ü', 'BA');
insert into HZPYDZB (HZ, PY)
values ('“á', 'HE');
insert into HZPYDZB (HZ, PY)
values ('“à', 'JI');
insert into HZPYDZB (HZ, PY)
values ('“â', 'JI');
insert into HZPYDZB (HZ, PY)
values ('“ä', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('“ä', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('“é', 'XU');
insert into HZPYDZB (HZ, PY)
values ('“ë', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('“í', 'MI');
insert into HZPYDZB (HZ, PY)
values ('“ì', 'MI');
insert into HZPYDZB (HZ, PY)
values ('“ï', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('“ò', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('“ô', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('“ô', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('“ö', 'MI');
insert into HZPYDZB (HZ, PY)
values ('“°', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('“¢', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('“£', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('“§', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('“•', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('“¶', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('“ß', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('“ß', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('“®', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('“©', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('“™', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('“´', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('“¨', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“≠', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“Æ', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“Ø', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“∞', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“±', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“≤', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“≥', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“¥', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“µ', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“∂', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“∑', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“∏', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“π', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“∫', 'YE');
insert into HZPYDZB (HZ, PY)
values ('“ª', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“º', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Ω', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“æ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“ø', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“¿', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“¡', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“¬', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“√', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“ƒ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“≈', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“∆', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“«', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“»', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“…', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“ ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“À', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Ã', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Õ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Œ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“œ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“–', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“—', 'YI');
insert into HZPYDZB (HZ, PY)
values ('““', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“”', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“‘', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“’', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“÷', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“◊', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“ÿ', 'E');
insert into HZPYDZB (HZ, PY)
values ('“ÿ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Ÿ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“⁄', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“€', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“‹', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“›', 'YI');
commit;
prompt 9100 records committed...
insert into HZPYDZB (HZ, PY)
values ('“ﬁ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('“‡', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“·', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“‚', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“„', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“‰', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Â', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Ê', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Á', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Ë', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“È', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Í', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Î', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Ï', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Ì', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Ó', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“Ô', 'YI');
insert into HZPYDZB (HZ, PY)
values ('“', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('“Ò', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('“Ú', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('“Û', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('“Ù', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('“ı', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('“ˆ', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('“˜', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('“¯', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('“˙', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('“˚', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('“¸', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('“˝', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('“˛', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('”A', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('”G', 'DU');
insert into HZPYDZB (HZ, PY)
values ('”H', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('”J', 'JI');
insert into HZPYDZB (HZ, PY)
values ('”M', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('”T', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('”Z', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('”^', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('”`', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('”b', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('”c', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('”e', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('”f', 'JI');
insert into HZPYDZB (HZ, PY)
values ('”g', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('”h', 'DI');
insert into HZPYDZB (HZ, PY)
values ('”i', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('”k', 'GE');
insert into HZPYDZB (HZ, PY)
values ('”m', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('”n', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('”o', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('”q', 'XING');
insert into HZPYDZB (HZ, PY)
values ('”s', 'JI');
insert into HZPYDZB (HZ, PY)
values ('”t', 'LU');
insert into HZPYDZB (HZ, PY)
values ('”u', 'DA');
insert into HZPYDZB (HZ, PY)
values ('”y', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('”|', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('”Ä', 'LU');
insert into HZPYDZB (HZ, PY)
values ('”Å', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('”Ü', 'DING');
insert into HZPYDZB (HZ, PY)
values ('”á', 'FU');
insert into HZPYDZB (HZ, PY)
values ('”à', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('”à', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('”â', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('”ä', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('”ç', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('”è', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('”ê', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('”ë', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('”ì', 'JI');
insert into HZPYDZB (HZ, PY)
values ('”ì', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('”î', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('”î', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('”ï', 'REN');
insert into HZPYDZB (HZ, PY)
values ('”ñ', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('”ó', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('”ò', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('”ô', 'QI');
insert into HZPYDZB (HZ, PY)
values ('”ö', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('”ù', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('”û', 'E');
insert into HZPYDZB (HZ, PY)
values ('”°', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('”¢', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”£', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”§', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”•', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”¶', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”ß', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”®', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”©', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”™', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”´', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”¨', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”≠', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”Æ', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”Ø', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”∞', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”±', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”≤', 'YING');
insert into HZPYDZB (HZ, PY)
values ('”≥', 'YING');
commit;
prompt 9200 records committed...
insert into HZPYDZB (HZ, PY)
values ('”µ', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('”∂', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('”π', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('”∫', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('”ª', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('”º', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('”Ω', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('”æ', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('”ø', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('”¿', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('”¡', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('”¬', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('”√', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('”ƒ', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”≈', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”∆', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”«', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”»', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”…', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('” ', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”À', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”Ã', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”Õ', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”Œ', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”œ', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”–', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”—', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”“', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('””', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”‘', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”’', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”÷', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”◊', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('”ÿ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Ÿ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”⁄', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”€', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”‹', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”›', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”ﬁ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”ﬂ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”‡', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”·', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”‚', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”„', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”‰', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Â', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Ê', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Á', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Ë', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”È', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Í', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Î', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Ï', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Ì', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Ó', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Ô', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Ò', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Ú', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Û', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”Ù', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”ı', 'XU');
insert into HZPYDZB (HZ, PY)
values ('”ı', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”ˆ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”˜', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”¯', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”˘', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”˙', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”˚', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”˝', 'YU');
insert into HZPYDZB (HZ, PY)
values ('”˛', 'YU');
insert into HZPYDZB (HZ, PY)
values ('‘A', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('‘B', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('‘C', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('‘D', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('‘E', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('‘F', 'NA');
insert into HZPYDZB (HZ, PY)
values ('‘G', 'NE');
insert into HZPYDZB (HZ, PY)
values ('‘H', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('‘I', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('‘J', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('‘M', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('‘N', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('‘N', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('‘O', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('‘P', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('‘Q', 'SA');
insert into HZPYDZB (HZ, PY)
values ('‘R', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('‘S', 'HU');
insert into HZPYDZB (HZ, PY)
values ('‘T', 'YI');
insert into HZPYDZB (HZ, PY)
values ('‘U', 'YI');
insert into HZPYDZB (HZ, PY)
values ('‘V', 'SU');
insert into HZPYDZB (HZ, PY)
values ('‘W', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('‘X', 'HE');
insert into HZPYDZB (HZ, PY)
values ('‘Y', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('‘Z', 'HE');
insert into HZPYDZB (HZ, PY)
values ('‘\', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('‘]', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('‘^', 'ZHENG');
commit;
prompt 9300 records committed...
insert into HZPYDZB (HZ, PY)
values ('‘_', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('‘a', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('‘c', 'FU');
insert into HZPYDZB (HZ, PY)
values ('‘f', 'LING');
insert into HZPYDZB (HZ, PY)
values ('‘g', 'DI');
insert into HZPYDZB (HZ, PY)
values ('‘g', 'TI');
insert into HZPYDZB (HZ, PY)
values ('‘i', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('‘j', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('‘k', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('‘l', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('‘m', 'YI');
insert into HZPYDZB (HZ, PY)
values ('‘n', 'JU');
insert into HZPYDZB (HZ, PY)
values ('‘p', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('‘q', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('‘r', 'YI');
insert into HZPYDZB (HZ, PY)
values ('‘s', 'QU');
insert into HZPYDZB (HZ, PY)
values ('‘t', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('‘u', 'PING');
insert into HZPYDZB (HZ, PY)
values ('‘x', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('‘x', 'QU');
insert into HZPYDZB (HZ, PY)
values ('‘{', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('‘|', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('‘}', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('‘Ä', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('‘Å', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('‘Ç', 'XU');
insert into HZPYDZB (HZ, PY)
values ('‘É', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('‘Ñ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('‘Ü', 'GE');
insert into HZPYDZB (HZ, PY)
values ('‘Ü', 'HE');
insert into HZPYDZB (HZ, PY)
values ('‘á', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('‘ä', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('‘å', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('‘ç', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('‘è', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('‘ê', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('‘ë', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('‘í', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('‘ì', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('‘î', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('‘ï', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('‘ñ', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('‘ó', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('‘ò', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('‘ô', 'MI');
insert into HZPYDZB (HZ, PY)
values ('‘ö', 'MING');
insert into HZPYDZB (HZ, PY)
values ('‘ù', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('‘ü', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('‘†', 'ER');
insert into HZPYDZB (HZ, PY)
values ('‘°', 'YU');
insert into HZPYDZB (HZ, PY)
values ('‘¢', 'YU');
insert into HZPYDZB (HZ, PY)
values ('‘£', 'YU');
insert into HZPYDZB (HZ, PY)
values ('‘§', 'YU');
insert into HZPYDZB (HZ, PY)
values ('‘•', 'YU');
insert into HZPYDZB (HZ, PY)
values ('‘¶', 'YU');
insert into HZPYDZB (HZ, PY)
values ('‘ß', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘®', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘©', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘™', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘´', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘¨', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘≠', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘Æ', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘Ø', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘∞', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘±', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘≤', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘≥', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘¥', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘µ', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘∂', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘∑', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘∏', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘π', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘∫', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘ª', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('‘º', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('‘º', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('‘Ω', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('‘æ', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('‘ø', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('‘¿', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('‘¡', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('‘¬', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('‘√', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('‘ƒ', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('‘≈', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('‘∆', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('‘«', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('‘»', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('‘…', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‘…', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('‘ ', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('‘À', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('‘Ã', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('‘Õ', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('‘Œ', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('‘œ', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('‘–', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('‘—', 'ZA');
commit;
prompt 9400 records committed...
insert into HZPYDZB (HZ, PY)
values ('‘“', 'ZA');
insert into HZPYDZB (HZ, PY)
values ('‘”', 'ZA');
insert into HZPYDZB (HZ, PY)
values ('‘‘', 'ZAI');
insert into HZPYDZB (HZ, PY)
values ('‘’', 'ZAI');
insert into HZPYDZB (HZ, PY)
values ('‘÷', 'ZAI');
insert into HZPYDZB (HZ, PY)
values ('‘◊', 'ZAI');
insert into HZPYDZB (HZ, PY)
values ('‘ÿ', 'ZAI');
insert into HZPYDZB (HZ, PY)
values ('‘Ÿ', 'ZAI');
insert into HZPYDZB (HZ, PY)
values ('‘⁄', 'ZAI');
insert into HZPYDZB (HZ, PY)
values ('‘€', 'ZAN');
insert into HZPYDZB (HZ, PY)
values ('‘‹', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('‘‹', 'ZAN');
insert into HZPYDZB (HZ, PY)
values ('‘›', 'ZAN');
insert into HZPYDZB (HZ, PY)
values ('‘ﬁ', 'ZAN');
insert into HZPYDZB (HZ, PY)
values ('‘ﬂ', 'ZANG');
insert into HZPYDZB (HZ, PY)
values ('‘‡', 'ZANG');
insert into HZPYDZB (HZ, PY)
values ('‘·', 'ZANG');
insert into HZPYDZB (HZ, PY)
values ('‘‚', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('‘‰', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('‘‰', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('‘Â', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('‘Ê', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('‘Á', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('‘Ë', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('‘È', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('‘Í', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('‘Î', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('‘Ï', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('‘Ì', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('‘Ó', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('‘Ô', 'ZAO');
insert into HZPYDZB (HZ, PY)
values ('‘', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('‘Ò', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('‘Ò', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('‘Ú', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('‘Û', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('‘ı', 'ZEN');
insert into HZPYDZB (HZ, PY)
values ('‘ˆ', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('‘˜', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('‘¯', 'CENG');
insert into HZPYDZB (HZ, PY)
values ('‘¯', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('‘˘', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('‘˙', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('‘˚', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('‘¸', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('‘˝', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('‘˛', 'YA');
insert into HZPYDZB (HZ, PY)
values ('‘˛', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('’A', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('’B', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('’C', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('’D', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('’F', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('’G', 'WU');
insert into HZPYDZB (HZ, PY)
values ('’I', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('’J', 'REN');
insert into HZPYDZB (HZ, PY)
values ('’L', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('’N', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('’O', 'YI');
insert into HZPYDZB (HZ, PY)
values ('’P', 'TING');
insert into HZPYDZB (HZ, PY)
values ('’R', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('’S', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('’T', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('’U', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('’V', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('’X', 'SHUA');
insert into HZPYDZB (HZ, PY)
values ('’Z', 'YU');
insert into HZPYDZB (HZ, PY)
values ('’\', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('’_', 'WU');
insert into HZPYDZB (HZ, PY)
values ('’`', 'WU');
insert into HZPYDZB (HZ, PY)
values ('’b', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('’c', 'BU');
insert into HZPYDZB (HZ, PY)
values ('’e', 'JING');
insert into HZPYDZB (HZ, PY)
values ('’f', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('’f', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('’g', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’h', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('’h', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('’k', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('’l', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('’n', 'KE');
insert into HZPYDZB (HZ, PY)
values ('’p', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('’r', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('’s', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('’x', 'YI');
insert into HZPYDZB (HZ, PY)
values ('’z', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('’{', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('’{', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('’|', 'PI');
insert into HZPYDZB (HZ, PY)
values ('’~', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('’Å', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('’Ç', 'JI');
insert into HZPYDZB (HZ, PY)
values ('’É', 'QI');
insert into HZPYDZB (HZ, PY)
values ('’Ñ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('’Ü', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('’á', 'JU');
insert into HZPYDZB (HZ, PY)
values ('’à', 'QING');
insert into HZPYDZB (HZ, PY)
values ('’ä', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('’ã', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('’è', 'LIANG');
commit;
prompt 9500 records committed...
insert into HZPYDZB (HZ, PY)
values ('’ë', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('’í', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('’ì', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('’î', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('’î', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('’ï', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('’ñ', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('’ö', 'XU');
insert into HZPYDZB (HZ, PY)
values ('’ú', 'DI');
insert into HZPYDZB (HZ, PY)
values ('’ú', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('’ü', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('’¢', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('’£', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('’§', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('’§', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('’•', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('’¶', 'ZA');
insert into HZPYDZB (HZ, PY)
values ('’ß', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('’®', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('’©', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('’™', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('’´', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('’¨', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('’≠', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('’Æ', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('’Ø', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('’∞', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’±', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’≤', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’≥', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('’≥', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’¥', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’µ', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’∂', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’∑', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’∏', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’π', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’ª', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’º', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’Ω', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’æ', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’ø', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’¿', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('’¡', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('’¬', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('’√', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('’ƒ', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('’≈', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('’∆', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('’«', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('’»', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('’…', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('’ ', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('’À', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('’Ã', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('’Õ', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('’œ', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('’–', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('’—', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('’“', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('’”', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('’‘', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('’’', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('’÷', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('’◊', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('’ÿ', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('’Ÿ', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('’⁄', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('’€', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('’€', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('’‹', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('’›', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('’ﬁ', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('’ﬂ', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('’‡', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('’·', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('’‚', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('’„', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('’‰', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’Â', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’Ê', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’Á', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’Ë', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’È', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’Í', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’Î', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’Ï', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’Ì', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’Ó', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’Ô', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’Ò', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’Ú', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’Û', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('’Ù', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('’ı', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('’ˆ', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('’˜', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('’¯', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('’˘', 'ZHENG');
commit;
prompt 9600 records committed...
insert into HZPYDZB (HZ, PY)
values ('’˙', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('’˚', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('’¸', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('’˝', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('’˛', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('÷A', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('÷B', 'DI');
insert into HZPYDZB (HZ, PY)
values ('÷B', 'TI');
insert into HZPYDZB (HZ, PY)
values ('÷C', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('÷D', 'FU');
insert into HZPYDZB (HZ, PY)
values ('÷E', 'PU');
insert into HZPYDZB (HZ, PY)
values ('÷F', 'TING');
insert into HZPYDZB (HZ, PY)
values ('÷I', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('÷I', 'YU');
insert into HZPYDZB (HZ, PY)
values ('÷L', 'AI');
insert into HZPYDZB (HZ, PY)
values ('÷L', 'XI');
insert into HZPYDZB (HZ, PY)
values ('÷M', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('÷N', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('÷O', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('÷Q', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('÷S', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('÷T', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷V', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('÷W', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('÷Y', 'GE');
insert into HZPYDZB (HZ, PY)
values ('÷Z', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('÷[', 'XU');
insert into HZPYDZB (HZ, PY)
values ('÷\', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('÷^', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('÷a', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('÷a', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('÷b', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('÷d', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('÷f', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('÷g', 'GE');
insert into HZPYDZB (HZ, PY)
values ('÷h', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('÷i', 'MI');
insert into HZPYDZB (HZ, PY)
values ('÷j', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('÷k', 'MI');
insert into HZPYDZB (HZ, PY)
values ('÷l', 'XI');
insert into HZPYDZB (HZ, PY)
values ('÷n', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('÷n', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('÷q', 'SU');
insert into HZPYDZB (HZ, PY)
values ('÷s', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('÷t', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('÷u', 'YI');
insert into HZPYDZB (HZ, PY)
values ('÷w', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('÷x', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('÷y', 'HE');
insert into HZPYDZB (HZ, PY)
values ('÷z', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('÷{', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('÷|', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('÷Ä', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('÷Ç', 'LI');
insert into HZPYDZB (HZ, PY)
values ('÷É', 'MO');
insert into HZPYDZB (HZ, PY)
values ('÷Ñ', 'MO');
insert into HZPYDZB (HZ, PY)
values ('÷Ü', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('÷á', 'MIU');
insert into HZPYDZB (HZ, PY)
values ('÷â', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('÷ä', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('÷ã', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('÷å', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('÷é', 'OU');
insert into HZPYDZB (HZ, PY)
values ('÷ê', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('÷ê', 'XI');
insert into HZPYDZB (HZ, PY)
values ('÷ë', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('÷ë', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('÷í', 'AO');
insert into HZPYDZB (HZ, PY)
values ('÷ñ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('÷ó', 'HU');
insert into HZPYDZB (HZ, PY)
values ('÷ò', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('÷ô', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('÷ö', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('÷õ', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('÷ú', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('÷ú', 'WA');
insert into HZPYDZB (HZ, PY)
values ('÷ü', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('÷°', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('÷¢', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('÷£', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('÷§', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('÷•', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷¶', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷ß', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷®', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷®', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('÷©', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷™', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷´', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷¨', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷≠', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷Æ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷Ø', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷∞', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷±', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷≤', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷≥', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('÷¥', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷µ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷∂', 'ZHI');
commit;
prompt 9700 records committed...
insert into HZPYDZB (HZ, PY)
values ('÷∑', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷∏', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷π', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷∫', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷ª', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷º', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷Ω', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷æ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷ø', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷¿', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷¡', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷¬', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷√', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷ƒ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷≈', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷∆', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷«', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷»', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷…', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷ ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷À', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷Õ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷Œ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷œ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('÷–', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('÷“', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('÷”', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('÷‘', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('÷’', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('÷÷', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('÷◊', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('÷ÿ', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('÷ÿ', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('÷Ÿ', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('÷⁄', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('÷€', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('÷‹', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('÷›', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('÷ﬁ', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('÷ﬂ', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('÷‡', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('÷·', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('÷‚', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('÷„', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('÷‰', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('÷Â', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('÷Ê', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('÷Á', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('÷Ë', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('÷È', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷Í', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷Î', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷Ï', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷Ó', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷Ô', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷Ò', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷Ú', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷Û', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷Ù', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷ı', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷ˆ', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷˜', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷¯', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷˘', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷˙', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷˚', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷¸', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷˝', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('÷˛', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('◊@', 'XI');
insert into HZPYDZB (HZ, PY)
values ('◊C', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('◊D', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('◊E', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('◊K', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('◊L', 'BO');
insert into HZPYDZB (HZ, PY)
values ('◊N', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('◊Q', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('◊S', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('◊T', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('◊V', 'PU');
insert into HZPYDZB (HZ, PY)
values ('◊Z', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('◊\', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('◊^', 'JI');
insert into HZPYDZB (HZ, PY)
values ('◊_', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('◊a', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('◊a', 'NOU');
insert into HZPYDZB (HZ, PY)
values ('◊c', 'AI');
insert into HZPYDZB (HZ, PY)
values ('◊e', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('◊g', 'YI');
insert into HZPYDZB (HZ, PY)
values ('◊h', 'YI');
insert into HZPYDZB (HZ, PY)
values ('◊k', 'NOU');
insert into HZPYDZB (HZ, PY)
values ('◊m', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('◊p', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('◊t', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('◊u', 'YU');
insert into HZPYDZB (HZ, PY)
values ('◊w', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('◊x', 'DU');
insert into HZPYDZB (HZ, PY)
values ('◊y', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('◊z', 'JUAN');
commit;
prompt 9800 records committed...
insert into HZPYDZB (HZ, PY)
values ('◊|', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('◊Å', 'LI');
insert into HZPYDZB (HZ, PY)
values ('◊Ç', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('◊É', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('◊Ü', 'E');
insert into HZPYDZB (HZ, PY)
values ('◊ã', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('◊é', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('◊è', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('◊ë', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('◊í', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('◊ò', 'DU');
insert into HZPYDZB (HZ, PY)
values ('◊ô', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('◊ö', 'REN');
insert into HZPYDZB (HZ, PY)
values ('◊õ', 'XIONG');
insert into HZPYDZB (HZ, PY)
values ('◊ù', 'BI');
insert into HZPYDZB (HZ, PY)
values ('◊û', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('◊û', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('◊ü', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('◊°', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('◊¢', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('◊£', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('◊§', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('◊•', 'ZHUA');
insert into HZPYDZB (HZ, PY)
values ('◊¶', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('◊¶', 'ZHUA');
insert into HZPYDZB (HZ, PY)
values ('◊ß', 'YE');
insert into HZPYDZB (HZ, PY)
values ('◊®', 'ZHUAN');
insert into HZPYDZB (HZ, PY)
values ('◊©', 'ZHUAN');
insert into HZPYDZB (HZ, PY)
values ('◊™', 'ZHUAN');
insert into HZPYDZB (HZ, PY)
values ('◊´', 'ZHUAN');
insert into HZPYDZB (HZ, PY)
values ('◊¨', 'ZHUAN');
insert into HZPYDZB (HZ, PY)
values ('◊≠', 'ZHUAN');
insert into HZPYDZB (HZ, PY)
values ('◊Æ', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('◊Ø', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('◊∞', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('◊±', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('◊≤', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('◊≥', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('◊¥', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('◊µ', 'ZHUI');
insert into HZPYDZB (HZ, PY)
values ('◊∂', 'ZHUI');
insert into HZPYDZB (HZ, PY)
values ('◊∑', 'ZHUI');
insert into HZPYDZB (HZ, PY)
values ('◊∏', 'ZHUI');
insert into HZPYDZB (HZ, PY)
values ('◊π', 'ZHUI');
insert into HZPYDZB (HZ, PY)
values ('◊∫', 'ZHUI');
insert into HZPYDZB (HZ, PY)
values ('◊ª', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('◊º', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('◊Ω', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('◊æ', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('◊ø', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('◊¿', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('◊¡', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('◊¬', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('◊√', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('◊ƒ', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('◊≈', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('◊≈', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('◊∆', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('◊«', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('◊»', 'CI');
insert into HZPYDZB (HZ, PY)
values ('◊»', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('◊…', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('◊ ', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('◊À', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('◊Ã', 'CI');
insert into HZPYDZB (HZ, PY)
values ('◊Ã', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('◊Õ', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('◊Œ', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('◊œ', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('◊–', 'ZAI');
insert into HZPYDZB (HZ, PY)
values ('◊–', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('◊—', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('◊”', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('◊‘', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('◊’', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('◊÷', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('◊ÿ', 'ZONG');
insert into HZPYDZB (HZ, PY)
values ('◊Ÿ', 'ZONG');
insert into HZPYDZB (HZ, PY)
values ('◊⁄', 'ZONG');
insert into HZPYDZB (HZ, PY)
values ('◊€', 'ZONG');
insert into HZPYDZB (HZ, PY)
values ('◊‹', 'ZONG');
insert into HZPYDZB (HZ, PY)
values ('◊›', 'ZONG');
insert into HZPYDZB (HZ, PY)
values ('◊ﬁ', 'ZOU');
insert into HZPYDZB (HZ, PY)
values ('◊ﬂ', 'ZOU');
insert into HZPYDZB (HZ, PY)
values ('◊‡', 'ZOU');
insert into HZPYDZB (HZ, PY)
values ('◊·', 'ZOU');
insert into HZPYDZB (HZ, PY)
values ('◊‚', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('◊„', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('◊‰', 'CU');
insert into HZPYDZB (HZ, PY)
values ('◊Â', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('◊Ê', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('◊Á', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('◊Ë', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('◊È', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('◊Í', 'ZUAN');
insert into HZPYDZB (HZ, PY)
values ('◊Ï', 'ZUI');
insert into HZPYDZB (HZ, PY)
values ('◊Ì', 'ZUI');
insert into HZPYDZB (HZ, PY)
values ('◊Ó', 'ZUI');
insert into HZPYDZB (HZ, PY)
values ('◊Ô', 'ZUI');
insert into HZPYDZB (HZ, PY)
values ('◊', 'ZUN');
commit;
prompt 9900 records committed...
insert into HZPYDZB (HZ, PY)
values ('◊Ò', 'ZUN');
insert into HZPYDZB (HZ, PY)
values ('◊Ú', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('◊Û', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('◊Ù', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('◊ı', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('◊ˆ', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('◊˜', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('◊¯', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('◊˘', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('ÿA', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ÿC', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÿD', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ÿE', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ÿG', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÿI', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ÿJ', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ÿJ', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ÿL', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('ÿM', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ÿN', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('ÿN', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ÿO', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('ÿP', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ÿP', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ÿX', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ÿY', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ÿ]', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ÿ^', 'BA');
insert into HZPYDZB (HZ, PY)
values ('ÿ_', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('ÿ`', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÿa', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ÿb', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ÿc', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('ÿc', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('ÿd', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('ÿe', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ÿh', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('ÿh', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ÿj', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ÿk', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('ÿm', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ÿo', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ÿt', 'AN');
insert into HZPYDZB (HZ, PY)
values ('ÿx', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('ÿy', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ÿy', 'NA');
insert into HZPYDZB (HZ, PY)
values ('ÿ{', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ÿ}', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ÿ~', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('ÿÄ', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ÿÅ', 'AN');
insert into HZPYDZB (HZ, PY)
values ('ÿÇ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ÿÇ', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('ÿÉ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ÿÑ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ÿÜ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ÿá', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('ÿà', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('ÿã', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ÿç', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ÿé', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ÿè', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ÿë', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ÿí', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('ÿì', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ÿî', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('ÿô', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÿö', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('ÿõ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ÿú', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ÿù', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ÿû', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÿü', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('ÿ†', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÿ°', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ÿ¢', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÿ¢', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ÿ£', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ÿ§', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('ÿ•', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('ÿ¶', 'SA');
insert into HZPYDZB (HZ, PY)
values ('ÿß', 'PI');
insert into HZPYDZB (HZ, PY)
values ('ÿ®', 'GEN');
insert into HZPYDZB (HZ, PY)
values ('ÿ®', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('ÿ©', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ÿ™', 'GE');
insert into HZPYDZB (HZ, PY)
values ('ÿ´', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ÿ¨', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÿÆ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ÿ∞', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ÿ±', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ÿ±', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ÿ≤', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ÿ≥', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ÿ¥', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÿµ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('ÿµ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÿ∑', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('ÿ∏', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ÿπ', 'YU');
commit;
prompt 10000 records committed...
insert into HZPYDZB (HZ, PY)
values ('ÿ∫', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('ÿΩ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÿΩ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ÿæ', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('ÿø', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ÿ¿', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÿ¡', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ÿ¬', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ÿ√', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('ÿ√', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ÿƒ', 'SE');
insert into HZPYDZB (HZ, PY)
values ('ÿ≈', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ÿ≈', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ÿ∆', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('ÿ«', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('ÿ»', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('ÿ»', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÿ ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ÿÀ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ÿœ', 'PO');
insert into HZPYDZB (HZ, PY)
values ('ÿ–', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ÿ—', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ÿ—', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ÿ“', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ÿ‘', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('ÿ÷', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('ÿ◊', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÿÿ', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('ÿŸ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ÿ⁄', 'KU');
insert into HZPYDZB (HZ, PY)
values ('ÿ⁄', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('ÿ€', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ÿ‹', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ÿ‹', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('ÿ›', 'LA');
insert into HZPYDZB (HZ, PY)
values ('ÿﬁ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÿﬂ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ÿ‡', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÿ·', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('ÿ‚', 'PIAO');
insert into HZPYDZB (HZ, PY)
values ('ÿ„', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ÿÂ', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ÿÂ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ÿÊ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÿÁ', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('ÿË', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('ÿÍ', 'DING');
insert into HZPYDZB (HZ, PY)
values ('ÿÏ', 'LE');
insert into HZPYDZB (HZ, PY)
values ('ÿÏ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ÿÌ', 'SA');
insert into HZPYDZB (HZ, PY)
values ('ÿÓ', 'GE');
insert into HZPYDZB (HZ, PY)
values ('ÿ', 'REN');
insert into HZPYDZB (HZ, PY)
values ('ÿÒ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ÿÚ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ÿÚ', 'PI');
insert into HZPYDZB (HZ, PY)
values ('ÿÛ', 'YA');
insert into HZPYDZB (HZ, PY)
values ('ÿÙ', 'WA');
insert into HZPYDZB (HZ, PY)
values ('ÿı', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ÿˆ', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('ÿ˜', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('ÿ˜', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ÿ¯', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('ÿ¯', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('ÿ˘', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('ÿ˙', 'NING');
insert into HZPYDZB (HZ, PY)
values ('ÿ˚', 'KA');
insert into HZPYDZB (HZ, PY)
values ('ÿ¸', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('ÿ˝', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÿ˛', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('Ÿ@', 'ER');
insert into HZPYDZB (HZ, PY)
values ('ŸA', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('ŸF', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ŸH', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ŸI', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('ŸJ', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('ŸK', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('ŸL', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('ŸM', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ŸN', 'TIE');
insert into HZPYDZB (HZ, PY)
values ('ŸP', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ŸQ', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('ŸR', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ŸS', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('ŸT', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ŸU', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ŸV', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ŸZ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Ÿ]', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ÿc', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Ÿd', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('Ÿe', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('Ÿf', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('Ÿg', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('Ÿh', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('Ÿi', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('Ÿj', 'ZANG');
insert into HZPYDZB (HZ, PY)
values ('Ÿp', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('Ÿr', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('Ÿs', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('Ÿu', 'MAI');
commit;
prompt 10100 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ÿz', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('Ÿ{', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('Ÿ}', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ŸÄ', 'DU');
insert into HZPYDZB (HZ, PY)
values ('ŸÇ', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('ŸÉ', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('ŸÖ', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Ÿà', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('Ÿâ', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('Ÿç', 'ZUAN');
insert into HZPYDZB (HZ, PY)
values ('Ÿê', 'SAI');
insert into HZPYDZB (HZ, PY)
values ('Ÿí', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('Ÿî', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('Ÿô', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Ÿö', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('Ÿõ', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('Ÿù', 'ZAN');
insert into HZPYDZB (HZ, PY)
values ('Ÿ°', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Ÿ¢', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Ÿ£', 'NI');
insert into HZPYDZB (HZ, PY)
values ('Ÿ§', 'GA');
insert into HZPYDZB (HZ, PY)
values ('Ÿ§', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Ÿ•', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ÿ¶', 'ER');
insert into HZPYDZB (HZ, PY)
values ('Ÿ®', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('Ÿ©', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('Ÿ™', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('Ÿ™', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Ÿ¨', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('Ÿ¨', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('Ÿ≠', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('ŸÆ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ŸÆ', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('ŸØ', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('Ÿ≤', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('Ÿ≥', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ÿ¥', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('Ÿµ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ÿ∏', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('Ÿπ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Ÿ∫', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('Ÿª', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('Ÿª', 'QING');
insert into HZPYDZB (HZ, PY)
values ('Ÿº', 'RE');
insert into HZPYDZB (HZ, PY)
values ('Ÿº', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('ŸΩ', 'PAI');
insert into HZPYDZB (HZ, PY)
values ('Ÿæ', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('Ÿø', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('Ÿ¿', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('Ÿ¡', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Ÿ¬', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Ÿ√', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('Ÿ√', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Ÿƒ', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('Ÿ≈', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('Ÿ∆', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Ÿ«', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('Ÿ»', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('Ÿ ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ÿ ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ŸÀ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ŸÃ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ŸÕ', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('ŸŒ', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ÿœ', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('Ÿ–', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('Ÿ—', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Ÿ“', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Ÿ”', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Ÿ‘', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ÿ’', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ÿ÷', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('Ÿ◊', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Ÿ◊', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('ŸŸ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ŸŸ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('Ÿ⁄', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Ÿ€', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('Ÿ€', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('Ÿ‹', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('Ÿ›', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('Ÿ‡', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('Ÿ·', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Ÿ‚', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Ÿ„', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('Ÿ‰', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ŸÊ', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ŸÈ', 'PU');
insert into HZPYDZB (HZ, PY)
values ('ŸÍ', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ŸÎ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ŸÌ', 'SU');
insert into HZPYDZB (HZ, PY)
values ('ŸÓ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ŸÔ', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('Ÿ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('ŸÒ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ŸÚ', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('ŸÛ', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('ŸÛ', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('Ÿı', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ÿı', 'LUAN');
commit;
prompt 10200 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ÿˆ', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Ÿ˜', 'BING');
insert into HZPYDZB (HZ, PY)
values ('ø‘', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('ø’', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('ø÷', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('ø◊', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('øÿ', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('øŸ', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('ø⁄', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('ø€', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('ø‹', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('ø›', 'KU');
insert into HZPYDZB (HZ, PY)
values ('øﬁ', 'KU');
insert into HZPYDZB (HZ, PY)
values ('øﬂ', 'KU');
insert into HZPYDZB (HZ, PY)
values ('ø‡', 'KU');
insert into HZPYDZB (HZ, PY)
values ('ø·', 'KU');
insert into HZPYDZB (HZ, PY)
values ('ø‚', 'KU');
insert into HZPYDZB (HZ, PY)
values ('ø„', 'KU');
insert into HZPYDZB (HZ, PY)
values ('ø‰', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('øÂ', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('øÊ', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('øÁ', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('øË', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('øÈ', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('øÍ', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('øÎ', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('øÏ', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('øÌ', 'KUAN');
insert into HZPYDZB (HZ, PY)
values ('øÓ', 'KUAN');
insert into HZPYDZB (HZ, PY)
values ('øÔ', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('ø', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('øÒ', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('øÚ', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('øÛ', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('øÙ', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('øı', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('øˆ', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('ø˜', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ø¯', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ø˘', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ø˘', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ø˙', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ø˚', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ø¸', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ø˝', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ø˛', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('ø˛', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('¿A', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('¿F', 'ZUAN');
insert into HZPYDZB (HZ, PY)
values ('¿I', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('¿L', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('¿M', 'JI');
insert into HZPYDZB (HZ, PY)
values ('¿Q', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('¿R', 'SAO');
insert into HZPYDZB (HZ, PY)
values ('¿S', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('¿U', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('¿Y', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('¿Z', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('¿]', 'RU');
insert into HZPYDZB (HZ, PY)
values ('¿^', 'JI');
insert into HZPYDZB (HZ, PY)
values ('¿_', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('¿a', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿b', 'FU');
insert into HZPYDZB (HZ, PY)
values ('¿f', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿g', 'MO');
insert into HZPYDZB (HZ, PY)
values ('¿h', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿k', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('¿n', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿q', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('¿r', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¿t', 'YING');
insert into HZPYDZB (HZ, PY)
values ('¿u', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('¿{', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿}', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿~', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¿Ä', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('¿Ç', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('¿É', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('¿Ñ', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('¿Ü', 'YING');
insert into HZPYDZB (HZ, PY)
values ('¿á', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('¿à', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('¿à', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('¿â', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('¿ä', 'SHUAI');
insert into HZPYDZB (HZ, PY)
values ('¿ä', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('¿ã', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('¿å', 'FOU');
insert into HZPYDZB (HZ, PY)
values ('¿ç', 'FOU');
insert into HZPYDZB (HZ, PY)
values ('¿è', 'BO');
insert into HZPYDZB (HZ, PY)
values ('¿ì', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('¿ò', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('¿ú', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿†', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('¿°', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('¿¢', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('¿£', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('¿§', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('¿•', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('¿¶', 'KUN');
commit;
prompt 10300 records committed...
insert into HZPYDZB (HZ, PY)
values ('¿ß', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('¿®', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('¿©', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('¿™', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('¿´', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('¿¨', 'LA');
insert into HZPYDZB (HZ, PY)
values ('¿≠', 'LA');
insert into HZPYDZB (HZ, PY)
values ('¿Æ', 'LA');
insert into HZPYDZB (HZ, PY)
values ('¿Ø', 'LA');
insert into HZPYDZB (HZ, PY)
values ('¿∞', 'LA');
insert into HZPYDZB (HZ, PY)
values ('¿±', 'LA');
insert into HZPYDZB (HZ, PY)
values ('¿≤', 'LA');
insert into HZPYDZB (HZ, PY)
values ('¿≥', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('¿¥', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('¿µ', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('¿∂', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿∑', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿∏', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿π', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿∫', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿ª', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿º', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿Ω', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿æ', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿ø', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿¿', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿¡', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿¬', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿√', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿ƒ', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('¿≈', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('¿∆', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('¿«', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('¿»', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('¿…', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('¿ ', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('¿À', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('¿Ã', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('¿Õ', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('¿Œ', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('¿œ', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('¿–', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('¿—', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('¿“', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('¿”', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('¿”', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('¿‘', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('¿’', 'LE');
insert into HZPYDZB (HZ, PY)
values ('¿÷', 'LE');
insert into HZPYDZB (HZ, PY)
values ('¿÷', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('¿◊', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿ÿ', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿Ÿ', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿⁄', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿€', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿‹', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿›', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿ﬁ', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿ﬂ', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿‡', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿·', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('¿‚', 'LENG');
insert into HZPYDZB (HZ, PY)
values ('¿‚', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¿„', 'LENG');
insert into HZPYDZB (HZ, PY)
values ('¿‰', 'LENG');
insert into HZPYDZB (HZ, PY)
values ('¿Â', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿Ê', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿Á', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿Ë', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿È', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿Í', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿Î', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿Ï', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿Ì', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿Ó', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿Ô', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿Ò', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿Ú', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿Û', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿Ù', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿ı', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿ˆ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿˜', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿¯', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿˘', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿˙', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿˚', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿¸', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿˝', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿˛', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¡B', 'GU');
insert into HZPYDZB (HZ, PY)
values ('¡C', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('¡D', 'JU');
insert into HZPYDZB (HZ, PY)
values ('¡E', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('¡E', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('¡F', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('¡G', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('¡H', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('¡I', 'JUAN');
commit;
prompt 10400 records committed...
insert into HZPYDZB (HZ, PY)
values ('¡J', 'FU');
insert into HZPYDZB (HZ, PY)
values ('¡L', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('¡L', 'GUAI');
insert into HZPYDZB (HZ, PY)
values ('¡O', 'AN');
insert into HZPYDZB (HZ, PY)
values ('¡R', 'MA');
insert into HZPYDZB (HZ, PY)
values ('¡S', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('¡T', 'BA');
insert into HZPYDZB (HZ, PY)
values ('¡W', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('¡Y', 'JI');
insert into HZPYDZB (HZ, PY)
values ('¡Z', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('¡[', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('¡\', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('¡]', 'MI');
insert into HZPYDZB (HZ, PY)
values ('¡_', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('¡a', 'JI');
insert into HZPYDZB (HZ, PY)
values ('¡b', 'JI');
insert into HZPYDZB (HZ, PY)
values ('¡c', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('¡d', 'MI');
insert into HZPYDZB (HZ, PY)
values ('¡e', 'DA');
insert into HZPYDZB (HZ, PY)
values ('¡i', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('¡j', 'BA');
insert into HZPYDZB (HZ, PY)
values ('¡l', 'GU');
insert into HZPYDZB (HZ, PY)
values ('¡o', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('¡o', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('¡q', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('¡s', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('¡u', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('¡v', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('¡w', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('¡x', 'YI');
insert into HZPYDZB (HZ, PY)
values ('¡z', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('¡}', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('¡~', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('¡Ä', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('¡Ç', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('¡Ñ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¡Ö', 'NOU');
insert into HZPYDZB (HZ, PY)
values ('¡á', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('¡á', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('¡à', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('¡â', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('¡ä', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('¡ã', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('¡å', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('¡è', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('¡ê', 'LA');
insert into HZPYDZB (HZ, PY)
values ('¡ë', 'BI');
insert into HZPYDZB (HZ, PY)
values ('¡î', 'QU');
insert into HZPYDZB (HZ, PY)
values ('¡ï', 'XI');
insert into HZPYDZB (HZ, PY)
values ('¡ñ', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('¡ô', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('¡ö', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('¡ù', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('¡û', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('¡ü', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('¡°', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¡¢', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¡£', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¡§', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¡•', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¡¶', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¡ß', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¡®', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¡©', 'LIA');
insert into HZPYDZB (HZ, PY)
values ('¡©', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('¡™', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¡´', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¡¨', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¡Æ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¡Ø', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¡∞', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¡±', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¡≤', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¡≥', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¡¥', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¡µ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¡∂', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¡∑', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¡∏', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('¡π', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('¡∫', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('¡ª', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('¡º', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('¡Ω', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('¡æ', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('¡ø', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('¡¿', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('¡¡', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('¡¬', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('¡√', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('¡ƒ', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('¡≈', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('¡∆', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('¡«', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('¡»', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('¡…', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('¡ ', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('¡À', 'LE');
insert into HZPYDZB (HZ, PY)
values ('¡À', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('¡Ã', 'LIAO');
commit;
prompt 10500 records committed...
insert into HZPYDZB (HZ, PY)
values ('¡Õ', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('¡Œ', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('¡œ', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('¡–', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('¡—', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('¡“', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('¡”', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('¡‘', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('¡’', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('¡÷', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('¡◊', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('¡◊', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡ÿ', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('¡Ÿ', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('¡⁄', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('¡€', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('¡‹', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('¡›', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('¡ﬁ', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('¡ﬂ', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('¡‡', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('¡‡', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡·', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡‚', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡„', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡‰', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡Â', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡Ê', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡Á', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡Ë', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡È', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡Í', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡Î', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡Ï', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡Ì', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡Ó', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¡Ô', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('¡', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('¡Ò', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('¡Ú', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('¡Ù', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('¡ı', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('¡˜', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('¡¯', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('¡˘', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('¡˙', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('¡˚', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('¡˝', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('¡˛', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('¬@', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('¬B', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('¬F', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('¬G', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('¬G', 'HE');
insert into HZPYDZB (HZ, PY)
values ('¬I', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¬J', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('¬K', 'AO');
insert into HZPYDZB (HZ, PY)
values ('¬L', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('¬P', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('¬T', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('¬U', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('¬X', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('¬Z', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('¬[', 'TING');
insert into HZPYDZB (HZ, PY)
values ('¬]', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('¬^', 'QU');
insert into HZPYDZB (HZ, PY)
values ('¬_', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('¬`', 'JU');
insert into HZPYDZB (HZ, PY)
values ('¬a', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('¬b', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('¬c', 'JI');
insert into HZPYDZB (HZ, PY)
values ('¬c', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('¬e', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('¬f', 'JI');
insert into HZPYDZB (HZ, PY)
values ('¬g', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('¬h', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('¬l', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('¬m', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('¬o', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('¬q', 'UU');
insert into HZPYDZB (HZ, PY)
values ('¬r', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('¬s', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('¬t', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('¬v', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('¬v', 'WA');
insert into HZPYDZB (HZ, PY)
values ('¬w', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('¬z', 'TIE');
insert into HZPYDZB (HZ, PY)
values ('¬z', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('¬|', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('¬}', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('¬~', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('¬Ä', 'JING');
insert into HZPYDZB (HZ, PY)
values ('¬Å', 'BI');
insert into HZPYDZB (HZ, PY)
values ('¬Ç', 'DI');
insert into HZPYDZB (HZ, PY)
values ('¬Ñ', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('¬á', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('¬à', 'DING');
insert into HZPYDZB (HZ, PY)
values ('¬â', 'UU');
insert into HZPYDZB (HZ, PY)
values ('¬ä', 'TING');
insert into HZPYDZB (HZ, PY)
values ('¬ã', 'JU');
commit;
prompt 10600 records committed...
insert into HZPYDZB (HZ, PY)
values ('¬å', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('¬ç', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('¬é', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¬è', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¬í', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¬ì', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¬î', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('¬ï', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('¬ò', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('¬ô', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('¬õ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('¬ú', 'NING');
insert into HZPYDZB (HZ, PY)
values ('¬û', 'NI');
insert into HZPYDZB (HZ, PY)
values ('¬°', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('¬¢', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('¬£', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('¬§', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('¬•', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('¬¶', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('¬¶', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬ß', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('¬®', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('¬©', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('¬´', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬¨', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬≠', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬Æ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬Ø', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬∞', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬±', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬≤', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬≥', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬¥', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬µ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬∂', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬∑', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬∏', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬π', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬∫', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬ª', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬º', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬Ω', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬æ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¬ø', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬¿', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬¡', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬¬', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬√', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬ƒ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬≈', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬∆', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬«', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬»', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬…', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬ ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬ ', 'SHUAI');
insert into HZPYDZB (HZ, PY)
values ('¬À', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬Ã', 'LV');
insert into HZPYDZB (HZ, PY)
values ('¬Õ', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('¬Œ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('¬Œ', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('¬œ', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('¬–', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('¬—', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('¬“', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('¬”', 'LUE');
insert into HZPYDZB (HZ, PY)
values ('¬‘', 'LUE');
insert into HZPYDZB (HZ, PY)
values ('¬’', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('¬÷', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('¬◊', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('¬ÿ', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('¬Ÿ', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('¬⁄', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('¬€', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('¬‹', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('¬›', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('¬ﬁ', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('¬ﬂ', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('¬‡', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('¬·', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('¬‚', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('¬„', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('¬‰', 'LA');
insert into HZPYDZB (HZ, PY)
values ('¬‰', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('¬Â', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('¬Ê', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('¬Á', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('¬Ë', 'MA');
insert into HZPYDZB (HZ, PY)
values ('¬È', 'MA');
insert into HZPYDZB (HZ, PY)
values ('¬Í', 'MA');
insert into HZPYDZB (HZ, PY)
values ('¬Î', 'MA');
insert into HZPYDZB (HZ, PY)
values ('¬Ï', 'MA');
insert into HZPYDZB (HZ, PY)
values ('¬Ì', 'MA');
insert into HZPYDZB (HZ, PY)
values ('¬Ó', 'MA');
insert into HZPYDZB (HZ, PY)
values ('¬Ô', 'MA');
insert into HZPYDZB (HZ, PY)
values ('¬', 'MA');
insert into HZPYDZB (HZ, PY)
values ('¬Ò', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('¬Ú', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('¬Û', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('¬Ù', 'MAI');
commit;
prompt 10700 records committed...
insert into HZPYDZB (HZ, PY)
values ('¬ı', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('¬ˆ', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('¬˜', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('¬¯', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('¬˘', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('¬˙', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('¬˚', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('¬¸', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('¬˝', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('¬˛', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('√@', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('√A', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('√B', 'SI');
insert into HZPYDZB (HZ, PY)
values ('√C', 'SU');
insert into HZPYDZB (HZ, PY)
values ('√D', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('√F', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('√G', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('√I', 'GE');
insert into HZPYDZB (HZ, PY)
values ('√J', 'BO');
insert into HZPYDZB (HZ, PY)
values ('√J', 'DI');
insert into HZPYDZB (HZ, PY)
values ('√K', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('√L', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('√N', 'RU');
insert into HZPYDZB (HZ, PY)
values ('√O', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('√P', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('√Q', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('√Q', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('√S', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('√T', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('√T', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('√V', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('√W', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('√Y', 'BI');
insert into HZPYDZB (HZ, PY)
values ('√Z', 'BI');
insert into HZPYDZB (HZ, PY)
values ('√\', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('√]', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('√^', 'BI');
insert into HZPYDZB (HZ, PY)
values ('√^', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('√`', 'BO');
insert into HZPYDZB (HZ, PY)
values ('√a', 'QU');
insert into HZPYDZB (HZ, PY)
values ('√b', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('√c', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('√d', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('√e', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('√e', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('√f', 'NI');
insert into HZPYDZB (HZ, PY)
values ('√h', 'CI');
insert into HZPYDZB (HZ, PY)
values ('√h', 'JI');
insert into HZPYDZB (HZ, PY)
values ('√i', 'FU');
insert into HZPYDZB (HZ, PY)
values ('√k', 'MU');
insert into HZPYDZB (HZ, PY)
values ('√l', 'QU');
insert into HZPYDZB (HZ, PY)
values ('√m', 'KE');
insert into HZPYDZB (HZ, PY)
values ('√n', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('√q', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('√q', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('√s', 'ER');
insert into HZPYDZB (HZ, PY)
values ('√t', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('√v', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('√v', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('√w', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('√w', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('√x', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('√y', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('√z', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√}', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('√Ä', 'NIN');
insert into HZPYDZB (HZ, PY)
values ('√Å', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('√Ñ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('√Ñ', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('√Ü', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('√á', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('√á', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('√â', 'TING');
insert into HZPYDZB (HZ, PY)
values ('√ã', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('√é', 'TE');
insert into HZPYDZB (HZ, PY)
values ('√è', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('√ê', 'CU');
insert into HZPYDZB (HZ, PY)
values ('√ê', 'JI');
insert into HZPYDZB (HZ, PY)
values ('√í', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('√ì', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('√î', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('√ï', 'NEI');
insert into HZPYDZB (HZ, PY)
values ('√ï', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('√ñ', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('√ó', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('√ô', 'GU');
insert into HZPYDZB (HZ, PY)
values ('√ö', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('√ö', 'LI');
insert into HZPYDZB (HZ, PY)
values ('√õ', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('√ú', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('√ù', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('√û', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('√ü', 'SHUI');
insert into HZPYDZB (HZ, PY)
values ('√†', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('√°', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('√¢', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('√£', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('√§', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('√•', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('√¶', 'MANG');
commit;
prompt 10800 records committed...
insert into HZPYDZB (HZ, PY)
values ('√ß', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('√®', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('√©', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('√™', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('√´', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('√¨', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('√≠', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('√Æ', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('√Ø', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('√∞', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('√±', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('√≤', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('√≥', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('√¥', 'MO');
insert into HZPYDZB (HZ, PY)
values ('√µ', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√∂', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√∑', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√∏', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√∫', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√ª', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√ª', 'MO');
insert into HZPYDZB (HZ, PY)
values ('√º', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√Ω', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√æ', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√ø', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√¿', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√¡', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√¬', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√√', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√ƒ', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('√≈', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('√∆', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('√«', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('√»', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('√…', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('√ ', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('√À', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('√Õ', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('√Œ', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('√œ', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('√–', 'MI');
insert into HZPYDZB (HZ, PY)
values ('√—', 'MI');
insert into HZPYDZB (HZ, PY)
values ('√“', 'MI');
insert into HZPYDZB (HZ, PY)
values ('√”', 'MI');
insert into HZPYDZB (HZ, PY)
values ('√‘', 'MI');
insert into HZPYDZB (HZ, PY)
values ('√’', 'MI');
insert into HZPYDZB (HZ, PY)
values ('√÷', 'MI');
insert into HZPYDZB (HZ, PY)
values ('√◊', 'MI');
insert into HZPYDZB (HZ, PY)
values ('√ÿ', 'MI');
insert into HZPYDZB (HZ, PY)
values ('√Ÿ', 'MI');
insert into HZPYDZB (HZ, PY)
values ('√⁄', 'MI');
insert into HZPYDZB (HZ, PY)
values ('√€', 'MI');
insert into HZPYDZB (HZ, PY)
values ('√‹', 'MI');
insert into HZPYDZB (HZ, PY)
values ('√›', 'MI');
insert into HZPYDZB (HZ, PY)
values ('√ﬁ', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('√ﬂ', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('√‡', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('√·', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('√‚', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('√„', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('√‰', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('√‰', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('√Â', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('√Ê', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('√Á', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('√Ë', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('√È', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('√Í', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('√Î', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('√Ï', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('√Ì', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('√Ó', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('√Ò', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('√Ú', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('√Û', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('√Ù', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('√ı', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('√ˆ', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('√˜', 'MING');
insert into HZPYDZB (HZ, PY)
values ('√˘', 'MING');
insert into HZPYDZB (HZ, PY)
values ('√˙', 'MING');
insert into HZPYDZB (HZ, PY)
values ('√˚', 'MING');
insert into HZPYDZB (HZ, PY)
values ('√¸', 'MING');
insert into HZPYDZB (HZ, PY)
values ('√˝', 'MIU');
insert into HZPYDZB (HZ, PY)
values ('√˛', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒ@', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('ƒB', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('ƒC', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ƒC', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ƒD', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('ƒF', 'NEI');
insert into HZPYDZB (HZ, PY)
values ('ƒG', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('ƒH', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('ƒJ', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('ƒK', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ƒM', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ƒN', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('ƒN', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ƒR', 'TU');
insert into HZPYDZB (HZ, PY)
values ('ƒS', 'CHI');
commit;
prompt 10900 records committed...
insert into HZPYDZB (HZ, PY)
values ('ƒU', 'OU');
insert into HZPYDZB (HZ, PY)
values ('ƒV', 'DI');
insert into HZPYDZB (HZ, PY)
values ('ƒW', 'AN');
insert into HZPYDZB (HZ, PY)
values ('ƒX', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ƒY', 'SHUAN');
insert into HZPYDZB (HZ, PY)
values ('ƒ[', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('ƒ]', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('ƒ]', 'TU');
insert into HZPYDZB (HZ, PY)
values ('ƒ^', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ƒ_', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ƒ`', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ƒa', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('ƒb', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ƒc', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('ƒe', 'WA');
insert into HZPYDZB (HZ, PY)
values ('ƒf', 'SHOU');
insert into HZPYDZB (HZ, PY)
values ('ƒg', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ƒh', 'SU');
insert into HZPYDZB (HZ, PY)
values ('ƒl', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ƒo', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ƒp', 'OU');
insert into HZPYDZB (HZ, PY)
values ('ƒr', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ƒr', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ƒs', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('ƒs', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ƒv', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ƒw', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ƒw', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ƒx', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('ƒx', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('ƒy', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ƒz', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('ƒz', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ƒ|', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('ƒÄ', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('ƒÄ', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('ƒÅ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ƒÑ', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('ƒÑ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ƒÜ', 'TENG');
insert into HZPYDZB (HZ, PY)
values ('ƒÜ', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('ƒá', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ƒâ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ƒä', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ƒä', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('ƒé', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ƒí', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('ƒì', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('ƒî', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ƒî', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ƒó', 'GE');
insert into HZPYDZB (HZ, PY)
values ('ƒò', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ƒõ', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('ƒú', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('ƒû', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ƒü', 'WO');
insert into HZPYDZB (HZ, PY)
values ('ƒ°', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒ¢', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒ£', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒ£', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒ§', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒ•', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒ¶', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒß', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒ®', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒ©', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒ™', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒ´', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒ≠', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒÆ', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒØ', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒ∞', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ƒ±', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('ƒ≤', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('ƒ≥', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('ƒ¥', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒµ', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒ∂', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒ∑', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒ∏', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒπ', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒª', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒº', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒΩ', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒæ', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒø', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒ¿', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒ¡', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒ¬', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ƒ√', 'NA');
insert into HZPYDZB (HZ, PY)
values ('ƒƒ', 'NE');
insert into HZPYDZB (HZ, PY)
values ('ƒ≈', 'NA');
insert into HZPYDZB (HZ, PY)
values ('ƒ∆', 'NA');
insert into HZPYDZB (HZ, PY)
values ('ƒ«', 'NA');
insert into HZPYDZB (HZ, PY)
values ('ƒ»', 'NA');
insert into HZPYDZB (HZ, PY)
values ('ƒ…', 'NA');
insert into HZPYDZB (HZ, PY)
values ('ƒ ', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('ƒÀ', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('ƒÃ', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('ƒÕ', 'NAI');
commit;
prompt 11000 records committed...
insert into HZPYDZB (HZ, PY)
values ('ƒŒ', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('ƒœ', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('ƒ–', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('ƒ—', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('ƒ“', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('ƒ”', 'RAO');
insert into HZPYDZB (HZ, PY)
values ('ƒ‘', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ƒ’', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ƒ÷', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ƒ◊', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ƒÿ', 'NE');
insert into HZPYDZB (HZ, PY)
values ('ƒÿ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ƒŸ', 'NEI');
insert into HZPYDZB (HZ, PY)
values ('ƒ⁄', 'NEI');
insert into HZPYDZB (HZ, PY)
values ('ƒ€', 'NEN');
insert into HZPYDZB (HZ, PY)
values ('ƒ‹', 'NENG');
insert into HZPYDZB (HZ, PY)
values ('ƒ›', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ƒﬁ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ƒﬂ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ƒ‡', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ƒ·', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ƒ‚', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ƒ„', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ƒ‰', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ƒÊ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ƒÁ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ƒË', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('ƒÈ', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('ƒÍ', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('ƒÎ', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('ƒÏ', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('ƒÌ', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('ƒÓ', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('ƒÔ', 'NIANG');
insert into HZPYDZB (HZ, PY)
values ('ƒ', 'NIANG');
insert into HZPYDZB (HZ, PY)
values ('ƒÒ', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('ƒÚ', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('ƒÚ', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ƒÛ', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ƒÙ', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ƒı', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ƒ¯', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ƒ˘', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ƒ˙', 'NIN');
insert into HZPYDZB (HZ, PY)
values ('ƒ˚', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ƒ˚', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('ƒ¸', 'NING');
insert into HZPYDZB (HZ, PY)
values ('ƒ˝', 'NING');
insert into HZPYDZB (HZ, PY)
values ('ƒ˛', 'NING');
insert into HZPYDZB (HZ, PY)
values ('≈A', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('≈C', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('≈D', 'LA');
insert into HZPYDZB (HZ, PY)
values ('≈D', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('≈F', 'LU');
insert into HZPYDZB (HZ, PY)
values ('≈L', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('≈M', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('≈M', 'NI');
insert into HZPYDZB (HZ, PY)
values ('≈O', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('≈P', 'WO');
insert into HZPYDZB (HZ, PY)
values ('≈Q', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('≈Q', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('≈R', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('≈S', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('≈S', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('≈T', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('≈U', 'JI');
insert into HZPYDZB (HZ, PY)
values ('≈W', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('≈X', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('≈X', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('≈Y', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('≈Z', 'GE');
insert into HZPYDZB (HZ, PY)
values ('≈[', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('≈]', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('≈_', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('≈a', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('≈c', 'YU');
insert into HZPYDZB (HZ, PY)
values ('≈h', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('≈i', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('≈j', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('≈l', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('≈m', 'PU');
insert into HZPYDZB (HZ, PY)
values ('≈n', 'PU');
insert into HZPYDZB (HZ, PY)
values ('≈o', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('≈p', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('≈q', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('≈s', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('≈t', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('≈v', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('≈w', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('≈x', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('≈x', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('≈y', 'LU');
insert into HZPYDZB (HZ, PY)
values ('≈z', 'LING');
insert into HZPYDZB (HZ, PY)
values ('≈|', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('≈}', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('≈~', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('≈Ä', 'FU');
insert into HZPYDZB (HZ, PY)
values ('≈Ç', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('≈É', 'LI');
insert into HZPYDZB (HZ, PY)
values ('≈Ñ', 'YU');
commit;
prompt 11100 records committed...
insert into HZPYDZB (HZ, PY)
values ('≈Ö', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('≈Ü', 'UU');
insert into HZPYDZB (HZ, PY)
values ('≈á', 'BO');
insert into HZPYDZB (HZ, PY)
values ('≈à', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('≈â', 'JU');
insert into HZPYDZB (HZ, PY)
values ('≈ä', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('≈ã', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('≈ã', 'KE');
insert into HZPYDZB (HZ, PY)
values ('≈å', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('≈ç', 'MO');
insert into HZPYDZB (HZ, PY)
values ('≈é', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('≈è', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('≈ê', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('≈ë', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('≈ì', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('≈î', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('≈ï', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('≈ò', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('≈ù', 'JI');
insert into HZPYDZB (HZ, PY)
values ('≈ü', 'WO');
insert into HZPYDZB (HZ, PY)
values ('≈°', 'NING');
insert into HZPYDZB (HZ, PY)
values ('≈¢', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('≈£', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('≈§', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('≈•', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('≈¶', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('≈ß', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('≈®', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('≈©', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('≈™', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('≈´', 'NU');
insert into HZPYDZB (HZ, PY)
values ('≈¨', 'NU');
insert into HZPYDZB (HZ, PY)
values ('≈≠', 'NU');
insert into HZPYDZB (HZ, PY)
values ('≈Æ', 'NV');
insert into HZPYDZB (HZ, PY)
values ('≈Ø', 'NUAN');
insert into HZPYDZB (HZ, PY)
values ('≈∞', 'NVE');
insert into HZPYDZB (HZ, PY)
values ('≈±', 'NVE');
insert into HZPYDZB (HZ, PY)
values ('≈≤', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('≈≥', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('≈¥', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('≈µ', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('≈∂', 'E');
insert into HZPYDZB (HZ, PY)
values ('≈∂', 'O');
insert into HZPYDZB (HZ, PY)
values ('≈∑', 'OU');
insert into HZPYDZB (HZ, PY)
values ('≈∏', 'OU');
insert into HZPYDZB (HZ, PY)
values ('≈π', 'OU');
insert into HZPYDZB (HZ, PY)
values ('≈∫', 'OU');
insert into HZPYDZB (HZ, PY)
values ('≈ª', 'OU');
insert into HZPYDZB (HZ, PY)
values ('≈º', 'OU');
insert into HZPYDZB (HZ, PY)
values ('≈Ω', 'OU');
insert into HZPYDZB (HZ, PY)
values ('≈æ', 'PA');
insert into HZPYDZB (HZ, PY)
values ('≈ø', 'PA');
insert into HZPYDZB (HZ, PY)
values ('≈¿', 'PA');
insert into HZPYDZB (HZ, PY)
values ('≈¡', 'PA');
insert into HZPYDZB (HZ, PY)
values ('≈¬', 'PA');
insert into HZPYDZB (HZ, PY)
values ('≈√', 'PA');
insert into HZPYDZB (HZ, PY)
values ('≈ƒ', 'PAI');
insert into HZPYDZB (HZ, PY)
values ('≈≈', 'PAI');
insert into HZPYDZB (HZ, PY)
values ('≈∆', 'PAI');
insert into HZPYDZB (HZ, PY)
values ('≈«', 'PAI');
insert into HZPYDZB (HZ, PY)
values ('≈»', 'PAI');
insert into HZPYDZB (HZ, PY)
values ('≈…', 'PAI');
insert into HZPYDZB (HZ, PY)
values ('≈ ', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('≈À', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('≈Ã', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('≈Œ', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('≈œ', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('≈–', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('≈—', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('≈“', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('≈”', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('≈‘', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('≈÷', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('≈◊', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('≈ÿ', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('≈Ÿ', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('≈⁄', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('≈€', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('≈‹', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('≈›', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('≈ﬁ', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('≈ﬂ', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('≈‡', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('≈·', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('≈‚', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('≈„', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('≈‰', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('≈Â', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('≈Ê', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('≈Á', 'PEN');
insert into HZPYDZB (HZ, PY)
values ('≈Ë', 'PEN');
insert into HZPYDZB (HZ, PY)
values ('≈È', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('≈Í', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('≈Î', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('≈Ï', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('≈Ì', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('≈Ó', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('≈Ô', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('≈', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('≈Ò', 'PENG');
commit;
prompt 11200 records committed...
insert into HZPYDZB (HZ, PY)
values ('≈Ú', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('≈Û', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('≈Ù', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('≈ı', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('≈ˆ', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('≈˜', 'PI');
insert into HZPYDZB (HZ, PY)
values ('≈˘', 'PI');
insert into HZPYDZB (HZ, PY)
values ('≈˙', 'PI');
insert into HZPYDZB (HZ, PY)
values ('≈˚', 'PI');
insert into HZPYDZB (HZ, PY)
values ('≈¸', 'PI');
insert into HZPYDZB (HZ, PY)
values ('≈˝', 'PI');
insert into HZPYDZB (HZ, PY)
values ('≈˛', 'PI');
insert into HZPYDZB (HZ, PY)
values ('∆@', 'LU');
insert into HZPYDZB (HZ, PY)
values ('∆A', 'LU');
insert into HZPYDZB (HZ, PY)
values ('∆B', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('∆I', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∆I', 'LE');
insert into HZPYDZB (HZ, PY)
values ('∆J', 'DING');
insert into HZPYDZB (HZ, PY)
values ('∆J', 'TING');
insert into HZPYDZB (HZ, PY)
values ('∆K', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('∆L', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('∆M', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('∆N', 'YI');
insert into HZPYDZB (HZ, PY)
values ('∆O', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('∆P', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('∆Q', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('∆R', 'YU');
insert into HZPYDZB (HZ, PY)
values ('∆U', 'HU');
insert into HZPYDZB (HZ, PY)
values ('∆U', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('∆V', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('∆W', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('∆X', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('∆Y', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('∆[', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('∆\', 'REN');
insert into HZPYDZB (HZ, PY)
values ('∆]', 'FOU');
insert into HZPYDZB (HZ, PY)
values ('∆^', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('∆_', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('∆`', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('∆a', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∆b', 'AO');
insert into HZPYDZB (HZ, PY)
values ('∆d', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('∆e', 'RENG');
insert into HZPYDZB (HZ, PY)
values ('∆f', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('∆g', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('∆j', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('∆l', 'TI');
insert into HZPYDZB (HZ, PY)
values ('∆m', 'DI');
insert into HZPYDZB (HZ, PY)
values ('∆n', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∆n', 'LI');
insert into HZPYDZB (HZ, PY)
values ('∆o', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('∆p', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('∆r', 'NING');
insert into HZPYDZB (HZ, PY)
values ('∆r', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('∆s', 'NI');
insert into HZPYDZB (HZ, PY)
values ('∆t', 'BO');
insert into HZPYDZB (HZ, PY)
values ('∆t', 'PA');
insert into HZPYDZB (HZ, PY)
values ('∆u', 'BING');
insert into HZPYDZB (HZ, PY)
values ('∆w', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('∆x', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('∆y', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('∆z', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('∆{', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('∆}', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('∆~', 'HU');
insert into HZPYDZB (HZ, PY)
values ('∆Ä', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('∆Å', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('∆Å', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('∆Ç', 'GU');
insert into HZPYDZB (HZ, PY)
values ('∆Ç', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('∆É', 'BI');
insert into HZPYDZB (HZ, PY)
values ('∆Ñ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('∆á', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('∆à', 'JI');
insert into HZPYDZB (HZ, PY)
values ('∆â', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('∆ä', 'UU');
insert into HZPYDZB (HZ, PY)
values ('∆å', 'GE');
insert into HZPYDZB (HZ, PY)
values ('∆å', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('∆ç', 'LI');
insert into HZPYDZB (HZ, PY)
values ('∆é', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('∆è', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('∆è', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('∆ê', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('∆ë', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('∆í', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('∆í', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('∆ó', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('∆ò', 'CI');
insert into HZPYDZB (HZ, PY)
values ('∆ô', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('∆ö', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('∆õ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('∆õ', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('∆ù', 'CI');
insert into HZPYDZB (HZ, PY)
values ('∆ù', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('∆û', 'FA');
insert into HZPYDZB (HZ, PY)
values ('∆û', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('∆ü', 'MU');
insert into HZPYDZB (HZ, PY)
values ('∆†', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('∆°', 'PI');
insert into HZPYDZB (HZ, PY)
values ('∆¢', 'PI');
commit;
prompt 11300 records committed...
insert into HZPYDZB (HZ, PY)
values ('∆£', 'PI');
insert into HZPYDZB (HZ, PY)
values ('∆§', 'PI');
insert into HZPYDZB (HZ, PY)
values ('∆•', 'PI');
insert into HZPYDZB (HZ, PY)
values ('∆¶', 'PI');
insert into HZPYDZB (HZ, PY)
values ('∆ß', 'PI');
insert into HZPYDZB (HZ, PY)
values ('∆©', 'PI');
insert into HZPYDZB (HZ, PY)
values ('∆™', 'PIAN');
insert into HZPYDZB (HZ, PY)
values ('∆´', 'PIAN');
insert into HZPYDZB (HZ, PY)
values ('∆¨', 'PIAN');
insert into HZPYDZB (HZ, PY)
values ('∆≠', 'PIAN');
insert into HZPYDZB (HZ, PY)
values ('∆Æ', 'PIAO');
insert into HZPYDZB (HZ, PY)
values ('∆Ø', 'PIAO');
insert into HZPYDZB (HZ, PY)
values ('∆∞', 'PIAO');
insert into HZPYDZB (HZ, PY)
values ('∆±', 'PIAO');
insert into HZPYDZB (HZ, PY)
values ('∆≤', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('∆≥', 'BI');
insert into HZPYDZB (HZ, PY)
values ('∆¥', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('∆µ', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('∆∂', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('∆∑', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('∆∏', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('∆π', 'PING');
insert into HZPYDZB (HZ, PY)
values ('∆∫', 'PING');
insert into HZPYDZB (HZ, PY)
values ('∆ª', 'PING');
insert into HZPYDZB (HZ, PY)
values ('∆º', 'PING');
insert into HZPYDZB (HZ, PY)
values ('∆Ω', 'PING');
insert into HZPYDZB (HZ, PY)
values ('∆æ', 'PING');
insert into HZPYDZB (HZ, PY)
values ('∆ø', 'PING');
insert into HZPYDZB (HZ, PY)
values ('∆¿', 'PING');
insert into HZPYDZB (HZ, PY)
values ('∆¡', 'PING');
insert into HZPYDZB (HZ, PY)
values ('∆¬', 'PO');
insert into HZPYDZB (HZ, PY)
values ('∆√', 'PO');
insert into HZPYDZB (HZ, PY)
values ('∆ƒ', 'PO');
insert into HZPYDZB (HZ, PY)
values ('∆≈', 'PO');
insert into HZPYDZB (HZ, PY)
values ('∆∆', 'PO');
insert into HZPYDZB (HZ, PY)
values ('∆«', 'PO');
insert into HZPYDZB (HZ, PY)
values ('∆»', 'PO');
insert into HZPYDZB (HZ, PY)
values ('∆…', 'PO');
insert into HZPYDZB (HZ, PY)
values ('∆ ', 'POU');
insert into HZPYDZB (HZ, PY)
values ('∆À', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆Ã', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆Õ', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆Œ', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆œ', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆–', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆—', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆“', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆”', 'PIAO');
insert into HZPYDZB (HZ, PY)
values ('∆”', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆‘', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆’', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆÷', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆◊', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆ÿ', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆Ÿ', 'PU');
insert into HZPYDZB (HZ, PY)
values ('∆⁄', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆€', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆‹', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆‹', 'XI');
insert into HZPYDZB (HZ, PY)
values ('∆›', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆ﬂ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆‡', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆·', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆‚', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆„', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆‰', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆Â', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆Ê', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆Á', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆Ë', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆È', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆Í', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆Î', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆Ï', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆Ì', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆Ó', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆Ô', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆Ò', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆Ú', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆Û', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆Ù', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆ı', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆ˆ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆˜', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆¯', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆˘', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆˙', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆˚', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆¸', 'QI');
insert into HZPYDZB (HZ, PY)
values ('∆˝', 'QI');
insert into HZPYDZB (HZ, PY)
values ('«@', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«A', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('«B', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('«C', 'FU');
insert into HZPYDZB (HZ, PY)
values ('«D', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('«E', 'DA');
insert into HZPYDZB (HZ, PY)
values ('«E', 'TA');
insert into HZPYDZB (HZ, PY)
values ('«F', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('«G', 'JING');
commit;
prompt 11400 records committed...
insert into HZPYDZB (HZ, PY)
values ('«K', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('«L', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('«M', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('«M', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«N', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('«N', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('«O', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('«P', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('«R', 'CE');
insert into HZPYDZB (HZ, PY)
values ('«S', 'YU');
insert into HZPYDZB (HZ, PY)
values ('«U', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('«V', 'LI');
insert into HZPYDZB (HZ, PY)
values ('«W', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('«Y', 'REN');
insert into HZPYDZB (HZ, PY)
values ('«Z', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('«[', 'BU');
insert into HZPYDZB (HZ, PY)
values ('«[', 'PU');
insert into HZPYDZB (HZ, PY)
values ('«\', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('«_', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('«`', 'WU');
insert into HZPYDZB (HZ, PY)
values ('«a', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('«c', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('«d', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('«e', 'MO');
insert into HZPYDZB (HZ, PY)
values ('«f', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('«g', 'JI');
insert into HZPYDZB (HZ, PY)
values ('«g', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('«h', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('«j', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('«k', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('«l', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('«l', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('«m', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('«n', 'XING');
insert into HZPYDZB (HZ, PY)
values ('«o', 'JING');
insert into HZPYDZB (HZ, PY)
values ('«q', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('«t', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('«u', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('«v', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('«w', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('«x', 'SU');
insert into HZPYDZB (HZ, PY)
values ('«z', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('«{', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('«|', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('«|', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('«}', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('«Ä', 'MU');
insert into HZPYDZB (HZ, PY)
values ('«Å', 'TU');
insert into HZPYDZB (HZ, PY)
values ('«Ç', 'NEUS');
insert into HZPYDZB (HZ, PY)
values ('«Ñ', 'CI');
insert into HZPYDZB (HZ, PY)
values ('«Ö', 'DI');
insert into HZPYDZB (HZ, PY)
values ('«à', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('«â', 'LA');
insert into HZPYDZB (HZ, PY)
values ('«ã', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('«ç', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('«é', 'PU');
insert into HZPYDZB (HZ, PY)
values ('«è', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('«ê', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('«í', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('«ì', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('«ñ', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('«ó', 'LI');
insert into HZPYDZB (HZ, PY)
values ('«ò', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('«ö', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('«ú', 'DI');
insert into HZPYDZB (HZ, PY)
values ('«ù', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('«û', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('«ü', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('«ü', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('«†', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('«°', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('«¢', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('«£', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«§', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«•', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«¶', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«ß', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«®', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«©', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«™', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«´', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«¨', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('«¨', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«≠', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«Æ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«Ø', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«∞', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«±', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«≤', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«≥', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«µ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«∂', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«∑', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«∏', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('«π', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('«∫', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('«ª', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('«º', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('«Ω', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('«æ', 'QIANG');
commit;
prompt 11500 records committed...
insert into HZPYDZB (HZ, PY)
values ('«ø', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('«ø', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('«¿', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('«¡', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('«¬', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('«√', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('«ƒ', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('«≈', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('«∆', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('««', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('«»', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('«…', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('« ', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('«À', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('«Ã', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('«Õ', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('«Œ', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('«œ', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('«–', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('«—', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('«—', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('«“', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('«”', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('«‘', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('«’', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('«÷', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('«◊', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('«ÿ', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('«Ÿ', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('«⁄', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('«€', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('«‹', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('«›', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('«ﬁ', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('«ﬂ', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('«‡', 'QING');
insert into HZPYDZB (HZ, PY)
values ('«·', 'QING');
insert into HZPYDZB (HZ, PY)
values ('«‚', 'QING');
insert into HZPYDZB (HZ, PY)
values ('«„', 'QING');
insert into HZPYDZB (HZ, PY)
values ('«‰', 'QING');
insert into HZPYDZB (HZ, PY)
values ('«Â', 'QING');
insert into HZPYDZB (HZ, PY)
values ('«Ê', 'QING');
insert into HZPYDZB (HZ, PY)
values ('«Á', 'QING');
insert into HZPYDZB (HZ, PY)
values ('«È', 'QING');
insert into HZPYDZB (HZ, PY)
values ('«Í', 'QING');
insert into HZPYDZB (HZ, PY)
values ('«Î', 'QING');
insert into HZPYDZB (HZ, PY)
values ('«Ï', 'QING');
insert into HZPYDZB (HZ, PY)
values ('«Ì', 'QIONG');
insert into HZPYDZB (HZ, PY)
values ('«Ó', 'QIONG');
insert into HZPYDZB (HZ, PY)
values ('«Ô', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('«', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('«Ò', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('«Ú', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('«Û', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('«Ù', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('«ı', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('«ˆ', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('«˜', 'QU');
insert into HZPYDZB (HZ, PY)
values ('«¯', 'OU');
insert into HZPYDZB (HZ, PY)
values ('«¯', 'QU');
insert into HZPYDZB (HZ, PY)
values ('«˘', 'JU');
insert into HZPYDZB (HZ, PY)
values ('«˙', 'QU');
insert into HZPYDZB (HZ, PY)
values ('«˚', 'QU');
insert into HZPYDZB (HZ, PY)
values ('«¸', 'QU');
insert into HZPYDZB (HZ, PY)
values ('«˝', 'QU');
insert into HZPYDZB (HZ, PY)
values ('«˛', 'QU');
insert into HZPYDZB (HZ, PY)
values ('»@', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('»A', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('»B', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('»C', 'AN');
insert into HZPYDZB (HZ, PY)
values ('»D', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('»E', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('»F', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('»G', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('»H', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('»K', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('»M', 'HE');
insert into HZPYDZB (HZ, PY)
values ('»P', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('»Q', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('»R', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('»T', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('»U', 'YI');
insert into HZPYDZB (HZ, PY)
values ('»V', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('»W', 'CI');
insert into HZPYDZB (HZ, PY)
values ('»W', 'JI');
insert into HZPYDZB (HZ, PY)
values ('»X', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('»X', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('»Z', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('»[', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('»_', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('»b', 'DING');
insert into HZPYDZB (HZ, PY)
values ('»c', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('»c', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('»d', 'KE');
insert into HZPYDZB (HZ, PY)
values ('»f', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('»g', 'JU');
insert into HZPYDZB (HZ, PY)
values ('»g', 'YU');
insert into HZPYDZB (HZ, PY)
values ('»h', 'YU');
insert into HZPYDZB (HZ, PY)
values ('»i', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('»i', 'FU');
commit;
prompt 11600 records committed...
insert into HZPYDZB (HZ, PY)
values ('»l', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('»m', 'CE');
insert into HZPYDZB (HZ, PY)
values ('»n', 'WO');
insert into HZPYDZB (HZ, PY)
values ('»o', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('»p', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('»p', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('»q', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('»r', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('»r', 'MU');
insert into HZPYDZB (HZ, PY)
values ('»s', 'AN');
insert into HZPYDZB (HZ, PY)
values ('»u', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('»u', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('»w', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('»x', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('»y', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('»y', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('»{', 'JU');
insert into HZPYDZB (HZ, PY)
values ('»{', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('»|', 'ROU');
insert into HZPYDZB (HZ, PY)
values ('»~', 'YE');
insert into HZPYDZB (HZ, PY)
values ('»Ä', 'AN');
insert into HZPYDZB (HZ, PY)
values ('»Ç', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('»É', 'FU');
insert into HZPYDZB (HZ, PY)
values ('»Ñ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('»Ö', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('»Ü', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('»á', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('»â', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('»ã', 'TU');
insert into HZPYDZB (HZ, PY)
values ('»ç', 'JING');
insert into HZPYDZB (HZ, PY)
values ('»é', 'MI');
insert into HZPYDZB (HZ, PY)
values ('»è', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('»ì', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('»ì', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('»î', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('»ï', 'BO');
insert into HZPYDZB (HZ, PY)
values ('»ñ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('»ó', 'JI');
insert into HZPYDZB (HZ, PY)
values ('»ò', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('»ö', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('»õ', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('»ú', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('»ú', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('»°', 'QU');
insert into HZPYDZB (HZ, PY)
values ('»¢', 'QU');
insert into HZPYDZB (HZ, PY)
values ('»£', 'QU');
insert into HZPYDZB (HZ, PY)
values ('»§', 'QU');
insert into HZPYDZB (HZ, PY)
values ('»•', 'QU');
insert into HZPYDZB (HZ, PY)
values ('»¶', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('»¶', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('»ß', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('»®', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('»©', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('»™', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('»´', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('»¨', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('»≠', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('»Æ', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('»Ø', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('»∞', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('»±', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('»≤', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('»¥', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('»µ', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('»∂', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('»∑', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('»∏', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('»π', 'QUN');
insert into HZPYDZB (HZ, PY)
values ('»∫', 'QUN');
insert into HZPYDZB (HZ, PY)
values ('»ª', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('»º', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('»Ω', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('»æ', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('»¿', 'RANG');
insert into HZPYDZB (HZ, PY)
values ('»¡', 'RANG');
insert into HZPYDZB (HZ, PY)
values ('»¬', 'RANG');
insert into HZPYDZB (HZ, PY)
values ('»√', 'RANG');
insert into HZPYDZB (HZ, PY)
values ('»ƒ', 'RAO');
insert into HZPYDZB (HZ, PY)
values ('»≈', 'RAO');
insert into HZPYDZB (HZ, PY)
values ('»∆', 'RAO');
insert into HZPYDZB (HZ, PY)
values ('»«', 'RE');
insert into HZPYDZB (HZ, PY)
values ('»«', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('»»', 'RE');
insert into HZPYDZB (HZ, PY)
values ('»…', 'REN');
insert into HZPYDZB (HZ, PY)
values ('» ', 'REN');
insert into HZPYDZB (HZ, PY)
values ('»À', 'REN');
insert into HZPYDZB (HZ, PY)
values ('»Ã', 'REN');
insert into HZPYDZB (HZ, PY)
values ('»Õ', 'REN');
insert into HZPYDZB (HZ, PY)
values ('»Œ', 'REN');
insert into HZPYDZB (HZ, PY)
values ('»œ', 'REN');
insert into HZPYDZB (HZ, PY)
values ('»–', 'REN');
insert into HZPYDZB (HZ, PY)
values ('»—', 'REN');
insert into HZPYDZB (HZ, PY)
values ('»“', 'REN');
insert into HZPYDZB (HZ, PY)
values ('»”', 'RENG');
insert into HZPYDZB (HZ, PY)
values ('»‘', 'RENG');
insert into HZPYDZB (HZ, PY)
values ('»’', 'RI');
insert into HZPYDZB (HZ, PY)
values ('»÷', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('»◊', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('»ÿ', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('»Ÿ', 'RONG');
commit;
prompt 11700 records committed...
insert into HZPYDZB (HZ, PY)
values ('»⁄', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('»€', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('»‹', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('»›', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('»ﬁ', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('»ﬂ', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('»‡', 'ROU');
insert into HZPYDZB (HZ, PY)
values ('»·', 'ROU');
insert into HZPYDZB (HZ, PY)
values ('»‚', 'ROU');
insert into HZPYDZB (HZ, PY)
values ('»„', 'RU');
insert into HZPYDZB (HZ, PY)
values ('»‰', 'RU');
insert into HZPYDZB (HZ, PY)
values ('»Â', 'RU');
insert into HZPYDZB (HZ, PY)
values ('»Ê', 'RU');
insert into HZPYDZB (HZ, PY)
values ('»Á', 'RU');
insert into HZPYDZB (HZ, PY)
values ('»Ë', 'RU');
insert into HZPYDZB (HZ, PY)
values ('»È', 'RU');
insert into HZPYDZB (HZ, PY)
values ('»Í', 'RU');
insert into HZPYDZB (HZ, PY)
values ('»Î', 'RU');
insert into HZPYDZB (HZ, PY)
values ('»Ï', 'RU');
insert into HZPYDZB (HZ, PY)
values ('»Ì', 'RUAN');
insert into HZPYDZB (HZ, PY)
values ('»Ó', 'RUAN');
insert into HZPYDZB (HZ, PY)
values ('»Ô', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('»', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('»Ò', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('»Ú', 'RUN');
insert into HZPYDZB (HZ, PY)
values ('»Û', 'RUN');
insert into HZPYDZB (HZ, PY)
values ('»Ù', 'RE');
insert into HZPYDZB (HZ, PY)
values ('»Ù', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('»ı', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('»ˆ', 'SA');
insert into HZPYDZB (HZ, PY)
values ('»˜', 'SA');
insert into HZPYDZB (HZ, PY)
values ('»¯', 'SA');
insert into HZPYDZB (HZ, PY)
values ('»˘', 'SAI');
insert into HZPYDZB (HZ, PY)
values ('»˙', 'SAI');
insert into HZPYDZB (HZ, PY)
values ('»˚', 'SAI');
insert into HZPYDZB (HZ, PY)
values ('»˚', 'SE');
insert into HZPYDZB (HZ, PY)
values ('»¸', 'SAI');
insert into HZPYDZB (HZ, PY)
values ('»˝', 'SAN');
insert into HZPYDZB (HZ, PY)
values ('»˛', 'SAN');
insert into HZPYDZB (HZ, PY)
values ('…A', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('…D', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('…F', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('…I', 'UU');
insert into HZPYDZB (HZ, PY)
values ('…J', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('…L', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('…L', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('…M', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('…O', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('…R', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('…S', 'NA');
insert into HZPYDZB (HZ, PY)
values ('…V', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('…X', 'JU');
insert into HZPYDZB (HZ, PY)
values ('…Z', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('…[', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('…\', 'TU');
insert into HZPYDZB (HZ, PY)
values ('…^', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('…^', 'WO');
insert into HZPYDZB (HZ, PY)
values ('…`', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('…a', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('…e', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('…i', 'NA');
insert into HZPYDZB (HZ, PY)
values ('…o', 'MI');
insert into HZPYDZB (HZ, PY)
values ('…p', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('…q', 'MI');
insert into HZPYDZB (HZ, PY)
values ('…q', 'MING');
insert into HZPYDZB (HZ, PY)
values ('…r', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('…u', 'GU');
insert into HZPYDZB (HZ, PY)
values ('…v', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('…w', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('…w', 'GE');
insert into HZPYDZB (HZ, PY)
values ('…y', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('…z', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('…}', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('…Ä', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('…Ç', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('…É', 'CE');
insert into HZPYDZB (HZ, PY)
values ('…Ö', 'UU');
insert into HZPYDZB (HZ, PY)
values ('…á', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('…à', 'LING');
insert into HZPYDZB (HZ, PY)
values ('…â', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('…ã', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('…å', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('…ç', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('…ç', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('…é', 'AN');
insert into HZPYDZB (HZ, PY)
values ('…è', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('…ê', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('…í', 'FU');
insert into HZPYDZB (HZ, PY)
values ('…í', 'OU');
insert into HZPYDZB (HZ, PY)
values ('…ì', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('…ï', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('…ñ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('…ó', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('…ò', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('…ô', 'YU');
insert into HZPYDZB (HZ, PY)
values ('…õ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('…ú', 'BI');
insert into HZPYDZB (HZ, PY)
values ('…ù', 'LU');
insert into HZPYDZB (HZ, PY)
values ('…û', 'BU');
insert into HZPYDZB (HZ, PY)
values ('…ü', 'ZHANG');
commit;
prompt 11800 records committed...
insert into HZPYDZB (HZ, PY)
values ('…†', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('…°', 'SAN');
insert into HZPYDZB (HZ, PY)
values ('…¢', 'SAN');
insert into HZPYDZB (HZ, PY)
values ('…£', 'SANG');
insert into HZPYDZB (HZ, PY)
values ('…§', 'SANG');
insert into HZPYDZB (HZ, PY)
values ('…•', 'SANG');
insert into HZPYDZB (HZ, PY)
values ('…¶', 'SAO');
insert into HZPYDZB (HZ, PY)
values ('…ß', 'SAO');
insert into HZPYDZB (HZ, PY)
values ('…®', 'SAO');
insert into HZPYDZB (HZ, PY)
values ('…©', 'SAO');
insert into HZPYDZB (HZ, PY)
values ('…™', 'SE');
insert into HZPYDZB (HZ, PY)
values ('…´', 'SE');
insert into HZPYDZB (HZ, PY)
values ('…´', 'SHAI');
insert into HZPYDZB (HZ, PY)
values ('…¨', 'SE');
insert into HZPYDZB (HZ, PY)
values ('…≠', 'SEN');
insert into HZPYDZB (HZ, PY)
values ('…Æ', 'SENG');
insert into HZPYDZB (HZ, PY)
values ('…Ø', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('…∞', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('…±', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('…≤', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('…≥', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('…¥', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('…µ', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('…∂', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('…∑', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('…∏', 'SHAI');
insert into HZPYDZB (HZ, PY)
values ('…π', 'SHAI');
insert into HZPYDZB (HZ, PY)
values ('…∫', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('…ª', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('…º', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('…Ω', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('…æ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('…ø', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('…¿', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('…¡', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('…¬', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('…√', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('…ƒ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('…≈', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('…∆', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('…«', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('…»', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('……', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('… ', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('…À', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('…Ã', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('…Õ', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('…Œ', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('…œ', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('…–', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('…—', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('…“', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('…”', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('…‘', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('…’', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('…÷', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('…◊', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('…ÿ', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('…Ÿ', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('…⁄', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('…€', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('…‹', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('…›', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('…ﬁ', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('…ﬂ', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('…‡', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('…·', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('…‚', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('…„', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('…‰', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('…Â', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('…Ê', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('…Á', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('…Ë', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('…È', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…Í', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…Î', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…Ï', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…Ì', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…Ó', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…Ô', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…Ò', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…Ú', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…Û', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…Ù', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…ı', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…ˆ', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…˜', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…¯', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('…˘', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('…˙', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('…˚', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('…¸', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('…˝', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('…˛', 'SHENG');
insert into HZPYDZB (HZ, PY)
values (' @', 'JIANG');
insert into HZPYDZB (HZ, PY)
values (' A', 'MAN');
insert into HZPYDZB (HZ, PY)
values (' C', 'LING');
insert into HZPYDZB (HZ, PY)
values (' D', 'JI');
commit;
prompt 11900 records committed...
insert into HZPYDZB (HZ, PY)
values (' G', 'HAN');
insert into HZPYDZB (HZ, PY)
values (' H', 'DI');
insert into HZPYDZB (HZ, PY)
values (' I', 'CU');
insert into HZPYDZB (HZ, PY)
values (' I', 'LU');
insert into HZPYDZB (HZ, PY)
values (' M', 'HUN');
insert into HZPYDZB (HZ, PY)
values (' N', 'BO');
insert into HZPYDZB (HZ, PY)
values (' S', 'HU');
insert into HZPYDZB (HZ, PY)
values (' T', 'AO');
insert into HZPYDZB (HZ, PY)
values (' U', 'MI');
insert into HZPYDZB (HZ, PY)
values (' V', 'LOU');
insert into HZPYDZB (HZ, PY)
values (' W', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values (' X', 'BO');
insert into HZPYDZB (HZ, PY)
values (' Y', 'JIANG');
insert into HZPYDZB (HZ, PY)
values (' Z', 'MI');
insert into HZPYDZB (HZ, PY)
values (' [', 'CONG');
insert into HZPYDZB (HZ, PY)
values (' ]', 'HUI');
insert into HZPYDZB (HZ, PY)
values (' ^', 'JUAN');
insert into HZPYDZB (HZ, PY)
values (' ^', 'JUN');
insert into HZPYDZB (HZ, PY)
values (' _', 'YIN');
insert into HZPYDZB (HZ, PY)
values (' d', 'HU');
insert into HZPYDZB (HZ, PY)
values (' f', 'KOU');
insert into HZPYDZB (HZ, PY)
values (' g', 'QIAN');
insert into HZPYDZB (HZ, PY)
values (' h', 'MA');
insert into HZPYDZB (HZ, PY)
values (' i', 'CANG');
insert into HZPYDZB (HZ, PY)
values (' j', 'ZE');
insert into HZPYDZB (HZ, PY)
values (' k', 'LI');
insert into HZPYDZB (HZ, PY)
values (' m', 'JI');
insert into HZPYDZB (HZ, PY)
values (' o', 'SHENG');
insert into HZPYDZB (HZ, PY)
values (' p', 'MENG');
insert into HZPYDZB (HZ, PY)
values (' q', 'OU');
insert into HZPYDZB (HZ, PY)
values (' r', 'CHAN');
insert into HZPYDZB (HZ, PY)
values (' t', 'JUAN');
insert into HZPYDZB (HZ, PY)
values (' u', 'LEI');
insert into HZPYDZB (HZ, PY)
values (' v', 'YU');
insert into HZPYDZB (HZ, PY)
values (' w', 'JIAO');
insert into HZPYDZB (HZ, PY)
values (' x', 'CHU');
insert into HZPYDZB (HZ, PY)
values (' y', 'HUA');
insert into HZPYDZB (HZ, PY)
values (' y', 'KUA');
insert into HZPYDZB (HZ, PY)
values (' {', 'MAI');
insert into HZPYDZB (HZ, PY)
values (' |', 'YUN');
insert into HZPYDZB (HZ, PY)
values (' Ä', 'LU');
insert into HZPYDZB (HZ, PY)
values (' Ñ', 'FEI');
insert into HZPYDZB (HZ, PY)
values (' Ü', 'FA');
insert into HZPYDZB (HZ, PY)
values (' Ü', 'FEI');
insert into HZPYDZB (HZ, PY)
values (' á', 'RU');
insert into HZPYDZB (HZ, PY)
values (' â', 'KUAI');
insert into HZPYDZB (HZ, PY)
values (' â', 'KUI');
insert into HZPYDZB (HZ, PY)
values (' ä', 'SHUN');
insert into HZPYDZB (HZ, PY)
values (' ç', 'FU');
insert into HZPYDZB (HZ, PY)
values (' é', 'DANG');
insert into HZPYDZB (HZ, PY)
values (' ê', 'DONG');
insert into HZPYDZB (HZ, PY)
values (' í', 'XIAO');
insert into HZPYDZB (HZ, PY)
values (' î', 'LONG');
insert into HZPYDZB (HZ, PY)
values (' î', 'SA');
insert into HZPYDZB (HZ, PY)
values (' ï', 'WEN');
insert into HZPYDZB (HZ, PY)
values (' ï', 'YUN');
insert into HZPYDZB (HZ, PY)
values (' ñ', 'SHAO');
insert into HZPYDZB (HZ, PY)
values (' ô', 'LING');
insert into HZPYDZB (HZ, PY)
values (' ú', 'SI');
insert into HZPYDZB (HZ, PY)
values (' ù', 'NONG');
insert into HZPYDZB (HZ, PY)
values (' ü', 'WEN');
insert into HZPYDZB (HZ, PY)
values (' ü', 'YUN');
insert into HZPYDZB (HZ, PY)
values (' °', 'SHENG');
insert into HZPYDZB (HZ, PY)
values (' °', 'XING');
insert into HZPYDZB (HZ, PY)
values (' ¢', 'SHENG');
insert into HZPYDZB (HZ, PY)
values (' £', 'SHENG');
insert into HZPYDZB (HZ, PY)
values (' §', 'SHENG');
insert into HZPYDZB (HZ, PY)
values (' •', 'SHENG');
insert into HZPYDZB (HZ, PY)
values (' ¶', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ß', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ®', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ©', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ™', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ´', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ¨', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' Æ', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' Ø', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ∞', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ±', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ≤', 'SHEN');
insert into HZPYDZB (HZ, PY)
values (' ≤', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ≥', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ¥', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' µ', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ∂', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ∑', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ∏', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' π', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ª', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' º', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' Ω', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' æ', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ø', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ¿', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ¡', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ¬', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' √', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ƒ', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ≈', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' ∆', 'SHI');
commit;
prompt 12000 records committed...
insert into HZPYDZB (HZ, PY)
values (' «', 'SHI');
insert into HZPYDZB (HZ, PY)
values (' »', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Òl', 'QU');
insert into HZPYDZB (HZ, PY)
values ('Òo', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('Òu', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Òv', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Òw', 'NU');
insert into HZPYDZB (HZ, PY)
values ('Òz', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('Ò{', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Ò|', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Ò~', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('Ò~', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('ÒÇ', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ÒÑ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ÒÖ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ÒÜ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Òá', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Òà', 'MA');
insert into HZPYDZB (HZ, PY)
values ('Òä', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Òè', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('Òí', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('Òî', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('Òú', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Ò†', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('Ò£', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('Ò§', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ò¶', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Ò©', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ò´', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('Ò≠', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('ÒÆ', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('Ò∞', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('Ò±', 'PI');
insert into HZPYDZB (HZ, PY)
values ('Ò≤', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('Ò¥', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Òµ', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('Ò∑', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('Ò∑', 'QIONG');
insert into HZPYDZB (HZ, PY)
values ('Ò∏', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('Òπ', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('Ò∫', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('Òª', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('Òº', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('ÒΩ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('Ò¿', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Ò√', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('Òƒ', 'NA');
insert into HZPYDZB (HZ, PY)
values ('Ò≈', 'REN');
insert into HZPYDZB (HZ, PY)
values ('Ò∆', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ò∆', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('Ò«', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('Ò»', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('Ò»', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('Ò…', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('Ò ', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('ÒÀ', 'GE');
insert into HZPYDZB (HZ, PY)
values ('ÒÀ', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ÒÃ', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('ÒÕ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ÒŒ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('Òœ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('Ò–', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ò—', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Ò“', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('Ò”', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Ò‘', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Ò‘', 'PI');
insert into HZPYDZB (HZ, PY)
values ('Ò’', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Ò÷', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('Ò◊', 'DA');
insert into HZPYDZB (HZ, PY)
values ('ÒŸ', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Ò⁄', 'LV');
insert into HZPYDZB (HZ, PY)
values ('Ò€', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('Ò€', 'PIAN');
insert into HZPYDZB (HZ, PY)
values ('Ò‹', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('Òﬁ', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('Òﬁ', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('Òﬂ', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('Ò‡', 'RU');
insert into HZPYDZB (HZ, PY)
values ('Ò‚', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('Ò„', 'XU');
insert into HZPYDZB (HZ, PY)
values ('Ò‰', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('ÒÂ', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('ÒÊ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ÒÁ', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('ÒË', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('ÒÈ', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('ÒÍ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ÒÎ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ÒÏ', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ÒÓ', 'OU');
insert into HZPYDZB (HZ, PY)
values ('Ò', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ÒÒ', 'NOU');
insert into HZPYDZB (HZ, PY)
values ('ÒÚ', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ÒÙ', 'DING');
insert into HZPYDZB (HZ, PY)
values ('Òı', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('Òˆ', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Ò˜', 'NING');
insert into HZPYDZB (HZ, PY)
values ('Ò¯', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('Ò˘', 'KUI');
commit;
prompt 12100 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ò˙', 'AO');
insert into HZPYDZB (HZ, PY)
values ('Ò˚', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('Ò¸', 'AN');
insert into HZPYDZB (HZ, PY)
values ('Ò¸', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Ò˝', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('Ò˝', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Ò˛', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('Ò˛', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('Ú@', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('ÚF', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÚI', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ÚJ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ÚL', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('ÚO', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('ÚP', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('ÚQ', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('ÚS', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ÚT', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ÚW', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Ú^', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('Úa', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Úb', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('Úd', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('Úl', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Ún', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Úq', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Út', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Úu', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('Úv', 'TENG');
insert into HZPYDZB (HZ, PY)
values ('Ú}', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('ÚÅ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ÚÉ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ÚÖ', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('Úá', 'MA');
insert into HZPYDZB (HZ, PY)
values ('Úá', 'MO');
insert into HZPYDZB (HZ, PY)
values ('Úà', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('Úâ', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('Úã', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('Úë', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('Úí', 'BO');
insert into HZPYDZB (HZ, PY)
values ('Úï', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Úò', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Úô', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Úö', 'CENG');
insert into HZPYDZB (HZ, PY)
values ('Ú°', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ú¢', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Ú£', 'YING');
insert into HZPYDZB (HZ, PY)
values ('Ú§', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('Ú§', 'KE');
insert into HZPYDZB (HZ, PY)
values ('Ú•', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Ú¶', 'E');
insert into HZPYDZB (HZ, PY)
values ('Ú®', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('Ú©', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('Ú´', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('Ú¨', 'RU');
insert into HZPYDZB (HZ, PY)
values ('ÚÆ', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ÚØ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('Ú∞', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('Ú±', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ú≤', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('Ú≥', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Ú¥', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Úµ', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('Ú∂', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Ú∏', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('Ú∫', 'CI');
insert into HZPYDZB (HZ, PY)
values ('Ú∫', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('Úª', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Úº', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('Úº', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('ÚΩ', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('Úæ', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('Úø', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Ú¿', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Ú¡', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Ú¬', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Ú¬', 'KE');
insert into HZPYDZB (HZ, PY)
values ('Ú√', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Úƒ', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('Úƒ', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Ú≈', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('Ú≈', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('Ú∆', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('Ú«', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('Ú»', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Ú…', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('Ú ', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('ÚÀ', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('ÚÀ', 'QIONG');
insert into HZPYDZB (HZ, PY)
values ('ÚÃ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ÚÕ', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ÚŒ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Úœ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Ú–', 'QU');
insert into HZPYDZB (HZ, PY)
values ('Ú—', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Ú“', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('Ú”', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Ú‘', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ú’', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('Ú÷', 'MAO');
commit;
prompt 12200 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ú÷', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('Úÿ', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ÚŸ', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('Ú⁄', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Ú€', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ú‹', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('Ú›', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Úﬁ', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('Úﬂ', 'QING');
insert into HZPYDZB (HZ, PY)
values ('Ú‡', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Ú·', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Ú„', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ÚÂ', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('ÚÊ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÚÁ', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('ÚÁ', 'PI');
insert into HZPYDZB (HZ, PY)
values ('ÚË', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('ÚÈ', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ÚÈ', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('ÚÍ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÚÎ', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('ÚÏ', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ÚÌ', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('ÚÓ', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('Ú', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ÚÒ', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ÚÚ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ÚÛ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ÚÙ', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('Ú˜', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('Ú¯', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('Ú˘', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('Ú˘', 'PIAN');
insert into HZPYDZB (HZ, PY)
values ('Ú˙', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('Ú˚', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('Ú¸', 'AO');
insert into HZPYDZB (HZ, PY)
values ('Ú˝', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('Ú˛', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('Ú˛', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('Û@', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ÛA', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÛG', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('ÛH', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ÛI', 'TENG');
insert into HZPYDZB (HZ, PY)
values ('ÛK', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÛM', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ÛO', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ÛP', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ÛQ', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ÛR', 'RI');
insert into HZPYDZB (HZ, PY)
values ('ÛW', 'ZONG');
insert into HZPYDZB (HZ, PY)
values ('ÛY', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ÛY', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Û[', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Û[', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Û\', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Û\', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Û]', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Û]', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Û_', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('Ûa', 'ANG');
insert into HZPYDZB (HZ, PY)
values ('Ûa', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('Ûb', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Ûf', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Ûf', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('Ûh', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('Ûi', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('Ûl', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('Ûm', 'BO');
insert into HZPYDZB (HZ, PY)
values ('Ûo', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('Ûp', 'BO');
insert into HZPYDZB (HZ, PY)
values ('Ûp', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ûq', 'CI');
insert into HZPYDZB (HZ, PY)
values ('Ûq', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('Ûr', 'MO');
insert into HZPYDZB (HZ, PY)
values ('Ûs', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('Ût', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('Ûw', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Ûx', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('Ûy', 'KUAN');
insert into HZPYDZB (HZ, PY)
values ('Ûz', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Û{', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('ÛÄ', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ÛÇ', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('Ûá', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('Ûà', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('Ûå', 'FA');
insert into HZPYDZB (HZ, PY)
values ('Ûé', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Ûê', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('Ûê', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('Ûë', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Ûë', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Ûì', 'ER');
insert into HZPYDZB (HZ, PY)
values ('Ûï', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('Ûñ', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('Ûú', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ûù', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('Ûû', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Û°', 'MA');
insert into HZPYDZB (HZ, PY)
values ('Û°', 'MO');
commit;
prompt 12300 records committed...
insert into HZPYDZB (HZ, PY)
values ('Û¢', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('Û£', 'CI');
insert into HZPYDZB (HZ, PY)
values ('Û£', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Û§', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Û•', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Û¶', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('Û¶', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('Û®', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('Û©', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('Û´', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Û¨', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Û∞', 'SHUAI');
insert into HZPYDZB (HZ, PY)
values ('Û±', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('Û≤', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('Û¥', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('Û¥', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('Ûπ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('Û∫', 'MIE');
insert into HZPYDZB (HZ, PY)
values ('Ûº', 'DU');
insert into HZPYDZB (HZ, PY)
values ('ÛΩ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ûæ', 'FOU');
insert into HZPYDZB (HZ, PY)
values ('Ûø', 'YING');
insert into HZPYDZB (HZ, PY)
values ('Û¿', 'QING');
insert into HZPYDZB (HZ, PY)
values ('Û¬', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Û√', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Ûƒ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Û≈', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Û∆', 'DU');
insert into HZPYDZB (HZ, PY)
values ('Û«', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Û»', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Û…', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('Û ', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('ÛÀ', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ÛÃ', 'QIONG');
insert into HZPYDZB (HZ, PY)
values ('ÛÕ', 'PO');
insert into HZPYDZB (HZ, PY)
values ('Ûœ', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('Û–', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('Û—', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('Û“', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Û”', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Û‘', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('Û‘', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('Û’', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Û÷', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('Û◊', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Ûÿ', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('ÛŸ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Û€', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('Û‹', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('Û›', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('Ûﬁ', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('Ûﬁ', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('Ûﬂ', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Û‡', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('Û‚', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('Û„', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('Û‰', 'QING');
insert into HZPYDZB (HZ, PY)
values ('ÛÁ', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('ÛË', 'NA');
insert into HZPYDZB (HZ, PY)
values ('ÛË', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('ÛÍ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ÛÎ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ÛÏ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ÛÌ', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('ÛÓ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÛÓ', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('ÛÔ', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('Û', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Û', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ÛÚ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ÛÛ', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('ÛÙ', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('Ûˆ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Û˜', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Û¯', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Û˘', 'SU');
insert into HZPYDZB (HZ, PY)
values ('Û˙', 'MIE');
insert into HZPYDZB (HZ, PY)
values ('Û˚', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('Û¸', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Û˛', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ÙD', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('ÙF', 'LA');
insert into HZPYDZB (HZ, PY)
values ('ÙK', 'MA');
insert into HZPYDZB (HZ, PY)
values ('ÙM', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('ÙQ', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('ÙT', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('ÙV', 'NING');
insert into HZPYDZB (HZ, PY)
values ('ÙX', 'NING');
insert into HZPYDZB (HZ, PY)
values ('Ù[', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('Ù\', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('Ù]', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Ù_', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Ùj', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Ùm', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('Ùn', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ùp', 'GA');
insert into HZPYDZB (HZ, PY)
values ('Ùr', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('Ùs', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('Ùu', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('Ùv', 'GAN');
commit;
prompt 12400 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ù{', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('Ù~', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ÙÄ', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('ÙÇ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÙÖ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ÙÜ', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('Ùá', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ùâ', 'E');
insert into HZPYDZB (HZ, PY)
values ('Ùâ', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('Ùä', 'E');
insert into HZPYDZB (HZ, PY)
values ('Ùä', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ùå', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('Ùç', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('Ùí', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Ùì', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Ùî', 'LV');
insert into HZPYDZB (HZ, PY)
values ('Ùï', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Ùö', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('Ùõ', 'NA');
insert into HZPYDZB (HZ, PY)
values ('Ùû', 'MO');
insert into HZPYDZB (HZ, PY)
values ('Ùü', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Ùü', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Ù°', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('Ù¢', 'ZAN');
insert into HZPYDZB (HZ, PY)
values ('Ù§', 'BO');
insert into HZPYDZB (HZ, PY)
values ('Ù•', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('Ùß', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Ù®', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Ù©', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('Ù´', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('Ù¨', 'NV');
insert into HZPYDZB (HZ, PY)
values ('Ù≠', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('ÙÆ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ÙØ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Ù∞', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Ù±', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('Ù≤', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('Ù≥', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('Ù¥', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Ùµ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Ù∂', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('Ù∂', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Ù∑', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('Ùπ', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('Ù∫', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Ùª', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('Ùº', 'SHOU');
insert into HZPYDZB (HZ, PY)
values ('ÙΩ', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('Ùæ', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('Ùæ', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Ùø', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('Ù¿', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('Ù¡', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('Ù¬', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Ù√', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('Ùƒ', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('Ù≈', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Ù∆', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Ù«', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('Ù«', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('Ù»', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('Ù…', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ù ', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ÙÀ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ÙŒ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('Ùœ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ù–', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('Ù—', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Ù“', 'CI');
insert into HZPYDZB (HZ, PY)
values ('Ù”', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('Ù‘', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Ù’', 'ZONG');
insert into HZPYDZB (HZ, PY)
values ('Ù÷', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('Ù◊', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('ÙŸ', 'CI');
insert into HZPYDZB (HZ, PY)
values ('Ù⁄', 'XU');
insert into HZPYDZB (HZ, PY)
values ('Ù€', 'ROU');
insert into HZPYDZB (HZ, PY)
values ('Ù‹', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('Ù›', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ùﬁ', 'GEN');
insert into HZPYDZB (HZ, PY)
values ('Ùﬁ', 'HEN');
insert into HZPYDZB (HZ, PY)
values ('Ùﬂ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ùﬂ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ù‡', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Ù·', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Ù‚', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Ù‰', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ÙÂ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ÙÊ', 'PIAN');
insert into HZPYDZB (HZ, PY)
values ('ÙÁ', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ÙÁ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ÙË', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÙÈ', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ÙÍ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÙÏ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ÙÓ', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('ÙÓ', 'DU');
insert into HZPYDZB (HZ, PY)
values ('ÙÔ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ÙÒ', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ÙÚ', 'JU');
commit;
prompt 12500 records committed...
insert into HZPYDZB (HZ, PY)
values ('ÙÛ', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('ÙÙ', 'CI');
insert into HZPYDZB (HZ, PY)
values ('ÙÙ', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('Ùı', 'ZAN');
insert into HZPYDZB (HZ, PY)
values ('Ùˆ', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('Ù˜', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('Ù¯', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ù˘', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Ù˙', 'DING');
insert into HZPYDZB (HZ, PY)
values ('Ù˚', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('Ù˚', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('Ù˛', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ıA', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ıD', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ıE', 'BA');
insert into HZPYDZB (HZ, PY)
values ('ıE', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ıH', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ıJ', 'CI');
insert into HZPYDZB (HZ, PY)
values ('ıJ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ıK', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ıP', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('ıQ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ıR', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('ıU', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('ıY', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ı]', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ı^', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ı`', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('ıf', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('ıh', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('ım', 'BING');
insert into HZPYDZB (HZ, PY)
values ('ıo', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ıp', 'KU');
insert into HZPYDZB (HZ, PY)
values ('ıq', 'WA');
insert into HZPYDZB (HZ, PY)
values ('ır', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('ıv', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ıÉ', 'NEI');
insert into HZPYDZB (HZ, PY)
values ('ıÖ', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('ıÜ', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('ıé', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ıè', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('ıê', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('ıí', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ıù', 'NEI');
insert into HZPYDZB (HZ, PY)
values ('ıü', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ı°', 'CU');
insert into HZPYDZB (HZ, PY)
values ('ı¢', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('ı¢', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ı£', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('ı•', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ıß', 'SHAI');
insert into HZPYDZB (HZ, PY)
values ('ı®', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ı©', 'TU');
insert into HZPYDZB (HZ, PY)
values ('ı™', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('ı´', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('ı¨', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('ı≠', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ıÆ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ıØ', 'XU');
insert into HZPYDZB (HZ, PY)
values ('ı∞', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('ı±', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ı≤', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ı≥', 'BU');
insert into HZPYDZB (HZ, PY)
values ('ı∂', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ı∑', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ı∏', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('ıπ', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ıª', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('ıΩ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ıø', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('ı¿', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('ı¡', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ı¡', 'TA');
insert into HZPYDZB (HZ, PY)
values ('ı¬', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ı√', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ıƒ', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('ı≈', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ı∆', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ı«', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ı»', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ı»', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('ı…', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ı ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ıÀ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ıÀ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ıÃ', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('ıÕ', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ıÕ', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('ıŒ', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('ıœ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ı–', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('ı–', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('ı—', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('ı”', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ı”', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('ı‘', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('ı‘', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('ı’', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ı÷', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('ı◊', 'HUAI');
commit;
prompt 12600 records committed...
insert into HZPYDZB (HZ, PY)
values ('ıÿ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ıŸ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ı⁄', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('ı€', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ı€', 'POU');
insert into HZPYDZB (HZ, PY)
values ('ı‹', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ı›', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ıﬁ', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ıﬂ', 'CHUAI');
insert into HZPYDZB (HZ, PY)
values ('ı‡', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('ı·', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ı‚', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('ı‚', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ı„', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('ıÂ', 'ROU');
insert into HZPYDZB (HZ, PY)
values ('ıÊ', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ıÁ', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('ıË', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ıÈ', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('ıÍ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ıÍ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ıÏ', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ıÌ', 'CU');
insert into HZPYDZB (HZ, PY)
values ('ıÔ', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ı', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ıÒ', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('ıÚ', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('ıı', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('ıˆ', 'MA');
insert into HZPYDZB (HZ, PY)
values ('ıˆ', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ı˙', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ı˚', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ı¸', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('ı˝', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ı˛', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('ı˛', 'ZUI');
insert into HZPYDZB (HZ, PY)
values ('ˆD', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('ˆE', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ˆF', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ˆH', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('ˆI', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ˆJ', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ˆL', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ˆM', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('ˆP', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ˆT', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('ˆU', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ˆY', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ˆ^', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('ˆ_', 'LA');
insert into HZPYDZB (HZ, PY)
values ('ˆa', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ˆb', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ˆc', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ˆl', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ˆm', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ˆn', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ˆs', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ˆt', 'E');
insert into HZPYDZB (HZ, PY)
values ('ˆv', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ˆx', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ˆÄ', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('ˆÑ', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('ˆÜ', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('ˆç', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ˆè', 'E');
insert into HZPYDZB (HZ, PY)
values ('ˆñ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ˆó', 'AO');
insert into HZPYDZB (HZ, PY)
values ('ˆô', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ˆõ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ˆü', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('ˆ†', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('ˆ°', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('ˆ¢', 'SU');
insert into HZPYDZB (HZ, PY)
values ('ˆ£', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ˆ•', 'QING');
insert into HZPYDZB (HZ, PY)
values ('ˆ¶', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('ˆ®', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ˆ©', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('ˆ™', 'TING');
insert into HZPYDZB (HZ, PY)
values ('ˆ´', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ˆ¨', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('ˆ≠', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ˆÆ', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('ˆ∞', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ˆ±', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('ˆ≤', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ˆ≥', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ˆ¥', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('ˆµ', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('ˆ∂', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('ˆ∑', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('ˆ∏', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('ˆ∫', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('ˆª', 'WO');
insert into HZPYDZB (HZ, PY)
values ('ˆº', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('ˆø', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('ˆ¿', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('ˆ¡', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ˆ¡', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('ˆ¬', 'JU');
commit;
prompt 12700 records committed...
insert into HZPYDZB (HZ, PY)
values ('ˆƒ', 'QU');
insert into HZPYDZB (HZ, PY)
values ('ˆ∆', 'QIONG');
insert into HZPYDZB (HZ, PY)
values ('ˆ«', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('ˆ»', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ˆ ', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('ˆÃ', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('ˆŒ', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('ˆœ', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('ˆ–', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('ˆ—', 'BA');
insert into HZPYDZB (HZ, PY)
values ('ˆ—', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ˆ“', 'PING');
insert into HZPYDZB (HZ, PY)
values ('ˆ”', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('ˆ‘', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ˆ’', 'SU');
insert into HZPYDZB (HZ, PY)
values ('ˆ÷', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('ˆ÷', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ˆ◊', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('ˆÿ', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('ˆŸ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ˆŸ', 'WA');
insert into HZPYDZB (HZ, PY)
values ('ˆ⁄', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ˆ⁄', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('ˆ€', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ˆ‹', 'ER');
insert into HZPYDZB (HZ, PY)
values ('ˆ›', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ˆﬁ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ˆ‡', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('ˆ·', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('ˆ‚', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ˆ‰', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ˆÊ', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('ˆÁ', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('ˆË', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('ˆÈ', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ˆÍ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ˆÎ', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('ˆÏ', 'LING');
insert into HZPYDZB (HZ, PY)
values ('ˆÓ', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ˆÔ', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('ˆ', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('ˆÚ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ˆÛ', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('ˆ˜', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('ˆ¯', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ˆ˙', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('ˆ˚', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ˆ¸', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ˆ˝', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('˜B', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('˜C', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˜D', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˜H', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('˜L', 'XUE');
insert into HZPYDZB (HZ, PY)
values ('˜M', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('˜R', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('˜U', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('˜Y', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('˜[', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('˜]', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('˜a', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('˜b', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('˜c', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('˜d', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('˜m', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('˜q', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˜u', 'LI');
insert into HZPYDZB (HZ, PY)
values ('˜v', 'LA');
insert into HZPYDZB (HZ, PY)
values ('˜v', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('˜w', 'LU');
insert into HZPYDZB (HZ, PY)
values ('˜w', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('˜{', 'E');
insert into HZPYDZB (HZ, PY)
values ('˜|', 'LU');
insert into HZPYDZB (HZ, PY)
values ('˜}', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('˜~', 'LI');
insert into HZPYDZB (HZ, PY)
values ('˜Å', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('˜Ç', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˜É', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('˜Ñ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('˜Ö', 'GE');
insert into HZPYDZB (HZ, PY)
values ('˜Ö', 'HE');
insert into HZPYDZB (HZ, PY)
values ('˜á', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('˜à', 'BA');
insert into HZPYDZB (HZ, PY)
values ('˜à', 'BO');
insert into HZPYDZB (HZ, PY)
values ('˜â', 'JU');
insert into HZPYDZB (HZ, PY)
values ('˜ä', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('˜ç', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('˜é', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('˜ê', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('˜ì', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('˜î', 'BI');
insert into HZPYDZB (HZ, PY)
values ('˜ï', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('˜ó', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('˜ö', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('˜õ', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('˜ú', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('˜†', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('˜£', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('˜§', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('˜ß', 'BIAO');
commit;
prompt 12800 records committed...
insert into HZPYDZB (HZ, PY)
values ('˜™', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('˜≠', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('˜Ø', 'LI');
insert into HZPYDZB (HZ, PY)
values ('˜∞', 'DA');
insert into HZPYDZB (HZ, PY)
values ('˜±', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('˜≤', 'DA');
insert into HZPYDZB (HZ, PY)
values ('˜≤', 'TA');
insert into HZPYDZB (HZ, PY)
values ('˜≥', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('˜¥', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('˜¥', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('˜µ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('˜∂', 'JU');
insert into HZPYDZB (HZ, PY)
values ('˜π', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('˜π', 'FU');
insert into HZPYDZB (HZ, PY)
values ('˜∫', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('˜∫', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('˜ª', 'GU');
insert into HZPYDZB (HZ, PY)
values ('˜º', 'KU');
insert into HZPYDZB (HZ, PY)
values ('˜Ω', 'GU');
insert into HZPYDZB (HZ, PY)
values ('˜Ω', 'HU');
insert into HZPYDZB (HZ, PY)
values ('˜æ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('˜ø', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('˜¿', 'GE');
insert into HZPYDZB (HZ, PY)
values ('˜¡', 'KE');
insert into HZPYDZB (HZ, PY)
values ('˜¡', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('˜¬', 'BI');
insert into HZPYDZB (HZ, PY)
values ('˜√', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('˜ƒ', 'GE');
insert into HZPYDZB (HZ, PY)
values ('˜≈', 'KUAN');
insert into HZPYDZB (HZ, PY)
values ('˜∆', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('˜»', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('˜…', 'BA');
insert into HZPYDZB (HZ, PY)
values ('˜À', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('˜œ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('˜‘', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('˜’', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('˜÷', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('˜◊', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('˜ÿ', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('˜Ÿ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˜‹', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('˜›', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('˜ﬁ', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('˜‡', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('˜·', 'MO');
insert into HZPYDZB (HZ, PY)
values ('˜‚', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('˜„', 'MI');
insert into HZPYDZB (HZ, PY)
values ('˜‰', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˜Â', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('˜Â', 'QUN');
insert into HZPYDZB (HZ, PY)
values ('˜Á', 'MI');
insert into HZPYDZB (HZ, PY)
values ('˜Ë', 'QI');
insert into HZPYDZB (HZ, PY)
values ('˜È', 'AO');
insert into HZPYDZB (HZ, PY)
values ('˜Í', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('˜Î', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('˜Ì', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('˜Ó', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('˜Ô', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('˜Û', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('˜Û', 'LI');
insert into HZPYDZB (HZ, PY)
values ('˜ı', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('˜ˆ', 'AN');
insert into HZPYDZB (HZ, PY)
values ('˜˜', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('˜¯', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('˜˘', 'WU');
insert into HZPYDZB (HZ, PY)
values ('˜˝', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('¯A', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('¯B', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('¯D', 'FU');
insert into HZPYDZB (HZ, PY)
values ('¯F', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('¯F', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('¯N', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('¯R', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('¯T', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('¯U', 'HU');
insert into HZPYDZB (HZ, PY)
values ('¯W', 'FU');
insert into HZPYDZB (HZ, PY)
values ('¯W', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('¯X', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('¯^', 'AO');
insert into HZPYDZB (HZ, PY)
values ('¯_', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('¯_', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('¯`', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('¯`', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('¯b', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('¯c', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('¯d', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('¯k', 'OU');
insert into HZPYDZB (HZ, PY)
values ('¯m', 'GE');
insert into HZPYDZB (HZ, PY)
values ('¯o', 'LING');
insert into HZPYDZB (HZ, PY)
values ('¯p', 'BI');
insert into HZPYDZB (HZ, PY)
values ('¯q', 'FU');
insert into HZPYDZB (HZ, PY)
values ('¯r', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('¯u', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('¯w', 'GE');
insert into HZPYDZB (HZ, PY)
values ('¯x', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('¯z', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('¯Ä', 'AO');
insert into HZPYDZB (HZ, PY)
values ('¯Å', 'GU');
insert into HZPYDZB (HZ, PY)
values ('¯á', 'HU');
insert into HZPYDZB (HZ, PY)
values ('¯ã', 'DUI');
commit;
prompt 12900 records committed...
insert into HZPYDZB (HZ, PY)
values ('¯é', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('¯ë', 'AN');
insert into HZPYDZB (HZ, PY)
values ('¯ë', 'E');
insert into HZPYDZB (HZ, PY)
values ('¯í', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('¯î', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('¯ï', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('¯ñ', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('¯ô', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('¯ö', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¯ú', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('¯ù', 'GE');
insert into HZPYDZB (HZ, PY)
values ('¯ü', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('˘@', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('˘B', 'GE');
insert into HZPYDZB (HZ, PY)
values ('˘B', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('˘C', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('˘D', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('˘F', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('˘H', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˘J', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('˘L', 'BU');
insert into HZPYDZB (HZ, PY)
values ('˘N', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('˘P', 'BO');
insert into HZPYDZB (HZ, PY)
values ('˘S', 'BI');
insert into HZPYDZB (HZ, PY)
values ('˘U', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('˘W', 'TU');
insert into HZPYDZB (HZ, PY)
values ('˘X', 'JING');
insert into HZPYDZB (HZ, PY)
values ('˘\', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('˘^', 'WU');
insert into HZPYDZB (HZ, PY)
values ('˘`', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('˘`', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('˘a', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('˘f', 'FU');
insert into HZPYDZB (HZ, PY)
values ('˘i', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('˘i', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('˘n', 'LU');
insert into HZPYDZB (HZ, PY)
values ('˘o', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('˘q', 'JU');
insert into HZPYDZB (HZ, PY)
values ('˘y', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('˘{', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('˘~', 'JING');
insert into HZPYDZB (HZ, PY)
values ('˘Ç', 'JING');
insert into HZPYDZB (HZ, PY)
values ('˘Ñ', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('˘à', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('˘â', 'JU');
insert into HZPYDZB (HZ, PY)
values ('˘ç', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˘ê', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('˘ë', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('˘ï', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('˘ñ', 'HU');
insert into HZPYDZB (HZ, PY)
values ('˘ò', 'E');
insert into HZPYDZB (HZ, PY)
values ('˘ô', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('˘ö', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('˘õ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('˘ü', 'HE');
insert into HZPYDZB (HZ, PY)
values ('˙@', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('˙A', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('˙C', 'HU');
insert into HZPYDZB (HZ, PY)
values ('˙E', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('˙F', 'WU');
insert into HZPYDZB (HZ, PY)
values ('˙G', 'JU');
insert into HZPYDZB (HZ, PY)
values ('˙I', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('˙K', 'HE');
insert into HZPYDZB (HZ, PY)
values ('˙K', 'HU');
insert into HZPYDZB (HZ, PY)
values ('˙Q', 'HE');
insert into HZPYDZB (HZ, PY)
values ('˙V', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('˙W', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˙[', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('˙a', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˙b', 'LI');
insert into HZPYDZB (HZ, PY)
values ('˙i', 'MA');
insert into HZPYDZB (HZ, PY)
values ('˙k', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('˙n', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˙t', 'OU');
insert into HZPYDZB (HZ, PY)
values ('˙u', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('˙w', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('˙y', 'LV');
insert into HZPYDZB (HZ, PY)
values ('˙Ü', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('˙ä', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('˙ã', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('˙å', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('˙ç', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('˙è', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('˙î', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('˙ò', 'LU');
insert into HZPYDZB (HZ, PY)
values ('˙ü', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('˚A', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˚G', 'BI');
insert into HZPYDZB (HZ, PY)
values ('˚H', 'NING');
insert into HZPYDZB (HZ, PY)
values ('˚I', 'HU');
insert into HZPYDZB (HZ, PY)
values ('˚J', 'MI');
insert into HZPYDZB (HZ, PY)
values ('˚L', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('˚P', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('˚Q', 'BU');
insert into HZPYDZB (HZ, PY)
values ('˚R', 'LU');
insert into HZPYDZB (HZ, PY)
values ('˚S', 'HE');
insert into HZPYDZB (HZ, PY)
values ('˚T', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('˚W', 'YING');
insert into HZPYDZB (HZ, PY)
values ('˚X', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('˚Y', 'GOU');
commit;
prompt 13000 records committed...
insert into HZPYDZB (HZ, PY)
values ('˚Z', 'LI');
insert into HZPYDZB (HZ, PY)
values ('˚]', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('˚_', 'LING');
insert into HZPYDZB (HZ, PY)
values ('˚a', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('˚b', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('˚d', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('˚f', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('˚i', 'HE');
insert into HZPYDZB (HZ, PY)
values ('˚m', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('˚n', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˚o', 'YI');
insert into HZPYDZB (HZ, PY)
values ('˚p', 'YI');
insert into HZPYDZB (HZ, PY)
values ('˚q', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('˚s', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('˚u', 'LU');
insert into HZPYDZB (HZ, PY)
values ('˚v', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('˚w', 'LING');
insert into HZPYDZB (HZ, PY)
values ('˚|', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('˚Å', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('˚Å', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('˚Ñ', 'CU');
insert into HZPYDZB (HZ, PY)
values ('˚Ü', 'MI');
insert into HZPYDZB (HZ, PY)
values ('˚à', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('˚ä', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('˚ã', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('˚å', 'NI');
insert into HZPYDZB (HZ, PY)
values ('˚ç', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('˚è', 'JING');
insert into HZPYDZB (HZ, PY)
values ('˚ê', 'LI');
insert into HZPYDZB (HZ, PY)
values ('˚ì', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('˚î', 'MI');
insert into HZPYDZB (HZ, PY)
values ('˚ï', 'LI');
insert into HZPYDZB (HZ, PY)
values ('˚ó', 'JING');
insert into HZPYDZB (HZ, PY)
values ('˚ô', 'LING');
insert into HZPYDZB (HZ, PY)
values ('˚õ', 'CU');
insert into HZPYDZB (HZ, PY)
values ('˚ú', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('˚ù', 'HE');
insert into HZPYDZB (HZ, PY)
values ('˚û', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('˚ü', 'FU');
insert into HZPYDZB (HZ, PY)
values ('˚†', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('¸@', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('¸A', 'FU');
insert into HZPYDZB (HZ, PY)
values ('¸E', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('¸F', 'FU');
insert into HZPYDZB (HZ, PY)
values ('¸H', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('¸M', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('¸N', 'MO');
insert into HZPYDZB (HZ, PY)
values ('¸O', 'MO');
insert into HZPYDZB (HZ, PY)
values ('¸Q', 'NUN');
insert into HZPYDZB (HZ, PY)
values ('¸R', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('¸S', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('¸T', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('¸U', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('¸V', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('¸Y', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('¸Z', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('¸\', 'HEI');
insert into HZPYDZB (HZ, PY)
values ('¸`', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('¸b', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('¸e', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('¸l', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('¸l', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('¸m', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('¸n', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('¸o', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('¸q', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('¸r', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('¸u', 'LU');
insert into HZPYDZB (HZ, PY)
values ('¸v', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('¸w', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('¸{', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('¸Ç', 'BIE');
insert into HZPYDZB (HZ, PY)
values ('¸Ö', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('¸Ü', 'MI');
insert into HZPYDZB (HZ, PY)
values ('¸â', 'GU');
insert into HZPYDZB (HZ, PY)
values ('¸ã', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('¸é', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('¸ñ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('¸ñ', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('¸ü', 'JU');
insert into HZPYDZB (HZ, PY)
values ('¸†', 'JING');
insert into HZPYDZB (HZ, PY)
values ('˝A', 'JU');
insert into HZPYDZB (HZ, PY)
values ('˝F', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('˝H', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('˝J', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('˝J', 'KU');
insert into HZPYDZB (HZ, PY)
values ('˝L', 'E');
insert into HZPYDZB (HZ, PY)
values ('˝L', 'HE');
insert into HZPYDZB (HZ, PY)
values ('˝M', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('˝P', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('˝Q', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('˝R', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˝T', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˝U', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˝V', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˝W', 'JI');
insert into HZPYDZB (HZ, PY)
values ('˝Y', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('˝Z', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('˝[', 'HE');
insert into HZPYDZB (HZ, PY)
values ('˝_', 'BAO');
commit;
prompt 13100 records committed...
insert into HZPYDZB (HZ, PY)
values ('˝b', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('˝g', 'LING');
insert into HZPYDZB (HZ, PY)
values ('˝i', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('˝l', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('˝l', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('˝m', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('˝p', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('˝s', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('˝u', 'NI');
insert into HZPYDZB (HZ, PY)
values ('˝v', 'CE');
insert into HZPYDZB (HZ, PY)
values ('˝w', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('˝{', 'OU');
insert into HZPYDZB (HZ, PY)
values ('˝}', 'WO');
insert into HZPYDZB (HZ, PY)
values ('˝Ñ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('˝Ö', 'E');
insert into HZPYDZB (HZ, PY)
values ('˝Ü', 'HE');
insert into HZPYDZB (HZ, PY)
values ('˝à', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('˝ä', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('˝ã', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('˝ç', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('˝é', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('˝è', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('˝ê', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('˝ë', 'DA');
insert into HZPYDZB (HZ, PY)
values ('˝í', 'LING');
insert into HZPYDZB (HZ, PY)
values ('˝ì', 'DA');
insert into HZPYDZB (HZ, PY)
values ('˝ó', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('˝ò', 'HE');
insert into HZPYDZB (HZ, PY)
values ('˝ô', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ÿ¯', 'YING');
insert into HZPYDZB (HZ, PY)
values ('Ÿ˙', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('Ÿ˙', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('Ÿ˝', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('Ÿ˛', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('⁄A', 'YING');
insert into HZPYDZB (HZ, PY)
values ('⁄C', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('⁄L', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('⁄M', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('⁄P', 'BI');
insert into HZPYDZB (HZ, PY)
values ('⁄S', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('⁄W', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('⁄Z', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('⁄\', 'LI');
insert into HZPYDZB (HZ, PY)
values ('⁄]', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('⁄_', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('⁄_', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('⁄a', 'CI');
insert into HZPYDZB (HZ, PY)
values ('⁄b', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('⁄b', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('⁄c', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('⁄d', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('⁄d', 'DI');
insert into HZPYDZB (HZ, PY)
values ('⁄e', 'CI');
insert into HZPYDZB (HZ, PY)
values ('⁄f', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('⁄f', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('⁄g', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('⁄g', 'TU');
insert into HZPYDZB (HZ, PY)
values ('⁄h', 'DI');
insert into HZPYDZB (HZ, PY)
values ('⁄k', 'JU');
insert into HZPYDZB (HZ, PY)
values ('⁄k', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('⁄l', 'JI');
insert into HZPYDZB (HZ, PY)
values ('⁄l', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('⁄m', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('⁄n', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('⁄o', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('⁄p', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('⁄q', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('⁄r', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('⁄s', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('⁄u', 'CU');
insert into HZPYDZB (HZ, PY)
values ('⁄w', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('⁄y', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('⁄z', 'JU');
insert into HZPYDZB (HZ, PY)
values ('⁄|', 'JI');
insert into HZPYDZB (HZ, PY)
values ('⁄|', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('⁄}', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('⁄Ä', 'LU');
insert into HZPYDZB (HZ, PY)
values ('⁄Å', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('⁄Ç', 'CU');
insert into HZPYDZB (HZ, PY)
values ('⁄Ñ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('⁄Ö', 'CU');
insert into HZPYDZB (HZ, PY)
values ('⁄á', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('⁄á', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('⁄à', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('⁄à', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('⁄å', 'TI');
insert into HZPYDZB (HZ, PY)
values ('⁄è', 'KU');
insert into HZPYDZB (HZ, PY)
values ('⁄è', 'WU');
insert into HZPYDZB (HZ, PY)
values ('⁄ê', 'KE');
insert into HZPYDZB (HZ, PY)
values ('⁄ë', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('⁄ë', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('⁄í', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('⁄ì', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('⁄ì', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('⁄î', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('⁄ï', 'BA');
insert into HZPYDZB (HZ, PY)
values ('⁄ï', 'PA');
insert into HZPYDZB (HZ, PY)
values ('⁄ñ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('⁄ñ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('⁄ó', 'CHI');
commit;
prompt 13200 records committed...
insert into HZPYDZB (HZ, PY)
values ('⁄ó', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('⁄ô', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('⁄ö', 'LING');
insert into HZPYDZB (HZ, PY)
values ('⁄õ', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('⁄ú', 'KU');
insert into HZPYDZB (HZ, PY)
values ('⁄ù', 'CI');
insert into HZPYDZB (HZ, PY)
values ('⁄û', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('⁄ü', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('⁄†', 'JU');
insert into HZPYDZB (HZ, PY)
values ('⁄†', 'QU');
insert into HZPYDZB (HZ, PY)
values ('⁄°', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('⁄¢', 'MI');
insert into HZPYDZB (HZ, PY)
values ('⁄§', 'MING');
insert into HZPYDZB (HZ, PY)
values ('⁄¶', 'JI');
insert into HZPYDZB (HZ, PY)
values ('⁄¶', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('⁄ß', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('⁄®', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('⁄©', 'OU');
insert into HZPYDZB (HZ, PY)
values ('⁄™', 'JU');
insert into HZPYDZB (HZ, PY)
values ('⁄´', 'NE');
insert into HZPYDZB (HZ, PY)
values ('⁄¨', 'GU');
insert into HZPYDZB (HZ, PY)
values ('⁄≠', 'HE');
insert into HZPYDZB (HZ, PY)
values ('⁄Æ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('⁄Æ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('⁄Ø', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('⁄∞', 'QU');
insert into HZPYDZB (HZ, PY)
values ('⁄±', 'YI');
insert into HZPYDZB (HZ, PY)
values ('⁄≤', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('⁄¥', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('⁄µ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('⁄µ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('⁄∂', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('⁄∑', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('⁄∏', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('⁄π', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('⁄∫', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('⁄ª', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('⁄º', 'XU');
insert into HZPYDZB (HZ, PY)
values ('⁄Ω', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('⁄æ', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('⁄ø', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('⁄¿', 'EI');
insert into HZPYDZB (HZ, PY)
values ('⁄¿', 'XI');
insert into HZPYDZB (HZ, PY)
values ('⁄¡', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('⁄¡', 'ZOU');
insert into HZPYDZB (HZ, PY)
values ('⁄¬', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('⁄√', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('⁄ƒ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('⁄≈', 'MIE');
insert into HZPYDZB (HZ, PY)
values ('⁄≈', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('⁄∆', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('⁄«', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('⁄»', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('⁄…', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('⁄ ', 'NUE');
insert into HZPYDZB (HZ, PY)
values ('⁄À', 'YE');
insert into HZPYDZB (HZ, PY)
values ('⁄Õ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('⁄œ', 'AN');
insert into HZPYDZB (HZ, PY)
values ('⁄œ', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('⁄–', 'DI');
insert into HZPYDZB (HZ, PY)
values ('⁄–', 'TI');
insert into HZPYDZB (HZ, PY)
values ('⁄—', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('⁄”', 'MO');
insert into HZPYDZB (HZ, PY)
values ('⁄‘', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('⁄’', 'SU');
insert into HZPYDZB (HZ, PY)
values ('⁄÷', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('⁄◊', 'MI');
insert into HZPYDZB (HZ, PY)
values ('⁄ÿ', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('⁄ÿ', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('⁄Ÿ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('⁄⁄', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('⁄€', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('⁄‹', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('⁄ﬁ', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('⁄ﬂ', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('⁄‡', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('⁄·', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('⁄‚', 'FU');
insert into HZPYDZB (HZ, PY)
values ('⁄„', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('⁄„', 'WU');
insert into HZPYDZB (HZ, PY)
values ('⁄‰', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('⁄Â', 'JING');
insert into HZPYDZB (HZ, PY)
values ('⁄Ê', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('⁄Á', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('⁄Ë', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('⁄È', 'PO');
insert into HZPYDZB (HZ, PY)
values ('⁄Í', 'JING');
insert into HZPYDZB (HZ, PY)
values ('⁄Í', 'XING');
insert into HZPYDZB (HZ, PY)
values ('⁄Î', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('⁄Ï', 'DE');
insert into HZPYDZB (HZ, PY)
values ('⁄Ï', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('⁄Ì', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('⁄Ô', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('⁄', 'BI');
insert into HZPYDZB (HZ, PY)
values ('⁄', 'PI');
insert into HZPYDZB (HZ, PY)
values ('⁄Ò', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('⁄Ú', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('⁄Û', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('⁄ı', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('⁄ˆ', 'QIONG');
commit;
prompt 13300 records committed...
insert into HZPYDZB (HZ, PY)
values ('⁄˜', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('⁄˜', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('⁄¯', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('⁄˘', 'WU');
insert into HZPYDZB (HZ, PY)
values ('⁄˚', 'BING');
insert into HZPYDZB (HZ, PY)
values ('⁄¸', 'PI');
insert into HZPYDZB (HZ, PY)
values ('⁄˝', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('⁄˛', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('⁄˛', 'YE');
insert into HZPYDZB (HZ, PY)
values ('€@', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('€@', 'TIE');
insert into HZPYDZB (HZ, PY)
values ('€A', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('€B', 'JU');
insert into HZPYDZB (HZ, PY)
values ('€C', 'NI');
insert into HZPYDZB (HZ, PY)
values ('€E', 'JI');
insert into HZPYDZB (HZ, PY)
values ('€F', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('€F', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('€H', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('€H', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('€I', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('€J', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('€L', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('€L', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('€M', 'PIAN');
insert into HZPYDZB (HZ, PY)
values ('€N', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('€O', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('€O', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('€P', 'CAI');
insert into HZPYDZB (HZ, PY)
values ('€Q', 'DA');
insert into HZPYDZB (HZ, PY)
values ('€R', 'JU');
insert into HZPYDZB (HZ, PY)
values ('€R', 'QU');
insert into HZPYDZB (HZ, PY)
values ('€S', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('€T', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('€U', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('€U', 'CU');
insert into HZPYDZB (HZ, PY)
values ('€V', 'JING');
insert into HZPYDZB (HZ, PY)
values ('€W', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('€X', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('€Y', 'BU');
insert into HZPYDZB (HZ, PY)
values ('€Z', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('€Z', 'QUN');
insert into HZPYDZB (HZ, PY)
values ('€\', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('€]', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('€_', 'MEO');
insert into HZPYDZB (HZ, PY)
values ('€a', 'JI');
insert into HZPYDZB (HZ, PY)
values ('€a', 'QI');
insert into HZPYDZB (HZ, PY)
values ('€b', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('€b', 'WO');
insert into HZPYDZB (HZ, PY)
values ('€c', 'CU');
insert into HZPYDZB (HZ, PY)
values ('€c', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('€e', 'JI');
insert into HZPYDZB (HZ, PY)
values ('€f', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('€g', 'JU');
insert into HZPYDZB (HZ, PY)
values ('€h', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('€j', 'LU');
insert into HZPYDZB (HZ, PY)
values ('€k', 'LENG');
insert into HZPYDZB (HZ, PY)
values ('€l', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('€l', 'WO');
insert into HZPYDZB (HZ, PY)
values ('€m', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('€n', 'CU');
insert into HZPYDZB (HZ, PY)
values ('€n', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('€o', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('€p', 'JI');
insert into HZPYDZB (HZ, PY)
values ('€q', 'CU');
insert into HZPYDZB (HZ, PY)
values ('€q', 'DI');
insert into HZPYDZB (HZ, PY)
values ('€s', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('€s', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('€t', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('€u', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('€v', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('€w', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('€w', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('€y', 'DI');
insert into HZPYDZB (HZ, PY)
values ('€z', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('€|', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('€}', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('€~', 'BI');
insert into HZPYDZB (HZ, PY)
values ('€~', 'FU');
insert into HZPYDZB (HZ, PY)
values ('€Å', 'NA');
insert into HZPYDZB (HZ, PY)
values ('€Ç', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('€Ç', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('€É', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('€Ö', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('€Ö', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('€Ü', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('€á', 'DI');
insert into HZPYDZB (HZ, PY)
values ('€à', 'JI');
insert into HZPYDZB (HZ, PY)
values ('€â', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('€ä', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('€å', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('€ç', 'LU');
insert into HZPYDZB (HZ, PY)
values ('€è', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('€ì', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('€î', 'JI');
insert into HZPYDZB (HZ, PY)
values ('€ó', 'DI');
insert into HZPYDZB (HZ, PY)
values ('€ö', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('€ú', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('€ù', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('€û', 'JU');
insert into HZPYDZB (HZ, PY)
values ('€†', 'CHONG');
commit;
prompt 13400 records committed...
insert into HZPYDZB (HZ, PY)
values ('€†', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('€°', 'DI');
insert into HZPYDZB (HZ, PY)
values ('€¢', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('€£', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('€§', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('€•', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('€¶', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('€®', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('€®', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('€©', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('€™', 'LI');
insert into HZPYDZB (HZ, PY)
values ('€™', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('€´', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('€´', 'YING');
insert into HZPYDZB (HZ, PY)
values ('€¨', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('€≠', 'XI');
insert into HZPYDZB (HZ, PY)
values ('€Ø', 'PI');
insert into HZPYDZB (HZ, PY)
values ('€∞', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('€±', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('€≤', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('€µ', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('€∂', 'PO');
insert into HZPYDZB (HZ, PY)
values ('€∑', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('€∫', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('€ª', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('€º', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('€Ω', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('€ø', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('€¿', 'HE');
insert into HZPYDZB (HZ, PY)
values ('€¡', 'GE');
insert into HZPYDZB (HZ, PY)
values ('€¬', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('€√', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('€√', 'XU');
insert into HZPYDZB (HZ, PY)
values ('€≈', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('€«', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('€…', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('€ ', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('€Ã', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('€Ã', 'SI');
insert into HZPYDZB (HZ, PY)
values ('€Õ', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('€Õ', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('€Œ', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('€œ', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('€–', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('€—', 'E');
insert into HZPYDZB (HZ, PY)
values ('€“', 'FA');
insert into HZPYDZB (HZ, PY)
values ('€”', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('€‘', 'JI');
insert into HZPYDZB (HZ, PY)
values ('€÷', 'HE');
insert into HZPYDZB (HZ, PY)
values ('€◊', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('€◊', 'XU');
insert into HZPYDZB (HZ, PY)
values ('€ÿ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('€Ÿ', 'GE');
insert into HZPYDZB (HZ, PY)
values ('€Ÿ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('€⁄', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('€⁄', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('€€', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('€‹', 'PI');
insert into HZPYDZB (HZ, PY)
values ('€›', 'YI');
insert into HZPYDZB (HZ, PY)
values ('€ﬁ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('€ﬂ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('€ﬂ', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('€‡', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('€·', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('€‚', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('€„', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('€„', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('€‰', 'LU');
insert into HZPYDZB (HZ, PY)
values ('€Â', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('€Ê', 'DI');
insert into HZPYDZB (HZ, PY)
values ('€Á', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('€Á', 'YI');
insert into HZPYDZB (HZ, PY)
values ('€Ë', 'NI');
insert into HZPYDZB (HZ, PY)
values ('€È', 'MU');
insert into HZPYDZB (HZ, PY)
values ('€Í', 'AO');
insert into HZPYDZB (HZ, PY)
values ('€Í', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('€Î', 'YA');
insert into HZPYDZB (HZ, PY)
values ('€Ï', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('€Ì', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('€Ì', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('€Ó', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('€Ô', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('€Ò', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('€Ú', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('€Û', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('€Û', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('€Ù', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('€ˆ', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('€ˆ', 'WO');
insert into HZPYDZB (HZ, PY)
values ('€˜', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('€¯', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('€˘', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('€˙', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('€˚', 'AN');
insert into HZPYDZB (HZ, PY)
values ('€˝', 'PI');
insert into HZPYDZB (HZ, PY)
values ('€˛', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('‹A', 'CU');
insert into HZPYDZB (HZ, PY)
values ('‹F', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('‹F', 'JU');
insert into HZPYDZB (HZ, PY)
values ('‹G', 'LIAO');
commit;
prompt 13500 records committed...
insert into HZPYDZB (HZ, PY)
values ('‹H', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('‹I', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('‹J', 'DA');
insert into HZPYDZB (HZ, PY)
values ('‹M', 'JU');
insert into HZPYDZB (HZ, PY)
values ('‹Q', 'JI');
insert into HZPYDZB (HZ, PY)
values ('‹S', 'TI');
insert into HZPYDZB (HZ, PY)
values ('‹T', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('‹V', 'LI');
insert into HZPYDZB (HZ, PY)
values ('‹V', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('‹[', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('‹\', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('‹_', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('‹b', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('‹f', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('‹g', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('‹j', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('‹k', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('‹l', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('‹m', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('‹n', 'TI');
insert into HZPYDZB (HZ, PY)
values ('‹p', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('‹q', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('‹t', 'AI');
insert into HZPYDZB (HZ, PY)
values ('‹u', 'JI');
insert into HZPYDZB (HZ, PY)
values ('‹v', 'JU');
insert into HZPYDZB (HZ, PY)
values ('‹w', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('‹x', 'UU');
insert into HZPYDZB (HZ, PY)
values ('‹{', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('‹|', 'QU');
insert into HZPYDZB (HZ, PY)
values ('‹}', 'LV');
insert into HZPYDZB (HZ, PY)
values ('‹~', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('‹É', 'TI');
insert into HZPYDZB (HZ, PY)
values ('‹á', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('‹à', 'GA');
insert into HZPYDZB (HZ, PY)
values ('‹à', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('‹â', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('‹ä', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('‹é', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('‹ë', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('‹ò', 'NA');
insert into HZPYDZB (HZ, PY)
values ('‹õ', 'RUAN');
insert into HZPYDZB (HZ, PY)
values ('‹ü', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('‹†', 'HU');
insert into HZPYDZB (HZ, PY)
values ('‹°', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('‹°', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('‹¢', 'TU');
insert into HZPYDZB (HZ, PY)
values ('‹§', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('‹•', 'KU');
insert into HZPYDZB (HZ, PY)
values ('‹¶', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('‹®', 'LENG');
insert into HZPYDZB (HZ, PY)
values ('‹©', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('‹™', 'GE');
insert into HZPYDZB (HZ, PY)
values ('‹¨', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('‹≠', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('‹Ø', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('‹∞', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('‹≤', 'YI');
insert into HZPYDZB (HZ, PY)
values ('‹¥', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('‹¥', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('‹µ', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('‹µ', 'RENG');
insert into HZPYDZB (HZ, PY)
values ('‹∑', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('‹∏', 'JI');
insert into HZPYDZB (HZ, PY)
values ('‹π', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('‹ª', 'QI');
insert into HZPYDZB (HZ, PY)
values ('‹Ω', 'FU');
insert into HZPYDZB (HZ, PY)
values ('‹æ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('‹æ', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‹ø', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('‹¿', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('‹¿', 'FU');
insert into HZPYDZB (HZ, PY)
values ('‹¡', 'JI');
insert into HZPYDZB (HZ, PY)
values ('‹¬', 'LI');
insert into HZPYDZB (HZ, PY)
values ('‹√', 'E');
insert into HZPYDZB (HZ, PY)
values ('‹ƒ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('‹ƒ', 'QU');
insert into HZPYDZB (HZ, PY)
values ('‹≈', 'BI');
insert into HZPYDZB (HZ, PY)
values ('‹≈', 'PI');
insert into HZPYDZB (HZ, PY)
values ('‹∆', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('‹«', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('‹«', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('‹»', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('‹»', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('‹…', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('‹ ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('‹À', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('‹À', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('‹Ã', 'HU');
insert into HZPYDZB (HZ, PY)
values ('‹Ã', 'WU');
insert into HZPYDZB (HZ, PY)
values ('‹Õ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('‹Œ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('‹Œ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('‹œ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('‹œ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('‹–', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('‹—', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('‹“', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('‹‘', 'MO');
insert into HZPYDZB (HZ, PY)
values ('‹’', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('‹÷', 'PI');
commit;
prompt 13600 records committed...
insert into HZPYDZB (HZ, PY)
values ('‹÷', 'PIE');
insert into HZPYDZB (HZ, PY)
values ('‹◊', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('‹ÿ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('‹Ÿ', 'MU');
insert into HZPYDZB (HZ, PY)
values ('‹⁄', 'JU');
insert into HZPYDZB (HZ, PY)
values ('‹€', 'RAN');
insert into HZPYDZB (HZ, PY)
values ('‹‹', 'QING');
insert into HZPYDZB (HZ, PY)
values ('‹›', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('‹ﬁ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('‹ﬁ', 'PU');
insert into HZPYDZB (HZ, PY)
values ('‹ﬂ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('‹ﬂ', 'LING');
insert into HZPYDZB (HZ, PY)
values ('‹‡', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('‹·', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('‹„', 'YING');
insert into HZPYDZB (HZ, PY)
values ('‹‰', 'QIONG');
insert into HZPYDZB (HZ, PY)
values ('‹Â', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('‹Ê', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('‹Ê', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('‹Á', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('‹Á', 'XI');
insert into HZPYDZB (HZ, PY)
values ('‹Ë', 'TI');
insert into HZPYDZB (HZ, PY)
values ('‹Ë', 'YI');
insert into HZPYDZB (HZ, PY)
values ('‹È', 'RAO');
insert into HZPYDZB (HZ, PY)
values ('‹È', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('‹Í', 'BI');
insert into HZPYDZB (HZ, PY)
values ('‹Î', 'CI');
insert into HZPYDZB (HZ, PY)
values ('‹Ï', 'JU');
insert into HZPYDZB (HZ, PY)
values ('‹Ì', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('‹Ó', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('‹Ô', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('‹', 'TING');
insert into HZPYDZB (HZ, PY)
values ('‹Ò', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('‹Ú', 'FU');
insert into HZPYDZB (HZ, PY)
values ('‹Û', 'REN');
insert into HZPYDZB (HZ, PY)
values ('‹ı', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('‹ı', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('‹ˆ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('‹˜', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('‹¯', 'MING');
insert into HZPYDZB (HZ, PY)
values ('‹˘', 'JI');
insert into HZPYDZB (HZ, PY)
values ('‹˙', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('‹˚', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('‹¸', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('‹˝', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('‹˛', 'XING');
insert into HZPYDZB (HZ, PY)
values ('‹˛', 'YING');
insert into HZPYDZB (HZ, PY)
values ('›A', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('›F', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('›H', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('›O', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('›P', 'FU');
insert into HZPYDZB (HZ, PY)
values ('›S', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('›U', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('›V', 'KE');
insert into HZPYDZB (HZ, PY)
values ('›W', 'YI');
insert into HZPYDZB (HZ, PY)
values ('›X', 'QING');
insert into HZPYDZB (HZ, PY)
values ('›Y', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('›\', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('›^', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('›_', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('›`', 'HE');
insert into HZPYDZB (HZ, PY)
values ('›`', 'LU');
insert into HZPYDZB (HZ, PY)
values ('›b', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('›d', 'ZAI');
insert into HZPYDZB (HZ, PY)
values ('›g', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('›i', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('›k', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('›m', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('›o', 'FU');
insert into HZPYDZB (HZ, PY)
values ('›p', 'QING');
insert into HZPYDZB (HZ, PY)
values ('›r', 'NI');
insert into HZPYDZB (HZ, PY)
values ('›s', 'LENG');
insert into HZPYDZB (HZ, PY)
values ('›s', 'LING');
insert into HZPYDZB (HZ, PY)
values ('›t', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('›v', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('›x', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('›z', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('›|', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('›Ç', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('›Ñ', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('›Ü', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('›â', 'ER');
insert into HZPYDZB (HZ, PY)
values ('›ä', 'ROU');
insert into HZPYDZB (HZ, PY)
values ('›ç', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('›ë', 'GE');
insert into HZPYDZB (HZ, PY)
values ('›î', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('›ó', 'FU');
insert into HZPYDZB (HZ, PY)
values ('›ö', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('›ù', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('›û', 'GU');
insert into HZPYDZB (HZ, PY)
values ('›†', 'HE');
insert into HZPYDZB (HZ, PY)
values ('›°', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('›°', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('›¢', 'GEN');
insert into HZPYDZB (HZ, PY)
values ('›¢', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('›£', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('›§', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('›•', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('›¶', 'HONG');
commit;
prompt 13700 records committed...
insert into HZPYDZB (HZ, PY)
values ('›®', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('›©', 'BI');
insert into HZPYDZB (HZ, PY)
values ('›´', 'WO');
insert into HZPYDZB (HZ, PY)
values ('›¨', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('›≠', 'E');
insert into HZPYDZB (HZ, PY)
values ('›Æ', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('›Ø', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('›∞', 'LI');
insert into HZPYDZB (HZ, PY)
values ('›±', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('›±', 'TU');
insert into HZPYDZB (HZ, PY)
values ('›≤', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('›¥', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('›¥', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('›∂', 'DI');
insert into HZPYDZB (HZ, PY)
values ('›∑', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('›∏', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('›∏', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('›π', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('›π', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('›∫', 'YING');
insert into HZPYDZB (HZ, PY)
values ('›ª', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('›º', 'JING');
insert into HZPYDZB (HZ, PY)
values ('›Ω', 'JI');
insert into HZPYDZB (HZ, PY)
values ('›Ω', 'QI');
insert into HZPYDZB (HZ, PY)
values ('›æ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('›ø', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('›¿', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('›¿', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('›¡', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('›¬', 'QI');
insert into HZPYDZB (HZ, PY)
values ('›ƒ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('›ƒ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('›≈', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('›∆', 'TIE');
insert into HZPYDZB (HZ, PY)
values ('›«', 'YU');
insert into HZPYDZB (HZ, PY)
values ('›»', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('›…', 'BI');
insert into HZPYDZB (HZ, PY)
values ('›À', 'TU');
insert into HZPYDZB (HZ, PY)
values ('›Ã', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('›Ã', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('›Õ', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('›œ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('›–', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('›—', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('›“', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('›“', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('›”', 'YING');
insert into HZPYDZB (HZ, PY)
values ('›‘', 'GU');
insert into HZPYDZB (HZ, PY)
values ('›’', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('›÷', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('›◊', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('›ÿ', 'REN');
insert into HZPYDZB (HZ, PY)
values ('›ÿ', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('›⁄', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('›€', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('›‹', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('››', 'QI');
insert into HZPYDZB (HZ, PY)
values ('›ﬁ', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('›ﬂ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('›‡', 'E');
insert into HZPYDZB (HZ, PY)
values ('›·', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('›„', 'DING');
insert into HZPYDZB (HZ, PY)
values ('›„', 'TING');
insert into HZPYDZB (HZ, PY)
values ('›‰', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('›Ê', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('›Á', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('›Ë', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('›Ë', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('›Î', 'MA');
insert into HZPYDZB (HZ, PY)
values ('›Î', 'MO');
insert into HZPYDZB (HZ, PY)
values ('›Ï', 'EN');
insert into HZPYDZB (HZ, PY)
values ('›Ì', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('›Ó', 'WENG');
insert into HZPYDZB (HZ, PY)
values ('›Ô', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('›Ô', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('›', 'JI');
insert into HZPYDZB (HZ, PY)
values ('›Ò', 'LI');
insert into HZPYDZB (HZ, PY)
values ('›Ú', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('›Û', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('›Ù', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('›ı', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('›¯', 'SU');
insert into HZPYDZB (HZ, PY)
values ('›˘', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('›˙', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('›¸', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('›¸', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('›˝', 'CU');
insert into HZPYDZB (HZ, PY)
values ('›˛', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ﬁA', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ﬁF', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('ﬁH', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ﬁI', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ﬁK', 'BU');
insert into HZPYDZB (HZ, PY)
values ('ﬁL', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ﬁO', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ﬁP', 'GE');
insert into HZPYDZB (HZ, PY)
values ('ﬁR', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁS', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁZ', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ﬁ[', 'LEI');
commit;
prompt 13800 records committed...
insert into HZPYDZB (HZ, PY)
values ('ﬁ]', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ^', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ_', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ﬁ`', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ﬁa', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('ﬁb', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('ﬁg', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁh', 'LA');
insert into HZPYDZB (HZ, PY)
values ('ﬁi', 'CI');
insert into HZPYDZB (HZ, PY)
values ('ﬁk', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁk', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁl', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁl', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁn', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁo', 'CI');
insert into HZPYDZB (HZ, PY)
values ('ﬁp', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁq', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁr', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('ﬁs', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('ﬁw', 'RENG');
insert into HZPYDZB (HZ, PY)
values ('ﬁx', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁy', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ﬁz', 'RU');
insert into HZPYDZB (HZ, PY)
values ('ﬁ{', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ|', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ~', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ﬁ~', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ﬁÄ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ﬁÅ', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('ﬁÇ', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('ﬁÉ', 'TU');
insert into HZPYDZB (HZ, PY)
values ('ﬁÑ', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('ﬁÖ', 'TA');
insert into HZPYDZB (HZ, PY)
values ('ﬁÖ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ﬁÜ', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('ﬁá', 'TA');
insert into HZPYDZB (HZ, PY)
values ('ﬁá', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ﬁâ', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('ﬁä', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('ﬁã', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ﬁã', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ﬁå', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ﬁå', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ﬁç', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ﬁç', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ﬁé', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('ﬁé', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('ﬁè', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('ﬁê', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ﬁë', 'KEOP');
insert into HZPYDZB (HZ, PY)
values ('ﬁí', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ﬁì', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('ﬁï', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('ﬁó', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ﬁõ', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('ﬁü', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ﬁ†', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ°', 'QU');
insert into HZPYDZB (HZ, PY)
values ('ﬁ¢', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('ﬁ£', 'XU');
insert into HZPYDZB (HZ, PY)
values ('ﬁ§', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ﬁ•', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ¶', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁß', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ﬁ©', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ﬁ™', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ´', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('ﬁ´', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ﬁ¨', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ¨', 'PI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ≠', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ≠', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ﬁÆ', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('ﬁ±', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ≤', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ≥', 'WENG');
insert into HZPYDZB (HZ, PY)
values ('ﬁ≥', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('ﬁ¥', 'COU');
insert into HZPYDZB (HZ, PY)
values ('ﬁ¥', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('ﬁµ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ∂', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('ﬁ∑', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ∏', 'RU');
insert into HZPYDZB (HZ, PY)
values ('ﬁπ', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ∫', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁª', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('ﬁº', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ﬁΩ', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ﬁø', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('ﬁ¡', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ﬁ¡', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ﬁ¬', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ√', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('ﬁƒ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ≈', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('ﬁ∆', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ«', 'DA');
insert into HZPYDZB (HZ, PY)
values ('ﬁ«', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ﬁ»', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ…', 'XI');
commit;
prompt 13900 records committed...
insert into HZPYDZB (HZ, PY)
values ('ﬁ ', 'ZANG');
insert into HZPYDZB (HZ, PY)
values ('ﬁ ', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('ﬁÃ', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('ﬁÃ', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('ﬁÕ', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ﬁÕ', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('ﬁŒ', 'GA');
insert into HZPYDZB (HZ, PY)
values ('ﬁœ', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ—', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ“', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ“', 'ZHUAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ”', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ”', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ‘', 'BU');
insert into HZPYDZB (HZ, PY)
values ('ﬁ‘', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ﬁ’', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ÷', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('ﬁ◊', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ﬁ◊', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ﬁÿ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ﬁ⁄', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ€', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ﬁ‹', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ›', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁﬁ', 'YE');
insert into HZPYDZB (HZ, PY)
values ('ﬁﬂ', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ‡', 'NA');
insert into HZPYDZB (HZ, PY)
values ('ﬁ·', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ·', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ‚', 'GUAI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ‚', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('ﬁ„', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ‰', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ﬁÂ', 'POU');
insert into HZPYDZB (HZ, PY)
values ('ﬁÊ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ﬁÊ', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('ﬁÁ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁË', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁÈ', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ﬁÈ', 'YE');
insert into HZPYDZB (HZ, PY)
values ('ﬁÍ', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('ﬁÎ', 'YA');
insert into HZPYDZB (HZ, PY)
values ('ﬁÏ', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('ﬁÌ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ﬁÓ', 'AN');
insert into HZPYDZB (HZ, PY)
values ('ﬁÓ', 'YE');
insert into HZPYDZB (HZ, PY)
values ('ﬁ', 'BING');
insert into HZPYDZB (HZ, PY)
values ('ﬁÒ', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ﬁÚ', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁÛ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ﬁÛ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ﬁÙ', 'EN');
insert into HZPYDZB (HZ, PY)
values ('ﬁı', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ﬁˆ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ˜', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('ﬁ¯', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('ﬁ˘', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('ﬁ˚', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ﬁ¸', 'YING');
insert into HZPYDZB (HZ, PY)
values ('ﬁ˝', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ˛', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ﬂ@', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ﬂA', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ﬂB', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ﬂC', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂD', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ﬂE', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ﬂF', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('ﬂG', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('ﬂH', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂI', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ﬂJ', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('ﬂL', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('ﬂM', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ﬂO', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂP', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ﬂQ', 'TA');
insert into HZPYDZB (HZ, PY)
values ('ﬂS', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂT', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ﬂU', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ﬂV', 'AN');
insert into HZPYDZB (HZ, PY)
values ('ﬂW', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ﬂX', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ﬂY', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ﬂZ', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ﬂ]', 'E');
insert into HZPYDZB (HZ, PY)
values ('ﬂ^', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂ_', 'TA');
insert into HZPYDZB (HZ, PY)
values ('ﬂ`', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ﬂa', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('ﬂb', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ﬂc', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('ﬂg', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ﬂh', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('ﬂi', 'SU');
insert into HZPYDZB (HZ, PY)
values ('ﬂj', 'HWEONG');
insert into HZPYDZB (HZ, PY)
values ('ﬂj', 'MA');
insert into HZPYDZB (HZ, PY)
values ('ﬂm', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ﬂo', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ﬂp', 'SU');
commit;
prompt 14000 records committed...
insert into HZPYDZB (HZ, PY)
values ('ﬂq', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('ﬂs', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('ﬂt', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ﬂx', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('ﬂz', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ|', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ﬂÄ', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('ﬂÄ', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ﬂÇ', 'TENG');
insert into HZPYDZB (HZ, PY)
values ('ﬂÜ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ﬂÜ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ﬂâ', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂä', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ﬂã', 'TING');
insert into HZPYDZB (HZ, PY)
values ('ﬂå', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ﬂç', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ﬂè', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ﬂè', 'RU');
insert into HZPYDZB (HZ, PY)
values ('ﬂê', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ﬂë', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ﬂí', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('ﬂí', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('ﬂì', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('ﬂî', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('ﬂï', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ﬂñ', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('ﬂó', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('ﬂò', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂô', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('ﬂö', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ﬂõ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ﬂõ', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ﬂú', 'WA');
insert into HZPYDZB (HZ, PY)
values ('ﬂù', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('ﬂû', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ﬂü', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ†', 'KU');
insert into HZPYDZB (HZ, PY)
values ('ﬂ°', 'LA');
insert into HZPYDZB (HZ, PY)
values ('ﬂ°', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('ﬂ§', 'ZUN');
insert into HZPYDZB (HZ, PY)
values ('ﬂ•', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('ﬂ¶', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ﬂ®', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ﬂ®', 'PI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ™', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂ´', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂ´', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('ﬂ≠', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('ﬂÆ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ﬂØ', 'TE');
insert into HZPYDZB (HZ, PY)
values ('ﬂØ', 'TEI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ∞', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ≤', 'BU');
insert into HZPYDZB (HZ, PY)
values ('ﬂ≤', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ≥', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ¥', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ﬂµ', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('ﬂ∂', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('ﬂ∂', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('ﬂ∑', 'LE');
insert into HZPYDZB (HZ, PY)
values ('ﬂ∑', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ∏', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('ﬂπ', 'A');
insert into HZPYDZB (HZ, PY)
values ('ﬂπ', 'YA');
insert into HZPYDZB (HZ, PY)
values ('ﬂ∫', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ﬂª', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ﬂº', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ﬂΩ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ﬂæ', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('ﬂæ', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('ﬂø', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ¿', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ¿', 'E');
insert into HZPYDZB (HZ, PY)
values ('ﬂ¡', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ¡', 'PI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ¬', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ¬', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ√', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂƒ', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('ﬂ≈', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ﬂ∆', 'ZA');
insert into HZPYDZB (HZ, PY)
values ('ﬂ«', 'KA');
insert into HZPYDZB (HZ, PY)
values ('ﬂ«', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('ﬂ»', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('ﬂ…', 'GU');
insert into HZPYDZB (HZ, PY)
values ('ﬂ…', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('ﬂ ', 'LING');
insert into HZPYDZB (HZ, PY)
values ('ﬂÀ', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('ﬂÃ', 'NING');
insert into HZPYDZB (HZ, PY)
values ('ﬂÕ', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂŒ', 'NA');
insert into HZPYDZB (HZ, PY)
values ('ﬂŒ', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('ﬂ–', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ—', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('ﬂ“', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ“', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('ﬂ”', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ﬂ‘', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ‘', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ’', 'DA');
commit;
prompt 14100 records committed...
insert into HZPYDZB (HZ, PY)
values ('ﬂ÷', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('ﬂ◊', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ﬂŸ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ⁄', 'CI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ⁄', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ€', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('ﬂ€', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('ﬂ‹', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ›', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('ﬂﬁ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ﬂﬂ', 'PAI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ‡', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ·', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂ‚', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ„', 'MIE');
insert into HZPYDZB (HZ, PY)
values ('ﬂ‰', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ﬂÂ', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('ﬂÊ', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('ﬂÊ', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('ﬂÁ', 'GEN');
insert into HZPYDZB (HZ, PY)
values ('ﬂÈ', 'MA');
insert into HZPYDZB (HZ, PY)
values ('ﬂÍ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ﬂÍ', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('ﬂÎ', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('ﬂÎ', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ﬂÏ', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('ﬂÌ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ﬂÔ', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂÒ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ﬂÚ', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ﬂÚ', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂÛ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ﬂÛ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ﬂı', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('ﬂˆ', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('ﬂˆ', 'RE');
insert into HZPYDZB (HZ, PY)
values ('ﬂ˜', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('ﬂ¯', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ﬂ˙', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('ﬂ˚', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('ﬂ¸', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ﬂ˝', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('ﬂ˝', 'E');
insert into HZPYDZB (HZ, PY)
values ('‡@', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('‡@', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('‡A', 'HE');
insert into HZPYDZB (HZ, PY)
values ('‡B', 'JI');
insert into HZPYDZB (HZ, PY)
values ('‡C', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('‡D', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('‡D', 'XING');
insert into HZPYDZB (HZ, PY)
values ('‡G', 'NA');
insert into HZPYDZB (HZ, PY)
values ('‡H', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('‡J', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('‡K', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('‡L', 'LV');
insert into HZPYDZB (HZ, PY)
values ('‡M', 'FU');
insert into HZPYDZB (HZ, PY)
values ('‡N', 'WU');
insert into HZPYDZB (HZ, PY)
values ('‡O', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('‡P', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('‡Q', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('‡R', 'BO');
insert into HZPYDZB (HZ, PY)
values ('‡T', 'JU');
insert into HZPYDZB (HZ, PY)
values ('‡U', 'AO');
insert into HZPYDZB (HZ, PY)
values ('‡V', 'QI');
insert into HZPYDZB (HZ, PY)
values ('‡W', 'QING');
insert into HZPYDZB (HZ, PY)
values ('‡X', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('‡Y', 'JU');
insert into HZPYDZB (HZ, PY)
values ('‡\', 'NI');
insert into HZPYDZB (HZ, PY)
values ('‡]', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('‡`', 'JU');
insert into HZPYDZB (HZ, PY)
values ('‡d', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('‡e', 'RUO');
insert into HZPYDZB (HZ, PY)
values ('‡g', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('‡j', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('‡k', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('‡n', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('‡o', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('‡p', 'MING');
insert into HZPYDZB (HZ, PY)
values ('‡s', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('‡u', 'JU');
insert into HZPYDZB (HZ, PY)
values ('‡w', 'WU');
insert into HZPYDZB (HZ, PY)
values ('‡|', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('‡}', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('‡~', 'FU');
insert into HZPYDZB (HZ, PY)
values ('‡~', 'LU');
insert into HZPYDZB (HZ, PY)
values ('‡Ä', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('‡Ñ', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('‡à', 'BI');
insert into HZPYDZB (HZ, PY)
values ('‡ä', 'BI');
insert into HZPYDZB (HZ, PY)
values ('‡ã', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('‡ç', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('‡é', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('‡è', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('‡ê', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('‡ê', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('‡ë', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('‡ï', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('‡ñ', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('‡ó', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('‡ó', 'KUO');
commit;
prompt 14200 records committed...
insert into HZPYDZB (HZ, PY)
values ('‡ö', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('‡ü', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('‡†', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('‡°', 'YU');
insert into HZPYDZB (HZ, PY)
values ('‡¢', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('‡£', 'BO');
insert into HZPYDZB (HZ, PY)
values ('‡§', 'DING');
insert into HZPYDZB (HZ, PY)
values ('‡•', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('‡¶', 'LI');
insert into HZPYDZB (HZ, PY)
values ('‡ß', 'SHUA');
insert into HZPYDZB (HZ, PY)
values ('‡®', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('‡®', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('‡©', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('‡©', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('‡™', 'DA');
insert into HZPYDZB (HZ, PY)
values ('‡™', 'TA');
insert into HZPYDZB (HZ, PY)
values ('‡´', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('‡¨', 'LI');
insert into HZPYDZB (HZ, PY)
values ('‡≠', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('‡Æ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('‡Ø', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('‡Ø', 'YU');
insert into HZPYDZB (HZ, PY)
values ('‡∞', 'HUAI');
insert into HZPYDZB (HZ, PY)
values ('‡∞', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('‡±', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('‡≤', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('‡≤', 'SU');
insert into HZPYDZB (HZ, PY)
values ('‡≥', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('‡¥', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('‡¥', 'DI');
insert into HZPYDZB (HZ, PY)
values ('‡µ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('‡µ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('‡∂', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('‡∑', 'KU');
insert into HZPYDZB (HZ, PY)
values ('‡∏', 'WU');
insert into HZPYDZB (HZ, PY)
values ('‡π', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('‡∫', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('‡ª', 'AO');
insert into HZPYDZB (HZ, PY)
values ('‡º', 'SU');
insert into HZPYDZB (HZ, PY)
values ('‡Ω', 'DU');
insert into HZPYDZB (HZ, PY)
values ('‡æ', 'HE');
insert into HZPYDZB (HZ, PY)
values ('‡æ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('‡ø', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('‡ø', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('‡¿', 'HE');
insert into HZPYDZB (HZ, PY)
values ('‡¡', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('‡¡', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('‡¬', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('‡√', 'GE');
insert into HZPYDZB (HZ, PY)
values ('‡ƒ', 'A');
insert into HZPYDZB (HZ, PY)
values ('‡ƒ', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('‡≈', 'EN');
insert into HZPYDZB (HZ, PY)
values ('‡∆', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('‡«', 'DIA');
insert into HZPYDZB (HZ, PY)
values ('‡»', 'AI');
insert into HZPYDZB (HZ, PY)
values ('‡…', 'AI');
insert into HZPYDZB (HZ, PY)
values ('‡ ', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('‡ ', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('‡À', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('‡À', 'HEI');
insert into HZPYDZB (HZ, PY)
values ('‡Ã', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('‡Õ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('‡Œ', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('‡œ', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('‡–', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('‡—', 'PIAO');
insert into HZPYDZB (HZ, PY)
values ('‡”', 'YING');
insert into HZPYDZB (HZ, PY)
values ('‡‘', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('‡’', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('‡÷', 'DI');
insert into HZPYDZB (HZ, PY)
values ('‡÷', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('‡ÿ', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('‡Ÿ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('‡⁄', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('‡€', 'PU');
insert into HZPYDZB (HZ, PY)
values ('‡‹', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('‡›', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('‡ﬁ', 'AO');
insert into HZPYDZB (HZ, PY)
values ('‡ﬁ', 'O');
insert into HZPYDZB (HZ, PY)
values ('‡ﬂ', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('‡·', 'CENG');
insert into HZPYDZB (HZ, PY)
values ('‡·', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('‡‚', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('‡„', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('‡‰', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('‡Â', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('‡Ê', 'YI');
insert into HZPYDZB (HZ, PY)
values ('‡Á', 'SAI');
insert into HZPYDZB (HZ, PY)
values ('‡È', 'RU');
insert into HZPYDZB (HZ, PY)
values ('‡Í', 'CA');
insert into HZPYDZB (HZ, PY)
values ('‡Ì', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('‡Ó', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('‡Ô', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('‡', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('‡Ò', 'HU');
insert into HZPYDZB (HZ, PY)
values ('‡Ú', 'LING');
insert into HZPYDZB (HZ, PY)
values ('‡Ù', 'YU');
insert into HZPYDZB (HZ, PY)
values ('‡˜', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('‡¯', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('‡˘', 'ZHI');
commit;
prompt 14300 records committed...
insert into HZPYDZB (HZ, PY)
values ('‡˙', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('‡˙', 'PI');
insert into HZPYDZB (HZ, PY)
values ('‡˚', 'NU');
insert into HZPYDZB (HZ, PY)
values ('‡˚', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('‡˝', 'CE');
insert into HZPYDZB (HZ, PY)
values ('‡˛', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('·A', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('·B', 'LI');
insert into HZPYDZB (HZ, PY)
values ('·F', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('·G', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('·G', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('·I', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('·J', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('·K', 'FU');
insert into HZPYDZB (HZ, PY)
values ('·L', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('·M', 'QIA');
insert into HZPYDZB (HZ, PY)
values ('·O', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('·Q', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('·U', 'FU');
insert into HZPYDZB (HZ, PY)
values ('·V', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('·X', 'LU');
insert into HZPYDZB (HZ, PY)
values ('·Y', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('·Z', 'ANG');
insert into HZPYDZB (HZ, PY)
values ('·[', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('·]', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('·]', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('·_', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('·`', 'DU');
insert into HZPYDZB (HZ, PY)
values ('·b', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('·c', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('·f', 'KE');
insert into HZPYDZB (HZ, PY)
values ('·g', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('·h', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('·i', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('·l', 'ANG');
insert into HZPYDZB (HZ, PY)
values ('·n', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('·p', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('·q', 'OU');
insert into HZPYDZB (HZ, PY)
values ('·r', 'LI');
insert into HZPYDZB (HZ, PY)
values ('·u', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('·w', 'FA');
insert into HZPYDZB (HZ, PY)
values ('·x', 'NONG');
insert into HZPYDZB (HZ, PY)
values ('·{', 'AI');
insert into HZPYDZB (HZ, PY)
values ('·|', 'NIANG');
insert into HZPYDZB (HZ, PY)
values ('·Å', 'LING');
insert into HZPYDZB (HZ, PY)
values ('·Ç', 'MI');
insert into HZPYDZB (HZ, PY)
values ('·É', 'MI');
insert into HZPYDZB (HZ, PY)
values ('·Ñ', 'NIANG');
insert into HZPYDZB (HZ, PY)
values ('·à', 'MI');
insert into HZPYDZB (HZ, PY)
values ('·ã', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('·å', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('·ç', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('·ç', 'LI');
insert into HZPYDZB (HZ, PY)
values ('·é', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('·è', 'GA');
insert into HZPYDZB (HZ, PY)
values ('·è', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('·ì', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('·ñ', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('·ó', 'BA');
insert into HZPYDZB (HZ, PY)
values ('·ò', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('·ô', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('·ö', 'BA');
insert into HZPYDZB (HZ, PY)
values ('·ú', 'FU');
insert into HZPYDZB (HZ, PY)
values ('·ù', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('·û', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('·ü', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('·°', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('·¢', 'WO');
insert into HZPYDZB (HZ, PY)
values ('·£', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('·§', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('·•', 'FU');
insert into HZPYDZB (HZ, PY)
values ('·¶', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('·ß', 'JI');
insert into HZPYDZB (HZ, PY)
values ('·®', 'QI');
insert into HZPYDZB (HZ, PY)
values ('·©', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('·™', 'QI');
insert into HZPYDZB (HZ, PY)
values ('·´', 'QU');
insert into HZPYDZB (HZ, PY)
values ('·¨', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('·¨', 'YA');
insert into HZPYDZB (HZ, PY)
values ('·≠', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('·Æ', 'AO');
insert into HZPYDZB (HZ, PY)
values ('·Ø', 'CEN');
insert into HZPYDZB (HZ, PY)
values ('·∞', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('·±', 'BA');
insert into HZPYDZB (HZ, PY)
values ('·≤', 'HU');
insert into HZPYDZB (HZ, PY)
values ('·≥', 'KE');
insert into HZPYDZB (HZ, PY)
values ('·µ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('·∑', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('·∏', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('·π', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('·∫', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('·ª', 'YI');
insert into HZPYDZB (HZ, PY)
values ('·º', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('·º', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('·Ω', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('·Ω', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('·æ', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('·ø', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('·¿', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('·¡', 'LAI');
commit;
prompt 14400 records committed...
insert into HZPYDZB (HZ, PY)
values ('·¬', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('·ƒ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('·∆', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('·«', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('·»', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('·»', 'YU');
insert into HZPYDZB (HZ, PY)
values ('·…', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('·À', 'WAI');
insert into HZPYDZB (HZ, PY)
values ('·À', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('·Ã', 'ZAI');
insert into HZPYDZB (HZ, PY)
values ('·Õ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('·œ', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('·“', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('·‘', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('·’', 'JI');
insert into HZPYDZB (HZ, PY)
values ('·÷', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('·◊', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('·ÿ', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('·Ÿ', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('·Ÿ', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('·⁄', 'NI');
insert into HZPYDZB (HZ, PY)
values ('·€', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('·›', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('·›', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('·ﬁ', 'CU');
insert into HZPYDZB (HZ, PY)
values ('·ﬂ', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('·‡', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('··', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('·‚', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('·„', 'SI');
insert into HZPYDZB (HZ, PY)
values ('·„', 'XI');
insert into HZPYDZB (HZ, PY)
values ('·‰', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('·Â', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('·Á', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('·Ë', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('·È', 'QU');
insert into HZPYDZB (HZ, PY)
values ('·Í', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('·Ï', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('·Ì', 'AN');
insert into HZPYDZB (HZ, PY)
values ('·Ó', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('·Ô', 'MA');
insert into HZPYDZB (HZ, PY)
values ('·', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('·', 'NV');
insert into HZPYDZB (HZ, PY)
values ('·Ú', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('·Û', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('·Ù', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('·ı', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('·ˆ', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('·˜', 'SHOU');
insert into HZPYDZB (HZ, PY)
values ('·¯', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('·˘', 'BI');
insert into HZPYDZB (HZ, PY)
values ('·˙', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('·˚', 'LI');
insert into HZPYDZB (HZ, PY)
values ('‚A', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('‚D', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('‚E', 'WU');
insert into HZPYDZB (HZ, PY)
values ('‚F', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('‚F', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('‚H', 'QI');
insert into HZPYDZB (HZ, PY)
values ('‚I', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('‚K', 'DI');
insert into HZPYDZB (HZ, PY)
values ('‚L', 'SI');
insert into HZPYDZB (HZ, PY)
values ('‚O', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('‚O', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('‚P', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('‚Q', 'TU');
insert into HZPYDZB (HZ, PY)
values ('‚S', 'NV');
insert into HZPYDZB (HZ, PY)
values ('‚T', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('‚U', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('‚W', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('‚Y', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('‚Z', 'PA');
insert into HZPYDZB (HZ, PY)
values ('‚\', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('‚\', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('‚]', 'XING');
insert into HZPYDZB (HZ, PY)
values ('‚_', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('‚`', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('‚`', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('‚b', 'PI');
insert into HZPYDZB (HZ, PY)
values ('‚c', 'NA');
insert into HZPYDZB (HZ, PY)
values ('‚c', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('‚d', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('‚d', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('‚f', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('‚h', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('‚j', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('‚n', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('‚o', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('‚q', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('‚t', 'BI');
insert into HZPYDZB (HZ, PY)
values ('‚t', 'PI');
insert into HZPYDZB (HZ, PY)
values ('‚x', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('‚y', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('‚{', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('‚Ä', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('‚Å', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('‚Ç', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('‚É', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('‚Ñ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('‚Ö', 'NGAG');
commit;
prompt 14500 records committed...
insert into HZPYDZB (HZ, PY)
values ('‚Ü', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('‚ã', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('‚ç', 'PI');
insert into HZPYDZB (HZ, PY)
values ('‚é', 'KE');
insert into HZPYDZB (HZ, PY)
values ('‚ê', 'BING');
insert into HZPYDZB (HZ, PY)
values ('‚ë', 'CI');
insert into HZPYDZB (HZ, PY)
values ('‚í', 'HU');
insert into HZPYDZB (HZ, PY)
values ('‚ï', 'YU');
insert into HZPYDZB (HZ, PY)
values ('‚ñ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('‚ó', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('‚ò', 'BU');
insert into HZPYDZB (HZ, PY)
values ('‚ö', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('‚ú', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('‚ù', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('‚û', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('‚ü', 'TIE');
insert into HZPYDZB (HZ, PY)
values ('‚ü', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('‚†', 'JU');
insert into HZPYDZB (HZ, PY)
values ('‚°', 'SUAN');
insert into HZPYDZB (HZ, PY)
values ('‚¢', 'YI');
insert into HZPYDZB (HZ, PY)
values ('‚£', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('‚§', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('‚¶', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('‚ß', 'CU');
insert into HZPYDZB (HZ, PY)
values ('‚®', 'MI');
insert into HZPYDZB (HZ, PY)
values ('‚©', 'HU');
insert into HZPYDZB (HZ, PY)
values ('‚™', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('‚´', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('‚¨', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('‚Æ', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('‚∞', 'JING');
insert into HZPYDZB (HZ, PY)
values ('‚±', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('‚≤', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('‚≤', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('‚≥', 'HA');
insert into HZPYDZB (HZ, PY)
values ('‚≥', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('‚¥', 'MI');
insert into HZPYDZB (HZ, PY)
values ('‚¥', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('‚µ', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('‚∂', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('‚∑', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('‚∏', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('‚∫', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('‚∫', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('‚º', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('‚Ω', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('‚Ω', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('‚æ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('‚ø', 'REN');
insert into HZPYDZB (HZ, PY)
values ('‚¡', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('‚¡', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('‚¬', 'SI');
insert into HZPYDZB (HZ, PY)
values ('‚¬', 'YI');
insert into HZPYDZB (HZ, PY)
values ('‚√', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('‚ƒ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('‚≈', 'YU');
insert into HZPYDZB (HZ, PY)
values ('‚∆', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('‚»', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('‚…', 'MO');
insert into HZPYDZB (HZ, PY)
values ('‚À', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('‚Œ', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('‚œ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('‚œ', 'PI');
insert into HZPYDZB (HZ, PY)
values ('‚–', 'WU');
insert into HZPYDZB (HZ, PY)
values ('‚—', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('‚“', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('‚÷', 'AN');
insert into HZPYDZB (HZ, PY)
values ('‚◊', 'YU');
insert into HZPYDZB (HZ, PY)
values ('‚ÿ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('‚ÿ', 'PI');
insert into HZPYDZB (HZ, PY)
values ('‚Ÿ', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('‚⁄', 'AO');
insert into HZPYDZB (HZ, PY)
values ('‚€', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('‚‹', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('‚ﬁ', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('‚ﬁ', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('‚ﬂ', 'YING');
insert into HZPYDZB (HZ, PY)
values ('‚·', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('‚‚', 'CUN');
insert into HZPYDZB (HZ, PY)
values ('‚„', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('‚„', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('‚‰', 'WU');
insert into HZPYDZB (HZ, PY)
values ('‚Â', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('‚Ê', 'OU');
insert into HZPYDZB (HZ, PY)
values ('‚Á', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('‚Ë', 'WU');
insert into HZPYDZB (HZ, PY)
values ('‚È', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('‚È', 'QI');
insert into HZPYDZB (HZ, PY)
values ('‚Í', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('‚Î', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('‚Ï', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('‚Ï', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('‚Ì', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('‚Ó', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('‚Ô', 'HU');
insert into HZPYDZB (HZ, PY)
values ('‚', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('‚', 'XU');
insert into HZPYDZB (HZ, PY)
values ('‚Ò', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('‚Ú', 'DA');
insert into HZPYDZB (HZ, PY)
values ('‚Ú', 'DAN');
commit;
prompt 14600 records committed...
insert into HZPYDZB (HZ, PY)
values ('‚Û', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('‚ı', 'NI');
insert into HZPYDZB (HZ, PY)
values ('‚ˆ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('‚˜', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('‚¯', 'YI');
insert into HZPYDZB (HZ, PY)
values ('‚˘', 'YI');
insert into HZPYDZB (HZ, PY)
values ('‚˙', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('‚¸', 'CE');
insert into HZPYDZB (HZ, PY)
values ('‚˝', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('‚˛', 'SHUN');
insert into HZPYDZB (HZ, PY)
values ('‚˛', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('„@', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('„@', 'TIE');
insert into HZPYDZB (HZ, PY)
values ('„A', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('„B', 'TA');
insert into HZPYDZB (HZ, PY)
values ('„D', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('„E', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('„G', 'SE');
insert into HZPYDZB (HZ, PY)
values ('„H', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('„I', 'JU');
insert into HZPYDZB (HZ, PY)
values ('„I', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('„J', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('„J', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('„L', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('„P', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('„Q', 'AN');
insert into HZPYDZB (HZ, PY)
values ('„Q', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('„R', 'FU');
insert into HZPYDZB (HZ, PY)
values ('„S', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('„T', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('„T', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('„U', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('„V', 'FU');
insert into HZPYDZB (HZ, PY)
values ('„[', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('„\', 'BO');
insert into HZPYDZB (HZ, PY)
values ('„]', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('„_', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('„`', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('„a', 'MU');
insert into HZPYDZB (HZ, PY)
values ('„b', 'NI');
insert into HZPYDZB (HZ, PY)
values ('„b', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('„c', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('„e', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('„g', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('„h', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('„h', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('„j', 'SI');
insert into HZPYDZB (HZ, PY)
values ('„k', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('„l', 'KA');
insert into HZPYDZB (HZ, PY)
values ('„n', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('„r', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('„t', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('„v', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('„w', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('„w', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('„x', 'GE');
insert into HZPYDZB (HZ, PY)
values ('„x', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('„y', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('„z', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('„|', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('„}', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('„~', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('„Ä', 'MO');
insert into HZPYDZB (HZ, PY)
values ('„Å', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('„É', 'SI');
insert into HZPYDZB (HZ, PY)
values ('„É', 'YU');
insert into HZPYDZB (HZ, PY)
values ('„Ñ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('„á', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('„à', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('„â', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('„â', 'LI');
insert into HZPYDZB (HZ, PY)
values ('„ã', 'XING');
insert into HZPYDZB (HZ, PY)
values ('„å', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('„è', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('„ê', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('„ë', 'MING');
insert into HZPYDZB (HZ, PY)
values ('„í', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('„ì', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('„ì', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('„î', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('„î', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('„ó', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('„ô', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('„ö', 'JI');
insert into HZPYDZB (HZ, PY)
values ('„ù', 'MI');
insert into HZPYDZB (HZ, PY)
values ('„°', 'KE');
insert into HZPYDZB (HZ, PY)
values ('„¢', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('„£', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('„§', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('„•', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('„¶', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('„¶', 'LI');
insert into HZPYDZB (HZ, PY)
values ('„ß', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('„®', 'YI');
insert into HZPYDZB (HZ, PY)
values ('„©', 'TI');
insert into HZPYDZB (HZ, PY)
values ('„™', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('„´', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('„¨', 'XING');
insert into HZPYDZB (HZ, PY)
values ('„≠', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('„Æ', 'CHANG');
commit;
prompt 14700 records committed...
insert into HZPYDZB (HZ, PY)
values ('„Ø', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('„∞', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('„∞', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('„±', 'HU');
insert into HZPYDZB (HZ, PY)
values ('„≤', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('„≥', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('„≥', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('„¥', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('„µ', 'E');
insert into HZPYDZB (HZ, PY)
values ('„∂', 'LENG');
insert into HZPYDZB (HZ, PY)
values ('„∑', 'ZHUI');
insert into HZPYDZB (HZ, PY)
values ('„∏', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('„∏', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('„π', 'BI');
insert into HZPYDZB (HZ, PY)
values ('„∫', 'SU');
insert into HZPYDZB (HZ, PY)
values ('„ª', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('„º', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('„Ω', 'JING');
insert into HZPYDZB (HZ, PY)
values ('„æ', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('„ø', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('„ø', 'ZHUANG');
insert into HZPYDZB (HZ, PY)
values ('„¿', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('„¡', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('„¬', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('„√', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('„ƒ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('„≈', 'SHUAN');
insert into HZPYDZB (HZ, PY)
values ('„∆', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('„«', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('„»', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('„…', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('„ ', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('„À', 'TA');
insert into HZPYDZB (HZ, PY)
values ('„Ã', 'LV');
insert into HZPYDZB (HZ, PY)
values ('„Õ', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('„Œ', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('„œ', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('„œ', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('„—', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('„“', 'HE');
insert into HZPYDZB (HZ, PY)
values ('„“', 'XI');
insert into HZPYDZB (HZ, PY)
values ('„”', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('„’', 'E');
insert into HZPYDZB (HZ, PY)
values ('„◊', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('„ÿ', 'HE');
insert into HZPYDZB (HZ, PY)
values ('„Ÿ', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('„⁄', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('„€', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('„›', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('„ﬁ', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('„‡', 'QI');
insert into HZPYDZB (HZ, PY)
values ('„·', 'SI');
insert into HZPYDZB (HZ, PY)
values ('„‚', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('„„', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('„‰', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('„Â', 'MU');
insert into HZPYDZB (HZ, PY)
values ('„Ê', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('„Á', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('„Ë', 'MI');
insert into HZPYDZB (HZ, PY)
values ('„È', 'GU');
insert into HZPYDZB (HZ, PY)
values ('„Í', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('„Î', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('„Ï', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('„Ï', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('„Ì', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('„Ì', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('„Ó', 'LE');
insert into HZPYDZB (HZ, PY)
values ('„Ô', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('„Ô', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('„', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('„Ò', 'SHUANG');
insert into HZPYDZB (HZ, PY)
values ('„Ú', 'LU');
insert into HZPYDZB (HZ, PY)
values ('„Û', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('„Ù', 'SI');
insert into HZPYDZB (HZ, PY)
values ('„ı', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('„ˆ', 'LING');
insert into HZPYDZB (HZ, PY)
values ('„˜', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('„¯', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('„˘', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('„˘', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('„˚', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('„¸', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('„˝', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('„˝', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('„˛', 'JING');
insert into HZPYDZB (HZ, PY)
values ('‰@', 'AN');
insert into HZPYDZB (HZ, PY)
values ('‰D', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('‰E', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('‰F', 'SI');
insert into HZPYDZB (HZ, PY)
values ('‰G', 'NGAI');
insert into HZPYDZB (HZ, PY)
values ('‰I', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('‰J', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('‰K', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('‰K', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('‰O', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('‰O', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('‰P', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('‰R', 'TI');
insert into HZPYDZB (HZ, PY)
values ('‰S', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('‰T', 'GUA');
commit;
prompt 14800 records committed...
insert into HZPYDZB (HZ, PY)
values ('‰U', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('‰U', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('‰V', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('‰V', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('‰W', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('‰W', 'TU');
insert into HZPYDZB (HZ, PY)
values ('‰Y', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('‰\', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('‰]', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('‰^', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('‰_', 'SU');
insert into HZPYDZB (HZ, PY)
values ('‰b', 'DING');
insert into HZPYDZB (HZ, PY)
values ('‰c', 'BO');
insert into HZPYDZB (HZ, PY)
values ('‰d', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('‰e', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('‰g', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('‰g', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('‰i', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('‰k', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('‰l', 'SI');
insert into HZPYDZB (HZ, PY)
values ('‰l', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('‰m', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('‰n', 'WU');
insert into HZPYDZB (HZ, PY)
values ('‰o', 'WU');
insert into HZPYDZB (HZ, PY)
values ('‰q', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('‰r', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('‰s', 'LUE');
insert into HZPYDZB (HZ, PY)
values ('‰t', 'JING');
insert into HZPYDZB (HZ, PY)
values ('‰u', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('‰w', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('‰x', 'LUE');
insert into HZPYDZB (HZ, PY)
values ('‰z', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('‰{', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('‰|', 'JU');
insert into HZPYDZB (HZ, PY)
values ('‰Ä', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('‰Å', 'PU');
insert into HZPYDZB (HZ, PY)
values ('‰Ç', 'LI');
insert into HZPYDZB (HZ, PY)
values ('‰Ñ', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('‰Ö', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('‰ä', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('‰ã', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('‰ç', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('‰é', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('‰í', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('‰î', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('‰ï', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('‰ñ', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('‰ó', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('‰ó', 'LUN');
insert into HZPYDZB (HZ, PY)
values ('‰ò', 'KE');
insert into HZPYDZB (HZ, PY)
values ('‰ò', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('‰ô', 'LING');
insert into HZPYDZB (HZ, PY)
values ('‰õ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('‰ú', 'LI');
insert into HZPYDZB (HZ, PY)
values ('‰û', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('‰û', 'POU');
insert into HZPYDZB (HZ, PY)
values ('‰ü', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('‰†', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('‰°', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('‰¢', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('‰£', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('‰§', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('‰•', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('‰•', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('‰¶', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('‰ß', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('‰®', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('‰©', 'JI');
insert into HZPYDZB (HZ, PY)
values ('‰™', 'XU');
insert into HZPYDZB (HZ, PY)
values ('‰™', 'YI');
insert into HZPYDZB (HZ, PY)
values ('‰´', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('‰´', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('‰¨', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('‰≠', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('‰Æ', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('‰Ø', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('‰∞', 'HU');
insert into HZPYDZB (HZ, PY)
values ('‰±', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('‰≤', 'RU');
insert into HZPYDZB (HZ, PY)
values ('‰≥', 'SU');
insert into HZPYDZB (HZ, PY)
values ('‰¥', 'WU');
insert into HZPYDZB (HZ, PY)
values ('‰µ', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('‰∂', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('‰∑', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('‰∏', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('‰π', 'CEN');
insert into HZPYDZB (HZ, PY)
values ('‰∫', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('‰∫', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('‰ª', 'XI');
insert into HZPYDZB (HZ, PY)
values ('‰º', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('‰æ', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('‰ø', 'QI');
insert into HZPYDZB (HZ, PY)
values ('‰¿', 'XI');
insert into HZPYDZB (HZ, PY)
values ('‰¡', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('‰¬', 'DU');
insert into HZPYDZB (HZ, PY)
values ('‰√', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('‰ƒ', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('‰ƒ', 'PI');
insert into HZPYDZB (HZ, PY)
values ('‰≈', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('‰∆', 'GAN');
commit;
prompt 14900 records committed...
insert into HZPYDZB (HZ, PY)
values ('‰∆', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('‰«', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('‰»', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('‰»', 'SHUANG');
insert into HZPYDZB (HZ, PY)
values ('‰…', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('‰ ', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('‰À', 'LU');
insert into HZPYDZB (HZ, PY)
values ('‰Ã', 'SHUA');
insert into HZPYDZB (HZ, PY)
values ('‰Ã', 'SHUAN');
insert into HZPYDZB (HZ, PY)
values ('‰Õ', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('‰Œ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('‰œ', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('‰–', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('‰—', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('‰—', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('‰“', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('‰“', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('‰”', 'XU');
insert into HZPYDZB (HZ, PY)
values ('‰‘', 'PEN');
insert into HZPYDZB (HZ, PY)
values ('‰’', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('‰÷', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('‰◊', 'WO');
insert into HZPYDZB (HZ, PY)
values ('‰ÿ', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('‰Ÿ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('‰⁄', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('‰⁄', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('‰€', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('‰€', 'KE');
insert into HZPYDZB (HZ, PY)
values ('‰‹', 'NI');
insert into HZPYDZB (HZ, PY)
values ('‰›', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('‰ﬁ', 'YING');
insert into HZPYDZB (HZ, PY)
values ('‰ﬂ', 'PU');
insert into HZPYDZB (HZ, PY)
values ('‰‡', 'LI');
insert into HZPYDZB (HZ, PY)
values ('‰‚', 'TA');
insert into HZPYDZB (HZ, PY)
values ('‰„', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('‰‰', 'BI');
insert into HZPYDZB (HZ, PY)
values ('‰Â', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('‰Â', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('‰Ê', 'FU');
insert into HZPYDZB (HZ, PY)
values ('‰Á', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('‰Ë', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('‰Ë', 'PENG');
insert into HZPYDZB (HZ, PY)
values ('‰È', 'MI');
insert into HZPYDZB (HZ, PY)
values ('‰È', 'MING');
insert into HZPYDZB (HZ, PY)
values ('‰Í', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('‰Í', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('‰Î', 'YING');
insert into HZPYDZB (HZ, PY)
values ('‰Ï', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('‰Ì', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('‰Ó', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('‰Ô', 'HU');
insert into HZPYDZB (HZ, PY)
values ('‰', 'TA');
insert into HZPYDZB (HZ, PY)
values ('‰Ò', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('‰Ú', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('‰Ù', 'YI');
insert into HZPYDZB (HZ, PY)
values ('‰ı', 'LU');
insert into HZPYDZB (HZ, PY)
values ('‰ˆ', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('‰˜', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('‰˜', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('‰¯', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('‰¯', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('‰˘', 'SI');
insert into HZPYDZB (HZ, PY)
values ('‰˙', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('‰˚', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('‰¸', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('‰˝', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('‰˛', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('ÂA', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('ÂC', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('ÂD', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ÂG', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('ÂG', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ÂH', 'A');
insert into HZPYDZB (HZ, PY)
values ('ÂH', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ÂI', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('ÂK', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('ÂK', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('ÂM', 'NEI');
insert into HZPYDZB (HZ, PY)
values ('ÂM', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ÂP', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('ÂR', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ÂT', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('ÂV', 'DING');
insert into HZPYDZB (HZ, PY)
values ('ÂY', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('Â\', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Â]', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('Â^', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('Â_', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('Âa', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Âc', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('Âc', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Âe', 'CU');
insert into HZPYDZB (HZ, PY)
values ('Âe', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('Âf', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('Âg', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Âh', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Âh', 'LV');
insert into HZPYDZB (HZ, PY)
values ('Âi', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('Âj', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Âl', 'BIAO');
commit;
prompt 15000 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ân', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('Âo', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('Âq', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Âr', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('Ât', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Âx', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('Ây', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('Âz', 'FA');
insert into HZPYDZB (HZ, PY)
values ('Â|', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Â|', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('Â~', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ÂÄ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ÂÉ', 'DU');
insert into HZPYDZB (HZ, PY)
values ('Âá', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Âà', 'ROU');
insert into HZPYDZB (HZ, PY)
values ('Ââ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Âå', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('Âç', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Âé', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('Âè', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Âî', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('Âï', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('Âñ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('Âö', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('Âõ', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('Âù', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('Âü', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('Â°', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('Â¢', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Â£', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('Â£', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Â§', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Â§', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('Â¶', 'RU');
insert into HZPYDZB (HZ, PY)
values ('Âß', 'PU');
insert into HZPYDZB (HZ, PY)
values ('Â®', 'PI');
insert into HZPYDZB (HZ, PY)
values ('Â©', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('Â™', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('Â´', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Â≠', 'YING');
insert into HZPYDZB (HZ, PY)
values ('ÂØ', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('Â∞', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('Â±', 'BA');
insert into HZPYDZB (HZ, PY)
values ('Â≤', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('Â≥', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('Â¥', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('Âµ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Âµ', 'MI');
insert into HZPYDZB (HZ, PY)
values ('Â∑', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('Âπ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('Â∫', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('Âª', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Âº', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('Âæ', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('Âæ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('Â¡', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('Â¬', 'YA');
insert into HZPYDZB (HZ, PY)
values ('Â√', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Âƒ', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('Â∆', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Â∆', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Â«', 'ER');
insert into HZPYDZB (HZ, PY)
values ('Â»', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Â»', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('Â…', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Â ', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('ÂÀ', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('ÂÃ', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('ÂÃ', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('ÂÕ', 'BU');
insert into HZPYDZB (HZ, PY)
values ('ÂŒ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Âœ', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('Â–', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('Â—', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Â“', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('Â“', 'XUN');
insert into HZPYDZB (HZ, PY)
values ('Â”', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Â‘', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Â’', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('Â÷', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('Â◊', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('Âÿ', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('Â⁄', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('Â€', 'AO');
insert into HZPYDZB (HZ, PY)
values ('Â‹', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('Â›', 'TA');
insert into HZPYDZB (HZ, PY)
values ('Â‡', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Â·', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Â‚', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('Â„', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('Â‰', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ÂÂ', 'LA');
insert into HZPYDZB (HZ, PY)
values ('ÂÁ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ÂË', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('ÂÍ', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('ÂÎ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÂÏ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÂÌ', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÂÓ', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ÂÔ', 'XI');
commit;
prompt 15100 records committed...
insert into HZPYDZB (HZ, PY)
values ('Â', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ÂÒ', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ÂÚ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ÂÛ', 'NU');
insert into HZPYDZB (HZ, PY)
values ('ÂÙ', 'MI');
insert into HZPYDZB (HZ, PY)
values ('Âˆ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Â˜', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Â¯', 'CHE');
insert into HZPYDZB (HZ, PY)
values ('Â˘', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('Â˙', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Â˚', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('Â¸', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Â˝', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('Â˛', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ÊD', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ÊJ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ÊJ', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('ÊN', 'DU');
insert into HZPYDZB (HZ, PY)
values ('ÊN', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ÊO', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ÊQ', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('ÊR', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('ÊV', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('Ê[', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('Ê\', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('Ê]', 'DA');
insert into HZPYDZB (HZ, PY)
values ('Ê]', 'TA');
insert into HZPYDZB (HZ, PY)
values ('Ê^', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('Ê`', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('Êa', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('Êc', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('Êd', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Êe', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('Êe', 'NOU');
insert into HZPYDZB (HZ, PY)
values ('Êg', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('Êi', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('Êk', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Êk', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ên', 'BO');
insert into HZPYDZB (HZ, PY)
values ('Êo', 'PAN');
insert into HZPYDZB (HZ, PY)
values ('Êp', 'SA');
insert into HZPYDZB (HZ, PY)
values ('Êq', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Êq', 'PI');
insert into HZPYDZB (HZ, PY)
values ('Êu', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Êv', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('Êw', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('Êy', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Êz', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('Ê}', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('ÊÇ', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ÊÇ', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ÊÉ', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('Êá', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('Êâ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Êä', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Êã', 'MA');
insert into HZPYDZB (HZ, PY)
values ('Êå', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('Êç', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('Êë', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('Êí', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Êì', 'NA');
insert into HZPYDZB (HZ, PY)
values ('Êî', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Êñ', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('Êñ', 'OU');
insert into HZPYDZB (HZ, PY)
values ('Êó', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('Êü', 'MO');
insert into HZPYDZB (HZ, PY)
values ('Ê†', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('Ê°', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ê°', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('Ê£', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('Ê§', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('Ê§', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('Ê•', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Ê¶', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Êß', 'DA');
insert into HZPYDZB (HZ, PY)
values ('Ê®', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('Ê®', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('Ê©', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('Ê™', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('Ê´', 'YA');
insert into HZPYDZB (HZ, PY)
values ('Ê¨', 'RAO');
insert into HZPYDZB (HZ, PY)
values ('Ê¨', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('Ê≠', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ÊÆ', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('ÊØ', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('ÊØ', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('Ê∞', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('Ê±', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('Ê≤', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ê≥', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('Ê≥', 'PING');
insert into HZPYDZB (HZ, PY)
values ('Ê¥', 'WA');
insert into HZPYDZB (HZ, PY)
values ('Êµ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('Ê∂', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('Ê∑', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Ê∏', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Êπ', 'E');
insert into HZPYDZB (HZ, PY)
values ('Ê∫', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Êª', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Êº', 'JIE');
commit;
prompt 15200 records committed...
insert into HZPYDZB (HZ, PY)
values ('Êº', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('ÊΩ', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('Êæ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Êø', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Ê¿', 'NU');
insert into HZPYDZB (HZ, PY)
values ('Ê¡', 'AO');
insert into HZPYDZB (HZ, PY)
values ('Ê¬', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('Ê√', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Êƒ', 'MU');
insert into HZPYDZB (HZ, PY)
values ('Êƒ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Ê≈', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('Ê∆', 'MO');
insert into HZPYDZB (HZ, PY)
values ('Ê«', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Ê«', 'PI');
insert into HZPYDZB (HZ, PY)
values ('Ê»', 'AI');
insert into HZPYDZB (HZ, PY)
values ('Ê…', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('Ê ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ÊÀ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ÊÃ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('ÊÕ', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('ÊŒ', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ÊŒ', 'PIAO');
insert into HZPYDZB (HZ, PY)
values ('Êœ', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('Ê–', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('Ê—', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('Ê“', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Ê”', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Ê‘', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Ê’', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('Ê◊', 'SHUANG');
insert into HZPYDZB (HZ, PY)
values ('ÊŸ', 'GA');
insert into HZPYDZB (HZ, PY)
values ('Ê⁄', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Ê›', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Êﬁ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Êﬂ', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Ê‡', 'ZU');
insert into HZPYDZB (HZ, PY)
values ('Ê·', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Ê‚', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Ê„', 'ZOU');
insert into HZPYDZB (HZ, PY)
values ('Ê‰', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÊÂ', 'NU');
insert into HZPYDZB (HZ, PY)
values ('ÊÊ', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('ÊÁ', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('ÊË', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ÊÈ', 'PIAN');
insert into HZPYDZB (HZ, PY)
values ('ÊÍ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ÊÍ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ÊÎ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ÊÏ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ÊÓ', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('Ê', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ÊÒ', 'AO');
insert into HZPYDZB (HZ, PY)
values ('ÊÒ', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ÊÚ', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('ÊÛ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ÊÙ', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ÊÙ', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('Êı', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('Ê˜', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ê¯', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('Ê˙', 'OU');
insert into HZPYDZB (HZ, PY)
values ('Ê˙', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Ê˚', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('Ê¸', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Ê˝', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Ê˛', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('ÁG', 'AO');
insert into HZPYDZB (HZ, PY)
values ('ÁG', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ÁH', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('ÁN', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('ÁO', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('ÁP', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ÁQ', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('ÁR', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ÁS', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ÁU', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('ÁU', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ÁW', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ÁX', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('Á\', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Á_', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('Áe', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Áf', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('Ál', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Áq', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Ár', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Ás', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Át', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('Áu', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('Áx', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ÁÇ', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ÁÑ', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ÁÖ', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('ÁÖ', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('Áà', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Áä', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('Áé', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('Áê', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('Áê', 'NOU');
insert into HZPYDZB (HZ, PY)
values ('Áë', 'TI');
commit;
prompt 15300 records committed...
insert into HZPYDZB (HZ, PY)
values ('Áì', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('Áó', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('Áò', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('Áú', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Áù', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('Á°', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('Á¢', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Á¢', 'PI');
insert into HZPYDZB (HZ, PY)
values ('Á£', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('Á§', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('Á¶', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Áß', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('Á®', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Á®', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Á©', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('Á™', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('Á´', 'KU');
insert into HZPYDZB (HZ, PY)
values ('Á¨', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('Á≠', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ÁÆ', 'BING');
insert into HZPYDZB (HZ, PY)
values ('ÁÆ', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('ÁØ', 'SHAO');
insert into HZPYDZB (HZ, PY)
values ('ÁØ', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('Á∞', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Á±', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Á≤', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Á≤', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Á≥', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Á¥', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('Áµ', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('Áµ', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('Á∂', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('Á∑', 'SHOU');
insert into HZPYDZB (HZ, PY)
values ('Á∏', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Áπ', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('Á∫', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Áª', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('Áº', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ÁΩ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('Áæ', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Áø', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('Á¿', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Á¡', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Á¬', 'PIAN');
insert into HZPYDZB (HZ, PY)
values ('Á√', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('Á≈', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('Á∆', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Á«', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('Á«', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Á…', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('Á ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ÁÀ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÁÃ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ÁÕ', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('ÁŒ', 'PIAO');
insert into HZPYDZB (HZ, PY)
values ('Áœ', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('Á–', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('Á—', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('Á‘', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('Á‘', 'RAO');
insert into HZPYDZB (HZ, PY)
values ('Á’', 'CENG');
insert into HZPYDZB (HZ, PY)
values ('Á’', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('Á÷', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Áÿ', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('Áÿ', 'SAO');
insert into HZPYDZB (HZ, PY)
values ('ÁŸ', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('Á⁄', 'ZUAN');
insert into HZPYDZB (HZ, PY)
values ('Á€', 'MI');
insert into HZPYDZB (HZ, PY)
values ('Á€', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('Á›', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('Á›', 'SHUN');
insert into HZPYDZB (HZ, PY)
values ('Áﬁ', 'ZAI');
insert into HZPYDZB (HZ, PY)
values ('Áﬁ', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('Á‡', 'DING');
insert into HZPYDZB (HZ, PY)
values ('Á·', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Á‚', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Á„', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('Á„', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('Á‰', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('ÁÂ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ÁÊ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ÁÁ', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('ÁË', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('ÁÈ', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('ÁÍ', 'PO');
insert into HZPYDZB (HZ, PY)
values ('ÁÎ', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('ÁÏ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ÁÏ', 'KA');
insert into HZPYDZB (HZ, PY)
values ('ÁÌ', 'ER');
insert into HZPYDZB (HZ, PY)
values ('ÁÓ', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('ÁÔ', 'XU');
insert into HZPYDZB (HZ, PY)
values ('ÁÒ', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('ÁÒ', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('ÁÚ', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('ÁÛ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ÁÛ', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ÁÙ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Áı', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Áı', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('Áˆ', 'LIAN');
commit;
prompt 15400 records committed...
insert into HZPYDZB (HZ, PY)
values ('Á˜', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Á¯', 'YING');
insert into HZPYDZB (HZ, PY)
values ('Á˘', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Á˙', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Á˚', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('Á¸', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('Á˝', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('Á˛', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ËA', 'CAO');
insert into HZPYDZB (HZ, PY)
values ('ËD', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('ËF', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ËK', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ËK', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ËL', 'JU');
insert into HZPYDZB (HZ, PY)
values ('ËM', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('ËM', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('ËN', 'DA');
insert into HZPYDZB (HZ, PY)
values ('ËU', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('ËW', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ËX', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ËX', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ËY', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ËZ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('Ë\', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('Ë^', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Ë_', 'NING');
insert into HZPYDZB (HZ, PY)
values ('Ëf', 'MIE');
insert into HZPYDZB (HZ, PY)
values ('Ëg', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ëh', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('Ëi', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ëk', 'KUANG');
insert into HZPYDZB (HZ, PY)
values ('Ën', 'LA');
insert into HZPYDZB (HZ, PY)
values ('Ëp', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ëq', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('Ër', 'LV');
insert into HZPYDZB (HZ, PY)
values ('Ës', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Ëu', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Ëw', 'KUAN');
insert into HZPYDZB (HZ, PY)
values ('Ëx', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('Ëy', 'E');
insert into HZPYDZB (HZ, PY)
values ('Ëz', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Ë|', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ËÅ', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ËÇ', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('ËÖ', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('ËÜ', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('Ëá', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('Ëà', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('Ëâ', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('Ëê', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('Ëë', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ëî', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('Ëó', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ëó', 'XING');
insert into HZPYDZB (HZ, PY)
values ('Ëò', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Ëò', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('Ëö', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('Ëú', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Ëù', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('Ëû', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Ëü', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Ë†', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('Ë°', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('Ë¢', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Ë£', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('Ë£', 'Q');
insert into HZPYDZB (HZ, PY)
values ('Ë§', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Ë•', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('Ë¶', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('Ëß', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('Ë®', 'AI');
insert into HZPYDZB (HZ, PY)
values ('Ë©', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ë™', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ë´', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('Ë¨', 'YING');
insert into HZPYDZB (HZ, PY)
values ('Ë≠', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('ËÆ', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('ËØ', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('Ë∞', 'ZHANG');
insert into HZPYDZB (HZ, PY)
values ('Ë±', 'PU');
insert into HZPYDZB (HZ, PY)
values ('Ë≤', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('Ë¥', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Ëµ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Ë∏', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Ëπ', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Ëπ', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('Ë∫', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ëª', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Ëª', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Ëº', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ËΩ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Ëæ', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('Ëø', 'MA');
insert into HZPYDZB (HZ, PY)
values ('Ë¿', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ë¡', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Ë¡', 'PI');
insert into HZPYDZB (HZ, PY)
values ('Ë¬', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('Ë√', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('Ëƒ', 'NEN');
insert into HZPYDZB (HZ, PY)
values ('Ëƒ', 'RUI');
commit;
prompt 15500 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ë≈', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ë∆', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('Ë«', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('Ë»', 'CONG');
insert into HZPYDZB (HZ, PY)
values ('Ë»', 'ZONG');
insert into HZPYDZB (HZ, PY)
values ('Ë…', 'XIAO');
insert into HZPYDZB (HZ, PY)
values ('ËÀ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('ËÀ', 'PA');
insert into HZPYDZB (HZ, PY)
values ('ËÃ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ËÃ', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('ËÕ', 'NAI');
insert into HZPYDZB (HZ, PY)
values ('ËŒ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Ëœ', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('Ë–', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('Ë—', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('Ë“', 'PING');
insert into HZPYDZB (HZ, PY)
values ('Ë”', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Ë‘', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ë‘', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('Ë÷', 'YOU');
insert into HZPYDZB (HZ, PY)
values ('Ë◊', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Ëÿ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ËŸ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Ë⁄', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Ë€', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('Ë‹', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Ë›', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ë›', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('Ëﬁ', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('Ëﬁ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Ëﬂ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('Ëﬂ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ë‡', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('Ë·', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('Ë‚', 'YA');
insert into HZPYDZB (HZ, PY)
values ('Ë„', 'RAO');
insert into HZPYDZB (HZ, PY)
values ('Ë‰', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ËÂ', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('ËÊ', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('ËÊ', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('ËÁ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ËË', 'TING');
insert into HZPYDZB (HZ, PY)
values ('ËÈ', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('ËÍ', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ËÎ', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ËÏ', 'HANG');
insert into HZPYDZB (HZ, PY)
values ('ËÏ', 'HENG');
insert into HZPYDZB (HZ, PY)
values ('ËÌ', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('ËÌ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ËÓ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ËÔ', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('Ë', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ËÒ', 'AN');
insert into HZPYDZB (HZ, PY)
values ('ËÚ', 'XU');
insert into HZPYDZB (HZ, PY)
values ('ËÚ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ËÛ', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('ËÙ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Ëı', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Ëˆ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ë˜', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('Ë¯', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('Ë˘', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Ë˙', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('Ë˙', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Ë˚', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('Ë¸', 'DU');
insert into HZPYDZB (HZ, PY)
values ('Ë˛', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('È@', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÈB', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('ÈC', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('ÈD', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ÈF', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('ÈG', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('ÈI', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ÈN', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('ÈP', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('ÈQ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ÈR', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('ÈS', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ÈS', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ÈT', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('ÈU', 'MA');
insert into HZPYDZB (HZ, PY)
values ('ÈV', 'SHUAN');
insert into HZPYDZB (HZ, PY)
values ('ÈW', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ÈX', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('È\', 'BI');
insert into HZPYDZB (HZ, PY)
values ('È\', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('È^', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('È_', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('Èc', 'RUN');
insert into HZPYDZB (HZ, PY)
values ('Èe', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('Èl', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('Èp', 'E');
insert into HZPYDZB (HZ, PY)
values ('Èt', 'RUN');
insert into HZPYDZB (HZ, PY)
values ('Èu', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Èw', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Èx', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Èz', 'CHU');
insert into HZPYDZB (HZ, PY)
values ('È{', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('È}', 'MIN');
commit;
prompt 15600 records committed...
insert into HZPYDZB (HZ, PY)
values ('ÈÄ', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('ÈÅ', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('ÈÅ', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('ÈÇ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('ÈÉ', 'TING');
insert into HZPYDZB (HZ, PY)
values ('ÈÖ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Èà', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Èä', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Èç', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('Èó', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('Èó', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('È†', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('È†', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('È°', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('È¢', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('È§', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('È•', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('È¶', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Èß', 'JU');
insert into HZPYDZB (HZ, PY)
values ('È®', 'COU');
insert into HZPYDZB (HZ, PY)
values ('È©', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('È©', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('È™', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('È´', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('È´', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('È≠', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ÈÆ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÈØ', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('È∞', 'JU');
insert into HZPYDZB (HZ, PY)
values ('È±', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('È≤', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('È≥', 'CHUI');
insert into HZPYDZB (HZ, PY)
values ('È≥', 'ZHUI');
insert into HZPYDZB (HZ, PY)
values ('È¥', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('Èµ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('È∂', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('È∑', 'JU');
insert into HZPYDZB (HZ, PY)
values ('È∏', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('Èπ', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('È∫', 'YING');
insert into HZPYDZB (HZ, PY)
values ('Èª', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Èº', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ÈΩ', 'TA');
insert into HZPYDZB (HZ, PY)
values ('Èæ', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('Èø', 'XIE');
insert into HZPYDZB (HZ, PY)
values ('È¿', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('È¡', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('È¬', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('È¬', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('Èƒ', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('Èƒ', 'BING');
insert into HZPYDZB (HZ, PY)
values ('È≈', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('È»', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('È»', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('È…', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('È ', 'SE');
insert into HZPYDZB (HZ, PY)
values ('ÈÃ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ÈÃ', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ÈŒ', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Èœ', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('È—', 'JING');
insert into HZPYDZB (HZ, PY)
values ('È“', 'DU');
insert into HZPYDZB (HZ, PY)
values ('È“', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('È”', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('È‘', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('È’', 'QIN');
insert into HZPYDZB (HZ, PY)
values ('È÷', 'LU');
insert into HZPYDZB (HZ, PY)
values ('È◊', 'ZUN');
insert into HZPYDZB (HZ, PY)
values ('Èÿ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ÈŸ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('È€', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('È‹', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('È›', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Èﬁ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Èﬁ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('Èﬂ', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('È·', 'AO');
insert into HZPYDZB (HZ, PY)
values ('È‚', 'MO');
insert into HZPYDZB (HZ, PY)
values ('È‚', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('È„', 'CU');
insert into HZPYDZB (HZ, PY)
values ('È‰', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('ÈÂ', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('ÈÊ', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('ÈÁ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ÈË', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ÈÈ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ÈÎ', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('ÈÌ', 'REN');
insert into HZPYDZB (HZ, PY)
values ('ÈÓ', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÈÔ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('È', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ÈÒ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ÈÚ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÈÛ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÈÙ', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Èı', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Èˆ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('È˜', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('È¯', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('È˘', 'ZHI');
commit;
prompt 15700 records committed...
insert into HZPYDZB (HZ, PY)
values ('È˙', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('È˙', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('È¸', 'ZHE');
insert into HZPYDZB (HZ, PY)
values ('È˝', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('È˛', 'WANG');
insert into HZPYDZB (HZ, PY)
values ('ÍE', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ÍG', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('ÍH', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ÍI', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('ÍJ', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ÍJ', 'CHUANG');
insert into HZPYDZB (HZ, PY)
values ('ÍN', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('ÍO', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('ÍR', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('ÍU', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ÍX', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('Í\', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Í\', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Í]', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('Í^', 'DU');
insert into HZPYDZB (HZ, PY)
values ('Í_', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Ía', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('Íb', 'LE');
insert into HZPYDZB (HZ, PY)
values ('Íd', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('Íe', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Íe', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Íg', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('Íh', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('Íi', 'AI');
insert into HZPYDZB (HZ, PY)
values ('Íi', 'E');
insert into HZPYDZB (HZ, PY)
values ('Íj', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('Ík', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('Íl', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('Ím', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('Ín', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Íp', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('Íq', 'AI');
insert into HZPYDZB (HZ, PY)
values ('Íq', 'E');
insert into HZPYDZB (HZ, PY)
values ('Ír', 'QU');
insert into HZPYDZB (HZ, PY)
values ('Ít', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Íu', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Íu', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Ív', 'BING');
insert into HZPYDZB (HZ, PY)
values ('Íw', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('Íx', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('Íy', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('Íy', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('Í{', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('Í}', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('Í~', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('ÍÄ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ÍÅ', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('ÍÇ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ÍÇ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ÍÑ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ÍÜ', 'BU');
insert into HZPYDZB (HZ, PY)
values ('Íá', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Íâ', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('Íä', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Íä', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('Íå', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('Íé', 'AN');
insert into HZPYDZB (HZ, PY)
values ('Íè', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Íê', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('Íë', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Íï', 'DU');
insert into HZPYDZB (HZ, PY)
values ('Íï', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Íñ', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('Íó', 'ER');
insert into HZPYDZB (HZ, PY)
values ('Íô', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('Íõ', 'AN');
insert into HZPYDZB (HZ, PY)
values ('Íú', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('Íù', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Í†', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('Í°', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('Í£', 'COU');
insert into HZPYDZB (HZ, PY)
values ('Í§', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Í•', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Íß', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Í®', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('Í©', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Í™', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Í´', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Í¨', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('Í¨', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Í≠', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('ÍÆ', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('Í∞', 'CANG');
insert into HZPYDZB (HZ, PY)
values ('Í∞', 'ZANG');
insert into HZPYDZB (HZ, PY)
values ('Í±', 'OU');
insert into HZPYDZB (HZ, PY)
values ('Í≤', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Í≥', 'BU');
insert into HZPYDZB (HZ, PY)
values ('Í¥', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('Í∑', 'PO');
insert into HZPYDZB (HZ, PY)
values ('Í∑', 'PU');
insert into HZPYDZB (HZ, PY)
values ('Í∏', 'GA');
insert into HZPYDZB (HZ, PY)
values ('Í∏', 'XU');
insert into HZPYDZB (HZ, PY)
values ('Íπ', 'LA');
insert into HZPYDZB (HZ, PY)
values ('Í∫', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('Í∫', 'HAN');
commit;
prompt 15800 records committed...
insert into HZPYDZB (HZ, PY)
values ('Íª', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('Íº', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Íº', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ÍΩ', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('Íæ', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('Íø', 'XIN');
insert into HZPYDZB (HZ, PY)
values ('Í¿', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('Í¡', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('Í¬', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Íƒ', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('Í≈', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Í∆', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('Í«', 'NI');
insert into HZPYDZB (HZ, PY)
values ('Í«', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Í»', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Í ', 'YE');
insert into HZPYDZB (HZ, PY)
values ('ÍÀ', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('ÍÃ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('ÍÕ', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ÍŒ', 'BU');
insert into HZPYDZB (HZ, PY)
values ('Íœ', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Í–', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('Í—', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('Í“', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Í”', 'AI');
insert into HZPYDZB (HZ, PY)
values ('Í‘', 'MING');
insert into HZPYDZB (HZ, PY)
values ('Í’', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('Í◊', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('Íÿ', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ÍŸ', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('Í⁄', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('Í›', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Íﬁ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Í‡', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('Í·', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Í‚', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Í„', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('Í‰', 'QIU');
insert into HZPYDZB (HZ, PY)
values ('ÍÂ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÍÊ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ÍÊ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('ÍÁ', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ÍË', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('ÍÎ', 'DI');
insert into HZPYDZB (HZ, PY)
values ('ÍÎ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÍÓ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('ÍÔ', 'QU');
insert into HZPYDZB (HZ, PY)
values ('Í', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ÍÒ', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ÍÚ', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('ÍÛ', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('ÍÙ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Íı', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Íˆ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Í˜', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Í˜', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Í¯', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Í˘', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Í˘', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('Í˙', 'PIAN');
insert into HZPYDZB (HZ, PY)
values ('Í˚', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('Í¸', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('Í˝', 'SA');
insert into HZPYDZB (HZ, PY)
values ('Í˝', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('Í˛', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('Î@', 'AN');
insert into HZPYDZB (HZ, PY)
values ('ÎA', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ÎB', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ÎB', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('ÎE', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('ÎF', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ÎG', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ÎJ', 'AO');
insert into HZPYDZB (HZ, PY)
values ('ÎL', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('ÎO', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ÎP', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('ÎQ', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('ÎS', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('ÎW', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ÎX', 'ER');
insert into HZPYDZB (HZ, PY)
values ('Î[', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('Î]', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('Îa', 'QUE');
insert into HZPYDZB (HZ, PY)
values ('Îb', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('Îb', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Îe', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Îf', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('Îg', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('Îh', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('Îh', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('Îi', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Îl', 'CHOU');
insert into HZPYDZB (HZ, PY)
values ('Îm', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('În', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Îo', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Îp', 'SHUANG');
insert into HZPYDZB (HZ, PY)
values ('Îq', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('Îq', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('Îr', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Îu', 'JI');
commit;
prompt 15900 records committed...
insert into HZPYDZB (HZ, PY)
values ('Îv', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('Îv', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('Îw', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Îx', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Îx', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Îy', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('Îy', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('Î|', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Î}', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Î~', 'NA');
insert into HZPYDZB (HZ, PY)
values ('ÎÄ', 'FOU');
insert into HZPYDZB (HZ, PY)
values ('ÎÑ', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('ÎÑ', 'PANG');
insert into HZPYDZB (HZ, PY)
values ('ÎÖ', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('ÎÜ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Îâ', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('Îâ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Îã', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('Îå', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Îé', 'MU');
insert into HZPYDZB (HZ, PY)
values ('Îë', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Îî', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('Îï', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('Îñ', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('Îó', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Îô', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Îú', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Îù', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Îü', 'HONG');
insert into HZPYDZB (HZ, PY)
values ('Î°', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Î¢', 'BO');
insert into HZPYDZB (HZ, PY)
values ('Î£', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('Î•', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('Î¶', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Î©', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('ÎÆ', 'DAO');
insert into HZPYDZB (HZ, PY)
values ('ÎØ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('Î∞', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('Î±', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('Î≤', 'YA');
insert into HZPYDZB (HZ, PY)
values ('Î¥', 'KE');
insert into HZPYDZB (HZ, PY)
values ('Îµ', 'YUN');
insert into HZPYDZB (HZ, PY)
values ('Î∑', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Î∑', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('Î∏', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('Î∏', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('Îπ', 'DU');
insert into HZPYDZB (HZ, PY)
values ('Î∫', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('Îº', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('ÎΩ', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('Îæ', 'YUE');
insert into HZPYDZB (HZ, PY)
values ('Îø', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Î¿', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('Î¿', 'RONG');
insert into HZPYDZB (HZ, PY)
values ('Î¬', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Î√', 'RUAN');
insert into HZPYDZB (HZ, PY)
values ('Î√', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Îƒ', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('Î≈', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('Î∆', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('Î∆', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('Î«', 'NV');
insert into HZPYDZB (HZ, PY)
values ('Î»', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('Î…', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('Î ', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('ÎÀ', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('ÎÃ', 'KA');
insert into HZPYDZB (HZ, PY)
values ('ÎÕ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ÎŒ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Îœ', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('Îœ', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('Î–', 'ZHOU');
insert into HZPYDZB (HZ, PY)
values ('Î—', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('Î“', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Î“', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('Î”', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Î”', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('Î‘', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('Î‘', 'QU');
insert into HZPYDZB (HZ, PY)
values ('Î’', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Î÷', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Î÷', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('Î◊', 'GUANG');
insert into HZPYDZB (HZ, PY)
values ('ÎŸ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('Î⁄', 'KUAI');
insert into HZPYDZB (HZ, PY)
values ('Î‹', 'GAI');
insert into HZPYDZB (HZ, PY)
values ('Î‹', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('Îﬁ', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Îﬂ', 'MI');
insert into HZPYDZB (HZ, PY)
values ('Î‡', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('Î‡', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('Î·', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('Î‚', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('Î‚', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('Î‰', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('Î‰', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÎÂ', 'NIAO');
insert into HZPYDZB (HZ, PY)
values ('ÎÊ', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ÎÁ', 'A');
insert into HZPYDZB (HZ, PY)
values ('ÎË', 'FEI');
commit;
prompt 16000 records committed...
insert into HZPYDZB (HZ, PY)
values ('ÎÈ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ÎÍ', 'ZONG');
insert into HZPYDZB (HZ, PY)
values ('ÎÎ', 'DING');
insert into HZPYDZB (HZ, PY)
values ('ÎÏ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('ÎÏ', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('ÎÌ', 'COU');
insert into HZPYDZB (HZ, PY)
values ('ÎÓ', 'NAN');
insert into HZPYDZB (HZ, PY)
values ('ÎÔ', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('Î', 'WA');
insert into HZPYDZB (HZ, PY)
values ('ÎÒ', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÎÛ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ÎÙ', 'YING');
insert into HZPYDZB (HZ, PY)
values ('Îı', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Îˆ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('Î˜', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('Î¯', 'TENG');
insert into HZPYDZB (HZ, PY)
values ('Î˙', 'CHUAI');
insert into HZPYDZB (HZ, PY)
values ('Î˚', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Î¸', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('Î¸', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('Î˝', 'SAO');
insert into HZPYDZB (HZ, PY)
values ('Î˛', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('Ï@', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('ÏA', 'MAI');
insert into HZPYDZB (HZ, PY)
values ('ÏD', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ÏE', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('ÏF', 'WU');
insert into HZPYDZB (HZ, PY)
values ('ÏG', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ÏN', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('ÏO', 'DAI');
insert into HZPYDZB (HZ, PY)
values ('ÏS', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ÏV', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÏW', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('ÏW', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ÏX', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ÏY', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('ÏZ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ï\', 'AI');
insert into HZPYDZB (HZ, PY)
values ('Ï_', 'LING');
insert into HZPYDZB (HZ, PY)
values ('Ï_', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('Ïb', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('Ïc', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ïd', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Ïe', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Ïf', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Ïi', 'QING');
insert into HZPYDZB (HZ, PY)
values ('Ïk', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Ïl', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('Ïn', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Ïn', 'LIANG');
insert into HZPYDZB (HZ, PY)
values ('Ïo', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Ïq', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Ïr', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('Ïs', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Ït', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('Ït', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('Ïu', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Ïw', 'DING');
insert into HZPYDZB (HZ, PY)
values ('Ïx', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('Ïy', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Ï{', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Ï|', 'DU');
insert into HZPYDZB (HZ, PY)
values ('ÏÅ', 'NIU');
insert into HZPYDZB (HZ, PY)
values ('ÏÑ', 'NA');
insert into HZPYDZB (HZ, PY)
values ('ÏÖ', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ÏÖ', 'WA');
insert into HZPYDZB (HZ, PY)
values ('Ïá', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('Ïä', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ïã', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('Ïã', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Ïå', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ïé', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('Ïë', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Ïë', 'SA');
insert into HZPYDZB (HZ, PY)
values ('Ïí', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ïì', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ïì', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ïï', 'HEN');
insert into HZPYDZB (HZ, PY)
values ('Ïñ', 'GONG');
insert into HZPYDZB (HZ, PY)
values ('Ïò', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Ïô', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('Ïô', 'YING');
insert into HZPYDZB (HZ, PY)
values ('Ïú', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('Ïù', 'KONG');
insert into HZPYDZB (HZ, PY)
values ('Ïû', 'BENG');
insert into HZPYDZB (HZ, PY)
values ('Ï¢', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('Ï¢', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('Ï•', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Ï•', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Ï®', 'SHE');
insert into HZPYDZB (HZ, PY)
values ('Ï®', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Ï™', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ï™', 'SA');
insert into HZPYDZB (HZ, PY)
values ('Ï´', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Ï¨', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('Ï≠', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ÏÆ', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ÏØ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('Ï∞', 'GOU');
insert into HZPYDZB (HZ, PY)
values ('Ï∞', 'KAO');
commit;
prompt 16100 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ï±', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Ï≥', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Ï¥', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ïµ', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('Ï∂', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Ï∂', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Ï∑', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('Ï∏', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('Ï∏', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Ï∫', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Ïª', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ÏΩ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Ïæ', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('Ïø', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Ï¿', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('Ï¿', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('Ï¡', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('Ï¬', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Ï√', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Ïƒ', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Ï≈', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('Ï∆', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('Ï«', 'YE');
insert into HZPYDZB (HZ, PY)
values ('Ï»', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('Ï…', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Ï ', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ÏÀ', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('ÏÃ', 'CHAO');
insert into HZPYDZB (HZ, PY)
values ('ÏÕ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('ÏŒ', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Ïœ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Ï–', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Ï—', 'DUAN');
insert into HZPYDZB (HZ, PY)
values ('Ï“', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Ï‘', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('Ï’', 'TUI');
insert into HZPYDZB (HZ, PY)
values ('Ï÷', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Ï◊', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('Ïÿ', 'SHANG');
insert into HZPYDZB (HZ, PY)
values ('ÏŸ', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('Ï⁄', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Ï‹', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('Ï›', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('Ïﬂ', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ï·', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Ï·', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('Ï‚', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ï„', 'XIU');
insert into HZPYDZB (HZ, PY)
values ('Ï„', 'XU');
insert into HZPYDZB (HZ, PY)
values ('Ï‰', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ÏÂ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ÏÊ', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ÏÁ', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('ÏË', 'HU');
insert into HZPYDZB (HZ, PY)
values ('ÏÈ', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ÏÎ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('ÏÌ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÏÓ', 'QU');
insert into HZPYDZB (HZ, PY)
values ('ÏÔ', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Ï', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Ï', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ÏÒ', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('ÏÚ', 'MI');
insert into HZPYDZB (HZ, PY)
values ('ÏÚ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ÏÛ', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ÏÛ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÏÙ', 'CI');
insert into HZPYDZB (HZ, PY)
values ('ÏÙ', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Ïı', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Ïˆ', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('Ï˜', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Ï¯', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Ï¯', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('Ï˙', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('Ï˚', 'XI');
insert into HZPYDZB (HZ, PY)
values ('Ï˝', 'TE');
insert into HZPYDZB (HZ, PY)
values ('Ï˛', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ì@', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Ì@', 'BING');
insert into HZPYDZB (HZ, PY)
values ('ÌA', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('ÌD', 'BANG');
insert into HZPYDZB (HZ, PY)
values ('ÌE', 'ENG');
insert into HZPYDZB (HZ, PY)
values ('ÌH', 'MO');
insert into HZPYDZB (HZ, PY)
values ('ÌJ', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('ÌJ', 'MU');
insert into HZPYDZB (HZ, PY)
values ('ÌM', 'ON');
insert into HZPYDZB (HZ, PY)
values ('ÌU', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('ÌV', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('ÌZ', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ì\', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('Ì]', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Ì^', 'DA');
insert into HZPYDZB (HZ, PY)
values ('Ìf', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Ìh', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Ìi', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('Ìj', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('Ìn', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Ìo', 'CHANG');
insert into HZPYDZB (HZ, PY)
values ('Ìp', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('Ìu', 'GE');
commit;
prompt 16200 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ìv', 'BAI');
insert into HZPYDZB (HZ, PY)
values ('Ìz', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('Ì}', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('ÌÉ', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('Ìâ', 'LE');
insert into HZPYDZB (HZ, PY)
values ('Ìã', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('Ìì', 'YE');
insert into HZPYDZB (HZ, PY)
values ('Ìï', 'QING');
insert into HZPYDZB (HZ, PY)
values ('Ìñ', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Ìó', 'XIANG');
insert into HZPYDZB (HZ, PY)
values ('Ìò', 'SHUN');
insert into HZPYDZB (HZ, PY)
values ('Ìô', 'AN');
insert into HZPYDZB (HZ, PY)
values ('Ìô', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Ìö', 'XU');
insert into HZPYDZB (HZ, PY)
values ('Ìû', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('Ìü', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Ì†', 'KEN');
insert into HZPYDZB (HZ, PY)
values ('Ì†', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Ì°', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('Ì¢', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Ì£', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Ì§', 'NV');
insert into HZPYDZB (HZ, PY)
values ('Ì•', 'NEN');
insert into HZPYDZB (HZ, PY)
values ('Ì¶', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('Ì™', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('Ì™', 'MIN');
insert into HZPYDZB (HZ, PY)
values ('Ì´', 'NI');
insert into HZPYDZB (HZ, PY)
values ('Ì¨', 'QI');
insert into HZPYDZB (HZ, PY)
values ('ÌÆ', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('ÌØ', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('Ì∞', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('Ì±', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('Ì≤', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Ì≥', 'DA');
insert into HZPYDZB (HZ, PY)
values ('Ì≥', 'TA');
insert into HZPYDZB (HZ, PY)
values ('Ìµ', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('Ì∂', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ì∑', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('Ì∑', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Ì∏', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('Ìπ', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('ÌΩ', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('ÌΩ', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('Ìæ', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('Ìø', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('Ì¿', 'FA');
insert into HZPYDZB (HZ, PY)
values ('Ì¡', 'AI');
insert into HZPYDZB (HZ, PY)
values ('Ì¬', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ì√', 'LONG');
insert into HZPYDZB (HZ, PY)
values ('Ìƒ', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('Ìƒ', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('Ì≈', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Ì∆', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Ì«', 'LA');
insert into HZPYDZB (HZ, PY)
values ('Ì«', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ì»', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Ì…', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Ì ', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('ÌÀ', 'MANG');
insert into HZPYDZB (HZ, PY)
values ('ÌÃ', 'XIA');
insert into HZPYDZB (HZ, PY)
values ('ÌÕ', 'QIAO');
insert into HZPYDZB (HZ, PY)
values ('ÌŒ', 'ZHAI');
insert into HZPYDZB (HZ, PY)
values ('Ìœ', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('Ìœ', 'TONG');
insert into HZPYDZB (HZ, PY)
values ('Ì—', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Ì“', 'E');
insert into HZPYDZB (HZ, PY)
values ('Ì“', 'WO');
insert into HZPYDZB (HZ, PY)
values ('Ì”', 'QI');
insert into HZPYDZB (HZ, PY)
values ('Ì’', 'BEI');
insert into HZPYDZB (HZ, PY)
values ('Ì÷', 'DING');
insert into HZPYDZB (HZ, PY)
values ('Ì◊', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ÌŸ', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ÌŸ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('Ì‹', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('Ìﬁ', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('Ì‡', 'QING');
insert into HZPYDZB (HZ, PY)
values ('Ì‚', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('Ì„', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('Ì‰', 'JIANG');
insert into HZPYDZB (HZ, PY)
values ('ÌÁ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ÌË', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('ÌË', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ÌÈ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ÌÏ', 'XU');
insert into HZPYDZB (HZ, PY)
values ('ÌÌ', 'MIAN');
insert into HZPYDZB (HZ, PY)
values ('ÌÓ', 'KOU');
insert into HZPYDZB (HZ, PY)
values ('ÌÔ', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('ÌÔ', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('Ì', 'MIAO');
insert into HZPYDZB (HZ, PY)
values ('ÌÒ', 'CHEN');
insert into HZPYDZB (HZ, PY)
values ('ÌÒ', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ÌÚ', 'SHENG');
insert into HZPYDZB (HZ, PY)
values ('ÌÙ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ÌÙ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Ìı', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('Ì˜', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('Ì¯', 'MOU');
insert into HZPYDZB (HZ, PY)
values ('Ì˘', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('Ì˙', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ì˚', 'DI');
commit;
prompt 16300 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ì˚', 'TI');
insert into HZPYDZB (HZ, PY)
values ('Ì¸', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('Ì¸', 'SUO');
insert into HZPYDZB (HZ, PY)
values ('Ì˝', 'YA');
insert into HZPYDZB (HZ, PY)
values ('Ì˛', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ÓA', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ÓB', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('ÓC', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('ÓD', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('ÓF', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('ÓF', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('ÓH', 'PI');
insert into HZPYDZB (HZ, PY)
values ('ÓH', 'PO');
insert into HZPYDZB (HZ, PY)
values ('ÓI', 'LING');
insert into HZPYDZB (HZ, PY)
values ('ÓK', 'JING');
insert into HZPYDZB (HZ, PY)
values ('ÓL', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('ÓM', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ÓR', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('ÓS', 'KUO');
insert into HZPYDZB (HZ, PY)
values ('ÓT', 'SHEN');
insert into HZPYDZB (HZ, PY)
values ('ÓU', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÓW', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('ÓW', 'KE');
insert into HZPYDZB (HZ, PY)
values ('ÓX', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('ÓY', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('Ó[', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('Ó\', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Ó]', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Ó^', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('Ó_', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Ó`', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Óa', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('Ób', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('Óe', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Óe', 'YING');
insert into HZPYDZB (HZ, PY)
values ('Óh', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Ói', 'GENG');
insert into HZPYDZB (HZ, PY)
values ('Ói', 'JING');
insert into HZPYDZB (HZ, PY)
values ('Ól', 'PIN');
insert into HZPYDZB (HZ, PY)
values ('Ór', 'DING');
insert into HZPYDZB (HZ, PY)
values ('Ót', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Óu', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Ów', 'KE');
insert into HZPYDZB (HZ, PY)
values ('Óx', 'CUI');
insert into HZPYDZB (HZ, PY)
values ('Óy', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('Ó}', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ÓÄ', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÓÅ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('ÓÉ', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('ÓÜ', 'YAN');
insert into HZPYDZB (HZ, PY)
values ('Óä', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('Óç', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('Óè', 'KUA');
insert into HZPYDZB (HZ, PY)
values ('Óè', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Óê', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('Óë', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('Óî', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('Óõ', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Óù', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('Óù', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('Ó†', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('Ó°', 'HUI');
insert into HZPYDZB (HZ, PY)
values ('Ó°', 'SUI');
insert into HZPYDZB (HZ, PY)
values ('Ó£', 'RUI');
insert into HZPYDZB (HZ, PY)
values ('Ó§', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('Ó•', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Ó¶', 'MAO');
insert into HZPYDZB (HZ, PY)
values ('Óß', 'KE');
insert into HZPYDZB (HZ, PY)
values ('Ó®', 'MING');
insert into HZPYDZB (HZ, PY)
values ('Ó©', 'PIAO');
insert into HZPYDZB (HZ, PY)
values ('Ó™', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('Ó™', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('Ó´', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('Ó¨', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('Ó¨', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ÓÆ', 'TING');
insert into HZPYDZB (HZ, PY)
values ('ÓØ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Ó∞', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('Ó±', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('Ó≤', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('Ó≥', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('Óµ', 'WAN');
insert into HZPYDZB (HZ, PY)
values ('Ó∂', 'TUAN');
insert into HZPYDZB (HZ, PY)
values ('Ó∑', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Ó∏', 'GANG');
insert into HZPYDZB (HZ, PY)
values ('Óπ', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Óæ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ó¡', 'HE');
insert into HZPYDZB (HZ, PY)
values ('Ó¡', 'KE');
insert into HZPYDZB (HZ, PY)
values ('Ó√', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('Óƒ', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ó∆', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Ó«', 'PO');
insert into HZPYDZB (HZ, PY)
values ('Ó»', 'ZHAO');
insert into HZPYDZB (HZ, PY)
values ('Ó ', 'TU');
insert into HZPYDZB (HZ, PY)
values ('ÓÀ', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('ÓÃ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ÓÃ', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('ÓÕ', 'MEN');
insert into HZPYDZB (HZ, PY)
values ('ÓŒ', 'CHA');
commit;
prompt 16400 records committed...
insert into HZPYDZB (HZ, PY)
values ('ÓŒ', 'CHAI');
insert into HZPYDZB (HZ, PY)
values ('Óœ', 'NV');
insert into HZPYDZB (HZ, PY)
values ('Ó–', 'BU');
insert into HZPYDZB (HZ, PY)
values ('Ó–', 'PI');
insert into HZPYDZB (HZ, PY)
values ('Ó—', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('Ó“', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Ó”', 'BAN');
insert into HZPYDZB (HZ, PY)
values ('Ó‘', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('Ó‘', 'QIAN');
insert into HZPYDZB (HZ, PY)
values ('Ó’', 'FANG');
insert into HZPYDZB (HZ, PY)
values ('Ó÷', 'KANG');
insert into HZPYDZB (HZ, PY)
values ('Ó◊', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('Ó◊', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('Óÿ', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('ÓŸ', 'BA');
insert into HZPYDZB (HZ, PY)
values ('ÓŸ', 'PA');
insert into HZPYDZB (HZ, PY)
values ('Ó⁄', 'YU');
insert into HZPYDZB (HZ, PY)
values ('Ó€', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('Ó‹', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Ó‹', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Ó›', 'KE');
insert into HZPYDZB (HZ, PY)
values ('Óﬁ', 'PO');
insert into HZPYDZB (HZ, PY)
values ('Óﬂ', 'BU');
insert into HZPYDZB (HZ, PY)
values ('Ó‡', 'BO');
insert into HZPYDZB (HZ, PY)
values ('Ó‚', 'MU');
insert into HZPYDZB (HZ, PY)
values ('Ó„', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ó‰', 'DIAN');
insert into HZPYDZB (HZ, PY)
values ('ÓÂ', 'SHUO');
insert into HZPYDZB (HZ, PY)
values ('ÓÊ', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('ÓÁ', 'XUAN');
insert into HZPYDZB (HZ, PY)
values ('ÓË', 'TA');
insert into HZPYDZB (HZ, PY)
values ('ÓÈ', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ÓÈ', 'SE');
insert into HZPYDZB (HZ, PY)
values ('ÓÍ', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ÓÏ', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ÓÌ', 'KAO');
insert into HZPYDZB (HZ, PY)
values ('ÓÓ', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('ÓÔ', 'ER');
insert into HZPYDZB (HZ, PY)
values ('ÓÔ', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('ÓÒ', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('ÓÚ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ÓÛ', 'NAO');
insert into HZPYDZB (HZ, PY)
values ('Óı', 'CHENG');
insert into HZPYDZB (HZ, PY)
values ('Óı', 'DANG');
insert into HZPYDZB (HZ, PY)
values ('Óˆ', 'DIAO');
insert into HZPYDZB (HZ, PY)
values ('Ó¯', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('Ó˘', 'ZHU');
insert into HZPYDZB (HZ, PY)
values ('Ó˙', 'TING');
insert into HZPYDZB (HZ, PY)
values ('Ó¸', 'HUA');
insert into HZPYDZB (HZ, PY)
values ('Ó˝', 'QUAN');
insert into HZPYDZB (HZ, PY)
values ('Ó˛', 'HA');
insert into HZPYDZB (HZ, PY)
values ('ÔB', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ÔC', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ÔC', 'LIN');
insert into HZPYDZB (HZ, PY)
values ('ÔD', 'NIE');
insert into HZPYDZB (HZ, PY)
values ('ÔG', 'JIONG');
insert into HZPYDZB (HZ, PY)
values ('ÔI', 'YING');
insert into HZPYDZB (HZ, PY)
values ('ÔK', 'LEI');
insert into HZPYDZB (HZ, PY)
values ('ÔO', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ÔR', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ÔS', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ÔU', 'TAI');
insert into HZPYDZB (HZ, PY)
values ('ÔV', 'LIE');
insert into HZPYDZB (HZ, PY)
values ('ÔW', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('ÔW', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ÔZ', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Ô[', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Ôa', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('Ôf', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('Ôf', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Ôi', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Ôj', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Ôk', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Ôl', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Ôm', 'LIAO');
insert into HZPYDZB (HZ, PY)
values ('Ôn', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Ôp', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('Ôs', 'ZHAN');
insert into HZPYDZB (HZ, PY)
values ('Ôv', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Ôx', 'FAN');
insert into HZPYDZB (HZ, PY)
values ('Ôy', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Ô{', 'CAN');
insert into HZPYDZB (HZ, PY)
values ('Ô|', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ô}', 'DING');
insert into HZPYDZB (HZ, PY)
values ('ÔÄ', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ÔÅ', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('ÔÇ', 'TUN');
insert into HZPYDZB (HZ, PY)
values ('ÔÇ', 'ZHUN');
insert into HZPYDZB (HZ, PY)
values ('ÔÖ', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('ÔÖ', 'YANG');
insert into HZPYDZB (HZ, PY)
values ('ÔÜ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('ÔÜ', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Ôá', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('Ôä', 'SUN');
insert into HZPYDZB (HZ, PY)
values ('Ôã', 'YIN');
insert into HZPYDZB (HZ, PY)
values ('Ôå', 'TOU');
insert into HZPYDZB (HZ, PY)
values ('Ôé', 'ZUO');
insert into HZPYDZB (HZ, PY)
values ('Ôê', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ôë', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('Ôí', 'BAO');
commit;
prompt 16500 records committed...
insert into HZPYDZB (HZ, PY)
values ('Ôï', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Ôñ', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Ôó', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Ôò', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('Ôô', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('Ôõ', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('Ôû', 'BING');
insert into HZPYDZB (HZ, PY)
values ('Ô°', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Ô¢', 'TIAO');
insert into HZPYDZB (HZ, PY)
values ('Ô¢', 'YAO');
insert into HZPYDZB (HZ, PY)
values ('Ô£', 'ZHENG');
insert into HZPYDZB (HZ, PY)
values ('Ô•', 'CHONG');
insert into HZPYDZB (HZ, PY)
values ('Ôß', 'AN');
insert into HZPYDZB (HZ, PY)
values ('Ô©', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('Ô™', 'LAI');
insert into HZPYDZB (HZ, PY)
values ('Ô¨', 'KENG');
insert into HZPYDZB (HZ, PY)
values ('Ô≠', 'ZENG');
insert into HZPYDZB (HZ, PY)
values ('ÔÆ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ÔØ', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('Ô∞', 'E');
insert into HZPYDZB (HZ, PY)
values ('Ô±', 'CUO');
insert into HZPYDZB (HZ, PY)
values ('Ô≤', 'LUE');
insert into HZPYDZB (HZ, PY)
values ('Ô¥', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('Ôµ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('Ô∂', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('Ô∑', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Ô∏', 'JU');
insert into HZPYDZB (HZ, PY)
values ('Ôπ', 'A');
insert into HZPYDZB (HZ, PY)
values ('Ô∫', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('Ôª', 'NUO');
insert into HZPYDZB (HZ, PY)
values ('Ôª', 'TIAN');
insert into HZPYDZB (HZ, PY)
values ('Ôº', 'BEN');
insert into HZPYDZB (HZ, PY)
values ('ÔΩ', 'DE');
insert into HZPYDZB (HZ, PY)
values ('Ôæ', 'KE');
insert into HZPYDZB (HZ, PY)
values ('Ôø', 'GUN');
insert into HZPYDZB (HZ, PY)
values ('Ôø', 'KUN');
insert into HZPYDZB (HZ, PY)
values ('Ô¿', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Ô¡', 'HUO');
insert into HZPYDZB (HZ, PY)
values ('Ô¬', 'PEI');
insert into HZPYDZB (HZ, PY)
values ('Ô√', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('Ôƒ', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ô∆', 'QIE');
insert into HZPYDZB (HZ, PY)
values ('Ô«', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('Ô«', 'KAI');
insert into HZPYDZB (HZ, PY)
values ('Ô»', 'SI');
insert into HZPYDZB (HZ, PY)
values ('Ô»', 'SONG');
insert into HZPYDZB (HZ, PY)
values ('Ô…', 'E');
insert into HZPYDZB (HZ, PY)
values ('ÔÀ', 'SOU');
insert into HZPYDZB (HZ, PY)
values ('ÔÃ', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('ÔÕ', 'AI');
insert into HZPYDZB (HZ, PY)
values ('ÔŒ', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('ÔŒ', 'LV');
insert into HZPYDZB (HZ, PY)
values ('Ôœ', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('Ô–', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Ô—', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('Ô”', 'GE');
insert into HZPYDZB (HZ, PY)
values ('Ô”', 'LI');
insert into HZPYDZB (HZ, PY)
values ('Ô‘', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('Ô÷', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('Ô◊', 'YI');
insert into HZPYDZB (HZ, PY)
values ('Ôÿ', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ÔŸ', 'BIN');
insert into HZPYDZB (HZ, PY)
values ('Ô⁄', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('Ô€', 'TANG');
insert into HZPYDZB (HZ, PY)
values ('Ô‹', 'MAN');
insert into HZPYDZB (HZ, PY)
values ('Ô›', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('Ôﬂ', 'CHUO');
insert into HZPYDZB (HZ, PY)
values ('Ô·', 'DI');
insert into HZPYDZB (HZ, PY)
values ('Ô‚', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('Ô„', 'JUE');
insert into HZPYDZB (HZ, PY)
values ('Ô‰', 'PU');
insert into HZPYDZB (HZ, PY)
values ('ÔÂ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('ÔÊ', 'DUI');
insert into HZPYDZB (HZ, PY)
values ('ÔÊ', 'DUN');
insert into HZPYDZB (HZ, PY)
values ('ÔÁ', 'LAN');
insert into HZPYDZB (HZ, PY)
values ('ÔÁ', 'LIAN');
insert into HZPYDZB (HZ, PY)
values ('ÔË', 'PU');
insert into HZPYDZB (HZ, PY)
values ('ÔÈ', 'CHUAN');
insert into HZPYDZB (HZ, PY)
values ('ÔÈ', 'CUAN');
insert into HZPYDZB (HZ, PY)
values ('ÔÍ', 'QIANG');
insert into HZPYDZB (HZ, PY)
values ('ÔÎ', 'DENG');
insert into HZPYDZB (HZ, PY)
values ('ÔÌ', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('ÔÌ', 'ZHUO');
insert into HZPYDZB (HZ, PY)
values ('ÔÓ', 'YI');
insert into HZPYDZB (HZ, PY)
values ('ÔÔ', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('Ô', 'BIAO');
insert into HZPYDZB (HZ, PY)
values ('ÔÒ', 'ZHONG');
insert into HZPYDZB (HZ, PY)
values ('ÔÙ', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Ôı', 'BI');
insert into HZPYDZB (HZ, PY)
values ('Ôˆ', 'ZI');
insert into HZPYDZB (HZ, PY)
values ('Ô˜', 'MO');
insert into HZPYDZB (HZ, PY)
values ('Ô¯', 'SHU');
insert into HZPYDZB (HZ, PY)
values ('Ô˘', 'LV');
insert into HZPYDZB (HZ, PY)
values ('Ô˙', 'JI');
insert into HZPYDZB (HZ, PY)
values ('Ô˚', 'FU');
insert into HZPYDZB (HZ, PY)
values ('Ô¸', 'LANG');
insert into HZPYDZB (HZ, PY)
values ('Ô˝', 'KE');
insert into HZPYDZB (HZ, PY)
values ('Ô˛', 'REN');
insert into HZPYDZB (HZ, PY)
values ('C', 'JUAN');
insert into HZPYDZB (HZ, PY)
values ('H', 'NEI');
commit;
prompt 16600 records committed...
insert into HZPYDZB (HZ, PY)
values ('J', 'BU');
insert into HZPYDZB (HZ, PY)
values ('K', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('M', 'SU');
insert into HZPYDZB (HZ, PY)
values ('Q', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('S', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('V', 'BING');
insert into HZPYDZB (HZ, PY)
values ('W', 'KAN');
insert into HZPYDZB (HZ, PY)
values ('Z', 'TAN');
insert into HZPYDZB (HZ, PY)
values ('^', 'GUAN');
insert into HZPYDZB (HZ, PY)
values ('`', 'NUAN');
insert into HZPYDZB (HZ, PY)
values ('a', 'HUN');
insert into HZPYDZB (HZ, PY)
values ('c', 'HUANG');
insert into HZPYDZB (HZ, PY)
values ('g', 'AI');
insert into HZPYDZB (HZ, PY)
values ('g', 'HE');
insert into HZPYDZB (HZ, PY)
values ('l', 'CHA');
insert into HZPYDZB (HZ, PY)
values ('o', 'BO');
insert into HZPYDZB (HZ, PY)
values ('p', 'GAO');
insert into HZPYDZB (HZ, PY)
values ('r', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('s', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('u', 'TAO');
insert into HZPYDZB (HZ, PY)
values ('x', 'MO');
insert into HZPYDZB (HZ, PY)
values ('Å', 'KUI');
insert into HZPYDZB (HZ, PY)
values ('Ñ', 'CHI');
insert into HZPYDZB (HZ, PY)
values ('á', 'JI');
insert into HZPYDZB (HZ, PY)
values ('ç', 'FEN');
insert into HZPYDZB (HZ, PY)
values ('é', 'HAI');
insert into HZPYDZB (HZ, PY)
values ('è', 'MENG');
insert into HZPYDZB (HZ, PY)
values ('ë', 'MO');
insert into HZPYDZB (HZ, PY)
values ('í', 'CHAN');
insert into HZPYDZB (HZ, PY)
values ('î', 'LUO');
insert into HZPYDZB (HZ, PY)
values ('ñ', 'NANG');
insert into HZPYDZB (HZ, PY)
values ('ó', 'DING');
insert into HZPYDZB (HZ, PY)
values ('ò', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ô', 'DUO');
insert into HZPYDZB (HZ, PY)
values ('ö', 'HE');
insert into HZPYDZB (HZ, PY)
values ('ö', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('ú', 'XI');
insert into HZPYDZB (HZ, PY)
values ('ù', 'DOU');
insert into HZPYDZB (HZ, PY)
values ('û', 'JUN');
insert into HZPYDZB (HZ, PY)
values ('ü', 'GUO');
insert into HZPYDZB (HZ, PY)
values ('°', 'BIAN');
insert into HZPYDZB (HZ, PY)
values ('°', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('¢', 'JI');
insert into HZPYDZB (HZ, PY)
values ('¢', 'ZE');
insert into HZPYDZB (HZ, PY)
values ('£', 'SE');
insert into HZPYDZB (HZ, PY)
values ('§', 'NIAN');
insert into HZPYDZB (HZ, PY)
values ('•', 'FU');
insert into HZPYDZB (HZ, PY)
values ('ß', 'GUI');
insert into HZPYDZB (HZ, PY)
values ('®', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('©', 'HAO');
insert into HZPYDZB (HZ, PY)
values ('™', 'XI');
insert into HZPYDZB (HZ, PY)
values ('´', 'PO');
insert into HZPYDZB (HZ, PY)
values ('¨', 'DIE');
insert into HZPYDZB (HZ, PY)
values ('≠', 'HU');
insert into HZPYDZB (HZ, PY)
values ('Æ', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('Æ', 'YONG');
insert into HZPYDZB (HZ, PY)
values ('Ø', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('∞', 'YUAN');
insert into HZPYDZB (HZ, PY)
values ('±', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('≤', 'ZHEN');
insert into HZPYDZB (HZ, PY)
values ('≥', 'GU');
insert into HZPYDZB (HZ, PY)
values ('¥', 'DONG');
insert into HZPYDZB (HZ, PY)
values ('µ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('∏', 'SI');
insert into HZPYDZB (HZ, PY)
values ('∫', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('ª', 'GUA');
insert into HZPYDZB (HZ, PY)
values ('Ω', 'LUAN');
insert into HZPYDZB (HZ, PY)
values ('æ', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ø', 'LI');
insert into HZPYDZB (HZ, PY)
values ('¿', 'HU');
insert into HZPYDZB (HZ, PY)
values ('√', 'TI');
insert into HZPYDZB (HZ, PY)
values ('ƒ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('∆', 'AN');
insert into HZPYDZB (HZ, PY)
values ('»', 'CHUN');
insert into HZPYDZB (HZ, PY)
values ('…', 'HU');
insert into HZPYDZB (HZ, PY)
values (' ', 'E');
insert into HZPYDZB (HZ, PY)
values ('À', 'CI');
insert into HZPYDZB (HZ, PY)
values ('Ã', 'MEI');
insert into HZPYDZB (HZ, PY)
values ('Õ', 'WU');
insert into HZPYDZB (HZ, PY)
values ('œ', 'JIAN');
insert into HZPYDZB (HZ, PY)
values ('–', 'YING');
insert into HZPYDZB (HZ, PY)
values ('“', 'LIU');
insert into HZPYDZB (HZ, PY)
values ('‘', 'JIAO');
insert into HZPYDZB (HZ, PY)
values ('’', 'JIU');
insert into HZPYDZB (HZ, PY)
values ('÷', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ÿ', 'LU');
insert into HZPYDZB (HZ, PY)
values ('Ÿ', 'HUAN');
insert into HZPYDZB (HZ, PY)
values ('⁄', 'NE');
insert into HZPYDZB (HZ, PY)
values ('€', 'DING');
insert into HZPYDZB (HZ, PY)
values ('€', 'NE');
insert into HZPYDZB (HZ, PY)
values ('‹', 'JIE');
insert into HZPYDZB (HZ, PY)
values ('›', 'LI');
insert into HZPYDZB (HZ, PY)
values ('ﬁ', 'SHAN');
insert into HZPYDZB (HZ, PY)
values ('ﬂ', 'LI');
insert into HZPYDZB (HZ, PY)
values ('·', 'GAN');
insert into HZPYDZB (HZ, PY)
values ('‚', 'KE');
insert into HZPYDZB (HZ, PY)
values ('„', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('‰', 'ZHA');
insert into HZPYDZB (HZ, PY)
values ('Â', 'PAO');
insert into HZPYDZB (HZ, PY)
values ('Ë', 'JIA');
commit;
prompt 16700 records committed...
insert into HZPYDZB (HZ, PY)
values ('È', 'YA');
insert into HZPYDZB (HZ, PY)
values ('Î', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Ï', 'LAO');
insert into HZPYDZB (HZ, PY)
values ('Ì', 'WU');
insert into HZPYDZB (HZ, PY)
values ('Ô', 'XIAN');
insert into HZPYDZB (HZ, PY)
values ('', 'SHA');
insert into HZPYDZB (HZ, PY)
values ('Ú', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('Û', 'GU');
insert into HZPYDZB (HZ, PY)
values ('Ù', 'WEI');
insert into HZPYDZB (HZ, PY)
values ('ı', 'YU');
insert into HZPYDZB (HZ, PY)
values ('ˆ', 'YU');
insert into HZPYDZB (HZ, PY)
values ('˜', 'DAN');
insert into HZPYDZB (HZ, PY)
values ('¯', 'LA');
insert into HZPYDZB (HZ, PY)
values ('˙', 'HOU');
insert into HZPYDZB (HZ, PY)
values ('¸', 'LOU');
insert into HZPYDZB (HZ, PY)
values ('˝', 'JIA');
insert into HZPYDZB (HZ, PY)
values ('˛', 'SAO');
insert into HZPYDZB (HZ, PY)
values ('ÒC', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ÒD', 'NI');
insert into HZPYDZB (HZ, PY)
values ('ÒE', 'BI');
insert into HZPYDZB (HZ, PY)
values ('ÒF', 'BO');
insert into HZPYDZB (HZ, PY)
values ('ÒG', 'TU');
insert into HZPYDZB (HZ, PY)
values ('ÒH', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ÒI', 'FEI');
insert into HZPYDZB (HZ, PY)
values ('ÒK', 'AN');
insert into HZPYDZB (HZ, PY)
values ('ÒN', 'WO');
insert into HZPYDZB (HZ, PY)
values ('ÒR', 'MA');
insert into HZPYDZB (HZ, PY)
values ('ÒT', 'FENG');
insert into HZPYDZB (HZ, PY)
values ('ÒT', 'PING');
insert into HZPYDZB (HZ, PY)
values ('ÒU', 'HAN');
insert into HZPYDZB (HZ, PY)
values ('ÒW', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('ÒX', 'TUO');
insert into HZPYDZB (HZ, PY)
values ('Ò\', 'SHI');
insert into HZPYDZB (HZ, PY)
values ('Ò\', 'ZHI');
insert into HZPYDZB (HZ, PY)
values ('Ò^', 'JIN');
insert into HZPYDZB (HZ, PY)
values ('Òb', 'WEN');
insert into HZPYDZB (HZ, PY)
values ('Òe', 'LV');
insert into HZPYDZB (HZ, PY)
values ('Òg', 'BO');
insert into HZPYDZB (HZ, PY)
values ('Òh', 'BAO');
insert into HZPYDZB (HZ, PY)
values ('Òj', 'DAI');
commit;
