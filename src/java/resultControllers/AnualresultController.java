/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultControllers;

import com.SET07.dbconn.DBAction;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import entities.Annualresult;
import sessionbeans.AnnualresultFacade;

@ManagedBean
@SessionScoped
public class AnualresultController implements Serializable {
    @Inject
    private AnnualresultFacade AF;
    @Inject
    private DBAction db;
    private String classcode;
    private String examsession;
    private String term;
    private String subject;
    private int min_number;
    private List<Annualresult> classResult;
    private List<Annualresult> annualresults;

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getExamsession() {
        return examsession;
    }

    public void setExamsession(String examsession) {
        this.examsession = examsession;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMin_number() {
        return min_number;
    }

    public void setMin_number(int min_number) {
        this.min_number = min_number;
    }

    public List<Annualresult> getAnnualresults() {
        return annualresults=AF.findByAcademicSession(examsession, classcode, subject);
    }

    public void setAnnualresults(List<Annualresult> annualresults) {
        this.annualresults = annualresults;
    }
    
    public void annualResult() {
        try {
            db.ComputeAnnualReport(classcode, examsession, min_number);
        } catch (Exception e) {
        }
    }
}
