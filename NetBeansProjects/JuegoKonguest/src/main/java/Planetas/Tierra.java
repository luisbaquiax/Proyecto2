package Planetas;

import Guerreros.Mole;

/**
 *
 * @author luis
 */
public final class Tierra extends Planeta {

    private Mole[] moles;
    private final int DINERO_MAXIMO_TIERRA = 100;
    private final int DINERO_MINIMO_TIERRA = 50;
    private final int CANTIDAD_GUERREOS_MAXIMO_TIERRA = 25;
    private final int CANTIDAD_GUERREOS_MINIMO_TIERRA = 1;
    private final int PORCENTAJE = 45;

    public Tierra() {
        super();
        this.cantidadDeGuerrero = super.producirCantidadGuerreros(this.CANTIDAD_GUERREOS_MAXIMO_TIERRA, this.CANTIDAD_GUERREOS_MINIMO_TIERRA);
        this.moles = new Mole[this.cantidadDeGuerrero];
        for (int i = 0; i < this.moles.length; i++) {//produce los guerreros de tipo mole
            moles[i] = new Mole();
        }
        this.cantidadDinero = super.generarDinero(DINERO_MAXIMO_TIERRA, DINERO_MINIMO_TIERRA);
        this.porcentajeDistribucion = PORCENTAJE;
    }

    /**
     *probabilida de que aparezca o no este planeta.
     * @return
     */
    @Override
    public boolean probaDeAparecer() {
        int probailidad = generarNumeroAleatorio(100, 1);

        return probailidad <= porcentajeDistribucion;
    }
    public Mole[] getMoles() {
        return moles;
    }

}
