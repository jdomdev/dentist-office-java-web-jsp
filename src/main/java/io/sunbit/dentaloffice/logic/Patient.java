package io.sunbit.dentaloffice.logic;

import java.util.Date;
import java.util.List;


public class Patient extends Person{
    // Atributes
    private long patientId;
    private boolean hasMedicalInsurance;
    private String bloodType;
    private Responsible responsable;
    private List<Shift> shifts;
    // Constructors
    public Patient() {
    }
    public Patient(long patientId, boolean hasMedicalInsurance, String bloodType, Responsible responsable, List<Shift> shifts, String dni, String name, String surname, String phone, String address, Date birthDate) {
        super(dni, name, surname, phone, address, birthDate);
        this.patientId = patientId;
        this.hasMedicalInsurance = hasMedicalInsurance;
        this.bloodType = bloodType;
        this.responsable = responsable;
        this.shifts = shifts;
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
    public List<Shift> getShifts() {
        return shifts;
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
    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }
}
