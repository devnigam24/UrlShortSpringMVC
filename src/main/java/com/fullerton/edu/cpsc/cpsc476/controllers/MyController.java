package com.fullerton.edu.cpsc.cpsc476.controllers;

import org.springframework.ui.ModelMap;

import com.fullerton.edu.cpsc.cpsc476.Util.ErrorAndMessages;
import com.fullerton.edu.cpsc.cpsc476.Util.ShowErrorPageUtil;
import com.fullerton.edu.cpsc.cpsc476.pojo.NewUserDetails;

public class MyController extends StoreOrFetchUser{

	protected boolean isSignUpUserValid(NewUserDetails user, ModelMap model) {
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
	
	protected boolean isLoginUserValid(NewUserDetails user, ModelMap model) {
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
		return true;
	}

}
