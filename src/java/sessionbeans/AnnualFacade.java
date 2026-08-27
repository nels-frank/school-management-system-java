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
import entities.Annual;
import entities.Annual_;
import entities.Annualbank;
import entities.Annualbank_;
import entities.Attendance;
import entities.Classreport;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class AnnualFacade extends AbstractFacade<Annual> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnnualFacade() {
        super(Annual.class);
    }
   public List<Annual> findByClasscode(String classcode) {
        return em.createNamedQuery("Annual.findByClasscode", Annual.class).setParameter("classcode", classcode).getResultList();
    }
    public void removeByRegno(String regno) {
        this.em.createNamedQuery("Annual.deleteByRegno",Annual.class)
                .setParameter("regno", regno)
                .executeUpdate();
    }
   public void removeAnnual(String classcode) {
        this.em.createNamedQuery("Annual.deleteStudents",Annual.class)
                .setParameter("classcode", classcode)
                .executeUpdate();
    }
   public List<Annual> findByRegno(String regno) {
        return em.createNamedQuery("Annual.findByRegno", Annual.class).setParameter("regno", regno).getResultList();
    } 
}
