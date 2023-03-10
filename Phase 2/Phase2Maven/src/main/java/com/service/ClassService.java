package com.service;

import java.util.List;

import com.dao.ClassDao;
import com.entity.Classroom;

public class ClassService {
ClassDao cd = new ClassDao();
	
	public String addClass(Classroom cls) {
		return cd.addClass(cls) >0 ? "Class added" : "Class was not added";
	}
	
	public String deleteClass(int cid) {
		return cd.deleteClass(cid) >0 ? "Class was deleted" : "Class could not be deleted";
	}
	
	public List<Classroom> findAllClasses(){
		return cd.classList();
	}
}
