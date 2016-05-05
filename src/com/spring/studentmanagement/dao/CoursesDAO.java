package com.spring.studentmanagement.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.spring.studentmanagement.pojo.Course;

@Component("coursesDAO")
public class CoursesDAO extends NamedParameterJdbcDaoSupport{

	
	
	
	/**
	 * This method returns all the courses from the course table
	 * @return The list of all courses
	 */
	public List<Course> getCourses()
	{
		return getNamedParameterJdbcTemplate().query("select * from course", new CourseRowMapper());
	}

	/**
	 * This method returns the course corresponding to courseId
	 * @param courseId- the courseId whose row we want to retrieve
	 * @return The Course Row corresponding to the courseId
	 */
	public Course getCourse(String courseId)
	{
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("courseId", courseId);	
		return getNamedParameterJdbcTemplate().queryForObject("select * from course where courseId = :courseId", params, new CourseRowMapper());
	}
	
	public boolean addCourse(Course course)
	{
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(course);
		String sql = "Insert into Course(courseId,courseName,credits) values (:courseId,:courseName,:credits)";
		return (getNamedParameterJdbcTemplate().update(sql, params)==1);
	}
	
	/**
	 * This method deletes course row corresponding to the courseId
	 * @param courseId - The couseId whose row we want to delete
	 * @return
	 */
	public boolean deleteCourse(String courseId)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("courseId", courseId);
		return (getNamedParameterJdbcTemplate().update("delete from course where courseId = :courseId", params)==1);
	}
	
	
	/**
	 * This method updated course record
	 * @param course- The course POJO whose record we want to update
	 * @return true/false- based on the successfullness of updating
	 */
	public boolean updateCourse(Course course)
	{
		Course retrievedCourse = getCourse(course.getCourseId());
		if(course.getCourseName()==null)
			course.setCourseName(retrievedCourse.getCourseName());
		if(course.getCredits()==0)
			course.setCredits(retrievedCourse.getCredits());
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(course);
		
		return (getNamedParameterJdbcTemplate().update("update course set courseName = :courseName, credits = :credits where courseId = :courseId", params)==1);
	}
	
	
}
