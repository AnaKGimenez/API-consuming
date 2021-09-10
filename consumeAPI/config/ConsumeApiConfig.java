package com.apitest.consumeAPI.config;

import com.apitest.consumeAPI.ConsumeApiApplication;
import com.apitest.consumeAPI.entity.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConsumeApiConfig {

    private static final Logger log = LoggerFactory.getLogger(ConsumeApiApplication.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate)
            throws Exception {
                return args -> {
                    Quote quote = restTemplate.getForObject(
                        "https://quoters.apps.pcfone.io/api/random", Quote.class);
                log.info(quote.toString());
                };
            }
}
