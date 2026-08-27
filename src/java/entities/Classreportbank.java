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
@Table(name = "classreportbank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classreportbank.findAll", query = "SELECT c FROM Classreportbank c")
    , @NamedQuery(name = "Classreportbank.findByRegno", query = "SELECT c FROM Classreportbank c WHERE c.regno = :regno")
    , @NamedQuery(name = "Classreportbank.findByName", query = "SELECT c FROM Classreportbank c WHERE c.name = :name")
    , @NamedQuery(name = "Classreportbank.findByFinaltotal", query = "SELECT c FROM Classreportbank c WHERE c.finaltotal = :finaltotal")
    , @NamedQuery(name = "Classreportbank.findByFinalaverage", query = "SELECT c FROM Classreportbank c WHERE c.finalaverage = :finalaverage")
    , @NamedQuery(name = "Classreportbank.findByClassposition", query = "SELECT c FROM Classreportbank c WHERE c.classposition = :classposition")
    , @NamedQuery(name = "Classreportbank.findByRemark", query = "SELECT c FROM Classreportbank c WHERE c.remark = :remark")
    , @NamedQuery(name = "Classreportbank.findByClasscode", query = "SELECT c FROM Classreportbank c WHERE c.classcode = :classcode")
    , @NamedQuery(name = "Classreportbank.findByTerm", query = "SELECT c FROM Classreportbank c WHERE c.term = :term")
    , @NamedQuery(name = "Classreportbank.findByAcasession", query = "SELECT c FROM Classreportbank c WHERE c.acasession = :acasession")
    , @NamedQuery(name = "Classreportbank.findByLevelposition", query = "SELECT c FROM Classreportbank c WHERE c.levelposition = :levelposition")
    , @NamedQuery(name = "Classreportbank.findByLevel", query = "SELECT c FROM Classreportbank c WHERE c.level = :level")
    , @NamedQuery(name = "Classreportbank.findByJuniorposition", query = "SELECT c FROM Classreportbank c WHERE c.juniorposition = :juniorposition")
    , @NamedQuery(name = "Classreportbank.findBySeniorposition", query = "SELECT c FROM Classreportbank c WHERE c.seniorposition = :seniorposition")
    , @NamedQuery(name = "Classreportbank.findByOverallposition", query = "SELECT c FROM Classreportbank c WHERE c.overallposition = :overallposition")
    , @NamedQuery(name = "Classreportbank.findByClassstatus", query = "SELECT c FROM Classreportbank c WHERE c.classstatus = :classstatus")
    , @NamedQuery(name = "Classreportbank.findByLevelstatus", query = "SELECT c FROM Classreportbank c WHERE c.levelstatus = :levelstatus")
    , @NamedQuery(name = "Classreportbank.findByJuniorstatus", query = "SELECT c FROM Classreportbank c WHERE c.juniorstatus = :juniorstatus")
    , @NamedQuery(name = "Classreportbank.findBySeniorstatus", query = "SELECT c FROM Classreportbank c WHERE c.seniorstatus = :seniorstatus")
    , @NamedQuery(name = "Classreportbank.findByOverallstatus", query = "SELECT c FROM Classreportbank c WHERE c.overallstatus = :overallstatus")
    , @NamedQuery(name = "Classreportbank.findByCode", query = "SELECT c FROM Classreportbank c WHERE c.code = :code")
    , @NamedQuery(name = "Classreportbank.findBySex", query = "SELECT c FROM Classreportbank c WHERE c.sex = :sex")
    , @NamedQuery(name = "Classreportbank.findByPictureurl", query = "SELECT c FROM Classreportbank c WHERE c.pictureurl = :pictureurl")
    , @NamedQuery(name = "Classreportbank.findByMinNumber", query = "SELECT c FROM Classreportbank c WHERE c.minNumber = :minNumber")
    , @NamedQuery(name = "Classreportbank.findByMax", query = "SELECT c FROM Classreportbank c WHERE c.max = :max")
    , @NamedQuery(name = "Classreportbank.findByPresence", query = "SELECT c FROM Classreportbank c WHERE c.presence = :presence")
    , @NamedQuery(name = "Classreportbank.findByAbsence", query = "SELECT c FROM Classreportbank c WHERE c.absence = :absence")
    , @NamedQuery(name = "Classreportbank.findByNextermbegin", query = "SELECT c FROM Classreportbank c WHERE c.nextermbegin = :nextermbegin")
    , @NamedQuery(name = "Classreportbank.findByNextermfees", query = "SELECT c FROM Classreportbank c WHERE c.nextermfees = :nextermfees")
    , @NamedQuery(name = "Classreportbank.findByAlertness", query = "SELECT c FROM Classreportbank c WHERE c.alertness = :alertness")
    , @NamedQuery(name = "Classreportbank.findByPunctuation", query = "SELECT c FROM Classreportbank c WHERE c.punctuation = :punctuation")
    , @NamedQuery(name = "Classreportbank.findByReliability", query = "SELECT c FROM Classreportbank c WHERE c.reliability = :reliability")
    , @NamedQuery(name = "Classreportbank.findByInitiativeness", query = "SELECT c FROM Classreportbank c WHERE c.initiativeness = :initiativeness")
    , @NamedQuery(name = "Classreportbank.findByLeadership", query = "SELECT c FROM Classreportbank c WHERE c.leadership = :leadership")
    , @NamedQuery(name = "Classreportbank.findByCourtesy", query = "SELECT c FROM Classreportbank c WHERE c.courtesy = :courtesy")
    , @NamedQuery(name = "Classreportbank.findBySelfcontrol", query = "SELECT c FROM Classreportbank c WHERE c.selfcontrol = :selfcontrol")
    , @NamedQuery(name = "Classreportbank.findBySpiritservice", query = "SELECT c FROM Classreportbank c WHERE c.spiritservice = :spiritservice")
    , @NamedQuery(name = "Classreportbank.findByPerseverance", query = "SELECT c FROM Classreportbank c WHERE c.perseverance = :perseverance")
    , @NamedQuery(name = "Classreportbank.findByConsideration", query = "SELECT c FROM Classreportbank c WHERE c.consideration = :consideration")
    , @NamedQuery(name = "Classreportbank.findByTeamspirit", query = "SELECT c FROM Classreportbank c WHERE c.teamspirit = :teamspirit")
    , @NamedQuery(name = "Classreportbank.findByFriendlyness", query = "SELECT c FROM Classreportbank c WHERE c.friendlyness = :friendlyness")
    , @NamedQuery(name = "Classreportbank.findByHandwritting", query = "SELECT c FROM Classreportbank c WHERE c.handwritting = :handwritting")
    , @NamedQuery(name = "Classreportbank.findByFluency", query = "SELECT c FROM Classreportbank c WHERE c.fluency = :fluency")
    , @NamedQuery(name = "Classreportbank.findByGames", query = "SELECT c FROM Classreportbank c WHERE c.games = :games")
    , @NamedQuery(name = "Classreportbank.findBySports", query = "SELECT c FROM Classreportbank c WHERE c.sports = :sports")
    , @NamedQuery(name = "Classreportbank.findByGymnastic", query = "SELECT c FROM Classreportbank c WHERE c.gymnastic = :gymnastic")
    , @NamedQuery(name = "Classreportbank.findByHandlingtools", query = "SELECT c FROM Classreportbank c WHERE c.handlingtools = :handlingtools")
    , @NamedQuery(name = "Classreportbank.findByAcasessionAndTermAndClasscode", query = "SELECT c FROM Classreportbank c WHERE c.acasession = :acasession AND c.term = :term AND c.classcode = :classcode")
    , @NamedQuery(name = "Classreportbank.deleteStudents", query = "DELETE  FROM Classreportbank c WHERE c.code=:code")
    , @NamedQuery(name = "Classreportbank.findByDrawing", query = "SELECT c FROM Classreportbank c WHERE c.drawing = :drawing")})
public class Classreportbank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 40)
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
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
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

    public Classreportbank() {
    }

    public Classreportbank(String code) {
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classreportbank)) {
            return false;
        }
        Classreportbank other = (Classreportbank) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Classreportbank[ code=" + code + " ]";
    }
    
}
