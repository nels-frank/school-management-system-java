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
@Table(name = "sessionaccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sessionaccount.findAll", query = "SELECT s FROM Sessionaccount s")
    , @NamedQuery(name = "Sessionaccount.findByDayofclosure", query = "SELECT s FROM Sessionaccount s WHERE s.dayofclosure = :dayofclosure")
    , @NamedQuery(name = "Sessionaccount.findByTimeofclosure", query = "SELECT s FROM Sessionaccount s WHERE s.timeofclosure = :timeofclosure")
    , @NamedQuery(name = "Sessionaccount.findBySessions", query = "SELECT s FROM Sessionaccount s WHERE s.sessions = :sessions")
    , @NamedQuery(name = "Sessionaccount.findBySessionobtained", query = "SELECT s FROM Sessionaccount s WHERE s.sessionobtained = :sessionobtained")
    , @NamedQuery(name = "Sessionaccount.findBySessionexpenses", query = "SELECT s FROM Sessionaccount s WHERE s.sessionexpenses = :sessionexpenses")
    , @NamedQuery(name = "Sessionaccount.deleteBySessions", query = "DELETE  FROM Sessionaccount s WHERE s.sessions = :sessions") 
    , @NamedQuery(name = "Sessionaccount.findByTookhome", query = "SELECT s FROM Sessionaccount s WHERE s.tookhome = :tookhome")})
public class Sessionaccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "dayofclosure")
    private String dayofclosure;
    @Size(max = 45)
    @Column(name = "timeofclosure")
    private String timeofclosure;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sessions")
    private String sessions;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sessionobtained")
    private Double sessionobtained;
    @Column(name = "sessionexpenses")
    private Double sessionexpenses;
    @Column(name = "tookhome")
    private Double tookhome;

    public Sessionaccount() {
    }

    public Sessionaccount(String sessions) {
        this.sessions = sessions;
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

    public String getSessions() {
        return sessions;
    }

    public void setSessions(String sessions) {
        this.sessions = sessions;
    }

    public Double getSessionobtained() {
        return sessionobtained;
    }

    public void setSessionobtained(Double sessionobtained) {
        this.sessionobtained = sessionobtained;
    }

    public Double getSessionexpenses() {
        return sessionexpenses;
    }

    public void setSessionexpenses(Double sessionexpenses) {
        this.sessionexpenses = sessionexpenses;
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
        hash += (sessions != null ? sessions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sessionaccount)) {
            return false;
        }
        Sessionaccount other = (Sessionaccount) object;
        if ((this.sessions == null && other.sessions != null) || (this.sessions != null && !this.sessions.equals(other.sessions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sessionaccount[ sessions=" + sessions + " ]";
    }
    
}
