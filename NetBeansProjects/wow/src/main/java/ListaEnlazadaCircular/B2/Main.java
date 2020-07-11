package ListaEnlazadaCircular.B2;

/**
 *
 * @author Luis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ListaCiruclar2 s = new ListaCiruclar2();
       s.insertarElementos(12);
       s.insertarElementos(45);
       s.insertarElementos(78);
       s.insertarElementos(98);
       s.insertarElementos(65);
       s.insertarElementos(22);
       s.sacarElemento();
    }

}
