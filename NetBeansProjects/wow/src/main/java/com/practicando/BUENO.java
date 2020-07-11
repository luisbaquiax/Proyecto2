/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practicando;

/**
 *
 * @author Luis
 */
public class BUENO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cuadro = ""
                + "+++++++++++++\n"
                + "+++++++++++++\n"
                + "+++++++++++++\n"
                + "+++++++++++++\n"
                + "+++++++++++++\n";
        System.out.println(cuadro);
        
        String[][] cuadros = new String[2][2];
        
        for (int i = 0; i < cuadros.length; i++) {

            for (int j = 0; j < cuadros.length; j++) {
                cuadros[i][j] = cuadro;
            }
            System.out.println("");
        }
        System.out.println("");
        for (int i = 0; i < cuadros.length; i++) {

            for (int j = 0; j < cuadros.length; j++) {
                System.out.print(cuadros[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
}
