package com.aqi.aqi_backend.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AqiVendorClient {

	 @Value("${aqi.token}")
	    private String token;

	    private final RestTemplate restTemplate = new RestTemplate();

	    public String searchCity(String city) {
	        String url = "https://api.waqi.info/search/?keyword=" + city + "&token=" + token;
	        return restTemplate.getForObject(url, String.class);
	    }
}
