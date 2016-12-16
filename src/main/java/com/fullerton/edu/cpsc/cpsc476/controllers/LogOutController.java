package com.fullerton.edu.cpsc.cpsc476.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fullerton.edu.cpsc.cpsc476.Util.ErrorAndMessages;
import com.fullerton.edu.cpsc.cpsc476.pojo.NewUserDetails;

@Controller
public class LogOutController {
		
	@RequestMapping(value="logOut" ,method = RequestMethod.GET)
	public ModelAndView doGet(HttpServletRequest req) {
		return this.doPost(req);
	}
	
	@RequestMapping(value="logOut" ,method = RequestMethod.POST)
	public ModelAndView doPost(HttpServletRequest req) {
		req.getSession().invalidate();
		ModelAndView mv = new ModelAndView("signUp","command",new NewUserDetails());
		mv.addObject("infoMessage", ErrorAndMessages.LOGOUTMESSAGE);
		return mv;
	}
}
