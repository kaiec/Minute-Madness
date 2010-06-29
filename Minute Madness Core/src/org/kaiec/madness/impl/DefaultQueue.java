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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.kaiec.madness.Presentation;
import org.kaiec.madness.Queue;


/**
 *
 * @author Kai Eckert (http://www.kaiec.org)
 */
public class DefaultQueue implements Queue {
    protected List<Presentation> list = new LinkedList<Presentation>();
    protected int pointer = 0;
    protected List<ChangeListener> listeners = new ArrayList<ChangeListener>();

    public void addChangeListener(ChangeListener cl) {
        listeners.add(cl);
    }

    protected void fireChange() {
        for (ChangeListener cl:listeners) {
            cl.queueChanged();
        }
    }


    public boolean add(Presentation p) {
        boolean res = list.add(p);
        fireChange();
        return res;
    }

    public boolean add(File file, String author, String title) {
        Presentation p = DefaultPresentationFactory.getFactory().getInstance(file);
        p.setAuthor(author);
        p.setTitle(title);
        p.load(file);
        boolean res = add(p);
        fireChange();
        return res;
    }




    public Presentation getNext() {
        if (pointer>=list.size()) return null;
        return list.get(pointer++);
    }

    public void moveAt(Presentation p, int pos) {
        int old=list.indexOf(p);
        if (old==-1) throw new RuntimeException("Presentation not found: " + p);
        if (old==pos) return;
        Presentation op  = list.get(old);
        list.add(pos, op);
        if (pos>old) list.remove(old);
        else list.remove(old+1);
        fireChange();
    }

    public void moveDown(Presentation p) {
        int old = list.indexOf(p);
        if (old==-1) throw new RuntimeException("Presentation not found: " + p);
        if (old==list.size()-1) return;
        Presentation other = list.set(old+1, p);
        list.set(old, other);
        fireChange();
    }

    public void moveUp(Presentation p) {
        int old = list.indexOf(p);
        if (old==-1) throw new RuntimeException("Presentation not found: " + p);
        if (old==0) return;
        Presentation other = list.set(old-1, p);
        list.set(old, other);
        fireChange();
    }

    public void remove(Presentation p) {
        list.remove(p);
        fireChange();
    }

    public void setPosition(int position) {
        this.pointer = position;
    }


    /*
     * List Interface
     */

    public void add(int index, Presentation element) {
        list.add(index, element);
        fireChange();
    }

    public boolean addAll(Collection<? extends Presentation> c) {
        boolean res =  list.addAll(c);
        fireChange();
        return res;
    }

    public boolean addAll(int index, Collection<? extends Presentation> c) {
        boolean res = list.addAll(index, c);
        fireChange();
        return res;
    }

    public void clear() {
        list.clear();
        fireChange();
    }

    public boolean contains(Object o) {
        return list.contains(o);
    }

    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    public Presentation get(int index) {
        return list.get(index);
    }

    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Iterator<Presentation> iterator() {
        return list.iterator();
    }

    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    public ListIterator<Presentation> listIterator() {
        return list.listIterator();
    }

    public ListIterator<Presentation> listIterator(int index) {
        return list.listIterator(index);
    }

    public boolean remove(Object o) {
        boolean res =  list.remove(o);
        fireChange();
        return res;
    }

    public Presentation remove(int index) {
        Presentation p =  list.remove(index);
        fireChange();
        return p;
    }

    public boolean removeAll(Collection<?> c) {
        boolean res = list.removeAll(c);
        fireChange();
        return res;
    }

    public boolean retainAll(Collection<?> c) {
        boolean res = list.retainAll(c);
        fireChange();
        return res;
    }

    public Presentation set(int index, Presentation element) {
        Presentation p = list.set(index, element);
        fireChange();
        return p;
    }

    public int size() {
        return list.size();
    }

    public List<Presentation> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }



}
