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
public class Member extends Person{
    
    private int idMember;

    public Member(){
        
    }

    public Member(int idMember,String nama,String alamat,String noKtp,String noHp,String username,String password,String privilege){
        this.idMember = idMember;
        this.setNama(nama);
        this.setNoHp(noHp);
        this.setNoKtp(noKtp);
        this.setPassword(password);
        this.setPrivilege(privilege);
        this.setUsername(username);
        this.setAlamat(alamat);
       
    }
    public Member(String nama,String alamat,String noKtp,String noHp,String username,String password,String privilege){
        this.setNama(nama);
        this.setNoHp(noHp);
        this.setNoKtp(noKtp);
        this.setPassword(password);
        this.setPrivilege(privilege);
        this.setUsername(username);
        this.setAlamat(alamat);
       
    }

    @Override
    public String toString(){
        return this.getNama();
    }
    /**
     * @return the idMember
     */
    public int getIdMember() {
        return idMember;
    }

    /**
     * @param idMember the idMember to set
     */
    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    
}
