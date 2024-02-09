/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Guillermo Pinzon
 */
public class DisneyStudio {
    
    public static int diasRestantesB = 30; // AGREGAR ESTO
    public static int totalPayB = 0;
    public static int ingresoB = 0;
    public static int utilidadB = ingresoB - totalPayB;
    public static int capitulosGeneradosB = 0;
    public static int capitulosPlotTGeneradosB = 0;

    // Capacidad de los drive
    static int capacidadDriveGuionB = 25;
    static int capacidadDriveEscenariosB = 20;
    static int capacidadDriveAnimacionesB = 55;
    static int capacidadDriveDoblajesB = 35;
    static int capacidadDriveGuionPlotTB = 10;

    // Semafotos de los drive de los desarrolladores.
    public static Semaphore driveGuionB = new Semaphore(capacidadDriveGuionB);
    public static Semaphore driveEscenariosB = new Semaphore(capacidadDriveEscenariosB);
    public static Semaphore driveAnimacionesB = new Semaphore(capacidadDriveAnimacionesB);
    public static Semaphore driveDoblajesB = new Semaphore(capacidadDriveDoblajesB);
    public static Semaphore driveGuionPlotTB = new Semaphore(capacidadDriveGuionPlotTB);
    public static Semaphore driveCapitulosB =  new Semaphore(Integer.MAX_VALUE);

    // Semaforo de los dias restantes:
    public static Semaphore diasRestantesSem = new Semaphore(diasRestantesB);

    final private boolean active = true;
    private int capitulosContador;
    private int dayDuration;
    private final Semaphore counterMutex = new Semaphore(1);

    int totalDayCounter = 0;

    // Contadores de empleados
    private static int trabajadorGuionCountB = 0;
    private static int trabajadorEscenarioCountB = 0;
    private static int trabajadorAnimacionCountB = 0;
    private static int trabajadorDoblajeCountB = 0;
    private static int trabajadorGuionPlotTCountB = 0;
    private static int ensambladoresCountB = 0;

    public DisneyStudio(int dayDuration, int daysUntilLaunch) {
        this.dayDuration = dayDuration;
    }

    // Listas de trabajadores:
    private static Guionistas[] trabajadoresGuionistas = new Guionistas[11];
    private static DiseñadorEscenarios[] trabajadoresEscenarios = new DiseñadorEscenarios[11];
    private static AnimadorDePersonajes[] trabajadoresPersonajes = new AnimadorDePersonajes[11];
    private static ActoresDeDoblaje[] trabajadoresDoblaje = new ActoresDeDoblaje[11];
    private static GuionistasPlotTwist[] trabajadoresPlotTwist = new GuionistasPlotTwist[11];
    private static Ensambladores[] ensambladores = new Ensambladores[11];

    // Guionistas
    public static void crearGuionistas(Semaphore driveGuionB, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        Guionistas trabajadorGuionista = new Guionistas(driveGuionB, totalPay, diasParaGenerar, studio, activo);
        // Busca la primera posicion libre del arreglo.
        for (int i = 0; i < 11; i++) {
            if (trabajadoresGuionistas[i] == null) {
                trabajadoresGuionistas[i] = trabajadorGuionista;
                trabajadorGuionCountB++;
                trabajadorGuionista.start();
                break;
            }
        }
    }

    public static void stopGuionistaAleatorio() {
        if (trabajadorGuionCountB == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (trabajadoresGuionistas[indiceAleatorio] == null);

        Guionistas hilo = trabajadoresGuionistas[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + trabajadorGuionCountB);
            hilo.setActivo(false);
            trabajadoresGuionistas[indiceAleatorio] = null;
            trabajadorGuionCountB--;
        }
    }

    // Escenarios
    public static void crearDiseñadorEscenarios(Semaphore driveEscenariosB, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        DiseñadorEscenarios trabajadorEscenario = new DiseñadorEscenarios(driveEscenariosB, totalPay, diasParaGenerar, studio, activo);
        // Busca la primera posicion libre del arreglo.
        for (int i = 0; i < 11; i++) {
            if (trabajadoresEscenarios[i] == null) {
                trabajadoresEscenarios[i] = trabajadorEscenario;
                trabajadorEscenarioCountB++;
                trabajadorEscenario.start();
                break;
            }
        }
    }

    public static void stopDiseñadorEscenariosAleatorio() {
        if (trabajadorEscenarioCountB == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (trabajadoresEscenarios[indiceAleatorio] == null);

        DiseñadorEscenarios hilo = trabajadoresEscenarios[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + trabajadorEscenarioCountB);
            hilo.setActivo(false);
            trabajadoresEscenarios[indiceAleatorio] = null;
            trabajadorEscenarioCountB--;
        }
    }

