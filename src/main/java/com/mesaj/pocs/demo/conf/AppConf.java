package com.mesaj.pocs.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class AppConf {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}