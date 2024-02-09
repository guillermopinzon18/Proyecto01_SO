/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Sebastian Rodriguez
 */
public class NickelodeonStudio {

    public static int diasRestantesA = 30; // AGREGAR ESTO
    public static int totalPayA = 0;
    public static int ingresoA = 0;
    public static int utilidadA = ingresoA - totalPayA;
    public static int capitulosGeneradosA = 0;
    public static int capitulosPlotTGeneradosA = 0;

    // Capacidad de los drive
    static int capacidadDriveGuionA = 25;
    static int capacidadDriveEscenariosA = 20;
    static int capacidadDriveAnimacionesA = 55;
    static int capacidadDriveDoblajesA = 35;
    static int capacidadDriveGuionPlotTA = 10;

    // Semafotos de los drive de los desarrolladores.
    public static Semaphore driveGuionA = new Semaphore(capacidadDriveGuionA);
    public static Semaphore driveEscenariosA = new Semaphore(capacidadDriveEscenariosA);
    public static Semaphore driveAnimacionesA = new Semaphore(capacidadDriveAnimacionesA);
    public static Semaphore driveDoblajesA = new Semaphore(capacidadDriveDoblajesA);
    public static Semaphore driveGuionPlotTA = new Semaphore(capacidadDriveGuionPlotTA);
    public static Semaphore driveCapitulosA =  new Semaphore(Integer.MAX_VALUE);

    // Semaforo de los dias restantes:
    public static Semaphore diasRestantesSem = new Semaphore(diasRestantesA);

    final private boolean active = true;
    private int capitulosContador;
    private int dayDuration;
    private final Semaphore counterMutex = new Semaphore(1);

    int totalDayCounter = 0;

    // Contadores de empleados
    private static int trabajadorGuionCountA = 0;
    private static int trabajadorEscenarioCountA = 0;
    private static int trabajadorAnimacionCountA = 0;
    private static int trabajadorDoblajeCountA = 0;
    private static int trabajadorGuionPlotTCountA = 0;
    private static int ensambladoresCountA = 0;

