/**
 * 
 */
package com.evolvus.springRestAPIAngular7.bean;

/**
 * @author user
 *
 */
public class CustomResponse {

	private String description;
	
	private String  status;
	
	
	private Object data;
	

	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
