package com.practicando;

import java.util.Scanner;

/**
 * @author Luis
 */
public class probando {

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        int fila, columna;
//        String cuadro[][];
//        System.out.println("Inserte filas");
//        fila = sc.nextInt();
//        System.out.println("Inserte columnas");
//        columna = sc.nextInt();
//        cuadro = new String[fila][columna];
//        dibujarCuadro(fila, columna, cuadro);
        cuadroArbol cuadro = new cuadroArbol();
        cuadro.creararboles();
        cuadro.mostrar();
    }

//    public static final String ANSI_RESET = "\u001B[0m";
//    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
//
//    public static void dibujarCuadro(int fila, int columna, String[][] cuadro) {
//        persona persona1 = new persona("luis", 23);
//        for (int i = 0; i < fila; i++) {
//            System.out.println("");
//            for (int j = 0; j < columna; j++) {
//
//                cuadro[2][0] = ANSI_YELLOW_BACKGROUND + ANSI_BLUE + persona1.mostrarDatosPersona() + ANSI_WHITE_BACKGROUND + ANSI_RESET;
//                System.out.print("| " + cuadro[i][j] + "  |");
//            }
//        }
//    }
}

class arbol {

    String nombre;
    int altura;

    public arbol(String nombre, int altura) {
        this.nombre = nombre;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void mostrarDatos() {
        System.out.println("nombre " + getNombre() + "\naltuara: " + getAltura());
    }
}

class cuadroArbol {

    arbol[][] arboles = new arbol[2][2];

    public cuadroArbol() {
    }

    public arbol[][] creararboles() {
        arboles[0][0] = new arbol("grande", 25);
        arboles[0][1] = new arbol("pequeño", 15);
        arboles[0][2] = new arbol("grande", 25);
        arboles[0][3] = new arbol("pequeño", 15);
        arboles[1][0] = new arbol("grande", 25);
        arboles[1][1] = new arbol("pequeño", 15);
        arboles[1][2] = new arbol("grande", 25);
        arboles[1][3] = new arbol("pequeño", 15);
        arboles[1][4] = new arbol("pequeño", 15);

        return arboles;
    }

    public void mostrar() {

        for (int i = 0; i < arboles.length; i++) {
            for (int j = 0; j < arboles.length; j++) {
                arboles[i][j].mostrarDatos();          
            }
        }
    }
 
}
