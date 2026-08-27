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
@Table(name = "mastersheet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mastersheet.findAll", query = "SELECT m FROM Mastersheet m")
    , @NamedQuery(name = "Mastersheet.findByRegno", query = "SELECT m FROM Mastersheet m WHERE m.regno = :regno")
    , @NamedQuery(name = "Mastersheet.findByName", query = "SELECT m FROM Mastersheet m WHERE m.name = :name")
    , @NamedQuery(name = "Mastersheet.findByTerm", query = "SELECT m FROM Mastersheet m WHERE m.term = :term")
    , @NamedQuery(name = "Mastersheet.findByAcasession", query = "SELECT m FROM Mastersheet m WHERE m.acasession = :acasession")
    , @NamedQuery(name = "Mastersheet.findBySub1", query = "SELECT m FROM Mastersheet m WHERE m.sub1 = :sub1")
    , @NamedQuery(name = "Mastersheet.findBySub2", query = "SELECT m FROM Mastersheet m WHERE m.sub2 = :sub2")
    , @NamedQuery(name = "Mastersheet.findBySub3", query = "SELECT m FROM Mastersheet m WHERE m.sub3 = :sub3")
    , @NamedQuery(name = "Mastersheet.findBySub4", query = "SELECT m FROM Mastersheet m WHERE m.sub4 = :sub4")
    , @NamedQuery(name = "Mastersheet.findBySub5", query = "SELECT m FROM Mastersheet m WHERE m.sub5 = :sub5")
    , @NamedQuery(name = "Mastersheet.findBySub6", query = "SELECT m FROM Mastersheet m WHERE m.sub6 = :sub6")
    , @NamedQuery(name = "Mastersheet.findBySub7", query = "SELECT m FROM Mastersheet m WHERE m.sub7 = :sub7")
    , @NamedQuery(name = "Mastersheet.findBySub8", query = "SELECT m FROM Mastersheet m WHERE m.sub8 = :sub8")
    , @NamedQuery(name = "Mastersheet.findBySub9", query = "SELECT m FROM Mastersheet m WHERE m.sub9 = :sub9")
    , @NamedQuery(name = "Mastersheet.findBySub10", query = "SELECT m FROM Mastersheet m WHERE m.sub10 = :sub10")
    , @NamedQuery(name = "Mastersheet.findBySub11", query = "SELECT m FROM Mastersheet m WHERE m.sub11 = :sub11")
    , @NamedQuery(name = "Mastersheet.findBySub12", query = "SELECT m FROM Mastersheet m WHERE m.sub12 = :sub12")
    , @NamedQuery(name = "Mastersheet.findBySub13", query = "SELECT m FROM Mastersheet m WHERE m.sub13 = :sub13")
    , @NamedQuery(name = "Mastersheet.findBySub14", query = "SELECT m FROM Mastersheet m WHERE m.sub14 = :sub14")
    , @NamedQuery(name = "Mastersheet.findBySub15", query = "SELECT m FROM Mastersheet m WHERE m.sub15 = :sub15")
    , @NamedQuery(name = "Mastersheet.findBySub16", query = "SELECT m FROM Mastersheet m WHERE m.sub16 = :sub16")
    , @NamedQuery(name = "Mastersheet.findBySub17", query = "SELECT m FROM Mastersheet m WHERE m.sub17 = :sub17")
    , @NamedQuery(name = "Mastersheet.findBySub18", query = "SELECT m FROM Mastersheet m WHERE m.sub18 = :sub18")
    , @NamedQuery(name = "Mastersheet.findBySub19", query = "SELECT m FROM Mastersheet m WHERE m.sub19 = :sub19")
    , @NamedQuery(name = "Mastersheet.findBySub20", query = "SELECT m FROM Mastersheet m WHERE m.sub20 = :sub20")
    , @NamedQuery(name = "Mastersheet.findByTotal", query = "SELECT m FROM Mastersheet m WHERE m.total = :total")
    , @NamedQuery(name = "Mastersheet.findByAvg", query = "SELECT m FROM Mastersheet m WHERE m.avg = :avg")
    , @NamedQuery(name = "Mastersheet.findByPost", query = "SELECT m FROM Mastersheet m WHERE m.post = :post")
    , @NamedQuery(name = "Mastersheet.findByClasscode", query = "SELECT m FROM Mastersheet m WHERE m.classcode = :classcode")
    , @NamedQuery(name = "Mastersheet.findByLevel", query = "SELECT m FROM Mastersheet m WHERE m.level = :level")
    , @NamedQuery(name = "Mastersheet.findByRemark", query = "SELECT m FROM Mastersheet m WHERE m.remark = :remark")})
