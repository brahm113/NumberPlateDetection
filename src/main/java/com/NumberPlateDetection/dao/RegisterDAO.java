package com.NumberPlateDetection.dao;

import java.util.*;

import com.NumberPlateDetection.model.LoginModel;
import com.NumberPlateDetection.model.RegisterModel;

public interface RegisterDAO {

	public void insertRegister(RegisterModel RegisterModel);
	
	public List viewRegister(RegisterModel RegisterModel);

	public List getDetection();
	
	
}
