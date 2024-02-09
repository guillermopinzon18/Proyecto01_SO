/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import interfaz.DisneyChannel;
import interfaz.Nickelodeon;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian Rodriguez
 */
public class Director extends Thread {

    Semaphore daysRemaining;
    private float totalIncome;
    int rand1;
    int rand2;
    String studio;
    int sueldoPorHora;
    static int ingresoA;
    static int ingresoB;
    String estado;
    int faltasCounterA;
    int faltasCounterB;
    static int descontadoPmA;
    static int descontadoPmB;

    public Director(Semaphore daysRemaining, String studio) {
        this.studio = studio;
        this.daysRemaining = daysRemaining;
        this.totalIncome = 0;
        this.sueldoPorHora = 60;
        this.estado = "Labores administrativas";
        this.ingresoA = 0;
        this.ingresoB = 0;
        this.faltasCounterA = 0;
        this.faltasCounterB = 0;
        this.descontadoPmA = 0;
        this.descontadoPmB = 0;
    }

    public void payDayDirector() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("A".equals(studio)) {
            NickelodeonStudio.totalPayA += salario;
        } else {
            DisneyStudio.totalPayB += salario;
        }
    }

    public void checkPM() {

        if ("A".equals(studio)) {
            Nickelodeon.actualizarEstadoDirectorA("Vigilando P.M.");
        } else {
            DisneyChannel.actualizarEstadoDirectorB("Vigilando P.M.");
        }
        if (ProjectManager.isWatchingAnime == true) {

            if ("A".equals(studio)) {
                faltasCounterA++;
                descontadoPmA -= 100;
                Nickelodeon.faltasPM.setText(Integer.toString(faltasCounterA));
                Nickelodeon.descontadoPM.setText(Integer.toString(descontadoPmA));
                Nickelodeon.actualizarEstadoDirectorA("Labores administrativas");
            } else {
                faltasCounterB++;
                descontadoPmB -= 100;
                DisneyChannel.faltasPM.setText(Integer.toString(faltasCounterB));
                DisneyChannel.descontadoPM.setText(Integer.toString(descontadoPmB));
                DisneyChannel.estadoDirector.setText("Labores administrativas");
            }

        }
    }

    public void trabajoAdministrativo() {
        try {
            int randomN = new Random().nextInt(1000);
            Thread.sleep(randomN);
            checkPM();
            Thread.sleep((1000 - randomN));
            payDayDirector();

        } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void entregarCapitulos() {

        if ("A".equals(studio)) {
            ingresoA += Ensambladores.countCapitulosGeneradosA * 450000;
            ingresoA += Ensambladores.countCapitulosPlotTGeneradosA * 500000;
            Ensambladores.countCapitulosGeneradosA = 0;
            Nickelodeon.actualizarCapitulosGenerados(Ensambladores.countCapitulosGeneradosA);
            Ensambladores.countCapitulosPlotTGeneradosA = 0;
            Nickelodeon.actualizarCapitulosPlotTGenerados(Ensambladores.countCapitulosPlotTGeneradosA);
            daysRemaining.release(NickelodeonStudio.diasRestantesA);  //Resetea Dias Restantes 
            Nickelodeon.estadoDirector.setText("Labores administrativas");
        } else {
            ingresoB += Ensambladores.countCapitulosGeneradosB * 250000;
            ingresoB += Ensambladores.countCapitulosPlotTGeneradosB * 600000;
            Ensambladores.countCapitulosGeneradosB = 0;
            DisneyChannel.actualizarCapitulosGenerados(Ensambladores.countCapitulosGeneradosB);
            Ensambladores.countCapitulosPlotTGeneradosB = 0;
            DisneyChannel.actualizarCapitulosPlotTGenerados(Ensambladores.countCapitulosPlotTGeneradosB);
            daysRemaining.release(DisneyStudio.diasRestantesB);  //Resetea Dias Restantes 
            DisneyChannel.estadoDirector.setText("Labores administrativas");
        }

    }

    @Override
    public void run() {
        while (true) {

            try {
                if ("A".equals(studio)) {
                    if (daysRemaining.availablePermits() == 0) {

                        Nickelodeon.actualizarEstadoDirectorA("Entregando Juegos");
                        Thread.sleep(1000);  //PASA UN DIA
                        payDayDirector();
                        entregarCapitulos();
                    } else {
                        trabajoAdministrativo();
                    }
                } else {
                    if (daysRemaining.availablePermits() == 0) {

                        DisneyChannel.actualizarEstadoDirectorB("Entregando Juegos");
                        Thread.sleep(1000);  //PASA UN DIA
                        payDayDirector();
                        entregarCapitulos();
                    } else {
                        trabajoAdministrativo();
                    }
                }
            } catch (InterruptedException ex) {
                System.out.println("TESTTT2");

            }
        }

    }

}
