package com.peoplewelfare.security;

import com.peoplewelfare.model.LoginVO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component(value = "customAuthFailureHandler")
public class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    static Logger LOGGER = Logger.getLogger(CustomAuthFailureHandler.class);

    @Value(value = "${ex.nouser}")
    String noUserFoundEx;
    @Value(value = "${ex.nopassword}")
    String noPasswordEx;
    @Value(value = "${ex.invalidpassword}")
    String invalidPassword;
    @Value(value = "${sec.defaultLoginPage}")
    String defaultLoginPage;
    @Value(value = "${sec.credentialsExpired}")
    String resetCredentials;
    @Value(value = "${ex.passwordExpired}")
    private String passwordExpired;
    @Value(value = "${ex.passwordExpired.invalidCurrentPassword}")
    private String passwordExpiredInvalidCurrentPassword;
    @Value(value = "${ex.passwordExpired.invalidPassword}")
    private String passwordExpiredInvalidPassword;
    @Value(value = "${ex.passwordExpired.resetDone}")
    private String passwordExpiredResetDone;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {


        LOGGER.info("=======================Inside CustomAuthFailureHandler=================");

        String errMessage = exception.getMessage();

        if (noUserFoundEx.equals(errMessage)) {
            request.getSession(true).setAttribute("errorKey", errMessage);
            response.sendRedirect(defaultLoginPage);
        } else {

            final LoginVO login = constructTempLoginObject(request, true);

            if (passwordExpired.equals(errMessage) || passwordExpiredInvalidPassword.equals(errMessage)
                    || passwordExpiredInvalidCurrentPassword.equals(errMessage)) {
                request.getSession(true).setAttribute("errorKey", errMessage);
                response.sendRedirect(resetCredentials);
            } else if (passwordExpiredResetDone.equals(errMessage)) {
                request.getSession(true).setAttribute("errorKey", errMessage);
                response.sendRedirect(defaultLoginPage);
            } else if (noPasswordEx.equals(errMessage) || invalidPassword.equals(errMessage)) {
                if (login.getLoginAttemptNumber() > 1 || invalidPassword.equals(errMessage)) {
                    request.getSession(true).setAttribute("errorKey", errMessage);
                }
                response.sendRedirect(defaultLoginPage);
            } else {
                response.sendRedirect(defaultLoginPage);
            }
        }

    }

    private LoginVO constructTempLoginObject(HttpServletRequest request, boolean replaceSessionObject) {
        LoginVO login = null;
        if (request.getSession(true).getAttribute("tempLogin") != null) {
            login = (LoginVO) request.getSession(true).getAttribute("tempLogin");
            if (!request.getParameter("username").equals(login.getUsername())) {
                login = new LoginVO(request.getParameter("username"));
                if (replaceSessionObject) {
                    request.getSession(true).removeAttribute("tempLogin");
                }
            }
        } else {
            login = new LoginVO(request.getParameter("username"));
            if (request.getParameter("redirectUrl") != null) {
                login.setRedirectUrl(request.getParameter("redirectUrl"));
            }
        }

        login.setLoginAttemptNumber(login.getLoginAttemptNumber() + 1);

        if (replaceSessionObject) {
            request.getSession(true).setAttribute("tempLogin", login);
        }
        return login;
    }

}
