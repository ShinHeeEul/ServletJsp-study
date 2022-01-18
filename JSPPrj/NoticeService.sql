--@getNoticeList & getNoticeCount

--1
select * from (
select rownum NUM, N.* from 
(select * from notice order by regdate desc) N
)
where num between 6 and 10;


--2
select * from(
    select row_number() over (order by regdate desc) num,
    notice.* from notice
) where num between 6 and 10;


--@getNotice

select * from notice where id = 3;



--@getNextNotice

--query
select * from notice
where id = (
    select id from 
(select * from notice order by id)
where id>3 and rownum = 1
);

--sub query
select id from 
(select * from notice order by id)
where id>3 and rownum = 1;

--@getprevNotice

--query
select id from notice 
where id = (select id from 
(select * from notice order by id desc)
where id<3 and rownum = 1);

--sub query
select id from 
(select * from notice order by id)
where id>3 and rownum = 1;

select id from notice order by id;