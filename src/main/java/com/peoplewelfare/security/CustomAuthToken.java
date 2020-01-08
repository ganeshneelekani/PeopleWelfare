package com.peoplewelfare.security;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CustomAuthToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 7445234693288803598L;

	static Logger LOGGER = Logger.getLogger(CustomAuthToken.class);

	private Object additionalLoginDetails;

	// ~ Constructors
	// ===================================================================================================

	/**
	 * This constructor can be safely used by any code that wishes to create a
	 * <code>CustomAuthToken</code>, as the {@link #isAuthenticated()}
	 * will return <code>false</code>.
	 */
	public CustomAuthToken(Object principal, Object credentials) {
		super(principal, credentials);
		this.additionalLoginDetails = null;
	}


	public CustomAuthToken(Object principal, Object credentials, Object additionalLoginDetails) {
		super(principal, credentials);
		this.additionalLoginDetails = additionalLoginDetails;
	}

	public Object getAdditionalLoginDetails() {
		return additionalLoginDetails;
	}

	public void setAdditionalLoginDetails(Object additionalLoginDetails) {
		this.additionalLoginDetails = additionalLoginDetails;
	}

	@Override
	public void eraseCredentials() {
		// TODO Auto-generated method stub
		super.eraseCredentials();
		this.additionalLoginDetails = null;
	}


}
