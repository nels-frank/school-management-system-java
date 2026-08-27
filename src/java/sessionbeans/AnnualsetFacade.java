/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Annualset;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class AnnualsetFacade extends AbstractFacade<Annualset> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnnualsetFacade() {
        super(Annualset.class);
    }
    
}
