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
import entities.Statelga;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class StatelgaFacade extends AbstractFacade<Statelga> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StatelgaFacade() {
        super(Statelga.class);
    }
    
    public List<Statelga> getLga(String states){
    return em.createNamedQuery("Statelga.findByStates",Statelga.class).setParameter("states", states).getResultList();
    } 
}
