<%@page import="io.sunbit.dentistoffice.logic.Controller"%>
<%@page import="io.sunbit.dentistoffice.logic.OfficeUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/body-start.jsp" %>

<h1>Office-User Updating</h1>
<p>This is the form to update the details of office-users of the system.</p>

<%                    
    OfficeUser userToUp = (OfficeUser)request.getSession().getAttribute("userToUp");
%>   
%>
<!-- Display user data in a form for editing -->
<form class="user-update" action="UserUpdateServlet" method="POST">
    <input type="hidden" name="user-id" value="<%=userToUp.getUserId()%>">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">                        
            <input type="text" id="user-name" name="user-name" class="form-control form-control-user" value="<%=userToUp.getUserName()%>"><br>
        </div>
        <div class="col-sm-6 mb-3">                        
            <input type="text" id="role" name="role" class="form-control form-control-user" value="<%=userToUp.getRole()%>"><br>
        </div> 
        <div class="col-sm-6 mb-3 position-relative" style="position: relative;">    
            <input type="password" id="passwordField" name="password" class="form-control form-control-user" value="<%=userToUp.getPassword()%>" 
                   style="padding-right: 30px;"> <!-- Añade un espacio para el icono -->
            <span class="toggle-password" onclick="togglePasswordVisibility()" 
                  style="position: absolute; top: 50%; right: 20px; transform: translateY(-50%); cursor: pointer;">
                👁
            </span>
        </div>
        <script>
            function togglePasswordVisibility() {
                const passwordField = document.getElementById('passwordField');
                const type = passwordField.getAttribute('type') === 'password' ? 'text' : 'password';
                passwordField.setAttribute('type', type);
            }
        </script>                                
    </div>
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Update
    </button>

</form>

<%@include file="components/body-end.jsp" %>