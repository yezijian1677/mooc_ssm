create database pay;
use pay;

create table department(
	id char(10) primary key,
	dept_name varchar(20),
	address varchar(100)
)charset = utf8;

create table staff(
	id char(10) primary key,
	password varchar(20),
	name varchar(20),
	dept char(10),
	professor varchar(20)
);

create table paybill(
	id int primary key,
	cause varchar(100),
	founder char(10),
	found_time datetime,
	wait_treator char(10),
	total double,
	status varchar(20)
);

create table  paybill_detail(
	id int primary key,
	paybill int,
	fee_type varchar(20),
	money double,
	descri varchar(100)
);

create table treatRecord(
	id int primary key,
	paybill int,
	treator char(10),
	treat_time datetime,
	treat_type varchar(20),
	treat_result varchar(20),
	mark varchar(100)
);

alter table staff add foreign key (dept) references department(id);
alter table paybill add foreign key (wait_treator) references staff(id);
alter table paybill add foreign key (founder) references staff(id);
alter table paybill_detail add foreign key (paybill) references paybill(id);
alter table treatRecord add foreign key (paybill) references paybill(id);
alter table treatRecord add foreign key (treator) references staff(id);