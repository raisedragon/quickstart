package com.raise.web.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 上下文工具类
 * @author raise
 *
 */
public class ContextUtil {
	
	
	/**
	 * 获取当前用户
	 * @return
	 */
	public static User currentUser(){
		User user = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication.getPrincipal() instanceof UserDetails){
			user = (User) authentication.getPrincipal();
		} else if (authentication.getDetails() instanceof UserDetails) {
			user = (User) authentication.getDetails();
        } else {
            throw new AccessDeniedException("User not properly authenticated.");
        }
        return user;
	}
}
