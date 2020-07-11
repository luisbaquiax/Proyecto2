/**
 *
 * @author luis
 */
public class FichaBlanca extends Ficha {
    @Override
    String getFicha() {
        return ANSI_RED+CUADRO;
    }
}