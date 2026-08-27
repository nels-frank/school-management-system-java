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
@Table(name = "psychomotor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Psychomotor.findAll", query = "SELECT p FROM Psychomotor p")
    , @NamedQuery(name = "Psychomotor.findByCode", query = "SELECT p FROM Psychomotor p WHERE p.code = :code")
    , @NamedQuery(name = "Psychomotor.findByRegno", query = "SELECT p FROM Psychomotor p WHERE p.regno = :regno")
    , @NamedQuery(name = "Psychomotor.findByName", query = "SELECT p FROM Psychomotor p WHERE p.name = :name")
    , @NamedQuery(name = "Psychomotor.findByLevel", query = "SELECT p FROM Psychomotor p WHERE p.level = :level")
    , @NamedQuery(name = "Psychomotor.findByClasscode", query = "SELECT p FROM Psychomotor p WHERE p.classcode = :classcode")
    , @NamedQuery(name = "Psychomotor.findByExamsession", query = "SELECT p FROM Psychomotor p WHERE p.examsession = :examsession")
    , @NamedQuery(name = "Psychomotor.findByTerm", query = "SELECT p FROM Psychomotor p WHERE p.term = :term")
    , @NamedQuery(name = "Psychomotor.findByAlertness", query = "SELECT p FROM Psychomotor p WHERE p.alertness = :alertness")
    , @NamedQuery(name = "Psychomotor.findByPunctuation", query = "SELECT p FROM Psychomotor p WHERE p.punctuation = :punctuation")
    , @NamedQuery(name = "Psychomotor.findByReliability", query = "SELECT p FROM Psychomotor p WHERE p.reliability = :reliability")
    , @NamedQuery(name = "Psychomotor.findByInitiativeness", query = "SELECT p FROM Psychomotor p WHERE p.initiativeness = :initiativeness")
    , @NamedQuery(name = "Psychomotor.findByLeadership", query = "SELECT p FROM Psychomotor p WHERE p.leadership = :leadership")
    , @NamedQuery(name = "Psychomotor.findByCourtesy", query = "SELECT p FROM Psychomotor p WHERE p.courtesy = :courtesy")
    , @NamedQuery(name = "Psychomotor.findBySelfcontrol", query = "SELECT p FROM Psychomotor p WHERE p.selfcontrol = :selfcontrol")
    , @NamedQuery(name = "Psychomotor.findBySpiritservice", query = "SELECT p FROM Psychomotor p WHERE p.spiritservice = :spiritservice")
    , @NamedQuery(name = "Psychomotor.findByPerseverance", query = "SELECT p FROM Psychomotor p WHERE p.perseverance = :perseverance")
    , @NamedQuery(name = "Psychomotor.findByConsideration", query = "SELECT p FROM Psychomotor p WHERE p.consideration = :consideration")
    , @NamedQuery(name = "Psychomotor.findByTeamspirit", query = "SELECT p FROM Psychomotor p WHERE p.teamspirit = :teamspirit")
    , @NamedQuery(name = "Psychomotor.findByFriendlyness", query = "SELECT p FROM Psychomotor p WHERE p.friendlyness = :friendlyness")
    , @NamedQuery(name = "Psychomotor.findByHandwritting", query = "SELECT p FROM Psychomotor p WHERE p.handwritting = :handwritting")
    , @NamedQuery(name = "Psychomotor.findByFluency", query = "SELECT p FROM Psychomotor p WHERE p.fluency = :fluency")
    , @NamedQuery(name = "Psychomotor.findByGames", query = "SELECT p FROM Psychomotor p WHERE p.games = :games")
    , @NamedQuery(name = "Psychomotor.findBySports", query = "SELECT p FROM Psychomotor p WHERE p.sports = :sports")
    , @NamedQuery(name = "Psychomotor.findByGymnastic", query = "SELECT p FROM Psychomotor p WHERE p.gymnastic = :gymnastic")
    , @NamedQuery(name = "Psychomotor.findByHandlingtools", query = "SELECT p FROM Psychomotor p WHERE p.handlingtools = :handlingtools")
    , @NamedQuery(name = "Psychomotor.findByDrawing", query = "SELECT p FROM Psychomotor p WHERE p.drawing = :drawing")})
public class Psychomotor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "code")
    private String code;
    @Size(max = 45)
    @Column(name = "regno")
    private String regno;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "level")
    private String level;
    @Size(max = 45)
    @Column(name = "classcode")
    private String classcode;
    @Size(max = 45)
    @Column(name = "examsession")
    private String examsession;
    @Size(max = 45)
    @Column(name = "term")
    private String term;
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

    public Psychomotor() {
    }

    public Psychomotor(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    public String getExamsession() {
        return examsession;
    }

    public void setExamsession(String examsession) {
        this.examsession = examsession;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
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
        if (!(object instanceof Psychomotor)) {
            return false;
        }
        Psychomotor other = (Psychomotor) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Psychomotor[ code=" + code + " ]";
    }
    
}
