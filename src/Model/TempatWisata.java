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
public class TempatWisata {
    private int idTempatWisata;
    private String nama;
    private String lokasi;
    private String deskripsi;
    private String latlong;

    public TempatWisata(){
        
    }
    
    public TempatWisata(int idTempatWisata,String nama,String lokasi,String deskripsi,String latlong){
        this.idTempatWisata = idTempatWisata;
        this.nama = nama;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.latlong = latlong;
    }
    
    public TempatWisata(String nama,String lokasi,String deskripsi,String latlong){
        this.nama = nama;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.latlong = latlong;
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
     * @return the lokasi
     */
    public String getLokasi() {
        return lokasi;
    }

    /**
     * @param lokasi the lokasi to set
     */
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    /**
     * @return the deskripsi
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     * @param deskripsi the deskripsi to set
     */
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    /**
     * @return the latlong
     */
    public String getLatlong() {
        return latlong;
    }

    /**
     * @param latlong the latlong to set
     */
    public void setLatlong(String latlong) {
        this.latlong = latlong;
    }
    
}
