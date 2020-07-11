
import java.util.Scanner;

/**
 *
 * @author jose
 */
public class Totito {

    public static final int CANTIDAD_JUGADAS = 9;

    /**
     * Procedimiento principal
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombre1;
        String nombre2;
        int fila;
        int columna;
        int turno;
        int marcasAgregadas;

        String[][] tablero = new String[3][3];

        System.out.println("Ingrese nombre jugador1:");
        nombre1 = scanner.nextLine();
        System.out.println("Ingrese nombre jugador2:");
        nombre2 = scanner.nextLine();

        marcasAgregadas = 0;
        turno = 1;
        String marca = "";
        do {
            boolean esTiroValido;
            boolean esCasillaVacia = false;
            dibujarTablero(tablero);
            if (turno == 1) {
                fila = pedirFila(nombre1, scanner);
                columna = pedirColumna(nombre1, scanner);
            } else {
                fila = pedirFila(nombre2, scanner);
                columna = pedirColumna(nombre2, scanner);
            }

            esTiroValido = esPosicionValida(fila, columna);
            if (esTiroValido) {
                esCasillaVacia = esCasillaVacia(fila, columna, tablero);
            }

            if (!esTiroValido || !esCasillaVacia) {
                System.out.println("La casilla está fuera del tablero o no está vacía. Pierde su turno.");

            } else {
                if (turno == 1) {
                    marca = "x";
                } else {

                    marca = "o";
                }

                tablero[fila - 1][columna - 1] = marca;
                marcasAgregadas = marcasAgregadas + 1;
            }

            turno = alternarTurno(turno);

        } while (!esTableroLleno(marcasAgregadas) && !seHizoLinea(tablero, marca));
        dibujarTablero(tablero);

        //si se sale del ciclo es porque alguien gano o se lleno el tablero
        if (esTableroLleno(marcasAgregadas)) {
            System.out.println("Empate! nadie gana");
        } else if (turno == 2) { // como hay un cambio de turno antes de validar si alguien gano, entonces se revierte ese cambio.
            System.out.println("Gano jugador 1:");
            System.out.println(nombre1);
        } else {
            System.out.println("Gano jugador 2:");
            System.out.println(nombre2);
        }

    }

    /**
     * Pide la fila de la casilla seleccionada
     *
     * @param jugador
     * @param scanner
     * @return el indice de la fila
     */
    public static int pedirFila(String jugador, Scanner scanner) {
        int fila;
        System.out.println("Jugador " + jugador + " ingrese fila:");
        fila = Integer.parseInt(scanner.nextLine());
        return fila;
    }

    /**
     * Pide la columna de la casilla seleccionada
     *
     * @param jugador
     * @param scanner
     * @return el indice de la columna
     */
    public static int pedirColumna(String jugador, Scanner scanner) {
        int columna;
        System.out.println("Jugador " + jugador + " ingrese columna:");
        columna = Integer.parseInt(scanner.nextLine());
        return columna;
    }

    /**
     * Verifica si el tablero ya está lleno
     *
     * @param marcasAgregadas
     * @return true si el tablero está lleno
     */
    public static boolean esTableroLleno(int marcasAgregadas) {
        return marcasAgregadas == CANTIDAD_JUGADAS;
    }

