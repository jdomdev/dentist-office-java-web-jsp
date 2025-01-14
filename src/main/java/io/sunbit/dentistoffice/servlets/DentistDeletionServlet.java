package io.sunbit.dentistoffice.servlets;

import io.sunbit.dentistoffice.logic.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DentistDeletionServlet", urlPatterns = {"/DentistDeletionServlet"})
public class DentistDeletionServlet extends HttpServlet {

    Controller control = new Controller();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long dentistId = Long.parseLong(request.getParameter("dentist-id"));            
        control.deleteOfficeUser(dentistId);
        // Reloading view dentists table from DB
        response.sendRedirect("DentistServlet");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
