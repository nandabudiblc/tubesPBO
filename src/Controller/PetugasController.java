/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import DAO.PetugasDAO;
import Model.Petugas;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
/**
 *
 * @author Nanda
 */
public class PetugasController {
    PetugasDAO petugasDAO;
    
    public PetugasController() {
        petugasDAO = new PetugasDAO();
    }
    
    public boolean addPetugas(Petugas petugas){
        boolean isSuccess = false;
        if(petugasDAO.addPetugas(petugas)){
            isSuccess = true;
        }
        return isSuccess;
    }
    
    public ArrayList<Petugas> getAllPetugas(){
        return petugasDAO.getAllPetugas();
    }
    
    public boolean deletePetugas(Petugas petugas){
        boolean isSuccess = false;
        if(petugasDAO.deletePetugas(petugas)){
            isSuccess = true;
        }
        return isSuccess;
    }
    
    public boolean updatePetugas(Petugas petugas){
        boolean isSuccess = false;
        if(petugasDAO.updatePetugas(petugas)){
            isSuccess = true;
        }
        return isSuccess;
    }
   
    public void populateDatatoJComboboxPetugas(ArrayList<Petugas> listPetugas, JComboBox jComboBoxPetugas) {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        for (final Petugas petugas : listPetugas) {
                    comboBoxModel.addElement(petugas);
            }
        jComboBoxPetugas.setModel(comboBoxModel);
    }
}
