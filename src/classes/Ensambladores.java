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
public class Ensambladores extends Thread {

    public static int countCapitulosGeneradosA = 0;
    public static int countCapitulosPlotTGeneradosA = 0;

    public static int countCapitulosGeneradosB = 0;
    public static int countCapitulosPlotTGeneradosB = 0;

    // Estudios para el cual trabaja
    String studio;

    // Drives 
    Semaphore driveGuion;
    Semaphore driveEscenarios;
    Semaphore driveAnimaciones;
    Semaphore driveDoblajes;
    Semaphore driveGuionPlotT;

    // Parametros propios del Integrador
    int sueldoPorHora;
    int totalPay;
    int diasParaGenerar;
    boolean activo;
    Semaphore driveCapitulos;
    public static int capitulosGeneradosTotalesA = 0;
    public static int capitulosGeneradosTotalesB = 0;
    int capitulosGenerados;
    int capitulosPlotTGenerados;
    int countCapitulos;

    // Parametros para capitulos
    int guionesNecesarios;
    int escenariosNecesarios;
    int animacionesNecesarios;
    int doblajesNecesarios;
    int plotTNecesarios;
    int gananciaPorCapitulo;

    public Ensambladores(Semaphore driveCapitulos, Semaphore driveGuion, Semaphore driveEscenarios, Semaphore driveAnimaciones, Semaphore driveDoblajes, Semaphore driveGuionPlotT, int capitulosGenerados, int capitulosPlotTGenerados, int diasParaGenerar, int guionesNecesarios, int escenariosNecesarios, int animacionesNecesarios, int doblajesNecesarios, int plotTNecesarios, String studio, boolean activo) {

        this.studio = studio;

        this.driveGuion = driveGuion;
        this.driveEscenarios = driveEscenarios;
        this.driveAnimaciones = driveAnimaciones;
        this.driveDoblajes = driveDoblajes;
        this.driveGuionPlotT = driveGuionPlotT;

        this.sueldoPorHora = 50;
        this.totalPay = 0;
        this.diasParaGenerar = diasParaGenerar;
        this.driveCapitulos = driveCapitulos;
        this.capitulosGenerados = capitulosGenerados;
        this.capitulosPlotTGenerados = capitulosPlotTGenerados;
        this.countCapitulos = 0;

        this.guionesNecesarios = guionesNecesarios;
        this.escenariosNecesarios = escenariosNecesarios;
        this.animacionesNecesarios = animacionesNecesarios;
        this.doblajesNecesarios = doblajesNecesarios;
        this.plotTNecesarios = plotTNecesarios;

    }

    public void payDayEnsamblador() {
        int horasTrabajadas = 24;
        int salario = sueldoPorHora * horasTrabajadas;
        if ("A".equals(studio)) {
            NickelodeonStudio.totalPayA += salario;
        } else {
            DisneyStudio.totalPayB += salario;
        }
    }

