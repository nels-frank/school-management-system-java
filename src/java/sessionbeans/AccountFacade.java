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
import entities.Account;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }
   public void closeDaily(String dayofpayment, String timeofpayment, double feesamount, double expensesamount, double dailysaved, String term, String sessions){
    Query query=em.createNativeQuery("INSERT INTO account( dayofpayment, timeofpayment, feesamount, expensesamount, dailysaved, term, sessions)"+
            "VALUES(?,?,?,?,?,?,?)");
    query.setParameter(1,dayofpayment).setParameter(2, timeofpayment).setParameter(3,feesamount).setParameter(4,expensesamount).setParameter(5, dailysaved).setParameter(6, term).setParameter(7, sessions);  
    query.executeUpdate();
    }
    
    public void removeByDay(String dayofpayment) {
        this.em.createNamedQuery("Account.deleteByDayofpayment",Account.class)
                .setParameter("dayofpayment", dayofpayment)
                .executeUpdate();
    }
    public List<Account> findBySessionAndTerm(String sessions, String term) {
        return em.createNamedQuery("Account.findBySessionsAndTerm", Account.class).setParameter("sessions", sessions).setParameter("term", term).getResultList();
    } 
}
