/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.awt.Color;
import java.util.Vector;

/**
 *
 * @author Yoeri
 */
public class Data {
    Vector Row;
    Vector Table = new Vector();
    
    public void makeData() {
        Row = new Vector();
        Row.addElement("Text 1");
        Row.addElement(123);
        Row.addElement(true);
        Row.addElement(Color.lightGray);
        Row.addElement(new Photo("blue.jpg"));
        Table.addElement(Row);
        
        Row = new Vector();
        Row.addElement("Text 2");
        Row.addElement(456);
        Row.addElement(false);
        Row.addElement(Color.red);
        Row.addElement(new Photo("pink.jpg"));
        Table.addElement(Row);
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
