-- member (회원) table
create table member(
    num int primary key auto_increment,
    id varchar(20) not null,
    pass varchar(20) not null,
    name varchar(30) not null,
    age int not null,``
    email varchar(30) not null,
    phone varchar(30) not null
);

-- 검색
select * from member;

-- 저장
insert into member(id, pass, name, age, email, phone)
values('admin', 'admin', 'admin', 27, 'imy@naver.com', '010-1111-1111');

-- 수정
update member set phone='010-0000-0000' where id='admin';

-- 삭제
delete from member where id='admin';