/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaiec.madness.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.kaiec.madness.Controller;
import org.kaiec.madness.Presentation;

/**
 *
 * @author Robert
 */
public class PresentationThread implements Runnable {

    private Controller controller;
    private boolean wait;

    public PresentationThread(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        for (Presentation p : controller.getQueue()) {
            wait = true;
              IntermediateFrame imf = new IntermediateFrame(p.getTitle(), p.getAuthor());
            imf.addChangeListener(new ChangeListener() {

                public void stateChanged(ChangeEvent e) {
                    wait = false;
                }
            });
            imf.setVisible(true);

            while (wait){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PresentationThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            imf.dispose();
            controller.proceed();
        }
    }
}
