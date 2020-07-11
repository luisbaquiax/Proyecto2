package ListaEnlazadaCircularT;

/**
 *
 * @author Luis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaCiruclar<String> s = new ListaCiruclar<>();
        s.insertarElementos("HOLA");
        s.insertarElementos("luis");
        s.insertarElementos("basi");
        s.insertarElementos("ajaj");
        s.insertarElementos("mama");

        s.sacarElemento();
    }
}
