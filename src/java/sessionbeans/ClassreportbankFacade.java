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
import entities.Classreport;
import entities.Classreport_;
import entities.Classreportbank;
import entities.Classreportbank_;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class ClassreportbankFacade extends AbstractFacade<Classreportbank> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClassreportbankFacade() {
        super(Classreportbank.class);
    }
   public List<Classreportbank> findBySesTermCod(String acasession, String term, String classcode){
    return em.createNamedQuery("Classreportbank.findByAcasessionAndTermAndClasscode",Classreportbank.class).setParameter("classcode", classcode).setParameter("term", term).setParameter("acasession", acasession)
              .getResultList();
    }
    
    public void removeByRegno(String code) {
        this.em.createNamedQuery("Classreportbank.deleteStudents",Classreportbank.class)
                .setParameter("code", code)
                .executeUpdate();
    }
    
    public void setPosition(String classcode, double average, String position, String acasession, String term) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Classreportbank> uc = bd.createCriteriaUpdate(Classreportbank.class);
            Root<Classreportbank> ur = uc.from(Classreportbank.class);
            uc.where(
                   bd.equal(ur.get(Classreportbank_.classcode), classcode),
                   bd.equal(ur.get(Classreportbank_.finalaverage), average),
                   bd.equal(ur.get(Classreportbank_.acasession), acasession),
                   bd.equal(ur.get(Classreportbank_.term), term)
            );
            uc.set(ur.get(Classreportbank_.classposition), position);
            uc.set(ur.get(Classreportbank_.classstatus),"position");
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    } 
}
