package com.greatech.server.rkg.config.swagger;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerOpenAPIConfig {

    private License license() {
        return new License()
                .name("MIT")
                .url("https://opensource.org/licenses/MIT");
    }

    private Info info() {
        return new Info()
                .title("IAM server API")
                .description(" 接口文档 ")
                .version("0.0.1")
                .license(license())
                .contact(new Contact().name("联系人").url("联想人链接"))
                .summary("概要");
    }

    private ExternalDocumentation externalDocumentation() {
        return new ExternalDocumentation()
                .description("这是一个额外的描述。")
                .url("文档地址");
    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(info())
                .externalDocs(externalDocumentation())
                .security(List.of(new SecurityRequirement().addList("api_token")));
    }
}