/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.PaketWisataDAO;
import Model.PaketWisata;
import java.awt.EventQueue;
import java.util.ArrayList;

/**
 *
 * @author Nanda
 */
public class PaketWisataController {
    PaketWisataDAO paketWisataDAO;
    public PaketWisataController() {
        paketWisataDAO = new PaketWisataDAO();
    }
    
    public boolean addTempatWisata(PaketWisata paketWisata){
        boolean isSuccess = false;
        if(paketWisataDAO.addPaketWisata(paketWisata)){
            isSuccess = true;
        }
        return isSuccess;
    }
    
    public ArrayList<PaketWisata> getAllTempatWisata(){
        return paketWisataDAO.getAllPaketWisata();
    }
    
    public boolean deleteTempatWisata(PaketWisata paketWisata){
        boolean isSuccess = false;
        if(paketWisataDAO.deletePaketWisata(paketWisata)){
            isSuccess = true;
        }
        return isSuccess;
    }
    
    public boolean updateTempatWisata(PaketWisata paketWisata){
        boolean isSuccess = false;
        if(paketWisataDAO.updatePaketWisata(paketWisata)){
            isSuccess = true;
        }
        return isSuccess;
    }

}
