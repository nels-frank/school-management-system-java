
package connection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import entities.Formaster;
import entities.Headteacher;
import sessionbeans.AnnualresultFacade;
import sessionbeans.FormasterFacade;
import sessionbeans.HeadteacherFacade;

@Stateless
public class dbConnection implements Serializable{
    
    @EJB
    private FormasterFacade FFF;
    private String formname;
    @EJB
    private HeadteacherFacade HF; 
    private String headteacher;
    private String headname;
    @EJB
    private AnnualresultFacade ANF;
    Connection con = null;
    Statement stmt = null;
    ResultSet rst = null;

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    public String getHeadteacher() {
        return headteacher;
    }

    public void setHeadteacher(String headteacher) {
        this.headteacher = headteacher;
    }

    public String getHeadname() {
        return headname;
    }

    public void setHeadname(String headname) {
        this.headname = headname;
    }

    
    
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
  
    public double SumFeespayment(String dayofpayment) {
        double acct = 0;
        String sql = "SELECT SUM(amountpaid) FROM feeshistory where date='" + dayofpayment + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getDouble(1);               
            }
        } catch (Exception e) {
            acct = 0;
        }
        return acct;
    }
    
    public double SumExpenses(String date) {
        double acct = 0;
        String sql = "SELECT SUM(amount) FROM expenditure where date='" + date + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getDouble(1);
                
            }
        } catch (Exception e) {
            acct = 0;
        }
        return acct;
    }
    
    public double Sumforterm(String sessions, String term) {
        double acct = 0;
        String sql = "SELECT SUM(feesamount) FROM account where sessions='" + sessions + "'AND term='" + term +"'" ;
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getDouble(1);
                
            }
        } catch (Exception e) {
            acct = 0;
        }
        return acct;
    }
    
    public double Sumforterm2(String sessions, String term) {
        double acct = 0;
        String sql = "SELECT SUM(expensesamount) FROM account where sessions='" + sessions + "'AND term='" + term +"'" ;
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getDouble(1);
                
            }
        } catch (Exception e) {
            acct = 0;
        }
        return acct;
    }
    
    public int checkAccount(String dayofpayment) {
        int acct = 0;
        String sql = "SELECT count(dayofpayment) FROM account where dayofpayment='" + dayofpayment +"'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt(1);
                acct = acct + 1;
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
    
    public int termlycount(String sessions, String term) {
        int acct = 0;
        String sql = "SELECT count(term,session) FROM termlyaccount where sessions='" + sessions + "' AND term='" + term+"'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt(1);
                acct = acct + 1;
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
    
    public double SumforSession(String sessions) {
        double acct = 0;
        String sql = "SELECT SUM(termlyobtained) FROM termlyaccount where sessions='" + sessions + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getDouble(1);
                
            }
        } catch (Exception e) {
            acct = 0;
        }
        return acct;
    }
    
    public double SumforSession2(String sessions) {
        double acct = 0;
        String sql = "SELECT SUM(termlyexpenses) FROM termlyaccount where sessions='" + sessions + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getDouble(1);
                
            }
        } catch (Exception e) {
            acct = 0;
        }
        return acct;
    }
    
    public double SumforSession4(String sessions) {
        double acct = 0;
        String sql = "SELECT SUM(tookhome) FROM termlyaccount where sessions='" + sessions + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getDouble(1);
                
            }
        } catch (Exception e) {
            acct = 0;
        }
        return acct;
    }
    
    public int checkSessionAccount(String sessions) {
        int acct = 0;
        String sql = "SELECT count(sessions) FROM sessionaccount where sessions='" + sessions +"'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt(1);
                acct = acct + 1;
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
    
    public void prepareclassFeespayment(String classcode,String term,String session, double tuitionfee, double balance) {
        String acct = "";
        String sql = "SELECT * FROM Studentsinfo where classcode='"+classcode+"'";
        Statement st = this.connect();
        try {
            ResultSet rst = null;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //feescode, session, term,  regno, name, classcode, classlevel
                String regno = rs.getString("regno");
                String fname = rs.getString("fname");
                String mname= rs.getString("mname");
                String lname = rs.getString("lname");
                String name = fname+" "+mname+" "+lname;
                String classlevel = rs.getString("level");
                String pictureurl = rs.getString("pictureurl");
               String sq = "INSERT INTO feespayment(session, term,  regno, balance, name, classlevel, classoption,tuitionfee,pictureurl) VALUES(?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, session);
                ps.setString(2, term);
                ps.setString(3, regno);
                ps.setDouble(4, balance);
                ps.setString(5, name);
                ps.setString(6, classlevel);
                ps.setString(7, classcode);
                ps.setDouble(8, tuitionfee);
                ps.setString(9, pictureurl);
                int rows = ps.executeUpdate();
                if (rows >= 1) {
                
                }
            }
        } catch (Exception e) {
            //       acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
        }
        //  return acct;
    }
         
     public void preparestudentFeespayment(String regno, String classcode,String term,String session, double tuitionfee, double balance) {
        String acct = "";
        String sql = "SELECT * FROM Studentsinfo where regno='"+regno+"'";
        Statement st = this.connect();
        try {
            ResultSet rst = null;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //feescode, session, term,  regno, name, classcode, classlevel
                String fname = rs.getString("fname");
                String mname= rs.getString("mname");
                String lname = rs.getString("lname");
                String name = fname+" "+mname+" "+lname;
                String classlevel = rs.getString("level");
                String pictureurl = rs.getString("pictureurl");
               String sq = "INSERT INTO feespayment(session, term,  regno, balance, name, classlevel, classoption,tuitionfee,pictureurl) VALUES(?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, session);
                ps.setString(2, term);
                ps.setString(3, regno);
                ps.setDouble(4, balance);
                ps.setString(5, name);
                ps.setString(6, classlevel);
                ps.setString(7, classcode);
                ps.setDouble(8, tuitionfee);
                ps.setString(9, pictureurl);
                int rows = ps.executeUpdate();
                if (rows >= 1) {
                
                }
            }
        } catch (Exception e) {
            //       acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
        }
        //  return acct;
    }
     
     public void DeleteFeespayment() {
        Statement stt = this.connect();
        try {
            String sql = "DELETE  FROM feespayment";
            int rows = stt.executeUpdate(sql);
            if (rows >= 1) {
                // System.out.println("Successfully Deleted");
            }
        } catch (Exception e) {
            // System.out.println("not deleted "+e.getMessage());
        }      
    }
     public int checkSSS3A() {
        int acct = 0;
        String sql = "SELECT count(classoption) FROM studentsinfo where classoption='" + "SSS 3A" +"'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt(1);
                acct = acct + 1;
            }
        } catch (Exception e) {
            acct = 0;
System.out.println("My name is Frank");
        }
        return acct;
    }
     
     public int checkUsername(String username) {
        int acct = 0;
        String sql = "SELECT * FROM users where username='" + username + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt(1);
              
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
     
     public int checkUsername2(String username) {
        int acct = 0;
        String sql = "SELECT * FROM users where username='" + username + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt(1);
              
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
     public String titleCase(String input) {
        String name = input;
        try {

            String[] parts = name.split(" ");
            StringBuilder sb = new StringBuilder(64);
            for (String part : parts) {
                char[] chars = part.toLowerCase().toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);

                sb.append(new String(chars)).append(" ");
            }

            name = sb.toString().trim();
            System.out.println(name);
        } catch (Exception e) {
        }
        return name;
    }
     public String feesPin(int count) {
        int ts = count+1;
        String regno = null;
        String sch = "";
        try {
            if (ts < 10) {
                regno = "000" + ts;
            }
            if (ts >= 10 && ts < 100) {
                regno = sch + "00" + ts;
            }
            if (ts >= 100  && ts<1000) {
                regno = sch + "0" + ts;
            }
            if (ts >= 1000) {
                regno = sch + "" + ts;
            }
        } catch (Exception e) {
        }
        return regno;
    }
     
     public int countbySessionAndClasslevel(String session) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM studentsinfo where session='" + session + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt(1);
                acct = acct + 1;
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
     
     public String totalStudent(int count, String sessioncode) {
        int ts = count +1;
        String regno = null;
        String sch = "KRS";
        try {
            if (ts < 10) {
                regno = sch + "/000" + ts + "/" + sessioncode;
            }
            if (ts >= 10 && ts < 100) {
                regno = sch + "/00" + ts + "/" + sessioncode;
            }
            if (ts >= 100 && ts < 1000) {
                regno = sch + "/0" + ts + "/" + sessioncode;
            }
            if (ts >= 1000) {
                regno = sch + "/" + ts + "/" + sessioncode;
            }
        } catch (Exception e) {
        }
        return regno;
    }
     public String checkClass(int ts, String classlevel) {
        String classcode = null;
        try {
            if (ts <= 50 && classlevel.equals("1")) {
                classcode = "JSS 1A";
            }
            if (ts > 50 && ts <= 100 && classlevel.equals("1")) {
                classcode = "JSS 1B";
            }
            if (ts > 100 && ts <= 150 && classlevel.equals("1")) {
                classcode = "JSS 1C";
            }
            if (ts > 150 && ts <= 200 && classlevel.equals("1")) {
                classcode = "JSS 1D";
            }
            if (ts > 200 && ts <= 250 && classlevel.equals("1")) {
                classcode = "JSS 1E";
            }
            if (ts > 250 && ts <= 300 && classlevel.equals("1")) {
                classcode = "JSS 1F";
            }
            if (ts > 300 && ts <= 350 && classlevel.equals("1")) {
                classcode = "JSS 1G";
            }
            if (ts > 350 && ts <= 400 && classlevel.equals("1")) {
                classcode = "JSS 1H";
            }
            if (ts > 400 && ts <= 450 && classlevel.equals("1")) {
                classcode = "JSS 1I";
            }
            if (ts > 450 && ts <= 500 && classlevel.equals("1")) {
                classcode = "JSS 1J";
            }
            if (ts <= 50 && classlevel.equals("2")) {
                classcode = "JSS 2A";
            }
            if (ts > 50 && ts <= 100 && classlevel.equals("2")) {
                classcode = "JSS 2B";
            }
            if (ts > 100 && ts <= 150 && classlevel.equals("2")) {
                classcode = "JSS 2C";
            }
            if (ts > 150 && ts <= 200 && classlevel.equals("2")) {
                classcode = "JSS 2D";
            }
            if (ts > 200 && ts <= 250 && classlevel.equals("2")) {
                classcode = "JSS 2E";
            }
            if (ts > 250 && ts <= 300 && classlevel.equals("2")) {
                classcode = "JSS 2F";
            }
            if (ts > 300 && ts <= 350 && classlevel.equals("2")) {
                classcode = "JSS 2G";
            }
            if (ts > 350 && ts <= 400 && classlevel.equals("2")) {
                classcode = "JSS 2H";
            }
            if (ts > 400 && ts <= 450 && classlevel.equals("2")) {
                classcode = "JSS 2I";
            }
            if (ts > 450 && ts <= 500 && classlevel.equals("2")) {
                classcode = "JSS 2J";
            }
            if (ts <= 50 && classlevel.equals("3")) {
                classcode = "JSS 3A";
            }
            if (ts > 50 && ts <= 100 && classlevel.equals("3")) {
                classcode = "JSS 3B";
            }
            if (ts > 100 && ts <= 150 && classlevel.equals("3")) {
                classcode = "JSS 3C";
            }
            if (ts > 150 && ts <= 200 && classlevel.equals("3")) {
                classcode = "JSS 3D";
            }
            if (ts > 200 && ts <= 250 && classlevel.equals("3")) {
                classcode = "JSS 3E";
            }
            if (ts > 250 && ts <= 300 && classlevel.equals("3")) {
                classcode = "JSS 3F";
            }
            if (ts > 300 && ts <= 350 && classlevel.equals("3")) {
                classcode = "JSS 3G";
            }
            if (ts > 350 && ts <= 400 && classlevel.equals("3")) {
                classcode = "JSS 3H";
            }
            if (ts > 400 && ts <= 450 && classlevel.equals("3")) {
                classcode = "JSS 3I";
            }
            if (ts > 450 && ts <= 500 && classlevel.equals("3")) {
                classcode = "JSS 3J";
            }
            if (ts <= 50 && classlevel.equals("4")) {
                classcode = "SSS 1A";
            }
            if (ts > 50 && ts <= 100 && classlevel.equals("4")) {
                classcode = "SSS 1B";
            }
            if (ts > 100 && ts <= 150 && classlevel.equals("4")) {
                classcode = "SSS 1C";
            }
            if (ts > 150 && ts <= 200 && classlevel.equals("4")) {
                classcode = "SSS 1D";
            }
            if (ts > 200 && ts <= 250 && classlevel.equals("4")) {
                classcode = "SSS 1E";
            }
            if (ts > 250 && ts <= 300) {
                classcode = "SSS 1F";
            }
            if (ts > 300 && ts <= 350 && classlevel.equals("4")) {
                classcode = "SSS 1G";
            }
            if (ts > 350 && ts <= 400 && classlevel.equals("4")) {
                classcode = "SSS 1H";
            }
            if (ts > 400 && ts <= 450 && classlevel.equals("4")) {
                classcode = "SSS 1I";
            }
            if (ts > 450 && ts <= 500 && classlevel.equals("4")) {
                classcode = "SSS 1J";
            }
        } catch (Exception e) {
        }
        return classcode;
    }
     
     public double checkBalance(String regno) {
        double acct = 0;
        String sql = "SELECT balance FROM feespayment where regno='" + regno + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getDouble(1);
                acct = acct ;
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
     
      public double checkClassoption(String classoption) {
        double acct = 0;
        String sql = "SELECT classoption FROM studentsinfo where classoption='" + classoption + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getDouble(1);
                acct = acct ;
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
      
      public double checkBalance2(String regno) {
        double acct = 0;
        String sql = "SELECT balance FROM feespayment where regno='" + regno + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getDouble(1);
                acct = acct ;
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
       public void prepareResult(String level, String classcode, String subjects, String examsession, String term) {
        String acct = "";
        String sql = "SELECT * FROM studentsinfo where classcode='"+classcode+"'";
        Statement st = this.connect();
        try {
            ResultSet rst = null;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String regno = rs.getString("regno");
                String fname = rs.getString("fname");
                String mname= rs.getString("mname");
                String lname = rs.getString("lname");               
                String name = fname+" "+mname+" "+lname;
                String computecode=regno+""+subjects+""+term+""+examsession;
                String sex = rs.getString("sex"); 
                String pictureurl = rs.getString("pictureurl");
               String sq = "INSERT INTO computeresult(computecode, regno,  name, subjects, level, classcode, term,examsession, sex, pictureurl) VALUES(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, computecode);
                ps.setString(2, regno);
                ps.setString(3, name);
                ps.setString(4, subjects);
                ps.setString(5, level);
                ps.setString(6, classcode);
                ps.setString(7, term);
                ps.setString(8, examsession); 
                ps.setString(9, sex);
                ps.setString(10, pictureurl);
                int rows = ps.executeUpdate();
                if (rows >= 1) {           
                }
            }
        } catch (Exception e) {
            //       acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
        }
        //  return acct;
    }
       
       public void prepareRegResult(String regno, String level, String classcode, String subjects, String examsession, String term) {
        String acct = "";
        String sql = "SELECT * FROM studentsinfo where regno='"+regno+"'";
        Statement st = this.connect();
        try {
            ResultSet rst = null;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {              
                String fname = rs.getString("fname");
                String mname= rs.getString("mname");
                String lname = rs.getString("lname");
                String name = fname+" "+mname+" "+lname;
                String computecode=regno+""+subjects+""+term+""+examsession;
                String sex = rs.getString("sex");
                String pictureurl = rs.getString("pictureurl");
                String sq = "INSERT INTO computeresult(computecode, regno,  name, subjects, level, classcode, term,examsession, sex, pictureurl) VALUES(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, computecode);
                ps.setString(2, regno);
                ps.setString(3, name);
                ps.setString(4, subjects);
                ps.setString(5, level);
                ps.setString(6, classcode);
                ps.setString(7, term);
                ps.setString(8, examsession);
                ps.setString(9, sex); 
                ps.setString(10, pictureurl); 
                int rows = ps.executeUpdate();
                if (rows >= 1) {           
                }
            }
        } catch (Exception e) {
            //       acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
        }
        //  return acct;
    }
       
       public void prepareAttendance(String classcode, String examsession, String term, String level) {
        String acct = "";
        String sql = "SELECT * FROM studentsinfo where classcode='"+classcode+"'";
        Statement st = this.connect();
        try {
            ResultSet rst = null;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String regno = rs.getString("regno");
                String fname = rs.getString("fname");
                String mname= rs.getString("mname");
                String lname = rs.getString("lname");
                String name = fname+" "+mname+" "+lname;               
                String attendancecode=regno+""+examsession+""+term;               
                String sq = "INSERT INTO attendance(attendancecode, regno,  name, level, classcode,term,examsession) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, attendancecode);
                ps.setString(2, regno);
                ps.setString(3, name);
                ps.setString(4, level);
                ps.setString(5, classcode); 
                ps.setString(6, term);
                ps.setString(7, examsession); 
                int rows = ps.executeUpdate();
                if (rows >= 1) {                
                }
            }
        } catch (Exception e) {
            //       acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
        }
        //  return acct;
    }
       
       public void preparePsychomotor(String classcode, String examsession, String term, String level) {
        String acct = "";
        String sql = "SELECT * FROM studentsinfo where classcode='"+classcode+"'";
        Statement st = this.connect();
        try {
            ResultSet rst = null;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String regno = rs.getString("regno");
                String fname = rs.getString("fname");
                String mname= rs.getString("mname");
                String lname = rs.getString("lname");
                String name = fname+" "+mname+" "+lname;               
                String code=regno+""+examsession+""+term;               
                String sq = "INSERT INTO psychomotor(code, regno,  name, level, classcode,term,examsession) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, code);
                ps.setString(2, regno);
                ps.setString(3, name);
                ps.setString(4, level);
                ps.setString(5, classcode); 
                ps.setString(6, term);
                ps.setString(7, examsession); 
                int rows = ps.executeUpdate();
                if (rows >= 1) {                
                }
            }
        } catch (Exception e) {
            //       acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
        }
        //  return acct;
    }
       
       public void studentPsychomotor(String regno, String classcode, String examsession, String term, String level) {
        String acct = "";
        String sql = "SELECT * FROM studentsinfo where regno='"+regno+"'";
        Statement st = this.connect();
        try {
            ResultSet rst = null;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String fname = rs.getString("fname");
                String mname= rs.getString("mname");
                String lname = rs.getString("lname");
                String name = fname+" "+mname+" "+lname;               
                String code=regno+""+examsession+""+term;               
                String sq = "INSERT INTO psychomotor(code, regno,  name, level, classcode,term,examsession) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, code);
                ps.setString(2, regno);
                ps.setString(3, name);
                ps.setString(4, level);
                ps.setString(5, classcode); 
                ps.setString(6, term);
                ps.setString(7, examsession); 
                int rows = ps.executeUpdate();
                if (rows >= 1) {                
                }
            }
        } catch (Exception e) {
            //       acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
        }
        //  return acct;
    }
       
       
       public void prepareRegAttendance( String examsession, String term, String level, String classcode, String regno) {
        String acct = "";
        String sql = "SELECT * FROM studentsinfo where regno='"+regno+"'";
        Statement st = this.connect();
        try {
            ResultSet rst = null;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {               
                String fname = rs.getString("fname");
                String mname= rs.getString("mname");
                String lname = rs.getString("lname");
                String name = fname+" "+mname+" "+lname;               
                String attendancecode=regno+""+examsession+""+term;               
                String sq = "INSERT INTO attendance(attendancecode, regno,  name, level, classcode,term,examsession) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, attendancecode);
                ps.setString(2, regno);
                ps.setString(3, name);
                ps.setString(4, level);
                ps.setString(5, classcode); 
                ps.setString(6, term);
                ps.setString(7, examsession); 
                int rows = ps.executeUpdate();
                if (rows >= 1) {                
                }
            }
        } catch (Exception e) {
            //       acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
        }
        //  return acct;
    }
              
       public void toSubHistory(String classcode, String subjects) {
        String acct = "";
        String sql = "SELECT * FROM computeresult where classcode='" + classcode + "'AND subjects='" + subjects +"'";
        Statement st = this.connect();
        try {
            ResultSet rst = null;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {             
                String computecode=rs.getString("computecode");
                String regno = rs.getString("regno");
                String name = rs.getString("name");
//            String subjects = rs.getString("subjects");
                int ass1= rs.getInt("ass1");
                int ass2 = rs.getInt("ass2");
                int ass3 = rs.getInt("ass3");
                int exam= rs.getInt("exam");
                int total = rs.getInt("total");
                Double classavg= rs.getDouble("classavg");
                int highest = rs.getInt("highest");
                int lowest = rs.getInt("lowest");
                String position= rs.getString("position");
                String grade = rs.getString("grade");
                String remark=rs.getString("remark");
                String level = rs.getString("level");
          //      String classcode = rs.getString("classcode");
                String term = rs.getString("term");  
                String examsession=rs.getString("examsession");
                String sex=rs.getString("sex");
                String pictureurl=rs.getString("pictureurl");
                String code= computecode+""+classcode;
               String sq = "INSERT INTO resultbank(computecode, regno,  name, subjects, ass1, ass2, ass3,exam,total,classavg,highest,lowest,position,grade,remark,level,classcode,term,examsession, sex, pictureurl) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, code);
                ps.setString(2, regno);
                ps.setString(3, name);
                ps.setString(4, subjects);
                ps.setInt(5, ass1);
                ps.setInt(6, ass2);
                ps.setInt(7, ass3);
                ps.setInt(8, exam); 
                ps.setInt(9, total);
                ps.setDouble(10, classavg);
                ps.setInt(11, highest);
                ps.setInt(12, lowest);
                ps.setString(13, position);
                ps.setString(14, grade);
                ps.setString(15, remark);
                ps.setString(16, level); 
                ps.setString(17, classcode);
                ps.setString(18, term);
                ps.setString(19, examsession);
                ps.setString(20, sex);
                ps.setString(21, pictureurl);                
                int rows = ps.executeUpdate();
                if (rows >= 1) {           
                }
            }
        } catch (Exception e) {
            //       acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
        }
        //  return acct;
    }
      
       public void DeleteCoputeResult(String classcode, String subjects, String examsession, String term) {
        Statement stt = this.connect();
        try {
            String sql = "DELETE  FROM computeresult where classcode='" + classcode + "'AND subjects='" + subjects +"'AND examsession='" + examsession +"'AND term='" + term +"'";
            int rows = stt.executeUpdate(sql);
            if (rows >= 1) {
                // System.out.println("Successfully Deleted");
            }
        } catch (Exception e) {
            // System.out.println("not deleted "+e.getMessage());
        }      
    } 
     
      
      public void DeleteAttendance(String classcode) {
        Statement stt = this.connect();
        try {
            String sql = "DELETE  FROM attendance where classcode='" + classcode +"'";
            int rows = stt.executeUpdate(sql);
            if (rows >= 1) {
            // System.out.println("Successfully Deleted");
            }
        } catch (Exception e) {
            // System.out.println("not deleted "+e.getMessage());
        }      
    }
      
      public void prepareAnnual(String examsession) {
        String acct = "";
        String sql = "SELECT * FROM studentsinfo where session='"+examsession+"'";
        Statement st = this.connect();
        try {
            ResultSet rst = null;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String regno = rs.getString("regno");
                String fname = rs.getString("fname");
                String mname= rs.getString("mname");
                String lname = rs.getString("lname");
                String classcode=rs.getString("classcode");
                String name = fname+" "+mname+" "+lname;                               
                String sq = "INSERT INTO attendance(regno,  name, examsession, classcode) VALUES(?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, regno);
                ps.setString(2, name);
                ps.setString(3, examsession);
                ps.setString(4, classcode);                
                int rows = ps.executeUpdate();
                if (rows >= 1) {                
                }
            }
        } catch (Exception e) {
            //       acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
        }
        //  return acct;
    }
      
      public int sumFinaltotal(String regno, String acasession) {
        int acct = 0;
        String sql = "SELECT SUM(finaltotal) FROM classreportbank where regno='" + regno + "'AND acasession='" + acasession +"'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt(1);
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
      
      public double sumFinalaverage(String regno, String acasession) {
        double acct = 0;
        String sql = "SELECT SUM(finalaverage) FROM classreportbank where regno='" + regno + "'AND acasession='" + acasession +"'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getDouble(1);
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
      
      public String remark(double finalaverage) {
        String remark = null;
        try {
            if (finalaverage >= 40.0) {
                remark = "PROMOTED";

            }
            if (finalaverage < 40.0) {
                remark = "REPEATED";
            }           
        } catch (Exception e) {
        }
        return remark;
    }
      
      public void ComputeAnnual(String classcode, String acasession) {
        String sql = "SELECT * FROM studentsinfo where classcode='" + classcode + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String regno = rs.getString("regno");
                String name = rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname");               
                int finaltotal = sumFinaltotal(regno, acasession);
                DecimalFormat OneDF = new DecimalFormat("#.00");
                double averages = sumFinalaverage(regno,acasession);
 //           System.out.println(averages);
                double finalaverage= averages/3;
                String av = OneDF.format(finalaverage);
                double avg = Double.parseDouble(av);
                String remark = remark(finalaverage);
                String level = rs.getString("level");
                String sex = rs.getString("sex");
                String pictureurl = rs.getString("pictureurl");
                String code=regno+""+acasession;
                headteacher="tesem";
                Headteacher cur= HF.find(headteacher);
                headname = cur.getHeadname();
                Formaster curr = FFF.find(classcode);
                formname = curr.getFormname();                                                    
                String sq = "INSERT INTO annualbank(code, name, finaltotal, finalaverage,  remark, classcode,term,acasession, levelposition, level, classstatus, levelstatus, juniorstatus, seniorstatus, overallstatus, regno, sex, pictureurl) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, code);
                ps.setString(2, name);
                ps.setDouble(3, finaltotal);
                ps.setDouble(4, avg);
                ps.setString(5, remark);
                ps.setString(6, classcode);
                ps.setString(7, headname);
                ps.setString(8, acasession);
                ps.setString(9, formname);
                ps.setString(10, level);
                ps.setString(11, "noposition");
                ps.setString(12, "noposition");
                ps.setString(13, "noposition");
                ps.setString(14, "noposition");
                ps.setString(15, "noposition");
                ps.setString(16, regno);
                ps.setString(17, sex);
                ps.setString(18, pictureurl);
                int rows = ps.executeUpdate();
                if (rows >= 1) {
                    System.out.println("successfully updated");
                }
            }
        } catch (Exception e) {
            //       acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
        }
        //  return acct;
    }
      
      
      public void DeleteAnnualBank(String classcode, String acasession) {
        Statement stt = this.connect();
        try {
            String sql = "DELETE  FROM annualbank where classcode='" + classcode + "' AND acasession='"+acasession+"'" ;
            int rows = stt.executeUpdate(sql);
            if (rows >= 1) {
                // System.out.println("Successfully Deleted");
            }
        } catch (Exception e) {
            // System.out.println("not deleted "+e.getMessage());
        }      
    }

      public void DeleteClassreportbank(String classcode, String acasession, String term) {
        Statement stt = this.connect();
        try {
            String sql = "DELETE  FROM classreportbank where classcode='" + classcode + "' AND acasession='" + acasession + "' AND term='" + term + "'";
            int rows = stt.executeUpdate(sql);
            if (rows >= 1) {         
            }
        } catch (Exception e) {         
        }      
    } 
      
      public void DeletePsychomotor(String classcode) {
        Statement stt = this.connect();
        try {
            String sql = "DELETE  FROM psychomotor where classcode='" + classcode +"'";
            int rows = stt.executeUpdate(sql);
            if (rows >= 1) {
            // System.out.println("Successfully Deleted");
            }
        } catch (Exception e) {
            // System.out.println("not deleted "+e.getMessage());
        }      
    }
      
      public int countCode(String code) {
        int acct = 0;
        String sql = "SELECT count(code) FROM classreportbank where code='" + code + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt(1);
                acct = acct + 1;
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
      
      public int countAnnuabank(String code) {
        int acct = 0;
        String sql = "SELECT count(code) FROM annualbank where code='" + code + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt(1);
                acct = acct + 1;
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
      
      public void setAnnual(String acasession, String classcode, String subjects) {
        String acct = "";
        String sql = "SELECT * FROM studentsinfo where classcode='" + classcode +"'" ;
        Statement st = this.connect();
        try {
            ResultSet rst = null;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String regno = rs.getString("regno");
                String resultcode= regno+""+acasession+""+classcode+""+subjects;                
                String name = rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname");           
                int firstterm= selectFirstTerm(acasession, classcode, subjects, regno);
                int secondterm=selectSecondTerm(acasession, classcode, subjects, regno);
                int thirdterm=selectThirdTerm(acasession, classcode, subjects, regno);
                String level = rs.getString("level");
                int total= firstterm+secondterm+thirdterm;
                double avg=total/3;
                String grade=ANF.grade(total);
                String remark=ANF.remark(total);     
                String sq = "INSERT INTO annualresult (resultcode, regno, name, subject, firsttermscore, secondtermscore, thirdtemscore, total, avg, grade, remark, acasession, classcode, level, status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, resultcode);
                ps.setString(2, regno);
                ps.setString(3, name);
                ps.setString(4, subjects);
                ps.setInt(5, firstterm); 
                ps.setInt(6, secondterm); 
                ps.setInt(7, thirdterm); 
                ps.setInt(8, total); 
                ps.setDouble(9, avg);
                ps.setString(10, grade);
                ps.setString(11, remark);
                ps.setString(12, acasession);
                ps.setString(13, classcode);
                ps.setString(14, level); 
                ps.setString(15, "noposition");
                int rows = ps.executeUpdate();
                if (rows >= 1) {           
                }
            }
        } catch (Exception e) {
            //       acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
        }
        //  return acct;
    }
      
        public int selectFirstTerm(String acasession, String classcode, String subjects, String regno) {
        int acct = 0;
        String sql = "SELECT total FROM computeresult where  examsession='" + acasession + "' AND classcode='"+classcode+"' AND subjects='"+subjects+"' AND regno='"+regno+"' AND term='1ST TERM' ";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt(1);

            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
        
    public int selectSecondTerm(String acasession, String classcode, String subjects, String regno) {
        int acct = 0;
        String sql = "SELECT total FROM computeresult where  examsession='" + acasession + "' AND classcode='"+classcode+"' AND subjects='"+subjects+"' AND regno='"+regno+"' AND term='2ND TERM' ";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt(1);
              
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }    
        
      
    public int selectThirdTerm(String acasession, String classcode, String subjects, String regno) {
        int acct = 0;
        String sql = "SELECT total FROM computeresult where  examsession='" + acasession + "' AND classcode='"+classcode+"' AND subjects='"+subjects+"' AND regno='"+regno+"' AND term='3RD TERM' ";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt(1);
              
            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
        public void DeleteAnnualResult(String acasession, String classcode, String subjects) {
        Statement stt = this.connect();
        try {
            String sql = "DELETE  FROM annualresult where acasession='" + acasession + "' AND classcode='" + classcode + "'AND subject='" + subjects +"'";
            int rows = stt.executeUpdate(sql);
            if (rows >= 1) {
                // System.out.println("Successfully Deleted");
            }
        } catch (Exception e) {
            // System.out.println("not deleted "+e.getMessage());
        }      
    } 
        
    
}
      

