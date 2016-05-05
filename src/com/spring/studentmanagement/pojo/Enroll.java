package com.spring.studentmanagement.pojo;

import org.springframework.stereotype.Component;

@Component("enroll")
public class Enroll {
	
	private String courseId;
	private int studentId;

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	@Override
	public String toString() {
		return "Enroll [courseId=" + courseId + ", studentId=" + studentId + "]";
	}
	
	

}
