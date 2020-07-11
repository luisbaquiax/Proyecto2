package Naves;

import Guerreros.Guerrero;

/**
 *
 * @author luis
 */
public final class X_Wing extends Nave {

    public X_Wing() {
        this.guerreros = new Guerrero[42];
        this.CosteDeProduccion = 50; //el dinero es de tipo Galactus
        this.velocidad = 1.25;
    }

}
