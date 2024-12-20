package io.sunbit.dentistoffice.logic;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Dentist extends Person{
    // Attributes
    //private long dentistId;
    private String specialty;
    // Bidirectional relation:
    // Dentists will know the appoinments, and the appoinments will know their dentists.
    @OneToMany(mappedBy="dentist")//-> Element searched in Appoinment class.
    private List<Appoinment>appoinments;
    @OneToOne
    private OfficeUser officeUser;
    @OneToOne
    private Schedule schedule;
    // Constructors
    public Dentist() {
    }
    public Dentist(String specialty, List<Appoinment> appoinments, 
                   OfficeUser officeUser, Schedule schedule, long id, 
                   String dni, String name, String surname, String phone, 
                   String address, LocalDate birthDate) {
        super(id, dni, name, surname, phone, address, birthDate);
        this.specialty = specialty;
        this.appoinments = appoinments;
        this.officeUser = officeUser;
        this.schedule = schedule;
    }
    // Setters
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public void setAppoinment(List<Appoinment> appoinments) {
        this.appoinments = appoinments;
    }
    public void setOfficeUser(OfficeUser officeUser) {
        this.officeUser = officeUser;
    }
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    // Getters  
    public String getSpecialty() {
        return specialty;
    }
    public List<Appoinment> getAppoinment() {
        return appoinments;
    }
    public OfficeUser getOfficeUser() {
        return officeUser;
    }    
    public Schedule getSchedule() {
        return schedule;
    }    
}
