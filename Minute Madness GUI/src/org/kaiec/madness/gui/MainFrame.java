/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on 25.06.2010, 23:04:48
 */
package org.kaiec.madness.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.kaiec.madness.Controller;
import org.kaiec.madness.impl.DefaultController;
import org.kaiec.madness.impl.DefaultQueue;

/**
 *
 * @author Robert
 */
public class MainFrame extends javax.swing.JFrame {

    private Controller controller;

    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        controller = new DefaultController();
        conQueue.setModel(new QueueTableModel(controller.getQueue()));
    }

    private void readFromFile(File f) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] lineComp = line.split(";");
                if (lineComp != null) {
                    controller.getQueue().add(new File(lineComp[0]), lineComp[2], lineComp[1]);
                }
            }
            ;
        } catch (IOException ex) {
        }
    }

    private DefaultQueue getQueue() {
        return (DefaultQueue) controller.getQueue();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addPres = new javax.swing.JButton();
        addFolder = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        conQueue = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        presInterval = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        startPres = new javax.swing.JButton();
        addFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addPres.setText("Add Presentation");
        addPres.setActionCommand("addPresentation");
        addPres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPresActionPerformed(evt);
            }
        });

        addFolder.setText("Add Whole Folder");
        addFolder.setActionCommand("addFolder");

        jScrollPane1.setViewportView(conQueue);

        jLabel1.setText("Presentation Interval");

        jLabel3.setText("sec");

        startPres.setText("Start");
        startPres.setActionCommand("start");
        startPres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startPresActionPerformed(evt);
            }
        });

        addFile.setText("Add From File");
        addFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(addFolder, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(addPres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(addFile, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(280, 280, 280))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(presInterval, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addGap(435, 435, 435))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addContainerGap(651, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(startPres)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addFolder)
                    .addComponent(addFile)
                    .addComponent(addPres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(presInterval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(startPres)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPresActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Presentation");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int retVal = fileChooser.showOpenDialog(this);
        if (retVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            controller.getQueue().add(file, "", "");
        }

}//GEN-LAST:event_addPresActionPerformed

    private void startPresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startPresActionPerformed
        int intervalInt;
        try {
            intervalInt = Integer.parseInt(presInterval.getText());
        } catch (NumberFormatException ex) {
            intervalInt = 5;
        }
        controller.setInterval(intervalInt);
        controller.getQueue().setPosition(0);
        PresentationThread pt = new PresentationThread(controller);
        Thread t = new Thread(pt);
        t.start();

    // start new thread

    // start presentation

    // if queue has next wait for input (keyboard)

    // else go back to screen
    }//GEN-LAST:event_startPresActionPerformed

    private void addFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFileActionPerformed
        JFileChooser fileChooser = new JFileChooser("/home/kai/x/daten/minutemadness/mm-core/Minute Madness GUI");
        fileChooser.setDialogTitle("Select Presentation");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int retVal = fileChooser.showOpenDialog(this);
        if (retVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            readFromFile(file);
        }

    }//GEN-LAST:event_addFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFile;
    private javax.swing.JButton addFolder;
    private javax.swing.JButton addPres;
    private javax.swing.JTable conQueue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField presInterval;
    private javax.swing.JButton startPres;
    // End of variables declaration//GEN-END:variables
}