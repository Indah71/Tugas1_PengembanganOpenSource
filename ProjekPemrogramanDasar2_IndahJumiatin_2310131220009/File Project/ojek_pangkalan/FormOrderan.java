package ojek_pangkalan;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ACER
 */
public class FormOrderan extends javax.swing.JFrame {
    private DefaultTableModel model;
    public FormOrderan() {
        initComponents();
        this.setLocationRelativeTo(null);

        model = new DefaultTableModel();
        model.addColumn("ID Order");
        model.addColumn("ID Pengguna");
        model.addColumn("ID Driver");
        model.addColumn("Lokasi Awal");
        model.addColumn("Lokasi Tujuan");
        model.addColumn("Status");
        model.addColumn("Waktu");
        model.addColumn("Tanggal");
        model.addColumn("Tarif");

        tableorder.setModel(model); 

        tampilkan_data(); 
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);
    }
    
    private void kosongkan_form(){
        tfLokasiAwal.setText(null);
        tfLokasiTujuan.setText(null);
        cbxStatus.setSelectedIndex(0);
        tfIDPengguna.setText(null);
        tfIDDriver.setText(null);
        tfNamaPengguna.setText(null);
        tfNoHP.setText(null);
        tfKendaraan.setText(null);
        tfTarif.setText(null);
        }
    
    
    // Menampilkan data pengguna ke dalam tabel
    private void tampilkan_data() {
       model.setRowCount(0); // Reset data dalam model tabel

       try {
           String sql = "SELECT o.id_order, o.lokasi_awal, o.lokasi_tujuan, o.status, "
                      + "o.waktu_pesan AS waktu, " 
                      + "o.tanggal_pesan AS tanggal, "
                      + "o.tarif, "
                      + "o.id_pengguna, o.id_driver "
                      + "FROM orderan o";

           // Koneksi ke database
           java.sql.Connection conn = Koneksi.getKoneksi();
           java.sql.Statement stm = conn.createStatement();
           java.sql.ResultSet res = stm.executeQuery(sql);

           while (res.next()) {
               BigDecimal tarif = res.getBigDecimal("tarif");
               String tarifFormatted = tarif != null ? String.format("%.2f", tarif) : "0.00"; 
               model.addRow(new Object[]{
                   res.getInt("id_order"),
                   res.getInt("id_pengguna"),
                   res.getInt("id_driver"),
                   res.getString("lokasi_awal"),
                   res.getString("lokasi_tujuan"),
                   res.getString("status"),
                   res.getTime("waktu"),
                   res.getDate("tanggal"),
                   tarifFormatted 
               });
           }

           tableorder.setModel(model); 
           System.out.println("Data berhasil ditampilkan.");
       } catch (SQLException e) {
           System.err.println("Error: " + e.getMessage());
       }
   }
    
    // Metode untuk mengatur data pengguna
    public void setDataPengguna(String id, String nama, String noHp) {
        tfIDPengguna.setText(id);
        tfNamaPengguna.setText(nama);
        tfNoHP.setText(noHp);
              
    }
    // Metode untuk mengatur data driver
    public void setDataDriver(String id, String kendaraan, BigDecimal tarif) {
        tfIDDriver.setText(id);
        tfKendaraan.setText(kendaraan);
        tfTarif.setText(tarif != null ? tarif.toString() : "0.00");
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jPasswordField1 = new javax.swing.JPasswordField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        tfNoHP = new javax.swing.JTextField();
        tfIDDriver = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfTarif = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableorder = new javax.swing.JTable();
        btnBatal = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfIDPengguna = new javax.swing.JTextField();
        caridatadriver = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tfNamaPengguna = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfKendaraan = new javax.swing.JTextField();
        caridatapengguna = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        tfLokasiAwal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfLokasiTujuan = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jFrame3.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jFrame3.getAccessibleContext().setAccessibleName("pengguna");
        jFrame3.getAccessibleContext().setAccessibleDescription("");

        jPasswordField1.setText("jPasswordField1");

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(185, 229, 232));

        jPanel1.setBackground(new java.awt.Color(74, 98, 138));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Form Order");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("ID Driver");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Kendaraan");

        btnTambah.setBackground(new java.awt.Color(0, 204, 51));
        btnTambah.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 102, 0));
        btnEdit.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(255, 0, 0));
        btnHapus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        tfNoHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNoHPActionPerformed(evt);
            }
        });

        tfIDDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIDDriverActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("No HP");

        tfTarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTarifActionPerformed(evt);
            }
        });

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tableorder.setBackground(new java.awt.Color(223, 242, 235));
        tableorder.setModel(new javax.swing.table.DefaultTableModel(
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
        tableorder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableorderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableorder);

        btnBatal.setBackground(new java.awt.Color(255, 204, 0));
        btnBatal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("ID Pengguna");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N

        tfIDPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIDPenggunaActionPerformed(evt);
            }
        });

        caridatadriver.setText("Cari");
        caridatadriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caridatadriverActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Nama Pengguna");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Tarif");

        caridatapengguna.setText("Cari");
        caridatapengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caridatapenggunaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Lokasi Awal");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Lokasi Tujuan");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Status");

        cbxStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proses", "Selesai", "Dibatalkan" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTambah)
                .addGap(42, 42, 42)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfIDDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfIDPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(caridatapengguna)
                                            .addComponent(caridatadriver))))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(126, 126, 126)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(tfNamaPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(tfKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(tfNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)
                                            .addComponent(tfTarif, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15))
                                .addGap(87, 87, 87)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfLokasiTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfLokasiAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(tfLokasiAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLokasiTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNamaPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caridatapengguna)
                    .addComponent(tfIDPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIDDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(caridatadriver)
                            .addComponent(tfKendaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTarif)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal)
                    .addComponent(btnHapus)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIDPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDPenggunaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIDPenggunaActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        kosongkan_form();
        tampilkan_data();
        btnTambah.setEnabled(true);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(false);
    }//GEN-LAST:event_btnBatalActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tableorderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableorderMouseClicked
    btnTambah.setEnabled(false);
    btnEdit.setEnabled(true);
    btnHapus.setEnabled(true);
    btnBatal.setEnabled(true);

    int i = tableorder.getSelectedRow();
    if (i == -1) {
        return; 
    }

    DefaultTableModel model = (DefaultTableModel) tableorder.getModel();

    String id_pengguna = model.getValueAt(i, 1) != null ? model.getValueAt(i, 1).toString() : "";
    String id_driver = model.getValueAt(i, 2) != null ? model.getValueAt(i, 2).toString() : "";
    String lokasi_awal = model.getValueAt(i, 3) != null ? model.getValueAt(i, 3).toString() : "";
    String lokasi_tujuan = model.getValueAt(i, 4) != null ? model.getValueAt(i, 4).toString() : "";
    String status = model.getValueAt(i, 5) != null ? model.getValueAt(i, 5).toString() : "";

    tfIDPengguna.setText(id_pengguna);
    tfIDDriver.setText(id_driver);
    tfLokasiAwal.setText(lokasi_awal);
    tfLokasiTujuan.setText(lokasi_tujuan);
    cbxStatus.setSelectedItem(status);
    }//GEN-LAST:event_tableorderMouseClicked

    private void tfTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTarifActionPerformed

    }//GEN-LAST:event_tfTarifActionPerformed

    private void tfIDDriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDDriverActionPerformed
    
    }//GEN-LAST:event_tfIDDriverActionPerformed

    private void tfNoHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNoHPActionPerformed
     
    }//GEN-LAST:event_tfNoHPActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
                                        
    try {
        int selectedRow = tableorder.getSelectedRow();
        if (selectedRow == -1) { 
            JOptionPane.showMessageDialog(null, "Silakan pilih data yang akan dihapus!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id_order = Integer.parseInt(tableorder.getValueAt(selectedRow, 0).toString());

        String sql = "DELETE FROM orderan WHERE id_order = ?";

        java.sql.Connection conn = Koneksi.getKoneksi();
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, id_order);
            pstm.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            tampilkan_data(); 
            kosongkan_form(); 
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        System.err.println("Error: " + e.getMessage());
    }


    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
                                 
    try {
        int selectedRow = tableorder.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Silakan pilih data yang akan diubah!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int id_order = Integer.parseInt(tableorder.getValueAt(selectedRow, 0).toString());

        String lokasi_awal = tfLokasiAwal.getText().trim();
        String lokasi_tujuan = tfLokasiTujuan.getText().trim();
        String status = cbxStatus.getSelectedItem().toString();
        String tarifString = tfTarif.getText().trim();

        BigDecimal tarif;
        try {
            tarif = new BigDecimal(tarifString);
            if (tarif.compareTo(BigDecimal.ZERO) < 0) {
                JOptionPane.showMessageDialog(null, "Tarif tidak boleh negatif!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Tarif harus berupa angka valid!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "UPDATE orderan SET lokasi_awal = ?, lokasi_tujuan = ?, status = ?, tarif = ? WHERE id_order = ?";
        try (Connection conn = Koneksi.getKoneksi(); PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, lokasi_awal);
            pstm.setString(2, lokasi_tujuan);
            pstm.setString(3, status);
            pstm.setBigDecimal(4, tarif); 
            pstm.setInt(5, id_order); 

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan atau tidak ada perubahan!", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        tampilkan_data(); 
        kosongkan_form();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengubah data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        System.err.println("Error: " + e.getMessage());
    }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
    String id_pengguna = tfIDPengguna.getText(); 
    String id_driver = tfIDDriver.getText(); 
    String lokasi_awal = tfLokasiAwal.getText();
    String lokasi_tujuan = tfLokasiTujuan.getText();
    String status = cbxStatus.getSelectedItem().toString();
    String tarifString = tfTarif.getText(); 

    try {
        if (id_pengguna.isEmpty() || id_driver.isEmpty() || lokasi_awal.isEmpty() || lokasi_tujuan.isEmpty() || status.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap isi semua kolom!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        BigDecimal tarif = null;
        try {
            tarif = new BigDecimal(tarifString);  
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Tarif tidak valid! Harap masukkan angka yang benar.", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        Connection c = Koneksi.getKoneksi();
        String sql = "INSERT INTO orderan (id_pengguna, id_driver, lokasi_awal, lokasi_tujuan, status, waktu_pesan, tanggal_pesan, tarif) "
                   + "VALUES (?, ?, ?, ?, ?, CURRENT_TIME(), CURRENT_DATE(), ?)";

        try (PreparedStatement p = c.prepareStatement(sql)) {
            p.setInt(1, Integer.parseInt(id_pengguna));  
            p.setInt(2, Integer.parseInt(id_driver));    
            p.setString(3, lokasi_awal);                
            p.setString(4, lokasi_tujuan);              
            p.setString(5, status);                    
            p.setBigDecimal(6, tarif);               

            p.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data ke database.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(null, "Data Tersimpan");
        tampilkan_data();  
        kosongkan_form();  
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "ID Pengguna dan ID Driver harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        System.err.println("Error: " + e.getMessage());
    } catch (HeadlessException e) {
        JOptionPane.showMessageDialog(null, "Terjadi Kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        System.err.println("Error: " + e.getMessage());
    }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void caridatapenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caridatapenggunaActionPerformed
        ListPengguna listPengguna = new ListPengguna(this);
        listPengguna.setVisible(true);
    }//GEN-LAST:event_caridatapenggunaActionPerformed

    private void caridatadriverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caridatadriverActionPerformed
        ListDriver listDriver = new ListDriver(this);
        listDriver.setVisible(true);
    }//GEN-LAST:event_caridatadriverActionPerformed

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
            java.util.logging.Logger.getLogger(FormOrderan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormOrderan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormOrderan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormOrderan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormOrderan().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton caridatadriver;
    private javax.swing.JButton caridatapengguna;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableorder;
    public javax.swing.JTextField tfIDDriver;
    public javax.swing.JTextField tfIDPengguna;
    public javax.swing.JTextField tfKendaraan;
    private javax.swing.JTextField tfLokasiAwal;
    private javax.swing.JTextField tfLokasiTujuan;
    public javax.swing.JTextField tfNamaPengguna;
    public javax.swing.JTextField tfNoHP;
    public javax.swing.JTextField tfTarif;
    // End of variables declaration//GEN-END:variables

}