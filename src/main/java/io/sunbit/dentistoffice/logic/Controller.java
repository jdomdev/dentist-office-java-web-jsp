package io.sunbit.dentistoffice.logic;

import io.sunbit.dentistoffice.persistence.PersistenceController;
import java.util.List;


public class Controller {
    
    PersistenceController persistenceControl = new PersistenceController();
    
    public void createUser(String userName, String password, String userRole){
        OfficeUser officeUser = new OfficeUser();
        officeUser.setUserName(userName);
        officeUser.setPassword(password);
        officeUser.setUserRole(userRole);
        persistenceControl.createUser(officeUser);
    }

    public List<OfficeUser> getOfficeUsers() {
        return persistenceControl.getOfficeUsers();
    }
    public void deleteUser(long userId) {
        persistenceControl.deleteUser(userId);
    }
    public OfficeUser getOfficeUser(long userId) {
        return persistenceControl.getOfficeUser(userId);
    }
    public void updateUser(OfficeUser officeUser) {
        persistenceControl.updateUser(officeUser);
    }
}
