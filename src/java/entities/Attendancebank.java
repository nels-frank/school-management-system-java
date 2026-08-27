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
@Table(name = "attendancebank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendancebank.findAll", query = "SELECT a FROM Attendancebank a")
    , @NamedQuery(name = "Attendancebank.findByAttendancecode", query = "SELECT a FROM Attendancebank a WHERE a.attendancecode = :attendancecode")
    , @NamedQuery(name = "Attendancebank.findByRegno", query = "SELECT a FROM Attendancebank a WHERE a.regno = :regno")
    , @NamedQuery(name = "Attendancebank.findByName", query = "SELECT a FROM Attendancebank a WHERE a.name = :name")
    , @NamedQuery(name = "Attendancebank.findByLevel", query = "SELECT a FROM Attendancebank a WHERE a.level = :level")
    , @NamedQuery(name = "Attendancebank.findByClasscode", query = "SELECT a FROM Attendancebank a WHERE a.classcode = :classcode")
    , @NamedQuery(name = "Attendancebank.findByMax", query = "SELECT a FROM Attendancebank a WHERE a.max = :max")
    , @NamedQuery(name = "Attendancebank.findByPresence", query = "SELECT a FROM Attendancebank a WHERE a.presence = :presence")
    , @NamedQuery(name = "Attendancebank.findByAbsence", query = "SELECT a FROM Attendancebank a WHERE a.absence = :absence")
    , @NamedQuery(name = "Attendancebank.findByTerm", query = "SELECT a FROM Attendancebank a WHERE a.term = :term")
    , @NamedQuery(name = "Attendancebank.findByExamsessionAndTermAndClasscode", query = "SELECT a FROM Attendancebank a WHERE a.examsession = :examsession AND a.term = :term AND a.classcode = :classcode")
    , @NamedQuery(name = "Attendancebank.findByExamsessionAndTermAndRegnoAndName", query = "SELECT a FROM Attendancebank a WHERE a.examsession = :examsession AND a.term = :term AND a.regno = :regno AND a.name=:name")
    , @NamedQuery(name = "Attendancebank.deleteByAttendancecode", query = "DELETE FROM Attendancebank a WHERE a.attendancecode = :attendancecode")
    , @NamedQuery(name = "Attendancebank.findByExamsession", query = "SELECT a FROM Attendancebank a WHERE a.examsession = :examsession")})
public class Attendancebank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "attendancecode")
    private String attendancecode;
    @Size(max = 45)
    @Column(name = "regno")
    private String regno;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "level")
    private String level;
    @Size(max = 45)
    @Column(name = "classcode")
    private String classcode;
    @Column(name = "max")
    private Integer max;
    @Column(name = "presence")
    private Integer presence;
    @Column(name = "absence")
    private Integer absence;
    @Size(max = 45)
    @Column(name = "term")
    private String term;
    @Size(max = 45)
    @Column(name = "examsession")
    private String examsession;

    public Attendancebank() {
    }

    public Attendancebank(String attendancecode) {
        this.attendancecode = attendancecode;
    }

    public String getAttendancecode() {
        return attendancecode;
    }

    public void setAttendancecode(String attendancecode) {
        this.attendancecode = attendancecode;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getPresence() {
        return presence;
    }

    public void setPresence(Integer presence) {
        this.presence = presence;
    }

    public Integer getAbsence() {
        return absence;
    }

    public void setAbsence(Integer absence) {
        this.absence = absence;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getExamsession() {
        return examsession;
    }

    public void setExamsession(String examsession) {
        this.examsession = examsession;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attendancecode != null ? attendancecode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendancebank)) {
            return false;
        }
        Attendancebank other = (Attendancebank) object;
        if ((this.attendancecode == null && other.attendancecode != null) || (this.attendancecode != null && !this.attendancecode.equals(other.attendancecode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Attendancebank[ attendancecode=" + attendancecode + " ]";
    }
    
}
