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
    public Secretary(String department, OfficeUser user, long id, String dni, 
                     String name, String surname, String phone, String address, 
                     LocalDate birthDate) {
        super(id, dni, name, surname, phone, address, birthDate);
        this.department = department;
        this.user = user;
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
