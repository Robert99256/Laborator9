package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportToFile implements Exporter {
    private String filename;

    public ExportToFile(String filename) {
        this.filename = filename;
    }

    @Override
    public void export(List<Persoana> persoane) {
        try (PrintWriter printWriter = new PrintWriter(filename)) {
            for (Persoana persoana : persoane) {
                printWriter.println(persoana.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
