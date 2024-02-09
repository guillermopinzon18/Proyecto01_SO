/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaz.DisneyChannel;
import interfaz.Nickelodeon;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillermo
 */
public class Funciones extends Thread {

    boolean activo;
    String studio;

    public Funciones(String studio) {
        this.activo = true;
        this.studio = studio;

    }

    @Override
    public void run() {
        while (activo) 
        try {
            Thread.sleep(1002);
            if ("A".equals(studio)) {
                Nickelodeon.costosOperativosA.setText(Integer.toString((NickelodeonStudio.totalPayA) + Director.descontadoPmA));
                Nickelodeon.gananciaA.setText(Integer.toString(Director.ingresoA - NickelodeonStudio.totalPayA + Math.abs(Director.descontadoPmA)));
                Nickelodeon.ingresosBrutosA.setText(Integer.toString(Director.ingresoA));
            } else {
                DisneyChannel.costosOperativosB.setText(Integer.toString((DisneyStudio.totalPayB) + Director.descontadoPmB));
                DisneyChannel.gananciaB.setText(Integer.toString(Director.ingresoB - DisneyStudio.totalPayB + Math.abs(Director.descontadoPmB)));
                DisneyChannel.ingresosBrutosB.setText(Integer.toString(Director.ingresoB));
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
