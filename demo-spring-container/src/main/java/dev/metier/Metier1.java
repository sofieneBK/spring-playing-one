package dev.metier;

import dev.persistance.IPersistance;
import org.springframework.stereotype.Service;

// new Metier1(..)

@Service
//@AllArgsConstructor
public class Metier1 implements IMetier {

    // injection par champ
//    @Autowired
    // 1. pas d'usage Java sans Spring
    // 2. pas de test sans framework (Spring, ...), => mes tests "uniquement" avec Spring
    // 3. la verbosité "par constructeur" => curseur de complexité
    private IPersistance persitance;

    // injection par setter
//    @Autowired
//    public void setPersitance(IPersistance persitance) {
//        this.persitance = persitance;
//    }

    //    // injection par constructeur
    public Metier1(/*@Qualifier("persistance2")*/ IPersistance persistance) {
        this.persitance = persistance;
    }


    public String get() {
        return "metier 1 - " + persitance.get();
    }


}
