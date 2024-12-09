package io.sunbit.dentistoffice.logic;

import io.sunbit.dentistoffice.persistence.PersistenceController;


public class Controller {
    
    PersistenceController persistenceControl = new PersistenceController();
    
    public void createUser(long userId, String userName, String password, String rol){
        OfficeUser officeUser = new OfficeUser(userId, userName, password, rol);
        persistenceControl.createUser(officeUser);
    }
}
