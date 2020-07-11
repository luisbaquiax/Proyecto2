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
public class Pila {

    private Nodo cabeza;
    private int size;

    public Pila() {
        this.cabeza = null;
        this.size = 0;
    }

    public void insertar(String valor) {
        size++;
        Nodo nuevo = new Nodo(valor);
        if (getCabeza() == null) {
            setCabeza(nuevo);
        } else {
            nuevo.setSiguiente(getCabeza());
            setCabeza(nuevo);
        }
    }

    public Nodo desapilar() {
        Nodo actual = cabeza;
        cabeza = cabeza.getSiguiente();
        size--;//probablemente me va servir más después
        return actual;
    }

    public String codigoGraphiz() {
        String cadena = "digraph G{\n" + "0[label = \" TOPE \" ]\n";
        Nodo temporal = getCabeza();
        cadena += "0->" + temporal.getValor() + "\n";

        do {
            if (temporal.getSiguiente() != null) {
                cadena += temporal.getValor() + "[label = \"" + temporal.getValor() + "," + temporal.getColor() + "\" ]\n"
                        + temporal.getValor() + "->" + temporal.getSiguiente().getValor() + ";\n";
            } else if (temporal.getSiguiente() == null) {
                cadena += temporal.getValor() + "[label = \"" + temporal.getValor() + "," + temporal.getColor() + "\" ]\n"
                        + ";\n";
            }
            temporal = temporal.getSiguiente();
        } while (temporal != null);
        cadena += "}";
        return cadena;
    }

    public void mostrarDatos() {
        Nodo temporal = getCabeza();
        while (temporal != null) {
            temporal.mostrarDatos();
            temporal = temporal.getSiguiente();
        }
    }

    /**
     * @return the cabeza
     */
    public Nodo getCabeza() {
        return cabeza;
    }

    /**
     * @param cabeza the cabeza to set
     */
    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

}
