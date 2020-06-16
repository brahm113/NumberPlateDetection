package com.NumberPlateDetection.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.NumberPlateDetection.model.LoginModel;

@Repository
public class LoginDAOImp implements LoginDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void insertLogin(LoginModel loginModel) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(loginModel);
		
		
		
	}

}
