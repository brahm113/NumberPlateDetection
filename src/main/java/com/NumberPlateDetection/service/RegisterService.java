package com.NumberPlateDetection.service;

import java.util.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NumberPlateDetection.dao.RegisterDAO;
import com.NumberPlateDetection.model.RegisterModel;

@Service
public class RegisterService {
	
	@Autowired 
	RegisterDAO registerDAO;
	
	
	@Transactional
	public void insertData(RegisterModel registerModel)
	{
		this.registerDAO.insertRegister(registerModel);
	}
	
	@Transactional
	public List viewRegister(RegisterModel registerModel)
	{
		return this.registerDAO.viewRegister(registerModel);
	}
	
	@Transactional
	public List getDetection()
	{
		return this.registerDAO.getDetection();
	}
	
}