    public NickelodeonStudio(int dayDuration, int daysUntilLaunch) {
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
    public static void crearGuionistas(Semaphore driveGuionA, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        Guionistas trabajadorGuionista = new Guionistas(driveGuionA, totalPay, diasParaGenerar, studio, activo);
        // Busca la primera posicion libre del arreglo.
        for (int i = 0; i < 11; i++) {
            if (trabajadoresGuionistas[i] == null) {
                trabajadoresGuionistas[i] = trabajadorGuionista;
                trabajadorGuionCountA++;
                trabajadorGuionista.start();
                break;
            }
        }
    }

    public static void stopGuionistaAleatorio() {
        if (trabajadorGuionCountA == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (trabajadoresGuionistas[indiceAleatorio] == null);

        Guionistas hilo = trabajadoresGuionistas[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + trabajadorGuionCountA);
            hilo.setActivo(false);
            trabajadoresGuionistas[indiceAleatorio] = null;
            trabajadorGuionCountA--;
        }
    }

    // Escenarios
    public static void crearDiseñadorEscenarios(Semaphore driveEscenariosA, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        DiseñadorEscenarios trabajadorEscenario = new DiseñadorEscenarios(driveEscenariosA, totalPay, diasParaGenerar, studio, activo);
        // Busca la primera posicion libre del arreglo.
        for (int i = 0; i < 11; i++) {
            if (trabajadoresEscenarios[i] == null) {
                trabajadoresEscenarios[i] = trabajadorEscenario;
                trabajadorEscenarioCountA++;
                trabajadorEscenario.start();
                break;
            }
        }
    }

    public static void stopDiseñadorEscenariosAleatorio() {
        if (trabajadorEscenarioCountA == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (trabajadoresEscenarios[indiceAleatorio] == null);

        DiseñadorEscenarios hilo = trabajadoresEscenarios[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + trabajadorEscenarioCountA);
            hilo.setActivo(false);
            trabajadoresEscenarios[indiceAleatorio] = null;
            trabajadorEscenarioCountA--;
        }
    }

    //Animaciones
    public static void crearAnimadorDePersonajes(Semaphore driveAnimacionesA, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        AnimadorDePersonajes trabajadorAnimacion = new AnimadorDePersonajes(driveAnimacionesA, totalPay, diasParaGenerar, studio, activo);
        // Busca la primera posicion libre del arreglo.
        for (int i = 0; i < 11; i++) {
            if (trabajadoresPersonajes[i] == null) {
                trabajadoresPersonajes[i] = trabajadorAnimacion;
                trabajadorAnimacionCountA++;
                trabajadorAnimacion.start();
                break;
            }
        }
    }

    public static void stopAnimadorDePersonajesAleatorio() {
        if (trabajadorAnimacionCountA == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (trabajadoresPersonajes[indiceAleatorio] == null);

        AnimadorDePersonajes hilo = trabajadoresPersonajes[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + trabajadorAnimacionCountA);
            hilo.setActivo(false);
            trabajadoresPersonajes[indiceAleatorio] = null;
            trabajadorAnimacionCountA--;
        }
    }

    // Doblajes
    public static void crearActoresDeDoblaje(Semaphore driveDoblajesA, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        ActoresDeDoblaje trabajadorDoblaje = new ActoresDeDoblaje(driveDoblajesA, totalPay, diasParaGenerar, studio, activo);
        // Busca la primera posicion libre del arreglo.
        for (int i = 0; i < 11; i++) {
            if (trabajadoresDoblaje[i] == null) {
                trabajadoresDoblaje[i] = trabajadorDoblaje;
                trabajadorDoblajeCountA++;
                trabajadorDoblaje.start();
                break;
            }
        }
    }

    public static void stopActoresDeDoblajeAleatorio() {
        if (trabajadorDoblajeCountA == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (trabajadoresDoblaje[indiceAleatorio] == null);

        ActoresDeDoblaje hilo = trabajadoresDoblaje[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + trabajadorDoblajeCountA);
            hilo.setActivo(false);
            trabajadoresDoblaje[indiceAleatorio] = null;
            trabajadorDoblajeCountA--;
        }
    }
    
    // PlotT
    public static void crearGuionistasPlotTwist(Semaphore driveGuionPlotTA, int totalPay, int diasParaGenerar, String studio, boolean activo) {
        GuionistasPlotTwist trabajadorGuionistaPlot = new GuionistasPlotTwist(driveGuionPlotTA, totalPay, diasParaGenerar, studio, activo);
        // Busca la primera posicion libre del arreglo.
        for (int i = 0; i < 11; i++) {
            if (trabajadoresPlotTwist[i] == null) {
                trabajadoresPlotTwist[i] = trabajadorGuionistaPlot;
                trabajadorGuionPlotTCountA++;
                trabajadorGuionistaPlot.start();
                break;
            }
        }
    }

    public static void stopGuionistasPlotTwistAleatorio() {
        if (trabajadorGuionPlotTCountA == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (trabajadoresPlotTwist[indiceAleatorio] == null);

        GuionistasPlotTwist hilo = trabajadoresPlotTwist[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + trabajadorGuionPlotTCountA);
            hilo.setActivo(false);
            trabajadoresPlotTwist[indiceAleatorio] = null;
            trabajadorGuionPlotTCountA--;
        }
    }
    
    // Ensambladores
    public static void crearEnsambladores(Semaphore driveCapitulosA, Semaphore driveGuionA, Semaphore driveEscenariosA, Semaphore driveAnimacionesA, Semaphore driveDoblajesA, Semaphore driveGuionPlotTA, int capitulosGeneradosA, int capitulosPlotTGeneradosA, int diasParaGenerar, int guionesNecesarios, int escenariosNecesarios, int animacionesNecesarios, int doblajesNecesarios, int plotTNecesarios, String studio, boolean activo) {
        Ensambladores ensamblador = new Ensambladores(driveCapitulosA, driveGuionA, driveEscenariosA, driveAnimacionesA, driveDoblajesA, driveGuionPlotTA, capitulosGeneradosA, capitulosPlotTGeneradosA, diasParaGenerar, guionesNecesarios, escenariosNecesarios, animacionesNecesarios, doblajesNecesarios, plotTNecesarios,  studio, activo);
        // Busca la primera posicion libre del arreglo.
        for (int i = 0; i < 11; i++) {
            if (ensambladores[i] == null) {
                ensambladores[i] = ensamblador;
                ensambladoresCountA++;
                ensamblador.start();
                break;
            }
        }
    }

    public static void stopEnsambladoresAleatorio() {
        if (ensambladoresCountA == 0) {
            return;
        }

        Random random = new Random();
        int indiceAleatorio;

        do {
            indiceAleatorio = random.nextInt(11); // Obtener un índice aleatorio
        } while (ensambladores[indiceAleatorio] == null);

        Ensambladores hilo = ensambladores[indiceAleatorio];

        if (hilo != null) {
            System.out.println("Cantidad de hilos antes de eliminar: " + ensambladoresCountA);
            hilo.setActivo(false);
            trabajadoresPlotTwist[indiceAleatorio] = null;
            ensambladoresCountA--;
        }
    }

}
