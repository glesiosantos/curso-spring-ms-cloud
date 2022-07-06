package br.dev.thinkers.mscreditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MscreditcardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscreditcardApplication.class, args);
    }

}
