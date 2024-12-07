package io.sunbit.dentistoffice.logic;

import java.util.Date;
import java.util.List;


public class Patient extends Person{
    // Atributes
    private long patientId;
    private boolean hasMedicalInsurance;
    private String bloodType;
    private Responsible responsable;
    private List<Appoinment> appoinments;
    // Constructors
    public Patient() {
    }
    public Patient(long patientId, boolean hasMedicalInsurance, String bloodType, 
            Responsible responsable, List<Appoinment> appoinments, String dni, 
            String name, String surname, String phone, String address, Date birthDate) {
        super(dni, name, surname, phone, address, birthDate);
        this.patientId = patientId;
        this.hasMedicalInsurance = hasMedicalInsurance;
        this.bloodType = bloodType;
        this.responsable = responsable;
        this.appoinments = appoinments;
    }
    // Getters
    public long getPatientId() {
        return patientId;
    }
    public boolean isHasMedicalInsurance() {
        return hasMedicalInsurance;
    }
    public String getBloodType() {
        return bloodType;
    }

    public Responsible getResponsable() {
        return responsable;
    }
    public List<Appoinment> getAppoinments() {
        return appoinments;
    }
    // Setters
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
    public void setHasMedicalInsurance(boolean hasMedicalInsurance) {
        this.hasMedicalInsurance = hasMedicalInsurance;
    }
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    public void setResponsable(Responsible responsable) {
        this.responsable = responsable;
    }
    public void setAppoinments(List<Appoinment> appoinments) {
        this.appoinments = appoinments;
    }
}
