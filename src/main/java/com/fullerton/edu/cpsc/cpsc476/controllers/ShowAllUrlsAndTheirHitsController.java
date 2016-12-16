package com.fullerton.edu.cpsc.cpsc476.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fullerton.edu.cpsc.cpsc476.Util.ShowErrorPageUtil;
import com.fullerton.edu.cpsc.cpsc476.dao.JDBCNewUserDao;
import com.fullerton.edu.cpsc.cpsc476.pojo.NewUserDetails;
import com.fullerton.edu.cpsc.cpsc476.pojo.URL;

@Controller
public class ShowAllUrlsAndTheirHitsController {

	@RequestMapping(value="showAllUrlsHits" ,method = RequestMethod.GET)
	public ModelAndView doGet(HttpServletRequest request,ModelMap model) {
		return this.doPost(request, model);
	}
	
	@RequestMapping(value="showAllUrlsHits" ,method = RequestMethod.POST)
	public ModelAndView doPost(HttpServletRequest request,ModelMap model) {
		NewUserDetails userObject = (NewUserDetails) request.getSession().getAttribute("userInsession");
		ApplicationContext context = new ClassPathXmlApplicationContext("dataSources/users.xml");
		JDBCNewUserDao dao = (JDBCNewUserDao)context.getBean("newUserDao");
		ArrayList<URL> myList = dao.getAllUrls(userObject.getUsername());
		model.addAttribute("URLlist", myList);
		ShowErrorPageUtil.setUserNameInRequest(model, userObject.getUsername());
		return ShowErrorPageUtil.returnModalWithRequest("UrlCounts", model);
	}
}
