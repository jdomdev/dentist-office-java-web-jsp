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
    private OfficeUser officeUser;
    // Constructors
    public Secretary() {
    }
    public Secretary(String department, OfficeUser officeUser, long id, String dni, 
                     String name, String surname, String phone, String address, 
                     LocalDate birthDate) {
        super(id, dni, name, surname, phone, address, birthDate);
        this.department = department;
        this.officeUser = officeUser;
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
