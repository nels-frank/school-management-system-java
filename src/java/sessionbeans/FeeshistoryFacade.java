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
import entities.Expenditure;
import entities.Feeshistory;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class FeeshistoryFacade extends AbstractFacade<Feeshistory> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FeeshistoryFacade() {
        super(Feeshistory.class);
    }
  public List<Feeshistory> historyTransaction(String regno) {
        return em.createNamedQuery("Feeshistory.findByRegno", Feeshistory.class).setParameter("regno", regno).getResultList();
    }
    
    public void removeByRegno(String regno) {
        this.em.createNamedQuery("Feeshistory.deleteByRegno",Feeshistory.class)
                .setParameter("regno", regno)
                .executeUpdate();
    }
    public void removeSN(int sn) {
        this.em.createNamedQuery("Feeshistory.deleteBySn",Expenditure.class)
                .setParameter("sn", sn)
                .executeUpdate();
    }  
}
