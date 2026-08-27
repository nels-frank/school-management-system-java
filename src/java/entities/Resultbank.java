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
@Table(name = "resultbank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultbank.findAll", query = "SELECT r FROM Resultbank r")
    , @NamedQuery(name = "Resultbank.findByComputecode", query = "SELECT r FROM Resultbank r WHERE r.computecode = :computecode")
    , @NamedQuery(name = "Resultbank.findByRegno", query = "SELECT r FROM Resultbank r WHERE r.regno = :regno")
    , @NamedQuery(name = "Resultbank.findByName", query = "SELECT r FROM Resultbank r WHERE r.name = :name")
    , @NamedQuery(name = "Resultbank.findBySubjects", query = "SELECT r FROM Resultbank r WHERE r.subjects = :subjects")
    , @NamedQuery(name = "Resultbank.findByAss1", query = "SELECT r FROM Resultbank r WHERE r.ass1 = :ass1")
    , @NamedQuery(name = "Resultbank.findByAss2", query = "SELECT r FROM Resultbank r WHERE r.ass2 = :ass2")
    , @NamedQuery(name = "Resultbank.findByAss3", query = "SELECT r FROM Resultbank r WHERE r.ass3 = :ass3")
    , @NamedQuery(name = "Resultbank.findByExam", query = "SELECT r FROM Resultbank r WHERE r.exam = :exam")
    , @NamedQuery(name = "Resultbank.findByTotal", query = "SELECT r FROM Resultbank r WHERE r.total = :total")
    , @NamedQuery(name = "Resultbank.findByClassavg", query = "SELECT r FROM Resultbank r WHERE r.classavg = :classavg")
    , @NamedQuery(name = "Resultbank.findByHighest", query = "SELECT r FROM Resultbank r WHERE r.highest = :highest")
    , @NamedQuery(name = "Resultbank.findByLowest", query = "SELECT r FROM Resultbank r WHERE r.lowest = :lowest")
    , @NamedQuery(name = "Resultbank.findByPosition", query = "SELECT r FROM Resultbank r WHERE r.position = :position")
    , @NamedQuery(name = "Resultbank.findByGrade", query = "SELECT r FROM Resultbank r WHERE r.grade = :grade")
    , @NamedQuery(name = "Resultbank.findByRemark", query = "SELECT r FROM Resultbank r WHERE r.remark = :remark")
    , @NamedQuery(name = "Resultbank.findByLevel", query = "SELECT r FROM Resultbank r WHERE r.level = :level")
    , @NamedQuery(name = "Resultbank.findByClasscode", query = "SELECT r FROM Resultbank r WHERE r.classcode = :classcode")
    , @NamedQuery(name = "Resultbank.findByTerm", query = "SELECT r FROM Resultbank r WHERE r.term = :term")
    , @NamedQuery(name = "Resultbank.findByExamsession", query = "SELECT r FROM Resultbank r WHERE r.examsession = :examsession")
    , @NamedQuery(name = "Resultbank.findBySex", query = "SELECT r FROM Resultbank r WHERE r.sex = :sex")
    , @NamedQuery(name = "Resultbank.deleteByComputecode", query = "DELETE  FROM Resultbank r WHERE r.computecode = :computecode")
    , @NamedQuery(name = "Resultbank.findByExamsessionAndTermAndSubjectsAndClasscode", query = "SELECT r FROM Resultbank r WHERE r.examsession = :examsession AND r.term = :term AND r.subjects = :subjects AND r.classcode = :classcode")
    , @NamedQuery(name = "Resultbank.findByExamsessionAndTermAndRegno", query = "SELECT r FROM Resultbank r WHERE r.examsession = :examsession AND r.term = :term AND r.regno = :regno")
    , @NamedQuery(name = "Resultbank.findByPictureurl", query = "SELECT r FROM Resultbank r WHERE r.pictureurl = :pictureurl")})
public class Resultbank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "computecode")
    private String computecode;
    @Size(max = 45)
    @Column(name = "regno")
    private String regno;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 100)
    @Column(name = "subjects")
    private String subjects;
    @Column(name = "ass1")
    private Integer ass1;
    @Column(name = "ass2")
    private Integer ass2;
    @Column(name = "ass3")
    private Integer ass3;
    @Column(name = "exam")
    private Integer exam;
    @Column(name = "total")
    private Integer total;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "classavg")
    private Double classavg;
    @Column(name = "highest")
    private Integer highest;
    @Column(name = "lowest")
    private Integer lowest;
    @Size(max = 10)
    @Column(name = "position")
    private String position;
    @Size(max = 45)
    @Column(name = "grade")
    private String grade;
    @Size(max = 45)
    @Column(name = "remark")
    private String remark;
    @Size(max = 10)
    @Column(name = "level")
    private String level;
    @Size(max = 45)
    @Column(name = "classcode")
    private String classcode;
    @Size(max = 45)
    @Column(name = "term")
    private String term;
    @Size(max = 45)
    @Column(name = "examsession")
    private String examsession;
    @Size(max = 45)
    @Column(name = "sex")
    private String sex;
    @Size(max = 100)
    @Column(name = "pictureurl")
    private String pictureurl;

    public Resultbank() {
    }

    public Resultbank(String computecode) {
        this.computecode = computecode;
    }

    public String getComputecode() {
        return computecode;
    }

    public void setComputecode(String computecode) {
        this.computecode = computecode;
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

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public Integer getAss1() {
        return ass1;
    }

    public void setAss1(Integer ass1) {
        this.ass1 = ass1;
    }

    public Integer getAss2() {
        return ass2;
    }

    public void setAss2(Integer ass2) {
        this.ass2 = ass2;
    }

    public Integer getAss3() {
        return ass3;
    }

    public void setAss3(Integer ass3) {
        this.ass3 = ass3;
    }

    public Integer getExam() {
        return exam;
    }

    public void setExam(Integer exam) {
        this.exam = exam;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Double getClassavg() {
        return classavg;
    }

    public void setClassavg(Double classavg) {
        this.classavg = classavg;
    }

    public Integer getHighest() {
        return highest;
    }

    public void setHighest(Integer highest) {
        this.highest = highest;
    }

    public Integer getLowest() {
        return lowest;
    }

    public void setLowest(Integer lowest) {
        this.lowest = lowest;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (computecode != null ? computecode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultbank)) {
            return false;
        }
        Resultbank other = (Resultbank) object;
        if ((this.computecode == null && other.computecode != null) || (this.computecode != null && !this.computecode.equals(other.computecode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Resultbank[ computecode=" + computecode + " ]";
    }
    
}
