package ejercicios;

import java.util.Scanner;

/**
 * Este programa es un CALCULADORA Autor: LUIS
 */
public class calculadora_LUIS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double suma, resta, division, multiplicación;
        int elegirOp = 0;
        double c, d;
        System.out.println("********************[BIENVENIDO A LA : CALCULADORA_autor_LUIS]********************");

        while (elegirOp != 5) {

            if (elegirOp == 0) {
                System.out.println("\n" + "ELige opción: [1 suma]  [2 resta]  [3 multiplicación]  [4 División]  [5 Salir]");
                elegirOp = scanner.nextInt();
            }
            if (elegirOp == 5) {
                System.exit(0);
            }
            if (elegirOp > 5 || elegirOp < 0) {
                System.out.println("Elige opción correcta");
                //elegirOp = 0;
            } else {
                System.out.println("Ingrese un número");
                c = scanner.nextDouble();
                System.out.println("Ingrese un segundo número");
                d = scanner.nextDouble();
                switch (elegirOp) {
                    case 1:
                        suma = c + d;
                        System.out.println("La suma es: " + suma);
                        break;
                    case 2:
                        resta = c - d;
                        System.out.println("La resta es: " + resta);
                        break;
                    case 3:
                        multiplicación = c * d;
                        System.out.println("La multiplicación es: " + multiplicación);
                        break;
                    case 4:
                        int D;
                        if (d == 0) {
                            System.out.println("Ingrese el segundo número diferente de cero");
                            D = scanner.nextInt();
                            d = D;
                        }
                        division = c / d;
                        System.out.println("La división es: " + division);
                        break;
                }
            }
            int seguir = 0;
            while (!(seguir == 1 || seguir == 2)) {
                System.out.println("Desea realizar otra operación: presione 1 (si), presione 2 (no)");
                seguir = scanner.nextInt();
                if (seguir == 1) {
                    break;
                } else if (seguir == 2) {
                    break;
                }
            }

            if (seguir == 1) {
                elegirOp = 0;
            } else if (seguir == 2) {
                System.out.println("Has salido");
                System.exit(0);
            }

        }
    }
}
