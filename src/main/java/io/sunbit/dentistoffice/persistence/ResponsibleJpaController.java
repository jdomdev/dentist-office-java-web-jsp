package io.sunbit.dentistoffice.persistence;

import io.sunbit.dentistoffice.logic.Responsible;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ResponsibleJpaController implements Serializable{

    private EntityManagerFactory emf = null;

    // Constructor initializing EntityManagerFactory
    public ResponsibleJpaController() {
        this.emf = Persistence.createEntityManagerFactory("DentistOfficePU");
    }

    // Gets an instance of EntityManager
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Method to create(Insert) a new Responsible in the database
    public void create(Responsible responsible) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(responsible);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to Lookup a Responsible for its ID
    public Responsible findResponsible(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Responsible.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to get a list of all Responsibles in the database
    public List<Responsible> findAllResponsibles() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT u FROM Responsible u", Responsible.class).getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to update an existing Responsible
    public void edit(Responsible responsible) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(responsible);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error updating Responsible with ID " + responsible.getId(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to delete a Responsible by its ID
    public void delete(long id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Responsible responsible = em.find(Responsible.class, id);
            if (responsible != null) {
                em.remove(responsible);
                em.getTransaction().commit();
            } else {
                throw new Exception("Responsible with ID not found" + id);
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
