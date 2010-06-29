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

package org.kaiec.madness;

import java.io.File;
import java.util.List;
import org.kaiec.madness.impl.ChangeListener;

/**
 *
 * @author Kai Eckert (http://www.kaiec.org)
 */
public interface Queue extends List<Presentation> {
    public boolean add(Presentation p);
    public void remove(Presentation p);
    public Presentation getNext();
    public void setPosition(int position);
    public boolean add(File file, String author, String title);
    public void moveUp(Presentation p);
    public void moveDown(Presentation p);
    public void moveAt(Presentation p, int pos);
    public void addChangeListener(ChangeListener cl);
}
