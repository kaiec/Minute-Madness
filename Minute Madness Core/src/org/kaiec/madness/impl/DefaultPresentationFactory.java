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

import java.io.File;
import org.kaiec.madness.Presentation;
import org.kaiec.madness.PresentationFactory;

/**
 *
 * @author Kai Eckert (http://www.kaiec.org)
 */
public class DefaultPresentationFactory implements PresentationFactory {


    public Presentation getInstance(File file) {
        if (file.getName().endsWith(".odp")) return new ImpressPresentation(this);
        else if (file.getName().endsWith(".ppt")) return new PowerpointPresentation(this);
        else if (file.getName().endsWith(".pptx")) return new PowerpointPresentation(this);
        else if (file.getName().endsWith(".ppts")) return new PowerpointPresentation(this);
        throw new RuntimeException("Filetype not supported: " + file.getName());
    }

    private static DefaultPresentationFactory factory = null;
    public static DefaultPresentationFactory getFactory() {
        if (factory==null) factory=new DefaultPresentationFactory();
        return factory;
    }

}
