/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kasirpbo;

import com.mysql.jdbc.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;


/**
 *
 * @author ASUS
 */
public class FormTransaksi extends javax.swing.JFrame {

    public Connection con;
    public Statement stat;
//    public PreparedStatement st;
//    public ResultSet rs;
    String sql;
    
    Koneksi koneksi = new Koneksi();
    
    public FormTransaksi() {
        initComponents();
       
        try {
            koneksi.config();  // Memanggil koneksi
            con = koneksi.con; // Menyimpan koneksi ke variabel con lokal
            stat = koneksi.stm; // Menyimpan statement ke variabel stat lokal
            ambilData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data: " + e.getMessage());
        }
        
        JButton CheckoutBTN = new JButton("Pesan"); 
CheckoutBTN.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      
    }
});
    }
    
    private void updatetotalharga() {
    int rowCount = TabelBarang.getRowCount();
    int totalHarga = 0;

    for (int i = 0; i < rowCount; i++) {
        String totalSementaraString = TabelBarang.getValueAt(i, 3).toString().replaceAll("Rp ", "").trim();
        int totalSementara = Integer.parseInt(totalSementaraString);
        totalHarga += totalSementara;
    }

    TotalHarga.setText("Rp " + totalHarga); 
}
    
    private void clearAll() {
        DefaultTableModel model = (DefaultTableModel) TabelBarang.getModel();
model.setRowCount(0); 

    TotalHarga.setText(" ");
    JmlBayar.setText(" ");
    FieldKembalian.setText(" ");
    Area.setText("");

    ambilData();
    }
    
    private void ambilData(){
        DefaultTableModel tableModel = new DefaultTableModel();
        // Untuk membuat judul kolom tabel
        tableModel.addColumn("Kode");
        tableModel.addColumn("Nama");
        tableModel.addColumn("Harga");
        tableModel.addColumn("Stok");
      
              
        try {
            String sql = "SELECT * FROM barang_table"; 
            ResultSet results = stat.executeQuery(sql);
            
            while (results.next()) {
                // Menambahkan baris baru ke tabel di form
                tableModel.addRow(new String[]{
                    results.getString("Kode"),
                    results.getString("Nama_barang"),
                    results.getString("Harga_barang"),
                    results.getString("Stok_barang"),
                   });
            }
            
            BarangTabel.setModel(tableModel);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
   
    public void simpanKeDatabase(JTable TabelBarang, String totalHarga) {
        DefaultTableModel model = (DefaultTableModel) TabelBarang.getModel();
        int rowCount = model.getRowCount();

        // Pastikan koneksi telah diinisialisasi
        if (con == null) {
            JOptionPane.showMessageDialog(null, "Koneksi tidak terhubung");
            return;
        }

        String sql = "INSERT INTO nama_tabel (nama_barang, harga_barang, jumlah, total, total_harga) VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            for (int i = 0; i < rowCount; i++) {
                String namaBarang = model.getValueAt(i, 0).toString();
                String hargaBarang = model.getValueAt(i, 1).toString();
                String jumlah = model.getValueAt(i, 2).toString();
//                String total = model.getValueAt(i, 3).toString();

                ps.setString(1, namaBarang);
                ps.setString(2, hargaBarang);
                ps.setString(3, jumlah);
//                ps.setString(4, total);
//                ps.setString(5, totalHarga);

                ps.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    List<Integer> daftarHargaSetelahDiskon = new ArrayList<>();

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Area = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        ExitBTN = new javax.swing.JButton();
        InputBarang = new javax.swing.JTextField();
        HargaBarang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        InputJumlah = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelBarang = new javax.swing.JTable();
        TambahBTN = new javax.swing.JButton();
        DeleteBTN = new javax.swing.JButton();
        ClearBTN = new javax.swing.JButton();
        TotalHarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JmlBayar = new javax.swing.JTextField();
        CheckoutBTN = new javax.swing.JButton();
        FieldKembalian = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        HitungTotal = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        BarangTabel = new javax.swing.JTable();
        refresh = new javax.swing.JButton();
        Diskon = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        Area.setColumns(20);
        Area.setRows(5);
        jScrollPane4.setViewportView(Area);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TRANSAKSI");

        ExitBTN.setText("X");
        ExitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBTNActionPerformed(evt);
            }
        });

        InputBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputBarangActionPerformed(evt);
            }
        });
        InputBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InputBarangKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nama barang");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Harga barang");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Jumlah");

        TabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama barang", "Harga barang", "Jumlah", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelBarang);

        TambahBTN.setText("Tambah");
        TambahBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahBTNActionPerformed(evt);
            }
        });

        DeleteBTN.setText("Hapus");
        DeleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBTNActionPerformed(evt);
            }
        });

        ClearBTN.setText("Clear");
        ClearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBTNActionPerformed(evt);
            }
        });

        TotalHarga.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TotalHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalHargaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Total harga");

        JmlBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmlBayarActionPerformed(evt);
            }
        });

        CheckoutBTN.setBackground(new java.awt.Color(153, 255, 153));
        CheckoutBTN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CheckoutBTN.setText("Bayar");
        CheckoutBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CheckoutBTNMouseClicked(evt);
            }
        });
        CheckoutBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutBTNActionPerformed(evt);
            }
        });
        CheckoutBTN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CheckoutBTNKeyPressed(evt);
            }
        });

        FieldKembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldKembalianActionPerformed(evt);
            }
        });

        jLabel7.setText("Kembalian");

        HitungTotal.setText("Hitung");
        HitungTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HitungTotalActionPerformed(evt);
            }
        });

        BarangTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode", "Nama", "Harga", "Stok"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        BarangTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BarangTabelMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(BarangTabel);

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        Diskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiskonActionPerformed(evt);
            }
        });

        jLabel8.setText("Bayar");

        Search.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchKeyReleased(evt);
            }
        });

        jButton1.setText("Riwayat");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ExitBTN)
                                        .addGap(72, 72, 72)
                                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(InputBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(HargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(InputJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(refresh)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Diskon, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DeleteBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ClearBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TambahBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                .addGap(81, 81, 81)
                                .addComponent(jButton1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                        .addComponent(JmlBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(FieldKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(297, 297, 297)
                                .addComponent(jLabel5)
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(HitungTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CheckoutBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(196, 196, 196)))
                        .addComponent(TotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ExitBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InputBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InputJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Diskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TambahBTN)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteBTN)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ClearBTN)
                            .addComponent(jButton1))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JmlBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FieldKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HitungTotal)
                            .addComponent(CheckoutBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBTNActionPerformed
 dispose();
 KasirDashboard.main(null);
    }//GEN-LAST:event_ExitBTNActionPerformed

    private void TotalHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalHargaActionPerformed
       
    }//GEN-LAST:event_TotalHargaActionPerformed

    private void JmlBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmlBayarActionPerformed
       
    }//GEN-LAST:event_JmlBayarActionPerformed

    private void TambahBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahBTNActionPerformed
