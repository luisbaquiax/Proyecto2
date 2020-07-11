package main.JUEGO.KONQUEST;

import Guerreros.*;
import Planetas.*;
import Constructores.*;
import Mapa_Otros.Diseño_De_Mapa;
import Naves.*;
import Mapa_Otros.Jugador;
import Mapa_Otros.Mapa;
import Mapa_Otros.Tienda;
import java.util.Scanner;

public class InicioJuego {

    static Scanner scanner = new Scanner(System.in);
    private static Jugador[] jugadores = new Jugador[2];
    private static Diseño_De_Mapa nuevoDiseño = new Diseño_De_Mapa();

    public static void main(String[] args) {

        int opcion = 0;
        System.out.println("                      [KONQUEST]\n");
        pedirDatosJugadores();
        while (!(opcion == 1 || opcion == 2)) {
            System.out.println("                     Comenzar juego\n                     [1] SI  [2] NO\n");
            opcion = scanner.nextInt();
            if (opcion == 1 || opcion == 2) {
                break;
            }
        }
        switch (opcion) {
            case 1:
                menu();
                break;
            case 2:
                System.exit(0);
            default:
                break;
        }

    }

    public static void menu() {

        int opcion2 = 0;
        while (!(opcion2 == 1 || opcion2 == 2 || opcion2 == 3)) {
            System.out.println("[1] Diseño de mapa\n[2] Cambiar atributos del mapa\n[4] SALIR");
            opcion2 = scanner.nextInt();
            switch (opcion2) {

                case 1:
                    //llamar metodo diseñar mapa
                    int cantidadMapas;
                    System.out.println("¿Cuàntas crearán?");
                    cantidadMapas = scanner.nextInt();

                    nuevoDiseño.crearMapa(cantidadMapas);

                    break;

                case 2:
                    //cambiar atribuos del mapa
                    nuevoDiseño.cambiarAtributosDelMapa();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Elige opción correcta.");
                    break;
            }

        }
    }

    public static void pedirDatosJugadores() {
        String nombre;
        for (int i = 0; i < jugadores.length; i++) {

            System.out.println("Nombre jugador " + (i + 1) + ": ");
            nombre = scanner.next();
            jugadores[i] = new Jugador(nombre);
        }
    }

}
