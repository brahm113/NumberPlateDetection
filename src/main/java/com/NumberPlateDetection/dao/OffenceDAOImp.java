package com.NumberPlateDetection.dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.NumberPlateDetection.model.OffenceModel;

@Repository
public class OffenceDAOImp implements OffenceDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List searchOffence(OffenceModel offenceModel) {
		
		List offenceList = new ArrayList();
		try{
			
			String query = "From OffenceModel where deleteStatus = 'Active' ";
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery(query);
			offenceList = q.list();
			System.out.println("size of the ofence list \n\n\n\n\n\n\n\n\n"+offenceList.size());
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return offenceList;
		
	}

	@Override
	public void insertOffence(OffenceModel offenceModel) {
		
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();
		session.save(offenceModel);
	}


}
