package com.greatech.server.rkg.config.swagger;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GroupsConfiguration {

    /**
     * current文档
     */
    @Bean
    public GroupedOpenApi accountApi() {
        return GroupedOpenApi.builder()
                .displayName("0.0.1")
                .group("0.0.1")
                .pathsToMatch("/" + "0.0.1" + "/**")
                .pathsToExclude("/" + "0.0.1" + "/remote/**")
//                .packagesToScan("com.greatech.server.iam")
                .build();
    }

    @Bean
    public GroupedOpenApi actionApi() {
        return GroupedOpenApi.builder()
                .displayName("0.0.1"+"_remote")
                .group("0.0.1"+"_remote")
                .pathsToMatch("/" + "0.0.1" + "/remote/**")
                .build();
    }

    /**
     * alpha文档
     */
    @Bean
    public GroupedOpenApi alphaApi() {
        return GroupedOpenApi.builder()
                .displayName("ALPHA")
                .group("0.0.2")
                .pathsToMatch("/" + "0.0.2" + "/**")
                .build();
    }

    /**
     * beta文档
     */
    @Bean
    public GroupedOpenApi betaApi() {
        return GroupedOpenApi.builder()
                .displayName("BETA")
                .group("0.0.3")
                .pathsToMatch("/" + "0.0.3" + "/**")
                .build();
    }
}
