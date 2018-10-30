/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Yoeri
 */
public class Photo {
    public String Location = "C:\\Users\\Yoeri\\Pictures\\JavaProject\\";
    public Image Img;
    public Image Thumbnail;
    
    public Photo(String fileName) {
        read(Location + fileName);
    }

    Photo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void read(String filePath) {
        try {
            Img = ImageIO.read(new File(filePath));
            Thumbnail = getScaledPhoto(50);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private Image getScaledPhoto(int height) {
        ImageIcon imageIcon = new ImageIcon(Img);
        Image imgThumb = null;
        
        int icHeight = imageIcon.getIconHeight();
        int width = imageIcon.getIconWidth();
        
        if (icHeight > height) {
            double ratio = ((double)height / icHeight);
            imgThumb = imageIcon.getImage().getScaledInstance(
                (int)((int)width * ratio),
                height,
                Image.SCALE_SMOOTH
            );
        }
        else {
            imgThumb = Img;
        }
        
        return imgThumb;
    }
}
