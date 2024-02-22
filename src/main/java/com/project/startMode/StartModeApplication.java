package com.project.startMode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StartModeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartModeApplication.class, args);
		System.out.println("\nBatman mode turned ON");
	}

	@Value("${openai.key}")
	private String openAiKey;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(((request, body, execution) -> {
			request.getHeaders().add("Authorization", "Bearer " + openAiKey);
			return execution.execute(request, body);
		}));
		return restTemplate;
	}

}
