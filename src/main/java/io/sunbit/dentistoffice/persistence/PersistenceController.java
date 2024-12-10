package io.sunbit.dentistoffice.persistence;

import io.sunbit.dentistoffice.logic.OfficeUser;
import java.util.List;


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
    
}
