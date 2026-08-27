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
@Table(name = "computeresult")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Computeresult.findAll", query = "SELECT c FROM Computeresult c")
    , @NamedQuery(name = "Computeresult.findByComputecode", query = "SELECT c FROM Computeresult c WHERE c.computecode = :computecode")
    , @NamedQuery(name = "Computeresult.findByRegno", query = "SELECT c FROM Computeresult c WHERE c.regno = :regno")
    , @NamedQuery(name = "Computeresult.findByName", query = "SELECT c FROM Computeresult c WHERE c.name = :name")
    , @NamedQuery(name = "Computeresult.findBySubjects", query = "SELECT c FROM Computeresult c WHERE c.subjects = :subjects")
    , @NamedQuery(name = "Computeresult.findBySubjectnumber", query = "SELECT c FROM Computeresult c WHERE c.subjectnumber = :subjectnumber")
    , @NamedQuery(name = "Computeresult.findByAss1", query = "SELECT c FROM Computeresult c WHERE c.ass1 = :ass1")
    , @NamedQuery(name = "Computeresult.findByAss2", query = "SELECT c FROM Computeresult c WHERE c.ass2 = :ass2")
    , @NamedQuery(name = "Computeresult.findByTest1", query = "SELECT c FROM Computeresult c WHERE c.test1 = :test1")
    , @NamedQuery(name = "Computeresult.findByAss3", query = "SELECT c FROM Computeresult c WHERE c.ass3 = :ass3")
    , @NamedQuery(name = "Computeresult.findByAss4", query = "SELECT c FROM Computeresult c WHERE c.ass4 = :ass4")
    , @NamedQuery(name = "Computeresult.findByTest2", query = "SELECT c FROM Computeresult c WHERE c.test2 = :test2")
    , @NamedQuery(name = "Computeresult.findByTotal1", query = "SELECT c FROM Computeresult c WHERE c.total1 = :total1")
    , @NamedQuery(name = "Computeresult.findByAss5", query = "SELECT c FROM Computeresult c WHERE c.ass5 = :ass5")
    , @NamedQuery(name = "Computeresult.findByAss6", query = "SELECT c FROM Computeresult c WHERE c.ass6 = :ass6")
    , @NamedQuery(name = "Computeresult.findByTest3", query = "SELECT c FROM Computeresult c WHERE c.test3 = :test3")
    , @NamedQuery(name = "Computeresult.findByExam", query = "SELECT c FROM Computeresult c WHERE c.exam = :exam")
    , @NamedQuery(name = "Computeresult.findByTotal", query = "SELECT c FROM Computeresult c WHERE c.total = :total")
    , @NamedQuery(name = "Computeresult.findByClassavg", query = "SELECT c FROM Computeresult c WHERE c.classavg = :classavg")
    , @NamedQuery(name = "Computeresult.findByHighest", query = "SELECT c FROM Computeresult c WHERE c.highest = :highest")
    , @NamedQuery(name = "Computeresult.findByLowest", query = "SELECT c FROM Computeresult c WHERE c.lowest = :lowest")
    , @NamedQuery(name = "Computeresult.findByPosition", query = "SELECT c FROM Computeresult c WHERE c.position = :position")
    , @NamedQuery(name = "Computeresult.findByMidposition", query = "SELECT c FROM Computeresult c WHERE c.midposition = :midposition")
    , @NamedQuery(name = "Computeresult.findByGrade", query = "SELECT c FROM Computeresult c WHERE c.grade = :grade")
    , @NamedQuery(name = "Computeresult.findByRemark", query = "SELECT c FROM Computeresult c WHERE c.remark = :remark")
    , @NamedQuery(name = "Computeresult.findByLevel", query = "SELECT c FROM Computeresult c WHERE c.level = :level")
    , @NamedQuery(name = "Computeresult.findByClasscode", query = "SELECT c FROM Computeresult c WHERE c.classcode = :classcode")
    , @NamedQuery(name = "Computeresult.findByTerm", query = "SELECT c FROM Computeresult c WHERE c.term = :term")
    , @NamedQuery(name = "Computeresult.findByExamsession", query = "SELECT c FROM Computeresult c WHERE c.examsession = :examsession")
    , @NamedQuery(name = "Computeresult.findByDob", query = "SELECT c FROM Computeresult c WHERE c.dob = :dob")
    , @NamedQuery(name = "Computeresult.findByMidstatus", query = "SELECT c FROM Computeresult c WHERE c.midstatus = :midstatus")
    , @NamedQuery(name = "Computeresult.findByStatus", query = "SELECT c FROM Computeresult c WHERE c.status = :status")
    , @NamedQuery(name = "Computeresult.findByMidremark", query = "SELECT c FROM Computeresult c WHERE c.midremark = :midremark")
    , @NamedQuery(name = "Computeresult.findByMidhighest", query = "SELECT c FROM Computeresult c WHERE c.midhighest = :midhighest")
    , @NamedQuery(name = "Computeresult.findByMidlowest", query = "SELECT c FROM Computeresult c WHERE c.midlowest = :midlowest")
    , @NamedQuery(name = "Computeresult.findByMidpercent", query = "SELECT c FROM Computeresult c WHERE c.midpercent = :midpercent")
    , @NamedQuery(name = "Computeresult.findByMidavg", query = "SELECT c FROM Computeresult c WHERE c.midavg = :midavg")
    , @NamedQuery(name = "Computeresult.findByChecked", query = "SELECT c FROM Computeresult c WHERE c.checked = :checked")
    ,@NamedQuery(name = "Computeresult.findByClassAndSubject", query = "SELECT c FROM Computeresult c WHERE c.classcode= :classcode AND c.subjects= :subjects AND c.examsession= :examsession AND c.term= :term ORDER BY c.name")
    ,@NamedQuery(name = "Computeresult.findByRegnoSessionTerm", query = "SELECT c FROM Computeresult c WHERE c.regno= :regno AND c.examsession= :examsession AND c.term= :term ORDER BY c.name")
    , @NamedQuery(name = "Computeresult.deleteBySubjectsAndClasscode", query = "DELETE FROM Computeresult c WHERE c.subjects = :subjects AND c.classcode=:classcode")
    , @NamedQuery(name = "Computeresult.deleteByRegno", query = "DELETE  FROM Computeresult c WHERE c.regno = :regno")
    , @NamedQuery(name = "Computeresult.findByMidgrade", query = "SELECT c FROM Computeresult c WHERE c.midgrade = :midgrade")
    , @NamedQuery(name = "Computeresult.findBySex", query = "SELECT c FROM Computeresult c WHERE c.sex = :sex")
    ,@NamedQuery(name = "Computeresult.deleteByComputecode", query = "DELETE  FROM Computeresult c WHERE c.computecode = :computecode")
     ,@NamedQuery(name = "Computeresult.findByPictureurl", query = "SELECT c FROM Computeresult c WHERE c.pictureurl = :pictureurl")})
