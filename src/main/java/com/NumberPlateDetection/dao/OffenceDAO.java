package com.NumberPlateDetection.dao;

import java.util.*;

import com.NumberPlateDetection.model.OffenceModel;


public interface OffenceDAO {

	
	public void insertOffence(OffenceModel offenceModel);
	
	public List searchOffence(OffenceModel offenceModel);
}
