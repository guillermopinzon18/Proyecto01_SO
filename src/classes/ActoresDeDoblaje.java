/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import interfaz.DisneyChannel;
import interfaz.Nickelodeon;
import java.util.concurrent.Semaphore;

public class ActoresDeDoblaje extends Thread {

    public static int doblajesSubidosDriveA = 0;
    public static int doblajesSubidosDriveB = 0;

    int sueldoPorHora; // 16
    int totalPay;
    int diasParaGenerar;
    boolean activo;

    Semaphore driveDoblajes;

    String studio;

    public ActoresDeDoblaje(Semaphore driveDoblajes, int diasParaGenerar, int totalPay, String studio, boolean activo) {

        this.sueldoPorHora = 16;
        this.totalPay = totalPay;
        this.diasParaGenerar = diasParaGenerar;
        this.driveDoblajes = driveDoblajes;
        this.studio = studio;
        this.activo = activo;

    }

    public void payDayActoresDeDoblaje() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("A".equals(studio)) {
            NickelodeonStudio.totalPayA += salario;
        } else {
           DisneyStudio.totalPayB += salario;
        }
    }

    public void generarDoblaje() throws InterruptedException {
        if ("A".equals(studio)) {
            //Guillermo
            if (driveDoblajes.availablePermits() >= 5) {
                driveDoblajes.acquire(5);
                doblajesSubidosDriveA += 5;
                Nickelodeon.actualizarDoblajeEnDrive(doblajesSubidosDriveA);
            } else {
                System.out.println("Drive lleno DOBLAJEEEEE");
            }
        } else {
            if (driveDoblajes.availablePermits() >= 3) {
                driveDoblajes.acquire(3);
                doblajesSubidosDriveB += 3;
                DisneyChannel.actualizarDoblajeEnDrive(doblajesSubidosDriveB);
            } else {
                System.out.println("Drive lleno DOBLAJEEE B");
            }
        }
    }

    @Override
    public void run() {
        while (activo) {
            try {
                Thread.sleep(1000);
                payDayActoresDeDoblaje();
                generarDoblaje();
            } catch (InterruptedException ex) {
                System.out.println("Metodo run ActoresDeDoblaje Catch");
            }
        }
    }
    

    public static int getDoblajesSubidosDriveA() {
        return doblajesSubidosDriveA;
    }

    public static void setDoblajesSubidosDriveA(int doblajesSubidosDriveA) {
        ActoresDeDoblaje.doblajesSubidosDriveA -= doblajesSubidosDriveA;
    }

    public static int getDoblajesSubidosDriveB() {
        return doblajesSubidosDriveB;
    }

    public static void setDoblajesSubidosDriveB(int doblajesSubidosDriveB) {
        ActoresDeDoblaje.doblajesSubidosDriveB -= doblajesSubidosDriveB;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
