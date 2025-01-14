package io.sunbit.dentistoffice.logic;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable {
    // Attributes
    // We create a unique id for the parent class and delete the id of the child classes.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dni;
    private String name;
    private String surname;
    private String phone;
    private String email;
    // Date Mapping
    // It's not necessary: @Temporal(TemporalType.TIMESTAMP)
    private LocalDate birthDate;
    // Constructors
    public Person() {
    }
    public Person(long id, String dni, String name, String surname, 
                  String phone, String email, LocalDate birthDate) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
    }

    // Getters
    public long getId() {
        return id;
    }
    public String getDni() {
        return dni;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    // Setters
    public void setId(long id) {
        this.id = id;
    }    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
