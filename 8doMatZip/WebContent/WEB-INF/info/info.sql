/*****************************권한 테이블****************************/
drop table athorized;
create table athorized(
	ano varchar2(100) primary key,
	aname varchar2(100) not null
)
select * from athorized;
insert into athorized(ano,aname) values('1','회원');
insert into athorized(ano,aname) values('2','비회원');
insert into athorized(ano,aname) values('3','관리자');
/*****************************************************************/

/*****************************지역 테이블****************************/
drop table location;
create table location(
	lno varchar2(100) primary key,
	lname varchar2(100) not null
	/*constraint board_fk foreign key(id) references board_member(id)*/
)
select * from location;
insert into location(lno,lname)values('1','서울');
insert into location(lno,lname)values('2','인천/경기');
insert into location(lno,lname)values('3','강원');
insert into location(lno,lname)values('4','충북');
insert into location(lno,lname)values('5','대전/충남');
insert into location(lno,lname)values('6','대구/경북');
insert into location(lno,lname)values('7','부산/울산/경남');
insert into location(lno,lname)values('8','전북');
insert into location(lno,lname)values('9','광주/전남');
insert into location(lno,lname)values('10','제주');
/*****************************************************************/

/*****************************도시 테이블****************************/
drop table city;
create table city(
	constraint loc_fk foreign key(lno) references location(lno),
	city varchar2(100) not null
)
select * from city;
insert into location(loc_fk,city)values('1','');
insert into location(loc_fk,city)values('1','');
insert into location(loc_fk,city)values('1','');
insert into location(loc_fk,city)values('1','');
insert into location(loc_fk,city)values('1','');
insert into location(loc_fk,city)values('1','');
insert into location(loc_fk,city)values('1','');
insert into location(loc_fk,city)values('1','');
insert into location(loc_fk,city)values('1','');
/*****************************************************************/

commit

SELECT b.no,b.title,b.time_posted,b.hits,b.id,m.name FROM(


SELECT b.no,b.title,b.hits,to_char(time_posted,'YYYY.MM.DD') as time_posted,m.id,m.name 
FROM board_inst b , board_member m
WHERE b.id=m.id
order by no desc





