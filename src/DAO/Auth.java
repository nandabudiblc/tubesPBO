/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nanda
 */
public class Auth extends ConnectionDB{
    
    public ResultSet login(String username,String password) throws SQLException, Exception{
        ResultSet rs;
        try{
            Statement stmt = this.connect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * from petugas where username='"+username+"' and password='"+password+"'";
            rs = stmt.executeQuery(sql);
            
        } catch (SQLException error){
            throw new SQLException("Koneksi error");
        }
        return rs;
    }
    
    public String encodeToMD5(String password){
        String hasil = password;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            hasil = sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hasil;
    }
    
}
