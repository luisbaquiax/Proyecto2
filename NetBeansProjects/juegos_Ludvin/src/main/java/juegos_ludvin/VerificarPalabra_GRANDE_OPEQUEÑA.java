package Ejercicios_SImples;

import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class VerificarPalabra_GRANDE_OPEQUEÑA {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String palabra1;
        String palabra2;
        boolean seguirJugando = true;
        int seguir = 0;
        while (seguirJugando) {
            if (seguir == 0) {
                System.out.println("Ingrese una palabra");
                palabra1 = scanner.next();
                char[] palabra1Arreglo = palabra1.toCharArray();
                System.out.println("Ingrese una segunda palabra");
                palabra2 = scanner.next();
                char[] palabra2Arreglo = palabra2.toCharArray();

                if (palabra1Arreglo.length > palabra2Arreglo.length) {
                    System.out.println("La palabra " + palabra1 + " Es mas grande que la palabra " + palabra2 + " por "
                            + (palabra1Arreglo.length - palabra2Arreglo.length) + " letras ");

                } else if (palabra1Arreglo.length < palabra2Arreglo.length) {
                    System.out.println("La palabra " + palabra2 + " Es mas grande que la palabra "
                            + palabra1 + " por " + (palabra2Arreglo.length - palabra1Arreglo.length) + " letras ");
                } else if (palabra1Arreglo.length == palabra2Arreglo.length) {
                    System.out.println("La palabra " + palabra2 + ", tienen la misma cantidad de letras que " + palabra1);
                }
            }

            while (!(seguir == 1 || seguir == 2)) {
                System.out.println("¿Quieres ingresar nuevas palabras? [1]Si, [2]No");
                seguir = scanner.nextInt();
                if (!(seguir == 1 || seguir == 2)) {
                    System.out.println("Ingrese opción permitido");
                }
            }
            if (seguir == 1) {
                seguir = 0;
            } else {
                seguirJugando = false;
            }

        }
    }
}
