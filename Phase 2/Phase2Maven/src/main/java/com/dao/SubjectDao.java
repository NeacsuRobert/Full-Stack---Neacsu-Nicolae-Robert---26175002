package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Subject;
import com.resource.DbResource;

public class SubjectDao {
	SessionFactory sf;
	
	public SubjectDao(){
		sf = DbResource.getSessionFactory();
	}
	
	public int addSubject(Subject subject) {
		try {
			Session ses = sf.openSession();
			Transaction tran = ses.getTransaction();
			tran.begin();
			ses.save(subject);
			tran.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public int deleteSubject(int sid) {
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		Subject s = session.get(Subject.class, sid);
		if(s==null) {
			return 0;
		}else {
			tran.begin();
				session.delete(s);
			tran.commit();
			return 1;
		}	
	}
	
	public List<Subject> subjectList() {
		Session session = sf.openSession();
		TypedQuery<Subject> tq = session.createQuery("from Subject");
		List<Subject> listOfSubject = tq.getResultList();
		return listOfSubject;
	}
}
