package com.proyecto2.CosasUtiles;

/**
 * PilasYColas
 * @author jose - 06.05.2020 
 * @Title: ListaEnzalada
 * @Description: description
 *
 * Changes History
 */
public class ListaEnzalada<T> {

    private Nodo<T> primerNodo;
    private Nodo<T> ultimoNodo;
    private int ultimoIndice = -1;


    public void insertar(T contenido) {
        ultimoIndice++;
        Nodo<T> nuevo = new Nodo<>(contenido);
        if (esVacia()) {
            primerNodo = nuevo;
            ultimoNodo = nuevo;
        } else {
            ultimoNodo.setSiguiente(nuevo);
            ultimoNodo = nuevo;
        }
    }


    public void eliminar()
            throws ListaEnzaladaException {
        if (esVacia()) {
            throw new ListaEnzaladaException("Error eliminado elemento en lista vacia.");
        }
        if (primerNodo.equals(ultimoNodo)) {
            primerNodo = null;
            ultimoNodo = null;
        } else {
            Nodo<T> penultimo = obtenerPorIndice(ultimoIndice - 1);
            penultimo.setSiguiente(null);
            ultimoNodo = penultimo;
        }
        ultimoIndice--;
    }

    public boolean esVacia() {
        return primerNodo == null;
    }

    public Nodo<T> obtenerPorIndice(int indice)
            throws ListaEnzaladaException {
        if (indice < 0 || indice > ultimoIndice) {
            throw new ListaEnzaladaException("Indice fuera de rango.");
        }
        Nodo<T> buscado = primerNodo;
        for (int i = 0; i < indice; i++) {
            buscado = buscado.getSiguiente();
        }

        return buscado;
    }

    public Nodo<T> getPrimerNodo() {
        return primerNodo;
    }

    public void setPrimerNodo(Nodo<T> primerNodo) {
        this.primerNodo = primerNodo;
    }

    public Nodo<T> getUltimoNodo() {
        return ultimoNodo;
    }

    public void setUltimoNodo(Nodo<T> ultimoNodo) {
        this.ultimoNodo = ultimoNodo;
    }

}