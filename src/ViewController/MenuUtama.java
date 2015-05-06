/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ViewController;
import Controller.*;
import DAO.Auth;
import Model.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Nanda
 */
public class MenuUtama extends javax.swing.JFrame {
    
    Helper helper;
    MemberController memberController;
    PetugasController petugasController;
    TempatWisataController twController;
    PaketWisataController pwController;
    TransaksiController transaksiController;
    ArrayList<Member> listMember;
    ArrayList<Petugas> listPetugas;
    ArrayList<TempatWisata> listTempatWisata;
    ArrayList<PaketWisata> listPaketWisata;
    ArrayList<Transaksi> listTransaksi;
    Auth auth;

    /**
     * Creates new form MenuUtama
     */
    public MenuUtama() {
        initComponents();
        memberController = new MemberController();
        petugasController = new PetugasController();
        twController= new TempatWisataController();
        pwController = new PaketWisataController();
        transaksiController = new TransaksiController();
        helper = new Helper();
        auth = new Auth();
        viewDataMember();
        disableEnableMember(false);
        viewDataPetugas();
        disableEnablePetugas(false);
        viewDataTempatWisata();
        disableEnableTW(false);
        viewDataPaketWisata();
        helper.setSpinnerDate(jSpinnerPetugasTanggal,"yyyy-MM-dd");
        helper.setSpinnerDate(jSpinnerTransaksiTanggal, "dd-MM-yyyy");
        disableEnablePaketWisata(false);
        setSpinnerJumlahKelompok(false);
        disableEnableTransaksi(false);
        viewDataTransaksi();
    }

