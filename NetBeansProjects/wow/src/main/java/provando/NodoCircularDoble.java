/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provando;

/**
 *
 * @author Luis
 */
public class NodoCircularDoble {

    private String valor;
    private String color;

    private NodoCircularDoble siguiente;
    private NodoCircularDoble anterior;

    public NodoCircularDoble(String valor) {
        this.valor = valor;
        this.color = "ROJO";
        this.siguiente = this;
        this.anterior = this;
    }

    public NodoCircularDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCircularDoble anterior) {
        this.anterior = anterior;
    }

    public NodoCircularDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircularDoble siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    public void mostrarDatos() {
        System.out.println("Valor>" + this.valor);
    }

}
