package com.dgsw.ogongsii.ogongsii_backend_v2.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("ikk2 타이머")
                .version("version 1.0")
                .description("ikk2 타이머");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }

}
