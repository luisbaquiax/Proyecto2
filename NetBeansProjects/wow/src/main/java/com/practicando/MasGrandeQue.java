package com.practicando;

import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class MasGrandeQue {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int valor = 0;
        int tamañoArreglo = 0;
        int numeros[];

        System.out.print("Ingrese el tamaño del arreglo: ");
        tamañoArreglo = scanner.nextInt();

        numeros = new int[tamañoArreglo];

        System.out.print("INGRESE UN NUMERO A COMPARAR CON CADA DEL ARREGLO: ");
        valor = scanner.nextInt();

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("INGRESE UN NÚMERO (EN EL ARREGLO)" + (i + 1)+": ");
            numeros[i] = scanner.nextInt();
        }
        mayoresQue(valor, numeros);
    }

    public static void mayoresQue(int valor, int[] numeros) {

        int contador = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > valor) {
                contador++;
            }
        }
        System.out.println("Son " + contador + " los mayores a " + valor);

    }
}
