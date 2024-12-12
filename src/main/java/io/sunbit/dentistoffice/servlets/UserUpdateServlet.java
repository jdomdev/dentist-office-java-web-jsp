package io.sunbit.dentistoffice.servlets;

import io.sunbit.dentistoffice.logic.Controller;
import io.sunbit.dentistoffice.logic.OfficeUser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "UserUpdateServlet", urlPatterns = {"/UserUpdateServlet"})
public class UserUpdateServlet extends HttpServlet {

    Controller control = new Controller();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controller control = new Controller();
        OfficeUser officeUser = new OfficeUser();
        // Get the user-id of the submitted form                
        String userIdParam = request.getParameter("user-id");
        if (userIdParam != null && !userIdParam.isEmpty()) {
            Long userId = Long.parseLong(userIdParam);
            // Call the Controller->PersistenceController->JPA to get the user's details      
            officeUser = control.getOfficeUser(userId);
            if (officeUser != null) {                
            } else {
                System.out.println("<p>User does not exist.</p>");
            }
        } else {
            System.out.println("<p>Invalid user-id.</p>");
        }
        HttpSession mySession = request.getSession();
        mySession.setAttribute("officeUser", officeUser);
        //request.setAttribute("officeUser", officeUser);
        response.sendRedirect("user-update.jsp");
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
        // Reloading view users table from DB
        response.sendRedirect("OfficeUserServlet");
    }   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
