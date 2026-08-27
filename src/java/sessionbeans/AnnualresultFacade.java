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
import entities.Annualresult;
import entities.Annualresult_;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class AnnualresultFacade extends AbstractFacade<Annualresult> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnnualresultFacade() {
        super(Annualresult.class);
    }
   public List<Annualresult> findByAcademicSession(String acasession, String classcode,String subject) {
        return em.createNamedQuery("Annualresult.findByAcasessionAndClasscodeAndSubject", Annualresult.class).setParameter("classcode", classcode)
                .setParameter("acasession", acasession).setParameter("subject", subject).getResultList();
    }
    
      public void setPosition(String acasession, String classcode, String subjects, int total, String position) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Annualresult> uc = bd.createCriteriaUpdate(Annualresult.class);
            Root<Annualresult> ur = uc.from(Annualresult.class);
            uc.where(bd.equal(ur.get(Annualresult_.acasession), acasession),
                    bd.equal(ur.get(Annualresult_.classcode), classcode),
                    bd.equal(ur.get(Annualresult_.subject), subjects),
                    bd.equal(ur.get(Annualresult_.total), total)                    
                    );
            uc.set(ur.get(Annualresult_.pos), position);
            uc.set(ur.get(Annualresult_.status), "position");
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
      public void setAHL(String acasession, String classcode, String subjects, double avg, double highest, double lowest) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Annualresult> uc = bd.createCriteriaUpdate(Annualresult.class);
            Root<Annualresult> ur = uc.from(Annualresult.class);
            uc.where(bd.equal(ur.get(Annualresult_.acasession), acasession),
                    bd.equal(ur.get(Annualresult_.classcode), classcode),
                    bd.equal(ur.get(Annualresult_.subject), subjects)                    
                    );
            uc.set(ur.get(Annualresult_.classavg), avg);
            uc.set(ur.get(Annualresult_.highestavg), highest);
            uc.set(ur.get(Annualresult_.lowestavg), lowest);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
      public void reSet(String acasession, String classcode, String subjects) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Annualresult> uc = bd.createCriteriaUpdate(Annualresult.class);
            Root<Annualresult> ur = uc.from(Annualresult.class);
            uc.where(bd.equal(ur.get(Annualresult_.acasession), acasession),
                    bd.equal(ur.get(Annualresult_.classcode), classcode),
                    bd.equal(ur.get(Annualresult_.subject), subjects)                    
                    );
            uc.set(ur.get(Annualresult_.pos), "");

            uc.set(ur.get(Annualresult_.status), "noposition");
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
      
       public String grade(double total) {
        String grade = null;
        try {
            if (total < 135) {
                grade = "F";

            }

            if (total >= 135 && total < 150) {
                grade = "E";

            }
            if (total >= 150 && total < 180) {
                grade = "D";

            }
            if (total >= 180 && total < 210) {
                grade = "C";

            }
            if (total >= 210 && total < 240) {
                grade = "B";

            }
            if (total >= 240) {
                grade = "A";

            }
        } catch (Exception e) {
        }
        return grade;
    
       }
       
       
        public String remark(double total) {
        String remark = null;
        try {
            if (total < 135) {
                remark = "Poor";

            }

            if (total >= 135 && total < 150) {
                remark = "Fail";

            }
            if (total >= 150 && total < 180) {
                remark = "Pass";

            }
            if (total >= 180 && total < 210) {
                remark = "Good";

            }
            if (total >= 210 && total < 240) {
                remark = "Very Good";

            }
            if (total >= 240) {
                remark = "Excellent";

            }
        } catch (Exception e) {
        }
        return remark;
    }
        public List<Annualresult> findByRegnoSession(String regno, String acasession) {
        return em.createNamedQuery("Annualresult.findByRegnoSession", Annualresult.class).setParameter("regno", regno).setParameter("acasession", acasession).getResultList();
    } 
}
