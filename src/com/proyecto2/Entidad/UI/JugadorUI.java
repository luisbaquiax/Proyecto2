package com.proyecto2.Entidad.UI;

import com.proyecto2.Entidad.Jugador;
import com.proyecto2.UI.CrearTablero;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Luis
 */
public class JugadorUI {

    //EN PIXELES
    public final int ESPACIO_INGRESO = 40;
    public final int ESPACIO_INTERMEDIO = 7;
    public final int ALTO_TEXTO = 30;
    public final int ANCHO_TEXTO = 125;
    //Para el ingreso del nombre de los jugadores
    private JLabel labelNombre;
    private JTextField txtNombres;

    /**
     *
     * @param iterador, para que nos muestre el número del jugador
     */
    public JugadorUI(int iterador) {
        this.labelNombre = new JLabel("Nombre jugador" + (iterador + 1));
        this.txtNombres = new JTextField();
    }

    public void setBounds(int iterador) {
        int posY = (ESPACIO_INGRESO * iterador) + ESPACIO_INTERMEDIO;
        labelNombre.setBounds(ESPACIO_INTERMEDIO, posY, 100, ALTO_TEXTO);
        txtNombres.setBounds(ESPACIO_INTERMEDIO * 3 + 5000000, posY, ANCHO_TEXTO, ALTO_TEXTO);
    }

    public Jugador nuevoJugador() {
        return new Jugador(txtNombres.getText());
    }

    //
    public boolean isEmpty() {
        return (txtNombres.getText().replaceAll(" ", "").isEmpty());
    }

    public JLabel getLabelNombre() {
        return labelNombre;
    }

    public JTextField getTxtNombres() {
        return txtNombres;
    }
//     public boolean isEmpty() {
//        return txtNombres.getText().replaceAll(" ", "").isEmpty();
//    }
}
