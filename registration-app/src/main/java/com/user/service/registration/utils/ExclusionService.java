package com.user.service.registration.utils;

import java.util.HashMap;
import java.util.Map;

import com.user.service.registration.model.UserDetailDO;

public class ExclusionService {
	
	private static Map<String,String> excludedUsers = new HashMap<String,String>();
	
	static {
		excludedUsers.put("20005463", "1980/01/01");
	}
	
	public static boolean validate(String dob, String ssn) {
		
		boolean isExcluded = false;
		
		String storedDob = excludedUsers.get(ssn);
		
		if(storedDob != null && storedDob.equalsIgnoreCase(dob))
			isExcluded = true;
		
		return isExcluded;
	}
	
	public static void addUserToExclusionList(UserDetailDO userDetailDO) {
		
		excludedUsers.put(userDetailDO.getSsn(), userDetailDO.getDob());
	}

}