String NamaBarang = InputBarang.getText();
int Hargabarang = Integer.parseInt(HargaBarang.getText());
int Jumlahbarang = Integer.parseInt(InputJumlah.getText());

int TotalSementara = Jumlahbarang * Hargabarang;

int hargaBarang = Integer.parseInt(HargaBarang.getText());
        int jumlahBarang = Integer.parseInt(InputJumlah.getText());
        int subtotal = hargaBarang * jumlahBarang;

        int diskonBarang = 0;
        String diskonInput = Diskon.getText();
        if (!diskonInput.isEmpty()) {
            if (diskonInput.contains("%")) {
                int persenDiskon = Integer.parseInt(diskonInput.replace("%", ""));
                diskonBarang = (subtotal * persenDiskon) / 100;
            } else {
                int jumlahDiskon = Integer.parseInt(diskonInput);
                diskonBarang = jumlahDiskon;
            }
        }

        int hargaSetelahDiskon = subtotal - diskonBarang;
        daftarHargaSetelahDiskon.add(hargaSetelahDiskon);

DefaultTableModel tbl = (DefaultTableModel) TabelBarang.getModel();

tbl.addRow(new Object[] {
    NamaBarang, 
    "Rp " + Hargabarang,
    Jumlahbarang, 
    "Rp " + hargaSetelahDiskon
});

