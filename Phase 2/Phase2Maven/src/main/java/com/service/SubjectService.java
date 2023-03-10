package com.service;

import java.util.List;

import com.dao.SubjectDao;
import com.entity.Subject;

public class SubjectService {

SubjectDao sd = new SubjectDao();
	
	public String addSubject(Subject sub) {
		return sd.addSubject(sub) >0 ? "Subject added" : "Subject was not added";
	}
	
	public String deleteSubject(int sid) {
		return sd.deleteSubject(sid) >0 ? "Subject was deleted" : "Subject could not be deleted";
	}
	
	public List<Subject> findAllSubjects(){
		return sd.subjectList();
	}
}
