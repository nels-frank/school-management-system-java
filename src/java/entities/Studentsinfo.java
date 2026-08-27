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
@Table(name = "studentsinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentsinfo.findAll", query = "SELECT s FROM Studentsinfo s")
    , @NamedQuery(name = "Studentsinfo.findByRegno", query = "SELECT s FROM Studentsinfo s WHERE s.regno = :regno")
    , @NamedQuery(name = "Studentsinfo.findByFname", query = "SELECT s FROM Studentsinfo s WHERE s.fname = :fname")
    , @NamedQuery(name = "Studentsinfo.findByMname", query = "SELECT s FROM Studentsinfo s WHERE s.mname = :mname")
    , @NamedQuery(name = "Studentsinfo.findByLname", query = "SELECT s FROM Studentsinfo s WHERE s.lname = :lname")
    , @NamedQuery(name = "Studentsinfo.findByState", query = "SELECT s FROM Studentsinfo s WHERE s.state = :state")
    , @NamedQuery(name = "Studentsinfo.findByLga", query = "SELECT s FROM Studentsinfo s WHERE s.lga = :lga")
    , @NamedQuery(name = "Studentsinfo.findBySex", query = "SELECT s FROM Studentsinfo s WHERE s.sex = :sex")
    , @NamedQuery(name = "Studentsinfo.findBySession", query = "SELECT s FROM Studentsinfo s WHERE s.session = :session")
    , @NamedQuery(name = "Studentsinfo.findByLevel", query = "SELECT s FROM Studentsinfo s WHERE s.level = :level")
    , @NamedQuery(name = "Studentsinfo.findByClasscode", query = "SELECT s FROM Studentsinfo s WHERE s.classcode = :classcode")
    , @NamedQuery(name = "Studentsinfo.findByDob", query = "SELECT s FROM Studentsinfo s WHERE s.dob = :dob")
    , @NamedQuery(name = "Studentsinfo.findByHouse", query = "SELECT s FROM Studentsinfo s WHERE s.house = :house")
    , @NamedQuery(name = "Studentsinfo.findByHealthstatus", query = "SELECT s FROM Studentsinfo s WHERE s.healthstatus = :healthstatus")
    , @NamedQuery(name = "Studentsinfo.findByStatus", query = "SELECT s FROM Studentsinfo s WHERE s.status = :status")
    , @NamedQuery(name = "Studentsinfo.findByPictureurl", query = "SELECT s FROM Studentsinfo s WHERE s.pictureurl = :pictureurl")
    , @NamedQuery(name = "Studentsinfo.findByNationality", query = "SELECT s FROM Studentsinfo s WHERE s.nationality = :nationality")
    , @NamedQuery(name = "Studentsinfo.findByTribe", query = "SELECT s FROM Studentsinfo s WHERE s.tribe = :tribe")
    , @NamedQuery(name = "Studentsinfo.findByReligion", query = "SELECT s FROM Studentsinfo s WHERE s.religion = :religion")
    , @NamedQuery(name = "Studentsinfo.findByGuardianoccupation", query = "SELECT s FROM Studentsinfo s WHERE s.guardianoccupation = :guardianoccupation")
    , @NamedQuery(name = "Studentsinfo.findByGuardianaddress", query = "SELECT s FROM Studentsinfo s WHERE s.guardianaddress = :guardianaddress")
    , @NamedQuery(name = "Studentsinfo.findByGuardianname", query = "SELECT s FROM Studentsinfo s WHERE s.guardianname = :guardianname")
    , @NamedQuery(name = "Studentsinfo.findByGuardianno", query = "SELECT s FROM Studentsinfo s WHERE s.guardianno = :guardianno")
    , @NamedQuery(name = "Studentsinfo.findByDate", query = "SELECT s FROM Studentsinfo s WHERE s.date = :date")
    , @NamedQuery(name = "Studentsinfo.findByLschattended", query = "SELECT s FROM Studentsinfo s WHERE s.lschattended = :lschattended")
    , @NamedQuery(name = "Studentsinfo.findByDatefrom", query = "SELECT s FROM Studentsinfo s WHERE s.datefrom = :datefrom")
        , @NamedQuery(name = "Studentsinfo.deleteByRegno", query = "DELETE  FROM Studentsinfo s WHERE s.regno = :regno")
    , @NamedQuery(name = "Studentsinfo.findByDateto", query = "SELECT s FROM Studentsinfo s WHERE s.dateto = :dateto")})
