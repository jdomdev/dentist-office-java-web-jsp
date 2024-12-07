# Dentist Office Management System

## **Overview**

The **Dentist Office Management System** is a web application designed to manage the operations of a dental clinic. It facilitates the scheduling and administration of appointments, patient data, and dentist schedules while ensuring a smooth and user-friendly experience for secretaries and dentists.

### **Key Features**
1. **Patient Management**:
   - Record and manage patient details, including:
     - Personal information.
     - Payment method (insurance or private).
     - Required treatments, conditions, or routine checkups.
   - Assign a **responsible party** (e.g., parent, guardian) for underage patients.

2. **Appointment Scheduling**:
   - Assign appointments to dentists based on their availability and working hours.
   - Prevent scheduling outside of a dentist's defined working hours, with warnings for invalid inputs.

3. **Dentist Management**:
   - Define dentist schedules (e.g., Monday to Friday, 08:00 AM to 05:00 PM).
   - View and manage appointments for each dentist.
   - Add observations about treatments performed after each appointment.

4. **User Management and Access Control**:
   - **Login system** for secretaries and dentists with secure username and password authentication.
   - Secretaries:
     - Manage patient data.
     - Schedule appointments.
   - Dentists:
     - View their daily schedules.
     - Register new appointments.
     - Record post-appointment notes.

5. **Reports and Queries**:
   - Number of patients treated on a specific day.
   - Appointments for each dentist by day.
   - Breakdown of patients with and without insurance.
   - Additional reports as required.

---

## **Technologies Used**

The application is developed using robust, modern technologies to ensure reliability, scalability, and ease of maintenance:

- **Java EE 8**: The backbone of the application, used for building the business logic and managing persistence.
- **JDK 21**: The latest Java Development Kit to leverage modern language features and improved performance.
- **JSP (JavaServer Pages)**: Used for creating dynamic web pages and serving user requests.
- **HTML & CSS**: For designing a clean and user-friendly front-end interface.
- **JPA (Java Persistence API)**: To manage database interactions and implement the object-relational mapping (ORM) layer.
- **NetBeans 23 IDE**: The integrated development environment for efficient project development and management.

---

## **Project Structure**

The system is divided into distinct modules to organize functionality effectively:

1. **Entities**:
   - `Person`: Super class.
   - `Patient`: Stores patient details.
   - `Dentist`: Stores dentist details, including specialties and working hours.
   - `Schedule`: Represents scheduled appointments.
   - `OfficeUser`: Manages system login credentials and roles.
   - `Responsible`: Records information about the guardian of underage patients.
   - `Secretary`: Stores office workers details.
   - `Appoinment`: Entity that depends on Dentists and Patients, and stores data from both. 

2. **Persistence**:
   - Database tables for storing and retrieving patient, dentist, appointment, and user data.
   - JPA for seamless ORM integration.

3. **Web Layer**:
   - JSP pages for handling patient registration, appointment scheduling, and generating reports.
   - CSS and HTML for responsive and professional UI design.

4. **Reports**:
   - Query system for generating statistics and summaries.

---

## **How to Run**

### **Requirements**
- **Java JDK 21** installed.
- **NetBeans IDE** with Java EE 8 support.
- A database system (e.g., MySQL or PostgreSQL).
- Maven for project dependency management.

### **Steps**
1. Clone the repository:
   ```bash
   git clone https://github.com/jdomdev/dentist-office-java-web-jsp.git
   ```
2. Open the project in **NetBeans**.
3. Configure the database connection in `persistence.xml`.
4. Build the project:
   ```bash
   mvn clean install
   ```
5. Deploy the application to a Java EE-compatible server (e.g., Apache Tomcat, GlassFish).
6. Access the application in your browser:
   ```bash
   http://localhost:8080/DentistOffice
   ```

---

## **Future Enhancements**

- Implement email notifications for appointment reminders.
- Add advanced search and filtering options for reports.
- Support multi-language UI for broader usability.

---

## Contributing

Feel free to submit issues and pull requests. For major changes, please discuss them via issues or email with the maintainers.

## License

This project is licensed under the GNU General Public License v3.0. See the [LICENSE](./LICENSE) file for more details.
With this update, it is specified that the application is under the **GPLv3** license. This informs contributors and users that they can modify and redistribute the software under the terms of this license.

