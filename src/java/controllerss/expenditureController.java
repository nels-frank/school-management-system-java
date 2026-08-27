/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerss;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entities.Expenditure;
import sessionbeans.ExpenditureFacade;

@ManagedBean
@SessionScoped
public class expenditureController implements Serializable{
    @EJB 
    private ExpenditureFacade EF;
    private String sessions;
    private String term;
    private String discription;
    private String date;
    private String time;
    private double amount;
    private int sn;
    private List<Expenditure> termlyExpenses;
    private List<Expenditure> todayExpenditure;
    private List<Expenditure> allExpenditures;
    private String msg;
     private String mssg;

    public String getMssg() {
        return mssg;
    }

    public void setMssg(String mssg) {
        this.mssg = mssg;
    }

     
     
    public String getSessions() {
        return sessions;
    }

    public void setSessions(String sessions) {
        this.sessions = sessions;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public List<Expenditure> getTermlyExpenses() {
        try{
         if (sessions != null && term != null) {
                termlyExpenses = EF.findBySessionAndTerm(sessions, term);
            }

        } catch (Exception e) {
        }
        return termlyExpenses;
    }

    public void setTermlyExpenses(List<Expenditure> termlyExpenses) {
        this.termlyExpenses = termlyExpenses;
    }

    public List<Expenditure> getTodayExpenditure() {
        return todayExpenditure = EF.todayTransaction(date);
    }

    public void setTodayExpenditure(List<Expenditure> todayExpenditure) {
        this.todayExpenditure = todayExpenditure;
    }

    public List<Expenditure> getAllExpenditures() {
        return allExpenditures = EF.findAll();
    }

    public void setAllExpenditures(List<Expenditure> allExpenditures) {
        this.allExpenditures = allExpenditures;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
     public void addExpenses(){ 
    try{         
       Date dates=new Date();       
       date=new SimpleDateFormat("dd/MM/yyyy").format(dates);
       time=new SimpleDateFormat("hh:mm:ss").format(dates);
       EF.createExpenditure(sessions, term, discription, date, time, amount);
       mssg="Expenses Successfully Added";      
           }catch (Exception e){
      System.out.println("error computing due to" + " " + e.getMessage());
}
    }

  public void findBydate(){
   this.getTodayExpenditure();
    }

    public String deleteExpenses(){
  EF.removeSN(sn);
  return "allExpenditure.jsf";
  }
  public String viewEx(Expenditure ex){
        discription=ex.getDiscription();
        amount=ex.getAmount();
        sn=ex.getSn();
    return "removeexpenses.jsf";
    }
}
