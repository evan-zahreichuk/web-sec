package edu.zahr.websec.config;

/*
@author ivan
@project IntelliJ IDEA 
@class AuditionConfiguration
@version 1.0.0 
@since 14.05.2025 - 21.34
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@Configuration
public class AuditionConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }


}