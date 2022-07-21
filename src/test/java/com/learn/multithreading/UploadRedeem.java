package com.learn.multithreading;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;



public class UploadRedeem {



    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

	/*	ObjectMapper objectMapper = new ObjectMapper();
		List<Object> langList = objectMapper.readValue(
		        new File("/Users/deeps/Downloads/Pass.json"),
		        new TypeReference<List<Object>>(){});*/


        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("/Users/deeps/Downloads/4_Outlets_RedeemData.json"));

            // A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
            //JSONObject jsonObject = (JSONObject) obj;
            //JSONArray companyList = new JSONArray();

            JSONObject jsonObject = (JSONObject) obj;

            // A JSON array. JSONObject supports java.util.List interface.
            JSONArray companyList = (JSONArray) jsonObject.get("sheet1");
            // A JSON array. JSONObject supports java.util.List interface.
            //JSONArray companyList = (JSONArray) jsonObject.get("Company List");

            // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
            // Iterators differ from enumerations in two ways:
            // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
            // 2. Method names have been improved.
            Iterator<Object> iterator = companyList.iterator();


            //System.out.println(iterator.next().toString());

            while (iterator.hasNext()) {
                String data=iterator.next().toString();
                //System.out.println(iterator.next());


                String theUrl = "http://localhost:8080/v1/redeemActivity";
                RestTemplate restTemplate = new RestTemplate();
                try {
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    headers.add("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcHBsaWNhdGUiLCJleHAiOjE3Mjg2MjgzNjgsImlhdCI6MTY1MDg2ODM2OCwib3V0bGV0Q29kZSI6bnVsbCwibG9iIjoibWFyc3NhbXBpbmRpYSJ9.51URdEFCZ28H4VpZRfhEl0gjEFzAZNRIN90_0z0xeraIPH4t_Ljg1yvdopp7MUGZtzDc1VinhWf4oO_WQiY4mA");
                    HttpEntity<String> entity = new HttpEntity<String>(data, headers);
                    ResponseEntity<String> response = restTemplate.exchange(theUrl, HttpMethod.POST, entity, String.class);
                    System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
                }
                catch (Exception eek) {
                    try (FileWriter f = new FileWriter("/Users/deeps/Downloads/file12345.txt", true);
                         BufferedWriter b = new BufferedWriter(f);
                         PrintWriter p = new PrintWriter(b);) {

                        p.println(data);
                        p.println(",");


                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                    System.out.println("** Exception: "+ eek.getMessage());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



		/*	try {
				activityController.createRedeemActivity(langList.get(0).toString());
			} catch (Exception e) {
				//
				e.printStackTrace();
			}


		System.out.println(langList.get(0)); */




//		String data = "{\n"
//				+ "  \"loginId\": \"PS001800\",\n"
//				+ "  \"outletCode\": \"PS001800\",\n"
//				+ "  \"redemptionId\": \"CL000330:test1:8149689900\",\n"
//				+ "  \"redemptionType\": \"sample_credit\",\n"
//				+ "  \"redeemPoints\": \"0\",\n"
//				+ "  \"status\": \"pending\",\n"
//				+ "  \"extendedAttributes\": {\n"
//				+ "  \"petParent\": \"8149689900\",\n"
//				+ "  \"retailer_name\": \"Samruddhi Pets\",\n"
//				+ "  \"mobile_number\": \"9822115824\",\n"
//				+ "  \"amount_credited\": \"0\",\n"
//				+ "  \"id\": \"06085ac8-6301-4b01-8369-5e3cd985d236\",\n"
//				+ "  \"outletType\": \"Clinic\"}\n"
//				+ " }";


	/*	URL url = new URL("http://127.0.0.1:8080/v1/redeemActivity");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcHBsaWNhdGUiLCJleHAiOjE3MjgwMzU0NzAsImlhdCI6MTY1MDI3NTQ3MCwib3V0bGV0Q29kZSI6bnVsbCwibG9iIjoibWFyc3NhbXBpbmR1YXQifQ.azQo2QSPEIV7motfkW7sHJq8Yv75LNs7INGGdjZfz5bxNCDrCDg69jwTo5cEZxc7iJD3CZevMA-o6NLw-JfxvA");
		http.setRequestProperty("Content-Type", "application/json");



		byte[] out = data.getBytes(StandardCharsets.UTF_8);

		OutputStream stream = http.getOutputStream();
		stream.write(out);

		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect(); */

        //String out1 = RestUtils.restTemplate().postForObject("http://127.0.0.1:8080/v1/redeemActivity",data,String.class);




        //JSONArray a = (JSONArray) parser.parse(new FileReader("c:\\exer4-courses.json"));

    }

}
