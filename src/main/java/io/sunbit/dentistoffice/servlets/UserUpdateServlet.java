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
        OfficeUser userToUp = new OfficeUser();
        // Get the user-id of the submitted form                
        String userIdParam = request.getParameter("user-id");
        if (userIdParam != null && !userIdParam.isEmpty()) {            
            // Call the Controller->PersistenceController->JPA to get the user's details      
            userToUp = control.getOfficeUser(Long.parseLong(userIdParam));
            if (userToUp != null) {                
            } else {
                System.out.println("<p>User does not exist.</p>");
            }
        } else {
            System.out.println("<p>Invalid user-id.</p>");
        }
        HttpSession mySession = request.getSession();
        mySession.setAttribute("userToUp", userToUp);        
        response.sendRedirect("user-update.jsp");
    }    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {          
        String userName = request.getParameter("user-name");
        String password = request.getParameter("password");
        String role = request.getParameter("user-role");
        OfficeUser userToUp = (OfficeUser)request.getSession().getAttribute("userToUp");
        userToUp.setUserName(userName);
        userToUp.setPassword(password);
        userToUp.setUserRole(role);
        control.updateUser(userToUp);
        // Reloading view users table from DB
        response.sendRedirect("OfficeUserServlet");
    }   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
