package biblioteca.FrontIn.Biblioteca;

import biblioteca.FrontIn.ManejadorBiblioteca.ManejadorLibros;
import biblioteca.backEnd.Estudiante.Estudiante;
import biblioteca.backEnd.Libro.Libro;
import biblioteca.backEnd.Prestamo.Prestamo;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author angel
 */
public class Biblioteca {

    public static final int CANTIDAD_MAXIMA_LIBROS = 3;
    public static final double PRECIO_PRESTAMO_NORMAL = 5;
    public static final double PRECIO_PRESTAMO_MOROSO = 10;
    public static final int LIMITE_DIAS_HABILES_PRESTAMO = 3;

    public static final int CODIGO_CARRERA_INGENIERIA = 1;
    public static final int CODIGO_CARRERA_MEDICINA = 2;
    public static final int CODIGO_CARRERA_DERECHO = 3;
    public static final int CODIGO_CARRERA_ARQUITECTURA = 4;
    public static final int CODIGO_CARRERA_ADMINISTRACION = 5;

    public static final String FORMATO_FECHA = "yyyy-MM-dd";
    SimpleDateFormat dateformatJava = new SimpleDateFormat("yyyyMMdd");

    private int librosDisponibles;

    private List<Prestamo> prestamo;
    private List<Estudiante> estudiante;
    private List<Libro> libros;

    ManejadorLibros manejadorLibro;

    public Biblioteca() {
        prestamo = new LinkedList<>();
        estudiante = new LinkedList<>();
        libros = new LinkedList<>();

    }

//    public Prestamo librosDisponibles(String codigoLibro, String carnetEstudiante){
//        Libro libro = buscarLibroPorCodigo(codigoLibro);
//        
//    }
//    
//    public Libro buscarLibroPorCodigo(String codigo){
//        for (Libro libro : libros) {
//            if(codigo.equalsIgnoreCase(libro.getCodigoLibro())){
//                return libro;
//            }
//        }
//        return null;
//    }
    public Libro agregarLibro(String titulo, String autor, String codigoLibro, int cantidadLibro, LocalDate fechaPublicacion) {
        String tituloPrueba = titulo;
        String autorPrueba = autor;
        String codigoLibroPrueba = codigoLibro;
        String fechaPublicacionPrueva = dateformatJava.format(fechaPublicacion);

        if (tituloPrueba.replace(" ", "").isEmpty()
                || autorPrueba.replace(" ", "").isEmpty()
                || codigoLibroPrueba.replace("-", "").isEmpty()
                || fechaPublicacionPrueva.isEmpty()) {
            return null;
        } else {
            if (manejadorLibro.buscarLibroPorAutor(autor) != null
                    || manejadorLibro.buscarLibroPorCodigo(codigoLibro) != null
                    || manejadorLibro.buscarLibroPorTitulo(titulo) != null
                    || manejadorLibro.buscarLibroPorFechaPublicacion(fechaPublicacion) != null) {
                return null;
            } else {
                Libro nuevoLibro = new Libro(titulo, autor, codigoLibro, cantidadLibro, fechaPublicacion);
                libros.add(nuevoLibro);
                return nuevoLibro;
            }
        }
    }

    public Estudiante agregarEstudiante(String nombre, String carnet, int codigoCarrera, LocalDate fechaCumple) {
        Estudiante nuevoEstudiante = new Estudiante(nombre, carnet, codigoCarrera, fechaCumple);
        estudiante.add(nuevoEstudiante);
        return nuevoEstudiante;
    }

    public int getLibrosDisponibles() {
        return librosDisponibles;
    }

    public void setLibrosDisponibles(int librosDisponibles) {
        this.librosDisponibles = librosDisponibles;
    }

    public List<Prestamo> getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(List<Prestamo> prestamo) {
        this.prestamo = prestamo;
    }

    public List<Estudiante> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(List<Estudiante> estudiante) {
        this.estudiante = estudiante;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

}
