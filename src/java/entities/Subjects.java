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
@Table(name = "subjects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subjects.findAll", query = "SELECT s FROM Subjects s")
    , @NamedQuery(name = "Subjects.findBySubjectcode", query = "SELECT s FROM Subjects s WHERE s.subjectcode = :subjectcode")
    , @NamedQuery(name = "Subjects.findBySubjectname", query = "SELECT s FROM Subjects s WHERE s.subjectname = :subjectname")
    , @NamedQuery(name = "Subjects.findByLevel", query = "SELECT s FROM Subjects s WHERE s.level = :level")
     , @NamedQuery(name = "Subjects.deleteBySubjectcode", query = "DELETE  FROM Subjects s WHERE s.subjectcode = :subjectcode")      
    , @NamedQuery(name = "Subjects.findByCategory", query = "SELECT s FROM Subjects s WHERE s.category = :category")})
public class Subjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "subjectcode")
    private String subjectcode;
    @Size(max = 45)
    @Column(name = "subjectname")
    private String subjectname;
    @Size(max = 45)
    @Column(name = "level")
    private String level;
    @Size(max = 45)
    @Column(name = "category")
    private String category;

    public Subjects() {
    }

    public Subjects(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectcode != null ? subjectcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subjects)) {
            return false;
        }
        Subjects other = (Subjects) object;
        if ((this.subjectcode == null && other.subjectcode != null) || (this.subjectcode != null && !this.subjectcode.equals(other.subjectcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        return "entities.Subjects[ subjectcode=" + subjectcode + " ]";
    }
    
}
