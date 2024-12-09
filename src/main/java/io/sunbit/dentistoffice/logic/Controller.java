package io.sunbit.dentistoffice.logic;

import io.sunbit.dentistoffice.persistence.PersistenceController;


public class Controller {
    
    PersistenceController persistenceControl = new PersistenceController();
    
    public void createUser(String userName, String password, String rol){
        OfficeUser officeUser = new OfficeUser();
        officeUser.setUserName(userName);
        officeUser.setPassword(password);
        officeUser.setRol(rol);
        persistenceControl.createUser(officeUser);
    }
}
