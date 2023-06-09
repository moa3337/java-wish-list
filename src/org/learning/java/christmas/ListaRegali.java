package org.learning.java.christmas;

import java.awt.desktop.ScreenSleepEvent;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaRegali {

    public static void main(String[] args) {
        // Creazione array per lista regali
        ArrayList<String> listaRegali = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String nuovoRegalo;
        boolean continua = true;

        // Ciclo per inserimento regali
        while (continua) {
            System.out.print("Inserisci un regalo da aggiungere alla lista\n");
            nuovoRegalo = scanner.nextLine();
            // Aggiungo regalo alla lista
            listaRegali.add(nuovoRegalo);

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
    }
}
