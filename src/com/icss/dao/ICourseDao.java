package com.icss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.icss.entity.Course;

public interface ICourseDao {
	@Select("select * from course")
	public List<Course> findCourse();
	@Select("select * from course where courseName like #{courseName}")
	public List<Course> findCourseByName(String courseName);
	@Insert("insert into course "
			+ "values(#{courseId},#{courseName},#{courseTimes},#{courseGrade},#{teacher});")
	public int insertCourse(Course cs);
}
