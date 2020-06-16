package com.NumberPlateDetection.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.NumberPlateDetection.model.OffenceModel;
import com.NumberPlateDetection.model.RegisterModel;
import com.NumberPlateDetection.service.OffenceService;


@Controller 
public class OffenceController {
	
	@Autowired
	private OffenceService offenceService;
	
	
	
	@RequestMapping(value="admin/loadOffence",method=RequestMethod.GET)
	public ModelAndView loadOffence()
	{
		return new ModelAndView("admin/addOffence","offenceData",new OffenceModel());
	}

	@RequestMapping(value="admin/insertOffence", method=RequestMethod.POST)
	public ModelAndView insertOffence(@ModelAttribute OffenceModel offenceModel)
	{
		offenceModel.setDeletestatus("Active");
		this.offenceService.insertOffence(offenceModel);
		return new ModelAndView("redirect:/admin/index");
	}
	
	@RequestMapping(value="/admin/viewOffence",method=RequestMethod.GET)
	public ModelAndView searchOffence(OffenceModel offenceModel)
	{
		
		List offenceList = this.offenceService.searchOffence(offenceModel);
		System.out.println("size of the ofence list \n\n\n\n\n\n\n\n\n"+offenceList.size());
		return new ModelAndView("user/viewDetection","viewOffence",offenceList);
	}

}
