package org.example;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Persoana> persoane = getPersoane();

        Exporter consoleExporter = new ExportToConsole();
        Exporter fileExporter = new ExportToFile("persoane.txt");

        export(persoane, consoleExporter);
        export(persoane, fileExporter);
    }

    public static void export(List<Persoana> persoane, Exporter exporter) {
        exporter.export(persoane);
    }

    private static List<Persoana> getPersoane() {
        List<Persoana> persoane = new ArrayList<>();
        persoane.add(new Persoana("Popescu", "Ion"));
        persoane.add(new Persoana("Ionescu", "Vasile"));
        return persoane;
    }
}

