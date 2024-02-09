/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import interfaz.DisneyChannel;
import interfaz.Nickelodeon;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Sebastian Rodriguez
 */
public class GuionistasPlotTwist extends Thread {

    public static int guionesPlotTSubidosDriveA = 0;
    public static int guionesPlotTSubidosDriveB = 0;
    int sueldoPorHora;
    Semaphore driveGuionPlotT;
    boolean activo;
    int diasParaGenerar;
    int totalPay;
    String studio;

    public GuionistasPlotTwist(Semaphore driveGuionPlotT, int totalPay, int diasParaGenerar, String studio, boolean activo) {

        this.sueldoPorHora = 34;
        this.driveGuionPlotT = driveGuionPlotT;
        this.totalPay = totalPay;
        this.activo = activo;
        this.diasParaGenerar = diasParaGenerar;
        this.studio = studio;

    }

    public void payDayGuionistasPlotT() {
        // Calcular el salario basado en las horas trabajadas y agregarlo al total de pago
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("A".equals(studio)) {
            NickelodeonStudio.totalPayA += salario;
        } else {
            DisneyStudio.totalPayB += salario; 
        }

    }

    private void generarGuion() throws InterruptedException {
        // Intento agregar el guion al drive
        if ("A".equals(studio)) {
            //Guillermo
            if (driveGuionPlotT.availablePermits() > 0) {
                driveGuionPlotT.acquire(1);
                guionesPlotTSubidosDriveA++; // Incrementa el contador 
                Nickelodeon.actualizarGuionesPlotTEnDrive(guionesPlotTSubidosDriveA);
            } else {
                System.out.println("Drive GUIONESPLOT Lleno esperando libere espacio.");
            }
        } else {
            if (driveGuionPlotT.availablePermits() > 0) {
                driveGuionPlotT.acquire(1);
                guionesPlotTSubidosDriveB++;
                DisneyChannel.actualizarGuionesPlotTEnDrive(guionesPlotTSubidosDriveB);
            } else {
                System.out.println("Drive GUIONESPLOT lleno. Esperando a que se libere espacio.");
            }
        }
    }

    @Override
    public void run() {
        while (activo) {
            try {
                int count = 0;

                while (count <= diasParaGenerar) {
                    Thread.sleep(1000);
                    payDayGuionistasPlotT();
                    count++;
                }
                generarGuion();
            } catch (InterruptedException ex) {
                System.out.println("TESTTT2");

            }
        }
    }

    public static int getGuionesPlotTSubidosDriveA() {
        return guionesPlotTSubidosDriveA;
    }

    public static void setGuionesPlotTSubidosDriveA(int guionesPlotTSubidosDriveA) {
        GuionistasPlotTwist.guionesPlotTSubidosDriveA -= guionesPlotTSubidosDriveA;
    }

    public static int getGuionesPlotTSubidosDriveB() {
        return guionesPlotTSubidosDriveB;
    }

    public static void setGuionesPlotTSubidosDriveB(int guionesPlotTSubidosDriveB) {
        GuionistasPlotTwist.guionesPlotTSubidosDriveB -= guionesPlotTSubidosDriveB;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
