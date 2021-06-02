package com.cowin.cowinapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CowinApiService {

	@Value("${cowin-base-url}")
	private String cowinBaseUrl;
	
	@Value("${cowin-find-by-district}")
	private String findByDistrictContextPath;
	
	public ResponseEntity<Object> getVaccineAvailabilityByDistrict(String districtId,String date)
	{
		String finalUrl = cowinBaseUrl + findByDistrictContextPath;
		
		List<MediaType> acceptableMediaTypesList = new ArrayList<>();
		acceptableMediaTypesList.add(MediaType.ALL);
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(acceptableMediaTypesList);
		requestHeaders.add("Accept-Language", "en_US");
		
		HttpEntity<Object> requestEntity = new HttpEntity<>(requestHeaders);
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(finalUrl)
				.queryParam("district_id", districtId)
				.queryParam("date", date);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                Object.class
        );
		
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
            System.out.println("response received");
            System.out.println(responseEntity.getBody());
        } else {
            System.out.println("error occurred");
            System.out.println(responseEntity.getStatusCode());
        }
		
		return responseEntity;
	}
}
