package io.sunbit.dentistoffice.servlets;

import io.sunbit.dentistoffice.logic.Controller;
import io.sunbit.dentistoffice.logic.Dentist;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "DentistServlet", urlPatterns = {"/DentistServlet"})
public class DentistServlet extends HttpServlet {

    Controller control = new Controller();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Dentist>dentists = control.getDentists();
        HttpSession mySession = request.getSession();
        mySession.setAttribute("dentists", dentists);
        response.sendRedirect("view-dentists.jsp");
    }    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                
        String dni = request.getParameter("dni");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        LocalDate birthDate = null;
        String specialty = request.getParameter("specialty");
        //System.out.println("**** Specialty ****: " + specialty);//test->OK
        try {
            String inputDate = request.getParameter("birth-date");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            birthDate = LocalDate.parse(inputDate, formatter);                                  
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            // Proper error handling (e.g. message to user)
            response.getWriter().write("Invalid date format. Please use dd/MM/yyyy.");
        }        
        if (birthDate != null) {
            // Add date as parameter to new Dentist entity
            control.createDentist(dni, name, surname, phone, email, birthDate, specialty);
        } else {
            // Manejar el caso en el que 'birthDate' no se pudo parsear
            response.getWriter().write("Failed to register dentist due to invalid birth date.");
        }
        response.sendRedirect("DentistServlet");
    }   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
