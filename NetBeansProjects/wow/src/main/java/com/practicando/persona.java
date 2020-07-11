
package com.practicando;

/**
 *
 * @author Usuario
 */
public class persona {

    String nombre;
    int edad;

    public persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String mostrarDatosPersona(){
        return "Nombre: "+this.getNombre()+" Edad: "+this.getEdad()+" Esto es una prueba";
    }
  
}
