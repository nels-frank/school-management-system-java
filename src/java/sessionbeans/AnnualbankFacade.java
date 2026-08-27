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
import entities.Annualbank;
import entities.Annualbank_;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class AnnualbankFacade extends AbstractFacade<Annualbank> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnnualbankFacade() {
        super(Annualbank.class);
    }
   
    public List<Annualbank> allAnnualBank(String acasession, String classcode) {
        return em.createNamedQuery("Annualbank.findByAcasessionAndClasscode", Annualbank.class).setParameter("acasession", acasession).setParameter("classcode", classcode).getResultList();
    }
    
    public void removeByCode(String code) {
        this.em.createNamedQuery("Annualbank.deleteByCode",Annualbank.class)
                .setParameter("code", code)
                .executeUpdate();
    }
    
    public List<Annualbank> findByRegno(String regno, String acasession) {
        return em.createNamedQuery("Annualbank.findByRegnoAndAcasession", Annualbank.class).setParameter("regno", regno).setParameter("acasession", acasession).getResultList();
    }
    
    public void setPosition(String classcode, String examsession, double finaltotal, String position) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Annualbank> uc = bd.createCriteriaUpdate(Annualbank.class);
            Root<Annualbank> ur = uc.from(Annualbank.class);
            uc.where(
                    bd.equal(ur.get(Annualbank_.classcode), classcode),
                    bd.equal(ur.get(Annualbank_.acasession), examsession),
                    bd.equal(ur.get(Annualbank_.finaltotal), finaltotal)                   
            );
            uc.set(ur.get(Annualbank_.classposition), position);  
            uc.set(ur.get(Annualbank_.classstatus), "position");  
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
}