public class Computeresult implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
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
    @Column(name = "subjectnumber")
    private Integer subjectnumber;
    @Column(name = "ass1")
    private Integer ass1;
    @Column(name = "ass2")
    private Integer ass2;
    @Column(name = "test1")
    private Integer test1;
    @Column(name = "ass3")
    private Integer ass3;
    @Column(name = "ass4")
    private Integer ass4;
    @Column(name = "test2")
    private Integer test2;
    @Column(name = "total1")
    private Integer total1;
    @Column(name = "ass5")
    private Integer ass5;
    @Column(name = "ass6")
    private Integer ass6;
    @Column(name = "test3")
    private Integer test3;
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
    @Size(max = 10)
    @Column(name = "midposition")
    private String midposition;
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
    @Column(name = "dob")
    private String dob;
    @Size(max = 45)
    @Column(name = "midstatus")
    private String midstatus;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Size(max = 45)
    @Column(name = "midremark")
    private String midremark;
    @Column(name = "midhighest")
    private Integer midhighest;
    @Column(name = "midlowest")
    private Integer midlowest;
    @Column(name = "midpercent")
    private Integer midpercent;
    @Column(name = "midavg")
    private Double midavg;
    @Size(max = 45)
    @Column(name = "checked")
    private String checked;
    @Size(max = 45)
    @Column(name = "midgrade")
    private String midgrade;
    @Size(max = 45)
    @Column(name = "sex")
    private String sex;
    @Size(max = 225)
    @Column(name = "pictureurl")
    private String pictureurl;

    public Computeresult() {
    }

    public Computeresult(String computecode) {
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

    public Integer getSubjectnumber() {
        return subjectnumber;
    }

    public void setSubjectnumber(Integer subjectnumber) {
        this.subjectnumber = subjectnumber;
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

    public Integer getTest1() {
        return test1;
    }

    public void setTest1(Integer test1) {
        this.test1 = test1;
    }

    public Integer getAss3() {
        return ass3;
    }

    public void setAss3(Integer ass3) {
        this.ass3 = ass3;
    }

    public Integer getAss4() {
        return ass4;
    }

    public void setAss4(Integer ass4) {
        this.ass4 = ass4;
    }

    public Integer getTest2() {
        return test2;
    }

    public void setTest2(Integer test2) {
        this.test2 = test2;
    }

    public Integer getTotal1() {
        return total1;
    }

    public void setTotal1(Integer total1) {
        this.total1 = total1;
    }

    public Integer getAss5() {
        return ass5;
    }

    public void setAss5(Integer ass5) {
        this.ass5 = ass5;
    }

    public Integer getAss6() {
        return ass6;
    }

    public void setAss6(Integer ass6) {
        this.ass6 = ass6;
    }

    public Integer getTest3() {
        return test3;
    }

    public void setTest3(Integer test3) {
        this.test3 = test3;
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

    public String getMidposition() {
        return midposition;
    }

    public void setMidposition(String midposition) {
        this.midposition = midposition;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMidstatus() {
        return midstatus;
    }

    public void setMidstatus(String midstatus) {
        this.midstatus = midstatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMidremark() {
        return midremark;
    }

    public void setMidremark(String midremark) {
        this.midremark = midremark;
    }

    public Integer getMidhighest() {
        return midhighest;
    }

    public void setMidhighest(Integer midhighest) {
        this.midhighest = midhighest;
    }

    public Integer getMidlowest() {
        return midlowest;
    }

    public void setMidlowest(Integer midlowest) {
        this.midlowest = midlowest;
    }

    public Integer getMidpercent() {
        return midpercent;
    }

    public void setMidpercent(Integer midpercent) {
        this.midpercent = midpercent;
    }

    public Double getMidavg() {
        return midavg;
    }

    public void setMidavg(Double midavg) {
        this.midavg = midavg;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getMidgrade() {
        return midgrade;
    }

    public void setMidgrade(String midgrade) {
        this.midgrade = midgrade;
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
        if (!(object instanceof Computeresult)) {
            return false;
        }
        Computeresult other = (Computeresult) object;
        if ((this.computecode == null && other.computecode != null) || (this.computecode != null && !this.computecode.equals(other.computecode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Computeresult[ computecode=" + computecode + " ]";
    }
    
}
