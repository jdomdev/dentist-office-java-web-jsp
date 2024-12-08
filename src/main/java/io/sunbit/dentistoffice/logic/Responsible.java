package io.sunbit.dentistoffice.logic;

import java.time.LocalDate;
import javax.persistence.Entity;

@Entity
public class Responsible extends Person{
    // Attributes
    //private long responsibleId;
    private String respType;
    // Constructors
    public Responsible() {
    }
    public Responsible(String respType, String dni, String name, String surname, 
                       String phone, String address, LocalDate birthDate) {
        super(dni, name, surname, phone, address, birthDate);
        this.respType = respType;
    }    
    // Setters   
    public void setRespType(String respType) {
        this.respType = respType;
    }
    // Getters    
    public String getRespType() {
        return respType;
    }    
}