public class Mastersheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "regno")
    private String regno;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "term")
    private String term;
    @Size(max = 45)
    @Column(name = "acasession")
    private String acasession;
    @Column(name = "sub1")
    private Integer sub1;
    @Column(name = "sub2")
    private Integer sub2;
    @Column(name = "sub3")
    private Integer sub3;
    @Column(name = "sub4")
    private Integer sub4;
    @Column(name = "sub5")
    private Integer sub5;
    @Column(name = "sub6")
    private Integer sub6;
    @Column(name = "sub7")
    private Integer sub7;
    @Column(name = "sub8")
    private Integer sub8;
    @Column(name = "sub9")
    private Integer sub9;
    @Column(name = "sub10")
    private Integer sub10;
    @Column(name = "sub11")
    private Integer sub11;
    @Column(name = "sub12")
    private Integer sub12;
    @Column(name = "sub13")
    private Integer sub13;
    @Column(name = "sub14")
    private Integer sub14;
    @Column(name = "sub15")
    private Integer sub15;
    @Column(name = "sub16")
    private Integer sub16;
    @Column(name = "sub17")
    private Integer sub17;
    @Column(name = "sub18")
    private Integer sub18;
    @Column(name = "sub19")
    private Integer sub19;
    @Column(name = "sub20")
    private Integer sub20;
    @Column(name = "total")
    private Integer total;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "avg")
    private Double avg;
    @Size(max = 45)
    @Column(name = "post")
    private String post;
    @Size(max = 45)
    @Column(name = "classcode")
    private String classcode;
    @Size(max = 45)
    @Column(name = "level")
    private String level;
    @Size(max = 45)
    @Column(name = "remark")
    private String remark;

    public Mastersheet() {
    }

    public Mastersheet(String regno) {
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

    public Integer getSub1() {
        return sub1;
    }

    public void setSub1(Integer sub1) {
        this.sub1 = sub1;
    }

    public Integer getSub2() {
        return sub2;
    }

    public void setSub2(Integer sub2) {
        this.sub2 = sub2;
    }

    public Integer getSub3() {
        return sub3;
    }

    public void setSub3(Integer sub3) {
        this.sub3 = sub3;
    }

    public Integer getSub4() {
        return sub4;
    }

    public void setSub4(Integer sub4) {
        this.sub4 = sub4;
    }

    public Integer getSub5() {
        return sub5;
    }

    public void setSub5(Integer sub5) {
        this.sub5 = sub5;
    }

    public Integer getSub6() {
        return sub6;
    }

    public void setSub6(Integer sub6) {
        this.sub6 = sub6;
    }

    public Integer getSub7() {
        return sub7;
    }

    public void setSub7(Integer sub7) {
        this.sub7 = sub7;
    }

    public Integer getSub8() {
        return sub8;
    }

    public void setSub8(Integer sub8) {
        this.sub8 = sub8;
    }

    public Integer getSub9() {
        return sub9;
    }

    public void setSub9(Integer sub9) {
        this.sub9 = sub9;
    }

    public Integer getSub10() {
        return sub10;
    }

    public void setSub10(Integer sub10) {
        this.sub10 = sub10;
    }

    public Integer getSub11() {
        return sub11;
    }

    public void setSub11(Integer sub11) {
        this.sub11 = sub11;
    }

    public Integer getSub12() {
        return sub12;
    }

    public void setSub12(Integer sub12) {
        this.sub12 = sub12;
    }

    public Integer getSub13() {
        return sub13;
    }

    public void setSub13(Integer sub13) {
        this.sub13 = sub13;
    }

    public Integer getSub14() {
        return sub14;
    }

    public void setSub14(Integer sub14) {
        this.sub14 = sub14;
    }

    public Integer getSub15() {
        return sub15;
    }

    public void setSub15(Integer sub15) {
        this.sub15 = sub15;
    }

    public Integer getSub16() {
        return sub16;
    }

    public void setSub16(Integer sub16) {
        this.sub16 = sub16;
    }

    public Integer getSub17() {
        return sub17;
    }

    public void setSub17(Integer sub17) {
        this.sub17 = sub17;
    }

    public Integer getSub18() {
        return sub18;
    }

    public void setSub18(Integer sub18) {
        this.sub18 = sub18;
    }

    public Integer getSub19() {
        return sub19;
    }

    public void setSub19(Integer sub19) {
        this.sub19 = sub19;
    }

    public Integer getSub20() {
        return sub20;
    }

    public void setSub20(Integer sub20) {
        this.sub20 = sub20;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        if (!(object instanceof Mastersheet)) {
            return false;
        }
        Mastersheet other = (Mastersheet) object;
        if ((this.regno == null && other.regno != null) || (this.regno != null && !this.regno.equals(other.regno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Mastersheet[ regno=" + regno + " ]";
    }
    
}
