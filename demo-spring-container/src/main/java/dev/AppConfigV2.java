package dev;

import org.springframework.context.annotation.*;

import java.util.Scanner;

@Configuration
@ComponentScan({"dev.metier", "dev.persistance","dev.presentation"})
public class AppConfigV2 {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
