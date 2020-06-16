package com.NumberPlateDetection.dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.NumberPlateDetection.model.LoginModel;
import com.NumberPlateDetection.model.RegisterModel;

@Repository
public class RegisterDAOImp implements RegisterDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertRegister(RegisterModel RegisterModel) {
		RegisterModel.setDeleteStatus("Active");
		Session session = this.sessionFactory.getCurrentSession();
		session.save(RegisterModel);
		
	}
	
	@Override
	public List viewRegister(RegisterModel registerModel) {
		// TODO Auto-generated method stub
		List registerList = new ArrayList();
		String query = "FROM RegisterModel where deleteStatus = 'Active'";
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query registerQuery = session.createQuery(query);
			registerList = registerQuery.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return registerList;
	}

	@Override
	public List getDetection() {
		// TODO Auto-generated method stub
		
		
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createSQLQuery("SELECT detection.number_plate, detection.offence, owner.owner_name FROM detection INNER JOIN OWNER ON detection.number_plate = owner.number_plate");
		List ls = q.list();
		return ls;
	}

}
