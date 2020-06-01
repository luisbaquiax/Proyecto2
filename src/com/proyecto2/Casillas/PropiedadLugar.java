package com.proyecto2.Casillas;

import com.proyecto2.Entidad.Jugador;

/**
 *
 * @author Luis
 */
public class PropiedadLugar extends CasillaPropiedad {

    protected int cantidad;
    protected int costoEstancia;
    protected int precioLugar;

    public PropiedadLugar(String nombrePropiedad, Jugador jugadorDueño, int precioDeCompra, int precioHipoteca,
            int cantidad, int costoEstancia, int precioLugar) {
        super(nombrePropiedad, jugadorDueño, precioDeCompra, precioHipoteca);
        this.cantidad = cantidad;
        this.costoEstancia = costoEstancia;
        this.precioLugar = precioLugar;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCostoEstancia() {
        return costoEstancia;
    }

    public void setCostoEstancia(int costoEstancia) {
        this.costoEstancia = costoEstancia;
    }

    public int getPrecioLugar() {
        return precioLugar;
    }

    public void setPrecioLugar(int precioLugar) {
        this.precioLugar = precioLugar;
    }

}
