package com.practicando;

import static com.practicando.Asignar_Tareas.scanner;

/**
 *
 * @author Luis
 */
public class Todos_Iguales_diferentes {

    public static void main(String[] args) {
        int longitud;
        int[] listaEnteros;
        System.out.print("LONGITUD DE ARREGLO: ");
        longitud = scanner.nextInt();

        listaEnteros = new int[longitud];
        for (int i = 0; i < listaEnteros.length; i++) {
            System.out.print("Inrese elemento del arreglo ");
            listaEnteros[i] = scanner.nextInt();
        }
        todosIguales(listaEnteros);

    }

    public static void todosIguales(int[] listaEnteros) {

        for (int i = 0; i < listaEnteros.length; i++) {
            
        }
    }

    public static void todosDistintos() {
    }
}

class listas {

}
