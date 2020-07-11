package Naves;

import Guerreros.*;

/**
 *
 * @author luis
 */
public class Nave {

    protected Guerrero[] guerreros;
    protected double velocidad;//en años de luz
    protected int CosteDeProduccion;
    protected boolean trasportar;
    protected int ESPACIOS;

    public Nave() {
    }

    public Guerrero[] getGuerreros() {
        return guerreros;
    }

    public void setGuerreros(Guerrero[] guerreros) {
        this.guerreros = guerreros;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public int getCosteDeProduccion() {
        return CosteDeProduccion;
    }

//    public boolean isTrasportar() {
//        return trasportar;
//    }

}
