CREATE TABLE NOTICE
(
     ID		NUMBER,
     TITLE 		NVARCHAR2(100),
     WRITER_ID	NVARCHAR2(50),
     CONTENT	CLOB,
     REGDATE  	TIMESTAMP,
     HIT		NUMBER,
     FILES		NVARCHAR2(1000)
);

insert ALL
into notice values (6, '��ȭ��ȣ�� �����ֽñ� �ٶ��ϴ�. 010-5900-7430', 'quest', '����ó�� ����ϴ�.', current_timestamp, 23, null)
into notice values (7, '����-����-�׸� �� ��������~~', 'okay', 'soso', current_timestamp, 0, null)
into notice values (1,  'JDBC�� �����ΰ�?', 'enwlec', 'aaa', current_timestamp, 0, null)
into notice values (2, 'JDBC ����̹� �ٿ�ε� ���', 'dragon', 'aaa', current_timestamp, 0, null)
into notice values (3, '�Ķ���͸� ������ ���� �����ϱ�', 'good', 'aaa', current_timestamp, 0, null)
into notice values (4, 'JSP���� JDBC ����ϱ�', 'dragon', 'ddd', current_timestamp, 0, null)
into notice values (5, 'Service ���� �߰��ϱ�', 'good', 'qqq', current_timestamp, 0, null)
into notice values (8, null, 'newlec', null, current_timestamp, 0, null)
select * from dual;

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