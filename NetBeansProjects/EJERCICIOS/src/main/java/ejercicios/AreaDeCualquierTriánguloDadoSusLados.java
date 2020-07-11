package ejercicios;

import java.util.Scanner;

/**
 *
 * @author luis
 */
public class AreaDeCualquierTriánguloDadoSusLados {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("                       [Bienvenido]                       ");
        menúOperaciones();
    }

    public static void menúOperaciones() {

        int opcion = 0;

        while (opcion != 5) {
            System.out.println("¿Qué quieres hacer?");
            if (opcion == 0) {
                do {
                    System.out.println("1. Calcular el área de cualquier triángulo\n2. Calcular el área de un triángulo rectángulo\n"
                            + "3. Calcular el perímetro de cualquier triángulo \n4. Calcular el perímetro de un triángulo rectángulo\n5.Salir");
                    opcion = scanner.nextInt();
                    if (opcion < 0 || opcion > 5) {
                        System.out.println("Elige una opción correcta, por favor.");
                    }
                } while (opcion < 0 || opcion > 5);
            }
            pedirMostrarDatosCualquierTriángulo(opcion);
            int continuar = 0;
            do {
                System.out.println();
                System.out.println("¿Quieres hacer otra operación? 1 (Sí) 2 (No = salir)");
                continuar = scanner.nextInt();
                System.out.println("Opcion incorrecta");
            } while (!(continuar == 1 || continuar == 2));
            if (continuar == 1) {
                opcion = 0;
            } else if (continuar == 2) {
                System.out.println("Adiós");
                System.exit(0);
            }
        }

    }

    public static void pedirDatos(){
    
    }
    public static void pedirMostrarDatosCualquierTriángulo(int opcion) {
        int ladoA = 0, ladoB = 0, ladoC = 0, altura = 0, base = 0;
        switch (opcion) {
            case 1:
                System.out.println("INGRESE UN LADO: A");
                ladoA = scanner.nextInt();
                System.out.println("INGRESE UN LADO: B");
                ladoB = scanner.nextInt();
                System.out.println("INGRESE UN LADO: C");
                ladoC = scanner.nextInt();
                System.out.print("EL ÁREA ES: " + calcularArea(ladoA, ladoB, ladoC));
                break;
            case 2:
                System.out.print("Ingrese altura del triángulo: ");
                altura = scanner.nextInt();
                System.out.print("Ingrese base del triángulo: ");
                base = scanner.nextInt();
                System.out.print("EL ÁREA ES: " + areaTrianguloRectángulo(altura, base));
                break;
            case 3:
                System.out.println("INGRESE UN LADO: A");
                ladoA = scanner.nextInt();
                System.out.println("INGRESE UN LADO: B");
                ladoB = scanner.nextInt();
                System.out.println("INGRESE UN LADO: C");
                ladoC = scanner.nextInt();
                System.out.print("El perímetro es: " + calcularPerímetro(ladoA, ladoB, ladoC));
                break;
            case 4:
                System.out.print("Ingrese altura del triángulo: ");
                altura = scanner.nextInt();
                System.out.print("Ingrese base del triángulo: ");
                base = scanner.nextInt();
                System.out.print("EL perímetro es: " + perímetroTriánguloRectángulo(altura, base));
                break;
            case 5:
                System.out.println("Adiós");
                System.exit(0);
            default:
                break;
        }

    }

    /**
     * Métodos para caclular el área de cualquier triángulo
     */
    static double calcularArea(int ladoA, int ladoB, int ladoC) {
        double a = calcularSemiPerímetro(ladoA, ladoB, ladoC);
        double áreaDelTriángulo = Math.sqrt(a * (a - ladoA) * (a - ladoB) * (a - ladoC));
        return áreaDelTriángulo;
    }

    static double calcularSemiPerímetro(int ladoA, int ladoB, int ladoC) {

        double semiPerímetro = (ladoA + ladoB + ladoC) / 2;
        return semiPerímetro;
    }

    static double calcularPerímetro(int ladoA, int ladoB, int ladoC) {

        double perímetroTriánguloCualquiera = 0;
        perímetroTriánguloCualquiera = ladoA + ladoB + ladoC;
        return perímetroTriánguloCualquiera;
    }

    /**
     * área de un triángulo rectángulo
     */
    static double areaTrianguloRectángulo(int altura, int base) {
        double areaRectángulo;
        areaRectángulo = (altura * base) / 2;
        return areaRectángulo;
    }

    static double perímetroTriánguloRectángulo(int altura, int base) {
        double perímetroRectángulo;
        perímetroRectángulo = altura + base;
        return perímetroRectángulo;
    }
}
