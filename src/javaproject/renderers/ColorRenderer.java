/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject.renderers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import javaproject.Photo;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Yoeri
 */
public class ColorRenderer extends JLabel implements TableCellRenderer {
    Boolean isBordered = true;
    Color color;
    Border selectedBorder, unselectedBorder;

    public ColorRenderer(boolean isBordered){
        this.isBordered = isBordered;
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof Color) {
            Color newColor = (Color)value;
            setBackground(newColor);
            setToolTipText("Color: " + newColor.getRed() + ", " + newColor.getGreen() + ", "  + newColor.getBlue());
        }
        if (value instanceof Photo) {
            Image image = ((Photo)value).Thumbnail;
            setIcon(new ImageIcon(image));
        }
        if (isBordered) {
            if (isSelected) {
                setBorder(selectedBorder);
            }
            else {
                setBorder(unselectedBorder);
            }
        }
        return this;
    }
}
