package Naves;

import Guerreros.Guerrero;

/**
 *
 * @author luis
 */
public final class Naboo_N1 extends Nave {

    public Naboo_N1() {
        this.ESPACIOS = 25;
        this.guerreros = new Guerrero[ESPACIOS];
        this.CosteDeProduccion = 40; //el dinero es de tipo Galactus
        this.velocidad = 1;
    }
}
