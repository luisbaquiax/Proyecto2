package com.practicando;

import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        String palabra;
        System.out.println("Escribe 10 palabras");
        for (int i = 0; i < 10; i++) {
            System.out.print("Palabra: "+(i+1));
            palabra = sc.nextLine();
        }
    }

}
