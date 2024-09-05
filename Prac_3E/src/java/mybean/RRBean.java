/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.Stateful;

/**
 *
 * @author Admin
 */
@Stateful
public class RRBean {
    public RRBean(){}
    public String roombooking(String cn, String cm , String rt) {
    String message = "";
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        String query = "select * from roombook_15 where room_type = ? and status_room = 'not booked'";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, rt.trim()); 
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            String rno = rs.getString("room_id");
            PreparedStatement psmt1 = con.prepareStatement("update roombook_15 set customer = ?  mobile=? ,status_room='booked' where room_id = ?");
            psmt1.setString(1, cn);
            psmt1.setString(1, cm);
            psmt1.setString(2, rno);
            psmt1.executeUpdate();


            message = "Room " + rno + " booked and charges = " + rs.getString("charges");
        } else {
            message = "Room " + rt + " currently not available ";
        }
    } catch (ClassNotFoundException | SQLException e) {
        message = "Error: " + e.getMessage();
    }
    return message;
    }
}

    

