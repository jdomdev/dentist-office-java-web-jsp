package io.sunbit.dentaloffice.logic;

import java.time.LocalDateTime;


public class Appoinment {
    // Attributes
    private int shiftId;
    private LocalDateTime shiftDate;
    private String affection;
    // Constructors
    public Appoinment() {
    }
    public Appoinment(int shiftId, LocalDateTime shiftDate, String affection) {
        this.shiftId = shiftId;
        this.shiftDate = shiftDate;
        this.affection = affection;
    }
    // Settersk
    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }
    public void setShiftDate(LocalDateTime shiftDate) {
        this.shiftDate = shiftDate;
    }
    public void setAffection(String affection) {
        this.affection = affection;
    }
    public int getShiftId() {
        return shiftId;
    }
    public LocalDateTime getShiftDate() {
        return shiftDate;
    }
    public String getAffection() {
        return affection;
    }        
}
