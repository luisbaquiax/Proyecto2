package com.proyecto2.Jugar;

import com.proyecto2.Entidad.Jugador;
import javax.swing.JPanel;

/**
 *
 * @author Luis
 */
public class Juego {

    private Jugador[] jugadoresJugando;
    private int cantidadDados;
    private JPanel panelTablero;
    private int limCasas, limHoteles, interes;
    //
    private int dineroPorVuelta, dineroInicialJugador;
    private String nombreDeJuego;

    /**
     * Con este constructor guardamos algunos de los atributos para el juego
     *
     * @param noDados
     * @param panelTablero
     * @param limCasas
     * @param limHoteles
     * @param interes
     * @param dineroPorVuelta
     * @param dineroInicialJugador
     * @param nombreDeJuego
     */
    public Juego(int noDados, JPanel panelTablero, int limCasas, int limHoteles, int interes,
            int dineroPorVuelta, int dineroInicialJugador, String nombreDeJuego) {

        this.cantidadDados = noDados;
        this.panelTablero = panelTablero;
        this.limCasas = limCasas;
        this.limHoteles = limHoteles;
        this.interes = interes;
        this.dineroPorVuelta = dineroPorVuelta;
        this.dineroInicialJugador = dineroInicialJugador;
        this.nombreDeJuego = nombreDeJuego;
    }

    /**
     * Este cosntructro, lo utilizaremos en agregar jugadores
     *
     * @param jugando
     */
    public Juego(Jugador[] jugando) {
        this.jugadoresJugando = jugando;
    }

    // para poder acceder a unos de sus atributos desde el juego principal
    public Juego() {
    }

    public Jugador[] getJugadoresJugando() {
        return jugadoresJugando;
    }

    public int getCantidadDados() {
        return cantidadDados;
    }

    public JPanel getPanelTablero() {
        return panelTablero;
    }

    public int getLimCasas() {
        return limCasas;
    }

    public int getLimHoteles() {
        return limHoteles;
    }

    public int getInteres() {
        return interes;
    }

    public int getDineroPorVuelta() {
        return dineroPorVuelta;
    }

    public int getDineroInicialJugador() {
        return dineroInicialJugador;
    }

    public String getNombreDeJuego() {
        return nombreDeJuego;
    }

}
