package Guerreros;

import Planetas.*;

/**
 *
 * @author Luis
 */
public class Guerrero {

    protected boolean vencer;
    protected double factorDeMuerte;
    protected double valorMuerte;
    protected final int ESPACIO_OCUPA;
    protected int espacioEnNave;
    protected String nombreGuerrero;
    protected Planeta planeta;
    protected boolean cabeONoEnNave;

    public Guerrero() {
        this.planeta = new Planeta();
        this.ESPACIO_OCUPA = this.espacioEnNave;
    }

    public String getNombreGuerrero() {
        return nombreGuerrero;
    }

    public int getEspacioOcupa() {
        return espacioEnNave;
    }

    /**
     * Verificamos si muero o vence el guerrero
     *
     * @param valorMuerteEnemigo
     * @return
     */
    public boolean vencerOMorir(double valorMuerteEnemigo) {
        if (calcularValorDeMuerte() > valorMuerteEnemigo) {
            return this.vencer;
        } else {
            return this.vencer = false;
        }
    }

    /**
     * calculamos el valor de muerte del guerrero
     *
     * @return
     */
    public double calcularValorDeMuerte() {
        return this.valorMuerte = this.planeta.getPorcentajeDeMuerte() * this.factorDeMuerte;
    }
}
