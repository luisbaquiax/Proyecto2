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
public class Cola {

    private Nodo cabeza;

    public Cola() {
        this.cabeza = null;
    }

    public void encolar(String valor) {
        Nodo nuevo = new Nodo(valor);
        if (this.getCabeza() == null) {
            this.setCabeza(nuevo);
        } else {
            Nodo actual = this.getCabeza();
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    /*
     * Dessencolar
     **/
    public Nodo desencolar() {
        Nodo retorno = null;
        if (this.getCabeza() != null) {
            retorno = this.getCabeza();
            if (this.getCabeza().getSiguiente() != null) {
                this.setCabeza(retorno.getSiguiente());
            } else {
                this.setCabeza(null);
            }
            return retorno;
        }
        return retorno;
    }

    public String codigoGraphiz() {
        String cadena = "digraph G{\n" + "0[label = \" TOPE \" ]\n";
        Nodo temporal = cabeza;
        cadena += "0->" + temporal.getValor() + "\n";
        while (temporal != null) {
            if (temporal.getSiguiente() != null) {
                cadena += temporal.getValor() + "[label = \"" + temporal.getValor() + "," + temporal.getColor() + "\" ]\n"
                        + temporal.getValor() + "->" + temporal.getSiguiente().getValor() + ";\n";
            } else if (temporal.getSiguiente() == null) {
                cadena += temporal.getValor() + "[label = \"" + temporal.getValor() + "," + temporal.getColor() + "\" ]\n"
                        + ";\n";
            }
            temporal = temporal.getSiguiente();
        }
        cadena += "}";
        return cadena;
    }

    public void mostrarDatos() {
        Nodo actual = cabeza;
        while (actual != null) {
            actual.mostrarDatos();
            actual = actual.getSiguiente();

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
}
