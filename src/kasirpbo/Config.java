package kasirpbo;

import java.sql.*;

public class Config {
        private static Connection mysqlconfig;
        
        public static Connection configDB() throws SQLException {
                try  {
                        String url = "jdbc:mysql://localhost:3306/dbkasirpbo";
                        String user = "root";
                        String pass = "";
                        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                        mysqlconfig = DriverManager.getConnection(url, user, pass);
                } catch (Exception e) {
                    System.out.println(e);
                }
                return mysqlconfig;
                }
}
