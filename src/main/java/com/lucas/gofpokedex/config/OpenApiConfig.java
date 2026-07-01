package com.lucas.gofpokedex.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI pokemonApi(){
        return new OpenAPI()
                .info(
                      new Info().title("GOF Pokémon Service API")
                              .description("RESTful API built with Java and Spring Boot to manage a personal Pokémon collection, showcasing design patterns, clean architecture principles, and integration with the external PokéAPI.")
                              .version("v1.0")
                              .contact(new Contact()
                                      .name("Lucas Oliveira da Silva")
                                      .url("https://github.com/lucaso-silva")
                                      .email("lucs.osilv@gmail.com"))
                );
    }
}
