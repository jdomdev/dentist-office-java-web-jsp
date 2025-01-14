package io.sunbit.dentistoffice.logic;

import io.sunbit.dentistoffice.persistence.PersistenceController;
import java.time.LocalDate;
import java.util.List;


public class Controller {
    
    PersistenceController persistenceControl = new PersistenceController();

    // OfficeUser
    public void createOfficeUser(String userName, String password, String userRole){
        OfficeUser officeUser = new OfficeUser();
        officeUser.setUserName(userName);
        officeUser.setPassword(password);
        officeUser.setUserRole(userRole);
        persistenceControl.createOfficeUser(officeUser);
    }
    public List<OfficeUser> getOfficeUsers() {
        return persistenceControl.getOfficeUsers();
    }
    public void deleteOfficeUser(long userId) {
        persistenceControl.deleteOfficeUser(userId);
    }
    public OfficeUser getOfficeUser(long userId) {
        return persistenceControl.getOfficeUser(userId);
    }
    public void updateOfficeUser(OfficeUser officeUser) {
        persistenceControl.updateOfficeUser(officeUser);
    }
    // Dentist
    public void createDentist(String dni, String name, String surname, 
                              String phone, String email, LocalDate birthDate, 
                              String specialty) {
        Dentist dentist = new Dentist();
        dentist.setDni(dni);
        dentist.setName(name);
        dentist.setSurname(surname);
        dentist.setPhone(phone);
        dentist.setEmail(email);
        dentist.setBirthDate(birthDate);
        dentist.setSpecialty(specialty);
        persistenceControl.createDentist(dentist);
    }
    public List<Dentist> getDentists() {
        return persistenceControl.getDentists();
    }
    public Dentist getDentist(long parseLong) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void updateDentist(Dentist dentistToUp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
