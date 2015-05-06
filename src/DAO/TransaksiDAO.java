/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.Transaksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.Chart;

/**
 *
 * @author Nanda
 */
public class TransaksiDAO extends ConnectionDB {
    
    Connection connection;
    
    public TransaksiDAO(){
        try {
            connection = this.connect();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public boolean addTransaksi(Transaksi transaksi){
        boolean isSuccess = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `travel`.`transaksi` (`id_transaksi`, `id_petugas`, `id_member`, `id_paketwisata`, `jenis_pesan`, `jumlah_kelompok`, `jumlah_orang`, `status`, `tanggal`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, transaksi.getId_petugas());  
            preparedStatement.setInt(2, transaksi.getId_member());  
            preparedStatement.setInt(3, transaksi.getId_paketwisata()); 
            preparedStatement.setString(4, transaksi.getJenis_pesan()); 
            preparedStatement.setInt(5, transaksi.getJumlah_kelompok()); 
            preparedStatement.setInt(6, transaksi.getJumlah_orang());
            preparedStatement.setString(7, transaksi.getStatus());
            preparedStatement.setDate(8, transaksi.getTanggal());
            preparedStatement.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return isSuccess;
    }
    
    public boolean deleteTransaksi(Transaksi transaksi){
        boolean isSuccess = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `travel`.`transaksi` WHERE `transaksi`.`id_transaksi` = ?");
            preparedStatement.setInt(1, transaksi.getId_transaksi());  
            preparedStatement.executeUpdate();  
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return isSuccess;
    }
    
    public boolean updateTransaksi(Transaksi transaksi){
        boolean isSuccess = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `travel`.`transaksi` SET `id_petugas` = ?, `id_member` = ?, `id_paketwisata` = ?, `jenis_pesan` = ?, `jumlah_kelompok` = ?, `jumlah_orang` = ?, `status` = ?, `tanggal` = ? WHERE `transaksi`.`id_transaksi` = ?");
            preparedStatement.setInt(1, transaksi.getId_petugas());  
            preparedStatement.setInt(2, transaksi.getId_member());  
            preparedStatement.setInt(3, transaksi.getId_paketwisata()); 
            preparedStatement.setString(4, transaksi.getJenis_pesan()); 
            preparedStatement.setInt(5, transaksi.getJumlah_kelompok()); 
            preparedStatement.setInt(6, transaksi.getJumlah_orang());
            preparedStatement.setString(7, transaksi.getStatus());
            preparedStatement.setDate(8, transaksi.getTanggal());
            preparedStatement.setInt(9, transaksi.getId_transaksi());
            preparedStatement.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return isSuccess;
    }
    
    public ArrayList<Transaksi> getAllTransaksi(){
        ArrayList<Transaksi> listTransaksi = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT t.id_transaksi, t.`id_petugas`, t.`id_member`, t.`id_paketwisata`,m.nama as nama_member,p.nama as nama_petugas,pk.nama as nama_paket,t.jenis_pesan,t.jumlah_kelompok,t.jumlah_orang,t.status,t.tanggal FROM `transaksi` t,member m,petugas p, paketwisata pk WHERE m.id_member = t.id_member and p.id_petugas = t.id_petugas and pk.id_paketwisata = t.id_paketwisata";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Transaksi transaksi = new Transaksi();
                transaksi.setId_transaksi(rs.getInt("id_transaksi")); 
                transaksi.setId_member(rs.getInt("id_member"));
                transaksi.setId_petugas(rs.getInt("id_petugas"));
                transaksi.setId_paketwisata(rs.getInt("id_paketwisata"));
                transaksi.setNamaMember(rs.getString("nama_member"));
                transaksi.setNamaPetugas(rs.getString("nama_petugas"));
                transaksi.setNamaPaket(rs.getString("nama_paket"));
                transaksi.setJenis_pesan(rs.getString("jenis_pesan"));
                transaksi.setJumlah_kelompok(rs.getInt("jumlah_kelompok"));
                transaksi.setStatus(rs.getString("status"));
                transaksi.setJumlah_orang(rs.getInt("jumlah_orang"));
                transaksi.setTanggal(rs.getDate("tanggal"));
                listTransaksi.add(transaksi);
            }
        } catch (SQLException error){
                error.getMessage();
        }
        return listTransaksi;
    }
    public ArrayList<Chart> getTransaksiByTempatWisata(){
        ArrayList<Chart> listDataChart = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT count(*) as count,tw.nama FROM `transaksi` t, paketwisata pk, tempatwisata tw WHERE pk.id_paketwisata = t.id_paketwisata and pk.id_tempatwisata = tw.id_tempatwisata group by tw.id_tempatwisata";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Chart chart = new Chart();
                chart.setCount(rs.getInt("count"));
                chart.setNama(rs.getString("nama"));
                listDataChart.add(chart);
            }
        } catch (SQLException error){
                error.getMessage();
        }
        return listDataChart;
    }
    
}
