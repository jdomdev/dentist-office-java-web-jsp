package io.sunbit.dentistoffice.persistence;

import io.sunbit.dentistoffice.logic.Patient;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PatientJpaController implements Serializable{

    private EntityManagerFactory emf = null;

    // Constructor initializing EntityManagerFactory
    public PatientJpaController() {
        this.emf = Persistence.createEntityManagerFactory("DentistOfficePU");
    }

    // Gets an instance of EntityManager
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Method to create(Insert) a new Patient in the database
    public void create(Patient patient) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(patient);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to Lookup a Patient for its ID
    public Patient findOfficeUser(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Patient.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to get a list of all Patients in the database
    public List<Patient> findAllPatients() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT u FROM Patient u", Patient.class).getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to update an existing Patient
    public void edit(Patient patient) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(patient);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error updating Patient with ID " + patient.getId(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to delete a Patient by its ID
    public void delete(long id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Patient patient = em.find(Patient.class, id);
            if (patient != null) {
                em.remove(patient);
                em.getTransaction().commit();
            } else {
                throw new Exception("Patient with ID not found" + id);
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
