/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.Transaksi;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Nanda
 */
public class TransaksiDAO extends ConnectionDB {
    
    Connection connect;
    
    public TransaksiDAO(){
        try {
            connect = this.connect();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void addTransaksi(Transaksi transaksi){
        
    }
    
    public void deleteTransaksi(int idTransaksi){
        
    }
    
    public void updateTransaksi(Transaksi transaksi){
        
    }
    
    public List<Transaksi> getAllTransaksi(){
        return null;
    }
    public Transaksi getTransaksiById(int idTransaksi){
        return null;
    }
}
