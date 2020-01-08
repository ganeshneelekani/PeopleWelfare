package com.peoplewelfare.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class RoleSecurityWrapper implements GrantedAuthority {

	/**
	 *
	 */
	private static final long serialVersionUID = 1189193357514610299L;
	private String name;
	private List<Privilege> privileges;

	public RoleSecurityWrapper(String name, List<Privilege> privileges) {
		super();
		this.name = name;
		this.privileges = privileges;
	}

	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

}
