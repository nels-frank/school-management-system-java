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
import entities.Classes;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class ClassesFacade extends AbstractFacade<Classes> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClassesFacade() {
        super(Classes.class);
    }
    public List<Classes> classByLevel(String level){
    return em.createNamedQuery("Classes.findByLevel",Classes.class).setParameter("level", level).getResultList();
    }
}
