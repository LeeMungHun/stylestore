package com.coda.stylestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing config 파일로 따로분리: 테스트코드 에러를 위해
@SpringBootApplication
public class StylestoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StylestoreApplication.class, args);
    }

}
