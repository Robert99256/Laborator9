package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportToFile implements Exporter {
    private String filename;

    public ExportToFile(String filename) {// Constructor care seteaza numele fisierului unde se va face exportul
        this.filename = filename;
    }

    @Override
    public void export(List<Persoana> persoane) {// Implementeaza metoda export care scrie lista de persoane in fisierul specificat
        try (PrintWriter printWriter = new PrintWriter(filename)) {
            for (Persoana persoana : persoane) {
                printWriter.println(persoana.toString()); // Scrie persoana in fisier
            }
        } catch (IOException e) {
            e.printStackTrace(); // Afiseaza eroarea daca nu poate scrie
        }
    }
}
