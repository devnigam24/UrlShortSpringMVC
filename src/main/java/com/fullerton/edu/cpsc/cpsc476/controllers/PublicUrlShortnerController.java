package com.fullerton.edu.cpsc.cpsc476.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fullerton.edu.cpsc.cpsc476.pojo.NewUserDetails;
import com.fullerton.edu.cpsc.cpsc476.pojo.URL;

@Controller
public class PublicUrlShortnerController {

	@RequestMapping(value="publicUrlShortner" ,method = RequestMethod.GET)
	public ModelAndView doGet(HttpServletRequest request,URL url,ModelMap model) {
		return this.doPost(request, url, model);
	}
	
	@RequestMapping(value="publicUrlShortner" ,method = RequestMethod.POST)
	public ModelAndView doPost(HttpServletRequest request,URL url,ModelMap model) {
		return new ModelAndView("publicUrlShortner","command",new NewUserDetails("GuestUser", "noPassword", true));
	}
}
