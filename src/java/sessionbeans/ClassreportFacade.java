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

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class ClassreportFacade extends AbstractFacade<Classreport> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClassreportFacade() {
        super(Classreport.class);
    }
    public List<Classreport> findByClasscode(String classcode){
    return em.createNamedQuery("Classreport.findByClasscode",Classreport.class).setParameter("classcode", classcode).getResultList();
    }
    
    
         public void setSchoolPosition(double average, String position) { 
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Classreport> uc = bd.createCriteriaUpdate(Classreport.class);
            Root<Classreport> ur = uc.from(Classreport.class);
            uc.where(
                    bd.equal(ur.get(Classreport_.average), average)
            );
            uc.set(ur.get(Classreport_.overallposition), position);
            uc.set(ur.get(Classreport_.overallstatus),"position");
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
         public void removeByRegno(String regno) {
        this.em.createNamedQuery("Classreport.deleteStudent",Classreport.class)
                .setParameter("regno", regno)
                .executeUpdate();
    }
 public void removeClassReport(String classcode) {
        this.em.createNamedQuery("Classreport.deleteStudents",Classreport.class)
                .setParameter("classcode", classcode)
                .executeUpdate();
    }
 public List<Classreport> findByClasscodeAndSubjects2(String subjects, String classcode, String examsession, String term) {
        return em.createNamedQuery("Computeresult.findByClassAndSubject", Classreport.class).setParameter("classcode", classcode)
                .setParameter("subjects", subjects).setParameter("examsession", examsession).setParameter("term", term).getResultList();
    }
}
