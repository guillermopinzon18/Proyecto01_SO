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
public class ProjectManager extends Thread {

    Semaphore diasRestantesEntregaCapitulos;
    int totalPay;
    public static boolean isWatchingAnime;
    int sueldoPorHora;
    String studio;

    // Tiempos basados en que 1 dia de trabajo (24 horas) son 1000 milisegundos.
    int currentTime = 0;
    int streamInterval = 21; // 30 minutos en milisegundos
    int workInterval = 21; // 30 minutos en milisegundos
    int totalWorkTime = 666; // 16 horas en milisegundos 
    int totalDayTime = 1000; // 24 horas en milisegundos

    // Estados PM
    String estadoWork = "Trabajando";
    String estadoAnime = "Viendo anime";

    public ProjectManager(Semaphore diasRestantesEntregaCapitulos, String studio) {
        this.diasRestantesEntregaCapitulos = diasRestantesEntregaCapitulos;
        this.totalPay = 0;
        this.isWatchingAnime = false;
        this.sueldoPorHora = 40;
        this.studio = studio;
    }

    private void trabaja() {
        if ("A".equals(studio)) {
            try {
                isWatchingAnime = false;
                Nickelodeon.actualizarEstadoPMA(estadoWork);
                Thread.sleep(workInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                isWatchingAnime = false;
                DisneyChannel.actualizarEstadoPMB(estadoWork);
                Thread.sleep(workInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void veAnime() {
        if ("A".equals(studio)) {
            try {
                isWatchingAnime = true;
                Nickelodeon.actualizarEstadoPMA(estadoAnime);
                Thread.sleep(streamInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                isWatchingAnime = true;
                DisneyChannel.actualizarEstadoPMB(estadoAnime);
                Thread.sleep(streamInterval); // 30 minutos en milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void changeDaysRemaining() {
        try {
            if ("A".equals(studio)) {
                // Cambia el contador de días restantes
                diasRestantesEntregaCapitulos.acquire(1);
                Nickelodeon.actualizarDiasParaLaEntregaA(diasRestantesEntregaCapitulos.availablePermits());
                currentTime = 0;
            } else {
                // Cambia el contador de días restantes
                diasRestantesEntregaCapitulos.acquire(1);
                DisneyChannel.actualizarDiasParaLaEntregaB(diasRestantesEntregaCapitulos.availablePermits());
                currentTime = 0;
            }
            // Simula el tiempo que lleva cambiar el contador
            Thread.sleep(100); // Tiempo despreciable
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void payDayPM() {
        // Calcular el salario basado en las horas trabajadas y agregarlo al total de pago
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("A".equals(studio)) {
            NickelodeonStudio.totalPayA += salario;
        } else {
            DisneyStudio.totalPayB += salario;
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                while (currentTime < totalWorkTime) {
                    trabaja();
                    veAnime();
                    currentTime += (workInterval + streamInterval);
                }

                // Simula el paso del tiempo restante 
                int tiempoRestanteDia = totalDayTime - totalWorkTime;
                Thread.sleep(tiempoRestanteDia);

                changeDaysRemaining();
                payDayPM();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
