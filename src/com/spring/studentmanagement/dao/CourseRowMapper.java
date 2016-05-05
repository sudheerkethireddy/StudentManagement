package com.spring.studentmanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.spring.studentmanagement.pojo.Course;

public class CourseRowMapper implements RowMapper<Course> {

	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();
		course.setCourseId(rs.getString("courseId"));
		course.setCourseName(rs.getString("courseName"));
		course.setCredits(rs.getInt("credits"));
		return course;
	}
}
