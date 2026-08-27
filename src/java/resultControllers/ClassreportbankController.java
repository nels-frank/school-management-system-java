
package resultControllers;

import com.SET07.dbconn.DBAction;
import com.SET07.dbconn.Resultbanck;
import connection.dbConnection;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import entities.Classreport;
import entities.Classreportbank;
import entities.Feespayment;
import sessionbeans.AnnualFacade;
import sessionbeans.AttendanceFacade;
import sessionbeans.ClassreportbankFacade;
import sessionbeans.ComputeresultFacade;
import sessionbeans.FormasterFacade;
import sessionbeans.HeadteacherFacade;
import sessionbeans.StudentsinfoFacade;

@ManagedBean
@SessionScoped
public class ClassreportbankController implements Serializable{
@EJB
private ClassreportbankFacade CR;
@EJB
private StudentsinfoFacade SF;
     @EJB
private dbConnection dc;
    @EJB
    private ComputeresultFacade CF;
    @EJB
    private AnnualFacade Annual;
    @EJB
    private FormasterFacade FFF; 
    @EJB
    private HeadteacherFacade HF; 
    @EJB
    private AttendanceFacade AF; 
 @Inject
    private Resultbanck sb;
 @Inject
     private  DBAction db ;  
    @EJB
private String regno, name, classposition, remark, classcode, term, acasession, levelposition, level, juniorposition, seniorposition, overallposition, classstatus, levelstatus, juniorstatus, seniorstatus, overallstatus, code, sex, pictureurl;
private int finaltotal;
private double finalaverage;

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassposition() {
        return classposition;
    }

    public void setClassposition(String classposition) {
        this.classposition = classposition;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getAcasession() {
        return acasession;
    }

    public void setAcasession(String acasession) {
        this.acasession = acasession;
    }

    public String getLevelposition() {
        return levelposition;
    }

    public void setLevelposition(String levelposition) {
        this.levelposition = levelposition;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getJuniorposition() {
        return juniorposition;
    }

    public void setJuniorposition(String juniorposition) {
        this.juniorposition = juniorposition;
    }

    public String getSeniorposition() {
        return seniorposition;
    }

    public void setSeniorposition(String seniorposition) {
        this.seniorposition = seniorposition;
    }

    public String getOverallposition() {
        return overallposition;
    }

    public void setOverallposition(String overallposition) {
        this.overallposition = overallposition;
    }

    public String getClassstatus() {
        return classstatus;
    }

    public void setClassstatus(String classstatus) {
        this.classstatus = classstatus;
    }

    public String getLevelstatus() {
        return levelstatus;
    }

    public void setLevelstatus(String levelstatus) {
        this.levelstatus = levelstatus;
    }

    public String getJuniorstatus() {
        return juniorstatus;
    }

    public void setJuniorstatus(String juniorstatus) {
        this.juniorstatus = juniorstatus;
    }

    public String getSeniorstatus() {
        return seniorstatus;
    }

    public void setSeniorstatus(String seniorstatus) {
        this.seniorstatus = seniorstatus;
    }

    public String getOverallstatus() {
        return overallstatus;
    }

    public void setOverallstatus(String overallstatus) {
        this.overallstatus = overallstatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    public int getFinaltotal() {
        return finaltotal;
    }

    public void setFinaltotal(int finaltotal) {
        this.finaltotal = finaltotal;
    }

    public double getFinalaverage() {
        return finalaverage;
    }

    public void setFinalaverage(double finalaverage) {
        this.finalaverage = finalaverage;
    }

    public String viewResult(String regno1) {
        try {
            
       Classreportbank current = CR.find(code);
       String level=current.getLevel();
       int lev=Integer.parseInt(level);
      // if(lev<=100){
code=regno+""+acasession+""+term;
finaltotal=current.getFinaltotal();
finalaverage=current.getFinalaverage();
classposition=current.getClassposition();
name=current.getName();
sex= current.getSex();
pictureurl= current.getPictureurl();
//totalScore=100*min_number;
//noOfStudents=db.noOfStudents(classcode);
//classEnrollment=db.classEnrollment(classcode);
//control=SF.find(regno1); 
//formRemark=sb.TeachersRemark(studentAvg);
//prinRemark=sb.PrincipalRemark(studentAvg);
//System.out.println(formName+":"+formRemark);
FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
   }catch(Exception e){}
    return "primaryreport.xhtml";
    }
}
