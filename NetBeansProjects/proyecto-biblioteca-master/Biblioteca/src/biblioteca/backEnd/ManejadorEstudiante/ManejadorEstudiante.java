package biblioteca.backEnd.ManejadorEstudiante;

import biblioteca.FrontIn.Biblioteca.Biblioteca;
import biblioteca.FrontIn.Excepciones.InputsVaciosException;
import biblioteca.backEnd.Estudiante.Estudiante;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.ValidationException;

/**
 *
 * @author angel
 */
public class ManejadorEstudiante {

    SimpleDateFormat dateformatJava = new SimpleDateFormat("yyyyMMdd");

    Estudiante estudiante;
    Biblioteca biblioteca;

    List<Estudiante> estudiantesBuscados = new LinkedList<>();

    public Estudiante agregarEstudiante(String nombre, String carnet, int codigoCarrera, LocalDate fechaCumple) throws InputsVaciosException, ValidationException {
        String pruebaNombre = nombre;
        String pruebaCarnet = carnet;
        String pruebaCodigoCarrera = String.valueOf(codigoCarrera);
        String pruebaFechaPublicacion = dateformatJava.format(fechaCumple);

        if (pruebaNombre.replace(" ", "").isEmpty()
                || pruebaCarnet.replace(" ", "").isEmpty()
                || pruebaCodigoCarrera.replace(" ", "").isEmpty()
                || pruebaFechaPublicacion.replace(" ", "").replace("-", "").isEmpty()) {
            throw new InputsVaciosException("Deben llenarse todos los campos!");
        } else {
            if (buscarEstudiantesPorNombre(nombre) != null) {
                throw new InputsVaciosException("Ya se ha registrado un estudiante con el nombre: " + nombre);
            } else if (buscarEstudiantePorCarnet(carnet) != null) {
                throw new InputsVaciosException("Ya existe un estudiante con el carnet: " + carnet);
            } else {
                Estudiante nuevoEstudiante = new Estudiante(nombre, carnet, codigoCarrera, fechaCumple);
                biblioteca.getEstudiante().add(nuevoEstudiante);
                return nuevoEstudiante;
            }
        }
    }

    public List<Estudiante> consultaEstudiantes() {
        return estudiantesBuscados;
    }

    public Estudiante buscarEstudiantesPorNombre(String nombre) {
        for (Estudiante busquedaEst : biblioteca.getEstudiante()) {
            if (busquedaEst.getNombre().equalsIgnoreCase(nombre)) {
                return busquedaEst;
            }
        }
        return null;
    }

    public List<Estudiante> listadoEstudiantesPorNombre(String nombre) {
        estudiantesBuscados.clear();
        estudiantesBuscados.add(buscarEstudiantesPorNombre(nombre));
        return estudiantesBuscados;
    }

    public Estudiante buscarEstudiantePorCarnet(String carnet) {
        for (Estudiante busquedaEst : biblioteca.getEstudiante()) {
            if (busquedaEst.getCarnet().equalsIgnoreCase(carnet)) {
                return busquedaEst;
            }
        }
        return null;
    }

    public List<Estudiante> listadoEstudiantePorCarnet(String carnet) {
        estudiantesBuscados.clear();
        estudiantesBuscados.add(buscarEstudiantePorCarnet(carnet));
        return estudiantesBuscados;
    }

    public Estudiante buscarEstudiantePorCarrera(int codigoCarrera) {
        for (Estudiante busquedaEst : biblioteca.getEstudiante()) {
            if (busquedaEst.getCodigoCarrera() == codigoCarrera) {
                return busquedaEst;
            }
        }
        return null;
    }

    public List<Estudiante> listadoEstudiantePoCarrera(int codigoCarrera) {
        estudiantesBuscados.clear();
        estudiantesBuscados.add(buscarEstudiantePorCarrera(codigoCarrera));
        return estudiantesBuscados;
    }
}
