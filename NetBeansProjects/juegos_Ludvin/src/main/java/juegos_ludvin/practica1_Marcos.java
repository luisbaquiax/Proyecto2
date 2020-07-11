package Ejercicios_SImples;

import java.util.Scanner;
import java.util.Random;

public class practica1_Marcos {

//Estas seran nuestras variables globales para almacenar los nombres y punteos de los participantes de los juegos, los inicializamos como en 1
    public static String[] nombres = new String[1];
    public static int[] punteos = new int[1];

    public static void main(String[] args) {
        //Llamamos el procedimiento menu
        //Usaremos una variable nombre en cada juego para llevar el control del jugador en su nombre y que se vea mas estetico

        if (args.length > 0) {
            menu(Integer.parseInt(args[0]));
        } else {
            menu(0);
        }
    }

    public static void menu(int juego) {
        /* Declaramos la variables necesarias
      decisionMenu sera el quien decidira si los valores ingresados estan de acuerdo a la tabla de parametros establecidos
      continuacionJuego la utilizaremos como la variable para indicar si el usuario quiere seguir jugando
      seleccionMenu es la variable en donde almacenaremos las opciones puestas por el usuario
      continuacionCilo la utilizaremos para corroborar si quiere repetir el juego, salir o ir al menu de nuevo
         */
        boolean decisionMenu;
        boolean continuacionJuego = true;
        int continuacionCiclo = 1;
        int seleccionMenu = 0;
        Scanner escaner = new Scanner(System.in);
        seleccionMenu = juego;
        while (continuacionJuego == true) {
            continuacionCiclo = 1;

            /* Esta es la parte del menu, se encuentra en un ciclo que comprueba si los valores ingresados
      se encuentran en el rango de las opciones dadas, de lo contrario repetira el ciclo hasta obtener un
      valor satisfactorio, es un ciclo comparativo  */
            if (seleccionMenu == 0) {

                do {

                    System.out.println("\nBienvenido al menu de juegos");
                    System.out.println("Selecciona el juego que quieres jugar");
                    System.out.println("Ingresa '1': Sopa de letras ");
                    System.out.println("Ingresa '2': Target ");
                    System.out.println("Ingresa '3': 2048 ");
                    System.out.println("Ingresa '4': Ver Punteos");
                    System.out.println("Ingresa '5': Salir del programa ");

                    seleccionMenu = Integer.parseInt(escaner.nextLine());

                    // Condicion para reconocer si los valores ingresados estan en el sistema, y lo decide a traves de una variable booleana
                    if ((seleccionMenu >= 1) && (seleccionMenu <= 5)) {
                        decisionMenu = true;
                    } else {
                        decisionMenu = false;
                        System.out.println("Has ingresado una opcion incorrecta, vuelve a intentar, recuerda que solo son numeros los que hay que ingresar");
                    }
                } while (decisionMenu == false);
            }

            while (continuacionCiclo == 1) {
                // Condiciones para llamar el tipo de juego que se requiere
                switch (seleccionMenu) {

                    case 1:
                        sopaLetras(); // la funcion sopaLetras inicia el juego de sopa de letras que regresara un punteo depende si gano o perdio activando la funcion punteo
                        continuacionCiclo = repetirJuego(1);
                        break;

                    case 2:
                        target();
                        continuacionCiclo = repetirJuego(2);
                        break;

                    case 3:
                        juego2048();
                        continuacionCiclo = repetirJuego(3);
                        break;

                    case 4:
                        //Muestra todos los jugadores que han participado en los juegos, y las veces que han ganado es decir su punteo
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("            Punteos                     ");
                        System.out.println("Nombre                  Puntos Ganados");
                        for (int sizeNombres = 0; sizeNombres < nombres.length - 1; sizeNombres++) {
                            System.out.println(nombres[sizeNombres] + "                 " + punteos[sizeNombres]);
                        }
                        System.out.println("Ingresa cualquier caracter para continuar");
                        escaner.nextLine();
                        continuacionCiclo = 2;
                        break;
                    case 5:
                        continuacionCiclo = 3;
                        break;

                }

            }

            if (continuacionCiclo == 3) {
                System.out.println("Hasta Pronto.......");
                continuacionJuego = false;
            }
            seleccionMenu = 0;
        }

    }

