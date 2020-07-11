/**
 *
 * @author luis
 */
public class Juego {
    Casilla[][] tablero;

    public Juego(){
        tablero = new Casilla[8][8];
        iniciarTablero();

    }


    public void jugar(){
        pintaTablero();



    }


    public void iniciarTablero(){
        boolean blanco = true;

        for (int i = 0; i<8; i++){
            for (int j = 0; j<8; j++){

                blanco = !blanco;

                if (blanco)
                    tablero[i][j] = new CasillaBlanca();
                else
                    tablero[i][j] = new CasillaNegra();
            }
            blanco = !blanco;
        }
    }

    public void pintaTablero(){
        String linea1 = "";
        String linea2 = "";
        String linea3 = "";
        String linea4 = "";

        for (int i = 0; i<8; i++){
            for (int j=0;j<8;j++){
                linea1 = linea1 + tablero[i][j].getLine1();
                linea2 += tablero[i][j].getLine2();
                linea3 += tablero[i][j].getLine3();
                if (j==7)
                    linea2+="  "+i;
                if (i==7)
                    linea4+="   "+j+"  ";
            }
            System.out.println(linea1);
            System.out.println(linea2);
            System.out.println(linea3);
            linea1 = "";
            linea2 = "";
            linea3 = "";
        }
        System.out.println(linea4);


    }



}