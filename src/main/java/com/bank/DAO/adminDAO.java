package com.bank.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.Model.Admin;

public class adminDAO {
    public Connection connection() throws ClassNotFoundException, SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/admindb";
        String jdbcUser = "root";
        String jdbcPass = "root";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return con;
    }

    
    public ResultSet adminVerify(Admin ad) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = connection();
            ps = con.prepareStatement("SELECT username, password FROM admincredits WHERE username=? AND password=?");
            ps.setString(1, ad.getUsername());
            ps.setString(2, ad.getPassword());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        // Do not close rs, ps, or con here
        // They will be closed in the calling method
        return rs;
    }
}