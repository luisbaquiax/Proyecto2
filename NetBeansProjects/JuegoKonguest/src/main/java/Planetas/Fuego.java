package Planetas;

import Guerreros.Magma;
import Guerreros.Mole;

/**
 *
 * @author luis
 */
public final class Fuego extends Planeta {

    private Magma[] magmas;
    private final int DINERO_MAXIMO_FUEGO = 140;
    private final int DINERO_MINIMO_FUEGO = 70;
    private final int CANTIDAD_GUERREOS_MAXIMO_FUEGO = 20;
    private final int CANTIDAD_GUERREOS_MINIMO_FUEGO = 10;
    private final int PORCENTAJE = 15;

    public Fuego() {
        super();
        this.cantidadDeGuerrero = super.producirCantidadGuerreros(this.CANTIDAD_GUERREOS_MAXIMO_FUEGO, this.CANTIDAD_GUERREOS_MINIMO_FUEGO);
        this.magmas = new Magma[this.cantidadDeGuerrero];
        for (int i = 0; i < this.magmas.length; i++) {//produce los guerreros de tipo mole
            this.magmas[i] = new Magma();
        }
        this.cantidadDinero = super.generarDinero(DINERO_MAXIMO_FUEGO, DINERO_MINIMO_FUEGO);
        this.porcentajeDistribucion = PORCENTAJE;
    }
    /**
     * Retorna guerreros Magma del planeta Fuego
     * @return 
     */
    public Magma[] getMagmas() {
        return magmas;
    }
}
