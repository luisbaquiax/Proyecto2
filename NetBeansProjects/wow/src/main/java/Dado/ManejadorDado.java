package Dado;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Luis
 */
public class ManejadorDado implements Runnable {

    private String[] imagenes;
    private ImageIcon iconoDado;
    private JLabel labelDado;
    private String imagen1 = "imagenesDados/11.jpg";
    private String imagen2 = "imagenesDados/22.jpg";
    private String imagen3 = "imagenesDados/33.jpg";
    private String imagen4 = "imagenesDados/44.jpg";
    private String imagen5 = "imagenesDados/55.jpg";
    private String imagen6 = "imagenesDados/66.jpg";

    public ManejadorDado(JLabel labelDado) {
        imagenes = new String[6];
        imagenes[0] = imagen1;
        imagenes[1] = imagen2;
        imagenes[2] = imagen3;
        imagenes[3] = imagen4;
        imagenes[4] = imagen5;
        imagenes[5] = imagen6;
        this.labelDado = labelDado;
    }

    public static int generarNumeroAleatorio(int max, int min) {
        int numero = (int) Math.floor(Math.random() * (max - min + 1) + (min));
        //int numero = (int) (Math.random() * (max-1) + (min));
        return numero;
    }

    @Override
    public void run() {
        int dado = generarNumeroAleatorio(5, 0);
        iconoDado = new ImageIcon(imagenes[dado]);
        labelDado.setIcon(new ImageIcon(iconoDado.getImage().getScaledInstance(labelDado.getHeight(), labelDado.getWidth(), Image.SCALE_SMOOTH)));
    }
}
