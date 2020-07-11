package Planetas;

import Guerreros.*;

/**
 *
 * @author luis
 */
public final class Agua extends Planeta {

    private Nemo[] nemos;
    //private double probabilidadApararecer;
    private final int DINERO_MAXIMO_AGUA = 120;
    private final int DINERO_MiNIMO_AGUA = 60;
    private final int CANTIDAD_GUERREOS_MAXIMO_AGUA = 23;
    private final int CANTIDAD_GUERREOS_MINIMO_AGUA = 12;
    private final int PORCENTAJE = 25;

    public Agua() {
        super();
        this.cantidadDeGuerrero = super.producirCantidadGuerreros(this.CANTIDAD_GUERREOS_MAXIMO_AGUA, this.CANTIDAD_GUERREOS_MINIMO_AGUA);
        this.nemos = new Nemo[this.cantidadDeGuerrero];
        for (int i = 0; i < this.nemos.length; i++) {//produce los guerreros de tipo nemo
            nemos[i] = new Nemo();
        }
        this.cantidadDinero = super.generarDinero(DINERO_MAXIMO_AGUA, DINERO_MiNIMO_AGUA);
        this.porcentajeDistribucion = PORCENTAJE;
    }

    /**
     * Crea los guerrero Nemo
     * @return
     */
    public Nemo[] crearNemo() {
        /*this.nemos = new Nemo[cantidadDeGuerrero];
        for (int i = 0; i < nemos.length; i++) {
            nemos[i] = new Nemo();
            return nemos;
        }*/
        return nemos;
    }
}
