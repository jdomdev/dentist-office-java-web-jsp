package io.sunbit.dentistoffice.persistence;


import io.sunbit.dentistoffice.logic.Dentist;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DentistJpaController implements Serializable{

    private EntityManagerFactory emf = null;

    // Constructor initializing EntityManagerFactory
    public DentistJpaController() {
        this.emf = Persistence.createEntityManagerFactory("DentistOfficePU");
    }

    // Gets an instance of EntityManager
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Method to create(Insert) a new Dentist in the database
    public void create(Dentist dentist) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(dentist);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to Lookup an Dentist for its ID
    public Dentist findDentist(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dentist.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to get a list of all Dentists in the database
    public List<Dentist> findAllDentists() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT u FROM Dentist u", Dentist.class).getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to update an existing Dentist
    public void edit(Dentist dentist) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(dentist);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error updating Dentist with ID " + dentist.getId(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to delete an Dentist by its ID
    public void delete(long id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Dentist dentist = em.find(Dentist.class, id);
            if (dentist != null) {
                em.remove(dentist);
                em.getTransaction().commit();
            } else {
                throw new Exception("Dentist with ID not found" + id);
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
