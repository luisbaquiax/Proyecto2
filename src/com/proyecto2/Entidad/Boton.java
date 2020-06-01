package com.proyecto2.Entidad;

import com.proyecto2.UI.CreandoTablero.CasillaUI;
import com.proyecto2.UI.CreandoTablero.PedirTipoCasilla;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Luis
 */
public class Boton extends JButton implements ActionListener {

    private int posicionX;
    private int posicionY;
    public static final int ANCHO = 75;
    public static final int ALTURA = 75;
    private CasillaUI casillaUI;

    public Boton(int posX, int posY, int ancho, int alto) {
        this.posicionX = posX;
        this.posicionY = posY;
        //Se coloca el boton en un lugar y se le da un tamanio
        setBounds(posX, posY, ancho, alto);

        //Se agrega el action listener en este caso la misma clase
        addActionListener(this);
    }

    /**
     * Asignar el Nombre del botón
     *
     * @param f
     * @param c
     */
    public void setNombre(int f, int c) {
        setText(f + " , " + c);
    }

    /**
     * Realizará esta acción al darle click, por el momento cambiará de color el
     * botón
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        PedirTipoCasilla tipoCasilla = new PedirTipoCasilla();
        System.out.println(this.posicionX + " +" + this.posicionY);
        //tipoCasilla.setVisible(true);

        //this.setEnabled(false);
        //Se asigna el color de fondo azul
        setBackground(Color.RED);
        //Se asigna un color de letra color blanco
        setForeground(Color.WHITE);
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

}
