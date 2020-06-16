package com.NumberPlateDetection.dao;

import java.util.List;
import com.NumberPlateDetection.model.ComplainModel;
import com.NumberPlateDetection.model.LoginModel;


public interface ComplainDAO {
	
	public void insertComplain(ComplainModel complainModel);
    public List seaechComplain();
    public List updateComplainData(ComplainModel complainModel);
    public void insertUpdatedReply(ComplainModel complainModel);
    public List searchLoginIdOfUser(LoginModel loginModel);
    public List viewComplainUSer(ComplainModel complainModel);
}
