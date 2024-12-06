package io.sunbit.dentaloffice.logic;

import java.time.LocalDateTime;


public class Shift {
    // Attributes
    private int shiftId;
    private LocalDateTime shiftDate;
    private String affection;
    // Constructors
    public Shift() {
    }
    public Shift(int shiftId, LocalDateTime shiftDate, String affection) {
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
