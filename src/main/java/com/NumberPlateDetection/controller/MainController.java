package com.NumberPlateDetection.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.NumberPlateDetection.model.LoginModel;
import com.NumberPlateDetection.model.OffenceModel;
import com.NumberPlateDetection.service.LoginService;
import com.NumberPlateDetection.service.OffenceService;
import com.NumberPlateDetection.service.RegisterService;
import com.NumberPlateDetection.utils.BaseMethods;
//import com.NumberPlateDetection.utils.BaseMethods;
@Controller
public class MainController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	OffenceService offenceService;
	
	@Autowired
	RegisterService registerservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadLogin() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "user/viewDetection", method = RequestMethod.GET)
	public ModelAndView viewDetction(OffenceModel offenceModel) {
		
		List offenceList = this.offenceService.searchOffence(offenceModel);
		return new ModelAndView("user/viewDetection","offenceList",offenceList);
	}
	
	
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView adminIndex(LoginModel LoginModel ) {
		
		String userName = BaseMethods.getUser();
		
		
		return new ModelAndView("admin/index","userName",userName);
	}

	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public ModelAndView userIndex(OffenceModel offenceModel) {
		String userName = BaseMethods.getUser();
		List offenceList = this.offenceService.searchOffence(offenceModel);
		List ls= registerservice.getDetection();
		System.out.println("size"+ls.size());
		
		return new ModelAndView("user/index","userName",userName).addObject("viewOffence",offenceList);
		
	}
	@RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})	
	public String viewUserDetails(ModelMap model,HttpServletResponse response,HttpServletRequest request) {

		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	            request.getSession().invalidate();
	            request.getSession().setAttribute("tempStatus", "success");
	            request.getSession().setAttribute("statusText", "Logout Successfully!");
	}
	        return "login";
	        }
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView load403() {

		return new ModelAndView("login");
	}
	

}
