insert into member values (
    'weed', 'southkorea1', '������', '����', 24, '1999-07-15', '010-5900-7430', null
    );
    
    /* ����Ŭ ������ ����
    
    Character ����
    
    Long : 2g���� -> �� �Ⱦ�
    
    clob : Chracteer large object -> ������ ū �����͸� �ٷ� (�ִ� 4g)
    
    nclob : national character large object
    
    numeric ����
    number(4) -> �ִ� 4��
    number(6,-2) �Ҽ��� 2�ڸ��� �����ϴ� �ִ� 6�ڸ��� ����
    number = number(38,*)
    number(*,5) = number(38,5)
    
    Date ����
    DATE : ��,��,�� ǥ��
    TIMESTAMP : ��,��,��,��,��,�ʱ���
    */
    
    select * from NLS_DATABASE_PARAMETERS;