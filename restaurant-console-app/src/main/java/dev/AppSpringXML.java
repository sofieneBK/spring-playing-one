package dev;

import dev.ihm.Menu;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppSpringXML {

    public static void main(String[] args) {

        // création du contexte Spring
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config-fichier.xml")) {
            Menu menu = context.getBean(Menu.class);
            menu.afficher();
        } // context.close() appelé automatiquement même s'il y a une erreur

    }
}
