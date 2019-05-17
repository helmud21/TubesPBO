/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipendataanmahasiswakp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Koneksi {
    static Connection conn;
    static Statement stm;
    public static Connection getKoneksi(){
        String host = "jdbc:mysql://localhost/data_kp",
               user = "root",
               pass = "";
        try{
            conn = (Connection) DriverManager.getConnection(host, user, pass);
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        return conn;
    }
}
