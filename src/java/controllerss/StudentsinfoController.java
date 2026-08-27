/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerss;

import connection.dbConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;
import entities.Classes;
import entities.Statelga;
import entities.Studentsinfo;
import sessionbeans.ClassesFacade;
import sessionbeans.StatelgaFacade;
import sessionbeans.StudentsinfoFacade;


@ManagedBean
@SessionScoped
public class StudentsinfoController implements Serializable{
    @Inject
    dbConnection dc;
    @EJB
    private ClassesFacade classesFacade;
    
    @EJB
    private StatelgaFacade statelgaFacade;
    
    @EJB
    private StudentsinfoFacade SF;
    private int selectedItemIndex;
    private Studentsinfo current;
    private String regno;
    private String pictureurl;
    private Part image;
    private boolean uploaded;
    public List<Statelga> lgabyState;
    public List<Studentsinfo> findByClasscode;
    public List<Classes> classcodeBylevel;
    public String  fname, mname, lname, state, lga, sex, session, level, classcode, dob, house, healthstatus, status, nationality, tribe, religion, guardianoccupation, guardianaddress, guardianname, guardianno,date;
   private int totalStudents;
    private String msg;
    private String jdk;
    private String mssg;
    
    private List<Studentsinfo> listofallSudents;
    @PostConstruct
    public void init() {
        
    }
    
    private List<Studentsinfo> allStuddentsinfo;

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public boolean isUploaded() {
        return uploaded;
    }

    public void setUploaded(boolean uploaded) {
        this.uploaded = uploaded;
    }

    public List<Statelga> getLgabyState() {
        if (state != null) {
            lgabyState = statelgaFacade.getLga(state);
        }
        return lgabyState;
    }

    public void setLgabyState(List<Statelga> lgabyState) {
        this.lgabyState = lgabyState;
    }

    public List<Studentsinfo> getFindByClasscode() {
        return findByClasscode;
    }

    public void setFindByClasscode(List<Studentsinfo> findByClasscode) {
        this.findByClasscode = findByClasscode;
    }

    public List<Classes> getClasscodeBylevel() {
        try {
            if (level != null) {
           classcodeBylevel = classesFacade.classByLevel(level);
            }
            
        } catch (Exception e) {
        }
        return classcodeBylevel;
    }

