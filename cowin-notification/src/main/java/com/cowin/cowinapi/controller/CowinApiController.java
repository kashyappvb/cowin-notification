package com.cowin.cowinapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cowin.cowinapi.service.CowinApiService;

@RestController
public class CowinApiController {

	@Autowired
	private CowinApiService cowinApiService;
	
	@GetMapping("/getVaccineAvailabilityByDistrict")
	public ResponseEntity<Object> getVaccineAvailabilityByDistrict(
				@RequestParam(value="district_id") String districtId,
				@RequestParam(value="date") String date
			)
	{
		
		return cowinApiService.getVaccineAvailabilityByDistrict(districtId, date);
		
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "Welcome to COWIN Notification App!";
	}
}
