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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import entities.Users;
import entities.Users_;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    public void createUsers(String username, String password, String role, String status) {
        Query query = em.createNativeQuery("INSERT INTO users(username,password,role,status) VALUES(?,?,?,?)");
        query.setParameter(1, username).setParameter(2, password).setParameter(3, "User").setParameter(4, "Active");
        query.executeUpdate();
    }
    
   public void updateUsers(String username,String status) {
 
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Users> uc = bd.createCriteriaUpdate(Users.class);
            Root<Users> ur = uc.from(Users.class);
            uc.where(bd.equal(ur.get(Users_.username), username));
            
            uc.set(ur.get(Users_.role), "Admin");
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
   
    public void DeleteByUsername(String username) {
        this.em.createNamedQuery("Users.deleteByUsername",Users.class)
                .setParameter("username", username)
                .executeUpdate();
    }
   
    
     public void udpdateEditUsers(String username, String password, String role) {
        try {
            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Users> uc = bd.createCriteriaUpdate(Users.class);
            Root<Users> ur = uc.from(Users.class);
            uc.where(bd.equal(ur.get(Users_.username), username));
            uc.set(ur.get(Users_.password), password);
            uc.set(ur.get(Users_.role), role);
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
}
