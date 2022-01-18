CREATE TABLE NOTICE
(
     ID		NUMBER PRIMARY KEY,
     TITLE 		NVARCHAR2(100),
     WRITER_ID	NVARCHAR2(50),
     CONTENT	CLOB,
     REGDATE  	TIMESTAMP,
     HIT		NUMBER,
     FILES		NVARCHAR2(1000)
);

drop table NOTICE;

insert ALL
into notice values (6, '전화번호로 연락주시기 바랍니다. 010-5900-7430', 'quest', '연락처를 남깁니다.', current_timestamp, 23, null)
into notice values (7, '선반-접시-그릇 이 세가지요~~', 'okay', 'soso', current_timestamp, 0, null)
into notice values (1,  'JDBC란 무엇인가?', 'enwlec', 'aaa', current_timestamp, 0, null)
into notice values (2, 'JDBC 드라이버 다운로드 방법', 'dragon', 'aaa', current_timestamp, 0, null)
into notice values (3, '파라미터를 가지는 문장 실행하기', 'good', 'aaa', current_timestamp, 0, null)
into notice values (4, 'JSP에서 JDBC 사용하기', 'dragon', 'ddd', current_timestamp, 0, null)
into notice values (5, 'Service 계층 추가하기', 'good', 'qqq', current_timestamp, 0, null)
into notice values (8, 'hh', 'newlec', null, current_timestamp, 0, null)
select * from dual;

delete from notice;

select * from notice;

CREATE TABLE "COMMENT"
(
     ID		NUMBER,
     CONTENT	NVARCHAR2(2000),
     REGDATE  	TIMESTAMP,
     WRITER_ID	NVARCHAR2(50),
     NOTICE_ID	NUMBER
);

CREATE TABLE ROLE
(
     ID		VARCHAR2(50),
     DISCRIPTION 	NVARCHAR2(500)
);

CREATE TABLE MEMBER_ROLE
(
     MEMBER_ID	NVARCHAR2(50),
     ROLE_ID		VARCHAR2(50)
);

insert ALL
into notice values (7, 'hello', 'shinheeeul', 'kk', current_timestamp, 0, null)
select * from dual;

select * from notice;
select notice.* from notice where title like '%%';

select * from notice where title like '%%' and id between 1 and 10 order by id;


select * from (select * from notice_view where title like '%%')
where id between 1 and 10 order by id;
-----------------

select count(ID) count from (select * from notice where title  like '%전화%');

delete from notice where id = 4;

select * from (select * from notice order by id) where id > 3 and rownum = 1;

insert ALL
into notice values (12, 'hell', 'shinheeeul', 'kk', current_timestamp, 0, null)
select * from dual;

-----------------------------

create view notice_view
as 
select n.id, n.title, n.writer_id, n.regdate, n.hit, n.files, COUNT(C.ID) CMT_COUNT from notice N 
LEFT JOIN "COMMENT" C on n.id = c.notice_id 
group by n.id, n.title, n.writer_id, n.regdate, n.hit, n.files;
