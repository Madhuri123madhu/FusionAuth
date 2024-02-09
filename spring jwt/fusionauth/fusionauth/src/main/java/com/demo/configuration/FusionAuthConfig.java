package com.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.fusionauth.client.FusionAuthClient;

@Configuration
public class FusionAuthConfig {

    @Bean
    public FusionAuthClient fusionAuthClient() {
       return new FusionAuthClient("<yip9t-owWhhihFKR-0lMtNx1f6SsgZ-ZfnDpe-m66kGpxgmoDf07mZyM>","http://localhost:9011"); // Replace with your FusionAuth server URL
    }
}
