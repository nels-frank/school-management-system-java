/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultControllers;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entities.Classes;
import sessionbeans.ClassesFacade;
@ManagedBean
@SessionScoped
public class ClassesController implements Serializable{
    @EJB
    private ClassesFacade CF;
    private int selectedItemIndex;
    private String classcode, classname, level, status;
    private Classes current;
    private String msg;

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Classes getCurrent() {
        return current;
    }

    public void setCurrent(Classes current) {
        this.current = current;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Classes getSelected() {
        if (current == null) {
            current = new Classes();
            selectedItemIndex = -1;
        }
        return current;
    }

    public String createClass() {
        getSelected().setStatus("active");
        CF.create(current);
        return "createclasses";
    }
    
    
}
