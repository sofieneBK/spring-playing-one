package dev.ihm.options;

import dev.exception.PlatException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

@Controller
@Order
public class OptionTerminer implements IOptionMenu {
    @Override
    public String getTitre() {
        return "Terminer";
    }

    @Override
    public void executer() {
        throw new PlatException("Aurevoir");
    }
}
