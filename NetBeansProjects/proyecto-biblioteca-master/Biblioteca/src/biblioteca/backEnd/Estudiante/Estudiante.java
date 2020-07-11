package biblioteca.backEnd.Estudiante;

import biblioteca.FrontIn.Biblioteca.Biblioteca;
import biblioteca.backEnd.Prestamo.Prestamo;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author angel
 */
public class Estudiante implements Serializable {

    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);
    public static final String FORMATO_FECHA = "dd/MM/yyyy";

    private String nombre;
    private String carnet;
    private int codigoCarrera;
    private LocalDate fechaCumple;
    private int cantidadLibroPrestados;
    private List<Prestamo> PrestamoNormal;
    private List<Prestamo> PrestamoConMora;

    public static final String PROP_NOMBRE = "nombre";
    public static final String PROP_CARNET = "carnet";
    public static final String PROP_COD_CARRERA = "CodigoCarrera";
    public static final String PROP_CANT_LIBROS = "CantidadLibrosPrestados";

    public Estudiante(String nombre, String carnet, int codigoCarrera, LocalDate fechaCumple) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.codigoCarrera = codigoCarrera;
        this.fechaCumple = fechaCumple;

    }

    public Estudiante() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String nombreAnterior = this.nombre;
        this.nombre = nombre;
        propertySupport.firePropertyChange(PROP_NOMBRE, nombreAnterior, nombre);
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        String carnetAnterior = this.carnet;
        this.carnet = carnet;
        propertySupport.firePropertyChange(PROP_CARNET, carnetAnterior, carnet);
    }

    public int getCodigoCarrera() {
        return codigoCarrera;
    }

    public String getCodigoCarreraStr() {
        switch (codigoCarrera) {
            case Biblioteca.CODIGO_CARRERA_INGENIERIA:
                return "Ingenieria";
            case Biblioteca.CODIGO_CARRERA_MEDICINA:
                return "Medicina";
            case Biblioteca.CODIGO_CARRERA_DERECHO:
                return "Derecho";
            case Biblioteca.CODIGO_CARRERA_ARQUITECTURA:
                return "Arquitectura";
            case Biblioteca.CODIGO_CARRERA_ADMINISTRACION:
                return "Administracion";
        }
        return null;
    }

    public void setCodigoCarrera(int codigoCarrera) {
        int codigoCarreraAnterior = this.codigoCarrera;
        this.codigoCarrera = codigoCarrera;
        propertySupport.firePropertyChange(PROP_COD_CARRERA, codigoCarreraAnterior, codigoCarrera);
    }

    public LocalDate getFechaCumple() {
        return fechaCumple;
    }

    public void setFechaCumple(LocalDate fechaCumple) {
        this.fechaCumple = fechaCumple;
    }

    public int getCantidadLibroPrestados() {
        return cantidadLibroPrestados;
    }

    public void setCantidadLibroPrestados(int cantidadLibroPrestados) {
        int cantidadLibroPrestadosAnterior = this.cantidadLibroPrestados;
        this.cantidadLibroPrestados = cantidadLibroPrestados;
        propertySupport.firePropertyChange(PROP_CANT_LIBROS, cantidadLibroPrestadosAnterior, cantidadLibroPrestados);
    }

    public List<Prestamo> getPrestamoNormal() {
        return PrestamoNormal;
    }

    public void setPrestamoNormal(List<Prestamo> PrestamoNormal) {
        this.PrestamoNormal = PrestamoNormal;
    }

    public List<Prestamo> getPrestamoConMora() {
        return PrestamoConMora;
    }

    public void setPrestamoConMora(List<Prestamo> PrestamoConMora) {
        this.PrestamoConMora = PrestamoConMora;
    }

    @Override
    public Estudiante clone() {
        return new Estudiante(this.nombre, this.carnet, this.codigoCarrera, this.fechaCumple);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

}
