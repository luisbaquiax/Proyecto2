package com.practicando;

import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class MAS_CORTO_MAS_LARGO_PALABRAS {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int cantidadPalabras;
        String[] palabras;

        System.out.print("Digite cantiddad de palabras: ");
        cantidadPalabras = scanner.nextInt();
        palabras = new String[cantidadPalabras];

        for (int i = 0; i < palabras.length; i++) {
            System.out.print("Ingrese palabra " + (i + 1) + ": ");
            palabras[i] = scanner.next();
        }
        for (int i = 0; i < palabras.length; i++) {
            System.out.println((i + 1) + ". " + palabras[i]);
        }
        int logitudMayor = 0;
        int longitudMenor = 0;
        String palabraMayor = null;
        String palabraMenor = null;
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].length() > logitudMayor) {
                logitudMayor = palabras[i].length();
                palabraMayor = palabras[i];
            } else if (palabras[i].length() < logitudMayor) {
                longitudMenor = palabras[i].length();
                palabraMenor = palabras[i];
            }

        }
        System.out.println("Palabra mayor " + palabraMayor);
        System.out.println("Palabra mneor " + palabraMenor);

    }

}
