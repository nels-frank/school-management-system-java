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
@Table(name = "statelga")
@XmlRootElement
@NamedQueries({
      @NamedQuery(name = "Statelga.findAll", query = "SELECT s FROM Statelga s")
    , @NamedQuery(name = "Statelga.findByStatecodes", query = "SELECT s FROM Statelga s WHERE s.statecodes = :statecodes")
    , @NamedQuery(name = "Statelga.findByLga", query = "SELECT s FROM Statelga s WHERE s.lga = :lga")
    , @NamedQuery(name = "Statelga.findByStates", query = "SELECT s FROM Statelga s WHERE s.states = :states")
    , @NamedQuery(name = "Statelga.findByStatus", query = "SELECT s FROM Statelga s WHERE s.status = :status")})
public class Statelga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "statecodes")
    private String statecodes;
    @Size(max = 45)
    @Column(name = "lga")
    private String lga;
    @Size(max = 45)
    @Column(name = "states")
    private String states;
    @Size(max = 45)
    @Column(name = "status")
    private String status;

    public Statelga() {
    }

    public Statelga(String statecodes) {
        this.statecodes = statecodes;
    }

    public String getStatecodes() {
        return statecodes;
    }

    public void setStatecodes(String statecodes) {
        this.statecodes = statecodes;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statecodes != null ? statecodes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statelga)) {
            return false;
        }
        Statelga other = (Statelga) object;
        if ((this.statecodes == null && other.statecodes != null) || (this.statecodes != null && !this.statecodes.equals(other.statecodes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Statelga[ statecodes=" + statecodes + " ]";
    }
    
}
