package com.frexdel.youness.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ConfigProfil {

    @Bean
    @Profile("test")
    public EnvirenementConfigTest forTest(){
        return new EnvirenementConfigTest("I am in Testing");
    }

    @Bean
    @Profile("prod")
    public EnvirenementConfigTest forProduction(){
        return new EnvirenementConfigTest("Im in Production");
    }
}
