/**
 *
 * @author luis
 */
public class FichaNegra extends Ficha{
    @Override
    String getFicha() {
        return ANSI_PURPLE+CUADRO;
    }
}