package dev.metier;

import dev.persistance.Persistance1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

// @RunWith JUnit 4
// @ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:config.xml")
// @ContextConfiguration(classes = {Metier2.class, Persistance1.class})
@ActiveProfiles("v1")

// @SpringJUnitConfig = @ExtendWith(SpringExtension.class) + @ContextConfiguration
@SpringJUnitConfig({Metier2.class, Persistance1.class})
class Metier2Persistance1Test {

    @Autowired
    Metier2 metier2;

//    @BeforeEach
//    public void init() {
//        Persistance1 p1 = new Persistance1();
//        metier2 = new Metier2(p1);
//    }

    @Test
    void get() {
        String resultat = metier2.get();
        assertThat(resultat).isEqualTo("metier 2 - persistance1");
    }
}
