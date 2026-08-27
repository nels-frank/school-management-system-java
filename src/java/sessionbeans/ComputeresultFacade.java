/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import com.SET07.dbconn.DBAction;
import connection.dbConnection;
import java.text.DecimalFormat;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import entities.Computeresult;
import entities.Computeresult_;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class ComputeresultFacade extends AbstractFacade<Computeresult> {
    
    @Inject
   private dbConnection dc;
 @Inject
   private DBAction db;

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComputeresultFacade() {
        super(Computeresult.class);
    }
    
    public List<Computeresult> findByClasscodeAndSubjects(String subjects, String classcode, String examsession, String term) {
        return em.createNamedQuery("Computeresult.findByClassAndSubject", Computeresult.class).setParameter("classcode", classcode)
                .setParameter("subjects", subjects).setParameter("examsession", examsession).setParameter("term", term).getResultList();
    }
    
    public List<Computeresult> findByClasscodeAndSubjectsPrint(String subjects, String classcode, String examsession, String term) {
        return em.createNamedQuery("Computeresult.findByClassAndSubject", Computeresult.class).setParameter("classcode", classcode)
                .setParameter("subjects", subjects).setParameter("examsession", examsession).setParameter("term", term).getResultList();
    }

    public int countAdeja(String regno) {
        int count = db.countbyRegno1(regno);
        return count;
    }

    public void udpdateResult(String computecode, int ass1, int ass2, int ass3,  int exam, int total1, int total, String grade, String remark, String status) {
        try {

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Computeresult> updateCriteria = builder.createCriteriaUpdate(Computeresult.class);
            Root<Computeresult> updateRoot = updateCriteria.from(Computeresult.class);
            updateCriteria.where(builder.equal(updateRoot.get(Computeresult_.computecode), computecode));
            updateCriteria.set(updateRoot.get(Computeresult_.ass1), ass1);
            updateCriteria.set(updateRoot.get(Computeresult_.ass2), ass2);
            updateCriteria.set(updateRoot.get(Computeresult_.ass3), ass3);           
            updateCriteria.set(updateRoot.get(Computeresult_.exam), exam);
            updateCriteria.set(updateRoot.get(Computeresult_.total1), total1);
            updateCriteria.set(updateRoot.get(Computeresult_.total), total);
            updateCriteria.set(updateRoot.get(Computeresult_.grade), grade);
            updateCriteria.set(updateRoot.get(Computeresult_.remark), remark);
           updateCriteria.set(updateRoot.get(Computeresult_.checked), "recorded");
           updateCriteria.set(updateRoot.get(Computeresult_.status), "noposition");
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }


    public void udpdateMidTotal(String computecode, int ass1, int ass2, int ass3, int total1) {
        try {

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Computeresult> updateCriteria = builder.createCriteriaUpdate(Computeresult.class);
            Root<Computeresult> updateRoot = updateCriteria.from(Computeresult.class);
            updateCriteria.where(builder.equal(updateRoot.get(Computeresult_.computecode), computecode));
            updateCriteria.set(updateRoot.get(Computeresult_.ass1), ass1);
            updateCriteria.set(updateRoot.get(Computeresult_.ass2), ass2);
            updateCriteria.set(updateRoot.get(Computeresult_.ass3), ass3);           
            updateCriteria.set(updateRoot.get(Computeresult_.total1), total1);            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }

    public String grade(int total) {
        String grade = null;
        try {
           

            if (total < 40) {
                grade = "E";

            }
            if (total >= 40 && total < 55) {
                grade = "D";

            }
            if (total >= 55 && total < 70) {
                grade = "C";

            }
            if (total >= 70 && total < 75) {
                grade = "B";

            }
            if (total >= 75) {
                grade = "A";

            }
        } catch (Exception e) {
        }
        return grade;
    }

    public String grade2(int total) {
        String grade = null;
        try {
            if (total < 45) {
                grade = "F";

            }

            if (total >= 45 && total < 50) {
                grade = "E";

            }
            if (total >= 50 && total < 60) {
                grade = "D";

            }
            if (total >= 60 && total < 70) {
                grade = "C";

            }
            if (total >= 70 && total < 80) {
                grade = "B";

            }
            if (total >= 80) {
                grade = "A";

            }
        } catch (Exception e) {
        }
        return grade;
    }

    public int midtotal(int total1) {
        DecimalFormat OneDF = new DecimalFormat("#.0");
        double percent;
        percent = total1 * 100;
        percent = percent / 40;
        String av = OneDF.format(percent);
        int pecent = Integer.valueOf(av);
        return pecent;
    }

    public String remark(int total) {
        String remark = null;
        try {
           

            if ( total < 40) {
                remark = "Fail";

            }
            if (total >= 40 && total < 55) {
                remark = "Fair";

            }
            if (total >= 55 && total < 70) {
                remark = "Good";

            }
            if (total >= 70 && total < 75) {
                remark = "Very Good";

            }
            if (total >= 75) {
                remark = "Excellent";

            }
        } catch (Exception e) {
        }
        return remark;
    }

    public String remark2(int total) {
        String remark = null;
        try {
            if (total < 45) {
                remark = "Poor";

            }

            if (total >= 45 && total < 55) {
                remark = "Fail";

            }
            if (total >= 55 && total < 60) {
                remark = "Fair";

            }
            if (total >= 60 && total < 70) {
                remark = "Good";

            }
            if (total >= 70 && total < 80) {
                remark = "Very Good";

            }
            if (total >= 80) {
                remark = "Excellent";

            }
        } catch (Exception e) {
        }
        return remark;
    }

    public void setPosition(String subjects, String classcode, String examsession, String term, int total, String position) {

        //  db.setPosition(classcode, subjects); 
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Computeresult> uc = bd.createCriteriaUpdate(Computeresult.class);
            Root<Computeresult> ur = uc.from(Computeresult.class);
            uc.where(bd.equal(ur.get(Computeresult_.subjects), subjects),
                    bd.equal(ur.get(Computeresult_.classcode), classcode),
                    bd.equal(ur.get(Computeresult_.examsession), examsession),
                    bd.equal(ur.get(Computeresult_.term), term),
                    bd.equal(ur.get(Computeresult_.total), total)
            );
            uc.set(ur.get(Computeresult_.position), position);
            uc.set(ur.get(Computeresult_.status), "position");
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }

    public void setPosition1(String subjects, String classcode) {

        //  db.setPosition(classcode, subjects); 
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Computeresult> uc = bd.createCriteriaUpdate(Computeresult.class);
            Root<Computeresult> ur = uc.from(Computeresult.class);
            uc.where(bd.equal(ur.get(Computeresult_.subjects), subjects),
                    bd.equal(ur.get(Computeresult_.classcode), classcode) );
           Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }

    public void setAHL(String subjects, String classcode, double avg, int highest, int lowest) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Computeresult> uc = bd.createCriteriaUpdate(Computeresult.class);
            Root<Computeresult> ur = uc.from(Computeresult.class);
            uc.where(bd.equal(ur.get(Computeresult_.subjects), subjects),
                    bd.equal(ur.get(Computeresult_.classcode), classcode)
            );
            uc.set(ur.get(Computeresult_.classavg), avg);
            uc.set(ur.get(Computeresult_.highest), highest);
            uc.set(ur.get(Computeresult_.lowest), lowest);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }

    public void setAHL1(String subjects, String classcode) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Computeresult> uc = bd.createCriteriaUpdate(Computeresult.class);
            Root<Computeresult> ur = uc.from(Computeresult.class);
            uc.where(bd.equal(ur.get(Computeresult_.subjects), subjects),
                    bd.equal(ur.get(Computeresult_.classcode), classcode) );           
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }

        public List<Computeresult> findByRegno(String regno) {
        return em.createNamedQuery("Computeresult.findByRegno", Computeresult.class).setParameter("regno", regno).getResultList();
    }
    
    public List<Computeresult> findByRegnoSessionTerm(String regno, String examsession, String term) {
        return em.createNamedQuery("Computeresult.findByRegnoSessionTerm", Computeresult.class).setParameter("regno", regno).setParameter("examsession", examsession).setParameter("term", term).getResultList();
    }
    
    public List<Computeresult> findByClasscodeAndSubjects2(String subjects, String classcode, String examsession, String term) {
        return em.createNamedQuery("Computeresult.findByClassAndSubject", Computeresult.class).setParameter("classcode", classcode)
                .setParameter("subjects", subjects).setParameter("examsession", examsession).setParameter("term", term).getResultList();
    }
    

    public void reSet(String subjects, String classcode, String examsession, String term) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Computeresult> uc = bd.createCriteriaUpdate(Computeresult.class);
            Root<Computeresult> ur = uc.from(Computeresult.class);
            uc.where(bd.equal(ur.get(Computeresult_.subjects), subjects),
                    bd.equal(ur.get(Computeresult_.classcode), classcode),
                    bd.equal(ur.get(Computeresult_.examsession), examsession),
                    bd.equal(ur.get(Computeresult_.term), term)
            );
            uc.set(ur.get(Computeresult_.position), "");

            uc.set(ur.get(Computeresult_.status), "noposition");
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
     public void reSet2(String subjects, String classcode) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Computeresult> uc = bd.createCriteriaUpdate(Computeresult.class);
            Root<Computeresult> ur = uc.from(Computeresult.class);
            uc.where(bd.equal(ur.get(Computeresult_.subjects), subjects),
                    bd.equal(ur.get(Computeresult_.classcode), classcode));
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
       public void removeByRegno(String regno) {
        this.em.createNamedQuery("Computeresult.deleteByRegno",Computeresult.class)
                .setParameter("regno", regno)
                .executeUpdate();
    }
         public void removeBySubjects(String subjects,String classcode) {
        this.em.createNamedQuery("Computeresult.deleteBySubjectsAndClasscode",Computeresult.class)
                .setParameter("subjects", subjects)
                 .setParameter("classcode", classcode)
                .executeUpdate();
    }
          public void setSubjectNumber(String subjects) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Computeresult> uc = bd.createCriteriaUpdate(Computeresult.class);
            Root<Computeresult> ur = uc.from(Computeresult.class);
            uc.where(bd.equal(ur.get(Computeresult_.subjects), subjects)
            );           
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
      public void udpdateInfo(String regno, String name) {
        try {

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Computeresult> updateCriteria = builder.createCriteriaUpdate(Computeresult.class);
            Root<Computeresult> updateRoot = updateCriteria.from(Computeresult.class);
            updateCriteria.where(builder.equal(updateRoot.get(Computeresult_.regno), regno));
            updateCriteria.set(updateRoot.get(Computeresult_.name), name);
             Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
    }
        
    }
      
      public void udpdateResult2(String computecode, int ass1, int ass2, int ass3,  int exam, int total1, int total, String grade, String remark, String status) {
        try {

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Computeresult> updateCriteria = builder.createCriteriaUpdate(Computeresult.class);
            Root<Computeresult> updateRoot = updateCriteria.from(Computeresult.class);
            updateCriteria.where(builder.equal(updateRoot.get(Computeresult_.computecode), computecode));
            updateCriteria.set(updateRoot.get(Computeresult_.ass1), ass1);
            updateCriteria.set(updateRoot.get(Computeresult_.ass2), ass2);
            updateCriteria.set(updateRoot.get(Computeresult_.ass3), ass3);           
            updateCriteria.set(updateRoot.get(Computeresult_.exam), exam);
            updateCriteria.set(updateRoot.get(Computeresult_.total1), total1);
            updateCriteria.set(updateRoot.get(Computeresult_.total), total);
            updateCriteria.set(updateRoot.get(Computeresult_.grade), grade);
            updateCriteria.set(updateRoot.get(Computeresult_.remark), remark);
           updateCriteria.set(updateRoot.get(Computeresult_.checked), "recorded");
           updateCriteria.set(updateRoot.get(Computeresult_.status), "noposition");
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
      public void removeByComputCod(String computecode) {
        this.em.createNamedQuery("Computeresult.deleteByComputecode",Computeresult.class)
                .setParameter("computecode", computecode)
                .executeUpdate();
    }
}
 
    
    