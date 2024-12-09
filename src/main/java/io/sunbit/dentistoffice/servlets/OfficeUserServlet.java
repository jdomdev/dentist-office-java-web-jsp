package io.sunbit.dentistoffice.servlets;

import io.sunbit.dentistoffice.logic.Controller;
import io.sunbit.dentistoffice.logic.OfficeUser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "OfficeUserServlet", urlPatterns = {"/OfficeUserServlet"})
public class OfficeUserServlet extends HttpServlet {

    Controller control = new Controller();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.sendRedirect("index.jsp");//->test
        
        String userName = request.getParameter("user-name");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");
        // Test
        //System.out.println("Name: "+userName+"\nPassword: "+password+"\nRol: "+rol);
        control.createUser(userName, password, rol);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
