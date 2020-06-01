package com.proyecto2.Casillas;

import com.proyecto2.Entidad.Jugador;

/**
 *
 * @author Luis
 */
public class PropiedadHoteles extends PropiedadLugar {
    
    public PropiedadHoteles(String nombre, Jugador jugadorDueño, int precioCompra, int precioHipoteca,
            int cantidad, int costoEstancia, int precioHotel) {
        super(nombre, jugadorDueño, precioCompra, precioHipoteca, cantidad, costoEstancia, precioHotel);
    }
}
