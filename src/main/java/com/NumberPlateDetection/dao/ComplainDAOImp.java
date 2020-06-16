package com.NumberPlateDetection.dao;

import java.util.List;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.NumberPlateDetection.model.ComplainModel;
import com.NumberPlateDetection.model.LoginModel;

@Repository
public class ComplainDAOImp implements ComplainDAO {
	
	
    
	
		@Autowired
		private SessionFactory sessionFactory;

		public void setSessionFactory(SessionFactory sf) {
			this.sessionFactory = sf;
		}
		
		public void insertComplain(ComplainModel complainModel) {
			 Date d = new Date();
			 complainModel.setComplainStatus("pending");
			 complainModel.setComplainDate((new java.sql.Date(System.currentTimeMillis()).toString()));
			complainModel.setComplainTime(java.time.LocalTime.now().toString());
			Session session = this.sessionFactory.getCurrentSession();
			session.save(complainModel);
		}

		@Override
		public List seaechComplain() {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ComplainModel");
			List ls=q.list();
			return ls;
		}

		@Override
		public List updateComplainData(ComplainModel complainModel) {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ComplainModel where complainid='"+complainModel.getComplainId()+"'");
			List ls=q.list();
			return ls;
		}
		public void insertUpdatedReply(ComplainModel complainModel) {
			
			complainModel.setComplainDate((new java.sql.Date(System.currentTimeMillis()).toString()));
			complainModel.setComplainTime(java.time.LocalTime.now().toString());
			complainModel.setComplainStatus("Replied");
			Session session = this.sessionFactory.getCurrentSession();
			session.update(complainModel);
		}

		@Override
		public List searchLoginIdOfUser(LoginModel loginModel) {
			// TODO Auto-generated method stub
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LoginModel where username='"+loginModel.getUsername()+"'");
			List ls=q.list();
			return ls;
		}

		@Override
		public List viewComplainUSer(ComplainModel complainModel) {
			
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ComplainModel where toId='"+complainModel.getToId().getLoginId()+"' AND complainstatus='Replied' ");
			List ls=q.list();
			System.out.println(ls);
		return ls;
		}
		
}

