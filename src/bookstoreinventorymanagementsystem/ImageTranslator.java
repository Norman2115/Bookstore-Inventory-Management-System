/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class ImageTranslator {
    private byte[] imageData;
    
    public ImageTranslator(){
        imageData  =  null;
    }
    
    public void iconToBLOB(Icon icon){
        Image image = ((ImageIcon) icon).getImage();
        //create a BufferedImage object
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        //convert image to BufferedImage
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        //let BufferedImage write into ByteArrayOutputStream to get BLOB
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "jpg", baos);
        } catch (IOException ex) {
            Logger.getLogger(ImageTranslator.class.getName()).log(Level.SEVERE, null, ex);
        }
        imageData = baos.toByteArray();
    }
    
    public byte[] getBLOB(){
        return imageData;
    }
}
