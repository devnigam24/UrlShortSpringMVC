package com.fullerton.edu.cpsc.cpsc476.Util;

import javax.servlet.http.HttpServlet;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.fullerton.edu.cpsc.cpsc476.pojo.URL;

public class ShowErrorPageUtil extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void reditectToErrorPage() {

	}
	
	public static void setErrorMessageInModel(ModelMap model,String error) {
		model.addAttribute("errorMessage", error);
	}
	
	public static void setInfoMessageInModel(ModelMap model,String error) {
		model.addAttribute("infoMessage", error);
	}
	
	public static void setLongUrl(ModelMap model,String url) {
		model.addAttribute("longUrl", url);
	}
	
	public static void setShortUrl(ModelMap model,String url) {
		model.addAttribute("shortUrl", url);
	}
	
	public static void setUserNameInRequest(ModelMap model,String userName) {
		model.addAttribute("userName", userName);
	}
	
	public static void setURLinRequest(ModelMap model,String url) {
		model.addAttribute("longUrlToGo", url);
	}
	
	public static ModelAndView returnModalWithRequest(String page,ModelMap model) {
		return new ModelAndView(page,"requestAttribute",model);
	}

}
