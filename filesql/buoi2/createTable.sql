create schema if not exists StudentManagementSystem ;
create table if not exists `sms1` (
	id int primary key auto_increment,
    namestd varchar(45),
    mssv int,
    phone varchar(10),
    address varchar(20),
    age tinyint,
    email varchar(25),
    created_timestamp timestamp(6) not null default current_timestamp(6),
    last_updated_timestamp timestamp(6) not null default current_timestamp(6)
    
)	default charset = utf8mb4;
create table if not exists `sms2`(
	id int primary key auto_increment,
    namestd varchar(45),
    major varchar(20),
    total_student tinyint,
    teacher_name varchar(20),
    teacher_phone varchar(10),
    created_timestamp timestamp(6) not null default current_timestamp(6),
    last_updated_timestamp timestamp(6) not null default current_timestamp(6)
) default charset = utf8mb4;
create table if not exists `sms4`(
	student_id int,
    class_id int primary key auto_increment
) default charset = utf8mb4;
