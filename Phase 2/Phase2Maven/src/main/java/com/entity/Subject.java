package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectId;
	
	private String subjectName;
	
	private int teacherId;

	@OneToMany
	@JoinColumn(name = "subjectId")		
	private List<Classroom> listOfClass;
	
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public List<Classroom> getListOfClass() {
		return listOfClass;
	}

	public void setListOfClass(List<Classroom> listOfClass) {
		this.listOfClass = listOfClass;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", teacherId=" + teacherId
				+ ", listOfClass=" + listOfClass + "]";
	}


	
	
}
