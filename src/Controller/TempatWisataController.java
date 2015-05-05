/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import DAO.TempatWisataDAO;
import Model.TempatWisata;
import java.util.ArrayList;
/**
 *
 * @author Nanda
 */
public class TempatWisataController {
    TempatWisataDAO tempatWisataDAO;
    
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
   
    
}
