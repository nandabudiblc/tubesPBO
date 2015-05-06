/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import DAO.TransaksiDAO;
import Model.Transaksi;
import java.util.ArrayList;
/**
 *
 * @author Nanda
 */
public class TransaksiController {
    TransaksiDAO transaksiDAO;
    
    public TransaksiController() {
        transaksiDAO = new TransaksiDAO();
    }
    
    public boolean addTransaksi(Transaksi transaksi){
        boolean isSuccess = false;
        if(transaksiDAO.addTransaksi(transaksi)){
            isSuccess = true;
        }
        return isSuccess;
    }
    
    public ArrayList<Transaksi> getAllTransaksi(){
        return transaksiDAO.getAllTransaksi();
    }
    
    public boolean deleteTransaksi(Transaksi transaksi){
        boolean isSuccess = false;
        if(transaksiDAO.deleteTransaksi(transaksi)){
            isSuccess = true;
        }
        return isSuccess;
    }
    
    public boolean updateTransaksi(Transaksi transaksi){
        boolean isSuccess = false;
        if(transaksiDAO.updateTransaksi(transaksi)){
            isSuccess = true;
        }
        return isSuccess;
    }

}
