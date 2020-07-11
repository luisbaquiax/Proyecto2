package biblioteca.backEnd.Libro;

import biblioteca.backEnd.Prestamo.Prestamo;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author angel
 */
public class Libro implements Serializable {

    private PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);

    public static final String FORMATO_FECHA = "yyyy-MM-dd";

    private String titulo;
    private String autor;
    private String codigoLibro;
    private int cantidadLibro;
    private LocalDate fechaPublicacion;
    private Prestamo prestamo;

    private List<Prestamo> prestamoLibro;

    public static final String PROP_TITULO = "Titulo";
    public static final String PROP_AUTOR = "Autor";
    public static final String PROP_COD_LIBRO = "codigoLibro";
    public static final String PROP_CANT_LIBROS = "cantidadLibros";

    public Libro(String titulo, String autor, String codigoLibro, int cantidadLibro, LocalDate fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigoLibro = codigoLibro;
        this.cantidadLibro = cantidadLibro;
        this.fechaPublicacion = fechaPublicacion;
        this.prestamo = prestamo;
    }

    public Libro(String titulo, String autor, String codigoLibro, int cantidadLibro) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigoLibro = codigoLibro;
        this.cantidadLibro = cantidadLibro;
    }

    public Libro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        String tituloAnterior = this.titulo;
        this.titulo = titulo;
        propertySupport.firePropertyChange(PROP_TITULO, tituloAnterior, titulo);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        String autorAnterior = this.autor;
        this.autor = autor;
        propertySupport.firePropertyChange(PROP_AUTOR, autorAnterior, autor);
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        String codigoLibroAnterior = this.codigoLibro;
        this.codigoLibro = codigoLibro;
        propertySupport.firePropertyChange(PROP_COD_LIBRO, codigoLibroAnterior, codigoLibro);
    }

    public int getCantidadLibro() {
        return cantidadLibro;
    }

    public void setCantidadLibro(int cantidadLibro) {
        int cantidadLibrosAnterior = this.cantidadLibro;
        this.cantidadLibro = cantidadLibro;
        propertySupport.firePropertyChange(PROP_CANT_LIBROS, cantidadLibrosAnterior, cantidadLibro);
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public Libro clone() {
        return new Libro(this.titulo, this.autor, this.codigoLibro, this.cantidadLibro, this.fechaPublicacion);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
