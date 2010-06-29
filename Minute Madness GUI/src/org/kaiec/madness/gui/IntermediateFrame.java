/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IntermediateFrame.java
 *
 * Created on 25.06.2010, 23:31:54
 */

package org.kaiec.madness.gui;

import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Robert
 */
public class IntermediateFrame extends javax.swing.JFrame {
    ArrayList<ChangeListener> listeners;
    /** Creates new form IntermediateFrame */
    public IntermediateFrame() {
        initComponents();
        listeners = new ArrayList<ChangeListener>();
    }

    public void addChangeListener(ChangeListener e){
        listeners.add(e);
    }



    public IntermediateFrame(String title, String author){
        initComponents();
        presTitle.setText(title);
        presAuthor.setText(author);
        listeners = new ArrayList<ChangeListener>();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        presTitle = new javax.swing.JLabel();
        presAuthor = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        presTitle.setText("Title");

        presAuthor.setText("Author");

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(presAuthor)
                    .addComponent(presTitle))
                .addContainerGap(325, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(563, Short.MAX_VALUE)
                .addComponent(startButton)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(presTitle)
                .addGap(18, 18, 18)
                .addComponent(presAuthor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(startButton)
                .addGap(29, 29, 29))
        );

        presTitle.getAccessibleContext().setAccessibleName("presTitle");
        presAuthor.getAccessibleContext().setAccessibleName("presAuthor");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        for (ChangeListener e : listeners){
            e.stateChanged(new ChangeEvent(this));
        }
}//GEN-LAST:event_startButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntermediateFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel presAuthor;
    private javax.swing.JLabel presTitle;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables

}
