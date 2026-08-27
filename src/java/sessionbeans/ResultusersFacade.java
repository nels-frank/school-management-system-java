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
import entities.Resultusers;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class ResultusersFacade extends AbstractFacade<Resultusers> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResultusersFacade() {
        super(Resultusers.class);
    }
    
    public void createResultusers(String username, String password, String role, String status) {
       Query query = em.createNativeQuery("INSERT INTO resultusers(username, password, role, status )"
                + "VALUES(?,?,?,?)");
        query.setParameter(1, username).setParameter(2, password).setParameter(3, "Admin").setParameter(4, "Active");
        query.executeUpdate();
    }
    public void removeUser(String username) {
        this.em.createNamedQuery("Resultusers.deleteByUsername",Resultusers.class)
                .setParameter("username", username)
                .executeUpdate();
    }
}
