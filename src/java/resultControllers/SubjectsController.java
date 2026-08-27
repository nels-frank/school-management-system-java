/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultControllers;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entities.Subjects;
import sessionbeans.SubjectsFacade;


@ManagedBean
@SessionScoped
public class SubjectsController implements Serializable{
    @EJB
    private SubjectsFacade subjectsFacade;
    private int selectedItemIndex;
    private Subjects current;
    public List<Subjects> allSubjects;
public List<Subjects> findBylevel;
private String subjectcode, subjectname,  level, category;
private String msg;
 public List<Subjects> classSubject;

    public List<Subjects> getClassSubject() {
        try {
            if (level != null) {
                allSubjects = subjectsFacade.findByLevel(level);
            }
        } catch (Exception e) {
        }
        return classSubject;
    }

    public void setClassSubject(List<Subjects> classSubject) {
        this.classSubject = classSubject;
    }
 
 

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    public List<Subjects> getAllSubjects() {
        return allSubjects=subjectsFacade.findAll();
    }

    public void setAllSubjects(List<Subjects> allSubjects) {
        this.allSubjects = allSubjects;
    }

    public List<Subjects> getFindBylevel() {
        return findBylevel=subjectsFacade.findByLevel(getSelected().getLevel());
    }

    public void setFindBylevel(List<Subjects> findBylevel) {
        this.findBylevel = findBylevel;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Subjects getSelected(){
    if(current==null){
    current=new Subjects();
    selectedItemIndex=-1;
    }
    return current;
    }
    public void createSubject(){
        try{
        String sub=getSelected().getSubjectname();
        String level=getSelected().getLevel();
        getSelected().setSubjectcode(sub+""+level);
    subjectsFacade.create(current);
        }catch(Exception e){
        
        }
          getSelected().setSubjectname(null);
    }
    public void addSubjects(){
    try{
    subjectcode=subjectname+""+level;
    subjectsFacade.createSubjects(subjectcode, subjectname, level, category);
    msg="Subject Succeffully Created";
    }catch(Exception e){}
    }

    public String editSubject(Subjects current) {
 //       SF.find(regno);subjectcode, subjectname, level, category
        if (current != null) {
            try {                      
                 subjectcode = current.getSubjectcode();
                 subjectname = current.getSubjectname();
                 level = current.getLevel();
                 category = current.getCategory();                                          
            } catch (Exception e) {}
        }
        return "updateSubject.jsf";
        
    }
   public String updateSubjects() {
        try {                        
          subjectsFacade.udpdateSubjects(subjectcode, subjectname, level, category);
            msg="Subject Successfully Updated";
        } catch (Exception e) {            
        }
        return "";
    } 
   public void DeleteSubject(String subjectcode){
        subjectsFacade.removeBySubjectcode(subjectcode);
}
}
