package com.fullerton.edu.cpsc.cpsc476.controllers;

import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fullerton.edu.cpsc.cpsc476.Util.ErrorAndMessages;
import com.fullerton.edu.cpsc.cpsc476.Util.ShowErrorPageUtil;
import com.fullerton.edu.cpsc.cpsc476.dao.JDBCNewUserDao;
import com.fullerton.edu.cpsc.cpsc476.pojo.NewUserDetails;
import com.fullerton.edu.cpsc.cpsc476.pojo.URL;

@Controller
public class UrlShortnerController {
	
	private SecureRandom randomString = new SecureRandom();

	@RequestMapping(value="UrlShortnerController" ,method = RequestMethod.GET)
	public ModelAndView doGet(HttpServletRequest request,URL url,ModelMap model) {
		return this.doPost(request, url, model);
	}
	
	@RequestMapping(value="UrlShortnerController" ,method = RequestMethod.POST)
	public ModelAndView doPost(HttpServletRequest request,URL url,ModelMap model) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("dataSources/users.xml");
		JDBCNewUserDao dao = (JDBCNewUserDao) context.getBean("newUserDao");
		NewUserDetails userObject;
		userObject = (NewUserDetails) request.getSession().getAttribute("userInsession");
		if (userObject == null) {
			userObject = new NewUserDetails("GuestUser", "noPassword", true);
			request.getSession().setAttribute("userInsession", userObject);
		}

		String longUrl = url.getLongUrl();
		String shortUrl = "";
		if (longUrl.length() <= 0) {
			ShowErrorPageUtil.setErrorMessageInModel(model, ErrorAndMessages.URLNULLMESSAGE); 
			return ShowErrorPageUtil.returnModalWithRequest("welcome", model);
		}
		shortUrl = dao.getShortUrl(longUrl);
		if (shortUrl.equals("")) {
			shortUrl = "http://" + request.getServerName() + ":" + request.getLocalPort() + request.getContextPath()
					+ "/" + "Short/" + new BigInteger(30, randomString).toString(32);
			if (!dao.insertLongAndShortURL(userObject.getUsername(),longUrl, shortUrl,0)) {
				ShowErrorPageUtil.setErrorMessageInModel(model, ErrorAndMessages.URLSHORTNERUNAVAILABLE);
				return ShowErrorPageUtil.returnModalWithRequest("welcome", model);
			}
		}
		ShowErrorPageUtil.setLongUrl(model, longUrl);
		ShowErrorPageUtil.setShortUrl(model, shortUrl);
		if (userObject.getIsGuestUser().equals(Boolean.FALSE)) {
			ShowErrorPageUtil.setUserNameInRequest(model, userObject.getUsername());
			return ShowErrorPageUtil.returnModalWithRequest("welcome", model);
		} else {
			return ShowErrorPageUtil.returnModalWithRequest("publicUrlShortner", model);
		}
	}
}
