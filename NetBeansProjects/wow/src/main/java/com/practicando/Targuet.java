package com.practicando;

import static com.practicando.Asignar_Tareas.scanner;

public class Targuet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int jugadores;
        String[] nombres;
        System.out.println("INGRESE CANTIDAD DE JUGADORES DE 1-4: ");
        jugadores = scanner.nextInt();

        nombres = new String[jugadores];

        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingrese nombre jugador " + (i + 1) + ": ");
            nombres[i] = scanner.next();
        }
        int punteoMaximo = 200;
        int punteoJugador = 0;
        int tiro;
        while (punteoMaximo >= punteoJugador) {
            for (int i = 0; i < jugadores; i++) {
                System.out.print(nombres[i] + " Elige un tiro: \n[1]Tiro al centro\n[2]Tiro con posibles puntoes: 40, 30 20 10\n[3]Tiro fallo total/centro");
                tiro = scanner.nextInt();
                switch (tiro) {
                    case 1:
                        punteoJugador = punteoJugador + 10;
                        break;
                    case 2:
                        punteoJugador = punteoJugador + 20;
                        break;
                    case 3:
                        punteoJugador = punteoJugador + 40;
                        break;
                }
                if(punteoJugador<=punteoMaximo){
                    break;
                }
            }
        }
        System.out.println("punteo alcanzado " + punteoJugador);
    }

}
