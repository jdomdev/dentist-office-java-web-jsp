<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Embed JSP code from another page -->
<%@include file="components/header.jsp" %>
<%@include file="components/body-start.jsp" %>

<h1>Dentist Register</h1>
<p>This a test</p>

<form class="user">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="dni"
                placeholder="Dni">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="name"
                placeholder="Name">
        </div>    
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="surname"            
                   placeholder="Surname">
        </div>        
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                id="telephone" placeholder="Telephone">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="email" class="form-control form-control-user"
                id="email" placeholder="Email Address">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                id="birth-date" placeholder="Birth Date">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                id="specialty" placeholder="Specialty">
        </div>
        
        <!-- Here we will indicate what is related to shifts and patients.  -->
        
    </div>
    <a href="" class="btn btn-primary btn-user btn-block">
        New Dentist
    </a>
    
</form>

<%@include file="components/body-end.jsp" %>

