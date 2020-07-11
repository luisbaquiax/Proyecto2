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
public class tablasDeMulitplicar {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numeroTabla = 0;
        boolean operacion = true;
        
        System.out.println("Bienvendio a: TABLAS DE MULTIPLICAR");
        while (operacion) {
            if (numeroTabla == 0) {
                System.out.println("Elige la tabla que quiere que se muestre: 1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10");
                numeroTabla = sc.nextInt();
            } else if (numeroTabla > 10 || numeroTabla <= 0) {
                System.out.println("Elige opción correcta!");
                numeroTabla = 0;
            } else {
                System.out.printf("La tabla de %d es: \n", numeroTabla);
                for (int i = numeroTabla; i <= numeroTabla; i++) {
                    for (int j = 1; j <= 10; j++) {
                        System.out.println(i  + "*" + j + " " + "=" + " " + (i * j));
                    }
                }
                int elegirTabla;
                System.out.println("¿Quiéres ver otra tabla de multiplicar? Presione 1 (SI) o Presione 2 (NO)");
                elegirTabla = sc.nextInt();
                switch (elegirTabla) {
                    case 1:
                        numeroTabla = 0;
                        break;
                    case 2:
                        System.out.println("Adiós :)");
                        operacion = false;      
                }             
            }
        }
    }
}
