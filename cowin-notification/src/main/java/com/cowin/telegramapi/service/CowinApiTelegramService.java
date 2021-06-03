package com.cowin.telegramapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CowinApiTelegramService {

	@Value("${telegram-bot-base-url}")
	private String telegramBotBaseUrl;
	
	@Value("${telegram-bot-api-token}")
	private String telegramBotApiToken;
	
	@Value("${telegram-bot-send-message}")
	private String telegramBotSendMessage;
	
	@Value("${telegram-channel-name}")
	private String telegramChannelName;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Object feedDataToBot(String data)
	{
		StringBuilder telegramFinalUrl = new StringBuilder(); 
		telegramFinalUrl
			.append(telegramBotBaseUrl)
			.append(telegramBotApiToken)
			.append(telegramBotSendMessage)
			.append("?chat_id=")
			.append(telegramChannelName)
			.append("&text=")
			.append(data);
		System.out.println(telegramFinalUrl);
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity(telegramFinalUrl.toString(), Object.class);
		System.out.println(responseEntity);
		return null;
	}
}
