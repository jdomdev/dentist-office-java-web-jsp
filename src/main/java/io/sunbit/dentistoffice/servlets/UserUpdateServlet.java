package io.sunbit.dentistoffice.servlets;

import io.sunbit.dentistoffice.logic.Controller;
import io.sunbit.dentistoffice.logic.OfficeUser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UserUpdateServlet", urlPatterns = {"/UserUpdateServlet"})
public class UserUpdateServlet extends HttpServlet {

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
        
        long userId = Long.parseLong(request.getParameter("user-id"));
        //System.out.println("User ID: " + userId);//->Test.
        String userName = request.getParameter("user-name");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        OfficeUser officeUser = new OfficeUser(userId, userName, password, role);
        
        control.updateUser(officeUser);
        response.sendRedirect("OfficeUserServlet");
    }   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
