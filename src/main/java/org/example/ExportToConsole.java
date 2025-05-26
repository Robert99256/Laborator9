package org.example;

import java.util.List;

public class ExportToConsole implements Exporter {
    @Override
    public void export(List<Persoana> persoane) {// Implementeaza metoda export care afiseaza lista de persoane in consola
        for (Persoana persoana : persoane) {
            System.out.println(persoana); // Afiseaza fiecare persoana in consola
        }
    }
}
