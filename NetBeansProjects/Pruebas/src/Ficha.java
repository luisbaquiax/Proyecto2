/**
 *
 * @author luis
 */
abstract public class Ficha {

    protected static final char CUADRO = (char)219;
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_WHITE = "\u001B[37m";
    protected static final String ANSI_YELLOW = "\u001B[33m";
    protected static final String ANSI_BLUE = "\u001B[34m";
    protected static final String ANSI_PURPLE = "\u001B[35m";


    abstract String getFicha();

    public void setFichaNull(){
        System.out.println("hola");
    }
}