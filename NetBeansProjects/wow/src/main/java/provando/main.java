package provando;

/**
 *
 * @author Luis
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaCircularDoble lista = new ListaCircularDoble();
        lista.insertar("2");
        lista.insertar("8");
        lista.insertar("28");
        lista.insertar("22");
        lista.insertar("29");
        System.out.println("datso");
        lista.mostrarDatosDeLalistaDoble();
        System.out.println("eliminando");
        lista.eliminar(String.valueOf(2));
        lista.eliminar(String.valueOf(8));
        lista.eliminar(String.valueOf(28));
        lista.eliminar(String.valueOf(22));
//        lista.eliminar(String.valueOf(29));

        System.out.println("datos finalse");
        lista.mostrarDatosDeLalistaDoble();
    }

}
