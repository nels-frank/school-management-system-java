/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerss;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import entities.Feeshistory;
import sessionbeans.FeeshistoryFacade;

@ManagedBean
@SessionScoped
public class FeeshistoryController implements Serializable{
    @EJB
    private FeeshistoryFacade FF;
    private String session;
    private String term;
    private double amountpaid;
    private String regno;
    private double balance;
    private String paymenttype;
    private String telanumber;
    private String status;
    private String name;
    private String level;
    private String classcode;
    private double tuitionfee;
    private String datetime;
    private String date;
    private String pin;
    private String pictureurl;
    private Part image;
    private boolean uploaded;
    private String bank;
    private int sn;
    private List<Feeshistory> HistoryTransaction;
    
    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public double getAmountpaid() {
        return amountpaid;
    }

    public void setAmountpaid(double amountpaid) {
        this.amountpaid = amountpaid;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getTelanumber() {
        return telanumber;
    }

    public void setTelanumber(String telanumber) {
        this.telanumber = telanumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getTuitionfee() {
        return tuitionfee;
    }

    public void setTuitionfee(double tuitionfee) {
        this.tuitionfee = tuitionfee;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public List<Feeshistory> getHistoryTransaction() {
        return HistoryTransaction = FF.historyTransaction(regno);
    }

    public void setHistoryTransaction(List<Feeshistory> HistoryTransaction) {
        this.HistoryTransaction = HistoryTransaction;
    }
   
    public void findTransactionHistory(){
   this.getHistoryTransaction();
    }
    
    public void deleteHistory(){
  FF.removeByRegno(regno); 
  }
    
    public String findByreg(Feeshistory control) {
            try {                  
                pictureurl=control.getPictureurl();
                session = control.getSession();
                term = control.getTerm();
                regno = control.getRegno();
                name = control.getName();
                level = control.getClasslevel();
                classcode = control.getClassoption();
                tuitionfee = control.getTuitionfee();
                amountpaid = control.getAmountpaid();
                balance = control.getBalance();
                paymenttype = control.getPaymenttype();
                telanumber = control.getTelanumber();
                status = control.getStatus();
                date = control.getDate(); ; 
                pin = control.getPin();
                bank=control.getBank();
                datetime=control.getDatetime();
                sn=control.getSn();
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);          
            } catch (Exception e) {}           
   return "historyReceipt.jsf";          
   }
    
   public String deleteFeeshistory(){
  FF.removeSN(sn);
  return "transactionHistory.jsf";
   }
    
}
