package com.peoplewelfare.security;

import com.peoplewelfare.model.Login;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface IUserSecurityService {

	UserSecurityWrapper loadUserByUsername(Login login) throws UsernameNotFoundException;

	UsernamePasswordAuthenticationToken createAuthenticationToken(UserDetails user, Authentication authentication,
																  String hospitalCode);
}
