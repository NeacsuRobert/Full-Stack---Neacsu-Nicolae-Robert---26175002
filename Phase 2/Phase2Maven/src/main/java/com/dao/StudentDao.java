package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.entity.Student;
import com.resource.DbResource;

public class StudentDao {
SessionFactory sf;
	
	public StudentDao(){
		sf = DbResource.getSessionFactory();
	}
	
	public int addStudent(Student ss) {
		try {
			Session ses = sf.openSession();
			Transaction tran = ses.getTransaction();
			tran.begin();
			ses.save(ss);
			tran.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public int deleteStudent(int sid) {
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		Student s = session.get(Student.class, sid);
		if(s==null) {
			return 0;
		}else {
			tran.begin();
				session.delete(s);
			tran.commit();
			return 1;
		}	
	}
	
	public List<Student> studentList() {
		Session session = sf.openSession();
		TypedQuery<Student> tq = session.createQuery("from Student");
		List<Student> listOfStudent = tq.getResultList();
		return listOfStudent;
	}
}
