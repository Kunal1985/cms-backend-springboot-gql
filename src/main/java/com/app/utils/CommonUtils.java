package com.app.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.app.constants.Constants;

public class CommonUtils implements Constants {
	public static boolean checkAuthentication(Authentication authentication) {
		for (Object currAuthorityObj : authentication.getAuthorities()) {
			GrantedAuthority currAuthority = (GrantedAuthority) currAuthorityObj;
			String currAuthorityStr = currAuthority.getAuthority();
			System.out.println("currAuthoritytr" + currAuthorityStr);
			if (ROLE_ANONYMOUS.equalsIgnoreCase(currAuthorityStr))
				return false;
		}
		return true;
	}
}
