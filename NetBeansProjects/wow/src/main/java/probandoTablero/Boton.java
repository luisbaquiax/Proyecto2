package probandoTablero;

import ListaEnlazadaCircularT.ListaCiruclar;
import MatrizBotones.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Boton extends JButton implements ActionListener {

    ListaCiruclar<panelCasilla> paneles;
    panelCasilla casilla;
    int x, y, ancho, alto;

    //-------- Constructor con parametros para posicionar a los botones ------//
    public Boton(int pos_x, int pos_y, int ancho, int alto) {
        //Se coloca el boton en un lugar y se le da un tamanio
        setBounds(pos_x, pos_y, ancho, alto);

        //Se agrega el action listener en este caso la misma clase
        addActionListener(this);
        this.x = pos_x;
        this.y = pos_y;
        this.ancho = ancho;
        this.alto = alto;
        paneles = new ListaCiruclar<>();
    }
    //------------------------------------------------------------------------//

    //---------------------- Se asigna una el nombre del boton ---------------//
    public void setNombre(int f, int c) {
        setText(f + " , " + c);
    }
    //------------------------------------------------------------------------//

    //------------------ Al darle click realizara este metodo ----------------//
    public void actionPerformed(ActionEvent e) {
        casilla = new panelCasilla(x, y, ancho, alto);
        paneles.insertarElementos(casilla);
        //JOptionPane.showMessageDialog(null, "Se creó exitosamente la casilla");
        //Se asigna el color de fondo azul
        setBackground(Color.BLUE);
        //Se asigna un color de letra color blanco
        setForeground(Color.WHITE);
    }
    //------------------------------------------------------------------------//
    
}
