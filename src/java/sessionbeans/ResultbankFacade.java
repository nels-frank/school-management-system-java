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
import entities.Resultbank;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class ResultbankFacade extends AbstractFacade<Resultbank> {

    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResultbankFacade() {
        super(Resultbank.class);
    }
    public List<Resultbank> findSubjHistory(String examsession, String term, String subjects, String classcode) {
        return em.createNamedQuery("Computeresult.findByExamsessionAndTermAndSubjectsAndClasscode", Resultbank.class).setParameter("examsession", examsession).setParameter("term", term).setParameter("subjects", subjects)
                .setParameter("classcode", classcode).getResultList();
    }
    public void removeByComputCod(String computecode) {
        this.em.createNamedQuery("Resultbank.deleteByComputecode",Resultbank.class)
                .setParameter("computecode", computecode)
                .executeUpdate();
    }
    public List<Resultbank> findByRegno(String examsession, String term, String regno) {
        return em.createNamedQuery("Resultbank.findByExamsessionAndTermAndRegno", Resultbank.class).setParameter("examsession", examsession).setParameter("term", term).setParameter("regno", regno).getResultList();
    }
}