int Totalharga = 0;
for (int i = 0; i < TabelBarang.getRowCount(); i++) {
    Totalharga += Integer.parseInt(TabelBarang.getValueAt(i, 3).toString().substring(3));
}


        // Hitung ulang Totalharga
        Totalharga = 0;
        for (int harga : daftarHargaSetelahDiskon) {
            Totalharga += harga;
        }
        TotalHarga.setText("Rp" + Totalharga);
        
        
        

        // Bersihkan input
        InputBarang.setText("");
        HargaBarang.setText("");
        InputJumlah.setText("");
        Diskon.setText("");
    }//GEN-LAST:event_TambahBTNActionPerformed

    
    
    private void CheckoutBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutBTNActionPerformed
       
//        CETAK INVOICE
        int numRows = TabelBarang.getRowCount();
        int numCols = TabelBarang.getColumnCount(); 

        // Create a dynamic 2D array to store the table data
        String[][] tableData = new String[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
    for (int j = 0; j < numCols; j++) {
        Object value = TabelBarang.getValueAt(i, j);
        if (value instanceof String) {
            tableData[i][j] = (String) value;
        } else if (value instanceof Integer) {
            tableData[i][j] = String.valueOf(value);
        } else {
            // Handle other types of values
            tableData[i][j] = value.toString();
        }
    }
}
        // Generate invoice content
Area.setText("********************************\n");
Area.setText(Area.getText() + "*            INVOICE           *\n");
Area.setText(Area.getText() + "********************************\n\n");

// Tampilkan tanggal
Date obj = new Date();
String date = obj.toString();
Area.setText(Area.getText() + date + "\n\n");

// Menampilkan detail pelanggan dan pesanan dengan lebar kolom tetap
Area.setText(Area.getText() + String.format("%-20s %10s %12s\n", "Item", "Harga", "Jumlah"));
Area.setText(Area.getText() + "-------------------------------------------------------------------------\n");

for (int i = 0; i < tableData.length; i++) {
    String item = tableData[i][0];
    String harga = tableData[i][3];
    String jumlah = tableData[i][2];
    Area.setText(Area.getText() + String.format("%-20s %10s %12s\n", item, harga, jumlah));
}

Area.setText(Area.getText() + "-------------------------------------------------------------------------\n");

// Menampilkan total harga, bayar, dan kembalian dengan lebar kolom tetap
Area.setText(Area.getText() + String.format("%-30s %10s\n", "Total", TotalHarga.getText()));
Area.setText(Area.getText() + String.format("%-30s %10s\n", "Bayar", JmlBayar.getText()));
Area.setText(Area.getText() + String.format("%-30s %10s\n", "Kembalian", FieldKembalian.getText()));

// Garis penutup
Area.setText(Area.getText() + "*******************************************************\n");

// Print
    try {
          Area.print();
      } catch (Exception e) {
        
      }
        
// INSERT TO DATABASE

for (int i = 0; i < numRows; i++) {
    for (int j = 0; j < numCols; j++) {
        tableData[i][j] = TabelBarang.getValueAt(i, j).toString(); 
    }
}

Connection conn = null;
try {
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbkasirpbo", "root", "");
} catch (SQLException ex) {
    Logger.getLogger(tstInvoice.class.getName()).log(Level.SEVERE, null, ex);
}

// Create a prepared statement
String sql = "INSERT INTO transaksi_table (Barang, Jumlah_barang, Total) VALUES (?, ?, ?)"; 
java.sql.PreparedStatement pstmt = null;
try {
    pstmt = conn.prepareStatement(sql);
} catch (SQLException ex) {
    Logger.getLogger(tstInvoice.class.getName()).log(Level.SEVERE, null, ex);
}

