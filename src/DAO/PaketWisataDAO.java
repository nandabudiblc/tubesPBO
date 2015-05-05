/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;
import Model.PaketWisata;
import java.sql.Connection;
import java.util.List;
/**
 *
 * @author Nanda
 */
public class PaketWisataDAO extends ConnectionDB {
    
    private Connection connection;
    
    public PaketWisataDAO(){
       try {
            connection = this.connect();
        } catch (Exception e) {
            e.getMessage();
        }    
    }
    
    public void addPaketWisata(PaketWisata paketWisata){
        
    }
    
    public void deletePaketWisata(int idPaketWisata){
        
    }
    
    public void updatePaketWisata(PaketWisata paketWisata){
        
    }
    
    public List<PaketWisata> getAllPaketWisata(){
        return null;
    }
    public PaketWisata getPaketWisataById(int idPaketWisata){
        return null;
    }
}
