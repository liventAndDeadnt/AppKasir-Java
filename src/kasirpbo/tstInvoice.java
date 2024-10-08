/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kasirpbo;

import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class tstInvoice extends javax.swing.JFrame {

    /**
     * Creates new form tstInvoice
     */
    public tstInvoice() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Area = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FNama = new javax.swing.JTextField();
        FKelas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        FTotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        AddBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Area.setColumns(20);
        Area.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Area.setRows(5);
        jScrollPane1.setViewportView(Area);

        jLabel1.setText("Test invoice");

        jLabel2.setText("Kelas");

        jLabel3.setText("Nama");

        jLabel4.setText("Total");

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Test", "100", "3", "300"},
                {"book", "3000", "2", "6000"},
                {"Pen", "2000", "1", "2000"}
            },
            new String [] {
                "Barang", "Harga", "Jumlah", "Total"
            }
        ));
        jScrollPane2.setViewportView(Table);

        AddBTN.setText("Add");
        AddBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(69, 69, 69)
                        .addComponent(AddBTN))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(52, 52, 52)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(FKelas, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                        .addComponent(FNama)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(FNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(FKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(FTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)
                                    .addComponent(AddBTN)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      String[][] tableData = new String[3][2]; // Assuming 3 rows and 2 columns
        for (int i = 0; i < 3; i++) {
            tableData[i][0] = (String) Table.getValueAt(i, 0);
            tableData[i][1] = (String) Table.getValueAt(i, 1);
        }

        // Generate invoice content
        Area.setText("*******************************\n");
        Area.setText(Area.getText() + "*                      INVOICE\n");
        Area.setText(Area.getText() + "********************\n");

        Date obj = new Date();
        String date = obj.toString();
        Area.setText(Area.getText() + "\n" + date + "\n");

        // Display customer details
        Area.setText(Area.getText() + "Nama : " + FNama.getText() + "\n");
        Area.setText(Area.getText() + "Kelas : " + FKelas.getText() + "\n");

        // Display item details
        for (int i = 0; i < tableData.length; i++) {
            Area.setText(Area.getText() + "Barang: " + tableData[i][0] + "                                          " + tableData[i][1] + "\n");
        }
        
        // Add a separator line
        Area.setText(Area.getText() + "_______________________________________________________ + \n");
        
        // Display total at the end
        Area.setText(Area.getText() + "Total                                            " + FTotal.getText() + "\n");
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      try {
          Area.print();
      } catch (Exception e) {
        
      }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void AddBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBTNActionPerformed
      
       int numRows = Table.getRowCount();
int numCols = Table.getColumnCount();

String[][] tableData = new String[numRows][numCols];

for (int i = 0; i < numRows; i++) {
    for (int j = 0; j < numCols; j++) {
        tableData[i][j] = Table.getValueAt(i, j).toString(); 
    }
}

// Establish a connection to the MySQL database
Connection conn = null;
try {
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbkasirpbo", "root", "");
} catch (SQLException ex) {
    Logger.getLogger(tstInvoice.class.getName()).log(Level.SEVERE, null, ex);
}

// Create a prepared statement
String sql = "INSERT INTO transaksi_table (Barang, Jumlah_barang, Total) VALUES (?, ?, ?)"; 
PreparedStatement pstmt = null;
try {
    pstmt = conn.prepareStatement(sql);
} catch (SQLException ex) {
    Logger.getLogger(tstInvoice.class.getName()).log(Level.SEVERE, null, ex);
}

// Mendapatkan nilai dari field "Total"
//JTextField FTotal = new JTextField(); // Dapatkan referensi ke JTextField bernama 'FTotal'
String totalValue = FTotal.getText();

// Iterate through the 2D array and execute the prepared statement
int barangColumnIndex = 0; 
int jumlahColumnIndex = 2; 

for (int i = 0; i < numRows; i++) {
    try {
        pstmt.setString(1, tableData[i][barangColumnIndex]);  // Barang
        pstmt.setString(2, tableData[i][jumlahColumnIndex]); // Jumlah

        // Mengirim nilai "Total" ke database, sesuaikan dengan tipe data kolom "Total"
        if (totalValue.matches("\\d+")) { // Cek apakah totalValue berisi hanya angka
            pstmt.setInt(3, Integer.parseInt(totalValue)); 
        } else {
            // Tangani kasus jika totalValue bukan angka valid, misalnya tampilkan pesan error
            System.err.println("Nilai Total harus berupa angka!");
        }

        pstmt.executeUpdate(); 
    } catch (SQLException ex) {
        Logger.getLogger(tstInvoice.class.getName()).log(Level.SEVERE, null, ex);
    } 
}

try {
    // Close the connection and prepared statement
    conn.close();
    pstmt.close();
} catch (SQLException ex) {
    Logger.getLogger(tstInvoice.class.getName()).log(Level.SEVERE, null, ex);
}
        
    }//GEN-LAST:event_AddBTNActionPerformed

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
            java.util.logging.Logger.getLogger(tstInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tstInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tstInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tstInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tstInvoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBTN;
    private javax.swing.JTextArea Area;
    private javax.swing.JTextField FKelas;
    private javax.swing.JTextField FNama;
    private javax.swing.JTextField FTotal;
    private javax.swing.JTable Table;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
