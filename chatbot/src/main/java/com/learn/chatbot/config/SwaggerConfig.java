package com.learn.chatbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("ERP API")
                .version("1.0")
                .description("API for managing chatbot conversations, messages, and user interactions within the ERP system. " +
                        "This module allows users to start new conversations, send and retrieve chat messages, and view conversation history.")
                .contact(new Contact()
                    .name("abdulraman Ahmed")
                    .email("abdulraman.ahmedd@gmail.com")
                )
            );
    }
}