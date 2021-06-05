package com.cowin.telegramapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CowinApiTelegramService {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
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
	
	public void feedDataToBot(String data)
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
		
		ResponseEntity<Object> responseEntity = restTemplate.getForEntity(telegramFinalUrl.toString(), Object.class);
		
		LOGGER.info("Response from BOT : {}",responseEntity);
	}
}
