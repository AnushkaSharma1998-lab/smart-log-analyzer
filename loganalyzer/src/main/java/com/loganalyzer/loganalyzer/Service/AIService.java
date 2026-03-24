package com.loganalyzer.loganalyzer.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AIService {

    @Value("${openai.api.key}")
    private String key;

    public String explain(String error) {

        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(key);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String body = """
        {
          "model": "gpt-4o-mini",
          "messages": [
            {"role": "user", "content": "Explain error: %s"}
          ]
        }
        """.formatted(error);

        return rt.postForObject(
            "https://api.openai.com/v1/chat/completions",
            new HttpEntity<>(body, headers),
            String.class
        );
    }
}
    

