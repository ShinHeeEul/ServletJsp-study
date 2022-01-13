insert into member values (
    'weed', 'southkorea1', '신희을', '남성', 24, '1999-07-15', '010-5900-7430', null
    );
    
    /* 오라클 데이터 형식
    
    Character 형식
    
    Long : 2g까지 -> 잘 안씀
    
    clob : Chracteer large object -> 굉장히 큰 데이터를 다룸 (최대 4g)
    
    nclob : national character large object
    
    numeric 형식
    number(4) -> 최대 4개
    number(6,-2) 소수점 2자리를 포함하는 최대 6자리의 숫자
    number = number(38,*)
    number(*,5) = number(38,5)
    
    Date 형식
    DATE : 년,월,일 표시
    TIMESTAMP : 년,월,일,시,분,초까지
    */
    
    select * from NLS_DATABASE_PARAMETERS;