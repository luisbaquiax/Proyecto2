package com.proyecto2.CosasUtiles;

/**
 *
 * @author Luis
 */
public class MetodosUtiles {

    /**
     * numero maximo = max, numero minimo = min
     *
     * @param max
     * @param min
     * @return
     */
  public int generarNumeroAleatorio(int max, int min) {
        int numero = (int) Math.floor(Math.random() * (max - min + 1) + (min));
        //int numero = (int) (Math.random() * (max-1) + (min));
        return numero;
    }
}
