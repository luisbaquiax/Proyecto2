/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guerreros;

/**
 *
 * @author luis
 */
public final class Mole extends Guerrero {

    private boolean enterrar;

    public Mole() {
        this.factorDeMuerte = 1.5;
        this.espacioEnNave = 1;
        this.nombreGuerrero = "MOLE";
    }

    public boolean enterrarVíctima(double valorMuerteEnemigo) {

        if (calcularValorDeMuerte() > valorMuerteEnemigo) {
            return this.enterrar;
        } else {
            return this.enterrar = false;
        }
    }
}
