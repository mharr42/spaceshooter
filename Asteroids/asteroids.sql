drop table user;

create table user(
username varchar(30),
password binary(16));


alter table user
	add constraint users_username_pk primary key(username);