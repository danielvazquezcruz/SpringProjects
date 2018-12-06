package com.user.service.registration.utils;

import java.util.HashMap;
import java.util.Map;

import com.user.service.registration.model.UserDetailDO;

public class UserCache {
	
	private static Map<String, String> userCache;

	public static void registerUserInCache(UserDetailDO userDetailDO) throws Exception{
		
		if(userCache == null)
			userCache = new HashMap<String,String>();
		
		if(userCache.get(userDetailDO.getUserName()) != null) {
			throw new Exception("User ID " + userDetailDO.getUserName() + " already exists!!");
		}
		else {
			userCache.put(userDetailDO.getUserName(), userDetailDO.getUserName());
		}
		
	}
	
	public static String searchForUserName(String userName) {
		
		if(userCache != null)
			return userCache.get(userName);
		else
			return null;
		
	}
		
}
