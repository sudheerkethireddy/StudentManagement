package com.spring.studentmanagement.pojo;

import org.springframework.stereotype.Component;

/**
 * 
 * @author sudheer kethireddy
 * This POJO holds the records of
 * the student table
 *
 */
@Component("student")
public class Student {
	
	private int studentId;
	private String studentfirstName;
	private String studentlastName;
	private String studentEmailId;
	private String logonPassword;
	
	
	public Student()
	{
		
	}
	
	
	public Student(String studentfirstName,String studentlastName, String studentEmailId)
	{
		this.studentfirstName = studentfirstName;
		this.studentlastName = studentlastName;
		this.studentEmailId = studentEmailId;
	}
	
	
	public Student(int studentId,String studentfirstName,String lastName,String studentEmailId,String logonPassword)
	{
		this.studentId = studentId;
		this.studentfirstName = studentfirstName;
		this.studentlastName = lastName;
		this.studentEmailId = studentEmailId;
		this.logonPassword = logonPassword;
	}
	
	

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentFirstName() {
		return studentfirstName;
	}
	public void setStudentFirstName(String firstName) {
		this.studentfirstName = firstName;
	}
	public String getStudentLastName() {
		return studentlastName;
	}
	public void setStudentLastName(String lastName) {
		this.studentlastName = lastName;
	}
	public String getStudentEmailId() {
		return studentEmailId;
	}
	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}
	public String getLogonPassword() {
		return logonPassword;
	}
	public void setLogonPassword(String logonPassword) {
		this.logonPassword = logonPassword;
	}
	
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + studentfirstName + ", lastName=" + studentlastName
				+ ", studentEmailId=" + studentEmailId + ", logonPassword=" + logonPassword + "]";
	}

}
