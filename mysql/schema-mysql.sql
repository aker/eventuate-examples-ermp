create database ermp;
GRANT ALL PRIVILEGES ON ermp.* TO 'mysqluser'@'%' WITH GRANT OPTION;

USE ermp;

DROP table IF EXISTS  role;
DROP table IF EXISTS  user;

create table role (
  id varchar(255) PRIMARY KEY,
  name varchar(255),
  deleted BOOLEAN
);

create table user_account (
  user_id varchar(255) PRIMARY KEY,
  user_code varchar(255),
  user_name varchar(255),
  password varchar(255),
  email varchar(255),
  deleted BOOLEAN
);