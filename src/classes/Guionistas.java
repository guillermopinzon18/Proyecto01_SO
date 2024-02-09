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
 * @author Guillermo Pinzon
 */
public class Guionistas extends Thread {

    public static int guionesSubidosDriveA = 0;
    public static int guionesSubidosDriveB = 0;
    int sueldoPorHora;
    Semaphore driveGuion;
    boolean activo;
    int diasParaGenerar;
    int totalPay;
    String studio;
    
    public Guionistas(Semaphore driveGuion, int totalPay, int diasParaGenerar, String studio, boolean activo) {
    
        this.sueldoPorHora = 20;
        this.driveGuion = driveGuion;
        this.totalPay = totalPay;
        this.activo = activo;
        this.diasParaGenerar = diasParaGenerar;
        this.studio = studio;
        
    }
    
    public void payDayGuionistas() {
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
            if (driveGuion.availablePermits() > 0) {
                driveGuion.acquire(1);
                guionesSubidosDriveA++; // Incrementa el contador 
                Nickelodeon.actualizarGuionesEnDrive(guionesSubidosDriveA);
            } else {
                System.out.println("Drive GUIONES Lleno esperando libere espacio.");
            }
        } else {
            if (driveGuion.availablePermits() > 0) {
                driveGuion.acquire(1);
                guionesSubidosDriveB++;
                DisneyChannel.actualizarGuionesEnDrive(guionesSubidosDriveB);
            } else {
                System.out.println("Drive GUIONES lleno. Esperando a que se libere espacio.");
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
                    payDayGuionistas();
                    count++;
                }
                generarGuion();
            } catch (InterruptedException ex) {
                System.out.println("TESTTT2");

            }
        }
    }

    public static int getGuionesSubidosDriveA() {
        return guionesSubidosDriveA;
    }

    public static void setGuionesSubidosDriveA(int guionesSubidosDriveA) {
        Guionistas.guionesSubidosDriveA -= guionesSubidosDriveA;
    }

    public static int getGuionesSubidosDriveB() {
        return guionesSubidosDriveB;
    }

    public static void setGuionesSubidosDriveB(int guionesSubidosDriveB) {
        Guionistas.guionesSubidosDriveB -= guionesSubidosDriveB;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
    
    
}
