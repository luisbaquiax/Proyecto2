/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provando;

import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class ListaDoble {

    private NodoDoble cabeza;
    private NodoDoble ultimo;

    public ListaDoble() {
        this.cabeza = null;
        this.ultimo = null;
    }

    /**
     * Valor
     *
     * @param valor
     */
    public void insertar(String valor) {
        NodoDoble nuevo = new NodoDoble(valor);
        //size++;
        if (esVacia()) {
            this.setCabeza(nuevo);
            this.ultimo = nuevo;
        } else {
            NodoDoble actual = getCabeza();
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();

            }
            actual.setSiguiente(nuevo);
            actual.setAnterior(actual.getAnterior());
        }
    }

    public NodoDoble eliminar() {
        return null;
    }

    public void eliminar(String valor) {
        if (this.cabeza == null) {
            JOptionPane.showMessageDialog(null, "No hay elementos en la lista simple");
        } else {
            if (this.cabeza.getValor().equals(valor)) {
                this.cabeza = this.cabeza.getSiguiente();
            } else {
                NodoDoble auxiliar = cabeza;
                while (auxiliar != null) {
                    if (auxiliar.getSiguiente() != null) {
                        if (auxiliar.getSiguiente().getValor().equals(valor)) {
                            NodoDoble auxSiguiente = auxiliar.getSiguiente();
                            //NodoDoble auxAnterior = auxiliar.getAnterior();
                            auxiliar.setSiguiente(auxSiguiente.getSiguiente());
                            //auxiliar.setAnterior(auxAnterior.getAnterior());
                            auxSiguiente.setSiguiente(null);
                            return;
                        }

                    }
                    auxiliar = auxiliar.getSiguiente();
                }

            }

        }

    }

    public String codigoGraphiz() {
        String cadena = "digraph G{\n";
        NodoDoble temporal = cabeza;
        if (!esVacia()) {
            while (temporal != null) {
                if (temporal.getSiguiente() != null) {
                    cadena += temporal.getValor() + "[label = \"" + temporal.getValor() + "," + temporal.getColor() + "\" ]\n"
                            + temporal.getValor() + "->" + temporal.getSiguiente().getValor() + ";\n"
                            + temporal.getSiguiente().getValor() + "->" + temporal.getValor() + ";\n";
                } else if (temporal.getAnterior() != null) {
                    cadena += temporal.getValor() + "[label = \"" + temporal.getValor() + "," + temporal.getColor() + "\" ]\n"
                            + ";\n"
                            + temporal.getAnterior().getValor() + "->" + temporal.getValor() + ";\n";
                } else if (temporal.getSiguiente() == null) {
                    cadena += temporal.getValor() + "[label = \"" + temporal.getValor() + "," + temporal.getColor() + "\" ]\n"
                            + ";\n";
                }

                temporal = temporal.getSiguiente();
            }
        }
        cadena += "}";
        return cadena;
    }

    public void mostrarDatos() {
        NodoDoble temporal = cabeza;
        do {
            temporal.mostrarDatos();
            temporal = temporal.getSiguiente();
        } while (temporal != null);
    }

    public boolean esVacia() {
        return (cabeza == null);
    }

    /**
     * @return the cabeza
     */
    public NodoDoble getCabeza() {
        return cabeza;
    }

    /**
     * @param cabeza the cabeza to set
     */
    public void setCabeza(NodoDoble cabeza) {
        this.cabeza = cabeza;
    }

    public NodoDoble getUltimoNodo() {
        return ultimo;
    }

    public void setUltimoNodo(NodoDoble ultimoNodo) {
        this.ultimo = ultimoNodo;
    }

}
