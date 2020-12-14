package dev.service;

import dev.entite.Plat;

import java.util.List;

public interface IPlatService {

    List<Plat> listerPlats();

    void ajouterPlat(String nomPlat, Integer prixPlat);
}
