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
import entities.Attendance;
import entities.Attendancebank;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class AttendancebankFacade extends AbstractFacade<Attendancebank> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AttendancebankFacade() {
        super(Attendancebank.class);
    }
    public List<Attendancebank> findAttendancebank(String examsession, String term,String classcode) {
        return em.createNamedQuery("Attendancebank.findByExamsessionAndTermAndClasscode", Attendancebank.class).setParameter("examsession", examsession).setParameter("term", term).setParameter("classcode", classcode).getResultList();
                
    }
     
     public void removeByAttcode(String attendancecode) {
        this.em.createNamedQuery("Attendancebank.deleteByAttendancecode",Attendancebank.class)
                .setParameter("attendancecode", attendancecode)
                .executeUpdate();
    }
     
     public List<Attendancebank> findByRegno(String examsession, String term,String regno, String name) {
        return em.createNamedQuery("Attendancebank.findByExamsessionAndTermAndRegnoAndName", Attendancebank.class).setParameter("examsession", examsession).setParameter("term", term).setParameter("regno", regno).setParameter("name", name).getResultList();
    }
}
