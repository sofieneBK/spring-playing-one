package dev.dao;

import dev.entite.Plat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlatDaoMemoireTest {

    private PlatDaoMemoire platDaoMemoire;

    // @Before JUnit 4
    @BeforeEach
    void setUp() {
        this.platDaoMemoire = new PlatDaoMemoire();
    }

    @Test
    void listerPlatsVideALInitialisation() {
        List<Plat> platList = this.platDaoMemoire.listerPlats();

        assertThat(platList).isEmpty();
        //Assertions.assertEquals(platList.size(), 0);
    }

    @ParameterizedTest
    @CsvSource(
            {"plat 1, 1500",
                    "plat 2, 1500",
                    "plat 3, 1500"}

    )
    void ajouterPlatCasPassants(String nomNouveauPlat, Integer prixNouveauPlat) {

        this.platDaoMemoire.ajouterPlat(nomNouveauPlat, prixNouveauPlat);

        List<Plat> platList = this.platDaoMemoire.listerPlats();

        assertThat(platList).isNotEmpty();
        assertThat(platList).hasSize(1);
        assertThat(platList).extracting(Plat::getNom).contains(nomNouveauPlat);
        assertThat(platList).extracting(Plat::getPrixEnCentimesEuros).contains(prixNouveauPlat);
    }
}
