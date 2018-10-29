/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.util.Vector;
import javax.swing.AbstractListModel;

/**
 *
 * @author Yoeri
 */
public class MyModel extends AbstractListModel {
    Vector Data = new Vector();

    @Override
    public int getSize() {
        return Data.size();
    }

    @Override
    public Object getElementAt(int index) {
        return Data.elementAt(index);
    }
    
    public void addElement(String s) {
        Data.addElement(s);
    }
}
