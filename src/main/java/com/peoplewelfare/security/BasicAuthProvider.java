package com.peoplewelfare.security;

import com.peoplewelfare.model.Login;
import com.peoplewelfare.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component(value = "basicAuthProvider")
/**
 * Supports Username password authentication by using JDBC connections.
 * Accepts only authentication token which are instances of UsernamePasswordAuthenticationToken.
 * @author arunk_000
 *
 */
public class BasicAuthProvider implements AuthenticationProvider {

	static Logger LOGGER = Logger.getLogger(BasicAuthProvider.class);
	@Autowired
	LoginService loginService;
	@Autowired
	@Qualifier(value = "passwordEncoder")
	PasswordEncoder encoder;
	@Autowired
	private IUserSecurityService userService;
	@Value(value = "${ex.nouser}")
	private String noUserFoundEx;
	@Value(value = "${ex.nopassword}")
	private String noPasswordEx;
	@Value(value = "${ex.invalidpassword}")
	private String invalidPassword;

	@Value(value = "${ex.nohospital}")
	private String noHospital;

	@Value(value = "${ex.passwordExpired}")
	private String passwordExpired;
	@Value(value = "${ex.passwordExpired.invalidCurrentPassword}")
	private String passwordExpiredInvalidCurrentPassword;
	@Value(value = "${ex.passwordExpired.invalidPassword}")
	private String passwordExpiredInvalidPassword;
	@Value(value = "${ex.passwordExpired.resetDone}")
	private String passwordExpiredResetDone;

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {


		LOGGER.info("=====================BasicAuthProvider=============");
		CustomAuthToken authToken = (CustomAuthToken) authentication;

		String username = authToken.getName();
		Login login = new Login();
		login.setPersonId(username);
		UserDetails user = userService.loadUserByUsername(login);

		if (user == null || !user.isAccountNonExpired()) {
			throw new BadCredentialsException(noUserFoundEx);
		}
		if (!user.isCredentialsNonExpired()) {
			if (!"".equals(authToken.getCredentials()) && authToken.getCredentials() != null && authToken.getAdditionalLoginDetails() != null) {
				String currentPassword = (String) authToken.getCredentials();
				if (encoder.matches(currentPassword, user.getPassword())) {
					AdditionalLoginDetails additionalDetails = (AdditionalLoginDetails) authToken.getAdditionalLoginDetails();

				} else {
					throw new BadCredentialsException(passwordExpiredInvalidCurrentPassword);
				}

			} else {
				throw new BadCredentialsException(passwordExpired);
			}

		} else {
			if (null == authToken.getCredentials()
					|| "".equals((String) authToken.getCredentials())) {
				throw new BadCredentialsException(noPasswordEx);
			} else {

				boolean matches = encoder.matches((String) authToken.getCredentials(), user.getPassword());
				Object hospital = ((AdditionalLoginDetails) authToken.getAdditionalLoginDetails()).getHospital();
//				if(hospital == null){
//					throw new BadCredentialsException(noHospital);
//				}
//				HospitalVO hos = hospitalServiceImpl.getUserHopital(username, hospital.toString(),false);
//				validatedLogin = loginService.validateUser(user);
//				if(!matches || hos == null){
//					throw new BadCredentialsException(invalidPassword);
//				}
//				user = userService.addUserHospital(user,hos);

			}
		}
		Object hospital = ((AdditionalLoginDetails) authToken.getAdditionalLoginDetails()).getHospital();

		return userService.createAuthenticationToken(user, authentication, hospital.toString());

	}

	/**
	 * Support only username password based authentications using <code>CustomAuthToken</code>
	 */
	public boolean supports(Class<?> arg0) {
		if (CustomAuthToken.class.isAssignableFrom(arg0)) {
			return true;
		}
		return false;
	}


}
