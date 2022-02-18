package com.example.jpa.springdatajpa.Response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse <T>{

	private Collection<T> features;
	  

	public ApiResponse(Collection<T> features) {
		
		this.features = features;
	}
	
	public ApiResponse(T features) {
		List<T> feature = new ArrayList<>();
		feature.add(features);
		this.features = feature;
		
	}		

	public Collection<T> getFeatures() {
		return features;
	}

	public void setFeatures(Collection<T> features) {
		this.features = features;
	}
	
	
	
}
