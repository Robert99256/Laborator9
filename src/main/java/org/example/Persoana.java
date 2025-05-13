package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Persoana {
    private String nume;
    private String prenume;

    public Persoana(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public Persoana(String linieFisier) {
        String[] parts = linieFisier.split(" ");
        if (parts.length >= 2) {
            this.nume = parts[0];
            this.prenume = parts[1];
        } else {
            this.nume = linieFisier;
            this.prenume = "";
        }
    }

    @Override
    public String toString() {
        return nume + " " + prenume;
    }

    public static List<Persoana> citesteDinFisier(String numeFisier) {
        List<Persoana> persoane = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                persoane.add(new Persoana(linie));
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fisierului: " + e.getMessage());
        }
        return persoane;
    }

    public static void afiseaza(List<Persoana> persoane) {
        for (Persoana p : persoane) {
            System.out.println(p);
        }
    }

    public static void export(List<Persoana> persoane, String parametru) {
        if (parametru.equals("fisier")) {
            try (FileWriter writer = new FileWriter("persoane.txt")) {
                for (Persoana p : persoane) {
                    writer.write(p.toString() + "\n");
                }
            } catch (IOException e) {
                System.out.println("Eroare la scrierea in fisier: " + e.getMessage());
            }
        } else if (parametru.equals("consola")) {
            afiseaza(persoane);
        } else {
            System.out.println("Parametru invalid.");
        }
    }
}
