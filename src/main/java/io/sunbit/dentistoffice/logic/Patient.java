package io.sunbit.dentistoffice.logic;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Patient extends Person{
    // Atributes
    //private long patientId;
    private boolean hasMedicalInsurance;
    private String bloodType;
    @OneToOne
    private Responsible responsible;
    @OneToMany(mappedBy = "patient")
    private List<Appoinment> appoinments;
    // Constructors
    public Patient() {
    }
    public Patient(boolean hasMedicalInsurance, String bloodType, 
                   Responsible responsible, List<Appoinment> appoinments, 
                   long id, String dni, String name, String surname, 
                   String phone, String address, LocalDate birthDate) {
        super(id, dni, name, surname, phone, address, birthDate);
        this.hasMedicalInsurance = hasMedicalInsurance;
        this.bloodType = bloodType;
        this.responsible = responsible;
        this.appoinments = appoinments;
    }
    // Getters    
    public boolean isHasMedicalInsurance() {
        return hasMedicalInsurance;
    }
    public String getBloodType() {
        return bloodType;
    }
    public Responsible getResponsible() {
        return responsible;
    }
    public List<Appoinment> getAppoinments() {
        return appoinments;
    }
    // Setters    
    public void setHasMedicalInsurance(boolean hasMedicalInsurance) {
        this.hasMedicalInsurance = hasMedicalInsurance;
    }
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }
    public void setAppoinments(List<Appoinment> appoinments) {
        this.appoinments = appoinments;
    }
}
