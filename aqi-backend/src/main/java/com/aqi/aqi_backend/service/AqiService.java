package com.aqi.aqi_backend.service;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.aqi.aqi_backend.client.AqiVendorClient;


@Service
public class AqiService {
	 private final AqiVendorClient vendorClient;

	    public AqiService(AqiVendorClient vendorClient) {
	        this.vendorClient = vendorClient;
	    }

	    @Cacheable(value = "aqiCache", key = "#city.toLowerCase()")
	    public String getCityAqi(String city) {
	        System.out.println("Calling Vendor API for: " + city);
	        return vendorClient.searchCity(city);
	    }
}
