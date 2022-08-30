package com.learn.collectors.resttemplates;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Iterator;


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


public class TestCollectors {


    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {


        String theUrl = "http://localhost:8080/v1/sales/details";
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBhcHBsaWNhdGUuaW4iLCJleHAiOjE3MzkzNDE2NDEsImlhdCI6MTY2MTU4MTY0MSwib3V0bGV0Q29kZSI6bnVsbCwibG9iIjoiY3BzZWxsaW5hbXlkZW1vIn0.UnTyGDoIvXDhP6kOflEa6J4tau0qEkPOXrTZinX28GVuNGDVydqRLXHkZLZEoMGWMx6tqxo7FJDnHp_PUpmyRw");
            HttpEntity<String> entity = new HttpEntity<String>(headers);
            ResponseEntity<String> response = restTemplate.exchange(theUrl, HttpMethod.GET, entity, String.class);
            System.out.println("Result - status (" + response.getStatusCode() + ") has body: " + response.getBody());
        } catch (Exception eek) {

        }


    }

}
