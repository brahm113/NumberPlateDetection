package com.NumberPlateDetection.service;

import java.util.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NumberPlateDetection.dao.OffenceDAO;
import com.NumberPlateDetection.model.OffenceModel;

@Service 
public class OffenceService {
	
	@Autowired 
	OffenceDAO offenceDAO;
	
	
	@Transactional
	public void insertOffence(OffenceModel offenceModel)
	{
		this.offenceDAO.insertOffence(offenceModel);
	}
	
	@Transactional 
	public List searchOffence(OffenceModel offenceModel)
	{
		return this.offenceDAO.searchOffence(offenceModel);
	}
	

}
