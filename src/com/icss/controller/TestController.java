package com.icss.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.icss.dao.ICourseDao;
import com.icss.entity.Course;
import com.icss.service.CourseService;
import com.icss.util.MybatisUtil;

@Controller
public class TestController {
	@Autowired
	private ICourseDao dao;
	@Autowired
	private CourseService service;
	
	@RequestMapping("hello")
	@ResponseBody
	public String fun(){
		return "hello";
	}
	@RequestMapping("show")
	public String fun1(){
		return "hello";
	}
	@RequestMapping("showCourse")
	@ResponseBody
	public List<Course> fun2(){
		ICourseDao dao=MybatisUtil.getMapper(ICourseDao.class);
		List<Course> list = dao.findCourse();
		return list;
	}
	@RequestMapping("showCourseByName")
	@ResponseBody
	public List<Course> fun21(String courseName){
		ICourseDao dao=MybatisUtil.getMapper(ICourseDao.class);
		List<Course> list = dao.findCourseByName("%"+courseName+"%");
		return list;
	}
	@RequestMapping("uploadPic")
	@ResponseBody
	public String fun22(String tid, @RequestParam("pic")CommonsMultipartFile pic,HttpServletRequest request) throws Exception{
		System.out.println("upload-------------------------"+tid);
		String path = request.getServletContext().getRealPath("upload");
		System.out.println(path);
		String filename=tid+System.currentTimeMillis()+".jpg";
		byte[] bt=pic.getBytes();
		FileOutputStream fout=new FileOutputStream(path+"/"+filename);
		fout.write(bt);
		fout.close();
		return "upload";
	}
	@RequestMapping("showCourseAuto")
	@ResponseBody
	public List<Course> fun3(){
		List<Course> list = dao.findCourse();
		return list;
	}
	@RequestMapping("addCourse")
	@ResponseBody
	public Course fun31(){
		Course cs=new Course();
		cs.setCourseId("c18001");
		cs.setCourseName("文学欣赏");
		cs.setCourseTimes(10);
		cs.setCourseGrade(1);
		cs.setTeacher("t1503");
		int r = dao.insertCourse(cs);
		return cs;
	}
	@RequestMapping("addCourses")
	@ResponseBody
	public List<Course> fun32(){
		List<Course> clist=new LinkedList<Course>();
		Course cs=new Course();
		cs.setCourseId("c18001");
		cs.setCourseName("文学欣赏");
		cs.setCourseTimes(10);
		cs.setCourseGrade(1);
		cs.setTeacher("t1503");
		clist.add(cs);
		cs=new Course();
		cs.setCourseId("c18002");
		cs.setCourseName("音乐欣赏");
		cs.setCourseTimes(10);
		cs.setCourseGrade(1);
		cs.setTeacher("t1502");
		clist.add(cs);
		int r = service.insertCourses(clist);
		return clist;
	}
}
