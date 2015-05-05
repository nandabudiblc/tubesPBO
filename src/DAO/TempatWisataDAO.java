/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.TempatWisata;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Nanda
 */
public class TempatWisataDAO extends ConnectionDB {
        
    Connection connection;
    
    public TempatWisataDAO(){
        try {
            connection = super.connect();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public boolean addTempatWisata(TempatWisata tempatWisata){
        boolean isSuccess = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `travel`.`tempatwisata` (`id_tempatwisata`, `nama`, `lokasi`, `deskripsi`, `latlong`) VALUES (NULL,?,?,?,?)");
            preparedStatement.setString(1, tempatWisata.getNama());  
            preparedStatement.setString(2, tempatWisata.getLokasi());  
            preparedStatement.setString(3, tempatWisata.getDeskripsi()); 
            preparedStatement.setString(4, tempatWisata.getLatlong()); 
            preparedStatement.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return isSuccess;
    }
    
    public boolean deleteTempatWisata(TempatWisata tempatWisata){
        boolean isSuccess = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `travel`.`tempatwisata` WHERE `tempatwisata`.`id_tempatwisata` = ?");
            preparedStatement.setInt(1, tempatWisata.getIdTempatWisata());  
            preparedStatement.executeUpdate();  
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return isSuccess;
    }
    
    public boolean updateTempatWisata(TempatWisata tempatWisata){
        boolean isSuccess = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `travel`.`tempatwisata` SET `nama` = ?, `lokasi` = ?, `deskripsi` = ?, `latlong` = ? WHERE `tempatwisata`.`id_tempatwisata` = ?");
            preparedStatement.setString(1, tempatWisata.getNama());  
            preparedStatement.setString(2, tempatWisata.getLokasi());  
            preparedStatement.setString(3, tempatWisata.getDeskripsi()); 
            preparedStatement.setString(4, tempatWisata.getLatlong()); 
            preparedStatement.setInt(5, tempatWisata.getIdTempatWisata());
            preparedStatement.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return isSuccess;
    }
    
    public ArrayList<TempatWisata> getAllTempatWisata(){
        ArrayList<TempatWisata> listTempatWisata = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * from tempatwisata";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                TempatWisata tempatWisata = new TempatWisata();
                tempatWisata.setIdTempatWisata(rs.getInt("id_tempatwisata")); 
                tempatWisata.setNama(rs.getString("nama"));
                tempatWisata.setLokasi(rs.getString("lokasi"));
                tempatWisata.setDeskripsi(rs.getString("deskripsi"));
                tempatWisata.setLatlong(rs.getString("latlong"));
                listTempatWisata.add(tempatWisata);
            }
        } catch (SQLException error){
                error.getMessage();
        }
        return listTempatWisata;
    }
    public TempatWisata getTempatWisataById(int idTempatWisata){
        TempatWisata tempatWisata = new TempatWisata();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from tempatwisata where id_tempatwisata = ?");
            preparedStatement.setInt(1,idTempatWisata);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                tempatWisata.setIdTempatWisata(rs.getInt("id_tempatwisata")); 
                tempatWisata.setNama(rs.getString("nama"));
                tempatWisata.setLokasi(rs.getString("lokasi"));
                tempatWisata.setDeskripsi(rs.getString("deskripsi"));
                tempatWisata.setLatlong(rs.getString("latlong"));
            }
        } catch (SQLException error){
           error.getMessage();
        }
        return tempatWisata;
    }
}
