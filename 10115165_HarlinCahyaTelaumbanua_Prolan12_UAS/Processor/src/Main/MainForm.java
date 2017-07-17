/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template Filele, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Object.ObjectPanel;
import Object.ObjectImg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public final class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    
    ObjectPanel lt = new ObjectPanel();
    
    private String DataTxt = "Data.txt"; 
    
    ClassData ReadData;
    ClassProses ProcessRun;
    
    int klik_Tabel;
            
    public MainForm() {
        initComponents();
        ProcessRun = new ClassProses();
        
        try{
            ReadData();
            DataReg();
        }catch(Exception ex){
            Notice("Data Tidak Ditemukan");
        }
    }

    public void ReadData(){
        File baru = new File(DataTxt);
        
        try{
            
            FileReader File = new FileReader(baru);
            BufferedReader buff = new BufferedReader(File);
            
                String linea = null;
                while((linea = buff.readLine())!=null){
                    StringTokenizer strToken = new StringTokenizer(linea, "#");
                    ReadData = new ClassData();
                    ReadData.setID(Integer.parseInt(strToken.nextToken()));
                    ReadData.setNama(strToken.nextToken());
                    ReadData.setVersi(strToken.nextToken());
                    ReadData.setTgl_tgl(Integer.parseInt(strToken.nextToken()));
                    ReadData.setTgl_bln(Integer.parseInt(strToken.nextToken()));
                    ReadData.setTgl_thn(Integer.parseInt(strToken.nextToken()));
                    ReadData.setClock(strToken.nextToken());
                    ReadData.setCache(strToken.nextToken());
                    ProcessRun.Save(ReadData);
                }
            
        }catch(Exception ex){
            Notice("Eror Saat Memuat Berkas: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
    
    public void Read_text(){
        FileWriter dataFile;
        PrintWriter dataPrint;
        try{
            dataFile = new FileWriter(DataTxt);
            dataPrint = new PrintWriter(dataFile);
            
            for(int i = 0; i < ProcessRun.CountSizeArray(); i++){
                ReadData = ProcessRun.CountArray(i);
                dataPrint.println(String.valueOf(ReadData.getID()+"#"+ReadData.getNama()+"#"+ReadData.getVersi()+"#"+ReadData.getTgl_tgl()+"#"+ReadData.getTgl_bln()+"#"+ReadData.getTgl_thn()+"#"+ReadData.getClock()+"#"+ReadData.getCache()));
            }
             dataPrint.close();
            
        }catch(Exception ex){
            Notice("Error Memuat Berkas: "+ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
    
    public void NewDataReg(File baru){
        try{
            if(DirectRunID() == -666){
                    Notice("ID Tidak Tersedia");
            }else if(DirectRunNama() == null){
                    Notice("input Nama Salah");
            }else if(DirectRunVersi() == null){
                Notice("input Versi Salah");
            }else if(DirectRunClock() == null){
                Notice("Input Clock Salah");
            }else if(DirectRunCache()== null){
                Notice("input Cache Salah");
            }else{
                ReadData = new ClassData(DirectRunID(), DirectRunNama(), DirectRunVersi(),DirectRunTgl_tgl(),DirectRunTgl_bln(),DirectRunTgl_thn(), DirectRunClock(),DirectRunCache());
                if(ProcessRun.CariKode(ReadData.getID())!= -1)Notice("ID Tidak tersedia");
                else ProcessRun.Save(ReadData);
                
                Read_text();
                DataReg();
               lt.limp_text(panel); 
            }
        }catch(Exception ex){
            Notice(ex.getMessage());
        }
    }
    
    public void editDataReg(File baru){
        try{
            if(DirectRunID() == -666){
                    Notice("ID Tidak Tersedia");
            }else if(DirectRunNama() == null){
                    Notice("input Nama Salah");
            }else if(DirectRunVersi() == null){
                Notice("input Versi Salah");
            }else if(DirectRunClock() == null){
                Notice("Input Clock Salah");
            }else if(DirectRunCache()== null){
                Notice("input Cache Salah");
            }else{
                int kode = ProcessRun.CariKode(DirectRunID());
                ReadData = new ClassData(DirectRunID(), DirectRunNama(), DirectRunVersi(),DirectRunTgl_tgl(),DirectRunTgl_bln(),DirectRunTgl_thn(), DirectRunClock(),DirectRunCache());
                
                if(kode == -1)ProcessRun.Save(ReadData);
                else ProcessRun.Edit(kode, ReadData);
                
                Read_text();
                DataReg();
                lt.limp_text(panel);
            }
        }catch(Exception ex){
            Notice(ex.getMessage());
        }
    }
    
    public void hapusDataReg(){
        try{
            if(DirectRunID() == -666) Notice(" ID Tidak Tersedia");
            
            else{
                int kode = ProcessRun.CariKode(DirectRunID());
                if(kode == -1) Notice("ID tidak Tersedia");
                
                else{
                    int s = JOptionPane.showConfirmDialog(null, "Anda Akan Menghapus Data","Ya/Tidak",0);
                    if(s == 0){
                        ProcessRun.Delete(kode);
                        
                        Read_text();
                        DataReg();
                        lt.limp_text(panel);
                    }
                }
                
                
            }
        }catch(Exception ex){
            Notice(ex.getMessage());
        }
    }
    
    public void DataReg(){
        DefaultTableModel dt = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        dt.addColumn("ID");
        dt.addColumn("Nama");
        dt.addColumn("Versi");
        dt.addColumn("Tanggal Rilis");
        dt.addColumn("Clock");
        dt.addColumn("Cache");
        
        Tabel.setDefaultRenderer(Object.class, new ObjectImg());
        
        Object Data[] = new Object[dt.getColumnCount()];
        for(int i = 0; i < ProcessRun.CountSizeArray(); i++){
            
            ReadData = ProcessRun.CountArray(i);
            Data[0] = ReadData.getID();
            Data[1] = ReadData.getNama();
            Data[2] = ReadData.getVersi();
            Data[3] = (ReadData.getTgl_tgl()+1)+"/"+ (ReadData.getTgl_bln()+1)+"/"+(2017-ReadData.getTgl_thn());
            Data[4] = ReadData.getClock();
            Data[5] = ReadData.getCache();
            dt.addRow(Data);
        }
        Tabel.setModel(dt);
        Tabel.setRowHeight(30);
    }
    
    public int DirectRunID(){
        try{
            int ID = Integer.parseInt(txtID.getText().trim());
            return ID;
        }catch(Exception ex){
            return -666;
        }
    }
    
    public String DirectRunNama(){
        try{
            String Nama = txtNama.getText().trim().replace("", "");
            return Nama;
        }catch(Exception ex){
            return null;
        }
    }
    
    public String DirectRunVersi(){
        try{
            String Versi = txtVersi.getText().trim().replace("","");
            return Versi;
        }catch(Exception ex){
            return null;
        }
    }
    
     public int DirectRunTgl_tgl(){
        try{
            int tgl_tgl = cmbTgl.getSelectedIndex();
            return tgl_tgl;
        }catch(Exception ex){
            return -666;
        }
    }
    public int DirectRunTgl_bln(){
        try{
            int tgl_bln = cmbBln.getSelectedIndex();
            return tgl_bln;
        }catch(Exception ex){
            return -666;
        }
    }
    public int DirectRunTgl_thn(){
        try{
            int tgl_thn = cmbThn.getSelectedIndex();
            return tgl_thn;
        }catch(Exception ex){
            return -666;
        }
    }
    
    
    public String DirectRunClock(){
        try{
            String Clock = txtClock.getText().trim().replace("","");
            return Clock;
        }catch(Exception ex){
            return null;
        }
    }
    
    public String DirectRunCache(){
        try{
            String Cache = txtCache.getText().trim().replace("","");
            return Cache;
        }catch(Exception ex){
            return null;
        }
    }

    public void Notice(String text){
        JOptionPane.showMessageDialog(null, text);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtClock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtVersi = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCache = new javax.swing.JTextField();
        cmbTgl = new javax.swing.JComboBox();
        cmbBln = new javax.swing.JComboBox();
        cmbThn = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Search = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Proccesor / 10115165");
        setResizable(false);

        panel.setBackground(new java.awt.Color(204, 204, 204));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        Tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabel);

        panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 324, 708, 251));

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("GeoSlab703 Md BT", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        jButton1.setText("Tambah");
        jButton1.setToolTipText("Data Baru");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 90, 132, 42));

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("GeoSlab703 Md BT", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        jButton2.setText("Edit");
        jButton2.setToolTipText("Edit");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 144, 132, 42));

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setFont(new java.awt.Font("GeoSlab703 Md BT", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        jButton3.setText("Hapus");
        jButton3.setToolTipText("Delete");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 198, 132, 42));

        txtClock.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        panel.add(txtClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 227, -1));

        jLabel4.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        jLabel4.setText("Tangal Rilis  :");
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        jLabel3.setText("Versi            :");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 168, -1, -1));

        txtVersi.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        panel.add(txtVersi, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 162, 227, -1));

        txtNama.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        panel.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 126, 227, -1));

        txtID.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        panel.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 227, -1));

        jLabel1.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        jLabel1.setText("ID                :");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 96, -1, -1));

        jLabel2.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        jLabel2.setText("Nama           :");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 132, -1, -1));

        txtRuta.setEditable(false);
        txtRuta.setBackground(new java.awt.Color(204, 204, 204));
        txtRuta.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        txtRuta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtRuta.setEnabled(false);
        panel.add(txtRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 72, 52, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 102));
        jButton5.setFont(new java.awt.Font("GeoSlab703 Md BT", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/reload.png"))); // NOI18N
        jButton5.setText("Reset");
        jButton5.setToolTipText("Clean");
        jButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panel.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 252, 132, 42));

        jLabel5.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        jLabel5.setText("Cache           :");
        panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 282, -1, -1));

        txtCache.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        panel.add(txtCache, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 276, 227, -1));

        cmbTgl.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        cmbTgl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        panel.add(cmbTgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 204, 66, -1));

        cmbBln.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        cmbBln.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        panel.add(cmbBln, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 204, 72, -1));

        cmbThn.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        cmbThn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995" }));
        panel.add(cmbThn, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 204, 72, -1));
        panel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 312, 864, 12));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 90, 42, 210));

        jLabel6.setFont(new java.awt.Font("Maiandra GD", 1, 14)); // NOI18N
        jLabel6.setText("Clock           :");
        panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 246, -1, -1));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 90, 24, 210));
        panel.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 96, 180, -1));

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/View.png"))); // NOI18N
        jButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 96, 54, 24));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/intel-logo-png-4.png"))); // NOI18N
        panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 144, 114, 150));

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Khmer UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Data Processor");
        jLabel8.setOpaque(true);
        panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 888, 60));

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Info Pembuat");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        File baru = new File(txtRuta.getText());
        this.NewDataReg(baru);
        JOptionPane.showMessageDialog(null,"Data berhasi Ditambahkan !");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        File baru = new File(txtRuta.getText());
        this.editDataReg(baru);
        JOptionPane.showMessageDialog(null,"Data berhasi Diubah !");
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.hapusDataReg();
        JOptionPane.showMessageDialog(null,"Data berhasil Dihapus !");
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void TabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMouseClicked
        
        klik_Tabel = Tabel.rowAtPoint(evt.getPoint());
        
        int ID = (int)Tabel.getValueAt(klik_Tabel, 0);
        
        double countLine = 0;
        String filePath = "Data.txt";
        BufferedReader br;
        String line;
        String paddedInput = "#" + ID + "#";
        String paddedInputStart = ID + "#";
        
        try {
            br = new BufferedReader(new FileReader(filePath));
            try {
                while((line = br.readLine()) != null)
                {
                    countLine++;
                    if(line.equals(ID) || line.startsWith(paddedInputStart) || line.contains(paddedInput)) {
                        String[] found = line.split("#");
                        
                        for(int counter = 0; counter < 8; counter++){
                            txtID.setText(found[0]);
                            txtNama.setText(found[1]);
                            txtVersi.setText(found[2]);
                            cmbTgl.setSelectedIndex(Integer.parseInt(found[3]));
                            cmbBln.setSelectedIndex(Integer.parseInt(found[4]));
                            cmbThn.setSelectedIndex(Integer.parseInt(found[5]));
                            txtClock.setText(found[6]);
                            txtCache.setText(found[7]);
                        }
                    }       
                }
                
                br.close();
            } catch (IOException e) {
                
            }
        } catch (FileNotFoundException e) {
        }
        




        
    }//GEN-LAST:event_TabelMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ObjectPanel lp = new ObjectPanel();
        lp.limp_text(panel);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         double countLine = 0;
        String filePath = "Data.txt";
        BufferedReader br;
        String line;
        String paddedInput = "#" + Search.getText() + "#";
        String paddedInputStart = Search.getText() + "#";
      
        try {
            br = new BufferedReader(new FileReader(filePath));
            try {
                while((line = br.readLine()) != null)
                {
                    countLine++;
                    if(Search.getText().equals(line) || line.startsWith(paddedInputStart) || line.contains(paddedInput)) {
                        String[] found = line.split("#");
                       
                        for(int counter = 0; counter < 8; counter++){
                            txtID.setText(found[0]);
                            txtNama.setText(found[1]);
                            txtVersi.setText(found[2]);
                            cmbTgl.setSelectedIndex(Integer.parseInt(found[3]));
                            cmbBln.setSelectedIndex(Integer.parseInt(found[4]));
                            cmbThn.setSelectedIndex(Integer.parseInt(found[5]));
                            txtClock.setText(found[6]);
                            txtCache.setText(found[7]);
                        }
                   
                    }
                    
                        
                }
                 
                br.close();
            } catch (IOException e) {
                
            }
        } catch (FileNotFoundException e) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        JOptionPane.showMessageDialog(null, "Nim : 10115165");
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        dispose();
    }//GEN-LAST:event_jMenuItem1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is namat available, stay with the default look and feel.
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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Search;
    private javax.swing.JTable Tabel;
    private javax.swing.JComboBox cmbBln;
    private javax.swing.JComboBox cmbTgl;
    private javax.swing.JComboBox cmbThn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtCache;
    private javax.swing.JTextField txtClock;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtVersi;
    // End of variables declaration//GEN-END:variables
}
