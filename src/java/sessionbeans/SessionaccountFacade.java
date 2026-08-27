/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entities.Sessionaccount;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class SessionaccountFacade extends AbstractFacade<Sessionaccount> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SessionaccountFacade() {
        super(Sessionaccount.class);
    }
    
    public void createSessionClosure(String dayofclosure, String timeofclosure, String sessions, double sessionobtained,double sessionexpenses, double tookhome) {
        Query query = em.createNativeQuery("INSERT INTO sessionaccount(dayofclosure, timeofclosure,  sessions, sessionobtained, sessionexpenses, tookhome) VALUES(?,?,?,?,?,?)");
        query.setParameter(1, dayofclosure).setParameter(2, timeofclosure).setParameter(3, sessions).setParameter(4, sessionobtained).setParameter(5, sessionexpenses).setParameter(6, tookhome);
        query.executeUpdate();
    } 
    
    public void removeBySession(String sessions) {
        this.em.createNamedQuery("Sessionaccount.deleteBySessions",Sessionaccount.class)
                .setParameter("sessions", sessions)
                .executeUpdate();
    }
}
