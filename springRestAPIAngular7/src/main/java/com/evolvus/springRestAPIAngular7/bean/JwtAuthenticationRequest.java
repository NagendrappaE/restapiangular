/**
 * 
 */
package com.evolvus.springRestAPIAngular7.bean;

/**
 * @author user
 *
 */
public class JwtAuthenticationRequest {

	private String userId;
	private String password;
	private String applicationName;

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public JwtAuthenticationRequest() {
		super();
	}

	public JwtAuthenticationRequest(String username, String password, String application) {
		this.setUserId(username);
		this.setPassword(password);
		this.setApplicationName(application);
	}

}
