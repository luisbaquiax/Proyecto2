package Naves;

import Guerreros.Guerrero;

/**
 *
 * @author luis
 */
public final class Star_Destroyer extends Nave {
    
    public Star_Destroyer() {
        this.guerreros = new Guerrero[80];
        this.CosteDeProduccion = 100; //el dinero es de tipo Galactus
        this.velocidad = 1.75;
    }
}
