package com.mybank.NotificationService.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwagerConfig {
	@Bean
	public OpenAPI customAPI(){
		return new OpenAPI()
				.info(new Info()
				.title("Notification Service")
				.version("1")
				.description("Notification Service API description"));
				
		
	}
}
