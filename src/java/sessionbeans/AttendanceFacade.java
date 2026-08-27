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
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import entities.Attendance;
import entities.Attendance_;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class AttendanceFacade extends AbstractFacade<Attendance> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AttendanceFacade() {
        super(Attendance.class);
    }
    
    public void udpdateAttendance(String attendancecode, int max, int presence, int attendant){
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Attendance> updateCriteria = builder.createCriteriaUpdate(Attendance.class);
            Root<Attendance> updateRoot = updateCriteria.from(Attendance.class);
            updateCriteria.where(builder.equal(updateRoot.get(Attendance_.attendancecode), attendancecode));
            updateCriteria.set(updateRoot.get(Attendance_.max), max);
            updateCriteria.set(updateRoot.get(Attendance_.presence), presence);
            updateCriteria.set(updateRoot.get(Attendance_.absence), attendant);  
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    } 
   public List<Attendance> findAttendance(String classcode) {
        return em.createNamedQuery("Attendance.findByClasscode", Attendance.class).setParameter("classcode", classcode).getResultList();
                
    }
   public void removeAttendance(String classcode) {
        this.em.createNamedQuery("Attendance.deleteStudents",Attendance.class)
                .setParameter("classcode", classcode)
                .executeUpdate();
    }
   public List<Attendance> findByRegno(String regno) {
        return em.createNamedQuery("Attendance.findByRegno", Attendance.class).setParameter("regno", regno).getResultList();
    }
}
