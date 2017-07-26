USE eventuate;

DROP table IF EXISTS  role;

create table role (
  id varchar(255) PRIMARY KEY,
  name varchar(255),
  deleted BOOLEAN
);