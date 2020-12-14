package dev;


import dev.metier.Metier1;

import dev.persistance.Persistance1;
import dev.presentation.Presentation1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

@Configuration
@Import({Persistance1.class, Metier1.class, Presentation1.class})
public class AppConfigV4 {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
