package com.proyecto2.Entidad;

/**
 *
 * @author Luis
 */
public class Jugador {

    private String nombreJugador;
    private int dineroInicial;
    private int dineroGanado;

    /**
     *
     * @param nombreJugador
     * @param dineroInicial
     */
    public Jugador(String nombreJugador, int dineroInicial) {
        this.nombreJugador = nombreJugador;
        this.dineroInicial = dineroInicial;
    }

    /**
     *
     * @param nombreJugador
     */
    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getDineroInicial() {
        return dineroInicial;
    }

    public void setDineroInicial(int dineroInicial) {
        this.dineroInicial = dineroInicial;
    }

    public int getDineroGanado() {
        return dineroGanado;
    }

    /**
     * Dinero que gana el jugador
     *
     * @param dineroGanado
     */
    public void setDineroGanado(int dineroGanado) {
        this.dineroGanado += dineroGanado;
    }

}
