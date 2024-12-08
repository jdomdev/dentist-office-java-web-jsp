package io.sunbit.dentistoffice.logic;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appoinment implements Serializable {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int appoinmentId;
    private LocalDateTime appoinmentDate;
    private String affection;
    @ManyToOne
    @JoinColumn(name = "id")//->relation,foreign key
    private Dentist dentist;
    @ManyToOne
    @JoinColumn(name = "id")
    private Patient patient;
    // Constructors
    public Appoinment() {
    }
    public Appoinment(int appoinmentId, LocalDateTime appoinmentDate, String affection) {
        this.appoinmentId = appoinmentId;
        this.appoinmentDate = appoinmentDate;
        this.affection = affection;
    }
    // Settersk
    public void setAppoinmentId(int appoinmentId) {
        this.appoinmentId = appoinmentId;
    }
    public void setAppoinmentDate(LocalDateTime appoinmentDate) {
        this.appoinmentDate = appoinmentDate;
    }
    public void setAffection(String affection) {
        this.affection = affection;
    }
    public int getAppoinmentId() {
        return appoinmentId;
    }
    public LocalDateTime getAppoinmentDate() {
        return appoinmentDate;
    }
    public String getAffection() {
        return affection;
    }        
}