    private void setSpinnerJumlahKelompok(boolean status){
        jSpinnerTransaksiJmlKel.setEnabled(status);
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
            helper.setSpinnerDate(jSpinnerPetugasTanggal,"yyyy-MM-dd");
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

    private void disableEnablePaketWisata(boolean status){
        jButtonPWEnDi.setEnabled(status);
        jButtonPWEdit.setEnabled(status);
        jButtonPWHapus.setEnabled(status);
        if(status){
            jButtonPWTambah.setEnabled(false);
        }else{
            jButtonPWTambah.setEnabled(true);
            jTextFieldPWNama.setText("");
            jSpinnerPWBatas.setValue(0);
            jSpinnerPWHarga.setValue(0);
            jSpinnerPWJumlah.setValue(0);
            jSpinnerPWLama.setValue(0);
            jComboBoxPWTempat.setSelectedIndex(0);
            jTextAreaPWFasilitas.setText("");
        }
    }
    
    private void disableEnableTransaksi(boolean status){
        jButtonTransaksiEnDi.setEnabled(status);
        jButtonTransaksiEdit.setEnabled(status);
        jButtonTransaksiHapus.setEnabled(status);
        if(status){
            jButtonTransaksiTambah.setEnabled(false);
        }else{
            jButtonTransaksiTambah.setEnabled(true);
            jComboBoxTransaksiJenis.setSelectedIndex(0);
            jComboBoxTransaksiMember.setSelectedIndex(0);
            jComboBoxTransaksiPaket.setSelectedIndex(0);
            jComboBoxTransaksiPetugas.setSelectedIndex(0);
            jComboBoxTransaksiStatus.setSelectedIndex(0);
            jComboBoxTransaksiJenis.setSelectedIndex(0);
            jSpinnerTransaksiJmlKel.setValue(0);
            jSpinnerTransaksiJmlOrang.setValue(0);
            helper.setSpinnerDate(jSpinnerTransaksiTanggal, "dd-MM-yyyy");
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
        memberController.populateDatatoJComboboxMember(listMember, jComboBoxTransaksiMember);
    }
    
    private void viewDataPetugas(){
        listPetugas = petugasController.getAllPetugas();
        String[] title = {"No","Nama","No KTP","No HP","Username","Privilege"};
        String[][] data = new String[listPetugas.size()][6];
        for(int i=0;i<listPetugas.size();i++){
            Petugas p = listPetugas.get(i);
            data[i][0] = String.valueOf(i+1);
            data[i][1] = p.getNama();
            data[i][2] = p.getNoKtp();
            data[i][3] = p.getNoHp();
            data[i][4] = p.getUsername();
            data[i][5] = p.getPrivilege();
        }
        jTablePetugas.setModel(new DefaultTableModel(data, title));
        petugasController.populateDatatoJComboboxPetugas(listPetugas, jComboBoxTransaksiPetugas);
    }
    
    private void viewDataTempatWisata(){
        listTempatWisata = twController.getAllTempatWisata();
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
        jTableTW.setModel(new DefaultTableModel(data, title));
        twController.populateDatatoJComboboxTWTempat(listTempatWisata,jComboBoxPWTempat);
    }
    
    private void viewDataPaketWisata(){
        listPaketWisata = pwController.getAllPaketWisata();
        String[] title = {"No","Nama Paket","Peserta","Harga","Tempat Wisata","Jumlah Paket", "Lama Hari"};
        String[][] data = new String[listPaketWisata.size()][7];
//            System.out.println(listPaketWisata);
        for(int i=0;i<listPaketWisata.size();i++){
            PaketWisata p = listPaketWisata.get(i);
            data[i][0] = String.valueOf(i+1);
            data[i][1] = p.getNama();
            data[i][2] = String.valueOf(p.getBatasPeserta());
            data[i][3] = String.valueOf(p.getHarga());
            data[i][4] = p.getTempatWisata();
            data[i][5] = String.valueOf(p.getJumlahPaket());
            data[i][6] = String.valueOf(p.getLamaHari());
        }
        jTablePaketWisata.setModel(new DefaultTableModel(data, title));
        pwController.populateDatatoJComboboxPW(listPaketWisata, jComboBoxTransaksiPaket);
    }

     private void viewDataTransaksi(){
        listTransaksi = transaksiController.getAllTransaksi();
        String[] title = {"No","Member","Petugas","Paket","Jenis Pesan","Jum.Kelompok", "Jum. Orang","Status","Tanggal"};
        String[][] data = new String[listTransaksi.size()][9];
        for(int i=0;i<listTransaksi.size();i++){
            Transaksi t = listTransaksi.get(i);
            data[i][0] = String.valueOf(i+1);
            data[i][1] = t.getNamaMember();
            data[i][2] = t.getNamaPetugas();
            data[i][3] = t.getNamaPaket();
            data[i][4] = t.getJenis_pesan();
            data[i][5] = String.valueOf(t.getJumlah_kelompok());
            data[i][6] = String.valueOf(t.getJumlah_orang());
            data[i][7] = t.getStatus();
            data[i][8] = t.getTanggal().toString();
        }
        jTableTransaksi.setModel(new DefaultTableModel(data, title));
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
        jTextAreaPWFasilitas = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jComboBoxPWTempat = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jTextFieldPWNama = new javax.swing.JTextField();
        jSpinnerPWBatas = new javax.swing.JSpinner();
        jSpinnerPWJumlah = new javax.swing.JSpinner();
        jSpinnerPWHarga = new javax.swing.JSpinner();
        jSpinnerPWLama = new javax.swing.JSpinner();
        jPanel24 = new javax.swing.JPanel();
        jButtonPWTambah = new javax.swing.JButton();
        jButtonPWEdit = new javax.swing.JButton();
        jButtonPWHapus = new javax.swing.JButton();
        jButtonPWEnDi = new javax.swing.JButton();
        jButtonPWPrint = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTablePaketWisata = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jComboBoxTransaksiPetugas = new javax.swing.JComboBox();
        jLabel37 = new javax.swing.JLabel();
        jSpinnerTransaksiJmlKel = new javax.swing.JSpinner();
        jComboBoxTransaksiMember = new javax.swing.JComboBox();
        jComboBoxTransaksiPaket = new javax.swing.JComboBox();
        jComboBoxTransaksiJenis = new javax.swing.JComboBox();
        jSpinnerTransaksiJmlOrang = new javax.swing.JSpinner();
        jComboBoxTransaksiStatus = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        jSpinnerTransaksiTanggal = new javax.swing.JSpinner();
        jPanel28 = new javax.swing.JPanel();
        jButtonTransaksiTambah = new javax.swing.JButton();
        jButtonTransaksiEdit = new javax.swing.JButton();
        jButtonTransaksiHapus = new javax.swing.JButton();
        jButtonTransaksiEnDi = new javax.swing.JButton();
        jButtonTransaksiPrint = new javax.swing.JButton();
        jButtonTransaksiChart = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTableTransaksi = new javax.swing.JTable();

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
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
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
            .addGap(0, 687, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
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
            .addGap(0, 508, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Tempat Wisata", jPanel3);

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextAreaPWFasilitas.setColumns(20);
        jTextAreaPWFasilitas.setRows(5);
        jScrollPane8.setViewportView(jTextAreaPWFasilitas);

        jLabel20.setText("Batas Peserta");

        jLabel21.setText("Harga");

        jLabel22.setText("Lama Hari");

        jLabel23.setText("Tempat Wisata");

        jLabel24.setText("Jumlah Paket");

        jLabel27.setText("Fasilitas");

        jLabel28.setText("Nama Paket");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldPWNama)
                    .addComponent(jComboBoxPWTempat, 0, 207, Short.MAX_VALUE)
                    .addComponent(jSpinnerPWBatas)
                    .addComponent(jSpinnerPWJumlah)
                    .addComponent(jSpinnerPWHarga)
                    .addComponent(jSpinnerPWLama))
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
                            .addComponent(jTextFieldPWNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jSpinnerPWBatas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jSpinnerPWHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jSpinnerPWJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jSpinnerPWLama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jComboBoxPWTempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7))
                    .addComponent(jScrollPane8))
                .addContainerGap())
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonPWTambah.setText("Tambah");
        jButtonPWTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPWTambahActionPerformed(evt);
            }
        });

        jButtonPWEdit.setText("Edit");
        jButtonPWEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPWEditActionPerformed(evt);
            }
        });

        jButtonPWHapus.setText("Hapus");
        jButtonPWHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPWHapusActionPerformed(evt);
            }
        });

        jButtonPWEnDi.setText("Batal");
        jButtonPWEnDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPWEnDiActionPerformed(evt);
            }
        });

        jButtonPWPrint.setText("Print");
        jButtonPWPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPWPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonPWTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButtonPWEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jButtonPWHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonPWEnDi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonPWPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonPWEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(jButtonPWEnDi, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(jButtonPWPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(jButtonPWHapus, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                    .addComponent(jButtonPWTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTablePaketWisata.setModel(new javax.swing.table.DefaultTableModel(
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
        jTablePaketWisata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePaketWisataMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTablePaketWisata);

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
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
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

        jPanel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel29.setText("Member");

        jLabel32.setText("Paket Wisata");

        jLabel33.setText("Jumlah Kelompok");

        jLabel34.setText("Jumlah Orang");

        jLabel35.setText("Jenis Pesan");

        jLabel36.setText("Status");

        jLabel37.setText("Petugas");

        jComboBoxTransaksiJenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Perorangan", "Kelompok" }));
        jComboBoxTransaksiJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTransaksiJenisActionPerformed(evt);
            }
        });

        jComboBoxTransaksiStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jadi", "Batal" }));

        jLabel38.setText("Tanggal");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBoxTransaksiPaket, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxTransaksiMember, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxTransaksiPetugas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxTransaksiJenis, 0, 208, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBoxTransaksiStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, 212, Short.MAX_VALUE)
                    .addComponent(jSpinnerTransaksiJmlOrang, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinnerTransaksiJmlKel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinnerTransaksiTanggal))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jSpinnerTransaksiJmlKel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(jSpinnerTransaksiJmlOrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(jComboBoxTransaksiStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jSpinnerTransaksiTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jComboBoxTransaksiPetugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jComboBoxTransaksiMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(jComboBoxTransaksiPaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jComboBoxTransaksiJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56))
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonTransaksiTambah.setText("Tambah");
        jButtonTransaksiTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransaksiTambahActionPerformed(evt);
            }
        });

        jButtonTransaksiEdit.setText("Edit");
        jButtonTransaksiEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransaksiEditActionPerformed(evt);
            }
        });

        jButtonTransaksiHapus.setText("Hapus");
        jButtonTransaksiHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransaksiHapusActionPerformed(evt);
            }
        });

        jButtonTransaksiEnDi.setText("Batal");
        jButtonTransaksiEnDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransaksiEnDiActionPerformed(evt);
            }
        });

        jButtonTransaksiPrint.setText("Print");
        jButtonTransaksiPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransaksiPrintActionPerformed(evt);
            }
        });

        jButtonTransaksiChart.setText("Laporan");
        jButtonTransaksiChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTransaksiChartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonTransaksiTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTransaksiEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonTransaksiHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonTransaksiEnDi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonTransaksiPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonTransaksiChart, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonTransaksiHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTransaksiEnDi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel28Layout.createSequentialGroup()
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonTransaksiPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonTransaksiChart, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButtonTransaksiEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTransaksiTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTransaksiMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTableTransaksi);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transaksi", jPanel26);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7);
        jPanel7.setBounds(10, 120, 710, 520);

        setBounds(0, 0, 748, 699);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTransaksiMouseClicked
        // TODO add your handling code here:
        Transaksi t = listTransaksi.get(jTableTransaksi.getSelectedRow());
        jSpinnerTransaksiJmlKel.setValue(t.getJumlah_kelompok());
        jSpinnerTransaksiJmlOrang.setValue(t.getJumlah_orang());
        jSpinnerTransaksiTanggal.setValue(t.getTanggal());
        switch(t.getJenis_pesan()){
            case "Perorangan":
                jComboBoxTransaksiJenis.setSelectedIndex(0);
                break;
            case "Kelompok":
                jComboBoxTransaksiJenis.setSelectedIndex(1);
                break;
        }
        switch(t.getStatus()){
            case "Jadi":
                jComboBoxTransaksiStatus.setSelectedIndex(0);
                break;
            case "Batal":
                jComboBoxTransaksiStatus.setSelectedIndex(1);
                break;
        }
        
        for(int i=0;i<listPetugas.size();i++){
            if(listPetugas.get(i).getIdPetugas()==t.getId_petugas()){
                jComboBoxTransaksiPetugas.setSelectedIndex(i);
                break;
            }
        }
        for(int i=0;i<listMember.size();i++){
            if(listMember.get(i).getIdMember()==t.getId_member()){
                jComboBoxTransaksiMember.setSelectedIndex(i);
                break;
            }
        }
        for(int i=0;i<listPaketWisata.size();i++){
            if(listPaketWisata.get(i).getIdPaketWisata()==t.getId_paketwisata()){
                jComboBoxTransaksiPaket.setSelectedIndex(i);
                break;
            }
        }
        
        disableEnableTransaksi(true);
    }//GEN-LAST:event_jTableTransaksiMouseClicked

    private void jButtonTransaksiChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransaksiChartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTransaksiChartActionPerformed

    private void jButtonTransaksiPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransaksiPrintActionPerformed
        // TODO add your handling code here:
        helper.printTable("Laporan Transaksi", jTableTransaksi);
    }//GEN-LAST:event_jButtonTransaksiPrintActionPerformed

    private void jButtonTransaksiEnDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransaksiEnDiActionPerformed
        // TODO add your handling code here:
        disableEnableTransaksi(false);
        jTableTransaksi.clearSelection();
    }//GEN-LAST:event_jButtonTransaksiEnDiActionPerformed

    private void jButtonTransaksiHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransaksiHapusActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        Transaksi transaksi = listTransaksi.get(jTableTransaksi.getSelectedRow());
        if(transaksiController.deleteTransaksi(transaksi)){
            helper.sendMessage("Data transaksi berhasil dihapus", "Berhasil");
        }else{
            helper.sendMessage("Data transaksi gagal dihapus", "Gagal");
        }
        disableEnableTransaksi(false);
        viewDataTransaksi();
    }//GEN-LAST:event_jButtonTransaksiHapusActionPerformed

    private void jButtonTransaksiEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransaksiEditActionPerformed
        // TODO add your handling code here:
                Member m = (Member)jComboBoxTransaksiMember.getSelectedItem();
        Petugas p = (Petugas)jComboBoxTransaksiPetugas.getSelectedItem();
        PaketWisata pk = (PaketWisata)jComboBoxTransaksiPaket.getSelectedItem();
        int idMember = m.getIdMember();
        int idPetugas = p.getIdPetugas();
        int idPaketWisata = pk.getIdPaketWisata();
        String jenis = "";
        switch(jComboBoxTransaksiJenis.getSelectedIndex()){
            case 0:
                jenis = "Perorangan";
                break;
            case 1:
                jenis = "Kelompok";
                break;
        }
        int jumlahKel = (int)jSpinnerTransaksiJmlKel.getValue();
        int jumlahOrang = (int)jSpinnerTransaksiJmlOrang.getValue();
        String status = "";
        switch(jComboBoxTransaksiStatus.getSelectedIndex()){
            case 0:
                status = "Jadi";
                break;
            case 1:
                status = "Batal";
                break;
        }
        Date tgl = (Date)jSpinnerTransaksiTanggal.getValue();
        java.sql.Date tanggal = new java.sql.Date(tgl.getTime());
        int idTransaksi = listTransaksi.get(jTableTransaksi.getSelectedRow()).getId_transaksi();
        if(idMember==0||idPaketWisata==0||idPetugas==0||jenis.equals("")||status.equals("")||jumlahOrang==0){
            helper.sendMessage("Data harus diisi semua", "Gagal");
        }else{
            Transaksi t = new Transaksi(idTransaksi,idPetugas, idMember, idPaketWisata, jenis, jumlahKel, jumlahOrang, status, tanggal);
            if(transaksiController.updateTransaksi(t)){
                helper.sendMessage("Data transaksi berhasil di edit", "Berhasil");
            }else{
                helper.sendMessage("Data transaksi gagal di edit", "Gagal");
            }
            disableEnableTransaksi(false);
            viewDataTransaksi();
        }
    }//GEN-LAST:event_jButtonTransaksiEditActionPerformed

    private void jButtonTransaksiTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTransaksiTambahActionPerformed
        // TODO add your handling code here:
        Member m = (Member)jComboBoxTransaksiMember.getSelectedItem();
        Petugas p = (Petugas)jComboBoxTransaksiPetugas.getSelectedItem();
        PaketWisata pk = (PaketWisata)jComboBoxTransaksiPaket.getSelectedItem();
        int idMember = m.getIdMember();
        int idPetugas = p.getIdPetugas();
        int idPaketWisata = pk.getIdPaketWisata();
        String jenis = "";
        switch(jComboBoxTransaksiJenis.getSelectedIndex()){
            case 0:
                jenis = "Perorangan";
                break;
            case 1:
                jenis = "Kelompok";
                break;
        }
        int jumlahKel = (int)jSpinnerTransaksiJmlKel.getValue();
        int jumlahOrang = (int)jSpinnerTransaksiJmlOrang.getValue();
        String status = "";
        switch(jComboBoxTransaksiStatus.getSelectedIndex()){
            case 0:
                status = "Jadi";
                break;
            case 1:
                status = "Batal";
                break;
        }
        Date tgl = (Date)jSpinnerTransaksiTanggal.getValue();
        java.sql.Date tanggal = new java.sql.Date(tgl.getTime());
        if(idMember==0||idPaketWisata==0||idPetugas==0||jenis.equals("")||status.equals("")||jumlahOrang==0){
            helper.sendMessage("Data harus diisi semua", "Gagal");
        }else{
            Transaksi t = new Transaksi(idPetugas, idMember, idPaketWisata, jenis, jumlahKel, jumlahOrang, status, tanggal);
            if(transaksiController.addTransaksi(t)){
                helper.sendMessage("Data transaksi berhasil di tambah", "Berhasil");
            }else{
                helper.sendMessage("Data transaksi gagal di tambah", "Gagal");
            }
            disableEnableTransaksi(false);
            viewDataTransaksi();
        }
    }//GEN-LAST:event_jButtonTransaksiTambahActionPerformed

    private void jTablePaketWisataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePaketWisataMouseClicked
        // TODO add your handling code here:
        PaketWisata p = listPaketWisata.get(jTablePaketWisata.getSelectedRow());
        jTextFieldPWNama.setText(p.getNama());
        jSpinnerPWBatas.setValue(p.getBatasPeserta());
        jSpinnerPWHarga.setValue(p.getHarga());
        jSpinnerPWJumlah.setValue(p.getJumlahPaket());
        jSpinnerPWLama.setValue(p.getLamaHari());
        for(int i=0;i<listTempatWisata.size();i++){
            if(listTempatWisata.get(i).getIdTempatWisata()==p.getIdTempatWisata()){
                jComboBoxPWTempat.setSelectedIndex(i);
                break;
            }
        }
        jTextAreaPWFasilitas.setText(p.getFasilitas());
        disableEnablePaketWisata(true);
    }//GEN-LAST:event_jTablePaketWisataMouseClicked

    private void jButtonPWPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPWPrintActionPerformed
        // TODO add your handling code here:
        helper.printTable("Laporan Paket Wisata", jTablePaketWisata);
    }//GEN-LAST:event_jButtonPWPrintActionPerformed

    private void jButtonPWEnDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPWEnDiActionPerformed
        // TODO add your handling code here:
        disableEnablePaketWisata(false);
        jTablePaketWisata.clearSelection();
    }//GEN-LAST:event_jButtonPWEnDiActionPerformed

    private void jButtonPWHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPWHapusActionPerformed
        // TODO add your handling code here:
        PaketWisata pw = listPaketWisata.get(jTablePaketWisata.getSelectedRow());
        if(pwController.deletePaketWisata(pw)){
            helper.sendMessage("Data paket wisata berhasil dihapus", "Berhasil");
        }else{
            helper.sendMessage("Data paket wisata gagal dihapus", "Gagal");
        }
        disableEnablePaketWisata(false);
        viewDataPaketWisata();
    }//GEN-LAST:event_jButtonPWHapusActionPerformed

    private void jButtonPWEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPWEditActionPerformed
        // TODO add your handling code here:
        TempatWisata tp = (TempatWisata)jComboBoxPWTempat.getSelectedItem();
        int idTempatWisata = tp.getIdTempatWisata();

        String nama = jTextFieldPWNama.getText();
        int batasPeserta = (int)jSpinnerPWBatas.getValue();
        double harga = Double.parseDouble(jSpinnerPWHarga.getValue()+"");
        int jumlahPaket = (int)jSpinnerPWJumlah.getValue();
        int lamaHari = (int)jSpinnerPWLama.getValue();
        String fasilitas = jTextAreaPWFasilitas.getText();
        int idPaketWisata = listPaketWisata.get(jTablePaketWisata.getSelectedRow()).getIdPaketWisata();
        //        System.out.println(idPaketWisata);
        if(nama.equals("")||batasPeserta==0||harga==0||jumlahPaket==0||lamaHari==0||fasilitas.equals("")){
            helper.sendMessage("Data harus diisi semua", "Gagal");
        }else{
            PaketWisata pw = new PaketWisata(idPaketWisata, nama, batasPeserta, harga, idTempatWisata, jumlahPaket, lamaHari, fasilitas);
            if(pwController.updatePaketWisata(pw)){
                helper.sendMessage("Data paket wisata berhasil di edit", "Berhasil");
            }else{
                helper.sendMessage("Data paket wisata gagal di edit", "Gagal");
            }
            disableEnablePaketWisata(false);
            viewDataPaketWisata();
        }

    }//GEN-LAST:event_jButtonPWEditActionPerformed

    private void jButtonPWTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPWTambahActionPerformed
        // TODO add your handling code here:
        TempatWisata tp = (TempatWisata)jComboBoxPWTempat.getSelectedItem();
        int idTempatWisata = tp.getIdTempatWisata();
        String nama = jTextFieldPWNama.getText();
        int batasPeserta = (int)jSpinnerPWBatas.getValue();
        double harga = Double.parseDouble(jSpinnerPWHarga.getValue()+"");
        int jumlahPaket = (int)jSpinnerPWJumlah.getValue();
        int lamaHari = (int)jSpinnerPWLama.getValue();
        String fasilitas = jTextAreaPWFasilitas.getText();

        if(nama.equals("")||batasPeserta==0||harga==0||jumlahPaket==0||lamaHari==0||fasilitas.equals("")){
            helper.sendMessage("Data harus diisi semua", "Gagal");
        }else{
            PaketWisata pw = new PaketWisata(nama, batasPeserta, harga, idTempatWisata, jumlahPaket, lamaHari, fasilitas);
            if(pwController.addPaketWisata(pw)){
                helper.sendMessage("Data paket wisata berhasil di tambah", "Berhasil");
            }else{
                helper.sendMessage("Data paket wisata gagal di tambah", "Gagal");
            }
            disableEnablePaketWisata(false);
            viewDataPaketWisata();
        }

    }//GEN-LAST:event_jButtonPWTambahActionPerformed

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

    private void jButtonTWPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTWPrintActionPerformed
        // TODO add your handling code here:
        helper.printTable("Laporan Tempat Wisata", jTableTW);
    }//GEN-LAST:event_jButtonTWPrintActionPerformed

    private void jButtonTWEnDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTWEnDiActionPerformed
        // TODO add your handling code here:
        disableEnableTW(false);
        jTableTW.clearSelection();
    }//GEN-LAST:event_jButtonTWEnDiActionPerformed

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

    private void jButtonPetugasEnDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPetugasEnDiActionPerformed
        // TODO add your handling code here:
        disableEnablePetugas(false);
        jTablePetugas.clearSelection();
    }//GEN-LAST:event_jButtonPetugasEnDiActionPerformed

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

    private void jButtonMemberPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMemberPrintActionPerformed
        // TODO add your handling code here:
        helper.printTable("Laporan Member", jTableMember);
    }//GEN-LAST:event_jButtonMemberPrintActionPerformed

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

    private void jComboBoxTransaksiJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTransaksiJenisActionPerformed
        // TODO add your handling code here:
        if(jComboBoxTransaksiJenis.getSelectedIndex()==0){
            setSpinnerJumlahKelompok(false);
        }else{
            setSpinnerJumlahKelompok(true);
        }
    }//GEN-LAST:event_jComboBoxTransaksiJenisActionPerformed

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
    private javax.swing.JButton jButtonMemberEnDi;
    private javax.swing.JButton jButtonMemberHapus;
    private javax.swing.JButton jButtonMemberPrint;
    private javax.swing.JButton jButtonMemberTambah;
    private javax.swing.JButton jButtonPWEdit;
    private javax.swing.JButton jButtonPWEnDi;
    private javax.swing.JButton jButtonPWHapus;
    private javax.swing.JButton jButtonPWPrint;
    private javax.swing.JButton jButtonPWTambah;
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
    private javax.swing.JButton jButtonTransaksiChart;
    private javax.swing.JButton jButtonTransaksiEdit;
    private javax.swing.JButton jButtonTransaksiEnDi;
    private javax.swing.JButton jButtonTransaksiHapus;
    private javax.swing.JButton jButtonTransaksiPrint;
    private javax.swing.JButton jButtonTransaksiTambah;
    private javax.swing.JComboBox jComboBoxMemberPrivelege;
    private javax.swing.JComboBox jComboBoxPWTempat;
    private javax.swing.JComboBox jComboBoxPetugasPrivelege;
    private javax.swing.JComboBox jComboBoxTransaksiJenis;
    private javax.swing.JComboBox jComboBoxTransaksiMember;
    private javax.swing.JComboBox jComboBoxTransaksiPaket;
    private javax.swing.JComboBox jComboBoxTransaksiPetugas;
    private javax.swing.JComboBox jComboBoxTransaksiStatus;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
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
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordFieldMemberPassword;
    private javax.swing.JPasswordField jPasswordFieldPetugasPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinnerPWBatas;
    private javax.swing.JSpinner jSpinnerPWHarga;
    private javax.swing.JSpinner jSpinnerPWJumlah;
    private javax.swing.JSpinner jSpinnerPWLama;
    private javax.swing.JSpinner jSpinnerPetugasGaji;
    private javax.swing.JSpinner jSpinnerPetugasTanggal;
    private javax.swing.JSpinner jSpinnerTransaksiJmlKel;
    private javax.swing.JSpinner jSpinnerTransaksiJmlOrang;
    private javax.swing.JSpinner jSpinnerTransaksiTanggal;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableMember;
    private javax.swing.JTable jTablePaketWisata;
    private javax.swing.JTable jTablePetugas;
    private javax.swing.JTable jTableTW;
    private javax.swing.JTable jTableTransaksi;
    private javax.swing.JTextArea jTextAreaMemberAlamat;
    private javax.swing.JTextArea jTextAreaPWFasilitas;
    private javax.swing.JTextArea jTextAreaPetugasAlamat;
    private javax.swing.JTextArea jTextAreaTWDeskripsi;
    private javax.swing.JTextArea jTextAreaTWLokasi;
    private javax.swing.JTextField jTextFieldMemberNama;
    private javax.swing.JTextField jTextFieldMemberNoHp;
    private javax.swing.JTextField jTextFieldMemberNoKtp;
    private javax.swing.JTextField jTextFieldMemberUsername;
    private javax.swing.JTextField jTextFieldPWNama;
    private javax.swing.JTextField jTextFieldPetugasNama;
    private javax.swing.JTextField jTextFieldPetugasNoHp;
    private javax.swing.JTextField jTextFieldPetugasNoKtp;
    private javax.swing.JTextField jTextFieldPetugasTempat;
    private javax.swing.JTextField jTextFieldPetugasUsername;
    private javax.swing.JTextField jTextFieldTWLatLong;
    private javax.swing.JTextField jTextFieldTWNama;
    // End of variables declaration//GEN-END:variables
}
