create database ermp;
GRANT ALL PRIVILEGES ON ermp.* TO 'mysqluser'@'%' WITH GRANT OPTION;

USE ermp;

DROP table IF EXISTS  role;

create table role (
  id varchar(255) PRIMARY KEY,
  name varchar(255),
  deleted BOOLEAN
);