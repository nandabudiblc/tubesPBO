/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import DAO.TempatWisataDAO;
import Model.TempatWisata;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
/**
 *
 * @author Nanda
 */
public class TempatWisataController {
    TempatWisataDAO tempatWisataDAO;
    DefaultComboBoxModel comboBoxModel;
    public TempatWisataController() {
        tempatWisataDAO = new TempatWisataDAO();
    }
    
    public boolean addTempatWisata(TempatWisata tempatWisata){
        boolean isSuccess = false;
        if(tempatWisataDAO.addTempatWisata(tempatWisata)){
            isSuccess = true;
        }
        return isSuccess;
    }
    
    public ArrayList<TempatWisata> getAllTempatWisata(){
        return tempatWisataDAO.getAllTempatWisata();
    }
    
    public boolean deleteTempatWisata(TempatWisata tempatWisata){
        boolean isSuccess = false;
        if(tempatWisataDAO.deleteTempatWisata(tempatWisata)){
            isSuccess = true;
        }
        return isSuccess;
    }
    
    public boolean updateTempatWisata(TempatWisata tempatWisata){
        boolean isSuccess = false;
        if(tempatWisataDAO.updateTempatWisata(tempatWisata)){
            isSuccess = true;
        }
        return isSuccess;
    }
   
    public void populateDatatoJComboboxTWTempat(ArrayList<TempatWisata> listTempatWisata, JComboBox jComboBoxPWTempat) {
        comboBoxModel = new DefaultComboBoxModel();
        for (final TempatWisata tempatWisata : listTempatWisata) {
                    comboBoxModel.addElement(tempatWisata);
            }
        jComboBoxPWTempat.setModel(comboBoxModel);
    }
    
}
