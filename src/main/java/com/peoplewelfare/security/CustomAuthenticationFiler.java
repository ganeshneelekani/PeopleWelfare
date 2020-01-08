package com.peoplewelfare.security;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomAuthenticationFiler extends UsernamePasswordAuthenticationFilter {

    static Logger LOGGER = Logger.getLogger(CustomAuthenticationFiler.class);

    private final String NEW_PASSWORD_PARAMETER = "newPassword";
    private final String CONFIRM_PASSWORD_PARAMETER = "confirmPassword";
    private final String LOCATION_PARAMETER = "hospital";

    private String newPasswordParameter = NEW_PASSWORD_PARAMETER;
    private String confirmPasswordParameter = CONFIRM_PASSWORD_PARAMETER;

    private boolean postOnly = false;
    private String defaultTargetURL = null;


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {


        LOGGER.info("===========================CustomAuthenticationFiler======================");
        if (postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        String username = obtainUsername(request);
        String password = obtainPassword(request);
        String newPassword = obtainNewPassword(request);
        String confirmPassword = obtainConfirmPassword(request);
        String locationCode = obtainHospitalCode(request);

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        final AdditionalLoginDetails additionDetails = new AdditionalLoginDetails(newPassword, confirmPassword, locationCode);

        username = username.trim();

        CustomAuthToken authRequest = new CustomAuthToken(
                username, password, additionDetails);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    protected String obtainNewPassword(HttpServletRequest request) {
        return request.getParameter(newPasswordParameter);
    }

    protected String obtainConfirmPassword(HttpServletRequest request) {
        return request.getParameter(confirmPasswordParameter);
    }

    protected String obtainHospitalCode(HttpServletRequest request) {
        return request.getParameter(LOCATION_PARAMETER);
    }


    public boolean isPostOnly() {
        return postOnly;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public String getDefaultTargetURL() {
        return defaultTargetURL;
    }

    public void setDefaultTargetURL(String defaultTargetURL) {
        this.defaultTargetURL = defaultTargetURL;
    }

    public String getNewPasswordParameter() {
        return newPasswordParameter;
    }

    public void setNewPasswordParameter(String newPasswordParameter) {
        this.newPasswordParameter = newPasswordParameter;
    }

    public String getConfirmPasswordParameter() {
        return confirmPasswordParameter;
    }

    public void setConfirmPasswordParameter(String confirmPasswordParameter) {
        this.confirmPasswordParameter = confirmPasswordParameter;
    }

}
