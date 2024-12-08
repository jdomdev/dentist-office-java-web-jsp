package io.sunbit.dentistoffice.logic;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Secretary extends Person{
    // Attributes
    //private long secretaryId;
    private String department;
    @OneToOne
    private OfficeUser user;
    // Constructors
    public Secretary() {
    }
    public Secretary(String department, String dni, String name, String surname, 
                     String phone, String address, LocalDate birthDate) {
        super(dni, name, surname, phone, address, birthDate);
        this.department = department;
    } 
    // Setters    
    public void setDepartment(String department) {
        this.department = department;
    }
    // Getters    
    public String getDepartment() {
        return department;
    }
}
