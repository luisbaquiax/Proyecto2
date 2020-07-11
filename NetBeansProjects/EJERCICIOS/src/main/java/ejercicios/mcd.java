package ejercicios;

import java.util.Scanner;

/**
 *
 * @author luis
 */
public class mcd {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] MCD) {

        int númeroA, númeroB;

        if(MCD.length != 2) {
            System.out.println("Ingrese dos números. Ejemplo: 4 espacio 6");
            System.exit(0);
        }
        númeroA = Integer.parseInt(MCD[0]);
        númeroB = Integer.parseInt(MCD[1]);
        System.out.println("MCD " + númeroA + " y " + númeroB + " = " + mcd(númeroA, númeroB));
        
        //númeroA = Integer.parseInt(MCD[0]);
        //númeroB = Integer.parseInt(MCD[1]);
        //System.out.println("MCD " + númeroA + " y " + númeroB + mcd(númeroA, númeroB));
        /*
        System.out.println("ingreseA");
        númeroA = sc.nextInt();
        System.out.println("ingreseB");
        númeroB = sc.nextInt();
        System.out.println("mcd: " + mcd(númeroA, númeroB));*/
    }

    static int mcd(int númeroA, int númeroB) {
        if (númeroB <= númeroA && númeroA % númeroB == 0) {
            return númeroB;
        } else if (númeroA < númeroB) {
            return mcd(númeroB, númeroA);
        } else {
            return mcd(númeroB, númeroA % númeroB);
        }
    }
}
