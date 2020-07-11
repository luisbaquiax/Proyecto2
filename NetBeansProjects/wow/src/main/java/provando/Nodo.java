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
public class Nodo {

    private String valor;
    private String color;
    private String tope;
    private Nodo siguiente;

    public Nodo(String valor) {
        this.valor = valor;
        this.color = "VERDE";
        this.tope = "0";
        this.siguiente = null;

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

    /**
     * @return the siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the tope
     */
    public String getTope() {
        return tope;
    }

    /**
     * @param tope the tope to set
     */
    public void setTope(String tope) {
        this.tope = tope;
    }

    public void mostrarDatos() {
        System.out.println("Valor " + this.getValor());
    }
}
