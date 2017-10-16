drop table imagepath;
drop table QNA;
drop table comments;
drop table authority;
drop table post_myfav;
drop table post;
drop table location;
drop table request;
drop table member;
commit
create table authority(
	ano varchar2(100) primary key,
	atype varchar2(100) not null
)
insert into authority(ano,atype) values('1','회원');
insert into authority(ano,atype) values('2','관리자');

create table location(
	locno varchar2(100) primary key,
	loc varchar2(100) not null,
	sigungu varchar2(100) not null
)
create sequence locno_seq;
drop sequence locno_seq;
insert into location (locno,loc, sigungu) values (locno_seq.nextval,'제주특별자치도','서귀포시');
insert into location (locno,loc, sigungu) values (locno_seq.nextval,'제주특별자치도','제주시');
insert into location (locno,loc, sigungu) values (locno_seq.nextval,'서울특별시','강동구');
insert into location (locno,loc, sigungu) values (locno_seq.nextval,'서울특별시','강남구');
insert into location (locno,loc, sigungu) values (locno_seq.nextval,'서울특별시','송파구');

select * from location;

create table member(
	mid varchar2(100) primary key,
	ano varchar2(100) not null,
	mpassword varchar2(100) not null,
	mname varchar2(100) not null,
	maddress varchar2(100) not null,
	mtel varchar2(100) not null,
	constraint fk_member_auth foreign key(ano) references authority(ano)
)
insert into member(mid,ano,mpassword,mname,maddress,mtel)values('master','2','master','master','master','master');
insert into member(mid,ano,mpassword,mname,maddress,mtel)values('aaaaa','1','aaaaa','공유','강남','010-0000-0000');
insert into member(mid,ano,mpassword,mname,maddress,mtel)values('bbbbb','1','bbbbb','원빈','청담동','010-0000-1111');

select * from member;
select * from post;
create table post(
	pno varchar2(100) primary key,
	mid varchar2(100) not null,
	ptitle varchar2(100) not null,
	pcontent clob not null,
	pstar number not null,
	pdate date not null,
	phit number not null,
	plike number not null,
	locno varchar2(100) not null,
	
	constraint fk_post_member foreign key(mid) references member(mid),
	constraint fk_post_location foreign key(locno) references location(locno)
)
drop sequence req_seq;
drop sequence pno_seq;
drop sequence com_seq;

create sequence pno_seq;
create sequence com_seq;
create sequence req_seq;

insert into post(pno,mid,ptitle,pcontent,pdate,phit,plike,pstar,locno)
values(pno_seq.nextval,'aaaaa','강동구에서 제일 맛있는 초밥집-원숭이초밥','회가 신선해요',sysdate,3,50,4,1);
insert into post(pno,mid,ptitle,pcontent,pdate,phit,plike,pstar,locno)
values(pno_seq.nextval,'bbbbb','삼겹살 맛집 - 시집','인테리어가 깔끔하고 서비스가 좋아요',sysdate,40,50,4,1);

insert into post(pno,mid,ptitle,pcontent,pdate,phit,plike,pstar,locno)
values(pno_seq.nextval,'bbbbb','물회가 맛있는 잠실 부부횟집','양이 많아요',sysdate,10,100,4,2);
delete from post where pno='5';
select * from post;
delete from post;
create table comments(
	comno varchar2(100) primary key,
	pno varchar2(100) not null,
	mid varchar2(100) not null,
	comcontent clob not null,
	comdate date not null,
	constraint fk_com_member foreign key(mid) references member(mid),
	constraint fk_com_post foreign key(pno) references post(pno)
)
insert into comments(comno,pno,mid,comcontent,comdate)values(com_seq.nextval,'23','bbbbb','저도 좋았어요~',sysdate);
delete from comments where pno='23'
create table request(
	reqno varchar2(100) primary key,
	mid varchar2(100) not null,
	reqcontent clob not null,
	reqdate date not null,
	constraint fk_req_member foreign key(mid) references member(mid)
)

create table post_myfav(
	mid varchar2(100) not null,
	pno varchar2(100) not null,
	constraint fk_pmyfav_member foreign key(mid) references member(mid),
	constraint fk_pmyfav_post foreign key(pno) references post(pno),
	constraint pk_member_post primary key (mid, pno)
)


create table imagepath(
	pno varchar2(100) not null,
	ipath varchar2(100) not null,
	constraint fk_imgp_post foreign key(pno) references post(pno),
	constraint pk_imgp_post primary key (pno, ipath)
)
select * from post;
insert into imagepath(pno,ipath)values('23','C:\Users\Administrator\git\semi-project\8doMatZip\WebContent\pictures');
delete from imagepath where pno='23'
create table QNA(
	mid varchar2(100) not null,
	answer varchar2(100) not null,
	constraint fk_qna_member foreign key(mid) references member(mid),
	constraint pk_qna_member primary key (mid, answer)
)
insert into qna (mid, answer) values ('bbbbb','bbbbb');
select m.mpassword from member m, qna q where m.mid=q.mid and m.mid='bbbbb' and q.answer='bbbbb';







