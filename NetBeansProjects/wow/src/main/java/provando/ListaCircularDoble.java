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
public class ListaCircularDoble {

    private NodoCircularDoble cabeza;
    private NodoCircularDoble ultimo;
    private int size =0;

    public ListaCircularDoble() {
        this.cabeza = null;
        this.ultimo = null;
    }

    public void insertar(String valor) {
        size++;
        NodoCircularDoble nuevo = new NodoCircularDoble(valor);
        if (this.getCabeza() != null) {

            nuevo.setSiguiente(this.getCabeza().getSiguiente());
            this.getCabeza().setSiguiente(nuevo);
            nuevo.setAnterior(getCabeza());
        }
        this.setCabeza(nuevo);
        this.getCabeza().getSiguiente().setAnterior(nuevo);
    }

    public void eliminar(String valor) {
        if (this.cabeza == null) {
            JOptionPane.showMessageDialog(null, "No hay elementos en la lista circular doble");
        } else {
            if (this.cabeza.getValor().equals(valor)) {
                this.cabeza = this.cabeza.getSiguiente();
                
            } else {
                NodoCircularDoble auxiliar = cabeza;

                while (auxiliar != null) {
                    if (auxiliar.getSiguiente() != null) {
                        if (auxiliar.getSiguiente().getValor().equals(valor)) {
                            NodoCircularDoble auxSiguiente = auxiliar.getSiguiente();
                            auxiliar.setSiguiente(auxSiguiente.getSiguiente());
                            NodoCircularDoble auxAnterior = auxiliar.getAnterior();
                            auxiliar.setAnterior(auxAnterior.getAnterior());

                            auxSiguiente.setSiguiente(null);
                            auxSiguiente.setAnterior(null);
                            return;
                        }else{
                           JOptionPane.showMessageDialog(null, "No existe ese elemento en la lista", "ELEMENTO NO ENCONTRADO", 
                                   JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }

                    }
                    auxiliar = auxiliar.getSiguiente();
                }
                
            }
            
        }

    }

    public String codigoGraphiz() {
        String cadena = "digraph G{\nlayout=\"circo\";\n";
        NodoCircularDoble temporal = cabeza;
        if (!esVacia()) {
            do {
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
            } while (temporal != cabeza);

        }
        cadena += "}";
        return cadena;
    }

    public void mostrarDatosDeLalistaDoble() {
        NodoCircularDoble actual = cabeza;
        do {
            actual.mostrarDatos();
            actual = actual.getSiguiente();
        } while (actual != cabeza);

    }

    public boolean esVacia() {
        return (cabeza == null);
    }

    public NodoCircularDoble getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoCircularDoble cabeza) {
        this.cabeza = cabeza;
    }

    public int getSize() {
        return size;
    }
    

}
