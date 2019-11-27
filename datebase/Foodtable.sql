show databases;
create database safefood;
use safefood;

show tables;

drop table members;
drop table allergy;
drop table intake;

desc members;
desc allergy;
desc intake;

# 회원테이블
/*
- 회원번호(PK,Auto)
- 아이디
- 성별[남/여]
- 나이
- 키
- 몸무게
*/

create table members(
	mem_id int primary key auto_increment,
    email varchar(20) not null unique,
    gender enum('M','W'),
    height int,
    weight int,
	day_intake int
);

# 회원별 알레르기 테이블
/*
알레르기
- 번호
- 회원번호
- context
*/

create table allergy(
	allergy_id int primary key auto_increment,
    mem_num int, 
    alle varchar(20) not null unique,
    foreign key(mem_num) references members(mem_id) on update cascade
);

# 회원별 섭취 테이블
# food_name 도 식품테이블과 fk 설정?
/*
- 섭취번호(PK,Auto)
- 회원아이디(FK) / 1:N
- 제품번호
- 해당 제품 횟수(1회 제공량 기준)
- 섭취 날짜
- 섭취 칼로리 1
- 섭취 탄수화물 2
- 섭취 단백질 3
- 섭취 지방 4
- 섭취 나트륨 5

*/

create table intake(
	intake_id int primary key auto_increment,
    mem_num int,
    food_name varchar(30) not null,
    count int default 1,
    eat_date date,
    KCAL float(7,2),
    carbohydrate float(7,2),
    protein float(7,2),
    fat float(7,2),
    natrium float(7,2),
    foreign key(mem_num) references members(mem_id) on update cascade
);

# 식품테이블
/*

- 식품아이디(PK,Auto)
- NUM : 번호
- FOOD_CD : 식품코드(중요)
- 식품군
- 식품이름
- 1회 제공량
- 열량(KCAL)
- 탄수화물 carbohydrate
- 단백질 protein
- 지방 fat
- 당류 sugars
- 나트륨 natrium
- 콜레스트롤 cholesterol
- 포화지방산 fattyacid
- 트랜스지방 transfat
- 가공업체명 ANIMAL_PLANT
- 구축년도 BGN_YEAR
- 자료원 FOOD_GROUP

NUM	번호
FOOD_CD	식품코드
FDGRP_NM	식품군
DESC_KOR	식품이름
SERVING_WT	1회제공량(g)
NUTR_CONT1	열량(kcal)(1회제공량당)
NUTR_CONT2	탄수화물(g)(1회제공량당)
NUTR_CONT3	단백질(g)(1회제공량당)
NUTR_CONT4	지방(g)(1회제공량당)
NUTR_CONT5	당류(g)(1회제공량당)
NUTR_CONT6	나트륨(mg)(1회제공량당)
NUTR_CONT7	콜레스테롤(mg)(1회제공량당)
NUTR_CONT8	포화지방산(g)(1회제공량당)
NUTR_CONT9	트랜스지방(g)(1회제공량당)
ANIMAL_PLANT	가공업체명
BGN_YEAR	구축년도
FOOD_GROUP	자료원
*/

create table food(
	food_id int primary key auto_increment,
	NUM int,
    FOOD_CD varchar(20),
    FOOD_GROUP varchar(20),
    FOOD_DESC varchar(20),
    SERVING_WT float(7,2),
    KCAL float(7,2), # 1
    carbohydrate float(7,2), # 2
    protein float(7,2), # 3
    fat float(7,2), # 4
    sugars float(7,2), # 5
    natrium float(7,2), # 6
    cholesterol float(7,2), # 7
    fatty_acid float(7,2), # 8
    trans_fat float(7,2) # 9
);



#식품원재료DB
/*
- 인허가 번호
- 업소명
- 품목제조번호 (중요)
- 허가일자
- 품목명
- 유형
- 원재료

LCNS_NO	인허가번호
BSSH_NM	업소명
PRDLST_REPORT_NO	품목제조번호
PRMS_DT	허가일자
PRDLST_NM	품목명
PRDLST_DCNM	유형
RAWMTRL_NM	원재료

*/

