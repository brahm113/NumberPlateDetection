package com.NumberPlateDetection.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NumberPlateDetection.dao.ComplainDAO;
import com.NumberPlateDetection.model.ComplainModel;
import com.NumberPlateDetection.model.LoginModel;



@Service
public class ComplainService {
	
@Autowired ComplainDAO complainDAO;
	
	
	@Transactional
	public void addComplain(ComplainModel complainmodel)
	{
		complainDAO.insertComplain(complainmodel);
	}
	@Transactional
	public List searchComplianData()
	{
		List ls = complainDAO.seaechComplain();
		return ls;
	}
	@Transactional
	public List viewComplainOfUSer(ComplainModel complainmodel)
	{
		List ls = complainDAO.viewComplainUSer(complainmodel);
		return ls;
		
	}
	@Transactional
	public List updateComplain(ComplainModel complainmodel)
	{
		List ls = complainDAO.updateComplainData(complainmodel);
		return ls;
	}
	@Transactional
	public void updateReply(ComplainModel complainmodel)
	{
		complainDAO.insertUpdatedReply(complainmodel);
	}
	@Transactional
	public List userLoginId(LoginModel loginModel)
	{
		List ls=complainDAO.searchLoginIdOfUser(loginModel);
		return ls;
	}


}
