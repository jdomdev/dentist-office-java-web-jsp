package io.sunbit.dentistoffice.persistence;

import io.sunbit.dentistoffice.logic.OfficeUser;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class OfficeUserJpaController implements Serializable{

    private EntityManagerFactory emf = null;

    // Constructor initializing EntityManagerFactory
    public OfficeUserJpaController() {
        this.emf = Persistence.createEntityManagerFactory("DentistOfficePU");
    }

    // Gets an instance of EntityManager
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Method to create(Insert) a new OfficeUser in the database
    public void create(OfficeUser officeUser) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(officeUser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to Lookup an OfficeUser for its ID
    public OfficeUser findOfficeUser(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OfficeUser.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to get a list of all OfficeUsers in the database
    public List<OfficeUser> findAllOfficeUsers() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT u FROM OfficeUser u", OfficeUser.class).getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to update an existing OfficeUser
    public void edit(OfficeUser officeUser) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(officeUser);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error updating OfficeUser with ID " + officeUser.getUserId(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to delete an OfficeUser by its ID
    public void delete(long id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            OfficeUser officeUser = em.find(OfficeUser.class, id);
            if (officeUser != null) {
                em.remove(officeUser);
                em.getTransaction().commit();
            } else {
                throw new Exception("OfficeUser with ID not found" + id);
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
