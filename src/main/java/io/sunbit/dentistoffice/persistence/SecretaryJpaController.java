package io.sunbit.dentistoffice.persistence;

import io.sunbit.dentistoffice.logic.Secretary;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class SecretaryJpaController implements Serializable{
    
    private EntityManagerFactory emf = null;

    // Constructor initializing EntityManagerFactory
    public SecretaryJpaController() {
        this.emf = Persistence.createEntityManagerFactory("DentistOfficePU");
    }

    // Gets an instance of EntityManager
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Method to create(Insert) a new Secretary in the database
    public void create(Secretary secretary) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(secretary);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to Lookup a Secretary for its ID
    public Secretary findSecretary(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Secretary.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to get a list of all Secretaries in the database
    public List<Secretary> findAllSecretaries() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT u FROM Secretary u", Secretary.class).getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to update an existing Secretary
    public void edit(Secretary secretary) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(secretary);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error updating Secretary with ID " + secretary.getId(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to delete a Secretary by its ID
    public void delete(long id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Secretary secretary = em.find(Secretary.class, id);
            if (secretary != null) {
                em.remove(secretary);
                em.getTransaction().commit();
            } else {
                throw new Exception("Secretary with ID not found" + id);
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }    
}
