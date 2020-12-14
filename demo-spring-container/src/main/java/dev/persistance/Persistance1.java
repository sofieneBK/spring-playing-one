package dev.persistance;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
//@Primary
@Profile("v1")
public class Persistance1 implements IPersistance {


    public String get() {
        return "persistance1";
    }

}