    //Animaciones
    public static void crearAnimadorDePersonajes(Semaphore driveAnimacionesB, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        AnimadorDePersonajes trabajadorAnimacion = new AnimadorDePersonajes(driveAnimacionesB, totalPay, diasParaGenerar, studio, activo);
        // Busca la primera posicion libre del arreglo.
        for (int i = 0; i < 11; i++) {
            if (trabajadoresPersonajes[i] == null) {
                trabajadoresPersonajes[i] = trabajadorAnimacion;
                trabajadorAnimacionCountB++;
                trabajadorAnimacion.start();
                break;
            }
        }
    }

    public static void stopAnimadorDePersonajesAleatorio() {
        if (trabajadorAnimacionCountB == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (trabajadoresPersonajes[indiceAleatorio] == null);

        AnimadorDePersonajes hilo = trabajadoresPersonajes[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + trabajadorAnimacionCountB);
            hilo.setActivo(false);
            trabajadoresPersonajes[indiceAleatorio] = null;
            trabajadorAnimacionCountB--;
        }
    }

    // Doblajes
    public static void crearActoresDeDoblaje(Semaphore driveDoblajesB, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        ActoresDeDoblaje trabajadorDoblaje = new ActoresDeDoblaje(driveDoblajesB, totalPay, diasParaGenerar, studio, activo);
        // Busca la primera posicion libre del arreglo.
        for (int i = 0; i < 11; i++) {
            if (trabajadoresDoblaje[i] == null) {
                trabajadoresDoblaje[i] = trabajadorDoblaje;
                trabajadorDoblajeCountB++;
                trabajadorDoblaje.start();
                break;
            }
        }
    }

    public static void stopActoresDeDoblajeAleatorio() {
        if (trabajadorDoblajeCountB== 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (trabajadoresDoblaje[indiceAleatorio] == null);

        ActoresDeDoblaje hilo = trabajadoresDoblaje[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + trabajadorDoblajeCountB);
            hilo.setActivo(false);
            trabajadoresDoblaje[indiceAleatorio] = null;
            trabajadorDoblajeCountB--;
        }
    }
    
    // PlotT
    public static void crearGuionistasPlotTwist(Semaphore driveGuionPlotTB, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        GuionistasPlotTwist trabajadorGuionistaPlot = new GuionistasPlotTwist(driveGuionPlotTB, totalPay, diasParaGenerar, studio, activo);
        // Busca la primera posicion libre del arreglo.
        for (int i = 0; i < 11; i++) {
            if (trabajadoresPlotTwist[i] == null) {
                trabajadoresPlotTwist[i] = trabajadorGuionistaPlot;
                trabajadorGuionPlotTCountB++;
                trabajadorGuionistaPlot.start();
                break;
            }
        }
    }

    public static void stopGuionistasPlotTwistAleatorio() {
        if (trabajadorGuionPlotTCountB == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (trabajadoresPlotTwist[indiceAleatorio] == null);

        GuionistasPlotTwist hilo = trabajadoresPlotTwist[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + trabajadorGuionPlotTCountB);
            hilo.setActivo(false);
            trabajadoresPlotTwist[indiceAleatorio] = null;
            trabajadorGuionPlotTCountB--;
        }
    }
    
    // Ensambladores
    public static void crearEnsambladores(Semaphore driveCapitulosA, Semaphore driveGuionB, Semaphore driveEscenariosA, Semaphore driveAnimacionesA, Semaphore driveDoblajesA, Semaphore driveGuionPlotTA, int capitulosGeneradosA, int capitulosPlotTGeneradosA, int diasParaGenerar, int guionesNecesarios, int escenariosNecesarios, int animacionesNecesarios, int doblajesNecesarios, int plotTNecesarios, String studio, boolean activo) {
        Ensambladores ensamblador = new Ensambladores(driveCapitulosA, driveGuionB, driveEscenariosA, driveAnimacionesA, driveDoblajesA, driveGuionPlotTA, capitulosGeneradosA, capitulosPlotTGeneradosA, diasParaGenerar, guionesNecesarios, escenariosNecesarios, animacionesNecesarios, doblajesNecesarios, plotTNecesarios,  studio, activo);
        // Busca la primera posicion libre del arreglo.
        for (int i = 0; i < 11; i++) {
            if (ensambladores[i] == null) {
                ensambladores[i] = ensamblador;
                ensambladoresCountB++;
                ensamblador.start();
                break;
            }
        }
    }

    public static void stopEnsambladoresAleatorio() {
        if (ensambladoresCountB == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (ensambladores[indiceAleatorio] == null);

        Ensambladores hilo = ensambladores[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + ensambladoresCountB);
            hilo.setActivo(false);
            trabajadoresPlotTwist[indiceAleatorio] = null;
            ensambladoresCountB--;
        }
    }
    
}
