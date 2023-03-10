package com.service;

import java.util.List;

import com.dao.TeacherDao;
import com.entity.Teacher;

public class TeacherService {

	TeacherDao td = new TeacherDao();
	
	public String addTeacher(Teacher tch) {
		return td.addTeacher(tch) >0 ? "Teacher added" : "Teacher was not added";
	}
	
	public String deleteTeacher(int tid) {
		return td.deleteTeacher(tid) >0 ? "Teacher was deleted" : "Teacher could not be deleted";
	}
	
	public List<Teacher> findAllTeachers(){
		return td.teacherList();
	}
}
