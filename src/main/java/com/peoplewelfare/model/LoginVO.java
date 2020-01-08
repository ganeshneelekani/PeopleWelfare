package com.peoplewelfare.model;

import java.io.Serializable;

public class LoginVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5719668555124028056L;
    private String username;
    private String password;
    private String redirectUrl;
    private boolean rememberMe;
    private int loginAttemptNumber = 0;
    public LoginVO() {
    }
    public LoginVO(String username) {
        super();
        this.username = username;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public int getLoginAttemptNumber() {
        return loginAttemptNumber;
    }

    public void setLoginAttemptNumber(int loginAttemptNumber) {
        this.loginAttemptNumber = loginAttemptNumber;
    }
}
