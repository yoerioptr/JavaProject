/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Yoeri
 */
public class MyTableModel implements TableModel {
    Data data;

    @Override
    public int getRowCount() {
        return data.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return data.getColumnCount();
    }

    @Override
    public String getColumnName(int cIndex) {
        return "Column" + cIndex;
    }

    @Override
    public Class<?> getColumnClass(int cIndex) {
        return data.getColumnClass(cIndex);
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return true;
    }

    @Override
    public Object getValueAt(int rIndex, int cIndex) {
        return data.getData(rIndex, cIndex);
    }

    @Override
    public void setValueAt(Object object, int rIndex, int cIndex) {
        data.setData(rIndex, cIndex, object);
        
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {

    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {

    }
    
    public void setData(Data data) {
        this.data = data;
    }
}
