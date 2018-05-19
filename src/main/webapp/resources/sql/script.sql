# 2018.05.08
# my.conf 에 utf-8 설정을 추가 할 것

#2018.05.10
#부적합한 속성명 변경 use -> used, function -> functionFor

#2018.05.19
#제품명 테이블 추가 -> product

drop database if exists chemdb;
create database chemdb;
use chemdb;


#질의응답 테이블
drop table if exists inquiry;
CREATE TABLE `chemdb`.`inquiry` (
    `num` INT NOT NULL auto_increment,
    `email` VARCHAR(100) NULL,
    `title` VARCHAR(200) NULL,
    `content` VARCHAR(500) NULL,
	`type` varchar(10) Null,
    PRIMARY KEY (`num`)
)  DEFAULT CHARSET=UTF8;

#화학성분 관련 테이블
drop table if exists cheminfo;
CREATE TABLE `chemdb`.`cheminfo` (
    `id` INT NOT NULL,
    `nameK` VARCHAR(100) NULL,
    `nameE` VARCHAR(150) NULL,
    `cas` VARCHAR(100) NULL,
    `definition` VARCHAR(200) NULL,
    `used` VARCHAR(500) NULL,
    `goodFor` VARCHAR(45) NULL,
    `badFor` VARCHAR(45) NULL,
    `functionFor` VARCHAR(30) NULL,
    `allergy` VARCHAR(50) NULL,
    `warning` VARCHAR(60) NULL,
    `productList` VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
)  DEFAULT CHARSET=UTF8;
  
# 화학 제품명 테이블
drop table if exists product;
CREATE TABLE `chemdb`.`product` (
    productname VARCHAR(30) NOT NULL,
    productgradient VARCHAR(50) NOT NULL
);

INSERT INTO `chemdb`.`cheminfo` (`id`, `nameK`, `nameE`, `cas`, `definition`, `used`, `goodFor`, `badFor`, `functionFor`, `allergy`, `warning`, `productList`) VALUES (1, '가는골무꽃추출물', 'Scutellaria Galericulata Extract', '90106-66-4', '이 원료는 가는골무꽃 (Scutellaria galericulata)에서 추출한 것이다.', '피부컨디셔닝제(기타) : 건조하거나 손상된 피부를 개선, 피부탈락 감소, 유연성 회복 등 피부에 특별한 효과를 주기 위한 성분', '', '', '', '', '', '스킨/로션/파우더/미스트');
INSERT INTO `chemdb`.`cheminfo` (`id`, `nameK`, `nameE`, `cas`, `definition`, `used`, `goodFor`, `badFor`, `functionFor`, `allergy`, `warning`, `productList`) VALUES ('2', '가는잎그늘사초뿌리추출물', 'Carex Humillis Root Extract', '정보없음', '이 원료는 산거울 Carex humilis의 뿌리에서 추출한 것이다.', '피부컨디셔닝제(기타) : 건조하거나 손상된 피부를 개선, 피부탈락 감소, 유연성 회복 등 피부에 특별한 효과를 주기 위한 성분', '', '', '', '', '', '스킨/로션/파우더/미스트');
INSERT INTO `chemdb`.`cheminfo` (`id`, `nameK`, `nameE`, `cas`, `definition`, `used`, `goodFor`, `badFor`, `functionFor`, `allergy`, `warning`, `productList`) VALUES ('3', '산거울뿌리추출물', 'Carex Humillis Root Extract', '정보없음', '이 원료는 산거울 Carex humilis의 뿌리에서 추출한 것이다.', '피부컨디셔닝제(기타) : 건조하거나 손상된 피부를 개선, 피부탈락 감소, 유연성 회복 등 피부에 특별한 효과를 주기 위한 성분', '', '', '', '', '', '스킨/로션/파우더/미스트');

select id,nameK,nameE,cas,definition,used,goodFor,badFor,functionFor,allergy,warning,productList from cheminfo where nameK = '가는골무꽃추출물';

insert into product values('미장센','알코올_알칸_아틸_알킬');
insert into product values('려','알코올_알칸_아틸_알킬');
insert into product values('헬로우','알코올_알칸_아틸_알킬');

