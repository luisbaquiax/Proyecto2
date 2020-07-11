package com.mycompany.metodos_de_ordenamiento;

import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class metodos_de_ordenamiento {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int lista[], tamaño;
        System.out.print("Tamaño del arreglo: ");
        tamaño = scanner.nextInt();
        lista = new int[tamaño];
        for (int i = 0; i < lista.length; i++) {
            System.out.print((i + 1) + ". Ingrese elemento del arreglo: ");
            lista[i] = scanner.nextInt();
        }
        metodoBurbuja(lista);
        System.out.println("");
        metodoPorInsercion(lista);
        System.out.println("");
        metodoPorSeleccion(lista);
        System.out.println("");
        metodoQuickSort(lista, lista[0], lista.length - 1);
        
    }

    /**
     * METODO BURBUJA, ordena los elementos por le métodO burbuja
     *
     * @param lista
     */
    public static void metodoBurbuja(int[] lista) {
        int auxiliar;
        for (int i = 0; i < (lista.length - 1); i++) {
            for (int j = 0; j < (lista.length - 1); j++) {
                if (lista[j] > lista[j + 1]) {
                    intercambiarValores(lista, j, j + 1);
//                    auxiliar = lista[j];
//                    lista[j] = lista[j + 1];
//                    lista[j + 1] = auxiliar;
                }
            }
        }
        System.out.println("Ordenado con metodo burbuja: ");
        for (int j = 0; j < lista.length; j++) {
            System.out.println(lista[j] + " ");
        }
    }

    /**
     * ORDENAMIENTO POR INSERCION
     *
     * @param lista
     */
    public static void metodoPorInsercion(int[] lista) {
        int posicion, auxiliar;

        for (int i = 0; i < lista.length; i++) {
            posicion = i;
            auxiliar = lista[i];
            while (posicion > 0 && (lista[posicion - 1] > auxiliar)) {
                lista[posicion] = lista[posicion - 1];
                posicion--;
            }
            lista[posicion] = auxiliar;
        }
        System.out.println("Ordenado por el método de Insercion");
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i] + " ");

        }

    }

    /**
     * METODO POR SELECCIÓN
     *
     * @param lista
     */
    public static void metodoPorSeleccion(int lista[]) {
        int auxiliar, posicionMinima;
        for (int i = 0; i < lista.length - 1; i++) {
            posicionMinima = i;//posicion del numero mas pequeño

            for (int j = i + 1; j < lista.length; j++) {
                if (lista[j] < lista[posicionMinima]) {//se compara el valor actual en j con el valor en la posicionMinima
                    //el valor mas pequeño se encuentra en la posicion nueva (j) en este caso, se hace el cambio de posición
                    posicionMinima = j;
                }
            }
            intercambiarValores(lista, i, posicionMinima);
//            auxiliar = lista[i];
//            lista[i] = lista[posicionMinima];
//            lista[posicionMinima] = auxiliar;
        }
        System.out.println("Ordenado por método por selección: ");
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
    }

    /**
     * METODO DE Quick Sort
     *
     * @param lista
     * @param primeraPosicion
     * @param ultimaPosicion
     */
    public static void metodoQuickSort(int lista[], int primeraPosicion, int ultimaPosicion) {

        int auxiliar; //variable auxiliar con el que aydudará a realizar el cambio
        int i = primeraPosicion;
        int j = ultimaPosicion;
        int pivote = lista[(primeraPosicion + ultimaPosicion) / 2];

        do {
            while (lista[i] < pivote) {
                i++;
            }
            while (lista[j] > pivote) {
                j--;
            }
            //En esta parte haremos el cambio de los valores con la ayuda de la variable auxiliar
            if (i <= j) {
                auxiliar = lista[i];
                lista[i] = lista[j];
                lista[j] = auxiliar;
                i++;
                j--;
            }
        } while (i <= j);

        //aplicamos la recursividad, para ordenar lo que podría faltar
        //en las sublistas, tanto izquierda como derecha
        if (primeraPosicion < j) {
            metodoQuickSort(lista, primeraPosicion, j);
        }
        if (i < ultimaPosicion) {
            metodoQuickSort(lista, i, ultimaPosicion);
        }
        System.out.println("ORDENADO POR EL METODO DE QUICK SORT");
        for (int k = 0; k < lista.length; k++) {
            System.out.println(lista[k]);

        }
    }

    /**
     * Metodo que ayuda a intercambiar de elementos de un arreglo
     *
     * @param lista
     * @param i
     * @param j
     */
    public static void intercambiarValores(int lista[], int i, int j) {
        int auxiliar;
        if (i != j) {
            auxiliar = lista[i];
            lista[i] = lista[j];
            lista[j] = auxiliar;
        }
    }
}
