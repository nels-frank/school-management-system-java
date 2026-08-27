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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adzua Frank
 */
@Entity
@Table(name = "expenditure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expenditure.findAll", query = "SELECT e FROM Expenditure e")
    , @NamedQuery(name = "Expenditure.findBySn", query = "SELECT e FROM Expenditure e WHERE e.sn = :sn")
    , @NamedQuery(name = "Expenditure.findBySessions", query = "SELECT e FROM Expenditure e WHERE e.sessions = :sessions")
    , @NamedQuery(name = "Expenditure.findByTerm", query = "SELECT e FROM Expenditure e WHERE e.term = :term")
    , @NamedQuery(name = "Expenditure.findByDiscription", query = "SELECT e FROM Expenditure e WHERE e.discription = :discription")
    , @NamedQuery(name = "Expenditure.findByDate", query = "SELECT e FROM Expenditure e WHERE e.date = :date")
    , @NamedQuery(name = "Expenditure.findByTime", query = "SELECT e FROM Expenditure e WHERE e.time = :time")
    , @NamedQuery(name = "Expenditure.deleteBySn", query = "DELETE  FROM Expenditure e WHERE e.sn = :sn")
    , @NamedQuery(name = "Expenditure.findBySessionsAndTerm", query = "SELECT e FROM Expenditure e WHERE e.sessions = :sessions AND e.term=:term")
    , @NamedQuery(name = "Expenditure.findByAmount", query = "SELECT e FROM Expenditure e WHERE e.amount = :amount")})
public class Expenditure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sn")
    private Integer sn;
    @Size(max = 45)
    @Column(name = "sessions")
    private String sessions;
    @Size(max = 45)
    @Column(name = "term")
    private String term;
    @Size(max = 200)
    @Column(name = "discription")
    private String discription;
    @Size(max = 45)
    @Column(name = "date")
    private String date;
    @Size(max = 45)
    @Column(name = "time")
    private String time;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;

    public Expenditure() {
    }

    public Expenditure(Integer sn) {
        this.sn = sn;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
        if (!(object instanceof Expenditure)) {
            return false;
        }
        Expenditure other = (Expenditure) object;
        if ((this.sn == null && other.sn != null) || (this.sn != null && !this.sn.equals(other.sn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Expenditure[ sn=" + sn + " ]";
    }
    
}
