package com.learn.json;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class TestWithJson {
    public static void main(String[] args) {
        //JsonPath.read();

        String jsonDataSourceString = "{\n" +
                "    \"tool\": \n" +
                "    {\n" +
                "        \"jsonpath\": \n" +
                "        {\n" +
                "            \"creator\": \n" +
                "            {\n" +
                "                \"name\": \"Jayway Inc.\",\n" +
                "                \"location\": \n" +
                "                [\n" +
                "                    \"Malmo\",\n" +
                "                    \"San Francisco\",\n" +
                "                    \"Helsingborg\"\n" +
                "                ]\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "\n" +
                "    \"book\": \n" +
                "    [\n" +
                "        {\n" +
                "            \"title\": \"Beginning JSON\",\n" +
                "            \"price\": 49.99\n" +
                "        },\n" +
                "\n" +
                "        {\n" +
                "            \"title\": \"JSON at Work\",\n" +
                "            \"price\": 29.99\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        String jsonpathCreatorNamePath = "$['tool']['jsonpath']['creator']['name']";
        String jsonpathCreatorLocationPath = "$['tool']['jsonpath']['creator']['location'][1]";
        DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);
        String jsonpathCreatorName = jsonContext.read(jsonpathCreatorNamePath);
        String jsonpathCreatorLocationName = jsonContext.read(jsonpathCreatorLocationPath);
        System.out.println(jsonpathCreatorName);
        System.out.println(jsonpathCreatorLocationName);
        //String path = JsonPath.getPath();
    }
}
