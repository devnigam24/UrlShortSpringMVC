package com.fullerton.edu.cpsc.cpsc476.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fullerton.edu.cpsc.cpsc476.Util.ErrorAndMessages;
import com.fullerton.edu.cpsc.cpsc476.Util.ShowErrorPageUtil;
import com.fullerton.edu.cpsc.cpsc476.pojo.NewUserDetails;

@Controller
public class LoginController extends MyController{
	@RequestMapping(value="LoginServlet" ,method = RequestMethod.GET)
	public ModelAndView doGet(HttpServletRequest request,NewUserDetails user,ModelMap model) {
		return this.doPost(request, user, model);
	}
	
	@RequestMapping(value="LoginServlet" ,method = RequestMethod.POST)
	public ModelAndView doPost(HttpServletRequest request,NewUserDetails user,ModelMap model) {
		if(isLoginUserValid(user, model)){
			if(checkLoginCredentials(user.getUsername(),user.getPassword())){
				ShowErrorPageUtil.setInfoMessageInModel(model, ErrorAndMessages.LOGINSUCCESS);
				user.setIsGuestUser(false);
				request.getSession().setAttribute("userInsession",user);
				return ShowErrorPageUtil.returnModalWithRequest("welcome", model);			
			}else{
				ShowErrorPageUtil.setErrorMessageInModel(model, ErrorAndMessages.LOGINCREDENTIALMISMATCH);
				return ShowErrorPageUtil.returnModalWithRequest("signUp",model);
			}
		}else{
			ShowErrorPageUtil.setErrorMessageInModel(model, ErrorAndMessages.LOGINCREDENTIALMISMATCH);
			return ShowErrorPageUtil.returnModalWithRequest("signUp",model);
		}
	}
}
