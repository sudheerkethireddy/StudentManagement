package com.spring.studentmanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.spring.studentmanagement.pojo.Enroll;

public class EnrollRowMapper implements RowMapper<Enroll> {

	public Enroll mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Enroll enroll = new Enroll();
		enroll.setCourseId(rs.getString("courseId"));
		enroll.setStudentId(rs.getInt("studentId"));
		return enroll;
	}

}
