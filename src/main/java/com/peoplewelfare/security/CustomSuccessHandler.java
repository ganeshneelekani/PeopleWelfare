package com.peoplewelfare.security;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	static Logger LOGGER = Logger.getLogger(CustomSuccessHandler.class);

	/**
	 * Invokes the configured {@code RedirectStrategy} with the URL returned by the
	 * {@code determineTargetUrl} method.
	 * <p>
	 * The redirect will not be performed if the response has already been committed.
	 */
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response,
						  Authentication authentication) throws IOException {

		LOGGER.info("===========================CustomSuccessHandler======================");
		String targetUrl = determineTargetUrl(request, authentication);

		if (response.isCommitted()) {
			logger.debug("Response has already been committed. Unable to redirect to "
					+ targetUrl);
			return;
		}

		getRedirectStrategy().sendRedirect(request, response, targetUrl);
	}

	/**
	 * Builds the target URL according to the logic defined in the main class Javadoc.
	 */

	protected String determineTargetUrl(HttpServletRequest request,
										Authentication authentication) {

		UserSecurityWrapper user = (UserSecurityWrapper) authentication.getPrincipal();

		// Check for the parameter and use that if available
		String targetUrl = null;
		if (getTargetUrlParameter() != null) {
			targetUrl = request.getParameter(getTargetUrlParameter());

			if (StringUtils.hasText(targetUrl)) {
				logger.debug("Found targetUrlParameter in request: " + targetUrl);

				return targetUrl;
			}
		}


		if (user.isDoctor()) {
			return "/#/activevisits";
		}
		if (user.isLabTechnician())
			return "/#/labQueue";

		if (isAlwaysUseDefaultTargetUrl()) {
			return getDefaultTargetUrl();
		}


		if (!StringUtils.hasText(targetUrl)) {
			targetUrl = getDefaultTargetUrl();
			logger.debug("Using default Url: " + targetUrl);
		}

		return targetUrl;
	}

}
