package dev.dao;

import dev.entite.Plat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(PlatDaoFichier.class)
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {PlatDaoFichier.class})

@TestPropertySource("classpath:test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PlatDaoFichierIntegrationTest {

    @Autowired
    PlatDaoFichier platDaoFichier;

    @Test
    void ajouterPlatCas1() {

        this.platDaoFichier.ajouterPlat("plat 1", 1300);

        List<Plat> plats = this.platDaoFichier.listerPlats();

        assertThat(plats).hasSize(1);
        assertThat(plats).extracting(Plat::getNom).contains("plat 1");
        assertThat(plats).extracting(Plat::getPrixEnCentimesEuros).contains(1300);
    }

    @Test
    void ajouterPlatCas2() {

        this.platDaoFichier.ajouterPlat("plat 2", 1350);

        List<Plat> plats = this.platDaoFichier.listerPlats();
        assertThat(plats).hasSize(1);
        assertThat(plats).extracting(Plat::getNom).contains("plat 2");
        assertThat(plats).extracting(Plat::getPrixEnCentimesEuros).contains(1350);
    }


    @AfterEach
    void tearDown() throws IOException {
        Object fichierStockage = ReflectionTestUtils.getField(this.platDaoFichier, "fichierStockage");
        Files.deleteIfExists(Paths.get(String.valueOf(fichierStockage)));
    }
}
