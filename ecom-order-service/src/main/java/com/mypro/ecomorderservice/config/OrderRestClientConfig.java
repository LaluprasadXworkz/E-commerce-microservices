package com.mypro.ecomorderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class OrderRestClientConfig {

    @Bean
    public RestClient restClient() {
        return RestClient.create();
    }

}
