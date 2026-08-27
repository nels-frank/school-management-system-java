/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import entities.Headteacher;
import entities.Headteacher_;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class HeadteacherFacade extends AbstractFacade<Headteacher> {
@PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public HeadteacherFacade() {
        super(Headteacher.class);
    }
    public void udpdateHM(String staffcode, String session, String term, String headname) {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Headteacher> updateCriteria = builder.createCriteriaUpdate(Headteacher.class);
            Root<Headteacher> updateRoot = updateCriteria.from(Headteacher.class);
            updateCriteria.where(builder.equal(updateRoot.get(Headteacher_.staffcode), staffcode));
            updateCriteria.set(updateRoot.get(Headteacher_.session), session);
            updateCriteria.set(updateRoot.get(Headteacher_.term), term);
            updateCriteria.set(updateRoot.get(Headteacher_.headname), headname);                                 
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
}
