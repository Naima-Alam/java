/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ERIN
 */
public class DatabaseControl {

    Connection dbconnection() {
        Connection c = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://DESKTOP-4P8UEER/myproject", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    ObservableList<AdminViewStdntModel> adminviewstdnttable() throws SQLException {
        ObservableList<AdminViewStdntModel> adminviewstdntlist = FXCollections.observableArrayList();
        Connection c = dbconnection();
        String sql = "SELECT * FROM adminadds";
        //String sql ="SELECT * FROM studentviewc";
        ResultSet rs = c.createStatement().executeQuery(sql);

        while (rs.next()) {
            int sn = rs.getInt("SerialNo");
            String name = rs.getString("Name");
            int id = rs.getInt("ID");
//                    String sec = rs.getString("Section");
            int batch = rs.getInt("Batch");
            String dept = rs.getString("Department");
            String pswrd = rs.getString("Password");
            AdminViewStdntModel objfx3vwstdnt = new AdminViewStdntModel(sn, name, id, batch, dept, pswrd);
            adminviewstdntlist.add(objfx3vwstdnt);

        }
        return adminviewstdntlist;
    }

    ObservableList<AdminViewCourseModel> adminviewcoursetable() throws SQLException {
        ObservableList<AdminViewCourseModel> adminviewcourselist = FXCollections.observableArrayList();
        Connection c = dbconnection();
        String sql = "SELECT * FROM adminaddc";
        ResultSet rs = c.createStatement().executeQuery(sql);

        while (rs.next()) {
            int sn = rs.getInt("SerialNo");
            String title = rs.getString("CourseTitle");
            String code = rs.getString("CourseCode");
            int batch = rs.getInt("Batch");
            int credit = rs.getInt("Credit");
            String sec = rs.getString("Section");
            int seat = rs.getInt("Seat");
            AdminViewCourseModel objfx6vwcourse = new AdminViewCourseModel(sn, title, code, batch, credit, sec, seat);
            adminviewcourselist.add(objfx6vwcourse);

        }
        return adminviewcourselist;
    }

    ObservableList<StudentEnrollCourseModel> stdntenrolltable(long stdntbatch) throws SQLException {
        ObservableList<StudentEnrollCourseModel> stdntenrolllist = FXCollections.observableArrayList();
        Connection c = dbconnection();
        String sql = "SELECT * FROM adminaddc WHERE Batch='" + stdntbatch + "'";
        ResultSet rs = c.createStatement().executeQuery(sql);

        while (rs.next()) {
            int sn = rs.getInt("SerialNo");
            String title = rs.getString("CourseTitle");
            String code = rs.getString("CourseCode");
            String sec = rs.getString("Section");
            int credit = rs.getInt("Credit");
            int batch = rs.getInt("Batch");
            int seat = rs.getInt("Seat");
            StudentEnrollCourseModel objfx8stdntenrlcrs = new StudentEnrollCourseModel(sn, title, code, sec, credit, batch, seat);
            stdntenrolllist.add(objfx8stdntenrlcrs);
        }
        return stdntenrolllist;
    }

    ObservableList<StudentViewCoursesModel> stdntvwcrstable(long stdntid) throws SQLException {
        ObservableList<StudentViewCoursesModel> stdntvwcrslist = FXCollections.observableArrayList();
        Connection c = dbconnection();
        String sql = "SELECT * FROM studentaddc WHERE StudentID='" + stdntid + "'";
        ResultSet rs = c.createStatement().executeQuery(sql);

        while (rs.next()) {
            int sn = rs.getInt("SerialNo");
            String title = rs.getString("CourseTitle");
            String code = rs.getString("CourseCode");
            String sec = rs.getString("Section");
            int batch = rs.getInt("Batch");
            StudentViewCoursesModel objfx9stdntvwcrs = new StudentViewCoursesModel(sn, title, code, batch, sec);
            stdntvwcrslist.add(objfx9stdntvwcrs);

        }
        return stdntvwcrslist;
    }

    void admininsertStdnt(String name, int id, int batch, String dept, String pswrd) {
        Connection c = dbconnection();
        String sql = "INSERT INTO adminadds(Name,ID,Batch,Department,Password) VALUES ('" + name + "','" + id + "','" + batch + "','" + dept + "','" + pswrd + "')";
        try {
            c.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void admindeleteStdnt(int sn) {
        Connection c = dbconnection();
        String sql = "DELETE FROM adminadds WHERE SerialNo='" + sn + "'";
        try {
            c.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void admininsertCourse(String title, String code, int batch, int credit, String sec, int seat) {
        Connection c = dbconnection();
        String sql = "INSERT INTO adminaddc(CourseTitle,CourseCode,Batch,Credit,Section,Seat) VALUES ('" + title + "','" + code + "','" + batch + "','" + credit + "','" + sec + "','" + seat + "')";
        try {
            c.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void admindeleteCourse(int sn) {
        Connection c = dbconnection();
        String sql = "DELETE FROM adminaddc WHERE SerialNo='" + sn + "'";
        try {
            c.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void adduserbyadmin(int username, String pswrd) {
        Connection c = dbconnection();
        String sql = "INSERT INTO login (Name,Password,Role) VALUES('" + username + "','" + pswrd + "','2')";
        try {
            c.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void stdntaddCourse(int sn, String title, String code, int batch, int credit, String sec, int seat, long stdntid) {
        Connection c = dbconnection();

        String sql = "INSERT INTO studentaddc(SerialNo,CourseTitle,CourseCode,Section,Batch,Seat,StudentID) VALUES ('" + sn + "','" + title + "','" + code + "','" + sec + "','" + batch + "','" + seat + "','" + stdntid + "')";
        try {
            c.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    void stdntdltCourse(int sn) {
        Connection c = dbconnection();
        String sql = "DELETE FROM studentaddc WHERE SerialNo='" + sn + "'";
        try {
            c.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   int seatcount(String code,String sec)
   {
      int count=0;
      Connection c=dbconnection();
      String sql="SELECT* FROM studentaddc WHERE CourseCode='"+code+"' AND Section='"+sec+"'";
        try {
            ResultSet rs= c.createStatement().executeQuery(sql);
            while(rs.next())
            {
                count++;
            }
            return count;
        } catch (SQLException ex) {
            System.out.println(ex);        }
        return count;
      
   }
    
    
    
    
}
