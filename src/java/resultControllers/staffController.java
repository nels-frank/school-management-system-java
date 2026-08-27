
package resultControllers;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entities.Formaster;
import entities.Headteacher;
import sessionbeans.AttendanceFacade;
import sessionbeans.FormasterFacade;
import sessionbeans.HeadteacherFacade;

@ManagedBean
@SessionScoped
public class staffController implements Serializable{
    @EJB
    private HeadteacherFacade HF;   
    @EJB 
    private AttendanceFacade AF;
    @EJB
    private FormasterFacade FF;
    
    private String staffcode;
    private String session;
    private String term;
    private String headname;
    private String formastercode;
    private String level;
    private String classcode;
   private String attendancecode;
   private String regno;
   private int max, presence, absence;
   public List<Headteacher> allHeadteachers;
   public List<Formaster> allFormaster;
   private String msg;

    public List<Formaster> getAllFormaster() {
        return allFormaster=FF.findAll();
    }

    public void setAllFormaster(List<Formaster> allFormaster) {
        this.allFormaster = allFormaster;
    }

   
   
   
   
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
   public List<Headteacher> getAllHeadteachers() {
        return allHeadteachers=HF.findAll();
    }

    public void setAllHeadteachers(List<Headteacher> allHeadteachers) {
        this.allHeadteachers = allHeadteachers;
    }





    public String getStaffcode() {
        return staffcode;
    }

    public void setStaffcode(String staffcode) {
        this.staffcode = staffcode;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getHeadname() {
        return headname;
    }

    public void setHeadname(String headname) {
        this.headname = headname;
    }

    public String getFormastercode() {
        return formastercode;
    }

    public void setFormastercode(String formastercode) {
        this.formastercode = formastercode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getAttendancecode() {
        return attendancecode;
    }

    public void setAttendancecode(String attendancecode) {
        this.attendancecode = attendancecode;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getPresence() {
        return presence;
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public int getAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }
    public String editHM(Headteacher current) {
 //       SF.find(regno);subjectcode, subjectname, level, category
        if (current != null) {
            try {                      
                 staffcode = current.getStaffcode();
                 session = current.getSession();
                 term = current.getTerm();
                 headname = current.getHeadname();
            } catch (Exception e) {}
        }
        return "creatHeadteacher.jsf";
    }
    public String updateHM() {
        try {                        
          HF.udpdateHM(staffcode, session, term, headname);
            msg="Head Teacher Successfully Replaced";
        } catch (Exception e) {            
        }
        return "creatHeadteacher.jsf";
    }
    
    public void DeleteFormaster(String classcode){
        FF.removeCode(classcode);
}
    
}
