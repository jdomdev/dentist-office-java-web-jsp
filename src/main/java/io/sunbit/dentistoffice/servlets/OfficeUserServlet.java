package io.sunbit.dentistoffice.servlets;

import io.sunbit.dentistoffice.logic.Controller;
import io.sunbit.dentistoffice.logic.OfficeUser;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "OfficeUserServlet", urlPatterns = {"/OfficeUserServlet"})
public class OfficeUserServlet extends HttpServlet {

    Controller control = new Controller();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<OfficeUser>officeUsers = control.getOfficeUsers();        
        HttpSession mySession = request.getSession();
        mySession.setAttribute("officeUsers", officeUsers);
        response.sendRedirect("view-users.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                
        String userName = request.getParameter("user-name");
        String password = request.getParameter("password");
        String userRole = request.getParameter("user-role");
        control.createOfficeUser(userName, password, userRole);
        // Reloading view users table from DB
        response.sendRedirect("OfficeUserServlet");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
