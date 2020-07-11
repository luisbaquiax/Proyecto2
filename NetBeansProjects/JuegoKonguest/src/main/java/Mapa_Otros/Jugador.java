package Mapa_Otros;

import Constructores.*;
import Guerreros.*;
import Naves.*;
import Planetas.*;

/**
 *
 * @author Luis
 */
public class Jugador {

    private String nombreJugador;
    private int galactusGanado;
    private boolean comprarConstructor;
    private boolean vendidoConstructor;
    Planeta[] planetas;
    Planeta planetaInicial;
    Planeta[] planetasConquistados;
    
    

    public Jugador(String miNombre) {
        this.nombreJugador = miNombre;

    }

    public void setNombre(String nombre) {
        this.nombreJugador = nombre;
    }

    public String getNombre() {
        return this.nombreJugador;
    }

    public void setgalacutsGanando(int galactusGanado) {
        this.galactusGanado = galactusGanado;
    }

    public int obtenerGalactusGanado() {
        return this.galactusGanado;
    }

    public void gastarGalacuts(int galactus) {
        this.galactusGanado -= galactus;
    }

    /**
     * El método sirve para saber si se puede comprar el constructor
     *
     * @param precioCompra
     * @return
     */
    public boolean comprarConsructor(int precioCompra, Constructor constructor) {

        if (this.galactusGanado >= constructor.obtenerPrecioCompra()) {

            return this.comprarConstructor;
        } else {

            return this.comprarConstructor = false;
        }
    }

    public boolean venderConstructor(int precioVenta) {
        return this.vendidoConstructor;
    }

    public Planeta[] obtenerPlanetas() {
        return this.planetas;
    }

    public Planeta[] obtenerPlanetasConquistadas() {
        return this.planetasConquistados;
    }

    public int medirDistancia() {
        return 0;
    }

    public void verPlaneta(Planeta[] planeta) {
    }

    public void consulatarFlota(Planeta[] planetas, Nave[] naves) {
    }

    public void enviarFlota(Nave[] naves, Guerrero[] guerreros) {

    }
}
