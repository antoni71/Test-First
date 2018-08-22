package com.icss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.icss.dao.ICourseDao;
import com.icss.entity.Course;

@Component
public class CourseService {
	@Autowired
	private ICourseDao dao;
	
	@Transactional
	public int insertCourses(List<Course> css){
		int r=0;
		for (Course cs : css) {
			r+=dao.insertCourse(cs);
		}
		return r;
	}
}
