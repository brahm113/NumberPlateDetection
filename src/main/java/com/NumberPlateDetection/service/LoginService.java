package com.NumberPlateDetection.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NumberPlateDetection.dao.LoginDAO;
import com.NumberPlateDetection.model.LoginModel;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Transactional
	public void insertLogin(LoginModel loginModel)
	{
		this.loginDAO.insertLogin(loginModel);
	}

}
