package Mapa_Otros;

import Planetas.*;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class Diseño_De_Mapa {

    private static Scanner scanner = new Scanner(System.in);
    private Planeta[][] planeta;
    private Mapa[] mapas;
    
  
    public Mapa[] crearMapa(int cantidadMapas) {
        int filas, columnas, cantidadPlanetas = 0;
        mapas = new Mapa[cantidadMapas];
        for (int i = 0; i < mapas.length; i++) {

            System.out.println("**********Mapa " + (i + 1) + "**********");
            System.out.println("¿Cuántas filas tendrá el mapa?");
            filas = Integer.parseInt(scanner.nextLine());
            System.out.println("¿Cuántas columnas tendrá el mapa?");
            columnas = Integer.parseInt(scanner.nextLine());
            System.out.println("¿Cuántos planetas se agregan al mapa? \n(recuerde que la cantidad de planetas depende del producto de las filas y columnas)");
            cantidadPlanetas = Integer.parseInt(scanner.nextLine());
            mapas[i] = new Mapa(filas, columnas, cantidadPlanetas);
//            mapa.crearPlanetas();
//            if (filas * columnas < cantidadPlanetas) {
//                System.out.println("La cantidad de planetas debe ser menor o igual a la cantidad de espacios que habrá en el mapa");
//                diseñarMapa(mapas);
//                break;
//            }
        }
        return mapas;

    }

    public void cambiarAtributosDelMapa() {
        System.out.println("No ha sido terminado");

    }
}
