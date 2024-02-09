/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import classes.Director;
import classes.Funciones;
import classes.NickelodeonStudio;
import classes.ProjectManager;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Guillermo
 */
public class Nickelodeon extends javax.swing.JFrame {

    /**
     * Creates new form Nickelodeon1
     */
    private int valorSpinnerGuion;
    private int valorSpinnerEscenarios;
    private int valorSpinnerAnimador;
    private int valorSpinnerDoblajes;
    private int valorSpinnerGuionPlot;
    private int valorSpinnerEnsambladores;

    public Nickelodeon() {
        initComponents();

//        Nickelodeon.capitulosTotales.setText(Integer.toString(NickelodeonStudio.diasRestantesSem.availablePermits()));

        Director director = new Director(NickelodeonStudio.diasRestantesSem, "A");
        director.start();

        ProjectManager pm = new ProjectManager(NickelodeonStudio.diasRestantesSem, "A");
        pm.start();

        Funciones dia = new Funciones("A");
        dia.start();

        // Spinner Guionistas
        valorSpinnerGuion = (int) spinnerGuion.getValue();
        if (valorSpinnerGuion == 1) {
            NickelodeonStudio.crearGuionistas(NickelodeonStudio.driveGuionA, 0, 3, "A", true);
        }

        spinnerGuion.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerGuion.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesA.getText());
                if (nuevoValorSpinner > valorSpinnerGuion) {
                    if (desarrolladoresRestantes > 0) {
                        NickelodeonStudio.crearGuionistas(NickelodeonStudio.driveGuionA, 0, 3, "A", true);
                        int valorActual = Integer.parseInt(desarrolladoresRestantesA.getText());
                        valorActual--;
                        desarrolladoresRestantesA.setText(Integer.toString(valorActual));
                        valorSpinnerGuion = nuevoValorSpinner;
                    } else {
                        spinnerGuion.setValue(valorSpinnerGuion);
                    }
                } else if (nuevoValorSpinner < valorSpinnerGuion) {
                    NickelodeonStudio.stopGuionistaAleatorio();
                    int valorActual = Integer.parseInt(desarrolladoresRestantesA.getText());
                    valorActual++;
                    desarrolladoresRestantesA.setText(Integer.toString(valorActual));
                    valorSpinnerGuion = nuevoValorSpinner;
                }
            }
        });

        // Spinner Escenarios
        valorSpinnerEscenarios = (int) spinnerEscenarios.getValue();
        if (valorSpinnerEscenarios == 1) {
            NickelodeonStudio.crearDiseñadorEscenarios(NickelodeonStudio.driveEscenariosA, 0, 3, "A", true);
        }

        spinnerEscenarios.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerEscenarios.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesA.getText());
                if (nuevoValorSpinner > valorSpinnerEscenarios) {
                    if (desarrolladoresRestantes > 0) {
                        NickelodeonStudio.crearDiseñadorEscenarios(NickelodeonStudio.driveEscenariosA, 0, 3, "A", true);
                        int valorActual = Integer.parseInt(desarrolladoresRestantesA.getText());
                        valorActual--;
                        desarrolladoresRestantesA.setText(Integer.toString(valorActual));
                        valorSpinnerEscenarios = nuevoValorSpinner;
                    } else {
                        spinnerEscenarios.setValue(valorSpinnerEscenarios);
                    }
                } else if (nuevoValorSpinner < valorSpinnerEscenarios) {
                    NickelodeonStudio.stopDiseñadorEscenariosAleatorio();
                    int valorActual = Integer.parseInt(desarrolladoresRestantesA.getText());
                    valorActual++;
                    desarrolladoresRestantesA.setText(Integer.toString(valorActual));
                    valorSpinnerEscenarios = nuevoValorSpinner;
                }
            }
        });

        // Spinner Animador de Personajes
        valorSpinnerAnimador = (int) spinnerPersonajes.getValue();
        if (valorSpinnerAnimador == 1) {
            NickelodeonStudio.crearAnimadorDePersonajes(NickelodeonStudio.driveAnimacionesA, 0, 1, "A", true);
        }

        spinnerPersonajes.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerPersonajes.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesA.getText());
                if (nuevoValorSpinner > valorSpinnerAnimador) {
                    if (desarrolladoresRestantes > 0) {
                        NickelodeonStudio.crearAnimadorDePersonajes(NickelodeonStudio.driveAnimacionesA, 0, 1, "A", true);
                        int valorActual = Integer.parseInt(desarrolladoresRestantesA.getText());
                        valorActual--;
                        desarrolladoresRestantesA.setText(Integer.toString(valorActual));
                        valorSpinnerAnimador = nuevoValorSpinner;
                    } else {
                        spinnerPersonajes.setValue(valorSpinnerAnimador);
                    }
                } else if (nuevoValorSpinner < valorSpinnerAnimador) {
                    NickelodeonStudio.stopAnimadorDePersonajesAleatorio();
                    int valorActual = Integer.parseInt(desarrolladoresRestantesA.getText());
                    valorActual++;
                    desarrolladoresRestantesA.setText(Integer.toString(valorActual));
                    valorSpinnerAnimador = nuevoValorSpinner;
                }
            }
        });

        // Spinner Doblajes
        valorSpinnerDoblajes = (int) spinnerDoblajes.getValue();
        if (valorSpinnerDoblajes == 1) {
            NickelodeonStudio.crearActoresDeDoblaje(NickelodeonStudio.driveDoblajesA, 0, 1, "A", true);
        }

        spinnerDoblajes.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerDoblajes.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesA.getText());
                if (nuevoValorSpinner > valorSpinnerDoblajes) {
                    if (desarrolladoresRestantes > 0) {
                        NickelodeonStudio.crearActoresDeDoblaje(NickelodeonStudio.driveDoblajesA, 0, 1, "A", true);
                        int valorActual = Integer.parseInt(desarrolladoresRestantesA.getText());
                        valorActual--;
                        desarrolladoresRestantesA.setText(Integer.toString(valorActual));
                        valorSpinnerDoblajes = nuevoValorSpinner;
                    } else {
                        spinnerDoblajes.setValue(valorSpinnerDoblajes);
                    }
                } else if (nuevoValorSpinner < valorSpinnerDoblajes) {
                    NickelodeonStudio.stopActoresDeDoblajeAleatorio();
                    int valorActual = Integer.parseInt(desarrolladoresRestantesA.getText());
                    valorActual++;
                    desarrolladoresRestantesA.setText(Integer.toString(valorActual));
                    valorSpinnerDoblajes = nuevoValorSpinner;
                }
            }
        });

        // Spinner Guionistas de PlotT
        valorSpinnerGuionPlot = (int) spinnerGuionPlot.getValue();
        if (valorSpinnerGuionPlot == 1) {
            NickelodeonStudio.crearGuionistasPlotTwist(NickelodeonStudio.driveGuionPlotTA, 0, 2, "A", true);
        }

        spinnerGuionPlot.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerGuionPlot.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesA.getText());
                if (nuevoValorSpinner > valorSpinnerGuionPlot) {
                    if (desarrolladoresRestantes > 0) {
                        NickelodeonStudio.crearGuionistasPlotTwist(NickelodeonStudio.driveGuionPlotTA, 0, 2, "A", true);
                        int valorActual = Integer.parseInt(desarrolladoresRestantesA.getText());
                        valorActual--;
                        desarrolladoresRestantesA.setText(Integer.toString(valorActual));
                        valorSpinnerGuionPlot = nuevoValorSpinner;
                    } else {
                        spinnerGuionPlot.setValue(valorSpinnerGuionPlot);
                    }
                } else if (nuevoValorSpinner < valorSpinnerGuionPlot) {
                    NickelodeonStudio.stopGuionistasPlotTwistAleatorio();
                    int valorActual = Integer.parseInt(desarrolladoresRestantesA.getText());
                    valorActual++;
                    desarrolladoresRestantesA.setText(Integer.toString(valorActual));
                    valorSpinnerGuionPlot = nuevoValorSpinner;
                }
            }
        });

        // Spinner Ensambladores
        valorSpinnerEnsambladores = (int) spinnerEnsamblador.getValue();
        if (valorSpinnerEnsambladores == 1) {
            NickelodeonStudio.crearEnsambladores(NickelodeonStudio.driveCapitulosA, NickelodeonStudio.driveGuionA, NickelodeonStudio.driveEscenariosA, NickelodeonStudio.driveAnimacionesA, NickelodeonStudio.driveDoblajesA, NickelodeonStudio.driveGuionPlotTA, NickelodeonStudio.capitulosGeneradosA, NickelodeonStudio.capitulosPlotTGeneradosA, 2, 2, 1, 4, 4, 2, "A", true);
        }

        spinnerEnsamblador.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerEnsamblador.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesA.getText());
                if (nuevoValorSpinner > valorSpinnerEnsambladores) {
                    if (desarrolladoresRestantes > 0) {
                        //FUNCION CREAR TRABAJADDOR
                        // Llama a la función para crear un trabajador
                        NickelodeonStudio.crearEnsambladores(NickelodeonStudio.driveCapitulosA, NickelodeonStudio.driveGuionA, NickelodeonStudio.driveEscenariosA, NickelodeonStudio.driveAnimacionesA, NickelodeonStudio.driveDoblajesA, NickelodeonStudio.driveGuionPlotTA, NickelodeonStudio.capitulosGeneradosA, NickelodeonStudio.capitulosPlotTGeneradosA, 2, 2, 1, 4, 4, 2, "A", true);
                        // Resta 1 a desarrolladoresRestantesB si el nuevo valor es mayor
                        int valorActual = Integer.parseInt(desarrolladoresRestantesA.getText());
                        valorActual--;
                        desarrolladoresRestantesA.setText(Integer.toString(valorActual));
                        valorSpinnerEnsambladores = nuevoValorSpinner;
                    } else {
                        spinnerEnsamblador.setValue(valorSpinnerEnsambladores);
                    }
                } else if (nuevoValorSpinner < valorSpinnerEnsambladores) {
                    //FUNCION STOP TRABAJADOR
                    NickelodeonStudio.stopEnsambladoresAleatorio();
                    // Suma 1 a desarrolladoresRestantesA si el nuevo valor es menor
                    int valorActual = Integer.parseInt(desarrolladoresRestantesA.getText());
                    valorActual++;
                    desarrolladoresRestantesA.setText(Integer.toString(valorActual));
                    valorSpinnerEnsambladores = nuevoValorSpinner;
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        guionesEnDriveA = new javax.swing.JLabel();
        animacionEnDriveA = new javax.swing.JLabel();
        doblajesEnDriveA = new javax.swing.JLabel();
        guionPlotEnDriveA = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        estadoPM = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        capitulosPlotGeneradosA = new javax.swing.JLabel();
        escenariosEnDriveA = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        desarrolladoresRestantesA = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        capitulosGeneradosA = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        costosOperativosA = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        ingresosBrutosA = new javax.swing.JLabel();
        gananciaA = new javax.swing.JLabel();
        capitulosTotales = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        spinnerEnsamblador = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        spinnerGuion = new javax.swing.JSpinner();
        spinnerEscenarios = new javax.swing.JSpinner();
        spinnerPersonajes = new javax.swing.JSpinner();
        spinnerDoblajes = new javax.swing.JSpinner();
        spinnerGuionPlot = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        faltasPM = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        descontadoPM = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        estadoDirector = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        diasParaEntrega = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        guionesEnDriveA.setText("0");
        jPanel1.add(guionesEnDriveA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 20, -1));

        animacionEnDriveA.setText("0");
        jPanel1.add(animacionEnDriveA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 20, -1));

        doblajesEnDriveA.setText("0");
        jPanel1.add(doblajesEnDriveA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 20, -1));

        guionPlotEnDriveA.setText("0");
        jPanel1.add(guionPlotEnDriveA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 20, 10));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, 20));

        estadoPM.setText("Estado del Pm");
        jPanel1.add(estadoPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 374, 120, 20));

        jLabel15.setText("Descontado");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("CAPITULOS GENERADOS");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("CON PLOT");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 620, -1, -1));

        capitulosPlotGeneradosA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        capitulosPlotGeneradosA.setForeground(new java.awt.Color(255, 255, 255));
        capitulosPlotGeneradosA.setText("0");
        jPanel1.add(capitulosPlotGeneradosA, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 620, 70, 20));

        escenariosEnDriveA.setText("0");
        jPanel1.add(escenariosEnDriveA, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 20, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Desarrolladores restantes:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, 20));

        desarrolladoresRestantesA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        desarrolladoresRestantesA.setText("11");
        jPanel1.add(desarrolladoresRestantesA, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 50, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Guionistas:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setText("Ir al Main");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 170, -1));

        jPanel5.setBackground(new java.awt.Color(255, 204, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51), 5));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        capitulosGeneradosA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        capitulosGeneradosA.setForeground(new java.awt.Color(255, 255, 255));
        capitulosGeneradosA.setText("0");
        jPanel5.add(capitulosGeneradosA, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 70, 20));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 290, 80));

        jPanel7.setBackground(new java.awt.Color(255, 204, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51), 5));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("COSTOS OPERATIVOS");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        costosOperativosA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        costosOperativosA.setForeground(new java.awt.Color(255, 255, 255));
        costosOperativosA.setText("0");
        jPanel7.add(costosOperativosA, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 130, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CAPITULOS TOTALES");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 130, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("GANANCIA");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("INGRESOS BRUTO");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 110, -1));

        ingresosBrutosA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ingresosBrutosA.setForeground(new java.awt.Color(255, 255, 255));
        ingresosBrutosA.setText("0");
        jPanel7.add(ingresosBrutosA, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 130, -1));

        gananciaA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        gananciaA.setForeground(new java.awt.Color(255, 255, 255));
        gananciaA.setText("0");
        jPanel7.add(gananciaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 130, 20));

        capitulosTotales.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        capitulosTotales.setForeground(new java.awt.Color(255, 255, 255));
        capitulosTotales.setText("0");
        jPanel7.add(capitulosTotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 50, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, 330, 160));

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0), 5));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ensambladores:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        spinnerEnsamblador.setValue(1);
        jPanel2.add(spinnerEnsamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 204, 51));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 240, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Diseñador de escenarios:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Animador de personajes:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Actores de doblaje:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Guionista de PlotTwist:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        spinnerGuion.setValue(1);
        jPanel2.add(spinnerGuion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        spinnerEscenarios.setValue(1);
        jPanel2.add(spinnerEscenarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        spinnerPersonajes.setValue(1);
        jPanel2.add(spinnerPersonajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        spinnerDoblajes.setValue(1);
        jPanel2.add(spinnerDoblajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        spinnerGuionPlot.setValue(1);
        jPanel2.add(spinnerGuionPlot, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, -1));

        jLabel14.setText("de 10");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        jLabel16.setText("de 25");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        jLabel18.setText("de 20");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        jLabel20.setText("de 55");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        jLabel22.setText("de 35");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Capacidades Drive");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 380, 250));

        jPanel4.setBackground(new java.awt.Color(255, 204, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51), 5));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Project Manager");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 100, 20));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Project Manager");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        faltasPM.setText("0");
        jPanel4.add(faltasPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 50, -1));

        jLabel13.setText("Faltas");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 40, -1));

        descontadoPM.setText("0");
        jPanel4.add(descontadoPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 70, -1));

        jLabel11.setText("ESTADO:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 200, 130));

        jPanel6.setBackground(new java.awt.Color(255, 204, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51), 5));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setText("ESTADO:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        estadoDirector.setText("ESTADO");
        jPanel6.add(estadoDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 200, 20));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Director");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 300, 80));

        jLabel28.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel28.setText("DIAS RESTANTES");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 180, -1));

        diasParaEntrega.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        diasParaEntrega.setText("0");
        jPanel1.add(diasParaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 30, -1));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/nick-rebrand-2023_5 (1).png"))); // NOI18N
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, -80, 1170, 820));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainInterface a = new MainInterface();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nickelodeon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nickelodeon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nickelodeon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nickelodeon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Nickelodeon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel animacionEnDriveA;
    public static javax.swing.JLabel capitulosGeneradosA;
    public static javax.swing.JLabel capitulosPlotGeneradosA;
    public static javax.swing.JLabel capitulosTotales;
    public static javax.swing.JLabel costosOperativosA;
    public static javax.swing.JLabel desarrolladoresRestantesA;
    public static javax.swing.JLabel descontadoPM;
    public static javax.swing.JLabel diasParaEntrega;
    public static javax.swing.JLabel doblajesEnDriveA;
    public static javax.swing.JLabel escenariosEnDriveA;
    public static javax.swing.JLabel estadoDirector;
    public static javax.swing.JLabel estadoPM;
    public static javax.swing.JLabel faltasPM;
    public static javax.swing.JLabel gananciaA;
    public static javax.swing.JLabel guionPlotEnDriveA;
    public static javax.swing.JLabel guionesEnDriveA;
    public static javax.swing.JLabel ingresosBrutosA;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public static javax.swing.JSpinner spinnerDoblajes;
    public static javax.swing.JSpinner spinnerEnsamblador;
    public static javax.swing.JSpinner spinnerEscenarios;
    public static javax.swing.JSpinner spinnerGuion;
    public static javax.swing.JSpinner spinnerGuionPlot;
    public static javax.swing.JSpinner spinnerPersonajes;
    // End of variables declaration//GEN-END:variables

    // METODOS PARA ACTUALIZAR EN LA INTERFAZ:
    public static void actualizarGuionesEnDrive(int nuevoValor) {
        guionesEnDriveA.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarEscenariosEnDrive(int nuevoValor) {
        escenariosEnDriveA.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarAnimadorPersonajesEnDrive(int nuevoValor) {
        animacionEnDriveA.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarDoblajeEnDrive(int nuevoValor) {
        doblajesEnDriveA.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarGuionesPlotTEnDrive(int nuevoValor) {
        guionPlotEnDriveA.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarEstadoPMA(String nuevoValor) {
        estadoPM.setText(nuevoValor);
    }

    public static void actualizarDiasParaLaEntregaA(int nuevoValor) {
        diasParaEntrega.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarEstadoDirectorA(String nuevoValor) {
        estadoDirector.setText(nuevoValor);
    }

    public static void actualizarCapitulosPlotTGenerados(int nuevoValor) {
        capitulosPlotGeneradosA.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarCapitulosGenerados(int nuevoValor) {
        capitulosGeneradosA.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarCapitulosTotalesA(int nuevoValor) {
        capitulosTotales.setText(Integer.toString(nuevoValor));
    }

    public int getValorSpinnerGuion() {
        return valorSpinnerGuion;
    }

    public void setValorSpinnerGuion(int valorSpinnerGuion) {
        this.valorSpinnerGuion = valorSpinnerGuion;
    }

    public int getValorSpinnerEscenarios() {
        return valorSpinnerEscenarios;
    }

    public void setValorSpinnerEscenarios(int valorSpinnerEscenarios) {
        this.valorSpinnerEscenarios = valorSpinnerEscenarios;
    }

    public int getValorSpinnerAnimador() {
        return valorSpinnerAnimador;
    }

    public void setValorSpinnerAnimador(int valorSpinnerAnimador) {
        this.valorSpinnerAnimador = valorSpinnerAnimador;
    }

    public int getValorSpinnerDoblajes() {
        return valorSpinnerDoblajes;
    }

    public void setValorSpinnerDoblajes(int valorSpinnerDoblajes) {
        this.valorSpinnerDoblajes = valorSpinnerDoblajes;
    }

    public int getValorSpinnerGuionPlot() {
        return valorSpinnerGuionPlot;
    }

    public void setValorSpinnerGuionPlot(int valorSpinnerGuionPlot) {
        this.valorSpinnerGuionPlot = valorSpinnerGuionPlot;
    }

    public int getValorSpinnerEnsambladores() {
        return valorSpinnerEnsambladores;
    }

    public void setValorSpinnerEnsambladores(int valorSpinnerEnsambladores) {
        this.valorSpinnerEnsambladores = valorSpinnerEnsambladores;
    }

    public JLabel getAnimacionEnDriveA() {
        return animacionEnDriveA;
    }

    public void setAnimacionEnDriveA(JLabel animacionEnDriveA) {
        this.animacionEnDriveA = animacionEnDriveA;
    }

    public JLabel getCapitulosGeneradosA() {
        return capitulosGeneradosA;
    }

    public void setCapitulosGeneradosA(JLabel capitulosGeneradosA) {
        this.capitulosGeneradosA = capitulosGeneradosA;
    }

    public JLabel getCapitulosPlotGeneradosA() {
        return capitulosPlotGeneradosA;
    }

    public void setCapitulosPlotGeneradosA(JLabel capitulosPlotGeneradosA) {
        this.capitulosPlotGeneradosA = capitulosPlotGeneradosA;
    }

    public JLabel getCostosOperativosA() {
        return costosOperativosA;
    }

    public void setCostosOperativosA(JLabel costosOperativosA) {
        this.costosOperativosA = costosOperativosA;
    }

    public JLabel getDescontadoPM() {
        return descontadoPM;
    }

    public void setDescontadoPM(JLabel descontadoPM) {
        this.descontadoPM = descontadoPM;
    }

    public static JLabel getDiasParaEntrega() {
        return capitulosTotales;
    }

    public static void setDiasParaEntrega(JLabel diasParaEntrega) {
        Nickelodeon.capitulosTotales = diasParaEntrega;
    }

    public JLabel getDoblajesEnDriveA() {
        return doblajesEnDriveA;
    }

    public void setDoblajesEnDriveA(JLabel doblajesEnDriveA) {
        this.doblajesEnDriveA = doblajesEnDriveA;
    }

    public JLabel getEscenariosEnDriveA() {
        return escenariosEnDriveA;
    }

    public void setEscenariosEnDriveA(JLabel escenariosEnDriveA) {
        this.escenariosEnDriveA = escenariosEnDriveA;
    }

    public JLabel getEstadoDirector() {
        return estadoDirector;
    }

    public void setEstadoDirector(JLabel estadoDirector) {
        this.estadoDirector = estadoDirector;
    }

    public JLabel getEstadoPM() {
        return estadoPM;
    }

    public void setEstadoPM(JLabel estadoPM) {
        this.estadoPM = estadoPM;
    }

    public JLabel getFaltasPM() {
        return faltasPM;
    }

    public void setFaltasPM(JLabel faltasPM) {
        this.faltasPM = faltasPM;
    }

    public JLabel getGananciaA() {
        return gananciaA;
    }

    public void setGananciaA(JLabel gananciaA) {
        this.gananciaA = gananciaA;
    }

    public JLabel getGuionPlotA() {
        return guionPlotEnDriveA;
    }

    public void setGuionPlotA(JLabel guionPlotA) {
        this.guionPlotEnDriveA = guionPlotA;
    }

    public JLabel getGuionesEnDriveN() {
        return guionesEnDriveA;
    }

    public void setGuionesEnDriveN(JLabel guionesEnDriveN) {
        this.guionesEnDriveA = guionesEnDriveN;
    }

    public JLabel getIngresosBrutosA() {
        return ingresosBrutosA;
    }

    public void setIngresosBrutosA(JLabel ingresosBrutosA) {
        this.ingresosBrutosA = ingresosBrutosA;
    }

    public JSpinner getSpinnerDoblajes() {
        return spinnerDoblajes;
    }

    public void setSpinnerDoblajes(JSpinner spinnerDoblajes) {
        this.spinnerDoblajes = spinnerDoblajes;
    }

    public JSpinner getSpinnerEnsamblador() {
        return spinnerEnsamblador;
    }

    public void setSpinnerEnsamblador(JSpinner spinnerEnsamblador) {
        this.spinnerEnsamblador = spinnerEnsamblador;
    }

    public JSpinner getSpinnerEscenarios() {
        return spinnerEscenarios;
    }

    public void setSpinnerEscenarios(JSpinner spinnerEscenarios) {
        this.spinnerEscenarios = spinnerEscenarios;
    }

    public static JSpinner getSpinnerGuion() {
        return spinnerGuion;
    }

    public static void setSpinnerGuion(JSpinner spinnerGuion) {
        Nickelodeon.spinnerGuion = spinnerGuion;
    }

    public JSpinner getSpinnerGuionPlot() {
        return spinnerGuionPlot;
    }

    public void setSpinnerGuionPlot(JSpinner spinnerGuionPlot) {
        this.spinnerGuionPlot = spinnerGuionPlot;
    }

    public JSpinner getSpinnerPersonajes() {
        return spinnerPersonajes;
    }

    public void setSpinnerPersonajes(JSpinner spinnerPersonajes) {
        this.spinnerPersonajes = spinnerPersonajes;
    }

    public JLabel getDesarrolladoresRestantesA() {
        return desarrolladoresRestantesA;
    }

    public void setDesarrolladoresRestantesA(JLabel desarrolladoresRestantesA) {
        this.desarrolladoresRestantesA = desarrolladoresRestantesA;
    }

}
