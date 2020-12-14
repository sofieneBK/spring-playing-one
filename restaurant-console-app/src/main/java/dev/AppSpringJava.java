package dev;

import dev.config.AppConfig;
import dev.ihm.Menu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppSpringJava {


    public static void main(String[] args) {

        // Création du contexte Spring à partir d'une configuration Java
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            Menu menu = context.getBean(Menu.class);
            menu.afficher();
        }


    }
}
