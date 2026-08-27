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
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import entities.Account;
import sessionbeans.AccountFacade;


@ManagedBean
@SessionScoped
public class accountController implements Serializable{
     @Inject
  private  dbConnection dc;
   @EJB  
    private AccountFacade AF;
    private String dayofpayment;
    private String timeofpayment;
    private double feesamount;
    private double expensesamount;
    private double dailysaved;
    private String term;
    private String sessions;
    private String msg;
    private List<Account> accStatement;
    private List<Account> termStatement;
    private Session session;
    private String msssg;

    public String getMsssg() {
        return msssg;
    }

    public void setMsssg(String msssg) {
        this.msssg = msssg;
    }

    
    

    public String getDayofpayment() {
        return dayofpayment;
    }

    public void setDayofpayment(String dayofpayment) {
        this.dayofpayment = dayofpayment;
    }

    public String getTimeofpayment() {
        return timeofpayment;
    }

    public void setTimeofpayment(String timeofpayment) {
        this.timeofpayment = timeofpayment;
    }

    public double getFeesamount() {
        return feesamount;
    }

    public void setFeesamount(double feesamount) {
        this.feesamount = feesamount;
    }

    public double getExpensesamount() {
        return expensesamount;
    }

    public void setExpensesamount(double expensesamount) {
        this.expensesamount = expensesamount;
    }

    public double getDailysaved() {
        return dailysaved;
    }

    public void setDailysaved(double dailysaved) {
        this.dailysaved = dailysaved;
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

    public List<Account> getAccStatement() {
        return accStatement = AF.findAll();
    }

    public void setAccStatement(List<Account> accStatement) {
        this.accStatement = accStatement;
    }

    public List<Account> getTermStatement() {
        try {
            if (sessions != null && term !=null) {
                termStatement = AF.findBySessionAndTerm(sessions, term);
            }
        } catch (Exception e) {
        }
        return termStatement;
    }

    public void setTermStatement(List<Account> termStatement) {
        this.termStatement = termStatement;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
     public void dailyClose(){ 
try{           
       Date date=new Date();       
       dayofpayment=new SimpleDateFormat("dd/MM/yyyy").format(date);
       timeofpayment=new SimpleDateFormat("hh:mm:ss").format(date);
       double paymentsum = dc.SumFeespayment(dayofpayment);
       double expendituresum =dc.SumExpenses(dayofpayment);
       double tookhome = paymentsum - expendituresum;
       AF.closeDaily(dayofpayment, timeofpayment, paymentsum, expendituresum, tookhome, term, sessions);
       msssg="Daily Acount Successfully Closed";
    }catch(Exception e){}
    }    
    
     public void deleteAccStatement(String dayofpayment){
                AF.removeByDay(dayofpayment); 
  }
 
     public void sendMessage(double totalsum, double expensesamount, double tookhome, String reason){       
        try{
    Message mssg=new MimeMessage(session);
    mssg.setSubject("Today's Transaction Report From Nelspeace College");
    mssg.setText("TOTAL PAYMENT: =NGN"+totalsum+"\n TOTAL EXPENSES=NGN "+expensesamount+"\n BALANCE OBTAINED =NGN"+tookhome+"\n REASONS FOR EXPENSES = "+reason);

    mssg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("nelsfrank247@gmail.com")); 
    Transport.send(mssg);
    msg="Mail has been Successfully Sent";
        }catch(MessagingException ex){
            msg="Network is not strong, try again";
         System.out.println(ex.getMessage());
        }
         System.out.println("stop sending");
    }
    
    
}
