package io.sunbit.dentistoffice.logic;

import java.util.Date;


public class Responsible extends Person{
    // Attributes
    private long responsibleId;
    private String respType;
    // Constructors
    public Responsible() {
    }
    public Responsible(long responsibleId, String respType, String dni, String name, String surname, String phone, String address, Date birthDate) {
        super(dni, name, surname, phone, address, birthDate);
        this.responsibleId = responsibleId;
        this.respType = respType;
    }
    // Setters
    public void setResponsibleId(long responsibleId) {
        this.responsibleId = responsibleId;
    }
    public void setRespType(String respType) {
        this.respType = respType;
    }
    // Getters
    public long getResponsibleId() {
        return responsibleId;
    }
    public String getRespType() {
        return respType;
    }    
}
