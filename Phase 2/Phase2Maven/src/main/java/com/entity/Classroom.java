package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classroom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classId;
	
	private String className;
	
	private int subjectId;
	
	public List<Student> getListOfStudent() {
		return listOfStudent;
	}

	public void setListOfStudent(List<Student> listOfStudent) {
		this.listOfStudent = listOfStudent;
	}

	@OneToMany
	@JoinColumn(name = "classId")		
	private List<Student> listOfStudent;

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public String toString() {
		return "Class [classId=" + classId + ", className=" + className + ", subjectId=" + subjectId
				+ ", listOfStudent=" + listOfStudent + "]";
	}
	
	
}
