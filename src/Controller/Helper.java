/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author Nanda
 */
public class Helper {
    
    public Helper(){
        
    }
    
    public void setSpinnerDate(JSpinner spinner){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1990);
        SpinnerDateModel model = new SpinnerDateModel();
        model.setValue(calendar.getTime());
        spinner.setModel(model);
        spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy-MM-dd"));
    }
    
    public void sendMessage(String message, String title){
        JOptionPane.showMessageDialog (null, message, title, JOptionPane.WARNING_MESSAGE);
    }
    
    public void printTable(String headerString, JTable jTable){
       MessageFormat header = new MessageFormat(headerString);
       MessageFormat footer = new MessageFormat("Halaman {0,number,integer}");
        try{
            jTable.print(JTable.PrintMode.FIT_WIDTH,header, footer);
       }catch(java.awt.print.PrinterException error) {
           System.err.format("Print Failed %s%n", error.getMessage());       
       }
    }
    
    public boolean cekKoneksi(){
        boolean isConnect = false;
        try {
            String imageUrl = "https://google.com";
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            is.close();
            isConnect = true;
        } catch (IOException e) {
            isConnect = false;
        }
        return isConnect;
    }
    
    
    public void setImage(String latlong, JLabel jLabelImage){
            try {
            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="+latlong+"&zoom=14&size=612x612&scale=2&maptype=roadmap&markers="+latlong+"&key=ABQIAAAAgb5KEVTm54vkPcAkU9xOvBR30EG5jFWfUzfYJTWEkWk2p04CHxTGDNV791-cU95kOnweeZ0SsURYSA&format=jpg";
            //String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=-6.975837,107.631359&zoom=14&size=612x612&scale=2&maptype=roadmap&markers=-6.975837,107.631359&key=ABQIAAAAgb5KEVTm54vkPcAkU9xOvBR30EG5jFWfUzfYJTWEkWk2p04CHxTGDNV791-cU95kOnweeZ0SsURYSA&format=jpg";
            String destinationFile = "image.jpg";
            String str = destinationFile;
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
        ImageIcon imageIcon = new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(630, 600,
                java.awt.Image.SCALE_SMOOTH));
        jLabelImage.setIcon(imageIcon);

    }
    
}
