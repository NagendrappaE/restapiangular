package com.evolvus.springRestAPIAngular7.bean;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("slave")
public class SlaveController {
	
	
	@GetMapping("process")
	public String processSlaveRequest() {
	String	val="dd";
		System.out.println("inside the  processSlaveRequest :::::::"+val);
		return "The data served"+val;
	}
	
	@GetMapping("second/{ffff}")
	public String processSlaveRequestsec(@PathVariable("ffff" )String gggg) {
	String	val="dd";
		System.out.println("inside the  processSlaveRequest :::::::"+gggg);
		try {
			
			RestTemplate restTemplate =new RestTemplate();
			
			HttpHeaders header=new HttpHeaders();
			
			header.set("Host", "jboss.evolvus.io");
			
		String	kongAdminUrl="http://jboss.evolvus.io:8000/add";
		
		String reqStr="Hi Kong testing";
		header.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		header.setContentType(MediaType.APPLICATION_JSON);
			
		HttpEntity <String>requestEntity= new HttpEntity<>(header);
	
		ResponseEntity<String> res=	restTemplate.exchange(kongAdminUrl, HttpMethod.GET, requestEntity, String.class);
		
		System.out.println("The response  body "+res.getBody());
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "The data served"+gggg;
	}

}
