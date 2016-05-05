package com.spring.studentmanagement.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.studentmanagement.pojo.Course;
import com.spring.studentmanagement.pojo.Student;
import com.spring.studentmanagement.service.StudentManagementService;

@Controller		
public class StudentController {
	
	
	private StudentManagementService studentManagementService;
	
	
	@Autowired
	public void setStudentManagementService(StudentManagementService studentManagementService) {
		this.studentManagementService = studentManagementService;
	}
	
	@RequestMapping("/courses")
	public String showCoursesOffered(Model model)
	{
		List<Course> courses = studentManagementService.getCourses();
		model.addAttribute("courses", courses);
		return "allcourses";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(HttpServletRequest request)
	{
		String emailId = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		Student student = 	studentManagementService.getStudent(emailId);
		if(student==null || emailId == null || password == null)
			return "error";
		else
		{
			if(student.getLogonPassword().equals(password))
				return "success";
			else
				return "error";
		}
	}
}
