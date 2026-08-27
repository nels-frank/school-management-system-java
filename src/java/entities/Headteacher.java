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
@Table(name = "headteacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Headteacher.findAll", query = "SELECT h FROM Headteacher h")
    , @NamedQuery(name = "Headteacher.findByStaffcode", query = "SELECT h FROM Headteacher h WHERE h.staffcode = :staffcode")
    , @NamedQuery(name = "Headteacher.findBySession", query = "SELECT h FROM Headteacher h WHERE h.session = :session")
    , @NamedQuery(name = "Headteacher.findByTerm", query = "SELECT h FROM Headteacher h WHERE h.term = :term")
    , @NamedQuery(name = "Headteacher.findByHeadname", query = "SELECT h FROM Headteacher h WHERE h.headname = :headname")})
public class Headteacher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "staffcode")
    private String staffcode;
    @Size(max = 45)
    @Column(name = "session")
    private String session;
    @Size(max = 45)
    @Column(name = "term")
    private String term;
    @Size(max = 45)
    @Column(name = "headname")
    private String headname;

    public Headteacher() {
    }

    public Headteacher(String staffcode) {
        this.staffcode = staffcode;
    }

    public String getStaffcode() {
        return staffcode;
    }

    public void setStaffcode(String staffcode) {
        this.staffcode = staffcode;
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

    public String getHeadname() {
        return headname;
    }

    public void setHeadname(String headname) {
        this.headname = headname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffcode != null ? staffcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Headteacher)) {
            return false;
        }
        Headteacher other = (Headteacher) object;
        if ((this.staffcode == null && other.staffcode != null) || (this.staffcode != null && !this.staffcode.equals(other.staffcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Headteacher[ staffcode=" + staffcode + " ]";
    }
    
}
