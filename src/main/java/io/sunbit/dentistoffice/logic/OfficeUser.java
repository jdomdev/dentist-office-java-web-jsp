package io.sunbit.dentistoffice.logic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OfficeUser implements Serializable {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String passw;
    private String rol;
    // Constructors
    public OfficeUser() {
    }
    public OfficeUser(long userId, String userName, String passw, String rol, String dni, String name, String surname, String phone, String address, Date birthDate) {        
        this.userId = userId;
        this.userName = userName;
        this.passw = passw;
        this.rol = rol;
    }
    // Setters
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassw(String passw) {
        this.passw = passw;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    // Getters
    public long getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassw() {
        return passw;
    }
    public String getRol() {
        return rol;
    }    
}
