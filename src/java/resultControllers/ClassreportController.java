
package resultControllers;
import com.SET07.dbconn.DBAction;
import com.SET07.dbconn.Resultbanck;
import connection.dbConnection;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;
import entities.Annual;
import entities.Annualbank;
import entities.Annualresult;
import entities.Attendance;
import entities.Attendancebank;
import entities.Classreport;
import entities.Classreportbank;
import entities.Computeresult;
import entities.Resultbank;
import entities.Studentsinfo;
import sessionbeans.AnnualFacade;
import sessionbeans.AnnualbankFacade;
import sessionbeans.AnnualresultFacade;
import sessionbeans.AttendanceFacade;
import sessionbeans.AttendancebankFacade;
import sessionbeans.ClassreportFacade;
import sessionbeans.ClassreportbankFacade;
import sessionbeans.ComputeresultFacade;
import sessionbeans.FormasterFacade;
import sessionbeans.HeadteacherFacade;
import sessionbeans.ResultbankFacade;
import sessionbeans.StudentsinfoFacade;
@ManagedBean
@SessionScoped
public class ClassreportController implements Serializable{
     @EJB
    private StudentsinfoFacade SF;
     @EJB
    private AnnualbankFacade ANF;
     @EJB
    private ClassreportbankFacade CRB;
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
    @EJB
    private AttendancebankFacade ABF;
    @EJB
    private AnnualresultFacade ANRF;
    @EJB
    private ResultbankFacade RBF;
 @Inject
    private Resultbanck sb;
 @Inject
     private  DBAction db ;  
    @EJB
    private ClassreportFacade CR;   
    public List<Classreport> findByClasscode;
    public List<Computeresult> findByRegno;
    public List<Annualresult> findAnualByRegno;
    public List<Resultbank> findByRegnoTermSession; 
    public List<Attendance> findByattendanceRegno;
    public List<Attendancebank> findByattenbankRegno;
    public List<Annual> findAnualRegno;
    public List<Annualbank> findAnualRegnoSession;
    public Studentsinfo control;
    public Attendance calll;
    //public Headteacher call;
    //public Formaster cal;
    public String classcode;
    public String subjects;
    public String term;
    public String examsession;
    public int min_number;
    public String regno;
    public String name;
    public String seniorposition;
    public String overallposition;
    public int check;
    public int totalScore;
    public int noOfStudents;
    public int classEnrollment;
public int studentTotal;
public double studentAvg;
public String studentPosition;
public String dob;
private String sex;
public String formName;
public String prinName;
public String prinRemark;
public String acasession;
private Part image;
private Part formsign;
       public String formRemark;
       private int max;
       private int presence;
       private int absence;
       private int histmax;
       private int histpresence;
       private int histabsence;
private String signurl;
private String pictureurl;
private String formname;  
private String headname;
private String jkd;
private String jjd;
private String jmm;
private String headteacher;
private String nextermbegin;
private String nextermfees;
public List<Classreportbank> findBySessionTerm;

private String code;
private int alertness, punctuation, reliability, initiativeness, leadership, courtesy, selfcontrol, spiritservice, perseverance, consideration, teamspirit, friendlyness, handwritting, fluency, games, sports, gymnastic, handlingtools, drawing;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

   
public int getAlertness() {
        return alertness;
    }

    public void setAlertness(int alertness) {
        this.alertness = alertness;
    }

