package com.spring.studentmanagement.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.spring.studentmanagement.pojo.Student;

/**
 * This class has the logic to
 * access the student tables
 * POJO
 * @author sudheer kethireddy
 *
 */
@Component("studentDAO")
public class StudentDAO extends NamedParameterJdbcDaoSupport{
	
	
	
	/**
	 * This method retrives all students that are there
	 * in the table
	 * @return List of all students in the student table
	 */
	public List<Student> getStudents()
	{
		return getNamedParameterJdbcTemplate().query("select * from student", new StudentRowMapper());
	}
	
	/**
	 * 
	 * @param studentId - the studentId whose record we want to retrieve
	 * @return - The POJO ( record) for the student with the specified
	 * studentId          
	 */
	public Student getStudent(int studentId)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("studentId", studentId);
		
		String sql = "select * from student where studentId = :studentId";
		return getNamedParameterJdbcTemplate().queryForObject(sql, params, new StudentRowMapper());
	}
	
	
	/**
	 * @param emailId - emailId of the student whose record we want to retrieve
	 * @return- The POJO ( record) for the student with specified emailId
	 */
	public Student getStudent(String emailId)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("studentEmailId", emailId);
		String sql = "select * from student where studentEmailId = :studentEmailId";
		Student student =  getNamedParameterJdbcTemplate().queryForObject(sql, params, new StudentRowMapper());
		System.out.println("student ="+student);
		return student;
	}
	
	/**
	 * 
	 * @param student - The student POJO which we want to insert
	 * @return true/false- based on the successfulness of insertion of record into 
	 * student table in the database
	 */
	public boolean createStudent(Student student)
	{
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(student);
		return (getNamedParameterJdbcTemplate().update("insert into student(studentFirstName,studentLastName,studentEmailId,logonPassword) values (:studentFirstName,:studentLastName,:studentEmailId,:logonPassword)", params)==1);
	}
	
	/**
	 * 
	 * @param student- The POJO record whose details we want to update
	 * @return - true/false based on the successfulness of updating 
	 * the corresponding student record.
	 */
	public boolean updateStudent(Student student)
	{
		Student retrievedStudent = getStudent(student.getStudentId());
		
		// lets fill in the unfilled values with the retrieved values first
		if(student.getStudentFirstName()==null)
			student.setStudentFirstName(retrievedStudent.getStudentFirstName());
		if(student.getStudentLastName()==null)
			student.setStudentLastName(retrievedStudent.getStudentLastName());
		if(student.getLogonPassword()==null)
			student.setLogonPassword(retrievedStudent.getLogonPassword());
		if(student.getStudentEmailId()==null)
			student.setStudentEmailId(retrievedStudent.getStudentEmailId());
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(student);
		return (getNamedParameterJdbcTemplate().update("update student set studentFirstName=:studentFirstName,studentLastName=:studentLastName,studentEmailId=:studentEmailId,logonPassword=:logonPassword where id = :id", params)==1);
		
	}
	
	/**
	 * This method deletes student record from database with specified emailId
	 * @param emailId- the emailId of the student whose records we want to remove
	 * @return- true/false- based on the success of deleting record
	 */
	public boolean deleteStudent(String emailId)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("studentEmailId", emailId);
		String sql = " delete from student where studentEmailId =:studentEmailId";
		return (getNamedParameterJdbcTemplate().update(sql,params)==1);
	}
	
	
	/**
	 * This method deletes student record from database with specified studentId
	 * @param id- the studentId of the student whose records we want to remove
	 * @return- true/false- based on the success of deleting record
	 */
	public boolean deleteStudent(int id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("studentId", id);
		String sql = " delete from student where studentId =:studentId";
		return (getNamedParameterJdbcTemplate().update(sql,params)==1);
	}
}
