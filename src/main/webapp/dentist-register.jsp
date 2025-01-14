<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Embed JSP code from another page -->
<%@include file="components/header.jsp" %>
<%@include file="components/body-start.jsp" %>

<h1>Dentist Register</h1>
<p>Registration form for qualified professionals</p>

<form id="dentist-register" class="dentist" action="DentistServlet" method="POST">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" 
                   id="dni" name="dni" placeholder="Dni">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" 
                   id="name" name="name" placeholder="Name">
        </div>    
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" 
                   id="surname" name="surname" placeholder="Surname">
        </div>        
        <div class="col-sm-6 mb-3">
            <input type="tel" class="form-control form-control-user"
                   id="phone" name="phone" placeholder="Phone Number">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="email" class="form-control form-control-user"
                   id="email" name="email" placeholder="Email Address">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   id="birth-date" name="birth-date" placeholder="Birth Date (dd/mm/yyyy)">
        </div>
        <script>
        document.getElementById("dentist-register").addEventListener("submit", function(event) {
            const dateInput = document.getElementById("birth-date").value;
            const regex = /^\d{2}\/\d{2}\/\d{4}$/; // Validation for dd/MM/yyyy
            if (!regex.test(dateInput)) {
                alert("Por favor, ingrese la fecha en formato dd/MM/yyyy.");
                event.preventDefault(); // Stops form submission
            }
        });
        </script>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user"
                   id="specialty" name="specialty" placeholder="Specialty">
        </div>
        
        <!-- Here we will indicate what is related to appoinments and patients.  -->
        
    </div>
    <button class="btn btn-primary btn-user btn-block" type="submit">
        New Dentist
    </button>
    
</form>

<%@include file="components/body-end.jsp" %>

