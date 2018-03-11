create database Jsql

go
use Jsql

create table STU
	(xh char(8) not null,
	xm varchar(10) not null,
	xb char(2),
	csrq char(10),
	jg varchar(6),
	mima varchar(12),
	primary key (xh));

create table ADM
        (gh char(8) not null ,
        xm varchar(10),
        xb char(2),
        csrq char(10),
        mima varchar(12),
        primary key (gh));

create table TCH
        (gh char(8) not null ,
        xm varchar(10),
        xb char(2),
        csrq char(10),
        mima varchar(12),
        primary key (gh));

create table CRS
	( kh char(8) not null ,
	km varchar(16),
	xf int default 4,
	primary key (kh));

create table OPN
        ( xq char(14) not null,
	kh char(8),
	gh char(8),
	sksj varchar(11),
	primary key(xq,kh,gh),
	foreign key (kh) references CRS(kh),
	foreign key (gh) references TCH(gh));

create table ELC
	( xh char(8) not null ,
	xq char(14) not null,
	kh char(8)not null,
	gh char(8)not null,
	cj int check(cj between 0 and 100),
	primary key(xh,xq,kh,gh),
	foreign key (gh) references TCH(gh),
	foreign key (kh) references CRS(kh),
	foreign key (xh) references STU(xh));

CREATE TABLE msg
(
  id      INT AUTO_INCREMENT
    PRIMARY KEY,
  sendId  INT          NOT NULL,
  recevId INT          NOT NULL,
  tittle  VARCHAR(128) NULL,
  content VARCHAR(512) NULL,
  date    DATETIME     NULL,
  CONSTRAINT msg_id_uindex
  UNIQUE (id)
)

  


insert into STU values('15121101','李明','男','1993-03-06','上海','13613005486')
insert into STU values('15121102','刘晓明','男','1992-12-08','安徽','18913457890')
insert into STU values('15121103','张颖','女','1993-01-05','江苏','18826490423')
insert into STU values('15121104','刘晶晶','女','1994-11-06','上海','13331934111')
insert into STU values('15121105','刘成刚','男','1991-06-07','上海','18015872567')
insert into STU values('15121106','李二丽','女','1993-05-04','江苏','18107620945')
insert into STU values('15121107','张晓峰','男','1992-08-16','浙江','13912341078')

insert into ADM values('00000000','admin','男','2000-01-01','system')

insert into TCH values('10000101','陈迪茂','男','1973-03-06','3567434')
insert into TCH values('10000102','马小红','女','1972-12-08','2845432')
insert into TCH values('10000201','张心颖','女','1960-01-05','4200324')
insert into TCH values('10000103','吴宝钢','男','1980-11-06','2554432')

insert into CRS values('08305001','离散数学',4)
insert into CRS values('08305002','数据库原理',4)
insert into CRS values('08305003','数据结构',4)
insert into CRS values('08305004','系统结构',6)
insert into CRS values('08301001','分子物理学',4)
insert into CRS values('08302001','通信学',3)

insert into OPN values('2012-2013 秋季','08305001','10000103','星期三 5-8')
insert into OPN values('2012-2013 冬季','08305002','10000101','星期三 1-4')
insert into OPN values('2012-2013 冬季','08305002','10000102','星期三 1-4')
insert into OPN values('2012-2013 冬季','08305002','10000103','星期三 1-4')
insert into OPN values('2012-2013 冬季','08305003','10000102','星期五 5-8')
insert into OPN values('2013-2014 秋季','08305004','10000101','星期二 1-4')
insert into OPN values('2013-2014 秋季','08305001','10000102','星期一 5-8')
insert into OPN values('2013-2014 冬季','08302001','10000201','星期一 5-8')

insert into ELC values('15121101','2012-2013 秋季','08305001','10000103',60)
insert into ELC values('15121102','2012-2013 秋季','08305001','10000103',87)
insert into ELC values('15121102','2012-2013 冬季','08305002','10000101',82)
insert into ELC values('15121102','2013-2014 秋季','08305004','10000101',null)
insert into ELC values('15121103','2012-2013 秋季','08305001','10000103',56)
insert into ELC values('15121103','2012-2013 冬季','08305002','10000102',75)
insert into ELC values('15121103','2012-2013 冬季','08305003','10000102',84)
insert into ELC values('15121103','2013-2014 秋季','08305001','10000102',null)
insert into ELC values('15121103','2013-2014 秋季','08305004','10000101',null)
insert into ELC values('15121104','2012-2013 秋季','08305001','10000103',74)
insert into ELC values('15121104','2013-2014 冬季','08302001','10000201',null)
insert into ELC values('15121106','2012-2013 秋季','08305001','10000103',85)
insert into ELC values('15121106','2012-2013 冬季','08305002','10000103',66)
insert into ELC values('15121107','2012-2013 秋季','08305001','10000103',90)
insert into ELC values('15121107','2012-2013 冬季','08305003','10000102',79)
insert into ELC values('15121107','2013-2014 秋季','08305004','10000101',null)
