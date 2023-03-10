package com;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Classroom;
import com.entity.Student;
import com.entity.Subject;
import com.entity.Teacher;
import com.service.ClassService;
import com.service.StudentService;
import com.service.SubjectService;
import com.service.TeacherService;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Welcome! Please insert the desired operation:");
		System.out.println("1: Open Teacher menu");
		System.out.println("2: Open Subject menu");
		System.out.println("3: Open Class menu");
		System.out.println("4: Open Student menu");
		String operation = scn.next();
		switch (operation) {
		case "1": teacherMenu();break;
		case "2": subjectMenu();break;
		case "3": classMenu();break;
		case "4": studentMenu();break;
		}
		scn.close();
	}
	
	public static void teacherMenu() {
		TeacherService tchServ = new TeacherService();
		Teacher tch = new Teacher();
		Scanner scn = new Scanner(System.in);
		System.out.println("Select needed teacher operation:");
		System.out.println("1: Add a teacher");
		System.out.println("2: Delete a teacher");
		System.out.println("3: Display all teachers");
		String op = scn.next();
		switch(op) {
		case "1": 
			System.out.println("Insert teacher name:");
			tch.setName(scn.next());
			System.out.println(tchServ.addTeacher(tch));
			break;
		case "2":
			System.out.println("Insert teacher id: ");
			System.out.println(tchServ.deleteTeacher(Integer.parseInt(scn.next())));
		       
			break;
		case "3":
			System.out.println(Arrays.toString(tchServ.findAllTeachers().toArray()));
		}
		scn.close();
		
	}
	
	public static void subjectMenu() {
		SubjectService subServ = new SubjectService();
		Subject sub = new Subject();
		Scanner scn = new Scanner(System.in);
		System.out.println("Select needed subject operation:");
		System.out.println("1: Add a subject");
		System.out.println("2: Delete a subject");
		System.out.println("3: Display all subjects");
		String op = scn.next();
		switch(op) {
		case "1": 
			System.out.println("Insert subject name:");
			sub.setSubjectName(scn.next());
			System.out.println("Insert a teacher id:");
			sub.setTeacherId(Integer.parseInt(scn.next()));
			System.out.println(subServ.addSubject(sub));
			break;
		case "2":
			System.out.println("Insert subject id: ");
			System.out.println(subServ.deleteSubject(Integer.parseInt(scn.next())));
			break;
		case "3":
			System.out.println(Arrays.toString(subServ.findAllSubjects().toArray()));
		}
		scn.close();
	}
	
	public static void classMenu() {
		ClassService classServ = new ClassService();
		Classroom cls = new Classroom();
		Scanner scn = new Scanner(System.in);
		System.out.println("Select needed class operation:");
		System.out.println("1: Add a class");
		System.out.println("2: Delete a class");
		System.out.println("3: Display all classes");
		String op = scn.next();
		switch(op) {
		case "1": 
			System.out.println("Insert subject name:");
			cls.setClassName(scn.next());
			System.out.println("Insert a subject id:");
			cls.setSubjectId(Integer.parseInt(scn.next()));
			System.out.println(classServ.addClass(cls));
			break;
		case "2":
			System.out.println("Insert class id: ");
			System.out.println(classServ.deleteClass(Integer.parseInt(scn.next())));
			break;
		case "3":
			System.out.println(Arrays.toString(classServ.findAllClasses().toArray()));
		}
		scn.close();
	}
	
	public static void studentMenu() {
		StudentService studServ = new StudentService();
		Student stud = new Student();
		Scanner scn = new Scanner(System.in);
		System.out.println("Select needed student operation:");
		System.out.println("1: Add a student");
		System.out.println("2: Delete a student");
		System.out.println("3: Display all students");
		String op = scn.next();
		switch(op) {
		case "1": 
			System.out.println("Insert student name:");
			stud.setName(scn.next());
			System.out.println("Insert student email:");
			stud.setMail(scn.next());
			System.out.println("Insert a class id:");
			stud.setClassId(Integer.parseInt(scn.next()));
			System.out.println(studServ.addStudent(stud));
			break;
		case "2":
			System.out.println("Insert student id: ");
			System.out.println(studServ.deleteStudent(Integer.parseInt(scn.next())));
			break;
		case "3":
			System.out.println(Arrays.toString(studServ.findAllStudents().toArray()));
		}
		scn.close();
	}
}
