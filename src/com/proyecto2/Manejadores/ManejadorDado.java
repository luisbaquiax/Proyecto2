package com.proyecto2.Manejadores;

import com.proyecto2.CosasUtiles.MetodosUtiles;
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
    private String imagen1 = "imagenes/11.jpg";
    private String imagen2 = "imagenes/22.jpg";
    private String imagen3 = "imagenes/33.jpg";
    private String imagen4 = "imagenes/44.jpg";
    private String imagen5 = "imagenes/55.jpg";
    private String imagen6 = "imagenes/66.jpg";
    private MetodosUtiles random;
    private int dado;
    
    public ManejadorDado(JLabel labelDado) {
        imagenes = new String[6];
        imagenes[0] = imagen1;
        imagenes[1] = imagen2;
        imagenes[2] = imagen3;
        imagenes[3] = imagen4;
        imagenes[4] = imagen5;
        imagenes[5] = imagen6;
        this.labelDado = labelDado;
        random = new MetodosUtiles();
        dado = random.generarNumeroAleatorio(5, 0);
    }

    @Override
    public void run() {
        //int dado = random.generarNumeroAleatorio(5, 0);
        iconoDado = new ImageIcon(imagenes[dado]);
        labelDado.setIcon(new ImageIcon(iconoDado.getImage().getScaledInstance(labelDado.getSize().width,
                labelDado.getSize().height, Image.SCALE_SMOOTH)));
    }

    public int getDado() {
        return dado;
    }
}
