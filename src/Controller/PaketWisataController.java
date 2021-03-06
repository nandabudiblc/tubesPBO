/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.PaketWisataDAO;
import Model.PaketWisata;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Nanda
 */
public class PaketWisataController {
    PaketWisataDAO paketWisataDAO;
    public PaketWisataController() {
        paketWisataDAO = new PaketWisataDAO();
    }
    
    public boolean addPaketWisata(PaketWisata paketWisata){
        boolean isSuccess = false;
        if(paketWisataDAO.addPaketWisata(paketWisata)){
            isSuccess = true;
        }
        return isSuccess;
    }
    
    public ArrayList<PaketWisata> getAllPaketWisata(){
        return paketWisataDAO.getAllPaketWisata();
    }
    
    public boolean deletePaketWisata(PaketWisata paketWisata){
        boolean isSuccess = false;
        if(paketWisataDAO.deletePaketWisata(paketWisata)){
            isSuccess = true;
        }
        return isSuccess;
    }
    
    public boolean updatePaketWisata(PaketWisata paketWisata){
        boolean isSuccess = false;
        if(paketWisataDAO.updatePaketWisata(paketWisata)){
            isSuccess = true;
        }
        return isSuccess;
    }

        public void populateDatatoJComboboxPW(ArrayList<PaketWisata> listPaketWisata, JComboBox jComboBoxPaketWisata) {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        for (final PaketWisata pw : listPaketWisata) {
                    comboBoxModel.addElement(pw);
            }
        jComboBoxPaketWisata.setModel(comboBoxModel);
    }
}
