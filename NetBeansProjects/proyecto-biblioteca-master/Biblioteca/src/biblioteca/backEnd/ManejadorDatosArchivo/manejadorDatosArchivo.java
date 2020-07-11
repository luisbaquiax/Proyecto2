package biblioteca.backEnd.ManejadorDatosArchivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angel
 */
public class manejadorDatosArchivo<T> {

    public void guardarLista(List<T> listado, File Archivo) throws IOException {
        ObjectOutputStream salidaObj = null;
        try {
            FileOutputStream salida = new FileOutputStream(Archivo);
            salidaObj = new ObjectOutputStream(salida);
            salidaObj.writeObject(listado);
        } catch (FileNotFoundException ex) {
            throw new IOException(ex);
        } catch (IOException ex) {
            throw new IOException(ex);
        } finally {
            salidaObj.close();
        }
    }

    public List<T> cargarLista(File archivo) throws IOException {
        if (archivo.exists()) {
            FileInputStream entrada = new FileInputStream(archivo);
            ObjectInputStream entradaObj = new ObjectInputStream(entrada);
            try {
                return (List<T>) entradaObj.readObject();
            } catch (ClassNotFoundException ex) {
                throw new IOException(ex);
            } finally {
                entradaObj.close();
            }
        } else {
            return new ArrayList<>();
        }
    }

}
