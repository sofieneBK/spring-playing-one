package dev.metier;

import dev.persistance.IPersistance;

public class Metier2 implements IMetier {

    private IPersistance persitance;

    public Metier2(IPersistance persitance) {
        this.persitance = persitance;
    }

    public String get() {
        return "metier 2 - " + persitance.get();
    }


}
