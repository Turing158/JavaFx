create database study character set utf8mb4;
use study;
create table student
(
    id       int          not null
        primary key,
    name     varchar(50)  null,
    class    varchar(100) null,
    gender   varchar(10)  null,
    phone    int          null,
    born     datetime     null,
    password varchar(50)  null
);
INSERT INTO study.student (id, name, classname, gender, phone, born, password) VALUES (1, '1', '1', '1', 1, '2023-10-01 22:28:45', '1');
INSERT INTO study.student (id, name, classname, gender, phone, born, password) VALUES (2, '2', '2', '男', 123, '2003-03-03 00:00:00', '123123123');
