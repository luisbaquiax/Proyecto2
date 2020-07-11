package biblioteca.FrontIn.ManejadorBiblioteca;

import biblioteca.FrontIn.Biblioteca.Biblioteca;
import biblioteca.FrontIn.Excepciones.InputsVaciosException;
import biblioteca.backEnd.Libro.Libro;
import biblioteca.backEnd.ManejadorDatosArchivo.manejadorDatosArchivo;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.ValidationException;

/**
 *
 * @author angel
 */
public class ManejadorLibros {

    private static final String ARCHIVO_LIBROS = "libros.dat";
    private File archivoLibros;
    private manejadorDatosArchivo<Libro> manejadorDatos;

    SimpleDateFormat dateformatJava = new SimpleDateFormat("yyyyMMdd");

    Libro libros;
    Biblioteca biblioteca;

    List<Libro> librosBuscados = new LinkedList<>();

    public ManejadorLibros(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        archivoLibros = new File(ARCHIVO_LIBROS);
        manejadorDatos = new manejadorDatosArchivo<>();
    }

    public Libro agregarLibro(String titulo, String autor, String codigoLibro, int cantidadLibro, LocalDate fechaPublicacion) throws ValidationException, InputsVaciosException {
        String tituloPrueba = titulo;
        String autorPrueba = autor;
        String codigoLibroPrueba = codigoLibro;
        String fechaPublicacionPrueva = dateformatJava.format(fechaPublicacion);

        if (tituloPrueba.replace(" ", "").isEmpty()
                || autorPrueba.replace(" ", "").isEmpty()
                || codigoLibroPrueba.replace("-", "").isEmpty()
                || fechaPublicacionPrueva.isEmpty()) {
            throw new InputsVaciosException("Debe llenar todos los campos");
        } else {
            if (buscarLibroPorCodigo(codigoLibro) != null) {
                throw new InputsVaciosException("El libro ya existe con el codigo" + codigoLibro);
            } else if (buscarLibroPorTitulo(titulo) != null) {
                throw new InputsVaciosException("Ya se ha registrado un libro con ese Titulo" + titulo);
            } else {
                Libro nuevoLibro = new Libro(titulo, autor, codigoLibro, cantidadLibro, fechaPublicacion);
                biblioteca.getLibros().add(nuevoLibro);
                try {
                    manejadorDatos.guardarLista(biblioteca.getLibros(), archivoLibros);
                } catch (Exception e) {
                }
                return nuevoLibro;
            }
        }
    }

    public List<Libro> consultaLibros() {
        return librosBuscados;
    }

    public List<Libro> listadoLibrosPorCodigo(String codigoLibro) {
        librosBuscados.clear();
        librosBuscados.add(buscarLibroPorCodigo(codigoLibro));
        return librosBuscados;
    }

    public Libro buscarLibroPorCodigo(String codigoLibro) {
        for (Libro librosBusqueda : biblioteca.getLibros()) {
            if (librosBusqueda.getCodigoLibro().equalsIgnoreCase(codigoLibro)) {
                return librosBusqueda;
            }
        }
        return null;
    }

    public List<Libro> listadoLibrosPorAutor(String autor) {
        librosBuscados.clear();
        librosBuscados.add(buscarLibroPorAutor(autor));
        return librosBuscados;
    }

    public Libro buscarLibroPorAutor(String autor) {
        for (Libro librosBusqueda : biblioteca.getLibros()) {
            if (librosBusqueda.getAutor().equalsIgnoreCase(autor)) {
                return librosBusqueda;
            }
        }
        return null;
    }

    public List<Libro> listadoLibrosPorTitulo(String Titulo) {
        librosBuscados.clear();
        librosBuscados.add(buscarLibroPorTitulo(Titulo));
        return librosBuscados;
    }

    public Libro buscarLibroPorTitulo(String Titulo) {
        for (Libro librosBusqueda : biblioteca.getLibros()) {
            if (librosBusqueda.getTitulo().equalsIgnoreCase(Titulo)) {
                return librosBusqueda;
            }
        }
        return null;
    }

    public List<Libro> listadoLibrosPorFechaPublicacion(LocalDate FechaPublicacion) {
        librosBuscados.clear();
        librosBuscados.add(buscarLibroPorFechaPublicacion(FechaPublicacion));
        return librosBuscados;
    }

    public Libro buscarLibroPorFechaPublicacion(LocalDate FechaPublicacion) {
        for (Libro librosBusqueda : biblioteca.getLibros()) {
            if (librosBusqueda.getFechaPublicacion().equals(FechaPublicacion)) {
                return librosBusqueda;
            }
        }
        return null;
    }
}
