-- Oracle

-- 계정 생성
create user inmo identified by inmo;

-- 권한 설정
grant connect, resource to inmo;

-- 테이블 생성
create table member(
    num number(10) primary key,
    id varchar2(20) not null,
    pass varchar2(20) not null,
    name varchar2(30) not null,
    age number(4) not null,
    email varchar2(30) not null,
    phone varchar2(30) not null,
    constraint member_id unique(id) -- 중복되는 아이디 방지
);

-- 시퀀스 생성
create sequence member_seq start with 1 increment by 1;

-- 검색
SELECT * FROM member;

-- 저장
INSERT INTO member(num, id, pass, name, age, email, phone)
VALUES(member_seq.nextval, 'admin', 'admin', 'admin', 27, 'imy@naver.com', '010-1111-1111');

-- 수정
UPDATE member SET phone = '010-0000-0000' WHERE id = 'admin';

-- 삭제
DELETE FROM member WHERE id = 'admin';