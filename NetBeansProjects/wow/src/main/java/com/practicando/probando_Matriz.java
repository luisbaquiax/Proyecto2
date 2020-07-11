package com.practicando;

/**
 *
 * @author Luis
 */
public class probando_Matriz {

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 1111111;
        int b = 2222222;
        int c = 3333333;
        int d = 8888888;
        
        int aleatoria = (int) (Math.random() * 99 + 1);

        int fila = 3, columna = 3;

        profesor[][] profesor = new profesor[fila][columna];
        for (int i = 0; i < profesor.length; i++) {
            for (int j = 0; j < profesor.length; j++) {
                
                    profesor[i][j] = new profesor();
                

            }
        }

        for (int i = 0; i < 3; i++) {
            //System.out.println("");
            for (int j = 0; j < 3; j++) {
              
                    System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_BLUE + " Nombre " + profesor[i][j].getNombre() + ANSI_WHITE + ANSI_RESET);
                    System.out.print(ANSI_YELLOW_BACKGROUND + ANSI_BLUE + " Edad " + profesor[i][j].getEdad() + ANSI_WHITE + ANSI_RESET);
                    System.out.print("");
                

            }
            System.out.println("");
        }
    }
}

class profesor {

    String nombre;
    int edad;

    public profesor() {
        this.nombre = "luis";
        this.edad = random(12, 2);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int random(int max, int min) {
        int aleatoria = (int) (Math.random() * (max - min) + min);
        return aleatoria;
    }

}
