package io.sunbit.dentistoffice.persistence;

import io.sunbit.dentistoffice.logic.Appoinment;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AppoinmentJpaController implements Serializable{

    private EntityManagerFactory emf = null;

    // Constructor initializing EntityManagerFactory
    public AppoinmentJpaController() {
        this.emf = Persistence.createEntityManagerFactory("DentistOfficePU");
    }

    // Gets an instance of EntityManager
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Method to create(Insert) a new Appoinment in the database
    public void create(Appoinment appoinment) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(appoinment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to Lookup an Appoinmnet for its ID
    public Appoinment findAppoinment(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Appoinment.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to get a list of all Appoinments in the database
    public List<Appoinment> findAllAppoinments() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT u FROM Appoinment u", Appoinment.class).getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to update an existing Appoinment
    public void edit(Appoinment appoinment) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(appoinment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error updating Appoinment with ID " + appoinment.getAppoinmentId(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to delete an Appoinment by its ID
    public void delete(long id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Appoinment appoinment = em.find(Appoinment.class, id);
            if (appoinment != null) {
                em.remove(appoinment);
                em.getTransaction().commit();
            } else {
                throw new Exception("Appoinment with ID not found" + id);
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
