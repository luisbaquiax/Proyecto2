package com.proyecto2.Casillas;

import com.proyecto2.Entidad.Jugador;

/**
 *
 * @author Luis
 */
public class PropiedadEstacion extends CasillaPropiedad {

    private int costoDeUsoEstacion;

    public PropiedadEstacion(String nombre, Jugador jugador, int precioCompra, int precioHipoteca,
            int costoDeUsoEstacion) {
        super(nombre, jugador, precioCompra, precioHipoteca);
        this.costoDeUsoEstacion = costoDeUsoEstacion;
    }

    public int getCostoDeUsoEstacion() {
        return costoDeUsoEstacion;
    }

    public void setCostoDeUsoEstacion(int costoDeUsoEstacion) {
        this.costoDeUsoEstacion = costoDeUsoEstacion;
    }
    
}
