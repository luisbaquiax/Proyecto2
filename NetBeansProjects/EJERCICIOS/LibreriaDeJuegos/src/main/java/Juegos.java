
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class Juegos {

    public static final int PUNTEO_CENTRO = 40;
    public static final int PUNTEO_10 = 10;
    public static final int PUNTEO_20 = 20;
    public static final int PUNTEO_30 = 30;
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Bienvenido y disfrute de los juegos");
        int numeroDeJuego = 0;
        while (numeroDeJuego != 4) {//Menú del juego

            if (numeroDeJuego == 0) {
                System.out.println("Seleccione el juego que quiere realizar: \n1. SOPA DE LETRAS \n2. TARGEET "
                        + "\n3. Juego: 2048 \n4. SALIR DEL JUEGO");
                numeroDeJuego = leer.nextInt();
            }

            switch (numeroDeJuego) {
                case 1:
                    System.out.println("*******************(SOPA DE LETRAS)***********************");
                    //llamar a sopa de letras
                    jugarSopaDeLetras();
                    break;
                case 2:
                    System.out.println("***********************(TARGET)***************************");
                    //llamar al juego de target
                    jugarElTarget();
                    break;
                case 3:
                    System.out.println("*******************(El juego 2048)************************");
                    //llamar all juego 2048
                    jugar2048();
                    break;
                case 4:
                    System.out.println("Has salido del juego.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("INGRESE UN NÚMERO VÀLIDO!!!");

            }//Menú que aparece después de terminar un juego
            int alFinalDelJuego = 0;
            System.out.println("¿Desea jugar nuevamente? \n1. Sí \n2. Seleccionar otro juego \n3. Salir");
            alFinalDelJuego = leer.nextInt();
            switch (alFinalDelJuego) {
                case 1:
                    System.out.println("\n");
                    //numeroDeJuego = 0;
                    break;
                case 2:
                    System.out.println("\n");
                    numeroDeJuego = 0;
                    break;
                case 3:
                    numeroDeJuego = 4;
                    System.out.println("Has salido del juego.");
                    break;
                default:
                    System.out.println("Seleccione una opción válida");
            }

        }
    }
//Ulizaré métodos para cada juego
//Métodos para el juego de SOPA DE LETRAS

    public static void jugarSopaDeLetras() {

        String nombreJugador = " ";
        String nombreAdivinador = " ";
        String palabraIngresada = " ";
        String palabraABuscar = " ";
        int intentos = 1;
        final int oportunidad = 3;
        int aleatoria;//La utilizé para generar un número aleatorio de la logitud de la palabra ingresada

        System.out.println("Por favor ingrese tu nombre (jugador que escribirá la palabra a adivinar): ");
        nombreJugador = leer.next();
        System.out.println("¿Cúal es tu nombre (jugador que adivinará la palabra)?");
        nombreAdivinador = leer.next();
        System.out.println("\n" + nombreJugador + ", Ingrese la palabra que se colocará en la sopa de letras");
        palabraIngresada = leer.next();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        do {//Con este bucle empezará el juego hasta cuando las oportunidades sean 0
            System.out.println("\n" + nombreAdivinador + ", tu No. intentos: " + intentos + "/3 oportunidades");

            String palabraAleatoria = "";//Variable donde se colocarán las letras generads en la posición según el random
            String palabraIngresada1 = palabraIngresada;//Variable auxiliar para generar la palabra mezclada
            for (int i = palabraIngresada.length(); i >= 2; i--) {//Con este ciclo generarè la palabra con las letras mezcladas
                aleatoria = (int) (Math.random() * i + 1);
                palabraAleatoria = palabraAleatoria + palabraIngresada1.substring(aleatoria - 1, aleatoria);//De forma aleatoria coloca una letra de la palabra ingresada
                palabraIngresada1 = palabraIngresada1.substring(0, aleatoria - 1) + palabraIngresada1.substring(aleatoria, i);//Pone las letras sin que se repitan
            }
            System.out.println(palabraAleatoria + palabraIngresada1);

            System.out.println("\n" + nombreAdivinador + ", ingrese la palabra correcta.");
            palabraABuscar = leer.next();
            if (verificarPalabra(palabraIngresada, palabraABuscar)) {//Verifica si la palabra es correcta
                System.out.println("Has ganado");
                break;
            } else {
                System.out.println("Has fallado");
            }
            if (intentos == 3) {
                System.out.println("Has perdido, la palabra era: " + palabraIngresada);
                break;
            }
            intentos++;
            System.out.println("-------------------------------------------");
        } while (intentos <= oportunidad);

    }

//Método para comprobar que la palabra existe o que es correcta
    public static boolean verificarPalabra(String palabraIngresada, String palabraABuscar) {
        boolean encontrada = false;
        if (palabraIngresada.equalsIgnoreCase(palabraABuscar)) {//Verifica si la palbra ingresada es igual a la palabra a adivinar sin importar mayúsculas o minúsculas
            encontrada = true;
        }
        return encontrada;
    }

//El juego de Target   
    public static void jugarElTarget() {
        System.out.println("jugar Targuet");
        int numeroDeJugadores = 0;
        int tipoDeTiro = 0;
        int punteo1 = 0;
        int punteo2 = 0;
        int punteo3 = 0;
        String[] jugadores;
        int[] punteos;

        System.out.println("¿Cuántos jugadores van a jugar (opción)(No.Jugadores): \n(2)Jugadores \n(3)Jugadores"
                + " \n(4)Jugadores");
        numeroDeJugadores = leer.nextInt();

        int ganador = 0;
        int punteoTotal = 0;
        if ((numeroDeJugadores == 2) || (numeroDeJugadores == 4) || (numeroDeJugadores == 3)) {
            jugadores = new String[numeroDeJugadores];
            punteos = new int[numeroDeJugadores];
            for (int i = 0; i < jugadores.length; i++) {
                System.out.println("Ingrese tu nombre, jugador " + (i + 1));
                jugadores[i] = leer.next();
            }
            do {
                for (int i = 0; i < jugadores.length; i++) {
                    System.out.println(jugadores[i] + " escoge el tipo de tiro quie quieres hacer");
                    System.out.println("tiro 1");
                    System.out.println("tiro 2");
                    System.out.println("tiro 3");
                    tipoDeTiro = leer.nextInt();
                    switch (tipoDeTiro) {
                        case 1:
                            punteo1 = generarPunteoDeTiroRapido();
                            System.out.println(punteo1);
                            break;
                        case 2:
                            punteo2 = generarPunteoDeTiroCualquiera();
                            System.out.println(punteo2);
                            break;
                        case 3:
                            punteo3 = generarPunteoDeTiroControlado();
                            System.out.println(punteo3);
                            break;
                        default:
                    }
                    punteoTotal = punteo1 + punteo2 + punteo3;
                    punteos[i] += punteoTotal;
                    System.out.println(jugadores[i] + " Llevas " + punteos[i] + " de puntos acumulados");
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

                    if (punteos[i] >= 200) {
                        System.out.println(jugadores[i] + " has ganado con " + punteos[i]);
                        //ganador = true;
                        break;
                    }
                }
                for (int i = 0; i < punteos.length; i++) {
                    if (punteos[i] >= 200) {
                        ganador = 1;
                    }
                }
            } while (ganador == 0);

            System.out.println(">>>>>>>>>>>>Tabla de Jugadores<<<<<<<<<<<<<<<");
            for (int i = 0; i < numeroDeJugadores; i++) {
                System.out.println("Jugador " + jugadores[i] + ", punteo : " + punteos[i]);
            }

        } else {
            System.out.println("Solo pueden jugar hasta 4 jugadores");
        }

    }

    /**
     * Método para generar punteo del tiro rápido
     */
    public static int generarPunteoDeTiroRapido() {

        int punteoDelTiroRapido = 0;

        int tiroRapido = (int) (Math.random() * 2) + 1;//Me sirve para generar el punteo de tiro al centro o fallo completo
        if (tiroRapido == 1) {
            punteoDelTiroRapido = PUNTEO_CENTRO;
            System.out.println("Has pegado al centro");
            System.out.println("Has ganado: 40pts");
        } else if (tiroRapido == 2) {
            System.out.println("Has fallado el tiro!");
            System.out.println("Has ganado 0 pts");
        }
        return punteoDelTiroRapido;
    }

    /**
     * Mégod para generar el punteo del tiro contralado
     */
    public static int generarPunteoDeTiroControlado() {

        int tiroControlado = 0;
        int punteoDeTiroControlado = 0;

        tiroControlado = (int) (Math.random() * 3) + 1;
//Este random sirve para generar del 1 al 3 del tipo de tiro de 10, 20 y 30 pts respectivamente
        switch (tiroControlado) {
            case 1:
                punteoDeTiroControlado = PUNTEO_10;
                System.out.println("Has ganado: 10pts");
                break;
            case 2:
                punteoDeTiroControlado = PUNTEO_20;
                System.out.println("Has ganado: 20pts");
                break;
            default:
                punteoDeTiroControlado = PUNTEO_30;
                System.out.println("Has ganado: 30pts");
                break;
        }
        return punteoDeTiroControlado;

    }
//Método para generar el punteo del tiro en cualquier dirección

    public static int generarPunteoDeTiroCualquiera() {

        int tiroCualquiera = 0;
        int punteoDeTiroCualquiera = 0;

        tiroCualquiera = (int) (Math.random() * 5) + 1;//Con este random genero numeros del 1 a 5 (tiro al centro, fallo completo y de 10, 20, 30, pts respectivamente
        switch (tiroCualquiera) {
            case 1:
                punteoDeTiroCualquiera = PUNTEO_CENTRO;
                System.out.println("Has pegado al centro!" + " Has ganado: " + PUNTEO_CENTRO);
                break;
            case 2:
                System.out.println("Has fallado el tiro, has ganado 0 pts");
                break;
            case 3:
                System.out.println("Has ganado 10pts");
                punteoDeTiroCualquiera = PUNTEO_10;
                break;
            case 4:
                System.out.println("Has ganado 20pts");
                punteoDeTiroCualquiera = PUNTEO_20;
                break;
            default:
                System.out.println("Has ganado 30pts");
                punteoDeTiroCualquiera = PUNTEO_30;
                break;
        }
        return punteoDeTiroCualquiera;
    }

    /**
     * El juego 2048
     */
    public static void jugar2048() {

    }
}
