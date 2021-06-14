/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.entity_Score;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ngnha
 */
public class DAOScore {


    public static void Them(entity_Score score) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            String dbURL = "jdbc:mysql://localhost/sem2_da";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(dbURL, username, password);
            String sql = "INSERT INTO score (Name, Score,Times,Dates) VALUES (?, ?, ?, ?)";
            st = conn.prepareCall(sql);
            st.setString(1, score.getName());
            st.setInt(2, score.getScore());
            st.setString(3, String.valueOf(score.getTimes()));
            st.setString(4, String.valueOf(score.getDates()));
            st.execute();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Thêm thông tin thất bại !");
            System.out.println(ex.getMessage());
        }
    }

    public static void Xoa(String ID) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            String dbURL = "jdbc:mysql://localhost/sem2_da";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(dbURL, username, password);
            String sql = "delete from score where id=?";
            st = conn.prepareCall(sql);
            st.setString(1, ID);
            st.execute();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
