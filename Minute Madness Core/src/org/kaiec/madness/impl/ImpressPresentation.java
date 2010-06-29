/*
 * This file is part of Semtinel (http://www.semtinel.org).
 * Copyright (c) 2007-2010 Kai Eckert (http://www.kaiec.org).
 * 
 * Semtinel is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Semtinel is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Semtinel.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package org.kaiec.madness.impl;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DesktopManager;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import org.kaiec.madness.PresentationFactory;

/**
 *
 * @author Kai Eckert (http://www.kaiec.org)
 */
public class ImpressPresentation extends AbstractPresentation {

    private Process process;
    public ImpressPresentation(PresentationFactory factory) {
        super(factory);
    }

    public void load(File file) {
        this.file = file;
    }

    public void start() {
        try {
            process = Runtime.getRuntime().exec("ooffice -show " + file.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(ImpressPresentation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stop() {
        process.destroy();
        
    }

}
