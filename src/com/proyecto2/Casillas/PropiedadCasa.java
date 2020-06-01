package com.proyecto2.Casillas;

import com.proyecto2.Entidad.Jugador;

/**
 *
 * @author Luis
 */
public class PropiedadCasa extends PropiedadLugar {

    public PropiedadCasa(String nombre, Jugador jugadorDueño, int precioCompra, int precioHipoteca,
            int cantidad, int costo, int precioCasa) {
        super(nombre, jugadorDueño, precioCompra, precioHipoteca, cantidad, costo, precioCasa);
    }
}
