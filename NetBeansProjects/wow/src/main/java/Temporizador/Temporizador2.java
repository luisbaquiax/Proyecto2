package Temporizador;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class Temporizador2 {

    private JLabel labelTemporizador;
    private int hora, minuto, segundo;
    private Timer timer;
    private boolean iniciando;
    JFrame frame;

    public Temporizador2(JLabel labelHora, int horas, int minutos) {
        this.labelTemporizador = labelHora;
        this.hora = horas;
        this.minuto = minutos;
        timer = new Timer();
    }
    TimerTask iniciarTarea = new TimerTask() {
        @Override
        public void run() {
            iniciando = true;
            if (segundo > 0) {
                segundo--;
            } else {
                segundo = 59;
                if (minuto > 0) {
                    minuto--;

                } else {
                    minuto = 59;
                    if (hora > 0) {
                        hora--;
                    } // si segundo = 0, minuto = 0 y hora = 0,
                    // cancelamos el timer
                    else {
                        JOptionPane.showMessageDialog(null, "Se ha terminado el tiempo", "Tiempo agotado", JOptionPane.INFORMATION_MESSAGE);
                        iniciando = false;
                        timer.cancel();
                        timer.purge();
                    }
                }
            }
            if (iniciando) {
                colocandoAlLabel(hora, minuto, segundo, labelTemporizador);
            }
        }
    };

    public void iniciandoTemporizador(int cuando, int largo) {
        timer.schedule(iniciarTarea, cuando, largo);
    }

    public void colocandoAlLabel(int hora, int minuto, int segundo, JLabel labelTemporizador) {

        
//        String horaCompleta = "";
//
//        horaCompleta += (hora > 9) ? ":" + hora : "0" + hora;
//        horaCompleta += (minuto > 9) ? ":" + minuto : ":0" + minuto;
//        horaCompleta += (segundo > 9) ? ":" + segundo : ":0" + segundo;
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
//        txtSeg += segundo;
//        txtMin += minuto;
//        txtHora += hora;
        String horaCompleta = txtHora + ": " + txtMin + ": " + txtSeg;
        labelTemporizador.setText(horaCompleta);
    }
}
