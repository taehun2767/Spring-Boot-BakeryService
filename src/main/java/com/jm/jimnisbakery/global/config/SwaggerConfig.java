package com.jm.jimnisbakery.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.servlet.ServletContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@OpenAPIDefinition(
        info = @Info(title = "Jimnis Bakery API 명세서",
                description = "지콩 베이커리 API 명세서",
                version = "v1"))
@Configuration
public class SwaggerConfig {
}
