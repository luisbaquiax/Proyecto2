package biblioteca.backEnd.Prestamo;

import biblioteca.backEnd.Estudiante.Estudiante;
import biblioteca.backEnd.Libro.Libro;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author angel
 */
public class Prestamo implements Serializable {

    private transient Libro libro;
    private transient Estudiante estudiante;

    private String codigoLibro;
    private String carnetEstudiante;

    private LocalDate fechaPrestamo;
    private double totalpago;
    private int diasPrestamo;

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        if (libro != null) {
            this.codigoLibro = libro.getCodigoLibro();
        }
        this.libro = libro;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            this.carnetEstudiante = estudiante.getCarnet();
        }
        this.estudiante = estudiante;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getCarnetEstudiante() {
        return carnetEstudiante;
    }

    public void setCarnetEstudiante(String carnetEstudiante) {
        this.carnetEstudiante = carnetEstudiante;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public double getTotalpago() {
        return totalpago;
    }

    public void setTotalpago(double totalpago) {
        this.totalpago = totalpago;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    public String getEstadoPrestamo() {
        return this.esCerrado() ? "Cerrado" : "Abierto";
    }

    public boolean esCerrado() {
        return this.diasPrestamo > 0;
    }

    public boolean getAntiguedad() {
        return fechaPrestamo.isBefore(LocalDate.now().minus(2, ChronoUnit.DAYS));
    }
}
