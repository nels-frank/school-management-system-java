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
@Table(name = "annual")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Annual.findAll", query = "SELECT a FROM Annual a")
    , @NamedQuery(name = "Annual.findByRegno", query = "SELECT a FROM Annual a WHERE a.regno = :regno")
    , @NamedQuery(name = "Annual.findByName", query = "SELECT a FROM Annual a WHERE a.name = :name")
    , @NamedQuery(name = "Annual.findByFinaltotal", query = "SELECT a FROM Annual a WHERE a.finaltotal = :finaltotal")
    , @NamedQuery(name = "Annual.findByFinalaverage", query = "SELECT a FROM Annual a WHERE a.finalaverage = :finalaverage")
    , @NamedQuery(name = "Annual.findByClassposition", query = "SELECT a FROM Annual a WHERE a.classposition = :classposition")
    , @NamedQuery(name = "Annual.findByRemark", query = "SELECT a FROM Annual a WHERE a.remark = :remark")
    , @NamedQuery(name = "Annual.findByClasscode", query = "SELECT a FROM Annual a WHERE a.classcode = :classcode")
    , @NamedQuery(name = "Annual.findByTerm", query = "SELECT a FROM Annual a WHERE a.term = :term")
    , @NamedQuery(name = "Annual.findByAcasession", query = "SELECT a FROM Annual a WHERE a.acasession = :acasession")
    , @NamedQuery(name = "Annual.findByLevelposition", query = "SELECT a FROM Annual a WHERE a.levelposition = :levelposition")
    , @NamedQuery(name = "Annual.findByLevel", query = "SELECT a FROM Annual a WHERE a.level = :level")
    , @NamedQuery(name = "Annual.findByJuniorposition", query = "SELECT a FROM Annual a WHERE a.juniorposition = :juniorposition")
    , @NamedQuery(name = "Annual.findBySeniorposition", query = "SELECT a FROM Annual a WHERE a.seniorposition = :seniorposition")
    , @NamedQuery(name = "Annual.findByOverallposition", query = "SELECT a FROM Annual a WHERE a.overallposition = :overallposition")
    , @NamedQuery(name = "Annual.findByClassstatus", query = "SELECT a FROM Annual a WHERE a.classstatus = :classstatus")
    , @NamedQuery(name = "Annual.findByLevelstatus", query = "SELECT a FROM Annual a WHERE a.levelstatus = :levelstatus")
    , @NamedQuery(name = "Annual.findByJuniorstatus", query = "SELECT a FROM Annual a WHERE a.juniorstatus = :juniorstatus")
    , @NamedQuery(name = "Annual.findBySeniorstatus", query = "SELECT a FROM Annual a WHERE a.seniorstatus = :seniorstatus")
    , @NamedQuery(name = "Annual.deleteByRegno", query = "DELETE FROM Annual a WHERE a.regno = :regno")
    , @NamedQuery(name = "Annual.findByOverallstatus", query = "SELECT a FROM Annual a WHERE a.overallstatus = :overallstatus")
    , @NamedQuery(name = "Annual.findBySex", query = "SELECT a FROM Annual a WHERE a.sex = :sex")})
public class Annual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "regno")
    private String regno;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "finaltotal")
    private Integer finaltotal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "finalaverage")
    private Double finalaverage;
    @Size(max = 45)
    @Column(name = "classposition")
    private String classposition;
    @Size(max = 45)
    @Column(name = "remark")
    private String remark;
    @Size(max = 45)
    @Column(name = "classcode")
    private String classcode;
    @Size(max = 45)
    @Column(name = "term")
    private String term;
    @Size(max = 45)
    @Column(name = "acasession")
    private String acasession;
    @Size(max = 45)
    @Column(name = "levelposition")
    private String levelposition;
    @Size(max = 45)
    @Column(name = "level")
    private String level;
    @Size(max = 45)
    @Column(name = "juniorposition")
    private String juniorposition;
    @Size(max = 45)
    @Column(name = "seniorposition")
    private String seniorposition;
    @Size(max = 45)
    @Column(name = "overallposition")
    private String overallposition;
    @Size(max = 45)
    @Column(name = "classstatus")
    private String classstatus;
    @Size(max = 45)
    @Column(name = "levelstatus")
    private String levelstatus;
    @Size(max = 45)
    @Column(name = "juniorstatus")
    private String juniorstatus;
    @Size(max = 45)
    @Column(name = "seniorstatus")
    private String seniorstatus;
    @Size(max = 45)
    @Column(name = "overallstatus")
    private String overallstatus;
    @Size(max = 45)
    @Column(name = "sex")
    private String sex;

    public Annual() {
    }

    public Annual(String regno) {
        this.regno = regno;
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

    public Integer getFinaltotal() {
        return finaltotal;
    }

    public void setFinaltotal(Integer finaltotal) {
        this.finaltotal = finaltotal;
    }

    public Double getFinalaverage() {
        return finalaverage;
    }

    public void setFinalaverage(Double finalaverage) {
        this.finalaverage = finalaverage;
    }

    public String getClassposition() {
        return classposition;
    }

    public void setClassposition(String classposition) {
        this.classposition = classposition;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getAcasession() {
        return acasession;
    }

    public void setAcasession(String acasession) {
        this.acasession = acasession;
    }

    public String getLevelposition() {
        return levelposition;
    }

    public void setLevelposition(String levelposition) {
        this.levelposition = levelposition;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getJuniorposition() {
        return juniorposition;
    }

    public void setJuniorposition(String juniorposition) {
        this.juniorposition = juniorposition;
    }

    public String getSeniorposition() {
        return seniorposition;
    }

    public void setSeniorposition(String seniorposition) {
        this.seniorposition = seniorposition;
    }

    public String getOverallposition() {
        return overallposition;
    }

    public void setOverallposition(String overallposition) {
        this.overallposition = overallposition;
    }

    public String getClassstatus() {
        return classstatus;
    }

    public void setClassstatus(String classstatus) {
        this.classstatus = classstatus;
    }

    public String getLevelstatus() {
        return levelstatus;
    }

    public void setLevelstatus(String levelstatus) {
        this.levelstatus = levelstatus;
    }

    public String getJuniorstatus() {
        return juniorstatus;
    }

    public void setJuniorstatus(String juniorstatus) {
        this.juniorstatus = juniorstatus;
    }

    public String getSeniorstatus() {
        return seniorstatus;
    }

    public void setSeniorstatus(String seniorstatus) {
        this.seniorstatus = seniorstatus;
    }

    public String getOverallstatus() {
        return overallstatus;
    }

    public void setOverallstatus(String overallstatus) {
        this.overallstatus = overallstatus;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regno != null ? regno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Annual)) {
            return false;
        }
        Annual other = (Annual) object;
        if ((this.regno == null && other.regno != null) || (this.regno != null && !this.regno.equals(other.regno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Annual[ regno=" + regno + " ]";
    }
    
}
