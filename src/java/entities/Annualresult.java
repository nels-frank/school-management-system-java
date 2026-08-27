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
@Table(name = "annualresult")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Annualresult.findAll", query = "SELECT a FROM Annualresult a")
    , @NamedQuery(name = "Annualresult.findByResultcode", query = "SELECT a FROM Annualresult a WHERE a.resultcode = :resultcode")
    , @NamedQuery(name = "Annualresult.findByRegno", query = "SELECT a FROM Annualresult a WHERE a.regno = :regno")
    , @NamedQuery(name = "Annualresult.findByName", query = "SELECT a FROM Annualresult a WHERE a.name = :name")
    , @NamedQuery(name = "Annualresult.findBySubject", query = "SELECT a FROM Annualresult a WHERE a.subject = :subject")
    , @NamedQuery(name = "Annualresult.findByFirsttermscore", query = "SELECT a FROM Annualresult a WHERE a.firsttermscore = :firsttermscore")
    , @NamedQuery(name = "Annualresult.findBySecondtermscore", query = "SELECT a FROM Annualresult a WHERE a.secondtermscore = :secondtermscore")
    , @NamedQuery(name = "Annualresult.findByThirdtemscore", query = "SELECT a FROM Annualresult a WHERE a.thirdtemscore = :thirdtemscore")
    , @NamedQuery(name = "Annualresult.findByTotal", query = "SELECT a FROM Annualresult a WHERE a.total = :total")
    , @NamedQuery(name = "Annualresult.findByAvg", query = "SELECT a FROM Annualresult a WHERE a.avg = :avg")
    , @NamedQuery(name = "Annualresult.findByClassavg", query = "SELECT a FROM Annualresult a WHERE a.classavg = :classavg")
    , @NamedQuery(name = "Annualresult.findByHighestavg", query = "SELECT a FROM Annualresult a WHERE a.highestavg = :highestavg")
    , @NamedQuery(name = "Annualresult.findByLowestavg", query = "SELECT a FROM Annualresult a WHERE a.lowestavg = :lowestavg")
    , @NamedQuery(name = "Annualresult.findByPos", query = "SELECT a FROM Annualresult a WHERE a.pos = :pos")
    , @NamedQuery(name = "Annualresult.findByGrade", query = "SELECT a FROM Annualresult a WHERE a.grade = :grade")
    , @NamedQuery(name = "Annualresult.findByRemark", query = "SELECT a FROM Annualresult a WHERE a.remark = :remark")
    , @NamedQuery(name = "Annualresult.findByAcasession", query = "SELECT a FROM Annualresult a WHERE a.acasession = :acasession")
    , @NamedQuery(name = "Annualresult.findByClasscode", query = "SELECT a FROM Annualresult a WHERE a.classcode = :classcode")
    , @NamedQuery(name = "Annualresult.findByLevel", query = "SELECT a FROM Annualresult a WHERE a.level = :level")
    , @NamedQuery(name = "Annualresult.findByAcasessionAndClasscodeAndSubject", query = "SELECT a FROM Annualresult a WHERE a.acasession = :acasession AND a.classcode=:classcode AND a.subject=:subject")
    , @NamedQuery(name = "Annualresult.findByRegnoSession", query = "SELECT a FROM Annualresult a WHERE a.regno = :regno AND a.acasession=:acasession")
    , @NamedQuery(name = "Annualresult.findByStatus", query = "SELECT a FROM Annualresult a WHERE a.status = :status")})
public class Annualresult implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "resultcode")
    private String resultcode;
    @Size(max = 45)
    @Column(name = "regno")
    private String regno;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 100)
    @Column(name = "subject")
    private String subject;
    @Column(name = "firsttermscore")
    private Integer firsttermscore;
    @Column(name = "secondtermscore")
    private Integer secondtermscore;
    @Column(name = "thirdtemscore")
    private Integer thirdtemscore;
    @Column(name = "total")
    private Integer total;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "avg")
    private Double avg;
    @Column(name = "classavg")
    private Double classavg;
    @Column(name = "highestavg")
    private Double highestavg;
    @Column(name = "lowestavg")
    private Double lowestavg;
    @Size(max = 45)
    @Column(name = "pos")
    private String pos;
    @Size(max = 45)
    @Column(name = "grade")
    private String grade;
    @Size(max = 45)
    @Column(name = "remark")
    private String remark;
    @Size(max = 45)
    @Column(name = "acasession")
    private String acasession;
    @Size(max = 45)
    @Column(name = "classcode")
    private String classcode;
    @Size(max = 45)
    @Column(name = "level")
    private String level;
    @Size(max = 45)
    @Column(name = "status")
    private String status;

    public Annualresult() {
    }

    public Annualresult(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getFirsttermscore() {
        return firsttermscore;
    }

    public void setFirsttermscore(Integer firsttermscore) {
        this.firsttermscore = firsttermscore;
    }

    public Integer getSecondtermscore() {
        return secondtermscore;
    }

    public void setSecondtermscore(Integer secondtermscore) {
        this.secondtermscore = secondtermscore;
    }

    public Integer getThirdtemscore() {
        return thirdtemscore;
    }

    public void setThirdtemscore(Integer thirdtemscore) {
        this.thirdtemscore = thirdtemscore;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Double getClassavg() {
        return classavg;
    }

    public void setClassavg(Double classavg) {
        this.classavg = classavg;
    }

    public Double getHighestavg() {
        return highestavg;
    }

    public void setHighestavg(Double highestavg) {
        this.highestavg = highestavg;
    }

    public Double getLowestavg() {
        return lowestavg;
    }

    public void setLowestavg(Double lowestavg) {
        this.lowestavg = lowestavg;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAcasession() {
        return acasession;
    }

    public void setAcasession(String acasession) {
        this.acasession = acasession;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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
        hash += (resultcode != null ? resultcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Annualresult)) {
            return false;
        }
        Annualresult other = (Annualresult) object;
        if ((this.resultcode == null && other.resultcode != null) || (this.resultcode != null && !this.resultcode.equals(other.resultcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Annualresult[ resultcode=" + resultcode + " ]";
    }
    
}
