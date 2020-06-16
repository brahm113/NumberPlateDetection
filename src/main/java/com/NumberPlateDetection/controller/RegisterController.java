package com.NumberPlateDetection.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.NumberPlateDetection.model.LoginModel;
import com.NumberPlateDetection.model.RegisterModel;
import com.NumberPlateDetection.service.LoginService;
import com.NumberPlateDetection.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/loadRegister",method=RequestMethod.GET)
	public ModelAndView loadRegister()
	{
		return new ModelAndView("register","registerdata",new RegisterModel());
	}
	
	@RequestMapping(value="insertRegister",method=RequestMethod.POST)
	public ModelAndView insertRegister(@ModelAttribute RegisterModel registerModel,LoginModel loginModel)
	{
	
		loginModel.setUsername(registerModel.getLoginModel().getUsername());
		loginModel.setPassword(registerModel.getLoginModel().getPassword());
		loginModel.setRole("ROLE_USER");
	
		if(loginModel.getRole().equals("ROLE_USER"))
		{
		//	registerModel.setRegisterstatus("Registered");
			loginModel.setEnabled(1);
		}
		else
		{
			//registerModel.setRegisterstatus("pending");
			loginModel.setEnabled(0);
		}
		this.loginService.insertLogin(loginModel);
		registerModel.setLoginModel(loginModel);
		
		this.registerService.insertData(registerModel);
	
		return new ModelAndView("redirect:/loadRegister");
	}
	
	@RequestMapping(value="/admin/viewUser",method=RequestMethod.GET)
	public ModelAndView viewRegister(RegisterModel registerModel)
	{
		List registerList = new ArrayList();
		
		registerList = this.registerService.viewRegister(registerModel);
		System.out.println(registerList.size());
		return new ModelAndView("admin/manageUsers","viewUsers",registerList);
	}
	@RequestMapping(value="/admin/detection",method=RequestMethod.GET)
	public ModelAndView viewDetection()
	{
		//List ls= registerService.getDetection();
		//System.out.println("size"+ls.size());
		
		return new ModelAndView("admin/eMemo");
	}
}
