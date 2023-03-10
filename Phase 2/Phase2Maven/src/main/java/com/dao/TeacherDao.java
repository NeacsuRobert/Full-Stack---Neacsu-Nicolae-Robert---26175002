package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.entity.Teacher;
import com.resource.DbResource;

public class TeacherDao {

		SessionFactory sf;
		
		public TeacherDao(){
			sf = DbResource.getSessionFactory();
		}
		
		public int addTeacher(Teacher teacher) {
			try {
				Session ses = sf.openSession();
				Transaction tran = ses.getTransaction();
				tran.begin();
				ses.save(teacher);
				tran.commit();
				return 1;
			} catch (Exception e) {
				System.out.println(e);
				return 0;
			}
		}
		
		public int deleteTeacher(int tid) {
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			Teacher t = session.get(Teacher.class, tid);
			if(t==null) {
				return 0;
			}else {
				tran.begin();
					session.delete(t);
				tran.commit();
				return 1;
			}	
		}
		
		public List<Teacher> teacherList() {
			Session session = sf.openSession();
			TypedQuery<Teacher> tq = session.createQuery("from Teacher");
			List<Teacher> listOfTeacher = tq.getResultList();
			return listOfTeacher;
		}
}
