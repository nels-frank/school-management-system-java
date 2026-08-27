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
import entities.Mastersheet;
import entities.Mastersheet_;


/**
 *
 * @author Adzua Frank
 */
@Stateless
public class MastersheetFacade extends AbstractFacade<Mastersheet> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MastersheetFacade() {
        super(Mastersheet.class);
    }
   public List<Mastersheet> getResultList(String classcode){
       return em.createNamedQuery("Mastersheet.findByClasscode", Mastersheet.class).setParameter("classcode", classcode)
                .getResultList();
    }
     public void addMasterSheet(String regno,String name,String term,String acasession,int total,double avg,String post,String classcode,String level,String remark){
    Query query=em.createNativeQuery("INSERT INTO Mastersheet(regno, name, term, acasession,total, avg, post, classcode, level, remark)"+
            "VALUES(?,?,?,?,?,?,?,?,?,?)");
    query.setParameter(1,regno).setParameter(2, name).setParameter(3,term).setParameter(4,acasession)
   .setParameter(5,total).setParameter(6,avg).setParameter(7,post).setParameter(8,classcode).setParameter(9,level).setParameter(10, remark);  
    query.executeUpdate();
            }
     public void updateSub1(String regno,int sub1) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub1), sub1);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
     public void updateSub2(String regno,int sub2) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub2), sub2);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
      public void updateSub3(String regno,int sub3) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub3), sub3);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
        public void updateSub4(String regno,int sub4) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub4), sub4);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
        public void updateSub5(String regno,int sub5) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub5), sub5);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
        public void updateSub6(String regno,int sub6) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub6), sub6);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
         public void updateSub7(String regno,int sub7) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub7), sub7);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
          public void updateSub8(String regno,int sub8) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub8), sub8);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
           public void updateSub9(String regno,int sub9) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub9), sub9);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
            public void updateSub10(String regno,int sub10) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub10), sub10);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
             public void updateSub11(String regno,int sub11) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub11), sub11);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
              public void updateSub12(String regno,int sub12) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub12), sub12);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
               public void updateSub13(String regno,int sub13) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub13), sub13);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
                public void updateSub14(String regno,int sub14) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub14), sub14);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
                 public void updateSub15(String regno,int sub15) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub15), sub15);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
                  public void updateSub16(String regno,int sub16) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub16), sub16);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
                  public void updateSub17(String regno,int sub17) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub17), sub17);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
                  public void updateSub18(String regno,int sub18) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub18), sub18);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
                  public void updateSub19(String regno,int sub19) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub19), sub19);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
                   public void updateSub20(String regno,int sub20) {
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Mastersheet> uc = bd.createCriteriaUpdate(Mastersheet.class);
            Root<Mastersheet> ur = uc.from(Mastersheet.class);
            uc.where(bd.equal(ur.get(Mastersheet_.regno), regno)
            );
            uc.set(ur.get(Mastersheet_.sub20), sub20);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    } 
}