    /**
     * Verifica en el tablero si ya se ha logrado una linea recta
     *
     * @param tablero
     * @param marca
     * @return true si ya hay linea recta
     */
    public static boolean seHizoLinea(String[][] tablero, String marca) {

        if (seHizoFila(tablero, 0, marca)) {
            return true;
        } else if (seHizoFila(tablero, 1, marca)) {
            return true;
        } else if (seHizoFila(tablero, 2, marca)) {
            return true;
        } else if (seHizoColumna(tablero, 0, marca)) {
            return true;
        } else if (seHizoColumna(tablero, 1, marca)) {
            return true;
        } else if (seHizoColumna(tablero, 2, marca)) {
            return true;
        } else if (seHizoDiagonal1(tablero, marca)) {
            return true;
        } else if (seHizoDiagonal2(tablero, marca)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica en el tablero si ya se ha logrado una linea recta en la fila
     * identificada por el indice
     *
     * @param tablero
     * @param fila
     * @param marca
     * @return true si ya hay linea en la fila indicada
     */
    public static boolean seHizoFila(String[][] tablero, int fila, String marca) {
        // Esta parte cambia respecto al algoritmo porque aqui en java un elemento null
        // no puede ser comparado con nada ya que null es la ausencia de valor
        // por lo que antes de comparar el valor de cada casilla debemos estar seguros
        // de obtener un valor valido.
        // Lo mismo aplica para todas las intrucciones que usan el valor de alguna casilla
        return obtenerMarcaParaDibujar(tablero[fila][0]).equals(marca)
                && obtenerMarcaParaDibujar(tablero[fila][1]).equals(marca)
                && obtenerMarcaParaDibujar(tablero[fila][2]).equals(marca);
    }

    /**
     * Verifica en el tablero si ya se ha logrado una linea recta en la columna
     * identificada por el indice
     *
     * @param tablero
     * @param columna
     * @param marca
     * @return true si ya hay linea en la columna indicada
     */
    public static boolean seHizoColumna(String[][] tablero, int columna, String marca) {
        return obtenerMarcaParaDibujar(tablero[0][columna]).equals(marca)
                && obtenerMarcaParaDibujar(tablero[1][columna]).equals(marca)
                && obtenerMarcaParaDibujar(tablero[2][columna]).equals(marca);
    }

    /**
     * Verifica en el tablero si ya se ha logrado una linea recta en la diagonal
     * descendente del tablero
     *
     * @param tablero
     * @param marca
     * @return true si ya hay linea en la diagonal descendete
     */
    public static boolean seHizoDiagonal1(String[][] tablero, String marca) {
        return obtenerMarcaParaDibujar(tablero[0][0]).equals(marca)
                && obtenerMarcaParaDibujar(tablero[1][1]).equals(marca)
                && obtenerMarcaParaDibujar(tablero[2][2]).equals(marca);
    }

    /**
     * Verifica en el tablero si ya se ha logrado una linea recta en la diagonal
     * ascendente del tablero
     *
     * @param tablero
     * @param marca
     * @return true si ya hay linea en la diagonal ascendete
     */
    public static boolean seHizoDiagonal2(String[][] tablero, String marca) {
        return obtenerMarcaParaDibujar(tablero[2][0]).equals(marca)
                && obtenerMarcaParaDibujar(tablero[1][1]).equals(marca)
                && obtenerMarcaParaDibujar(tablero[0][2]).equals(marca);
    }

    /**
     * Verifica que los indices de fila y columna ingresados por el usuario
     * esten dentro del tablero
     *
     * @param fila
     * @param columna
     * @return true si los indices estan dentro del tablero
     */
    public static boolean esPosicionValida(int fila, int columna) {

        boolean esValida;
        fila = fila - 1;
        columna = columna - 1;
        if (fila >= 0 && fila <= 2 && columna >= 0 && columna <= 2) {
            esValida = true;
        } else {
            esValida = false;
        }

        return esValida;

    }

    /**
     * Verifica que la casilla seleccionada esté vacia
     *
     * @param fila
     * @param columna
     * @param tablero
     * @return true si la casilla está vacia
     */
    public static boolean esCasillaVacia(int fila, int columna, String[][] tablero) {

        String valorEnCasilla;

        valorEnCasilla = tablero[fila - 1][columna - 1];
        if (valorEnCasilla == null) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Controla la alternancia de turnos basandose en el turno actual
     *
     * @param turnoActual
     * @return 2 si el turno actual es 1, de lo contrario 1
     */
    public static int alternarTurno(int turnoActual) {

        if (turnoActual == 1) {
            return 2;
        } else {
            return 1;
        }
    }

    /**
     * Usando caracteres "dibuja" en pantalla el tablero de totito
     *
     * @param tablero
     */
    public static void dibujarTablero(String[][] tablero) {
        for (int i = 0; i < 3; i++) {
            System.out.printf("fila %d: %s | %s | %s\n", i + 1,
                    obtenerMarcaParaDibujar(tablero[i][0]),
                    obtenerMarcaParaDibujar(tablero[i][1]),
                    obtenerMarcaParaDibujar(tablero[i][2])
            );
            System.out.println("       ---|---|---");
        }
        System.out.println("cols    1 | 2 | 3 ");

    }

    /**
     * Basado en el valor de la marca se devuelve la cadena a usar para dibujar
     * dicha marca en pantalla.
     *
     * Esta funcion principalmente es para evitar un NullPointerException al
     * momento de intentar usar el valor de una casilla vacia (null)
     *
     * @param marca
     * @return si la marca es nula se devuelve un espacio en blanco, de lo
     * contrario se devuelve el valor de la marca
     */
    public static String obtenerMarcaParaDibujar(String marca) {
        return marca == null ? " " : marca;
    }
}
