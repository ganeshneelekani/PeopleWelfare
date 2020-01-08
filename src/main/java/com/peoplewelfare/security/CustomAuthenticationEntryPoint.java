package com.peoplewelfare.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CustomAuthenticationEntryPoint extends ALoginUrlAuthenticationEntryPoint {

	static Logger LOGGER = Logger.getLogger(CustomAuthenticationEntryPoint.class);

	@Value(value = "/loginUser")
	String loginPage;

	public CustomAuthenticationEntryPoint(String loginFormUrl) {
		super(loginFormUrl);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {

		LOGGER.info("====================================1 Security===============");

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String apiPath = contextPath + "/";
		boolean baseUrl = requestURI.equalsIgnoreCase(apiPath);

		LOGGER.info("=======================requestURI==========================" + requestURI);
		LOGGER.info("===========================contextPath======================" + contextPath);
		LOGGER.info("========================apiPath=========================" + apiPath);


		String uiPath = contextPath + "/" + loginPage;
		String printPath = contextPath + "/print";
		boolean isPrint = requestURI.startsWith(printPath);
		boolean isUi = requestURI.startsWith(uiPath);

		super.commence(request, response, authException);
//		if ( "true".equalsIgnoreCase(request.getHeader("X-Ajax-call")))
//		if(!isUi && !baseUrl && !isPrint)
//		{
////			RestApiError restApiError = new RestApiError(RestApiHttpStatus.UNAUTHORIZED);
////			restApiError.setApiCode(ApiErrorCodes.SESSION_EXPIRED);
////			restApiError.setDeveloperMessage("The server side http session has expired, user needs to login in again");
////			restApiError.setUserMessage("<strong>Your account was signed out for your security, because of a lack of activity.</strong>");
////			restApiError.setRedirectUrl(loginPage);
////			String json = JacksonUtils.toJSON(restApiError);
////			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
////			response.setStatus(HttpStatus.UNAUTHORIZED.value());
////			response.getWriter().println(json);
//
//		} else
//		{
//
//			super.commence(request, response, authException);
//		}
	}
}
