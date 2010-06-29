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
import java.util.logging.Logger;
import org.kaiec.madness.PresentationFactory;

/**
 *
 * @author Kai Eckert (http://www.kaiec.org)
 */
public class DummyPresentation extends AbstractPresentation {
    private Logger log = Logger.getLogger(getClass().getName());

    public DummyPresentation(PresentationFactory factory) {
        super(factory);
    }

    public void load(File file) {
        this.file = file;
    }

    public void start() {
        log.info("START presentation: " + getTitle());
        return;
    }

    public void stop() {
        log.info("STOP presentation: " + getTitle());
        return;
    }

}
