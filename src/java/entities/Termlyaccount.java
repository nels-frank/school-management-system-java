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
@Table(name = "termlyaccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Termlyaccount.findAll", query = "SELECT t FROM Termlyaccount t")
    , @NamedQuery(name = "Termlyaccount.findByDayofclosure", query = "SELECT t FROM Termlyaccount t WHERE t.dayofclosure = :dayofclosure")
    , @NamedQuery(name = "Termlyaccount.findByTimeofclosure", query = "SELECT t FROM Termlyaccount t WHERE t.timeofclosure = :timeofclosure")
    , @NamedQuery(name = "Termlyaccount.findByTerm", query = "SELECT t FROM Termlyaccount t WHERE t.term = :term")
    , @NamedQuery(name = "Termlyaccount.findBySessions", query = "SELECT t FROM Termlyaccount t WHERE t.sessions = :sessions")
    , @NamedQuery(name = "Termlyaccount.findByTermlyobtained", query = "SELECT t FROM Termlyaccount t WHERE t.termlyobtained = :termlyobtained")
    , @NamedQuery(name = "Termlyaccount.findByTermlyexpenses", query = "SELECT t FROM Termlyaccount t WHERE t.termlyexpenses = :termlyexpenses")
    , @NamedQuery(name = "Termlyaccount.findByTermlypaidsalary", query = "SELECT t FROM Termlyaccount t WHERE t.termlypaidsalary = :termlypaidsalary")
    , @NamedQuery(name = "Termlyaccount.deleteByDayofclosure", query = "DELETE  FROM Termlyaccount a WHERE a.dayofclosure = :dayofclosure")
    , @NamedQuery(name = "Termlyaccount.findByTookhome", query = "SELECT t FROM Termlyaccount t WHERE t.tookhome = :tookhome")})
public class Termlyaccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dayofclosure")
    private String dayofclosure;
    @Size(max = 45)
    @Column(name = "timeofclosure")
    private String timeofclosure;
    @Size(max = 45)
    @Column(name = "term")
    private String term;
    @Size(max = 45)
    @Column(name = "sessions")
    private String sessions;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "termlyobtained")
    private Double termlyobtained;
    @Column(name = "termlyexpenses")
    private Double termlyexpenses;
    @Column(name = "termlypaidsalary")
    private Double termlypaidsalary;
    @Column(name = "tookhome")
    private Double tookhome;

    public Termlyaccount() {
    }

    public Termlyaccount(String dayofclosure) {
        this.dayofclosure = dayofclosure;
    }

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

    public Double getTermlyobtained() {
        return termlyobtained;
    }

    public void setTermlyobtained(Double termlyobtained) {
        this.termlyobtained = termlyobtained;
    }

    public Double getTermlyexpenses() {
        return termlyexpenses;
    }

    public void setTermlyexpenses(Double termlyexpenses) {
        this.termlyexpenses = termlyexpenses;
    }

    public Double getTermlypaidsalary() {
        return termlypaidsalary;
    }

    public void setTermlypaidsalary(Double termlypaidsalary) {
        this.termlypaidsalary = termlypaidsalary;
    }

    public Double getTookhome() {
        return tookhome;
    }

    public void setTookhome(Double tookhome) {
        this.tookhome = tookhome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dayofclosure != null ? dayofclosure.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Termlyaccount)) {
            return false;
        }
        Termlyaccount other = (Termlyaccount) object;
        if ((this.dayofclosure == null && other.dayofclosure != null) || (this.dayofclosure != null && !this.dayofclosure.equals(other.dayofclosure))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Termlyaccount[ dayofclosure=" + dayofclosure + " ]";
    }
    
}
