create table location(
	locno varchar2(100) primary key,
	loc varchar2(100) not null,
	sigungu varchar2(100) not null,
)
create sequence locno_seq;

insert into location (loc, sigungu) values (locno_seq.nextval,'제주특별자치도','서귀포시');
insert into location (loc, sigungu) values (locno_seq.nextval,'제주특별자치도','제주시');
insert into location (loc, sigungu) values (locno_seq.nextval,'서울특별시','강동구');
insert into location (loc, sigungu) values (locno_seq.nextval,'서울특별시','강남구');
insert into location (loc, sigungu) values ('서울특별시','강북구');
insert into location (loc, sigungu) values ('서울특별시','강서구');
insert into location (loc, sigungu) values ('서울특별시','관악구');
insert into location (loc, sigungu) values ('서울특별시','광진구');
insert into location (loc, sigungu) values ('서울특별시','구로구');
insert into location (loc, sigungu) values ('서울특별시','금천구');
insert into location (loc, sigungu) values ('서울특별시','노원구');
insert into location (loc, sigungu) values ('서울특별시','도봉구');
insert into location (loc, sigungu) values ('서울특별시','동대문구');
insert into location (loc, sigungu) values ('서울특별시','동작구');
insert into location (loc, sigungu) values ('서울특별시','마포구');
insert into location (loc, sigungu) values ('서울특별시','서대문구');
insert into location (loc, sigungu) values ('서울특별시','서초구');
insert into location (loc, sigungu) values ('서울특별시','성동구');
insert into location (loc, sigungu) values ('서울특별시','성북구');
insert into location (loc, sigungu) values ('서울특별시','송파구');
insert into location (loc, sigungu) values ('서울특별시','양천구');
insert into location (loc, sigungu) values ('서울특별시','영등포구');
insert into location (loc, sigungu) values ('서울특별시','용산구');
insert into location (loc, sigungu) values ('서울특별시','은평구');
insert into location (loc, sigungu) values ('서울특별시','종로구');
insert into location (loc, sigungu) values ('서울특별시','중구');
insert into location (loc, sigungu) values ('서울특별시','중랑구');

create table member(
	mid varchar2(100) primary key,
	ano varchar2(100) not null,
	mpassword varchar2(100) not null,
	mname varchar2(100) not null,
	maddress varchar2(100) not null,
	mtel varchar2(100) not null,
	constraint fk_member_auth foreign key(ano) references authority(ano),
)

create table post(
	pno varchar2(100) primary key,
	mid varchar2(100) not null,
	ptitle varchar2(100) not null,
	pcontent clob not null,
	pdate date not null,
	phit number not null,
	plike number not null,
	pstar number not null,
	locno varchar2(100) not null,
	constraint fk_post_member foreign key(mid) references member(mid),
	constraint fk_post_location foreign key(locno) references location(locno),
)

create table comment(
	pno varchar2(100) not null,
	mid varchar2(100) not null,
	comcontent clob not null,
	comdate date not null,
	constraint fk_com_member foreign key(mid) references member(mid),
	constraint fk_com_post foreign key(pno) references post(pno),
	constraint pk_com_post primary key (pno)
)

create table request(
	reqno varchar2(100) primary key,
	mid varchar2(100) not null,
	reqcontent clob not null,
	reqdate date not null,
	constraint fk_req_member foreign key(mid) references member(mid),
)

create table myfavorite(
	mid varchar2(100) not null,
	pno varchar2(100) not null,
	constraint fk_myfav_member foreign key(mid) references member(mid),
	constraint pk_member_post primary key (mid, pno)
)
create table post_myfav(
	mid varchar2(100) not null,
	pno varchar2(100) not null,
	constraint fk_pmyfav_member foreign key(mid) references member(mid),
	constraint fk_pmyfav_post foreign key(pno) references post(pno),
	constraint pk_member_post primary key (mid, pno)
)

create table authority(
	ano varchar2(100) primary key,
	atype varchar2(100) not null,
)

create table imagepath(
	pno varchar2(100) not null,
	ipath varchar2(100) not null,
	constraint fk_imgp_post foreign key(pno) references post(pno),
	constraint pk_imgp_post primary key (pno, ipath)
)

create table QNA(
	mid varchar2(100) not null,
	answer varchar2(100) not null,
	constraint fk_qna_member foreign key(mid) references member(mid),
	constraint pk_qna_member primary key (mid, answer)
)









