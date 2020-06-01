package com.proyecto2.Casillas;

import com.proyecto2.Entidad.Jugador;

/**
 *
 * @author Luis
 */
public class PropiedadServicioBasico extends CasillaPropiedad {

    private int costoDelServicio;
    private String nombreDelServicio;

    public PropiedadServicioBasico(int costoDelServicio, String nombreDelServicio,
            String nombre, Jugador jugador, int precioCompra, int precioHipoteca) {
        super(nombre, jugador, precioCompra, precioHipoteca);
        this.costoDelServicio = costoDelServicio;
        this.nombreDelServicio = nombreDelServicio;
    }

    public int getCostoDelServicio() {
        return costoDelServicio;
    }

    public void setCostoDelServicio(int costoDelServicio) {
        this.costoDelServicio = costoDelServicio;
    }

    public String getNombreDelServicio() {
        return nombreDelServicio;
    }

    public void setNombreDelServicio(String nombreDelServicio) {
        this.nombreDelServicio = nombreDelServicio;
    }
}
