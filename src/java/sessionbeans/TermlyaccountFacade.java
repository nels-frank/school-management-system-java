/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Termlyaccount;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class TermlyaccountFacade extends AbstractFacade<Termlyaccount> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TermlyaccountFacade() {
        super(Termlyaccount.class);
    }
    public void removeByDayofClosure(String dayofclosure) {
        this.em.createNamedQuery("Termlyaccount.deleteByDayofclosure",Termlyaccount.class)
                .setParameter("dayofclosure", dayofclosure)
                .executeUpdate();
    }
    public void createTermClosure(String dayofclosure, String timeofclosure, String term, String sessions, double termlyobtained, double termlyexpenses, double termlypaidsalary, double tookhome) {
        Query query = em.createNativeQuery("INSERT INTO termlyaccount(dayofclosure, timeofclosure, term, sessions, termlyobtained, termlyexpenses, termlypaidsalary, tookhome) VALUES(?,?,?,?,?,?,?,?)");
        query.setParameter(1, dayofclosure).setParameter(2, timeofclosure).setParameter(3, term).setParameter(4, sessions).setParameter(5, termlyobtained).setParameter(6, termlyexpenses).setParameter(7, termlypaidsalary).setParameter(8, tookhome);
        query.executeUpdate();
        
   }
    public void addTermlyExpenses(String dayofclosure, String timeofclosure, String term, String sessions, double termlyobtained, double termlyexpenses, double termlypaidsalary, double tookhome){
    Query query=em.createNativeQuery("INSERT INTO termlyaccount( dayofclosure, timeofclosure, term, sessions, termlyobtained, termlyexpenses, termlypaidsalary, tookhome)"+
            "VALUES(?,?,?,?,?,?,?,?)");
    query.setParameter(1,dayofclosure).setParameter(2, timeofclosure).setParameter(3,term).setParameter(4,sessions).setParameter(5, termlyobtained).setParameter(6, termlyexpenses).setParameter(7, termlypaidsalary).setParameter(8, tookhome);  
    query.executeUpdate();
    }
    
public List<Termlyaccount> findBySessions(String sessions) {
        return em.createNamedQuery("Termlyaccount.findBySessions", Termlyaccount.class).setParameter("sessions", sessions).getResultList();
    }
}
