package com.project.startMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class ChatGptTemplate extends RestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.key}")
    private String openAiKey;

    public void chatGptTemplate() {
        restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openAiKey);
            return execution.execute(request, body);
        }));
    }
}
