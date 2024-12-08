package io.sunbit.dentistoffice.persistence;

import io.sunbit.dentistoffice.logic.Person;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonJpaController implements Serializable{

    private EntityManagerFactory emf = null;

    // Constructor initializing EntityManagerFactory
    public PersonJpaController() {
        this.emf = Persistence.createEntityManagerFactory("DentistOfficePU");
    }

    // Gets an instance of EntityManager
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Method to create(Insert) a new Person in the database
    public void create(Person person) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to Lookup a Person for its ID
    public Person findPerson(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Person.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to get a list of all Persons in the database
    public List<Person> findAllPersons() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT u FROM Person u", Person.class).getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to update an existing Person
    public void edit(Person person) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception("Error updating Person with ID " + person.getId(), ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Method to delete a Person by its ID
    public void delete(long id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Person person = em.find(Person.class, id);
            if (person != null) {
                em.remove(person);
                em.getTransaction().commit();
            } else {
                throw new Exception("Person with ID not found" + id);
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
