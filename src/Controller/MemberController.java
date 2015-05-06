/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;
import DAO.MemberDAO;
import Model.Member;
import Model.Petugas;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Nanda
 */
public class MemberController {
    MemberDAO memberDAO;
    
    public MemberController() {
        memberDAO = new MemberDAO();
    }
    
    public boolean addMember(Member member){
        boolean isSuccess = false;
        if(memberDAO.addMember(member)){
            isSuccess = true;
        }
        return isSuccess;
    }
    
    public ArrayList<Member> getAllMember(){
        return memberDAO.getAllMember();
    }
    
    public boolean deleteMember(Member member){
        boolean isSuccess = false;
        if(memberDAO.deleteMember(member)){
            isSuccess = true;
        }
        return isSuccess;
    }
    
    public boolean updateMember(Member member){
        boolean isSuccess = false;
        if(memberDAO.updateMember(member)){
            isSuccess = true;
        }
        return isSuccess;
    }
   
    public void populateDatatoJComboboxMember(ArrayList<Member> listMember, JComboBox jComboBoxMember) {
    DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
    for (final Member member : listMember) {
                comboBoxModel.addElement(member);
        }
    jComboBoxMember.setModel(comboBoxModel);
    }

}
