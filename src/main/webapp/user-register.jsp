<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Embed JSP code from another page -->
<%@include file="components/header.jsp" %>
<%@include file="components/body-start.jsp" %>

<h1>Office-User Register</h1>
<p>This is the form to register the different users of the system.</p>

<form class="user">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="user-name"
                placeholder="User Name">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="password"
                placeholder="Password">
        </div>    
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="rol"            
                   placeholder="Rol">
        </div>                                    
    </div>
    <a href="" class="btn btn-primary btn-user btn-block">
        New Office-User
    </a>
    
</form>

<%@include file="components/body-end.jsp" %>

