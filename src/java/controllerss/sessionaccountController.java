/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerss;

import connection.dbConnection;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.mail.Session;
import entities.Sessionaccount;
import sessionbeans.SessionaccountFacade;


@ManagedBean
@SessionScoped
public class sessionaccountController implements Serializable{
    @Inject
    private  dbConnection dc;
    @EJB
    private SessionaccountFacade SF;    
    private String dayofclosure; 
    private String timeofclosure;
    private String sessions;
    private double sessionobtained;
    private double sessionexpenses;
    private double tookhome;
    private String msg;
    private Session session;
    private List<Sessionaccount> sessionStatement;

    public String getDayofclosure() {
        return dayofclosure;
    }

    public void setDayofclosure(String dayofclosure) {
        this.dayofclosure = dayofclosure;
    }

    public String getTimeofclosure() {
        return timeofclosure;
    }

    public void setTimeofclosure(String timeofclosure) {
        this.timeofclosure = timeofclosure;
    }

    public String getSessions() {
        return sessions;
    }

    public void setSessions(String sessions) {
        this.sessions = sessions;
    }

    public double getSessionobtained() {
        return sessionobtained;
    }

    public void setSessionobtained(double sessionobtained) {
        this.sessionobtained = sessionobtained;
    }

    public double getSessionexpenses() {
        return sessionexpenses;
    }

    public void setSessionexpenses(double sessionexpenses) {
        this.sessionexpenses = sessionexpenses;
    }

    public double getTookhome() {
        return tookhome;
    }

    public void setTookhome(double tookhome) {
        this.tookhome = tookhome;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public List<Sessionaccount> getSessionStatement() {
        return sessionStatement = SF.findAll();
    }

    public void setSessionStatement(List<Sessionaccount> sessionStatement) {
        this.sessionStatement = sessionStatement;
    }
    
    public void closeSessionAccount(){ 
try{        
       Date date=new Date();       
       dayofclosure =new SimpleDateFormat("dd/MM/yyyy").format(date);
       timeofclosure=new SimpleDateFormat("hh:mm:ss").format(date);
       double sessionamount = dc.SumforSession(sessions);
       double sessionexpenses = dc.SumforSession2(sessions);
       double sessionaimed = dc.SumforSession4(sessions);      
       SF.createSessionClosure(dayofclosure, timeofclosure, sessions, sessionamount, sessionexpenses, sessionaimed);
       msg = "Account Successfully Closed";     
}catch (Exception e){
//System.out.println("error computing due to" + " " + e.getMessage());
}
} 
    public void DeletSesAccount(String sessions){
    SF.removeBySession(sessions);
    
    }
    
}
