/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import classes.Director;
import classes.DisneyStudio;
import classes.Funciones;
import classes.ProjectManager;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Guillermo
 */
public class DisneyChannel extends javax.swing.JFrame {

    private int valorSpinnerGuion;
    private int valorSpinnerEscenarios;
    private int valorSpinnerAnimador;
    private int valorSpinnerDoblajes;
    private int valorSpinnerGuionPlot;
    private int valorSpinnerEnsambladores;

    public DisneyChannel() {
        initComponents();

//        DisneyChannel.capitulosTotalesB.setText(Integer.toString(DisneyStudio.diasRestantesSem.availablePermits()));

        Director director = new Director(DisneyStudio.diasRestantesSem, "B");
        director.start();

        ProjectManager pm = new ProjectManager(DisneyStudio.diasRestantesSem, "B");
        pm.start();

        Funciones dia = new Funciones("B");
        dia.start();

        // Spinner Guionistas
        valorSpinnerGuion = (int) spinnerGuion.getValue();
        if (valorSpinnerGuion == 1) {
            DisneyStudio.crearGuionistas(DisneyStudio.driveGuionB, 0, 2, "B", true);
        }

        spinnerGuion.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerGuion.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesB.getText());
                if (nuevoValorSpinner > valorSpinnerGuion) {
                    if (desarrolladoresRestantes > 0) {
                        DisneyStudio.crearGuionistas(DisneyStudio.driveGuionB, 0, 2, "B", true);
                        int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                        valorActual--;
                        desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                        valorSpinnerGuion = nuevoValorSpinner;
                    } else {
                        spinnerGuion.setValue(valorSpinnerGuion);
                    }
                } else if (nuevoValorSpinner < valorSpinnerGuion) {
                    DisneyStudio.stopGuionistaAleatorio();
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual++;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                    valorSpinnerGuion = nuevoValorSpinner;
                }
            }
        });

        // Spinner Escenarios
        valorSpinnerEscenarios = (int) spinnerEscenarios.getValue();
        if (valorSpinnerEscenarios == 1) {
            DisneyStudio.crearDiseñadorEscenarios(DisneyStudio.driveEscenariosB, 0, 2, "B", true);
        }

        spinnerEscenarios.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerEscenarios.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesB.getText());
                if (nuevoValorSpinner > valorSpinnerEscenarios) {
                    if (desarrolladoresRestantes > 0) {
                        DisneyStudio.crearDiseñadorEscenarios(DisneyStudio.driveEscenariosB, 0, 2, "B", true);
                        int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                        valorActual--;
                        desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                        valorSpinnerEscenarios = nuevoValorSpinner;
                    } else {
                        spinnerEscenarios.setValue(valorSpinnerEscenarios);
                    }
                } else if (nuevoValorSpinner < valorSpinnerEscenarios) {
                    DisneyStudio.stopDiseñadorEscenariosAleatorio();
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual++;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                    valorSpinnerEscenarios = nuevoValorSpinner;
                }
            }
        });

        // Spinner Animador de Personajes
        valorSpinnerAnimador = (int) spinnerPersonajes.getValue();
        if (valorSpinnerAnimador == 1) {
            DisneyStudio.crearAnimadorDePersonajes(DisneyStudio.driveAnimacionesB, 0, 1, "B", true);
        }

        spinnerPersonajes.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerPersonajes.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesB.getText());
                if (nuevoValorSpinner > valorSpinnerAnimador) {
                    if (desarrolladoresRestantes > 0) {
                        DisneyStudio.crearAnimadorDePersonajes(DisneyStudio.driveAnimacionesB, 0, 1, "B", true);
                        int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                        valorActual--;
                        desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                        valorSpinnerAnimador = nuevoValorSpinner;
                    } else {
                        spinnerPersonajes.setValue(valorSpinnerAnimador);
                    }
                } else if (nuevoValorSpinner < valorSpinnerAnimador) {
                    DisneyStudio.stopAnimadorDePersonajesAleatorio();
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual++;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                    valorSpinnerAnimador = nuevoValorSpinner;
                }
            }
        });

        // Spinner Doblajes
        valorSpinnerDoblajes = (int) spinnerDoblajes.getValue();
        if (valorSpinnerDoblajes == 1) {
            DisneyStudio.crearActoresDeDoblaje(DisneyStudio.driveDoblajesB, 0, 1, "B", true);
        }

        spinnerDoblajes.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerDoblajes.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesB.getText());
                if (nuevoValorSpinner > valorSpinnerDoblajes) {
                    if (desarrolladoresRestantes > 0) {
                        DisneyStudio.crearActoresDeDoblaje(DisneyStudio.driveDoblajesB, 0, 1, "B", true);
                        int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                        valorActual--;
                        desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                        valorSpinnerDoblajes = nuevoValorSpinner;
                    } else {
                        spinnerDoblajes.setValue(valorSpinnerDoblajes);
                    }
                } else if (nuevoValorSpinner < valorSpinnerDoblajes) {
                    DisneyStudio.stopActoresDeDoblajeAleatorio();
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual++;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                    valorSpinnerDoblajes = nuevoValorSpinner;
                }
            }
        });

        // Spinner Guionistas de PlotT
        valorSpinnerGuionPlot = (int) spinnerGuionPlot.getValue();
        if (valorSpinnerGuionPlot == 1) {
            DisneyStudio.crearGuionistasPlotTwist(DisneyStudio.driveGuionPlotTB, 0, 3, "B", true);
        }

        spinnerGuionPlot.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerGuionPlot.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesB.getText());
                if (nuevoValorSpinner > valorSpinnerGuionPlot) {
                    if (desarrolladoresRestantes > 0) {
                        DisneyStudio.crearGuionistasPlotTwist(DisneyStudio.driveGuionPlotTB, 0, 3, "B", true);
                        int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                        valorActual--;
                        desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                        valorSpinnerGuionPlot = nuevoValorSpinner;
                    } else {
                        spinnerGuionPlot.setValue(valorSpinnerGuionPlot);
                    }
                } else if (nuevoValorSpinner < valorSpinnerGuionPlot) {
                    DisneyStudio.stopGuionistasPlotTwistAleatorio();
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual++;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                    valorSpinnerGuionPlot = nuevoValorSpinner;
                }
            }
        });

        // Spinner Ensambladores
        valorSpinnerEnsambladores = (int) spinnerEnsamblador.getValue();
        if (valorSpinnerEnsambladores == 1) {
            DisneyStudio.crearEnsambladores(DisneyStudio.driveCapitulosB, DisneyStudio.driveGuionB, DisneyStudio.driveEscenariosB, DisneyStudio.driveAnimacionesB, DisneyStudio.driveDoblajesB, DisneyStudio.driveGuionPlotTB, DisneyStudio.capitulosGeneradosB, DisneyStudio.capitulosPlotTGeneradosB, 2, 1, 1, 2, 4, 3, "B", true);
        }

        spinnerEnsamblador.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int nuevoValorSpinner = (int) spinnerEnsamblador.getValue();
                int desarrolladoresRestantes = Integer.parseInt(desarrolladoresRestantesB.getText());
                if (nuevoValorSpinner > valorSpinnerEnsambladores) {
                    if (desarrolladoresRestantes > 0) {
                        DisneyStudio.crearEnsambladores(DisneyStudio.driveCapitulosB, DisneyStudio.driveGuionB, DisneyStudio.driveEscenariosB, DisneyStudio.driveAnimacionesB, DisneyStudio.driveDoblajesB, DisneyStudio.driveGuionPlotTB, DisneyStudio.capitulosGeneradosB, DisneyStudio.capitulosPlotTGeneradosB, 2, 1, 1, 2, 4, 3, "B", true);
                        int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                        valorActual--;
                        desarrolladoresRestantesB.setText(Integer.toString(valorActual));
                        valorSpinnerEnsambladores = nuevoValorSpinner;
                    } else {
                        spinnerEnsamblador.setValue(valorSpinnerEnsambladores);
                    }
                } else if (nuevoValorSpinner < valorSpinnerEnsambladores) {
                    DisneyStudio.stopEnsambladoresAleatorio();
                    int valorActual = Integer.parseInt(desarrolladoresRestantesB.getText());
                    valorActual++;
                    desarrolladoresRestantesB.setText(Integer.toString(valorActual));
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
        jButton1 = new javax.swing.JButton();
        guionesEnDriveB = new javax.swing.JLabel();
        animacionEnDriveB = new javax.swing.JLabel();
        doblajesEnDriveB = new javax.swing.JLabel();
        guionPlotEnDriveB = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        estadoPM = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        faltasPM = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        descontadoPM = new javax.swing.JLabel();
        escenariosEnDriveB = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        desarrolladoresRestantesB = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        capitulosGeneradosB = new javax.swing.JLabel();
        capitulosPlotGeneradosB = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        costosOperativosB = new javax.swing.JLabel();
        capitulosTotalesB = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        ingresosBrutosB = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        gananciaB = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        diasParaEntrega = new javax.swing.JLabel();
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
        jLabel27 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        estadoDirector = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setText("Ir al Main");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, 170, -1));

        guionesEnDriveB.setText("0");
        jPanel1.add(guionesEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 20, -1));

        animacionEnDriveB.setText("0");
        jPanel1.add(animacionEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 20, -1));

        doblajesEnDriveB.setText("0");
        jPanel1.add(doblajesEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 20, -1));

        guionPlotEnDriveB.setText("0");
        jPanel1.add(guionPlotEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 20, 10));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, 20));

        jLabel11.setText("ESTADO:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        estadoPM.setText(" ESTADO");
        jPanel1.add(estadoPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 90, -1));

        jLabel13.setText("Faltas");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 40, -1));

        faltasPM.setText("0");
        jPanel1.add(faltasPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 30, -1));

        jLabel15.setText("Descontado");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        descontadoPM.setText("0");
        jPanel1.add(descontadoPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 30, -1));

        escenariosEnDriveB.setText("0");
        jPanel1.add(escenariosEnDriveB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 20, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Trabajadores restantes:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 200, 20));

        desarrolladoresRestantesB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        desarrolladoresRestantesB.setForeground(new java.awt.Color(255, 255, 255));
        desarrolladoresRestantesB.setText("6");
        jPanel1.add(desarrolladoresRestantesB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 50, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Guionistas:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 5));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("CAPITULOS GENERADOS");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("CON PLOT");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        capitulosGeneradosB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        capitulosGeneradosB.setForeground(new java.awt.Color(255, 255, 255));
        capitulosGeneradosB.setText("0");
        jPanel5.add(capitulosGeneradosB, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 70, 20));

        capitulosPlotGeneradosB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        capitulosPlotGeneradosB.setForeground(new java.awt.Color(255, 255, 255));
        capitulosPlotGeneradosB.setText("0");
        jPanel5.add(capitulosPlotGeneradosB, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 70, 20));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 290, 80));

        jPanel7.setBackground(new java.awt.Color(153, 153, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 5));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("CAPITULOS TOTALES");
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("COSTOS OPERATIVOS");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        costosOperativosB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        costosOperativosB.setForeground(new java.awt.Color(255, 255, 255));
        costosOperativosB.setText("0");
        jPanel7.add(costosOperativosB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 70, 10));

        capitulosTotalesB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        capitulosTotalesB.setForeground(new java.awt.Color(255, 255, 255));
        capitulosTotalesB.setText("0");
        jPanel7.add(capitulosTotalesB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 60, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("INGRESOS BRUTO");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, -1));

        ingresosBrutosB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ingresosBrutosB.setForeground(new java.awt.Color(255, 255, 255));
        ingresosBrutosB.setText("0");
        jPanel7.add(ingresosBrutosB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 70, 10));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("GANANCIA");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        gananciaB.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        gananciaB.setForeground(new java.awt.Color(255, 255, 255));
        gananciaB.setText("0");
        jPanel7.add(gananciaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 70, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DIAS PARA ENTREGA");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 130, 20));

        diasParaEntrega.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        diasParaEntrega.setForeground(new java.awt.Color(255, 255, 255));
        diasParaEntrega.setText("0");
        jPanel7.add(diasParaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 40, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 230, 150));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 5));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ensambladores:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        spinnerEnsamblador.setValue(1);
        jPanel2.add(spinnerEnsamblador, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));
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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 380, 250));

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 5));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Project Manager");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 100, 20));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Project Manager");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 200, 130));

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 5));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setText("ESTADO:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Director");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        estadoDirector.setText("ESTADO");
        jPanel6.add(estadoDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 200, 20));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 300, 80));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/disney+ (1).jpg"))); // NOI18N
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(-220, 0, 990, 570));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

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
            java.util.logging.Logger.getLogger(DisneyChannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisneyChannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisneyChannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisneyChannel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisneyChannel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel animacionEnDriveB;
    public static javax.swing.JLabel capitulosGeneradosB;
    public static javax.swing.JLabel capitulosPlotGeneradosB;
    public static javax.swing.JLabel capitulosTotalesB;
    public static javax.swing.JLabel costosOperativosB;
    public static javax.swing.JLabel desarrolladoresRestantesB;
    public static javax.swing.JLabel descontadoPM;
    public static javax.swing.JLabel diasParaEntrega;
    public static javax.swing.JLabel doblajesEnDriveB;
    public static javax.swing.JLabel escenariosEnDriveB;
    public static javax.swing.JLabel estadoDirector;
    public static javax.swing.JLabel estadoPM;
    public static javax.swing.JLabel faltasPM;
    public static javax.swing.JLabel gananciaB;
    public static javax.swing.JLabel guionPlotEnDriveB;
    public static javax.swing.JLabel guionesEnDriveB;
    public static javax.swing.JLabel ingresosBrutosB;
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
    private javax.swing.JLabel jLabel29;
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
        guionesEnDriveB.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarEscenariosEnDrive(int nuevoValor) {
        escenariosEnDriveB.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarAnimadorPersonajesEnDrive(int nuevoValor) {
        animacionEnDriveB.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarDoblajeEnDrive(int nuevoValor) {
        doblajesEnDriveB.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarGuionesPlotTEnDrive(int nuevoValor) {
        guionPlotEnDriveB.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarEstadoPMB(String nuevoValor) {
        estadoPM.setText(nuevoValor);
    }

    public static void actualizarDiasParaLaEntregaB(int nuevoValor) {
        diasParaEntrega.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarEstadoDirectorB(String nuevoValor) {
        estadoDirector.setText(nuevoValor);
    }

    public static void actualizarCapitulosPlotTGenerados(int nuevoValor) {
        capitulosPlotGeneradosB.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarCapitulosGenerados(int nuevoValor) {
        capitulosGeneradosB.setText(Integer.toString(nuevoValor));
    }

    public static void actualizarCapitulosTotalesB(int nuevoValor) {
        capitulosTotalesB.setText(Integer.toString(nuevoValor));
    }
    
    public static JLabel getJuegosTotalesB() {
        return capitulosTotalesB;
    }

    public static void setJuegosTotalesB(JLabel JuegosTotalesB) {
        DisneyChannel.capitulosTotalesB = JuegosTotalesB;
    }

    public static JLabel getAnimacionEnDriveB() {
        return animacionEnDriveB;
    }

    public static void setAnimacionEnDriveB(JLabel animacionEnDriveB) {
        DisneyChannel.animacionEnDriveB = animacionEnDriveB;
    }

    public static JLabel getCapitulosGeneradosB() {
        return capitulosGeneradosB;
    }

    public static void setCapitulosGeneradosB(JLabel capitulosGeneradosB) {
        DisneyChannel.capitulosGeneradosB = capitulosGeneradosB;
    }

    public static JLabel getCapitulosPlotGeneradosB() {
        return capitulosPlotGeneradosB;
    }

    public static void setCapitulosPlotGeneradosB(JLabel capitulosPlotGeneradosB) {
        DisneyChannel.capitulosPlotGeneradosB = capitulosPlotGeneradosB;
    }

    public static JLabel getCostosOperativosB() {
        return costosOperativosB;
    }

    public static void setCostosOperativosB(JLabel costosOperativosB) {
        DisneyChannel.costosOperativosB = costosOperativosB;
    }

    public static JLabel getDesarrolladoresRestantesB() {
        return desarrolladoresRestantesB;
    }

    public static void setDesarrolladoresRestantesB(JLabel desarrolladoresRestantesB) {
        DisneyChannel.desarrolladoresRestantesB = desarrolladoresRestantesB;
    }

    public static JLabel getDescontadoPM() {
        return descontadoPM;
    }

    public static void setDescontadoPM(JLabel descontadoPM) {
        DisneyChannel.descontadoPM = descontadoPM;
    }

    public static JLabel getDiasParaEntrega() {
        return diasParaEntrega;
    }

    public static void setDiasParaEntrega(JLabel diasParaEntrega) {
        DisneyChannel.diasParaEntrega = diasParaEntrega;
    }

    public static JLabel getDoblajesEnDriveB() {
        return doblajesEnDriveB;
    }

    public static void setDoblajesEnDriveB(JLabel doblajesEnDriveB) {
        DisneyChannel.doblajesEnDriveB = doblajesEnDriveB;
    }

    public static JLabel getEscenariosEnDriveB() {
        return escenariosEnDriveB;
    }

    public static void setEscenariosEnDriveB(JLabel escenariosEnDriveB) {
        DisneyChannel.escenariosEnDriveB = escenariosEnDriveB;
    }

    public static JLabel getEstadoDirector() {
        return estadoDirector;
    }

    public static void setEstadoDirector(JLabel estadoDirector) {
        DisneyChannel.estadoDirector = estadoDirector;
    }

    public static JLabel getEstadoPM() {
        return estadoPM;
    }

    public static void setEstadoPM(JLabel estadoPM) {
        DisneyChannel.estadoPM = estadoPM;
    }

    public static JLabel getFaltasPM() {
        return faltasPM;
    }

    public static void setFaltasPM(JLabel faltasPM) {
        DisneyChannel.faltasPM = faltasPM;
    }

    public static JLabel getGananciaB() {
        return gananciaB;
    }

    public static void setGananciaB(JLabel gananciaB) {
        DisneyChannel.gananciaB = gananciaB;
    }

    public static JLabel getGuionPlotEnDriveB() {
        return guionPlotEnDriveB;
    }

    public static void setGuionPlotEnDriveB(JLabel guionPlotEnDriveB) {
        DisneyChannel.guionPlotEnDriveB = guionPlotEnDriveB;
    }

    public static JLabel getIngresosBrutosB() {
        return ingresosBrutosB;
    }

    public static void setIngresosBrutosB(JLabel ingresosBrutosB) {
        DisneyChannel.ingresosBrutosB = ingresosBrutosB;
    }

    public static JSpinner getSpinnerDoblajes() {
        return spinnerDoblajes;
    }

    public static void setSpinnerDoblajes(JSpinner spinnerDoblajes) {
        DisneyChannel.spinnerDoblajes = spinnerDoblajes;
    }

    public static JSpinner getSpinnerEnsamblador() {
        return spinnerEnsamblador;
    }

    public static void setSpinnerEnsamblador(JSpinner spinnerEnsamblador) {
        DisneyChannel.spinnerEnsamblador = spinnerEnsamblador;
    }

    public static JSpinner getSpinnerEscenarios() {
        return spinnerEscenarios;
    }

    public static void setSpinnerEscenarios(JSpinner spinnerEscenarios) {
        DisneyChannel.spinnerEscenarios = spinnerEscenarios;
    }

    public static JSpinner getSpinnerGuion() {
        return spinnerGuion;
    }

    public static void setSpinnerGuion(JSpinner spinnerGuion) {
        DisneyChannel.spinnerGuion = spinnerGuion;
    }

    public static JSpinner getSpinnerGuionPlot() {
        return spinnerGuionPlot;
    }

    public static void setSpinnerGuionPlot(JSpinner spinnerGuionPlot) {
        DisneyChannel.spinnerGuionPlot = spinnerGuionPlot;
    }

    public static JSpinner getSpinnerPersonajes() {
        return spinnerPersonajes;
    }

    public static void setSpinnerPersonajes(JSpinner spinnerPersonajes) {
        DisneyChannel.spinnerPersonajes = spinnerPersonajes;
    }
    
    

}
