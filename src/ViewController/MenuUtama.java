/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ViewController;
import Controller.*;
import DAO.Auth;
import Model.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.JTable;
/**
 *
 * @author Nanda
 */
public class MenuUtama extends javax.swing.JFrame {
    
    Helper helper;
    MemberController memberController;
    PetugasController petugasController;
    TempatWisataController twController;
    ArrayList<Member> listMember;
    ArrayList<Petugas> listPetugas;
    ArrayList<TempatWisata> listTempatWisata;
    Auth auth;
    /**
     * Creates new form MenuUtama
     */
    public MenuUtama() {
        initComponents();
        memberController = new MemberController();
        petugasController = new PetugasController();
        twController= new TempatWisataController();
        helper = new Helper();
        auth = new Auth();
        viewDataMember();
        disableEnableMember(false);
        viewDataPetugas();
        disableEnablePetugas(false);
        viewDataTempatWisata();
        disableEnableTW(false);
        helper.setSpinnerDate(jSpinnerPetugasTanggal);
    }

    
    private void disableEnableMember(boolean status){
        jButtonMemberEnDi.setEnabled(status);
        jButtonMemberEdit.setEnabled(status);
        jButtonMemberHapus.setEnabled(status);
        if(status){
            jButtonMemberTambah.setEnabled(false);
        }else{
            jButtonMemberTambah.setEnabled(true);
            jTextFieldMemberNama.setText("");
            jTextFieldMemberNoKtp.setText("");
            jTextFieldMemberNoHp.setText("");
            jTextFieldMemberUsername.setText("");
            jPasswordFieldMemberPassword.setText("");
            jTextAreaMemberAlamat.setText("");
            jComboBoxMemberPrivelege.setSelectedIndex(0);
        }
    }
    
    private void disableEnablePetugas(boolean status){
        jButtonPetugasEnDi.setEnabled(status);
        jButtonPetugasEdit.setEnabled(status);
        jButtonPetugasHapus.setEnabled(status);
        if(status){
            jButtonPetugasTambah.setEnabled(false);
        }else{
            jButtonPetugasTambah.setEnabled(true);
            jTextFieldPetugasNama.setText("");
            jTextFieldPetugasNoKtp.setText("");
            jTextFieldPetugasNoHp.setText("");
            jTextFieldPetugasUsername.setText("");
            jPasswordFieldPetugasPassword.setText("");
            jTextAreaPetugasAlamat.setText("");
            jTextFieldPetugasTempat.setText("");
            jSpinnerPetugasGaji.setValue(0);
            helper.setSpinnerDate(jSpinnerPetugasTanggal);
            jComboBoxPetugasPrivelege.setSelectedIndex(0);
        }
    }
    
    private void disableEnableTW(boolean status){
        jButtonTWEnDi.setEnabled(status);
        jButtonTWEdit.setEnabled(status);
        jButtonTWHapus.setEnabled(status);
        if(status){
            jButtonTWTambah.setEnabled(false);
        }else{
            jButtonTWTambah.setEnabled(true);
            jTextFieldTWNama.setText("");
            jTextFieldTWLatLong.setText("");
            jTextAreaTWDeskripsi.setText("");
            jTextAreaTWLokasi.setText("");
        }
    }
    
    private void viewDataMember(){
        listMember = memberController.getAllMember();
        String[] title = {"No","Nama","No KTP","No HP","Username","Privilege"};
        String[][] data = new String[listMember.size()][6];
        for(int i=0;i<listMember.size();i++){
            Member m = listMember.get(i);
            data[i][0] = String.valueOf(i+1);
            data[i][1] = m.getNama();
            data[i][2] = m.getNoKtp();
            data[i][3] = m.getNoHp();
            data[i][4] = m.getUsername();
            data[i][5] = m.getPrivilege();
        }
        jTableMember.setModel(new DefaultTableModel(data, title));
    }
    
    private void viewDataPetugas(){
        listPetugas = petugasController.getAllPetugas();
        String[] title = {"No","Nama","No KTP","No HP","Username","Privilege"};
        String[][] data = new String[listPetugas.size()][6];
        for(int i=0;i<listPetugas.size();i++){
            Petugas p = listPetugas.get(i);
            data[i][0] = String.valueOf(i+1);
//            data[i][1] = String.valueOf(p.getIdPetugas());
            data[i][1] = p.getNama();
            data[i][2] = p.getNoKtp();
            data[i][3] = p.getNoHp();
            data[i][4] = p.getUsername();
            data[i][5] = p.getPrivilege();
        }
//        System.out.println(listPetugas.get(1).getNama());
        jTablePetugas.setModel(new DefaultTableModel(data, title));
    }
    
