package io.sunbit.dentistoffice.logic;

import java.util.Date;

public class Person {
    // Attributes
    private String dni;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private Date birthDate;
    // Constructors
    public Person() {
    }
    public Person(String dni, String name, String surname, String phone, String address, Date birthDate) {        
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.birthDate = birthDate;
    }
    // Getters
    public String getDni() {
        return dni;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    // Setters
    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
