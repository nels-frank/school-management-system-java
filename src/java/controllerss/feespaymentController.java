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
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;
import entities.Classes;
import entities.Feespayment;
import sessionbeans.ClassesFacade;
import sessionbeans.FeespaymentFacade;

@ManagedBean
@SessionScoped
public class feespaymentController implements Serializable{
    
    @Inject
    dbConnection dc;

    @EJB
    private ClassesFacade classesFacade;

    @EJB
    private FeespaymentFacade FF;
    private int selectedItemIndex;
    private Feespayment current;
    public List<Classes> classcodeBylevel;
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
    private String todaydate;
    private String pin;
    private String pictureurl;
    private Part image;
    private boolean uploaded;
    private String bank;
    private String checkFessPayment;
    private List<Feespayment> todaySales;
    private List<Feespayment> dayofSales;
    private List<Feespayment> listofallSudents;
    private List<Feespayment> allPayment;
    private List<Feespayment> allFeespayment;
    private String msg;
    private String mmsg;
    private String mnng;
    private String nnng;

    public String getMmsg() {
        return mmsg;
    }

    public void setMmsg(String mmsg) {
        this.mmsg = mmsg;
    }

    public String getMnng() {
        return mnng;
    }

    public void setMnng(String mnng) {
        this.mnng = mnng;
    }

    public String getNnng() {
        return nnng;
    }

    public void setNnng(String nnng) {
        this.nnng = nnng;
    }
    
    

    public ClassesFacade getClassesFacade() {
        return classesFacade;
    }

    public void setClassesFacade(ClassesFacade classesFacade) {
        this.classesFacade = classesFacade;
    }

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    public Feespayment getCurrent() {
        return current;
    }

