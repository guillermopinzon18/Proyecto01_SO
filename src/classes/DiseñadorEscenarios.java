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
public class DiseñadorEscenarios extends Thread {

    public static int escenariosSubidosDriveA = 0;
    public static int escenariosSubidosDriveB = 0;

    int sueldoPorHora; // 26
    int totalPay;
    int diasParaGenerar;
    boolean activo;

    Semaphore driveEscenarios;

    String studio;

    public DiseñadorEscenarios(Semaphore driveEscenarios, int totalPay, int diasParaGenerar, String studio, boolean activo) {

        this.sueldoPorHora = 26;
        this.totalPay = totalPay;
        this.diasParaGenerar = diasParaGenerar;
        this.driveEscenarios = driveEscenarios;
        this.studio = studio;
        this.activo = activo;

    }

    public void payDayDiseñadorEscenarios() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("A".equals(studio)) {
            NickelodeonStudio.totalPayA += salario;
        } else {
            DisneyStudio.totalPayB += salario;
        }
    }

    public void generarEscenario() throws InterruptedException {

        if ("A".equals(studio)) {
            if (driveEscenarios.availablePermits() >= 1) {
                driveEscenarios.acquire(1);
                escenariosSubidosDriveA += 1;
                Nickelodeon.actualizarEscenariosEnDrive(escenariosSubidosDriveA);
            } else {
                System.out.println("Drive lleno ESCENARIOS ");
            }
        } else {
            if (driveEscenarios.availablePermits() >= 1) {
                driveEscenarios.acquire(1);
                escenariosSubidosDriveB += 1;
                DisneyChannel.actualizarEscenariosEnDrive(escenariosSubidosDriveB);
            } else {
                System.out.println("Drive lleno ESCENARIOS B");
            }
        }
    }

    @Override
    public void run() {
        while (activo) {
            try {

                Thread.sleep(1000);
                payDayDiseñadorEscenarios();
                generarEscenario();

            } catch (InterruptedException ex) {
                System.out.println("Metodo Run DiseñadorEscenarios Catch");
            }
        }
    }

    public static int getEscenariosSubidosDriveA() {
        return escenariosSubidosDriveA;
    }

    public static void setEscenariosSubidosDriveA(int escenariosSubidosDriveA) {
        DiseñadorEscenarios.escenariosSubidosDriveA -= escenariosSubidosDriveA;
    }

    public static int getEscenariosSubidosDriveB() {
        return escenariosSubidosDriveB;
    }

    public static void setEscenariosSubidosDriveB(int escenariosSubidosDriveB) {
        DiseñadorEscenarios.escenariosSubidosDriveB -= escenariosSubidosDriveB;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
