package io.sunbit.dentaloffice.logic;

import java.util.Date;


public class Secretary extends Person{
    // Attributes
    private long secretaryId;
    private String department;
    // Constructors
    public Secretary() {
    }
    public Secretary(long secretaryId, String department, String dni, String name, String surname, String phone, String address, Date birthDate) {
        super(dni, name, surname, phone, address, birthDate);
        this.secretaryId = secretaryId;
        this.department = department;
    }
    // Setters
    public void setSecretaryId(long secretaryId) {
        this.secretaryId = secretaryId;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    // Getters
    public long getSecretaryId() {
        return secretaryId;
    }
    public String getDepartment() {
        return department;
    }
}
