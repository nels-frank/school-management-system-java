/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerss;

import connection.dbConnection;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import entities.Users;
import sessionbeans.ClassesFacade;
import sessionbeans.UsersFacade;

@ManagedBean
@SessionScoped
public class userController implements Serializable{
    @EJB
    private ClassesFacade classesFacade;
    @Inject
    private dbConnection dc;
    @EJB
    private UsersFacade UF;
    private String username;
    private String password;
    private String passwordComfirmation;
    private String role;
    private String status;
    private String msg;
    private String jdk;
    private List<Users> allUsers;

    public ClassesFacade getClassesFacade() {
        return classesFacade;
    }

    public void setClassesFacade(ClassesFacade classesFacade) {
        this.classesFacade = classesFacade;
    }

    public dbConnection getDc() {
        return dc;
    }

    public void setDc(dbConnection dc) {
        this.dc = dc;
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

    public String getPasswordComfirmation() {
        return passwordComfirmation;
    }

    public void setPasswordComfirmation(String passwordComfirmation) {
        this.passwordComfirmation = passwordComfirmation;
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

    public List<Users> getAllUsers() {
        return allUsers =UF.findAll();
    }

    public void setAllUsers(List<Users> allUsers) {
        this.allUsers = allUsers;
    }
    
     public void createUsers(){
        int name=dc.checkUsername(username);
        if(name==0){
        try{
       if(password.equals(passwordComfirmation)){
    UF.createUsers(username, password, role, status);
    msg="User is Successfully Created";
        }else{
     msg="Password dose not Matched";
        }
        }catch(Exception e) {} 
        }  else{
        
        msg="Password Already Exist";
        } 
        
         int name2=dc.checkUsername2(username);
         
                if(name2> 0){
                   
        msg="User Already Existed";            
    }
    }
    
    private Users current;
    private int selectedItemIndex;
    
    public Users getSelected() {
        if (current == null) {
            current = new Users();
            selectedItemIndex = -1;
        }
        return current;
    }
    
    
    public void create() {
        UF.create(current);
    }
    
    public String isValid() {
        String msg="";
        try {
            
            current = UF.find(username);
            String username1 = current.getUsername();
            String password1 = current.getPassword();
            role = current.getRole();
            status = current.getStatus();
            
            if (username1.equals(username) && password1.equals(password) && role.equals("Admin") && status.equals("Active")) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username1);
                msg="newdashboard.xhtml?faces=redirect=true";
            } else 
               if (username1.equals(username) && password1.equals(password) && role.equals("User") && status.equals("Active")){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username1);
                msg="dashboard.xhtml?faces=redirect=true";
            }else{ 
               jdk = "User not Recognised";
               }
        } catch (Exception e) {
        }
        getSelected().setUsername(null);
        return msg;
    }
    
    public String logOut(){
 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("username");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
 return "index.xhtml?faces=redirect=true";
}
    
    public String updateUsers(String username){
    
    UF.updateUsers(username, status);
    return "confirmUsers.jsf";
    }
  
    public void deleteUser(String username){
    UF.DeleteByUsername(username);
    } 


public String UpdateUsers2() {

UF.udpdateEditUsers(username, password, role);
return "editUsers.jsf";
}
    
     public String editUsers(Users current) {
        if (current != null) {
            try {
                username = current.getUsername();
                password = current.getPassword();
                role = current.getRole();
                status = current.getStatus(); 
                 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", username);
            } catch (Exception e) {
            }
        }
        return "updateUser.jsf";
    }
    
}
