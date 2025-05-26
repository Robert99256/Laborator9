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

    // Constructor care primeste o linie de text si o imparte in nume si prenume
    public Persoana(String linieFisier) {
        String[] parts = linieFisier.split(" ");
        if (parts.length >= 2) {
            this.nume = parts[0];
            this.prenume = parts[1];
        } else {
            this.nume = linieFisier;// Daca linia contine doar un singur cuvant, il considera nume si lasa prenumele gol
            this.prenume = "";
        }
    }

    @Override
    public String toString() {
        return nume + " " + prenume;
    }

    public static List<Persoana> citesteDinFisier(String numeFisier) {
        List<Persoana> persoane = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {// Deschide fisierul pentru citire si asigura inchiderea automata la final
            String linie;
            while ((linie = br.readLine()) != null) {// Citeste fiecare linie din fisier pana cand nu mai sunt linii
                persoane.add(new Persoana(linie));// Creeaza persoana din linie
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fisierului: " + e.getMessage());
        }
        return persoane;
    }

    // Afiseaza fiecare persoana din lista in consola
    public static void afiseaza(List<Persoana> persoane) {
        for (Persoana p : persoane) {
            System.out.println(p);
        }
    }

    // Exporta lista de persoane fie in fisier, fie in consola, in functie de parametru
    public static void export(List<Persoana> persoane, String parametru) {
        if (parametru.equals("fisier")) {
            try (FileWriter writer = new FileWriter("persoane.txt")) {
                for (Persoana p : persoane) {
                    writer.write(p.toString() + "\n");// Scrie persoana in fisier
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
