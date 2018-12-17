/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
import javaproject.helpers.DatabaseHelper;

/**
 *
 * @author Yoeri
 */
public class Data {
    private DatabaseHelper databaseHelper;
    Vector Row;
    Vector Table = new Vector();
    
    public void makeData() {
        databaseHelper = new DatabaseHelper();
        
        ArrayList<Vector> rows = databaseHelper.getAllData();
        
        for (Vector row : rows) {
            Table.addElement(row);
        }
    }
    
    public Object getData(int rIndex, int cIndex) {
        return ((Vector)Table.elementAt(rIndex)).elementAt(cIndex);
    }
    
    public void setData(int rIndex, int cIndex, Object data){
        Vector Row = ((Vector)Table.elementAt(rIndex));
        Row.setElementAt(data, cIndex);
    }
    
    public Class getColumnClass(int cIndex){
    
     return ((Object)((Vector)Table.elementAt(0)).elementAt(cIndex)).getClass();
}
    
    public int getRowCount(){
        return Table.size();
    }
    
       public int getColumnCount(){
        return ((Vector)Table.elementAt(0)).size();
    }
}
