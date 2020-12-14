package dev.service;

import dev.dao.PlatDaoMemoire;
import dev.entite.Plat;
import dev.exception.PlatException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PlatServiceVersion2.class, PlatDaoMemoire.class})
@ActiveProfiles({"service2", "memoire"})
class PlatServiceVersion2IntegrationTest {

    @Autowired
    PlatServiceVersion2 platServiceVersion2;

    @Test
    void ajouterPlatCasPassant() {
        this.platServiceVersion2.ajouterPlat("plat 1", 1400);

        List<Plat> plats = this.platServiceVersion2.listerPlats();

        Assertions.assertThat(plats).extracting(Plat::getNom).contains("plat 1");
        Assertions.assertThat(plats).extracting(Plat::getPrixEnCentimesEuros).contains(1400);
    }

    @Test
    void ajouterPlatCasPrixInferieurA1000() {
        Assertions.assertThatThrownBy(() ->      this.platServiceVersion2.ajouterPlat("plat 1", 900))
                .isInstanceOf(PlatException.class)
                .hasMessage("le prix d'un plat doit être supérieur à 10 €");
    }
}
