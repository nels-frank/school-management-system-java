/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import connection.dbConnection;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import entities.Feespayment;
import entities.Feespayment_;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class FeespaymentFacade extends AbstractFacade<Feespayment> {
    @Inject
    private dbConnection dc;

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FeespaymentFacade() {
        super(Feespayment.class);
    }
   
    public List<Feespayment> findByClasscode(String classcode){
    return em.createNamedQuery("Feespayment.findByClasscode", Feespayment.class).setParameter("classcode", classcode).getResultList();
    }
                                                                
   public void createFeesPayament(String session, String term, String regno, double balance,String name,String classlevel,String classoption, double tuitionfee) {
        Query query = em.createNativeQuery("INSERT INTO feespayment(session, term,  regno, balance, name, classlevel, classoption,tuitionfee) VALUES(?,?,?,?,?,?,?,?)");
        query.setParameter(1, session).setParameter(2, term).setParameter(3, regno).setParameter(4, balance).setParameter(5, name).setParameter(6, classoption).setParameter(7, classlevel).setParameter(8, tuitionfee);
        query.executeUpdate();
    }
    
   public void updateFeespayment(  double amountpaid, String regno, double balance, String paymenttype, String status,String datetime, String todaydate, String pin) {        
           try {
            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Feespayment> uc = bd.createCriteriaUpdate(Feespayment.class);
            Root<Feespayment> ur = uc.from(Feespayment.class);
            uc.where(bd.equal(ur.get(Feespayment_.regno), regno));
            uc.set(ur.get(Feespayment_.amountpaid), amountpaid);            
            uc.set(ur.get(Feespayment_.balance), balance);
            uc.set(ur.get(Feespayment_.paymenttype), "Cash");
            uc.set(ur.get(Feespayment_.todaydate), todaydate ); 
            uc.set(ur.get(Feespayment_.datetime), datetime );
             uc.set(ur.get(Feespayment_.status), "Active" ); 
              uc.set(ur.get(Feespayment_.pin), pin ); 
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    } 
   public void createFeeshistory(String session, String term,double amountpaid, String regno, double balance, String paymenttype, String status, String name,String classlevel, String classoption, double tuitionfee, String datetime, String todaydate) {
        Query query = em.createNativeQuery("INSERT INTO feeshistory(session, term, amountpaid, regno, balance, paymenttype, status,name, classlevel, classoption, tuitionfee, datetime, todaydate) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        query.setParameter(1, session).setParameter(2, term).setParameter(3, amountpaid).setParameter(4, regno).setParameter(5, balance).setParameter(6, "Cash").setParameter(7, "Active").setParameter(8, name).setParameter(9, classlevel).setParameter(10, classoption).setParameter(11, tuitionfee).setParameter(12, datetime).setParameter(13, todaydate);
        query.executeUpdate();
   }
   
   public void updateFeespayment2(  double amountpaid, String regno, double balance, String paymenttype, String telanumber, String status,String datetime, String todaydate, String pin, String bank) {        
           try {
            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Feespayment> uc = bd.createCriteriaUpdate(Feespayment.class);
            Root<Feespayment> ur = uc.from(Feespayment.class);
            uc.where(bd.equal(ur.get(Feespayment_.regno), regno));
            uc.set(ur.get(Feespayment_.amountpaid), amountpaid);            
            uc.set(ur.get(Feespayment_.balance), balance);
            uc.set(ur.get(Feespayment_.paymenttype), "Bank");
            uc.set(ur.get(Feespayment_.telanumber), telanumber);
            uc.set(ur.get(Feespayment_.todaydate), todaydate ); 
            uc.set(ur.get(Feespayment_.datetime), datetime );
            uc.set(ur.get(Feespayment_.status), "Active" ); 
            uc.set(ur.get(Feespayment_.pin), pin ); 
            uc.set(ur.get(Feespayment_.bank), bank ); 
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    } 
          public void createFeeshistory2(String session, String term,double amountpaid, String regno, double balance, String paymenttype, String telanumber, String status, String name,String classlevel, String classoption, double tuitionfee, String datetime, String date, String bank, String pictureurl, String pin) {
        Query query = em.createNativeQuery("INSERT INTO feeshistory(session, term, amountpaid, regno, balance, paymenttype,telanumber, status, name, classlevel, classoption, tuitionfee, datetime, date, bank, pictureurl,pin) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        query.setParameter(1, session).setParameter(2, term).setParameter(3, amountpaid).setParameter(4, regno).setParameter(5, balance).setParameter(6, paymenttype).setParameter(7, telanumber).setParameter(8, status).setParameter(9, name).setParameter(10, classlevel).setParameter(11, classoption).setParameter(12, tuitionfee).setParameter(13, datetime).setParameter(14, date).setParameter(15, bank).setParameter(16, pictureurl).setParameter(17, pin);
        query.executeUpdate();
   }
   
   public String Feespin(int count) {
        String regno = dc.feesPin(count);
        return regno;
     }
   public String titleCase(String input) {
        String inputText = dc.titleCase(input);
        return inputText;
}
   public void removeByRegno(String regno) {
        this.em.createNamedQuery("Feespayment.deleteByRegno",Feespayment.class)
                .setParameter("regno", regno)
                .executeUpdate();
    }

   public List<Feespayment> todayTransaction(String todaydate) {
        return em.createNamedQuery("Feespayment.findByTodaydate", Feespayment.class).setParameter("todaydate", todaydate).getResultList();
    }
   
   public List<Feespayment> findByClassoption(String classoption) {
        return em.createNamedQuery("Feespayment.findByClassoption", Feespayment.class).setParameter("classoption", classoption).getResultList();
    }
}
