/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.Petugas;
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
public class PetugasDAO extends ConnectionDB {
    
    Connection connection;
    
    public PetugasDAO(){
        try {
            connection = super.connect();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public boolean addPetugas(Petugas petugas){
        boolean isSuccess = false;
        try {
//            System.out.println(petugas.getTanggalLahir().toString());
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `travel`.`petugas` (`id_petugas`, `nama`, `alamat`, `no_ktp`, `no_hp`, `username`, `password`, `privilege`, `tempat_lahir`, `tanggal_lahir`, `gaji`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, petugas.getNama());  
            preparedStatement.setString(2, petugas.getAlamat());  
            preparedStatement.setString(3, petugas.getNoKtp()); 
            preparedStatement.setString(4, petugas.getNoHp()); 
            preparedStatement.setString(5, petugas.getUsername()); 
            preparedStatement.setString(6, petugas.getPassword());
            preparedStatement.setString(7, petugas.getPrivilege());
            preparedStatement.setString(8, petugas.getTempatLahir());
            preparedStatement.setDate(9, petugas.getTanggalLahir());
            preparedStatement.setInt(10, petugas.getGaji());
            preparedStatement.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return isSuccess;
    }
    
    public boolean deletePetugas(Petugas petugas){
        boolean isSuccess = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `travel`.`petugas` WHERE `petugas`.`id_petugas` = ?");
            preparedStatement.setInt(1, petugas.getIdPetugas());  
            preparedStatement.executeUpdate();  
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return isSuccess;
    }
    
    public boolean updatePetugas(Petugas petugas){
        boolean isSuccess = false;
         try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `travel`.`petugas` SET `nama` = ?, `alamat` = ?, `no_ktp` = ?, `no_hp` = ?, `username` = ?, `password` = ?, `privilege` = ?, `tempat_lahir` = ?,`tanggal_lahir` = ?, `gaji` = ? WHERE `petugas`.`id_petugas` = ?");
            preparedStatement.setString(1, petugas.getNama());  
            preparedStatement.setString(2, petugas.getAlamat());  
            preparedStatement.setString(3, petugas.getNoKtp()); 
            preparedStatement.setString(4, petugas.getNoHp()); 
            preparedStatement.setString(5, petugas.getUsername()); 
            preparedStatement.setString(6, petugas.getPassword());
            preparedStatement.setString(7, petugas.getPrivilege());
            preparedStatement.setString(8, petugas.getTempatLahir());
            preparedStatement.setString(9, petugas.getTanggalLahir().toString());
            preparedStatement.setInt(10, petugas.getGaji());
            preparedStatement.setInt(11, petugas.getIdPetugas());
            preparedStatement.executeUpdate();  
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
         return isSuccess;
    }
    
    public ArrayList<Petugas> getAllPetugas(){
        ArrayList<Petugas> listpetugas = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * from petugas";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Petugas petugas = new Petugas();
                petugas.setIdPetugas(rs.getInt("id_petugas")); 
                petugas.setNama(rs.getString("nama"));
                petugas.setNoHp(rs.getString("no_hp"));
                petugas.setNoKtp(rs.getString("no_ktp"));
                petugas.setPassword(rs.getString("password"));
                petugas.setPrivilege(rs.getString("privilege"));
                petugas.setUsername(rs.getString("username"));
                petugas.setAlamat(rs.getString("alamat"));
                petugas.setTempatLahir(rs.getString("tempat_lahir"));
                petugas.setTanggalLahir(rs.getDate("tanggal_lahir"));
                petugas.setGaji(rs.getInt("gaji"));
                listpetugas.add(petugas);
            }
        } catch (SQLException error){
                error.getMessage();
        }
        return listpetugas;
    }
    
    public Petugas getPetugasById(int idPetugas){
        Petugas petugas = new Petugas();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from petugas where id_petugas = ?");
            preparedStatement.setInt(1,idPetugas);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                petugas.setIdPetugas(rs.getInt("id_petugas")); 
                petugas.setNama(rs.getString("nama"));
                petugas.setNoHp(rs.getString("no_hp"));
                petugas.setNoKtp(rs.getString("no_ktp"));
                petugas.setPassword(rs.getString("password"));
                petugas.setPrivilege(rs.getString("privilege"));
                petugas.setUsername(rs.getString("username"));
                petugas.setAlamat(rs.getString("alamat"));
                petugas.setTempatLahir(rs.getString("tempat_lahir"));
                petugas.setTanggalLahir(rs.getDate("tanggal_lahir"));
                petugas.setGaji(rs.getInt("gaji"));
            }
        } catch (SQLException error){
           error.getMessage();
        }
        return petugas;
    }
}
