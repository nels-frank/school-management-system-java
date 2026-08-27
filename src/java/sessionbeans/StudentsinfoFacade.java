/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import connection.dbConnection;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import entities.Classes;
import entities.Studentsinfo;
import entities.Studentsinfo_;

/**
 *
 * @author Adzua Frank
 */
@Stateless
public class StudentsinfoFacade extends AbstractFacade<Studentsinfo> {
@Inject
    private dbConnection dc;
    @PersistenceContext(unitName = "schoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentsinfoFacade() {
        super(Studentsinfo.class);
    }
    
    public int countS(String session) {
        int count = dc.countbySessionAndClasslevel(session);
        return count;
    }
    public String totalStud(int count, String sessioncode) {
        String regno = dc.totalStudent(count, sessioncode);
        return regno;
    }
    
    public String titleCase(String input) {
        String inputText = dc.titleCase(input);
        return inputText;
    }
    public String checkClass(int ts, String classlevel) {
        String classoption = null;
        return classoption = dc.checkClass(ts, classlevel);
    }
    public List<Classes> getClassoption(String classlevel){
    return em.createNamedQuery("Classes.findByClasslevel",Classes.class).setParameter("classlevel", classlevel).getResultList();
    }
    
    public void setStatus(String regno) {

        //  db.setPosition(classcode, subjects); 
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> uc = bd.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> ur = uc.from(Studentsinfo.class);
            uc.where(bd.equal(ur.get(Studentsinfo_.regno), regno)
            );
            uc.set(ur.get(Studentsinfo_.status), "computed");
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
    
    public void udpdateStudent(String regno, String fname, String mname,String lname, String state, String lga, String sex, String session, String classlevel, String classoption, String dob, String house, String healthstatus, String status, String pictureurl, String nationality, String tribe, String religion, String guardianoccupation, String guardianaddress, String guardianname, String guardianno) {
        try {

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.regno), regno));
            updateCriteria.set(updateRoot.get(Studentsinfo_.fname), fname);
            updateCriteria.set(updateRoot.get(Studentsinfo_.mname), mname);
            updateCriteria.set(updateRoot.get(Studentsinfo_.lname), lname);            
            updateCriteria.set(updateRoot.get(Studentsinfo_.state), state);
            updateCriteria.set(updateRoot.get(Studentsinfo_.lga), lga);
            updateCriteria.set(updateRoot.get(Studentsinfo_.sex), sex);
            updateCriteria.set(updateRoot.get(Studentsinfo_.session), session);
            updateCriteria.set(updateRoot.get(Studentsinfo_.level), classlevel);
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), classoption);
            updateCriteria.set(updateRoot.get(Studentsinfo_.dob), dob);
            updateCriteria.set(updateRoot.get(Studentsinfo_.dob), dob);
            updateCriteria.set(updateRoot.get(Studentsinfo_.house), house);
            updateCriteria.set(updateRoot.get(Studentsinfo_.healthstatus), healthstatus);
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), status);
            updateCriteria.set(updateRoot.get(Studentsinfo_.pictureurl), pictureurl);
            updateCriteria.set(updateRoot.get(Studentsinfo_.nationality), nationality);
            updateCriteria.set(updateRoot.get(Studentsinfo_.tribe), tribe);
            updateCriteria.set(updateRoot.get(Studentsinfo_.religion), religion);
            updateCriteria.set(updateRoot.get(Studentsinfo_.guardianoccupation), guardianoccupation);
            updateCriteria.set(updateRoot.get(Studentsinfo_.guardianaddress), guardianaddress);
            updateCriteria.set(updateRoot.get(Studentsinfo_.guardianname), guardianname);
            updateCriteria.set(updateRoot.get(Studentsinfo_.guardianno), guardianno);
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
    
    public void createStudents(String regno, String fname, String mname, String lname, String state, String lga,
            String sex, String session, String level, String classcode,
            String dob, String house, String healthstatus, String status,
            String pictureurl,String nationality, String tribe, String religion, String guardianoccupation,String guardianaddress,
            String guardianname, String guardianno, String date) {
         //regno, fname, mname, lname, state, lga, sex, session, classlevel, classoption, dob, house, healthstatus, status, pictureurl, nationality, tribe, religion, guardianoccupation, guardianaddress, guardianname, guardianno
        Query query = em.createNativeQuery("INSERT INTO studentsinfo(regno, fname, mname, lname, state, lga, sex, session, "
                +"level, classcode, dob, house, healthstatus, status, pictureurl, nationality, tribe, religion, guardianoccupation, guardianaddress, guardianname, guardianno, date)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        query.setParameter(1, regno).setParameter(2, fname).setParameter(3, mname).setParameter(4, lname)
                .setParameter(5, state).setParameter(6, lga).setParameter(7, sex).setParameter(8, session).
                setParameter(9, level).setParameter(10, classcode).setParameter(11, dob).setParameter(12, house)
                .setParameter(13, healthstatus).setParameter(14, "Active").setParameter(15, pictureurl).setParameter(16, "Nigeria")
                .setParameter(17, tribe).setParameter(18, religion).setParameter(19, guardianoccupation)
                .setParameter(20, guardianaddress).setParameter(21, guardianname).setParameter(22, guardianno).setParameter(23, date);              
        query.executeUpdate();
    }
    public void removeByRegno(String regno) {
        this.em.createNamedQuery("Studentsinfo.deleteByRegno",Studentsinfo.class)
                .setParameter("regno", regno)
                .executeUpdate();
    }
    
    public void promotSS3A(String classcode) {
        try {

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Graduated");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "X-Student");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }   
    public void promotSSS3B(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Graduated");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "X-Student");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
      
    public void promotSSS3C(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Graduated");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "X-Student");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotSSS3D(String classoption) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classoption));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Graduated");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "X-Student");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotSSS2A(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 6A");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotSSS2B(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 6B");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotSSS2C(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 6C");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotSSS2D(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 6D");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotSSS1A(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 6E");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotSSS1B(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 6F");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotSSS1C(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 5A");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotSSS1D(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 5B");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotJSS3A(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 5C");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotJSS3B(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 5D");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotJSS3C(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 5E");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotJSS3D(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 5F");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotJSS2A(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 4A");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotJSS2B(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 4B");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotJSS2C(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 4C");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotJSS2D(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 4D");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotJSS1A(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 4E");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotJSS1B(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 4F");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotJSS1C(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 3A");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public void promotJSS1D(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 3B");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRI2C(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 3C");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRI2D(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 3D");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRI2E(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 3E");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRI2F(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 3F");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRI1A(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 2A");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRI1B(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 2B");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRI1C(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 2C");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRI1D(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 2D");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRI1E(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 2E");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRI1F(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Primary 2F");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPNURA(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Nursery 1A");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRNB(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Nursery 1B");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRNC(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Nursery 1C");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRND(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Nursery 1D");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRNE(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Nursery 1E");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void promotPRNF(String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.classcode), classcode));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Promoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), "Nursery 1F");            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    
    public void DemotStudent(String regno, String classcode) {
        try {
        CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> updateCriteria = builder.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> updateRoot = updateCriteria.from(Studentsinfo.class);
            updateCriteria.where(builder.equal(updateRoot.get(Studentsinfo_.regno), regno));
            updateCriteria.set(updateRoot.get(Studentsinfo_.status), "Demoted");
            updateCriteria.set(updateRoot.get(Studentsinfo_.classcode), classcode);            
            Query q = em.createQuery(updateCriteria);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
}
    public List<Studentsinfo> findByClasscode(String classcode) {
        return em.createNamedQuery("Studentsinfo.findByClasscode", Studentsinfo.class).setParameter("classcode", classcode).getResultList();
    }
    public void updateStatus(String classcode) {

        //  db.setPosition(classcode, subjects); 
        try {

            CriteriaBuilder bd = em.getCriteriaBuilder();
            CriteriaUpdate<Studentsinfo> uc = bd.createCriteriaUpdate(Studentsinfo.class);
            Root<Studentsinfo> ur = uc.from(Studentsinfo.class);
            uc.where(bd.equal(ur.get(Studentsinfo_.classcode), classcode)
            );
            uc.set(ur.get(Studentsinfo_.status), "Active");
            Query q = em.createQuery(uc);
            q.executeUpdate();
            em.flush();
        } catch (Exception e) {
        }
    }
}
