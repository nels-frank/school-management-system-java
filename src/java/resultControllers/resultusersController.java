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
import javax.faces.context.FacesContext;
import entities.Resultusers;
import sessionbeans.ResultusersFacade;
@ManagedBean
@SessionScoped
public class resultusersController implements Serializable{
   @EJB
    private ResultusersFacade resultusersFacade;
    private Resultusers current;
    private int selectedItemIndex;
    private String username, password, role, status, confirmpassword, msg;
    public List<Resultusers> allUsers;
    private String jdk;

    public String getJdk() {
        return jdk;
    }

    public void setJdk(String jdk) {
        this.jdk = jdk;
    }
    

    public List<Resultusers> getAllUsers() {
        return allUsers=resultusersFacade.findAll();
    }

    public void setAllUsers(List<Resultusers> allUsers) {
        this.allUsers = allUsers;
    }
    
    

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
    
    public void createUsers(){
    try{
        if (password.equals(confirmpassword) ){
    resultusersFacade.createResultusers(username, password, role, status);   
        }else{
        msg="Password Dose not Match";
        }
    }catch(Exception e){}
    }

    public Resultusers getSelected() {
        if (current == null) {
            current = new Resultusers();
            selectedItemIndex = -1;
        }
        return current;
    }

    public void create() {
        resultusersFacade.create(current);
    }

    public String isValid() {
        String msg="";
        try {
            String username = getSelected().getUsername();
           
            String password = getSelected().getPassword();
            current = resultusersFacade.find(username);
            String username1 = current.getUsername();
            String password1 = current.getPassword();
            String role = current.getRole();
            if (username1.equals(username) && password1.equals(password) && role.equals("Admin")) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username1);
                msg="dashboard.xhtml?faces=redirect=true";
            } else {
              jdk="User not Recognised";
            }
        } catch (Exception e) {
        }
        getSelected().setUsername(null);
        return msg;
    }
    
public String logOut(){
 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("username");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
 return "Login.xhtml?faces=redirect=true";
}
  
public void DeleteUser(String username){
    try{
    resultusersFacade.removeUser(username);
    }catch(Exception e){}
}
}
