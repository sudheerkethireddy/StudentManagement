create database studentmanagement;

use studentmanagement;


create table student
(studentId int auto_increment,
 studentFirstName varchar(50),
 studentLastName varchar(50),
 studentEmailId varchar(50),
 logonPassword varchar(34),
 primary key (studentId)
 );
 
 create table course
 (
   courseId varchar(10),
   courseName varchar(35),
   credits int,
   primary key (courseId)
 );
 
 
 create table enroll
 (
	courseId varchar(10),
    studentId int,
    foreign key fk_course(courseId) references course(courseId),
    foreign key fk_studentId(studentId) references student(studentId),
    constraint enroll_pk primary key (courseId,studentId)
 );
 
commit;
