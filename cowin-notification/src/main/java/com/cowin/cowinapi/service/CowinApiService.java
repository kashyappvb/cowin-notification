package com.cowin.cowinapi.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cowin.cowinapi.model.CowinApiResponse;
import com.cowin.cowinapi.model.Session;
import com.cowin.telegramapi.service.CowinApiTelegramService;

@Service
public class CowinApiService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Value("${cowin-base-url}")
	private String cowinBaseUrl;
	
	@Value("${cowin-find-by-district}")
	private String findByDistrictContextPath;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CowinApiTelegramService cowinApiTelegramService;
	
	List<Session> sessionsPushedToTelegram = new ArrayList<Session>();
	
	public ResponseEntity<CowinApiResponse> getVaccineAvailabilityByDistrict(String districtId,String date)
	{
		String finalUrl = cowinBaseUrl + findByDistrictContextPath;
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Accept-Language", "en_US");
		
		HttpEntity<Object> requestEntity = new HttpEntity<>(requestHeaders);
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(finalUrl)
				.queryParam("district_id", districtId)
				.queryParam("date", date);
		
		ResponseEntity<CowinApiResponse> responseEntity = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                CowinApiResponse.class
        );
		
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
            
			LOGGER.info("COWIN RESPONSE : {}", responseEntity);
            List<Session> avaialbleVaccineList =  responseEntity.getBody().getSessions().stream()
            		.filter(session -> session.getAvailableCapacity()>0 && sessionsPushedToTelegram.contains(session)).collect(Collectors.toList());
            		
            LOGGER.info("Eligible Vaccination with Availability, Size {} : {}",avaialbleVaccineList.size(),avaialbleVaccineList);
            
            for(Session session : avaialbleVaccineList) {
            	StringBuilder finalMessageToBot = new StringBuilder();
            	
            	finalMessageToBot
                .append("Vaccination Information :\n\n")
                .append("Date : ").append(session.getDate()).append("\n")
                .append("Center ID : ").append(session.getCenterId()).append("\n")
                .append("Age Group : ").append(session.getMinAgeLimit()).append("\n")
                .append("Name : ").append(session.getName()).append("\n")
                .append("Address : ").append(session.getAddress()).append("\n")
                .append("District : ").append(session.getDistrictName()).append("\n")
                .append("Pincode : ").append(session.getPincode()).append("\n")
                .append("Vaccine : ").append(session.getVaccine()).append("\n")
                .append("Available Capacity : ").append(session.getAvailableCapacity()).append("\n")
                .append("Available Capacity Dose 1 : ").append(session.getAvailableCapacityDose1()).append("\n")
                .append("Available Capacity Dose 2 : ").append(session.getAvailableCapacityDose2()).append("\n")
                .append("Fee type : ").append(session.getFeeType()).append("\n")
                .append("Fee : ").append(session.getFee()).append("\n")
                .append("Slots :").append(session.getSlots()).append("\n")
                .append("\n")
                .append("Book your Vaccination at https://www.cowin.gov.in/ and get vaccinated! \n");
            	
            	sessionsPushedToTelegram.add(session);
            	
            	cowinApiTelegramService.feedDataToBot(finalMessageToBot.toString());
            	
            }
            
            
        } else {
        	LOGGER.error("Error Occured : {}",responseEntity);
        }
		LOGGER.info("Sessions pushed till now :{}",sessionsPushedToTelegram);
		return responseEntity;
	}
}
