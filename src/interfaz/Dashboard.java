/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Guillermo
 */
public class Dashboard extends javax.swing.JFrame {

    public static int duracionDiasSegundos;
    public static int diasParaEntrega;
    public static int guionesNickelodeon;
    public static int escenariosNickelodeon;
    public static int personajesNickelodeon;
    public static int doblajesNickelodeon;
    public static int plotTNickelodeon;
    public static int ensambladoresNickelodeon;
    public static int guionesDisneyChannel;
    public static int escenariosDisneyChannel;
    public static int personajesDisneyChannel;
    public static int doblajesDisneyChannel;
    public static int plotTDisneyChannel;
    public static int ensambladoresDisneyChannel;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        cargarValoresDesdeArchivo();
        cargarValoresEnSpinners();

    }

    public static void cargarValoresDesdeArchivo() {
        try ( FileReader fileReader = new FileReader("src/assets/valoresIniciales.txt");  Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];
                    switch (key) {
                        case "duracionDiasSegundos":
                            duracionDiasSegundos = Integer.parseInt(value);
                            break;
                        case "diasParaEntrega":
                            diasParaEntrega = Integer.parseInt(value);
                            break;
                        case "guionesNickelodeon":
                            guionesNickelodeon = Integer.parseInt(value);
                            break;
                        case "escenariosNickelodeon":
                            escenariosNickelodeon = Integer.parseInt(value);
                            break;
                        case "personajesNickelodeon":
                            personajesNickelodeon = Integer.parseInt(value);
                            break;
                        case "doblajesNickelodeon":
                            doblajesNickelodeon = Integer.parseInt(value);
                            break;
                        case "plotTNickelodeon":
                            plotTNickelodeon = Integer.parseInt(value);
                            break;
                        case "ensambladoresNickelodeon":
                            ensambladoresNickelodeon = Integer.parseInt(value);
                            break;
                        case "guionesDisneyChannel":
                            guionesDisneyChannel = Integer.parseInt(value);
                            break;
                        case "escenariosDisneyChannel":
                            escenariosDisneyChannel = Integer.parseInt(value);
                            break;
                        case "personajesDisneyChannel":
                            personajesDisneyChannel = Integer.parseInt(value);
                            break;
                        case "doblajesDisneyChannel":
                            doblajesDisneyChannel = Integer.parseInt(value);
                            break;
                        case "plotTDisneyChannel":
                            plotTDisneyChannel = Integer.parseInt(value);
                            break;
                        case "ensambladoresDisneyChannel":
                            ensambladoresDisneyChannel = Integer.parseInt(value);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarValoresEnTxt() {
        try ( FileWriter fileWriter = new FileWriter("src/assets/valoresIniciales.txt")) {
            fileWriter.write("duracionDiasSegundos=" + spinnerDuracionDias.getValue() + "\n");
            fileWriter.write("diasParaEntrega=" + spinnerDiasParaEntrega.getValue() + "\n");
            fileWriter.write("guionesNickelodeon=" + spinnerGuionA.getValue() + "\n");
            fileWriter.write("escenariosNickelodeon=" + spinnerEscenariosA.getValue() + "\n");
            fileWriter.write("personajesNickelodeon=" + spinnerPersonajesA.getValue() + "\n");
            fileWriter.write("doblajesNickelodeon=" + spinnerDoblajesA.getValue() + "\n");
            fileWriter.write("plotTNickelodeon=" + spinnerGuionPlotA.getValue() + "\n");
            fileWriter.write("ensambladoresNickelodeon=" + spinnerEnsambladorA.getValue() + "\n");
            fileWriter.write("guionesDisneyChannel=" + spinnerGuionB.getValue() + "\n");
            fileWriter.write("escenariosDisneyChannel=" + spinnerEscenariosB.getValue() + "\n");
            fileWriter.write("personajesDisneyChannel=" + spinnerPersonajesB.getValue() + "\n");
            fileWriter.write("doblajesDisneyChannel=" + spinnerDoblajesB.getValue() + "\n");
            fileWriter.write("plotTDisneyChannel=" + spinnerGuionPlotB.getValue() + "\n");
            fileWriter.write("ensambladoresDisneyChannel=" + spinnerEnsambladorB.getValue() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarValoresEnSpinners() {
        spinnerDuracionDias.setValue(duracionDiasSegundos);
        spinnerDiasParaEntrega.setValue(diasParaEntrega);
        spinnerGuionA.setValue(guionesNickelodeon);
        spinnerEscenariosA.setValue(escenariosNickelodeon);
        spinnerPersonajesA.setValue(personajesNickelodeon);
        spinnerDoblajesA.setValue(doblajesNickelodeon);
        spinnerGuionPlotA.setValue(plotTNickelodeon);
        spinnerEnsambladorA.setValue(ensambladoresNickelodeon);
        spinnerGuionB.setValue(guionesDisneyChannel);
        spinnerEscenariosB.setValue(escenariosDisneyChannel);
        spinnerPersonajesB.setValue(personajesDisneyChannel);
        spinnerDoblajesB.setValue(doblajesDisneyChannel);
        spinnerGuionPlotB.setValue(plotTDisneyChannel);
        spinnerEnsambladorB.setValue(ensambladoresDisneyChannel);
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
        jLabel23 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        spinnerEnsambladorA = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        spinnerEscenariosA = new javax.swing.JSpinner();
        spinnerPersonajesA = new javax.swing.JSpinner();
        spinnerDoblajesA = new javax.swing.JSpinner();
        spinnerGuionPlotA = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        spinnerGuionA = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        spinnerEnsambladorB = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        spinnerGuionB = new javax.swing.JSpinner();
        spinnerEscenariosB = new javax.swing.JSpinner();
        spinnerPersonajesB = new javax.swing.JSpinner();
        spinnerDoblajesB = new javax.swing.JSpinner();
        spinnerGuionPlotB = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spinnerDuracionDias = new javax.swing.JSpinner();
        spinnerDiasParaEntrega = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        desarrolladoresRestantesA = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Deadline de entrega:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 160, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Dashboard");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 210, 60));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Ir al Main");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 100, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Duración en segundos de un día:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 240, -1));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 5));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nickelodeon");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ensambladores:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));
        jPanel2.add(spinnerEnsambladorA, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Diseñador de escenarios:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Animador de personajes:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Actores de doblaje:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Guionista de PlotTwist:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));
        jPanel2.add(spinnerEscenariosA, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));
        jPanel2.add(spinnerPersonajesA, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));
        jPanel2.add(spinnerDoblajesA, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));
        jPanel2.add(spinnerGuionPlotA, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Guionistas:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));
        jPanel2.add(spinnerGuionA, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 270));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 5));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Disney Channel");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ensambladores:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));
        jPanel3.add(spinnerEnsambladorB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Diseñador de escenarios:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Animador de personajes:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Actores de doblaje:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Guionista de PlotTwist:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel3.add(spinnerGuionB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));
        jPanel3.add(spinnerEscenariosB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));
        jPanel3.add(spinnerPersonajesB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));
        jPanel3.add(spinnerDoblajesB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));
        jPanel3.add(spinnerGuionPlotB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Guionistas:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 260, 280));
        jPanel1.add(spinnerDuracionDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, -1, -1));
        jPanel1.add(spinnerDiasParaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, -1, -1));

        jButton2.setBackground(new java.awt.Color(51, 204, 0));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setText("GUARDAR");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 80, 30));

        desarrolladoresRestantesA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        desarrolladoresRestantesA.setText("17");
        jPanel1.add(desarrolladoresRestantesA, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 50, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/fondo-cemento-gris-1.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 570));

        jLabel19.setText("jLabel19");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));

        jLabel20.setText("jLabel20");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Duración en segundos de un día:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MainInterface a = new MainInterface();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        guardarValoresEnTxt();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel desarrolladoresRestantesA;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JSpinner spinnerDiasParaEntrega;
    public static javax.swing.JSpinner spinnerDoblajesA;
    public static javax.swing.JSpinner spinnerDoblajesB;
    public static javax.swing.JSpinner spinnerDuracionDias;
    public static javax.swing.JSpinner spinnerEnsambladorA;
    public static javax.swing.JSpinner spinnerEnsambladorB;
    public static javax.swing.JSpinner spinnerEscenariosA;
    public static javax.swing.JSpinner spinnerEscenariosB;
    public static javax.swing.JSpinner spinnerGuionA;
    public static javax.swing.JSpinner spinnerGuionB;
    public static javax.swing.JSpinner spinnerGuionPlotA;
    public static javax.swing.JSpinner spinnerGuionPlotB;
    public static javax.swing.JSpinner spinnerPersonajesA;
    public static javax.swing.JSpinner spinnerPersonajesB;
    // End of variables declaration//GEN-END:variables
    

}
