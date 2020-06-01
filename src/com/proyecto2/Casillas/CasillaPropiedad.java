package com.proyecto2.Casillas;

import com.proyecto2.Entidad.Jugador;

/**
 *
 * @author Luis
 */
public class CasillaPropiedad {

    protected String nombrePropiedad;
    protected Jugador jugadorDueño;
    protected int precioDeCompra;
    protected int precioHipoteca;
    protected boolean estado;//true = hipotecado, false = no hipotecado

    public CasillaPropiedad(String nombrePropiedad, int precioDeCompra) {
        this.nombrePropiedad = nombrePropiedad;
        this.precioDeCompra = precioDeCompra;
    }
    
   

    /**
     *
     * @param nombre, nombre de la propiedad
     * @param jugador, jugador dueño
     * @param precioCompra, precio de compra
     * @param precioHipoteca, precio de hipoteca
     */
    public CasillaPropiedad(String nombre, Jugador jugador, int precioCompra, int precioHipoteca) {
        this.nombrePropiedad = nombre;
        this.jugadorDueño = jugador;
        this.precioDeCompra = precioCompra;
        this.precioHipoteca = precioHipoteca;
    }

    public String getNombrePropiedad() {
        return nombrePropiedad;
    }

    public void setNombrePropiedad(String nombrePropiedad) {
        this.nombrePropiedad = nombrePropiedad;
    }

    public Jugador getJugadorDueño() {
        return jugadorDueño;
    }

    public void setJugadorDueño(Jugador jugadorDueño) {
        this.jugadorDueño = jugadorDueño;
    }

    public int getPrecioDeCompra() {
        return precioDeCompra;
    }

    public void setPrecioDeCompra(int precioDeCompra) {
        this.precioDeCompra = precioDeCompra;
    }

    public int getPrecioHipoteca() {
        return precioHipoteca;
    }

    public void setPrecioHipoteca(int precioHipoteca) {
        this.precioHipoteca = precioHipoteca;
    }

    /**
     * Devuelve true si la propiedad está hipotecado, o false si ela propiedad
     * no lo está
     *
     * @return
     */
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