    public void setCurrent(Feespayment current) {
        this.current = current;
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

    public String getTodaydate() {
        return todaydate;
    }

    public void setTodaydate(String todaydate) {
        this.todaydate = todaydate;
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

    public String getCheckFessPayment() {
        return checkFessPayment;
    }

    public void setCheckFessPayment(String checkFessPayment) {
        this.checkFessPayment = checkFessPayment;
    }

    public List<Feespayment> getTodaySales() {
        return todaySales;
    }

    public void setTodaySales(List<Feespayment> todaySales) {
        this.todaySales = todaySales;
    }

    public List<Feespayment> getDayofSales() {
        return dayofSales = FF.todayTransaction(todaydate);
    }

    public void setDayofSales(List<Feespayment> dayofSales) {
        this.dayofSales = dayofSales;
    }

    public List<Feespayment> getListofallSudents() {
        try {
            if (classcode != null) {
                listofallSudents = FF.findByClassoption(classcode);
            }
        } catch (Exception e) {
        }
        return listofallSudents;
    }

    public void setListofallSudents(List<Feespayment> listofallSudents) {
        this.listofallSudents = listofallSudents;
    }

    public List<Feespayment> getAllPayment() {
        return allPayment;
    }

    public void setAllPayment(List<Feespayment> allPayment) {
        this.allPayment = allPayment;
    }

    public List<Feespayment> getAllFeespayment() {
        return allFeespayment= FF.findAll();
    }

    public void setAllFeespayment(List<Feespayment> allFeespayment) {
        this.allFeespayment = allFeespayment;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void prepareStudents() {
        dc.prepareclassFeespayment(classcode, term, session, tuitionfee, tuitionfee);       
        mnng="Class Successfully Prepared";
    }

    public void prepareStudent() {       
        dc.preparestudentFeespayment(regno, classcode, term, session, tuitionfee, tuitionfee);
        mmsg="The Student is Successfully Prepared";
    }

    public List<Feespayment> getTodayTransaction() {
        Date date=new Date();
        todaydate =new SimpleDateFormat("dd/MM/yyyy").format(date);
        return todaySales=FF.todayTransaction(todaydate);
        
    }
  
    public String findByreg() {
        double checkpayment = dc.checkBalance(regno);
        if (checkpayment > 0.0) {
        Feespayment curry = FF.find(regno);
        name = curry.getName();
        balance = curry.getBalance();
        pictureurl=curry.getPictureurl();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
        return "confirmname.jsf";
        } else {
            try {
            Feespayment control = FF.find(regno);
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
                todaydate = control.getTodaydate(); 
                pin = control.getPin();
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
            return "feesCompleted.jsf";
            } catch (Exception e) {
            };
          //  msg = name + " has completed fess";
        }
        return "";
    }
    
    public String findByreg2() {
        double checkpayment = dc.checkBalance(regno);
        if (checkpayment > 0) {
        Feespayment curry = FF.find(regno);
        name = curry.getName();
        balance = curry.getBalance();
        pictureurl=curry.getPictureurl();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
        return "confirmbankName.jsf";
        } else {
            try {
            Feespayment control = FF.find(regno);
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
                todaydate = control.getTodaydate(); 
                pin = control.getPin();
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
            return "feesCompleted.jsf";
            } catch (Exception e) {
            };
          //  msg = name + " has completed fess";
        }
        return "";
    }

    public String viewByregno() {
        
            try {
                Feespayment control = FF.find(regno);
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
                todaydate = control.getTodaydate();  
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
            } catch (Exception e) {
            };
    return "feesSelecttype.jsf";
    }
    
     public String viewByregno2() {
        
            try {
                
                Feespayment control = FF.find(regno);
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
                todaydate = control.getTodaydate();                
            } catch (Exception e) {
            };
    return "feesfinalConfirm.jsf";
    }   


    public Feespayment getSelected() {
        if (current == null) {
            current = new Feespayment();
            selectedItemIndex = -1;
        }
        return current;
    }
    public String feesPayment(String datepaid) {
        pictureurl = pictureurl;
        session = FF.titleCase(session);
        term = FF.titleCase(term);
        amountpaid =amountpaid;
        regno = regno;      
        paymenttype = "Cash";
        status = "Active";
        name = FF.titleCase(name);
        level = FF.titleCase(level);
        classcode = classcode;
        tuitionfee = tuitionfee;
        telanumber = "Nill";
        double finalbalance = balance - amountpaid;
         balance = finalbalance;
        Date date1 = new Date();
        SimpleDateFormat x = new SimpleDateFormat("E @ hh:mm a");
        String time = x.format(date1);
        bank = "Nill";
        datetime=FF.titleCase(time);        
        Date date2 = new Date();
        SimpleDateFormat y = new SimpleDateFormat("dd/MM/yyyy");
        String finaldate = y.format(date2);
        todaydate = FF.titleCase(finaldate);                 
                int count=FF.count();
                pin = FF.Feespin(count);
                pin = pin;
          double checkpayment = dc.checkBalance2(regno);
                if(amountpaid > checkpayment){
                    try {
                    msg="The entered amount is greater than the standing fee";
                return "feesSearch.jsf";              
                    }catch(Exception e){}
                    } else
                if (amountpaid<=checkpayment){
                    try{
                FF.updateFeespayment2(amountpaid, regno, finalbalance, paymenttype, telanumber, status, time, finaldate, pin, bank);
               FF.createFeeshistory2(session, term, amountpaid, regno, balance, paymenttype, telanumber, status, name, level, classcode, tuitionfee, datetime, todaydate, bank, pictureurl, pin);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
                if (pictureurl != null) {
                return "newfeesReciept.jsf";
                }
                }catch (Exception e){}             
            }                      
        return "";
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
        return "newfeesReciept.jsf";
    }
    
    
    public String feesPayment2( String datepaid) {
        pictureurl = pictureurl;
        session = FF.titleCase(session);
        term = FF.titleCase(term);
        amountpaid =amountpaid;
        regno = regno;      
        paymenttype = "Bank";
        status = "Active";
        name = FF.titleCase(name);
        level = FF.titleCase(level);
        classcode = classcode;
        tuitionfee = tuitionfee;
        telanumber = telanumber;
        double finalbalance = balance - amountpaid;
         balance = finalbalance;
        Date date1 = new Date();
        SimpleDateFormat x = new SimpleDateFormat("E @ hh:mm a");
        String time = x.format(date1);
        bank =FF.titleCase(bank);
        datetime=FF.titleCase(time);             
        Date date2 = new Date();
        SimpleDateFormat y = new SimpleDateFormat("dd/MM/yyyy");
        String finaldate = y.format(date2);
        todaydate = FF.titleCase(finaldate);
                int count=FF.count();
                pin = FF.Feespin(count);
                pin = pin;
                double checkpayment = dc.checkBalance2(regno);
                if(amountpaid > checkpayment){
                    try {
                    msg="The entered amount is greater than the standing fee";
                return "bankSearch.jsf";              
                    }catch(Exception e){}
                    } else
                if (amountpaid<=checkpayment){
                    try{
                FF.updateFeespayment2(amountpaid, regno, finalbalance, paymenttype, telanumber, status, time, finaldate, pin, bank);
                FF.createFeeshistory2(session, term, amountpaid, regno, balance, paymenttype, telanumber, status, name, level, classcode, tuitionfee, datetime, todaydate, bank, pictureurl, pin);            
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", pictureurl);
                //if (pictureurl != null) {
                return "newfeesReciept.jsf";
               // }
                }catch (Exception e){}             
            }                      
        return "";
    }
    
    public void DeletePrepared(String regno){
        FF.removeByRegno(regno);
    
    } 
        public void findBydate(){
   this.getDayofSales();
    }
      
    public String feesReceipt( String datepaid) {
        try{
        pictureurl=pictureurl;
        session = FF.titleCase(session);
        term = FF.titleCase(term);
        amountpaid =amountpaid;
        regno = regno;      
        paymenttype = FF.titleCase(paymenttype);
        name = FF.titleCase(name);
        level = FF.titleCase(level);
        classcode = classcode;
        tuitionfee = tuitionfee;
        telanumber = telanumber;
        balance = balance;
        Date date1 = new Date();
        SimpleDateFormat x = new SimpleDateFormat("E @ hh:mm a");
        String time = x.format(date1);
        datetime=FF.titleCase(time);        
        Date date2 = new Date();
        SimpleDateFormat y = new SimpleDateFormat("dd/MM/yyyy");
        String finaldate = y.format(date2);
        todaydate = FF.titleCase(finaldate);
        }catch(Exception e){}; 
        return "newfeesReciept.jsf";     
    }
    public void deleteTransaction(){
  dc.DeleteFeespayment();
  }
    
    
    
    
}
