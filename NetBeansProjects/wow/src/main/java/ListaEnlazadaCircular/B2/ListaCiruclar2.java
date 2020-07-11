package ListaEnlazadaCircular.B2;

/**
 *
 * @author Luis
 */
public class ListaCiruclar2{

    Nodo primero;
    Nodo ultimo;

    public ListaCiruclar2() {
        primero = null;
        ultimo = null;
    }

    public void insertarElementos(int elemento) {
        Nodo nuevo = new Nodo();
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
