package com.peoplewelfare.security;

import com.peoplewelfare.form.PersonDetailVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class UserSecurityWrapper extends User implements UserDetails {

	/**
	 *
	 */
	private static final long serialVersionUID = -6015984886527553486L;
	/*
	 * private String username; private String password;
	 */
	private String localId;
	private String guid;
	private String hospitalId;
	private String fullname;
	private String staffCode;
	private Long staffId;
	private String staffTypeCode;
	private String staffTypeDescription;
	private Integer staffType;
	private String sysUserId;
	private String department;
	private String proxyStaffCode;
	private PersonDetailVO personDetail;
	public UserSecurityWrapper() {
		super(null, null, null);
	}
	public UserSecurityWrapper(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		/*
		 * this.username=username; this.password=password;
		 */

/*			if (this.getAuthorities() == null) {
				this.authorities = new ArrayList<>();
			}
*/
	}
	public UserSecurityWrapper(String username, String password, boolean enabled, boolean accountNonExpired,
							   boolean credentialsNonExpired, boolean accountNonLocked,
							   Collection<? extends GrantedAuthority> authorities) {

		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}


	//private List<GrantedAuthority> authorities;
	/*
	 * private boolean accountNonExpired = true; private boolean
	 * accountNonLocked = true; private boolean credentialsNonExpired = true;
	 * private boolean enabled = true;
	 */

/*	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}
*/
	/*
	 * public String getPassword() { // TODO Auto-generated method stub return
	 * this.password; }
	 *
	 * public String getUsername() { // TODO Auto-generated method stub return
	 * this.username; }
	 */

	/*
	 * public boolean isAccountNonExpired() { // TODO Auto-generated method stub
	 * return this.accountNonExpired; }
	 *
	 * public boolean isAccountNonLocked() { // TODO Auto-generated method stub
	 * return this.accountNonLocked; }
	 *
	 * public boolean isCredentialsNonExpired() { // TODO Auto-generated method
	 * stub return this.credentialsNonExpired; }
	 *
	 * public boolean isEnabled() { // TODO Auto-generated method stub return
	 * enabled; }
	 */

	public PersonDetailVO getPersonDetail() {
		return personDetail;
	}

	public void setPersonDetail(PersonDetailVO personDetail) {
		this.personDetail = personDetail;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}


	/*
	 * public void setUsername(String username) { this.username = username; }
	 *
	 * public void setPassword(String password) { this.password = password; }
	 */

/*	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}*/

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

//	@Override
//	public String toString() {
//		return "UserSecurityWrapper [fullname=" + fullname + "]";
//	}

	public String getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}

	@Override
	public String toString() {
		return "UserSecurityWrapper [localId=" + localId + ", guid=" + guid + ", hospitalId=" + hospitalId
				+ ", fullname=" + fullname + ", staffCode=" + staffCode + ", staffId=" + staffId + ", staffTypeCode="
				+ staffTypeCode + ", staffTypeDescription=" + staffTypeDescription + ", staffType=" + staffType
				+ ", sysUserId=" + sysUserId + ", department=" + department + ", proxyStaffCode=" + proxyStaffCode
				+ ", hospital=" + personDetail + "]";
	}

	public String getStaffTypeCode() {
		return staffTypeCode;
	}

	public void setStaffTypeCode(String staffTypeCode) {
		this.staffTypeCode = staffTypeCode;
	}

	public String getStaffTypeDescription() {
		return staffTypeDescription;
	}

	public void setStaffTypeDescription(String staffTypeDescription) {
		this.staffTypeDescription = staffTypeDescription;
	}

	public Integer getStaffType() {
		return staffType;
	}

	public void setStaffType(Integer staffType) {
		this.staffType = staffType;
	}

	public final boolean isDoctor() {
		if (getStaffTypeCode() != null && ("DR".equalsIgnoreCase(getStaffTypeCode()))) {
			return true;
		}
		return false;
	}

	public boolean isLabTechnician() {
		if (getStaffTypeCode() != null && ("LB".equalsIgnoreCase(getStaffTypeCode()))) {
			return true;
		}
		return false;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProxyStaffCode() {
		return proxyStaffCode;
	}

	public void setProxyStaffCode(String proxyStaffCode) {
		this.proxyStaffCode = proxyStaffCode;
	}

	/*
	 * public void setAccountNonExpired(boolean accountNonExpired) {
	 * this.accountNonExpired = accountNonExpired; }
	 *
	 * public void setAccountNonLocked(boolean accountNonLocked) {
	 * this.accountNonLocked = accountNonLocked; }
	 *
	 * public void setCredentialsNonExpired(boolean credentialsNonExpired) {
	 * this.credentialsNonExpired = credentialsNonExpired; }
	 *
	 * public void setEnabled(boolean enabled) { this.enabled = enabled; }
	 */

	public String getJsonString() {
		return "";
	}
}
