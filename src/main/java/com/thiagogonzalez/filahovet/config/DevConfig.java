package com.thiagogonzalez.filahovet.config;

import com.thiagogonzalez.filahovet.services.DBService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    private final DBService dbService;


    public DevConfig(DBService dbService) {
        this.dbService = dbService;
    }

    @Bean
    public boolean initialize() {
        dbService.initializeDb();
        return false;
    }
}
