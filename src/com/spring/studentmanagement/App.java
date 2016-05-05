package com.spring.studentmanagement;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.studentmanagement.dao.CoursesDAO;
import com.spring.studentmanagement.dao.EnrollDAO;
import com.spring.studentmanagement.dao.StudentDAO;
import com.spring.studentmanagement.pojo.Course;
import com.spring.studentmanagement.pojo.Enroll;
import com.spring.studentmanagement.pojo.Student;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-bean.xml");
//        StudentDAO studentDAO = (StudentDAO)ctx.getBean("studentDAO");
//        Student student = new Student();
//        student.setStudentFirstName("sudheer kumar");
//        student.setStudentLastName("kethireddy");
//        student.setLogonPassword("sudheer");
//        student.setStudentEmailId("sudheer.kethireddy@yahoo.com");
//        studentDAO.createStudent(student);
        
//        Course course = new Course();
//        course.setCourseId("CMPE273");
//        course.setCourseName("Software Engineering Process");
//        course.setCredits(3);
        Enroll enroll = new Enroll();
        enroll.setStudentId(1);
        enroll.setCourseId("CMPE273");
        EnrollDAO enrollDAO = (EnrollDAO)ctx.getBean("enrollDAO");
        List<Enroll> list = enrollDAO.getAllEnrollments();
        System.out.println(list.size());
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
