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
public abstract class AbstractPresentation implements Presentation{
    protected String author;
    protected String title;
    protected PresentationFactory factory;
    protected File file;

    public AbstractPresentation(PresentationFactory factory) {
        this.factory = factory;
    }



    public PresentationFactory getFactory() {
        return factory;
    }



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String name) {
        this.author = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public File getFile() {
        return file;
    }



}
