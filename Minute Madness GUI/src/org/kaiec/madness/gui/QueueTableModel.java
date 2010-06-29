/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kaiec.madness.gui;

import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.kaiec.madness.Queue;
import org.kaiec.madness.impl.ChangeListener;

/**
 *
 * @author Robert
 */
public class QueueTableModel implements TableModel {

    private Queue queue;
    private ArrayList<TableModelListener> listeners = new ArrayList<TableModelListener>();

    public QueueTableModel(Queue queue) {
        this.queue = queue;
        final QueueTableModel myTab = this;
        queue.addChangeListener(new ChangeListener() {
            public void queueChanged() {
                for (TableModelListener tml : listeners){
                    tml.tableChanged(new TableModelEvent(myTab));
                }
            }
        });
    }

    public int getRowCount() {
        return queue.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Position";
            case 1:
                return "Title";
            case 2:
                return "Author";
            case 3:
                return "File";
            default:
                return "Error";
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            default:
                return String.class;
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
//                if (columnIndex == 1)
//                    return false;
//                else
//                    return true;
        return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex;
            case 1:
                return queue.get(rowIndex).getTitle();
            case 2:
                return queue.get(rowIndex).getAuthor();
            case 3:
                return queue.get(rowIndex).getFile().getName();
            default:
                return "Error";

        }
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }
    

    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }
}
