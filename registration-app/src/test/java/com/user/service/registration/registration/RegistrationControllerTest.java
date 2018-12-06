package com.user.service.registration.registration;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.user.service.registration.controller.RegistrationController;
import com.user.service.registration.model.UserDetailDO;
import com.user.service.registration.utils.UserCache;

public class RegistrationControllerTest {
	
	@Test (expected  = Exception.class)
	public void register_InvalidUserName_ExceptionThrown() throws Exception {
		
		RegistrationController registrationController = new RegistrationController();
		registrationController.register(new UserDetailDO("John Wick", "$!Da51", "1990/11/24","512512"));
	}
	
	@Test (expected  = Exception.class)
	public void register_InvalidPassword_MissingNumeric_ExceptionThrown() throws Exception {
		
		RegistrationController registrationController = new RegistrationController();
		registrationController.register(new UserDetailDO("JohnWick", "Test", "1990/11/24","512512"));
	}
	
	@Test (expected  = Exception.class)
	public void register_InvalidPassword_MissingUpperCase_ExceptionThrown() throws Exception {
		
		RegistrationController registrationController = new RegistrationController();
		registrationController.register(new UserDetailDO("JohnWick", "test1", "1990/11/24","512512"));
	}
	
	@Test (expected  = Exception.class)
	public void register_InvalidPassword_MissingMinLength_ExceptionThrown() throws Exception {
		
		RegistrationController registrationController = new RegistrationController();
		registrationController.register(new UserDetailDO("JohnWick", "Tt1", "1990/11/24","512512"));
	}
	
	@Test (expected  = Exception.class)
	public void register_excludedUser_ExceptionThrown() throws Exception {
		
		RegistrationController registrationController = new RegistrationController();
		registrationController.register(new UserDetailDO("Maximus", "Rome1", "1980/01/01","20005463"));
	}
	
	@Test (expected  = Exception.class)
	public void register_userAlreadyExists_ExceptionThrown() throws Exception {
		
		UserDetailDO userDetail = new UserDetailDO("Vader", "!Empire1", "1960/01/01","457694");
		
		RegistrationController registrationController = new RegistrationController();
		registrationController.register(userDetail);
		
		registrationController.register(userDetail);
	}
	
	@Test
	public void register_successfull_UserAdded() throws Exception{
		
		UserDetailDO userDetail = new UserDetailDO("Picard", "Federation1", "2000/01/01","457694");
		
		RegistrationController registrationController = new RegistrationController();
		registrationController.register(userDetail);
		
		assertEquals(userDetail.getUserName(),UserCache.searchForUserName(userDetail.getUserName()));
	}
	

}
