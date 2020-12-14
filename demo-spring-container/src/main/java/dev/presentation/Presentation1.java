package dev.presentation;

import dev.metier.IMetier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class Presentation1 {

    private IMetier metier;

    private Scanner scanner;

    private String libelleHello;

    public Presentation1(IMetier metier, Scanner scanner, @Value("${libelle}") String libelleHello) {
        this.metier = metier;
        this.scanner = scanner;
        this.libelleHello = libelleHello;
    }

    public void print() {
        System.out.println(libelleHello);
        System.out.println("Saisie : ");
        String saisie = scanner.next();
        System.out.println("P - " + metier.get() + " " + saisie);
    }
}
