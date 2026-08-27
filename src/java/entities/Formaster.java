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
@Table(name = "formaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formaster.findAll", query = "SELECT f FROM Formaster f")
    , @NamedQuery(name = "Formaster.findBySession", query = "SELECT f FROM Formaster f WHERE f.session = :session")
    , @NamedQuery(name = "Formaster.findByTerm", query = "SELECT f FROM Formaster f WHERE f.term = :term")
    , @NamedQuery(name = "Formaster.findByLevel", query = "SELECT f FROM Formaster f WHERE f.level = :level")
    , @NamedQuery(name = "Formaster.findByClasscode", query = "SELECT f FROM Formaster f WHERE f.classcode = :classcode")
    , @NamedQuery(name = "Formaster.deleteByClasscode", query = "DELETE FROM Formaster f WHERE f.classcode = :classcode")
    , @NamedQuery(name = "Formaster.findByFormame", query = "SELECT f FROM Formaster f WHERE f.formname = :formname")
    , @NamedQuery(name = "Formaster.findBySignurl", query = "SELECT f FROM Formaster f WHERE f.signurl = :signurl")})
public class Formaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "session")
    private String session;
    @Size(max = 45)
    @Column(name = "term")
    private String term;
    @Size(max = 45)
    @Column(name = "level")
    private String level;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "classcode")
    private String classcode;
    @Size(max = 60)
    @Column(name = "formname")
    private String formname;
    @Size(max = 100)
    @Column(name = "signurl")
    private String signurl;
    public Formaster() {
    }

    public Formaster(String classcode) {
        this.classcode = classcode;
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

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    public String getSignurl() {
        return signurl;
    }

    public void setSignurl(String signurl) {
        this.signurl = signurl;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classcode != null ? classcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formaster)) {
            return false;
        }
        Formaster other = (Formaster) object;
        if ((this.classcode == null && other.classcode != null) || (this.classcode != null && !this.classcode.equals(other.classcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    
        return "entities.Formaster[ classcode=" + classcode + " ]";
    }
    
}
