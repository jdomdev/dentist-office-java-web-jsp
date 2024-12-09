package io.sunbit.dentistoffice.logic;

import java.io.Serializable;
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
    private String password;
    private String rol;
    // Constructors
    public OfficeUser() {
    }
    public OfficeUser(long userId, String userName, String password, String rol) {        
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.rol = rol;
    }
    // Setters
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
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
    public String getPassword() {
        return password;
    }
    public String getRol() {
        return rol;
    }    
}
