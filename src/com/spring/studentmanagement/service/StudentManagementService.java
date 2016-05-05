package com.spring.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.studentmanagement.dao.CoursesDAO;
import com.spring.studentmanagement.dao.StudentDAO;
import com.spring.studentmanagement.pojo.Course;
import com.spring.studentmanagement.pojo.Student;

@Service("studentManagementService")
public class StudentManagementService {

	private CoursesDAO coursesDAO;
	private StudentDAO studentDAO;
		
	
	@Autowired
	public void setCoursesDAo(CoursesDAO coursesDAO)
	{
		this.coursesDAO = coursesDAO;
	}
	
	@Autowired
	public void setStudentDAO(StudentDAO studentDAO)
	{
		this.studentDAO = studentDAO;
	}
	
	public List<Course> getCourses()
	{
		return coursesDAO.getCourses();
	}
	
	
	public Student getStudent(String emailId)
	{
		return studentDAO.getStudent(emailId);
	}
}
