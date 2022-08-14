package com.coda.stylestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StylestoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StylestoreApplication.class, args);
    }

}