    public static void juego2048() {
        Scanner escaner = new Scanner(System.in);
        Random posicionAleatoria = new Random();
        boolean victoria = false;
        char direccion;
        String nombre;
        int columna;
        int fila;
        int espaciosOcupados;
        int numeroAparecido;
        int[][] guardaNumerosAleatorios = new int[4][4];
        String[][] cuadricula = new String[4][4];

        for (int posicionColumna = 0; posicionColumna < 4; posicionColumna++) {
            for (int posicionFila = 0; posicionFila < 4; posicionFila++) {
                cuadricula[posicionColumna][posicionFila] = "    ";
            }
        }

        System.out.println("\n Bienvenido al juego de 2048");
        System.out.println("Instrucciones: Tienes una cuadricula de 4 x 4");
        System.out.println("en el cual tendras potencias de 2");
        System.out.println("tienes que mover hacia las direcciones dadas");
        System.out.println("para sumar las potencias de misma base ");
        System.out.println("si logras sumar todas hasta llegar a 2048 GANAS");
        System.out.println("si te quedas sin espacios pierdes\n\n\n");

        nombre = asignarNombres();

        while (victoria == false) {
            espaciosOcupados = 0;

            for (int posicionFila = 0; posicionFila < 4; posicionFila++) {
                for (int posicionColumna = 0; posicionColumna < 4; posicionColumna++) {
                    if (cuadricula[posicionFila][posicionColumna].equals("2048")) {
                        victoria = true;
                    }
                }
            }
            if (victoria == true) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                graficarCuadricula(cuadricula);
                System.out.println(nombre + " HAS GANADO");
                //le sumamos un punto al jugador
                asignarPunteo(1, nombre);
                break;
            }

            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Ingresa 'w' para dirigir todos los numeros hacia arriba");
            System.out.println("Ingresa 's' para dirigir todos los numeros hacia abajo");
            System.out.println("Ingresa 'd' para dirigir todos los numeros hacia derecha");
            System.out.println("Ingresa 'a' para dirigir todos los numeros hacia izquierda");
            System.out.println("Ingresa 'f' para salir del juego");
            System.out.println("Ingresa cualquier caracter para avanzar un turno sin hacer nada\n\n");
            //Se hace un ciclo que terminara hasta que encuentra una posicion que no se halle un numero y colocara el 2 alli
            // la variable columna la utilizamos para seleccionar la posicion aleatoria de aparicion del 2
            while (true) {

                columna = (posicionAleatoria.nextInt(4) + 1) - 1;
                fila = (posicionAleatoria.nextInt(4) + 1) - 1;
                numeroAparecido = posicionAleatoria.nextInt(2) + 1;

                if (cuadricula[columna][fila].equals("    ") == true) {
                    if (numeroAparecido == 1) {
                        cuadricula[columna][fila] = "2   ";
                    } else {
                        cuadricula[columna][fila] = "4   ";
                    }
                    break;
                } else if ((cuadricula[columna][fila].equals("    ") == false) && (guardaNumerosAleatorios[columna][fila] == 0)) {
                    espaciosOcupados++;
                    guardaNumerosAleatorios[columna][fila] = 1;
                    if (espaciosOcupados == 16) {
                        victoria = true;
                        break;
                    }
                }

            }

            guardaNumerosAleatorios = new int[4][4];

            graficarCuadricula(cuadricula);
            if (victoria == true) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.println(nombre + " HAS PERDIDO");
                //solo agregamos su nombre pero su puntuacion no incrementa
                asignarPunteo(0, nombre);
                break;
            }
            direccion = escaner.nextLine().charAt(0);
            cuadricula = acomodamiento(direccion, cuadricula);
            if (direccion == 'f') {
                victoria = true;
            }

        }

    }

    public static void graficarCuadricula(String[][] cuadricula) {
        // Se grafica la cuadricula utilizando dos ciclos for, para parametros de la matriz
        for (int posicionFila = 0; posicionFila < 4; posicionFila++) {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.print("x");
            for (int posicionColumna = 0; posicionColumna < 4; posicionColumna++) {
                //esta en un doble ciclo se escoge de primero la posicion de la fila de la matriz y luego se coloca su posicion de columnas
                System.out.print(" " + cuadricula[posicionFila][posicionColumna] + "  ");
            }
            System.out.println("x");
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    public static String[][] acomodamiento(char direccion, String[][] cuadricula) {
        //El numeroA lo utilizaremos para sumar los numeros que sean iguales
        /*espacios lo utilizaremos para agregar los espacios en blanco a los numeros faltantes para que queden como una cifra de 4 espaciosOcupados
        , para que se mantenga la estructura del cuadro sin que se vea afectada
         */
        int numeroA;
        int espacios;
        for (int fila = 0; fila < 4; fila++) {

            for (int columna = 0; columna < 4; columna++) {

                switch (direccion) {
                    case 'w':
                        /*Creamos una condicion que empezara a mover los numeros si la posicion en esa parte
                de la matriz no esta vacia, cuando la encuentra mueve desde esa posicion hacia arriba
                del cuadro y si se encuentra alguna parte igual la suma , si esta vacia la remplaza y si no se queda igual
                         */
                        if (cuadricula[columna][fila].equals("    ") == false) {
                            for (int vecesMovimiento = columna; vecesMovimiento > 0; vecesMovimiento--) {
                                //Verigica si hay un numero igual arriba suyo para sumarse
                                if (cuadricula[vecesMovimiento][fila].equals(cuadricula[vecesMovimiento - 1][fila])) {
                                    /* Como los numeros son iguales se toma uno, se convierte el string de esa parte de la cuadricula a
                        numeroA la duplica y se la agrega a la posicion de arriba
                                     */
                                    numeroA = Integer.parseInt(cuadricula[vecesMovimiento][fila].replaceAll(" ", ""));
                                    numeroA += numeroA;
                                    cuadricula[vecesMovimiento - 1][fila] = Integer.toString(numeroA);
                                    /* desde la parte de espacios = 4 - cuadricula[vecesMovimiento-1]... hasta el for solo es el numero de espacios agregados al numero que dara
                          para que se mantenga posicionado junto con la cuadricula
                                     */
                                    espacios = 4 - cuadricula[vecesMovimiento - 1][fila].length();
                                    for (int barras = espacios; barras > 0; barras--) {
                                        cuadricula[vecesMovimiento - 1][fila] += " ";
                                    }
                                    cuadricula[vecesMovimiento][fila] = "    ";
                                } //Condicion que indica si hay un espacio vacio en una posicion arriba la sustituye la de abajo
                                else if (cuadricula[vecesMovimiento - 1][fila].equals("    ")) {
                                    cuadricula[vecesMovimiento - 1][fila] = cuadricula[vecesMovimiento][fila];
                                    cuadricula[vecesMovimiento][fila] = "    ";
                                }
                            }
                        }
                        break;

                    case 's':
                        /*Creamos una condicion que empezara a mover los numeros si la posicion en esa parte
                de la matriz no esta vacia,tomando en cuenta que inicia a contar de abajo para arriba, cuando la encuentra mueve
                desde esa posicion hacia abajo del cuadro y si se encuentra alguna parte igual la suma , si esta vacia la remplaza y si no se queda igual
                         */
                        if (cuadricula[3 - columna][fila].equals("    ") == false) {
                            //Empezamos el ciclo en una posicion de abajo de la matriz
                            // llegaremos hasta 2 ya que sigue comparando con una posicion abajo extra gracias al +1
                            for (int vecesMovimiento = 3 - columna; vecesMovimiento < 3; vecesMovimiento++) {
                                /* Como los numeros son iguales se toma uno, se convierte el string de esa parte de la cuadricula a
                    numeroA la duplica y se la agrega a la posicion de abajo
                                 */
                                if (cuadricula[vecesMovimiento][fila].equals(cuadricula[vecesMovimiento + 1][fila])) {
                                    numeroA = Integer.parseInt(cuadricula[vecesMovimiento][fila].replaceAll(" ", ""));
                                    numeroA += numeroA;
                                    cuadricula[vecesMovimiento + 1][fila] = Integer.toString(numeroA);
                                    /* desde la parte de espacios = 4 - cuadricula[vecesMovimiento-1]... hasta el for solo es el numero de espacios agregados al numero que dara
                        para que se mantenga posicionado junto con la cuadricula
                                     */
                                    espacios = 4 - cuadricula[vecesMovimiento + 1][fila].length();
                                    for (int barras = espacios; barras > 0; barras--) {
                                        cuadricula[vecesMovimiento + 1][fila] += " ";
                                    }
                                    cuadricula[vecesMovimiento][fila] = "    ";
                                } //Condicion que indica si hay un espacio vacio en una posicion abajo la sustituye la de arriba
                                else if (cuadricula[vecesMovimiento + 1][fila].equals("    ")) {
                                    cuadricula[vecesMovimiento + 1][fila] = cuadricula[vecesMovimiento][fila];
                                    cuadricula[vecesMovimiento][fila] = "    ";
                                }
                            }
                        }
                        break;

                    case 'a':
                        /*Creamos una condicion que empezara a mover los numeros si la posicion en esa parte
                de la matriz no esta vacia,tomando en cuenta que inicia a contar de izquierda a derecha, cuando la encuentra mueve
                desde esa posicion hacia la izquierda del cuadro y si se encuentra alguna parte igual la suma , si esta vacia la remplaza y si no se queda igual
                         */
                        if (cuadricula[fila][columna].equals("    ") == false) {
                            //Empezamos el ciclo en una posicion de la izquierda de la matriz, es decir inicializada en 0
                            for (int vecesMovimiento = columna; vecesMovimiento > 0; vecesMovimiento--) {
                                /* Como los numeros son iguales se toma uno, se convierte el string de esa parte de la cuadricula a
                    numeroA la duplica y se la agrega a la posicion de izquierda
                                 */
                                if (cuadricula[fila][vecesMovimiento].equals(cuadricula[fila][vecesMovimiento - 1])) {
                                    numeroA = Integer.parseInt(cuadricula[fila][vecesMovimiento].replaceAll(" ", ""));
                                    numeroA += numeroA;
                                    cuadricula[fila][vecesMovimiento - 1] = Integer.toString(numeroA);
                                    espacios = 4 - cuadricula[fila][vecesMovimiento - 1].length();
                                    for (int barras = espacios; barras > 0; barras--) {
                                        cuadricula[fila][vecesMovimiento - 1] += " ";
                                    }
                                    cuadricula[fila][vecesMovimiento] = "    ";
                                } //Condicion que indica si hay un espacio vacio en una posicion izquierda la sustituye la de derecha
                                else if (cuadricula[fila][vecesMovimiento - 1].equals("    ")) {
                                    cuadricula[fila][vecesMovimiento - 1] = cuadricula[fila][vecesMovimiento];
                                    cuadricula[fila][vecesMovimiento] = "    ";
                                }
                            }
                        }
                        break;

                    //Lo mismo establecido pero orientado a la derecha, y en lugar del -1 de los vectores lo pasamos como +1 siguiendo la estructura
                    //de la opcion 's'
                    case 'd':
                        if (cuadricula[fila][3 - columna].equals("    ") == false) {
                            for (int vecesMovimiento = 3 - columna; vecesMovimiento < 3; vecesMovimiento++) {
                                if (cuadricula[fila][vecesMovimiento].equals(cuadricula[fila][vecesMovimiento + 1])) {
                                    numeroA = Integer.parseInt(cuadricula[fila][vecesMovimiento].replaceAll(" ", ""));
                                    numeroA += numeroA;
                                    cuadricula[fila][vecesMovimiento + 1] = Integer.toString(numeroA);
                                    espacios = 4 - cuadricula[fila][vecesMovimiento + 1].length();
                                    for (int barras = espacios; barras > 0; barras--) {
                                        cuadricula[fila][vecesMovimiento + 1] += " ";
                                    }
                                    cuadricula[fila][vecesMovimiento] = "    ";
                                } else if (cuadricula[fila][vecesMovimiento + 1].equals("    ")) {
                                    cuadricula[fila][vecesMovimiento + 1] = cuadricula[fila][vecesMovimiento];
                                    cuadricula[fila][vecesMovimiento] = "    ";
                                }
                            }
                        }
                        break;

                }

            }
        }
        return cuadricula;
    }

    public static void target() {
        /* Usaremos la variable booleana decisionNumeroParticipantes tanto para identificar el numero de jugadores como para saber
      cuando termina el juego

      El arreglo String nombresParticipantesTarget lo usaremos para mostrar los resultados ademas de que seran guardados
      inmediatamente en la lista de jugadores general del programa, al igual que el arreglo int punteosParticipantesTarget

      El objeto aleatorio lo usaremos como nuestra variable para seleccionar las probabilidades de los tiros de los jugadores

      La variable cantidadParticipantesTarget la usaremos para saber la cantidad de participantes del juego ademas de nuestro
      limite para nuestros ciclos for

      La variable decisionTiro es la que escoge que tiro escogera el jugador
         */
        Scanner escaner = new Scanner(System.in);
        Random aleatorio = new Random();
        int cantidadParticipantesTarget;
        int decisionTiro;
        int probabilidadesTiro;
        int[] punteosParticipantesTarget = new int[4];
        String[] nombresParticipantesTarget = new String[4];
        boolean decisionNumeroParticipantes;

        do {
            System.out.println("Bienvenido al juego de Target");
            System.out.println("El juego consiste en tiros hacia un tablero de 5 zonas");
            System.out.println("Zonas: 0,10,20,30,40 puntos respectivamente");
            System.out.println("El juego se basa en probabilidades y la descripciones del tiro");
            System.out.println("Puedes elegir el tipo que creas mas conveniente para ganar");
            System.out.println("Gana el primero a llegar a 200 puntos, y si ambos llegan al mismo tiempo ambos ganan");
            System.out.println("Intenta jugarlo");
            System.out.println("      xxxxxxxxxxxxxxx ");
            System.out.println("     x               x ");
            System.out.println("    xx xxxxxxxxxxxxx xx ");
            System.out.println("   xxx x           x xxx ");
            System.out.println("  xxxx x xxxxxxxxx x xxxx ");
            System.out.println(" xxxxx x x       x x xxxxx ");
            System.out.println(" xxxxx x x   x   x x xxxxx ");
            System.out.println(" xxxxx x x       x x xxxxx ");
            System.out.println("  xxxx x xxxxxxxxx x xxxx ");
            System.out.println("   xxx x           x xxx ");
            System.out.println("    xx xxxxxxxxxxxxx xx ");
            System.out.println("     x               x ");
            System.out.println("      xxxxxxxxxxxxxxx ");
            System.out.println("Cuantos jugadores participaran? (minimo 1 persona, maximo 4 personas)");
            cantidadParticipantesTarget = Integer.parseInt(escaner.nextLine());

            //Ciclo y condicion que nos permite saber si la cantidad de jugadores estan establecidas en el limite
            if ((cantidadParticipantesTarget > 0) && (cantidadParticipantesTarget < 5)) {
                decisionNumeroParticipantes = true;
            } else {
                System.out.println("Parece que has salido del rango de participantes admitidos, vuelve a ingresar");
                decisionNumeroParticipantes = false;
            }

        } while (decisionNumeroParticipantes == false);

        System.out.println("\n\n\n\n");
        //ingresamos los nombres y los asignamos a nuestra variable global, depende de cuantos jugadores esten jugando esa sera su magnitud
        for (int contador = 0; contador < cantidadParticipantesTarget; contador++) {
            System.out.println("Ingrese el Nombre del Jugador No.-" + (contador + 1));
            nombresParticipantesTarget[contador] = asignarNombres();
        }
        System.out.println("\n\n\n\n");

        decisionNumeroParticipantes = true;

//Ciclo que empieza el juego en General, no terminara hasta que decisionNumeroParticipantes = false
        while (decisionNumeroParticipantes == true) {

            //Este for nos indica los turnos de los participantes, con magnitud de cantidadParticipantesTarget que son los participantes establecidos
            for (int turno = 0; turno < cantidadParticipantesTarget; turno++) {
                System.out.println("\n\nTURNO DE " + nombresParticipantesTarget[turno]);
                System.out.println("Tipo de Tiro                     Descripcion                       Resultado del Tiro");
                System.out.println("(Ingresa el valor mostrado)                                                           \n");
                System.out.println("    1                            Rapido con el dardo arriba          Al centro o fallo completo");
                System.out.println("                                 del brazo                                                      ");
                System.out.println("    2                            Controlado con el dardo arriba      En zonas de 10,20 o 30 puntos");
                System.out.println("                                 del brazo");
                System.out.println("    3                            Con el dardo bajo el brazo           En cualquier zona incluyendo fallo completo");
                decisionTiro = Integer.parseInt(escaner.nextLine());

                //decision del tipo de tiro segun la descripcion
                //para decidir estos tiros utilizamos la variable probabilidadesTiro para determinar el destino del tiro y lo asignamos segun cada caso
                switch (decisionTiro) {

                    case 1:
                        System.out.println(nombresParticipantesTarget[turno] + " ha usado tipo de tiro 1");
                        probabilidadesTiro = aleatorio.nextInt(2) + 1;
                        if (probabilidadesTiro == 1) {
                            System.out.println("FUE TIRO AL CENTRO, PERFECTO!");
                            System.out.println("Obtienes 40 puntos");
                            punteosParticipantesTarget[turno] += 40;
                        } else {
                            System.out.println("OH NO!, HAS FALLADO POR COMPLETO EL TIRO");
                            System.out.println("Obtienes 0 puntos");
                        }

                        break;

                    case 2:
                        probabilidadesTiro = aleatorio.nextInt(3) + 1;
                        System.out.println(nombresParticipantesTarget[turno] + " ha usado tipo de tiro 2");

                        switch (probabilidadesTiro) {
                            case 1:
                                System.out.println("HAS ACERTADO EN LA ZONA DE 10 PUNTOS, BIEN HECHO!");
                                punteosParticipantesTarget[turno] += 10;
                                break;

                            case 2:
                                System.out.println("HAS ACERTADO EN LA ZONA DE 20 PUNTOS, MUY BIEN HECHO!");
                                punteosParticipantesTarget[turno] += 20;
                                break;

                            default:
                                System.out.println("HAS ACERTADO EN LA ZONA DE 30 PUNTOS, GENIAL!");
                                punteosParticipantesTarget[turno] += 30;
                        }
                        break;

                    default:
                        System.out.println(nombresParticipantesTarget[turno] + " ha usado tipo de tiro 3");
                        probabilidadesTiro = aleatorio.nextInt(5) + 1;

                        switch (probabilidadesTiro) {
                            case 1:
                                System.out.println("FUE TIRO AL CENTRO, PERFECTO!");
                                System.out.println("Obtienes 40 puntos");
                                punteosParticipantesTarget[turno] += 40;
                                break;

                            case 2:
                                System.out.println("HAS ACERTADO EN LA ZONA DE 30 PUNTOS, GENIAL!");
                                punteosParticipantesTarget[turno] += 30;
                                break;

                            case 3:
                                System.out.println("HAS ACERTADO EN LA ZONA DE 20 PUNTOS, MUY BIEN HECHO!");
                                punteosParticipantesTarget[turno] += 20;
                                break;

                            case 4:
                                System.out.println("HAS ACERTADO EN LA ZONA DE 10 PUNTOS, BIEN HECHO!");
                                punteosParticipantesTarget[turno] += 10;
                                break;

                            default:
                                System.out.println("OH NO!, HAS FALLADO POR COMPLETO EL TIRO");
                                System.out.println("Obtienes 0 puntos");
                        }
                }
            }

//Despues de cada turno mostramos la tabla de jugadores, el punteo que llevan , y su estado es decir si han ganado o no
            System.out.println("\n\n");
            System.out.println("  Jugador       Punteo     Estado");
            for (int contador = 0; contador < cantidadParticipantesTarget; contador++) {
                System.out.print(nombresParticipantesTarget[contador] + "        " + punteosParticipantesTarget[contador]);

                if (punteosParticipantesTarget[contador] >= 200) {
                    System.out.println("  HA GANADO");
                    decisionNumeroParticipantes = false;
                    asignarPunteo(1, nombresParticipantesTarget[contador]);
                } else {
                    System.out.println("  NO HA GANADO");
                }

            }
            escaner.nextLine();

        }

        System.out.println("FIN DEL JUEGO");

    }

    public static int sopaLetras() {
        Scanner escaner = new Scanner(System.in);
        boolean decision = true;
        String palabra;
        String intento;
        String nombre;
        int oportunidades = 3;
        //Usamos estos vectores char para poder usar nuestra funcion mayusculas y nos lo devuelva con caracteres en mayuscula
        //guardanumero sera la magnitud de la palabra y es tomada como referencia para ver si ya se ha repetido ese numero a la hora de revolver las letras
        char[] palabraSeparada;
        char[] palabraUsuario;
        int[] guardaNumero;

        nombre = asignarNombres();
        System.out.println("");
        System.out.println("Bienvenido " + nombre + " al juego de Sopa de letras");
        System.out.println("Ingrese una palabra para iniciar el juego");
        palabra = escaner.nextLine();
        palabraSeparada = palabra.toCharArray();
        guardaNumero = new int[palabra.length()];

        //Convertimos la palabra ingresada a mayusculas
        palabraSeparada = mayusculas(palabraSeparada);
        System.out.println(" ");

        while (oportunidades > 0) {
            //Limpiamos la pantalla y le damos informacion al usuario de cuantos intentos le quedas, se vuelve a cambiar el orden de las palabras
            limpiarPantalla(oportunidades, decision, palabra.length(), guardaNumero, palabraSeparada);

            intento = escaner.nextLine();
            palabraUsuario = intento.toCharArray();
            palabraUsuario = mayusculas(palabraUsuario);

            for (int index = 0; index < palabra.length(); index++) {
                if (palabraSeparada[index] != palabraUsuario[index]) {
                    decision = false;
                    break;
                } else {
                    decision = true;
                }

            }

            if (decision == true) {
                System.out.println("GENIAL " + nombre + " HAS GANADO");
                asignarPunteo(1, nombre);
                return 1;
            } else {
                oportunidades--;
            }
        }

        System.out.println(nombre + " HAS PERDIDO" + "\nLa palabra era: " + palabra);
        asignarPunteo(0, nombre);
        return 0;

    }

    public static void limpiarPantalla(int oportunidades, boolean decision, int size, int[] guardaNumero, char[] palabraSeparada) {
        Random aleatorio = new Random();
        boolean reyNeron = true;
        int comprobador;

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        if (decision == false) {
            System.out.println("No acertaste la palabra vuelve a intentar");
        }

        System.out.println("Trata de adivinar, escribe la palabra que creas que sea");
        System.out.println("tienes " + oportunidades + " oportunidades");

        // Ciclo que reparte las palabras de forma aleatoria
        for (int contador = 0; contador < size; contador++) {
            //utilizamos comprobador que tomara n numeros del tamano de la palabra ingresada y se guardara en guardaNumero para que no se
            //repita el mismo numero a la hora de colocar el numero en el arreglo
            comprobador = aleatorio.nextInt(size) + 1;

            //Parte del ciclo que comprueba que no haya repitentes
            if (contador > 0) {
                for (int contadors = 0; contadors < contador; contadors++) {
                    if (guardaNumero[contadors] != comprobador - 1) {
                        reyNeron = true;
                    } else {
                        reyNeron = false;
                        break;
                    }
                }
            }

            if (reyNeron == false) {
                contador--;
            } else {
                guardaNumero[contador] = comprobador - 1;
                System.out.print(palabraSeparada[guardaNumero[contador]] + "  ");
            }
        }
    }

    public static char[] mayusculas(char[] palabraSeparada) {
        // lo pasamos a codigo ascci y comprobamos que si es mayor a 90 le restamos 32 para que se vuelvan mayusculas
        for (int index = 0; index < palabraSeparada.length; index++) {
            if (palabraSeparada[index] > 90) {
                palabraSeparada[index] -= 32;
            }
        }

        return palabraSeparada;

    }

    public static int repetirJuego(int juegoDecision) {
        //Segun juegoDecision nos hara saber que juego andamos repitiendo, pero como todo depende de que valor retorne
        // y es tomado en cuenta por las condiciones del menu junto con la variable continuacionCilo
        Scanner escanerDecision = new Scanner(System.in);
        String juego = "";
        int opcionUsuario = 0;
        switch (juegoDecision) {

            case 1:
                juego = "Sopa de letras";
                break;

            case 2:
                juego = "Target";
                break;

            case 3:
                juego = "2048";
                break;
        }

        System.out.println("\nIngresa '1': Si Quieres volver a jugar " + juego);
        System.out.println("Ingresa '2': Si Quieres cambiar de juego ");
        System.out.println("Ingresa '3': Si Deseas Salir");
        opcionUsuario = Integer.parseInt(escanerDecision.nextLine());

//Retornamos para cada caso que establecimos en el menu, el 1 para volver a llamar la funcion del juego pero evitando que se abra una funcion adentro de otra
//2 como no hace nada es un predeterminado para que el menu se vuelva a mostrar
//3 que en el procedimiento menu significa que ha acabado la condicion del cilo y acaba el programa
        switch (opcionUsuario) {
            case 1:
                return 1;

            case 2:
                return 2;

            case 3:
                return 3;

            default:
                return 0;
        }

    }

    public static String asignarNombres() {
        //nombrePrevioArreglo lo usaremos para determinar si el nombre ingresado por el usuario ya se encuentra en el sistema
        //contador que sera del tamano del arreglo nombres
        // nombreEncontrado para verificar si hallo el nombre y tomar acciones como agrandar los arreglos o no
        Scanner escaner = new Scanner(System.in);
        String nombrePrevioArreglo;
        int contador;
        boolean nombreEncontrado = true;

        System.out.println("Bienvenido Jugador");
        System.out.println("Escribe tu nombre: \n");
        nombrePrevioArreglo = escaner.nextLine();
        //Volvemos a construir el string que adoptara los valores del mismo pero en mayusculas
        nombrePrevioArreglo = new String((mayusculas(nombrePrevioArreglo.toCharArray())));

        //Empezamos desde una condicion de inicio 1 para agrandar los nombres y asignarle el nombre a la posicion 0 como al punteo
        if (nombres.length == 1) {
            nombres = new String[nombres.length + 1];
            punteos = new int[nombres.length + 1];
            nombres[0] = nombrePrevioArreglo;
            punteos[0] = 0;

        } else {
            //ciclo que trata de encontrar el nombre en el arreglo nombre
            for (contador = 0; contador < nombres.length; contador++) {
                if (nombrePrevioArreglo.equals(nombres[contador])) {
                    nombreEncontrado = true;
                    break;
                }
                nombreEncontrado = false;
            }
            /*Al no encontrar el nombre creamos dos arreglos mas (nombresAuxiliar y punteosAuxiliar) que serviran de almacenamiento tenporal mientras
            volvemos a crear el nuevo arreglo de los nombres les volvemos a colocar los datos que poseian mas el nombre nuevo
             */
            if (nombreEncontrado == false) {
                String[] nombresAuxiliar = new String[nombres.length];
                int[] punteosAuxiliar = new int[nombres.length];
                punteosAuxiliar = punteos;
                nombresAuxiliar = nombres;
                nombres = new String[nombres.length + 1];
                punteos = new int[nombres.length + 1];
                for (contador = 0; contador < nombresAuxiliar.length; contador++) {
                    nombres[contador] = nombresAuxiliar[contador];
                    punteos[contador] = punteosAuxiliar[contador];
                }
                punteos[nombres.length - 2] = 0;
                nombres[nombres.length - 2] = nombrePrevioArreglo;
            }
        }
        //Regresa el nombre ya registrado
        return nombrePrevioArreglo;

    }

    public static void asignarPunteo(int puntos, String nombreJugador) {

        //Al coincidir el nombre le suma puntos, ademas del parametro de la variable puntos si es 1 se le sumara de lo contrario no le sumara puntos
        for (int sizeNombres = 0; sizeNombres < nombres.length - 1; sizeNombres++) {
            if ((nombreJugador.equals(nombres[sizeNombres])) && (puntos == 1)) {
                punteos[sizeNombres] += 1;
                break;
            }

        }

    }
}
