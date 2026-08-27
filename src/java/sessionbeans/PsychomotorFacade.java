/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import entities.Psychomotor;
import entities.Psychomotor_;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class PsychomotorFacade extends AbstractFacade<Psychomotor> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PsychomotorFacade() {
        super(Psychomotor.class);
    }
    public List<Psychomotor> findByClasscode(String classcode) {
    return em.createNamedQuery("Psychomotor.findByClasscode", Psychomotor.class).setParameter("classcode", classcode).getResultList();
    }
    
    public void udpdatePsychomotor(String code, int alertness, int punctuation, int reliability, int initiativeness, int leadership, int courtesy, int selfcontrol, int spiritservice, int perseverance, int consideration, int teamspirit, int friendlyness, int handwritting, int fluency, int games, int sports, int gymnastic, int handlingtools, int drawing) {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Psychomotor> updateCriteria = builder.createCriteriaUpdate(Psychomotor.class);
            Root<Psychomotor> updateRoot = updateCriteria.from(Psychomotor.class);
            updateCriteria.where(builder.equal(updateRoot.get(Psychomotor_.code), code));
            updateCriteria.set(updateRoot.get(Psychomotor_.alertness), alertness);
            updateCriteria.set(updateRoot.get(Psychomotor_.punctuation), punctuation);
            updateCriteria.set(updateRoot.get(Psychomotor_.reliability), reliability);
            updateCriteria.set(updateRoot.get(Psychomotor_.initiativeness), initiativeness);
            updateCriteria.set(updateRoot.get(Psychomotor_.leadership), leadership);
            updateCriteria.set(updateRoot.get(Psychomotor_.courtesy), courtesy);
            updateCriteria.set(updateRoot.get(Psychomotor_.selfcontrol), selfcontrol);
            updateCriteria.set(updateRoot.get(Psychomotor_.spiritservice), spiritservice);
            updateCriteria.set(updateRoot.get(Psychomotor_.perseverance), perseverance);
            updateCriteria.set(updateRoot.get(Psychomotor_.consideration), consideration);
            updateCriteria.set(updateRoot.get(Psychomotor_.teamspirit), teamspirit);
            updateCriteria.set(updateRoot.get(Psychomotor_.friendlyness), friendlyness);
            updateCriteria.set(updateRoot.get(Psychomotor_.handwritting), handwritting);
            updateCriteria.set(updateRoot.get(Psychomotor_.fluency), fluency);
            updateCriteria.set(updateRoot.get(Psychomotor_.games), games);
            updateCriteria.set(updateRoot.get(Psychomotor_.sports), sports);
            updateCriteria.set(updateRoot.get(Psychomotor_.gymnastic), gymnastic);
            updateCriteria.set(updateRoot.get(Psychomotor_.handlingtools), handlingtools);
            updateCriteria.set(updateRoot.get(Psychomotor_.drawing), drawing);            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
}
