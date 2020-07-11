package Planetas;

import Guerreros.Fision_Guy;

/**
 *
 * @author luis
 */
public final class Radioactivo extends Planeta {

    private Fision_Guy[] fisionGuys;
    private final int DINERO_MAXIMO_RADIOACTIVO = 180;
    private final int DINERO_MINIMO_RADIOACTIVO = 90;
    private final int CANTIDAD_GUERREOS_MAXIMO_RADIOACTIVO = 9;
    private final int CANTIDAD_GUERREOS_MINIMO_RADIOACTIVO = 3;
    private final int PORCENTAJE = 5;

    public Radioactivo() {
        super();

        this.cantidadDeGuerrero = super.producirCantidadGuerreros(this.CANTIDAD_GUERREOS_MAXIMO_RADIOACTIVO, this.CANTIDAD_GUERREOS_MINIMO_RADIOACTIVO);
        this.fisionGuys = new Fision_Guy[this.cantidadDeGuerrero];
        for (int i = 0; i < this.fisionGuys.length; i++) {//produce los guerreros de tipo mole
            this.fisionGuys[i] = new Fision_Guy();
        }
        this.cantidadDinero = super.generarDinero(DINERO_MAXIMO_RADIOACTIVO, DINERO_MINIMO_RADIOACTIVO);
        this.porcentajeDistribucion = PORCENTAJE;
    }

    public Fision_Guy[] getFisionGuys() {
        return fisionGuys;
    }

}
