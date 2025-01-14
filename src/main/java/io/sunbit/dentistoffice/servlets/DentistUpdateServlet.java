package io.sunbit.dentistoffice.servlets;

import io.sunbit.dentistoffice.logic.Controller;
import io.sunbit.dentistoffice.logic.Dentist;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "DentistUpdateServlet", urlPatterns = {"/DentistUpdateServlet"})
public class DentistUpdateServlet extends HttpServlet {

    Controller control = new Controller();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        Dentist dentistToUp = new Dentist();        
        String dentistIdParam = request.getParameter("dentist-id");
        if (dentistIdParam != null && !dentistIdParam.isEmpty()) {                        
            dentistToUp = control.getDentist(Long.parseLong(dentistIdParam));
            if (dentistToUp != null) {                
            } else {
                System.out.println("<p>Dentist does not exist.</p>");
            }
        } else {
            System.out.println("<p>Invalid dentist ID.</p>");
        }
        HttpSession mySession = request.getSession();
        mySession.setAttribute("dentistToUp", dentistToUp);        
        response.sendRedirect("dentist-update.jsp");
    }    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {          
        String dni = request.getParameter("dni");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");        
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        // TODO
        LocalDate birthDate = LocalDate.parse(request.getParameter("birth-date"));
        Dentist dentistToUp = (Dentist)request.getSession().getAttribute("dentistToUp");
        dentistToUp.setDni(dni);
        dentistToUp.setName(name);
        dentistToUp.setSurname(surname);
        dentistToUp.setPhone(phone);
        dentistToUp.setEmail(email);
        dentistToUp.setBirthDate(birthDate);
        
        control.updateDentist(dentistToUp);
        // Reloading view users table from DB
        response.sendRedirect("OfficeUserServlet");
    }   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