    public void generarCapitulo() {
        if ("A".equals(studio)) {
            // Guillermo
            if (countCapitulos == 5) {
                if (Guionistas.getGuionesSubidosDriveA() >= guionesNecesarios && DiseñadorEscenarios.getEscenariosSubidosDriveA() >= escenariosNecesarios && AnimadorDePersonajes.getAnimacionesSubidosDriveA() >= animacionesNecesarios && ActoresDeDoblaje.getDoblajesSubidosDriveA() >= doblajesNecesarios) {
                    try {
                        // Tiempo de armado (2 dias)
                        Thread.sleep(2000);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Guiones
                        driveGuion.release(guionesNecesarios);
                        Guionistas.setGuionesSubidosDriveA(guionesNecesarios);

                        // Escenarios
                        driveEscenarios.release(escenariosNecesarios);
                        DiseñadorEscenarios.setEscenariosSubidosDriveA(escenariosNecesarios);

                        // Animaciones
                        driveAnimaciones.release(animacionesNecesarios);
                        AnimadorDePersonajes.setAnimacionesSubidosDriveA(animacionesNecesarios);

                        // Doblajes
                        driveDoblajes.release(doblajesNecesarios);
                        ActoresDeDoblaje.setDoblajesSubidosDriveA(doblajesNecesarios);

                        // Guiones PlotT
                        driveGuionPlotT.release(plotTNecesarios);
                        GuionistasPlotTwist.setGuionesPlotTSubidosDriveA(plotTNecesarios);

                        countCapitulosPlotTGeneradosA++;
                        capitulosGeneradosTotalesA++;
                        Nickelodeon.actualizarCapitulosPlotTGenerados(countCapitulosPlotTGeneradosA);
                        countCapitulos = 0; // Se reinicia el contador de capitulos para poder contar otra vez la cantidad de capitulos necesarios para desarrollar uno con PlotT.
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para generar el Capitulo");
                }
            } else {
                if (Guionistas.getGuionesSubidosDriveA() >= guionesNecesarios && DiseñadorEscenarios.getEscenariosSubidosDriveA() >= escenariosNecesarios && AnimadorDePersonajes.getAnimacionesSubidosDriveA() >= animacionesNecesarios && ActoresDeDoblaje.getDoblajesSubidosDriveA() >= doblajesNecesarios) {
                    try {
                        // Tiempo de armado (2 dias)
                        Thread.sleep(2000);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Guiones
                        driveGuion.release(guionesNecesarios);
                        Guionistas.setGuionesSubidosDriveA(guionesNecesarios);

                        // Escenarios
                        driveEscenarios.release(escenariosNecesarios);
                        DiseñadorEscenarios.setEscenariosSubidosDriveA(escenariosNecesarios);

                        // Animaciones
                        driveAnimaciones.release(animacionesNecesarios);
                        AnimadorDePersonajes.setAnimacionesSubidosDriveA(animacionesNecesarios);

                        // Doblajes
                        driveDoblajes.release(doblajesNecesarios);
                        ActoresDeDoblaje.setDoblajesSubidosDriveA(doblajesNecesarios);

                        countCapitulosGeneradosA++;
                        capitulosGeneradosTotalesA++;
                        Nickelodeon.actualizarCapitulosGenerados(countCapitulosGeneradosA);
                        countCapitulos++;
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para generar el capitulo");
                }
            }
                Nickelodeon.actualizarCapitulosTotalesA(capitulosGeneradosTotalesA);
        } else {
            if (countCapitulos == 2) {
                if (Guionistas.getGuionesSubidosDriveB() >= guionesNecesarios && DiseñadorEscenarios.getEscenariosSubidosDriveB() >= escenariosNecesarios && AnimadorDePersonajes.getAnimacionesSubidosDriveB() >= animacionesNecesarios && ActoresDeDoblaje.getDoblajesSubidosDriveB() >= doblajesNecesarios) {
                    try {
                        // Tiempo de armado (2 dias)
                        Thread.sleep(2000);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Guiones
                        driveGuion.release(guionesNecesarios);
                        Guionistas.setGuionesSubidosDriveB(guionesNecesarios);

                        // Escenarios
                        driveEscenarios.release(escenariosNecesarios);
                        DiseñadorEscenarios.setEscenariosSubidosDriveB(escenariosNecesarios);

                        // Animaciones
                        driveAnimaciones.release(animacionesNecesarios);
                        AnimadorDePersonajes.setAnimacionesSubidosDriveB(animacionesNecesarios);

                        // Doblajes
                        driveDoblajes.release(doblajesNecesarios);
                        ActoresDeDoblaje.setDoblajesSubidosDriveB(doblajesNecesarios);

                        // Guiones PlotT
                        driveGuionPlotT.release(plotTNecesarios);
                        GuionistasPlotTwist.setGuionesPlotTSubidosDriveB(plotTNecesarios);

                        countCapitulosPlotTGeneradosB++;
                        capitulosGeneradosTotalesB++;
                        DisneyChannel.actualizarCapitulosPlotTGenerados(countCapitulosPlotTGeneradosB);
                        countCapitulos = 0; // Se reinicia el contador de capitulos para poder contar otra vez la cantidad de capitulos necesarios para desarrollar uno con PlotT.
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para generar el Capitulo");
                }
            } else {
                if (Guionistas.getGuionesSubidosDriveB() >= guionesNecesarios && DiseñadorEscenarios.getEscenariosSubidosDriveB() >= escenariosNecesarios && AnimadorDePersonajes.getAnimacionesSubidosDriveB() >= animacionesNecesarios && ActoresDeDoblaje.getDoblajesSubidosDriveB() >= doblajesNecesarios) {
                    try {
                        // Tiempo de armado (2 dias)
                        Thread.sleep(2000);

                        // LIBERAR Y ACTUALIZAR VALORES EN LA INTERFAZ
                        // Guiones
                        driveGuion.release(guionesNecesarios);
                        Guionistas.setGuionesSubidosDriveB(guionesNecesarios);

                        // Escenarios
                        driveEscenarios.release(escenariosNecesarios);
                        DiseñadorEscenarios.setEscenariosSubidosDriveB(escenariosNecesarios);

                        // Animaciones
                        driveAnimaciones.release(animacionesNecesarios);
                        AnimadorDePersonajes.setAnimacionesSubidosDriveB(animacionesNecesarios);

                        // Doblajes
                        driveDoblajes.release(doblajesNecesarios);
                        ActoresDeDoblaje.setDoblajesSubidosDriveB(doblajesNecesarios);

                        countCapitulosGeneradosB++;
                        capitulosGeneradosTotalesB++;
                        DisneyChannel.actualizarCapitulosGenerados(countCapitulosGeneradosB);
                        countCapitulos++;
                    } catch (InterruptedException ex) {
                        System.out.println("testttt");
                    }
                } else {
                    System.out.println("No hay recursos suficientes para generar el capitulo");
                }
            }
                DisneyChannel.actualizarCapitulosTotalesB(capitulosGeneradosTotalesB);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                payDayEnsamblador();
                generarCapitulo();
            } catch (InterruptedException ex) {
                System.out.println("TESTTTT Ensamblador catch");
            }
        }
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getCountCapitulos() {
        return countCapitulos;
    }

    public void setCountCapitulos(int countCapitulos) {
        this.countCapitulos = countCapitulos;
    }
    
    

}
