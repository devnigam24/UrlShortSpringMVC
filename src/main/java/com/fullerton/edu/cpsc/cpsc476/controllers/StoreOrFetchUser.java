package com.fullerton.edu.cpsc.cpsc476.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;

import com.fullerton.edu.cpsc.cpsc476.Util.ErrorAndMessages;
import com.fullerton.edu.cpsc.cpsc476.Util.ShowErrorPageUtil;
import com.fullerton.edu.cpsc.cpsc476.dao.JDBCNewUserDao;
import com.fullerton.edu.cpsc.cpsc476.pojo.NewUserDetails;

public class StoreOrFetchUser {
	protected Boolean createNewUsr(HttpServletRequest req, NewUserDetails user, ModelMap model) {
		NewUserDetails newUser = new NewUserDetails(user.getUsername(), user.getPassword(), false);
		ApplicationContext context = new ClassPathXmlApplicationContext("dataSources/users.xml");
		JDBCNewUserDao dao = (JDBCNewUserDao) context.getBean("newUserDao");
		Boolean isUserStored = dao.inserNewUserInDB(newUser, req, model);
		if (null == isUserStored) {
			return false;
		} else {
			if (isUserStored) {
				ShowErrorPageUtil.setInfoMessageInModel(model, ErrorAndMessages.SIGNUPSUCCESSFULLMESSAAGE);
				return true;
			} else {
				ShowErrorPageUtil.setInfoMessageInModel(model, ErrorAndMessages.DATABASEDOWNNOTRANSACTIONHAPPENED);
				return false;
			}
		}
	}
	
	protected Boolean checkLoginCredentials(String username, String password) {
		ApplicationContext context = new ClassPathXmlApplicationContext("dataSources/users.xml");
		JDBCNewUserDao dao = (JDBCNewUserDao)context.getBean("newUserDao");
		return dao.authenticateThisUser(username,password);
	}
}