String totalValue = TotalHarga.getText().replaceAll("Rp", "").trim();

// Iterate through the 2D array and execute the prepared statement
int barangColumnIndex = 0; 
int jumlahColumnIndex = 2; 

for (int i = 0; i < numRows; i++) {
    try {
        pstmt.setString(1, tableData[i][barangColumnIndex]);  // Barang
        pstmt.setString(2, tableData[i][jumlahColumnIndex]); // Jumlah

        // Mengirim nilai "Total" ke database, sesuaikan dengan tipe data kolom "Total"
        if (totalValue != null && !totalValue.isEmpty() && totalValue.matches("\\d+")) {
            pstmt.setInt(3, Integer.parseInt(totalValue)); 
            pstmt.executeUpdate(); 
        } else {
            // Tampilkan pesan error yang lebih spesifik
            JOptionPane.showMessageDialog(null, "Nilai Total harga harus berupa angka bulat!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException ex) {
        Logger.getLogger(tstInvoice.class.getName()).log(Level.SEVERE, null, ex);
    }  
}

try {

    conn.close();
    pstmt.close();
} catch (SQLException ex) {
    Logger.getLogger(tstInvoice.class.getName()).log(Level.SEVERE, null, ex);
}
   
// Reset all 
        clearAll();
        
JOptionPane.showMessageDialog(null, "Pesanan Anda berhasil diproses!", "Pesanan Berhasil", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_CheckoutBTNActionPerformed

    private void DeleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBTNActionPerformed
        int row = TabelBarang.getSelectedRow();
        
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data untuk dihapus", "Peringatan",  JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel tbl = (DefaultTableModel) TabelBarang.getModel();
        tbl.removeRow(row);
        
        updatetotalharga();
        
        InputBarang.setText("");
        HargaBarang.setText("");
        InputJumlah.setText("");
    }//GEN-LAST:event_DeleteBTNActionPerformed

    private void ClearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBTNActionPerformed
        InputBarang.setText("");
        HargaBarang.setText("");
        InputJumlah.setText("");
    }//GEN-LAST:event_ClearBTNActionPerformed

    private void HitungTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HitungTotalActionPerformed
      
    try {
        // Hapus semua karakter non-numerik dan konversi ke integer
        String totalHargaStr = TotalHarga.getText().replaceAll("[^0-9]", "");
        int totalHarga = Integer.parseInt(totalHargaStr);

        String totalBayarStr = JmlBayar.getText().replaceAll("[^0-9]", "");
        int totalBayar = Integer.parseInt(totalBayarStr);

        // Hitung kembalian
        int kembalian = totalBayar - totalHarga;

        // Tampilkan kembalian dengan format mata uang
        FieldKembalian.setText("Rp " + kembalian);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Masukkan angka yang valid untuk total harga dan jumlah pembayaran.");
    }

    }//GEN-LAST:event_HitungTotalActionPerformed

    private void CheckoutBTNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CheckoutBTNKeyPressed

    }//GEN-LAST:event_CheckoutBTNKeyPressed

    private void InputBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputBarangActionPerformed

    private void FieldKembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FieldKembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldKembalianActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbkasirpbo", "root", "");
          Statement stat = con.createStatement();
          String sql = "select * from barang_table";
          ResultSet rs = stat.executeQuery(sql);
          
          DefaultTableModel tblModel = (DefaultTableModel) BarangTabel.getModel();
            tblModel.setRowCount(0);
        
          while(rs.next()) {
              String kode = String.valueOf(rs.getString("Kode"));
              String nama = String.valueOf(rs.getString("Nama_barang"));
              String harga = String.valueOf(rs.getInt("Harga_barang"));
              String stok = String.valueOf(rs.getInt("Stok_barang"));
              
              String tbData[ ] = {kode, nama, harga, stok };
   
                tblModel.addRow(tbData);
                
          }
          
          } catch(Exception e) {
              System.out.println(e.getMessage());
          }
    }//GEN-LAST:event_refreshActionPerformed

    private void BarangTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarangTabelMouseClicked
         int row = BarangTabel.rowAtPoint(evt.getPoint());
        InputBarang.setText(BarangTabel.getValueAt(row, 1).toString());
        HargaBarang.setText(BarangTabel.getValueAt(row, 2).toString());
    }//GEN-LAST:event_BarangTabelMouseClicked

    private void InputBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputBarangKeyReleased
        DefaultTableModel tabel =(DefaultTableModel) BarangTabel.getModel();
       TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(tabel);
       BarangTabel.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(InputBarang.getText()));
    }//GEN-LAST:event_InputBarangKeyReleased

    private void CheckoutBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckoutBTNMouseClicked
