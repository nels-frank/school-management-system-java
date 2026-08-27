/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SET07.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ejb.Stateless;

@Stateless
public class Resultbanck {
      Connection con = null;
    Statement stmt = null;
    ResultSet rst = null;

    public Statement connect() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/school";
        String un = "root";
        String pw = "YOUR_DATABASE_PASSWORD";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, un, pw);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error connecting due to " + e.getMessage());
        }
        return stmt;
    }

    public void closeConnection() {
        if (rst != null) {
            try {
                rst.close();
            } catch (Exception e) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {

            }
        }
   }
   public String PrincipalRemark(double avg) {
        String remark = null; 
        try {
            if (avg < 40.0) {
                remark = "Improve your Performance";

            }
            if (avg >= 40.0 && avg < 50.0) {
                remark = "You need to Sit up";

            }
            if (avg >= 50.0 && avg < 60.0) {
                remark = "Good Result but work harder";

            }
            if (avg >= 60.0 && avg < 70.0) {
                remark = "Good Result";

            }
            if (avg >= 70.0 && avg < 80.0) {
                remark = "Very Good Result";

            }
             if (avg >= 80.0 ) {
                remark = "Excellent Result ";

            }
        } catch (Exception e) {
        }
        return remark;
    }
 public String TeachersRemark(double avg) {
        String remark = null;
        try {
            if (avg < 40.0) {
                remark = "Sit up and Study Hard";

            }
            if (avg >= 40.0 && avg < 50.0) {
                remark = "Try and Sit up";

            }
            if (avg >= 50.0 && avg < 60.0) {
                remark = "Good Result but work harder";

            }
            if (avg >= 60.0 && avg < 70.0) {
                remark = "Good Result keep it up";

            }
            if (avg >= 70.0 && avg < 80.0) {
                remark = "Very Good Result keep it up";

            }
             if (avg >= 80.0 ) {
                remark = "Excellent Result keep it up ";
            }
        } catch (Exception e) {
        }
        return remark;
 }
 public String PrincipalAnnualRemark(double avg) {
        String remark = null; 
        try {
            if (avg < 45.0) {
                remark = "REPEAT";

            }
            if (avg >= 45.0 && avg < 50.0) {
                remark = "PROMOTED ON TRIAL";

            }
            if (avg >= 50.0 ) {
                remark = "PROMOTED";

            }
           
        } catch (Exception e) {
        }
        return remark;
    }
 
}
