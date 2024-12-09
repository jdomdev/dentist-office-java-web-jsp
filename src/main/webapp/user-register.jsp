<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Embed JSP code from another page -->
<%@include file="components/header.jsp" %>
<%@include file="components/body-start.jsp" %>

<h1>Office-User Register</h1>
<p>This is the form to register the different users of the system.</p>

<form class="user" action="OfficeUserServlet" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <!-- not id="user-name"-->
            <input type="text" class="form-control form-control-user" name="user-name"
                placeholder="User Name">
        </div>        
        <div class="col-sm-6 mb-3 position-relative">    
            <input type="password" id="passwordField" class="form-control form-control-user" name="password" 
           placeholder="Password">
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
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="rol"            
                   placeholder="Rol">
        </div>                                    
    </div>
    <button class="btn btn-primary btn-user btn-block" type="submit">
        New Office-User
    </button>
    
</form>

<%@include file="components/body-end.jsp" %>

