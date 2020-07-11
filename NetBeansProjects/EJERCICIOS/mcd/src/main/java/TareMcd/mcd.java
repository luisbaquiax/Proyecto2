package TareMcd;

/**
 *
 * @author luis
 */
public class mcd {

    public static void main(String[] MCD) {

        int númeroA, númeroB;

        if (MCD.length == 2) {

            númeroA = Integer.parseInt(MCD[0]);
            númeroB = Integer.parseInt(MCD[1]);

            System.out.printf("MCD %d y %d = %d \n", númeroA, númeroB, mcd(númeroA, númeroB));
            System.exit(0);
        } else if (MCD.length != 2) {
            System.out.println("Ingrese dos números. Ejemplo: 4 espacio 6");
        }

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
