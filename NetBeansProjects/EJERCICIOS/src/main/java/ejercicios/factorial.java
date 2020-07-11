/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.util.Scanner;

/**
 *
 * @author luis
 */
public class factorial {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        long factorial = 1;
        int numeroIgresado;
        System.out.println("Digite un número:");
        numeroIgresado = entrada.nextInt();
        for(int i = 1;i <= numeroIgresado; i ++){
            factorial = factorial*i;
        }
        System.out.printf("El factorial de %d es: %d", numeroIgresado, factorial);
    }
    
}
