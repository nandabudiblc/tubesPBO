/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;
import Model.PaketWisata;
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
public class PaketWisataDAO extends ConnectionDB {
    
    private Connection connection;
    
    public PaketWisataDAO(){
       try {
            connection = this.connect();
        } catch (Exception e) {
            e.getMessage();
        }    
    }
    
    public boolean addPaketWisata(PaketWisata paketWisata){
        boolean isSuccess = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `travel`.`paketwisata` (`id_paketwisata`, `nama`, `batas_peserta`, `harga`, `id_tempatwisata`, `jumlah_paket`, `lama_hari`, `fasilitas`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, paketWisata.getNama());  
            preparedStatement.setInt(2, paketWisata.getBatasPeserta());  
            preparedStatement.setDouble(3, paketWisata.getHarga()); 
            preparedStatement.setInt(4, paketWisata.getIdTempatWisata()); 
            preparedStatement.setInt(5, paketWisata.getJumlahPaket()); 
            preparedStatement.setInt(6, paketWisata.getLamaHari());
            preparedStatement.setString(7, paketWisata.getFasilitas());
            preparedStatement.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return isSuccess;

    }
    
    public boolean deletePaketWisata(PaketWisata paketWisata){
        boolean isSuccess = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `travel`.`paketwisata` WHERE `paketwisata`.`id_paketwisata` = ?");
            preparedStatement.setInt(1, paketWisata.getIdPaketWisata());  
            preparedStatement.executeUpdate();  
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return isSuccess;
    }
    
    public boolean updatePaketWisata(PaketWisata paketWisata){
        boolean isSuccess = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `travel`.`paketwisata` SET `nama` = ?, `batas_peserta` = ?, `harga` = ?, `id_tempatwisata` = ?, `jumlah_paket` = ?, `lama_hari` = ?, `fasilitas` = ? WHERE `paketwisata`.`id_paketwisata` = ?");
            preparedStatement.setString(1, paketWisata.getNama());  
            preparedStatement.setInt(2, paketWisata.getBatasPeserta());  
            preparedStatement.setDouble(3, paketWisata.getHarga()); 
            preparedStatement.setInt(4, paketWisata.getIdTempatWisata()); 
            preparedStatement.setInt(5, paketWisata.getJumlahPaket()); 
            preparedStatement.setInt(6, paketWisata.getLamaHari());
            preparedStatement.setString(7, paketWisata.getFasilitas());
            preparedStatement.setInt(8, paketWisata.getIdPaketWisata());
            preparedStatement.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return isSuccess;

    }
    
    public ArrayList<PaketWisata> getAllPaketWisata(){
         ArrayList<PaketWisata> listPaketWisata = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * from paketwisata";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                PaketWisata paketWisata = new PaketWisata();
                paketWisata.setIdPaketWisata(rs.getInt("id_paketwisata")); 
                paketWisata.setNama(rs.getString("nama"));
                paketWisata.setBatasPeserta(rs.getInt("batas_peserta")); 
                paketWisata.setHarga(rs.getInt("harga")); 
                paketWisata.setIdTempatWisata(rs.getInt("id_tempatwisata")); 
                paketWisata.setJumlahPaket(rs.getInt("jumlah_paket")); 
                paketWisata.setLamaHari(rs.getInt("lama_hari")); 
                paketWisata.setFasilitas(rs.getString("fasilitas"));
                listPaketWisata.add(paketWisata);
            }
        } catch (SQLException error){
                error.getMessage();
        }
        return listPaketWisata;

    }
    public PaketWisata getPaketWisataById(int idPaketWisata){
        return null;
    }
}
