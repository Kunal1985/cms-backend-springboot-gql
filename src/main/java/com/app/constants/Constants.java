package com.app.constants;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public interface Constants {
	public static final String SPRING_SECURITY_CONTEXT = "SPRING_SECURITY_CONTEXT";
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";

	public static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>() {
		private static final long serialVersionUID = 1L;
		{
			add(new SimpleGrantedAuthority(ROLE_USER));
		}
	};
}
