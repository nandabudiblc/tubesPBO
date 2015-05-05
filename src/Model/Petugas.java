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
public class Petugas extends Person{
    
    private int idPetugas;
    private String tempatLahir;
    private Date tanggalLahir;
    private int gaji;

    public Petugas(){
        
    }
    
    public Petugas(String nama,String alamat,String noKtp,String noHp,String username,String password,String privilege,String tempatLahir,Date tanggalLahir,int gaji){
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.gaji = gaji;
        this.setNama(nama);
        this.setNoHp(noHp);
        this.setNoKtp(noKtp);
        this.setPassword(password);
        this.setPrivilege(privilege);
        this.setUsername(username);
        this.setAlamat(alamat);
        
    }
    public Petugas(int idPetugas,String nama,String alamat,String noKtp,String noHp,String username,String password,String privilege,String tempatLahir,Date tanggalLahir,int gaji){
        this.idPetugas = idPetugas;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.gaji = gaji;
        this.setNama(nama);
        this.setNoHp(noHp);
        this.setNoKtp(noKtp);
        this.setPassword(password);
        this.setPrivilege(privilege);
        this.setUsername(username);
        this.setAlamat(alamat);
        
    }
    /**
     * @return the idPetugas
     */
    public int getIdPetugas() {
        return idPetugas;
    }

    /**
     * @param idPetugas the idPetugas to set
     */
    public void setIdPetugas(int idPetugas) {
        this.idPetugas = idPetugas;
    }



    /**
     * @return the gaji
     */
    public int getGaji() {
        return gaji;
    }

    /**
     * @param gaji the gaji to set
     */
    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    /**
     * @return the tempatLahir
     */
    public String getTempatLahir() {
        return tempatLahir;
    }

    /**
     * @param tempatLahir the tempatLahir to set
     */
    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    /**
     * @return the tanggalLahir
     */
    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    /**
     * @param tanggalLahir the tanggalLahir to set
     */
    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
    
}
