package dev.service;

import dev.dao.IPlatDao;
import dev.entite.Plat;
import dev.exception.PlatException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile({"service1", "v1"})
public class PlatServiceVersion1 implements IPlatService {

    // injection par champ
    // PlatServiceVersion1 p = new PlatServiceVersion1()
    // p.dao = ???
//    @Autowired
    private IPlatDao dao;

    // Injection par constructeur
    // => recommandé
    //      => testable unitairement votre classe sans framework
    //      => bonne visibilité des prérequis
    //      => "curseur" de complexité ? responsabilité
    public PlatServiceVersion1(IPlatDao platDaoMemoire) {
        this.dao = platDaoMemoire;
    }


    // Injection par setter
//    @Autowired
//    public void setDao(IPlatDao dao) {
//        this.dao = dao;
//    }

    @Override
    public List<Plat> listerPlats() {
        return dao.listerPlats();
    }

    @Override
    public void ajouterPlat(String nomPlat, Integer prixPlat) {

        // règle métier

        if (nomPlat.length() <= 3) {
            throw new PlatException("un plat doit avoir un nom de plus de 3 caractères");
        }

        if (prixPlat <= 500) {
            throw new PlatException("le prix d'un plat doit être supérieur à 5 €");
        }

        // persistance uniquement si les règles métiers sont respectées
        dao.ajouterPlat(nomPlat, prixPlat);
    }
}
