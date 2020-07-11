package Mapa_Otros;

/**
 *
 * @author Luis
 */
public class Batalla {

    private Jugador[] jugadores = new Jugador[2];
    private boolean turno = true; //true para jugador1, false para jugador 2

    public Batalla(String nombreJugador1, String nombreJugador2) {

        this.jugadores[0] = new Jugador(nombreJugador1);
        this.jugadores[1] = new Jugador(nombreJugador2);

    }

    /**
     *
     */
    public void batalla() {
        if(alternandoTurno(1)){//turnos de jugador1
        
        }else{//turno de jugador2
        
        }

    }

    public boolean alternandoTurno(int turno) {
        if (turno == 1) {
            return this.turno;
        } else {
            return this.turno = false;
        }
    }

}
