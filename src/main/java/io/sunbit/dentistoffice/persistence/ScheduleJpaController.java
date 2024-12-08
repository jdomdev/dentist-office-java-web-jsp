package io.sunbit.dentistoffice.persistence;

import io.sunbit.dentistoffice.logic.Schedule;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ScheduleJpaController implements Serializable{
    
    private EntityManagerFactory emf = null;

    // Constructor initializing EntityManagerFactory
    public ScheduleJpaController() {
        this.emf = Persistence.createEntityManagerFactory("DentistOfficePU");
    }

    // Gets an instance of EntityManager
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Method to create(Insert) a new Schedule in the database
    public void create(Schedule schedule) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(schedule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to Lookup a Schedule for its ID
    public Schedule findSchedule(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Schedule.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to get a list of all Schedule in the database
    public List<Schedule> findAllSchedules() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT u FROM Schedule u", Schedule.class).getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to update an existing Schedule
    public void edit(Schedule schedule) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(schedule);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error updating Schedule with ID " + schedule.getScheduleId(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to delete a Schedule by its ID
    public void delete(long id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Schedule schedule = em.find(Schedule.class, id);
            if (schedule != null) {
                em.remove(schedule);
                em.getTransaction().commit();
            } else {
                throw new Exception("Schedule with ID not found" + id);
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
