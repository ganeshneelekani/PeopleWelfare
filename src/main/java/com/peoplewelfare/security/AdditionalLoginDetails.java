package com.peoplewelfare.security;

import java.io.Serializable;

public class AdditionalLoginDetails implements Serializable {

	private static final long serialVersionUID = 1636537591424242641L;

	private Object newPassword;
	private Object confirmPassword;
	private Object hospital;

	public AdditionalLoginDetails(Object newPassword, Object confirmPassword, Object hospital) {
		super();
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
		this.hospital = hospital;
	}

	public Object getHospital() {
		return hospital;
	}

	public void setHospital(Object hospital) {
		this.hospital = hospital;
	}

	public Object getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(Object newPassword) {
		this.newPassword = newPassword;
	}

	public Object getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(Object confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


}
