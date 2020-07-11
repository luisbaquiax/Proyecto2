package Planetas;

import Constructores.*;
import Naves.*;
import Guerreros.*;

/**
 *
 * @author luis
 */
public class Planeta {

    protected String nombrePlaneta;
    protected double porcentajeMuerte;
    protected int cantidadDinero;
    protected Constructor[] constructores;
    protected int cantidadConstructores;
    protected Nave[] naves;
    protected int cantidadDeNaves;
    protected Guerrero guerreros[];
    protected int cantidadDeGuerrero;
    protected int porcentajeDistribucion;

    protected int dineroMáximo;
    protected int dineroMínimo;

    public Planeta() {
        this.nombrePlaneta = generarNombrePlaneta();
        this.porcentajeMuerte = Math.random();
        if (this.porcentajeMuerte == 0) {
            this.porcentajeMuerte = 0.1;
        }
        this.cantidadDinero = (int) (Math.random() * (this.dineroMáximo - this.dineroMínimo) + this.dineroMínimo);
        this.cantidadConstructores = 1;
        this.constructores = new Constructor[this.cantidadConstructores];
        this.constructores[0] = new Obrero();
        this.cantidadDeNaves = (int) (Math.random() * 2 + 1);
        this.naves = new Nave[this.cantidadDeNaves];
        for (int i = 0; i < this.naves.length; i++) {
            naves[i] = new Naboo_N1();
        }
        this.dineroMáximo = 500;
        this.dineroMínimo = 100;
    }

    /**
     * En caso que el usuario personalize su planeta inicial
     *
     * @param nombrePlaneta
     * @param cantidadDinero
     * @param cantidadConstructores
     * @param cantidadDeNaves
     * @param cantidadDeGuerrero
     */
    public Planeta(String nombrePlaneta, int cantidadDinero, int cantidadConstructores, int cantidadDeNaves, int cantidadDeGuerrero) {
        this.nombrePlaneta = nombrePlaneta;
        this.cantidadDinero = cantidadDinero;
        this.cantidadConstructores = cantidadConstructores;
        this.constructores = new Constructor[this.cantidadConstructores];
        for (int i = 0; i < this.constructores.length; i++) {
            this.constructores[i] = new Obrero();
        }
        this.cantidadDeNaves = cantidadDeNaves;
        this.naves = new Nave[this.cantidadDeNaves];
        for (int i = 0; i < this.cantidadDeNaves; i++) {
            this.naves[i] = new Naboo_N1();
        }
        this.cantidadDeGuerrero = cantidadDeGuerrero;
    }

    /**
     * Coloca el nombre del planeta
     *
     * @return
     */
    public static String generarNombrePlaneta() {
        return "A1";
    }

    public void setNombrePlaneta(String nombrePlaneta) {
        this.nombrePlaneta = nombrePlaneta;
    }

    public String obtnerNombrePlaneta() {
        return this.nombrePlaneta;
    }

    public double getPorcentajeDeMuerte() {
        return this.porcentajeMuerte;
    }

    public void setCantidadDinero(int cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }

    public int getCantidadDinero() {
        return this.cantidadDinero;
    }

    public void setCantidadConstructores(int cantidadConstructores) {
        this.cantidadConstructores = cantidadConstructores;
    }

    public int getCantidadConstructores() {
        return this.cantidadConstructores;
    }

    public void setCantidadNaves(int cantidadNaves) {
        this.cantidadDeNaves = cantidadNaves;
    }

    public int obtenerCantidadDeNaves() {
        return this.cantidadDeNaves;
    }

    public void cantidadGuerrero(int cantidadGuerreros) {
        this.cantidadDeGuerrero = cantidadGuerreros;
    }

    public int ObtenerCantidadGuerrero() {
        return this.cantidadDeGuerrero;
    }

    /**
     * sirve para la probailidad de aparecer un planeta
     */
    public int generarNumeroAleatorio(int max, int min) {
        int numero = (int) (Math.random() * (max - min) + min);
        return numero;
    }

    public boolean probaDeAparecer() {
        int probailidad = generarNumeroAleatorio(100, 1);

        return probailidad <= this.porcentajeDistribucion;
    }

    /**
     * Método para generar la cantidad de guerreros me refiero a la cantidad de
     * guerreros que producirán las claes hijas
     *
     * @param cantidadMaxima
     * @param cantidadMinima
     * @return
     */
    public int producirCantidadGuerreros(int cantidadMaxima, int cantidadMinima) {
        return this.cantidadDeGuerrero = (int) (Math.random() * (cantidadMaxima - cantidadMinima) + cantidadMinima);
    }

    /**
     * Metodo que me permite generar el dinero, servira para las clases hijas
     *
     * @param maximo
     * @param minimo
     * @return dinero
     */
    protected int generarDinero(int maximo, int minimo) {
        int dinero = 0;
        return dinero = (int) (Math.random() * (maximo - minimo) + minimo);
    }

    public Constructor[] getConstructores() {
        return constructores;
    }

    public Nave[] getNaves() {
        return naves;
    }

    public Guerrero[] getGuerreros() {
        return guerreros;
    }

}
