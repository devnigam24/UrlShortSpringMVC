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
public class SignUpController{
	
	@RequestMapping(value="gotoSignUpPage" ,method = RequestMethod.GET)
	public ModelAndView doGet() {
		return new ModelAndView("signUp","command",new NewUserDetails());
	}
	
	@RequestMapping(value="SignUpServlet" ,method = RequestMethod.POST)
	public ModelAndView doPost(HttpServletRequest request,NewUserDetails user,ModelMap model) {
		if(isUserValid(user,model)){
			return new ModelAndView("welcome",model);
		}else{
			return new ModelAndView("signUp",model);
		}
	}

	private boolean isUserValid(NewUserDetails user, ModelMap model) {
		if (user.getUsername() != null && user.getUsername() != "") {
			model.addAttribute("userName", user.getUsername());
		} else {
			ShowErrorPageUtil.setErrorMessageInModel(model, ErrorAndMessages.USERNAMENULL);
			return false;
		}
		if (user.getPassword() != null && user.getPassword() != "") {
			model.addAttribute("password", user.getPassword());
		} else {
			ShowErrorPageUtil.setErrorMessageInModel(model, ErrorAndMessages.PASSWORDNULL);
			return false;
		}
		if (user.getCpassword() != null && user.getCpassword() != "") {
			model.addAttribute("cpassword", user.getCpassword());

		} else {
			ShowErrorPageUtil.setErrorMessageInModel(model, ErrorAndMessages.PASSWORDNULL);
			return false;
		}
		if (user.getPassword().equals(user.getCpassword())) {
			return true;
		}
		return false;
	}

}
