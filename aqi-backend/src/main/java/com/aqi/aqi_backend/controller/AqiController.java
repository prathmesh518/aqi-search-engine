package com.aqi.aqi_backend.controller;


import org.springframework.web.bind.annotation.*;

import com.aqi.aqi_backend.service.AqiService;

@RestController
@RequestMapping("/api/aqi")
@CrossOrigin(origins = "*")
public class AqiController {

	 private final AqiService aqiService;

	    public AqiController(AqiService aqiService) {
	        this.aqiService = aqiService;
	    }

	    @GetMapping("/search")
	    public String search(@RequestParam String city) {
	        return aqiService.getCityAqi(city);
	    }
}