    public int getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }

    public int getReliability() {
        return reliability;
    }

    public void setReliability(int reliability) {
        this.reliability = reliability;
    }

    public int getInitiativeness() {
        return initiativeness;
    }

    public void setInitiativeness(int initiativeness) {
        this.initiativeness = initiativeness;
    }

    public int getLeadership() {
        return leadership;
    }

    public void setLeadership(int leadership) {
        this.leadership = leadership;
    }

    public int getCourtesy() {
        return courtesy;
    }

    public void setCourtesy(int courtesy) {
        this.courtesy = courtesy;
    }

    public int getSelfcontrol() {
        return selfcontrol;
    }

    public void setSelfcontrol(int selfcontrol) {
        this.selfcontrol = selfcontrol;
    }

    public int getSpiritservice() {
        return spiritservice;
    }

    public void setSpiritservice(int spiritservice) {
        this.spiritservice = spiritservice;
    }

    public int getPerseverance() {
        return perseverance;
    }

    public void setPerseverance(int perseverance) {
        this.perseverance = perseverance;
    }

    public int getConsideration() {
        return consideration;
    }

    public void setConsideration(int consideration) {
        this.consideration = consideration;
    }

    public int getTeamspirit() {
        return teamspirit;
    }

    public void setTeamspirit(int teamspirit) {
        this.teamspirit = teamspirit;
    }

    public int getFriendlyness() {
        return friendlyness;
    }

    public void setFriendlyness(int friendlyness) {
        this.friendlyness = friendlyness;
    }

    public int getHandwritting() {
        return handwritting;
    }

    public void setHandwritting(int handwritting) {
        this.handwritting = handwritting;
    }

    public int getFluency() {
        return fluency;
    }

    public void setFluency(int fluency) {
        this.fluency = fluency;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getSports() {
        return sports;
    }

    public void setSports(int sports) {
        this.sports = sports;
    }

    public int getGymnastic() {
        return gymnastic;
    }

    public void setGymnastic(int gymnastic) {
        this.gymnastic = gymnastic;
    }

    public int getHandlingtools() {
        return handlingtools;
    }

    public void setHandlingtools(int handlingtools) {
        this.handlingtools = handlingtools;
    }

    public int getDrawing() {
        return drawing;
    }

    public void setDrawing(int drawing) {
        this.drawing = drawing;
    }

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }


    public String getJjd() {
        return jjd;
    }

    public void setJjd(String jjd) {
        this.jjd = jjd;
    }

    public String getJmm() {
        return jmm;
    }

    public void setJmm(String jmm) {
        this.jmm = jmm;
    }




 public List<Classreportbank> getFindBySessionTerm() {
        try {
          if (classcode != null && term != null) {
              findBySessionTerm = CRB.findBySesTermCod(acasession, term, classcode);
           }
       } catch (Exception e) {
       }
        return findBySessionTerm;
    }

    public void setFindBySessionTerm(List<Classreportbank> findBySessionTerm) {
        this.findBySessionTerm = findBySessionTerm;
    }

    public String getNextermbegin() {
        return nextermbegin;
    }

    public void setNextermbegin(String nextermbegin) {
        this.nextermbegin = nextermbegin;
    }

    public String getNextermfees() {
        return nextermfees;
    }

    public void setNextermfees(String nextermfees) {
        this.nextermfees = nextermfees;
    }

    public int getHistmax() {
        return histmax;
        //= db.getHistMaxAttendance(acasession, term, regno);
    }

    public void setHistmax(int histmax) {
        this.histmax = histmax;
    }

    public int getHistpresence() {
        return histpresence;
        //= db.getHistDaysPresent(acasession, term, regno, name);
    }

    public void setHistpresence(int histpresence) {
        this.histpresence = histpresence;
    }

    public int getHistabsence() {
        return histabsence;
        //= db.getHistDaysAbsent(acasession, term, regno);
    }

    public void setHistabsence(int histabsence) {
        this.histabsence = histabsence;
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


    public int getMax() {
        return max ;
                //= db.getMaxAttendance(regno);
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getPresence() {
        return presence;
                //= db.getDaysPresent(regno);
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public int getAbsence() {
        return absence;
        //= db.getDaysAbsent(regno);
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }



    public String getHeadteacher() {
        return headteacher;
    }

    public void setHeadteacher(String headteacher) {
        this.headteacher = headteacher;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public Part getFormsign() {
        return formsign;
    }

    public void setFormsign(Part formsign) {
        this.formsign = formsign;
    }


    public String getJkd() {
        return jkd;
    }

    public void setJkd(String jkd) {
        this.jkd = jkd;
    }



    public List<Attendancebank> getFindByattenbankRegno() {
        try{
        if(regno!=null){
        findByattenbankRegno=ABF.findByRegno(acasession, term, regno,name);
        }
        }catch(Exception e){}
        return findByattenbankRegno;
    }

    public void setFindByattenbankRegno(List<Attendancebank> findByattenbankRegno) {
        this.findByattenbankRegno = findByattenbankRegno;
    }

    public List<Annualbank> getFindAnualRegnoSession() {
        try{
        if(regno!=null){
        findAnualRegnoSession= ANF.findByRegno(regno, acasession);
        }
        }catch(Exception e){}
        return findAnualRegnoSession;
    }

    public void setFindAnualRegnoSession(List<Annualbank> findAnualRegnoSession) {
        this.findAnualRegnoSession = findAnualRegnoSession;
    }

    public List<Resultbank> getFindByRegnoTermSession() {
        try{
        if(regno!=null){
        findByRegnoTermSession=RBF.findByRegno(acasession, term, regno);
        }
        }catch(Exception e){}
        return findByRegnoTermSession;
    }

    public void setFindByRegnoTermSession(List<Resultbank> findByRegnoTermSession) {
        this.findByRegnoTermSession = findByRegnoTermSession;
    }

    public String getAcasession() {
        return acasession;
    }

    public void setAcasession(String acasession) {
        this.acasession = acasession;
    }

    public List<Classreport> getFindByClasscode() {
        try {
            if (classcode != null) {
                findByClasscode = CR.findByClasscode(classcode);
            }
        } catch (Exception e) {
        }
        return findByClasscode;
    }

    public void setFindByClasscode(List<Classreport> findByClasscode) {
        this.findByClasscode = findByClasscode;
    }

    public List<Classreport> getFindByRegno1() {
        try{
        if(regno!=null){
        findByClasscode=CR.findByClasscodeAndSubjects2(subjects, classcode, examsession, term);
        }
        }catch(Exception e){}
        
        return findByClasscode;
    }
    
    public List<Computeresult> getFindByRegno() {
        try{
        if(regno!=null){
        findByRegno=CF.findByRegnoSessionTerm(regno, acasession, term);
        }
        }catch(Exception e){}
        
        return findByRegno;
    }
    
    public void setFindByRegno(List<Computeresult> findByRegno) {
        this.findByRegno = findByRegno;
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

    public String getExamsession() {
        return examsession;
    }

    public void setExamsession(String examsession) {
        this.examsession = examsession;
    }

    public int getMin_number() {
        return min_number;
    }

    public void setMin_number(int min_number) {
        this.min_number = min_number;
    }

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

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public int getClassEnrollment() {
        return classEnrollment;
    }

    public void setClassEnrollment(int classEnrollment) {
        this.classEnrollment = classEnrollment;
    }

    public int getStudentTotal() {
        return studentTotal;
    }

    public void setStudentTotal(int studentTotal) {
        this.studentTotal = studentTotal;
    }

    public double getStudentAvg() {
        return studentAvg;
    }

    public void setStudentAvg(double studentAvg) {
        this.studentAvg = studentAvg;
    }

    public String getStudentPosition() {
        return studentPosition;
    }

    public void setStudentPosition(String studentPosition) {
        this.studentPosition = studentPosition;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getPrinName() {
        return prinName;
    }

    public void setPrinName(String prinName) {
        this.prinName = prinName;
    }

    public String getPrinRemark() {
        return prinRemark;
    }

    public void setPrinRemark(String prinRemark) {
        this.prinRemark = prinRemark;
    }

    public String getFormRemark() {
        return formRemark;
    }

    public void setFormRemark(String formRemark) {
        this.formRemark = formRemark;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }
    
    

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    public String getHeadname() {
        return headname;
    }

    public void setHeadname(String headname) {
        this.headname = headname;
    }

    public String getSignurl() {
        return signurl;
    }

    public void setSignurl(String signurl) {
        this.signurl = signurl;
        
        
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }
    public void classResult() {
        try {
          db.ComputeClassReport(classcode, term, acasession, min_number, nextermbegin, nextermfees);
        } catch (Exception e) {
        }
    }

    public void setPosition() {
        try {
            int lastloop = db.countForLoops1(classcode, acasession, term);
            while (lastloop >= 1) {
                String sql = "SELECT MAX(finalaverage) from classreportbank where classcode='" + classcode + "' AND acasession='" + acasession + "' AND term='" + term + "' AND classstatus='noposition'";
                Statement st = db.connect();
                try {
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        double average = rs.getDouble(1);
                        System.out.println(average);
                        int position = db.countClasscode1(classcode, acasession, term);
                        String post = db.getPosition(position);
                        CRB.setPosition(classcode, average, post, acasession, term);
                    }
                } catch (Exception e) {

                    System.out.println("error computing due to" + " " + e.getMessage());
                }

                lastloop = db.countForLoops1(classcode, acasession, term);
                System.out.println(lastloop);
            }

        } catch (Exception e) {
        }

    }
    
    
    
public void setSchoolPosition() {
        try {
            int lastloop = db.countForLoops4();
            while (lastloop >= 1) {
                String sql = "SELECT MAX(average) from classreport where  overallstatus='noposition'";
                Statement st = db.connect();
                try {
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        double average = rs.getDouble(1);
                        System.out.println(average);
                        int position = db.countClassreport();
                        String post = db.getPosition(position);
                        CR.setSchoolPosition(average, post);
                    }
                } catch (Exception e) {

                    System.out.println("error computing due to" + " " + e.getMessage());
                }

                lastloop = db.countForLoops4();
                System.out.println(lastloop);
            }

        } catch (Exception e) {
        }

    }

public String viewResult(String regno1) {
        try {          
if(term.equals("3RD TERM")){
Classreport current = CR.find(regno1);  
regno=regno1;
studentTotal=current.getTotal();
studentAvg=current.getAverage();
studentPosition=current.getClassposition();
name=current.getName();
sex= current.getSex();
term=current.getTerm();
acasession=current.getAcasession();
pictureurl= current.getPictureurl();
min_number=current.getMinNumber();
seniorposition=current.getSeniorposition();
overallposition=current.getOverallposition();
max=current.getMax();
presence=current.getPresence();
absence=current.getAbsence();
nextermbegin=current.getNextermbegin();
nextermfees=current.getNextermfees();
alertness=current.getAlertness();
punctuation=current.getPunctuation();
reliability=current.getReliability();
initiativeness=current.getInitiativeness();
leadership=current.getLeadership();
courtesy=current.getCourtesy();
selfcontrol=current.getSelfcontrol();
spiritservice=current.getSpiritservice();
perseverance=current.getPerseverance();
consideration=current.getConsideration();
teamspirit=current.getTeamspirit();
friendlyness=current.getFriendlyness();
handwritting=current.getHandwritting();
fluency=current.getFluency();
games=current.getGames();
sports=current.getSports();
gymnastic=current.getGymnastic();
handlingtools=current.getHandlingtools();
drawing=current.getDrawing();
FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
noOfStudents=db.noOfStudents(classcode);
classEnrollment=db.classEnrollment(classcode);
formRemark=sb.TeachersRemark(studentAvg);
prinRemark=sb.PrincipalRemark(studentAvg);
return "primaryreport.xhtml";

      }else{
    
Classreport current = CR.find(regno1);  
regno=regno1;
studentTotal=current.getTotal();
studentAvg=current.getAverage();
studentPosition=current.getClassposition();
name=current.getName();
sex= current.getSex();
term=current.getTerm();
acasession=current.getAcasession();
pictureurl= current.getPictureurl();
min_number=current.getMinNumber();
seniorposition=current.getSeniorposition();
overallposition=current.getOverallposition();
max=current.getMax();
presence=current.getPresence();
absence=current.getAbsence();
nextermbegin=current.getNextermbegin();
nextermfees=current.getNextermfees();
alertness=current.getAlertness();
punctuation=current.getPunctuation();
reliability=current.getReliability();
initiativeness=current.getInitiativeness();
leadership=current.getLeadership();
courtesy=current.getCourtesy();
selfcontrol=current.getSelfcontrol();
spiritservice=current.getSpiritservice();
perseverance=current.getPerseverance();
consideration=current.getConsideration();
teamspirit=current.getTeamspirit();
friendlyness=current.getFriendlyness();
handwritting=current.getHandwritting();
fluency=current.getFluency();
games=current.getGames();
sports=current.getSports();
gymnastic=current.getGymnastic();
handlingtools=current.getHandlingtools();
drawing=current.getDrawing();
FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
noOfStudents=db.noOfStudents(classcode);
classEnrollment=db.classEnrollment(classcode);
formRemark=sb.TeachersRemark(studentAvg);
prinRemark=sb.PrincipalRemark(studentAvg);
return "primaryreportcard.xhtml";  
      }
   }catch(Exception e){}
    return "";
    }

    public void deleteStudents(){
    dc.DeleteClassreportbank(classcode, acasession, term);
    } 

    public void deleteStuden(String regno){
    CR.removeByRegno(regno); 
    }
   

    public Resultbanck getSb() {
        return sb;
    }

    public void setSb(Resultbanck sb) {
        this.sb = sb;
    }

    public DBAction getDb() {
        return db;
    }

    public void setDb(DBAction db) {
        this.db = db;
    }

    
       
     

    public List<Attendance> getFindByattendanceRegno() {
        try{
        if(regno!=null){
        findByattendanceRegno=AF.findByRegno(regno);
        }
        }catch(Exception e){}
        return findByattendanceRegno;
    }

    public void setFindByattendanceRegno(List<Attendance> findByattendanceRegno) {
        this.findByattendanceRegno = findByattendanceRegno;
    }

    public List<Annualbank> getFindAnualRegno() {
        try{
        if(regno!=null){
        findAnualRegnoSession= ANF.findByRegno(regno, acasession);
        }
        }catch(Exception e){}
        return findAnualRegnoSession;
    }

    public void setFindAnualRegno(List<Annual> findAnualRegno) {
        this.findAnualRegno = findAnualRegno;
    }
    
public String viewResultbank(String regno1) {
try { 
if(term.equals("3RD TERM")){
Classreportbank current = CRB.find(regno1);
code=regno1;
studentTotal=current.getFinaltotal();
studentAvg=current.getFinalaverage();
studentPosition=current.getClassposition();
name=current.getName();
sex= current.getSex();
classcode=current.getClasscode();
acasession=current.getAcasession();
term=current.getTerm();
code=current.getCode();
regno=current.getRegno();
pictureurl= current.getPictureurl();
min_number=current.getMinNumber();
seniorposition=current.getSeniorposition();
overallposition=current.getOverallposition();
max=current.getMax();
presence=current.getPresence();
absence=current.getAbsence();
nextermbegin=current.getNextermbegin();
nextermfees=current.getNextermfees();
alertness=current.getAlertness();
punctuation=current.getPunctuation();
reliability=current.getReliability();
initiativeness=current.getInitiativeness();
leadership=current.getLeadership();
courtesy=current.getCourtesy();
selfcontrol=current.getSelfcontrol();
spiritservice=current.getSpiritservice();
perseverance=current.getPerseverance();
consideration=current.getConsideration();
teamspirit=current.getTeamspirit();
friendlyness=current.getFriendlyness();
handwritting=current.getHandwritting();
fluency=current.getFluency();
games=current.getGames();
sports=current.getSports();
gymnastic=current.getGymnastic();
handlingtools=current.getHandlingtools();
drawing=current.getDrawing();
FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
noOfStudents=db.classStudents(acasession, term, classcode);
classEnrollment=db.classEnrollments(acasession, term, classcode);
formRemark=sb.TeachersRemark(studentAvg);
prinRemark=sb.PrincipalRemark(studentAvg);
return "primaryreport.xhtml";

}else{
    
Classreportbank current = CRB.find(regno1);
code=regno1;
studentTotal=current.getFinaltotal();
studentAvg=current.getFinalaverage();
studentPosition=current.getClassposition();
name=current.getName();
sex= current.getSex();
classcode=current.getClasscode();
acasession=current.getAcasession();
term=current.getTerm();
code=current.getCode();
regno=current.getRegno();
pictureurl= current.getPictureurl();
min_number=current.getMinNumber();
seniorposition=current.getSeniorposition();
overallposition=current.getOverallposition();
max=current.getMax();
presence=current.getPresence();
absence=current.getAbsence();
nextermbegin=current.getNextermbegin();
nextermfees=current.getNextermfees();
alertness=current.getAlertness();
punctuation=current.getPunctuation();
reliability=current.getReliability();
initiativeness=current.getInitiativeness();
leadership=current.getLeadership();
courtesy=current.getCourtesy();
selfcontrol=current.getSelfcontrol();
spiritservice=current.getSpiritservice();
perseverance=current.getPerseverance();
consideration=current.getConsideration();
teamspirit=current.getTeamspirit();
friendlyness=current.getFriendlyness();
handwritting=current.getHandwritting();
fluency=current.getFluency();
games=current.getGames();
sports=current.getSports();
gymnastic=current.getGymnastic();
handlingtools=current.getHandlingtools();
drawing=current.getDrawing();
FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
noOfStudents=db.classStudents(acasession, term, classcode);
classEnrollment=db.classEnrollments(acasession, term, classcode);
formRemark=sb.TeachersRemark(studentAvg);
prinRemark=sb.PrincipalRemark(studentAvg);
return "primaryreportcard.xhtml";
}
}catch(Exception e){}
return "";
}
    
public String viewResultCheck() {
String code1= regno+""+acasession+""+term; 
int check = dc.countCode(code1);
if (check==0){
jjd = "Record Not Found";
}else{
Classreportbank current = CRB.find(code1);
try { 
if(term.equals("3RD TERM")){
classcode=current.getClasscode();
acasession= current.getAcasession();
term=current.getTerm();
regno=current.getRegno();
//if (acasession1.equals(acasession) && term1.equals(term) && classcode1.equals(classcode) && regno2.equals(regno) && term1.equals("3RD TERM")) {
studentTotal=current.getFinaltotal();
studentAvg=current.getFinalaverage();
studentPosition=current.getClassposition();
name=current.getName();
sex= current.getSex();
code=current.getCode();
pictureurl= current.getPictureurl();
min_number=current.getMinNumber();
seniorposition=current.getSeniorposition();
overallposition=current.getOverallposition();
max=current.getMax();
presence=current.getPresence();
absence=current.getAbsence();
nextermbegin=current.getNextermbegin();
nextermfees=current.getNextermfees();
alertness=current.getAlertness();
punctuation=current.getPunctuation();
reliability=current.getReliability();
initiativeness=current.getInitiativeness();
leadership=current.getLeadership();
courtesy=current.getCourtesy();
selfcontrol=current.getSelfcontrol();
spiritservice=current.getSpiritservice();
perseverance=current.getPerseverance();
consideration=current.getConsideration();
teamspirit=current.getTeamspirit();
friendlyness=current.getFriendlyness();
handwritting=current.getHandwritting();
fluency=current.getFluency();
games=current.getGames();
sports=current.getSports();
gymnastic=current.getGymnastic();
handlingtools=current.getHandlingtools();
drawing=current.getDrawing();
FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
noOfStudents=db.classStudents(acasession, term, classcode);
classEnrollment=db.classEnrollments(acasession, term, classcode);
formRemark=sb.TeachersRemark(studentAvg);
prinRemark=sb.PrincipalRemark(studentAvg);
return "primaryreport.xhtml";
                } else{ 
classcode=current.getClasscode();
acasession= current.getAcasession();
term=current.getTerm();
regno=current.getRegno();
studentTotal=current.getFinaltotal();
studentAvg=current.getFinalaverage();
studentPosition=current.getClassposition();
name=current.getName();
sex= current.getSex();
code=current.getCode();
pictureurl= current.getPictureurl();
min_number=current.getMinNumber();
seniorposition=current.getSeniorposition();
overallposition=current.getOverallposition();
max=current.getMax();
presence=current.getPresence();
absence=current.getAbsence();
nextermbegin=current.getNextermbegin();
nextermfees=current.getNextermfees();
alertness=current.getAlertness();
punctuation=current.getPunctuation();
reliability=current.getReliability();
initiativeness=current.getInitiativeness();
leadership=current.getLeadership();
courtesy=current.getCourtesy();
selfcontrol=current.getSelfcontrol();
spiritservice=current.getSpiritservice();
perseverance=current.getPerseverance();
consideration=current.getConsideration();
teamspirit=current.getTeamspirit();
friendlyness=current.getFriendlyness();
handwritting=current.getHandwritting();
fluency=current.getFluency();
games=current.getGames();
sports=current.getSports();
gymnastic=current.getGymnastic();
handlingtools=current.getHandlingtools();
drawing=current.getDrawing();
FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
noOfStudents=db.classStudents(acasession, term, classcode);
classEnrollment=db.classEnrollments(acasession, term, classcode);
formRemark=sb.TeachersRemark(studentAvg);
prinRemark=sb.PrincipalRemark(studentAvg);
return "primaryreportcard.xhtml";
}
} catch (Exception e) {}
}
        return "";
    }
     
    private Classreportbank current;
    private int selectedItemIndex;    
    public Classreportbank getSelected() {
        if (current == null) {
            current = new Classreportbank();
            selectedItemIndex = -1;
        }
        return current;
    }
  
}
