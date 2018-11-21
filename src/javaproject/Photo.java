/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private File imageFile;
    
    public Photo(String fileName) {
        read(Location + fileName);
    }

    Photo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void read(String filePath) {
        imageFile = new File(filePath);
        try {
            Img = ImageIO.read(imageFile);
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
    
    public byte [] getPhotoByteArray() {
        try {
            BufferedImage img = ImageIO.read(imageFile);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", output);
            return output.toByteArray();
            
        } catch (IOException ex) {
            Logger.getLogger(Photo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
