package dev;

import dev.presentation.Presentation1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppSpringJava {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // context.getEnvironment().setActiveProfiles("v2");

        context.register(AppConfigV2bis.class);

        context.refresh();

        // ...

        // Récupérer l'objet Presentation1
        Presentation1 presentation1 = context.getBean(Presentation1.class);
        Presentation1 presentation2 = context.getBean(Presentation1.class);
        Presentation1 presentation3 = context.getBean(Presentation1.class);

        // invoquer la méthode print
        presentation1.print();

        context.close();
    }
}
