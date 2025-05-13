package org.example;

import java.util.List;

public class ExportToConsole implements Exporter {
    @Override
    public void export(List<Persoana> persoane) {
        for (Persoana persoana : persoane) {
            System.out.println(persoana);
        }
    }
}
