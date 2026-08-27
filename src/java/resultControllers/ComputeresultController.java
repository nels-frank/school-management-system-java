
package resultControllers;
import com.SET07.dbconn.DBAction;
import com.SET07.dbconn.Resultbanck;
import connection.dbConnection;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
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
import entities.Classes;
import entities.Classreportbank;
import entities.Computeresult;
import entities.Psychomotor;
import entities.Resultbank;
import entities.Subjects;
import sessionbeans.AnnualFacade;
import sessionbeans.AnnualbankFacade;
import sessionbeans.AnnualresultFacade;
import sessionbeans.AttendanceFacade;
import sessionbeans.AttendancebankFacade;
import sessionbeans.ClassesFacade;
import sessionbeans.ClassreportbankFacade;
import sessionbeans.ComputeresultFacade;
import sessionbeans.FormasterFacade;
import sessionbeans.HeadteacherFacade;
import sessionbeans.PsychomotorFacade;
import sessionbeans.ResultbankFacade;
import sessionbeans.SubjectsFacade;

@ManagedBean
@SessionScoped
public class ComputeresultController implements Serializable{
    @EJB
    private PsychomotorFacade PS;
    @EJB
    private ClassesFacade classesFacade;
    @EJB
    private AnnualbankFacade ACF;
    @EJB
    private ClassreportbankFacade CRB;
    @EJB
    private ResultbankFacade RF;
     @EJB
    private HeadteacherFacade HF;
    @EJB
    private FormasterFacade FF;
    @EJB
    private AnnualFacade AFF;
    @Inject
   private DBAction db;
    @Inject
   private dbConnection dc;
    @Inject
    private Resultbanck sb;
    @EJB
    private SubjectsFacade subjectsFacade;
    @EJB
    private AttendanceFacade AF; 
    @EJB
    private AttendancebankFacade ABF; 
    @EJB
    private ComputeresultFacade CF;
    @EJB
    private AnnualresultFacade ANF;
    public List<Computeresult> listOfStudent;
    public List<Psychomotor> classStudents;
    public List<Resultbank> subjectPerformance;
    public List<Annualresult> allanualresult;
    public List<Annualresult> findAnualByRegno;
    public String examsession;
    public String term;
    public String name;
    public String codecompute;
    public String classcode;
    public String level;
    public String subjects;
    public int ass1;
    public int ass2;
    public int ass3;
    public int exam;
    public String remark;
    private int subjectnumber;
     private String msg;
     public List<Classes> classByLevel;
    public List<Subjects> allSubjects;
    private String formastercode;
    private String attendancecode; 
    private String regno;
    private int max;
    private int presence;
    private int absence;
    private String status;
    public List<Attendance> allAttendance;
    public List<Psychomotor> allPsychomotor;
    public List<Annual> allAnnual;
    public List<Attendancebank> allatendancebank;
    public List<Annualbank> allAnnualBank;
    private String computecode;
    private String formname;
private String pictureurl;
private String headname;
public int studentTotal;
public double studentAvg;
public String studentPosition;
public String dob;
private String sex;
public String formName;
public String prinName;
public String prinRemark;
public String formRemark;
public int totalScore;
public int min_number;
public int noOfStudents;
public int classEnrollment;
public String acasession;
public String code;
private String mssg;
private String mrg;
private String mrsg;
private String musg;
private String mmsg;
private String mmmg;
private String nnng;
private String jbt;
private String jkt;
private String jtl;
private String jlb;
private String bbh;
private String bbb;
private String signurl;
private Part formsign;
private boolean uploaded;
private String headteacher;
private String nextermbegin;
private String nextermfees;
public String seniorposition;
public String overallposition;
private int histmax;
private int histpresence;
private int histabsence;
private int finaltotal;
private double finalaverage;
private int alertness, punctuation, reliability, initiativeness, leadership, courtesy, selfcontrol, spiritservice, perseverance, consideration, teamspirit, friendlyness, handwritting, fluency, games, sports, gymnastic, handlingtools, drawing;
private String classposition, levelposition, juniorposition, classstatus, levelstatus, juniorstatus, seniorstatus, overallstatus;

