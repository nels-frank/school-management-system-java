/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Expenditure;
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
public class ExpenditureFacade extends AbstractFacade<Expenditure> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExpenditureFacade() {
        super(Expenditure.class);
    }
    
    public void createExpenditure(String sessions, String term, String discription, String date, String time,double amount) {
        Query query = em.createNativeQuery("INSERT INTO expenditure(sessions, term, discription, date, time, amount) VALUES(?,?,?,?,?,?)");
        query.setParameter(1, sessions).setParameter(2, term).setParameter(3, discription).setParameter(4, date).setParameter(5, time).setParameter(6, amount);
        query.executeUpdate();
    }
    public List<Expenditure> findBySessionAndTerm(String sessions, String term) {
        return em.createNamedQuery("Expenditure.findBySessionsAndTerm", Expenditure.class).setParameter("sessions", sessions).setParameter("term", term).getResultList();
    }
    public List<Expenditure> todayTransaction(String date) {
        return em.createNamedQuery("Expenditure.findByDate", Expenditure.class).setParameter("date", date).getResultList();
    }
    public void removeSN(int sn) {
        this.em.createNamedQuery("Expenditure.deleteBySn",Expenditure.class)
                .setParameter("sn", sn)
                .executeUpdate();
    }
}
