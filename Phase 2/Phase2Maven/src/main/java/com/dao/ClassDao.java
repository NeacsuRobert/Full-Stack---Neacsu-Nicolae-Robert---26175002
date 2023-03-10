package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Classroom;
import com.resource.DbResource;

public class ClassDao {
SessionFactory sf;
	
	public ClassDao(){
		sf = DbResource.getSessionFactory();
	}
	
	public int addClass(Classroom cls) {
		try {
			Session ses = sf.openSession();
			Transaction tran = ses.getTransaction();
			tran.begin();
			ses.save(cls);
			tran.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public int deleteClass(int cid) {
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		Classroom c = session.get(Classroom.class, cid);
		if(c==null) {
			return 0;
		}else {
			tran.begin();
				session.delete(c);
			tran.commit();
			return 1;
		}	
	}
	
	public List<Classroom> classList() {
		Session session = sf.openSession();
		TypedQuery<Classroom> tq = session.createQuery("from Classroom");
		List<Classroom> listOfClass = tq.getResultList();
		return listOfClass;
	}
}