    public String getBbh() {
        return bbh;
    }

    public void setBbh(String bbh) {
        this.bbh = bbh;
    }

    public String getLevelposition() {
        return levelposition;
    }

    public void setLevelposition(String levelposition) {
        this.levelposition = levelposition;
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

    public int getHistmax() {
        return histmax;
    }

    public void setHistmax(int histmax) {
        this.histmax = histmax;
    }

    public int getHistpresence() {
        return histpresence;
    }

    public void setHistpresence(int histpresence) {
        this.histpresence = histpresence;
    }

    public int getHistabsence() {
        return histabsence;
    }

    public void setHistabsence(int histabsence) {
        this.histabsence = histabsence;
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



    public Part getFormsign() {
        return formsign;
    }

    public void setFormsign(Part formsign) {
        this.formsign = formsign;
    }

    public boolean isUploaded() {
        return uploaded;
    }

    public void setUploaded(boolean uploaded) {
        this.uploaded = uploaded;
    }


    public String getSignurl() {
        return signurl;
    }

    public void setSignurl(String signurl) {
        this.signurl = signurl;
    }

    public String getMmmg() {
        return mmmg;
    }

    public void setMmmg(String mmmg) {
        this.mmmg = mmmg;
    }

    public String getNnng() {
        return nnng;
    }

    public void setNnng(String nnng) {
        this.nnng = nnng;
    }


    public String getMssg() {
        return mssg;
    }

    public void setMssg(String mssg) {
        this.mssg = mssg;
    }

    public String getMrg() {
        return mrg;
    }

    public void setMrg(String mrg) {
        this.mrg = mrg;
    }

    public String getMrsg() {
        return mrsg;
    }

    public void setMrsg(String mrsg) {
        this.mrsg = mrsg;
    }

    public String getMusg() {
        return musg;
    }

    public void setMusg(String musg) {
        this.musg = musg;
    }

    public String getMmsg() {
        return mmsg;
    }

    public void setMmsg(String mmsg) {
        this.mmsg = mmsg;
    }

    public String getJbt() {
        return jbt;
    }

    public void setJbt(String jbt) {
        this.jbt = jbt;
    }

    public String getJkt() {
        return jkt;
    }

    public void setJkt(String jkt) {
        this.jkt = jkt;
    }

    public String getJtl() {
        return jtl;
    }

    public void setJtl(String jtl) {
        this.jtl = jtl;
    }

    public String getJlb() {
        return jlb;
    }

    public void setJlb(String jlb) {
        this.jlb = jlb;
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

   

    public String getAcasession() {
        return acasession;
    }

    public void setAcasession(String acasession) {
        this.acasession = acasession;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
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

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getMin_number() {
        return min_number;
    }

    public void setMin_number(int min_number) {
        this.min_number = min_number;
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

    public String getComputecode() {
        return computecode;
    }
    public void setComputecode(String computecode) {
        this.computecode = computecode;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public String getFormastercode() {
        return formastercode;
    }

    public void setFormastercode(String formastercode) {
        this.formastercode = formastercode;
    }

    public String getBbb() {
        return bbb;
    }

    public void setBbb(String bbb) {
        this.bbb = bbb;
    }   

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }
    
    public List<Classes> getClassByLevel() {
        try {
            if (level != null) {
             classByLevel = classesFacade.classByLevel(level);
            }
        } catch (Exception e) {
        }
        return classByLevel;
    }

    public void setClassByLevel(List<Classes> classByLevel) {
        this.classByLevel = classByLevel;
    }

    public List<Subjects> getAllSubjects() {
        try {
            if (level != null) {
                allSubjects = subjectsFacade.findByLevel(level);
            }
        } catch (Exception e) {
        }
        return allSubjects;
    }

    public void setAllSubjects(List<Subjects> allSubjects) {
        this.allSubjects = allSubjects;
    }


    public List<Computeresult> getListOfStudent() {
        try {
            if (classcode != null && subjects != null) {
                listOfStudent = CF.findByClasscodeAndSubjects(subjects, classcode, examsession, term);
            }
        } catch (Exception e) {
        }
        return listOfStudent;
    }

    public void setListOfStudent(List<Computeresult> listOfStudent) {
        this.listOfStudent = listOfStudent;
    }

    public List<Psychomotor> getClassStudents() {
        try {
            if (classcode != null) {
                classStudents = PS.findByClasscode(classcode);
            }
        } catch (Exception e) {
        }
        return classStudents;
    }

    public void setClassStudents(List<Psychomotor> classStudents) {
        this.classStudents = classStudents;
    }
    
 public List<Computeresult> getListOfStudentPrint() {
        try {
            if (classcode != null && subjects != null) {
                listOfStudent = CF.findByClasscodeAndSubjectsPrint(subjects, classcode, examsession, term);
            }
        } catch (Exception e) {
        }
        return listOfStudent;
    }   
    

    public void setSubjectPerformance(List<Resultbank> subjectPerformance) {
        this.subjectPerformance = subjectPerformance;
    }
  
    public List<Annual> getAllAnnual() {
        try {
        if (classcode != null) {
                allAnnual = AFF.findByClasscode(classcode);
            }
        } catch (Exception e) {
        }
        return allAnnual;
    }
    
    public void setAllAnnual(List<Annual> allAnnual) {
        this.allAnnual = allAnnual;
    }
    

    public List<Annualbank> getAllAnnualBank() {
        try {
        if (classcode != null) {
                allAnnualBank = ACF.allAnnualBank(examsession, classcode);
            }
        } catch (Exception e) {
        }
        return allAnnualBank;
    }

    public void setAllAnnualBank(List<Annualbank> allAnnualBank) {
        this.allAnnualBank = allAnnualBank;
    }

    public List<Annualresult> getAllanualresult() {
        try {
            if (classcode != null && subjects != null) {
                allanualresult = ANF.findByAcademicSession(acasession, classcode, subjects);
            }
        } catch (Exception e) {
            
        }
        return allanualresult;
    }

    public void setAllanualresult(List<Annualresult> allanualresult) {
        this.allanualresult = allanualresult;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodecompute() {
        return codecompute;
    }

    public void setCodecompute(String codecompute) {
        this.codecompute = codecompute;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public int getAss1() {
        return ass1;
    }

    public void setAss1(int ass1) {
        this.ass1 = ass1;
    }

    public int getAss2() {
        return ass2;
    }

    public void setAss2(int ass2) {
        this.ass2 = ass2;
    }

    public int getAss3() {
        return ass3;
    }

    public void setAss3(int ass3) {
        this.ass3 = ass3;
    }
    
    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getSubjectnumber() {
        return subjectnumber;
    }

    public void setSubjectnumber(int subjectnumber) {
        this.subjectnumber = subjectnumber;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public String getClassposition() {
        return classposition;
    }

    public void setClassposition(String classposition) {
        this.classposition = classposition;
    }
    
    
   
     public void sendCompute(Computeresult result) {
        try {
            name = result.getName();
            String check=result.getChecked();
            codecompute = result.getComputecode();
            subjects = result.getSubjects();
            remark = result.getRemark();
            
            if (remark != null) {
                ass1 = result.getAss1();
                ass2 = result.getAss2();
                ass3 = result.getAss3();
                
                if(check!=null){               
                exam = result.getExam();
                }else{               
                exam=0;
                }
               
              
            }
            if (remark == null) {
                ass1 = 0;
                ass2 = 0;
                ass3 = 0;
                exam = 0;
                System.out.println(ass1);
            }
        } catch (Exception e) {
        }
                   System.out.println(ass1);
    }
public void sendCompute1(Computeresult result) {
        try {
            name = result.getName();

            codecompute = result.getComputecode();
            subjects = result.getSubjects();
            remark = result.getRemark();
            if (remark != null) {                             
                exam = result.getExam();    
            }
            if (remark == null) {               
                exam = 0;
                System.out.println(ass1);
            }
        } catch (Exception e) {
        }
                   System.out.println(ass1);
    }
 public void sendCompute2(Computeresult result) {
        try {
            name = result.getName();

            codecompute = result.getComputecode();
            subjects = result.getSubjects();
            remark = result.getRemark();
            if (remark != null) {
                exam = result.getExam();    
            }
            if (remark == null) {
                ass1 = 0;
                ass2 = 0;
                ass3 = 0;                
                exam = 0;
                System.out.println(ass1);
            }
        } catch (Exception e) {
        }
                   System.out.println(ass1);
    }
   
public void saveRecords() {
        try {
            int total1 = ass1 + ass2 + ass3;
            int total = ass1 + ass2 + ass3 + exam;
            String grade = CF.grade(total);
            remark = CF.remark(total);
            CF.udpdateResult(codecompute, ass1, ass2, ass3, exam, total1, total, grade, remark, status);
        } catch (Exception e) {
        }

    }
    
    public void saveScores() {
        try {
            int total1 = ass1 + ass2 + ass3;
            DecimalFormat OneDF = new DecimalFormat("#");
            double percent;
            percent = total1 * 100;
            percent = percent / 40;
            String av = OneDF.format(percent);
            int midpercent = Integer.valueOf(av);
            String grade = CF.grade(midpercent);
            remark = CF.remark(midpercent);
            CF.udpdateMidTotal(codecompute, ass1, ass2, ass3, total1);
        } catch (Exception e) {
        }
    }

    public void setPosition() {
        DecimalFormat OneDF = new DecimalFormat("#.0");

        try {
            double avg = db.selectAvg(subjects, classcode, examsession, term);
            String av = OneDF.format(avg);
            avg = Double.parseDouble(av);
            int highest = db.selectHigest(subjects, classcode, examsession, term);
            int lowest = db.selectLowest(subjects, classcode, examsession, term);
            int pointer = 0;
            int lastloop = db.countForLoop1(subjects, classcode, examsession, term);
            while (pointer <= lastloop) {
                pointer++;
                String sql = "SELECT MAX(total) from computeresult where classcode='" + classcode + "' AND subjects='" + subjects + "' AND examsession='" + examsession + "' AND term='" + term + "' AND status='noposition'";
                Statement st = db.connect();

                try {
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        int total = rs.getInt(1);
                        System.out.println(total);
                        int position = db.countbySubjectAndClasscode1(subjects, classcode, examsession, term);
                        String post = db.getPosition(position);
                        CF.setPosition(subjects, classcode, examsession, term, total, post);
                    }
                } catch (Exception e) {

                    System.out.println("error computing due to" + " " + e.getMessage());
                }
                System.out.println(pointer);
            }
            CF.setAHL(subjects, classcode, avg, highest, lowest);

        } catch (Exception e) {
        }
    }

    public void sentSubHistory() {
        try {
            dc.toSubHistory(classcode, subjects);
            mmsg="Successfully Sent to History";
        } catch (Exception e) {
        }
         
    }
        
   public void deleteComput(){
          dc.DeleteCoputeResult(classcode, subjects, examsession, term);
          jkt="Successfully Cleared";
   }
   
   public void deleteAnnualresult(){
          dc.DeleteAnnualResult(acasession, classcode, subjects);
          
   }
   
   public void deleteAttendance(){
          dc.DeleteAttendance(classcode);
          jbt="Successfully Cleared";
   }
   
   public void deletePsycho(){
   dc.DeletePsychomotor(classcode);
   }

    
 public void reSet3() {
        try {
            CF.reSet2(subjects, classcode);
        } catch (Exception e) {
        }
    }
    
    public void deleteSubject(){
        int check=db.checkSubjects(subjects, classcode);
        if(check==0){
    CF.removeBySubjects(subjects,classcode); 
        }else{
        msg="subjects cannot be deleted";
        }
    }
    public void deleteStudent(String regno){
        int check=db.checkRegno(regno);
        if(check==0){
    CF.removeByRegno(regno); 
        }else{
        msg="subjects cannot be deleted";
        }
    }
    public void setSubjectNumber(){
    CF.setSubjectNumber(subjects);
    }
    public void viewId(int id){
    System.out.println(id);
    }
    
  public void prepareResult() {
        dc.prepareResult(level, classcode, subjects, examsession, term);
        mssg="Subject Successfully Prepared. Select Another Subject";
    }
  public void prepareRegResult() {
        dc.prepareRegResult(regno, level, classcode, subjects, examsession, term);
        musg="Subject Successfully Prepared. Select Another Subject";
    }
  
  public void setAnnual() {
        dc.setAnnual(acasession, classcode, subjects);
        musg="Subject Successfully Prepared. Select Another Subject";
    }
  
  public void creatFormaster(){
    FF.createFormaster(examsession, term, level, classcode, formname, signurl);
    msg="Class Teacher Successfully Allocated";
    }
  
  public void saveAttendance() {
        try {
            int absent = max - presence;
            AF.udpdateAttendance(attendancecode, max, presence, absent);
        } catch (Exception e) {
        }
    }

    public List<Attendance> getAllAttendance() {
        try {
            if (classcode != null) {
                allAttendance = AF.findAttendance(classcode);
            }
        } catch (Exception e) {
        }
        return allAttendance;
    }

    public void setAllAttendance(List<Attendance> allAttendance) {
        this.allAttendance = allAttendance;
    }

    public List<Attendancebank> getAllatendancebank() {
        try {
            if (classcode != null && term!=null && examsession!=null) {
                allatendancebank = ABF.findAttendancebank(examsession, term, classcode);
            }
        } catch (Exception e) {
        }
        return allatendancebank;
    }

    public void setAllatendancebank(List<Attendancebank> allatendancebank) {
        this.allatendancebank = allatendancebank;
    }
    
    
  public void prepareAttendance() {
        dc.prepareAttendance(classcode, examsession, term, level);
        mrsg="Class Successfully Prepared. Select Another Class";
    }
  
  public void preparePsychomotor() {
        dc.preparePsychomotor(classcode, examsession, term, level);
        bbh="Class Successfully Prepared. Select Another Class";
    }
  public void studentPsychomotor() {
        dc.studentPsychomotor(regno, classcode, examsession, term, level);
        bbb="Student Successfully Prepared";
    }
  
  public void prepareRegAttendance() {
        dc.prepareRegAttendance(examsession, term, level, classcode, regno);
        mrg="Student Successfully Prepared";
    }
  public void prepareAnnual() {
        dc.prepareAnnual(examsession);
        msg="Class Successfully Prepared. Select Another Class";
    }
  
  public String computeAttendance(Attendance result) {
        try {
            attendancecode=result.getAttendancecode();
            name = result.getName();
            max = result.getMax();
            presence = result.getPresence();
            absence = result.getAbsence();
            examsession = result.getExamsession();
        } catch (Exception e) {
        }
         return"attendance.jsf";
    }
  
   public String computePsychomotor(Psychomotor result) {
         try {
            code=result.getCode();
            name = result.getName();
            alertness = result.getAlertness();
            punctuation = result.getPunctuation();
            reliability = result.getReliability();
            examsession = result.getExamsession();
            reliability= result.getReliability();
            initiativeness= result.getInitiativeness();
            leadership = result.getLeadership();
            courtesy= result.getCourtesy();
            selfcontrol= result.getSelfcontrol();
            spiritservice=result.getSpiritservice();
            perseverance=result.getPerseverance();
            consideration = result.getConsideration();
            teamspirit = result.getTeamspirit();
            friendlyness = result.getFriendlyness();
            handwritting = result.getHandwritting();
            fluency = result.getFluency();
            games = result.getGames();
            sports = result.getSports();
            gymnastic = result.getGymnastic();
            handlingtools = result.getHandlingtools();
            drawing = result.getDrawing();
        } catch (Exception e) {
        }
         return"Psychomotor.jsf";
    }
  
  public void annualResult() {
        try {
            dc.ComputeAnnual(classcode, examsession);
        } catch (Exception e) {
        }
    }
  public void deleteAnnual(String regno){
    AFF.removeByRegno(regno);
    }
  public void deleteAnnualbank(String code){
    ACF.removeByCode(code);
    }
  
  public void deleteStudSub(String computecode){
    CF.removeByComputCod(computecode);
  }
  public void deleteAttendancebank(String attendancecode){
    ABF.removeByAttcode(attendancecode);
    }
  
  public void setAnuaPosition() {
        try {
        int pointer = 0;       
            int lastloop = db.countForLoops2(classcode,examsession);
            while (pointer<=lastloop) {
                pointer++;
                String sql = "SELECT MAX(finaltotal) from annualbank where classcode='" + classcode + "'AND acasession='" + examsession + "' AND classstatus='noposition'";
                 Statement st = db.connect();
                 
                try {
                   ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        int finaltotal = rs.getInt(1);
                       System.out.println(finaltotal);
                        int position = db.countClasscode2(classcode,examsession);
                        String post = db.getAnnualPosition(position);
                      //  AFF.setPosition(classcode, examsession,finaltotal, post);
                        ACF.setPosition(classcode, examsession, finaltotal, post);
                    }
                } catch (Exception e) {
                    System.out.println("error computing due to" + " " + e.getMessage());
                }      
      //          lastloop = db.countForLoops2(classcode,examsession);
                System.out.println(pointer);              
           }

        } catch (Exception e) {
        }
    }
 
  public void deleteallAnnual(){
          dc.DeleteAnnualBank(classcode, examsession);         
          msg="Successfully Cleared";
  }
  
  public void reSet() {
        try {
            CF.reSet(subjects, classcode, examsession, term);
        } catch (Exception e) {
        }
    }
    
public void deleteStudens(String code){
CRB.removeByRegno(code); 
    }

public void updatePsycho(){
PS.udpdatePsychomotor(code, alertness, punctuation, reliability, initiativeness, leadership, courtesy, selfcontrol, spiritservice, perseverance, consideration, teamspirit, friendlyness, handwritting, fluency, games, sports, gymnastic, handlingtools, drawing);
    }

    public List<Psychomotor> getAllPsychomotor() {
        try {
            if (classcode != null) {
                allPsychomotor = PS.findByClasscode(classcode);
            }
        } catch (Exception e) {
        }
        return allPsychomotor;
    }

    public void setAllPsychomotor(List<Psychomotor> allPsychomotor) {
        this.allPsychomotor = allPsychomotor;
    }
    
public void setAnnualPosition() {
        DecimalFormat OneDF = new DecimalFormat("#.0");

        try {
           double avg = db.selectAnnualAvg(acasession, classcode, subjects);
            String av = OneDF.format(avg);
           avg = Double.parseDouble(av);
           double highest = db.selectAnualHigest(acasession, classcode, subjects);
           double lowest = db.selectAnnualLowest(acasession, classcode, subjects);
            int pointer = 0;
            int lastloop = db.countAnnualForLoop1(acasession, classcode, subjects);
            while (pointer <= lastloop) {
                pointer++;
                String sql = "SELECT MAX(total) from annualresult where acasession='" + acasession + "' AND classcode='" + classcode + "' AND subject='" + subjects + "' AND status='noposition'";
                Statement st = db.connect();
                
                try {
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {
                        int total = rs.getInt(1);
                        System.out.println(total);
                        int position = db.countbySubjectAndClasscode3(acasession, classcode, subjects);
                        String post = db.getPosition(position);
                        ANF.setPosition(acasession, classcode, subjects, total, post);
                    }
                } catch (Exception e) {

                    System.out.println("error computing due to" + " " + e.getMessage());
                }
                System.out.println(pointer);
            }
            ANF.setAHL(acasession, classcode, subjects, avg, highest, lowest);

        } catch (Exception e) {
        }
    }

public String viewResultCheck(String code1) {
Annualbank current = ACF.find(code1);
try {
code=code1;
name= current.getName();
finaltotal=current.getFinaltotal();
finalaverage=current.getFinalaverage();
classposition=current.getClassposition();
remark=current.getRemark();
classcode=current.getClasscode();
term=current.getTerm();
acasession= current.getAcasession();
levelposition=current.getLevelposition();
level= current.getLevel();
juniorposition=current.getJuniorposition();
seniorposition=current.getSeniorposition();
overallposition=current.getOverallposition();
classstatus=current.getClassstatus();
levelstatus=current.getLevelstatus();
juniorstatus=current.getJuniorstatus();
seniorstatus=current.getSeniorstatus();
overallstatus=current.getOverallstatus();
regno=current.getRegno();
sex=current.getSex();
term=current.getTerm();
levelposition=current.getLevelposition();
pictureurl=current.getPictureurl();
FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
noOfStudents=db.classStudents(acasession, term, classcode);
classEnrollment=db.AnualclassEnrollments(acasession, classcode);
formRemark=sb.TeachersRemark(finalaverage);
prinRemark=sb.PrincipalAnnualRemark(finalaverage);
seniorposition=db.formaster(classcode);
overallposition=db.HM(classcode);
return "annualreportcard.xhtml";
} catch (Exception e) {}

        return "";
    }

public String viewResultCheck2() {
String code1= regno+""+acasession; 
int check = dc.countAnnuabank(code1);
if (check==0){
bbb = "Record Not Found";
}else{
Annualbank current = ACF.find(code1);
try { 
name= current.getName();
finaltotal=current.getFinaltotal();
finalaverage=current.getFinalaverage();
classposition=current.getClassposition();
remark=current.getRemark();
classcode=current.getClasscode();
term=current.getTerm();
acasession= current.getAcasession();
levelposition=current.getLevelposition();
level= current.getLevel();
juniorposition=current.getJuniorposition();
seniorposition=current.getSeniorposition();
overallposition=current.getOverallposition();
classstatus=current.getClassstatus();
levelstatus=current.getLevelstatus();
juniorstatus=current.getJuniorstatus();
seniorstatus=current.getSeniorstatus();
overallstatus=current.getOverallstatus();
regno=current.getRegno();
sex=current.getSex();
term=current.getTerm();
levelposition=current.getLevelposition();
pictureurl=current.getPictureurl();
FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
noOfStudents=db.classStudents(acasession, term, classcode);
classEnrollment=db.AnualclassEnrollments(acasession, classcode);
formRemark=sb.TeachersRemark(finalaverage);
prinRemark=sb.PrincipalAnnualRemark(finalaverage);
seniorposition=db.formaster(classcode);
overallposition=db.HM(classcode);
return "annualreportcard.xhtml";
} catch (Exception e) {}
}
        return "";
    }

public List<Annualresult> getFindAnualByRegno() {
        try{
        if(regno!=null){
        findAnualByRegno=ANF.findByRegnoSession(regno, examsession);
        }
        }catch(Exception e){}
        return findAnualByRegno;
    }

    public void setFindAnualByRegno(List<Annualresult> findAnualByRegno) {
        this.findAnualByRegno = findAnualByRegno;
    }

}
