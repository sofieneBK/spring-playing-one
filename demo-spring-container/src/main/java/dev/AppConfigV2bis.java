package dev;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"dev.metier", "dev.persistance", "dev.presentation"})
@ImportResource("classpath:utils.xml")
@PropertySource("classpath:app.properties")
public class AppConfigV2bis {

}
