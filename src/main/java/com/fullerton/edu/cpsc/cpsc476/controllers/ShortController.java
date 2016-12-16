package com.fullerton.edu.cpsc.cpsc476.controllers;

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

@Controller
@RequestMapping("Short/")
public class ShortController {

	@RequestMapping(value="*" ,method = RequestMethod.GET)
	public ModelAndView doGet(HttpServletRequest request,NewUserDetails user,ModelMap model) {
		return this.doPost(request, user, model);
	}
	
	@RequestMapping(value="*" ,method = RequestMethod.POST)
	public ModelAndView doPost(HttpServletRequest request,NewUserDetails user,ModelMap model) {
		NewUserDetails userObject = (NewUserDetails)request.getSession().getAttribute("userInsession");
		if (userObject == null) {
			userObject = new NewUserDetails("GuestUser", "noPassword", true);
			request.getSession().setAttribute("userInsession", userObject);
		}
		StringBuffer shortUrlBuffer = request.getRequestURL();
		String shortUrl = shortUrlBuffer.toString().trim();
		ApplicationContext context = new ClassPathXmlApplicationContext("dataSources/users.xml");
		JDBCNewUserDao dao = (JDBCNewUserDao) context.getBean("newUserDao");
		String longUrl = dao.getLongUrl(shortUrl);
		if(userObject.getIsGuestUser().equals(false)){
			dao.updateUrlHits(longUrl);
		}
		if(!(longUrl.contains("http://") || longUrl.contains("https://"))){
			longUrl = "http://" + longUrl;
		}		
		ShowErrorPageUtil.setURLinRequest(model, longUrl);
		return ShowErrorPageUtil.returnModalWithRequest("redirectToLongUrl", model);
	}
}
