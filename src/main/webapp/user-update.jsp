<%@page import="io.sunbit.dentistoffice.logic.Controller"%>
<%@page import="io.sunbit.dentistoffice.logic.OfficeUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/body-start.jsp" %>

<h1>Office-User Updating</h1>
<p>This is the form to update the details of office-users of the system.</p>

<%    
    // Get the user-id of the submitted form
    String userIdParam = request.getParameter("user-id");

    if (userIdParam != null && !userIdParam.isEmpty()) {
        Long userId = Long.parseLong(userIdParam);

        // Call the Controller->PersistenceController->JPA to get the user's details
        Controller control = new Controller();
        OfficeUser officeUser = control.getOfficeUser(userId);

        if (officeUser != null) {
            // Mostrar los datos del usuario en un formulario para edición
%>
            <h2>Updating User:</h2>
            <form action="UserUpdateServlet" method="POST">
                <input type="hidden" name="user-id" value="<%=officeUser.getUserId() %>">

                <label for="username">Office-User Name:</label>
                <input type="text" id="user-name" name="user-name" value="<%=officeUser.getUserName() %>"><br>

                <label for="role">Rol:</label>
                <input type="text" id="role" name="role" value="<%=officeUser.getRol() %>"><br>
                
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" value="<%=officeUser.getPassword() %>"><br>

                <button type="submit" class="btn btn-success">Update</button>
            </form>
<%
        } else {
            out.println("<p>User does not exist.</p>");
        }
    } else {
        out.println("<p>Invalid user-id.</p>");
    }
%>

<%@include file="components/body-end.jsp" %>