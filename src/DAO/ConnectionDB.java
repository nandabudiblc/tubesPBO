/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Nanda
 */
public class ConnectionDB {
    
    public Connection connect() throws Exception{
        Connection con;
        try {
            String host = "jdbc:mysql://localhost:3306/travel";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(host, username, password);
        } catch (SQLException e) {
            throw new Exception("Koneksi gagal");
        }
        return con;
    }    
}
