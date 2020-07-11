package Mapa_Otros;

import Planetas.*;

/**
 *
 * @author Luis
 */
public class Mapa {

    private int cantidadFilas;
    private int cantidadColumnas;
    private Planeta[][] planetasNeutrales;
    private int cantidadPlanetas;
    private Jugador dueño;
    private String[] nombreJugador;

    private Planeta planeta;

    private Agua agua;
    private Tierra tierra;
    private Orgánico organico;
    private Radioactivo radioctivo;
    private Fuego fuego;

    public Mapa(int filas, int columnas, int cantidadPlanetas) {
        this.cantidadFilas = filas;
        this.cantidadColumnas = columnas;
        this.cantidadPlanetas = cantidadPlanetas;
    }

    public Planeta[][] crearPlanetas() {
        for (int i = 0; i < planetasNeutrales.length; i++) {
            for (int j = 0; j < 10; j++) {
                if (tierra.probaDeAparecer()) {
                    planetasNeutrales[i][i] = new Tierra();
                } else if (agua.probaDeAparecer()) {
                    planetasNeutrales[i][i] = new Agua();
                } else if (fuego.probaDeAparecer()) {
                    planetasNeutrales[i][i] = new Fuego();
                } else if (fuego.probaDeAparecer()) {
                    planetasNeutrales[i][i] = new Fuego();
                } else if (organico.probaDeAparecer()) {
                    planetasNeutrales[i][i] = new Orgánico();
                } else if (radioctivo.probaDeAparecer()) {
                    planetasNeutrales[i][i] = new Radioactivo();
                }
            }
        }
        return this.planetasNeutrales;
    }

    public void establecerFila(int fila) {
        this.cantidadFilas = fila;
    }

    public int obtenerFila() {
        return this.cantidadFilas;
    }

    public void establecerColumna(int columna) {
        this.cantidadColumnas = columna;
    }

    public int obtenerColumana() {
        return this.cantidadColumnas;
    }

    public Planeta[][] planetasNeutrales() {
        return this.planetasNeutrales;
    }

    public void establecerCantidadPlanetas(int cantidadPlanetas) {
        this.cantidadPlanetas = cantidadPlanetas;
    }

    public int getCantidadPlanetas() {
        return this.cantidadPlanetas;
    }

}
