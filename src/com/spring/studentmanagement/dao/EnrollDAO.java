package com.spring.studentmanagement.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.spring.studentmanagement.pojo.Enroll;

@Component("enrollDAO")
public class EnrollDAO extends NamedParameterJdbcDaoSupport{
	

	public List<Enroll> getAllEnrollments()
	{
		return getJdbcTemplate().query("select * from enroll", new EnrollRowMapper());
	}

	
	public List<Enroll> getCoursesEnrolled(String studentId)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("studentId", "studentId");
		String sql = "select * from enroll where studentId=:studentId";
		return getNamedParameterJdbcTemplate().query(sql, params, new EnrollRowMapper());
	}
	

	public boolean deleteEnrollment(Enroll enroll)
	{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(enroll);
		String sql = "delete from enroll where studentId =:studentId AND courseId =:courseId";
		return (getNamedParameterJdbcTemplate().update(sql, params)==1);
	}
	
	public boolean enrollCourse(Enroll enroll)
	{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(enroll);
		String sql = "insert into enroll values (:courseId,:studentId)";
		return (getNamedParameterJdbcTemplate().update(sql, params)==1);
	}
	
	
	public boolean updateCourse(Enroll enroll)
	{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(enroll);
		String sql = "update enroll set courseId =:courseId where studentId =:studentId" ;
		return (getNamedParameterJdbcTemplate().update(sql, params)==1);
	}
	
}
