package org.example;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Persoana> persoane = getPersoane();

        Exporter consoleExporter = new ExportToConsole(); // Export in consola
        Exporter fileExporter = new ExportToFile("persoane.txt"); // Export in fisier

        export(persoane, consoleExporter); // Exporta in consola
        export(persoane, fileExporter);    // Exporta in fisier
    }

    public static void export(List<Persoana> persoane, Exporter exporter) {
        exporter.export(persoane); // Apeleaza metoda export a implementarii
    }

    private static List<Persoana> getPersoane() {// Creeaza si returneaza o lista de obiecte Persoana
        List<Persoana> persoane = new ArrayList<>();// Lista in care se adauga persoane
        persoane.add(new Persoana("Popescu", "Ion"));
        persoane.add(new Persoana("Ionescu", "Vasile"));
        return persoane;
    }
}
