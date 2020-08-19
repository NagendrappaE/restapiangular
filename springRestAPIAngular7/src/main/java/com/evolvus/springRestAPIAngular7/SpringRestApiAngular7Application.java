package com.evolvus.springRestAPIAngular7;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evolvus.springRestAPIAngular7.bean.AmountType;
import com.evolvus.springRestAPIAngular7.bean.CustomResponse;
import com.evolvus.springRestAPIAngular7.bean.JwtAuthenticationRequest;
import com.evolvus.springRestAPIAngular7.bean.MandateCatoryList;
import com.evolvus.springRestAPIAngular7.bean.ServerData;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@RestController
@RequestMapping("api")
//@ComponentScan(basePackages = "com.evolvus")

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

		// customResponse.setData("successfully saved the data");
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

	@PostMapping("authenticate")

	public ResponseEntity createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) {

		CustomResponse customResp = null;
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		try {
			if (authenticationRequest.getUserId().equals("nagendra")) {
				customResp = new CustomResponse();
				status = HttpStatus.OK;
				customResp.setDescription("Login SuccesFull");
				customResp.setData("login successfull");
				customResp.setStatus("SUCCESS");
			} else {
				status = HttpStatus.OK;

			}

		} catch (Exception ex) {
			ex.fillInStackTrace();
		}

		return new ResponseEntity<>(customResp, status);

	}

	@PostMapping("basicinfo")

	public ResponseEntity<CustomResponse> getBasicInfo(@RequestParam(name = "requestType") String value) {

		HttpStatus httpStatus = HttpStatus.OK;
		CustomResponse customResponse = new CustomResponse();

		if (value.equals("AMOUNTTYPE")) {

			AmountType[] amountTypeAr = new AmountType[2];
			AmountType amt = new AmountType();
			amt.setAmtKey("F");
			amt.setAmtName("Fixed");

			amountTypeAr[0] = amt;

			AmountType amt1 = new AmountType();
			amt1.setAmtKey("V");
			amt1.setAmtName("Variable");
			amountTypeAr[1] = amt1;

			customResponse.setData(amountTypeAr);
		} else if (value.equals("ACCOUNTTYPE")) {

			String[] accounType = new String[4];
			accounType[0] = "SAVINGS";
			accounType[1] = "CURRENT";
			accounType[2] = "CC";
			accounType[3] = "SB-NRE";

			customResponse.setData(accounType);

		} else {

			MandateCatoryList[] mndArry = new MandateCatoryList[5];
			MandateCatoryList cat1 = new MandateCatoryList();

			cat1.setMndCatCode("A001");
			cat1.setMndCatName("Electricity Bill");

			MandateCatoryList cat2 = new MandateCatoryList();
			cat2.setMndCatCode("L001");
			cat2.setMndCatName("Loan utility");

			MandateCatoryList cat3 = new MandateCatoryList();

			cat3.setMndCatCode("API");

			cat3.setMndCatName("API Mandate");

			MandateCatoryList cat4 = new MandateCatoryList();

			cat4.setMndCatCode("W001");
			cat4.setMndCatName("Water Bill");

			MandateCatoryList cat5 = new MandateCatoryList();

			cat5.setMndCatCode("B2B");

			cat5.setMndCatName("B2B Corporate");

			mndArry[0] = cat1;
			mndArry[1] = cat2;
			mndArry[2] = cat3;
			mndArry[3] = cat4;
			mndArry[4] = cat5;
			customResponse.setData(mndArry);

		}

		customResponse.setStatus("SUCCESS");

		return new ResponseEntity<>(customResponse, httpStatus);

	}

	@PostMapping("savemandate")

	public ResponseEntity<CustomResponse> saveMandateData(@RequestBody String mandateData) {

		HttpStatus httpStatus = HttpStatus.OK;
		CustomResponse customResponse = new CustomResponse();

		try {


			customResponse.setStatus("SUCCESS");
			customResponse.setData("your mandate has been registred  reference Number " +System.currentTimeMillis());

			System.out.println("the mandate data...." + mandateData);

		} catch (Exception e) {
			customResponse.setStatus("ERROR");
			customResponse.setData("your mandate has been registration Failed ");


			e.printStackTrace();
		}

		return new ResponseEntity<>(customResponse, httpStatus);

	}
}
