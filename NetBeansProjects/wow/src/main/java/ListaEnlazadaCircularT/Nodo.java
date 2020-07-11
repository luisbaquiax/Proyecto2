package ListaEnlazadaCircularT;

/**
 *
 * @author Luis
 */
public class Nodo<T> {

    T dato;
    Nodo<T> siguiente;
    Nodo<T> anterior;
    
    public Nodo(){
    }
     public Nodo(T contenido) {
        this.dato = contenido;
    }
    
    public Nodo(T contenido,
            Nodo<T> siguiente) {
        this.dato = contenido;
        this.siguiente = siguiente;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }
    
    
}
