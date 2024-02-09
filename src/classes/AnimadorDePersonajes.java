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
public class AnimadorDePersonajes extends Thread {

    public static int animacionesSubidosDriveA = 0;
    public static int animacionesSubidosDriveB = 0;

    int sueldoPorHora;
    Semaphore driveAnimaciones;
    boolean activo;
    int diasParaGenerar;
    int totalPay;
    String studio;

    public AnimadorDePersonajes(Semaphore driveAnimaciones, int totalPay, int diasParaGenerar, String studio, boolean activo) {

        this.sueldoPorHora = 40;
        this.driveAnimaciones = driveAnimaciones;
        this.totalPay = totalPay;
        this.activo = activo;
        this.diasParaGenerar = diasParaGenerar;
        this.studio = studio;

    }

    public void payDayAnimadorDePersonajes() {
        // Calcular el salario basado en las horas trabajadas y agregarlo al total de pago
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("A".equals(studio)) {
            NickelodeonStudio.totalPayA += salario;
        } else {
            DisneyStudio.totalPayB += salario;
        }

    }

    private void generarAnimacion() throws InterruptedException {
        if ("A".equals(studio)) {
            // Guillermo
            if (driveAnimaciones.availablePermits() > 2) {
                driveAnimaciones.acquire(2);
                animacionesSubidosDriveA++; // Incrementa el contador 
                Nickelodeon.actualizarAnimadorPersonajesEnDrive(animacionesSubidosDriveA);
            } else {
                System.out.println("Drive Animacion lleno. Esperando a que se libere espacio.");
            }
        } else {
            if (driveAnimaciones.availablePermits() > 3) {
                driveAnimaciones.acquire(3);
                animacionesSubidosDriveB++; // Incrementa el contador 
                DisneyChannel.actualizarAnimadorPersonajesEnDrive(animacionesSubidosDriveB);
            } else {
                System.out.println("Drive Animacion lleno. Esperando a que se libere espacio.");
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
                    payDayAnimadorDePersonajes();
                    count++;
                }
                generarAnimacion();
            } catch (InterruptedException ex) {
                System.out.println("TESTTT");
            }
        }
    }

    public static int getAnimacionesSubidosDriveA() {
        return animacionesSubidosDriveA;
    }

    public static void setAnimacionesSubidosDriveA(int animacionesSubidosDriveA) {
        AnimadorDePersonajes.animacionesSubidosDriveA -= animacionesSubidosDriveA;
    }

    public static int getAnimacionesSubidosDriveB() {
        return animacionesSubidosDriveB;
    }

    public static void setAnimacionesSubidosDriveB(int animacionesSubidosDriveB) {
        AnimadorDePersonajes.animacionesSubidosDriveB -= animacionesSubidosDriveB;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    

}
