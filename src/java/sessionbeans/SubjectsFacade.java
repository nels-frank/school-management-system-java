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
import entities.Subjects;
import entities.Subjects_;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class SubjectsFacade extends AbstractFacade<Subjects> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SubjectsFacade() {
        super(Subjects.class);
    }
    public List<Subjects> findByLevel(String level){
    return em.createNamedQuery("Subjects.findByLevel",Subjects.class).setParameter("level", level).getResultList();
    }
     public void createSubjects(String subjectcode, String subjectname, String level, String category) {
       Query query = em.createNativeQuery("INSERT INTO subjects(subjectcode, subjectname, level, category )"
                + "VALUES(?,?,?,?)");
        query.setParameter(1, subjectcode).setParameter(2, subjectname).setParameter(3, level).setParameter(4, category);
        query.executeUpdate();
    }
 
    public void udpdateSubjects(String subjectcode, String subjectname, String level,String category) {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Subjects> updateCriteria = builder.createCriteriaUpdate(Subjects.class);
            Root<Subjects> updateRoot = updateCriteria.from(Subjects.class);
            updateCriteria.where(builder.equal(updateRoot.get(Subjects_.subjectcode), subjectcode));
            updateCriteria.set(updateRoot.get(Subjects_.subjectname), subjectname);
            updateCriteria.set(updateRoot.get(Subjects_.level), level);
            updateCriteria.set(updateRoot.get(Subjects_.category), category);
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
    
    public void removeBySubjectcode(String subjectcode) {
        this.em.createNamedQuery("Subjects.deleteBySubjectcode",Subjects.class)
                .setParameter("subjectcode", subjectcode)
                .executeUpdate();
    }
}
