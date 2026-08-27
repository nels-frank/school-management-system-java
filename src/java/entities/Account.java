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
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByDayofpayment", query = "SELECT a FROM Account a WHERE a.dayofpayment = :dayofpayment")
    , @NamedQuery(name = "Account.findByTimeofpayment", query = "SELECT a FROM Account a WHERE a.timeofpayment = :timeofpayment")
    , @NamedQuery(name = "Account.findByFeesamount", query = "SELECT a FROM Account a WHERE a.feesamount = :feesamount")
    , @NamedQuery(name = "Account.findByExpensesamount", query = "SELECT a FROM Account a WHERE a.expensesamount = :expensesamount")
    , @NamedQuery(name = "Account.findByDailysaved", query = "SELECT a FROM Account a WHERE a.dailysaved = :dailysaved")
    , @NamedQuery(name = "Account.findByTerm", query = "SELECT a FROM Account a WHERE a.term = :term")
    , @NamedQuery(name = "Account.findBySessionsAndTerm", query = "SELECT a FROM Account a WHERE a.sessions = :sessions AND a.term=:term")
    , @NamedQuery(name = "Account.deleteByDayofpayment", query = "DELETE  FROM Account a WHERE a.dayofpayment = :dayofpayment")
    , @NamedQuery(name = "Account.findBySessions", query = "SELECT a FROM Account a WHERE a.sessions = :sessions")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dayofpayment")
    private String dayofpayment;
    @Size(max = 45)
    @Column(name = "timeofpayment")
    private String timeofpayment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "feesamount")
    private Double feesamount;
    @Column(name = "expensesamount")
    private Double expensesamount;
    @Column(name = "dailysaved")
    private Double dailysaved;
    @Size(max = 45)
    @Column(name = "term")
    private String term;
    @Size(max = 45)
    @Column(name = "sessions")
    private String sessions;

    public Account() {
    }

    public Account(String dayofpayment) {
        this.dayofpayment = dayofpayment;
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

    public Double getFeesamount() {
        return feesamount;
    }

    public void setFeesamount(Double feesamount) {
        this.feesamount = feesamount;
    }

    public Double getExpensesamount() {
        return expensesamount;
    }

    public void setExpensesamount(Double expensesamount) {
        this.expensesamount = expensesamount;
    }

    public Double getDailysaved() {
        return dailysaved;
    }

    public void setDailysaved(Double dailysaved) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dayofpayment != null ? dayofpayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.dayofpayment == null && other.dayofpayment != null) || (this.dayofpayment != null && !this.dayofpayment.equals(other.dayofpayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Account[ dayofpayment=" + dayofpayment + " ]";
    }
    
}