//        Integer TotalHarga = Integer.parseInt(ttlcuy.getText());
//        Integer TotalBayar = Integer.parseInt(byrya.getText());
//        Integer result = TotalBayar - TotalHarga;
//        cngres.setText(result.toString());
//
//        sql = "INSERT INTO orders (date, total_price) VALUES (?, ?)";
//        try (Connection connection = DB.connectdb(); PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//
//            preparedStatement.setString(1, currentDate.toString());
//            preparedStatement.setInt(2, TotalHarga);
//
//            int hasil = preparedStatement.executeUpdate();
//
//            if (hasil > 0) {
//                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
//                Integer orderId = null;
//
//                if (generatedKeys.next()) {
//                    orderId = generatedKeys.getInt(1);
//                }
//
//                if (orderId != null) {
//                    DefaultTableModel dm = (DefaultTableModel) TabelBarang.getModel();
//
//                    // Insert each item from the table into orders_detail
//                    sql = "INSERT INTO transaksi_table (Barang, Jumlah_barang, Total) VALUES (?, ?, ?, ?)";
//                    try (PreparedStatement detailStatement = (PreparedStatement) connection.prepareStatement(sql)) {
//                        for (int i = 0; i < dm.getRowCount(); i++) {
//                            String productName = dm.getValueAt(i, 0).toString();
//                            int quantity = Integer.parseInt(dm.getValueAt(i, 2).toString());
//                            int price = Integer.parseInt(dm.getValueAt(i, 3).toString());
//
//                            detailStatement.setInt(1, orderId);
//                            detailStatement.setString(2, productName);
//                            detailStatement.setInt(3, quantity);
//                            detailStatement.setInt(4, price);
//
//                            detailStatement.executeUpdate();
//                        }
//                    }
//
//                    // Reset the UI elements
////                    productPrice = 0;
////                    ttlcuy.setText("");
////                    valharga.setText("");
////                    dm.setNumRows(0);
//
//                    JOptionPane.showMessageDialog(null, "Pesanan berhasil ditambahkan");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Gagal mendapatkan Order ID");
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Gagal menambahkan pesanan ke Database");
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e.toString());
//        }
    }//GEN-LAST:event_CheckoutBTNMouseClicked

    private void DiskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiskonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiskonActionPerformed

    private void SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKeyReleased
        DefaultTableModel tabel =(DefaultTableModel) BarangTabel.getModel();
       TableRowSorter<DefaultTableModel> obj=new TableRowSorter<>(tabel);
       BarangTabel.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(Search.getText()));
    }//GEN-LAST:event_SearchKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        history2.main(null);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Area;
    private javax.swing.JTable BarangTabel;
    private javax.swing.JButton CheckoutBTN;
    private javax.swing.JButton ClearBTN;
    private javax.swing.JButton DeleteBTN;
    private javax.swing.JTextField Diskon;
    private javax.swing.JButton ExitBTN;
    private javax.swing.JTextField FieldKembalian;
    private javax.swing.JTextField HargaBarang;
    private javax.swing.JButton HitungTotal;
    private javax.swing.JTextField InputBarang;
    private javax.swing.JTextField InputJumlah;
    private javax.swing.JTextField JmlBayar;
    private javax.swing.JTextField Search;
    private javax.swing.JTable TabelBarang;
    private javax.swing.JButton TambahBTN;
    private javax.swing.JTextField TotalHarga;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables
}
