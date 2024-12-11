package io.sunbit.dentistoffice.persistence;

import io.sunbit.dentistoffice.logic.OfficeUser;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersistenceController {

    ScheduleJpaController scheduleJpa = new ScheduleJpaController();
    DentistJpaController dentistJpa = new DentistJpaController();
    PatientJpaController patientJpa = new PatientJpaController();
    ResponsibleJpaController responsibleJpa = new ResponsibleJpaController();
    SecretaryJpaController secretaryJpa = new SecretaryJpaController();
    AppoinmentJpaController appoinmentJpa = new AppoinmentJpaController();
    OfficeUserJpaController officeUserJpa = new OfficeUserJpaController();

    public void createUser(OfficeUser officeUser) {
        officeUserJpa.create(officeUser);
    }
    public List<OfficeUser> getOfficeUsers() {
        return officeUserJpa.findAllOfficeUsers();
    }
    public void deleteUser(long userId) {
        try {
            officeUserJpa.delete(userId);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public OfficeUser getOfficeUser(long userId) {
        return officeUserJpa.findOfficeUser(userId);
    }
    public void updateUser(OfficeUser officeUser) {
        try {
            officeUserJpa.edit(officeUser);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
