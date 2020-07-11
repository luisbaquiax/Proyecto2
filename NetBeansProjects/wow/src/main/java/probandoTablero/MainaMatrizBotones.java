package probandoTablero;

import MatrizBotones.*;

/**
 *
 * @author Luis
 */
public class MainaMatrizBotones {

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        new MatrizBoton().setVisible(true);
    }

}
