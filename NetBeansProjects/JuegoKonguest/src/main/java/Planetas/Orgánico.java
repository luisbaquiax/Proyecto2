package Planetas;

import Guerreros.Groot;

/**
 *
 * @author luis
 */
public final class Orgánico extends Planeta {

    private Groot[] grootes;
    private final int DINERO_MAXIMO_ORGANICO = 160;
    private final int DINERO_MINIMO_ORGANICO = 80;
    private final int CANTIDAD_GUERREOS_MAXIMO_ORGANICO = 15;
    private final int CANTIDAD_GUERREOS_MINIMO_ORGANICO = 5;
    private final int PORCENTAJE = 10;

    public Orgánico() {
        super();

        this.cantidadDeGuerrero = super.producirCantidadGuerreros(this.CANTIDAD_GUERREOS_MAXIMO_ORGANICO, this.CANTIDAD_GUERREOS_MINIMO_ORGANICO);
        this.grootes = new Groot[this.cantidadDeGuerrero];
        for (int i = 0; i < this.grootes.length; i++) {//produce los guerreros de tipo mole
            this.grootes[i] = new Groot();
        }
        this.cantidadDinero = super.generarDinero(DINERO_MAXIMO_ORGANICO, DINERO_MINIMO_ORGANICO);
        this.porcentajeDistribucion = PORCENTAJE;
    }

    /**
     * retorna guerreros groots
     * @return
     */
    public Groot[] getGrootes() {
        return grootes;
    }

}
