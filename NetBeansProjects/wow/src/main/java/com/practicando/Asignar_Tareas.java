package com.practicando;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class Asignar_Tareas {

    static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();

        int tareas;
//        System.out.println("Cuántas tareas hay?");
//        tareas = scanner.nextInt();
        String[] tarea = {"CARATULA", "INTRODUCCION", "CONTENIDO", "CONCLUSION", "INDICE"};
        //String[] tarea;

//        for (int i = 0; i < tarea.length; i++) {
//            System.out.print("Ingrese tarea " + (i + 1) + ": ");
//            tarea[i] = scanner.next();
//        }
        for (int i = 0; i < tarea.length; i++) {
            System.out.println((i + 1) + " " + tarea[i]);
        }

        String[] nombres;
        nombres = new String[tarea.length];
        int elementos = 0;
        int posicion[] = new int[nombres.length];
        int aleatorio;
        boolean agregado;

        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingrese nombre " + (i + 1) + ": ");
            nombres[i] = scanner.next();
        }
        while (elementos < nombres.length) {

            aleatorio = random.nextInt(nombres.length);
            agregado = false;

            for (int i = 0; i < nombres.length && agregado; i++) {
                if (aleatorio == posicion[i]) {
                    agregado = true;
                }
            }
            if (!agregado) {
                posicion[elementos++] = aleatorio;
            }
        }

    }

}
