package com.daniel.microservices_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(QueryRepository queryRepository){
        return args -> {
            log.info("Preloading " + queryRepository.save(new QueryEntity("example query", "example response")));
            log.info("Preloading " + queryRepository.save(new QueryEntity("example query2", "example response2")));
        };
    }

}
