package dev.service;

import dev.dao.IPlatDao;
import dev.exception.PlatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlatServiceVersion1Test {

    private IPlatDao platDao;

    private PlatServiceVersion1 platServiceVersion1;

    @BeforeEach
    void init() {
        this.platDao = Mockito.mock(IPlatDao.class);
        this.platServiceVersion1 = new PlatServiceVersion1(platDao);
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "Plat 1, 1300", // ligne 1
                    "Plat 2, 501", // ligne 2
                    "Plat, 502" // ligne 3
            }
    )
    void ajouterPlatCasPassants(String nomPlat, Integer prixPlat) {

        this.platServiceVersion1.ajouterPlat(nomPlat, prixPlat);

        Mockito.verify(this.platDao).ajouterPlat(nomPlat, prixPlat);
    }


    @Test
    void ajouterPlatCasNom3Caracteres() {

        // Assertion JUnit 5
        Exception exception = assertThrows(PlatException.class,
                () -> this.platServiceVersion1.ajouterPlat("pla", 1000));

        org.junit.jupiter.api.Assertions.assertEquals(exception.getMessage(), "un plat doit avoir un nom de plus de 3 caractères");

        Mockito.verifyNoInteractions(this.platDao);
    }

    @Test
    void ajouterPlatCasPrixInferieurA500() {

        // Assertion AssertJ
        assertThatThrownBy(() -> this.platServiceVersion1.ajouterPlat("plat 1", 400))
                .isInstanceOf(PlatException.class)
                .hasMessage("le prix d'un plat doit être supérieur à 5 €");

        Mockito.verifyNoInteractions(this.platDao);
    }

}
