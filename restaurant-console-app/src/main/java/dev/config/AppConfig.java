package dev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Scanner;

@Configuration
@ComponentScan("dev")
@PropertySource("classpath:app.properties")
public class AppConfig {

    // <bean id="scanner" class="java.util.Scanner"/>
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
