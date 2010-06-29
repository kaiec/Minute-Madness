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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.kaiec.madness.Controller;
import org.kaiec.madness.EventListener;
import org.kaiec.madness.Presentation;
import org.kaiec.madness.Queue;

/**
 *
 * @author Kai Eckert (http://www.kaiec.org)
 */
public class DefaultController implements Controller {

    protected List<EventListener> listeners = new ArrayList<EventListener>();
    protected int interval;
    protected Queue queue = new DefaultQueue();

    public DefaultController() {
    }



    public void addIntervalListener(EventListener il) {
        listeners.add(il);
    }

    public int getInterval() {
        return interval;
    }

    public Presentation getIntro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Presentation getOutro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Queue getQueue() {
        return queue;
    }

    public boolean proceed() {
        final Presentation next = queue.getNext();
        if (next==null) return false;
        next.start();
        Thread t = new Thread(new TimerThread(interval, new EventListener() {

            public void timeOutReached() {
                next.stop();
                for (EventListener el:listeners) {
                    el.timeOutReached();
                }
            }
        }));
        t.run();
        return true;
    }

    public void removeIntervalListener(EventListener il) {
        listeners.remove(il);
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void setIntro(Presentation p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setOutro(Presentation p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void start() {
        proceed();
    }

}