    private void viewDataTempatWisata(){
        listTempatWisata = twController.getAllTempatWisata();
//        System.out.println(listTempatWisata.get(1));
        String[] title = {"No","Nama","Lokasi","Deskripsi","Lat Long"};
        String[][] data = new String[listTempatWisata.size()][5];
        for(int i=0;i<listTempatWisata.size();i++){
            TempatWisata tw = listTempatWisata.get(i);
            data[i][0] = String.valueOf(i+1);
            data[i][1] = tw.getNama();
            data[i][2] = tw.getLokasi();
            data[i][3] = tw.getDeskripsi();
            data[i][4] = tw.getLatlong();
        }
//        System.out.println(listPetugas.get(1).getNama());
        jTableTW.setModel(new DefaultTableModel(data, title));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMemberAlamat = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMemberNoKtp = new javax.swing.JTextField();
        jTextFieldMemberNoHp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldMemberUsername = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPasswordFieldMemberPassword = new javax.swing.JPasswordField();
        jComboBoxMemberPrivelege = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldMemberNama = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jButtonMemberTambah = new javax.swing.JButton();
        jButtonMemberEdit = new javax.swing.JButton();
        jButtonMemberHapus = new javax.swing.JButton();
        jButtonMemberEnDi = new javax.swing.JButton();
        jButtonMemberPrint = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMember = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaPetugasAlamat = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldPetugasNoKtp = new javax.swing.JTextField();
        jTextFieldPetugasNoHp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldPetugasUsername = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPasswordFieldPetugasPassword = new javax.swing.JPasswordField();
        jComboBoxPetugasPrivelege = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldPetugasNama = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldPetugasTempat = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSpinnerPetugasGaji = new javax.swing.JSpinner();
        jSpinnerPetugasTanggal = new javax.swing.JSpinner();
        jPanel15 = new javax.swing.JPanel();
        jButtonPetugasTambah = new javax.swing.JButton();
        jButtonPetugasEdit = new javax.swing.JButton();
        jButtonPetugasHapus = new javax.swing.JButton();
        jButtonPetugasEnDi = new javax.swing.JButton();
        jButtonPetugasPrint = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablePetugas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaTWLokasi = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldTWNama = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextFieldTWLatLong = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaTWDeskripsi = new javax.swing.JTextArea();
        jPanel20 = new javax.swing.JPanel();
        jButtonTWTambah = new javax.swing.JButton();
        jButtonTWEdit = new javax.swing.JButton();
        jButtonTWHapus = new javax.swing.JButton();
        jButtonTWEnDi = new javax.swing.JButton();
        jButtonTWPrint = new javax.swing.JButton();
        jButtonTWLokasi = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableTW = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextAreaMemberAlamat1 = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jComboBoxMemberPrivelege1 = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jTextFieldMemberNama1 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jSpinner4 = new javax.swing.JSpinner();
        jPanel24 = new javax.swing.JPanel();
        jButtonMemberTambah1 = new javax.swing.JButton();
        jButtonMemberEdit1 = new javax.swing.JButton();
        jButtonMemberHapus1 = new javax.swing.JButton();
        jButtonMemberEnDi1 = new javax.swing.JButton();
        jButtonMemberPrint1 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableMember1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setText("Bedjo Travel Agent");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6);
        jPanel6.setBounds(10, 10, 710, 90);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextAreaMemberAlamat.setColumns(20);
        jTextAreaMemberAlamat.setRows(5);
        jScrollPane1.setViewportView(jTextAreaMemberAlamat);

        jLabel2.setText("Nomor KTP ");

        jLabel4.setText("Nomor HP ");

        jLabel5.setText("Password");

        jLabel6.setText("Privilege ");

        jLabel7.setText("Username");

        jLabel8.setText("Alamat");

        jComboBoxMemberPrivelege.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Member", "Customer" }));

