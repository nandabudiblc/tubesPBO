/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Nanda
 */
public class PaketWisata {
    private int idPaketWisata;
    private String nama;
    private int batasPeserta;
    private double harga;
    private int idTempatWisata;
    private int jumlahPaket;
    private int lamaHari;
    private String fasilitas;
    
    
    public PaketWisata(){
        
    }
    
    public PaketWisata(int idPaketWisata,String nama,int batasPeserta,double harga,int idTempatWisata,int jumlahPaket,int lamaHari,String fasilitas){
        this.idPaketWisata = idPaketWisata;
        this.nama = nama;
        this.batasPeserta = batasPeserta;
        this.harga = harga;
        this.idTempatWisata = idTempatWisata;
        this.jumlahPaket = jumlahPaket;
        this.lamaHari = lamaHari;
        this.fasilitas = fasilitas;
    }

    /**
     * @return the idPaketWisata
     */
    public int getIdPaketWisata() {
        return idPaketWisata;
    }

    /**
     * @param idPaketWisata the idPaketWisata to set
     */
    public void setIdPaketWisata(int idPaketWisata) {
        this.idPaketWisata = idPaketWisata;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the batasPeserta
     */
    public int getBatasPeserta() {
        return batasPeserta;
    }

    /**
     * @param batasPeserta the batasPeserta to set
     */
    public void setBatasPeserta(int batasPeserta) {
        this.batasPeserta = batasPeserta;
    }

    /**
     * @return the harga
     */
    public double getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(double harga) {
        this.harga = harga;
    }

    /**
     * @return the idTempatWisata
     */
    public int getIdTempatWisata() {
        return idTempatWisata;
    }

    /**
     * @param idTempatWisata the idTempatWisata to set
     */
    public void setIdTempatWisata(int idTempatWisata) {
        this.idTempatWisata = idTempatWisata;
    }

    /**
     * @return the jumlahPaket
     */
    public int getJumlahPaket() {
        return jumlahPaket;
    }

    /**
     * @param jumlahPaket the jumlahPaket to set
     */
    public void setJumlahPaket(int jumlahPaket) {
        this.jumlahPaket = jumlahPaket;
    }

    /**
     * @return the lamaHari
     */
    public int getLamaHari() {
        return lamaHari;
    }

    /**
     * @param lamaHari the lamaHari to set
     */
    public void setLamaHari(int lamaHari) {
        this.lamaHari = lamaHari;
    }

    /**
     * @return the fasilitas
     */
    public String getFasilitas() {
        return fasilitas;
    }

    /**
     * @param fasilitas the fasilitas to set
     */
    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }
    
}
