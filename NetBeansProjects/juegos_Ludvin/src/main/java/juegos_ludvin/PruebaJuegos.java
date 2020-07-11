package juegos_ludvin;

/**
 * Ludvin Nicolás Basilio Baquiax Vásquez
 * 201831699
 */
import java.util.Scanner;

public class PruebaJuegos {

    //Reset
    public static final String ANSI_RESET = "\u001B[0m";
    //Colores de letra
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    //Colores de fondo
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void main(String[] parametroConsola) {
        System.out.println("Bienvenido");
        if (parametroConsola.length == 1) {       //en caso de que el usuario ingrese un parametro
            switch (parametroConsola[0]) {
                case "sopa":
                    sopaDeLetras();
                    break;
                case "target":
                    target();
                    break;
                case "2048":
                    dosMilCuarentaYOcho();
                    break;
                default:
                    System.out.println("Parametro invalido");
            }
        }
        menu();
    }

    public static void menu() {
        int opcion;
        System.out.println("Libreria de juegos");
        Scanner lectorEntrada = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("");
            System.out.println("Por favor elija el juego que desea jugar");
            System.out.println("1. Sopa de letras");
            System.out.println("2. Target");
            System.out.println("3. Juego 2048");
            System.out.println("4. Descripcion");
            System.out.println("5. Tabla de Ganadores");
            System.out.println("6. Salir");
            System.out.println("Escribe una de las opciones");
            opcion = lectorEntrada.nextInt();
            switch (opcion) {
                case 1:
                    espacios(30);
                    sopaDeLetras();
                    break;
                case 2:
                    espacios(30);
                    target();
                    break;
                case 3:
                    espacios(30);
                    dosMilCuarentaYOcho();
                    break;
                case 4:
                    espacios(30);
                    descripcion();
                    break;
                case 5:
                    espacios(30);
                    tablaDeGanadores();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opccion incorrecta, por favor eliga de nuevo");
            }
        }
    }

    public static void sopaDeLetras() {
        final int OPORTUNIDADES_DE_ADIVINAR = 3;
        Scanner lectorEntrada = new Scanner(System.in);

        System.out.println("Bienvenido a Sopa de letras");
        System.out.println("Ingrese su nombre");

        String nombreJugador = lectorEntrada.nextLine();
        System.out.println("Ingrese la palabra");
        String palabra = lectorEntrada.nextLine();

        //Guardar palabra en un arreglo
        char[] guardarPalabra = palabra.toCharArray();

        //Generar un numeros aletoria de acuerdo al tamaño de la palabra ingresada
        //Esto para luego colocar las letras en el orden de los numeros aleatorios
        int minimo = 0;
        int numeroElementos = 0;
        //arreglo de para guardar numeros con el numero de letras de la palabra
        int guardarNumeros[] = new int[guardarPalabra.length];
        boolean verificar;
        int aleatorio;
        //genera numeros en orden aleatorio con el rango de la palabra
        while (numeroElementos < guardarPalabra.length) {
            aleatorio = generaNumeroAleatorio(minimo, guardarPalabra.length);
            //valor falso
            verificar = false;
            for (int i = 0; i < guardarNumeros.length && !verificar; i++) {
                if (aleatorio == guardarNumeros[i]) {
                    verificar = true;
                }
            }
            if (!verificar) {
                guardarNumeros[numeroElementos++] = aleatorio;
            }
        }
        espacios(30);
        //equalsIgnoreCase funcion para comparar las palabras sin importar mayusculas
        int intento = 0;
        String palabraAdivinada = null;
        while (intento < OPORTUNIDADES_DE_ADIVINAR && !palabra.equalsIgnoreCase(palabraAdivinada)) {
            System.out.println(nombreJugador + " este es tu intento No. " + (intento + 1));
            System.out.println("Tienes " + OPORTUNIDADES_DE_ADIVINAR + " intentos");
            System.out.println("La palabra esta formada por las siguientes letras");
            //Muestra las letras que forman las palabra de una forma ordenada
            for (int i = 0; i < guardarNumeros.length; i++) {
                int indiceLetra = guardarNumeros[i] - 1;//le restamos 1 para incluir el indice 0
                System.out.print(guardarPalabra[indiceLetra]);
            }
            System.out.println("");
            System.out.println("Ingrese la palabra, que cree que es");
            for (int i = 0; i < guardarNumeros.length; i++) {
                System.out.print("-");
            }
            System.out.println("");
            palabraAdivinada = lectorEntrada.nextLine();
            if (palabra.equalsIgnoreCase(palabraAdivinada)) {
                System.out.println(nombreJugador + " Es correcto, has adivinado la palabra");
            } else {
                System.out.println("Es Incorrecto");
            }
            if (intento == (OPORTUNIDADES_DE_ADIVINAR - 1)) {
                System.out.println("La palabra era: " + palabra);
            }
            System.out.println("");
            intento++;
        }
    }
    final static int PUNTEO_MAXIMO = 200;
    final static int NUMERO_MAXIMO_JUGADORES = 4;

    public static void target() {

        Scanner lectorEntrada = new Scanner(System.in);
        System.out.println("Bienvenido a Target");
        System.out.println("Ingrese la cantidad de jugadores, el numero máximo es " + NUMERO_MAXIMO_JUGADORES);
        int numeroJugadores = lectorEntrada.nextInt();
        if (numeroJugadores <= NUMERO_MAXIMO_JUGADORES) {
            System.out.println("Jugaran " + numeroJugadores);
            String nombres[] = new String[numeroJugadores];
            int punteos[] = new int[numeroJugadores];
            for (int i = 0; i < numeroJugadores; i++) {
                lectorEntrada = new Scanner(System.in);
                System.out.println("Ingrese el nombre del Jugador No. " + (i + 1));
                String nombreTemp = lectorEntrada.nextLine();
                nombres[i] = nombreTemp;
                punteos[i] = 0;
            }
            for (int i = 0; i < numeroJugadores; i++) {
                System.out.println(nombres[i] + " Tienes " + punteos[i] + " puntos");
            }
            int i = 0;
            System.out.println("");
            while (punteos[i] < PUNTEO_MAXIMO) {
                for (int j = 0; j < numeroJugadores && punteos[i] < PUNTEO_MAXIMO; j++) {
                    lectorEntrada = new Scanner(System.in);
                    System.out.println("");
                    System.out.println(nombres[j] + " que tipo de tiro deseas realizar");
                    System.out.println("Ahora tienes: " + punteos[j] + " puntos");
                    System.out.println("1. Rápido con el dardo arriba del brazo ");
                    System.out.println("Otorga 40 o 0 puntos");
                    System.out.println("2. Controlado con el dardo arriba del brazo");
                    System.out.println("Otorga 10, 20 o 30 puntos");
                    System.out.println("3. Con el dardo bajo el brazo");
                    System.out.println("Otorga 0, 10, 20, 30 o 40 puntos");
                    int tipoTiro = lectorEntrada.nextInt();

                    switch (tipoTiro) {
                        case 1: {
                            int minimo = 0;
                            int maximo = 1;
                            int punteo = 40;
                            int punteoGanado = punteoDeTiro(minimo, maximo, punteo);
                            punteos[j] = punteos[j] + punteoGanado;
                            System.out.println(nombres[j] + " Ganaste " + punteoGanado + " puntos");
                            System.out.println(nombres[j] + " Ahora tienes: " + punteos[j]);
                            break;
                        }
                        case 2: {
                            int minimo = 1;
                            int maximo = 3;
                            int punteo = 10;
                            int punteoGanado = punteoDeTiro(minimo, maximo, punteo);
                            punteos[j] = punteos[j] + punteoGanado;
                            System.out.println(nombres[j] + " Ganaste " + punteoGanado + " puntos");
                            System.out.println(nombres[j] + " Ahora tienes: " + punteos[j]);
                            break;
                        }
                        case 3: {
                            int minimo = 0;
                            int maximo = 4;
                            int punteo = 10;
                            int punteoGanado = punteoDeTiro(minimo, maximo, punteo);
                            punteos[j] = punteos[j] + punteoGanado;
                            System.out.println(nombres[j] + " Ganaste " + punteoGanado + " puntos");
                            System.out.println(nombres[j] + " Ahora tienes: " + punteos[j]);
                            break;
                        }
                        default:
                            System.out.println("El tiro no existe, has desperdiciado tu turno");
                            break;
                    }
                    i = j;
                }
            }
        } else {
            System.out.println("El numero de jugadores maximo es 4, has sobrepasado el limite");
        }
    }

    public static int punteoDeTiro(int minimo, int maximo, int punteo) {
        return generaNumeroAleatorio(minimo, maximo) * punteo;
    }

    public static void dosMilCuarentaYOcho() {
        Scanner lectorEntrada = new Scanner(System.in);
        System.out.println("Bienvenido a 2048");
        //Matriz cuadrada de 4x4
        int matriz[][] = new int[4][4];

        int punteo = 0;
        //Variables utilizadas
        boolean salir = false;
        int opcion;
        //Utilizado
        do {
            //Mensajes del menu
            System.out.println("Menu 2048");
            System.out.println("1. Empezar a jugar");
            System.out.println("2. Salir");
            System.out.println("Elije una opcion");
            opcion = lectorEntrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa tu nombre");
                    String nombreJugador = lectorEntrada.next();

                    boolean regresar = false;
                    String movimiento;
                    iniciarJuego(matriz);
                    mostrarMatriz(matriz);
                    do {
                        //Mensajes del menu
                        System.out.println("Juego 2048, suerte " + nombreJugador);
                        System.out.println("w. Arriba");
                        System.out.println("s. Abajo");
                        System.out.println("a. Izquierda");
                        System.out.println("d. Derecha");
                        System.out.println("r. Regresar y abandonar la partida");
                        System.out.println("Elije una opcion");
                        movimiento = lectorEntrada.nextLine();

                        switch (movimiento) {
                            case "w":
                                punteo = moverArriba(matriz, punteo);
                                System.out.println(nombreJugador + " Tienes: " + punteo + " puntos");
                                if (continuarJugando(matriz)) {
                                    agregarNumero(matriz);
                                    mostrarMatriz(matriz);
                                } else {
                                    regresar = !continuarJugando(matriz);
                                }
                                break;
                            case "s":
                                punteo = moverAbajo(matriz, punteo);
                                System.out.println(nombreJugador + " Tienes: " + punteo + " puntos");
                                if (continuarJugando(matriz)) {
                                    agregarNumero(matriz);
                                    mostrarMatriz(matriz);
                                } else {
                                    regresar = !continuarJugando(matriz);
                                }
                                break;
                            case "a":
                                punteo = moverIzquierda(matriz, punteo);
                                System.out.println(nombreJugador + " Tienes: " + punteo + " puntos");
                                if (continuarJugando(matriz)) {
                                    agregarNumero(matriz);
                                    mostrarMatriz(matriz);
                                } else {
                                    regresar = !continuarJugando(matriz);
                                }
                                break;
                            case "d":
                                punteo = moverDerecha(matriz, punteo);
                                System.out.println(nombreJugador + " Tienes: " + punteo + " puntos");
                                if (continuarJugando(matriz)) {
                                    agregarNumero(matriz);
                                    mostrarMatriz(matriz);
                                } else {
                                    regresar = !continuarJugando(matriz);
                                }
                                break;
                            case "r":
                                regresar = true;
                                break;
                            default:
                                System.out.println("Movimiento invalido");

                        }

                    } while (!regresar);

                    System.out.println("Fin de la partida");
                    break;
                case 2:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (!salir);
    }

    public static void iniciarJuego(int[][] matriz) {
        agregarNumero(matriz);
        agregarNumero(matriz);
    }

    public static void mostrarMatriz(int[][] matriz) {

        for (int i = 0; i < 35; i++) {
            System.out.print("-");
        }
        System.out.println("");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == 0) {
                    System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "|      |" + ANSI_WHITE_BACKGROUND + ANSI_RESET + " ");
                } else if (matriz[i][j] == 2) {
                    System.out.print(ANSI_RED_BACKGROUND + ANSI_CYAN + "|" + matriz[i][j] + "     |" + ANSI_WHITE_BACKGROUND + ANSI_RESET + " ");
                } else if (matriz[i][j] == 4) {
                    System.out.print(ANSI_PURPLE_BACKGROUND + ANSI_BLACK + "|" + matriz[i][j] + "     |" + ANSI_WHITE_BACKGROUND + ANSI_RESET + " ");
                } else if (matriz[i][j] == 8) {
                    System.out.print(ANSI_BLUE_BACKGROUND + ANSI_YELLOW + "|" + matriz[i][j] + "     |" + ANSI_WHITE_BACKGROUND + ANSI_RESET + " ");
                } else if (matriz[i][j] == 16) {
                    System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_RED + "|" + matriz[i][j] + "    |" + ANSI_WHITE_BACKGROUND + ANSI_RESET + " ");
                } else if (matriz[i][j] == 32) {
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_BLUE + "|" + matriz[i][j] + "    |" + ANSI_WHITE_BACKGROUND + ANSI_RESET + " ");
                } else if (matriz[i][j] == 64) {
                    System.out.print(ANSI_RED_BACKGROUND + ANSI_BLACK + "|" + matriz[i][j] + "    |" + ANSI_WHITE_BACKGROUND + ANSI_RESET + " ");
                } else if (matriz[i][j] == 128) {
                    System.out.print(ANSI_BLACK_BACKGROUND + ANSI_CYAN + "|" + matriz[i][j] + "   |" + ANSI_WHITE_BACKGROUND + ANSI_RESET + " ");
                } else if (matriz[i][j] == 256) {
                    System.out.print(ANSI_RED_BACKGROUND + ANSI_YELLOW + "|" + matriz[i][j] + "   |" + ANSI_WHITE_BACKGROUND + ANSI_RESET + " ");
                } else if (matriz[i][j] == 512) {
                    System.out.print(ANSI_PURPLE_BACKGROUND + ANSI_RED + "|" + matriz[i][j] + "   |" + ANSI_WHITE_BACKGROUND + ANSI_RESET + " ");
                } else if (matriz[i][j] == 1024) {
                    System.out.print(ANSI_BLUE_BACKGROUND + ANSI_WHITE + "|" + matriz[i][j] + "  |" + ANSI_WHITE_BACKGROUND + ANSI_RESET + " ");
                } else {
                    System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_BLUE + "|" + matriz[i][j] + "  |" + ANSI_WHITE_BACKGROUND + ANSI_RESET + " ");
                }
                if (j == (matriz[i].length - 1)) {
                    System.out.println("");
                }
            }
            for (int k = 0; k < 35; k++) {
                System.out.print("-");
            }
            System.out.println("");
        }
    }

    public static int numeroDosOCuatro() {
        int minimo = 1;
        int maximo = 2;
        int numeroAleatorio = generaNumeroAleatorio(minimo, maximo) * 2;
        return numeroAleatorio;
    }

    public static boolean continuarJugando(int matriz[][]) {
        boolean movimiento = true;
        for (int k = 0; k <= (matriz.length - 1); k++) {
            for (int l = 0; l <= (matriz.length - 1); l++) {
                if (matriz[k][l] == 0) {
                    movimiento = true;
                }
            }
        }
        return movimiento;
    }

    public static void agregarNumero(int[][] matriz) {
        boolean agregar = false;
        //while se repite hasta que se agregue un numero aleatorio
        while (!agregar) {
            int i = generaNumeroAleatorio(0, (matriz.length - 1));
            int j = generaNumeroAleatorio(0, (matriz.length - 1));
            //si la posicion en la matriz es igual a 0 se agrega el numero 2 o 4
            if (matriz[i][j] == 0) {
                matriz[i][j] = numeroDosOCuatro();
                agregar = true;
            }
        }

    }

    public static int moverArriba(int[][] matriz, int punteo) {
        //comparacion inicia de abajo hacia arriba
        for (int i = 0; i < 4; i++) {
            int posicionComparar = 0;//indica la casilla que vamos a comparar
            int comparador = 1;//indica la casilla con la que vamos a comparar
            //por eso se inicia en uno mas que la posicion
            int cursor = 0;//indica la casilla que se va a modificar 
            while (posicionComparar <= 3 && comparador < 4) {
                //condicion para realizar la suma comparando el contador poscicion y comparador
                //sumando en la casilla cursor
                //y que las casillas pocicion y comparador sea diferente de 0
                if (posicionComparar < 3 && matriz[posicionComparar][i] == matriz[comparador][i] && matriz[posicionComparar][i] != 0
                        && matriz[comparador][i] != 0) {
                    int suma = matriz[comparador][i] + matriz[posicionComparar][i];
                    matriz[posicionComparar][i] = 0;
                    matriz[comparador][i] = 0;
                    matriz[cursor][i] = suma;
                    cursor++;
                    posicionComparar = comparador + 1;
                    comparador += 2;
                    punteo = punteo + suma;
                    //condicion en caso de que la casilla posicionComparar sea 0
                } else if (matriz[posicionComparar][i] == 0) {
                    posicionComparar++;
                    comparador++;
                    //condicion en caso de que la casilla comparador sea 0
                } else if (matriz[comparador][i] == 0) {
                    comparador++;
                } else {
                    // Si Ambos son diferentes de cero y diferentes entre si                    // si
                    int aux = matriz[posicionComparar][i];
                    matriz[posicionComparar][i] = 0;
                    matriz[cursor][i] = aux;
                    cursor++;
                    posicionComparar = comparador;
                    comparador++;
                }
            }
            if (posicionComparar <= 3) {
                int aux = matriz[posicionComparar][i];
                matriz[posicionComparar][i] = 0;
                matriz[cursor][i] = aux;

            }
        }
        return punteo;
    }

    public static int moverAbajo(int[][] matriz, int punteo) {
        //comparacion inicia de arriva hacia abajo
        for (int i = 0; i < 4; i++) {
            int posicionComparar = 3;//indica la casilla que vamos a comparar
            int comparador = 2;//indica la casilla con la que vamos a comparar
            //por eso se inicia en uno menos que la posicion
            int cursor = 3;//indica la casilla que se va a modificar 
            while (posicionComparar >= 0 && comparador > -1) {
                //condicion para realizar la suma comparando el contador poscicion y comparador
                //sumando en la casilla cursor
                //y que las casillas pocicion y comparador sea diferente de 0
                if (posicionComparar > 0 && matriz[posicionComparar][i] == matriz[comparador][i] && matriz[posicionComparar][i] != 0
                        && matriz[comparador][i] != 0) {
                    int suma = matriz[comparador][i] + matriz[posicionComparar][i];
                    matriz[posicionComparar][i] = 0;
                    matriz[comparador][i] = 0;
                    matriz[cursor][i] = suma;
                    cursor--;
                    posicionComparar = comparador - 1;
                    comparador -= 2;
                    punteo = punteo + suma;
                    //condicion en caso de que la casilla posicion sea 0
                } else if (matriz[posicionComparar][i] == 0) {
                    posicionComparar--;
                    comparador--;//condicion en caso de que la casilla  comparador sea 0
                } else if (matriz[comparador][i] == 0) {
                    comparador--;
                } else { // Ambos son diferentes de cero y diferentes entre si
                    int aux = matriz[posicionComparar][i];
                    matriz[posicionComparar][i] = 0;
                    matriz[cursor][i] = aux;
                    cursor--;
                    posicionComparar = comparador;
                    comparador--;
                }
            }
            if (posicionComparar >= 0) {
                int aux = matriz[posicionComparar][i];
                matriz[posicionComparar][i] = 0;
                matriz[cursor][i] = aux;

            }
        }
        return punteo;
    }

    public static int moverIzquierda(int[][] matriz, int punteo) {
        //comparacion inicia de derecha hacia izquierda
        for (int i = 0; i < 4; i++) {
            int posicionComparar = 0;
            int comparador = 1;
            int cursor = 0;
            while (posicionComparar <= 3 && comparador < 4) {
                if (posicionComparar < 3 && matriz[i][posicionComparar] == matriz[i][comparador] && matriz[i][posicionComparar] != 0
                        && matriz[i][comparador] != 0) {
                    int suma = matriz[i][comparador] + matriz[i][posicionComparar];
                    matriz[i][posicionComparar] = 0;
                    matriz[i][comparador] = 0;
                    matriz[i][cursor] = suma;
                    cursor++;
                    posicionComparar = comparador + 1;
                    comparador += 2;
                    punteo = punteo + suma;
                } else if (matriz[i][posicionComparar] == 0) {
                    posicionComparar++;
                    comparador++;
                } else if (matriz[i][comparador] == 0) {
                    comparador++;
                } else {
                    int aux = matriz[i][posicionComparar];
                    matriz[i][posicionComparar] = 0;
                    matriz[i][cursor] = aux;
                    cursor++;
                    posicionComparar = comparador;
                    comparador++;
                }
            }
            if (posicionComparar <= 3) {
                int aux = matriz[i][posicionComparar];
                matriz[i][posicionComparar] = 0;
                matriz[i][cursor] = aux;

            }
        }
        return punteo;
    }

    public static int moverDerecha(int[][] matriz, int punteo) {
        //comparacion inicia de izquierda hacia derecha
        for (int i = 0; i < 4; i++) {
            int posicionComparar = 3;
            int comparador = 2;
            int cursor = 3;
            while (posicionComparar >= 0 && comparador > -1) {
                if (posicionComparar > 0 && matriz[i][posicionComparar] == matriz[i][comparador] && matriz[i][posicionComparar] != 0
                        && matriz[i][comparador] != 0) {
                    int suma = matriz[i][comparador] + matriz[i][posicionComparar];
                    matriz[i][posicionComparar] = 0;
                    matriz[i][comparador] = 0;
                    matriz[i][cursor] = suma;
                    cursor--;
                    posicionComparar = comparador - 1;
                    comparador -= 2;
                    punteo = punteo + suma;
                } else if (matriz[i][posicionComparar] == 0) {
                    posicionComparar--;
                    comparador--;
                } else if (matriz[i][comparador] == 0) {
                    comparador--;
                } else {
                    int aux = matriz[i][posicionComparar];
                    matriz[i][posicionComparar] = 0;
                    matriz[i][cursor] = aux;
                    cursor--;
                    posicionComparar = comparador;
                    comparador--;
                }
            }
            if (posicionComparar >= 0) {
                int aux = matriz[i][posicionComparar];
                matriz[i][posicionComparar] = 0;
                matriz[i][cursor] = aux;
            }
        }
        return punteo;
    }

    public static void descripcion() {
        System.out.println("Bienvenido a Descripcion de los juegos");
        System.out.println("Te damos una breve descripcion de los juegos\n");
        System.out.println("Sopa de letras");
        System.out.println("El objetivo es la entrada de una palabra,\n"
                + " luego esta devolveran las letras en un orden aleatorio,\n"
                + " el jugador contará con tres intentos,\n"
                + " para adivinar la palabra colocada inicialmente,");
        System.out.println("\nTarget");
        System.out.println("\n En este juego pueden participar hasta 4 jugadores,"
                + "\n y lanzar dardos a un objetivo que tiene zonas de 10, 20, 30 y 40 puntos\n"
                + "se ganan puntos al acertar en alguna zona o se obtienen cero puntos,\n "
                + "si se falla el tiro, quien alcance 200 puntos o más gana.");
        System.out.println("\n2048");
        System.out.println("Tiene como objetivo combinar números (potencias de 2)\n "
                + "con el fin de alcanzar el máximo de baldosas (2048) y ganar el juego.");

    }

    public static void tablaDeGanadores() {
        System.out.println("Te mostramos los gandores");
        System.out.println("Lo sentimos, opcion aun no disponible");
    }

//Metodo para generar dos numero aleatorios con un rango
    public static int generaNumeroAleatorio(int minimo, int maximo) {
        //math.floor redondea el numero al numero inferior
        //Math.random genera un decimal entre 0 incluido y 1 no incluido
        //math.random multiplicado por el rango(genera numero desde el 0 hasta el rango)
        //es por eso que se le suma el minimo)
        int numero = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return numero;
    }

    public static void espacios(int cantLineas) {
        for (int i = 0; i <= cantLineas; i++) {
            System.out.println("");
        }
    }
}