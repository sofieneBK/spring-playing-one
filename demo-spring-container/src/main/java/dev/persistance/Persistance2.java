package dev.persistance;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("v2")
public class Persistance2 implements IPersistance {

    public String get() {
        return "persistance2";
    }


}
