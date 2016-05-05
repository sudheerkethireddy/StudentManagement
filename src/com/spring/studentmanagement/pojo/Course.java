package com.spring.studentmanagement.pojo;

import org.springframework.stereotype.Component;

/**
 * This POJO holds the records of the Course table 
 * @author skethireddy2
 *
 */

@Component("course")
public class Course {

	private String courseId;
	private String courseName;
	private int credits;
	
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", credits=" + credits + "]";
	}
	
	
	
}
