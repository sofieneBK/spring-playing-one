package dev;

import dev.metier.IMetier;
import dev.metier.Metier1;
import dev.persistance.IPersistance;
import dev.persistance.Persistance1;
import dev.presentation.Presentation1;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class AppSpringXML {

    public static void main(String[] args) {

//        IPersistance persitance = new Persistance1();
//        IMetier metier = new Metier1(persitance);
//        Scanner scanner = new Scanner(System.in);
//        Presentation1 presentation1 = ...;
//        presentation1.print();

        // Créer un contexte Spring
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");


        // Récupérer l'objet Presentation1
        Presentation1 presentation1 = context.getBean(Presentation1.class);
        Presentation1 presentation2 = context.getBean(Presentation1.class);
        Presentation1 presentation3 = context.getBean(Presentation1.class);

        // invoquer la méthode print
        presentation1.print();

        context.close();
    }
}
