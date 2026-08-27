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
import entities.Termlyaccount;
import sessionbeans.TermlyaccountFacade;

@ManagedBean
@SessionScoped
public class termlyaccountController implements Serializable{
    
    @Inject
  private  dbConnection dc;
    @EJB
    private TermlyaccountFacade TF;
    private String dayofclosure, timeofclosure, term, sessions, msg;
    private double termlyobtained, termlyexpenses, termlypaidsalary, tookhome;
    private Session session;
    private List<Termlyaccount> termlyTransaction;
    private List<Termlyaccount> transactionbySesion;  

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

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getSessions() {
        return sessions;
    }

    public void setSessions(String sessions) {
        this.sessions = sessions;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public double getTermlyobtained() {
        return termlyobtained;
    }

    public void setTermlyobtained(double termlyobtained) {
        this.termlyobtained = termlyobtained;
    }

    public double getTermlyexpenses() {
        return termlyexpenses;
    }

    public void setTermlyexpenses(double termlyexpenses) {
        this.termlyexpenses = termlyexpenses;
    }

    public double getTermlypaidsalary() {
        return termlypaidsalary;
    }

    public void setTermlypaidsalary(double termlypaidsalary) {
        this.termlypaidsalary = termlypaidsalary;
    }

    public double getTookhome() {
        return tookhome;
    }

    public void setTookhome(double tookhome) {
        this.tookhome = tookhome;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public List<Termlyaccount> getTermlyTransaction() {
        return termlyTransaction = TF.findAll();
    }

    public void setTermlyTransaction(List<Termlyaccount> termlyTransaction) {
        this.termlyTransaction = termlyTransaction;
    }

    public List<Termlyaccount> getTransactionbySesion() {
        try {
            if (sessions != null) {
                transactionbySesion =TF.findBySessions(sessions);
            }
        } catch (Exception e) {
        }
        return transactionbySesion;
    }

    public void setTransactionbySesion(List<Termlyaccount> transactionbySesion) {
        this.transactionbySesion = transactionbySesion;
    }
      public void deleteTermlyStatement(String Dayofclosure){
                TF.removeByDayofClosure(Dayofclosure);
  }
    
    public void closeTermAccount(){ 
try{        
       Date date=new Date();       
       dayofclosure =new SimpleDateFormat("dd/MM/yyyy").format(date);
       timeofclosure=new SimpleDateFormat("hh:mm:ss").format(date);
       double termamount = dc.Sumforterm(sessions, term);
       double termexpenses = dc.Sumforterm2(sessions, term);
       double total= termamount-termexpenses;
       TF.addTermlyExpenses(dayofclosure, timeofclosure, term, sessions, termamount, termexpenses, termlypaidsalary, total);
       msg = "Account Successfully Closed";
}catch (Exception e){
System.out.println("error computing due to" + " " + e.getMessage());
}
}
   
    
    
}
