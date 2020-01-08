package com.peoplewelfare.security;

import org.apache.log4j.Logger;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("customPermissionEvaluator")
public class CustomPermissionEvaluatorImpl implements PermissionEvaluator {

	static Logger LOGGER = Logger.getLogger(CustomPermissionEvaluatorImpl.class);

	@Override
	/**
	 * <code>authentication</code> is the security token containing current session auth details (principal and authorities).
	 * <code>targetDomainObject</code> is the module for which permission is being evaluated (ex. patient register module).
	 * <code>permission</code> is the access level being checked for the <code>targetDomainObject</code>. 
	 */
	public boolean hasPermission(Authentication authentication,
								 Object targetDomainObject, Object permission) {

		boolean hasPermission = false;

		if (null == authentication || null == authentication.getAuthorities()) {
			return hasPermission;
		}
		if (null == targetDomainObject) {
			return hasPermission;
		}
		if (null == permission) {
			return hasPermission;
		}

		Privilege requestedPrivilege = new Privilege((String) permission);
		String module = (String) targetDomainObject;
		for (GrantedAuthority authority : authentication.getAuthorities()) {
			RoleSecurityWrapper role = (RoleSecurityWrapper) authority;
			if (module.equals(role.getAuthority())
					&& (null != role.getPrivileges())
					&& (role.getPrivileges().contains(requestedPrivilege))
			) {
				hasPermission = true;
				break;
			}
		}

		return hasPermission;
//		return true;
	}


	@Override
	/**
	 * <code>targetId</code> is the user for whom permission is being evaluated.
	 * <code>authentication</code> is the security token containing current session auth details (principal and authorities).
	 * <code>targetType</code> is the module for which permission is being evaluated (ex. patient register module).
	 * <code>permission</code> is the access level being checked for the <code>targetType</code>. 
	 */
	public boolean hasPermission(Authentication authentication,
								 Serializable targetId, String targetType, Object permission) {

		boolean hasPermission = false;

		if (null == authentication || null == authentication.getAuthorities()) {
			return hasPermission;
		}
		if (null == targetId) {
			return hasPermission;
		}
		if (null == targetType) {
			return hasPermission;
		}
		if (null == permission) {
			return hasPermission;
		}

		String module = targetType;
		Privilege requestedPrivilege = new Privilege((String) permission);
		for (GrantedAuthority authority : authentication.getAuthorities()) {
			RoleSecurityWrapper role = (RoleSecurityWrapper) authority;
			if (module.equals(role.getAuthority())
					&& (null != role.getPrivileges())
					&& role.getPrivileges().contains(requestedPrivilege)) {
				hasPermission = true;
				break;
			}
		}
		return hasPermission;
//		return true;
	}
}
