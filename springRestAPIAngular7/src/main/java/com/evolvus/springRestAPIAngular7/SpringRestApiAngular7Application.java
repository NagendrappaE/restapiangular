package com.evolvus.springRestAPIAngular7;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evolvus.springRestAPIAngular7.bean.CustomResponse;
import com.evolvus.springRestAPIAngular7.bean.ServerData;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@RestController
@RequestMapping("api")

public class SpringRestApiAngular7Application {

	ArrayList<ServerData> arrayList = new ArrayList<ServerData>();

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiAngular7Application.class, args);
	}

	@GetMapping("add")

	public ResponseEntity<CustomResponse> welcome() {
		HttpStatus httpStatus = HttpStatus.OK;
		CustomResponse customResponse = new CustomResponse();

	
		customResponse.setStatus("SUCCESS");

		return new ResponseEntity<>(customResponse, httpStatus);
	}

	@PostMapping("save")

	public ResponseEntity<CustomResponse> saveServers(@RequestBody ServerData[] str) {

		System.out.println("the   response " + str);
		HttpStatus httpStatus = HttpStatus.OK;
		CustomResponse customResponse = new CustomResponse();

		for (ServerData server : str) {
			arrayList.add(server);
		}

		// arrayList.add(e)

		//customResponse.setData("successfully saved the data");
		customResponse.setStatus("SUCCESS");

		return new ResponseEntity<>(customResponse, httpStatus);
	}

	@GetMapping("/hi")

	public String welcoem() {

		System.out.println();
		return "jj";
	}

	@GetMapping("getserver")

	public ResponseEntity<CustomResponse> getServers() {
		HttpStatus httpStatus = HttpStatus.OK;
		CustomResponse customResponse = new CustomResponse();

		System.out.println(arrayList.size());

		ServerData server[] = new ServerData[arrayList.size()];

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
			server[i] = arrayList.get(i);

		}

		// Creating Object of ObjectMapper define in Jakson Api
		ObjectMapper Obj = new ObjectMapper();
		String jsonStr = null;
		try {

			jsonStr = Obj.writeValueAsString(server);

			// Displaying JSON String
			System.out.println(jsonStr);
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		customResponse.setData(server);
		customResponse.setStatus("SUCCESS");

		return new ResponseEntity<>(customResponse, httpStatus);
	}

}
