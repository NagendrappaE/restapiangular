package com.evolvus.springRestAPIAngular7.bean;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class SimpleCORSFilter implements Filter {

	@Value("${cors.url}")
	private String corsUrl;

	@Value("${cors.xframe.option}")
	private String xframOption;

	public static final String NO_CACHE = "no-cache";

	@Override
	public void destroy() {

		// Do nothing because of X and Y.
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		request.getHeader("Origin");
		request.getHeader("HTTP_X_FORWARDED_FOR");
		req.getRemoteAddr();
		req.getRemoteHost();
		req.getParameterMap();
//		
//		if(HttpMethod.OPTIONS.matches(request.getMethod()) || HttpMethod.TRACE.matches(request.getMethod())) {
//			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
//		} 
		
		HttpMethod.OPTIONS.matches(request.getMethod());
		request.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD);
		response.setHeader("Access-Control-Allow-Origin", corsUrl);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Accept, X-Requested-With, remember-me,Authorization");
		response.setHeader("Cache-Control",
				"cache,no-store, must-revalidate,pre-check=0, post-check=0, max-age=0, s-maxage=0");

		/*
		 * response.setDateHeader("expires", -1);
		 * 
		 * response.addHeader("x-frame-options", xframOption);
		 * 
		 * response.setHeader("X-XSS-Protection", "1; mode=block");
		 * 
		 * response.setHeader("X-Content-Type-Options", "nosniff");
		 */
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// Do nothing because of X and Y.

	}

}
