/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adzua Frank
 */
@Entity
@Table(name = "feespayment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feespayment.findAll", query = "SELECT f FROM Feespayment f")
    , @NamedQuery(name = "Feespayment.findBySession", query = "SELECT f FROM Feespayment f WHERE f.session = :session")
    , @NamedQuery(name = "Feespayment.findByTerm", query = "SELECT f FROM Feespayment f WHERE f.term = :term")
    , @NamedQuery(name = "Feespayment.findByAmountpaid", query = "SELECT f FROM Feespayment f WHERE f.amountpaid = :amountpaid")
    , @NamedQuery(name = "Feespayment.findByRegno", query = "SELECT f FROM Feespayment f WHERE f.regno = :regno")
    , @NamedQuery(name = "Feespayment.findByBalance", query = "SELECT f FROM Feespayment f WHERE f.balance = :balance")
    , @NamedQuery(name = "Feespayment.findByPaymenttype", query = "SELECT f FROM Feespayment f WHERE f.paymenttype = :paymenttype")
    , @NamedQuery(name = "Feespayment.findByTelanumber", query = "SELECT f FROM Feespayment f WHERE f.telanumber = :telanumber")
    , @NamedQuery(name = "Feespayment.findByStatus", query = "SELECT f FROM Feespayment f WHERE f.status = :status")
    , @NamedQuery(name = "Feespayment.findByName", query = "SELECT f FROM Feespayment f WHERE f.name = :name")
    , @NamedQuery(name = "Feespayment.findByClasslevel", query = "SELECT f FROM Feespayment f WHERE f.classlevel = :classlevel")
    , @NamedQuery(name = "Feespayment.findByClassoption", query = "SELECT f FROM Feespayment f WHERE f.classoption = :classoption")
    , @NamedQuery(name = "Feespayment.findByTuitionfee", query = "SELECT f FROM Feespayment f WHERE f.tuitionfee = :tuitionfee")
    , @NamedQuery(name = "Feespayment.findByDatetime", query = "SELECT f FROM Feespayment f WHERE f.datetime = :datetime")
    , @NamedQuery(name = "Feespayment.findByTodaydate", query = "SELECT f FROM Feespayment f WHERE f.todaydate = :todaydate")
    , @NamedQuery(name = "Feespayment.findByPin", query = "SELECT f FROM Feespayment f WHERE f.pin = :pin")
    , @NamedQuery(name = "Feespayment.findByPictureurl", query = "SELECT f FROM Feespayment f WHERE f.pictureurl = :pictureurl")
    , @NamedQuery(name = "Feespayment.deleteByRegno", query = "DELETE  FROM Feespayment f WHERE f.regno = :regno")
    , @NamedQuery(name = "Feespayment.findByBank", query = "SELECT f FROM Feespayment f WHERE f.bank = :bank")})
public class Feespayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "session")
    private String session;
    @Size(max = 100)
    @Column(name = "term")
    private String term;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amountpaid")
    private Double amountpaid;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "regno")
    private String regno;
    @Column(name = "balance")
    private Double balance;
    @Size(max = 200)
    @Column(name = "paymenttype")
    private String paymenttype;
    @Size(max = 50)
    @Column(name = "telanumber")
    private String telanumber;
    @Size(max = 50)
    @Column(name = "status")
    private String status;
    @Size(max = 200)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "classlevel")
    private String classlevel;
    @Size(max = 100)
    @Column(name = "classoption")
    private String classoption;
    @Column(name = "tuitionfee")
    private Double tuitionfee;
    @Size(max = 100)
    @Column(name = "datetime")
    private String datetime;
    @Size(max = 100)
    @Column(name = "todaydate")
    private String todaydate;
    @Size(max = 100)
    @Column(name = "pin")
    private String pin;
    @Size(max = 500)
    @Column(name = "pictureurl")
    private String pictureurl;
    @Size(max = 70)
    @Column(name = "bank")
    private String bank;

    public Feespayment() {
    }

    public Feespayment(String regno) {
        this.regno = regno;
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

    public Double getAmountpaid() {
        return amountpaid;
    }

    public void setAmountpaid(Double amountpaid) {
        this.amountpaid = amountpaid;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
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

    public String getClasslevel() {
        return classlevel;
    }

    public void setClasslevel(String classlevel) {
        this.classlevel = classlevel;
    }

    public String getClassoption() {
        return classoption;
    }

    public void setClassoption(String classoption) {
        this.classoption = classoption;
    }

    public Double getTuitionfee() {
        return tuitionfee;
    }

    public void setTuitionfee(Double tuitionfee) {
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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regno != null ? regno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feespayment)) {
            return false;
        }
        Feespayment other = (Feespayment) object;
        if ((this.regno == null && other.regno != null) || (this.regno != null && !this.regno.equals(other.regno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Feespayment[ regno=" + regno + " ]";
    }
    
}
