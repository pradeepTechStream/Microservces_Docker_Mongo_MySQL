package com.techstream.microservice.inventry_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI inventoryServiceAPIDoc(){
        return new OpenAPI().info(new Info().title("Inventory service details.")
                .description("This is Inventory microservices").version("2.0"));
    }
}
