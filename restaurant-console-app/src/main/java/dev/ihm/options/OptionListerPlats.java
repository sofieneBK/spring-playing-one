package dev.ihm.options;

import dev.service.IPlatService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

@Controller
@Order(1)
public class OptionListerPlats implements IOptionMenu {

    private IPlatService service;

    public OptionListerPlats(IPlatService service) {
        this.service = service;
    }

    @Override
    public String getTitre() {
        return "Lister plats";
    }

    @Override
    public void executer() {

        this.service.listerPlats().forEach(plat -> System.out.println(plat.getNom() + " (" + (plat.getPrixEnCentimesEuros() / 100) + " €)"));

    }
}
