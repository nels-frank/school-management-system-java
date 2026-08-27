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
@Table(name = "classreport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classreport.findAll", query = "SELECT c FROM Classreport c")
    , @NamedQuery(name = "Classreport.findByRegno", query = "SELECT c FROM Classreport c WHERE c.regno = :regno")
    , @NamedQuery(name = "Classreport.findByName", query = "SELECT c FROM Classreport c WHERE c.name = :name")
    , @NamedQuery(name = "Classreport.findByTotal", query = "SELECT c FROM Classreport c WHERE c.total = :total")
    , @NamedQuery(name = "Classreport.findByAverage", query = "SELECT c FROM Classreport c WHERE c.average = :average")
    , @NamedQuery(name = "Classreport.findByClassposition", query = "SELECT c FROM Classreport c WHERE c.classposition = :classposition")
    , @NamedQuery(name = "Classreport.findByRemark", query = "SELECT c FROM Classreport c WHERE c.remark = :remark")
    , @NamedQuery(name = "Classreport.findByClasscode", query = "SELECT c FROM Classreport c WHERE c.classcode = :classcode")
    , @NamedQuery(name = "Classreport.findByTerm", query = "SELECT c FROM Classreport c WHERE c.term = :term")
    , @NamedQuery(name = "Classreport.findByAcasession", query = "SELECT c FROM Classreport c WHERE c.acasession = :acasession")
    , @NamedQuery(name = "Classreport.findByLevelposition", query = "SELECT c FROM Classreport c WHERE c.levelposition = :levelposition")
    , @NamedQuery(name = "Classreport.findByLevel", query = "SELECT c FROM Classreport c WHERE c.level = :level")
    , @NamedQuery(name = "Classreport.findByJuniorposition", query = "SELECT c FROM Classreport c WHERE c.juniorposition = :juniorposition")
    , @NamedQuery(name = "Classreport.findBySeniorposition", query = "SELECT c FROM Classreport c WHERE c.seniorposition = :seniorposition")
    , @NamedQuery(name = "Classreport.findByOverallposition", query = "SELECT c FROM Classreport c WHERE c.overallposition = :overallposition")
    , @NamedQuery(name = "Classreport.findByClassstatus", query = "SELECT c FROM Classreport c WHERE c.classstatus = :classstatus")
    , @NamedQuery(name = "Classreport.findByLevelstatus", query = "SELECT c FROM Classreport c WHERE c.levelstatus = :levelstatus")
    , @NamedQuery(name = "Classreport.findByJuniorstatus", query = "SELECT c FROM Classreport c WHERE c.juniorstatus = :juniorstatus")
    , @NamedQuery(name = "Classreport.findBySeniorstatus", query = "SELECT c FROM Classreport c WHERE c.seniorstatus = :seniorstatus")
    , @NamedQuery(name = "Classreport.findByOverallstatus", query = "SELECT c FROM Classreport c WHERE c.overallstatus = :overallstatus")
    , @NamedQuery(name = "Classreport.findBySex", query = "SELECT c FROM Classreport c WHERE c.sex = :sex")
    , @NamedQuery(name = "Classreport.findByPictureurl", query = "SELECT c FROM Classreport c WHERE c.pictureurl = :pictureurl")
    , @NamedQuery(name = "Classreport.findByMinNumber", query = "SELECT c FROM Classreport c WHERE c.minNumber = :minNumber")
    , @NamedQuery(name = "Classreport.findByMax", query = "SELECT c FROM Classreport c WHERE c.max = :max")
    , @NamedQuery(name = "Classreport.findByPresence", query = "SELECT c FROM Classreport c WHERE c.presence = :presence")
    , @NamedQuery(name = "Classreport.findByAbsence", query = "SELECT c FROM Classreport c WHERE c.absence = :absence")
    , @NamedQuery(name = "Classreport.findByNextermbegin", query = "SELECT c FROM Classreport c WHERE c.nextermbegin = :nextermbegin")
    , @NamedQuery(name = "Classreport.findByNextermfees", query = "SELECT c FROM Classreport c WHERE c.nextermfees = :nextermfees")
    , @NamedQuery(name = "Classreport.findByAlertness", query = "SELECT c FROM Classreport c WHERE c.alertness = :alertness")
    , @NamedQuery(name = "Classreport.findByPunctuation", query = "SELECT c FROM Classreport c WHERE c.punctuation = :punctuation")
    , @NamedQuery(name = "Classreport.findByReliability", query = "SELECT c FROM Classreport c WHERE c.reliability = :reliability")
    , @NamedQuery(name = "Classreport.findByInitiativeness", query = "SELECT c FROM Classreport c WHERE c.initiativeness = :initiativeness")
    , @NamedQuery(name = "Classreport.findByLeadership", query = "SELECT c FROM Classreport c WHERE c.leadership = :leadership")
    , @NamedQuery(name = "Classreport.findByCourtesy", query = "SELECT c FROM Classreport c WHERE c.courtesy = :courtesy")
    , @NamedQuery(name = "Classreport.findBySelfcontrol", query = "SELECT c FROM Classreport c WHERE c.selfcontrol = :selfcontrol")
    , @NamedQuery(name = "Classreport.findBySpiritservice", query = "SELECT c FROM Classreport c WHERE c.spiritservice = :spiritservice")
    , @NamedQuery(name = "Classreport.findByPerseverance", query = "SELECT c FROM Classreport c WHERE c.perseverance = :perseverance")
    , @NamedQuery(name = "Classreport.findByConsideration", query = "SELECT c FROM Classreport c WHERE c.consideration = :consideration")
    , @NamedQuery(name = "Classreport.findByTeamspirit", query = "SELECT c FROM Classreport c WHERE c.teamspirit = :teamspirit")
    , @NamedQuery(name = "Classreport.findByFriendlyness", query = "SELECT c FROM Classreport c WHERE c.friendlyness = :friendlyness")
    , @NamedQuery(name = "Classreport.findByHandwritting", query = "SELECT c FROM Classreport c WHERE c.handwritting = :handwritting")
    , @NamedQuery(name = "Classreport.findByFluency", query = "SELECT c FROM Classreport c WHERE c.fluency = :fluency")
    , @NamedQuery(name = "Classreport.findByGames", query = "SELECT c FROM Classreport c WHERE c.games = :games")
    , @NamedQuery(name = "Classreport.findBySports", query = "SELECT c FROM Classreport c WHERE c.sports = :sports")
    , @NamedQuery(name = "Classreport.findByGymnastic", query = "SELECT c FROM Classreport c WHERE c.gymnastic = :gymnastic")
    , @NamedQuery(name = "Classreport.findByHandlingtools", query = "SELECT c FROM Classreport c WHERE c.handlingtools = :handlingtools")
    , @NamedQuery(name = "Classreport.findByDrawing", query = "SELECT c FROM Classreport c WHERE c.drawing = :drawing")})

    public class Classreport implements Serializable {

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
    @Column(name = "total")
    private Integer total;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "average")
    private Double average;
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
    @Size(max = 225)
    @Column(name = "pictureurl")
    private String pictureurl;
    @Column(name = "min_number")
    private Integer minNumber;
    @Column(name = "max")
    private Integer max;
    @Column(name = "presence")
    private Integer presence;
    @Column(name = "absence")
    private Integer absence;
    @Size(max = 45)
    @Column(name = "nextermbegin")
    private String nextermbegin;
    @Size(max = 45)
    @Column(name = "nextermfees")
    private String nextermfees;
    @Column(name = "alertness")
    private Integer alertness;
    @Column(name = "punctuation")
    private Integer punctuation;
    @Column(name = "reliability")
    private Integer reliability;
    @Column(name = "initiativeness")
    private Integer initiativeness;
    @Column(name = "leadership")
    private Integer leadership;
    @Column(name = "courtesy")
    private Integer courtesy;
    @Column(name = "selfcontrol")
    private Integer selfcontrol;
    @Column(name = "spiritservice")
    private Integer spiritservice;
    @Column(name = "perseverance")
    private Integer perseverance;
    @Column(name = "consideration")
    private Integer consideration;
    @Column(name = "teamspirit")
    private Integer teamspirit;
    @Column(name = "friendlyness")
    private Integer friendlyness;
    @Column(name = "handwritting")
    private Integer handwritting;
    @Column(name = "fluency")
    private Integer fluency;
    @Column(name = "games")
    private Integer games;
    @Column(name = "sports")
    private Integer sports;
    @Column(name = "gymnastic")
    private Integer gymnastic;
    @Column(name = "handlingtools")
    private Integer handlingtools;
    @Column(name = "drawing")
    private Integer drawing;

    public Classreport() {
    }

    public Classreport(String regno) {
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
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

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    public Integer getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(Integer minNumber) {
        this.minNumber = minNumber;
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

    public String getNextermbegin() {
        return nextermbegin;
    }

    public void setNextermbegin(String nextermbegin) {
        this.nextermbegin = nextermbegin;
    }

    public String getNextermfees() {
        return nextermfees;
    }

    public void setNextermfees(String nextermfees) {
        this.nextermfees = nextermfees;
    }

    public Integer getAlertness() {
        return alertness;
    }

    public void setAlertness(Integer alertness) {
        this.alertness = alertness;
    }

    public Integer getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(Integer punctuation) {
        this.punctuation = punctuation;
    }

    public Integer getReliability() {
        return reliability;
    }

    public void setReliability(Integer reliability) {
        this.reliability = reliability;
    }

    public Integer getInitiativeness() {
        return initiativeness;
    }

    public void setInitiativeness(Integer initiativeness) {
        this.initiativeness = initiativeness;
    }

    public Integer getLeadership() {
        return leadership;
    }

    public void setLeadership(Integer leadership) {
        this.leadership = leadership;
    }

    public Integer getCourtesy() {
        return courtesy;
    }

    public void setCourtesy(Integer courtesy) {
        this.courtesy = courtesy;
    }

    public Integer getSelfcontrol() {
        return selfcontrol;
    }

    public void setSelfcontrol(Integer selfcontrol) {
        this.selfcontrol = selfcontrol;
    }

    public Integer getSpiritservice() {
        return spiritservice;
    }

    public void setSpiritservice(Integer spiritservice) {
        this.spiritservice = spiritservice;
    }

    public Integer getPerseverance() {
        return perseverance;
    }

    public void setPerseverance(Integer perseverance) {
        this.perseverance = perseverance;
    }

    public Integer getConsideration() {
        return consideration;
    }

    public void setConsideration(Integer consideration) {
        this.consideration = consideration;
    }

    public Integer getTeamspirit() {
        return teamspirit;
    }

    public void setTeamspirit(Integer teamspirit) {
        this.teamspirit = teamspirit;
    }

    public Integer getFriendlyness() {
        return friendlyness;
    }

    public void setFriendlyness(Integer friendlyness) {
        this.friendlyness = friendlyness;
    }

    public Integer getHandwritting() {
        return handwritting;
    }

    public void setHandwritting(Integer handwritting) {
        this.handwritting = handwritting;
    }

    public Integer getFluency() {
        return fluency;
    }

    public void setFluency(Integer fluency) {
        this.fluency = fluency;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getSports() {
        return sports;
    }

    public void setSports(Integer sports) {
        this.sports = sports;
    }

    public Integer getGymnastic() {
        return gymnastic;
    }

    public void setGymnastic(Integer gymnastic) {
        this.gymnastic = gymnastic;
    }

    public Integer getHandlingtools() {
        return handlingtools;
    }

    public void setHandlingtools(Integer handlingtools) {
        this.handlingtools = handlingtools;
    }

    public Integer getDrawing() {
        return drawing;
    }

    public void setDrawing(Integer drawing) {
        this.drawing = drawing;
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
        if (!(object instanceof Classreport)) {
            return false;
        }
        Classreport other = (Classreport) object;
        if ((this.regno == null && other.regno != null) || (this.regno != null && !this.regno.equals(other.regno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Classreport[ regno=" + regno + " ]";
    }
    
}
