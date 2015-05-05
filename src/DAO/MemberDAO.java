/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.Member;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Nanda
 */
public class MemberDAO extends ConnectionDB{
     
    private Connection connection;
    
    
    public MemberDAO(){
        try {
            connection = super.connect();
        } catch (Exception e) {
            e.getMessage();
        }    
    }
    
    public boolean addMember(Member member){
        boolean isSuccess = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `travel`.`member` (`id_member`, `nama`, `alamat`, `no_ktp`, `no_hp`, `username`, `password`, `privilege`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, member.getNama());  
            preparedStatement.setString(2, member.getAlamat());  
            preparedStatement.setString(3, member.getNoKtp()); 
            preparedStatement.setString(4, member.getNoHp()); 
            preparedStatement.setString(5, member.getUsername()); 
            preparedStatement.setString(6, member.getPassword());
            preparedStatement.setString(7, member.getPrivilege());
            preparedStatement.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return isSuccess;
    }
    
    public boolean deleteMember(Member member){
        boolean isSuccess = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `travel`.`member` WHERE `member`.`id_member` = ?");
            preparedStatement.setInt(1, member.getIdMember());  
            preparedStatement.executeUpdate();  
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
        return isSuccess;
    }
    
    public boolean updateMember(Member member){
        boolean isSuccess = false;
         try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `travel`.`member` SET `nama` = ?, `alamat` = ?, `no_ktp` = ?, `no_hp` = ?, `username` = ?, `password` = ?, `privilege` = ? WHERE `member`.`id_member` = ?");
            preparedStatement.setString(1, member.getNama());  
            preparedStatement.setString(2, member.getAlamat());  
            preparedStatement.setString(3, member.getNoKtp()); 
            preparedStatement.setString(4, member.getNoHp()); 
            preparedStatement.setString(5, member.getUsername()); 
            preparedStatement.setString(6, member.getPassword());
            preparedStatement.setString(7, member.getPrivilege());
            preparedStatement.setInt(8, member.getIdMember());
            preparedStatement.executeUpdate();  
            isSuccess = true;
        } catch (SQLException e) {
            e.getMessage();
        }
         return isSuccess;
    }
    
    public ArrayList<Member> getAllMember(){
        ArrayList<Member> members = new ArrayList<>();
        try{
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String sql = "SELECT * from member";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Member member = new Member();
                member.setIdMember(rs.getInt("id_member")); 
                member.setNama(rs.getString("nama"));
                member.setNoHp(rs.getString("no_hp"));
                member.setNoKtp(rs.getString("no_ktp"));
                member.setPassword(rs.getString("password"));
                member.setPrivilege(rs.getString("privilege"));
                member.setUsername(rs.getString("username"));
                member.setAlamat(rs.getString("alamat"));
                members.add(member);
            }
        } catch (SQLException error){
                error.getMessage();
        }
        return members;
    }
    
    public Member getMemberById(int idMember){
        Member member = new Member();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from member where id_member = ?");
            preparedStatement.setInt(1,idMember);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                member.setIdMember(rs.getInt("id_member")); 
                member.setNama(rs.getString("nama"));
                member.setNoHp(rs.getString("no_hp"));
                member.setNoKtp(rs.getString("no_ktp"));
                member.setPassword(rs.getString("password"));
                member.setPrivilege(rs.getString("privilege"));
                member.setUsername(rs.getString("username"));
                member.setAlamat(rs.getString("alamat"));
            }
        } catch (SQLException error){
           error.getMessage();
        }
        return member;
    }
}
