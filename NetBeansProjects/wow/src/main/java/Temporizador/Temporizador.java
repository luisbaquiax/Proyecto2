package Temporizador;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer.*;

/**
 *
 * @author Luis
 */
public class Temporizador implements Runnable {

    private JLabel labelTemporizador;
    static int hora;
    static int minuto;
    static int segundo;
    private JFrame frame;

    public Temporizador(JFrame frame, JLabel labelHora) {
        this.labelTemporizador = labelHora;
        this.frame = frame;
    }

    @Override
    public void run() {
        try {
            while (TemporizadorUI.iniciarHilo) {
                Thread.sleep(100);
                iniciaTemp();
                if (hora == 0 && minuto == 2 && segundo == 5) {
                    JOptionPane.showMessageDialog(frame, "Se ha agotado el tiempo");
                    TemporizadorUI.iniciarHilo = false;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void iniciaTemp() {
        segundo++;
        if (segundo > 59) {
            segundo = 0;
            minuto++;
            if (minuto > 59) {
                minuto = 0;
                hora++;
                if (hora > 1) {
                    System.out.println("Paso una hora");
                }

            }
        }
        String txtSeg = "", txtMin = "", txtHora = "";
        if (segundo < 10) {
            txtSeg = "0" + segundo;
        } else {
            txtSeg = "" + segundo;
        }
        if (minuto < 10) {
            txtMin = "0" + minuto;
        } else {
            txtMin = "" + minuto;
        }
        if (hora < 10) {
            txtHora = "0" + hora;
        } else {
            txtHora = "" + hora;
        }
        String horaComplea = txtHora + ": " + txtMin + ": " + txtSeg;
        labelTemporizador.setText(horaComplea);
    }
}
