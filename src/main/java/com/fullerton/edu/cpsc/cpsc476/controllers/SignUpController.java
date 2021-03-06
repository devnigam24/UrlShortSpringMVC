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
public class SignUpController extends MyController{
	
	@RequestMapping(value="gotoSignUpPage" ,method = RequestMethod.GET)
	public ModelAndView doGet() {
		return new ModelAndView("signUp","command",new NewUserDetails());
	}
	
	@RequestMapping(value="SignUpServlet" ,method = RequestMethod.POST)
	public ModelAndView doPost(HttpServletRequest request,NewUserDetails user,ModelMap model) {
		if(isSignUpUserValid(user,model)){
			if(super.createNewUsr(request,user,model)){
				user.setIsGuestUser(false);
				request.getSession().setAttribute("userInsession",user);
				return ShowErrorPageUtil.returnModalWithRequest("welcome", model);
			}else{
				return ShowErrorPageUtil.returnModalWithRequest("signUp",model);
			}			
		}else{
			return ShowErrorPageUtil.returnModalWithRequest("signUp",model);
		}
	}

}
