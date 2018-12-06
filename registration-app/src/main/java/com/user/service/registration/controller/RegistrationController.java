package com.user.service.registration.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.registration.model.UserDetailDO;
import com.user.service.registration.utils.ExclusionService;
import com.user.service.registration.utils.UserCache;
import com.user.service.registration.utils.UserInputValidation;

@RestController
@RequestMapping("user/service")
public class RegistrationController {
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @param dob
	 * @param ssn
	 */
	@RequestMapping(value ="register/{userName}/{password}/{dob}/{ssn}", method = RequestMethod.GET)
	public void register(@PathVariable String userName, @PathVariable String password, 
			@PathVariable String dob, @PathVariable String ssn) {
		String test = userName;
		
		
	} 
		
	/**
	 * 
	 * @param userDetails
	 */
	@RequestMapping(value ="register", method = RequestMethod.POST)
	public void register(@RequestBody UserDetailDO userDetailDO) throws Exception {
		
		UserInputValidation.validateUserInputs(userDetailDO);
		
		UserCache.registerUserInCache(userDetailDO);
		
		if(ExclusionService.validate(userDetailDO.getDob(), userDetailDO.getSsn()))
			throw new Exception("You are blacklisted from this site!!!");
		
		
	}
	
	/**
	 * 
	 * @param userDetailDO
	 * @throws Exception
	 */
	
	@RequestMapping(value ="blacklist", method = RequestMethod.POST)
	public void addUserToExclusionList(@RequestBody UserDetailDO userDetailDO) throws Exception {
		
		UserInputValidation.validateUserInputs(userDetailDO);
		
		ExclusionService.addUserToExclusionList(userDetailDO);
		
		
	} 

}
