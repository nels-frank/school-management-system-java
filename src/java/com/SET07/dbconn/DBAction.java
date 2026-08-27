package com.SET07.dbconn;
//import com.sessions.Project.AnnualresultFacade;
//import com.sessions.Project.AttendancebankFacade;
//import com.sessions.Project.MastersheetFacade;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import entities.Attendance;
import entities.Formaster;
import entities.Headteacher;
import sessionbeans.AnnualresultFacade;
import sessionbeans.AttendanceFacade;
import sessionbeans.AttendancebankFacade;
import sessionbeans.FormasterFacade;
import sessionbeans.HeadteacherFacade;
import sessionbeans.MastersheetFacade;

@Stateless
public class DBAction implements Serializable {
    @EJB
    private FormasterFacade FFF;
    private String formname;
    @EJB
    private HeadteacherFacade HF; 
    private String headteacher;
    private String headname;
    
    
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

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }
    
@Inject
        AttendancebankFacade ABF;
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

    public int countbyYearAndLevel(String yearadmitted) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM studentsinfo where yearadmitted='" + yearadmitted + "'";
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

    public int countbyRegno(String regno) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM resultsheet where regno='" + regno + "'";
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

    public int countRegno(String regno) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM computeresult where regno='" + regno + "'";
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

    public String totalStudent(int count, String sessioncode) {
        int ts = count;
        String regno = null;
        String sch = "AJ";
        try {
            if (ts < 10) {
                regno = sch + "/00" + ts + "/" + sessioncode;
            }
            if (ts >= 10 && ts < 100) {
                regno = sch + "/0" + ts + "/" + sessioncode;
            }
            if (ts >= 100) {
                regno = sch + "/" + ts + "/" + sessioncode;
            }
        } catch (Exception e) {
        }
        return regno;
    }

    public String getSubjects(String level, String regno, String classcode, String name, String dob) {
        String acct = null;
        String sql = "SELECT * FROM subjects where level='" + level + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getString("subjectname");

                //computecode, regno, name, subjects, firsttest, secondtest, thirdtest, exam, total, grade, position, remark, classname, classcode, term, examsession
                String scorecode = regno + "" + acct;
                String sq = "INSERT INTO resultsheet(codecompute, regno,name, subjects,level, classcode,dob,status) VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, scorecode);
                ps.setString(2, regno);
                ps.setString(3, name);
                ps.setString(4, acct);
                ps.setString(5, level);
                ps.setString(6, classcode);
                ps.setString(7, dob);
                ps.setString(8, "noposition");
                int rows = ps.executeUpdate();
                if (rows >= 1) {
                    System.out.println("successfully updated");
                }
            }
        } catch (Exception e) {
            acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
        }
        return acct;
    }

    public String getClassAndSubject(String classcode, String subject) {
        String acct = subject;
        String sql = "SELECT * FROM studentsinfo where classcode='" + classcode + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("fname") + "" + rs.getString("mname");
                String regno = rs.getString("regno");
                String dob = rs.getString("dob");
                String level = rs.getString("level");
                String scorecode = regno + "" + acct;
                String sq = "INSERT INTO resultsheet(codecompute, regno,name, subjects,level, classcode,dob) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, scorecode);
                ps.setString(2, regno);
                ps.setString(3, name);
                ps.setString(4, acct);
                ps.setString(5, level);
                ps.setString(6, classcode);
                ps.setString(7, dob);
                int rows = ps.executeUpdate();
                if (rows >= 1) {
                    System.out.println("successfully updated");
                }
            }
        } catch (Exception e) {
            acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
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

    public String checkClass(int ts, String level) {
        String classcode = null;
        try {
            if (ts <= 50 && level.equals("1")) {
                classcode = "JSS 1A";
            }
            if (ts > 50 && ts <= 100 && level.equals("1")) {
                classcode = "JSS 1B";
            }
            if (ts > 100 && ts <= 150 && level.equals("1")) {
                classcode = "JSS 1C";
            }
            if (ts > 150 && ts <= 200 && level.equals("1")) {
                classcode = "JSS 1D";
            }
            if (ts > 200 && ts <= 250 && level.equals("1")) {
                classcode = "JSS 1E";
            }
            if (ts > 250 && ts <= 300 && level.equals("1")) {
                classcode = "JSS 1F";
            }
            if (ts > 300 && ts <= 350 && level.equals("1")) {
                classcode = "JSS 1G";
            }
            if (ts > 350 && ts <= 400 && level.equals("1")) {
                classcode = "JSS 1H";
            }
            if (ts > 400 && ts <= 450 && level.equals("1")) {
                classcode = "JSS 1I";
            }
            if (ts > 450 && ts <= 500 && level.equals("1")) {
                classcode = "JSS 1J";
            }
            if (ts <= 50 && level.equals("2")) {
                classcode = "JSS 2A";
            }
            if (ts > 50 && ts <= 100 && level.equals("2")) {
                classcode = "JSS 2B";
            }
            if (ts > 100 && ts <= 150 && level.equals("2")) {
                classcode = "JSS 2C";
            }
            if (ts > 150 && ts <= 200 && level.equals("2")) {
                classcode = "JSS 2D";
            }
            if (ts > 200 && ts <= 250 && level.equals("2")) {
                classcode = "JSS 2E";
            }
            if (ts > 250 && ts <= 300 && level.equals("2")) {
                classcode = "JSS 2F";
            }
            if (ts > 300 && ts <= 350 && level.equals("2")) {
                classcode = "JSS 2G";
            }
            if (ts > 350 && ts <= 400 && level.equals("2")) {
                classcode = "JSS 2H";
            }
            if (ts > 400 && ts <= 450 && level.equals("2")) {
                classcode = "JSS 2I";
            }
            if (ts > 450 && ts <= 500 && level.equals("2")) {
                classcode = "JSS 2J";
            }
            if (ts <= 50 && level.equals("3")) {
                classcode = "JSS 3A";
            }
            if (ts > 50 && ts <= 100 && level.equals("3")) {
                classcode = "JSS 3B";
            }
            if (ts > 100 && ts <= 150 && level.equals("3")) {
                classcode = "JSS 3C";
            }
            if (ts > 150 && ts <= 200 && level.equals("3")) {
                classcode = "JSS 3D";
            }
            if (ts > 200 && ts <= 250 && level.equals("3")) {
                classcode = "JSS 3E";
            }
            if (ts > 250 && ts <= 300 && level.equals("3")) {
                classcode = "JSS 3F";
            }
            if (ts > 300 && ts <= 350 && level.equals("3")) {
                classcode = "JSS 3G";
            }
            if (ts > 350 && ts <= 400 && level.equals("3")) {
                classcode = "JSS 3H";
            }
            if (ts > 400 && ts <= 450 && level.equals("3")) {
                classcode = "JSS 3I";
            }
            if (ts > 450 && ts <= 500 && level.equals("3")) {
                classcode = "JSS 3J";
            }
            if (ts <= 50 && level.equals("4")) {
                classcode = "SSS 1A";
            }
            if (ts > 50 && ts <= 100 && level.equals("4")) {
                classcode = "SSS 1B";
            }
            if (ts > 100 && ts <= 150 && level.equals("4")) {
                classcode = "SSS 1C";
            }
            if (ts > 150 && ts <= 200 && level.equals("4")) {
                classcode = "SSS 1D";
            }
            if (ts > 200 && ts <= 250 && level.equals("4")) {
                classcode = "SSS 1E";
            }
            if (ts > 250 && ts <= 300) {
                classcode = "SSS 1F";
            }
            if (ts > 300 && ts <= 350 && level.equals("4")) {
                classcode = "SSS 1G";
            }
            if (ts > 350 && ts <= 400 && level.equals("4")) {
                classcode = "SSS 1H";
            }
            if (ts > 400 && ts <= 450 && level.equals("4")) {
                classcode = "SSS 1I";
            }
            if (ts > 450 && ts <= 500 && level.equals("4")) {
                classcode = "SSS 1J";
            }
        } catch (Exception e) {
        }
        return classcode;
    }

    public int countbySubjectAndClasscode(String subjects, String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM resultsheet where subjects='" + subjects + "' AND classcode='" + classcode + "' AND status='position'";
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

    public int countClasscode(String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM classresult where classcode='" + classcode + "' AND classstatus='position'";
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

    public int countClasscode1(String classcode, String acasession, String term) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM classreportbank where classcode='" + classcode + "' AND acasession='" + acasession + "' AND term='" + term + "' AND classstatus='position'";
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
    
    public int countClasscode2(String classcode, String examsession) {
        int acct = 0;
        String sql = "SELECT count(regno) from annualbank where classcode='" + classcode + "'AND acasession='" + examsession + "' AND classstatus='position'";
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

    public int countClassreport() {
        int acct = 0;
        String sql = "SELECT count(regno) FROM classreport where  classstatus='position'";
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

    public int countClasscode22(String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM midtermreport where classcode='" + classcode + "' AND classstatus='position'";
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

    public int countForLoop(String subjects, String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM resultsheet where subjects='" + subjects + "' AND classcode='" + classcode + "'";
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

    public int countForLoops(String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM classresult where classcode='" + classcode + "' AND classstatus='noposition'";
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

   public int countForLoops1(String classcode, String acasession, String term) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM classreportbank where classcode='" + classcode + "' AND acasession='" + acasession + "' AND term='" + term + "' AND classstatus='noposition'";
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
    
    public int countForLoops2(String classcode, String examsession) {
        int acct = 0;
        String sql = "SELECT count(regno) from annualbank where classcode='" + classcode + "'AND acasession='" + examsession + "'";
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

    public int countForLoops4() {
        int acct = 0;
        String sql = "SELECT count(regno) FROM classreport where overallstatus='noposition'";
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

    public int countForLoops33(String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM midtermreport where classcode='" + classcode + "' AND overallclassstatus='noposition'";
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

    public void setPosition(String classcode, String subjects) {

        String sql = "SELECT MAX(total) from resultsheet where classcode='" + classcode + "' AND subjects='" + subjects + "' AND status='noposition'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                double total = rs.getDouble(1);
                System.out.println(total);
                int position = countbySubjectAndClasscode(subjects, classcode);
                String sq = "UPDATE resultsheet set position=?,status=? where classcode=? AND Subjects=? AND total=?";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setInt(1, position);
                ps.setString(2, "position");
                ps.setString(3, classcode);
                ps.setString(4, subjects);
                ps.setDouble(5, total);
                int rows = ps.executeUpdate();
                if (rows >= 1) {
                    System.out.println("successfully updated");
                }
            }
        } catch (Exception e) {

            System.out.println("error computing due to" + " " + e.getMessage());
        }

    }

    public String getPosition1(int position) {
        String pst = "";

        int a = position;
        int b = 10;
        int ab = a % b;
        if (a > 13) {

//System.out.println(ab);
            if (ab == 2) {
                pst = a + "nd";
//System.out.println(pst);
            } else {
                if (ab == 1) {
                    pst = a + "st";
//System.out.println(pst);
                } else {
                    if (ab == 3) {
                        pst = a + "rd";
//System.out.println(pst);
                    } else {
                        if (a == 11 || a == 12 || a == 13) {
                            pst = a + "th";
//System.out.println(pst);
                        }
                    }
                }
            }
        } else {
            if (a > 3 && a <= 11) {
                pst = a + "th";

            } else {
                if (a == 1) {
                    pst = a + "st";

                } else {
                    if (a == 2) {
                        pst = a + "nd";

                    } else {
                        if (a == 3) {
                            pst = a + "rd";
//System.out.println(pst);
                        }
                    }
                }
            }
        }
        return pst;
    }

    public String getPosition(int position) {
        String post = "";
        int pos = position;
        if (pos == 1) {
            post = "1st";
        } else {
            if (pos == 2) {
                post = "2nd";
            } else {
                if (pos == 3) {
                    post = "3rd";
                } else {
                    if (pos == 21) {
                        post = "21st";
                    } else {
                        if (pos == 22) {
                            post = "22nd";
                        } else {
                            if (pos == 23) {
                                post = "23rd";
                            } else {

                                if (pos == 31) {
                                    post = "31st";
                                } else {
                                    if (pos == 32) {
                                        post = "32nd";
                                    } else {
                                        if (pos == 33) {
                                            post = "33rd";
                                        } else {
                                            if (pos == 41) {
                                                post = "41st";
                                            } else {
                                                if (pos == 42) {
                                                    post = "42nd";
                                                } else {
                                                    if (pos == 43) {
                                                        post = "43rd";
                                                    } else {
                                                        if (pos == 51) {
                                                            post = "51st";
                                                        } else {
                                                            if (pos == 52) {
                                                                post = "52nd";
                                                            } else {
                                                                if (pos == 53) {
                                                                    post = "53rd";
                                                                } else {
                                                                    if (pos == 61) {
                                                                        post = "61st";
                                                                    } else {
                                                                        if (pos == 62) {
                                                                            post = "62nd";
                                                                        } else {
                                                                            if (pos == 63) {
                                                                                post = "63rd";
                                                                            } else {
                                                                                if (pos == 71) {
                                                                                    post = "71st";
                                                                                } else {
                                                                                    if (pos == 72) {
                                                                                        post = "72nd";
                                                                                    } else {
                                                                                        if (pos == 73) {
                                                                                            post = "73rd";
                                                                                        } else {

                                                                                            if (pos == 81) {
                                                                                                post = "81st";
                                                                                            } else {
                                                                                                if (pos == 82) {
                                                                                                    post = "82nd";
                                                                                                } else {
                                                                                                    if (pos == 83) {
                                                                                                        post = "83rd";
                                                                                                    } else {
                                                                                                        if (pos == 91) {
                                                                                                            post = "91st";
                                                                                                        } else {
                                                                                                            if (pos == 92) {
                                                                                                                post = "92nd";
                                                                                                            } else {
                                                                                                                if (pos == 93) {
                                                                                                                    post = "93rd";
                                                                                                                } else {
                                                                                                                    if (pos == 101) {
                                                                                                                        post = "101st";
                                                                                                                    } else {
                                                                                                                        if (pos == 102) {
                                                                                                                            post = "102nd";
                                                                                                                        } else {
                                                                                                                            if (pos == 103) {
                                                                                                                                post = "103rd";
                                                                                                                            } else {
                                                                                                                                if (pos == 121) {
                                                                                                                                    post = "121st";
                                                                                                                                } else {
                                                                                                                                    if (pos == 121) {
                                                                                                                                        post = "121st";
                                                                                                                                    } else {
                                                                                                                                        if (pos == 122) {
                                                                                                                                            post = "122nd";
                                                                                                                                        } else {
                                                                                                                                            if (pos == 123) {
                                                                                                                                                post = "123rd";
                                                                                                                                            } else {
                                                                                                                                                if (pos == 131) {
                                                                                                                                                    post = "131st";
                                                                                                                                                } else {
                                                                                                                                                    if (pos == 132) {
                                                                                                                                                        post = "132nd";
                                                                                                                                                    } else {
                                                                                                                                                        if (pos == 133) {
                                                                                                                                                            post = "133rd";
                                                                                                                                                        } else {
                                                                                                                                                            if (pos == 141) {
                                                                                                                                                                post = "141st";
                                                                                                                                                            } else {
                                                                                                                                                                if (pos == 142) {
                                                                                                                                                                    post = "142nd";
                                                                                                                                                                } else {

                                                                                                                                                                    if (pos == 143) {
                                                                                                                                                                        post = "143rd";
                                                                                                                                                                    } else {
                                                                                                                                                                        if (pos == 151) {
                                                                                                                                                                            post = "151st";
                                                                                                                                                                        } else {
                                                                                                                                                                            if (pos == 152) {
                                                                                                                                                                                post = "152nd";
                                                                                                                                                                            } else {
                                                                                                                                                                                if (pos == 153) {
                                                                                                                                                                                    post = "153rd";
                                                                                                                                                                                } else {
                                                                                                                                                                                    if (pos == 161) {
                                                                                                                                                                                        post = "161st";
                                                                                                                                                                                    } else {
                                                                                                                                                                                        if (pos == 162) {
                                                                                                                                                                                            post = "162nd";
                                                                                                                                                                                        } else {
                                                                                                                                                                                            if (pos == 163) {
                                                                                                                                                                                                post = "163rd";
                                                                                                                                                                                            } else {
                                                                                                                                                                                                if (pos == 171) {
                                                                                                                                                                                                    post = "171st";
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    if (pos == 172) {
                                                                                                                                                                                                        post = "172nd";
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        if (pos == 173) {
                                                                                                                                                                                                            post = "173rd";
                                                                                                                                                                                                        } else {
                                                                                                                                                                                                            if (pos == 181) {
                                                                                                                                                                                                                post = "181st";
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                if (pos == 182) {
                                                                                                                                                                                                                    post = "182nd";
                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                    if (pos == 183) {
                                                                                                                                                                                                                        post = "183rd";
                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                        if (pos == 191) {
                                                                                                                                                                                                                            post = "191st";
                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                            if (pos == 192) {
                                                                                                                                                                                                                                post = "192nd";
                                                                                                                                                                                                                            } else {

                                                                                                                                                                                                                                if (pos == 193) {
                                                                                                                                                                                                                                    post = "193rd";
                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                    if (pos == 201) {
                                                                                                                                                                                                                                        post = "201st";
                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                        if (pos == 202) {
                                                                                                                                                                                                                                            post = "202nd";
                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                            if (pos == 203) {
                                                                                                                                                                                                                                                post = "203rd";
                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                if (pos == 221) {
                                                                                                                                                                                                                                                    post = "221st";
                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                    if (pos == 222) {
                                                                                                                                                                                                                                                        post = "222nd";
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        if (pos == 223) {
                                                                                                                                                                                                                                                            post = "223rd";
                                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                                            if (pos == 231) {
                                                                                                                                                                                                                                                                post = "231st";
                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                if (pos == 232) {
                                                                                                                                                                                                                                                                    post = "232nd";
                                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                                    if (pos == 233) {
                                                                                                                                                                                                                                                                        post = "233rd";
                                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                                        if (pos == 241) {
                                                                                                                                                                                                                                                                            post = "241st";
                                                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                                                            if (pos == 242) {
                                                                                                                                                                                                                                                                                post = "242nd";
                                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                                if (pos == 243) {
                                                                                                                                                                                                                                                                                    post = "243rd";
                                                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                                                    post = pos + "th";
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return post;
    }
//     public double getTotal() {
//        double total = 0.0;
//
//        return total;
//    }

    public void ComputeClassExam(String classcode, String term, String acasession, int no) {
        String sql = "SELECT * FROM studentsinfo where classcode='" + classcode + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("fname") + " " + rs.getString("mname");
                String regno = rs.getString("regno");
                double total = sumTotal(regno);
                DecimalFormat OneDF = new DecimalFormat("#.0");
                double average = total / no;
                String av = OneDF.format(average);
                double avg = Double.parseDouble(av);
                String remark = remark(average);
                String level = rs.getString("level");
                String sq = "INSERT INTO classresult(regno, name, total, average,  remark, classcode,term,acasession, level, classstatus, levelstatus, juniorstatus, seniorstatus, overallstatus) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, regno);
                ps.setString(2, name);
                ps.setDouble(3, total);
                ps.setDouble(4, avg);
                ps.setString(5, remark);
                ps.setString(6, classcode);
                ps.setString(7, term);
                ps.setString(8, acasession);
                ps.setString(9, level);
                ps.setString(10, "noposition");
                ps.setString(11, "noposition");
                ps.setString(12, "noposition");
                ps.setString(13, "noposition");
                ps.setString(14, "noposition");
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

    public int sumTotal(String regno) {
        int acct = 0;
        String sql = "SELECT SUM(total) FROM resultsheet where regno='" + regno + "'";
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

    public int sumTotal1(String regno, String examsession, String term) {
        int acct = 0;
        String sql = "SELECT SUM(total) FROM computeresult where regno='" + regno + "' AND examsession='" + examsession + "'AND term='" + term + "'";
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

    public double sumAvg(String regno) {
        double acct = 0.0;
        String sql = "SELECT SUM(avg) FROM annualresult where regno='" + regno + "'";
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

    public int sumTotal2(String regno) {
        int acct = 0;
        String sql = "SELECT SUM(midpercent) FROM computeresult where regno='" + regno + "'";
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

    public String remark(double total) {
        String remark = null;
        try {
            if (total < 40.0) {
                remark = "POOR";

            }
            if (total >= 40.0 && total < 50.0) {
                remark = "FAIR";

            }
            if (total >= 50.0 && total < 60.0) {
                remark = "GOOD";

            }
            if (total >= 60.0 && total < 70.0) {
                remark = "VERY GOOD";

            }
            if (total >= 70.0) {
                remark = "EXCELLENT";

            }
        } catch (Exception e) {
        }
        return remark;
    }

    public int countbyRegno1(String regno) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM computeresult where regno='" + regno + "'";
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

    public String getSubjects1(String level, String regno, String classcode, String name, String dob, String term, String examsession) {
        String acct = null;
        String sql = "SELECT * FROM subjects where level='" + level + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getString("subjectname");
                int subjectnumber = rs.getInt("subjectnumber");
                //computecode, regno, name, subjects, firsttest, secondtest, thirdtest, exam, total, grade, position, remark, classname, classcode, term, examsession
                String scorecode = regno + "" + acct;
                String sq = "INSERT INTO computeresult(computecode, regno,name, subjects,level, classcode,term,examsession,dob,midstatus,status,subjectnumber) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, scorecode);
                ps.setString(2, regno);
                ps.setString(3, name);
                ps.setString(4, acct);
                ps.setString(5, level);
                ps.setString(6, classcode);
                ps.setString(7, term);
                ps.setString(8, examsession);
                ps.setString(9, dob);
                ps.setString(10, "noposition");
                ps.setString(11, "noposition");
                ps.setInt(12, subjectnumber);
                int rows = ps.executeUpdate();
                if (rows >= 1) {
                    System.out.println("successfully updated");
                }
            }
        } catch (Exception e) {
            acct = null;
            System.out.println("error computing due to" + " " + e.getMessage());
        }
        return acct;
    }

    public int countForLoop1(String subjects, String classcode, String examsession, String term) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM computeresult where subjects='" + subjects + "' AND classcode='" + classcode + "'AND examsession='" + examsession + "'AND term='" + term + "'";
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

    public int countAnnualForLoop1(String acasession, String classcode, String subjects) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM annualresult where acasession='" + acasession + "' AND classcode='" + classcode + "' AND subject='" + subjects + "'";
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

    public int countbySubjectAndClasscode1(String subjects, String classcode, String examsession, String term) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM computeresult where subjects='" + subjects + "' AND classcode='" + classcode + "' AND examsession='" + examsession + "' AND term='" + term + "' AND status='position'";
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

    public int countbySubjectAndClasscode3(String acasession, String classcode, String subjects) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM annualresult where acasession='" + acasession + "' AND classcode='" + classcode + "' AND subject='" + subjects + "' AND status='position'";
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

    public int countbySubjectAndClasscode2(String subjects, String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM computeresult where subjects='" + subjects + "' AND classcode='" + classcode + "' AND midstatus='position'";
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

    public double selectAvg(String subjects, String classcode, String examsession, String term) {
        double acct = 0;
        String sql = "SELECT AVG(total) FROM computeresult where subjects='" + subjects + "'AND classcode='" + classcode + "'AND examsession='" + examsession + "'AND term='" + term + "'";
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

    public double selectAnnualAvg(String acasession, String classcode, String subjects) {
        double acct = 0;
        String sql = "SELECT AVG(total) FROM annualresult where acasession='" + acasession + "' AND classcode='" + classcode + "' AND subject='" + subjects + "'";
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

    public double selectAvg1(String subjects, String classcode) {
        double acct = 0;
        String sql = "SELECT AVG(midpercent) FROM computeresult where subjects='" + subjects + "'AND classcode='" + classcode + "'";
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

    public int selectHigest(String subjects, String classcode, String examsession, String term) {
        int acct = 0;
        String sql = "SELECT MAX(total) FROM computeresult where subjects='" + subjects + "'AND classcode='" + classcode + "'AND examsession='" + examsession + "'AND term='" + term + "'";
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

    public double selectAnualHigest(String acasession, String classcode, String subjects) {
        double acct = 0;
        String sql = "SELECT MAX(total) FROM annualresult where acasession='" + acasession + "' AND classcode='" + classcode + "' AND subject='" + subjects + "'";
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

    public int selectHigest1(String subjects, String classcode) {
        int acct = 0;
        String sql = "SELECT MAX(midpercent) FROM computeresult where subjects='" + subjects + "'AND classcode='" + classcode + "'";
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

    public int selectLowest(String subjects, String classcode, String examsession, String term) {
        int acct = 0;
        String sql = "SELECT MIN(total) FROM computeresult where subjects='" + subjects + "'AND classcode='" + classcode + "'AND examsession='" + examsession + "'AND term='" + term + "'";
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

    public double selectAnnualLowest(String acasession, String classcode, String subjects) {
        double acct = 0;
        String sql = "SELECT MIN(total) FROM annualresult where acasession='" + acasession + "' AND classcode='" + classcode + "' AND subject='" + subjects + "'";
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

    public int selectLowest1(String subjects, String classcode) {
        int acct = 0;
        String sql = "SELECT MIN(midpercent) FROM computeresult where subjects='" + subjects + "'AND classcode='" + classcode + "'";
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
    
    

    public void ComputeMidTermClassReport(String classcode, String term, String acasession, int no) {
        String sql = "SELECT * FROM studentsinfo where classcode='" + classcode + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("fname") + " " + rs.getString("mname");
                String regno = rs.getString("regno");
                double total = sumTotal2(regno);
                DecimalFormat OneDF = new DecimalFormat("#.0");
                double average = total / no;
                int expectedtotal = 40 * no;
                String av = OneDF.format(average);
                double avg = Double.parseDouble(av);
                String remark = remark(average);
                String level = rs.getString("level");
                String sq = "INSERT INTO midtermreport(regno, name, total, average,  remark, classcode,term,acasession, level, classstatus, levelstatus, juniorstatus, seniorstatus, overallstatus,expectedtotal) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, regno);
                ps.setString(2, name);
                ps.setDouble(3, total);
                ps.setDouble(4, avg);
                ps.setString(5, remark);
                ps.setString(6, classcode);
                ps.setString(7, term);
                ps.setString(8, acasession);
                ps.setString(9, level);
                ps.setString(10, "noposition");
                ps.setString(11, "noposition");
                ps.setString(12, "noposition");
                ps.setString(13, "noposition");
                ps.setString(14, "noposition");
                ps.setInt(15, expectedtotal);
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

    public int noOfStudents(String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM classreport where classcode='" + classcode + "' AND total>0";
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
    
    public int classStudents(String acasession, String term, String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM classreportbank where acasession='" + acasession + "' AND term='"+term+ "' AND classcode='"+classcode+ "' AND finaltotal>0";
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

    public int noOfStudents2(String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM classresult where classcode='" + classcode + "'";
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

    public int classEnrollment(String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM studentsinfo where classcode='" + classcode + "'";
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
    
    public int classEnrollments(String acasession, String term, String classcode) {
        int acct = 0;
         String sql = "SELECT count(regno) FROM classreportbank where acasession='" + acasession + "' AND term='"+term+ "' AND classcode='"+classcode+ "'";
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
    
    public int AnualclassEnrollments(String acasession, String classcode) {
        int acct = 0;
         String sql = "SELECT count(regno) FROM annualbank where acasession='" + acasession + "' AND classcode='"+classcode+ "'";
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

    public int noSatforExams(String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM classreport where classcode='" + classcode + "' AND total>0";
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

    public int noPassed(String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM classreport where classcode='" + classcode + "'AND average>39";
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

    public int noFailed(String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM classreport where classcode='" + classcode + "'AND average<40";
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

    public int noOfStudents1(String classcode) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM midtermreport where classcode='" + classcode + "'";
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
    
    @Inject
    private MastersheetFacade mf;

    public String masterList(String regno, int total, String subject) {
        String action = "";
        if (subject.equals("BST")) {
            mf.updateSub1(regno, total);
            action = "success";
        }
        if (subject.equals("Business Studies")) {
            mf.updateSub2(regno, total);
            action = "success";
        }
        if (subject.equals("Catholic Doctrine")) {
            mf.updateSub3(regno, total);
            action = "success";
        }
        if (subject.equals("English Studies")) {
            mf.updateSub4(regno, total);
            action = "success";
        }
        if (subject.equals("Mathematics")) {
            mf.updateSub5(regno, total);
            action = "success";
        }
        if (subject.equals("PVS")) {
            mf.updateSub6(regno, total);
            action = "success";
        }
        if (subject.equals("RNV")) {
            mf.updateSub7(regno, total);
            action = "success";
        }
        return action;
    }

    public String PrimarymasterList(String regno, int total, int subno) {
        String action = "";
        if (subno == 1) {
            mf.updateSub1(regno, total);
            action = "success";
        }
        if (subno == 2) {
            mf.updateSub2(regno, total);
            action = "success";
        }
        if (subno == 3) {
            mf.updateSub3(regno, total);
            action = "success";
        }
        if (subno == 4) {
            mf.updateSub4(regno, total);
            action = "success";
        }
        if (subno == 5) {
            mf.updateSub5(regno, total);
            action = "success";
        }
        if (subno == 6) {
            mf.updateSub6(regno, total);
            action = "success";
        }
        if (subno == 7) {
            mf.updateSub7(regno, total);
            action = "success";
        }
        if (subno == 8) {
            mf.updateSub8(regno, total);
            action = "success";
        }
        if (subno == 9) {
            mf.updateSub9(regno, total);
            action = "success";
        }
        if (subno == 10) {
            mf.updateSub10(regno, total);
            action = "success";
        }
        if (subno == 11) {
            mf.updateSub11(regno, total);
            action = "success";
        }
        if (subno == 12) {
            mf.updateSub12(regno, total);
            action = "success";
        }
        if (subno == 13) {
            mf.updateSub13(regno, total);
            action = "success";
        }
        if (subno == 14) {
            mf.updateSub14(regno, total);
            action = "success";
        }
        if (subno == 15) {
            mf.updateSub15(regno, total);
            action = "success";
        }
        return action;
    }

    public int checkSubjects(String subjects, String classcode) {
        int acct = 0;
        String sql = "SELECT SUM(total) FROM computeresult where subjects='" + subjects + "' AND classcode='" + classcode + "'";
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

    public int checkRegno(String regno) {
        int acct = 0;
        String sql = "SELECT SUM(total) FROM computeresult where regno='" + regno + "'";
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

    public int sumAnnualTotal(int firstterm, int secondterm, int thirdterm) {
        int total = 0;
        if (firstterm > 0 && secondterm > 0 && thirdterm > 0) {
            total = firstterm + secondterm + thirdterm;
        } else {
            if (firstterm == 0 && secondterm > 0 && thirdterm > 0) {
                total = secondterm + thirdterm;
            } else {
                if (firstterm == 0 && secondterm == 0 && thirdterm > 0) {
                    total = thirdterm;
                } else {
                    if (firstterm > 0 && secondterm == 0 && thirdterm > 0) {
                        total = firstterm + thirdterm;
                    } else {
                        if (firstterm > 0 && secondterm > 0 && thirdterm == 0) {
                            total = firstterm + secondterm;
                        } else {
                            if (firstterm > 0 && secondterm == 0 && thirdterm == 0) {
                                total = firstterm;
                            } else {
                                if (firstterm == 0 && secondterm > 0 && thirdterm == 0) {
                                    total = secondterm;
                                }
                            }
                        }
                    }
                }

            }
        }
        return total;
    }

    public double avgTotal(int firstterm, int secondterm, int thirdterm) {
        DecimalFormat OneDF = new DecimalFormat("#.0");
        double total;
        double avg = 0.0;
        if (firstterm > 0 && secondterm > 0 && thirdterm > 0) {
            total = firstterm + secondterm + thirdterm;
            avg = total / 3;
            String av = OneDF.format(avg);
            avg = Double.parseDouble(av);
        } else {
            if (firstterm == 0 && secondterm > 0 && thirdterm > 0) {
                total = secondterm + thirdterm;
                avg = total / 2;
                String av = OneDF.format(avg);
                avg = Double.parseDouble(av);
            } else {
                if (firstterm == 0 && secondterm == 0 && thirdterm > 0) {
                    total = thirdterm;
                    avg = total;
                    String av = OneDF.format(avg);
                    avg = Double.parseDouble(av);
                } else {
                    if (firstterm > 0 && secondterm == 0 && thirdterm > 0) {
                        total = firstterm + thirdterm;
                        avg = total / 2;
                        String av = OneDF.format(avg);
                        avg = Double.parseDouble(av);
                    } else {
                        if (firstterm > 0 && secondterm > 0 && thirdterm == 0) {
                            total = firstterm + secondterm;
                            avg = total / 2;
                            String av = OneDF.format(avg);
                            avg = Double.parseDouble(av);
                        } else {
                            if (firstterm == 0 && secondterm > 0 && thirdterm == 0) {
                                total = secondterm;
                                avg = total;
                                String av = OneDF.format(avg);
                                avg = Double.parseDouble(av);
                            } else {
                                if (firstterm > 0 && secondterm == 0 && thirdterm == 0) {
                                    total = firstterm;
                                    avg = total;
                                    String av = OneDF.format(avg);
                                    avg = Double.parseDouble(av);
                                }
                            }
                        }
                    }
                }

            }
        }
        return avg;
    }

    public void ComputeAnnualReport(String classcode, String acasession, int no) {
        String sql = "SELECT * FROM studentsinfo where classcode='" + classcode + "' ";
        Statement st = this.connect();
        //regno, name, total, average, classposition, remark, classcode, term, acasession, levelposition, level, juniorposition, seniorposition, overallposition, classstatus, levelstatus, juniorstatus, seniorstatus, overallstatus     
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("fname") + " " + rs.getString("mname");
                String regno = rs.getString("regno");
                double total = sumAvg(regno);
                DecimalFormat OneDF = new DecimalFormat("#.0");
                double average = total / no;
                String av = OneDF.format(average);
                double avg = Double.parseDouble(av);
                String remark = remark(average);
                String level = rs.getString("level");
                String sq = "INSERT INTO classresult(regno, name, total, average,  remark, classcode,term,acasession, level, classstatus, levelstatus, juniorstatus, seniorstatus, overallstatus) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, regno);
                ps.setString(2, name);
                ps.setDouble(3, total);
                ps.setDouble(4, avg);
                ps.setString(5, remark);
                ps.setString(6, classcode);
                ps.setString(7, "");
                ps.setString(8, acasession);
                ps.setString(9, level);
                ps.setString(10, "noposition");
                ps.setString(11, "noposition");
                ps.setString(12, "noposition");
                ps.setString(13, "noposition");
                ps.setString(14, "noposition");
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

    public String getClassAttendance(String classcode, String acasession, String term) {
        String sql = "SELECT * FROM studentsinfo where classcode='" + classcode + "' AND status='computed'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //atcode, regno, name, term, acasession, classcode, level, noattended, noabsent, desiredattendance, status
                String name = rs.getString("fname") + "  " + rs.getString("mname");
                String regno = rs.getString("regno");
                String level = rs.getString("level");
                String atcode = regno + "" + acasession + "" + term;
                String sq = "INSERT INTO attendance(atcode, regno, name, term, acasession, classcode, level) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, atcode);
                ps.setString(2, regno);
                ps.setString(3, name);
                ps.setString(4, term);
                ps.setString(5, acasession);
                ps.setString(6, classcode);
                ps.setString(7, level);

                int rows = ps.executeUpdate();
                if (rows >= 1) {

                }
            }
        } catch (Exception e) {

            System.out.println("error computing due to" + " " + e.getMessage());
        }
        return "";
    }

    public int getDaysPresent(String regno) {
        int acct = 0;
        String sql = "SELECT * FROM Attendance where  regno='" + regno + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt("presence");

            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }

    public int getMaxAttendance(String regno) {
        int acct = 0;
        String sql = "SELECT * FROM Attendance where  regno='" + regno + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt("max");

            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }

    public int getDaysAbsent(String regno) {
        int acct = 0;
        String sql = "SELECT * FROM Attendance where  regno='" + regno + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt("absence");

            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }

    public String getClasspSYCHOMOTOR(String classcode, String acasession, String term) {
        String sql = "SELECT * FROM studentsinfo where classcode='" + classcode + "' AND status='computed'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                //atcode, regno, name, term, acasession, classcode, level, noattended, noabsent, desiredattendance, status
                String name = rs.getString("fname") + "  " + rs.getString("mname");
                String regno = rs.getString("regno");

                String atcode = regno + "" + acasession + "" + term;
                String sq = "INSERT INTO psychomotor(code, regno, name, term, acasession, classcode) VALUES(?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, atcode);
                ps.setString(2, regno);
                ps.setString(3, name);
                ps.setString(4, term);
                ps.setString(5, acasession);
                ps.setString(6, classcode);

                int rows = ps.executeUpdate();
                if (rows >= 1) {

                }
            }
        } catch (Exception e) {

            System.out.println("error computing due to" + " " + e.getMessage());
        }
        return "";
    }

    
    public int countAttendanceBank(String classcode,String acasession,String term) {
        int acct = 0;
        String sql = "SELECT count(regno) FROM attendancebank where classcode='" + classcode + "' AND acasession='"+acasession+"' AND term='"+term+"'";
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
    
     public String getAnnualPosition(int position) {
        String post = "";
        int pos = position;
        if (pos == 1) {
            post = "1st";
        } else {
            if (pos == 2) {
                post = "2nd";
            } else {
                if (pos == 3) {
                    post = "3rd";
                } else {
                    if (pos == 21) {
                        post = "21st";
                    } else {
                        if (pos == 22) {
                            post = "22nd";
                        } else {
                            if (pos == 23) {
                                post = "23rd";
                            } else {

                                if (pos == 31) {
                                    post = "31st";
                                } else {
                                    if (pos == 32) {
                                        post = "32nd";
                                    } else {
                                        if (pos == 33) {
                                            post = "33rd";
                                        } else {
                                            if (pos == 41) {
                                                post = "41st";
                                            } else {
                                                if (pos == 42) {
                                                    post = "42nd";
                                                } else {
                                                    if (pos == 43) {
                                                        post = "43rd";
                                                    } else {
                                                        if (pos == 51) {
                                                            post = "51st";
                                                        } else {
                                                            if (pos == 52) {
                                                                post = "52nd";
                                                            } else {
                                                                if (pos == 53) {
                                                                    post = "53rd";
                                                                } else {
                                                                    if (pos == 61) {
                                                                        post = "61st";
                                                                    } else {
                                                                        if (pos == 62) {
                                                                            post = "62nd";
                                                                        } else {
                                                                            if (pos == 63) {
                                                                                post = "63rd";
                                                                            } else {
                                                                                if (pos == 71) {
                                                                                    post = "71st";
                                                                                } else {
                                                                                    if (pos == 72) {
                                                                                        post = "72nd";
                                                                                    } else {
                                                                                        if (pos == 73) {
                                                                                            post = "73rd";
                                                                                        } else {

                                                                                            if (pos == 81) {
                                                                                                post = "81st";
                                                                                            } else {
                                                                                                if (pos == 82) {
                                                                                                    post = "82nd";
                                                                                                } else {
                                                                                                    if (pos == 83) {
                                                                                                        post = "83rd";
                                                                                                    } else {
                                                                                                        if (pos == 91) {
                                                                                                            post = "91st";
                                                                                                        } else {
                                                                                                            if (pos == 92) {
                                                                                                                post = "92nd";
                                                                                                            } else {
                                                                                                                if (pos == 93) {
                                                                                                                    post = "93rd";
                                                                                                                } else {
                                                                                                                    if (pos == 101) {
                                                                                                                        post = "101st";
                                                                                                                    } else {
                                                                                                                        if (pos == 102) {
                                                                                                                            post = "102nd";
                                                                                                                        } else {
                                                                                                                            if (pos == 103) {
                                                                                                                                post = "103rd";
                                                                                                                            } else {
                                                                                                                                if (pos == 121) {
                                                                                                                                    post = "121st";
                                                                                                                                } else {
                                                                                                                                    if (pos == 121) {
                                                                                                                                        post = "121st";
                                                                                                                                    } else {
                                                                                                                                        if (pos == 122) {
                                                                                                                                            post = "122nd";
                                                                                                                                        } else {
                                                                                                                                            if (pos == 123) {
                                                                                                                                                post = "123rd";
                                                                                                                                            } else {
                                                                                                                                                if (pos == 131) {
                                                                                                                                                    post = "131st";
                                                                                                                                                } else {
                                                                                                                                                    if (pos == 132) {
                                                                                                                                                        post = "132nd";
                                                                                                                                                    } else {
                                                                                                                                                        if (pos == 133) {
                                                                                                                                                            post = "133rd";
                                                                                                                                                        } else {
                                                                                                                                                            if (pos == 141) {
                                                                                                                                                                post = "141st";
                                                                                                                                                            } else {
                                                                                                                                                                if (pos == 142) {
                                                                                                                                                                    post = "142nd";
                                                                                                                                                                } else {

                                                                                                                                                                    if (pos == 143) {
                                                                                                                                                                        post = "143rd";
                                                                                                                                                                    } else {
                                                                                                                                                                        if (pos == 151) {
                                                                                                                                                                            post = "151st";
                                                                                                                                                                        } else {
                                                                                                                                                                            if (pos == 152) {
                                                                                                                                                                                post = "152nd";
                                                                                                                                                                            } else {
                                                                                                                                                                                if (pos == 153) {
                                                                                                                                                                                    post = "153rd";
                                                                                                                                                                                } else {
                                                                                                                                                                                    if (pos == 161) {
                                                                                                                                                                                        post = "161st";
                                                                                                                                                                                    } else {
                                                                                                                                                                                        if (pos == 162) {
                                                                                                                                                                                            post = "162nd";
                                                                                                                                                                                        } else {
                                                                                                                                                                                            if (pos == 163) {
                                                                                                                                                                                                post = "163rd";
                                                                                                                                                                                            } else {
                                                                                                                                                                                                if (pos == 171) {
                                                                                                                                                                                                    post = "171st";
                                                                                                                                                                                                } else {
                                                                                                                                                                                                    if (pos == 172) {
                                                                                                                                                                                                        post = "172nd";
                                                                                                                                                                                                    } else {
                                                                                                                                                                                                        if (pos == 173) {
                                                                                                                                                                                                            post = "173rd";
                                                                                                                                                                                                        } else {
                                                                                                                                                                                                            if (pos == 181) {
                                                                                                                                                                                                                post = "181st";
                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                if (pos == 182) {
                                                                                                                                                                                                                    post = "182nd";
                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                    if (pos == 183) {
                                                                                                                                                                                                                        post = "183rd";
                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                        if (pos == 191) {
                                                                                                                                                                                                                            post = "191st";
                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                            if (pos == 192) {
                                                                                                                                                                                                                                post = "192nd";
                                                                                                                                                                                                                            } else {

                                                                                                                                                                                                                                if (pos == 193) {
                                                                                                                                                                                                                                    post = "193rd";
                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                    if (pos == 201) {
                                                                                                                                                                                                                                        post = "201st";
                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                        if (pos == 202) {
                                                                                                                                                                                                                                            post = "202nd";
                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                            if (pos == 203) {
                                                                                                                                                                                                                                                post = "203rd";
                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                if (pos == 221) {
                                                                                                                                                                                                                                                    post = "221st";
                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                    if (pos == 222) {
                                                                                                                                                                                                                                                        post = "222nd";
                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                        if (pos == 223) {
                                                                                                                                                                                                                                                            post = "223rd";
                                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                                            if (pos == 231) {
                                                                                                                                                                                                                                                                post = "231st";
                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                if (pos == 232) {
                                                                                                                                                                                                                                                                    post = "232nd";
                                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                                    if (pos == 233) {
                                                                                                                                                                                                                                                                        post = "233rd";
                                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                                        if (pos == 241) {
                                                                                                                                                                                                                                                                            post = "241st";
                                                                                                                                                                                                                                                                        } else {
                                                                                                                                                                                                                                                                            if (pos == 242) {
                                                                                                                                                                                                                                                                                post = "242nd";
                                                                                                                                                                                                                                                                            } else {
                                                                                                                                                                                                                                                                                if (pos == 243) {
                                                                                                                                                                                                                                                                                    post = "243rd";
                                                                                                                                                                                                                                                                                } else {
                                                                                                                                                                                                                                                                                    post = pos + "th";
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return post;
    }
     
     public int getHistDaysPresent(String acasession, String term, String regno, String name) {
        int acct = 0;
        String sql = "SELECT * FROM attendancebank where  acasession='" + acasession + "' AND term='"+ term +"' AND regno='"+ regno +"' AND name='"+ name +"' ";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt("presence");

            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }

    public int getHistMaxAttendance(String acasession, String term, String regno) {
        int acct = 0;
        String sql = "SELECT * FROM attendancebank where  acasession='" + acasession + "' AND term='"+ term +"' AND regno='"+ regno +"' ";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt("max");

            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }

    public int getHistDaysAbsent(String acasession, String term, String regno) {
        int acct = 0;
        String sql = "SELECT * FROM attendancebank where  acasession='" + acasession + "' AND term='"+ term +"' AND regno='"+ regno +"' ";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                acct = rs.getInt("absence");

            }
        } catch (Exception e) {
            acct = 0;

        }
        return acct;
    }
    
    public int selectmax(String regno) {
        int acct = 0;
        String sql = "SELECT max FROM attendance where regno='" + regno + "'";
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
    
    public int selectpresence(String regno) {
        int acct = 0;
        String sql = "SELECT presence FROM attendance where regno='" + regno + "'";
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
    
    public int selectabsence(String regno) {
        int acct = 0;
        String sql = "SELECT absence FROM attendance where regno='" + regno + "'";
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
    
    
    public int selectalertness(String regno) {
        int acct = 0;
        String sql = "SELECT alertness FROM psychomotor where regno='" + regno + "'";
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
    
    public int selectpunctuation(String regno) {
        int acct = 0;
        String sql = "SELECT punctuation FROM psychomotor where regno='" + regno + "'";
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
    
    public int selectreliability(String regno) {
        int acct = 0;
        String sql = "SELECT reliability FROM psychomotor where regno='" + regno + "'";
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
    public int selectinitiativeness(String regno) {
        int acct = 0;
        String sql = "SELECT initiativeness FROM psychomotor where regno='" + regno + "'";
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
    public int selectleadership(String regno) {
        int acct = 0;
        String sql = "SELECT leadership FROM psychomotor where regno='" + regno + "'";
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
    public int selectcourtesy(String regno) {
        int acct = 0;
        String sql = "SELECT courtesy FROM psychomotor where regno='" + regno + "'";
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
    public int selectselfcontrol(String regno) {
        int acct = 0;
        String sql = "SELECT selfcontrol FROM psychomotor where regno='" + regno + "'";
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
    
    public int selectspiritservice(String regno) {
        int acct = 0;
        String sql = "SELECT spiritservice FROM psychomotor where regno='" + regno + "'";
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
    public int selectperseverance(String regno) {
        int acct = 0;
        String sql = "SELECT perseverance FROM psychomotor where regno='" + regno + "'";
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
    public int selectconsideration(String regno) {
        int acct = 0;
        String sql = "SELECT consideration FROM psychomotor where regno='" + regno + "'";
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
    
    public int selectteamspirit(String regno) {
        int acct = 0;
        String sql = "SELECT teamspirit FROM psychomotor where regno='" + regno + "'";
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
    public int selectfriendlyness(String regno) {
        int acct = 0;
        String sql = "SELECT friendlyness FROM psychomotor where regno='" + regno + "'";
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
    public int selecthandwritting(String regno) {
        int acct = 0;
        String sql = "SELECT handwritting FROM psychomotor where regno='" + regno + "'";
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
    public int selectfluency(String regno) {
        int acct = 0;
        String sql = "SELECT fluency FROM psychomotor where regno='" + regno + "'";
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
    public int selectgames(String regno) {
        int acct = 0;
        String sql = "SELECT games FROM psychomotor where regno='" + regno + "'";
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
    public int selectsports(String regno) {
        int acct = 0;
        String sql = "SELECT sports FROM psychomotor where regno='" + regno + "'";
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
    
    public int selectgymnastic(String regno) {
        int acct = 0;
        String sql = "SELECT gymnastic FROM psychomotor where regno='" + regno + "'";
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
    
    public int selecthandlingtools(String regno) {
        int acct = 0;
        String sql = "SELECT handlingtools FROM psychomotor where regno='" + regno + "'";
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
    
    public int selectdrawing(String regno) {
        int acct = 0;
        String sql = "SELECT drawing FROM psychomotor where regno='" + regno + "'";
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
    public String HM(String classcode) {       
        String sql = "SELECT seniorposition FROM classreportbank where classcode='" + classcode + "'";
        Statement st = this.connect();   
        return "";
    }
    public String formaster(String classcode) {        
        String sql = "SELECT overallposition FROM classreportbank where classcode='" + classcode + "'";
        Statement st = this.connect();
        return "";
    }
    
    public void ComputeClassReport(String classcode, String term, String examsession, int min_number, String nextermbegin, String nextermfees) {
        String sql = "SELECT * FROM studentsinfo where classcode='" + classcode + "'";
        Statement st = this.connect();
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String regno = rs.getString("regno");
                String name = rs.getString("fname") + " " + rs.getString("mname") + " " + rs.getString("lname");               
                double total = sumTotal1(regno, examsession, term);
                DecimalFormat TwoDF = new DecimalFormat("#.00");
                double average = total / min_number;
                String av = TwoDF.format(average);
                double avg = Double.parseDouble(av);
                String remark = remark(average);
                String level = rs.getString("level");
                String code=regno+""+examsession+""+term; 
                String sex = rs.getString("sex");
                String pictureurl = rs.getString("pictureurl");
                int totalscores = min_number*100;
                headteacher="tesem";
                Headteacher cur= HF.find(headteacher);
                headname = cur.getHeadname();
                Formaster curr = FFF.find(classcode);
                formname = curr.getFormname();               
                int max=selectmax(regno);
                int presence=selectpresence(regno);
                int absence=selectabsence(regno);
                int alertness=selectalertness(regno);
                int punctuation=selectpunctuation(regno);
                int reliability=selectreliability(regno);
                int initiativeness=selectinitiativeness(regno);
                int leadership=selectleadership(regno);
                int courtesy=selectcourtesy(regno);
                int selfcontrol=selectselfcontrol(regno);
                int spiritservice=selectspiritservice(regno);
                int perseverance=selectperseverance(regno);
                int consideration=selectconsideration(regno);
                int teamspirit=selectteamspirit(regno);
                int friendlyness=selectfriendlyness(regno);
                int handwritting=selecthandwritting(regno);
                int fluency=selectfluency(regno);
                int games=selectgames(regno);
                int sports=selectsports(regno);
                int gymnastic=selectgymnastic(regno);
                int handlingtools=selecthandlingtools(regno);
                int drawing=selectdrawing(regno);        
                String sq = "INSERT INTO classreportbank(regno, name, finaltotal, finalaverage, remark, classcode, term, acasession, level, seniorposition, overallposition, classstatus, levelstatus, juniorstatus, seniorstatus, overallstatus, code, sex, pictureurl, min_number, max, presence, absence, nextermbegin, nextermfees, alertness, punctuation, reliability, initiativeness, leadership, courtesy, selfcontrol, spiritservice, perseverance, consideration, teamspirit, friendlyness, handwritting, fluency, games, sports, gymnastic, handlingtools, drawing) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sq);
                ps.setString(1, regno);
                ps.setString(2, name);
                ps.setDouble(3, total);
                ps.setDouble(4, avg);
                ps.setString(5, remark);
                ps.setString(6, classcode);
                ps.setString(7, term);
                ps.setString(8, examsession);
                ps.setString(9, level);
                ps.setString(10, headname);
                ps.setString(11, formname);
                ps.setString(12, "noposition");
                ps.setString(13, "noposition");
                ps.setString(14, "noposition");
                ps.setString(15, "noposition");
                ps.setString(16, "noposition");
                ps.setString(17, code);
                ps.setString(18, sex);
                ps.setString(19, pictureurl);
                ps.setInt(20, totalscores);

                ps.setInt(21, max);
                ps.setInt(22, presence);
                ps.setInt(23, absence);
                ps.setString(24, nextermbegin);
                ps.setString(25, nextermfees);
                ps.setInt(26, alertness);
                ps.setInt(27, punctuation);
                ps.setInt(28, reliability);
                ps.setInt(29, initiativeness);
                ps.setInt(30, leadership);
                ps.setInt(31, courtesy);
                ps.setInt(32, selfcontrol);
                ps.setInt(33, spiritservice);
                ps.setInt(34, perseverance);
                ps.setInt(35, consideration);
                ps.setInt(36, teamspirit);
                ps.setInt(37, friendlyness);
                ps.setInt(38, handwritting);
                ps.setInt(39, fluency);
                ps.setInt(40, games);
                ps.setInt(41, sports);
                ps.setInt(42, gymnastic);
                ps.setInt(43, handlingtools);
                ps.setInt(44, drawing);
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
}