public class Studentsinfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "regno")
    private String regno;
    @Size(max = 45)
    @Column(name = "fname")
    private String fname;
    @Size(max = 45)
    @Column(name = "mname")
    private String mname;
    @Size(max = 45)
    @Column(name = "lname")
    private String lname;
    @Size(max = 45)
    @Column(name = "state")
    private String state;
    @Size(max = 45)
    @Column(name = "lga")
    private String lga;
    @Size(max = 45)
    @Column(name = "sex")
    private String sex;
    @Size(max = 45)
    @Column(name = "session")
    private String session;
    @Size(max = 45)
    @Column(name = "level")
    private String level;
    @Size(max = 45)
    @Column(name = "classcode")
    private String classcode;
    @Size(max = 45)
    @Column(name = "dob")
    private String dob;
    @Size(max = 45)
    @Column(name = "house")
    private String house;
    @Size(max = 100)
    @Column(name = "healthstatus")
    private String healthstatus;
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    @Size(max = 225)
    @Column(name = "pictureurl")
    private String pictureurl;
    @Size(max = 45)
    @Column(name = "nationality")
    private String nationality;
    @Size(max = 45)
    @Column(name = "tribe")
    private String tribe;
    @Size(max = 45)
    @Column(name = "religion")
    private String religion;
    @Size(max = 45)
    @Column(name = "guardianoccupation")
    private String guardianoccupation;
    @Size(max = 45)
    @Column(name = "guardianaddress")
    private String guardianaddress;
    @Size(max = 45)
    @Column(name = "guardianname")
    private String guardianname;
    @Size(max = 45)
    @Column(name = "guardianno")
    private String guardianno;
    @Size(max = 45)
    @Column(name = "date")
    private String date;
    @Size(max = 100)
    @Column(name = "lschattended")
    private String lschattended;
    @Size(max = 45)
    @Column(name = "datefrom")
    private String datefrom;
    @Size(max = 45)
    @Column(name = "dateto")
    private String dateto;

    public Studentsinfo() {
    }

    public Studentsinfo(String regno) {
        this.regno = regno;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getHealthstatus() {
        return healthstatus;
    }

    public void setHealthstatus(String healthstatus) {
        this.healthstatus = healthstatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getGuardianoccupation() {
        return guardianoccupation;
    }

    public void setGuardianoccupation(String guardianoccupation) {
        this.guardianoccupation = guardianoccupation;
    }

    public String getGuardianaddress() {
        return guardianaddress;
    }

    public void setGuardianaddress(String guardianaddress) {
        this.guardianaddress = guardianaddress;
    }

    public String getGuardianname() {
        return guardianname;
    }

    public void setGuardianname(String guardianname) {
        this.guardianname = guardianname;
    }

    public String getGuardianno() {
        return guardianno;
    }

    public void setGuardianno(String guardianno) {
        this.guardianno = guardianno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLschattended() {
        return lschattended;
    }

    public void setLschattended(String lschattended) {
        this.lschattended = lschattended;
    }

    public String getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(String datefrom) {
        this.datefrom = datefrom;
    }

    public String getDateto() {
        return dateto;
    }

    public void setDateto(String dateto) {
        this.dateto = dateto;
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
        if (!(object instanceof Studentsinfo)) {
            return false;
        }
        Studentsinfo other = (Studentsinfo) object;
        if ((this.regno == null && other.regno != null) || (this.regno != null && !this.regno.equals(other.regno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Studentsinfo[ regno=" + regno + " ]";
    }
    
}
