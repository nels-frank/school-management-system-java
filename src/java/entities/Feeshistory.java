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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "feeshistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feeshistory.findAll", query = "SELECT f FROM Feeshistory f")
    , @NamedQuery(name = "Feeshistory.findBySession", query = "SELECT f FROM Feeshistory f WHERE f.session = :session")
    , @NamedQuery(name = "Feeshistory.findByTerm", query = "SELECT f FROM Feeshistory f WHERE f.term = :term")
    , @NamedQuery(name = "Feeshistory.findByAmountpaid", query = "SELECT f FROM Feeshistory f WHERE f.amountpaid = :amountpaid")
    , @NamedQuery(name = "Feeshistory.findByRegno", query = "SELECT f FROM Feeshistory f WHERE f.regno = :regno")
    , @NamedQuery(name = "Feeshistory.findByBalance", query = "SELECT f FROM Feeshistory f WHERE f.balance = :balance")
    , @NamedQuery(name = "Feeshistory.findByPaymenttype", query = "SELECT f FROM Feeshistory f WHERE f.paymenttype = :paymenttype")
    , @NamedQuery(name = "Feeshistory.findByTelanumber", query = "SELECT f FROM Feeshistory f WHERE f.telanumber = :telanumber")
    , @NamedQuery(name = "Feeshistory.findByStatus", query = "SELECT f FROM Feeshistory f WHERE f.status = :status")
    , @NamedQuery(name = "Feeshistory.findByName", query = "SELECT f FROM Feeshistory f WHERE f.name = :name")
    , @NamedQuery(name = "Feeshistory.findByClasslevel", query = "SELECT f FROM Feeshistory f WHERE f.classlevel = :classlevel")
    , @NamedQuery(name = "Feeshistory.findByClassoption", query = "SELECT f FROM Feeshistory f WHERE f.classoption = :classoption")
    , @NamedQuery(name = "Feeshistory.findByTuitionfee", query = "SELECT f FROM Feeshistory f WHERE f.tuitionfee = :tuitionfee")
    , @NamedQuery(name = "Feeshistory.findByDatetime", query = "SELECT f FROM Feeshistory f WHERE f.datetime = :datetime")
    , @NamedQuery(name = "Feeshistory.findByDate", query = "SELECT f FROM Feeshistory f WHERE f.date = :date")
    , @NamedQuery(name = "Feeshistory.findBySn", query = "SELECT f FROM Feeshistory f WHERE f.sn = :sn")
    , @NamedQuery(name = "Feeshistory.findByBank", query = "SELECT f FROM Feeshistory f WHERE f.bank = :bank")
    , @NamedQuery(name = "Feeshistory.findByPictureurl", query = "SELECT f FROM Feeshistory f WHERE f.pictureurl = :pictureurl")
    , @NamedQuery(name = "Feeshistory.deleteBySn", query = "DELETE  FROM Feeshistory f WHERE f.sn = :sn")
    , @NamedQuery(name = "Feeshistory.findByPin", query = "SELECT f FROM Feeshistory f WHERE f.pin = :pin")})
public class Feeshistory implements Serializable {

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
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "classlevel")
    private String classlevel;
    @Size(max = 50)
    @Column(name = "classoption")
    private String classoption;
    @Column(name = "tuitionfee")
    private Double tuitionfee;
    @Size(max = 50)
    @Column(name = "datetime")
    private String datetime;
    @Size(max = 45)
    @Column(name = "date")
    private String date;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sn")
    private Integer sn;
    @Size(max = 100)
    @Column(name = "bank")
    private String bank;
    @Size(max = 500)
    @Column(name = "pictureurl")
    private String pictureurl;
    @Size(max = 45)
    @Column(name = "pin")
    private String pin;

    public Feeshistory() {
    }

    public Feeshistory(Integer sn) {
        this.sn = sn;
    }

    public Feeshistory(Integer sn, String regno) {
        this.sn = sn;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sn != null ? sn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feeshistory)) {
            return false;
        }
        Feeshistory other = (Feeshistory) object;
        if ((this.sn == null && other.sn != null) || (this.sn != null && !this.sn.equals(other.sn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Feeshistory[ sn=" + sn + " ]";
    }
    
}
