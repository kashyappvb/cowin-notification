package com.cowin.cowinapi.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cowin.cowinapi.model.CowinApiResponse;
import com.cowin.cowinapi.service.CowinApiService;

@RestController
public class CowinApiController {

	@Autowired
	private CowinApiService cowinApiService;
	
	@GetMapping("/getVaccineAvailabilityByDistrict")
	public ResponseEntity<CowinApiResponse> getVaccineAvailabilityByDistrict(
				@RequestParam(value="district_id",defaultValue="266") String districtId,
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
	
	//Runs every 5 minutes
	@Scheduled(cron="0 0/5 * * * ?")
	public void callVaccinationAvailabilityCron()
	{
		System.out.println("Running from Cron.....");
		String districtId = "266";
		
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate localDate = LocalDate.now().plusDays(1);
	    String date = localDate.format(formatter);
	    
	    getVaccineAvailabilityByDistrict(districtId,date);
	    
	}
}
