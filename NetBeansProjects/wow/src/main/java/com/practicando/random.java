/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicando;

import java.util.Random;

/**
 *
 * @author Luis
 */
public class random {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //genera numero entre 1 0 2
        int numero = (int) (Math.random() * 2) + 1;

        Random random = new Random();
        int numeroDos = random.nextInt(2) + 1;
        System.out.println("numero : " + numero + "  " + "numeroDos: " + numeroDos);
        System.out.println("veamos");
        for (int i = 0; i < 20; i++) {
            int numeroGenerado = generarNumeroAleatorio(6, 0);
            System.out.println(numeroGenerado);
        }

    }

    public static int generarNumeroAleatorio(int max, int min) {
        int numero = (int) Math.floor(Math.random() * (max - min + 1) + (min));
        //int numero = (int) (Math.random() * (max-1) + (min));
        return numero;
    }
}
