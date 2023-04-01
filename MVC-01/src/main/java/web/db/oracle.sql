create table member(
    num number(10) primary key,
    id varchar2(20) not null,
    pass varchar2(20) not null,
    name varchar2(30) not null,
    age number(3) not null,
    email varchar2(30) not null,
    phone varchar2(30) not null,
    constraint member_id unique(id)
);

create sequence member_seq start with 1 increment by 1;

create or replace trigger member_trg
before insert on member
for each row
begin
  select member_seq.nextval into :new.num from dual;
end;
/