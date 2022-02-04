package com.example.jpa.springdatajpa.converters;

import javax.persistence.AttributeConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class JSONObjectConverter implements AttributeConverter<JsonNode, String> {

	@Override
	public String convertToDatabaseColumn(JsonNode attribute) {
		if (attribute != null) {
			return attribute.toString();
		} else {
			return null;
		}
		
	}

	@Override
	public JsonNode convertToEntityAttribute(String dbData) {
		if(dbData != null) {
			try {
				return new ObjectMapper().readTree(dbData);
			}
			catch(Exception e) {
				e.printStackTrace();
				return null;
			}
			
		}else {
			return null;
		}
	}

}
