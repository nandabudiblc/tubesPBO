/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Date;

/**
 *
 * @author Nanda
 */
public class Transaksi {
    private int id_transaksi;
    private int id_petugas; 
    private int id_member;
    private int id_paketwisata;
    private String jenis_pesan;
    private int jumlah_kelompok;
    private int jumlah_orang;
    private String status;
    private Date tanggal;
    
    public Transaksi(){
        
    }
    public Transaksi(int id_transaksi, int id_petugas, int id_member, int id_paketwisata, String jenis_pesan, int jumlah_kelompok, int jumlah_orang, String status, Date tanggal){
        this.id_transaksi = id_transaksi;
        this.id_petugas = id_petugas;
        this.id_member = id_member;
        this.id_paketwisata = id_paketwisata;
        this.jenis_pesan = jenis_pesan;
        this.jumlah_kelompok = jumlah_kelompok;
        this.jumlah_orang = jumlah_orang;
        this.status = status;
        this.tanggal = tanggal;
    }

    /**
     * @return the id_transaksi
     */
    public int getId_transaksi() {
        return id_transaksi;
    }

    /**
     * @param id_transaksi the id_transaksi to set
     */
    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    /**
     * @return the id_petugas
     */
    public int getId_petugas() {
        return id_petugas;
    }

    /**
     * @param id_petugas the id_petugas to set
     */
    public void setId_petugas(int id_petugas) {
        this.id_petugas = id_petugas;
    }

    /**
     * @return the id_member
     */
    public int getId_member() {
        return id_member;
    }

    /**
     * @param id_member the id_member to set
     */
    public void setId_member(int id_member) {
        this.id_member = id_member;
    }

    /**
     * @return the id_paketwisata
     */
    public int getId_paketwisata() {
        return id_paketwisata;
    }

    /**
     * @param id_paketwisata the id_paketwisata to set
     */
    public void setId_paketwisata(int id_paketwisata) {
        this.id_paketwisata = id_paketwisata;
    }

    /**
     * @return the jenis_pesan
     */
    public String getJenis_pesan() {
        return jenis_pesan;
    }

    /**
     * @param jenis_pesan the jenis_pesan to set
     */
    public void setJenis_pesan(String jenis_pesan) {
        this.jenis_pesan = jenis_pesan;
    }

    /**
     * @return the jumlah_kelompok
     */
    public int getJumlah_kelompok() {
        return jumlah_kelompok;
    }

    /**
     * @param jumlah_kelompok the jumlah_kelompok to set
     */
    public void setJumlah_kelompok(int jumlah_kelompok) {
        this.jumlah_kelompok = jumlah_kelompok;
    }

    /**
     * @return the jumlah_orang
     */
    public int getJumlah_orang() {
        return jumlah_orang;
    }

    /**
     * @param jumlah_orang the jumlah_orang to set
     */
    public void setJumlah_orang(int jumlah_orang) {
        this.jumlah_orang = jumlah_orang;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the tanggal
     */
    public Date getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
