package org.learning.java.christmas;

import java.awt.desktop.ScreenSleepEvent;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ListaRegali {
    // Definisco nome file per il salvataggio
    private static final String NOME_FILE = "lista_regali.txt";

    public static void main(String[] args) {
        // Creazione array per lista regali
        ArrayList<String> listaRegali = new ArrayList<>();
        // Scanner per lettura input utente
        Scanner scanner = new Scanner(System.in);
        String nuovoRegalo;
        boolean continua = true;

        // Caricamento lista da file
        caricaLista(listaRegali);

        // Ciclo per inserimento regali
        while (continua) {
            System.out.println("Inserisci un regalo da aggiungere alla lista");
            nuovoRegalo = scanner.nextLine();
            // Aggiungo regalo alla lista
            listaRegali.add(nuovoRegalo);

            // Per visualizzare lunghezza lista ad ogni inserimento
            System.out.println("Lunghezza lista: " + listaRegali.size());

            System.out.print("Vuoi aggiungere? (si/no): ");
            String scelta = scanner.nextLine();
            // Se l'utente non vuole continuare ad inserire
            if (scelta.equalsIgnoreCase("no")) {
                // Termino inserimento
                continua = false;
            }
        }
        scanner.close();

        // Ordinamento lista regali
        Collections.sort(listaRegali);

        // Stampo la lista regali
        System.out.println("Lista regali ordinata");
        for (String regalo : listaRegali) {
            System.out.println(regalo);
        }

        // Salvo lista su file
        salvaLista(listaRegali);
    }

    // Metodo per caricare lista da file
    private static void caricaLista(ArrayList<String> listaRegali) {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_FILE))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                listaRegali.add(linea);
            }
            System.out.println("Lista regali caricata da file. ");
            // Se non c'è nessuna lista stampo messaggio errore
        } catch (IOException e) {
            System.out.println("Impossibile leggere il file. Lista regali vuota");
        }
    }

    // Metodo per salvare lista su file
    private static void salvaLista(ArrayList<String> listaRegali) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_FILE))) {
            for (String regalo : listaRegali) {
                writer.write(regalo);
                writer.newLine();
            }
            System.out.println("Lista regali salvata su file");
            // Se non c'è nessuna lista stampo messaggio errore
        } catch (IOException e) {
            System.out.println("Impossibile salvare il file");
        }
    }
}
