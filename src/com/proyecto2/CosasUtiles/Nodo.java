package com.proyecto2.CosasUtiles;

/**
 * PilasYColas
 * @author jose - 06.05.2020 
 * @Title: Nodo
 * @Description: description
 *
 * Changes History
 */
public class Nodo<T> {

    private T contenido;
    private Nodo<T> siguiente;

    public Nodo(T contenido) {
        this.contenido = contenido;
    }

    public Nodo(T contenido,
            Nodo<T> siguiente) {
        this.contenido = contenido;
        this.siguiente = siguiente;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

}