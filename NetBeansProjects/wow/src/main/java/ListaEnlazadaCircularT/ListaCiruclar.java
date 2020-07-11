package ListaEnlazadaCircularT;

/**
 *
 * @author Luis
 */
public class ListaCiruclar<T> {

    Nodo<T> primero;
    Nodo<T> ultimo;
//    Nodo<T> actual;

    public ListaCiruclar() {
        primero = null;
        ultimo = null;
    }

    public void insertarElementos(T elemento) {
        Nodo<T> nuevo = new Nodo(elemento);
        nuevo.dato = elemento;
        if (primero == null) {
            primero = nuevo;
            primero.siguiente = primero;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.siguiente = primero;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
            primero.anterior = ultimo;
        }
    }

    public void sacarElemento() {

        Nodo actual = new Nodo();
        actual = primero;
        do {
            
            System.out.println(actual.dato);
            actual = actual.siguiente;
        } while (actual != primero);
    }
}
