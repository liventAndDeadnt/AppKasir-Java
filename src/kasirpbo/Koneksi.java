package kasirpbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Koneksi {
    Connection con;
    Statement stm;
    
    public void config(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbkasirpbo", "root", "");
            stm = con.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal:   " +  e.getMessage());
        }
    }
}
