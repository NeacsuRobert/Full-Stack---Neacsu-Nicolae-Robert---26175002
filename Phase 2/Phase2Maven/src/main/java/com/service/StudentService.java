package com.service;

import java.util.List;

import com.dao.StudentDao;
import com.entity.Student;

public class StudentService {
StudentDao sd = new StudentDao();
	
	public String addStudent(Student cls) {
		return sd.addStudent(cls) >0 ? "Student added" : "Student was not added";
	}
	
	public String deleteStudent(int cid) {
		return sd.deleteStudent(cid) >0 ? "Student was deleted" : "Student could not be deleted";
	}
	
	public List<Student> findAllStudents(){
		return sd.studentList();
	}
}
