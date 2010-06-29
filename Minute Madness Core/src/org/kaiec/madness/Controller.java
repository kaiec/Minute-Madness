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

/**
 *
 * @author Kai Eckert (http://www.kaiec.org)
 */
public interface Controller {
    public Queue getQueue();
    public void setIntro(Presentation p);
    public void setOutro(Presentation p);
    public Presentation getIntro();
    public Presentation getOutro();
    public void start();
    public void setInterval(int interval);
    public int getInterval();
    public void addIntervalListener(EventListener il);
    public void removeIntervalListener(EventListener il);
    public boolean proceed();


}
