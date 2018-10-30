/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject.editors;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javaproject.Photo;
import javaproject.helpers.ImageFilter;
import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Yoeri
 */
public class PhotoEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    Photo currentPhoto;
    JButton button;
    JFileChooser fileChooser;
    JDialog dialog;
    ImageIcon currentImage;
    protected static final String EDIT = "edit";
    boolean OK = false;
    
    public PhotoEditor() {
        button = new JButton();
        button.setActionCommand(EDIT);
        button.addActionListener(this);
        button.setBorderPainted(false);
        
        fileChooser = new JFileChooser();
    }
    
    @Override
    public Object getCellEditorValue() {
        return currentPhoto;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        currentPhoto = (Photo)value;
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (EDIT.equals(e.getActionCommand())) {
            button.setIcon(new ImageIcon(currentPhoto.Thumbnail));
            fileChooser.setFileFilter(new ImageFilter());
            int returnValue = fileChooser.showOpenDialog(null);
            
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                currentPhoto.read(file.getPath());
            }
            fireEditingStopped();
        }
    }
    
    public void setVisible(Photo currentPhoto) {
        this.currentPhoto = currentPhoto;
        fileChooser.setFileFilter(new ImageFilter());
        int returnvalue = fileChooser.showOpenDialog(null);
        
        if (returnvalue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            OK = true;
            
            this.currentPhoto.read(file.getPath());
        }
    }
}
