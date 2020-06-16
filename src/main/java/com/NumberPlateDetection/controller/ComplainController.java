package com.NumberPlateDetection.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.NumberPlateDetection.model.ComplainModel;
import com.NumberPlateDetection.model.LoginModel;
import com.NumberPlateDetection.service.ComplainService;




@Controller
public class ComplainController {

	@Autowired ComplainService complainservice;
	
	@RequestMapping(value="/user/addComplain",method=RequestMethod.GET)
	public ModelAndView addComplainOfUser()
	{
			return new ModelAndView ("user/addComplain","modelinsertcomplain",new ComplainModel());
	}
	@RequestMapping(value="/user/viewComplain",method=RequestMethod.GET)
	public ModelAndView viewComplainOfUser(HttpServletRequest request)
	{
		System.out.println("rohan200");
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("usernameofuser");
		LoginModel loginModel=new LoginModel();
		loginModel.setUsername(username);
		List ls1=complainservice.userLoginId(loginModel);
		LoginModel loginModel2=(LoginModel)ls1.get(0);
		ComplainModel complainmodel=new ComplainModel();
		complainmodel.setToId(loginModel2);
		List ls2=complainservice.viewComplainOfUSer(complainmodel);
		System.out.println(ls2+"hello");
		return new ModelAndView ("user/viewComplain","listofuserforview",ls2);
	}
	
	@RequestMapping(value="/user/insertComplain",method=RequestMethod.GET)
	public ModelAndView insertComplainOfUser(@ModelAttribute ComplainModel complainmodel,HttpServletRequest request)
	{
		System.out.println("deep");
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("usernameofuser");
		LoginModel loginModel=new LoginModel();
		loginModel.setUsername(username);
		List ls1=complainservice.userLoginId(loginModel);
		LoginModel loginModel2=(LoginModel)ls1.get(0);
		complainmodel.setFromId(loginModel2);
	
		LoginModel loginModel3=new LoginModel();
		loginModel3.setLoginId(1);
		complainmodel.setToId(loginModel3);
		complainservice.addComplain(complainmodel);
		List ls=complainservice.searchComplianData();
		
		return new ModelAndView ("user/addComplain","modelinsertcomplain",new ComplainModel());
	}
	
	@RequestMapping(value="/admin/viewComplain",method=RequestMethod.GET)
	public ModelAndView viewComplainForAdmin()
	{
		
		List ls= complainservice.searchComplianData();
		return new ModelAndView ("admin/viewComplain","modelinsertcomplain",new ComplainModel()).addObject("listofcomplain",ls);
		
	}
	
	@RequestMapping(value="/admin/replyComplain",method=RequestMethod.GET)
	public ModelAndView replyOfComplain(@ModelAttribute ComplainModel complainmodel)
	{
		System.out.println("DEEP");
		List l= complainservice.updateComplain(complainmodel);
		return new ModelAndView("admin/replyComplain","replyComplain",(ComplainModel)l.get(0));
	
	}
	@RequestMapping(value="/admin/updateComplain",method=RequestMethod.GET)
	public ModelAndView insertReplyOfComplain(@ModelAttribute ComplainModel complainmodel)
	{
		List ls1=complainservice.updateComplain(complainmodel);
		 LoginModel loginModel=new LoginModel();
		 loginModel.setLoginId(1);
		 complainmodel.setFromId(loginModel);
		 
		 
		 ComplainModel complainModel2=(ComplainModel) ls1.get(0);
		 LoginModel loginModel2=complainModel2.getFromId();
		 complainmodel.setToId(loginModel2);
		 
		 complainservice.updateReply(complainmodel);
		 List ls= complainservice.searchComplianData();
		return new ModelAndView ("admin/viewComplain","modelinsertcomplain",new ComplainModel()).addObject("listofcomplain",ls);
		
	}

}

