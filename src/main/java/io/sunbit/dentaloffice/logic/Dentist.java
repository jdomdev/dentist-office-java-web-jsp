package io.sunbit.dentaloffice.logic;

import java.util.Date;
import java.util.List;


public class Dentist extends Person{
    // Attributes
    private long dentistId;
    private String specialty;
    private List<Shift>shifts;
    private OfficeUser user;
    private Schedule schedule;
    // Constructors
    public Dentist() {
    }
    public Dentist(long dentistId, String specialty, List<Shift> shifts, OfficeUser user, Schedule schedule, String dni, String name, String surname, String phone, String address, Date birthDate) {
        super(dni, name, surname, phone, address, birthDate);
        this.dentistId = dentistId;
        this.specialty = specialty;
        this.shifts = shifts;
        this.user = user;
        this.schedule = schedule;
    }
    // Setters
    public void setDentistId(long dentistId) {
        this.dentistId = dentistId;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }
    public void setUser(OfficeUser user) {
        this.user = user;
    }
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    // Getters
    public long getDentistId() {
        return dentistId;
    }
    public String getSpecialty() {
        return specialty;
    }
    public List<Shift> getShifts() {
        return shifts;
    }
    public OfficeUser getUser() {
        return user;
    }    
    public Schedule getSchedule() {
        return schedule;
    }    
}