    public void setClasscodeBylevel(List<Classes> classcodeBylevel) {
        this.classcodeBylevel = classcodeBylevel;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getHealthstatus() {
        return healthstatus;
    }

    public void setHealthstatus(String healthstatus) {
        this.healthstatus = healthstatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getGuardianoccupation() {
        return guardianoccupation;
    }

    public void setGuardianoccupation(String guardianoccupation) {
        this.guardianoccupation = guardianoccupation;
    }

    public String getGuardianaddress() {
        return guardianaddress;
    }

    public void setGuardianaddress(String guardianaddress) {
        this.guardianaddress = guardianaddress;
    }

    public String getGuardianname() {
        return guardianname;
    }

    public void setGuardianname(String guardianname) {
        this.guardianname = guardianname;
    }

    public String getGuardianno() {
        return guardianno;
    }

    public void setGuardianno(String guardianno) {
        this.guardianno = guardianno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalStudents() {
        return totalStudents = SF.count();
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getJdk() {
        return jdk;
    }

    public void setJdk(String jdk) {
        this.jdk = jdk;
    }

    public String getMssg() {
        return mssg;
    }

    public void setMssg(String mssg) {
        this.mssg = mssg;
    }

    public List<Studentsinfo> getListofallSudents() {
        try {
            if (classcode != null) {
                listofallSudents = SF.findByClasscode(classcode);
            }
        } catch (Exception e) {
        }
        return listofallSudents;
    }

    public void setListofallSudents(List<Studentsinfo> listofallSudents) {
        this.listofallSudents = listofallSudents;
    }

    public List<Studentsinfo> getAllStuddentsinfo() {
        return allStuddentsinfo = SF.findAll();
    }

    public void setAllStuddentsinfo(List<Studentsinfo> allStuddentsinfo) {
        this.allStuddentsinfo = allStuddentsinfo;
    }
    
    public Studentsinfo getSelected() {
        if (current == null) {
            current = new Studentsinfo();
            selectedItemIndex = -1;
        }
        return current;
    }
    
    public String upload() {
        try {
            InputStream in = image.getInputStream();
            File f = new File(image.getSubmittedFileName());
            System.out.println(f.getAbsolutePath());
            pictureurl = f.getAbsolutePath();
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", f.getAbsolutePath());
            uploaded = true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return "viewstudent.jsf";
    }
    
    public String createStudents() {
        try {
            upload();
            session = getSelected().getSession();
            level = getSelected().getLevel();
            int count = SF.countS(session);
            regno = SF.totalStud(count, session);
            classcode = SF.checkClass(count, level);
            getSelected().setRegno(regno);
            getSelected().setFname(SF.titleCase(getSelected().getFname()));
            getSelected().setMname(SF.titleCase(getSelected().getMname()));
            getSelected().setLname(SF.titleCase(getSelected().getLname()));
            getSelected().setState(state);
            getSelected().setLevel(level);
            getSelected().setClasscode(classcode);
            getSelected().setStatus("Active");     
            getSelected().setPictureurl(pictureurl);
            getSelected().setNationality("Nigeria");
            getSelected().setTribe(SF.titleCase(getSelected().getTribe()));
            getSelected().setReligion(religion);
             getSelected().setGuardianoccupation(SF.titleCase(getSelected().getGuardianoccupation()));
            getSelected().setGuardianaddress(SF.titleCase(getSelected().getGuardianaddress()));
            getSelected().setGuardianname(SF.titleCase(getSelected().getGuardianname()));
            getSelected().setGuardianno(SF.titleCase(getSelected().getGuardianno()));
            
            SF.create(current);
            
        } catch (Exception e) {
        }
        return "viewstudent";
    }
    
    public String editProfile(Studentsinfo current) {
 //       SF.find(regno);
        if (current != null) {
            try {                      
                 regno = current.getRegno();
                 fname = current.getFname();
                 mname = current.getMname();
                 lname = current.getLname();
                 state = current.getState();
                 lga = current.getLga();
                 sex = current.getSex();
                 session = current.getSession();
                 level = current.getLevel();
                  classcode = current.getClasscode();
                  dob = current.getDob();
                  house = current.getHouse();
                  healthstatus = current.getHealthstatus();
                  status = current.getStatus();
                  pictureurl = current.getPictureurl();
                  nationality = current.getNationality();
                  tribe = current.getTribe();
                  religion = current.getReligion();
                  guardianoccupation = current.getGuardianoccupation();
                  guardianaddress = current.getGuardianaddress();
                  guardianname = current.getGuardianname();
                  guardianno = current.getGuardianno();
                  date = current.getDate();
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
                if (pictureurl != null) {
                return "viewstudent.jsf";
                }               
            } catch (Exception e) {}
        }
        return "viewstudent.jsf";
        
    }
    
     public String editStudent(Studentsinfo current) {
        if (current != null) {
            try {
                regno = current.getRegno();
                fname = current.getFname();
                mname = current.getMname();
                lname = current.getLname();
                 state = current.getState();
                  lga = current.getLga();
                  sex = current.getSex();
                  session = current.getSession();
                  level = current.getLevel();
                  classcode = current.getClasscode();
                  dob = current.getDob();
                  house = current.getHouse();
                  healthstatus = current.getHealthstatus();
                  status = current.getStatus();
                  pictureurl = current.getPictureurl();
                  nationality = current.getNationality();
                  tribe = current.getTribe();
                  religion = current.getReligion();
                  guardianoccupation = current.getGuardianoccupation();
                  guardianaddress = current.getGuardianaddress();
                  guardianname = current.getGuardianname();
                  guardianno = current.getGuardianno();
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
                
            } catch (Exception e) {
            }
        }
        return "updateStudent.jsf";
    } 
    
    public String updateStudent() {
        try {            
            upload();
            SF.udpdateStudent(regno, fname, mname, lname, state, lga, sex, session, level, classcode, dob, house, healthstatus, status, pictureurl, nationality, tribe, religion, guardianoccupation, guardianaddress, guardianname, guardianno);
            msg="Student Successfully Updated";
        } catch (Exception e) {            
        }
        return "viewstudent.jsf";
    }
    
    public String createStudent() {      
        try {
            this.upload();
            int count = SF.count();
            regno = SF.totalStud(count, session);
            status = "Active";
             nationality="Nigeria";
             fname = SF.titleCase(fname);
             mname = SF.titleCase(mname);
             lname = SF.titleCase(lname);
             tribe =SF.titleCase(tribe);
             guardianoccupation =SF.titleCase(guardianoccupation);
             guardianaddress = SF.titleCase(guardianaddress);
             guardianname = SF.titleCase(guardianname);
             guardianno = SF.titleCase(guardianno);           
             Date date1= new Date();
             SimpleDateFormat x =new SimpleDateFormat ("E dd/MM/yyyy '@' hh:mm a");
             String finaldate = x.format(date1);
             date=SF.titleCase(finaldate);
            SF.createStudents(regno, fname, mname, lname, state, lga, sex, session, level, classcode, dob, house, healthstatus, status, pictureurl, nationality, tribe, religion, guardianoccupation, guardianaddress, guardianname, guardianno,finaldate);    
           System.out.println(pictureurl);
        } catch (Exception e) {} 
        
      return "viewstudent.jsf";
    }
    
     public String back() {
         try{
                  fname = "";
                  mname = "";
                  lname = "";
                  state = "";
                  lga = "";
                  sex = "";
                  session = "";
                  level = "";
                  classcode = "";
                  dob = "";
                  house = "";
                  healthstatus = "";
                  status = "";
                  pictureurl = "";
                  nationality = "";
                  tribe = "";
                  religion = "";
                  guardianoccupation = "";
                  guardianaddress = "";
                  guardianname = "";
                  guardianno = "";
         }catch(Exception e){}        
        return "createstudents.jsf";
    }  
     
     public void deleteStudents(String regno){
  SF.removeByRegno(regno); 
  }
     
     public void promotion(){           
            if(classcode.equals("Primary 6A") ){              
            SF.promotSS3A(classcode);
              }else{
             if(classcode.equals("Primary 6B") ){
                 SF.promotSSS3B(classcode);
             }else{
             if(classcode.equals("Primary 6C")){
                 SF.promotSSS3C(classcode);
             }else{
             if(classcode.equals("Primary 6D")){
                 SF.promotSSS3D(classcode);
             }else{
             if(classcode.equals("Primary 6E")){
                 SF.promotSSS3C(classcode);
             }else{
              if(classcode.equals("Primary 6F")){
                 SF.promotSSS3C(classcode);
                 
             }else{
                 if(classcode.equals("Primary 5A")){
                 SF.promotSSS2A(classcode);
             }else{
                  if(classcode.equals("Primary 5B")){
                 SF.promotSSS2B(classcode);
             }else{
                      if(classcode.equals("Primary 5C")){
                 SF.promotSSS2C(classcode);
             }else{
                          if(classcode.equals("Primary 5D")){
                 SF.promotSSS2D(classcode);
             }else{
                              if(classcode.equals("Primary 5E")){
                 SF.promotSSS1A(classcode);                             
            }else{
                                  if(classcode.equals("Primary 5F")){
                 SF.promotSSS1B(classcode);
            }else{
                                      if(classcode.equals("Primary 4A")){
                 SF.promotSSS1C(classcode);
            }else{
                                      if(classcode.equals("Primary 4B")){
                 SF.promotSSS1D(classcode);
             }else{
                                      if(classcode.equals("Primary 4C")){
                 SF.promotJSS3A(classcode);
             }else{
                                      if(classcode.equals("Primary 4D")){
                 SF.promotJSS3B(classcode);
             }else{
                                       if(classcode.equals("Primary 4E")){
                 SF.promotJSS3C(classcode);
             }else{
                                       if(classcode.equals("Primary 4F")){
                 SF.promotJSS3D(classcode);
             }else{
                                       if(classcode.equals("Primary 3A")){
                 SF.promotJSS2A(classcode);
             }else{
                                       if(classcode.equals("Primary 3B")){
                 SF.promotJSS2B(classcode);
             }else{
                                          if(classcode.equals("Primary 3C")){
                 SF.promotJSS2C(classcode);
             }else{
                                              if(classcode.equals("Primary 3D")){
                 SF.promotJSS2D(classcode);
             }else{
                                              if(classcode.equals("Primary 3E")){
                 SF.promotJSS1A(classcode);
             }else{                                              
                                              if(classcode.equals("Primary 3F")){
                 SF.promotJSS1B(classcode);
             }else{
                                              if(classcode.equals("Primary 2A")){
                 SF.promotJSS1C(classcode);
             }else{
                                              if(classcode.equals("Primary 2B")){
                 SF.promotJSS1D(classcode);
                                          }else{
                                                  if(classcode.equals("Primary 2C")){
                 SF.promotPRI2C(classcode);
                                          }else{
                                                      if(classcode.equals("Primary 2D")){
                 SF.promotPRI2D(classcode);
                                          }else{
                                                          if(classcode.equals("Primary 2E")){
                 SF.promotPRI2E(classcode);
                                          }else{
                                                             if(classcode.equals("Primary 2F")){
                 SF.promotPRI2F(classcode);
                                          }else{
                                                             if(classcode.equals("Primary 1A")){
                 SF.promotPRI1A(classcode);
                                          }else{
                                                             if(classcode.equals("Primary 1B")){
                 SF.promotPRI1B(classcode);
                                          }else{
                                                             if(classcode.equals("Primary 1C")){
                 SF.promotPRI1C(classcode);
                                          }else{
                                                             if(classcode.equals("Primary 1D")){
                 SF.promotPRI1D(classcode);
                                          }else{
                                                             if(classcode.equals("Primary 1E")){
                 SF.promotPRI1E(classcode);
                                          }else{
                                                             if(classcode.equals("Primary 1F")){
                 SF.promotPRI1F(classcode);
                                          }else{
                                                             if(classcode.equals("Pre-Nursery A")){
                 SF.promotPNURA(classcode);
                                          }else{
                                                             if(classcode.equals("Pre-Nursery B")){
                 SF.promotPRNB(classcode);
                                                             }else{
                                                                 
                                                             if(classcode.equals("Pre-Nursery C")){
                 SF.promotPRNC(classcode);
                                                             }else{
                                                                  
                                                             if(classcode.equals("Pre-Nursery D")){
                 SF.promotPRND(classcode);
                                                              }else{
                                                             if(classcode.equals("Pre-Nursery E")){
                 SF.promotPRNE(classcode);
                                                             }else{
                                                             if(classcode.equals("Pre-Nursery F")){
                 SF.promotPRNF(classcode);
                                       
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
     jdk="Successfully Promoted";    
     } 
     }         
     public void Demotion(){
     SF.DemotStudent(regno, classcode);{
     mssg="Successfully Demoted";
     }
     }  
}
