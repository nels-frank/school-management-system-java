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
import entities.Formaster;
/**
 *
 * @author Adzua Frank
 */
@Stateless
public class FormasterFacade extends AbstractFacade<Formaster> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormasterFacade() {
        super(Formaster.class);
    }
    public void removeCode(String classcode) {
        this.em.createNamedQuery("Formaster.deleteByClasscode",Formaster.class)
                .setParameter("classcode", classcode)
                .executeUpdate();
    }
       
    public void createFormaster(String session, String term, String level, String classcode, String formname, String signurl) {
       Query query = em.createNativeQuery("INSERT INTO formaster(session, term, level, classcode, formname, signurl)"
       + "VALUES(?,?,?,?,?,?)");
        query.setParameter(1, session).setParameter(2, term).setParameter(3, level).setParameter(4, classcode).setParameter(5, formname).setParameter(6, signurl);
        query.executeUpdate();
    }
}
