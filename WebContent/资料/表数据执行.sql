delete from SKQ_PMSZ
delete from SKQ_ZCLX
delete from SKQ_NSRXX
delete from SKQ_NSRSZSM
delete from SKQ_JQXX
delete from SKQ_JQSZSM
delete from SKQ_FP
delete from SKQ_HY
delete from SKQ_HYMX
delete from SKQ_JQXH
delete from SKQ_SWJG
delete from skq_user
delete from skq_role
delete from skq_roleuser
delete from SKQ_ROLEMENU
insert into SKQ_USER(USERNAME,ACTUALNAME,[PASSWORD],STATUS,SWJGBM) values('system','系统管理员','54b53072540eeeb8f8e9343e71f28176',1,'00000001')
insert into SKQ_FP(FPBM,FPMC,STATUS) values('001','通用发票',1)
insert into SKQ_HY(HYBM,HYMC,HYJC,STATUS) values('1','中石化','中石化',1)
insert into SKQ_HYMX(HYBM,HYMXBM,HYMXMC,HYMXJC,STATUS) values('1','1','中石化','中石化',1)
insert into SKQ_JQXH(JQXHBM,JQXHMC,SCCS,STATUS) values('1','税控收款机','江苏大唐',1)
insert into SKQ_SWJG(SWJGBM,SWJGMC,SWJGJC,STATUS) values('00000001','南京国税','南京国税',1)
insert into SKQ_MENU(MENUCODE,MENUNAME) values('ZCDJGL','税控基础设置')
insert into SKQ_MENU(MENUCODE,MENUNAME) values('FPGL','发票管理')
insert into SKQ_MENU(MENUCODE,MENUNAME) values('SBSJ','申报数据')
insert into SKQ_MENU(MENUCODE,MENUNAME) values('XTGL','系统管理')
insert into SKQ_MENU(MENUCODE,MENUNAME) values('CXTJ','查询统计')
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('NSHXXGL','纳税户信息管理',1)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('FPGM','发票购买',2)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('FPBL','发票补领',2)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('ZRYSB','自然月申报',3)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('JDSB','阶段申报',3)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('JKHC','监控回传',3)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('ZXSBFPMX','在线申报发票明细',3)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('ZXSBRJY','在线申报日交易',3)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('LXSBFPMX','离线申报发票明细',3)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('LXSBRJY','离线申报日交易',3)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('FPPZGL','发票票种管理',4)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('PMSZ','品目设置',4)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('JQXHGL','机器型号管理',4)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('ZCLXGL','注册类型管理',4)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('HYJMXGL','行业及明细管理',4)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('SWJGGL','税务机关管理',4)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('YHGL','用户管理',4)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('JSQXGL','角色权限管理',4)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('NSHXXCX','纳税户信息查询',5)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('SKZZCX','税控装置查询',5)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('FPLGCX','发票领购查询',5)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('FPMXCX','发票明细查询',5)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('SBSJCX','申报汇总数据查询',5)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('RJYCX','日交易查询',5)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('YHKDK','用户卡信息读取',5)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('SKKDK','税控卡信息读取',5)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('WSBCX','本月未申报纳税户查询',5)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('SKKFZ','税控卡复制',5)
insert into SKQ_MENU(MENUCODE,MENUNAME,PARENTID) values('SKKJS','税控卡使用口令解锁',5)
