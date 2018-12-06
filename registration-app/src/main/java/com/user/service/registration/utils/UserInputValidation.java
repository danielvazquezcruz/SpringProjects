package com.user.service.registration.utils;

import com.user.service.registration.model.UserDetailDO;

public class UserInputValidation {
	
	public static void validateUserInputs(UserDetailDO userDetailDO) throws Exception {
		
		validateUserName(userDetailDO.getUserName());
		
		validatePassword(userDetailDO.getPassword());
				
	}
	
	private static void validateUserName(String userName) throws Exception {
		
		if(userName == null || userName.length() == 0 || userName.trim().contains(" ")) {
			throw new Exception("User Name must be populated and should not contain spaces");
		}
	}
	
	private static void validatePassword(String password) throws Exception {
		
		char currentCharacter;
		boolean hasUpperCaseChar = false;
		boolean hasNumericChar = false;
		boolean hasMinLength = false;
		
		if(password != null && password.length() > 3)
			hasMinLength = true;
		
		for(int i=0; i < password.length(); i++) {
			currentCharacter = password.charAt(i);
			
			if(Character.isDigit(currentCharacter)){
				hasNumericChar = true;
			}
			if(Character.isUpperCase(currentCharacter)) {
				hasUpperCaseChar = true;
			}
		}
		
		if(!hasUpperCaseChar || !hasNumericChar || !hasMinLength)
			throw new Exception("Password needs to have a minimum of 4 characters, including 1 upper case and 1 numeric character");
		
	}
	
	
	

}
