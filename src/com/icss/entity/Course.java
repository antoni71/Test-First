package com.icss.entity;

public class Course {
	private String courseId;
	private String courseName;
	private Integer courseTimes;
	private Integer courseGrade;
	private String teacher;
	private String stuId;//标记是否选课
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
	public Integer getCourseTimes() {
		return courseTimes;
	}
	public void setCourseTimes(Integer courseTimes) {
		this.courseTimes = courseTimes;
	}
	public Integer getCourseGrade() {
		return courseGrade;
	}
	public void setCourseGrade(Integer courseGrade) {
		this.courseGrade = courseGrade;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

}