        jLabel9.setText("Nama");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldMemberNama)
                    .addComponent(jTextFieldMemberNoKtp)
                    .addComponent(jTextFieldMemberNoHp)
                    .addComponent(jTextFieldMemberUsername)
                    .addComponent(jPasswordFieldMemberPassword)
                    .addComponent(jComboBoxMemberPrivelege, 0, 207, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldMemberNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldMemberNoKtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldMemberNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldMemberUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jPasswordFieldMemberPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBoxMemberPrivelege, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonMemberTambah.setText("Tambah");
        jButtonMemberTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMemberTambahActionPerformed(evt);
            }
        });

        jButtonMemberEdit.setText("Edit");
        jButtonMemberEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMemberEditActionPerformed(evt);
            }
        });

        jButtonMemberHapus.setText("Hapus");
        jButtonMemberHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMemberHapusActionPerformed(evt);
            }
        });

        jButtonMemberEnDi.setText("Batal");
        jButtonMemberEnDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMemberEnDiActionPerformed(evt);
            }
        });

        jButtonMemberPrint.setText("Print");
        jButtonMemberPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMemberPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonMemberTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButtonMemberEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145)
                .addComponent(jButtonMemberEnDi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonMemberPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(254, 254, 254)
                    .addComponent(jButtonMemberHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(286, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonMemberEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(jButtonMemberEnDi, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(jButtonMemberPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addComponent(jButtonMemberTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButtonMemberHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTableMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMemberMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableMember);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Member", jPanel1);

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextAreaPetugasAlamat.setColumns(20);
        jTextAreaPetugasAlamat.setRows(5);
        jScrollPane3.setViewportView(jTextAreaPetugasAlamat);

        jLabel10.setText("Nomor KTP ");

        jLabel11.setText("Nomor HP ");

        jLabel12.setText("Password");

        jLabel13.setText("Privilege ");

        jLabel14.setText("Username");

        jLabel15.setText("Alamat");

        jComboBoxPetugasPrivelege.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "Petugas" }));

        jLabel16.setText("Nama");

        jLabel17.setText("Tempat Lahir");

        jLabel18.setText("Tanggal Lahir");

        jLabel19.setText("Gaji");

        jSpinnerPetugasGaji.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(500000)));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldPetugasNama)
                    .addComponent(jTextFieldPetugasNoKtp)
                    .addComponent(jTextFieldPetugasNoHp)
                    .addComponent(jTextFieldPetugasUsername)
                    .addComponent(jPasswordFieldPetugasPassword)
                    .addComponent(jComboBoxPetugasPrivelege, 0, 207, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                        .addComponent(jTextFieldPetugasTempat)
                        .addComponent(jSpinnerPetugasGaji))
                    .addComponent(jSpinnerPetugasTanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jTextFieldPetugasNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldPetugasNoKtp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPetugasNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPetugasUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldPetugasTempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jPasswordFieldPetugasPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jSpinnerPetugasTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxPetugasPrivelege, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jSpinnerPetugasGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonPetugasTambah.setText("Tambah");
        jButtonPetugasTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPetugasTambahActionPerformed(evt);
            }
        });

        jButtonPetugasEdit.setText("Edit");
        jButtonPetugasEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPetugasEditActionPerformed(evt);
            }
        });

        jButtonPetugasHapus.setText("Hapus");
        jButtonPetugasHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPetugasHapusActionPerformed(evt);
            }
        });

        jButtonPetugasEnDi.setText("Batal");
        jButtonPetugasEnDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPetugasEnDiActionPerformed(evt);
            }
        });

        jButtonPetugasPrint.setText("Print");
        jButtonPetugasPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPetugasPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonPetugasTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButtonPetugasEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPetugasEnDi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonPetugasPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(254, 254, 254)
                    .addComponent(jButtonPetugasHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(286, Short.MAX_VALUE)))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonPetugasEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(jButtonPetugasEnDi, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(jButtonPetugasPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addComponent(jButtonPetugasTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButtonPetugasHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTablePetugas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablePetugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePetugasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTablePetugas);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Petugas", jPanel2);

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextAreaTWLokasi.setColumns(20);
        jTextAreaTWLokasi.setRows(5);
        jScrollPane5.setViewportView(jTextAreaTWLokasi);

        jLabel25.setText("Lokasi");

        jLabel26.setText("Nama");

        jLabel30.setText("Lat Long");

        jLabel31.setText("Deskripsi");

        jTextAreaTWDeskripsi.setColumns(20);
        jTextAreaTWDeskripsi.setRows(5);
        jScrollPane7.setViewportView(jTextAreaTWDeskripsi);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldTWNama)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldTWLatLong, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextFieldTWNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(jTextFieldTWLatLong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jLabel31)
                    .addComponent(jScrollPane7))
                .addContainerGap())
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonTWTambah.setText("Tambah");
        jButtonTWTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTWTambahActionPerformed(evt);
            }
        });

        jButtonTWEdit.setText("Edit");
        jButtonTWEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTWEditActionPerformed(evt);
            }
        });

        jButtonTWHapus.setText("Hapus");
        jButtonTWHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTWHapusActionPerformed(evt);
            }
        });

        jButtonTWEnDi.setText("Batal");
        jButtonTWEnDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTWEnDiActionPerformed(evt);
            }
        });

        jButtonTWPrint.setText("Print");
        jButtonTWPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTWPrintActionPerformed(evt);
            }
        });

        jButtonTWLokasi.setText("Lokasi");
        jButtonTWLokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTWLokasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonTWTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTWEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTWHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonTWEnDi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTWPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonTWLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonTWEnDi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonTWTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonTWEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonTWHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonTWPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonTWLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTableTW.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableTW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTWMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableTW);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 655, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Tempat Wisata", jPanel3);

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextAreaMemberAlamat1.setColumns(20);
        jTextAreaMemberAlamat1.setRows(5);
        jScrollPane8.setViewportView(jTextAreaMemberAlamat1);

        jLabel20.setText("Batas Peseta");

        jLabel21.setText("Harga");

        jLabel22.setText("Lama Hari");

        jLabel23.setText("Tempat Wisata");

        jLabel24.setText("Jumlah Paket");

        jLabel27.setText("Fasilitas");

        jLabel28.setText("Nama");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldMemberNama1)
                    .addComponent(jComboBoxMemberPrivelege1, 0, 207, Short.MAX_VALUE)
                    .addComponent(jSpinner1)
                    .addComponent(jSpinner2)
                    .addComponent(jSpinner3)
                    .addComponent(jSpinner4))
                .addGap(18, 18, 18)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jTextFieldMemberNama1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jComboBoxMemberPrivelege1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7))
                    .addComponent(jScrollPane8))
                .addContainerGap())
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonMemberTambah1.setText("Tambah");
        jButtonMemberTambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMemberTambah1ActionPerformed(evt);
            }
        });

        jButtonMemberEdit1.setText("Edit");
        jButtonMemberEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMemberEdit1ActionPerformed(evt);
            }
        });

        jButtonMemberHapus1.setText("Hapus");
        jButtonMemberHapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMemberHapus1ActionPerformed(evt);
            }
        });

        jButtonMemberEnDi1.setText("Batal");
        jButtonMemberEnDi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMemberEnDi1ActionPerformed(evt);
            }
        });

        jButtonMemberPrint1.setText("Print");
        jButtonMemberPrint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMemberPrint1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonMemberTambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButtonMemberEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145)
                .addComponent(jButtonMemberEnDi1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonMemberPrint1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(254, 254, 254)
                    .addComponent(jButtonMemberHapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(286, Short.MAX_VALUE)))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonMemberEdit1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(jButtonMemberEnDi1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(jButtonMemberPrint1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addComponent(jButtonMemberTambah1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButtonMemberHapus1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTableMember1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableMember1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMember1MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTableMember1);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Paket Wisata", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Transaksi", jPanel5);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7);
        jPanel7.setBounds(10, 120, 710, 560);

        setBounds(0, 0, 748, 724);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMemberMouseClicked
        // TODO add your handling code here:
        Member member = listMember.get(jTableMember.getSelectedRow());
        jTextFieldMemberNama.setText(member.getNama());
        jTextFieldMemberNoKtp.setText(member.getNoKtp());
        jTextFieldMemberNoHp.setText(member.getNoHp());
        jTextFieldMemberUsername.setText(member.getUsername());
        jTextAreaMemberAlamat.setText(member.getAlamat());
        int selectedIndex = 0;
        switch(member.getPrivilege()){
            case "Member" :
                selectedIndex = 0;
                break;
            case "Customer" :
                selectedIndex = 1;
                break;
        }
        jComboBoxMemberPrivelege.setSelectedIndex(selectedIndex);
        disableEnableMember(true);
    }//GEN-LAST:event_jTableMemberMouseClicked

    private void jButtonMemberTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMemberTambahActionPerformed
        // TODO add your handling code here:
        String nama = jTextFieldMemberNama.getText();
        String alamat = jTextAreaMemberAlamat.getText() ;
        String noKtp = jTextFieldMemberNoKtp.getText();
        String noHp = jTextFieldMemberNoHp.getText();
        String username = jTextFieldMemberUsername.getText();
        String password = auth.encodeToMD5(jPasswordFieldMemberPassword.getText());
        String privilege = "";
        switch(jComboBoxMemberPrivelege.getSelectedIndex()){
            case 0 :
                privilege = "Member";
                break;
            case 1 :
                privilege = "Customer";
                break;
        }
        if(nama.equals("")||alamat.equals("")||noKtp.equals("")||noHp.equals("")
           ||username.equals("")||password.equals("")||privilege.equals("")){
            helper.sendMessage("Data harus diisi semua", "Gagal");
        }else{
            Member member = new Member(nama, alamat, noKtp, noHp, username, password, privilege);
            if(memberController.addMember(member)){
                helper.sendMessage("Data member berhasil ditambah", "Berhasil");
            }else{
                helper.sendMessage("Data member gagal ditambah", "Gagal");
            }
            disableEnableMember(false);
            viewDataMember();
        }
        
    }//GEN-LAST:event_jButtonMemberTambahActionPerformed

    private void jButtonMemberEnDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMemberEnDiActionPerformed
        // TODO add your handling code here:
        disableEnableMember(false);
        jTableMember.clearSelection();
    }//GEN-LAST:event_jButtonMemberEnDiActionPerformed

    private void jButtonMemberHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMemberHapusActionPerformed
        // TODO add your handling code here:
        Member member = listMember.get(jTableMember.getSelectedRow());
        if(memberController.deleteMember(member)){
            helper.sendMessage("Data member berhasil dihapus", "Berhasil");
        }else{
            helper.sendMessage("Data member gagal dihapus", "Gagal");
        }
        disableEnableMember(false);
        viewDataMember();
    }//GEN-LAST:event_jButtonMemberHapusActionPerformed

    private void jButtonMemberEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMemberEditActionPerformed
        // TODO add your handling code here:
        int idMember = listMember.get(jTableMember.getSelectedRow()).getIdMember();
        String nama = jTextFieldMemberNama.getText();
        String alamat = jTextAreaMemberAlamat.getText() ;
        String noKtp = jTextFieldMemberNoKtp.getText();
        String noHp = jTextFieldMemberNoHp.getText();
        String username = jTextFieldMemberUsername.getText();
        String password = jPasswordFieldMemberPassword.getText();
        String privilege = "";
        switch(jComboBoxMemberPrivelege.getSelectedIndex()){
            case 0 :
                privilege = "Member";
                break;
            case 1 :
                privilege = "Customer";
                break;
        }
        if(nama.equals("")||alamat.equals("")||noKtp.equals("")||noHp.equals("")
           ||username.equals("")||password.equals("")||privilege.equals("")){
            helper.sendMessage("Data harus diisi semua", "Gagal");
        }else{
            password = auth.encodeToMD5(jPasswordFieldMemberPassword.getText());
            Member member = new Member(idMember,nama, alamat, noKtp, noHp, username, password, privilege);
            if(memberController.updateMember(member)){
                helper.sendMessage("Data member berhasil di edit", "Berhasil");
            }else{
                helper.sendMessage("Data member gagal di edit", "Gagal");
            }
            disableEnableMember(false);
            viewDataMember();
        }
    }//GEN-LAST:event_jButtonMemberEditActionPerformed

    private void jButtonPetugasTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPetugasTambahActionPerformed
        // TODO add your handling code here:
        String nama = jTextFieldPetugasNama.getText();
        String alamat = jTextAreaPetugasAlamat.getText() ;
        String noKtp = jTextFieldPetugasNoKtp.getText();
        String noHp = jTextFieldPetugasNoHp.getText();
        String username = jTextFieldPetugasUsername.getText();
        String password = auth.encodeToMD5(jPasswordFieldPetugasPassword.getText());
        String tempatLahir = jTextFieldPetugasTempat.getText();
        Date tanggal = (Date)jSpinnerPetugasTanggal.getValue();
        java.sql.Date tanggaLahir = new java.sql.Date(tanggal.getTime());
        int gaji = (int)jSpinnerPetugasGaji.getValue();
        String privilege = "";
        switch(jComboBoxPetugasPrivelege.getSelectedIndex()){
            case 0 :
                privilege = "Admin";
                break;
            case 1 :
                privilege = "Petugas";
                break;
        }
        if(nama.equals("")||alamat.equals("")||noKtp.equals("")||noHp.equals("")
           ||username.equals("")||password.equals("")||privilege.equals("")||tanggaLahir.equals("")||gaji==0){
            helper.sendMessage("Data harus diisi semua", "Gagal");
        }else{
            Petugas petugas = new Petugas(nama, alamat, noKtp, noHp, username, password, privilege, tempatLahir, tanggaLahir, gaji);
            if(petugasController.addPetugas(petugas)){
                helper.sendMessage("Data petugas berhasil ditambah", "Berhasil");
            }else{
                helper.sendMessage("Data petugas gagal ditambah", "Gagal");
            }
            disableEnablePetugas(false);
            viewDataPetugas();
        }
    }//GEN-LAST:event_jButtonPetugasTambahActionPerformed

    private void jButtonPetugasEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPetugasEditActionPerformed
        // TODO add your handling code here:
        int idPetugas = listPetugas.get(jTablePetugas.getSelectedRow()).getIdPetugas();
        String nama = jTextFieldPetugasNama.getText();
        String alamat = jTextAreaPetugasAlamat.getText() ;
        String noKtp = jTextFieldPetugasNoKtp.getText();
        String noHp = jTextFieldPetugasNoHp.getText();
        String username = jTextFieldPetugasUsername.getText();
        String password = jPasswordFieldPetugasPassword.getText();
        String tempatLahir = jTextFieldPetugasTempat.getText();
        Date tanggal = (Date)jSpinnerPetugasTanggal.getValue();
        java.sql.Date tanggaLahir = new java.sql.Date(tanggal.getTime());
        int gaji = (int)jSpinnerPetugasGaji.getValue();
        String privilege = "";
        switch(jComboBoxPetugasPrivelege.getSelectedIndex()){
            case 0 :
                privilege = "Admin";
                break;
            case 1 :
                privilege = "Petugas";
                break;
        }
        if(nama.equals("")||alamat.equals("")||noKtp.equals("")||noHp.equals("")
           ||username.equals("")||password.equals("")||privilege.equals("")||tanggaLahir.equals("")||gaji==0){
            helper.sendMessage("Data harus diisi semua", "Gagal");
        }else{
            password = auth.encodeToMD5(jPasswordFieldPetugasPassword.getText());
            Petugas petugas = new Petugas(idPetugas,nama, alamat, noKtp, noHp, username, password, privilege, tempatLahir, tanggaLahir, gaji);
            if(petugasController.updatePetugas(petugas)){
                helper.sendMessage("Data petugas berhasil di edit", "Berhasil");
            }else{
                helper.sendMessage("Data petugas gagal di edit", "Gagal");
            }
            disableEnablePetugas(false);
            viewDataPetugas();
        }
    }//GEN-LAST:event_jButtonPetugasEditActionPerformed

    private void jButtonPetugasHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPetugasHapusActionPerformed
        // TODO add your handling code here:
        Petugas petugas = listPetugas.get(jTablePetugas.getSelectedRow());
        if(petugasController.deletePetugas(petugas)){
            helper.sendMessage("Data petugas berhasil dihapus", "Berhasil");
        }else{
            helper.sendMessage("Data petugas gagal dihapus", "Gagal");
        }
        disableEnablePetugas(false);
        viewDataPetugas();
    }//GEN-LAST:event_jButtonPetugasHapusActionPerformed

    private void jButtonPetugasEnDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPetugasEnDiActionPerformed
        // TODO add your handling code here:
        disableEnablePetugas(false);
        jTablePetugas.clearSelection();
    }//GEN-LAST:event_jButtonPetugasEnDiActionPerformed

    private void jTablePetugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePetugasMouseClicked
        // TODO add your handling code here:
        Petugas petugas = listPetugas.get(jTablePetugas.getSelectedRow());
        jTextFieldPetugasNama.setText(petugas.getNama());
        jTextFieldPetugasNoKtp.setText(petugas.getNoKtp());
        jTextFieldPetugasNoHp.setText(petugas.getNoHp());
        jTextFieldPetugasUsername.setText(petugas.getUsername());
        jTextAreaPetugasAlamat.setText(petugas.getAlamat());
        int selectedIndex = 0;
        switch(petugas.getPrivilege()){
            case "Admin" :
                selectedIndex = 0;
                break;
            case "Petugas" :
                selectedIndex = 1;
                break;
        }
        jComboBoxPetugasPrivelege.setSelectedIndex(selectedIndex);
        jTextFieldPetugasTempat.setText(petugas.getTempatLahir());
        jSpinnerPetugasGaji.setValue(petugas.getGaji());
        jSpinnerPetugasTanggal.setValue(petugas.getTanggalLahir());
        disableEnablePetugas(true);
    }//GEN-LAST:event_jTablePetugasMouseClicked

    private void jButtonPetugasPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPetugasPrintActionPerformed
        helper.printTable("Laporan Petugas", jTablePetugas);

    }//GEN-LAST:event_jButtonPetugasPrintActionPerformed

    private void jButtonTWTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTWTambahActionPerformed
        // TODO add your handling code here:
        String nama = jTextFieldTWNama.getText();
        String lokasi = jTextAreaTWLokasi.getText() ;
        String deskripsi = jTextAreaTWDeskripsi.getText();
        String latlong = jTextFieldTWLatLong.getText();
       if(nama.equals("")||lokasi.equals("")||deskripsi.equals("")||latlong.equals("")){
            helper.sendMessage("Data harus diisi semua", "Gagal");
        }else{
           TempatWisata tw = new TempatWisata(nama, lokasi, deskripsi, latlong);
            if(twController.addTempatWisata(tw)){
                helper.sendMessage("Data tempat wisata berhasil ditambah", "Berhasil");
            }else{
                helper.sendMessage("Data tempat wisata gagal ditambah", "Gagal");
            }
            disableEnableTW(false);
            viewDataTempatWisata();
        }

    }//GEN-LAST:event_jButtonTWTambahActionPerformed

    private void jButtonTWEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTWEditActionPerformed
        // TODO add your handling code here:
        int idTempatWisata = listTempatWisata.get(jTableTW.getSelectedRow()).getIdTempatWisata();
        String nama = jTextFieldTWNama.getText();
        String lokasi = jTextAreaTWLokasi.getText() ;
        String deskripsi = jTextAreaTWDeskripsi.getText();
        String latlong = jTextFieldTWLatLong.getText();
       if(nama.equals("")||lokasi.equals("")||deskripsi.equals("")||latlong.equals("")){
            helper.sendMessage("Data harus diisi semua", "Gagal");
        }else{
           TempatWisata tw = new TempatWisata(idTempatWisata, nama, lokasi, deskripsi, latlong);
            if(twController.updateTempatWisata(tw)){
                helper.sendMessage("Data tempat wisata berhasil di edit", "Berhasil");
            }else{
                helper.sendMessage("Data tempat wisata gagal di edit", "Gagal");
            }
            disableEnableTW(false);
            viewDataTempatWisata();
        }
    }//GEN-LAST:event_jButtonTWEditActionPerformed

    private void jButtonTWHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTWHapusActionPerformed
        // TODO add your handling code here:
        TempatWisata tw = listTempatWisata.get(jTableTW.getSelectedRow());
        if(twController.deleteTempatWisata(tw)){
            helper.sendMessage("Data tempat wisata berhasil dihapus", "Berhasil");
        }else{
            helper.sendMessage("Data tempat wisata gagal dihapus", "Gagal");
        }
        disableEnableTW(false);
        viewDataTempatWisata();
    }//GEN-LAST:event_jButtonTWHapusActionPerformed

    private void jButtonTWEnDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTWEnDiActionPerformed
        // TODO add your handling code here:
        disableEnableTW(false);
        jTableTW.clearSelection();
    }//GEN-LAST:event_jButtonTWEnDiActionPerformed

    private void jButtonTWPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTWPrintActionPerformed
        // TODO add your handling code here:
        helper.printTable("Laporan Tempat Wisata", jTableTW);
    }//GEN-LAST:event_jButtonTWPrintActionPerformed

    private void jTableTWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTWMouseClicked
        TempatWisata tw = listTempatWisata.get(jTableTW.getSelectedRow());
        jTextFieldTWNama.setText(tw.getNama());
        jTextFieldTWLatLong.setText(tw.getLatlong());
        jTextAreaTWDeskripsi.setText(tw.getDeskripsi());
        jTextAreaTWLokasi.setText(tw.getLokasi());
        disableEnableTW(true);
    }//GEN-LAST:event_jTableTWMouseClicked

    private void jButtonTWLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTWLokasiActionPerformed
        // TODO add your handling code here:
        String latlong = jTextFieldTWLatLong.getText();
        if(helper.cekKoneksi()){
            if(!(latlong.equals(""))){
                new Lokasi(latlong).setVisible(true);
            }else{
                helper.sendMessage("Pilih dari tabel dulu", "Gagal");
            }
        }else{
            helper.sendMessage("Periksa Koneksi anda", "Gagal");
        }
        
        
    }//GEN-LAST:event_jButtonTWLokasiActionPerformed

    private void jButtonMemberPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMemberPrintActionPerformed
        // TODO add your handling code here:
        helper.printTable("Laporan Member", jTableMember);
    }//GEN-LAST:event_jButtonMemberPrintActionPerformed

    private void jButtonMemberTambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMemberTambah1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMemberTambah1ActionPerformed

    private void jButtonMemberEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMemberEdit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMemberEdit1ActionPerformed

    private void jButtonMemberHapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMemberHapus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMemberHapus1ActionPerformed

    private void jButtonMemberEnDi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMemberEnDi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMemberEnDi1ActionPerformed

    private void jButtonMemberPrint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMemberPrint1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMemberPrint1ActionPerformed

    private void jTableMember1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMember1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableMember1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonMemberEdit;
    private javax.swing.JButton jButtonMemberEdit1;
    private javax.swing.JButton jButtonMemberEnDi;
    private javax.swing.JButton jButtonMemberEnDi1;
    private javax.swing.JButton jButtonMemberHapus;
    private javax.swing.JButton jButtonMemberHapus1;
    private javax.swing.JButton jButtonMemberPrint;
    private javax.swing.JButton jButtonMemberPrint1;
    private javax.swing.JButton jButtonMemberTambah;
    private javax.swing.JButton jButtonMemberTambah1;
    private javax.swing.JButton jButtonPetugasEdit;
    private javax.swing.JButton jButtonPetugasEnDi;
    private javax.swing.JButton jButtonPetugasHapus;
    private javax.swing.JButton jButtonPetugasPrint;
    private javax.swing.JButton jButtonPetugasTambah;
    private javax.swing.JButton jButtonTWEdit;
    private javax.swing.JButton jButtonTWEnDi;
    private javax.swing.JButton jButtonTWHapus;
    private javax.swing.JButton jButtonTWLokasi;
    private javax.swing.JButton jButtonTWPrint;
    private javax.swing.JButton jButtonTWTambah;
    private javax.swing.JComboBox jComboBoxMemberPrivelege;
    private javax.swing.JComboBox jComboBoxMemberPrivelege1;
    private javax.swing.JComboBox jComboBoxPetugasPrivelege;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordFieldMemberPassword;
    private javax.swing.JPasswordField jPasswordFieldPetugasPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinnerPetugasGaji;
    private javax.swing.JSpinner jSpinnerPetugasTanggal;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableMember;
    private javax.swing.JTable jTableMember1;
    private javax.swing.JTable jTablePetugas;
    private javax.swing.JTable jTableTW;
    private javax.swing.JTextArea jTextAreaMemberAlamat;
    private javax.swing.JTextArea jTextAreaMemberAlamat1;
    private javax.swing.JTextArea jTextAreaPetugasAlamat;
    private javax.swing.JTextArea jTextAreaTWDeskripsi;
    private javax.swing.JTextArea jTextAreaTWLokasi;
    private javax.swing.JTextField jTextFieldMemberNama;
    private javax.swing.JTextField jTextFieldMemberNama1;
    private javax.swing.JTextField jTextFieldMemberNoHp;
    private javax.swing.JTextField jTextFieldMemberNoKtp;
    private javax.swing.JTextField jTextFieldMemberUsername;
    private javax.swing.JTextField jTextFieldPetugasNama;
    private javax.swing.JTextField jTextFieldPetugasNoHp;
    private javax.swing.JTextField jTextFieldPetugasNoKtp;
    private javax.swing.JTextField jTextFieldPetugasTempat;
    private javax.swing.JTextField jTextFieldPetugasUsername;
    private javax.swing.JTextField jTextFieldTWLatLong;
    private javax.swing.JTextField jTextFieldTWNama;
    // End of variables declaration//GEN-END:variables
}
